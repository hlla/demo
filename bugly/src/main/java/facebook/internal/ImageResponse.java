/*    */ package com.facebook.internal;
/*    */ 
/*    */ import android.graphics.Bitmap;
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
/*    */ public class ImageResponse
/*    */ {
/*    */   private ImageRequest request;
/*    */   private Exception error;
/*    */   private boolean isCachedRedirect;
/*    */   private Bitmap bitmap;
/*    */   
/*    */   ImageResponse(ImageRequest request, Exception error, boolean isCachedRedirect, Bitmap bitmap)
/*    */   {
/* 38 */     this.request = request;
/* 39 */     this.error = error;
/* 40 */     this.bitmap = bitmap;
/* 41 */     this.isCachedRedirect = isCachedRedirect;
/*    */   }
/*    */   
/*    */   public ImageRequest getRequest() {
/* 45 */     return this.request;
/*    */   }
/*    */   
/*    */   public Exception getError() {
/* 49 */     return this.error;
/*    */   }
/*    */   
/*    */   public Bitmap getBitmap() {
/* 53 */     return this.bitmap;
/*    */   }
/*    */   
/*    */   public boolean isCachedRedirect() {
/* 57 */     return this.isCachedRedirect;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/ImageResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */