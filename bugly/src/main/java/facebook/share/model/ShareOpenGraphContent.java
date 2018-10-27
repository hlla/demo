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
/*     */ 
/*     */ 
/*     */ public final class ShareOpenGraphContent
/*     */   extends ShareContent<ShareOpenGraphContent, Builder>
/*     */ {
/*     */   private final ShareOpenGraphAction action;
/*     */   private final String previewPropertyName;
/*     */   
/*     */   private ShareOpenGraphContent(Builder builder)
/*     */   {
/*  40 */     super(builder);
/*  41 */     this.action = builder.action;
/*  42 */     this.previewPropertyName = builder.previewPropertyName;
/*     */   }
/*     */   
/*     */   ShareOpenGraphContent(Parcel in) {
/*  46 */     super(in);
/*  47 */     this.action = new ShareOpenGraphAction.Builder().readFrom(in).build();
/*  48 */     this.previewPropertyName = in.readString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public ShareOpenGraphAction getAction()
/*     */   {
/*  58 */     return this.action;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public String getPreviewPropertyName()
/*     */   {
/*  69 */     return this.previewPropertyName;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/*  73 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/*  77 */     super.writeToParcel(out, flags);
/*  78 */     out.writeParcelable(this.action, 0);
/*  79 */     out.writeString(this.previewPropertyName);
/*     */   }
/*     */   
/*     */ 
/*  83 */   public static final Parcelable.Creator<ShareOpenGraphContent> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public ShareOpenGraphContent createFromParcel(Parcel in) {
/*  86 */       return new ShareOpenGraphContent(in);
/*     */     }
/*     */     
/*     */     public ShareOpenGraphContent[] newArray(int size) {
/*  90 */       return new ShareOpenGraphContent[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final class Builder
/*     */     extends ShareContent.Builder<ShareOpenGraphContent, Builder>
/*     */   {
/*     */     private ShareOpenGraphAction action;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private String previewPropertyName;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setAction(@Nullable ShareOpenGraphAction action)
/*     */     {
/* 113 */       this.action = (action == null ? null : new ShareOpenGraphAction.Builder().readFrom(action).build());
/* 114 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setPreviewPropertyName(@Nullable String previewPropertyName)
/*     */     {
/* 126 */       this.previewPropertyName = previewPropertyName;
/* 127 */       return this;
/*     */     }
/*     */     
/*     */     public ShareOpenGraphContent build()
/*     */     {
/* 132 */       return new ShareOpenGraphContent(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(ShareOpenGraphContent model)
/*     */     {
/* 137 */       if (model == null) {
/* 138 */         return this;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 143 */       return ((Builder)super.readFrom(model)).setAction(model.getAction()).setPreviewPropertyName(model.getPreviewPropertyName());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareOpenGraphContent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */