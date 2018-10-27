/*    */ package com.facebook.internal;
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
/*    */ public class InternalSettings
/*    */ {
/*    */   private static volatile String mCustomUserAgent;
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
/*    */   public static void setCustomUserAgent(String customUserAgent)
/*    */   {
/* 33 */     mCustomUserAgent = customUserAgent;
/*    */   }
/*    */   
/*    */   public static String getCustomUserAgent() {
/* 37 */     return mCustomUserAgent;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/InternalSettings.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */