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
/*     */ 
/*     */ 
/*     */ public final class ShareLinkContent
/*     */   extends ShareContent<ShareLinkContent, Builder>
/*     */ {
/*     */   private final String contentDescription;
/*     */   private final String contentTitle;
/*     */   private final Uri imageUrl;
/*     */   private final String quote;
/*     */   
/*     */   private ShareLinkContent(Builder builder)
/*     */   {
/*  42 */     super(builder);
/*  43 */     this.contentDescription = builder.contentDescription;
/*  44 */     this.contentTitle = builder.contentTitle;
/*  45 */     this.imageUrl = builder.imageUrl;
/*  46 */     this.quote = builder.quote;
/*     */   }
/*     */   
/*     */   ShareLinkContent(Parcel in) {
/*  50 */     super(in);
/*  51 */     this.contentDescription = in.readString();
/*  52 */     this.contentTitle = in.readString();
/*  53 */     this.imageUrl = ((Uri)in.readParcelable(Uri.class.getClassLoader()));
/*  54 */     this.quote = in.readString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getContentDescription()
/*     */   {
/*  63 */     return this.contentDescription;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public String getContentTitle()
/*     */   {
/*  72 */     return this.contentTitle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public Uri getImageUrl()
/*     */   {
/*  81 */     return this.imageUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public String getQuote()
/*     */   {
/*  90 */     return this.quote;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/*  94 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/*  98 */     super.writeToParcel(out, flags);
/*  99 */     out.writeString(this.contentDescription);
/* 100 */     out.writeString(this.contentTitle);
/* 101 */     out.writeParcelable(this.imageUrl, 0);
/* 102 */     out.writeString(this.quote);
/*     */   }
/*     */   
/*     */ 
/* 106 */   public static final Parcelable.Creator<ShareLinkContent> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public ShareLinkContent createFromParcel(Parcel in) {
/* 109 */       return new ShareLinkContent(in);
/*     */     }
/*     */     
/*     */     public ShareLinkContent[] newArray(int size) {
/* 113 */       return new ShareLinkContent[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */   public static final class Builder
/*     */     extends ShareContent.Builder<ShareLinkContent, Builder>
/*     */   {
/*     */     private String contentDescription;
/*     */     
/*     */ 
/*     */     private String contentTitle;
/*     */     
/*     */     private Uri imageUrl;
/*     */     
/*     */     private String quote;
/*     */     
/*     */ 
/*     */     public Builder setContentDescription(@Nullable String contentDescription)
/*     */     {
/* 134 */       this.contentDescription = contentDescription;
/* 135 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setContentTitle(@Nullable String contentTitle)
/*     */     {
/* 144 */       this.contentTitle = contentTitle;
/* 145 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setImageUrl(@Nullable Uri imageUrl)
/*     */     {
/* 154 */       this.imageUrl = imageUrl;
/* 155 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setQuote(@Nullable String quote)
/*     */     {
/* 164 */       this.quote = quote;
/* 165 */       return this;
/*     */     }
/*     */     
/*     */     public ShareLinkContent build()
/*     */     {
/* 170 */       return new ShareLinkContent(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(ShareLinkContent model)
/*     */     {
/* 175 */       if (model == null) {
/* 176 */         return this;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 183 */       return ((Builder)super.readFrom(model)).setContentDescription(model.getContentDescription()).setImageUrl(model.getImageUrl()).setContentTitle(model.getContentTitle()).setQuote(model.getQuote());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareLinkContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */