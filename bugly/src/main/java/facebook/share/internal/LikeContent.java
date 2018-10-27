/*     */ package com.facebook.share.internal;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import com.facebook.share.model.ShareModel;
/*     */ import com.facebook.share.model.ShareModelBuilder;
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
/*     */ public class LikeContent
/*     */   implements ShareModel
/*     */ {
/*     */   private final String objectId;
/*     */   private final String objectType;
/*     */   
/*     */   private LikeContent(Builder builder)
/*     */   {
/*  41 */     this.objectId = builder.objectId;
/*  42 */     this.objectType = builder.objectType;
/*     */   }
/*     */   
/*     */   LikeContent(Parcel in) {
/*  46 */     this.objectId = in.readString();
/*  47 */     this.objectType = in.readString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getObjectId()
/*     */   {
/*  56 */     return this.objectId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getObjectType()
/*     */   {
/*  65 */     return this.objectType;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/*  69 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/*  73 */     out.writeString(this.objectId);
/*  74 */     out.writeString(this.objectType);
/*     */   }
/*     */   
/*     */ 
/*  78 */   public static final Parcelable.Creator<LikeContent> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public LikeContent createFromParcel(Parcel in) {
/*  81 */       return new LikeContent(in);
/*     */     }
/*     */     
/*     */     public LikeContent[] newArray(int size) {
/*  85 */       return new LikeContent[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */   public static class Builder
/*     */     implements ShareModelBuilder<LikeContent, Builder>
/*     */   {
/*     */     private String objectId;
/*     */     
/*     */ 
/*     */     private String objectType;
/*     */     
/*     */ 
/*     */     public Builder setObjectId(String objectId)
/*     */     {
/* 102 */       this.objectId = objectId;
/* 103 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setObjectType(String objectType)
/*     */     {
/* 111 */       this.objectType = objectType;
/* 112 */       return this;
/*     */     }
/*     */     
/*     */     public LikeContent build()
/*     */     {
/* 117 */       return new LikeContent(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(LikeContent content)
/*     */     {
/* 122 */       if (content == null) {
/* 123 */         return this;
/*     */       }
/*     */       
/*     */ 
/* 127 */       return setObjectId(content.getObjectId()).setObjectType(content.getObjectType());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/LikeContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */