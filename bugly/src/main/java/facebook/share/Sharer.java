/*    */ package com.facebook.share;
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
/*    */ public abstract interface Sharer
/*    */ {
/*    */   public abstract boolean getShouldFailOnDataError();
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
/*    */   public abstract void setShouldFailOnDataError(boolean paramBoolean);
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
/*    */   public static class Result
/*    */   {
/*    */     final String postId;
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
/*    */     public Result(String postId)
/*    */     {
/* 57 */       this.postId = postId;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public String getPostId()
/*    */     {
/* 65 */       return this.postId;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/Sharer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */