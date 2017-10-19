/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public final class ar
/*    */   extends k
/*    */   implements Cloneable
/*    */ {
/* 12 */   public byte a = 0;
/*    */   
/* 14 */   public String b = "";
/*    */   
/* 16 */   public String c = "";
/*    */   
/* 18 */   public ArrayList<aq> d = null;
/*    */   
/* 20 */   public Map<String, String> e = null;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private static ArrayList<aq> f;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private static Map<String, String> g;
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
/* 47 */     if (this.d != null)
/*    */     {
/* 49 */       paramj.a(this.d, 3);
/*    */     }
/* 51 */     if (this.e != null)
/*    */     {
/* 53 */       paramj.a(this.e, 4);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void a(i parami)
/*    */   {
/* 62 */     this.a = parami.a(this.a, 0, true);
/* 63 */     this.b = parami.b(1, false);
/* 64 */     this.c = parami.b(2, false);
/* 65 */     Object localObject; if (f == null)
/*    */     {
/* 67 */       f = new ArrayList();
/* 68 */       localObject = new aq();
/* 69 */       f.add(localObject);
/*    */     }
/* 71 */     this.d = ((ArrayList)parami.a(f, 3, false));
/* 72 */     if (g == null)
/*    */     {
/* 74 */       g = new HashMap();
/* 75 */       localObject = "";
/* 76 */       String str = "";
/* 77 */       g.put(localObject, str);
/*    */     }
/* 79 */     this.e = ((Map)parami.a(g, 4, false));
/*    */   }
/*    */   
/*    */   public final void a(StringBuilder paramStringBuilder, int paramInt) {}
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */