/*     */ package com.facebook.internal;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.Uri;
/*     */ import android.net.Uri.Builder;
/*     */ import java.util.Locale;
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
/*     */ public class ImageRequest
/*     */ {
/*     */   public static final int UNSPECIFIED_DIMENSION = 0;
/*     */   private static final String SCHEME = "https";
/*     */   private static final String AUTHORITY = "graph.facebook.com";
/*     */   private static final String PATH = "%s/picture";
/*     */   private static final String HEIGHT_PARAM = "height";
/*     */   private static final String WIDTH_PARAM = "width";
/*     */   private static final String MIGRATION_PARAM = "migration_overrides";
/*     */   private static final String MIGRATION_VALUE = "{october_2012:true}";
/*     */   private Context context;
/*     */   private Uri imageUri;
/*     */   private Callback callback;
/*     */   private boolean allowCachedRedirects;
/*     */   private Object callerTag;
/*     */   
/*     */   public static Uri getProfilePictureUri(String userId, int width, int height)
/*     */   {
/*  65 */     Validate.notNullOrEmpty(userId, "userId");
/*     */     
/*  67 */     width = Math.max(width, 0);
/*  68 */     height = Math.max(height, 0);
/*     */     
/*  70 */     if ((width == 0) && (height == 0)) {
/*  71 */       throw new IllegalArgumentException("Either width or height must be greater than 0");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  78 */     Uri.Builder builder = new Uri.Builder().scheme("https").authority("graph.facebook.com").path(String.format(Locale.US, "%s/picture", new Object[] { userId }));
/*     */     
/*  80 */     if (height != 0) {
/*  81 */       builder.appendQueryParameter("height", String.valueOf(height));
/*     */     }
/*     */     
/*  84 */     if (width != 0) {
/*  85 */       builder.appendQueryParameter("width", String.valueOf(width));
/*     */     }
/*     */     
/*  88 */     builder.appendQueryParameter("migration_overrides", "{october_2012:true}");
/*     */     
/*  90 */     return builder.build();
/*     */   }
/*     */   
/*     */   private ImageRequest(Builder builder) {
/*  94 */     this.context = builder.context;
/*  95 */     this.imageUri = builder.imageUrl;
/*  96 */     this.callback = builder.callback;
/*  97 */     this.allowCachedRedirects = builder.allowCachedRedirects;
/*  98 */     this.callerTag = (builder.callerTag == null ? new Object() : builder.callerTag);
/*     */   }
/*     */   
/*     */   public Context getContext() {
/* 102 */     return this.context;
/*     */   }
/*     */   
/*     */   public Uri getImageUri() {
/* 106 */     return this.imageUri;
/*     */   }
/*     */   
/*     */   public Callback getCallback() {
/* 110 */     return this.callback;
/*     */   }
/*     */   
/*     */   public boolean isCachedRedirectAllowed() {
/* 114 */     return this.allowCachedRedirects;
/*     */   }
/*     */   
/*     */   public Object getCallerTag() {
/* 118 */     return this.callerTag;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class Builder
/*     */   {
/*     */     private Context context;
/*     */     private Uri imageUrl;
/*     */     private Callback callback;
/*     */     private boolean allowCachedRedirects;
/*     */     private Object callerTag;
/*     */     
/*     */     public Builder(Context context, Uri imageUri)
/*     */     {
/* 132 */       Validate.notNull(imageUri, "imageUri");
/* 133 */       this.context = context;
/* 134 */       this.imageUrl = imageUri;
/*     */     }
/*     */     
/*     */     public Builder setCallback(Callback callback) {
/* 138 */       this.callback = callback;
/* 139 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setCallerTag(Object callerTag) {
/* 143 */       this.callerTag = callerTag;
/* 144 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setAllowCachedRedirects(boolean allowCachedRedirects) {
/* 148 */       this.allowCachedRedirects = allowCachedRedirects;
/* 149 */       return this;
/*     */     }
/*     */     
/*     */     public ImageRequest build() {
/* 153 */       return new ImageRequest(this, null);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface Callback
/*     */   {
/*     */     public abstract void onCompleted(ImageResponse paramImageResponse);
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/ImageRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */