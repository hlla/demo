/*     */ package com.facebook;
/*     */ 
/*     */ import android.os.Handler;
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ProgressOutputStream
/*     */   extends FilterOutputStream
/*     */   implements RequestOutputStream
/*     */ {
/*     */   private final Map<GraphRequest, RequestProgress> progressMap;
/*     */   private final GraphRequestBatch requests;
/*     */   private final long threshold;
/*     */   private long batchProgress;
/*     */   private long lastReportedProgress;
/*     */   private long maxProgress;
/*     */   private RequestProgress currentRequestProgress;
/*     */   
/*     */   ProgressOutputStream(OutputStream out, GraphRequestBatch requests, Map<GraphRequest, RequestProgress> progressMap, long maxProgress)
/*     */   {
/*  43 */     super(out);
/*  44 */     this.requests = requests;
/*  45 */     this.progressMap = progressMap;
/*  46 */     this.maxProgress = maxProgress;
/*     */     
/*  48 */     this.threshold = FacebookSdk.getOnProgressThreshold();
/*     */   }
/*     */   
/*     */   private void addProgress(long size) {
/*  52 */     if (this.currentRequestProgress != null) {
/*  53 */       this.currentRequestProgress.addProgress(size);
/*     */     }
/*     */     
/*  56 */     this.batchProgress += size;
/*     */     
/*  58 */     if ((this.batchProgress >= this.lastReportedProgress + this.threshold) || (this.batchProgress >= this.maxProgress)) {
/*  59 */       reportBatchProgress();
/*     */     }
/*     */   }
/*     */   
/*     */   private void reportBatchProgress() {
/*  64 */     if (this.batchProgress > this.lastReportedProgress) {
/*  65 */       for (GraphRequestBatch.Callback callback : this.requests.getCallbacks()) {
/*  66 */         if ((callback instanceof GraphRequestBatch.OnProgressCallback)) {
/*  67 */           Handler callbackHandler = this.requests.getCallbackHandler();
/*     */           
/*     */ 
/*  70 */           final GraphRequestBatch.OnProgressCallback progressCallback = (GraphRequestBatch.OnProgressCallback)callback;
/*     */           
/*  72 */           if (callbackHandler == null) {
/*  73 */             progressCallback.onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
/*     */           }
/*     */           else {
/*  76 */             callbackHandler.post(new Runnable()
/*     */             {
/*     */               public void run() {
/*  79 */                 progressCallback.onBatchProgress(
/*  80 */                   ProgressOutputStream.this.requests, 
/*  81 */                   ProgressOutputStream.this.batchProgress, 
/*  82 */                   ProgressOutputStream.this.maxProgress);
/*     */               }
/*     */             });
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  89 */       this.lastReportedProgress = this.batchProgress;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setCurrentRequest(GraphRequest request) {
/*  94 */     this.currentRequestProgress = (request != null ? (RequestProgress)this.progressMap.get(request) : null);
/*     */   }
/*     */   
/*     */   long getBatchProgress() {
/*  98 */     return this.batchProgress;
/*     */   }
/*     */   
/*     */   long getMaxProgress() {
/* 102 */     return this.maxProgress;
/*     */   }
/*     */   
/*     */   public void write(byte[] buffer) throws IOException
/*     */   {
/* 107 */     this.out.write(buffer);
/* 108 */     addProgress(buffer.length);
/*     */   }
/*     */   
/*     */   public void write(byte[] buffer, int offset, int length) throws IOException
/*     */   {
/* 113 */     this.out.write(buffer, offset, length);
/* 114 */     addProgress(length);
/*     */   }
/*     */   
/*     */   public void write(int oneByte) throws IOException
/*     */   {
/* 119 */     this.out.write(oneByte);
/* 120 */     addProgress(1L);
/*     */   }
/*     */   
/*     */   public void close() throws IOException
/*     */   {
/* 125 */     super.close();
/*     */     
/* 127 */     for (RequestProgress p : this.progressMap.values()) {
/* 128 */       p.reportProgress();
/*     */     }
/*     */     
/* 131 */     reportBatchProgress();
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/ProgressOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */