/*     */ package com.facebook.applinks;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphResponse;
/*     */ import com.facebook.appevents.AppEventsLogger;
/*     */ import com.facebook.internal.AttributionIdentifiers;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Validate;
/*     */ import java.util.Iterator;
/*     */ import java.util.concurrent.Executor;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AppLinkData
/*     */ {
/*     */   public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
/*     */   public static final String ARGUMENTS_REFERER_DATA_KEY = "referer_data";
/*     */   public static final String ARGUMENTS_EXTRAS_KEY = "extras";
/*     */   public static final String ARGUMENTS_NATIVE_CLASS_KEY = "com.facebook.platform.APPLINK_NATIVE_CLASS";
/*     */   public static final String ARGUMENTS_NATIVE_URL = "com.facebook.platform.APPLINK_NATIVE_URL";
/*     */   static final String BUNDLE_APPLINK_ARGS_KEY = "com.facebook.platform.APPLINK_ARGS";
/*     */   private static final String BUNDLE_AL_APPLINK_DATA_KEY = "al_applink_data";
/*     */   private static final String APPLINK_BRIDGE_ARGS_KEY = "bridge_args";
/*     */   private static final String APPLINK_METHOD_ARGS_KEY = "method_args";
/*     */   private static final String APPLINK_VERSION_KEY = "version";
/*     */   private static final String BRIDGE_ARGS_METHOD_KEY = "method";
/*     */   private static final String DEFERRED_APP_LINK_EVENT = "DEFERRED_APP_LINK";
/*     */   private static final String DEFERRED_APP_LINK_PATH = "%s/activities";
/*     */   private static final String DEFERRED_APP_LINK_ARGS_FIELD = "applink_args";
/*     */   private static final String DEFERRED_APP_LINK_CLASS_FIELD = "applink_class";
/*     */   private static final String DEFERRED_APP_LINK_CLICK_TIME_FIELD = "click_time";
/*     */   private static final String DEFERRED_APP_LINK_URL_FIELD = "applink_url";
/*     */   private static final String METHOD_ARGS_TARGET_URL_KEY = "target_url";
/*     */   private static final String METHOD_ARGS_REF_KEY = "ref";
/*     */   private static final String REFERER_DATA_REF_KEY = "fb_ref";
/*     */   private static final String EXTRAS_DEEPLINK_CONTEXT_KEY = "deeplink_context";
/*     */   private static final String PROMOTION_CODE_KEY = "promo_code";
/*  99 */   private static final String TAG = AppLinkData.class.getCanonicalName();
/*     */   
/*     */ 
/*     */   private String ref;
/*     */   
/*     */ 
/*     */   private Uri targetUri;
/*     */   
/*     */ 
/*     */   private JSONObject arguments;
/*     */   
/*     */ 
/*     */   private Bundle argumentBundle;
/*     */   
/*     */   private String promotionCode;
/*     */   
/*     */ 
/*     */   public static void fetchDeferredAppLinkData(Context context, CompletionHandler completionHandler)
/*     */   {
/* 118 */     fetchDeferredAppLinkData(context, null, completionHandler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void fetchDeferredAppLinkData(Context context, String applicationId, final CompletionHandler completionHandler)
/*     */   {
/* 134 */     Validate.notNull(context, "context");
/* 135 */     Validate.notNull(completionHandler, "completionHandler");
/*     */     
/* 137 */     if (applicationId == null) {
/* 138 */       applicationId = Utility.getMetadataApplicationId(context);
/*     */     }
/*     */     
/* 141 */     Validate.notNull(applicationId, "applicationId");
/*     */     
/* 143 */     Context applicationContext = context.getApplicationContext();
/* 144 */     final String applicationIdCopy = applicationId;
/* 145 */     FacebookSdk.getExecutor().execute(new Runnable()
/*     */     {
/*     */       public void run() {
/* 148 */         AppLinkData.fetchDeferredAppLinkFromServer(this.val$applicationContext, applicationIdCopy, completionHandler);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void fetchDeferredAppLinkFromServer(Context context, String applicationId, CompletionHandler completionHandler)
/*     */   {
/* 159 */     JSONObject deferredApplinkParams = new JSONObject();
/*     */     try {
/* 161 */       deferredApplinkParams.put("event", "DEFERRED_APP_LINK");
/* 162 */       Utility.setAppEventAttributionParameters(deferredApplinkParams, 
/* 163 */         AttributionIdentifiers.getAttributionIdentifiers(context), 
/* 164 */         AppEventsLogger.getAnonymousAppDeviceGUID(context), 
/* 165 */         FacebookSdk.getLimitEventAndDataUsage(context));
/* 166 */       deferredApplinkParams.put("application_package_name", context.getPackageName());
/*     */     } catch (JSONException e) {
/* 168 */       throw new FacebookException("An error occurred while preparing deferred app link", e);
/*     */     }
/*     */     
/* 171 */     String deferredApplinkUrlPath = String.format("%s/activities", new Object[] { applicationId });
/* 172 */     AppLinkData appLinkData = null;
/*     */     try
/*     */     {
/* 175 */       GraphRequest deferredApplinkRequest = GraphRequest.newPostRequest(null, deferredApplinkUrlPath, deferredApplinkParams, null);
/*     */       
/* 177 */       GraphResponse deferredApplinkResponse = deferredApplinkRequest.executeAndWait();
/* 178 */       JSONObject jsonResponse = deferredApplinkResponse.getJSONObject();
/* 179 */       if (jsonResponse != null)
/*     */       {
/* 181 */         String appLinkArgsJsonString = jsonResponse.optString("applink_args");
/*     */         
/* 183 */         long tapTimeUtc = jsonResponse.optLong("click_time", -1L);
/*     */         
/* 185 */         String appLinkClassName = jsonResponse.optString("applink_class");
/* 186 */         String appLinkUrl = jsonResponse.optString("applink_url");
/*     */         
/* 188 */         if (!TextUtils.isEmpty(appLinkArgsJsonString)) {
/* 189 */           appLinkData = createFromJson(appLinkArgsJsonString);
/*     */           
/* 191 */           if (tapTimeUtc != -1L) {
/*     */             try {
/* 193 */               if (appLinkData.arguments != null) {
/* 194 */                 appLinkData.arguments.put("com.facebook.platform.APPLINK_TAP_TIME_UTC", tapTimeUtc);
/*     */               }
/* 196 */               if (appLinkData.argumentBundle != null) {
/* 197 */                 appLinkData.argumentBundle.putString("com.facebook.platform.APPLINK_TAP_TIME_UTC", 
/* 198 */                   Long.toString(tapTimeUtc));
/*     */               }
/*     */             } catch (JSONException e) {
/* 201 */               Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
/*     */             }
/*     */           }
/*     */           
/* 205 */           if (appLinkClassName != null) {
/*     */             try {
/* 207 */               if (appLinkData.arguments != null) {
/* 208 */                 appLinkData.arguments.put("com.facebook.platform.APPLINK_NATIVE_CLASS", appLinkClassName);
/*     */               }
/*     */               
/* 211 */               if (appLinkData.argumentBundle != null) {
/* 212 */                 appLinkData.argumentBundle.putString("com.facebook.platform.APPLINK_NATIVE_CLASS", appLinkClassName);
/*     */               }
/*     */             }
/*     */             catch (JSONException e) {
/* 216 */               Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
/*     */             }
/*     */           }
/*     */           
/* 220 */           if (appLinkUrl != null) {
/*     */             try {
/* 222 */               if (appLinkData.arguments != null) {
/* 223 */                 appLinkData.arguments.put("com.facebook.platform.APPLINK_NATIVE_URL", appLinkUrl);
/*     */               }
/* 225 */               if (appLinkData.argumentBundle != null) {
/* 226 */                 appLinkData.argumentBundle.putString("com.facebook.platform.APPLINK_NATIVE_URL", appLinkUrl);
/*     */               }
/*     */             }
/*     */             catch (JSONException e) {
/* 230 */               Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 236 */       Utility.logd(TAG, "Unable to fetch deferred applink from server");
/*     */     }
/*     */     
/* 239 */     completionHandler.onDeferredAppLinkDataFetched(appLinkData);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static AppLinkData createFromActivity(Activity activity)
/*     */   {
/* 248 */     Validate.notNull(activity, "activity");
/* 249 */     Intent intent = activity.getIntent();
/* 250 */     if (intent == null) {
/* 251 */       return null;
/*     */     }
/*     */     
/* 254 */     AppLinkData appLinkData = createFromAlApplinkData(intent);
/* 255 */     if (appLinkData == null) {
/* 256 */       String appLinkArgsJsonString = intent.getStringExtra("com.facebook.platform.APPLINK_ARGS");
/* 257 */       appLinkData = createFromJson(appLinkArgsJsonString);
/*     */     }
/* 259 */     if (appLinkData == null)
/*     */     {
/* 261 */       appLinkData = createFromUri(intent.getData());
/*     */     }
/*     */     
/* 264 */     return appLinkData;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static AppLinkData createFromAlApplinkData(Intent intent)
/*     */   {
/* 273 */     if (intent == null) {
/* 274 */       return null;
/*     */     }
/*     */     
/* 277 */     Bundle applinks = intent.getBundleExtra("al_applink_data");
/* 278 */     if (applinks == null) {
/* 279 */       return null;
/*     */     }
/*     */     
/* 282 */     AppLinkData appLinkData = new AppLinkData();
/* 283 */     appLinkData.targetUri = intent.getData();
/* 284 */     if (appLinkData.targetUri == null) {
/* 285 */       String targetUriString = applinks.getString("target_url");
/* 286 */       if (targetUriString != null) {
/* 287 */         appLinkData.targetUri = Uri.parse(targetUriString);
/*     */       }
/*     */     }
/* 290 */     appLinkData.argumentBundle = applinks;
/* 291 */     appLinkData.arguments = null;
/* 292 */     Bundle refererData = applinks.getBundle("referer_data");
/* 293 */     if (refererData != null) {
/* 294 */       appLinkData.ref = refererData.getString("fb_ref");
/*     */     }
/*     */     
/* 297 */     Bundle extras = applinks.getBundle("extras");
/* 298 */     if (extras != null) {
/* 299 */       String deeplinkContext = extras.getString("deeplink_context");
/* 300 */       if (deeplinkContext != null) {
/*     */         try {
/* 302 */           JSONObject dlContextJson = new JSONObject(deeplinkContext);
/* 303 */           if (dlContextJson.has("promo_code")) {
/* 304 */             appLinkData.promotionCode = dlContextJson.getString("promo_code");
/*     */           }
/*     */         } catch (JSONException e) {
/* 307 */           Log.d(TAG, "Unable to parse deeplink_context JSON", e);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 312 */     return appLinkData;
/*     */   }
/*     */   
/*     */   private static AppLinkData createFromJson(String jsonString) {
/* 316 */     if (jsonString == null) {
/* 317 */       return null;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 322 */       JSONObject appLinkArgsJson = new JSONObject(jsonString);
/* 323 */       String version = appLinkArgsJson.getString("version");
/*     */       
/* 325 */       JSONObject bridgeArgs = appLinkArgsJson.getJSONObject("bridge_args");
/* 326 */       String method = bridgeArgs.getString("method");
/* 327 */       if ((method.equals("applink")) && (version.equals("2")))
/*     */       {
/* 329 */         AppLinkData appLinkData = new AppLinkData();
/*     */         
/* 331 */         appLinkData.arguments = appLinkArgsJson.getJSONObject("method_args");
/*     */         
/* 333 */         if (appLinkData.arguments.has("ref")) {
/* 334 */           appLinkData.ref = appLinkData.arguments.getString("ref");
/* 335 */         } else if (appLinkData.arguments.has("referer_data"))
/*     */         {
/* 337 */           JSONObject refererData = appLinkData.arguments.getJSONObject("referer_data");
/*     */           
/* 339 */           if (refererData.has("fb_ref")) {
/* 340 */             appLinkData.ref = refererData.getString("fb_ref");
/*     */           }
/*     */         }
/*     */         
/* 344 */         if (appLinkData.arguments.has("target_url")) {
/* 345 */           appLinkData.targetUri = Uri.parse(appLinkData.arguments
/* 346 */             .getString("target_url"));
/*     */         }
/*     */         
/* 349 */         if (appLinkData.arguments.has("extras"))
/*     */         {
/* 351 */           JSONObject extrasData = appLinkData.arguments.getJSONObject("extras");
/* 352 */           if (extrasData.has("deeplink_context"))
/*     */           {
/* 354 */             JSONObject deeplink_context = extrasData.getJSONObject("deeplink_context");
/* 355 */             if (deeplink_context.has("promo_code"))
/*     */             {
/* 357 */               appLinkData.promotionCode = deeplink_context.getString("promo_code");
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 362 */         appLinkData.argumentBundle = toBundle(appLinkData.arguments);
/*     */         
/* 364 */         return appLinkData;
/*     */       }
/*     */     } catch (JSONException e) {
/* 367 */       Log.d(TAG, "Unable to parse AppLink JSON", e);
/*     */     } catch (FacebookException e) {
/* 369 */       Log.d(TAG, "Unable to parse AppLink JSON", e);
/*     */     }
/*     */     
/* 372 */     return null;
/*     */   }
/*     */   
/*     */   private static AppLinkData createFromUri(Uri appLinkDataUri) {
/* 376 */     if (appLinkDataUri == null) {
/* 377 */       return null;
/*     */     }
/*     */     
/* 380 */     AppLinkData appLinkData = new AppLinkData();
/* 381 */     appLinkData.targetUri = appLinkDataUri;
/* 382 */     return appLinkData;
/*     */   }
/*     */   
/*     */   private static Bundle toBundle(JSONObject node) throws JSONException {
/* 386 */     Bundle bundle = new Bundle();
/*     */     
/* 388 */     Iterator<String> fields = node.keys();
/* 389 */     while (fields.hasNext()) {
/* 390 */       String key = (String)fields.next();
/*     */       
/* 392 */       Object value = node.get(key);
/*     */       
/* 394 */       if ((value instanceof JSONObject)) {
/* 395 */         bundle.putBundle(key, toBundle((JSONObject)value));
/* 396 */       } else if ((value instanceof JSONArray)) {
/* 397 */         JSONArray valueArr = (JSONArray)value;
/* 398 */         if (valueArr.length() == 0) {
/* 399 */           bundle.putStringArray(key, new String[0]);
/*     */         } else {
/* 401 */           Object firstNode = valueArr.get(0);
/* 402 */           if ((firstNode instanceof JSONObject)) {
/* 403 */             Bundle[] bundles = new Bundle[valueArr.length()];
/* 404 */             for (int i = 0; i < valueArr.length(); i++) {
/* 405 */               bundles[i] = toBundle(valueArr.getJSONObject(i));
/*     */             }
/* 407 */             bundle.putParcelableArray(key, bundles);
/* 408 */           } else { if ((firstNode instanceof JSONArray))
/*     */             {
/* 410 */               throw new FacebookException("Nested arrays are not supported.");
/*     */             }
/* 412 */             String[] arrValues = new String[valueArr.length()];
/* 413 */             for (int i = 0; i < valueArr.length(); i++) {
/* 414 */               arrValues[i] = valueArr.get(i).toString();
/*     */             }
/* 416 */             bundle.putStringArray(key, arrValues);
/*     */           }
/*     */         }
/*     */       } else {
/* 420 */         bundle.putString(key, value.toString());
/*     */       }
/*     */     }
/* 423 */     return bundle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Uri getTargetUri()
/*     */   {
/* 435 */     return this.targetUri;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRef()
/*     */   {
/* 443 */     return this.ref;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPromotionCode()
/*     */   {
/* 451 */     return this.promotionCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bundle getArgumentBundle()
/*     */   {
/* 460 */     return this.argumentBundle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bundle getRefererData()
/*     */   {
/* 470 */     if (this.argumentBundle != null) {
/* 471 */       return this.argumentBundle.getBundle("referer_data");
/*     */     }
/* 473 */     return null;
/*     */   }
/*     */   
/*     */   public static abstract interface CompletionHandler
/*     */   {
/*     */     public abstract void onDeferredAppLinkDataFetched(AppLinkData paramAppLinkData);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/applinks/AppLinkData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */