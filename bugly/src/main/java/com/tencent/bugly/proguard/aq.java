/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class aq
/*    */   extends k
/*    */ {
/* 11 */   public long a = 0L;
/*    */   
/* 13 */   public byte b = 0;
/*    */   
/* 15 */   public String c = "";
/*    */   
/* 17 */   public String d = "";
/*    */   
/* 19 */   public String e = "";
/*    */   
/* 21 */   public Map<String, String> f = null;
/*    */   
/* 23 */   public String g = "";
/*    */   
/* 25 */   public boolean h = true;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 55 */     if (this.e != null)
/*    */     {
/* 57 */       paramj.a(this.e, 4);
/*    */     }
/* 59 */     if (this.f != null)
/*    */     {
/* 61 */       paramj.a(this.f, 5);
/*    */     }
/* 63 */     if (this.g != null)
/*    */     {
/* 65 */       paramj.a(this.g, 6);
/*    */     }
/* 67 */     paramj.a(this.h, 7);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/* 72 */   private static Map<String, String> i = new HashMap();
/* 73 */   static { String str1 = "";
/* 74 */     String str2 = "";
/* 75 */     i.put(str1, str2);
/*    */   }
/*    */   
/*    */   public final void a(i parami)
/*    */   {
/* 80 */     this.a = parami.a(this.a, 0, true);
/* 81 */     this.b = parami.a(this.b, 1, true);
/* 82 */     this.c = parami.b(2, false);
/* 83 */     this.d = parami.b(3, false);
/* 84 */     this.e = parami.b(4, false);
/* 85 */     this.f = ((Map)parami.a(i, 5, false));
/* 86 */     this.g = parami.b(6, false);
/* 87 */     this.h = parami.a(7, false);
/*    */   }
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */