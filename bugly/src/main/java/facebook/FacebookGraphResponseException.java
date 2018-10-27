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
/*    */ public class FacebookGraphResponseException
/*    */   extends FacebookException
/*    */ {
/*    */   private final GraphResponse graphResponse;
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
/*    */   public FacebookGraphResponseException(GraphResponse graphResponse, String errorMessage)
/*    */   {
/* 37 */     super(errorMessage);
/* 38 */     this.graphResponse = graphResponse;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final GraphResponse getGraphResponse()
/*    */   {
/* 46 */     return this.graphResponse;
/*    */   }
/*    */   
/*    */   public final String toString()
/*    */   {
/* 51 */     FacebookRequestError requestError = this.graphResponse != null ? this.graphResponse.getError() : null;
/*    */     
/* 53 */     StringBuilder errorStringBuilder = new StringBuilder().append("{FacebookGraphResponseException: ");
/* 54 */     String message = getMessage();
/* 55 */     if (message != null) {
/* 56 */       errorStringBuilder.append(message);
/* 57 */       errorStringBuilder.append(" ");
/*    */     }
/* 59 */     if (requestError != null)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 68 */       errorStringBuilder.append("httpResponseCode: ").append(requestError.getRequestStatusCode()).append(", facebookErrorCode: ").append(requestError.getErrorCode()).append(", facebookErrorType: ").append(requestError.getErrorType()).append(", message: ").append(requestError.getErrorMessage()).append("}");
/*    */     }
/*    */     
/* 71 */     return errorStringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookGraphResponseException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */