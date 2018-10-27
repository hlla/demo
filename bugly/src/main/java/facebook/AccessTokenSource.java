/*    */ package com.facebook;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum AccessTokenSource
/*    */ {
/* 30 */   NONE(false), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 35 */   FACEBOOK_APPLICATION_WEB(true), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 40 */   FACEBOOK_APPLICATION_NATIVE(true), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 46 */   FACEBOOK_APPLICATION_SERVICE(true), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   WEB_VIEW(true), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 56 */   CHROME_CUSTOM_TAB(true), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 61 */   TEST_USER(true), 
/*    */   
/*    */ 
/*    */ 
/* 65 */   CLIENT_TOKEN(true), 
/*    */   
/*    */ 
/*    */ 
/* 69 */   DEVICE_AUTH(true);
/*    */   
/*    */   private final boolean canExtendToken;
/*    */   
/*    */   private AccessTokenSource(boolean canExtendToken) {
/* 74 */     this.canExtendToken = canExtendToken;
/*    */   }
/*    */   
/*    */   boolean canExtendToken() {
/* 78 */     return this.canExtendToken;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/AccessTokenSource.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */