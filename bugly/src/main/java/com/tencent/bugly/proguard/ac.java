/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.util.zip.GZIPInputStream;
/*    */ import java.util.zip.GZIPOutputStream;
/*    */ 
/*    */ public final class ac
/*    */   implements ab
/*    */ {
/*    */   public final byte[] a(byte[] paramArrayOfByte) throws Exception
/*    */   {
/* 13 */     ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/*    */     
/*    */     GZIPOutputStream localGZIPOutputStream;
/* 16 */     (localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream)).write(paramArrayOfByte);
/* 17 */     localGZIPOutputStream.finish();
/* 18 */     localGZIPOutputStream.close();
/* 19 */     paramArrayOfByte = localByteArrayOutputStream.toByteArray();
/* 20 */     localByteArrayOutputStream.close();
/* 21 */     return paramArrayOfByte;
/*    */   }
/*    */   
/*    */   public final byte[] b(byte[] paramArrayOfByte) throws Exception
/*    */   {
/* 26 */     ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
/*    */     
/* 28 */     GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
/* 29 */     paramArrayOfByte = new byte['Ѐ'];
/* 30 */     int i = 0;
/* 31 */     ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 32 */     while ((i = localGZIPInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length)) != -1)
/*    */     {
/* 34 */       localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
/*    */     }
/* 36 */     paramArrayOfByte = localByteArrayOutputStream.toByteArray();
/* 37 */     localByteArrayOutputStream.flush();
/* 38 */     localByteArrayOutputStream.close();
/* 39 */     localGZIPInputStream.close();
/* 40 */     localByteArrayInputStream.close();
/* 41 */     return paramArrayOfByte;
/*    */   }
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */