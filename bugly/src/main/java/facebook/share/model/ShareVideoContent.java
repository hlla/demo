/*     */ package com.facebook.share.model;
/*     */ 
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
/*     */ 
/*     */ public final class ShareVideoContent
/*     */   extends ShareContent<ShareVideoContent, Builder>
/*     */   implements ShareModel
/*     */ {
/*     */   private final String contentDescription;
/*     */   private final String contentTitle;
/*     */   private final SharePhoto previewPhoto;
/*     */   private final ShareVideo video;
/*     */   
/*     */   private ShareVideoContent(Builder builder)
/*     */   {
/*  41 */     super(builder);
/*     */     
/*  43 */     this.contentDescription = builder.contentDescription;
/*  44 */     this.contentTitle = builder.contentTitle;
/*  45 */     this.previewPhoto = builder.previewPhoto;
/*  46 */     this.video = builder.video;
/*     */   }
/*     */   
/*     */   ShareVideoContent(Parcel in) {
/*  50 */     super(in);
/*  51 */     this.contentDescription = in.readString();
/*  52 */     this.contentTitle = in.readString();
/*  53 */     SharePhoto.Builder previewPhotoBuilder = new SharePhoto.Builder().readFrom(in);
/*  54 */     if ((previewPhotoBuilder.getImageUrl() != null) || (previewPhotoBuilder.getBitmap() != null)) {
/*  55 */       this.previewPhoto = previewPhotoBuilder.build();
/*     */     } else {
/*  57 */       this.previewPhoto = null;
/*     */     }
/*  59 */     this.video = new ShareVideo.Builder().readFrom(in).build();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public String getContentDescription()
/*     */   {
/*  68 */     return this.contentDescription;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public String getContentTitle()
/*     */   {
/*  77 */     return this.contentTitle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public SharePhoto getPreviewPhoto()
/*     */   {
/*  86 */     return this.previewPhoto;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public ShareVideo getVideo()
/*     */   {
/*  95 */     return this.video;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/*  99 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/* 103 */     super.writeToParcel(out, flags);
/* 104 */     out.writeString(this.contentDescription);
/* 105 */     out.writeString(this.contentTitle);
/* 106 */     out.writeParcelable(this.previewPhoto, 0);
/* 107 */     out.writeParcelable(this.video, 0);
/*     */   }
/*     */   
/*     */ 
/* 111 */   public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator() {
/*     */     public ShareVideoContent createFromParcel(Parcel in) {
/* 113 */       return new ShareVideoContent(in);
/*     */     }
/*     */     
/*     */     public ShareVideoContent[] newArray(int size) {
/* 117 */       return new ShareVideoContent[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */   public static final class Builder
/*     */     extends ShareContent.Builder<ShareVideoContent, Builder>
/*     */   {
/*     */     private String contentDescription;
/*     */     
/*     */     private String contentTitle;
/*     */     
/*     */     private SharePhoto previewPhoto;
/*     */     
/*     */     private ShareVideo video;
/*     */     
/*     */ 
/*     */     public Builder setContentDescription(@Nullable String contentDescription)
/*     */     {
/* 137 */       this.contentDescription = contentDescription;
/* 138 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setContentTitle(@Nullable String contentTitle)
/*     */     {
/* 147 */       this.contentTitle = contentTitle;
/* 148 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setPreviewPhoto(@Nullable SharePhoto previewPhoto)
/*     */     {
/* 160 */       this.previewPhoto = (previewPhoto == null ? null : new SharePhoto.Builder().readFrom(previewPhoto).build());
/* 161 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setVideo(@Nullable ShareVideo video)
/*     */     {
/* 170 */       if (video == null) {
/* 171 */         return this;
/*     */       }
/*     */       
/* 174 */       this.video = new ShareVideo.Builder().readFrom(video).build();
/* 175 */       return this;
/*     */     }
/*     */     
/*     */     public ShareVideoContent build()
/*     */     {
/* 180 */       return new ShareVideoContent(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(ShareVideoContent model)
/*     */     {
/* 185 */       if (model == null) {
/* 186 */         return this;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 193 */       return ((Builder)super.readFrom(model)).setContentDescription(model.getContentDescription()).setContentTitle(model.getContentTitle()).setPreviewPhoto(model.getPreviewPhoto()).setVideo(model.getVideo());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareVideoContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */