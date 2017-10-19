/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import java.util.HashMap;
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
/*     */ public final class ap
/*     */   extends k
/*     */   implements Cloneable
/*     */ {
/*  21 */   public boolean a = true;
/*     */   
/*  23 */   public boolean b = true;
/*     */   
/*  25 */   public boolean c = true;
/*     */   
/*  27 */   public String d = "";
/*     */   
/*  29 */   public String e = "";
/*     */   
/*  31 */   public ao f = null;
/*     */   
/*  33 */   public Map<String, String> g = null;
/*     */   
/*  35 */   public long h = 0L;
/*     */   
/*  37 */   private String j = "";
/*     */   
/*  39 */   private String k = "";
/*     */   
/*  41 */   private int l = 0;
/*     */   
/*  43 */   public int i = 0;
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
/*     */   private static ao m;
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
/*     */   private static Map<String, String> n;
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
/*     */   public final boolean equals(Object o)
/*     */   {
/* 187 */     if (o == null)
/*     */     {
/* 189 */       return false;
/*     */     }
/*     */     
/* 192 */     o = (ap)o;
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
/* 205 */     return (l.a(this.a, ((ap)o).a)) && (l.a(this.b, ((ap)o).b)) && (l.a(this.c, ((ap)o).c)) && (l.a(this.d, ((ap)o).d)) && (l.a(this.e, ((ap)o).e)) && (l.a(this.f, ((ap)o).f)) && (l.a(this.g, ((ap)o).g)) && (l.a(this.h, ((ap)o).h)) && (l.a(this.j, ((ap)o).j)) && (l.a(this.k, ((ap)o).k)) && (l.a(this.l, ((ap)o).l)) && (l.a(this.i, ((ap)o).i));
/*     */   }
/*     */   
/*     */   public final int hashCode()
/*     */   {
/*     */     try
/*     */     {
/* 212 */       throw new Exception("Need define key first!");
/*     */     }
/*     */     catch (Exception localException2) {
/*     */       Exception localException1;
/* 216 */       (localException1 = localException2).printStackTrace();
/*     */     }
/* 218 */     return 0;
/*     */   }
/*     */   
/*     */   public final Object clone() {
/* 222 */     Object localObject = null;
/*     */     try
/*     */     {
/* 225 */       localObject = super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException localCloneNotSupportedException)
/*     */     {
/* 229 */       if (!o) throw new AssertionError();
/*     */     }
/* 231 */     return localObject;
/*     */   }
/*     */   
/*     */   public final void a(j paramj)
/*     */   {
/* 236 */     paramj.a(this.a, 0);
/* 237 */     paramj.a(this.b, 1);
/* 238 */     paramj.a(this.c, 2);
/* 239 */     if (this.d != null)
/*     */     {
/* 241 */       paramj.a(this.d, 3);
/*     */     }
/* 243 */     if (this.e != null)
/*     */     {
/* 245 */       paramj.a(this.e, 4);
/*     */     }
/* 247 */     if (this.f != null)
/*     */     {
/* 249 */       paramj.a(this.f, 5);
/*     */     }
/* 251 */     if (this.g != null)
/*     */     {
/* 253 */       paramj.a(this.g, 6);
/*     */     }
/* 255 */     paramj.a(this.h, 7);
/* 256 */     if (this.j != null)
/*     */     {
/* 258 */       paramj.a(this.j, 8);
/*     */     }
/* 260 */     if (this.k != null)
/*     */     {
/* 262 */       paramj.a(this.k, 9);
/*     */     }
/* 264 */     paramj.a(this.l, 10);
/* 265 */     paramj.a(this.i, 11);
/*     */   }
/*     */   
/*     */   static
/*     */   {
/* 270 */     m = new ao();
/*     */     
/*     */ 
/*     */ 
/* 274 */     n = new HashMap();
/* 275 */     String str1 = "";
/* 276 */     String str2 = "";
/* 277 */     n.put(str1, str2);
/*     */   }
/*     */   
/*     */   public final void a(i parami)
/*     */   {
/* 282 */     this.a = parami.a(0, true);
/* 283 */     this.b = parami.a(1, true);
/* 284 */     this.c = parami.a(2, true);
/* 285 */     this.d = parami.b(3, false);
/* 286 */     this.e = parami.b(4, false);
/* 287 */     this.f = ((ao)parami.a(m, 5, false));
/* 288 */     this.g = ((Map)parami.a(n, 6, false));
/* 289 */     this.h = parami.a(this.h, 7, false);
/* 290 */     this.j = parami.b(8, false);
/* 291 */     this.k = parami.b(9, false);
/* 292 */     this.l = parami.a(this.l, 10, false);
/* 293 */     this.i = parami.a(this.i, 11, false);
/*     */   }
/*     */   
/*     */ 
/*     */   public final void a(StringBuilder paramStringBuilder, int paramInt)
/*     */   {
/* 299 */     (paramStringBuilder = new h(paramStringBuilder, paramInt)).a(this.a, "enable");
/* 300 */     paramStringBuilder.a(this.b, "enableUserInfo");
/* 301 */     paramStringBuilder.a(this.c, "enableQuery");
/* 302 */     paramStringBuilder.a(this.d, "url");
/* 303 */     paramStringBuilder.a(this.e, "expUrl");
/* 304 */     paramStringBuilder.a(this.f, "security");
/* 305 */     paramStringBuilder.a(this.g, "valueMap");
/* 306 */     paramStringBuilder.a(this.h, "strategylastUpdateTime");
/* 307 */     paramStringBuilder.a(this.j, "httpsUrl");
/* 308 */     paramStringBuilder.a(this.k, "httpsExpUrl");
/* 309 */     paramStringBuilder.a(this.l, "eventRecordCount");
/* 310 */     paramStringBuilder.a(this.i, "eventTimeInterval");
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */