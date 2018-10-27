/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import com.facebook.LoggingBehavior;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
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
/*     */ class UrlRedirectCache
/*     */ {
/*  38 */   static final String TAG = UrlRedirectCache.class.getSimpleName();
/*  39 */   private static final String REDIRECT_CONTENT_TAG = TAG + "_Redirect";
/*     */   private static volatile FileLruCache urlRedirectCache;
/*     */   
/*     */   static synchronized FileLruCache getCache() throws IOException
/*     */   {
/*  44 */     if (urlRedirectCache == null) {
/*  45 */       urlRedirectCache = new FileLruCache(TAG, new FileLruCache.Limits());
/*     */     }
/*  47 */     return urlRedirectCache;
/*     */   }
/*     */   
/*     */   static Uri getRedirectedUri(Uri uri) {
/*  51 */     if (uri == null) {
/*  52 */       return null;
/*     */     }
/*     */     
/*  55 */     String uriString = uri.toString();
/*  56 */     InputStreamReader reader = null;
/*     */     try
/*     */     {
/*  59 */       FileLruCache cache = getCache();
/*  60 */       boolean redirectExists = false;
/*  61 */       InputStream stream; char[] buffer; while ((stream = cache.get(uriString, REDIRECT_CONTENT_TAG)) != null) {
/*  62 */         redirectExists = true;
/*     */         
/*     */ 
/*  65 */         reader = new InputStreamReader(stream);
/*  66 */         buffer = new char[''];
/*     */         
/*  68 */         StringBuilder urlBuilder = new StringBuilder();
/*  69 */         int bufferLength; while ((bufferLength = reader.read(buffer, 0, buffer.length)) > 0) {
/*  70 */           urlBuilder.append(buffer, 0, bufferLength);
/*     */         }
/*  72 */         Utility.closeQuietly(reader);
/*     */         
/*     */ 
/*  75 */         uriString = urlBuilder.toString();
/*     */       }
/*     */       
/*  78 */       if (redirectExists) {
/*  79 */         return Uri.parse(uriString);
/*     */       }
/*     */     }
/*     */     catch (IOException localIOException) {}finally {
/*  83 */       Utility.closeQuietly(reader);
/*     */     }
/*     */     
/*  86 */     return null;
/*     */   }
/*     */   
/*     */   static void cacheUriRedirect(Uri fromUri, Uri toUri) {
/*  90 */     if ((fromUri == null) || (toUri == null)) {
/*  91 */       return;
/*     */     }
/*     */     
/*  94 */     OutputStream redirectStream = null;
/*     */     try {
/*  96 */       FileLruCache cache = getCache();
/*  97 */       redirectStream = cache.openPutStream(fromUri.toString(), REDIRECT_CONTENT_TAG);
/*  98 */       redirectStream.write(toUri.toString().getBytes());
/*     */     }
/*     */     catch (IOException localIOException) {}finally
/*     */     {
/* 102 */       Utility.closeQuietly(redirectStream);
/*     */     }
/*     */   }
/*     */   
/*     */   static void clearCache() {
/*     */     try {
/* 108 */       getCache().clearCache();
/*     */     } catch (IOException e) {
/* 110 */       Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e.getMessage());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/UrlRedirectCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */