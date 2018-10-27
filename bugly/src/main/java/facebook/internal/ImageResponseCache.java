/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.Uri;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
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
/*     */ class ImageResponseCache
/*     */ {
/*  39 */   static final String TAG = ImageResponseCache.class.getSimpleName();
/*     */   private static volatile FileLruCache imageCache;
/*     */   
/*     */   static synchronized FileLruCache getCache(Context context) throws IOException
/*     */   {
/*  44 */     if (imageCache == null) {
/*  45 */       imageCache = new FileLruCache(TAG, new FileLruCache.Limits());
/*     */     }
/*  47 */     return imageCache;
/*     */   }
/*     */   
/*     */ 
/*     */   static InputStream getCachedImageStream(Uri uri, Context context)
/*     */   {
/*  53 */     InputStream imageStream = null;
/*  54 */     if ((uri != null) && 
/*  55 */       (isCDNURL(uri))) {
/*     */       try {
/*  57 */         FileLruCache cache = getCache(context);
/*  58 */         imageStream = cache.get(uri.toString());
/*     */       } catch (IOException e) {
/*  60 */         Logger.log(LoggingBehavior.CACHE, 5, TAG, e.toString());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  65 */     return imageStream;
/*     */   }
/*     */   
/*     */ 
/*     */   static InputStream interceptAndCacheImageStream(Context context, HttpURLConnection connection)
/*     */     throws IOException
/*     */   {
/*  72 */     InputStream stream = null;
/*  73 */     if (connection.getResponseCode() == 200) {
/*  74 */       Uri uri = Uri.parse(connection.getURL().toString());
/*  75 */       stream = connection.getInputStream();
/*     */       try {
/*  77 */         if (isCDNURL(uri)) {
/*  78 */           FileLruCache cache = getCache(context);
/*     */           
/*     */ 
/*  81 */           stream = cache.interceptAndPut(uri
/*  82 */             .toString(), new BufferedHttpInputStream(stream, connection));
/*     */         }
/*     */       }
/*     */       catch (IOException localIOException) {}
/*     */     }
/*     */     
/*     */ 
/*  89 */     return stream;
/*     */   }
/*     */   
/*     */   private static boolean isCDNURL(Uri uri) {
/*  93 */     if (uri != null) {
/*  94 */       String uriHost = uri.getHost();
/*     */       
/*  96 */       if (uriHost.endsWith("fbcdn.net")) {
/*  97 */         return true;
/*     */       }
/*     */       
/* 100 */       if ((uriHost.startsWith("fbcdn")) && (uriHost.endsWith("akamaihd.net"))) {
/* 101 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 105 */     return false;
/*     */   }
/*     */   
/*     */   static void clearCache(Context context) {
/*     */     try {
/* 110 */       getCache(context).clearCache();
/*     */     } catch (IOException e) {
/* 112 */       Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e.getMessage());
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BufferedHttpInputStream extends BufferedInputStream {
/*     */     HttpURLConnection connection;
/*     */     
/* 119 */     BufferedHttpInputStream(InputStream stream, HttpURLConnection connection) { super(8192);
/* 120 */       this.connection = connection;
/*     */     }
/*     */     
/*     */     public void close() throws IOException
/*     */     {
/* 125 */       super.close();
/* 126 */       Utility.disconnectQuietly(this.connection);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/ImageResponseCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */