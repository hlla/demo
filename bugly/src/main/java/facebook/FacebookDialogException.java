/*    */ package com.facebook;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FacebookDialogException
/*    */   extends FacebookException
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private int errorCode;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private String failingUrl;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public FacebookDialogException(String message, int errorCode, String failingUrl)
/*    */   {
/* 35 */     super(message);
/* 36 */     this.errorCode = errorCode;
/* 37 */     this.failingUrl = failingUrl;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getErrorCode()
/*    */   {
/* 47 */     return this.errorCode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getFailingUrl()
/*    */   {
/* 55 */     return this.failingUrl;
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
/*    */ 
/*    */   public final String toString()
/*    */   {
/* 69 */     return "{FacebookDialogException: " + "errorCode: " + getErrorCode() + ", message: " + getMessage() + ", url: " + getFailingUrl() + "}";
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookDialogException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */