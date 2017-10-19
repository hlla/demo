/*     */ package com.tencent.bugly.crashreport.common.strategy;
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
/*     */ public class StrategyBean
/*     */   implements Parcelable
/*     */ {
/*  33 */   public static String a = "http://rqd.uu.qq.com/rqd/sync";
/*  34 */   public static String b = "http://android.bugly.qq.com/rqd/async";
/*  35 */   public static String c = "http://android.bugly.qq.com/rqd/async";
/*     */   public static String d;
/*  37 */   public long e = -1L;
/*  38 */   public long f = -1L;
/*  39 */   public boolean g = true;
/*  40 */   public boolean h = true;
/*  41 */   public boolean i = true;
/*  42 */   public boolean j = true;
/*  43 */   public boolean k = false;
/*  44 */   public boolean l = true;
/*  45 */   public boolean m = true;
/*  46 */   public boolean n = true;
/*  47 */   public boolean o = true;
/*     */   public long p;
/*  49 */   public long q = 30000L;
/*  50 */   public String r = b;
/*  51 */   public String s = c;
/*  52 */   public String t = a;
/*     */   public String u;
/*     */   public Map<String, String> v;
/*  55 */   public int w = 10;
/*  56 */   public long x = 300000L;
/*  57 */   public long y = -1L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public StrategyBean()
/*     */   {
/*  65 */     this.f = System.currentTimeMillis();
/*     */     StringBuilder localStringBuilder;
/*  67 */     (localStringBuilder = new StringBuilder()).append("S(@L@L").append("@)");
/*  68 */     d = localStringBuilder.toString();
/*     */     
/*  70 */     localStringBuilder.setLength(0);
/*  71 */     localStringBuilder.append("*^@K#K").append("@!");
/*  72 */     this.u = localStringBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public StrategyBean(Parcel paramParcel)
/*     */   {
/*     */     try
/*     */     {
/*  85 */       (localObject = new StringBuilder()).append("S(@L@L").append("@)");
/*  86 */       d = ((StringBuilder)localObject).toString();
/*     */       
/*  88 */       this.f = paramParcel.readLong();
/*  89 */       this.g = (paramParcel.readByte() == 1);
/*  90 */       this.h = (paramParcel.readByte() == 1);
/*  91 */       this.i = (paramParcel.readByte() == 1);
/*  92 */       this.r = paramParcel.readString();
/*  93 */       this.s = paramParcel.readString();
/*  94 */       this.u = paramParcel.readString();
/*  95 */       this.v = z.b(paramParcel);
/*  96 */       this.j = (paramParcel.readByte() == 1);
/*  97 */       this.k = (paramParcel.readByte() == 1);
/*  98 */       this.n = (paramParcel.readByte() == 1);
/*  99 */       this.o = (paramParcel.readByte() == 1);
/* 100 */       this.q = paramParcel.readLong();
/* 101 */       this.l = (paramParcel.readByte() == 1);
/* 102 */       this.m = (paramParcel.readByte() == 1);
/* 103 */       this.p = paramParcel.readLong();
/* 104 */       this.w = paramParcel.readInt();
/* 105 */       this.x = paramParcel.readLong();
/* 106 */       this.y = paramParcel.readLong(); return;
/*     */     } catch (Exception localException) { Object localObject;
/* 108 */       (localObject = 
/* 109 */         localException).printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 114 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt)
/*     */   {
/* 119 */     paramParcel.writeLong(this.f);
/* 120 */     paramParcel.writeByte((byte)(this.g ? 1 : 0));
/* 121 */     paramParcel.writeByte((byte)(this.h ? 1 : 0));
/* 122 */     paramParcel.writeByte((byte)(this.i ? 1 : 0));
/* 123 */     paramParcel.writeString(this.r);
/* 124 */     paramParcel.writeString(this.s);
/* 125 */     paramParcel.writeString(this.u);
/* 126 */     z.b(paramParcel, this.v);
/* 127 */     paramParcel.writeByte((byte)(this.j ? 1 : 0));
/* 128 */     paramParcel.writeByte((byte)(this.k ? 1 : 0));
/* 129 */     paramParcel.writeByte((byte)(this.n ? 1 : 0));
/* 130 */     paramParcel.writeByte((byte)(this.o ? 1 : 0));
/* 131 */     paramParcel.writeLong(this.q);
/* 132 */     paramParcel.writeByte((byte)(this.l ? 1 : 0));
/* 133 */     paramParcel.writeByte((byte)(this.m ? 1 : 0));
/* 134 */     paramParcel.writeLong(this.p);
/* 135 */     paramParcel.writeInt(this.w);
/* 136 */     paramParcel.writeLong(this.x);
/* 137 */     paramParcel.writeLong(this.y);
/*     */   }
/*     */   
/* 140 */   public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator() {};
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/common/strategy/StrategyBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */