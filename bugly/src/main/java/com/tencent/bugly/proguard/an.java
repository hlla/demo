/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class an
/*    */   extends k
/*    */ {
/* 11 */   public byte a = 0;
/*    */   
/* 13 */   public int b = 0;
/*    */   
/* 15 */   public byte[] c = null;
/*    */   
/* 17 */   public String d = "";
/*    */   
/* 19 */   public long e = 0L;
/*    */   
/* 21 */   private String h = "";
/*    */   
/* 23 */   public String f = "";
/*    */   
/* 25 */   public Map<String, String> g = null;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static byte[] i;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static Map<String, String> j;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void a(j paramj)
/*    */   {
/* 45 */     paramj.a(this.a, 0);
/* 46 */     paramj.a(this.b, 1);
/* 47 */     if (this.c != null)
/*    */     {
/* 49 */       paramj.a(this.c, 2);
/*    */     }
/* 51 */     if (this.d != null)
/*    */     {
/* 53 */       paramj.a(this.d, 3);
/*    */     }
/* 55 */     paramj.a(this.e, 4);
/* 56 */     if (this.h != null)
/*    */     {
/* 58 */       paramj.a(this.h, 5);
/*    */     }
/* 60 */     if (this.f != null)
/*    */     {
/* 62 */       paramj.a(this.f, 6);
/*    */     }
/* 64 */     if (this.g != null)
/*    */     {
/* 66 */       paramj.a(this.g, 7);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   static
/*    */   {
/* 73 */     ((byte[])(i = (byte[])new byte[1]))[0] = 0;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 78 */     j = new HashMap();
/* 79 */     String str1 = "";
/* 80 */     String str2 = "";
/* 81 */     j.put(str1, str2);
/*    */   }
/*    */   
/*    */   public final void a(i parami)
/*    */   {
/* 86 */     this.a = parami.a(this.a, 0, true);
/* 87 */     this.b = parami.a(this.b, 1, true);
/* 88 */     this.c = ((byte[])parami.c(2, false));
/* 89 */     this.d = parami.b(3, false);
/* 90 */     this.e = parami.a(this.e, 4, false);
/* 91 */     this.h = parami.b(5, false);
/* 92 */     this.f = parami.b(6, false);
/* 93 */     this.g = ((Map)parami.a(j, 7, false));
/*    */   }
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */