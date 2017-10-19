/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ import java.security.Key;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import java.security.spec.KeySpec;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.SecretKeyFactory;
/*    */ import javax.crypto.spec.DESKeySpec;
/*    */ import javax.crypto.spec.IvParameterSpec;
/*    */ 
/*    */ public final class af implements ag
/*    */ {
/* 13 */   private String a = null;
/*    */   
/*    */   public final byte[] a(byte[] paramArrayOfByte) throws Exception
/*    */   {
/* 17 */     if ((this.a == null) || (paramArrayOfByte == null))
/* 18 */       return null;
/* 19 */     Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
/*    */     
/* 21 */     Object localObject = new DESKeySpec(this.a.getBytes("UTF-8"));
/* 22 */     localObject = SecretKeyFactory.getInstance("DES").generateSecret((KeySpec)localObject);
/* 23 */     IvParameterSpec localIvParameterSpec = new IvParameterSpec(this.a.getBytes("UTF-8"));
/* 24 */     localCipher.init(2, (Key)localObject, localIvParameterSpec);
/*    */     
/* 26 */     return paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
/*    */   }
/*    */   
/*    */   public final byte[] b(byte[] paramArrayOfByte) throws Exception, NoSuchAlgorithmException
/*    */   {
/* 31 */     if ((this.a == null) || (paramArrayOfByte == null))
/* 32 */       return null;
/* 33 */     Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
/*    */     
/* 35 */     Object localObject = new DESKeySpec(this.a.getBytes("UTF-8"));
/* 36 */     localObject = SecretKeyFactory.getInstance("DES").generateSecret((KeySpec)localObject);
/* 37 */     IvParameterSpec localIvParameterSpec = new IvParameterSpec(this.a.getBytes("UTF-8"));
/* 38 */     localCipher.init(1, (Key)localObject, localIvParameterSpec);
/*    */     
/* 40 */     return paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void a(String paramString)
/*    */   {
/* 50 */     if (paramString != null)
/*    */     {
/* 52 */       this.a = paramString;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */