/*     */ package com.tencent.bugly.crashreport.biz;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.Parcelable.Creator;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UserInfoBean
/*     */   implements Parcelable
/*     */ {
/*     */   public long a;
/*     */   public int b;
/*     */   public String c;
/*     */   public String d;
/*     */   public long e;
/*     */   public long f;
/*     */   public long g;
/*     */   public long h;
/*     */   public long i;
/*     */   public String j;
/*  52 */   public long k = 0L;
/*     */   
/*  54 */   public boolean l = false;
/*     */   
/*  56 */   public String m = "unknown";
/*     */   
/*     */ 
/*     */   public String n;
/*     */   
/*     */   public int o;
/*     */   
/*  63 */   public int p = -1;
/*  64 */   public int q = -1;
/*  65 */   public Map<String, String> r = null;
/*  66 */   public Map<String, String> s = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public UserInfoBean() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public UserInfoBean(Parcel paramParcel)
/*     */   {
/*  77 */     this.b = paramParcel.readInt();
/*  78 */     this.c = paramParcel.readString();
/*  79 */     this.d = paramParcel.readString();
/*  80 */     this.e = paramParcel.readLong();
/*  81 */     this.f = paramParcel.readLong();
/*  82 */     this.g = paramParcel.readLong();
/*  83 */     this.h = paramParcel.readLong();
/*  84 */     this.i = paramParcel.readLong();
/*  85 */     this.j = paramParcel.readString();
/*  86 */     this.k = paramParcel.readLong();
/*  87 */     this.l = (paramParcel.readByte() == 1);
/*  88 */     this.m = paramParcel.readString();
/*     */     
/*     */ 
/*  91 */     this.p = paramParcel.readInt();
/*  92 */     this.q = paramParcel.readInt();
/*  93 */     this.r = z.b(paramParcel);
/*  94 */     this.s = z.b(paramParcel);
/*     */     
/*     */ 
/*  97 */     this.n = paramParcel.readString();
/*     */     
/*     */ 
/* 100 */     this.o = paramParcel.readInt();
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 105 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt)
/*     */   {
/* 110 */     paramParcel.writeInt(this.b);
/* 111 */     paramParcel.writeString(this.c);
/* 112 */     paramParcel.writeString(this.d);
/* 113 */     paramParcel.writeLong(this.e);
/* 114 */     paramParcel.writeLong(this.f);
/* 115 */     paramParcel.writeLong(this.g);
/* 116 */     paramParcel.writeLong(this.h);
/* 117 */     paramParcel.writeLong(this.i);
/* 118 */     paramParcel.writeString(this.j);
/* 119 */     paramParcel.writeLong(this.k);
/* 120 */     paramParcel.writeByte((byte)(this.l ? 1 : 0));
/* 121 */     paramParcel.writeString(this.m);
/*     */     
/*     */ 
/* 124 */     paramParcel.writeInt(this.p);
/* 125 */     paramParcel.writeInt(this.q);
/* 126 */     z.b(paramParcel, this.r);
/* 127 */     z.b(paramParcel, this.s);
/*     */     
/*     */ 
/* 130 */     paramParcel.writeString(this.n);
/*     */     
/*     */ 
/* 133 */     paramParcel.writeInt(this.o);
/*     */   }
/*     */   
/* 136 */   public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator() {};
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/biz/UserInfoBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */