/*     */ package com.facebook.share.widget;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.graphics.Bitmap;
/*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.AccessToken;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.appevents.AppEventsLogger;
/*     */ import com.facebook.internal.AppCall;
/*     */ import com.facebook.internal.CallbackManagerImpl;
/*     */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*     */ import com.facebook.internal.DialogFeature;
/*     */ import com.facebook.internal.DialogPresenter;
/*     */ import com.facebook.internal.DialogPresenter.ParameterProvider;
/*     */ import com.facebook.internal.FacebookDialogBase;
/*     */ import com.facebook.internal.FacebookDialogBase.ModeHandler;
/*     */ import com.facebook.internal.FragmentWrapper;
/*     */ import com.facebook.internal.NativeAppCallAttachmentStore;
/*     */ import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
/*     */ import com.facebook.internal.Utility;
/*     */ import com.facebook.share.Sharer;
/*     */ import com.facebook.share.Sharer.Result;
/*     */ import com.facebook.share.internal.LegacyNativeDialogParameters;
/*     */ import com.facebook.share.internal.NativeDialogParameters;
/*     */ import com.facebook.share.internal.OpenGraphActionDialogFeature;
/*     */ import com.facebook.share.internal.ShareContentValidation;
/*     */ import com.facebook.share.internal.ShareDialogFeature;
/*     */ import com.facebook.share.internal.ShareFeedContent;
/*     */ import com.facebook.share.internal.ShareInternalUtility;
/*     */ import com.facebook.share.internal.WebDialogParameters;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ import com.facebook.share.model.ShareLinkContent;
/*     */ import com.facebook.share.model.ShareMediaContent;
/*     */ import com.facebook.share.model.ShareOpenGraphContent;
/*     */ import com.facebook.share.model.SharePhoto;
/*     */ import com.facebook.share.model.SharePhoto.Builder;
/*     */ import com.facebook.share.model.SharePhotoContent;
/*     */ import com.facebook.share.model.SharePhotoContent.Builder;
/*     */ import com.facebook.share.model.ShareVideoContent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
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
/*     */ public final class ShareDialog
/*     */   extends FacebookDialogBase<ShareContent, Sharer.Result>
/*     */   implements Sharer
/*     */ {
/*     */   private static final String FEED_DIALOG = "feed";
/*     */   public static final String WEB_SHARE_DIALOG = "share";
/*     */   private static final String WEB_OG_SHARE_DIALOG = "share_open_graph";
/*     */   
/*     */   public static enum Mode
/*     */   {
/*  77 */     AUTOMATIC, 
/*     */     
/*     */ 
/*     */ 
/*  81 */     NATIVE, 
/*     */     
/*     */ 
/*     */ 
/*  85 */     WEB, 
/*     */     
/*     */ 
/*     */ 
/*  89 */     FEED;
/*     */     
/*     */ 
/*     */     private Mode() {}
/*     */   }
/*     */   
/*     */ 
/*  96 */   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Share
/*  97 */     .toRequestCode();
/*     */   
/*  99 */   private boolean shouldFailOnDataError = false;
/*     */   
/* 101 */   private boolean isAutomaticMode = true;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void show(Activity activity, ShareContent shareContent)
/*     */   {
/* 113 */     new ShareDialog(activity).show(shareContent);
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
/*     */   public static void show(android.support.v4.app.Fragment fragment, ShareContent shareContent)
/*     */   {
/* 126 */     show(new FragmentWrapper(fragment), shareContent);
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
/*     */   public static void show(android.app.Fragment fragment, ShareContent shareContent)
/*     */   {
/* 139 */     show(new FragmentWrapper(fragment), shareContent);
/*     */   }
/*     */   
/*     */ 
/*     */   private static void show(FragmentWrapper fragmentWrapper, ShareContent shareContent)
/*     */   {
/* 145 */     new ShareDialog(fragmentWrapper).show(shareContent);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean canShow(Class<? extends ShareContent> contentType)
/*     */   {
/* 157 */     return (canShowWebTypeCheck(contentType)) || (canShowNative(contentType));
/*     */   }
/*     */   
/*     */   private static boolean canShowNative(Class<? extends ShareContent> contentType) {
/* 161 */     DialogFeature feature = getFeature(contentType);
/*     */     
/* 163 */     return (feature != null) && (DialogPresenter.canPresentNativeDialogWithFeature(feature));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean canShowWebTypeCheck(Class<? extends ShareContent> contentType)
/*     */   {
/* 174 */     AccessToken accessToken = AccessToken.getCurrentAccessToken();
/* 175 */     boolean haveUserAccessToken = (accessToken != null) && (!accessToken.isExpired());
/*     */     
/*     */ 
/*     */ 
/* 179 */     return (ShareLinkContent.class.isAssignableFrom(contentType)) || (ShareOpenGraphContent.class.isAssignableFrom(contentType)) || ((SharePhotoContent.class.isAssignableFrom(contentType)) && (haveUserAccessToken));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ShareDialog(Activity activity)
/*     */   {
/* 187 */     super(activity, DEFAULT_REQUEST_CODE);
/*     */     
/* 189 */     ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ShareDialog(android.support.v4.app.Fragment fragment)
/*     */   {
/* 197 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ShareDialog(android.app.Fragment fragment)
/*     */   {
/* 206 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */   private ShareDialog(FragmentWrapper fragmentWrapper) {
/* 210 */     super(fragmentWrapper, DEFAULT_REQUEST_CODE);
/*     */     
/* 212 */     ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */   ShareDialog(Activity activity, int requestCode)
/*     */   {
/* 217 */     super(activity, requestCode);
/*     */     
/* 219 */     ShareInternalUtility.registerStaticShareCallback(requestCode);
/*     */   }
/*     */   
/*     */   ShareDialog(android.support.v4.app.Fragment fragment, int requestCode)
/*     */   {
/* 224 */     this(new FragmentWrapper(fragment), requestCode);
/*     */   }
/*     */   
/*     */   ShareDialog(android.app.Fragment fragment, int requestCode)
/*     */   {
/* 229 */     this(new FragmentWrapper(fragment), requestCode);
/*     */   }
/*     */   
/*     */   private ShareDialog(FragmentWrapper fragmentWrapper, int requestCode) {
/* 233 */     super(fragmentWrapper, requestCode);
/*     */     
/* 235 */     ShareInternalUtility.registerStaticShareCallback(requestCode);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void registerCallbackImpl(CallbackManagerImpl callbackManager, FacebookCallback<Sharer.Result> callback)
/*     */   {
/* 242 */     ShareInternalUtility.registerSharerCallback(
/* 243 */       getRequestCode(), callbackManager, callback);
/*     */   }
/*     */   
/*     */   public boolean getShouldFailOnDataError()
/*     */   {
/* 248 */     return this.shouldFailOnDataError;
/*     */   }
/*     */   
/*     */   public void setShouldFailOnDataError(boolean shouldFailOnDataError)
/*     */   {
/* 253 */     this.shouldFailOnDataError = shouldFailOnDataError;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canShow(ShareContent content, Mode mode)
/*     */   {
/* 263 */     return canShowImpl(content, mode == Mode.AUTOMATIC ? BASE_AUTOMATIC_MODE : mode);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void show(ShareContent content, Mode mode)
/*     */   {
/* 271 */     this.isAutomaticMode = (mode == Mode.AUTOMATIC);
/*     */     
/* 273 */     showImpl(content, this.isAutomaticMode ? BASE_AUTOMATIC_MODE : mode);
/*     */   }
/*     */   
/*     */   protected AppCall createBaseAppCall()
/*     */   {
/* 278 */     return new AppCall(getRequestCode());
/*     */   }
/*     */   
/*     */   protected List<FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler> getOrderedModeHandlers()
/*     */   {
/* 283 */     ArrayList<FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler> handlers = new ArrayList();
/* 284 */     handlers.add(new NativeHandler(null));
/* 285 */     handlers.add(new FeedHandler(null));
/* 286 */     handlers.add(new WebShareHandler(null));
/*     */     
/* 288 */     return handlers;
/*     */   }
/*     */   
/* 291 */   private class NativeHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler { private NativeHandler() { super(); }
/*     */     
/*     */     public Object getMode() {
/* 294 */       return Mode.NATIVE;
/*     */     }
/*     */     
/*     */     public boolean canShow(ShareContent content, boolean isBestEffort)
/*     */     {
/* 299 */       if (content == null) {
/* 300 */         return false;
/*     */       }
/*     */       
/* 303 */       boolean canShowResult = true;
/* 304 */       if (!isBestEffort)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 310 */         if (content.getShareHashtag() != null) {
/* 311 */           canShowResult = DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG);
/*     */         }
/*     */         
/* 314 */         if (((content instanceof ShareLinkContent)) && 
/* 315 */           (!Utility.isNullOrEmpty(((ShareLinkContent)content).getQuote()))) {
/* 316 */           canShowResult &= DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES);
/*     */         }
/*     */       }
/*     */       
/* 320 */       return (canShowResult) && (ShareDialog.canShowNative(content.getClass()));
/*     */     }
/*     */     
/*     */     public AppCall createAppCall(final ShareContent content)
/*     */     {
/* 325 */       ShareDialog.this.logDialogShare(ShareDialog.access$400(ShareDialog.this), content, Mode.NATIVE);
/*     */       
/* 327 */       ShareContentValidation.validateForNativeShare(content);
/*     */       
/* 329 */       final AppCall appCall = ShareDialog.this.createBaseAppCall();
/* 330 */       final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
/*     */       
/* 332 */       DialogPresenter.setupAppCallForNativeDialog(appCall, new DialogPresenter.ParameterProvider()
/*     */       {
/*     */ 
/*     */         public Bundle getParameters()
/*     */         {
/* 337 */           return NativeDialogParameters.create(appCall
/* 338 */             .getCallId(), content, shouldFailOnDataError);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */         public Bundle getLegacyParameters()
/*     */         {
/* 345 */           return LegacyNativeDialogParameters.create(appCall
/* 346 */             .getCallId(), content, shouldFailOnDataError);
/*     */ 
/*     */         }
/*     */         
/*     */ 
/* 351 */       }, ShareDialog.getFeature(content.getClass()));
/*     */       
/* 353 */       return appCall;
/*     */     }
/*     */   }
/*     */   
/* 357 */   private class WebShareHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler { private WebShareHandler() { super(); }
/*     */     
/*     */     public Object getMode() {
/* 360 */       return Mode.WEB;
/*     */     }
/*     */     
/*     */     public boolean canShow(ShareContent content, boolean isBestEffort)
/*     */     {
/* 365 */       return (content != null) && (ShareDialog.canShowWebTypeCheck(content.getClass()));
/*     */     }
/*     */     
/*     */     public AppCall createAppCall(ShareContent content)
/*     */     {
/* 370 */       ShareDialog.this.logDialogShare(ShareDialog.access$800(ShareDialog.this), content, Mode.WEB);
/*     */       
/* 372 */       AppCall appCall = ShareDialog.this.createBaseAppCall();
/*     */       
/* 374 */       ShareContentValidation.validateForWebShare(content);
/*     */       Bundle params;
/*     */       Bundle params;
/* 377 */       if ((content instanceof ShareLinkContent)) {
/* 378 */         params = WebDialogParameters.create((ShareLinkContent)content); } else { Bundle params;
/* 379 */         if ((content instanceof SharePhotoContent))
/*     */         {
/* 381 */           SharePhotoContent photoContent = createAndMapAttachments((SharePhotoContent)content, appCall.getCallId());
/* 382 */           params = WebDialogParameters.create(photoContent);
/*     */         } else {
/* 384 */           params = WebDialogParameters.create((ShareOpenGraphContent)content);
/*     */         }
/*     */       }
/* 387 */       DialogPresenter.setupAppCallForWebDialog(appCall, 
/*     */       
/* 389 */         getActionName(content), params);
/*     */       
/*     */ 
/* 392 */       return appCall;
/*     */     }
/*     */     
/*     */     private String getActionName(ShareContent shareContent) {
/* 396 */       if (((shareContent instanceof ShareLinkContent)) || ((shareContent instanceof SharePhotoContent)))
/*     */       {
/* 398 */         return "share"; }
/* 399 */       if ((shareContent instanceof ShareOpenGraphContent)) {
/* 400 */         return "share_open_graph";
/*     */       }
/*     */       
/* 403 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     private SharePhotoContent createAndMapAttachments(SharePhotoContent content, UUID callId)
/*     */     {
/* 410 */       SharePhotoContent.Builder contentBuilder = new SharePhotoContent.Builder().readFrom(content);
/* 411 */       List<SharePhoto> photos = new ArrayList();
/* 412 */       List<NativeAppCallAttachmentStore.Attachment> attachments = new ArrayList();
/* 413 */       for (int i = 0; i < content.getPhotos().size(); i++) {
/* 414 */         SharePhoto sharePhoto = (SharePhoto)content.getPhotos().get(i);
/* 415 */         Bitmap photoBitmap = sharePhoto.getBitmap();
/*     */         
/* 417 */         if (photoBitmap != null)
/*     */         {
/* 419 */           NativeAppCallAttachmentStore.Attachment attachment = NativeAppCallAttachmentStore.createAttachment(callId, photoBitmap);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 424 */           sharePhoto = new SharePhoto.Builder().readFrom(sharePhoto).setImageUrl(Uri.parse(attachment.getAttachmentUrl())).setBitmap(null).build();
/* 425 */           attachments.add(attachment);
/*     */         }
/*     */         
/* 428 */         photos.add(sharePhoto);
/*     */       }
/* 430 */       contentBuilder.setPhotos(photos);
/* 431 */       NativeAppCallAttachmentStore.addAttachments(attachments);
/* 432 */       return contentBuilder.build();
/*     */     }
/*     */   }
/*     */   
/* 436 */   private class FeedHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler { private FeedHandler() { super(); }
/*     */     
/*     */     public Object getMode() {
/* 439 */       return Mode.FEED;
/*     */     }
/*     */     
/*     */     public boolean canShow(ShareContent content, boolean isBestEffort)
/*     */     {
/* 444 */       return ((content instanceof ShareLinkContent)) || ((content instanceof ShareFeedContent));
/*     */     }
/*     */     
/*     */ 
/*     */     public AppCall createAppCall(ShareContent content)
/*     */     {
/* 450 */       ShareDialog.this.logDialogShare(ShareDialog.access$900(ShareDialog.this), content, Mode.FEED);
/* 451 */       AppCall appCall = ShareDialog.this.createBaseAppCall();
/*     */       Bundle params;
/* 453 */       Bundle params; if ((content instanceof ShareLinkContent)) {
/* 454 */         ShareLinkContent linkContent = (ShareLinkContent)content;
/* 455 */         ShareContentValidation.validateForWebShare(linkContent);
/* 456 */         params = WebDialogParameters.createForFeed(linkContent);
/*     */       } else {
/* 458 */         ShareFeedContent feedContent = (ShareFeedContent)content;
/* 459 */         params = WebDialogParameters.createForFeed(feedContent);
/*     */       }
/*     */       
/* 462 */       DialogPresenter.setupAppCallForWebDialog(appCall, "feed", params);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 467 */       return appCall;
/*     */     }
/*     */   }
/*     */   
/*     */   private static DialogFeature getFeature(Class<? extends ShareContent> contentType)
/*     */   {
/* 473 */     if (ShareLinkContent.class.isAssignableFrom(contentType))
/* 474 */       return ShareDialogFeature.SHARE_DIALOG;
/* 475 */     if (SharePhotoContent.class.isAssignableFrom(contentType))
/* 476 */       return ShareDialogFeature.PHOTOS;
/* 477 */     if (ShareVideoContent.class.isAssignableFrom(contentType))
/* 478 */       return ShareDialogFeature.VIDEO;
/* 479 */     if (ShareOpenGraphContent.class.isAssignableFrom(contentType))
/* 480 */       return OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
/* 481 */     if (ShareMediaContent.class.isAssignableFrom(contentType)) {
/* 482 */       return ShareDialogFeature.MULTIMEDIA;
/*     */     }
/* 484 */     return null;
/*     */   }
/*     */   
/*     */   private void logDialogShare(Context context, ShareContent content, Mode mode)
/*     */   {
/* 489 */     if (this.isAutomaticMode)
/* 490 */       mode = Mode.AUTOMATIC;
/*     */     String displayType;
/*     */     String displayType;
/* 493 */     String displayType; String displayType; switch (mode) {
/*     */     case AUTOMATIC: 
/* 495 */       displayType = "automatic";
/* 496 */       break;
/*     */     case WEB: 
/* 498 */       displayType = "web";
/* 499 */       break;
/*     */     case NATIVE: 
/* 501 */       displayType = "native";
/* 502 */       break;
/*     */     default: 
/* 504 */       displayType = "unknown";
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 509 */     DialogFeature dialogFeature = getFeature(content.getClass());
/* 510 */     String contentType; String contentType; if (dialogFeature == ShareDialogFeature.SHARE_DIALOG) {
/* 511 */       contentType = "status"; } else { String contentType;
/* 512 */       if (dialogFeature == ShareDialogFeature.PHOTOS) {
/* 513 */         contentType = "photo"; } else { String contentType;
/* 514 */         if (dialogFeature == ShareDialogFeature.VIDEO) {
/* 515 */           contentType = "video"; } else { String contentType;
/* 516 */           if (dialogFeature == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
/* 517 */             contentType = "open_graph";
/*     */           } else
/* 519 */             contentType = "unknown";
/*     */         }
/*     */       } }
/* 522 */     AppEventsLogger logger = AppEventsLogger.newLogger(context);
/* 523 */     Bundle parameters = new Bundle();
/* 524 */     parameters.putString("fb_share_dialog_show", displayType);
/*     */     
/*     */ 
/*     */ 
/* 528 */     parameters.putString("fb_share_dialog_content_type", contentType);
/*     */     
/*     */ 
/*     */ 
/* 532 */     logger.logSdkEvent("fb_share_dialog_show", null, parameters);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/ShareDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */