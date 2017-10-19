/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import java.util.Map;
/*     */ 
/*     */ public final class f extends k
/*     */ {
/*   7 */   public short a = 0;
/*     */   
/*   9 */   private byte f = 0;
/*     */   
/*  11 */   private int g = 0;
/*     */   
/*  13 */   public int b = 0;
/*     */   
/*  15 */   public String c = null;
/*     */   
/*  17 */   public String d = null;
/*     */   
/*     */   public byte[] e;
/*     */   
/*  21 */   private int h = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<String, String> i;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<String, String> j;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean equals(Object o)
/*     */   {
/*  47 */     o = (f)o;
/*  48 */     return (l.a(1, ((f)o).a)) && (l.a(1, ((f)o).f)) && (l.a(1, ((f)o).g)) && (l.a(1, ((f)o).b)) && (l.a(Integer.valueOf(1), ((f)o).c)) && (l.a(Integer.valueOf(1), ((f)o).d)) && (l.a(Integer.valueOf(1), ((f)o).e)) && (l.a(1, ((f)o).h)) && (l.a(Integer.valueOf(1), ((f)o).i)) && (l.a(Integer.valueOf(1), ((f)o).j));
/*     */   }
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
/*     */   public final Object clone()
/*     */   {
/*  63 */     Object localObject = null;
/*     */     try
/*     */     {
/*  66 */       localObject = super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException localCloneNotSupportedException)
/*     */     {
/*  70 */       if (!m) throw new AssertionError();
/*     */     }
/*  72 */     return localObject;
/*     */   }
/*     */   
/*     */   public final void a(j paramj)
/*     */   {
/*  77 */     paramj.a(this.a, 1);
/*  78 */     paramj.a(this.f, 2);
/*  79 */     paramj.a(this.g, 3);
/*  80 */     paramj.a(this.b, 4);
/*  81 */     paramj.a(this.c, 5);
/*  82 */     paramj.a(this.d, 6);
/*  83 */     paramj.a(this.e, 7);
/*  84 */     paramj.a(this.h, 8);
/*  85 */     paramj.a(this.i, 9);
/*  86 */     paramj.a(this.j, 10);
/*     */   }
/*     */   
/*     */ 
/*  90 */   private static byte[] k = null;
/*  91 */   private static Map<String, String> l = null;
/*     */   
/*     */   public final void a(i parami)
/*     */   {
/*     */     try {
/*  96 */       this.a = parami.a(this.a, 1, true);
/*  97 */       this.f = parami.a(this.f, 2, true);
/*  98 */       this.g = parami.a(this.g, 3, true);
/*  99 */       this.b = parami.a(this.b, 4, true);
/* 100 */       this.c = parami.b(5, true);
/* 101 */       this.d = parami.b(6, true);
/* 102 */       if (k == null) {
/* 103 */         k = new byte[] { 0 };
/*     */       }
/* 105 */       this.e = ((byte[])parami.c(7, true));
/* 106 */       this.h = parami.a(this.h, 8, true);
/* 107 */       if (l == null)
/*     */       {
/* 109 */         (l = new java.util.HashMap()).put("", "");
/*     */       }
/* 111 */       this.i = ((Map)parami.a(l, 9, true));
/* 112 */       if (l == null)
/*     */       {
/* 114 */         (l = new java.util.HashMap()).put("", "");
/*     */       }
/* 116 */       this.j = ((Map)parami.a(l, 10, true));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 121 */       return;
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 118 */       (parami = 
/*     */       
/*     */ 
/* 121 */         localException).printStackTrace();System.out.println("RequestPacket decode error " + e.a(this.e));throw new RuntimeException(parami);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void a(StringBuilder paramStringBuilder, int paramInt)
/*     */   {
/* 129 */     (paramStringBuilder = new h(paramStringBuilder, paramInt)).a(this.a, "iVersion");
/* 130 */     paramStringBuilder.a(this.f, "cPacketType");
/* 131 */     paramStringBuilder.a(this.g, "iMessageType");
/* 132 */     paramStringBuilder.a(this.b, "iRequestId");
/* 133 */     paramStringBuilder.a(this.c, "sServantName");
/* 134 */     paramStringBuilder.a(this.d, "sFuncName");
/* 135 */     paramStringBuilder.a(this.e, "sBuffer");
/* 136 */     paramStringBuilder.a(this.h, "iTimeout");
/* 137 */     paramStringBuilder.a(this.i, "context");
/* 138 */     paramStringBuilder.a(this.j, "status");
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */