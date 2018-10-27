/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.annotation.Nullable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
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
/*     */ public final class SharePhotoContent
/*     */   extends ShareContent<SharePhotoContent, Builder>
/*     */ {
/*     */   private final List<SharePhoto> photos;
/*     */   
/*     */   private SharePhotoContent(Builder builder)
/*     */   {
/*  40 */     super(builder);
/*  41 */     this.photos = Collections.unmodifiableList(builder.photos);
/*     */   }
/*     */   
/*     */   SharePhotoContent(Parcel in) {
/*  45 */     super(in);
/*     */     
/*  47 */     this.photos = Collections.unmodifiableList(SharePhoto.Builder.readPhotoListFrom(in));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public List<SharePhoto> getPhotos()
/*     */   {
/*  56 */     return this.photos;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/*  60 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/*  64 */     super.writeToParcel(out, flags);
/*  65 */     SharePhoto.Builder.writePhotoListTo(out, flags, this.photos);
/*     */   }
/*     */   
/*     */ 
/*  69 */   public static final Parcelable.Creator<SharePhotoContent> CREATOR = new Parcelable.Creator() {
/*     */     public SharePhotoContent createFromParcel(Parcel in) {
/*  71 */       return new SharePhotoContent(in);
/*     */     }
/*     */     
/*     */     public SharePhotoContent[] newArray(int size) {
/*  75 */       return new SharePhotoContent[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */   public static class Builder
/*     */     extends ShareContent.Builder<SharePhotoContent, Builder>
/*     */   {
/*  83 */     private final List<SharePhoto> photos = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder addPhoto(@Nullable SharePhoto photo)
/*     */     {
/*  91 */       if (photo != null) {
/*  92 */         this.photos.add(new SharePhoto.Builder().readFrom(photo).build());
/*     */       }
/*  94 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder addPhotos(@Nullable List<SharePhoto> photos)
/*     */     {
/* 104 */       if (photos != null) {
/* 105 */         for (SharePhoto photo : photos) {
/* 106 */           addPhoto(photo);
/*     */         }
/*     */       }
/* 109 */       return this;
/*     */     }
/*     */     
/*     */     public SharePhotoContent build()
/*     */     {
/* 114 */       return new SharePhotoContent(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(SharePhotoContent model)
/*     */     {
/* 119 */       if (model == null) {
/* 120 */         return this;
/*     */       }
/*     */       
/*     */ 
/* 124 */       return ((Builder)super.readFrom(model)).addPhotos(model.getPhotos());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setPhotos(@Nullable List<SharePhoto> photos)
/*     */     {
/* 133 */       this.photos.clear();
/* 134 */       addPhotos(photos);
/* 135 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/SharePhotoContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */