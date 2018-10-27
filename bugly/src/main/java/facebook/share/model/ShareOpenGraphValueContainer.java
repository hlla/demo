/*     */ package com.facebook.share.model;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.support.annotation.Nullable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Set;
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
/*     */ 
/*     */ public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends Builder>
/*     */   implements ShareModel
/*     */ {
/*     */   private final Bundle bundle;
/*     */   
/*     */   protected ShareOpenGraphValueContainer(Builder<P, E> builder)
/*     */   {
/*  44 */     this.bundle = ((Bundle)builder.bundle.clone());
/*     */   }
/*     */   
/*     */   ShareOpenGraphValueContainer(Parcel in) {
/*  48 */     this.bundle = in.readBundle(Builder.class.getClassLoader());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public Object get(String key)
/*     */   {
/*  58 */     return this.bundle.get(key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getBoolean(String key, boolean defaultValue)
/*     */   {
/*  68 */     return this.bundle.getBoolean(key, defaultValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public boolean[] getBooleanArray(String key)
/*     */   {
/*  78 */     return this.bundle.getBooleanArray(key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getDouble(String key, double defaultValue)
/*     */   {
/*  88 */     return this.bundle.getDouble(key, defaultValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public double[] getDoubleArray(String key)
/*     */   {
/*  98 */     return this.bundle.getDoubleArray(key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getInt(String key, int defaultValue)
/*     */   {
/* 108 */     return this.bundle.getInt(key, defaultValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public int[] getIntArray(String key)
/*     */   {
/* 118 */     return this.bundle.getIntArray(key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getLong(String key, long defaultValue)
/*     */   {
/* 128 */     return this.bundle.getLong(key, defaultValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public long[] getLongArray(String key)
/*     */   {
/* 138 */     return this.bundle.getLongArray(key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ShareOpenGraphObject getObject(String key)
/*     */   {
/* 147 */     Object value = this.bundle.get(key);
/* 148 */     return (value instanceof ShareOpenGraphObject) ? (ShareOpenGraphObject)value : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public ArrayList<ShareOpenGraphObject> getObjectArrayList(String key)
/*     */   {
/* 158 */     ArrayList<Parcelable> items = this.bundle.getParcelableArrayList(key);
/* 159 */     if (items == null) {
/* 160 */       return null;
/*     */     }
/* 162 */     ArrayList<ShareOpenGraphObject> list = new ArrayList();
/* 163 */     for (Parcelable item : items) {
/* 164 */       if ((item instanceof ShareOpenGraphObject)) {
/* 165 */         list.add((ShareOpenGraphObject)item);
/*     */       }
/*     */     }
/* 168 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public SharePhoto getPhoto(String key)
/*     */   {
/* 178 */     Object value = this.bundle.getParcelable(key);
/* 179 */     return (value instanceof SharePhoto) ? (SharePhoto)value : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public ArrayList<SharePhoto> getPhotoArrayList(String key)
/*     */   {
/* 189 */     ArrayList<Parcelable> items = this.bundle.getParcelableArrayList(key);
/* 190 */     if (items == null) {
/* 191 */       return null;
/*     */     }
/* 193 */     ArrayList<SharePhoto> list = new ArrayList();
/* 194 */     for (Parcelable item : items) {
/* 195 */       if ((item instanceof SharePhoto)) {
/* 196 */         list.add((SharePhoto)item);
/*     */       }
/*     */     }
/* 199 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public String getString(String key)
/*     */   {
/* 209 */     return this.bundle.getString(key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Nullable
/*     */   public ArrayList<String> getStringArrayList(String key)
/*     */   {
/* 219 */     return this.bundle.getStringArrayList(key);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bundle getBundle()
/*     */   {
/* 227 */     return (Bundle)this.bundle.clone();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<String> keySet()
/*     */   {
/* 235 */     return this.bundle.keySet();
/*     */   }
/*     */   
/*     */   public int describeContents() {
/* 239 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel out, int flags) {
/* 243 */     out.writeBundle(this.bundle);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static abstract class Builder<P extends ShareOpenGraphValueContainer, E extends Builder>
/*     */     implements ShareModelBuilder<P, E>
/*     */   {
/* 252 */     private Bundle bundle = new Bundle();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putBoolean(String key, boolean value)
/*     */     {
/* 261 */       this.bundle.putBoolean(key, value);
/* 262 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putBooleanArray(String key, @Nullable boolean[] value)
/*     */     {
/* 272 */       this.bundle.putBooleanArray(key, value);
/* 273 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putDouble(String key, double value)
/*     */     {
/* 283 */       this.bundle.putDouble(key, value);
/* 284 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putDoubleArray(String key, @Nullable double[] value)
/*     */     {
/* 294 */       this.bundle.putDoubleArray(key, value);
/* 295 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putInt(String key, int value)
/*     */     {
/* 305 */       this.bundle.putInt(key, value);
/* 306 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putIntArray(String key, @Nullable int[] value)
/*     */     {
/* 316 */       this.bundle.putIntArray(key, value);
/* 317 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putLong(String key, long value)
/*     */     {
/* 327 */       this.bundle.putLong(key, value);
/* 328 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putLongArray(String key, @Nullable long[] value)
/*     */     {
/* 338 */       this.bundle.putLongArray(key, value);
/* 339 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putObject(String key, @Nullable ShareOpenGraphObject value)
/*     */     {
/* 349 */       this.bundle.putParcelable(key, value);
/* 350 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putObjectArrayList(String key, @Nullable ArrayList<ShareOpenGraphObject> value)
/*     */     {
/* 362 */       this.bundle.putParcelableArrayList(key, value);
/* 363 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putPhoto(String key, @Nullable SharePhoto value)
/*     */     {
/* 373 */       this.bundle.putParcelable(key, value);
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putPhotoArrayList(String key, @Nullable ArrayList<SharePhoto> value)
/*     */     {
/* 384 */       this.bundle.putParcelableArrayList(key, value);
/* 385 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putString(String key, @Nullable String value)
/*     */     {
/* 395 */       this.bundle.putString(key, value);
/* 396 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public E putStringArrayList(String key, @Nullable ArrayList<String> value)
/*     */     {
/* 406 */       this.bundle.putStringArrayList(key, value);
/* 407 */       return this;
/*     */     }
/*     */     
/*     */     public E readFrom(P model)
/*     */     {
/* 412 */       if (model != null) {
/* 413 */         this.bundle.putAll(model.getBundle());
/*     */       }
/* 415 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareOpenGraphValueContainer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */