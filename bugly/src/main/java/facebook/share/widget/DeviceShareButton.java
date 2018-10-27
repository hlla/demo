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
/*     */ import com.facebook.R.style;
/*     */ import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
/*     */ import com.facebook.share.DeviceShareDialog;
/*     */ import com.facebook.share.DeviceShareDialog.Result;
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
/*     */ 
/*     */ 
/*     */ public final class DeviceShareButton
/*     */   extends FacebookButtonBase
/*     */ {
/*     */   private ShareContent shareContent;
/*  44 */   private int requestCode = 0;
/*  45 */   private boolean enabledExplicitlySet = false;
/*  46 */   private DeviceShareDialog dialog = null;
/*     */   
/*     */ 
/*     */ 
/*     */   public DeviceShareButton(Context context)
/*     */   {
/*  52 */     this(context, null, 0);
/*     */   }
/*     */   
/*     */ 
/*     */   public DeviceShareButton(Context context, AttributeSet attrs)
/*     */   {
/*  58 */     this(context, attrs, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private DeviceShareButton(Context context, AttributeSet attrs, int defStyleAttr)
/*     */   {
/*  67 */     super(context, attrs, defStyleAttr, 0, "fb_device_share_button_create", "fb_device_share_button_did_tap");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  74 */     this.requestCode = (isInEditMode() ? 0 : getDefaultRequestCode());
/*  75 */     internalSetEnabled(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ShareContent getShareContent()
/*     */   {
/*  83 */     return this.shareContent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setShareContent(ShareContent shareContent)
/*     */   {
/*  91 */     this.shareContent = shareContent;
/*  92 */     if (!this.enabledExplicitlySet) {
/*  93 */       internalSetEnabled(canShare());
/*     */     }
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled)
/*     */   {
/*  99 */     super.setEnabled(enabled);
/* 100 */     this.enabledExplicitlySet = true;
/*     */   }
/*     */   
/*     */   public int getRequestCode() {
/* 104 */     return this.requestCode;
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
/*     */   public void registerCallback(CallbackManager callbackManager, FacebookCallback<DeviceShareDialog.Result> callback)
/*     */   {
/* 120 */     getDialog().registerCallback(callbackManager, callback);
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
/*     */   public void registerCallback(CallbackManager callbackManager, FacebookCallback<DeviceShareDialog.Result> callback, int requestCode)
/*     */   {
/* 140 */     setRequestCode(requestCode);
/* 141 */     getDialog().registerCallback(callbackManager, callback, requestCode);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void configureButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
/*     */   {
/* 150 */     super.configureButton(context, attrs, defStyleAttr, defStyleRes);
/* 151 */     setInternalOnClickListener(getShareOnClickListener());
/*     */   }
/*     */   
/*     */   protected int getDefaultStyleResource()
/*     */   {
/* 156 */     return R.style.com_facebook_button_share;
/*     */   }
/*     */   
/*     */   protected int getDefaultRequestCode()
/*     */   {
/* 161 */     return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
/*     */   }
/*     */   
/*     */   protected OnClickListener getShareOnClickListener() {
/* 165 */     new OnClickListener()
/*     */     {
/*     */       public void onClick(View v) {
/* 168 */         DeviceShareButton.this.callExternalOnClickListener(v);
/* 169 */         DeviceShareButton.this.getDialog().show(DeviceShareButton.this.getShareContent());
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   private void internalSetEnabled(boolean enabled) {
/* 175 */     setEnabled(enabled);
/* 176 */     this.enabledExplicitlySet = false;
/*     */   }
/*     */   
/*     */   private void setRequestCode(int requestCode) {
/* 180 */     if (FacebookSdk.isFacebookRequestCode(requestCode)) {
/* 181 */       throw new IllegalArgumentException("Request code " + requestCode + " cannot be within the range reserved by the Facebook SDK.");
/*     */     }
/*     */     
/* 184 */     this.requestCode = requestCode;
/*     */   }
/*     */   
/*     */   private boolean canShare() {
/* 188 */     return new DeviceShareDialog(getActivity()).canShow(getShareContent());
/*     */   }
/*     */   
/*     */   private DeviceShareDialog getDialog() {
/* 192 */     if (this.dialog != null) {
/* 193 */       return this.dialog;
/*     */     }
/* 195 */     if (getFragment() != null) {
/* 196 */       this.dialog = new DeviceShareDialog(getFragment());
/* 197 */     } else if (getNativeFragment() != null) {
/* 198 */       this.dialog = new DeviceShareDialog(getNativeFragment());
/*     */     } else {
/* 200 */       this.dialog = new DeviceShareDialog(getActivity());
/*     */     }
/* 202 */     return this.dialog;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/widget/DeviceShareButton.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */