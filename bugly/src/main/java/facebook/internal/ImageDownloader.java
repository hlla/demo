/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.graphics.Bitmap;
/*     */ import android.graphics.BitmapFactory;
/*     */ import android.net.Uri;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import com.facebook.FacebookException;
/*     */ import com.facebook.R.string;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImageDownloader
/*     */ {
/*     */   private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
/*     */   private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
/*     */   private static Handler handler;
/*  49 */   private static WorkQueue downloadQueue = new WorkQueue(8);
/*  50 */   private static WorkQueue cacheReadQueue = new WorkQueue(2);
/*     */   
/*  52 */   private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void downloadAsync(ImageRequest request)
/*     */   {
/*  60 */     if (request == null) {
/*  61 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  70 */     RequestKey key = new RequestKey(request.getImageUri(), request.getCallerTag());
/*  71 */     synchronized (pendingRequests) {
/*  72 */       DownloaderContext downloaderContext = (DownloaderContext)pendingRequests.get(key);
/*  73 */       if (downloaderContext != null) {
/*  74 */         downloaderContext.request = request;
/*  75 */         downloaderContext.isCancelled = false;
/*  76 */         downloaderContext.workItem.moveToFront();
/*     */       } else {
/*  78 */         enqueueCacheRead(request, key, request.isCachedRedirectAllowed());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean cancelRequest(ImageRequest request) {
/*  84 */     boolean cancelled = false;
/*  85 */     RequestKey key = new RequestKey(request.getImageUri(), request.getCallerTag());
/*  86 */     synchronized (pendingRequests) {
/*  87 */       DownloaderContext downloaderContext = (DownloaderContext)pendingRequests.get(key);
/*  88 */       if (downloaderContext != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  93 */         cancelled = true;
/*     */         
/*  95 */         if (downloaderContext.workItem.cancel()) {
/*  96 */           pendingRequests.remove(key);
/*     */         }
/*     */         else
/*     */         {
/* 100 */           downloaderContext.isCancelled = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 105 */     return cancelled;
/*     */   }
/*     */   
/*     */   public static void prioritizeRequest(ImageRequest request) {
/* 109 */     RequestKey key = new RequestKey(request.getImageUri(), request.getCallerTag());
/* 110 */     synchronized (pendingRequests) {
/* 111 */       DownloaderContext downloaderContext = (DownloaderContext)pendingRequests.get(key);
/* 112 */       if (downloaderContext != null) {
/* 113 */         downloaderContext.workItem.moveToFront();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void clearCache(Context context) {
/* 119 */     ImageResponseCache.clearCache(context);
/* 120 */     UrlRedirectCache.clearCache();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void enqueueCacheRead(ImageRequest request, RequestKey key, boolean allowCachedRedirects)
/*     */   {
/* 127 */     enqueueRequest(request, key, cacheReadQueue, new CacheReadWorkItem(request
/*     */     
/*     */ 
/*     */ 
/* 131 */       .getContext(), key, allowCachedRedirects));
/*     */   }
/*     */   
/*     */   private static void enqueueDownload(ImageRequest request, RequestKey key) {
/* 135 */     enqueueRequest(request, key, downloadQueue, new DownloadImageWorkItem(request
/*     */     
/*     */ 
/*     */ 
/* 139 */       .getContext(), key));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void enqueueRequest(ImageRequest request, RequestKey key, WorkQueue workQueue, Runnable workItem)
/*     */   {
/* 147 */     synchronized (pendingRequests) {
/* 148 */       DownloaderContext downloaderContext = new DownloaderContext(null);
/* 149 */       downloaderContext.request = request;
/* 150 */       pendingRequests.put(key, downloaderContext);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 160 */       downloaderContext.workItem = workQueue.addActiveWorkItem(workItem);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void issueResponse(RequestKey key, final Exception error, final Bitmap bitmap, final boolean isCachedRedirect)
/*     */   {
/* 171 */     DownloaderContext completedRequestContext = removePendingRequest(key);
/* 172 */     if ((completedRequestContext != null) && (!completedRequestContext.isCancelled)) {
/* 173 */       ImageRequest request = completedRequestContext.request;
/* 174 */       final ImageRequest.Callback callback = request.getCallback();
/* 175 */       if (callback != null) {
/* 176 */         getHandler().post(new Runnable()
/*     */         {
/*     */           public void run() {
/* 179 */             ImageResponse response = new ImageResponse(this.val$request, error, isCachedRedirect, bitmap);
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 184 */             callback.onCompleted(response);
/*     */           }
/*     */         });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void readFromCache(RequestKey key, Context context, boolean allowCachedRedirects)
/*     */   {
/* 195 */     InputStream cachedStream = null;
/* 196 */     boolean isCachedRedirect = false;
/* 197 */     if (allowCachedRedirects) {
/* 198 */       Uri redirectUri = UrlRedirectCache.getRedirectedUri(key.uri);
/* 199 */       if (redirectUri != null) {
/* 200 */         cachedStream = ImageResponseCache.getCachedImageStream(redirectUri, context);
/* 201 */         isCachedRedirect = cachedStream != null;
/*     */       }
/*     */     }
/*     */     
/* 205 */     if (!isCachedRedirect) {
/* 206 */       cachedStream = ImageResponseCache.getCachedImageStream(key.uri, context);
/*     */     }
/*     */     
/* 209 */     if (cachedStream != null)
/*     */     {
/* 211 */       Bitmap bitmap = BitmapFactory.decodeStream(cachedStream);
/* 212 */       Utility.closeQuietly(cachedStream);
/* 213 */       issueResponse(key, null, bitmap, isCachedRedirect);
/*     */     }
/*     */     else
/*     */     {
/* 217 */       DownloaderContext downloaderContext = removePendingRequest(key);
/* 218 */       if ((downloaderContext != null) && (!downloaderContext.isCancelled)) {
/* 219 */         enqueueDownload(downloaderContext.request, key);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void download(RequestKey key, Context context) {
/* 225 */     HttpURLConnection connection = null;
/* 226 */     InputStream stream = null;
/* 227 */     Exception error = null;
/* 228 */     Bitmap bitmap = null;
/* 229 */     boolean issueResponse = true;
/*     */     try
/*     */     {
/* 232 */       URL url = new URL(key.uri.toString());
/* 233 */       connection = (HttpURLConnection)url.openConnection();
/* 234 */       connection.setInstanceFollowRedirects(false);
/*     */       
/* 236 */       switch (connection.getResponseCode())
/*     */       {
/*     */       case 301: 
/*     */       case 302: 
/* 240 */         issueResponse = false;
/*     */         
/* 242 */         String redirectLocation = connection.getHeaderField("location");
/* 243 */         if (!Utility.isNullOrEmpty(redirectLocation)) {
/* 244 */           Uri redirectUri = Uri.parse(redirectLocation);
/* 245 */           UrlRedirectCache.cacheUriRedirect(key.uri, redirectUri);
/*     */           
/*     */ 
/*     */ 
/* 249 */           DownloaderContext downloaderContext = removePendingRequest(key);
/* 250 */           if ((downloaderContext != null) && (!downloaderContext.isCancelled)) {
/* 251 */             enqueueCacheRead(downloaderContext.request, new RequestKey(redirectUri, key.tag), false);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 256 */         break;
/*     */       
/*     */ 
/*     */ 
/*     */       case 200: 
/* 261 */         stream = ImageResponseCache.interceptAndCacheImageStream(context, connection);
/* 262 */         bitmap = BitmapFactory.decodeStream(stream);
/* 263 */         break;
/*     */       
/*     */       default: 
/* 266 */         stream = connection.getErrorStream();
/* 267 */         StringBuilder errorMessageBuilder = new StringBuilder();
/* 268 */         if (stream != null) {
/* 269 */           InputStreamReader reader = new InputStreamReader(stream);
/* 270 */           char[] buffer = new char[''];
/*     */           int bufferLength;
/* 272 */           while ((bufferLength = reader.read(buffer, 0, buffer.length)) > 0) {
/* 273 */             errorMessageBuilder.append(buffer, 0, bufferLength);
/*     */           }
/* 275 */           Utility.closeQuietly(reader);
/*     */         } else {
/* 277 */           errorMessageBuilder.append(context
/* 278 */             .getString(R.string.com_facebook_image_download_unknown_error));
/*     */         }
/* 280 */         error = new FacebookException(errorMessageBuilder.toString());
/*     */       }
/*     */     }
/*     */     catch (IOException e) {
/* 284 */       error = e;
/*     */     } finally {
/* 286 */       Utility.closeQuietly(stream);
/* 287 */       Utility.disconnectQuietly(connection);
/*     */     }
/*     */     
/* 290 */     if (issueResponse) {
/* 291 */       issueResponse(key, error, bitmap, false);
/*     */     }
/*     */   }
/*     */   
/*     */   private static synchronized Handler getHandler() {
/* 296 */     if (handler == null) {
/* 297 */       handler = new Handler(Looper.getMainLooper());
/*     */     }
/* 299 */     return handler;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private static DownloaderContext removePendingRequest(RequestKey key)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: getstatic 9	com/facebook/internal/ImageDownloader:pendingRequests	Ljava/util/Map;
/*     */     //   3: dup
/*     */     //   4: astore_1
/*     */     //   5: monitorenter
/*     */     //   6: getstatic 9	com/facebook/internal/ImageDownloader:pendingRequests	Ljava/util/Map;
/*     */     //   9: aload_0
/*     */     //   10: invokeinterface 19 2 0
/*     */     //   15: checkcast 11	com/facebook/internal/ImageDownloader$DownloaderContext
/*     */     //   18: aload_1
/*     */     //   19: monitorexit
/*     */     //   20: areturn
/*     */     //   21: astore_2
/*     */     //   22: aload_1
/*     */     //   23: monitorexit
/*     */     //   24: aload_2
/*     */     //   25: athrow
/*     */     // Line number table:
/*     */     //   Java source line #303	-> byte code offset #0
/*     */     //   Java source line #304	-> byte code offset #6
/*     */     //   Java source line #305	-> byte code offset #21
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	26	0	key	RequestKey
/*     */     //   4	19	1	Ljava/lang/Object;	Object
/*     */     //   21	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	20	21	finally
/*     */     //   21	24	21	finally
/*     */   }
/*     */   
/*     */   private static class RequestKey
/*     */   {
/*     */     private static final int HASH_SEED = 29;
/*     */     private static final int HASH_MULTIPLIER = 37;
/*     */     Uri uri;
/*     */     Object tag;
/*     */     
/*     */     RequestKey(Uri url, Object tag)
/*     */     {
/* 316 */       this.uri = url;
/* 317 */       this.tag = tag;
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/* 322 */       int result = 29;
/*     */       
/* 324 */       result = result * 37 + this.uri.hashCode();
/* 325 */       result = result * 37 + this.tag.hashCode();
/*     */       
/* 327 */       return result;
/*     */     }
/*     */     
/*     */     public boolean equals(Object o)
/*     */     {
/* 332 */       boolean isEqual = false;
/*     */       
/* 334 */       if ((o != null) && ((o instanceof RequestKey))) {
/* 335 */         RequestKey compareTo = (RequestKey)o;
/* 336 */         isEqual = (compareTo.uri == this.uri) && (compareTo.tag == this.tag);
/*     */       }
/*     */       
/* 339 */       return isEqual;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class DownloaderContext {
/*     */     WorkQueue.WorkItem workItem;
/*     */     ImageRequest request;
/*     */     boolean isCancelled;
/*     */   }
/*     */   
/*     */   private static class CacheReadWorkItem implements Runnable {
/*     */     private Context context;
/*     */     private RequestKey key;
/*     */     private boolean allowCachedRedirects;
/*     */     
/*     */     CacheReadWorkItem(Context context, RequestKey key, boolean allowCachedRedirects) {
/* 355 */       this.context = context;
/* 356 */       this.key = key;
/* 357 */       this.allowCachedRedirects = allowCachedRedirects;
/*     */     }
/*     */     
/*     */     public void run()
/*     */     {
/* 362 */       ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class DownloadImageWorkItem implements Runnable {
/*     */     private Context context;
/*     */     private RequestKey key;
/*     */     
/*     */     DownloadImageWorkItem(Context context, RequestKey key) {
/* 371 */       this.context = context;
/* 372 */       this.key = key;
/*     */     }
/*     */     
/*     */     public void run()
/*     */     {
/* 377 */       ImageDownloader.download(this.key, this.context);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/ImageDownloader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */