/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.graphics.Bitmap;
/*     */ import android.net.Uri;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.support.annotation.Nullable;
/*     */ import java.util.ArrayList;
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
/*     */ public final class SharePhoto
/*     */   extends ShareMedia
/*     */ {
/*     */   private final Bitmap bitmap;
/*     */   private final Uri imageUrl;
/*     */   private final boolean userGenerated;
/*     */   private final String caption;
/*     */   
/*     */   private SharePhoto(Builder builder)
/*     */   {
/*  44 */     super(builder);
/*  45 */     this.bitmap = builder.bitmap;
/*  46 */     this.imageUrl = builder.imageUrl;
/*  47 */     this.userGenerated = builder.userGenerated;
/*  48 */     this.caption = builder.caption;
/*     */   }
/*     */   
/*     */   SharePhoto(Parcel in) {
/*  52 */     super(in);
/*  53 */     this.bitmap = ((Bitmap)in.readParcelable(Bitmap.class.getClassLoader()));
/*  54 */     this.imageUrl = ((Uri)in.readParcelable(Uri.class.getClassLoader()));
/*  55 */     this.userGenerated = (in.readByte() != 0);
/*  56 */     this.caption = in.readString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public Bitmap getBitmap()
/*     */   {
/*  65 */     return this.bitmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public Uri getImageUrl()
/*     */   {
/*  75 */     return this.imageUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getUserGenerated()
/*     */   {
/*  84 */     return this.userGenerated;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCaption()
/*     */   {
/*  93 */     return this.caption;
/*     */   }
/*     */   
/*     */   public int describeContents() {
/*  97 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/* 101 */     super.writeToParcel(out, flags);
/* 102 */     out.writeParcelable(this.bitmap, 0);
/* 103 */     out.writeParcelable(this.imageUrl, 0);
/* 104 */     out.writeByte((byte)(this.userGenerated ? 1 : 0));
/* 105 */     out.writeString(this.caption);
/*     */   }
/*     */   
/* 108 */   public static final Parcelable.Creator<SharePhoto> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */ 
/*     */     public SharePhoto createFromParcel(Parcel source)
/*     */     {
/* 113 */       return new SharePhoto(source);
/*     */     }
/*     */     
/*     */     public SharePhoto[] newArray(int size)
/*     */     {
/* 118 */       return new SharePhoto[size];
/*     */     }
/*     */   };
/*     */   
/*     */   public Type getMediaType()
/*     */   {
/* 124 */     return Type.PHOTO;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Builder
/*     */     extends ShareMedia.Builder<SharePhoto, Builder>
/*     */   {
/*     */     private Bitmap bitmap;
/*     */     
/*     */     private Uri imageUrl;
/*     */     
/*     */     private boolean userGenerated;
/*     */     
/*     */     private String caption;
/*     */     
/*     */ 
/*     */     public Builder setBitmap(@Nullable Bitmap bitmap)
/*     */     {
/* 142 */       this.bitmap = bitmap;
/* 143 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setImageUrl(@Nullable Uri imageUrl)
/*     */     {
/* 153 */       this.imageUrl = imageUrl;
/* 154 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setUserGenerated(boolean userGenerated)
/*     */     {
/* 164 */       this.userGenerated = userGenerated;
/* 165 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setCaption(@Nullable String caption)
/*     */     {
/* 176 */       this.caption = caption;
/* 177 */       return this;
/*     */     }
/*     */     
/*     */     Uri getImageUrl()
/*     */     {
/* 182 */       return this.imageUrl;
/*     */     }
/*     */     
/*     */     Bitmap getBitmap()
/*     */     {
/* 187 */       return this.bitmap;
/*     */     }
/*     */     
/*     */     public SharePhoto build()
/*     */     {
/* 192 */       return new SharePhoto(this, null);
/*     */     }
/*     */     
/*     */     public Builder readFrom(SharePhoto model)
/*     */     {
/* 197 */       if (model == null) {
/* 198 */         return this;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 204 */       return ((Builder)super.readFrom(model)).setBitmap(model.getBitmap()).setImageUrl(model.getImageUrl()).setUserGenerated(model.getUserGenerated()).setCaption(model.getCaption());
/*     */     }
/*     */     
/*     */     Builder readFrom(Parcel parcel)
/*     */     {
/* 209 */       return readFrom(
/* 210 */         (SharePhoto)parcel.readParcelable(SharePhoto.class.getClassLoader()));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     static void writePhotoListTo(Parcel out, int parcelFlags, List<SharePhoto> photos)
/*     */     {
/* 221 */       ShareMedia[] array = new ShareMedia[photos.size()];
/* 222 */       for (int i = 0; i < photos.size(); i++) {
/* 223 */         array[i] = ((ShareMedia)photos.get(i));
/*     */       }
/* 225 */       out.writeParcelableArray(array, parcelFlags);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     static List<SharePhoto> readPhotoListFrom(Parcel in)
/*     */     {
/* 233 */       List<ShareMedia> media = readListFrom(in);
/* 234 */       List<SharePhoto> photos = new ArrayList();
/* 235 */       for (ShareMedia medium : media) {
/* 236 */         if ((medium instanceof SharePhoto)) {
/* 237 */           photos.add((SharePhoto)medium);
/*     */         }
/*     */       }
/* 240 */       return photos;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/SharePhoto.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */