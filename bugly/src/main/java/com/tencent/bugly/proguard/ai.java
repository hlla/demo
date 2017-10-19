/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ai
/*    */   extends k
/*    */   implements Cloneable
/*    */ {
/* 12 */   private String a = "";
/*    */   
/* 14 */   private ArrayList<String> b = null;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static ArrayList<String> c;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void a(j paramj)
/*    */   {
/* 29 */     paramj.a(this.a, 0);
/* 30 */     if (this.b != null)
/*    */     {
/* 32 */       paramj.a(this.b, 1);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public final void a(i parami)
/*    */   {
/* 40 */     this.a = parami.b(0, true);
/* 41 */     if (c == null)
/*    */     {
/* 43 */       c = new ArrayList();
/* 44 */       String str = "";
/* 45 */       c.add(str);
/*    */     }
/* 47 */     this.b = ((ArrayList)parami.a(c, 1, false));
/*    */   }
/*    */   
/*    */   public final void a(StringBuilder paramStringBuilder, int paramInt) {}
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */