/*     */ package com.facebook.login;
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
/*     */ public enum LoginBehavior
/*     */ {
/*  31 */   NATIVE_WITH_FALLBACK(true, true, true, false, true, true), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  37 */   NATIVE_ONLY(true, true, false, false, false, true), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  42 */   KATANA_ONLY(false, true, false, false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  47 */   WEB_ONLY(false, false, true, false, true, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  52 */   WEB_VIEW_ONLY(false, false, true, false, false, false), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  59 */   DEVICE_AUTH(false, false, false, true, false, false);
/*     */   
/*     */ 
/*     */   private final boolean allowsGetTokenAuth;
/*     */   
/*     */   private final boolean allowsKatanaAuth;
/*     */   
/*     */   private final boolean allowsWebViewAuth;
/*     */   
/*     */   private final boolean allowsDeviceAuth;
/*     */   
/*     */   private final boolean allowsCustomTabAuth;
/*     */   private final boolean allowsFacebookLiteAuth;
/*     */   
/*     */   private LoginBehavior(boolean allowsGetTokenAuth, boolean allowsKatanaAuth, boolean allowsWebViewAuth, boolean allowsDeviceAuth, boolean allowsCustomTabAuth, boolean allowsFacebookLiteAuth)
/*     */   {
/*  75 */     this.allowsGetTokenAuth = allowsGetTokenAuth;
/*  76 */     this.allowsKatanaAuth = allowsKatanaAuth;
/*  77 */     this.allowsWebViewAuth = allowsWebViewAuth;
/*  78 */     this.allowsDeviceAuth = allowsDeviceAuth;
/*  79 */     this.allowsCustomTabAuth = allowsCustomTabAuth;
/*  80 */     this.allowsFacebookLiteAuth = allowsFacebookLiteAuth;
/*     */   }
/*     */   
/*     */   boolean allowsGetTokenAuth() {
/*  84 */     return this.allowsGetTokenAuth;
/*     */   }
/*     */   
/*     */   boolean allowsKatanaAuth() {
/*  88 */     return this.allowsKatanaAuth;
/*     */   }
/*     */   
/*     */   boolean allowsWebViewAuth() {
/*  92 */     return this.allowsWebViewAuth;
/*     */   }
/*     */   
/*     */   boolean allowsDeviceAuth() {
/*  96 */     return this.allowsDeviceAuth;
/*     */   }
/*     */   
/*     */   boolean allowsCustomTabAuth() {
/* 100 */     return this.allowsCustomTabAuth;
/*     */   }
/*     */   
/*     */   boolean allowsFacebookLiteAuth() {
/* 104 */     return this.allowsFacebookLiteAuth;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/LoginBehavior.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */