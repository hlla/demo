/*    */ package com.facebook;
/*    */ 
/*    */ import android.os.Handler;
/*    */ import java.io.OutputStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ class ProgressNoopOutputStream
/*    */   extends OutputStream
/*    */   implements RequestOutputStream
/*    */ {
/* 30 */   private final Map<GraphRequest, RequestProgress> progressMap = new HashMap();
/*    */   private final Handler callbackHandler;
/*    */   private GraphRequest currentRequest;
/*    */   private RequestProgress currentRequestProgress;
/*    */   private int batchMax;
/*    */   
/*    */   ProgressNoopOutputStream(Handler callbackHandler)
/*    */   {
/* 38 */     this.callbackHandler = callbackHandler;
/*    */   }
/*    */   
/*    */   public void setCurrentRequest(GraphRequest currentRequest) {
/* 42 */     this.currentRequest = currentRequest;
/*    */     
/* 44 */     this.currentRequestProgress = (currentRequest != null ? (RequestProgress)this.progressMap.get(currentRequest) : null);
/*    */   }
/*    */   
/*    */   int getMaxProgress() {
/* 48 */     return this.batchMax;
/*    */   }
/*    */   
/*    */   Map<GraphRequest, RequestProgress> getProgressMap() {
/* 52 */     return this.progressMap;
/*    */   }
/*    */   
/*    */   void addProgress(long size) {
/* 56 */     if (this.currentRequestProgress == null) {
/* 57 */       this.currentRequestProgress = new RequestProgress(this.callbackHandler, this.currentRequest);
/* 58 */       this.progressMap.put(this.currentRequest, this.currentRequestProgress);
/*    */     }
/*    */     
/* 61 */     this.currentRequestProgress.addToMax(size);
/* 62 */     this.batchMax = ((int)(this.batchMax + size));
/*    */   }
/*    */   
/*    */   public void write(byte[] buffer)
/*    */   {
/* 67 */     addProgress(buffer.length);
/*    */   }
/*    */   
/*    */   public void write(byte[] buffer, int offset, int length)
/*    */   {
/* 72 */     addProgress(length);
/*    */   }
/*    */   
/*    */   public void write(int oneByte)
/*    */   {
/* 77 */     addProgress(1L);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/ProgressNoopOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */