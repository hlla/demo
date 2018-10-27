/*     */ package com.facebook.login.widget;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.Uri;
/*     */ import android.util.AttributeSet;
/*     */ import com.facebook.login.DeviceLoginManager;
/*     */ import com.facebook.login.LoginBehavior;
/*     */ import com.facebook.login.LoginManager;
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
/*     */ public class DeviceLoginButton
/*     */   extends LoginButton
/*     */ {
/*     */   private Uri deviceRedirectUri;
/*     */   
/*     */   public DeviceLoginButton(Context context, AttributeSet attrs, int defStyle)
/*     */   {
/*  47 */     super(context, attrs, defStyle);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DeviceLoginButton(Context context, AttributeSet attrs)
/*     */   {
/*  56 */     super(context, attrs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DeviceLoginButton(Context context)
/*     */   {
/*  65 */     super(context);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDeviceRedirectUri(Uri uri)
/*     */   {
/*  77 */     this.deviceRedirectUri = uri;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Uri getDeviceRedirectUri()
/*     */   {
/*  89 */     return this.deviceRedirectUri;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*  94 */   protected LoginClickListener getNewLoginClickListener() { return new DeviceLoginClickListener(null); }
/*     */   
/*     */   private class DeviceLoginClickListener extends LoginClickListener {
/*  97 */     private DeviceLoginClickListener() { super(); }
/*     */     
/*     */     protected LoginManager getLoginManager() {
/* 100 */       DeviceLoginManager manager = DeviceLoginManager.getInstance();
/* 101 */       manager.setDefaultAudience(DeviceLoginButton.this.getDefaultAudience());
/* 102 */       manager.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
/* 103 */       manager.setDeviceRedirectUri(DeviceLoginButton.this.getDeviceRedirectUri());
/* 104 */       return manager;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/widget/DeviceLoginButton.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */