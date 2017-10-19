/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class am
/*     */   extends k
/*     */ {
/*  11 */   public int a = 0;
/*     */   
/*  13 */   public String b = "";
/*     */   
/*  15 */   public String c = "";
/*     */   
/*  17 */   public String d = "";
/*     */   
/*  19 */   public String e = "";
/*     */   
/*  21 */   public String f = "";
/*     */   
/*  23 */   public int g = 0;
/*     */   
/*  25 */   public byte[] h = null;
/*     */   
/*  27 */   public String i = "";
/*     */   
/*  29 */   public String j = "";
/*     */   
/*  31 */   public Map<String, String> k = null;
/*     */   
/*  33 */   public String l = "";
/*     */   
/*  35 */   public long m = 0L;
/*     */   
/*  37 */   public String n = "";
/*     */   
/*  39 */   public String o = "";
/*     */   
/*  41 */   public String p = "";
/*     */   
/*  43 */   public long q = 0L;
/*     */   
/*  45 */   public String r = "";
/*     */   
/*  47 */   public String s = "";
/*     */   
/*  49 */   public String t = "";
/*     */   
/*  51 */   public String u = "";
/*     */   
/*  53 */   public String v = "";
/*     */   
/*  55 */   public String w = "";
/*     */   
/*  57 */   private String x = "";
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
/*     */   private static byte[] y;
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
/*     */   private static Map<String, String> z;
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
/*  93 */     paramj.a(this.a, 0);
/*  94 */     paramj.a(this.b, 1);
/*  95 */     paramj.a(this.c, 2);
/*  96 */     paramj.a(this.d, 3);
/*  97 */     if (this.e != null)
/*     */     {
/*  99 */       paramj.a(this.e, 4);
/*     */     }
/* 101 */     paramj.a(this.f, 5);
/* 102 */     paramj.a(this.g, 6);
/* 103 */     paramj.a(this.h, 7);
/* 104 */     if (this.i != null)
/*     */     {
/* 106 */       paramj.a(this.i, 8);
/*     */     }
/* 108 */     if (this.j != null)
/*     */     {
/* 110 */       paramj.a(this.j, 9);
/*     */     }
/* 112 */     if (this.k != null)
/*     */     {
/* 114 */       paramj.a(this.k, 10);
/*     */     }
/* 116 */     if (this.l != null)
/*     */     {
/* 118 */       paramj.a(this.l, 11);
/*     */     }
/* 120 */     paramj.a(this.m, 12);
/* 121 */     if (this.n != null)
/*     */     {
/* 123 */       paramj.a(this.n, 13);
/*     */     }
/* 125 */     if (this.o != null)
/*     */     {
/* 127 */       paramj.a(this.o, 14);
/*     */     }
/* 129 */     if (this.p != null)
/*     */     {
/* 131 */       paramj.a(this.p, 15);
/*     */     }
/* 133 */     paramj.a(this.q, 16);
/* 134 */     if (this.r != null)
/*     */     {
/* 136 */       paramj.a(this.r, 17);
/*     */     }
/* 138 */     if (this.s != null)
/*     */     {
/* 140 */       paramj.a(this.s, 18);
/*     */     }
/* 142 */     if (this.t != null)
/*     */     {
/* 144 */       paramj.a(this.t, 19);
/*     */     }
/* 146 */     if (this.u != null)
/*     */     {
/* 148 */       paramj.a(this.u, 20);
/*     */     }
/* 150 */     if (this.v != null)
/*     */     {
/* 152 */       paramj.a(this.v, 21);
/*     */     }
/* 154 */     if (this.w != null)
/*     */     {
/* 156 */       paramj.a(this.w, 22);
/*     */     }
/* 158 */     if (this.x != null)
/*     */     {
/* 160 */       paramj.a(this.x, 23);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static
/*     */   {
/* 167 */     ((byte[])(y = (byte[])new byte[1]))[0] = 0;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 172 */     z = new HashMap();
/* 173 */     String str1 = "";
/* 174 */     String str2 = "";
/* 175 */     z.put(str1, str2);
/*     */   }
/*     */   
/*     */   public final void a(i parami)
/*     */   {
/* 180 */     this.a = parami.a(this.a, 0, true);
/* 181 */     this.b = parami.b(1, true);
/* 182 */     this.c = parami.b(2, true);
/* 183 */     this.d = parami.b(3, true);
/* 184 */     this.e = parami.b(4, false);
/* 185 */     this.f = parami.b(5, true);
/* 186 */     this.g = parami.a(this.g, 6, true);
/* 187 */     this.h = ((byte[])parami.c(7, true));
/* 188 */     this.i = parami.b(8, false);
/* 189 */     this.j = parami.b(9, false);
/* 190 */     this.k = ((Map)parami.a(z, 10, false));
/* 191 */     this.l = parami.b(11, false);
/* 192 */     this.m = parami.a(this.m, 12, false);
/* 193 */     this.n = parami.b(13, false);
/* 194 */     this.o = parami.b(14, false);
/* 195 */     this.p = parami.b(15, false);
/* 196 */     this.q = parami.a(this.q, 16, false);
/* 197 */     this.r = parami.b(17, false);
/* 198 */     this.s = parami.b(18, false);
/* 199 */     this.t = parami.b(19, false);
/* 200 */     this.u = parami.b(20, false);
/* 201 */     this.v = parami.b(21, false);
/* 202 */     this.w = parami.b(22, false);
/* 203 */     this.x = parami.b(23, false);
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */