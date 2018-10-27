/*    */ package com.facebook.share.model;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable.Creator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ShareOpenGraphObject
/*    */   extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder>
/*    */ {
/*    */   private ShareOpenGraphObject(Builder builder)
/*    */   {
/* 39 */     super(builder);
/*    */   }
/*    */   
/*    */   ShareOpenGraphObject(Parcel in) {
/* 43 */     super(in);
/*    */   }
/*    */   
/*    */ 
/* 47 */   public static final Parcelable.Creator<ShareOpenGraphObject> CREATOR = new Parcelable.Creator()
/*    */   {
/*    */     public ShareOpenGraphObject createFromParcel(Parcel in) {
/* 50 */       return new ShareOpenGraphObject(in);
/*    */     }
/*    */     
/*    */     public ShareOpenGraphObject[] newArray(int size) {
/* 54 */       return new ShareOpenGraphObject[size];
/*    */     }
/*    */   };
/*    */   
/*    */ 
/*    */ 
/*    */   public static final class Builder
/*    */     extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder>
/*    */   {
/*    */     public Builder()
/*    */     {
/* 65 */       putBoolean("fbsdk:create_object", true);
/*    */     }
/*    */     
/*    */     public ShareOpenGraphObject build()
/*    */     {
/* 70 */       return new ShareOpenGraphObject(this, null);
/*    */     }
/*    */     
/*    */     Builder readFrom(Parcel parcel) {
/* 74 */       return (Builder)readFrom(
/* 75 */         (ShareOpenGraphObject)parcel.readParcelable(ShareOpenGraphObject.class
/* 76 */         .getClassLoader()));
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareOpenGraphObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */