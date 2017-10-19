/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ public final class ak
/*     */   extends k
/*     */ {
/*  11 */   public String a = "";
/*     */   
/*  13 */   public long b = 0L;
/*     */   
/*  15 */   public String c = "";
/*     */   
/*  17 */   public String d = "";
/*     */   
/*  19 */   public String e = "";
/*     */   
/*  21 */   public String f = "";
/*     */   
/*  23 */   public String g = "";
/*     */   
/*  25 */   public Map<String, String> h = null;
/*     */   
/*  27 */   public String i = "";
/*     */   
/*  29 */   public ai j = null;
/*     */   
/*  31 */   public int k = 0;
/*     */   
/*  33 */   public String l = "";
/*     */   
/*  35 */   public String m = "";
/*     */   
/*  37 */   public ah n = null;
/*     */   
/*  39 */   public ArrayList<ah> o = null;
/*     */   
/*  41 */   public ArrayList<ah> p = null;
/*     */   
/*  43 */   public ArrayList<aj> q = null;
/*     */   
/*  45 */   public Map<String, String> r = null;
/*     */   
/*  47 */   public Map<String, String> s = null;
/*     */   
/*  49 */   public String t = "";
/*     */   
/*  51 */   private boolean u = true;
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
/*     */   public final void a(j paramj)
/*     */   {
/*  84 */     paramj.a(this.a, 0);
/*  85 */     paramj.a(this.b, 1);
/*  86 */     paramj.a(this.c, 2);
/*  87 */     if (this.d != null)
/*     */     {
/*  89 */       paramj.a(this.d, 3);
/*     */     }
/*  91 */     if (this.e != null)
/*     */     {
/*  93 */       paramj.a(this.e, 4);
/*     */     }
/*  95 */     if (this.f != null)
/*     */     {
/*  97 */       paramj.a(this.f, 5);
/*     */     }
/*  99 */     if (this.g != null)
/*     */     {
/* 101 */       paramj.a(this.g, 6);
/*     */     }
/* 103 */     if (this.h != null)
/*     */     {
/* 105 */       paramj.a(this.h, 7);
/*     */     }
/* 107 */     if (this.i != null)
/*     */     {
/* 109 */       paramj.a(this.i, 8);
/*     */     }
/* 111 */     if (this.j != null)
/*     */     {
/* 113 */       paramj.a(this.j, 9);
/*     */     }
/* 115 */     paramj.a(this.k, 10);
/* 116 */     if (this.l != null)
/*     */     {
/* 118 */       paramj.a(this.l, 11);
/*     */     }
/* 120 */     if (this.m != null)
/*     */     {
/* 122 */       paramj.a(this.m, 12);
/*     */     }
/* 124 */     if (this.n != null)
/*     */     {
/* 126 */       paramj.a(this.n, 13);
/*     */     }
/* 128 */     if (this.o != null)
/*     */     {
/* 130 */       paramj.a(this.o, 14);
/*     */     }
/* 132 */     if (this.p != null)
/*     */     {
/* 134 */       paramj.a(this.p, 15);
/*     */     }
/* 136 */     if (this.q != null)
/*     */     {
/* 138 */       paramj.a(this.q, 16);
/*     */     }
/* 140 */     if (this.r != null)
/*     */     {
/* 142 */       paramj.a(this.r, 17);
/*     */     }
/* 144 */     if (this.s != null)
/*     */     {
/* 146 */       paramj.a(this.s, 18);
/*     */     }
/* 148 */     if (this.t != null)
/*     */     {
/* 150 */       paramj.a(this.t, 19);
/*     */     }
/* 152 */     paramj.a(this.u, 20);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 157 */   private static Map<String, String> v = new HashMap();
/* 158 */   static { Object localObject = "";
/* 159 */     String str = "";
/* 160 */     v.put(localObject, str);
/*     */     
/*     */ 
/*     */ 
/* 164 */     w = new ai();
/*     */     
/*     */ 
/*     */ 
/* 168 */     x = new ah();
/*     */     
/*     */ 
/*     */ 
/* 172 */     y = new ArrayList();
/* 173 */     localObject = new ah();
/* 174 */     y.add(localObject);
/*     */     
/*     */ 
/*     */ 
/* 178 */     z = new ArrayList();
/* 179 */     localObject = new ah();
/* 180 */     z.add(localObject);
/*     */     
/*     */ 
/*     */ 
/* 184 */     A = new ArrayList();
/* 185 */     localObject = new aj();
/* 186 */     A.add(localObject);
/*     */     
/*     */ 
/*     */ 
/* 190 */     B = new HashMap();
/* 191 */     localObject = "";
/* 192 */     str = "";
/* 193 */     B.put(localObject, str);
/*     */     
/*     */ 
/*     */ 
/* 197 */     C = new HashMap();
/* 198 */     localObject = "";
/* 199 */     str = "";
/* 200 */     C.put(localObject, str); }
/*     */   
/*     */   private static ai w;
/*     */   private static ah x;
/*     */   
/* 205 */   public final void a(i parami) { this.a = parami.b(0, true);
/* 206 */     this.b = parami.a(this.b, 1, true);
/* 207 */     this.c = parami.b(2, true);
/* 208 */     this.d = parami.b(3, false);
/* 209 */     this.e = parami.b(4, false);
/* 210 */     this.f = parami.b(5, false);
/* 211 */     this.g = parami.b(6, false);
/* 212 */     this.h = ((Map)parami.a(v, 7, false));
/* 213 */     this.i = parami.b(8, false);
/* 214 */     this.j = ((ai)parami.a(w, 9, false));
/* 215 */     this.k = parami.a(this.k, 10, false);
/* 216 */     this.l = parami.b(11, false);
/* 217 */     this.m = parami.b(12, false);
/* 218 */     this.n = ((ah)parami.a(x, 13, false));
/* 219 */     this.o = ((ArrayList)parami.a(y, 14, false));
/* 220 */     this.p = ((ArrayList)parami.a(z, 15, false));
/* 221 */     this.q = ((ArrayList)parami.a(A, 16, false));
/* 222 */     this.r = ((Map)parami.a(B, 17, false));
/* 223 */     this.s = ((Map)parami.a(C, 18, false));
/* 224 */     this.t = parami.b(19, false);
/* 225 */     this.u = parami.a(20, false);
/*     */   }
/*     */   
/*     */   private static ArrayList<ah> y;
/*     */   private static ArrayList<ah> z;
/*     */   private static ArrayList<aj> A;
/*     */   private static Map<String, String> B;
/*     */   private static Map<String, String> C;
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */