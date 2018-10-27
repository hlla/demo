/*     */ package com.facebook.share.widget;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.os.Bundle;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.internal.AppCall;
/*     */ import com.facebook.internal.CallbackManagerImpl;
/*     */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*     */ import com.facebook.internal.DialogFeature;
/*     */ import com.facebook.internal.DialogPresenter;
/*     */ import com.facebook.internal.DialogPresenter.ParameterProvider;
/*     */ import com.facebook.internal.FacebookDialogBase;
/*     */ import com.facebook.internal.FacebookDialogBase.ModeHandler;
/*     */ import com.facebook.internal.FragmentWrapper;
/*     */ import com.facebook.share.Sharer;
/*     */ import com.facebook.share.Sharer.Result;
/*     */ import com.facebook.share.internal.LegacyNativeDialogParameters;
/*     */ import com.facebook.share.internal.MessageDialogFeature;
/*     */ import com.facebook.share.internal.NativeDialogParameters;
/*     */ import com.facebook.share.internal.OpenGraphMessageDialogFeature;
/*     */ import com.facebook.share.internal.ShareContentValidation;
/*     */ import com.facebook.share.internal.ShareInternalUtility;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ import com.facebook.share.model.ShareLinkContent;
/*     */ import com.facebook.share.model.ShareOpenGraphContent;
/*     */ import com.facebook.share.model.SharePhotoContent;
/*     */ import com.facebook.share.model.ShareVideoContent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public final class MessageDialog
/*     */   extends FacebookDialogBase<ShareContent, Sharer.Result>
/*     */   implements Sharer
/*     */ {
/*  53 */   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Message
/*  54 */     .toRequestCode();
/*     */   
/*  56 */   private boolean shouldFailOnDataError = false;
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
/*  68 */     new MessageDialog(activity).show(shareContent);
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
/*  81 */     show(new FragmentWrapper(fragment), shareContent);
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
/*  94 */     show(new FragmentWrapper(fragment), shareContent);
/*     */   }
/*     */   
/*     */ 
/*     */   private static void show(FragmentWrapper fragmentWrapper, ShareContent shareContent)
/*     */   {
/* 100 */     new MessageDialog(fragmentWrapper).show(shareContent);
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
/* 112 */     DialogFeature feature = getFeature(contentType);
/*     */     
/* 114 */     return (feature != null) && (DialogPresenter.canPresentNativeDialogWithFeature(feature));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MessageDialog(Activity activity)
/*     */   {
/* 122 */     super(activity, DEFAULT_REQUEST_CODE);
/*     */     
/* 124 */     ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MessageDialog(android.support.v4.app.Fragment fragment)
/*     */   {
/* 132 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MessageDialog(android.app.Fragment fragment)
/*     */   {
/* 141 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */   private MessageDialog(FragmentWrapper fragmentWrapper) {
/* 145 */     super(fragmentWrapper, DEFAULT_REQUEST_CODE);
/*     */     
/* 147 */     ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */   MessageDialog(Activity activity, int requestCode)
/*     */   {
/* 152 */     super(activity, requestCode);
/*     */     
/* 154 */     ShareInternalUtility.registerStaticShareCallback(requestCode);
/*     */   }
/*     */   
/*     */   MessageDialog(android.support.v4.app.Fragment fragment, int requestCode)
/*     */   {
/* 159 */     this(new FragmentWrapper(fragment), requestCode);
/*     */   }
/*     */   
/*     */   MessageDialog(android.app.Fragment fragment, int requestCode)
/*     */   {
/* 164 */     this(new FragmentWrapper(fragment), requestCode);
/*     */   }
/*     */   
/*     */   private MessageDialog(FragmentWrapper fragmentWrapper, int requestCode) {
/* 168 */     super(fragmentWrapper, requestCode);
/*     */     
/* 170 */     ShareInternalUtility.registerStaticShareCallback(requestCode);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void registerCallbackImpl(CallbackManagerImpl callbackManager, FacebookCallback<Sharer.Result> callback)
/*     */   {
/* 177 */     ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager, callback);
/*     */   }
/*     */   
/*     */   public boolean getShouldFailOnDataError()
/*     */   {
/* 182 */     return this.shouldFailOnDataError;
/*     */   }
/*     */   
/*     */   public void setShouldFailOnDataError(boolean shouldFailOnDataError)
/*     */   {
/* 187 */     this.shouldFailOnDataError = shouldFailOnDataError;
/*     */   }
/*     */   
/*     */   protected AppCall createBaseAppCall()
/*     */   {
/* 192 */     return new AppCall(getRequestCode());
/*     */   }
/*     */   
/*     */   protected List<FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler> getOrderedModeHandlers()
/*     */   {
/* 197 */     ArrayList<FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler> handlers = new ArrayList();
/* 198 */     handlers.add(new NativeHandler(null));
/*     */     
/* 200 */     return handlers;
/*     */   }
/*     */   
/* 203 */   private class NativeHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler { private NativeHandler() { super(); }
/*     */     
/*     */     public boolean canShow(ShareContent shareContent, boolean isBestEffort) {
/* 206 */       return (shareContent != null) && (MessageDialog.canShow(shareContent.getClass()));
/*     */     }
/*     */     
/*     */     public AppCall createAppCall(final ShareContent content)
/*     */     {
/* 211 */       ShareContentValidation.validateForMessage(content);
/*     */       
/* 213 */       final AppCall appCall = MessageDialog.this.createBaseAppCall();
/* 214 */       final boolean shouldFailOnDataError = MessageDialog.this.getShouldFailOnDataError();
/*     */       
/* 216 */       DialogPresenter.setupAppCallForNativeDialog(appCall, new DialogPresenter.ParameterProvider()
/*     */       {
/*     */ 
/*     */         public Bundle getParameters()
/*     */         {
/* 221 */           return NativeDialogParameters.create(appCall
/* 222 */             .getCallId(), content, shouldFailOnDataError);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */         public Bundle getLegacyParameters()
/*     */         {
/* 229 */           return LegacyNativeDialogParameters.create(appCall
/* 230 */             .getCallId(), content, shouldFailOnDataError);
/*     */ 
/*     */         }
/*     */         
/*     */ 
/* 235 */       }, MessageDialog.getFeature(content.getClass()));
/*     */       
/* 237 */       return appCall;
/*     */     }
/*     */   }
/*     */   
/*     */   private static DialogFeature getFeature(Class<? extends ShareContent> contentType)
/*     */   {
/* 243 */     if (ShareLinkContent.class.isAssignableFrom(contentType))
/* 244 */       return MessageDialogFeature.MESSAGE_DIALOG;
/* 245 */     if (SharePhotoContent.class.isAssignableFrom(contentType))
/* 246 */       return MessageDialogFeature.PHOTOS;
/* 247 */     if (ShareVideoContent.class.isAssignableFrom(contentType))
/* 248 */       return MessageDialogFeature.VIDEO;
/* 249 */     if (ShareOpenGraphContent.class.isAssignableFrom(contentType)) {
/* 250 */       return OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG;
/*     */     }
/* 252 */     return null;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/MessageDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */