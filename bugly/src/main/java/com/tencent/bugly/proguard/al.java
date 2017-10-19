/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class al
/*    */   extends k
/*    */   implements Cloneable
/*    */ {
/* 12 */   public ArrayList<ak> a = null;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static ArrayList<ak> b;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void a(j paramj)
/*    */   {
/* 27 */     paramj.a(this.a, 0);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public final void a(i parami)
/*    */   {
/* 34 */     if (b == null)
/*    */     {
/* 36 */       b = new ArrayList();
/* 37 */       ak localak = new ak();
/* 38 */       b.add(localak);
/*    */     }
/* 40 */     this.a = ((ArrayList)parami.a(b, 0, true));
/*    */   }
/*    */   
/*    */   public final void a(StringBuilder paramStringBuilder, int paramInt) {}
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */