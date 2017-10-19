/*    */ package com.tencent.bugly.proguard;
/*    */ 
/*    */ import java.security.Key;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.spec.IvParameterSpec;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ 
/*    */ public final class ae
/*    */   implements ag
/*    */ {
/* 12 */   private String a = null;
/*    */   
/*    */   public final byte[] a(byte[] paramArrayOfByte)
/*    */     throws Exception
/*    */   {
/* 17 */     if ((this.a == null) || (paramArrayOfByte == null))
/*    */     {
/* 19 */       return null;
/*    */     }
/*    */     
/* 22 */     StringBuffer localStringBuffer = new StringBuffer();
/* 23 */     int j = (localObject = paramArrayOfByte).length; for (int m = 0; m < j; m++) { int i1 = localObject[m];
/*    */       
/* 25 */       localStringBuffer.append(i1 + " ");
/*    */     }
/*    */     
/* 28 */     Object localObject = new SecretKeySpec(this.a.getBytes(), "AES");
/* 29 */     Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
/* 30 */     IvParameterSpec localIvParameterSpec = new IvParameterSpec(this.a.getBytes());
/* 31 */     localCipher.init(2, (Key)localObject, localIvParameterSpec);
/* 32 */     byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte);
/*    */     
/* 34 */     localStringBuffer = new StringBuffer();
/* 35 */     int i = (paramArrayOfByte = arrayOfByte).length; for (int k = 0; k < i; k++) { int n = paramArrayOfByte[k];
/*    */       
/* 37 */       localStringBuffer.append(n + " ");
/*    */     }
/* 39 */     return arrayOfByte;
/*    */   }
/*    */   
/*    */   public final byte[] b(byte[] paramArrayOfByte)
/*    */     throws Exception, NoSuchAlgorithmException
/*    */   {
/* 45 */     if ((this.a == null) || (paramArrayOfByte == null))
/*    */     {
/* 47 */       return null;
/*    */     }
/*    */     
/* 50 */     StringBuffer localStringBuffer = new StringBuffer();
/* 51 */     int j = (localObject = paramArrayOfByte).length; for (int m = 0; m < j; m++) { int i1 = localObject[m];
/*    */       
/* 53 */       localStringBuffer.append(i1 + " ");
/*    */     }
/*    */     
/* 56 */     Object localObject = new SecretKeySpec(this.a.getBytes(), "AES");
/* 57 */     Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
/* 58 */     IvParameterSpec localIvParameterSpec = new IvParameterSpec(this.a.getBytes());
/* 59 */     localCipher.init(1, (Key)localObject, localIvParameterSpec);
/* 60 */     byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte);
/*    */     
/* 62 */     localStringBuffer = new StringBuffer();
/* 63 */     int i = (paramArrayOfByte = arrayOfByte).length; for (int k = 0; k < i; k++) { int n = paramArrayOfByte[k];
/*    */       
/* 65 */       localStringBuffer.append(n + " ");
/*    */     }
/* 67 */     return arrayOfByte;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void a(String paramString)
/*    */   {
/* 79 */     if (paramString != null)
/*    */     {
/* 81 */       for (int i = paramString.length(); i < 16; i++)
/*    */       {
/* 83 */         paramString = paramString + "0";
/*    */       }
/* 85 */       this.a = paramString.substring(0, 16);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */