/*     */ package com.facebook;
/*     */ 
/*     */ import android.os.Handler;
/*     */ import java.util.AbstractList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
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
/*     */ public class GraphRequestBatch
/*     */   extends AbstractList<GraphRequest>
/*     */ {
/*  33 */   private static AtomicInteger idGenerator = new AtomicInteger();
/*     */   
/*     */   private Handler callbackHandler;
/*  36 */   private List<GraphRequest> requests = new ArrayList();
/*  37 */   private int timeoutInMilliseconds = 0;
/*  38 */   private final String id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
/*  39 */   private List<Callback> callbacks = new ArrayList();
/*     */   
/*     */   private String batchApplicationId;
/*     */   
/*     */ 
/*     */   public GraphRequestBatch()
/*     */   {
/*  46 */     this.requests = new ArrayList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GraphRequestBatch(Collection<GraphRequest> requests)
/*     */   {
/*  54 */     this.requests = new ArrayList(requests);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GraphRequestBatch(GraphRequest... requests)
/*     */   {
/*  62 */     this.requests = Arrays.asList(requests);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GraphRequestBatch(GraphRequestBatch requests)
/*     */   {
/*  70 */     this.requests = new ArrayList(requests);
/*  71 */     this.callbackHandler = requests.callbackHandler;
/*  72 */     this.timeoutInMilliseconds = requests.timeoutInMilliseconds;
/*  73 */     this.callbacks = new ArrayList(requests.callbacks);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTimeout()
/*     */   {
/*  81 */     return this.timeoutInMilliseconds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTimeout(int timeoutInMilliseconds)
/*     */   {
/*  89 */     if (timeoutInMilliseconds < 0) {
/*  90 */       throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
/*     */     }
/*  92 */     this.timeoutInMilliseconds = timeoutInMilliseconds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addCallback(Callback callback)
/*     */   {
/* 102 */     if (!this.callbacks.contains(callback)) {
/* 103 */       this.callbacks.add(callback);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeCallback(Callback callback)
/*     */   {
/* 113 */     this.callbacks.remove(callback);
/*     */   }
/*     */   
/*     */   public final boolean add(GraphRequest request)
/*     */   {
/* 118 */     return this.requests.add(request);
/*     */   }
/*     */   
/*     */   public final void add(int location, GraphRequest request)
/*     */   {
/* 123 */     this.requests.add(location, request);
/*     */   }
/*     */   
/*     */   public final void clear()
/*     */   {
/* 128 */     this.requests.clear();
/*     */   }
/*     */   
/*     */   public final GraphRequest get(int i)
/*     */   {
/* 133 */     return (GraphRequest)this.requests.get(i);
/*     */   }
/*     */   
/*     */   public final GraphRequest remove(int location)
/*     */   {
/* 138 */     return (GraphRequest)this.requests.remove(location);
/*     */   }
/*     */   
/*     */   public final GraphRequest set(int location, GraphRequest request)
/*     */   {
/* 143 */     return (GraphRequest)this.requests.set(location, request);
/*     */   }
/*     */   
/*     */   public final int size()
/*     */   {
/* 148 */     return this.requests.size();
/*     */   }
/*     */   
/*     */   final String getId() {
/* 152 */     return this.id;
/*     */   }
/*     */   
/*     */   final Handler getCallbackHandler() {
/* 156 */     return this.callbackHandler;
/*     */   }
/*     */   
/*     */   final void setCallbackHandler(Handler callbackHandler) {
/* 160 */     this.callbackHandler = callbackHandler;
/*     */   }
/*     */   
/*     */   final List<GraphRequest> getRequests() {
/* 164 */     return this.requests;
/*     */   }
/*     */   
/*     */   final List<Callback> getCallbacks() {
/* 168 */     return this.callbacks;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String getBatchApplicationId()
/*     */   {
/* 176 */     return this.batchApplicationId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void setBatchApplicationId(String batchApplicationId)
/*     */   {
/* 184 */     this.batchApplicationId = batchApplicationId;
/*     */   }
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
/*     */   public final List<GraphResponse> executeAndWait()
/*     */   {
/* 201 */     return executeAndWaitImpl();
/*     */   }
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
/*     */   public final GraphRequestAsyncTask executeAsync()
/*     */   {
/* 218 */     return executeAsyncImpl();
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<GraphResponse> executeAndWaitImpl()
/*     */   {
/* 252 */     return GraphRequest.executeBatchAndWait(this);
/*     */   }
/*     */   
/*     */   GraphRequestAsyncTask executeAsyncImpl() {
/* 256 */     return GraphRequest.executeBatchAsync(this);
/*     */   }
/*     */   
/*     */   public static abstract interface OnProgressCallback
/*     */     extends Callback
/*     */   {
/*     */     public abstract void onBatchProgress(GraphRequestBatch paramGraphRequestBatch, long
        paramLong1, long paramLong2);
/*     */   }
/*     */   
/*     */   public static abstract interface Callback
/*     */   {
/*     */     public abstract void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/GraphRequestBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */