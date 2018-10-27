/*     */ package com.facebook.messenger;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ public class ShareToMessengerParams
/*     */ {
/*     */   public static final Set<String> VALID_URI_SCHEMES;
/*     */   public static final Set<String> VALID_MIME_TYPES;
/*     */   public static final Set<String> VALID_EXTERNAL_URI_SCHEMES;
/*     */   public final Uri uri;
/*     */   public final String mimeType;
/*     */   public final String metaData;
/*     */   public final Uri externalUri;
/*     */   
/*     */   static
/*     */   {
/*  41 */     Set<String> validMimeTypes = new HashSet();
/*  42 */     validMimeTypes.add("image/*");
/*  43 */     validMimeTypes.add("image/jpeg");
/*  44 */     validMimeTypes.add("image/png");
/*  45 */     validMimeTypes.add("image/gif");
/*  46 */     validMimeTypes.add("image/webp");
/*  47 */     validMimeTypes.add("video/*");
/*  48 */     validMimeTypes.add("video/mp4");
/*  49 */     validMimeTypes.add("audio/*");
/*  50 */     validMimeTypes.add("audio/mpeg");
/*  51 */     VALID_MIME_TYPES = Collections.unmodifiableSet(validMimeTypes);
/*     */     
/*  53 */     Set<String> validUriSchemes = new HashSet();
/*  54 */     validUriSchemes.add("content");
/*  55 */     validUriSchemes.add("android.resource");
/*  56 */     validUriSchemes.add("file");
/*  57 */     VALID_URI_SCHEMES = Collections.unmodifiableSet(validUriSchemes);
/*     */     
/*  59 */     Set<String> validExternalUriSchemes = new HashSet();
/*  60 */     validExternalUriSchemes.add("http");
/*  61 */     validExternalUriSchemes.add("https");
/*  62 */     VALID_EXTERNAL_URI_SCHEMES = Collections.unmodifiableSet(validExternalUriSchemes);
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
/*     */   ShareToMessengerParams(ShareToMessengerParamsBuilder builder)
/*     */   {
/*  94 */     this.uri = builder.getUri();
/*  95 */     this.mimeType = builder.getMimeType();
/*  96 */     this.metaData = builder.getMetaData();
/*  97 */     this.externalUri = builder.getExternalUri();
/*     */     
/*  99 */     if (this.uri == null) {
/* 100 */       throw new NullPointerException("Must provide non-null uri");
/*     */     }
/* 102 */     if (this.mimeType == null) {
/* 103 */       throw new NullPointerException("Must provide mimeType");
/*     */     }
/* 105 */     if (!VALID_URI_SCHEMES.contains(this.uri.getScheme())) {
/* 106 */       throw new IllegalArgumentException("Unsupported URI scheme: " + this.uri.getScheme());
/*     */     }
/* 108 */     if (!VALID_MIME_TYPES.contains(this.mimeType)) {
/* 109 */       throw new IllegalArgumentException("Unsupported mime-type: " + this.mimeType);
/*     */     }
/* 111 */     if ((this.externalUri != null) && 
/* 112 */       (!VALID_EXTERNAL_URI_SCHEMES.contains(this.externalUri.getScheme())))
/*     */     {
/* 114 */       throw new IllegalArgumentException("Unsupported external uri scheme: " + this.externalUri.getScheme());
/*     */     }
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
/*     */   public static ShareToMessengerParamsBuilder newBuilder(Uri uri, String mimeType)
/*     */   {
/* 128 */     return new ShareToMessengerParamsBuilder(uri, mimeType);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/messenger/ShareToMessengerParams.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */