/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.graphics.Bitmap;
/*     */ import android.net.Uri;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.internal.Validate;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ import com.facebook.share.model.ShareLinkContent;
/*     */ import com.facebook.share.model.ShareMedia;
/*     */ import com.facebook.share.model.ShareMediaContent;
/*     */ import com.facebook.share.model.ShareOpenGraphAction;
/*     */ import com.facebook.share.model.ShareOpenGraphContent;
/*     */ import com.facebook.share.model.ShareOpenGraphObject;
/*     */ import com.facebook.share.model.ShareOpenGraphValueContainer;
/*     */ import com.facebook.share.model.SharePhoto;
/*     */ import com.facebook.share.model.SharePhotoContent;
/*     */ import com.facebook.share.model.ShareVideo;
/*     */ import com.facebook.share.model.ShareVideoContent;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
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
/*     */ public class ShareContentValidation
/*     */ {
/*     */   private static Validator WebShareValidator;
/*     */   private static Validator DefaultValidator;
/*     */   private static Validator ApiValidator;
/*     */   
/*     */   public static void validateForMessage(ShareContent content)
/*     */   {
/*  59 */     validate(content, getDefaultValidator());
/*     */   }
/*     */   
/*     */   public static void validateForNativeShare(ShareContent content) {
/*  63 */     validate(content, getDefaultValidator());
/*     */   }
/*     */   
/*     */   public static void validateForWebShare(ShareContent content) {
/*  67 */     validate(content, getWebShareValidator());
/*     */   }
/*     */   
/*     */   public static void validateForApiShare(ShareContent content) {
/*  71 */     validate(content, getApiValidator());
/*     */   }
/*     */   
/*     */   private static Validator getDefaultValidator() {
/*  75 */     if (DefaultValidator == null) {
/*  76 */       DefaultValidator = new Validator(null);
/*     */     }
/*  78 */     return DefaultValidator;
/*     */   }
/*     */   
/*     */   private static Validator getApiValidator() {
/*  82 */     if (ApiValidator == null) {
/*  83 */       ApiValidator = new ApiValidator(null);
/*     */     }
/*  85 */     return ApiValidator;
/*     */   }
/*     */   
/*     */   private static Validator getWebShareValidator() {
/*  89 */     if (WebShareValidator == null) {
/*  90 */       WebShareValidator = new WebShareValidator(null);
/*     */     }
/*  92 */     return WebShareValidator;
/*     */   }
/*     */   
/*     */   private static void validate(ShareContent content, Validator validator) throws FacebookException
/*     */   {
/*  97 */     if (content == null) {
/*  98 */       throw new FacebookException("Must provide non-null content to share");
/*     */     }
/*     */     
/* 101 */     if ((content instanceof ShareLinkContent)) {
/* 102 */       validator.validate((ShareLinkContent)content);
/* 103 */     } else if ((content instanceof SharePhotoContent)) {
/* 104 */       validator.validate((SharePhotoContent)content);
/* 105 */     } else if ((content instanceof ShareVideoContent)) {
/* 106 */       validator.validate((ShareVideoContent)content);
/* 107 */     } else if ((content instanceof ShareOpenGraphContent)) {
/* 108 */       validator.validate((ShareOpenGraphContent)content);
/* 109 */     } else if ((content instanceof ShareMediaContent)) {
/* 110 */       validator.validate((ShareMediaContent)content);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void validateLinkContent(ShareLinkContent linkContent, Validator validator)
/*     */   {
/* 116 */     Uri imageUrl = linkContent.getImageUrl();
/* 117 */     if ((imageUrl != null) && (!Utility.isWebUri(imageUrl))) {
/* 118 */       throw new FacebookException("Image Url must be an http:// or https:// url");
/*     */     }
/*     */   }
/*     */   
/*     */   private static void validatePhotoContent(SharePhotoContent photoContent, Validator validator)
/*     */   {
/* 124 */     List<SharePhoto> photos = photoContent.getPhotos();
/* 125 */     if ((photos == null) || (photos.isEmpty())) {
/* 126 */       throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
/*     */     }
/* 128 */     if (photos.size() > 6)
/*     */     {
/* 130 */       throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", new Object[] {
/*     */       
/*     */ 
/* 133 */         Integer.valueOf(6) }));
/*     */     }
/*     */     
/* 136 */     for (SharePhoto photo : photos) {
/* 137 */       validator.validate(photo);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void validatePhoto(SharePhoto photo) {
/* 142 */     if (photo == null) {
/* 143 */       throw new FacebookException("Cannot share a null SharePhoto");
/*     */     }
/*     */     
/* 146 */     Bitmap photoBitmap = photo.getBitmap();
/* 147 */     Uri photoUri = photo.getImageUrl();
/*     */     
/* 149 */     if ((photoBitmap == null) && (photoUri == null)) {
/* 150 */       throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
/*     */     }
/*     */   }
/*     */   
/*     */   private static void validatePhotoForApi(SharePhoto photo, Validator validator) {
/* 155 */     validatePhoto(photo);
/*     */     
/* 157 */     Bitmap photoBitmap = photo.getBitmap();
/* 158 */     Uri photoUri = photo.getImageUrl();
/*     */     
/* 160 */     if ((photoBitmap == null) && (Utility.isWebUri(photoUri)) && (!validator.isOpenGraphContent())) {
/* 161 */       throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static void validatePhotoForNativeDialog(SharePhoto photo, Validator validator)
/*     */   {
/* 168 */     validatePhotoForApi(photo, validator);
/*     */     
/* 170 */     if ((photo.getBitmap() != null) || (!Utility.isWebUri(photo.getImageUrl()))) {
/* 171 */       Validate.hasContentProvider(FacebookSdk.getApplicationContext());
/*     */     }
/*     */   }
/*     */   
/*     */   private static void validatePhotoForWebDialog(SharePhoto photo, Validator validator) {
/* 176 */     validatePhoto(photo);
/*     */   }
/*     */   
/*     */   private static void validateVideoContent(ShareVideoContent videoContent, Validator validator)
/*     */   {
/* 181 */     validator.validate(videoContent.getVideo());
/*     */     
/* 183 */     SharePhoto previewPhoto = videoContent.getPreviewPhoto();
/* 184 */     if (previewPhoto != null) {
/* 185 */       validator.validate(previewPhoto);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void validateVideo(ShareVideo video, Validator validator) {
/* 190 */     if (video == null) {
/* 191 */       throw new FacebookException("Cannot share a null ShareVideo");
/*     */     }
/*     */     
/* 194 */     Uri localUri = video.getLocalUrl();
/* 195 */     if (localUri == null) {
/* 196 */       throw new FacebookException("ShareVideo does not have a LocalUrl specified");
/*     */     }
/*     */     
/* 199 */     if ((!Utility.isContentUri(localUri)) && (!Utility.isFileUri(localUri))) {
/* 200 */       throw new FacebookException("ShareVideo must reference a video that is on the device");
/*     */     }
/*     */   }
/*     */   
/*     */   private static void validateMediaContent(ShareMediaContent mediaContent, Validator validator) {
/* 205 */     List<ShareMedia> media = mediaContent.getMedia();
/* 206 */     if ((media == null) || (media.isEmpty())) {
/* 207 */       throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
/*     */     }
/* 209 */     if (media.size() > 6)
/*     */     {
/* 211 */       throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", new Object[] {
/*     */       
/*     */ 
/* 214 */         Integer.valueOf(6) }));
/*     */     }
/* 216 */     for (ShareMedia medium : media) {
/* 217 */       validator.validate(medium);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void validateMedium(ShareMedia medium, Validator validator) {
/* 222 */     if ((medium instanceof SharePhoto)) {
/* 223 */       validator.validate((SharePhoto)medium);
/* 224 */     } else if ((medium instanceof ShareVideo)) {
/* 225 */       validator.validate((ShareVideo)medium);
/*     */     }
/*     */     else {
/* 228 */       throw new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", new Object[] {medium
/*     */       
/*     */ 
/* 231 */         .getClass().getSimpleName() }));
/*     */     }
/*     */   }
/*     */   
/*     */   private static void validateOpenGraphContent(ShareOpenGraphContent openGraphContent, Validator validator)
/*     */   {
/* 237 */     validator.validate(openGraphContent.getAction());
/*     */     
/* 239 */     String previewPropertyName = openGraphContent.getPreviewPropertyName();
/* 240 */     if (Utility.isNullOrEmpty(previewPropertyName)) {
/* 241 */       throw new FacebookException("Must specify a previewPropertyName.");
/*     */     }
/*     */     
/* 244 */     if (openGraphContent.getAction().get(previewPropertyName) == null) {
/* 245 */       throw new FacebookException("Property \"" + previewPropertyName + "\" was not found on the action. " + "The name of the preview property must match the name of an " + "action property.");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void validateOpenGraphAction(ShareOpenGraphAction openGraphAction, Validator validator)
/*     */   {
/* 255 */     if (openGraphAction == null) {
/* 256 */       throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
/*     */     }
/*     */     
/* 259 */     if (Utility.isNullOrEmpty(openGraphAction.getActionType())) {
/* 260 */       throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
/*     */     }
/*     */     
/* 263 */     validator.validate(openGraphAction, false);
/*     */   }
/*     */   
/*     */ 
/*     */   private static void validateOpenGraphObject(ShareOpenGraphObject openGraphObject, Validator validator)
/*     */   {
/* 269 */     if (openGraphObject == null) {
/* 270 */       throw new FacebookException("Cannot share a null ShareOpenGraphObject");
/*     */     }
/*     */     
/* 273 */     validator.validate(openGraphObject, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void validateOpenGraphValueContainer(ShareOpenGraphValueContainer valueContainer, Validator validator, boolean requireNamespace)
/*     */   {
/* 280 */     Set<String> keySet = valueContainer.keySet();
/* 281 */     for (String key : keySet) {
/* 282 */       validateOpenGraphKey(key, requireNamespace);
/* 283 */       Object o = valueContainer.get(key);
/* 284 */       if ((o instanceof List)) {
/* 285 */         List list = (List)o;
/* 286 */         for (Object objectInList : list) {
/* 287 */           if (objectInList == null) {
/* 288 */             throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
/*     */           }
/*     */           
/*     */ 
/* 292 */           validateOpenGraphValueContainerObject(objectInList, validator);
/*     */         }
/*     */       } else {
/* 295 */         validateOpenGraphValueContainerObject(o, validator);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void validateOpenGraphKey(String key, boolean requireNamespace) {
/* 301 */     if (!requireNamespace) {
/* 302 */       return;
/*     */     }
/*     */     
/* 305 */     String[] components = key.split(":");
/* 306 */     if (components.length < 2) {
/* 307 */       throw new FacebookException("Open Graph keys must be namespaced: %s", new Object[] { key });
/*     */     }
/* 309 */     for (String component : components) {
/* 310 */       if (component.isEmpty()) {
/* 311 */         throw new FacebookException("Invalid key found in Open Graph dictionary: %s", new Object[] { key });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void validateOpenGraphValueContainerObject(Object o, Validator validator)
/*     */   {
/* 318 */     if ((o instanceof ShareOpenGraphObject)) {
/* 319 */       validator.validate((ShareOpenGraphObject)o);
/* 320 */     } else if ((o instanceof SharePhoto))
/* 321 */       validator.validate((SharePhoto)o);
/*     */   }
/*     */   
/*     */   private static class WebShareValidator extends Validator {
/* 325 */     private WebShareValidator() { super(); }
/*     */     
/*     */     public void validate(ShareVideoContent videoContent) {
/* 328 */       throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
/*     */     }
/*     */     
/*     */     public void validate(ShareMediaContent mediaContent)
/*     */     {
/* 333 */       throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 338 */     public void validate(SharePhoto photo) { ShareContentValidation.validatePhotoForWebDialog(photo, this); }
/*     */   }
/*     */   
/*     */   private static class ApiValidator extends Validator {
/* 342 */     private ApiValidator() { super(); }
/*     */     
/*     */     public void validate(SharePhoto photo) {
/* 345 */       ShareContentValidation.validatePhotoForApi(photo, this);
/*     */     }
/*     */     
/*     */     public void validate(ShareVideoContent videoContent)
/*     */     {
/* 350 */       if (!Utility.isNullOrEmpty(videoContent.getPlaceId())) {
/* 351 */         throw new FacebookException("Cannot share video content with place IDs using the share api");
/*     */       }
/*     */       
/* 354 */       if (!Utility.isNullOrEmpty(videoContent.getPeopleIds())) {
/* 355 */         throw new FacebookException("Cannot share video content with people IDs using the share api");
/*     */       }
/*     */       
/* 358 */       if (!Utility.isNullOrEmpty(videoContent.getRef())) {
/* 359 */         throw new FacebookException("Cannot share video content with referrer URL using the share api");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public void validate(ShareMediaContent mediaContent)
/*     */     {
/* 366 */       throw new FacebookException("Cannot share ShareMediaContent using the share api");
/*     */     }
/*     */     
/*     */     public void validate(ShareLinkContent linkContent)
/*     */     {
/* 371 */       if (!Utility.isNullOrEmpty(linkContent.getQuote())) {
/* 372 */         throw new FacebookException("Cannot share link content with quote using the share api");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Validator
/*     */   {
/* 379 */     private boolean isOpenGraphContent = false;
/*     */     
/*     */     public void validate(ShareLinkContent linkContent) {
/* 382 */       ShareContentValidation.validateLinkContent(linkContent, this);
/*     */     }
/*     */     
/*     */     public void validate(SharePhotoContent photoContent) {
/* 386 */       ShareContentValidation.validatePhotoContent(photoContent, this);
/*     */     }
/*     */     
/*     */     public void validate(ShareVideoContent videoContent) {
/* 390 */       ShareContentValidation.validateVideoContent(videoContent, this);
/*     */     }
/*     */     
/*     */     public void validate(ShareMediaContent mediaContent) {
/* 394 */       ShareContentValidation.validateMediaContent(mediaContent, this);
/*     */     }
/*     */     
/*     */     public void validate(ShareOpenGraphContent openGraphContent) {
/* 398 */       this.isOpenGraphContent = true;
/* 399 */       ShareContentValidation.validateOpenGraphContent(openGraphContent, this);
/*     */     }
/*     */     
/*     */     public void validate(ShareOpenGraphAction openGraphAction) {
/* 403 */       ShareContentValidation.validateOpenGraphAction(openGraphAction, this);
/*     */     }
/*     */     
/*     */     public void validate(ShareOpenGraphObject openGraphObject) {
/* 407 */       ShareContentValidation.validateOpenGraphObject(openGraphObject, this);
/*     */     }
/*     */     
/*     */     public void validate(ShareOpenGraphValueContainer openGraphValueContainer, boolean requireNamespace)
/*     */     {
/* 412 */       ShareContentValidation.validateOpenGraphValueContainer(openGraphValueContainer, this, requireNamespace);
/*     */     }
/*     */     
/*     */     public void validate(SharePhoto photo) {
/* 416 */       ShareContentValidation.validatePhotoForNativeDialog(photo, this);
/*     */     }
/*     */     
/*     */     public void validate(ShareVideo video) {
/* 420 */       ShareContentValidation.validateVideo(video, this);
/*     */     }
/*     */     
/*     */     public void validate(ShareMedia medium) {
/* 424 */       ShareContentValidation.validateMedium(medium, this);
/*     */     }
/*     */     
/*     */     public boolean isOpenGraphContent() {
/* 428 */       return this.isOpenGraphContent;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/ShareContentValidation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */