/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.graphics.Bitmap;
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import android.os.ParcelFileDescriptor;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.util.Pair;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.CallbackManager;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookGraphResponseException;
/*     */ import com.facebook.FacebookOperationCanceledException;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphRequest.Callback;
/*     */ import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
/*     */ import com.facebook.GraphResponse;
/*     */ import com.facebook.HttpMethod;
/*     */ import com.facebook.appevents.AppEventsLogger;
/*     */ import com.facebook.internal.AppCall;
/*     */ import com.facebook.internal.CallbackManagerImpl;
/*     */ import com.facebook.internal.CallbackManagerImpl.Callback;
/*     */ import com.facebook.internal.NativeAppCallAttachmentStore;
/*     */ import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
/*     */ import com.facebook.internal.NativeProtocol;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Utility.Mapper;
/*     */ import com.facebook.share.Sharer.Result;
/*     */ import com.facebook.share.model.ShareMedia;
/*     */ import com.facebook.share.model.ShareMedia.Type;
/*     */ import com.facebook.share.model.ShareMediaContent;
/*     */ import com.facebook.share.model.ShareOpenGraphAction;
/*     */ import com.facebook.share.model.ShareOpenGraphContent;
/*     */ import com.facebook.share.model.SharePhoto;
/*     */ import com.facebook.share.model.SharePhotoContent;
/*     */ import com.facebook.share.model.ShareVideo;
/*     */ import com.facebook.share.model.ShareVideoContent;
/*     */ import com.facebook.share.widget.LikeView.ObjectType;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
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
/*     */ public final class ShareInternalUtility
/*     */ {
/*     */   public static final String MY_PHOTOS = "me/photos";
/*     */   private static final String MY_STAGING_RESOURCES = "me/staging_resources";
/*     */   private static final String STAGING_PARAM = "file";
/*     */   
/*     */   public static void invokeCallbackWithException(FacebookCallback<Sharer.Result> callback, Exception exception)
/*     */   {
/*  89 */     if ((exception instanceof FacebookException)) {
/*  90 */       invokeOnErrorCallback(callback, (FacebookException)exception);
/*  91 */       return;
/*     */     }
/*  93 */     invokeCallbackWithError(callback, "Error preparing share content: " + exception
/*     */     
/*  95 */       .getLocalizedMessage());
/*     */   }
/*     */   
/*     */ 
/*     */   public static void invokeCallbackWithError(FacebookCallback<Sharer.Result> callback, String error)
/*     */   {
/* 101 */     invokeOnErrorCallback(callback, error);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void invokeCallbackWithResults(FacebookCallback<Sharer.Result> callback, String postId, GraphResponse graphResponse)
/*     */   {
/* 108 */     FacebookRequestError requestError = graphResponse.getError();
/* 109 */     if (requestError != null) {
/* 110 */       String errorMessage = requestError.getErrorMessage();
/* 111 */       if (Utility.isNullOrEmpty(errorMessage)) {
/* 112 */         errorMessage = "Unexpected error sharing.";
/*     */       }
/* 114 */       invokeOnErrorCallback(callback, graphResponse, errorMessage);
/*     */     } else {
/* 116 */       invokeOnSuccessCallback(callback, postId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getNativeDialogCompletionGesture(Bundle result)
/*     */   {
/* 128 */     if (result.containsKey("completionGesture")) {
/* 129 */       return result.getString("completionGesture");
/*     */     }
/* 131 */     return result.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getShareDialogPostId(Bundle result)
/*     */   {
/* 142 */     if (result.containsKey("postId")) {
/* 143 */       return result.getString("postId");
/*     */     }
/* 145 */     if (result.containsKey("com.facebook.platform.extra.POST_ID")) {
/* 146 */       return result.getString("com.facebook.platform.extra.POST_ID");
/*     */     }
/* 148 */     return result.getString("post_id");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean handleActivityResult(int requestCode, int resultCode, Intent data, ResultProcessor resultProcessor)
/*     */   {
/* 156 */     AppCall appCall = getAppCallFromActivityResult(requestCode, resultCode, data);
/* 157 */     if (appCall == null) {
/* 158 */       return false;
/*     */     }
/*     */     
/* 161 */     NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCall.getCallId());
/* 162 */     if (resultProcessor == null) {
/* 163 */       return true;
/*     */     }
/*     */     
/* 166 */     FacebookException exception = NativeProtocol.getExceptionFromErrorData(
/* 167 */       NativeProtocol.getErrorDataFromResultIntent(data));
/* 168 */     if (exception != null) {
/* 169 */       if ((exception instanceof FacebookOperationCanceledException)) {
/* 170 */         resultProcessor.onCancel(appCall);
/*     */       } else {
/* 172 */         resultProcessor.onError(appCall, exception);
/*     */       }
/*     */     }
/*     */     else {
/* 176 */       Bundle results = NativeProtocol.getSuccessResultsFromIntent(data);
/* 177 */       resultProcessor.onSuccess(appCall, results);
/*     */     }
/*     */     
/* 180 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public static ResultProcessor getShareResultProcessor(final FacebookCallback<Sharer.Result> callback)
/*     */   {
/* 186 */     new ResultProcessor(callback)
/*     */     {
/*     */       public void onSuccess(AppCall appCall, Bundle results) {
/* 189 */         if (results != null) {
/* 190 */           String gesture = ShareInternalUtility.getNativeDialogCompletionGesture(results);
/* 191 */           if ((gesture == null) || ("post".equalsIgnoreCase(gesture))) {
/* 192 */             String postId = ShareInternalUtility.getShareDialogPostId(results);
/* 193 */             ShareInternalUtility.invokeOnSuccessCallback(callback, postId);
/* 194 */           } else if ("cancel".equalsIgnoreCase(gesture)) {
/* 195 */             ShareInternalUtility.invokeOnCancelCallback(callback);
/*     */           } else {
/* 197 */             ShareInternalUtility.invokeOnErrorCallback(callback, new FacebookException("UnknownError"));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void onCancel(AppCall appCall)
/*     */       {
/* 206 */         ShareInternalUtility.invokeOnCancelCallback(callback);
/*     */       }
/*     */       
/*     */       public void onError(AppCall appCall, FacebookException error)
/*     */       {
/* 211 */         ShareInternalUtility.invokeOnErrorCallback(callback, error);
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */ 
/*     */   private static AppCall getAppCallFromActivityResult(int requestCode, int resultCode, Intent data)
/*     */   {
/* 219 */     UUID callId = NativeProtocol.getCallIdFromIntent(data);
/* 220 */     if (callId == null) {
/* 221 */       return null;
/*     */     }
/*     */     
/* 224 */     return AppCall.finishPendingCall(callId, requestCode);
/*     */   }
/*     */   
/*     */   public static void registerStaticShareCallback(int requestCode)
/*     */   {
/* 229 */     CallbackManagerImpl.registerStaticCallback(requestCode, new CallbackManagerImpl.Callback()
/*     */     {
/*     */ 
/*     */       public boolean onActivityResult(int resultCode, Intent data)
/*     */       {
/* 234 */         return ShareInternalUtility.handleActivityResult(this.val$requestCode, resultCode, data, 
/*     */         
/*     */ 
/*     */ 
/* 238 */           ShareInternalUtility.getShareResultProcessor(null));
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerSharerCallback(int requestCode, CallbackManager callbackManager, final FacebookCallback<Sharer.Result> callback)
/*     */   {
/* 248 */     if (!(callbackManager instanceof CallbackManagerImpl)) {
/* 249 */       throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
/*     */     }
/*     */     
/*     */ 
/* 253 */     ((CallbackManagerImpl)callbackManager).registerCallback(requestCode, new CallbackManagerImpl.Callback()
/*     */     {
/*     */ 
/*     */       public boolean onActivityResult(int resultCode, Intent data)
/*     */       {
/* 258 */         return ShareInternalUtility.handleActivityResult(this.val$requestCode, resultCode, data, 
/*     */         
/*     */ 
/*     */ 
/* 262 */           ShareInternalUtility.getShareResultProcessor(callback));
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   public static List<String> getPhotoUrls(SharePhotoContent photoContent, UUID appCallId)
/*     */   {
/*     */     List<SharePhoto> photos;
/* 271 */     if ((photoContent == null) || ((photos = photoContent.getPhotos()) == null)) {
/* 272 */       return null;
/*     */     }
/*     */     List<SharePhoto> photos;
/* 275 */     List<NativeAppCallAttachmentStore.Attachment> attachments = Utility.map(photos, new Utility.Mapper()
/*     */     {
/*     */ 
/*     */       public NativeAppCallAttachmentStore.Attachment apply(SharePhoto item)
/*     */       {
/* 280 */         return ShareInternalUtility.getAttachment(this.val$appCallId, item);
/*     */       }
/*     */       
/* 283 */     });
/* 284 */     List<String> attachmentUrls = Utility.map(attachments, new Utility.Mapper()
/*     */     {
/*     */ 
/*     */       public String apply(NativeAppCallAttachmentStore.Attachment item)
/*     */       {
/* 289 */         return item.getAttachmentUrl();
/*     */       }
/*     */       
/* 292 */     });
/* 293 */     NativeAppCallAttachmentStore.addAttachments(attachments);
/*     */     
/* 295 */     return attachmentUrls;
/*     */   }
/*     */   
/*     */   public static String getVideoUrl(ShareVideoContent videoContent, UUID appCallId) {
/* 299 */     if ((videoContent == null) || (videoContent.getVideo() == null)) {
/* 300 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 304 */     NativeAppCallAttachmentStore.Attachment attachment = NativeAppCallAttachmentStore.createAttachment(appCallId, videoContent
/*     */     
/* 306 */       .getVideo().getLocalUrl());
/*     */     
/* 308 */     ArrayList<NativeAppCallAttachmentStore.Attachment> attachments = new ArrayList(1);
/* 309 */     attachments.add(attachment);
/* 310 */     NativeAppCallAttachmentStore.addAttachments(attachments);
/*     */     
/* 312 */     return attachment.getAttachmentUrl();
/*     */   }
/*     */   
/*     */ 
/*     */   public static List<Bundle> getMediaInfos(ShareMediaContent mediaContent, UUID appCallId)
/*     */   {
/*     */     List<ShareMedia> media;
/* 319 */     if ((mediaContent == null) || ((media = mediaContent.getMedia()) == null)) {
/* 320 */       return null;
/*     */     }
/*     */     List<ShareMedia> media;
/* 323 */     final List<NativeAppCallAttachmentStore.Attachment> attachments = new ArrayList();
/* 324 */     List<Bundle> mediaInfos = Utility.map(media, new Utility.Mapper()
/*     */     {
/*     */ 
/*     */       public Bundle apply(ShareMedia item)
/*     */       {
/*     */ 
/* 330 */         NativeAppCallAttachmentStore.Attachment attachment = ShareInternalUtility.getAttachment(this.val$appCallId, item);
/* 331 */         attachments.add(attachment);
/* 332 */         Bundle mediaInfo = new Bundle();
/* 333 */         mediaInfo.putString("type", item
/*     */         
/* 335 */           .getMediaType().name());
/* 336 */         mediaInfo.putString("uri", attachment
/*     */         
/* 338 */           .getAttachmentUrl());
/* 339 */         return mediaInfo;
/*     */       }
/*     */       
/* 342 */     });
/* 343 */     NativeAppCallAttachmentStore.addAttachments(attachments);
/*     */     
/* 345 */     return mediaInfos;
/*     */   }
/*     */   
/*     */ 
/*     */   public static JSONObject toJSONObjectForCall(UUID callId, ShareOpenGraphContent content)
/*     */     throws JSONException
/*     */   {
/* 352 */     ShareOpenGraphAction action = content.getAction();
/* 353 */     final ArrayList<NativeAppCallAttachmentStore.Attachment> attachments = new ArrayList();
/* 354 */     JSONObject actionJSON = OpenGraphJSONUtility.toJSONObject(action, new OpenGraphJSONUtility.PhotoJSONProcessor()
/*     */     {
/*     */ 
/*     */       public JSONObject toJSONObject(SharePhoto photo)
/*     */       {
/* 359 */         NativeAppCallAttachmentStore.Attachment attachment = ShareInternalUtility.getAttachment(this.val$callId, photo);
/*     */         
/*     */ 
/*     */ 
/* 363 */         if (attachment == null) {
/* 364 */           return null;
/*     */         }
/*     */         
/* 367 */         attachments.add(attachment);
/*     */         
/* 369 */         JSONObject photoJSONObject = new JSONObject();
/*     */         try {
/* 371 */           photoJSONObject.put("url", attachment
/* 372 */             .getAttachmentUrl());
/* 373 */           if (photo.getUserGenerated()) {
/* 374 */             photoJSONObject.put("user_generated", true);
/*     */           }
/*     */         } catch (JSONException e) {
/* 377 */           throw new FacebookException("Unable to attach images", e);
/*     */         }
/* 379 */         return photoJSONObject;
/*     */       }
/*     */       
/* 382 */     });
/* 383 */     NativeAppCallAttachmentStore.addAttachments(attachments);
/*     */     
/* 385 */     if (content.getPlaceId() != null) {
/* 386 */       String placeTag = actionJSON.optString("place");
/*     */       
/*     */ 
/*     */ 
/* 390 */       if (Utility.isNullOrEmpty(placeTag)) {
/* 391 */         actionJSON.put("place", content.getPlaceId());
/*     */       }
/*     */     }
/*     */     
/* 395 */     if (content.getPeopleIds() != null) {
/* 396 */       JSONArray peopleTags = actionJSON.optJSONArray("tags");
/*     */       
/*     */ 
/* 399 */       Set<String> peopleIdSet = peopleTags == null ? new HashSet() : Utility.jsonArrayToSet(peopleTags);
/*     */       
/* 401 */       for (String peopleId : content.getPeopleIds()) {
/* 402 */         peopleIdSet.add(peopleId);
/*     */       }
/* 404 */       actionJSON.put("tags", new JSONArray(peopleIdSet));
/*     */     }
/*     */     
/* 407 */     return actionJSON;
/*     */   }
/*     */   
/*     */   public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent shareOpenGraphContent)
/*     */     throws JSONException
/*     */   {
/* 413 */     ShareOpenGraphAction action = shareOpenGraphContent.getAction();
/*     */     
/* 415 */     OpenGraphJSONUtility.toJSONObject(action, new OpenGraphJSONUtility.PhotoJSONProcessor()
/*     */     {
/*     */ 
/*     */       public JSONObject toJSONObject(SharePhoto photo)
/*     */       {
/* 420 */         Uri photoUri = photo.getImageUrl();
/* 421 */         JSONObject photoJSONObject = new JSONObject();
/*     */         try {
/* 423 */           photoJSONObject.put("url", photoUri
/* 424 */             .toString());
/*     */         } catch (JSONException e) {
/* 426 */           throw new FacebookException("Unable to attach images", e);
/*     */         }
/* 428 */         return photoJSONObject;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static JSONArray removeNamespacesFromOGJsonArray(JSONArray jsonArray, boolean requireNamespace)
/*     */     throws JSONException
/*     */   {
/* 436 */     JSONArray newArray = new JSONArray();
/* 437 */     for (int i = 0; i < jsonArray.length(); i++) {
/* 438 */       Object value = jsonArray.get(i);
/* 439 */       if ((value instanceof JSONArray)) {
/* 440 */         value = removeNamespacesFromOGJsonArray((JSONArray)value, requireNamespace);
/* 441 */       } else if ((value instanceof JSONObject)) {
/* 442 */         value = removeNamespacesFromOGJsonObject((JSONObject)value, requireNamespace);
/*     */       }
/* 444 */       newArray.put(value);
/*     */     }
/*     */     
/* 447 */     return newArray;
/*     */   }
/*     */   
/*     */ 
/*     */   public static JSONObject removeNamespacesFromOGJsonObject(JSONObject jsonObject, boolean requireNamespace)
/*     */   {
/* 453 */     if (jsonObject == null) {
/* 454 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 458 */       JSONObject newJsonObject = new JSONObject();
/* 459 */       JSONObject data = new JSONObject();
/* 460 */       JSONArray names = jsonObject.names();
/* 461 */       for (int i = 0; i < names.length(); i++) {
/* 462 */         String key = names.getString(i);
/*     */         
/* 464 */         Object value = jsonObject.get(key);
/* 465 */         if ((value instanceof JSONObject)) {
/* 466 */           value = removeNamespacesFromOGJsonObject((JSONObject)value, true);
/* 467 */         } else if ((value instanceof JSONArray)) {
/* 468 */           value = removeNamespacesFromOGJsonArray((JSONArray)value, true);
/*     */         }
/*     */         
/* 471 */         Pair<String, String> fieldNameAndNamespace = getFieldNameAndNamespaceFromFullName(key);
/*     */         
/* 473 */         String namespace = (String)fieldNameAndNamespace.first;
/* 474 */         String fieldName = (String)fieldNameAndNamespace.second;
/*     */         
/* 476 */         if (requireNamespace) {
/* 477 */           if ((namespace != null) && (namespace.equals("fbsdk"))) {
/* 478 */             newJsonObject.put(key, value);
/* 479 */           } else if ((namespace == null) || (namespace.equals("og"))) {
/* 480 */             newJsonObject.put(fieldName, value);
/*     */           } else {
/* 482 */             data.put(fieldName, value);
/*     */           }
/* 484 */         } else if ((namespace != null) && (namespace.equals("fb"))) {
/* 485 */           newJsonObject.put(key, value);
/*     */         } else {
/* 487 */           newJsonObject.put(fieldName, value);
/*     */         }
/*     */       }
/*     */       
/* 491 */       if (data.length() > 0) {
/* 492 */         newJsonObject.put("data", data);
/*     */       }
/*     */       
/* 495 */       return newJsonObject;
/*     */     } catch (JSONException e) {
/* 497 */       throw new FacebookException("Failed to create json object from share content");
/*     */     }
/*     */   }
/*     */   
/*     */   public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String fullName) {
/* 502 */     String namespace = null;
/*     */     
/* 504 */     int index = fullName.indexOf(':');
/* 505 */     String fieldName; String fieldName; if ((index != -1) && (fullName.length() > index + 1)) {
/* 506 */       namespace = fullName.substring(0, index);
/* 507 */       fieldName = fullName.substring(index + 1);
/*     */     } else {
/* 509 */       fieldName = fullName;
/*     */     }
/* 511 */     return new Pair(namespace, fieldName);
/*     */   }
/*     */   
/*     */ 
/*     */   private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID callId, ShareMedia medium)
/*     */   {
/* 517 */     Bitmap bitmap = null;
/* 518 */     Uri uri = null;
/*     */     
/* 520 */     if ((medium instanceof SharePhoto)) {
/* 521 */       SharePhoto photo = (SharePhoto)medium;
/* 522 */       bitmap = photo.getBitmap();
/* 523 */       uri = photo.getImageUrl();
/* 524 */     } else if ((medium instanceof ShareVideo)) {
/* 525 */       ShareVideo video = (ShareVideo)medium;
/* 526 */       uri = video.getLocalUrl();
/*     */     }
/*     */     
/* 529 */     NativeAppCallAttachmentStore.Attachment attachment = null;
/* 530 */     if (bitmap != null) {
/* 531 */       attachment = NativeAppCallAttachmentStore.createAttachment(callId, bitmap);
/*     */ 
/*     */     }
/* 534 */     else if (uri != null) {
/* 535 */       attachment = NativeAppCallAttachmentStore.createAttachment(callId, uri);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 540 */     return attachment;
/*     */   }
/*     */   
/*     */   static void invokeOnCancelCallback(FacebookCallback<Sharer.Result> callback) {
/* 544 */     logShareResult("cancelled", null);
/* 545 */     if (callback != null) {
/* 546 */       callback.onCancel();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> callback, String postId)
/*     */   {
/* 553 */     logShareResult("succeeded", null);
/* 554 */     if (callback != null) {
/* 555 */       callback.onSuccess(new Sharer.Result(postId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> callback, GraphResponse response, String message)
/*     */   {
/* 563 */     logShareResult("error", message);
/* 564 */     if (callback != null) {
/* 565 */       callback.onError(new FacebookGraphResponseException(response, message));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> callback, String message)
/*     */   {
/* 573 */     logShareResult("error", message);
/* 574 */     if (callback != null) {
/* 575 */       callback.onError(new FacebookException(message));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> callback, FacebookException ex)
/*     */   {
/* 582 */     logShareResult("error", ex.getMessage());
/* 583 */     if (callback != null) {
/* 584 */       callback.onError(ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void logShareResult(String shareOutcome, String errorMessage) {
/* 589 */     Context context = FacebookSdk.getApplicationContext();
/* 590 */     AppEventsLogger logger = AppEventsLogger.newLogger(context);
/* 591 */     Bundle parameters = new Bundle();
/* 592 */     parameters.putString("fb_share_dialog_outcome", shareOutcome);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 597 */     if (errorMessage != null) {
/* 598 */       parameters.putString("error_message", errorMessage);
/*     */     }
/* 600 */     logger.logSdkEvent("fb_share_dialog_result", null, parameters);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Bitmap image, GraphRequest.Callback callback)
/*     */   {
/* 619 */     Bundle parameters = new Bundle(1);
/* 620 */     parameters.putParcelable("file", image);
/*     */     
/* 622 */     return new GraphRequest(accessToken, "me/staging_resources", parameters, HttpMethod.POST, callback);
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
/*     */   public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, File file, GraphRequest.Callback callback)
/*     */     throws FileNotFoundException
/*     */   {
/* 649 */     ParcelFileDescriptor descriptor = ParcelFileDescriptor.open(file, 268435456);
/* 650 */     GraphRequest.ParcelableResourceWithMimeType<ParcelFileDescriptor> resourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(descriptor, "image/png");
/*     */     
/* 652 */     Bundle parameters = new Bundle(1);
/* 653 */     parameters.putParcelable("file", resourceWithMimeType);
/*     */     
/* 655 */     return new GraphRequest(accessToken, "me/staging_resources", parameters, HttpMethod.POST, callback);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri imageUri, GraphRequest.Callback callback)
/*     */     throws FileNotFoundException
/*     */   {
/* 681 */     if (Utility.isFileUri(imageUri)) {
/* 682 */       return newUploadStagingResourceWithImageRequest(accessToken, new File(imageUri
/*     */       
/* 684 */         .getPath()), callback);
/*     */     }
/* 686 */     if (!Utility.isContentUri(imageUri)) {
/* 687 */       throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
/*     */     }
/*     */     
/* 690 */     GraphRequest.ParcelableResourceWithMimeType<Uri> resourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(imageUri, "image/png");
/*     */     
/* 692 */     Bundle parameters = new Bundle(1);
/* 693 */     parameters.putParcelable("file", resourceWithMimeType);
/*     */     
/* 695 */     return new GraphRequest(accessToken, "me/staging_resources", parameters, HttpMethod.POST, callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public static LikeView.ObjectType getMostSpecificObjectType(LikeView.ObjectType objectType1, LikeView.ObjectType objectType2)
/*     */   {
/* 707 */     if (objectType1 == objectType2) {
/* 708 */       return objectType1;
/*     */     }
/*     */     
/* 711 */     if (objectType1 == LikeView.ObjectType.UNKNOWN)
/* 712 */       return objectType2;
/* 713 */     if (objectType2 == LikeView.ObjectType.UNKNOWN) {
/* 714 */       return objectType1;
/*     */     }
/*     */     
/* 717 */     return null;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/ShareInternalUtility.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */