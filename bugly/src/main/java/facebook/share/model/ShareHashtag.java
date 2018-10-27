/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
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
/*     */ public class ShareHashtag
/*     */   implements ShareModel
/*     */ {
/*     */   private final String hashtag;
/*     */   
/*     */   private ShareHashtag(Builder builder)
/*     */   {
/*  35 */     this.hashtag = builder.hashtag;
/*     */   }
/*     */   
/*     */   ShareHashtag(Parcel in) {
/*  39 */     this.hashtag = in.readString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getHashtag()
/*     */   {
/*  46 */     return this.hashtag;
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/*  51 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel dest, int flags)
/*     */   {
/*  56 */     dest.writeString(this.hashtag);
/*     */   }
/*     */   
/*     */ 
/*  60 */   public static final Parcelable.Creator<ShareHashtag> CREATOR = new Parcelable.Creator() {
/*     */     public ShareHashtag createFromParcel(Parcel in) {
/*  62 */       return new ShareHashtag(in);
/*     */     }
/*     */     
/*     */     public ShareHashtag[] newArray(int size) {
/*  66 */       return new ShareHashtag[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class Builder
/*     */     implements ShareModelBuilder<ShareHashtag, Builder>
/*     */   {
/*     */     private String hashtag;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setHashtag(String hashtag)
/*     */     {
/*  83 */       this.hashtag = hashtag;
/*  84 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getHashtag()
/*     */     {
/*  91 */       return this.hashtag;
/*     */     }
/*     */     
/*     */     public Builder readFrom(ShareHashtag model)
/*     */     {
/*  96 */       if (model == null) {
/*  97 */         return this;
/*     */       }
/*     */       
/* 100 */       return setHashtag(model.getHashtag());
/*     */     }
/*     */     
/*     */     Builder readFrom(Parcel parcel) {
/* 104 */       return readFrom(
/* 105 */         (ShareHashtag)parcel.readParcelable(ShareHashtag.class.getClassLoader()));
/*     */     }
/*     */     
/*     */     public ShareHashtag build()
/*     */     {
/* 110 */       return new ShareHashtag(this, null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareHashtag.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */