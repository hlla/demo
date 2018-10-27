/*     */ package com.facebook.share;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Intent;
/*     */ import com.facebook.FacebookActivity;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.FacebookRequestError;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.internal.AppCall;
/*     */ import com.facebook.internal.CallbackManagerImpl;
/*     */ import com.facebook.internal.CallbackManagerImpl.Callback;
/*     */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*     */ import com.facebook.internal.FacebookDialogBase;
/*     */ import com.facebook.internal.FragmentWrapper;
/*     */ import com.facebook.share.model.ShareContent;
/*     */ import com.facebook.share.model.ShareLinkContent;
/*     */ import com.facebook.share.model.ShareOpenGraphContent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DeviceShareDialog
/*     */   extends FacebookDialogBase<ShareContent, Result>
/*     */ {
/*  55 */   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.DeviceShare
/*  56 */     .toRequestCode();
/*     */   
/*     */ 
/*     */ 
/*     */   public DeviceShareDialog(Activity activity)
/*     */   {
/*  62 */     super(activity, DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public DeviceShareDialog(android.app.Fragment fragment)
/*     */   {
/*  69 */     super(new FragmentWrapper(fragment), DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public DeviceShareDialog(android.support.v4.app.Fragment fragment)
/*     */   {
/*  76 */     super(new FragmentWrapper(fragment), DEFAULT_REQUEST_CODE);
/*     */   }
/*     */   
/*     */   protected boolean canShowImpl(ShareContent content, Object mode)
/*     */   {
/*  81 */     return ((content instanceof ShareLinkContent)) || ((content instanceof ShareOpenGraphContent));
/*     */   }
/*     */   
/*     */ 
/*     */   protected void showImpl(ShareContent content, Object mode)
/*     */   {
/*  87 */     if (content == null) {
/*  88 */       throw new FacebookException("Must provide non-null content to share");
/*     */     }
/*     */     
/*  91 */     if ((!(content instanceof ShareLinkContent)) && (!(content instanceof ShareOpenGraphContent)))
/*     */     {
/*  93 */       throw new FacebookException(getClass().getSimpleName() + " only supports ShareLinkContent or ShareOpenGraphContent");
/*     */     }
/*     */     
/*  96 */     Intent intent = new Intent();
/*  97 */     intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
/*  98 */     intent.setAction("DeviceShareDialogFragment");
/*  99 */     intent.putExtra("content", content);
/* 100 */     startActivityForResult(intent, getRequestCode());
/*     */   }
/*     */   
/*     */   protected List<FacebookDialogBase<ShareContent, Result>.ModeHandler> getOrderedModeHandlers()
/*     */   {
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   protected AppCall createBaseAppCall()
/*     */   {
/* 110 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void registerCallbackImpl(CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback)
/*     */   {
/* 118 */     callbackManager.registerCallback(
/* 119 */       getRequestCode(), new CallbackManagerImpl.Callback()
/*     */       {
/*     */         public boolean onActivityResult(int resultCode, Intent data)
/*     */         {
/* 123 */           if (data.hasExtra("error")) {
/* 124 */             FacebookRequestError error = (FacebookRequestError)data.getParcelableExtra("error");
/* 125 */             callback.onError(error.getException());
/* 126 */             return true;
/*     */           }
/* 128 */           callback.onSuccess(new Result());
/* 129 */           return true;
/*     */         }
/*     */       });
/*     */   }
/*     */   
/*     */   public static class Result {}
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/DeviceShareDialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */