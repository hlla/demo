/*     */ package com.facebook.share;
/*     */ 
/*     */ import android.graphics.Bitmap;
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookGraphResponseException;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.GraphRequest;
/*     */ import com.facebook.GraphRequest.Callback;
/*     */ import com.facebook.GraphResponse;
/*     */ import com.facebook.HttpMethod;
/*     */ import com.facebook.internal.CollectionMapper;
/*     */ import com.facebook.internal.CollectionMapper.Collection;
/*     */ import com.facebook.internal.CollectionMapper.OnErrorListener;
/*     */ import com.facebook.internal.CollectionMapper.OnMapValueCompleteListener;
/*     */ import com.facebook.internal.CollectionMapper.OnMapperCompleteListener;
/*     */ import com.facebook.internal.CollectionMapper.ValueMapper;
/*     */ import com.facebook.internal.Mutable;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.share.internal.ShareContentValidation;
/*     */ import com.facebook.share.internal.ShareInternalUtility;
/*     */ import com.facebook.share.internal.VideoUploader;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ import com.facebook.share.model.ShareLinkContent;
/*     */ import com.facebook.share.model.ShareOpenGraphAction;
/*     */ import com.facebook.share.model.ShareOpenGraphContent;
/*     */ import com.facebook.share.model.ShareOpenGraphObject;
/*     */ import com.facebook.share.model.SharePhoto;
/*     */ import com.facebook.share.model.SharePhotoContent;
/*     */ import com.facebook.share.model.ShareVideoContent;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
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
/*     */ public final class ShareApi
/*     */ {
/*     */   private static final String TAG = "ShareApi";
/*     */   private static final String DEFAULT_GRAPH_NODE = "me";
/*     */   private static final String PHOTOS_EDGE = "photos";
/*     */   private static final String GRAPH_PATH_FORMAT = "%s/%s";
/*     */   private static final String DEFAULT_CHARSET = "UTF-8";
/*     */   private String message;
/*     */   private String graphNode;
/*     */   private final ShareContent shareContent;
/*     */   
/*     */   public static void share(ShareContent shareContent, FacebookCallback<Sharer.Result> callback)
/*     */   {
/*  79 */     new ShareApi(shareContent).share(callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ShareApi(ShareContent shareContent)
/*     */   {
/*  88 */     this.shareContent = shareContent;
/*  89 */     this.graphNode = "me";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMessage()
/*     */   {
/*  98 */     return this.message;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMessage(String message)
/*     */   {
/* 107 */     this.message = message;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getGraphNode()
/*     */   {
/* 115 */     return this.graphNode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGraphNode(String graphNode)
/*     */   {
/* 124 */     this.graphNode = graphNode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ShareContent getShareContent()
/*     */   {
/* 133 */     return this.shareContent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canShare()
/*     */   {
/* 144 */     if (getShareContent() == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     AccessToken accessToken = AccessToken.getCurrentAccessToken();
/* 148 */     if (accessToken == null) {
/* 149 */       return false;
/*     */     }
/* 151 */     Set<String> permissions = accessToken.getPermissions();
/* 152 */     if ((permissions == null) || (!permissions.contains("publish_actions"))) {
/* 153 */       Log.w("ShareApi", "The publish_actions permissions are missing, the share will fail unless this app was authorized to publish in another installation.");
/*     */     }
/*     */     
/*     */ 
/* 157 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void share(FacebookCallback<Sharer.Result> callback)
/*     */   {
/* 166 */     if (!canShare()) {
/* 167 */       ShareInternalUtility.invokeCallbackWithError(callback, "Insufficient permissions for sharing content via Api.");
/*     */       
/* 169 */       return;
/*     */     }
/* 171 */     ShareContent shareContent = getShareContent();
/*     */     
/*     */     try
/*     */     {
/* 175 */       ShareContentValidation.validateForApiShare(shareContent);
/*     */     } catch (FacebookException ex) {
/* 177 */       ShareInternalUtility.invokeCallbackWithException(callback, ex);
/* 178 */       return;
/*     */     }
/*     */     
/* 181 */     if ((shareContent instanceof ShareLinkContent)) {
/* 182 */       shareLinkContent((ShareLinkContent)shareContent, callback);
/* 183 */     } else if ((shareContent instanceof SharePhotoContent)) {
/* 184 */       sharePhotoContent((SharePhotoContent)shareContent, callback);
/* 185 */     } else if ((shareContent instanceof ShareVideoContent)) {
/* 186 */       shareVideoContent((ShareVideoContent)shareContent, callback);
/* 187 */     } else if ((shareContent instanceof ShareOpenGraphContent)) {
/* 188 */       shareOpenGraphContent((ShareOpenGraphContent)shareContent, callback);
/*     */     }
/*     */   }
/*     */   
/*     */   private String getGraphPath(String pathAfterGraphNode)
/*     */   {
/*     */     try {
/* 195 */       return String.format(Locale.ROOT, "%s/%s", new Object[] {
/*     */       
/* 197 */         URLEncoder.encode(getGraphNode(), "UTF-8"), pathAfterGraphNode });
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/* 200 */     return null;
/*     */   }
/*     */   
/*     */   private void addCommonParameters(Bundle bundle, ShareContent shareContent)
/*     */   {
/* 205 */     List<String> peopleIds = shareContent.getPeopleIds();
/* 206 */     if (!Utility.isNullOrEmpty(peopleIds)) {
/* 207 */       bundle.putString("tags", TextUtils.join(", ", peopleIds));
/*     */     }
/*     */     
/* 210 */     if (!Utility.isNullOrEmpty(shareContent.getPlaceId())) {
/* 211 */       bundle.putString("place", shareContent.getPlaceId());
/*     */     }
/*     */     
/* 214 */     if (!Utility.isNullOrEmpty(shareContent.getRef())) {
/* 215 */       bundle.putString("ref", shareContent.getRef());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void shareOpenGraphContent(ShareOpenGraphContent openGraphContent, final FacebookCallback<Sharer.Result> callback)
/*     */   {
/* 226 */     final GraphRequest.Callback requestCallback = new GraphRequest.Callback()
/*     */     {
/*     */       public void onCompleted(GraphResponse response) {
/* 229 */         JSONObject data = response.getJSONObject();
/* 230 */         String postId = data == null ? null : data.optString("id");
/* 231 */         ShareInternalUtility.invokeCallbackWithResults(callback, postId, response);
/*     */       }
/* 233 */     };
/* 234 */     final ShareOpenGraphAction action = openGraphContent.getAction();
/* 235 */     final Bundle parameters = action.getBundle();
/* 236 */     addCommonParameters(parameters, openGraphContent);
/* 237 */     if (!Utility.isNullOrEmpty(getMessage())) {
/* 238 */       parameters.putString("message", getMessage());
/*     */     }
/*     */     
/* 241 */     CollectionMapper.OnMapperCompleteListener stageCallback = new CollectionMapper.OnMapperCompleteListener()
/*     */     {
/*     */       public void onComplete()
/*     */       {
/*     */         try {
/* 246 */           ShareApi.handleImagesOnAction(parameters);
/*     */           
/* 248 */           new GraphRequest(
/* 249 */             AccessToken.getCurrentAccessToken(), ShareApi.this
/* 250 */             .getGraphPath(
/* 251 */             URLEncoder.encode(action.getActionType(), "UTF-8")), parameters, HttpMethod.POST, requestCallback)
/*     */             
/*     */ 
/* 254 */             .executeAsync();
/*     */         } catch (UnsupportedEncodingException ex) {
/* 256 */           ShareInternalUtility.invokeCallbackWithException(callback, ex);
/*     */         }
/*     */       }
/*     */       
/*     */       public void onError(FacebookException exception)
/*     */       {
/* 262 */         ShareInternalUtility.invokeCallbackWithException(callback, exception);
/*     */       }
/* 264 */     };
/* 265 */     stageOpenGraphAction(parameters, stageCallback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void handleImagesOnAction(Bundle parameters)
/*     */   {
/* 272 */     String imageStr = parameters.getString("image");
/* 273 */     if (imageStr != null) {
/*     */       try
/*     */       {
/* 276 */         JSONArray images = new JSONArray(imageStr);
/* 277 */         for (int i = 0; i < images.length(); i++) {
/* 278 */           JSONObject jsonImage = images.optJSONObject(i);
/* 279 */           if (jsonImage != null) {
/* 280 */             putImageInBundleWithArrayFormat(parameters, i, jsonImage);
/*     */           }
/*     */           else {
/* 283 */             String url = images.getString(i);
/* 284 */             parameters.putString(String.format(Locale.ROOT, "image[%d][url]", new Object[] { Integer.valueOf(i) }), url);
/*     */           }
/*     */         }
/* 287 */         parameters.remove("image");
/* 288 */         return;
/*     */ 
/*     */       }
/*     */       catch (JSONException localJSONException)
/*     */       {
/*     */         try
/*     */         {
/* 295 */           JSONObject image = new JSONObject(imageStr);
/* 296 */           putImageInBundleWithArrayFormat(parameters, 0, image);
/* 297 */           parameters.remove("image");
/*     */         }
/*     */         catch (JSONException localJSONException1) {}
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void putImageInBundleWithArrayFormat(Bundle parameters, int index, JSONObject image)
/*     */     throws JSONException
/*     */   {
/* 309 */     Iterator<String> keys = image.keys();
/* 310 */     while (keys.hasNext()) {
/* 311 */       String property = (String)keys.next();
/* 312 */       String key = String.format(Locale.ROOT, "image[%d][%s]", new Object[] { Integer.valueOf(index), property });
/* 313 */       parameters.putString(key, image.get(property).toString());
/*     */     }
/*     */   }
/*     */   
/*     */   private void sharePhotoContent(SharePhotoContent photoContent, final FacebookCallback<Sharer.Result> callback)
/*     */   {
/* 319 */     final Mutable<Integer> requestCount = new Mutable(Integer.valueOf(0));
/* 320 */     AccessToken accessToken = AccessToken.getCurrentAccessToken();
/* 321 */     ArrayList<GraphRequest> requests = new ArrayList();
/* 322 */     final ArrayList<JSONObject> results = new ArrayList();
/* 323 */     final ArrayList<GraphResponse> errorResponses = new ArrayList();
/* 324 */     GraphRequest.Callback requestCallback = new GraphRequest.Callback()
/*     */     {
/*     */       public void onCompleted(GraphResponse response) {
/* 327 */         JSONObject result = response.getJSONObject();
/* 328 */         if (result != null) {
/* 329 */           results.add(result);
/*     */         }
/* 331 */         if (response.getError() != null) {
/* 332 */           errorResponses.add(response);
/*     */         }
/* 334 */         requestCount.value = Integer.valueOf(((Integer)requestCount.value).intValue() - 1);
/* 335 */         if (((Integer)requestCount.value).intValue() == 0) {
/* 336 */           if (!errorResponses.isEmpty()) {
/* 337 */             ShareInternalUtility.invokeCallbackWithResults(callback, null, 
/*     */             
/*     */ 
/* 340 */               (GraphResponse)errorResponses.get(0));
/* 341 */           } else if (!results.isEmpty()) {
/* 342 */             String postId = ((JSONObject)results.get(0)).optString("id");
/* 343 */             ShareInternalUtility.invokeCallbackWithResults(callback, postId, response);
/*     */           }
/*     */         }
/*     */       }
/*     */     };
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 352 */       for (SharePhoto photo : photoContent.getPhotos())
/*     */       {
/*     */         try {
/* 355 */           params = getSharePhotoCommonParameters(photo, photoContent);
/*     */         } catch (JSONException e) { Bundle params;
/* 357 */           ShareInternalUtility.invokeCallbackWithException(callback, e); return;
/*     */         }
/*     */         Bundle params;
/* 360 */         Bitmap bitmap = photo.getBitmap();
/* 361 */         Uri photoUri = photo.getImageUrl();
/* 362 */         String caption = photo.getCaption();
/* 363 */         if (caption == null) {
/* 364 */           caption = getMessage();
/*     */         }
/* 366 */         if (bitmap != null) {
/* 367 */           requests.add(GraphRequest.newUploadPhotoRequest(accessToken, 
/*     */           
/* 369 */             getGraphPath("photos"), bitmap, caption, params, requestCallback));
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 374 */         else if (photoUri != null) {
/* 375 */           requests.add(GraphRequest.newUploadPhotoRequest(accessToken, 
/*     */           
/* 377 */             getGraphPath("photos"), photoUri, caption, params, requestCallback));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 384 */       requestCount.value = Integer.valueOf(((Integer)requestCount.value).intValue() + requests.size());
/* 385 */       for (GraphRequest request : requests) {
/* 386 */         request.executeAsync();
/*     */       }
/*     */     } catch (FileNotFoundException ex) {
/* 389 */       ShareInternalUtility.invokeCallbackWithException(callback, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private void shareLinkContent(ShareLinkContent linkContent, final FacebookCallback<Sharer.Result> callback)
/*     */   {
/* 395 */     GraphRequest.Callback requestCallback = new GraphRequest.Callback()
/*     */     {
/*     */       public void onCompleted(GraphResponse response) {
/* 398 */         JSONObject data = response.getJSONObject();
/* 399 */         String postId = data == null ? null : data.optString("id");
/* 400 */         ShareInternalUtility.invokeCallbackWithResults(callback, postId, response);
/*     */       }
/* 402 */     };
/* 403 */     Bundle parameters = new Bundle();
/* 404 */     addCommonParameters(parameters, linkContent);
/* 405 */     parameters.putString("message", getMessage());
/* 406 */     parameters.putString("link", Utility.getUriString(linkContent.getContentUrl()));
/* 407 */     parameters.putString("picture", Utility.getUriString(linkContent.getImageUrl()));
/* 408 */     parameters.putString("name", linkContent.getContentTitle());
/* 409 */     parameters.putString("description", linkContent.getContentDescription());
/* 410 */     parameters.putString("ref", linkContent.getRef());
/* 411 */     new GraphRequest(
/* 412 */       AccessToken.getCurrentAccessToken(), 
/* 413 */       getGraphPath("feed"), parameters, HttpMethod.POST, requestCallback)
/*     */       
/*     */ 
/* 416 */       .executeAsync();
/*     */   }
/*     */   
/*     */   private void shareVideoContent(ShareVideoContent videoContent, FacebookCallback<Sharer.Result> callback)
/*     */   {
/*     */     try {
/* 422 */       VideoUploader.uploadAsync(videoContent, getGraphNode(), callback);
/*     */     } catch (FileNotFoundException ex) {
/* 424 */       ShareInternalUtility.invokeCallbackWithException(callback, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private Bundle getSharePhotoCommonParameters(SharePhoto photo, SharePhotoContent photoContent) throws JSONException
/*     */   {
/* 430 */     Bundle params = photo.getParameters();
/* 431 */     if ((!params.containsKey("place")) && 
/* 432 */       (!Utility.isNullOrEmpty(photoContent.getPlaceId()))) {
/* 433 */       params.putString("place", photoContent.getPlaceId());
/*     */     }
/* 435 */     if ((!params.containsKey("tags")) && 
/* 436 */       (!Utility.isNullOrEmpty(photoContent.getPeopleIds()))) {
/* 437 */       List<String> peopleIds = photoContent.getPeopleIds();
/* 438 */       if (!Utility.isNullOrEmpty(peopleIds)) {
/* 439 */         JSONArray tags = new JSONArray();
/* 440 */         for (String id : peopleIds) {
/* 441 */           JSONObject tag = new JSONObject();
/* 442 */           tag.put("tag_uid", id);
/* 443 */           tags.put(tag);
/*     */         }
/* 445 */         params.putString("tags", tags.toString());
/*     */       }
/*     */     }
/* 448 */     if ((!params.containsKey("ref")) && 
/* 449 */       (!Utility.isNullOrEmpty(photoContent.getRef()))) {
/* 450 */       params.putString("ref", photoContent.getRef());
/*     */     }
/* 452 */     return params;
/*     */   }
/*     */   
/*     */ 
/*     */   private void stageArrayList(final ArrayList arrayList, final CollectionMapper.OnMapValueCompleteListener onArrayListStagedListener)
/*     */   {
/* 458 */     final JSONArray stagedObject = new JSONArray();
/* 459 */     CollectionMapper.Collection<Integer> collection = new CollectionMapper.Collection()
/*     */     {
/*     */       public Iterator<Integer> keyIterator()
/*     */       {
/* 463 */         final int size = arrayList.size();
/* 464 */         final Mutable<Integer> current = new Mutable(Integer.valueOf(0));
/* 465 */         new Iterator()
/*     */         {
/*     */           public boolean hasNext() {
/* 468 */             return ((Integer)current.value).intValue() < size;
/*     */           }
/*     */           
/*     */           public Integer next()
/*     */           {
/* 473 */             Integer localInteger1 = (Integer)current.value;Mutable localMutable = current;Integer localInteger2 = localMutable.value = Integer.valueOf(((Integer)localMutable.value).intValue() + 1);return localInteger1;
/*     */           }
/*     */           
/*     */ 
/*     */           public void remove() {}
/*     */         };
/*     */       }
/*     */       
/*     */ 
/*     */       public Object get(Integer key)
/*     */       {
/* 484 */         return arrayList.get(key.intValue());
/*     */       }
/*     */       
/*     */ 
/*     */       public void set(Integer key, Object value, CollectionMapper.OnErrorListener onErrorListener)
/*     */       {
/*     */         try
/*     */         {
/* 492 */           stagedObject.put(key.intValue(), value);
/*     */         } catch (JSONException ex) {
/* 494 */           String message = ex.getLocalizedMessage();
/* 495 */           if (message == null) {
/* 496 */             message = "Error staging object.";
/*     */           }
/* 498 */           onErrorListener.onError(new FacebookException(message));
/*     */         }
/*     */       }
/* 501 */     };
/* 502 */     CollectionMapper.OnMapperCompleteListener onStagedArrayMapperCompleteListener = new CollectionMapper.OnMapperCompleteListener()
/*     */     {
/*     */       public void onComplete()
/*     */       {
/* 506 */         onArrayListStagedListener.onComplete(stagedObject);
/*     */       }
/*     */       
/*     */       public void onError(FacebookException exception)
/*     */       {
/* 511 */         onArrayListStagedListener.onError(exception);
/*     */       }
/* 513 */     };
/* 514 */     stageCollectionValues(collection, onStagedArrayMapperCompleteListener);
/*     */   }
/*     */   
/*     */ 
/*     */   private <T> void stageCollectionValues(CollectionMapper.Collection<T> collection, CollectionMapper.OnMapperCompleteListener onCollectionValuesStagedListener)
/*     */   {
/* 520 */     CollectionMapper.ValueMapper valueMapper = new CollectionMapper.ValueMapper()
/*     */     {
/*     */ 
/*     */       public void mapValue(Object value, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener)
/*     */       {
/* 525 */         if ((value instanceof ArrayList)) {
/* 526 */           ShareApi.this.stageArrayList((ArrayList)value, onMapValueCompleteListener);
/* 527 */         } else if ((value instanceof ShareOpenGraphObject)) {
/* 528 */           ShareApi.this.stageOpenGraphObject((ShareOpenGraphObject)value, onMapValueCompleteListener);
/*     */ 
/*     */         }
/* 531 */         else if ((value instanceof SharePhoto)) {
/* 532 */           ShareApi.this.stagePhoto((SharePhoto)value, onMapValueCompleteListener);
/*     */         } else {
/* 534 */           onMapValueCompleteListener.onComplete(value);
/*     */         }
/*     */       }
/* 537 */     };
/* 538 */     CollectionMapper.iterate(collection, valueMapper, onCollectionValuesStagedListener);
/*     */   }
/*     */   
/*     */ 
/*     */   private void stageOpenGraphAction(final Bundle parameters, CollectionMapper.OnMapperCompleteListener onOpenGraphActionStagedListener)
/*     */   {
/* 544 */     CollectionMapper.Collection<String> collection = new CollectionMapper.Collection()
/*     */     {
/*     */       public Iterator<String> keyIterator()
/*     */       {
/* 548 */         return parameters.keySet().iterator();
/*     */       }
/*     */       
/*     */       public Object get(String key)
/*     */       {
/* 553 */         return parameters.get(key);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void set(String key, Object value, CollectionMapper.OnErrorListener onErrorListener)
/*     */       {
/* 560 */         if (!Utility.putJSONValueInBundle(parameters, key, value)) {
/* 561 */           onErrorListener.onError(new FacebookException("Unexpected value: " + value
/* 562 */             .toString()));
/*     */         }
/*     */       }
/* 565 */     };
/* 566 */     stageCollectionValues(collection, onOpenGraphActionStagedListener);
/*     */   }
/*     */   
/*     */ 
/*     */   private void stageOpenGraphObject(final ShareOpenGraphObject object, final CollectionMapper.OnMapValueCompleteListener onOpenGraphObjectStagedListener)
/*     */   {
/* 572 */     String type = object.getString("type");
/* 573 */     if (type == null) {
/* 574 */       type = object.getString("og:type");
/*     */     }
/*     */     
/* 577 */     if (type == null) {
/* 578 */       onOpenGraphObjectStagedListener.onError(new FacebookException("Open Graph objects must contain a type value."));
/*     */       
/* 580 */       return;
/*     */     }
/* 582 */     final JSONObject stagedObject = new JSONObject();
/* 583 */     CollectionMapper.Collection<String> collection = new CollectionMapper.Collection()
/*     */     {
/*     */       public Iterator<String> keyIterator()
/*     */       {
/* 587 */         return object.keySet().iterator();
/*     */       }
/*     */       
/*     */       public Object get(String key)
/*     */       {
/* 592 */         return object.get(key);
/*     */       }
/*     */       
/*     */ 
/*     */       public void set(String key, Object value, CollectionMapper.OnErrorListener onErrorListener)
/*     */       {
/*     */         try
/*     */         {
/* 600 */           stagedObject.put(key, value);
/*     */         } catch (JSONException ex) {
/* 602 */           String message = ex.getLocalizedMessage();
/* 603 */           if (message == null) {
/* 604 */             message = "Error staging object.";
/*     */           }
/* 606 */           onErrorListener.onError(new FacebookException(message));
/*     */         }
/*     */       }
/* 609 */     };
/* 610 */     final GraphRequest.Callback requestCallback = new GraphRequest.Callback()
/*     */     {
/*     */       public void onCompleted(GraphResponse response) {
/* 613 */         FacebookRequestError error = response.getError();
/* 614 */         if (error != null) {
/* 615 */           String message = error.getErrorMessage();
/* 616 */           if (message == null) {
/* 617 */             message = "Error staging Open Graph object.";
/*     */           }
/* 619 */           onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(response, message));
/*     */           
/* 621 */           return;
/*     */         }
/* 623 */         JSONObject data = response.getJSONObject();
/* 624 */         if (data == null) {
/* 625 */           onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(response, "Error staging Open Graph object."));
/*     */           
/*     */ 
/* 628 */           return;
/*     */         }
/* 630 */         String stagedObjectId = data.optString("id");
/* 631 */         if (stagedObjectId == null) {
/* 632 */           onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(response, "Error staging Open Graph object."));
/*     */           
/*     */ 
/* 635 */           return;
/*     */         }
/* 637 */         onOpenGraphObjectStagedListener.onComplete(stagedObjectId);
/*     */       }
/* 639 */     };
/* 640 */     final String ogType = type;
/* 641 */     CollectionMapper.OnMapperCompleteListener onMapperCompleteListener = new CollectionMapper.OnMapperCompleteListener()
/*     */     {
/*     */       public void onComplete()
/*     */       {
/* 645 */         String objectString = stagedObject.toString();
/* 646 */         Bundle parameters = new Bundle();
/* 647 */         parameters.putString("object", objectString);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         try
/*     */         {
/* 656 */           new GraphRequest(AccessToken.getCurrentAccessToken(), ShareApi.this.getGraphPath("objects/" + URLEncoder.encode(ogType, "UTF-8")), parameters, HttpMethod.POST, requestCallback).executeAsync();
/*     */         } catch (UnsupportedEncodingException ex) {
/* 658 */           String message = ex.getLocalizedMessage();
/* 659 */           if (message == null) {
/* 660 */             message = "Error staging Open Graph object.";
/*     */           }
/* 662 */           onOpenGraphObjectStagedListener.onError(new FacebookException(message));
/*     */         }
/*     */       }
/*     */       
/*     */       public void onError(FacebookException exception)
/*     */       {
/* 668 */         onOpenGraphObjectStagedListener.onError(exception);
/*     */       }
/* 670 */     };
/* 671 */     stageCollectionValues(collection, onMapperCompleteListener);
/*     */   }
/*     */   
/*     */ 
/*     */   private void stagePhoto(final SharePhoto photo, final CollectionMapper.OnMapValueCompleteListener onPhotoStagedListener)
/*     */   {
/* 677 */     Bitmap bitmap = photo.getBitmap();
/* 678 */     Uri imageUrl = photo.getImageUrl();
/* 679 */     if ((bitmap != null) || (imageUrl != null)) {
/* 680 */       GraphRequest.Callback requestCallback = new GraphRequest.Callback()
/*     */       {
/*     */         public void onCompleted(GraphResponse response) {
/* 683 */           FacebookRequestError error = response.getError();
/* 684 */           if (error != null) {
/* 685 */             String message = error.getErrorMessage();
/* 686 */             if (message == null) {
/* 687 */               message = "Error staging photo.";
/*     */             }
/* 689 */             onPhotoStagedListener.onError(new FacebookGraphResponseException(response, message));
/*     */             
/* 691 */             return;
/*     */           }
/* 693 */           JSONObject data = response.getJSONObject();
/* 694 */           if (data == null) {
/* 695 */             onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
/*     */             
/* 697 */             return;
/*     */           }
/* 699 */           String stagedImageUri = data.optString("uri");
/* 700 */           if (stagedImageUri == null) {
/* 701 */             onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
/*     */             
/* 703 */             return;
/*     */           }
/*     */           
/* 706 */           JSONObject stagedObject = new JSONObject();
/*     */           try {
/* 708 */             stagedObject.put("url", stagedImageUri);
/* 709 */             stagedObject.put("user_generated", photo.getUserGenerated());
/*     */           } catch (JSONException ex) {
/* 711 */             String message = ex.getLocalizedMessage();
/* 712 */             if (message == null) {
/* 713 */               message = "Error staging photo.";
/*     */             }
/* 715 */             onPhotoStagedListener.onError(new FacebookException(message));
/* 716 */             return;
/*     */           }
/* 718 */           onPhotoStagedListener.onComplete(stagedObject);
/*     */         }
/*     */       };
/* 721 */       if (bitmap != null)
/*     */       {
/*     */ 
/*     */ 
/* 725 */         ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), bitmap, requestCallback).executeAsync();
/*     */       }
/*     */       else
/*     */       {
/*     */         try
/*     */         {
/* 731 */           ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), imageUrl, requestCallback).executeAsync();
/*     */         } catch (FileNotFoundException ex) {
/* 733 */           String message = ex.getLocalizedMessage();
/* 734 */           if (message == null) {
/* 735 */             message = "Error staging photo.";
/*     */           }
/* 737 */           onPhotoStagedListener.onError(new FacebookException(message));
/*     */         }
/*     */       }
/*     */     } else {
/* 741 */       onPhotoStagedListener.onError(new FacebookException("Photos must have an imageURL or bitmap."));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/ShareApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */