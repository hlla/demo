/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class aj
/*    */   extends k
/*    */   implements Cloneable
/*    */ {
/* 11 */   private byte a = 0;
/*    */   
/* 13 */   private String b = "";
/*    */   
/* 15 */   private byte[] c = null;
/*    */   
/*    */   private static byte[] d;
/*    */   
/*    */ 
/*    */   public aj() {}
/*    */   
/*    */   public aj(byte paramByte, String paramString, byte[] paramArrayOfByte)
/*    */   {
/* 24 */     this.a = paramByte;
/* 25 */     this.b = paramString;
/* 26 */     this.c = paramArrayOfByte;
/*    */   }
/*    */   
/*    */ 
/*    */   public final void a(j paramj)
/*    */   {
/* 32 */     paramj.a(this.a, 0);
/* 33 */     paramj.a(this.b, 1);
/* 34 */     if (this.c != null)
/*    */     {
/* 36 */       paramj.a(this.c, 2);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public final void a(i parami)
/*    */   {
/* 44 */     this.a = parami.a(this.a, 0, true);
/* 45 */     this.b = parami.b(1, true);
/* 46 */     if (d == null)
/*    */     {
/*    */ 
/* 49 */       ((byte[])(d = (byte[])new byte[1]))[0] = 0;
/*    */     }
/*    */     
/* 52 */     this.c = ((byte[])parami.c(2, false));
/*    */   }
/*    */   
/*    */   public final void a(StringBuilder paramStringBuilder, int paramInt) {}
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */