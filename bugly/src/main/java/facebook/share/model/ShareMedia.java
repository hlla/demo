/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import java.util.ArrayList;
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
/*     */ public abstract class ShareMedia
/*     */   implements ShareModel
/*     */ {
/*     */   private final Bundle params;
/*     */   
/*     */   public static enum Type
/*     */   {
/*  36 */     PHOTO, 
/*  37 */     VIDEO;
/*     */     
/*     */     private Type() {}
/*     */   }
/*     */   
/*     */   protected ShareMedia(Builder builder)
/*     */   {
/*  44 */     this.params = new Bundle(builder.params);
/*     */   }
/*     */   
/*     */   ShareMedia(Parcel in) {
/*  48 */     this.params = in.readBundle();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public Bundle getParameters()
/*     */   {
/*  56 */     return new Bundle(this.params);
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/*  61 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel dest, int flags)
/*     */   {
/*  66 */     dest.writeBundle(this.params);
/*     */   }
/*     */   
/*     */ 
/*     */   public abstract Type getMediaType();
/*     */   
/*     */ 
/*     */   public static abstract class Builder<M extends ShareMedia, B extends Builder>
/*     */     implements ShareModelBuilder<M, B>
/*     */   {
/*  76 */     private Bundle params = new Bundle();
/*     */     
/*     */ 
/*     */ 
/*     */     @Deprecated
/*     */     public B setParameter(String key, String value)
/*     */     {
/*  83 */       this.params.putString(key, value);
/*  84 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     @Deprecated
/*     */     public B setParameters(Bundle parameters)
/*     */     {
/*  92 */       this.params.putAll(parameters);
/*  93 */       return this;
/*     */     }
/*     */     
/*     */     public B readFrom(M model)
/*     */     {
/*  98 */       if (model == null) {
/*  99 */         return this;
/*     */       }
/* 101 */       return setParameters(model.getParameters());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     static void writeListTo(Parcel out, int parcelFlags, List<ShareMedia> media)
/*     */     {
/* 108 */       out.writeParcelableArray((ShareMedia[])media.toArray(), parcelFlags);
/*     */     }
/*     */     
/*     */     static List<ShareMedia> readListFrom(Parcel in) {
/* 112 */       Parcelable[] parcelables = in.readParcelableArray(ShareMedia.class
/* 113 */         .getClassLoader());
/* 114 */       List<ShareMedia> shareMedia = new ArrayList(parcelables.length);
/* 115 */       for (Parcelable parcelable : parcelables) {
/* 116 */         shareMedia.add((ShareMedia)parcelable);
/*     */       }
/* 118 */       return shareMedia;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareMedia.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */