/*     */ package com.tencent.bugly.crashreport.crash;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.Parcelable.Creator;
/*     */ import com.tencent.bugly.crashreport.common.info.PlugInBean;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
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
/*     */ public class CrashDetailBean
/*     */   implements Parcelable, Comparable<CrashDetailBean>
/*     */ {
/*  29 */   public long a = -1L;
/*  30 */   public int b = 0;
/*  31 */   public String c = UUID.randomUUID().toString();
/*  32 */   public boolean d = false;
/*  33 */   public String e = "";
/*  34 */   public String f = "";
/*  35 */   public String g = "";
/*  36 */   public Map<String, PlugInBean> h = null;
/*  37 */   public Map<String, PlugInBean> i = null;
/*     */   
/*  39 */   public boolean j = false;
/*  40 */   public boolean k = false;
/*  41 */   public int l = 0;
/*  42 */   public String m = "";
/*  43 */   public String n = "";
/*  44 */   public String o = "";
/*  45 */   public String p = "";
/*  46 */   public String q = "";
/*  47 */   public long r = -1L;
/*  48 */   public String s = null;
/*  49 */   public int t = 0;
/*  50 */   public String u = "";
/*  51 */   public String v = "";
/*  52 */   public String w = null;
/*  53 */   public byte[] x = null;
/*  54 */   public Map<String, String> y = null;
/*     */   
/*     */ 
/*  57 */   public String z = "";
/*  58 */   public String A = "";
/*  59 */   public long B = -1L;
/*  60 */   public long C = -1L;
/*  61 */   public long D = -1L;
/*  62 */   public long E = -1L;
/*  63 */   public long F = -1L;
/*  64 */   public long G = -1L;
/*  65 */   public String H = "";
/*     */   
/*     */ 
/*  68 */   private String V = "";
/*  69 */   public String I = "";
/*  70 */   public String J = "";
/*  71 */   public String K = "";
/*     */   
/*  73 */   public long L = -1L;
/*  74 */   public boolean M = false;
/*  75 */   public Map<String, String> N = null;
/*     */   
/*     */ 
/*  78 */   public int O = -1;
/*  79 */   public int P = -1;
/*  80 */   public Map<String, String> Q = null;
/*  81 */   public Map<String, String> R = null;
/*     */   
/*  83 */   public byte[] S = null;
/*     */   
/*  85 */   public String T = null;
/*     */   
/*  87 */   public String U = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CrashDetailBean() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CrashDetailBean(Parcel paramParcel)
/*     */   {
/*  98 */     this.b = paramParcel.readInt();
/*  99 */     this.c = paramParcel.readString();
/* 100 */     this.d = (paramParcel.readByte() == 1);
/* 101 */     this.e = paramParcel.readString();
/* 102 */     this.f = paramParcel.readString();
/* 103 */     this.g = paramParcel.readString();
/* 104 */     this.j = (paramParcel.readByte() == 1);
/* 105 */     this.k = (paramParcel.readByte() == 1);
/* 106 */     this.l = paramParcel.readInt();
/* 107 */     this.m = paramParcel.readString();
/* 108 */     this.n = paramParcel.readString();
/* 109 */     this.o = paramParcel.readString();
/* 110 */     this.p = paramParcel.readString();
/* 111 */     this.q = paramParcel.readString();
/* 112 */     this.r = paramParcel.readLong();
/* 113 */     this.s = paramParcel.readString();
/* 114 */     this.t = paramParcel.readInt();
/* 115 */     this.u = paramParcel.readString();
/* 116 */     this.v = paramParcel.readString();
/* 117 */     this.w = paramParcel.readString();
/* 118 */     this.y = z.b(paramParcel);
/* 119 */     this.z = paramParcel.readString();
/* 120 */     this.A = paramParcel.readString();
/* 121 */     this.B = paramParcel.readLong();
/* 122 */     this.C = paramParcel.readLong();
/* 123 */     this.D = paramParcel.readLong();
/* 124 */     this.E = paramParcel.readLong();
/* 125 */     this.F = paramParcel.readLong();
/* 126 */     this.G = paramParcel.readLong();
/* 127 */     this.H = paramParcel.readString();
/* 128 */     this.V = paramParcel.readString();
/* 129 */     this.I = paramParcel.readString();
/* 130 */     this.J = paramParcel.readString();
/* 131 */     this.K = paramParcel.readString();
/* 132 */     this.L = paramParcel.readLong();
/* 133 */     this.M = (paramParcel.readByte() == 1);
/* 134 */     this.N = z.b(paramParcel);
/*     */     
/* 136 */     this.h = z.a(paramParcel);
/* 137 */     this.i = z.a(paramParcel);
/*     */     
/*     */ 
/* 140 */     this.O = paramParcel.readInt();
/* 141 */     this.P = paramParcel.readInt();
/* 142 */     this.Q = z.b(paramParcel);
/* 143 */     this.R = z.b(paramParcel);
/*     */     
/* 145 */     this.S = paramParcel.createByteArray();
/*     */     
/*     */ 
/* 148 */     this.x = paramParcel.createByteArray();
/*     */     
/* 150 */     this.T = paramParcel.readString();
/*     */     
/* 152 */     this.U = paramParcel.readString();
/*     */   }
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 157 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt)
/*     */   {
/* 162 */     paramParcel.writeInt(this.b);
/* 163 */     paramParcel.writeString(this.c);
/* 164 */     paramParcel.writeByte((byte)(this.d ? 1 : 0));
/* 165 */     paramParcel.writeString(this.e);
/* 166 */     paramParcel.writeString(this.f);
/* 167 */     paramParcel.writeString(this.g);
/* 168 */     paramParcel.writeByte((byte)(this.j ? 1 : 0));
/* 169 */     paramParcel.writeByte((byte)(this.k ? 1 : 0));
/* 170 */     paramParcel.writeInt(this.l);
/* 171 */     paramParcel.writeString(this.m);
/* 172 */     paramParcel.writeString(this.n);
/* 173 */     paramParcel.writeString(this.o);
/* 174 */     paramParcel.writeString(this.p);
/* 175 */     paramParcel.writeString(this.q);
/* 176 */     paramParcel.writeLong(this.r);
/* 177 */     paramParcel.writeString(this.s);
/* 178 */     paramParcel.writeInt(this.t);
/* 179 */     paramParcel.writeString(this.u);
/* 180 */     paramParcel.writeString(this.v);
/* 181 */     paramParcel.writeString(this.w);
/* 182 */     z.b(paramParcel, this.y);
/* 183 */     paramParcel.writeString(this.z);
/* 184 */     paramParcel.writeString(this.A);
/* 185 */     paramParcel.writeLong(this.B);
/* 186 */     paramParcel.writeLong(this.C);
/* 187 */     paramParcel.writeLong(this.D);
/* 188 */     paramParcel.writeLong(this.E);
/* 189 */     paramParcel.writeLong(this.F);
/* 190 */     paramParcel.writeLong(this.G);
/* 191 */     paramParcel.writeString(this.H);
/* 192 */     paramParcel.writeString(this.V);
/* 193 */     paramParcel.writeString(this.I);
/* 194 */     paramParcel.writeString(this.J);
/* 195 */     paramParcel.writeString(this.K);
/* 196 */     paramParcel.writeLong(this.L);
/* 197 */     paramParcel.writeByte((byte)(this.M ? 1 : 0));
/* 198 */     z.b(paramParcel, this.N);
/*     */     
/* 200 */     z.a(paramParcel, this.h);
/* 201 */     z.a(paramParcel, this.i);
/*     */     
/*     */ 
/* 204 */     paramParcel.writeInt(this.O);
/* 205 */     paramParcel.writeInt(this.P);
/* 206 */     z.b(paramParcel, this.Q);
/* 207 */     z.b(paramParcel, this.R);
/*     */     
/* 209 */     paramParcel.writeByteArray(this.S);
/*     */     
/*     */ 
/* 212 */     paramParcel.writeByteArray(this.x);
/*     */     
/* 214 */     paramParcel.writeString(this.T);
/*     */     
/* 216 */     paramParcel.writeString(this.U);
/*     */   }
/*     */   
/* 219 */   public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator() {};
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/CrashDetailBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */