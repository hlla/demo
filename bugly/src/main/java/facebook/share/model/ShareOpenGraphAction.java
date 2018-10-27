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
/*     */ 
/*     */ public final class ShareOpenGraphAction
/*     */   extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder>
/*     */ {
/*     */   private ShareOpenGraphAction(Builder builder)
/*     */   {
/*  38 */     super(builder);
/*     */   }
/*     */   
/*     */   ShareOpenGraphAction(Parcel in) {
/*  42 */     super(in);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public String getActionType()
/*     */   {
/*  52 */     return getString("og:type");
/*     */   }
/*     */   
/*     */ 
/*  56 */   public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public ShareOpenGraphAction createFromParcel(Parcel in) {
/*  59 */       return new ShareOpenGraphAction(in);
/*     */     }
/*     */     
/*     */     public ShareOpenGraphAction[] newArray(int size) {
/*  63 */       return new ShareOpenGraphAction[size];
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final class Builder
/*     */     extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder>
/*     */   {
/*     */     private static final String ACTION_TYPE_KEY = "og:type";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setActionType(String actionType)
/*     */     {
/*  81 */       putString("og:type", actionType);
/*  82 */       return this;
/*     */     }
/*     */     
/*     */     public ShareOpenGraphAction build()
/*     */     {
/*  87 */       return new ShareOpenGraphAction(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(ShareOpenGraphAction model)
/*     */     {
/*  92 */       if (model == null) {
/*  93 */         return this;
/*     */       }
/*     */       
/*     */ 
/*  97 */       return ((Builder)super.readFrom(model)).setActionType(model.getActionType());
/*     */     }
/*     */     
/*     */     Builder readFrom(Parcel parcel)
/*     */     {
/* 102 */       return readFrom(
/* 103 */         (ShareOpenGraphAction)parcel.readParcelable(ShareOpenGraphAction.class
/* 104 */         .getClassLoader()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareOpenGraphAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */