/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipInputStream;
/*    */ import java.util.zip.ZipOutputStream;
/*    */ 
/*    */ public final class ad
/*    */   implements ab
/*    */ {
/*    */   public final byte[] a(byte[] paramArrayOfByte) throws Exception
/*    */   {
/* 14 */     ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/*    */     
/* 16 */     ZipOutputStream localZipOutputStream = new ZipOutputStream(localByteArrayOutputStream);
/*    */     ZipEntry localZipEntry;
/* 18 */     (localZipEntry = new ZipEntry("zip")).setSize(paramArrayOfByte.length);
/* 19 */     localZipOutputStream.putNextEntry(localZipEntry);
/* 20 */     localZipOutputStream.write(paramArrayOfByte);
/* 21 */     localZipOutputStream.closeEntry();
/* 22 */     localZipOutputStream.close();
/* 23 */     paramArrayOfByte = localByteArrayOutputStream.toByteArray();
/* 24 */     localByteArrayOutputStream.close();
/* 25 */     return paramArrayOfByte;
/*    */   }
/*    */   
/*    */   public final byte[] b(byte[] paramArrayOfByte) throws Exception
/*    */   {
/* 30 */     byte[] arrayOfByte = null;
/* 31 */     paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
/* 32 */     ZipInputStream localZipInputStream = new ZipInputStream(paramArrayOfByte);
/* 33 */     while (localZipInputStream.getNextEntry() != null)
/*    */     {
/* 35 */       arrayOfByte = new byte['Ѐ'];
/* 36 */       int i = 0;
/* 37 */       ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 38 */       while ((i = localZipInputStream.read(arrayOfByte, 0, arrayOfByte.length)) != -1)
/*    */       {
/* 40 */         localByteArrayOutputStream.write(arrayOfByte, 0, i);
/*    */       }
/* 42 */       arrayOfByte = localByteArrayOutputStream.toByteArray();
/* 43 */       localByteArrayOutputStream.flush();
/* 44 */       localByteArrayOutputStream.close();
/*    */     }
/* 46 */     localZipInputStream.close();
/* 47 */     paramArrayOfByte.close();
/* 48 */     return arrayOfByte;
/*    */   }
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */