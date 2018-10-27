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
/*    */ public class FacebookOperationCanceledException
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
/*    */   public FacebookOperationCanceledException() {}
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
/*    */   public FacebookOperationCanceledException(String message)
/*    */   {
/* 42 */     super(message);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public FacebookOperationCanceledException(String message, Throwable throwable)
/*    */   {
/* 52 */     super(message, throwable);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public FacebookOperationCanceledException(Throwable throwable)
/*    */   {
/* 61 */     super(throwable);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookOperationCanceledException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */