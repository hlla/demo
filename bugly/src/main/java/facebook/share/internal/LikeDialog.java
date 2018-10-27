/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.util.Log;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.internal.AppCall;
/*     */ import com.facebook.internal.CallbackManagerImpl;
/*     */ import com.facebook.internal.CallbackManagerImpl.Callback;
/*     */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*     */ import com.facebook.internal.DialogFeature;
/*     */ import com.facebook.internal.DialogPresenter;
/*     */ import com.facebook.internal.DialogPresenter.ParameterProvider;
/*     */ import com.facebook.internal.FacebookDialogBase;
/*     */ import com.facebook.internal.FacebookDialogBase.ModeHandler;
/*     */ import com.facebook.internal.FragmentWrapper;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LikeDialog
/*     */   extends FacebookDialogBase<LikeContent, Result>
/*     */ {
/*     */   private static final String TAG = "LikeDialog";
/*  49 */   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Like
/*  50 */     .toRequestCode();
/*     */   
/*     */ 
/*     */ 
/*     */   public static final class Result
/*     */   {
/*     */     private final Bundle bundle;
/*     */     
/*     */ 
/*     */     public Result(Bundle bundle)
/*     */     {
/*  61 */       this.bundle = bundle;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Bundle getData()
/*     */     {
/*  70 */       return this.bundle;
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean canShowNativeDialog()
/*     */   {
/*  76 */     return DialogPresenter.canPresentNativeDialogWithFeature(getFeature());
/*     */   }
/*     */   
/*     */   public static boolean canShowWebFallback()
/*     */   {
/*  81 */     return DialogPresenter.canPresentWebFallbackDialogWithFeature(getFeature());
/*     */   }
/*     */   
/*     */   public LikeDialog(Activity activity) {
/*  85 */     super(activity, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */   public LikeDialog(android.support.v4.app.Fragment fragment) {
/*  89 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */   public LikeDialog(android.app.Fragment fragment) {
/*  93 */     this(new FragmentWrapper(fragment));
/*     */   }
/*     */   
/*     */   public LikeDialog(FragmentWrapper fragmentWrapper) {
/*  97 */     super(fragmentWrapper, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */   protected AppCall createBaseAppCall()
/*     */   {
/* 102 */     return new AppCall(getRequestCode());
/*     */   }
/*     */   
/*     */   protected List<FacebookDialogBase<LikeContent, Result>.ModeHandler> getOrderedModeHandlers()
/*     */   {
/* 107 */     ArrayList<FacebookDialogBase<LikeContent, Result>.ModeHandler> handlers = new ArrayList();
/* 108 */     handlers.add(new NativeHandler(null));
/* 109 */     handlers.add(new WebFallbackHandler(null));
/*     */     
/* 111 */     return handlers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void registerCallbackImpl(CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback)
/*     */   {
/* 118 */     final ResultProcessor resultProcessor = callback == null ? null : new ResultProcessor(callback)
/*     */     {
/*     */ 
/*     */       public void onSuccess(AppCall appCall, Bundle results)
/*     */       {
/* 123 */         callback.onSuccess(new Result(results));
/*     */       }
/*     */       
/* 126 */     };
/* 127 */     CallbackManagerImpl.Callback callbackManagerCallback = new CallbackManagerImpl.Callback()
/*     */     {
/*     */       public boolean onActivityResult(int resultCode, Intent data) {
/* 130 */         return ShareInternalUtility.handleActivityResult(LikeDialog.this
/* 131 */           .getRequestCode(), resultCode, data, resultProcessor);
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 137 */     };
/* 138 */     callbackManager.registerCallback(
/* 139 */       getRequestCode(), callbackManagerCallback);
/*     */   }
/*     */   
/*     */   private class NativeHandler extends FacebookDialogBase<LikeContent, Result>.ModeHandler {
/* 143 */     private NativeHandler() { super(); }
/*     */     
/*     */     public boolean canShow(LikeContent content, boolean isBestEffort) {
/* 146 */       return (content != null) && (LikeDialog.canShowNativeDialog());
/*     */     }
/*     */     
/*     */     public AppCall createAppCall(final LikeContent content)
/*     */     {
/* 151 */       AppCall appCall = LikeDialog.this.createBaseAppCall();
/*     */       
/* 153 */       DialogPresenter.setupAppCallForNativeDialog(appCall, new DialogPresenter.ParameterProvider()
/*     */       {
/*     */ 
/*     */         public Bundle getParameters()
/*     */         {
/* 158 */           return LikeDialog.createParameters(content);
/*     */         }
/*     */         
/*     */ 
/*     */         public Bundle getLegacyParameters()
/*     */         {
/* 164 */           Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
/*     */           
/* 166 */           return new Bundle();
/*     */         }
/*     */         
/* 169 */       }, LikeDialog.access$300());
/*     */       
/* 171 */       return appCall;
/*     */     }
/*     */   }
/*     */   
/* 175 */   private class WebFallbackHandler extends FacebookDialogBase<LikeContent, Result>.ModeHandler { private WebFallbackHandler() { super(); }
/*     */     
/*     */     public boolean canShow(LikeContent content, boolean isBestEffort) {
/* 178 */       return (content != null) && (LikeDialog.canShowWebFallback());
/*     */     }
/*     */     
/*     */     public AppCall createAppCall(LikeContent content)
/*     */     {
/* 183 */       AppCall appCall = LikeDialog.this.createBaseAppCall();
/*     */       
/* 185 */       DialogPresenter.setupAppCallForWebFallbackDialog(appCall, 
/*     */       
/* 187 */         LikeDialog.createParameters(content), 
/* 188 */         LikeDialog.access$300());
/*     */       
/* 190 */       return appCall;
/*     */     }
/*     */   }
/*     */   
/*     */   private static DialogFeature getFeature() {
/* 195 */     return LikeDialogFeature.LIKE_DIALOG;
/*     */   }
/*     */   
/*     */   private static Bundle createParameters(LikeContent likeContent) {
/* 199 */     Bundle params = new Bundle();
/*     */     
/* 201 */     params.putString("object_id", likeContent.getObjectId());
/* 202 */     params.putString("object_type", likeContent.getObjectType());
/*     */     
/* 204 */     return params;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/LikeDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */