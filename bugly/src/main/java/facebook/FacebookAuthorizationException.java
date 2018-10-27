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
/*    */ public class FacebookAuthorizationException
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
/*    */ 
/*    */   public FacebookAuthorizationException() {}
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
/*    */   public FacebookAuthorizationException(String message)
/*    */   {
/* 44 */     super(message);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public FacebookAuthorizationException(String message, Throwable throwable)
/*    */   {
/* 57 */     super(message, throwable);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public FacebookAuthorizationException(Throwable throwable)
/*    */   {
/* 67 */     super(throwable);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookAuthorizationException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */