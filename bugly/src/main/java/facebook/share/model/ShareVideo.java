/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.annotation.Nullable;
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
/*     */ public final class ShareVideo
/*     */   extends ShareMedia
/*     */ {
/*     */   private final Uri localUrl;
/*     */   
/*     */   private ShareVideo(Builder builder)
/*     */   {
/*  37 */     super(builder);
/*  38 */     this.localUrl = builder.localUrl;
/*     */   }
/*     */   
/*     */   ShareVideo(Parcel in) {
/*  42 */     super(in);
/*  43 */     this.localUrl = ((Uri)in.readParcelable(Uri.class.getClassLoader()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public Uri getLocalUrl()
/*     */   {
/*  52 */     return this.localUrl;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/*  56 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/*  60 */     super.writeToParcel(out, flags);
/*  61 */     out.writeParcelable(this.localUrl, 0);
/*     */   }
/*     */   
/*  64 */   public static final Parcelable.Creator<ShareVideo> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */ 
/*     */     public ShareVideo createFromParcel(Parcel source)
/*     */     {
/*  69 */       return new ShareVideo(source);
/*     */     }
/*     */     
/*     */     public ShareVideo[] newArray(int size)
/*     */     {
/*  74 */       return new ShareVideo[size];
/*     */     }
/*     */   };
/*     */   
/*     */   public Type getMediaType()
/*     */   {
/*  80 */     return Type.VIDEO;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final class Builder
/*     */     extends ShareMedia.Builder<ShareVideo, Builder>
/*     */   {
/*     */     private Uri localUrl;
/*     */     
/*     */ 
/*     */ 
/*     */     public Builder setLocalUrl(@Nullable Uri localUrl)
/*     */     {
/*  95 */       this.localUrl = localUrl;
/*  96 */       return this;
/*     */     }
/*     */     
/*     */     public ShareVideo build()
/*     */     {
/* 101 */       return new ShareVideo(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(ShareVideo model)
/*     */     {
/* 106 */       if (model == null) {
/* 107 */         return this;
/*     */       }
/*     */       
/* 110 */       return ((Builder)super.readFrom(model)).setLocalUrl(model.getLocalUrl());
/*     */     }
/*     */     
/*     */     Builder readFrom(Parcel parcel) {
/* 114 */       return readFrom(
/* 115 */         (ShareVideo)parcel.readParcelable(ShareVideo.class.getClassLoader()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareVideo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */