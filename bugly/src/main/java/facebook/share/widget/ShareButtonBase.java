/*     */ package com.facebook.share.widget;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.AttributeSet;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import com.facebook.CallbackManager;
/*     */ import com.facebook.FacebookButtonBase;
/*     */ import com.facebook.FacebookCallback;
/*     */ import com.facebook.FacebookSdk;
/*     */ import com.facebook.internal.FacebookDialogBase;
/*     */ import com.facebook.share.Sharer.Result;
/*     */ import com.facebook.share.internal.ShareInternalUtility;
/*     */ import com.facebook.share.model.ShareContent;
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
/*     */ public abstract class ShareButtonBase
/*     */   extends FacebookButtonBase
/*     */ {
/*     */   private ShareContent shareContent;
/*  41 */   private int requestCode = 0;
/*  42 */   private boolean enabledExplicitlySet = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected ShareButtonBase(Context context, AttributeSet attrs, int defStyleAttr, String analyticsButtonCreatedEventName, String analyticsButtonTappedEventName)
/*     */   {
/*  50 */     super(context, attrs, defStyleAttr, 0, analyticsButtonCreatedEventName, analyticsButtonTappedEventName);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  57 */     this.requestCode = (isInEditMode() ? 0 : getDefaultRequestCode());
/*  58 */     internalSetEnabled(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ShareContent getShareContent()
/*     */   {
/*  66 */     return this.shareContent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setShareContent(ShareContent shareContent)
/*     */   {
/*  74 */     this.shareContent = shareContent;
/*  75 */     if (!this.enabledExplicitlySet) {
/*  76 */       internalSetEnabled(canShare());
/*     */     }
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled)
/*     */   {
/*  82 */     super.setEnabled(enabled);
/*  83 */     this.enabledExplicitlySet = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRequestCode()
/*     */   {
/*  93 */     return this.requestCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setRequestCode(int requestCode)
/*     */   {
/* 105 */     if (FacebookSdk.isFacebookRequestCode(requestCode)) {
/* 106 */       throw new IllegalArgumentException("Request code " + requestCode + " cannot be within the range reserved by the Facebook SDK.");
/*     */     }
/*     */     
/* 109 */     this.requestCode = requestCode;
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
/*     */   public void registerCallback(CallbackManager callbackManager, FacebookCallback<Sharer.Result> callback)
/*     */   {
/* 125 */     ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager, callback);
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
/*     */   public void registerCallback(CallbackManager callbackManager, FacebookCallback<Sharer.Result> callback, int requestCode)
/*     */   {
/* 145 */     setRequestCode(requestCode);
/* 146 */     registerCallback(callbackManager, callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void configureButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
/*     */   {
/* 155 */     super.configureButton(context, attrs, defStyleAttr, defStyleRes);
/* 156 */     setInternalOnClickListener(getShareOnClickListener());
/*     */   }
/*     */   
/*     */   protected boolean canShare() {
/* 160 */     return getDialog().canShow(getShareContent());
/*     */   }
/*     */   
/*     */   protected OnClickListener getShareOnClickListener() {
/* 164 */     new OnClickListener()
/*     */     {
/*     */       public void onClick(View v) {
/* 167 */         ShareButtonBase.this.callExternalOnClickListener(v);
/* 168 */         ShareButtonBase.this.getDialog().show(ShareButtonBase.this.getShareContent());
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   protected abstract FacebookDialogBase<ShareContent, Sharer.Result> getDialog();
/*     */   
/*     */   private void internalSetEnabled(boolean enabled) {
/* 176 */     setEnabled(enabled);
/* 177 */     this.enabledExplicitlySet = false;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/ShareButtonBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */