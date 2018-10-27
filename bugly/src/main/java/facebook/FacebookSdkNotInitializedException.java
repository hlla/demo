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
/*    */ public class FacebookSdkNotInitializedException
/*    */   extends FacebookException
/*    */ {
/*    */   static final long serialVersionUID = 1L;
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
/*    */   public FacebookSdkNotInitializedException() {}
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
/*    */   public FacebookSdkNotInitializedException(String message)
/*    */   {
/* 42 */     super(message);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public FacebookSdkNotInitializedException(String message, Throwable throwable)
/*    */   {
/* 52 */     super(message, throwable);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public FacebookSdkNotInitializedException(Throwable throwable)
/*    */   {
/* 61 */     super(throwable);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookSdkNotInitializedException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */