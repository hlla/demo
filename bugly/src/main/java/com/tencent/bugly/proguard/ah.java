/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ah
/*    */   extends k
/*    */   implements Cloneable
/*    */ {
/* 12 */   public String a = "";
/*    */   
/* 14 */   public String b = "";
/*    */   
/* 16 */   public String c = "";
/*    */   
/* 18 */   private String e = "";
/*    */   
/* 20 */   public String d = "";
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
/* 38 */     paramj.a(this.a, 0);
/* 39 */     if (this.b != null)
/*    */     {
/* 41 */       paramj.a(this.b, 1);
/*    */     }
/* 43 */     if (this.c != null)
/*    */     {
/* 45 */       paramj.a(this.c, 2);
/*    */     }
/* 47 */     if (this.e != null)
/*    */     {
/* 49 */       paramj.a(this.e, 3);
/*    */     }
/* 51 */     if (this.d != null)
/*    */     {
/* 53 */       paramj.a(this.d, 4);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public final void a(i parami)
/*    */   {
/* 60 */     this.a = parami.b(0, true);
/* 61 */     this.b = parami.b(1, false);
/* 62 */     this.c = parami.b(2, false);
/* 63 */     this.e = parami.b(3, false);
/* 64 */     this.d = parami.b(4, false);
/*    */   }
/*    */   
/*    */   public final void a(StringBuilder paramStringBuilder, int paramInt) {}
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */