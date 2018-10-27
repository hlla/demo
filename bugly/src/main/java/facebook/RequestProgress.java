/*    */ package com.facebook;
/*    */ 
/*    */ import android.os.Handler;
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
/*    */ class RequestProgress
/*    */ {
/*    */   private final GraphRequest request;
/*    */   private final Handler callbackHandler;
/*    */   private final long threshold;
/*    */   private long progress;
/*    */   private long lastReportedProgress;
/*    */   private long maxProgress;
/*    */   
/*    */   RequestProgress(Handler callbackHandler, GraphRequest request)
/*    */   {
/* 33 */     this.request = request;
/* 34 */     this.callbackHandler = callbackHandler;
/*    */     
/* 36 */     this.threshold = FacebookSdk.getOnProgressThreshold();
/*    */   }
/*    */   
/*    */   long getProgress() {
/* 40 */     return this.progress;
/*    */   }
/*    */   
/*    */   long getMaxProgress() {
/* 44 */     return this.maxProgress;
/*    */   }
/*    */   
/*    */   void addProgress(long size) {
/* 48 */     this.progress += size;
/*    */     
/* 50 */     if ((this.progress >= this.lastReportedProgress + this.threshold) || (this.progress >= this.maxProgress)) {
/* 51 */       reportProgress();
/*    */     }
/*    */   }
/*    */   
/*    */   void addToMax(long size) {
/* 56 */     this.maxProgress += size;
/*    */   }
/*    */   
/*    */   void reportProgress() {
/* 60 */     if (this.progress > this.lastReportedProgress) {
/* 61 */       GraphRequest.Callback callback = this.request.getCallback();
/* 62 */       if ((this.maxProgress > 0L) && ((callback instanceof GraphRequest.OnProgressCallback)))
/*    */       {
/* 64 */         final long currentCopy = this.progress;
/* 65 */         long maxProgressCopy = this.maxProgress;
/* 66 */         final GraphRequest.OnProgressCallback callbackCopy = (GraphRequest.OnProgressCallback)callback;
/*    */         
/* 68 */         if (this.callbackHandler == null) {
/* 69 */           callbackCopy.onProgress(currentCopy, maxProgressCopy);
/*    */         }
/*    */         else {
/* 72 */           this.callbackHandler.post(new Runnable()
/*    */           {
/*    */             public void run() {
/* 75 */               callbackCopy.onProgress(currentCopy, this.val$maxProgressCopy);
/*    */             }
/*    */           });
/*    */         }
/* 79 */         this.lastReportedProgress = this.progress;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/RequestProgress.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */