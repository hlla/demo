/*     */ package com.facebook.messenger;
/*     */ 
/*     */ import android.net.Uri;
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
/*     */ public class ShareToMessengerParamsBuilder
/*     */ {
/*     */   private final Uri mUri;
/*     */   private final String mMimeType;
/*     */   private String mMetaData;
/*     */   private Uri mExternalUri;
/*     */   
/*     */   ShareToMessengerParamsBuilder(Uri uri, String mimeType)
/*     */   {
/*  36 */     this.mUri = uri;
/*  37 */     this.mMimeType = mimeType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Uri getUri()
/*     */   {
/*  47 */     return this.mUri;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMimeType()
/*     */   {
/*  57 */     return this.mMimeType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ShareToMessengerParamsBuilder setMetaData(String metaData)
/*     */   {
/*  69 */     this.mMetaData = metaData;
/*  70 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMetaData()
/*     */   {
/*  81 */     return this.mMetaData;
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
/*     */   public ShareToMessengerParamsBuilder setExternalUri(Uri externalUri)
/*     */   {
/*  96 */     this.mExternalUri = externalUri;
/*  97 */     return this;
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
/*     */   public Uri getExternalUri()
/*     */   {
/* 111 */     return this.mExternalUri;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ShareToMessengerParams build()
/*     */   {
/* 120 */     return new ShareToMessengerParams(this);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/messenger/ShareToMessengerParamsBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */