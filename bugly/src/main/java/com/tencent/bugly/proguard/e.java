/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class e
/*    */ {
/* 12 */   private static final char[] a = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String a(byte[] paramArrayOfByte)
/*    */   {
/* 53 */     if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
/*    */     {
/* 55 */       return null;
/*    */     }
/*    */     
/* 58 */     char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
/* 59 */     for (int i = 0; i < paramArrayOfByte.length; i++)
/*    */     {
/* 61 */       int j = paramArrayOfByte[i];
/* 62 */       arrayOfChar[(2 * i + 1)] = a[(j & 0xF)];
/* 63 */       j = (byte)(j >>> 4);
/* 64 */       arrayOfChar[(2 * i)] = a[(j & 0xF)];
/*    */     }
/* 66 */     return new String(arrayOfChar);
/*    */   }
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */