/*     */ package com.facebook;
/*     */ 
/*     */ import android.os.AsyncTask;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.Looper;
/*     */ import android.util.Log;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
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
/*     */ public class GraphRequestAsyncTask
/*     */   extends AsyncTask<Void, Void, List<GraphResponse>>
/*     */ {
/*  38 */   private static final String TAG = GraphRequestAsyncTask.class.getCanonicalName();
/*     */   
/*     */ 
/*     */   private final HttpURLConnection connection;
/*     */   
/*     */ 
/*     */   private final GraphRequestBatch requests;
/*     */   
/*     */ 
/*     */   private Exception exception;
/*     */   
/*     */ 
/*     */   public GraphRequestAsyncTask(GraphRequest... requests)
/*     */   {
/*  52 */     this(null, new GraphRequestBatch(requests));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GraphRequestAsyncTask(Collection<GraphRequest> requests)
/*     */   {
/*  62 */     this(null, new GraphRequestBatch(requests));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GraphRequestAsyncTask(GraphRequestBatch requests)
/*     */   {
/*  72 */     this(null, requests);
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
/*     */   public GraphRequestAsyncTask(HttpURLConnection connection, GraphRequest... requests)
/*     */   {
/*  85 */     this(connection, new GraphRequestBatch(requests));
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
/*     */   public GraphRequestAsyncTask(HttpURLConnection connection, Collection<GraphRequest> requests)
/*     */   {
/*  98 */     this(connection, new GraphRequestBatch(requests));
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
/*     */   public GraphRequestAsyncTask(HttpURLConnection connection, GraphRequestBatch requests)
/*     */   {
/* 111 */     this.requests = requests;
/* 112 */     this.connection = connection;
/*     */   }
/*     */   
/*     */   protected final Exception getException() {
/* 116 */     return this.exception;
/*     */   }
/*     */   
/*     */   protected final GraphRequestBatch getRequests() {
/* 120 */     return this.requests;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 132 */     return "{RequestAsyncTask: " + " connection: " + this.connection + ", requests: " + this.requests + "}";
/*     */   }
/*     */   
/*     */   protected void onPreExecute()
/*     */   {
/* 137 */     super.onPreExecute();
/* 138 */     if (FacebookSdk.isDebugEnabled()) {
/* 139 */       Log.d(TAG, String.format("execute async task: %s", new Object[] { this }));
/*     */     }
/* 141 */     if (this.requests.getCallbackHandler() == null)
/*     */     {
/*     */       Handler handler;
/*     */       Handler handler;
/* 145 */       if ((Thread.currentThread() instanceof HandlerThread)) {
/* 146 */         handler = new Handler();
/*     */       } else {
/* 148 */         handler = new Handler(Looper.getMainLooper());
/*     */       }
/* 150 */       this.requests.setCallbackHandler(handler);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onPostExecute(List<GraphResponse> result)
/*     */   {
/* 156 */     super.onPostExecute(result);
/*     */     
/* 158 */     if (this.exception != null) {
/* 159 */       Log.d(TAG, String.format("onPostExecute: exception encountered during request: %s", new Object[] {this.exception
/*     */       
/* 161 */         .getMessage() }));
/*     */     }
/*     */   }
/*     */   
/*     */   protected List<GraphResponse> doInBackground(Void... params)
/*     */   {
/*     */     try {
/* 168 */       if (this.connection == null) {
/* 169 */         return this.requests.executeAndWait();
/*     */       }
/* 171 */       return GraphRequest.executeConnectionAndWait(this.connection, this.requests);
/*     */     }
/*     */     catch (Exception e) {
/* 174 */       this.exception = e; }
/* 175 */     return null;
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/GraphRequestAsyncTask.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */