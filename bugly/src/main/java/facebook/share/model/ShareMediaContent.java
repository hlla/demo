/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.annotation.Nullable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
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
/*     */ public final class ShareMediaContent
/*     */   extends ShareContent<ShareMediaContent, Builder>
/*     */ {
/*     */   private final List<ShareMedia> media;
/*     */   
/*     */   private ShareMediaContent(Builder builder)
/*     */   {
/*  36 */     super(builder);
/*  37 */     this.media = Collections.unmodifiableList(builder.media);
/*     */   }
/*     */   
/*     */   ShareMediaContent(Parcel in) {
/*  41 */     super(in);
/*  42 */     ShareMedia[] shareMedia = (ShareMedia[])in.readParcelableArray(ShareMedia.class
/*  43 */       .getClassLoader());
/*  44 */     this.media = Arrays.asList(shareMedia);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public List<ShareMedia> getMedia()
/*     */   {
/*  54 */     return this.media;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/*  58 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/*  62 */     super.writeToParcel(out, flags);
/*  63 */     out.writeParcelableArray((ShareMedia[])this.media.toArray(), flags);
/*     */   }
/*     */   
/*     */ 
/*  67 */   public static final Parcelable.Creator<ShareMediaContent> CREATOR = new Parcelable.Creator() {
/*     */     public ShareMediaContent createFromParcel(Parcel in) {
/*  69 */       return new ShareMediaContent(in);
/*     */     }
/*     */     
/*     */     public ShareMediaContent[] newArray(int size) {
/*  73 */       return new ShareMediaContent[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */   public static class Builder
/*     */     extends ShareContent.Builder<ShareMediaContent, Builder>
/*     */   {
/*  81 */     private final List<ShareMedia> media = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder addMedium(@Nullable ShareMedia medium)
/*     */     {
/*  90 */       if (medium != null) {
/*     */         ShareMedia mediumToAdd;
/*  92 */         if ((medium instanceof SharePhoto)) {
/*  93 */           mediumToAdd = new SharePhoto.Builder().readFrom((SharePhoto)medium).build(); } else { ShareMedia mediumToAdd;
/*  94 */           if ((medium instanceof ShareVideo)) {
/*  95 */             mediumToAdd = new ShareVideo.Builder().readFrom((ShareVideo)medium).build();
/*     */           } else
/*  97 */             throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
/*     */         }
/*     */         ShareMedia mediumToAdd;
/* 100 */         this.media.add(mediumToAdd);
/*     */       }
/* 102 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder addMedia(@Nullable List<ShareMedia> media)
/*     */     {
/* 113 */       if (media != null) {
/* 114 */         for (ShareMedia medium : media) {
/* 115 */           addMedium(medium);
/*     */         }
/*     */       }
/* 118 */       return this;
/*     */     }
/*     */     
/*     */     public ShareMediaContent build()
/*     */     {
/* 123 */       return new ShareMediaContent(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(ShareMediaContent model)
/*     */     {
/* 128 */       if (model == null) {
/* 129 */         return this;
/*     */       }
/*     */       
/*     */ 
/* 133 */       return ((Builder)super.readFrom(model)).addMedia(model.getMedia());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setMedia(@Nullable List<ShareMedia> media)
/*     */     {
/* 144 */       this.media.clear();
/* 145 */       addMedia(media);
/* 146 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareMediaContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */