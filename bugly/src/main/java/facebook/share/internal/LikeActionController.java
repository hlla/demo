/*      */ package com.facebook.share.internal;
/*      */ 
/*      */ import android.app.Activity;
/*      */ import android.content.Context;
/*      */ import android.content.Intent;
/*      */ import android.content.SharedPreferences;
/*      */ import android.content.SharedPreferences.Editor;
/*      */ import android.os.Bundle;
/*      */ import android.os.Handler;
/*      */ import android.os.Looper;
/*      */ import android.support.v4.content.LocalBroadcastManager;
/*      */ import android.util.Log;
/*      */ import com.facebook.AccessToken;
/*      */ import com.facebook.AccessTokenTracker;
/*      */ import com.facebook.FacebookCallback;
/*      */ import com.facebook.FacebookException;
/*      */ import com.facebook.FacebookOperationCanceledException;
/*      */ import com.facebook.FacebookRequestError;
/*      */ import com.facebook.FacebookSdk;
/*      */ import com.facebook.GraphRequest;
/*      */ import com.facebook.GraphRequest.Callback;
/*      */ import com.facebook.GraphRequestBatch;
/*      */ import com.facebook.GraphRequestBatch.Callback;
/*      */ import com.facebook.GraphResponse;
/*      */ import com.facebook.HttpMethod;
/*      */ import com.facebook.LoggingBehavior;
/*      */ import com.facebook.appevents.AppEventsLogger;
/*      */ import com.facebook.internal.AppCall;
/*      */ import com.facebook.internal.BundleJSONConverter;
/*      */ import com.facebook.internal.CallbackManagerImpl;
/*      */ import com.facebook.internal.CallbackManagerImpl.Callback;
/*      */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*      */ import com.facebook.internal.FileLruCache;
/*      */ import com.facebook.internal.FileLruCache.Limits;
/*      */ import com.facebook.internal.FragmentWrapper;
/*      */ import com.facebook.internal.Logger;
/*      */ import com.facebook.internal.NativeProtocol;
/*      */ import com.facebook.internal.PlatformServiceClient.CompletedListener;
/*      */ import com.facebook.internal.Utility;
/*      */ import com.facebook.internal.WorkQueue;
/*      */ import com.facebook.share.widget.LikeView.ObjectType;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Locale;
/*      */ import java.util.Set;
/*      */ import java.util.UUID;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import org.json.JSONArray;
/*      */ import org.json.JSONException;
/*      */ import org.json.JSONObject;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class LikeActionController
/*      */ {
/*      */   public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
/*      */   public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
/*      */   public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
/*      */   public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
/*      */   public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
/*      */   public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
/*   76 */   private static final String TAG = LikeActionController.class.getSimpleName();
/*      */   
/*      */   private static final int LIKE_ACTION_CONTROLLER_VERSION = 3;
/*      */   
/*      */   private static final int MAX_CACHE_SIZE = 128;
/*      */   
/*      */   private static final int MAX_OBJECT_SUFFIX = 1000;
/*      */   
/*      */   private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
/*      */   
/*      */   private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
/*      */   
/*      */   private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
/*      */   
/*      */   private static final String JSON_INT_VERSION_KEY = "com.facebook.share.internal.LikeActionController.version";
/*      */   
/*      */   private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
/*      */   
/*      */   private static final String JSON_INT_OBJECT_TYPE_KEY = "object_type";
/*      */   
/*      */   private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
/*      */   
/*      */   private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
/*      */   
/*      */   private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
/*      */   
/*      */   private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
/*      */   
/*      */   private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
/*      */   
/*      */   private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
/*      */   
/*      */   private static final String JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE = "facebook_dialog_analytics_bundle";
/*      */   private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
/*      */   private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
/*      */   private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
/*      */   private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
/*      */   private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
/*      */   private static FileLruCache controllerDiskCache;
/*  115 */   private static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap();
/*      */   
/*      */ 
/*      */ 
/*  119 */   private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
/*      */   
/*  121 */   private static WorkQueue diskIOWorkQueue = new WorkQueue(1);
/*      */   
/*      */   private static Handler handler;
/*      */   
/*      */   private static String objectIdForPendingController;
/*      */   
/*      */   private static boolean isInitialized;
/*      */   
/*      */   private static volatile int objectSuffix;
/*      */   
/*      */   private static AccessTokenTracker accessTokenTracker;
/*      */   
/*      */   private String objectId;
/*      */   
/*      */   private LikeView.ObjectType objectType;
/*      */   
/*      */   private boolean isObjectLiked;
/*      */   
/*      */   private String likeCountStringWithLike;
/*      */   
/*      */   private String likeCountStringWithoutLike;
/*      */   
/*      */   private String socialSentenceWithLike;
/*      */   
/*      */   private String socialSentenceWithoutLike;
/*      */   
/*      */   private String unlikeToken;
/*      */   
/*      */   private String verifiedObjectId;
/*      */   
/*      */   private boolean objectIsPage;
/*      */   
/*      */   private boolean isObjectLikedOnServer;
/*      */   
/*      */   private boolean isPendingLikeOrUnlike;
/*      */   private Bundle facebookDialogAnalyticsBundle;
/*      */   private AppEventsLogger appEventsLogger;
/*      */   
/*      */   public static boolean handleOnActivityResult(int requestCode, final int resultCode, final Intent data)
/*      */   {
/*  161 */     if (Utility.isNullOrEmpty(objectIdForPendingController)) {
/*  162 */       Context appContext = FacebookSdk.getApplicationContext();
/*  163 */       SharedPreferences sharedPreferences = appContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0);
/*      */       
/*      */ 
/*      */ 
/*  167 */       objectIdForPendingController = sharedPreferences.getString("PENDING_CONTROLLER_KEY", null);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  172 */     if (Utility.isNullOrEmpty(objectIdForPendingController))
/*      */     {
/*  174 */       return false;
/*      */     }
/*      */     
/*  177 */     getControllerForObjectId(objectIdForPendingController, LikeView.ObjectType.UNKNOWN, new CreationCallback()
/*      */     {
/*      */ 
/*      */ 
/*      */       public void onComplete(LikeActionController likeActionController, FacebookException error)
/*      */       {
/*      */ 
/*      */ 
/*  185 */         if (error == null) {
/*  186 */           likeActionController.onActivityResult(this.val$requestCode, resultCode, data);
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  191 */           Utility.logd(LikeActionController.TAG, error);
/*      */         }
/*      */         
/*      */       }
/*  195 */     });
/*  196 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void getControllerForObjectId(String objectId, LikeView.ObjectType objectType, CreationCallback callback)
/*      */   {
/*  209 */     if (!isInitialized) {
/*  210 */       performFirstInitialize();
/*      */     }
/*      */     
/*  213 */     LikeActionController controllerForObject = getControllerFromInMemoryCache(objectId);
/*  214 */     if (controllerForObject != null)
/*      */     {
/*  216 */       verifyControllerAndInvokeCallback(controllerForObject, objectType, callback);
/*      */     } else {
/*  218 */       diskIOWorkQueue.addActiveWorkItem(new CreateLikeActionControllerWorkItem(objectId, objectType, callback));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void verifyControllerAndInvokeCallback(LikeActionController likeActionController, LikeView.ObjectType objectType, CreationCallback callback)
/*      */   {
/*  227 */     LikeView.ObjectType bestObjectType = ShareInternalUtility.getMostSpecificObjectType(objectType, likeActionController.objectType);
/*      */     
/*      */ 
/*  230 */     FacebookException error = null;
/*  231 */     if (bestObjectType == null)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  239 */       error = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", new Object[] { likeActionController.objectId, likeActionController.objectType.toString(), objectType.toString() });
/*  240 */       likeActionController = null;
/*      */     } else {
/*  242 */       likeActionController.objectType = bestObjectType;
/*      */     }
/*      */     
/*  245 */     invokeCallbackWithController(callback, likeActionController, error);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void createControllerForObjectIdAndType(String objectId, LikeView.ObjectType objectType, CreationCallback callback)
/*      */   {
/*  261 */     LikeActionController controllerForObject = getControllerFromInMemoryCache(objectId);
/*  262 */     if (controllerForObject != null)
/*      */     {
/*  264 */       verifyControllerAndInvokeCallback(controllerForObject, objectType, callback);
/*  265 */       return;
/*      */     }
/*      */     
/*      */ 
/*  269 */     controllerForObject = deserializeFromDiskSynchronously(objectId);
/*      */     
/*  271 */     if (controllerForObject == null) {
/*  272 */       controllerForObject = new LikeActionController(objectId, objectType);
/*  273 */       serializeToDiskAsync(controllerForObject);
/*      */     }
/*      */     
/*      */ 
/*  277 */     putControllerInMemoryCache(objectId, controllerForObject);
/*      */     
/*      */ 
/*  280 */     LikeActionController controllerToRefresh = controllerForObject;
/*  281 */     handler.post(new Runnable()
/*      */     {
/*      */       public void run() {
/*  284 */         this.val$controllerToRefresh.refreshStatusAsync();
/*      */       }
/*      */       
/*  287 */     });
/*  288 */     invokeCallbackWithController(callback, controllerToRefresh, null);
/*      */   }
/*      */   
/*      */   private static synchronized void performFirstInitialize() {
/*  292 */     if (isInitialized) {
/*  293 */       return;
/*      */     }
/*      */     
/*  296 */     handler = new Handler(Looper.getMainLooper());
/*      */     
/*  298 */     Context appContext = FacebookSdk.getApplicationContext();
/*  299 */     SharedPreferences sharedPreferences = appContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0);
/*      */     
/*      */ 
/*      */ 
/*  303 */     objectSuffix = sharedPreferences.getInt("OBJECT_SUFFIX", 1);
/*  304 */     controllerDiskCache = new FileLruCache(TAG, new FileLruCache.Limits());
/*      */     
/*  306 */     registerAccessTokenTracker();
/*      */     
/*  308 */     CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Like
/*  309 */       .toRequestCode(), new CallbackManagerImpl.Callback()
/*      */       {
/*      */         public boolean onActivityResult(int resultCode, Intent data)
/*      */         {
/*  313 */           return LikeActionController.handleOnActivityResult(CallbackManagerImpl.RequestCodeOffset.Like
/*  314 */             .toRequestCode(), resultCode, data);
/*      */ 
/*      */         }
/*      */         
/*      */ 
/*  319 */       });
/*  320 */     isInitialized = true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void invokeCallbackWithController(CreationCallback callback, final LikeActionController controller, final FacebookException error)
/*      */   {
/*  327 */     if (callback == null) {
/*  328 */       return;
/*      */     }
/*      */     
/*  331 */     handler.post(new Runnable()
/*      */     {
/*      */       public void run() {
/*  334 */         this.val$callback.onComplete(controller, error);
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void registerAccessTokenTracker()
/*      */   {
/*  344 */     accessTokenTracker = new AccessTokenTracker()
/*      */     {
/*      */ 
/*      */       protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken)
/*      */       {
/*  349 */         Context appContext = FacebookSdk.getApplicationContext();
/*  350 */         if (currentAccessToken == null)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  358 */           LikeActionController.access$302((LikeActionController.objectSuffix + 1) % 1000);
/*  359 */           appContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0)
/*      */           
/*      */ 
/*  362 */             .edit()
/*  363 */             .putInt("OBJECT_SUFFIX", LikeActionController.objectSuffix)
/*  364 */             .apply();
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*  369 */           LikeActionController.cache.clear();
/*  370 */           LikeActionController.controllerDiskCache.clearCache();
/*      */         }
/*  372 */         LikeActionController.broadcastAction(null, "com.facebook.sdk.LikeActionController.DID_RESET");
/*      */       }
/*      */     };
/*      */   }
/*      */   
/*      */ 
/*      */   private static void putControllerInMemoryCache(String objectId, LikeActionController controllerForObject)
/*      */   {
/*  380 */     String cacheKey = getCacheKeyForObjectId(objectId);
/*      */     
/*  382 */     mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKey, true));
/*      */     
/*  384 */     cache.put(cacheKey, controllerForObject);
/*      */   }
/*      */   
/*      */   private static LikeActionController getControllerFromInMemoryCache(String objectId) {
/*  388 */     String cacheKey = getCacheKeyForObjectId(objectId);
/*      */     
/*  390 */     LikeActionController controller = (LikeActionController)cache.get(cacheKey);
/*  391 */     if (controller != null)
/*      */     {
/*  393 */       mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKey, false));
/*      */     }
/*      */     
/*  396 */     return controller;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void serializeToDiskAsync(LikeActionController controller)
/*      */   {
/*  404 */     String controllerJson = serializeToJson(controller);
/*  405 */     String cacheKey = getCacheKeyForObjectId(controller.objectId);
/*      */     
/*  407 */     if ((!Utility.isNullOrEmpty(controllerJson)) && (!Utility.isNullOrEmpty(cacheKey))) {
/*  408 */       diskIOWorkQueue.addActiveWorkItem(new SerializeToDiskWorkItem(cacheKey, controllerJson));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void serializeToDiskSynchronously(String cacheKey, String controllerJson)
/*      */   {
/*  418 */     OutputStream outputStream = null;
/*      */     try {
/*  420 */       outputStream = controllerDiskCache.openPutStream(cacheKey);
/*  421 */       outputStream.write(controllerJson.getBytes());
/*      */     } catch (IOException e) {
/*  423 */       Log.e(TAG, "Unable to serialize controller to disk", e);
/*      */     } finally {
/*  425 */       if (outputStream != null) {
/*  426 */         Utility.closeQuietly(outputStream);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static LikeActionController deserializeFromDiskSynchronously(String objectId)
/*      */   {
/*  436 */     LikeActionController controller = null;
/*      */     
/*  438 */     InputStream inputStream = null;
/*      */     try {
/*  440 */       String cacheKey = getCacheKeyForObjectId(objectId);
/*  441 */       inputStream = controllerDiskCache.get(cacheKey);
/*  442 */       if (inputStream != null) {
/*  443 */         String controllerJsonString = Utility.readStreamToString(inputStream);
/*  444 */         if (!Utility.isNullOrEmpty(controllerJsonString)) {
/*  445 */           controller = deserializeFromJson(controllerJsonString);
/*      */         }
/*      */       }
/*      */     } catch (IOException e) {
/*  449 */       Log.e(TAG, "Unable to deserialize controller from disk", e);
/*  450 */       controller = null;
/*      */     } finally {
/*  452 */       if (inputStream != null) {
/*  453 */         Utility.closeQuietly(inputStream);
/*      */       }
/*      */     }
/*      */     
/*  457 */     return controller;
/*      */   }
/*      */   
/*      */   private static LikeActionController deserializeFromJson(String controllerJsonString)
/*      */   {
/*      */     LikeActionController controller;
/*      */     try {
/*  464 */       JSONObject controllerJson = new JSONObject(controllerJsonString);
/*  465 */       int version = controllerJson.optInt("com.facebook.share.internal.LikeActionController.version", -1);
/*  466 */       if (version != 3)
/*      */       {
/*      */ 
/*  469 */         return null;
/*      */       }
/*      */       
/*  472 */       String objectId = controllerJson.getString("object_id");
/*  473 */       int objectTypeInt = controllerJson.optInt("object_type", LikeView.ObjectType.UNKNOWN
/*      */       
/*  475 */         .getValue());
/*      */       
/*      */ 
/*      */ 
/*  479 */       LikeActionController controller = new LikeActionController(objectId, LikeView.ObjectType.fromInt(objectTypeInt));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  484 */       controller.likeCountStringWithLike = controllerJson.optString("like_count_string_with_like", null);
/*      */       
/*  486 */       controller.likeCountStringWithoutLike = controllerJson.optString("like_count_string_without_like", null);
/*      */       
/*  488 */       controller.socialSentenceWithLike = controllerJson.optString("social_sentence_with_like", null);
/*      */       
/*  490 */       controller.socialSentenceWithoutLike = controllerJson.optString("social_sentence_without_like", null);
/*  491 */       controller.isObjectLiked = controllerJson.optBoolean("is_object_liked");
/*  492 */       controller.unlikeToken = controllerJson.optString("unlike_token", null);
/*      */       
/*  494 */       JSONObject analyticsJSON = controllerJson.optJSONObject("facebook_dialog_analytics_bundle");
/*      */       
/*  496 */       if (analyticsJSON != null)
/*      */       {
/*  498 */         controller.facebookDialogAnalyticsBundle = BundleJSONConverter.convertToBundle(analyticsJSON);
/*      */       }
/*      */     } catch (JSONException e) {
/*  501 */       Log.e(TAG, "Unable to deserialize controller from JSON", e);
/*  502 */       controller = null;
/*      */     }
/*      */     
/*  505 */     return controller;
/*      */   }
/*      */   
/*      */   private static String serializeToJson(LikeActionController controller) {
/*  509 */     JSONObject controllerJson = new JSONObject();
/*      */     try {
/*  511 */       controllerJson.put("com.facebook.share.internal.LikeActionController.version", 3);
/*  512 */       controllerJson.put("object_id", controller.objectId);
/*  513 */       controllerJson.put("object_type", controller.objectType.getValue());
/*  514 */       controllerJson.put("like_count_string_with_like", controller.likeCountStringWithLike);
/*      */       
/*      */ 
/*  517 */       controllerJson.put("like_count_string_without_like", controller.likeCountStringWithoutLike);
/*      */       
/*      */ 
/*  520 */       controllerJson.put("social_sentence_with_like", controller.socialSentenceWithLike);
/*      */       
/*      */ 
/*  523 */       controllerJson.put("social_sentence_without_like", controller.socialSentenceWithoutLike);
/*      */       
/*      */ 
/*  526 */       controllerJson.put("is_object_liked", controller.isObjectLiked);
/*  527 */       controllerJson.put("unlike_token", controller.unlikeToken);
/*  528 */       if (controller.facebookDialogAnalyticsBundle != null)
/*      */       {
/*  530 */         JSONObject analyticsJSON = BundleJSONConverter.convertToJSON(controller.facebookDialogAnalyticsBundle);
/*      */         
/*  532 */         if (analyticsJSON != null) {
/*  533 */           controllerJson.put("facebook_dialog_analytics_bundle", analyticsJSON);
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (JSONException e)
/*      */     {
/*  539 */       Log.e(TAG, "Unable to serialize controller to JSON", e);
/*  540 */       return null;
/*      */     }
/*      */     
/*  543 */     return controllerJson.toString();
/*      */   }
/*      */   
/*      */   private static String getCacheKeyForObjectId(String objectId) {
/*  547 */     String accessTokenPortion = null;
/*  548 */     AccessToken accessToken = AccessToken.getCurrentAccessToken();
/*  549 */     if (accessToken != null) {
/*  550 */       accessTokenPortion = accessToken.getToken();
/*      */     }
/*  552 */     if (accessTokenPortion != null)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*  557 */       accessTokenPortion = Utility.md5hash(accessTokenPortion);
/*      */     }
/*  559 */     return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", new Object[] { objectId, 
/*      */     
/*      */ 
/*      */ 
/*  563 */       Utility.coerceValueIfNullOrEmpty(accessTokenPortion, ""), 
/*  564 */       Integer.valueOf(objectSuffix) });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void broadcastAction(LikeActionController controller, String action)
/*      */   {
/*  574 */     broadcastAction(controller, action, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void broadcastAction(LikeActionController controller, String action, Bundle data)
/*      */   {
/*  581 */     Intent broadcastIntent = new Intent(action);
/*  582 */     if (controller != null) {
/*  583 */       if (data == null) {
/*  584 */         data = new Bundle();
/*      */       }
/*      */       
/*  587 */       data.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", controller.getObjectId());
/*      */     }
/*      */     
/*  590 */     if (data != null) {
/*  591 */       broadcastIntent.putExtras(data);
/*      */     }
/*      */     
/*  594 */     LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(broadcastIntent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private LikeActionController(String objectId, LikeView.ObjectType objectType)
/*      */   {
/*  601 */     this.objectId = objectId;
/*  602 */     this.objectType = objectType;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getObjectId()
/*      */   {
/*  611 */     return this.objectId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getLikeCountString()
/*      */   {
/*  620 */     return this.isObjectLiked ? this.likeCountStringWithLike : this.likeCountStringWithoutLike;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSocialSentence()
/*      */   {
/*  629 */     return this.isObjectLiked ? this.socialSentenceWithLike : this.socialSentenceWithoutLike;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isObjectLiked()
/*      */   {
/*  638 */     return this.isObjectLiked;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean shouldEnableView()
/*      */   {
/*  647 */     if ((LikeDialog.canShowNativeDialog()) || (LikeDialog.canShowWebFallback())) {
/*  648 */       return true;
/*      */     }
/*  650 */     if ((this.objectIsPage) || (this.objectType == LikeView.ObjectType.PAGE))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*  655 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  661 */     AccessToken token = AccessToken.getCurrentAccessToken();
/*      */     
/*      */ 
/*  664 */     return (token != null) && (token.getPermissions() != null) && (token.getPermissions().contains("publish_actions"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void toggleLike(Activity activity, FragmentWrapper fragment, Bundle analyticsParameters)
/*      */   {
/*  674 */     boolean shouldLikeObject = !this.isObjectLiked;
/*      */     
/*  676 */     if (canUseOGPublish())
/*      */     {
/*  678 */       updateLikeState(shouldLikeObject);
/*  679 */       if (this.isPendingLikeOrUnlike)
/*      */       {
/*      */ 
/*      */ 
/*  683 */         getAppEventsLogger().logSdkEvent("fb_like_control_did_undo_quickly", null, analyticsParameters);
/*      */ 
/*      */ 
/*      */       }
/*  687 */       else if (!publishLikeOrUnlikeAsync(shouldLikeObject, analyticsParameters))
/*      */       {
/*      */ 
/*  690 */         updateLikeState(!shouldLikeObject);
/*  691 */         presentLikeDialog(activity, fragment, analyticsParameters);
/*      */       }
/*      */     } else {
/*  694 */       presentLikeDialog(activity, fragment, analyticsParameters);
/*      */     }
/*      */   }
/*      */   
/*      */   private AppEventsLogger getAppEventsLogger() {
/*  699 */     if (this.appEventsLogger == null) {
/*  700 */       this.appEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
/*      */     }
/*  702 */     return this.appEventsLogger;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean publishLikeOrUnlikeAsync(boolean shouldLikeObject, Bundle analyticsParameters)
/*      */   {
/*  708 */     boolean requested = false;
/*  709 */     if (canUseOGPublish()) {
/*  710 */       if (shouldLikeObject) {
/*  711 */         requested = true;
/*  712 */         publishLikeAsync(analyticsParameters);
/*  713 */       } else if (!Utility.isNullOrEmpty(this.unlikeToken)) {
/*  714 */         requested = true;
/*  715 */         publishUnlikeAsync(analyticsParameters);
/*      */       }
/*      */     }
/*      */     
/*  719 */     return requested;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void publishDidError(boolean oldLikeState)
/*      */   {
/*  727 */     updateLikeState(oldLikeState);
/*      */     
/*  729 */     Bundle errorBundle = new Bundle();
/*  730 */     errorBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
/*      */     
/*      */ 
/*      */ 
/*  734 */     broadcastAction(this, "com.facebook.sdk.LikeActionController.DID_ERROR", errorBundle);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void updateLikeState(boolean isObjectLiked)
/*      */   {
/*  741 */     updateState(isObjectLiked, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void updateState(boolean isObjectLiked, String likeCountStringWithLike, String likeCountStringWithoutLike, String socialSentenceWithLike, String socialSentenceWithoutLike, String unlikeToken)
/*      */   {
/*  756 */     likeCountStringWithLike = Utility.coerceValueIfNullOrEmpty(likeCountStringWithLike, null);
/*      */     
/*  758 */     likeCountStringWithoutLike = Utility.coerceValueIfNullOrEmpty(likeCountStringWithoutLike, null);
/*  759 */     socialSentenceWithLike = Utility.coerceValueIfNullOrEmpty(socialSentenceWithLike, null);
/*      */     
/*  761 */     socialSentenceWithoutLike = Utility.coerceValueIfNullOrEmpty(socialSentenceWithoutLike, null);
/*  762 */     unlikeToken = Utility.coerceValueIfNullOrEmpty(unlikeToken, null);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  775 */     boolean stateChanged = (isObjectLiked != this.isObjectLiked) || (!Utility.areObjectsEqual(likeCountStringWithLike, this.likeCountStringWithLike)) || (!Utility.areObjectsEqual(likeCountStringWithoutLike, this.likeCountStringWithoutLike)) || (!Utility.areObjectsEqual(socialSentenceWithLike, this.socialSentenceWithLike)) || (!Utility.areObjectsEqual(socialSentenceWithoutLike, this.socialSentenceWithoutLike)) || (!Utility.areObjectsEqual(unlikeToken, this.unlikeToken));
/*      */     
/*  777 */     if (!stateChanged) {
/*  778 */       return;
/*      */     }
/*      */     
/*  781 */     this.isObjectLiked = isObjectLiked;
/*  782 */     this.likeCountStringWithLike = likeCountStringWithLike;
/*  783 */     this.likeCountStringWithoutLike = likeCountStringWithoutLike;
/*  784 */     this.socialSentenceWithLike = socialSentenceWithLike;
/*  785 */     this.socialSentenceWithoutLike = socialSentenceWithoutLike;
/*  786 */     this.unlikeToken = unlikeToken;
/*      */     
/*  788 */     serializeToDiskAsync(this);
/*      */     
/*  790 */     broadcastAction(this, "com.facebook.sdk.LikeActionController.UPDATED");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void presentLikeDialog(Activity activity, FragmentWrapper fragmentWrapper, Bundle analyticsParameters)
/*      */   {
/*  797 */     String analyticsEvent = null;
/*      */     
/*  799 */     if (LikeDialog.canShowNativeDialog()) {
/*  800 */       analyticsEvent = "fb_like_control_did_present_dialog";
/*  801 */     } else if (LikeDialog.canShowWebFallback()) {
/*  802 */       analyticsEvent = "fb_like_control_did_present_fallback_dialog";
/*      */     }
/*      */     else {
/*  805 */       logAppEventForError("present_dialog", analyticsParameters);
/*  806 */       Utility.logd(TAG, "Cannot show the Like Dialog on this device.");
/*      */       
/*      */ 
/*      */ 
/*  810 */       broadcastAction(null, "com.facebook.sdk.LikeActionController.UPDATED");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  815 */     if (analyticsEvent != null)
/*      */     {
/*      */ 
/*  818 */       String objectTypeString = this.objectType != null ? this.objectType.toString() : LikeView.ObjectType.UNKNOWN.toString();
/*      */       
/*      */ 
/*      */ 
/*  822 */       LikeContent likeContent = new LikeContent.Builder().setObjectId(this.objectId).setObjectType(objectTypeString).build();
/*      */       
/*  824 */       if (fragmentWrapper != null) {
/*  825 */         new LikeDialog(fragmentWrapper).show(likeContent);
/*      */       } else {
/*  827 */         new LikeDialog(activity).show(likeContent);
/*      */       }
/*      */       
/*  830 */       saveState(analyticsParameters);
/*      */       
/*  832 */       getAppEventsLogger().logSdkEvent("fb_like_control_did_present_dialog", null, analyticsParameters);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void onActivityResult(int requestCode, int resultCode, Intent data)
/*      */   {
/*  844 */     ShareInternalUtility.handleActivityResult(requestCode, resultCode, data, 
/*      */     
/*      */ 
/*      */ 
/*  848 */       getResultProcessor(this.facebookDialogAnalyticsBundle));
/*      */     
/*      */ 
/*      */ 
/*  852 */     clearState();
/*      */   }
/*      */   
/*      */   private ResultProcessor getResultProcessor(final Bundle analyticsParameters) {
/*  856 */     new ResultProcessor(null)
/*      */     {
/*      */       public void onSuccess(AppCall appCall, Bundle data) {
/*  859 */         if ((data == null) || (!data.containsKey("object_is_liked")))
/*      */         {
/*  861 */           return;
/*      */         }
/*      */         
/*  864 */         boolean isObjectLiked = data.getBoolean("object_is_liked");
/*      */         
/*      */ 
/*      */ 
/*  868 */         String likeCountStringWithLike = LikeActionController.this.likeCountStringWithLike;
/*      */         
/*  870 */         String likeCountStringWithoutLike = LikeActionController.this.likeCountStringWithoutLike;
/*  871 */         if (data.containsKey("like_count_string"))
/*      */         {
/*  873 */           likeCountStringWithLike = data.getString("like_count_string");
/*  874 */           likeCountStringWithoutLike = likeCountStringWithLike;
/*      */         }
/*      */         
/*  877 */         String socialSentenceWithLike = LikeActionController.this.socialSentenceWithLike;
/*      */         
/*  879 */         String socialSentenceWithoutWithoutLike = LikeActionController.this.socialSentenceWithoutLike;
/*  880 */         if (data.containsKey("social_sentence")) {
/*  881 */           socialSentenceWithLike = data.getString("social_sentence");
/*      */           
/*  883 */           socialSentenceWithoutWithoutLike = socialSentenceWithLike;
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*  888 */         String unlikeToken = data.containsKey("object_is_liked") ? data.getString("unlike_token") : LikeActionController.this.unlikeToken;
/*      */         
/*  890 */         Bundle logParams = analyticsParameters == null ? new Bundle() : analyticsParameters;
/*      */         
/*  892 */         logParams.putString("call_id", appCall
/*      */         
/*  894 */           .getCallId().toString());
/*  895 */         LikeActionController.this.getAppEventsLogger().logSdkEvent("fb_like_control_dialog_did_succeed", null, logParams);
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  900 */         LikeActionController.this.updateState(isObjectLiked, likeCountStringWithLike, likeCountStringWithoutLike, socialSentenceWithLike, socialSentenceWithoutWithoutLike, unlikeToken);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       public void onError(AppCall appCall, FacebookException error)
/*      */       {
/*  911 */         Logger.log(LoggingBehavior.REQUESTS, 
/*      */         
/*  913 */           LikeActionController.TAG, "Like Dialog failed with error : %s", new Object[] { error });
/*      */         
/*      */ 
/*      */ 
/*  917 */         Bundle logParams = analyticsParameters == null ? new Bundle() : analyticsParameters;
/*  918 */         logParams.putString("call_id", appCall
/*      */         
/*  920 */           .getCallId().toString());
/*      */         
/*      */ 
/*  923 */         LikeActionController.this.logAppEventForError("present_dialog", logParams);
/*      */         
/*  925 */         LikeActionController.broadcastAction(LikeActionController.this, "com.facebook.sdk.LikeActionController.DID_ERROR", 
/*      */         
/*      */ 
/*  928 */           NativeProtocol.createBundleForException(error));
/*      */       }
/*      */       
/*      */       public void onCancel(AppCall appCall)
/*      */       {
/*  933 */         onError(appCall, new FacebookOperationCanceledException());
/*      */       }
/*      */     };
/*      */   }
/*      */   
/*      */   private void saveState(Bundle analyticsParameters)
/*      */   {
/*  940 */     storeObjectIdForPendingController(this.objectId);
/*      */     
/*      */ 
/*  943 */     this.facebookDialogAnalyticsBundle = analyticsParameters;
/*      */     
/*      */ 
/*  946 */     serializeToDiskAsync(this);
/*      */   }
/*      */   
/*      */   private void clearState() {
/*  950 */     this.facebookDialogAnalyticsBundle = null;
/*      */     
/*  952 */     storeObjectIdForPendingController(null);
/*      */   }
/*      */   
/*      */   private static void storeObjectIdForPendingController(String objectId) {
/*  956 */     objectIdForPendingController = objectId;
/*  957 */     Context appContext = FacebookSdk.getApplicationContext();
/*      */     
/*  959 */     appContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0)
/*  960 */       .edit()
/*  961 */       .putString("PENDING_CONTROLLER_KEY", objectIdForPendingController)
/*      */       
/*      */ 
/*  964 */       .apply();
/*      */   }
/*      */   
/*      */   private boolean canUseOGPublish() {
/*  968 */     AccessToken accessToken = AccessToken.getCurrentAccessToken();
/*      */     
/*      */ 
/*  971 */     if ((!this.objectIsPage) && (this.verifiedObjectId != null) && (accessToken != null)) {}
/*      */     
/*      */ 
/*      */ 
/*  975 */     return (accessToken.getPermissions() != null) && (accessToken.getPermissions().contains("publish_actions"));
/*      */   }
/*      */   
/*      */   private void publishLikeAsync(final Bundle analyticsParameters) {
/*  979 */     this.isPendingLikeOrUnlike = true;
/*      */     
/*  981 */     fetchVerifiedObjectId(new RequestCompletionCallback()
/*      */     {
/*      */       public void onComplete() {
/*  984 */         if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId))
/*      */         {
/*  986 */           Bundle errorBundle = new Bundle();
/*  987 */           errorBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
/*      */           
/*      */ 
/*      */ 
/*  991 */           LikeActionController.broadcastAction(LikeActionController.this, "com.facebook.sdk.LikeActionController.DID_ERROR", errorBundle);
/*      */           
/*      */ 
/*      */ 
/*  995 */           return;
/*      */         }
/*      */         
/*      */ 
/*  999 */         GraphRequestBatch requestBatch = new GraphRequestBatch();
/*      */         
/* 1001 */         final PublishLikeRequestWrapper likeRequest = new PublishLikeRequestWrapper(LikeActionController.this, LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
/* 1002 */         likeRequest.addToBatch(requestBatch);
/* 1003 */         requestBatch.addCallback(new GraphRequestBatch.Callback()
/*      */         {
/*      */           public void onBatchCompleted(GraphRequestBatch batch) {
/* 1006 */             LikeActionController.this.isPendingLikeOrUnlike = false;
/*      */             
/* 1008 */             if (likeRequest.getError() != null)
/*      */             {
/*      */ 
/*      */ 
/* 1012 */               LikeActionController.this.publishDidError(false);
/*      */             } else {
/* 1014 */               LikeActionController.this.unlikeToken = 
/* 1015 */                 Utility.coerceValueIfNullOrEmpty(likeRequest.unlikeToken, null);
/* 1016 */               LikeActionController.this.isObjectLikedOnServer = true;
/*      */               
/* 1018 */               LikeActionController.this.getAppEventsLogger().logSdkEvent("fb_like_control_did_like", null, LikeActionController.7.this.val$analyticsParameters);
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1025 */               LikeActionController.this.publishAgainIfNeeded(LikeActionController.7.this.val$analyticsParameters);
/*      */             }
/*      */             
/*      */           }
/* 1029 */         });
/* 1030 */         requestBatch.executeAsync();
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */   private void publishUnlikeAsync(final Bundle analyticsParameters) {
/* 1036 */     this.isPendingLikeOrUnlike = true;
/*      */     
/*      */ 
/* 1039 */     GraphRequestBatch requestBatch = new GraphRequestBatch();
/* 1040 */     final PublishUnlikeRequestWrapper unlikeRequest = new PublishUnlikeRequestWrapper(this.unlikeToken);
/*      */     
/* 1042 */     unlikeRequest.addToBatch(requestBatch);
/* 1043 */     requestBatch.addCallback(new GraphRequestBatch.Callback()
/*      */     {
/*      */       public void onBatchCompleted(GraphRequestBatch batch) {
/* 1046 */         LikeActionController.this.isPendingLikeOrUnlike = false;
/*      */         
/* 1048 */         if (unlikeRequest.getError() != null)
/*      */         {
/*      */ 
/* 1051 */           LikeActionController.this.publishDidError(true);
/*      */         } else {
/* 1053 */           LikeActionController.this.unlikeToken = null;
/* 1054 */           LikeActionController.this.isObjectLikedOnServer = false;
/*      */           
/* 1056 */           LikeActionController.this.getAppEventsLogger().logSdkEvent("fb_like_control_did_unlike", null, analyticsParameters);
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1063 */           LikeActionController.this.publishAgainIfNeeded(analyticsParameters);
/*      */         }
/*      */         
/*      */       }
/* 1067 */     });
/* 1068 */     requestBatch.executeAsync();
/*      */   }
/*      */   
/*      */   private void refreshStatusAsync() {
/* 1072 */     AccessToken accessToken = AccessToken.getCurrentAccessToken();
/* 1073 */     if (accessToken == null)
/*      */     {
/*      */ 
/*      */ 
/* 1077 */       refreshStatusViaService();
/* 1078 */       return;
/*      */     }
/*      */     
/* 1081 */     fetchVerifiedObjectId(new RequestCompletionCallback() {
/*      */       public void onComplete() {
/*      */         LikeRequestWrapper likeRequestWrapper;
/*      */         final LikeRequestWrapper likeRequestWrapper;
/* 1085 */         switch (LikeActionController.12.$SwitchMap$com$facebook$share$widget$LikeView$ObjectType[LikeActionController.this.objectType.ordinal()]) {
/*      */         case 1: 
/* 1087 */           likeRequestWrapper = new GetPageLikesRequestWrapper(LikeActionController.this, LikeActionController.this.verifiedObjectId);
/* 1088 */           break;
/*      */         
/*      */         default: 
/* 1091 */           likeRequestWrapper = new GetOGObjectLikesRequestWrapper(LikeActionController.this, LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
/*      */         }
/*      */         
/*      */         
/* 1095 */         final GetEngagementRequestWrapper engagementRequest = new GetEngagementRequestWrapper(LikeActionController.this, LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
/*      */         
/* 1097 */         GraphRequestBatch requestBatch = new GraphRequestBatch();
/* 1098 */         likeRequestWrapper.addToBatch(requestBatch);
/* 1099 */         engagementRequest.addToBatch(requestBatch);
/*      */         
/* 1101 */         requestBatch.addCallback(new GraphRequestBatch.Callback()
/*      */         {
/*      */           public void onBatchCompleted(GraphRequestBatch batch) {
/* 1104 */             if ((likeRequestWrapper.getError() != null) || 
/* 1105 */               (engagementRequest.getError() != null))
/*      */             {
/*      */ 
/* 1108 */               Logger.log(LoggingBehavior.REQUESTS, 
/*      */               
/* 1110 */                 LikeActionController.TAG, "Unable to refresh like state for id: '%s'", new Object[] {
/* 1111 */                 LikeActionController.this.objectId });
/* 1112 */               return;
/*      */             }
/*      */             
/* 1115 */             LikeActionController.this.updateState(likeRequestWrapper
/* 1116 */               .isObjectLiked(), engagementRequest.likeCountStringWithLike, engagementRequest.likeCountStringWithoutLike, engagementRequest.socialSentenceStringWithLike, engagementRequest.socialSentenceStringWithoutLike, likeRequestWrapper
/*      */               
/*      */ 
/*      */ 
/*      */ 
/* 1121 */               .getUnlikeToken());
/*      */           }
/*      */           
/* 1124 */         });
/* 1125 */         requestBatch.executeAsync();
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */   private void refreshStatusViaService()
/*      */   {
/* 1133 */     LikeStatusClient likeStatusClient = new LikeStatusClient(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), this.objectId);
/*      */     
/* 1135 */     if (!likeStatusClient.start()) {
/* 1136 */       return;
/*      */     }
/*      */     
/* 1139 */     PlatformServiceClient.CompletedListener callback = new PlatformServiceClient.CompletedListener()
/*      */     {
/*      */       public void completed(Bundle result)
/*      */       {
/* 1143 */         if ((result == null) || (!result.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED"))) {
/* 1144 */           return;
/*      */         }
/*      */         
/* 1147 */         boolean objectIsLiked = result.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1152 */         String likeCountWithLike = result.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE") ? result.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE") : LikeActionController.this.likeCountStringWithLike;
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1158 */         String likeCountWithoutLike = result.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE") ? result.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE") : LikeActionController.this.likeCountStringWithoutLike;
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1163 */         String socialSentenceWithLike = result.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE") ? result.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE") : LikeActionController.this.socialSentenceWithLike;
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1169 */         String socialSentenceWithoutLike = result.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE") ? result.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE") : LikeActionController.this.socialSentenceWithoutLike;
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1174 */         String unlikeToken = result.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN") ? result.getString("com.facebook.platform.extra.UNLIKE_TOKEN") : LikeActionController.this.unlikeToken;
/*      */         
/* 1176 */         LikeActionController.this.updateState(objectIsLiked, likeCountWithLike, likeCountWithoutLike, socialSentenceWithLike, socialSentenceWithoutLike, unlikeToken);
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1185 */     };
/* 1186 */     likeStatusClient.setCompletedListener(callback);
/*      */   }
/*      */   
/*      */   private void publishAgainIfNeeded(Bundle analyticsParameters) {
/* 1190 */     if ((this.isObjectLiked != this.isObjectLikedOnServer) && 
/* 1191 */       (!publishLikeOrUnlikeAsync(this.isObjectLiked, analyticsParameters)))
/*      */     {
/*      */ 
/* 1194 */       publishDidError(!this.isObjectLiked);
/*      */     }
/*      */   }
/*      */   
/*      */   private void fetchVerifiedObjectId(final RequestCompletionCallback completionHandler) {
/* 1199 */     if (!Utility.isNullOrEmpty(this.verifiedObjectId)) {
/* 1200 */       if (completionHandler != null) {
/* 1201 */         completionHandler.onComplete();
/*      */       }
/*      */       
/* 1204 */       return;
/*      */     }
/*      */     
/* 1207 */     final GetOGObjectIdRequestWrapper objectIdRequest = new GetOGObjectIdRequestWrapper(this.objectId, this.objectType);
/*      */     
/* 1209 */     final GetPageIdRequestWrapper pageIdRequest = new GetPageIdRequestWrapper(this.objectId, this.objectType);
/*      */     
/*      */ 
/* 1212 */     GraphRequestBatch requestBatch = new GraphRequestBatch();
/* 1213 */     objectIdRequest.addToBatch(requestBatch);
/* 1214 */     pageIdRequest.addToBatch(requestBatch);
/*      */     
/* 1216 */     requestBatch.addCallback(new GraphRequestBatch.Callback()
/*      */     {
/*      */       public void onBatchCompleted(GraphRequestBatch batch) {
/* 1219 */         LikeActionController.this.verifiedObjectId = objectIdRequest.verifiedObjectId;
/* 1220 */         if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
/* 1221 */           LikeActionController.this.verifiedObjectId = pageIdRequest.verifiedObjectId;
/* 1222 */           LikeActionController.this.objectIsPage = pageIdRequest.objectIsPage;
/*      */         }
/*      */         
/* 1225 */         if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
/* 1226 */           Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 
/* 1227 */             LikeActionController.TAG, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", new Object[] {
/*      */             
/*      */ 
/* 1230 */             LikeActionController.this.objectId });
/* 1231 */           LikeActionController.this.logAppEventForError("get_verified_id", pageIdRequest
/* 1232 */             .getError() != null ? pageIdRequest
/* 1233 */             .getError() : objectIdRequest
/* 1234 */             .getError());
/*      */         }
/*      */         
/* 1237 */         if (completionHandler != null) {
/* 1238 */           completionHandler.onComplete();
/*      */         }
/*      */         
/*      */       }
/* 1242 */     });
/* 1243 */     requestBatch.executeAsync();
/*      */   }
/*      */   
/*      */   private void logAppEventForError(String action, Bundle parameters) {
/* 1247 */     Bundle logParams = new Bundle(parameters);
/* 1248 */     logParams.putString("object_id", this.objectId);
/* 1249 */     logParams.putString("object_type", this.objectType.toString());
/* 1250 */     logParams.putString("current_action", action);
/*      */     
/* 1252 */     getAppEventsLogger().logSdkEvent("fb_like_control_error", null, logParams);
/*      */   }
/*      */   
/*      */   private void logAppEventForError(String action, FacebookRequestError error) {
/* 1256 */     Bundle logParams = new Bundle();
/* 1257 */     if (error != null) {
/* 1258 */       JSONObject requestResult = error.getRequestResult();
/* 1259 */       if (requestResult != null) {
/* 1260 */         logParams.putString("error", requestResult
/*      */         
/* 1262 */           .toString());
/*      */       }
/*      */     }
/* 1265 */     logAppEventForError(action, logParams);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static abstract interface CreationCallback
/*      */   {
/*      */     public abstract void onComplete(LikeActionController paramLikeActionController,
                                               FacebookException paramFacebookException);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static abstract interface RequestCompletionCallback
/*      */   {
/*      */     public abstract void onComplete();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private class GetOGObjectIdRequestWrapper
/*      */     extends AbstractRequestWrapper
/*      */   {
/*      */     String verifiedObjectId;
/*      */     
/*      */ 
/*      */ 
/*      */     GetOGObjectIdRequestWrapper(String objectId, LikeView.ObjectType objectType)
/*      */     {
/* 1296 */       super(objectId, objectType);
/*      */       
/* 1298 */       Bundle objectIdRequestParams = new Bundle();
/* 1299 */       objectIdRequestParams.putString("fields", "og_object.fields(id)");
/* 1300 */       objectIdRequestParams.putString("ids", objectId);
/*      */       
/* 1302 */       setRequest(new GraphRequest(
/* 1303 */         AccessToken.getCurrentAccessToken(), "", objectIdRequestParams, HttpMethod.GET));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void processError(FacebookRequestError error)
/*      */     {
/* 1313 */       if (error.getErrorMessage().contains("og_object")) {
/* 1314 */         this.error = null;
/*      */       } else {
/* 1316 */         Logger.log(LoggingBehavior.REQUESTS, 
/* 1317 */           LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, error });
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void processSuccess(GraphResponse response)
/*      */     {
/* 1327 */       JSONObject results = Utility.tryGetJSONObjectFromResponse(response
/* 1328 */         .getJSONObject(), this.objectId);
/*      */       
/* 1330 */       if (results != null)
/*      */       {
/* 1332 */         JSONObject ogObject = results.optJSONObject("og_object");
/* 1333 */         if (ogObject != null) {
/* 1334 */           this.verifiedObjectId = ogObject.optString("id");
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private class GetPageIdRequestWrapper extends AbstractRequestWrapper {
/*      */     String verifiedObjectId;
/*      */     boolean objectIsPage;
/*      */     
/*      */     GetPageIdRequestWrapper(String objectId, LikeView.ObjectType objectType) {
/* 1345 */       super(objectId, objectType);
/*      */       
/* 1347 */       Bundle pageIdRequestParams = new Bundle();
/* 1348 */       pageIdRequestParams.putString("fields", "id");
/* 1349 */       pageIdRequestParams.putString("ids", objectId);
/*      */       
/* 1351 */       setRequest(new GraphRequest(
/* 1352 */         AccessToken.getCurrentAccessToken(), "", pageIdRequestParams, HttpMethod.GET));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void processSuccess(GraphResponse response)
/*      */     {
/* 1360 */       JSONObject results = Utility.tryGetJSONObjectFromResponse(response
/* 1361 */         .getJSONObject(), this.objectId);
/*      */       
/* 1363 */       if (results != null) {
/* 1364 */         this.verifiedObjectId = results.optString("id");
/* 1365 */         this.objectIsPage = (!Utility.isNullOrEmpty(this.verifiedObjectId));
/*      */       }
/*      */     }
/*      */     
/*      */     protected void processError(FacebookRequestError error)
/*      */     {
/* 1371 */       Logger.log(LoggingBehavior.REQUESTS, 
/* 1372 */         LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, error });
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private class PublishLikeRequestWrapper
/*      */     extends AbstractRequestWrapper
/*      */   {
/*      */     String unlikeToken;
/*      */     
/*      */     PublishLikeRequestWrapper(String objectId, LikeView.ObjectType objectType)
/*      */     {
/* 1384 */       super(objectId, objectType);
/*      */       
/* 1386 */       Bundle likeRequestParams = new Bundle();
/* 1387 */       likeRequestParams.putString("object", objectId);
/*      */       
/* 1389 */       setRequest(new GraphRequest(
/* 1390 */         AccessToken.getCurrentAccessToken(), "me/og.likes", likeRequestParams, HttpMethod.POST));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void processSuccess(GraphResponse response)
/*      */     {
/* 1398 */       this.unlikeToken = Utility.safeGetStringFromResponse(response.getJSONObject(), "id");
/*      */     }
/*      */     
/*      */     protected void processError(FacebookRequestError error)
/*      */     {
/* 1403 */       int errorCode = error.getErrorCode();
/* 1404 */       if (errorCode == 3501)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1409 */         this.error = null;
/*      */       } else {
/* 1411 */         Logger.log(LoggingBehavior.REQUESTS, 
/* 1412 */           LikeActionController.TAG, "Error liking object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, error });
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1417 */         LikeActionController.this.logAppEventForError("publish_like", error);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private class PublishUnlikeRequestWrapper extends AbstractRequestWrapper {
/*      */     private String unlikeToken;
/*      */     
/*      */     PublishUnlikeRequestWrapper(String unlikeToken) {
/* 1426 */       super(null, null);
/*      */       
/* 1428 */       this.unlikeToken = unlikeToken;
/*      */       
/* 1430 */       setRequest(new GraphRequest(
/* 1431 */         AccessToken.getCurrentAccessToken(), unlikeToken, null, HttpMethod.DELETE));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void processSuccess(GraphResponse response) {}
/*      */     
/*      */ 
/*      */ 
/*      */     protected void processError(FacebookRequestError error)
/*      */     {
/* 1443 */       Logger.log(LoggingBehavior.REQUESTS, 
/* 1444 */         LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", new Object[] { this.unlikeToken, error });
/*      */       
/* 1446 */       LikeActionController.this.logAppEventForError("publish_unlike", error);
/*      */     }
/*      */   }
/*      */   
/*      */   private static abstract interface LikeRequestWrapper extends RequestWrapper
/*      */   {
/*      */     public abstract boolean isObjectLiked();
/*      */     
/*      */     public abstract String getUnlikeToken();
/*      */   }
/*      */   
/*      */   private class GetPageLikesRequestWrapper extends AbstractRequestWrapper implements LikeRequestWrapper {
/* 1458 */     private boolean objectIsLiked = LikeActionController.this.isObjectLiked;
/*      */     private String pageId;
/*      */     
/*      */     GetPageLikesRequestWrapper(String pageId) {
/* 1462 */       super(pageId, LikeView.ObjectType.PAGE);
/* 1463 */       this.pageId = pageId;
/*      */       
/* 1465 */       Bundle requestParams = new Bundle();
/* 1466 */       requestParams.putString("fields", "id");
/*      */       
/* 1468 */       setRequest(new GraphRequest(
/* 1469 */         AccessToken.getCurrentAccessToken(), "me/likes/" + pageId, requestParams, HttpMethod.GET));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void processSuccess(GraphResponse response)
/*      */     {
/* 1477 */       JSONArray dataSet = Utility.tryGetJSONArrayFromResponse(response
/* 1478 */         .getJSONObject(), "data");
/*      */       
/* 1480 */       if ((dataSet != null) && (dataSet.length() > 0)) {
/* 1481 */         this.objectIsLiked = true;
/*      */       }
/*      */     }
/*      */     
/*      */     protected void processError(FacebookRequestError error)
/*      */     {
/* 1487 */       Logger.log(LoggingBehavior.REQUESTS, 
/* 1488 */         LikeActionController.TAG, "Error fetching like status for page id '%s': %s", new Object[] { this.pageId, error });
/*      */       
/*      */ 
/*      */ 
/* 1492 */       LikeActionController.this.logAppEventForError("get_page_like", error);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isObjectLiked()
/*      */     {
/* 1498 */       return this.objectIsLiked;
/*      */     }
/*      */     
/*      */     public String getUnlikeToken()
/*      */     {
/* 1503 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private class GetOGObjectLikesRequestWrapper
/*      */     extends AbstractRequestWrapper
/*      */     implements LikeRequestWrapper
/*      */   {
/* 1512 */     private boolean objectIsLiked = LikeActionController.this.isObjectLiked;
/*      */     private String unlikeToken;
/*      */     private final String objectId;
/*      */     private final LikeView.ObjectType objectType;
/*      */     
/*      */     GetOGObjectLikesRequestWrapper(String objectId, LikeView.ObjectType objectType) {
/* 1518 */       super(objectId, objectType);
/* 1519 */       this.objectId = objectId;
/* 1520 */       this.objectType = objectType;
/*      */       
/* 1522 */       Bundle requestParams = new Bundle();
/* 1523 */       requestParams.putString("fields", "id,application");
/* 1524 */       requestParams.putString("object", this.objectId);
/*      */       
/* 1526 */       setRequest(new GraphRequest(
/* 1527 */         AccessToken.getCurrentAccessToken(), "me/og.likes", requestParams, HttpMethod.GET));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void processSuccess(GraphResponse response)
/*      */     {
/* 1535 */       JSONArray dataSet = Utility.tryGetJSONArrayFromResponse(response
/* 1536 */         .getJSONObject(), "data");
/*      */       
/* 1538 */       if (dataSet != null) {
/* 1539 */         for (int i = 0; i < dataSet.length(); i++) {
/* 1540 */           JSONObject data = dataSet.optJSONObject(i);
/* 1541 */           if (data != null) {
/* 1542 */             this.objectIsLiked = true;
/* 1543 */             JSONObject appData = data.optJSONObject("application");
/* 1544 */             AccessToken accessToken = AccessToken.getCurrentAccessToken();
/* 1545 */             if ((appData != null) && (accessToken != null))
/*      */             {
/* 1547 */               if (Utility.areObjectsEqual(accessToken
/* 1548 */                 .getApplicationId(), appData
/* 1549 */                 .optString("id"))) {
/* 1550 */                 this.unlikeToken = data.optString("id");
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     protected void processError(FacebookRequestError error) {
/* 1559 */       Logger.log(LoggingBehavior.REQUESTS, 
/* 1560 */         LikeActionController.TAG, "Error fetching like status for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, error });
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1565 */       LikeActionController.this.logAppEventForError("get_og_object_like", error);
/*      */     }
/*      */     
/*      */     public boolean isObjectLiked()
/*      */     {
/* 1570 */       return this.objectIsLiked;
/*      */     }
/*      */     
/*      */     public String getUnlikeToken()
/*      */     {
/* 1575 */       return this.unlikeToken;
/*      */     }
/*      */   }
/*      */   
/*      */   private class GetEngagementRequestWrapper
/*      */     extends AbstractRequestWrapper
/*      */   {
/* 1582 */     String likeCountStringWithLike = LikeActionController.this.likeCountStringWithLike;
/* 1583 */     String likeCountStringWithoutLike = LikeActionController.this.likeCountStringWithoutLike;
/* 1584 */     String socialSentenceStringWithLike = LikeActionController.this.socialSentenceWithLike;
/*      */     
/* 1586 */     String socialSentenceStringWithoutLike = LikeActionController.this.socialSentenceWithoutLike;
/*      */     
/*      */     GetEngagementRequestWrapper(String objectId, LikeView.ObjectType objectType) {
/* 1589 */       super(objectId, objectType);
/*      */       
/* 1591 */       Bundle requestParams = new Bundle();
/* 1592 */       requestParams.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1601 */       requestParams.putString("locale", Locale.getDefault().toString());
/*      */       
/* 1603 */       setRequest(new GraphRequest(
/* 1604 */         AccessToken.getCurrentAccessToken(), objectId, requestParams, HttpMethod.GET));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void processSuccess(GraphResponse response)
/*      */     {
/* 1612 */       JSONObject engagementResults = Utility.tryGetJSONObjectFromResponse(response
/* 1613 */         .getJSONObject(), "engagement");
/*      */       
/* 1615 */       if (engagementResults != null)
/*      */       {
/*      */ 
/* 1618 */         this.likeCountStringWithLike = engagementResults.optString("count_string_with_like", this.likeCountStringWithLike);
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1623 */         this.likeCountStringWithoutLike = engagementResults.optString("count_string_without_like", this.likeCountStringWithoutLike);
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1628 */         this.socialSentenceStringWithLike = engagementResults.optString("social_sentence_with_like", this.socialSentenceStringWithLike);
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1633 */         this.socialSentenceStringWithoutLike = engagementResults.optString("social_sentence_without_like", this.socialSentenceStringWithoutLike);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     protected void processError(FacebookRequestError error)
/*      */     {
/* 1641 */       Logger.log(LoggingBehavior.REQUESTS, 
/* 1642 */         LikeActionController.TAG, "Error fetching engagement for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, error });
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1647 */       LikeActionController.this.logAppEventForError("get_engagement", error);
/*      */     }
/*      */   }
/*      */   
/*      */   private static abstract interface RequestWrapper {
/*      */     public abstract FacebookRequestError getError();
/*      */     
/*      */     public abstract void addToBatch(GraphRequestBatch paramGraphRequestBatch);
/*      */   }
/*      */   
/*      */   private abstract class AbstractRequestWrapper implements RequestWrapper {
/*      */     private GraphRequest request;
/*      */     protected String objectId;
/*      */     protected LikeView.ObjectType objectType;
/*      */     protected FacebookRequestError error;
/*      */     
/* 1663 */     protected AbstractRequestWrapper(String objectId, LikeView.ObjectType objectType) { this.objectId = objectId;
/* 1664 */       this.objectType = objectType;
/*      */     }
/*      */     
/*      */     public void addToBatch(GraphRequestBatch batch) {
/* 1668 */       batch.add(this.request);
/*      */     }
/*      */     
/*      */     public FacebookRequestError getError() {
/* 1672 */       return this.error;
/*      */     }
/*      */     
/*      */     protected void setRequest(GraphRequest request) {
/* 1676 */       this.request = request;
/*      */       
/*      */ 
/* 1679 */       request.setVersion(FacebookSdk.getGraphApiVersion());
/* 1680 */       request.setCallback(new GraphRequest.Callback()
/*      */       {
/*      */         public void onCompleted(GraphResponse response) {
/* 1683 */           AbstractRequestWrapper.this.error = response.getError();
/* 1684 */           if (AbstractRequestWrapper.this.error != null) {
/* 1685 */             AbstractRequestWrapper.this.processError(AbstractRequestWrapper.this.error);
/*      */           } else {
/* 1687 */             AbstractRequestWrapper.this.processSuccess(response);
/*      */           }
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*      */     protected void processError(FacebookRequestError error) {
/* 1694 */       Logger.log(LoggingBehavior.REQUESTS, 
/* 1695 */         LikeActionController.TAG, "Error running request for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, error });
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     protected abstract void processSuccess(GraphResponse paramGraphResponse);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static class MRUCacheWorkItem
/*      */     implements Runnable
/*      */   {
/* 1710 */     private static ArrayList<String> mruCachedItems = new ArrayList();
/*      */     private String cacheItem;
/*      */     private boolean shouldTrim;
/*      */     
/*      */     MRUCacheWorkItem(String cacheItem, boolean shouldTrim) {
/* 1715 */       this.cacheItem = cacheItem;
/* 1716 */       this.shouldTrim = shouldTrim;
/*      */     }
/*      */     
/*      */     public void run()
/*      */     {
/* 1721 */       if (this.cacheItem != null) {
/* 1722 */         mruCachedItems.remove(this.cacheItem);
/* 1723 */         mruCachedItems.add(0, this.cacheItem);
/*      */       }
/* 1725 */       if ((this.shouldTrim) && (mruCachedItems.size() >= 128)) {
/* 1726 */         int targetSize = 64;
/* 1727 */         while (targetSize < mruCachedItems.size()) {
/* 1728 */           String cacheKey = (String)mruCachedItems.remove(mruCachedItems.size() - 1);
/*      */           
/*      */ 
/* 1731 */           LikeActionController.cache.remove(cacheKey);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static class SerializeToDiskWorkItem implements Runnable {
/*      */     private String cacheKey;
/*      */     private String controllerJson;
/*      */     
/*      */     SerializeToDiskWorkItem(String cacheKey, String controllerJson) {
/* 1742 */       this.cacheKey = cacheKey;
/* 1743 */       this.controllerJson = controllerJson;
/*      */     }
/*      */     
/*      */     public void run()
/*      */     {
/* 1748 */       LikeActionController.serializeToDiskSynchronously(this.cacheKey, this.controllerJson);
/*      */     }
/*      */   }
/*      */   
/*      */   private static class CreateLikeActionControllerWorkItem
/*      */     implements Runnable
/*      */   {
/*      */     private String objectId;
/*      */     private LikeView.ObjectType objectType;
/*      */     private CreationCallback callback;
/*      */     
/*      */     CreateLikeActionControllerWorkItem(String objectId, LikeView.ObjectType objectType, CreationCallback callback)
/*      */     {
/* 1761 */       this.objectId = objectId;
/* 1762 */       this.objectType = objectType;
/* 1763 */       this.callback = callback;
/*      */     }
/*      */     
/*      */     public void run()
/*      */     {
/* 1768 */       LikeActionController.createControllerForObjectIdAndType(this.objectId, this.objectType, this.callback);
/*      */     }
/*      */   }
/*      */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/LikeActionController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */