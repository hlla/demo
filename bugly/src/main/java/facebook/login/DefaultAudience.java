/*    */ package com.facebook.login;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DefaultAudience
/*    */ {
/* 35 */   NONE(null), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 40 */   ONLY_ME("only_me"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 45 */   FRIENDS("friends"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 50 */   EVERYONE("everyone");
/*    */   
/*    */   private final String nativeProtocolAudience;
/*    */   
/*    */   private DefaultAudience(String protocol) {
/* 55 */     this.nativeProtocolAudience = protocol;
/*    */   }
/*    */   
/*    */   public String getNativeProtocolAudience() {
/* 59 */     return this.nativeProtocolAudience;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/DefaultAudience.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */