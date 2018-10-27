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
/*    */ public class FacebookException
/*    */   extends RuntimeException
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
/*    */   public FacebookException() {}
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
/*    */   public FacebookException(String message)
/*    */   {
/* 42 */     super(message);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public FacebookException(String format, Object... args)
/*    */   {
/* 52 */     this(String.format(format, args));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public FacebookException(String message, Throwable throwable)
/*    */   {
/* 62 */     super(message, throwable);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public FacebookException(Throwable throwable)
/*    */   {
/* 71 */     super(throwable);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String toString()
/*    */   {
/* 78 */     return getMessage();
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/FacebookException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */