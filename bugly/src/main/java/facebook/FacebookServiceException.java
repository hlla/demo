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
/*    */ public class FacebookServiceException
/*    */   extends FacebookException
/*    */ {
/*    */   private final FacebookRequestError error;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static final long serialVersionUID = 1L;
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
/*    */   public FacebookServiceException(FacebookRequestError error, String errorMessage)
/*    */   {
/* 38 */     super(errorMessage);
/* 39 */     this.error = error;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final FacebookRequestError getRequestError()
/*    */   {
/* 48 */     return this.error;
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
/*    */ 
/*    */ 
/*    */   public final String toString()
/*    */   {
/* 64 */     return "{FacebookServiceException: " + "httpResponseCode: " + this.error.getRequestStatusCode() + ", facebookErrorCode: " + this.error.getErrorCode() + ", facebookErrorType: " + this.error.getErrorType() + ", message: " + this.error.getErrorMessage() + "}";
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookServiceException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */