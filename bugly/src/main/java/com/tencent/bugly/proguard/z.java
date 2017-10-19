/*      */ package com.tencent.bugly.proguard;
/*      */ 
/*      */ import android.annotation.TargetApi;
/*      */ import android.content.Context;
/*      */ import android.content.SharedPreferences;
/*      */ import android.os.Build.VERSION;
/*      */ import android.os.Bundle;
/*      */ import android.os.Parcel;
/*      */ import android.os.Parcelable;
/*      */ import android.os.Parcelable.Creator;
/*      */ import com.tencent.bugly.crashreport.common.info.AppInfo;
/*      */ import com.tencent.bugly.crashreport.common.info.PlugInBean;
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.DataInputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.io.PrintWriter;
/*      */ import java.io.StringWriter;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.io.Writer;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.security.InvalidAlgorithmParameterException;
/*      */ import java.security.Key;
/*      */ import java.security.KeyFactory;
/*      */ import java.security.MessageDigest;
/*      */ import java.security.SecureRandom;
/*      */ import java.security.spec.X509EncodedKeySpec;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.TimeZone;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import java.util.zip.ZipEntry;
/*      */ import java.util.zip.ZipOutputStream;
/*      */ import javax.crypto.Cipher;
/*      */ import javax.crypto.KeyGenerator;
/*      */ import javax.crypto.SecretKey;
/*      */ import javax.crypto.spec.GCMParameterSpec;
/*      */ import javax.crypto.spec.IvParameterSpec;
/*      */ import javax.crypto.spec.SecretKeySpec;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class z
/*      */ {
/*      */   public static String a(Throwable paramThrowable)
/*      */   {
/*   80 */     if (paramThrowable == null) {
/*   81 */       return "";
/*      */     }
/*      */     try
/*      */     {
/*   85 */       localObject = new StringWriter();
/*   86 */       paramThrowable.printStackTrace(new PrintWriter((Writer)localObject));
/*   87 */       return ((StringWriter)localObject).getBuffer().toString();
/*      */     } catch (Throwable localThrowable) { Object localObject;
/*   89 */       if (!x.a(localObject = localThrowable)) {
/*   90 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*      */     
/*   94 */     return "fail";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String a()
/*      */   {
/*  103 */     return a(System.currentTimeMillis());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static String a(long paramLong)
/*      */   {
/*      */     try
/*      */     {
/*      */       SimpleDateFormat localSimpleDateFormat;
/*      */       
/*  114 */       return (localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)).format(new Date(paramLong));
/*      */     } catch (Exception localException) {}
/*  116 */     return new Date().toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String a(Date paramDate)
/*      */   {
/*  127 */     if (paramDate == null) {
/*  128 */       return null;
/*      */     }
/*      */     try {
/*      */       SimpleDateFormat localSimpleDateFormat;
/*  132 */       return (localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)).format(paramDate);
/*      */     } catch (Exception localException) {}
/*  134 */     return new Date().toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
/*      */   {
/*  143 */     if ((paramArrayOfByte == null) || (paramInt == -1)) {
/*  144 */       return paramArrayOfByte;
/*      */     }
/*      */     
/*  147 */     x.c("rqdp{  enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
/*      */     
/*  149 */     Object localObject = null;
/*  150 */     localObject = null;
/*      */     try
/*      */     {
/*  153 */       if ((localObject = a.a(paramInt)) == null) {
/*  154 */         return null;
/*      */       }
/*      */       
/*  157 */       ((ag)localObject).a(paramString);
/*      */       
/*  159 */       return localObject = ((ag)localObject).b(paramArrayOfByte);
/*      */     }
/*      */     catch (Throwable localThrowable) {
/*  162 */       if (!x.a(paramArrayOfByte = localThrowable))
/*  163 */         paramArrayOfByte.printStackTrace();
/*      */     }
/*  165 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static byte[] b(byte[] paramArrayOfByte, int paramInt, String paramString)
/*      */   {
/*  173 */     if ((paramArrayOfByte == null) || (paramInt == -1)) {
/*  174 */       return paramArrayOfByte;
/*      */     }
/*      */     
/*  177 */     Object localObject = null;
/*  178 */     localObject = null;
/*      */     try
/*      */     {
/*  181 */       if ((localObject = a.a(paramInt)) == null) {
/*  182 */         return null;
/*      */       }
/*      */       
/*  185 */       ((ag)localObject).a(paramString);
/*      */       
/*      */ 
/*  188 */       return localObject = ((ag)localObject).a(paramArrayOfByte);
/*      */     }
/*      */     catch (Throwable localThrowable) {
/*  191 */       if (!x.a(paramArrayOfByte = localThrowable)) {
/*  192 */         paramArrayOfByte.printStackTrace();
/*      */       }
/*  194 */       x.d("encrytype %d %s", new Object[] { Integer.valueOf(paramInt), paramString }); }
/*  195 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static byte[] a(File paramFile, String paramString1, String paramString2)
/*      */   {
/*  203 */     x.c("rqdp{  ZF start}", new Object[0]);
/*      */     
/*  205 */     FileInputStream localFileInputStream = null;
/*  206 */     ZipOutputStream localZipOutputStream = null;
/*      */     try
/*      */     {
/*  209 */       if ((paramFile != null) && (paramFile.exists()) && (paramFile.canRead())) {
/*  210 */         localFileInputStream = new FileInputStream(paramFile);
/*  211 */         paramString2 = paramFile.getName();
/*      */       }
/*  213 */       paramFile = paramString1.getBytes("UTF-8");
/*  214 */       paramFile = new ByteArrayInputStream(paramFile);
/*  215 */       paramString1 = new ByteArrayOutputStream();
/*  216 */       (
/*  217 */         localZipOutputStream = new ZipOutputStream(paramString1)).setMethod(8);
/*  218 */       paramString2 = new ZipEntry(paramString2);
/*  219 */       localZipOutputStream.putNextEntry(paramString2);
/*      */       
/*  221 */       paramString2 = new byte['Ѐ'];
/*      */       int i;
/*  223 */       if (localFileInputStream != null) {
/*  224 */         while ((i = localFileInputStream.read(paramString2)) > 0) {
/*  225 */           localZipOutputStream.write(paramString2, 0, i);
/*      */         }
/*      */       }
/*  228 */       while ((i = paramFile.read(paramString2)) > 0) {
/*  229 */         localZipOutputStream.write(paramString2, 0, i);
/*      */       }
/*  231 */       localZipOutputStream.closeEntry();
/*  232 */       localZipOutputStream.flush();
/*  233 */       localZipOutputStream.finish();
/*  234 */       paramFile = paramString1.toByteArray();
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  241 */       if (localFileInputStream != null) {
/*      */         try {
/*  243 */           localFileInputStream.close();
/*      */         } catch (IOException localIOException1) {
/*  245 */           (paramString1 = 
/*  246 */             localIOException1).printStackTrace();
/*      */         }
/*      */       }
/*      */       try {
/*  249 */         localZipOutputStream.close();
/*      */       }
/*      */       catch (IOException localIOException2)
/*      */       {
/*  253 */         (paramString1 = 
/*  254 */           localIOException2).printStackTrace();
/*      */       }
/*      */       
/*  256 */       x.c("rqdp{  ZF end}", new Object[0]);return paramFile;
/*      */     }
/*      */     catch (Throwable localThrowable)
/*      */     {
/*  237 */       paramFile.printStackTrace();
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  256 */       return null;
/*      */     }
/*      */     finally
/*      */     {
/*  241 */       if (localFileInputStream != null) {
/*      */         try {
/*  243 */           localFileInputStream.close();
/*      */         } catch (IOException localIOException5) {
/*  245 */           (paramString1 = 
/*  246 */             localIOException5).printStackTrace();
/*      */         }
/*      */       }
/*      */       
/*  249 */       if (localZipOutputStream != null) {
/*      */         try {
/*  251 */           localZipOutputStream.close();
/*      */         } catch (IOException localIOException6) {
/*  253 */           (paramString1 = 
/*  254 */             localIOException6).printStackTrace();
/*      */         }
/*      */       }
/*  256 */       x.c("rqdp{  ZF end}", new Object[0]);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static byte[] a(byte[] paramArrayOfByte, int paramInt)
/*      */   {
/*  269 */     if ((paramArrayOfByte == null) || (paramInt == -1)) {
/*  270 */       return paramArrayOfByte;
/*      */     }
/*      */     
/*  273 */     x.c("[Util] Zip %d bytes data with type %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), paramInt == 2 ? "Gzip" : "zip" });
/*      */     
/*      */ 
/*  276 */     Object localObject = null;
/*  277 */     localObject = null;
/*      */     
/*      */     try
/*      */     {
/*  281 */       if ((localObject = aa.a(paramInt)) == null) {
/*  282 */         return null;
/*      */       }
/*      */       
/*      */ 
/*  286 */       return localObject = ((ab)localObject).a(paramArrayOfByte);
/*      */     }
/*      */     catch (Throwable localThrowable) {
/*  289 */       if (!x.a(paramArrayOfByte = localThrowable))
/*  290 */         paramArrayOfByte.printStackTrace();
/*      */     }
/*  292 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static byte[] b(byte[] paramArrayOfByte, int paramInt)
/*      */   {
/*  305 */     if ((paramArrayOfByte == null) || (paramInt == -1)) {
/*  306 */       return paramArrayOfByte;
/*      */     }
/*      */     
/*  309 */     x.c("[Util] Unzip %d bytes data with type %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), paramInt == 2 ? "Gzip" : "zip" });
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     try
/*      */     {
/*  317 */       if ((paramInt = aa.a(paramInt)) == null) {
/*  318 */         return null;
/*      */       }
/*      */       
/*      */ 
/*  322 */       return paramArrayOfByte = paramInt.b(paramArrayOfByte);
/*      */     }
/*      */     catch (Throwable localThrowable) {
/*  325 */       if (!x.a(paramArrayOfByte = localThrowable))
/*  326 */         paramArrayOfByte.printStackTrace();
/*      */     }
/*  328 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
/*      */   {
/*  337 */     if (paramArrayOfByte == null) {
/*  338 */       return null;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     try
/*      */     {
/*  346 */       return paramArrayOfByte = a(paramArrayOfByte = a(paramArrayOfByte, 2), 1, paramString);
/*      */     } catch (Throwable localThrowable) {
/*  348 */       if (!x.a(paramArrayOfByte = localThrowable))
/*  349 */         paramArrayOfByte.printStackTrace();
/*      */     }
/*  351 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
/*      */   {
/*      */     try
/*      */     {
/*  371 */       return paramArrayOfByte = b(paramArrayOfByte = b(paramArrayOfByte, 1, paramString), 2);
/*      */     } catch (Exception localException) {
/*  373 */       if (!x.a(paramArrayOfByte = localException))
/*  374 */         paramArrayOfByte.printStackTrace();
/*      */     }
/*  376 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long b()
/*      */   {
/*      */     try
/*      */     {
/*      */       long l;
/*      */       
/*      */ 
/*      */ 
/*  391 */       return (l = System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000L * 86400000L - TimeZone.getDefault().getRawOffset();
/*      */     } catch (Throwable localThrowable2) {
/*      */       Throwable localThrowable1;
/*  394 */       if (!x.a(localThrowable1 = localThrowable2)) {
/*  395 */         localThrowable1.printStackTrace();
/*      */       }
/*      */     }
/*  398 */     return -1L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static String a(byte[] paramArrayOfByte)
/*      */   {
/*  405 */     if (paramArrayOfByte == null) {
/*  406 */       return "";
/*      */     }
/*      */     
/*  409 */     StringBuffer localStringBuffer = new StringBuffer();
/*  410 */     String str = null;
/*  411 */     for (int i = 0; i < paramArrayOfByte.length; i++)
/*      */     {
/*  413 */       if ((str = Integer.toHexString(paramArrayOfByte[i] & 0xFF)).length() == 1) {
/*  414 */         localStringBuffer.append("0");
/*      */       }
/*  416 */       localStringBuffer.append(str);
/*      */     }
/*  418 */     return localStringBuffer.toString().toUpperCase();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String b(byte[] paramArrayOfByte)
/*      */   {
/*  428 */     if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
/*  429 */       return "NULL";
/*      */     }
/*      */     
/*  432 */     MessageDigest localMessageDigest = null;
/*      */     try
/*      */     {
/*  435 */       (localMessageDigest = MessageDigest.getInstance("SHA-1")).update(paramArrayOfByte);
/*  436 */       return a(localMessageDigest.digest());
/*      */     } catch (Throwable localThrowable) {
/*  438 */       if (!x.a(paramArrayOfByte = localThrowable))
/*  439 */         paramArrayOfByte.printStackTrace();
/*      */     }
/*  441 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean a(File paramFile1, File paramFile2, int paramInt)
/*      */   {
/*  496 */     x.c("rqdp{  ZF start}", new Object[0]);
/*  497 */     if ((paramFile1 == null) || (paramFile2 == null) || (paramFile1.equals(paramFile2))) {
/*  498 */       x.d("rqdp{  err ZF 1R!}", new Object[0]);
/*  499 */       return false;
/*      */     }
/*      */     
/*  502 */     if ((!paramFile1.exists()) || (!paramFile1.canRead())) {
/*  503 */       x.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
/*  504 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  508 */       if ((paramFile2.getParentFile() != null) && (!paramFile2.getParentFile().exists())) {
/*  509 */         paramFile2.getParentFile().mkdirs();
/*      */       }
/*      */       
/*  512 */       if (!paramFile2.exists()) {
/*  513 */         paramFile2.createNewFile();
/*      */       }
/*      */     }
/*      */     catch (Throwable localThrowable1) {
/*  517 */       if (!x.a(paramInt = 
/*      */       
/*      */ 
/*  520 */         localThrowable1)) {
/*  518 */         paramInt.printStackTrace();
/*      */       }
/*      */     }
/*      */     
/*  522 */     if ((!paramFile2.exists()) || (!paramFile2.canRead())) {
/*  523 */       return false;
/*      */     }
/*      */     
/*  526 */     paramInt = null;
/*  527 */     ZipOutputStream localZipOutputStream = null;
/*      */     try {
/*  529 */       paramInt = new FileInputStream(paramFile1);
/*  530 */       (
/*  531 */         localZipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramFile2)))).setMethod(8);
/*  532 */       paramFile1 = new ZipEntry(paramFile1.getName());
/*  533 */       localZipOutputStream.putNextEntry(paramFile1);
/*      */       
/*  535 */       paramFile1 = new byte['ᎈ'];
/*      */       
/*      */ 
/*  538 */       while ((paramFile2 = paramInt.read(paramFile1)) > 0) {
/*  539 */         localZipOutputStream.write(paramFile1, 0, paramFile2);
/*      */       }
/*  541 */       localZipOutputStream.flush();
/*  542 */       localZipOutputStream.closeEntry();
/*  543 */       try { paramInt.close();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*      */       catch (IOException localIOException1)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  554 */         (paramFile1 = 
/*  555 */           localIOException1).printStackTrace();
/*      */       }
/*      */       try
/*      */       {
/*  558 */         localZipOutputStream.close();
/*      */       }
/*      */       catch (IOException localIOException2)
/*      */       {
/*  562 */         (paramFile1 = 
/*  563 */           localIOException2).printStackTrace();
/*      */       }
/*      */       
/*  565 */       x.c("rqdp{  ZF end}", new Object[0]);return true;
/*      */     }
/*      */     catch (Throwable localThrowable2)
/*      */     {
/*  546 */       paramFile1.printStackTrace();
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  565 */       return false;
/*      */     }
/*      */     finally
/*      */     {
/*  550 */       if (paramInt != null) {
/*      */         try {
/*  552 */           paramInt.close();
/*      */         } catch (IOException localIOException5) {
/*  554 */           (paramFile2 = 
/*  555 */             localIOException5).printStackTrace();
/*      */         }
/*      */       }
/*      */       
/*  558 */       if (localZipOutputStream != null) {
/*      */         try {
/*  560 */           localZipOutputStream.close();
/*      */         } catch (IOException localIOException6) {
/*  562 */           (paramFile2 = 
/*  563 */             localIOException6).printStackTrace();
/*      */         }
/*      */       }
/*  565 */       x.c("rqdp{  ZF end}", new Object[0]);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static ArrayList<String> a(Context paramContext, String[] paramArrayOfString)
/*      */   {
/*  573 */     String str = null;
/*  574 */     localArrayList = new ArrayList();
/*  575 */     Process localProcess = null;
/*  576 */     BufferedReader localBufferedReader1 = null;
/*  577 */     BufferedReader localBufferedReader2 = null;
/*  578 */     if (com.tencent.bugly.crashreport.common.info.a.a(paramContext).H())
/*      */     {
/*  580 */       (paramContext = new ArrayList()).add(new String("unknown(low memory)"));
/*  581 */       return paramContext;
/*      */     }
/*      */     try {
/*  584 */       localProcess = Runtime.getRuntime().exec(paramArrayOfString);
/*  585 */       localBufferedReader1 = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
/*  586 */       while ((str = localBufferedReader1.readLine()) != null) {
/*  587 */         localArrayList.add(str);
/*      */       }
/*      */       
/*  590 */       localBufferedReader2 = new BufferedReader(new InputStreamReader(localProcess.getErrorStream()));
/*  591 */       while ((str = localBufferedReader2.readLine()) != null) {
/*  592 */         localArrayList.add(str);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */       try
/*      */       {
/*  600 */         localBufferedReader1.close();
/*      */       }
/*      */       catch (IOException localIOException1)
/*      */       {
/*  604 */         (paramContext = 
/*  605 */           localIOException1).printStackTrace();
/*      */       }
/*      */       try
/*      */       {
/*  608 */         localBufferedReader2.close();
/*      */       }
/*      */       catch (IOException localIOException2)
/*      */       {
/*  612 */         (paramContext = 
/*  613 */           localIOException2).printStackTrace();
/*      */       }
/*      */       
/*      */ 
/*  616 */       return localArrayList;
/*      */     }
/*      */     catch (Throwable localThrowable)
/*      */     {
/*  596 */       paramContext.printStackTrace();
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  613 */       return null;
/*      */     }
/*      */     finally
/*      */     {
/*  600 */       if (localBufferedReader1 != null) {
/*      */         try {
/*  602 */           localBufferedReader1.close();
/*      */         } catch (IOException localIOException5) {
/*  604 */           (paramArrayOfString = 
/*  605 */             localIOException5).printStackTrace();
/*      */         }
/*      */       }
/*      */       
/*  608 */       if (localBufferedReader2 != null) {
/*      */         try {
/*  610 */           localBufferedReader2.close();
/*      */         } catch (IOException localIOException6) {
/*  612 */           (paramArrayOfString = 
/*  613 */             localIOException6).printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*  619 */   private static Map<String, String> a = null;
/*      */   
/*      */ 
/*      */ 
/*      */   public static String a(Context paramContext, String paramString)
/*      */   {
/*  625 */     if ((paramString == null) || (paramString.trim().equals(""))) {
/*  626 */       return "";
/*      */     }
/*  628 */     if (a == null) {
/*  629 */       a = new HashMap();
/*      */       
/*      */ 
/*  632 */       if (((paramContext = a(paramContext, new String[] { "/system/bin/sh", "-c", "getprop" })) != null) && (paramContext.size() > 0)) {
/*  633 */         x.b(z.class, "Successfully get 'getprop' list.", new Object[0]);
/*  634 */         Pattern localPattern = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
/*  635 */         for (Object localObject : paramContext)
/*      */         {
/*  637 */           if ((localObject = localPattern.matcher((CharSequence)localObject)).find()) {
/*  638 */             a.put(((Matcher)localObject).group(1), ((Matcher)localObject).group(2));
/*      */           }
/*      */         }
/*  641 */         x.b(z.class, "System properties number: %dffffdsfsdfff.", new Object[] { Integer.valueOf(a.size()) });
/*      */       }
/*      */     }
/*      */     
/*  645 */     if (a.containsKey(paramString))
/*      */     {
/*  647 */       return (String)a.get(paramString);
/*      */     }
/*      */     
/*  650 */     return "fail";
/*      */   }
/*      */   
/*      */ 
/*      */   public static void b(long paramLong)
/*      */   {
/*      */     try
/*      */     {
/*  658 */       Thread.sleep(paramLong); return;
/*      */     } catch (InterruptedException localInterruptedException) {
/*  660 */       (paramLong = 
/*  661 */         localInterruptedException).printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean a(String paramString)
/*      */   {
/*  718 */     if ((paramString != null) && (paramString.trim().length() > 0)) {
/*  719 */       return false;
/*      */     }
/*  721 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void b(String paramString)
/*      */   {
/*  730 */     if (paramString == null) {
/*  731 */       return;
/*      */     }
/*      */     
/*      */ 
/*  735 */     if (((paramString = new File(paramString)).isFile()) && (paramString.exists()) && (paramString.canWrite())) {
/*  736 */       paramString.delete();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static byte[] c(long paramLong)
/*      */   {
/*      */     try
/*      */     {
/*  745 */       return paramLong.getBytes("utf-8");
/*      */     } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
/*  747 */       (paramLong = localUnsupportedEncodingException).printStackTrace();
/*      */     }
/*  749 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long c(byte[] paramArrayOfByte)
/*      */   {
/*  759 */     if (paramArrayOfByte == null) {
/*  760 */       return -1L;
/*      */     }
/*      */     try
/*      */     {
/*  764 */       return Long.parseLong(new String(paramArrayOfByte, "utf-8"));
/*      */     } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
/*  766 */       (paramArrayOfByte = localUnsupportedEncodingException).printStackTrace();
/*      */     }
/*  768 */     return -1L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static Context a(Context paramContext)
/*      */   {
/*  775 */     if (paramContext == null) {
/*  776 */       return paramContext;
/*      */     }
/*      */     Context localContext;
/*  779 */     if ((localContext = paramContext.getApplicationContext()) == null) return paramContext; return localContext;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String b(Throwable paramThrowable)
/*      */   {
/*  790 */     if (paramThrowable == null) {
/*  791 */       return "";
/*      */     }
/*      */     
/*  794 */     StringWriter localStringWriter = new StringWriter();
/*  795 */     PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
/*  796 */     paramThrowable.printStackTrace(localPrintWriter);
/*  797 */     localPrintWriter.flush();
/*  798 */     return localStringWriter.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void a(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2)
/*      */   {
/*      */     try
/*      */     {
/*  836 */       (paramClass = paramClass.getDeclaredField(paramString)).setAccessible(true);
/*  837 */       paramClass.set(null, paramObject1);
/*      */       
/*      */ 
/*  840 */       return;
/*      */     }
/*      */     catch (Exception localException) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Object a(String paramString1, String paramString2, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
/*      */   {
/*      */     try
/*      */     {
/*  858 */       (paramString1 = (paramString1 = Class.forName(paramString1)).getDeclaredMethod(paramString2, paramArrayOfClass)).setAccessible(true);
/*  859 */       return paramString1.invoke(null, paramArrayOfObject);
/*      */     } catch (Exception localException) {}
/*  861 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void a(Parcel paramParcel, Map<String, PlugInBean> paramMap)
/*      */   {
/*  872 */     if ((paramMap == null) || (paramMap.size() <= 0)) {
/*  873 */       paramParcel.writeBundle(null);
/*  874 */       return;
/*      */     }
/*  876 */     int i = paramMap.size();
/*  877 */     ArrayList localArrayList2 = new ArrayList(i);
/*  878 */     ArrayList localArrayList1 = new ArrayList(i);
/*  879 */     for (Map.Entry localEntry : paramMap.entrySet()) {
/*  880 */       localArrayList2.add(localEntry.getKey());
/*  881 */       localArrayList1.add(localEntry.getValue());
/*      */     }
/*      */     
/*  884 */     (paramMap = new Bundle()).putInt("pluginNum", localArrayList2.size());
/*  885 */     for (int j = 0; j < localArrayList2.size(); j++) {
/*  886 */       paramMap.putString("pluginKey" + j, (String)localArrayList2.get(j));
/*      */     }
/*  888 */     for (j = 0; j < localArrayList2.size(); j++) {
/*  889 */       paramMap.putString("pluginVal" + j + "plugInId", ((PlugInBean)localArrayList1.get(j)).a);
/*  890 */       paramMap.putString("pluginVal" + j + "plugInUUID", ((PlugInBean)localArrayList1.get(j)).c);
/*  891 */       paramMap.putString("pluginVal" + j + "plugInVersion", ((PlugInBean)localArrayList1.get(j)).b);
/*      */     }
/*  893 */     paramParcel.writeBundle(paramMap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<String, PlugInBean> a(Parcel paramParcel)
/*      */   {
/*  904 */     if ((paramParcel = paramParcel.readBundle()) == null) {
/*  905 */       return null;
/*      */     }
/*  907 */     ArrayList localArrayList1 = new ArrayList();
/*  908 */     ArrayList localArrayList2 = new ArrayList();
/*  909 */     int i = ((Integer)paramParcel.get("pluginNum")).intValue();
/*  910 */     for (int j = 0; j < i; j++) {
/*  911 */       localArrayList1.add(paramParcel.getString("pluginKey" + j));
/*      */     }
/*  913 */     for (j = 0; j < i; j++) {
/*  914 */       String str1 = paramParcel.getString("pluginVal" + j + "plugInId");
/*  915 */       String str2 = paramParcel.getString("pluginVal" + j + "plugInUUID");
/*  916 */       String str3 = paramParcel.getString("pluginVal" + j + "plugInVersion");
/*  917 */       localArrayList2.add(new PlugInBean(str1, str3, str2));
/*      */     }
/*  919 */     HashMap localHashMap = null;
/*      */     
/*  921 */     if (localArrayList1.size() == localArrayList2.size()) {
/*  922 */       localHashMap = new HashMap(localArrayList1.size());
/*  923 */       for (int k = 0; k < localArrayList1.size(); k++) {
/*  924 */         localHashMap.put(localArrayList1.get(k), PlugInBean.class.cast(localArrayList2.get(k)));
/*      */       }
/*      */     } else {
/*  927 */       x.e("map plugin parcel error!", new Object[0]);
/*      */     }
/*      */     
/*  930 */     return localHashMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void b(Parcel paramParcel, Map<String, String> paramMap)
/*      */   {
/*  940 */     if ((paramMap == null) || (paramMap.size() <= 0)) {
/*  941 */       paramParcel.writeBundle(null);
/*  942 */       return;
/*      */     }
/*      */     
/*  945 */     int i = paramMap.size();
/*      */     
/*  947 */     ArrayList localArrayList2 = new ArrayList(i);
/*  948 */     ArrayList localArrayList1 = new ArrayList(i);
/*  949 */     for (Map.Entry localEntry : paramMap.entrySet()) {
/*  950 */       localArrayList2.add(localEntry.getKey());
/*  951 */       localArrayList1.add(localEntry.getValue());
/*      */     }
/*      */     
/*  954 */     (paramMap = new Bundle()).putStringArrayList("keys", localArrayList2);
/*  955 */     paramMap.putStringArrayList("values", localArrayList1);
/*  956 */     paramParcel.writeBundle(paramMap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<String, String> b(Parcel paramParcel)
/*      */   {
/*  967 */     if ((paramParcel = paramParcel.readBundle()) == null) {
/*  968 */       return null;
/*      */     }
/*      */     
/*  971 */     HashMap localHashMap = null;
/*  972 */     ArrayList localArrayList = paramParcel.getStringArrayList("keys");
/*  973 */     paramParcel = paramParcel.getStringArrayList("values");
/*      */     
/*  975 */     if ((localArrayList != null) && (paramParcel != null) && (localArrayList.size() == paramParcel.size())) {
/*  976 */       localHashMap = new HashMap(localArrayList.size());
/*  977 */       for (int i = 0; i < localArrayList.size(); i++) {
/*  978 */         localHashMap.put(localArrayList.get(i), paramParcel.get(i));
/*      */       }
/*      */     } else {
/*  981 */       x.e("map parcel error!", new Object[0]);
/*      */     }
/*      */     
/*  984 */     return localHashMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static byte[] a(Parcelable paramParcelable)
/*      */   {
/*  994 */     Parcel localParcel = Parcel.obtain();
/*  995 */     paramParcelable.writeToParcel(localParcel, 0);
/*  996 */     paramParcelable = localParcel.marshall();
/*  997 */     localParcel.recycle();
/*  998 */     return paramParcelable;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static <T> T a(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
/*      */   {
/* 1023 */     paramArrayOfByte = paramArrayOfByte; Parcel localParcel; (localParcel = Parcel.obtain()).unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);localParcel.setDataPosition(0);paramArrayOfByte = localParcel;
/*      */     try {
/* 1025 */       return (T)paramCreator.createFromParcel(paramArrayOfByte);
/*      */ 
/*      */     }
/*      */     catch (Throwable localThrowable)
/*      */     {
/*      */ 
/* 1031 */       return null;
/*      */     }
/*      */     finally
/*      */     {
/* 1030 */       if (paramArrayOfByte != null) {
/* 1031 */         paramArrayOfByte.recycle();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String a(Context paramContext, int paramInt, String paramString)
/*      */   {
/* 1042 */     if (!AppInfo.a(paramContext, "android.permission.READ_LOGS")) {
/* 1043 */       x.d("no read_log permission!", new Object[0]);
/* 1044 */       return null;
/*      */     }
/*      */     
/*      */ 
/* 1048 */     if (paramString == null) {
/* 1049 */       paramContext = new String[] { "logcat", "-d", "-v", "threadtime" };
/*      */     } else {
/* 1051 */       paramContext = new String[] { "logcat", "-d", "-v", "threadtime", "-s", paramString };
/*      */     }
/* 1053 */     paramString = null;
/* 1054 */     StringBuilder localStringBuilder = new StringBuilder();
/*      */     try {
/* 1056 */       paramString = Runtime.getRuntime().exec(paramContext);
/* 1057 */       paramContext = new BufferedReader(new InputStreamReader(paramString.getInputStream()));
/*      */       
/*      */ 
/* 1060 */       while ((str = paramContext.readLine()) != null) {
/* 1061 */         localStringBuilder.append(str).append("\n");
/* 1062 */         if ((paramInt > 0) && (localStringBuilder.length() > paramInt)) {
/* 1063 */           localStringBuilder.delete(0, localStringBuilder.length() - paramInt);
/*      */         }
/*      */       }
/* 1066 */       return localStringBuilder.toString();
/*      */     } catch (Throwable localThrowable) {
/*      */       String str;
/* 1069 */       paramContext.printStackTrace();
/*      */       
/* 1071 */       return new StringBuilder("\n[error:").append(paramContext.toString()).append("]").toString();
/*      */     } finally {
/* 1073 */       if (paramString != null) {
/*      */         try {
/* 1075 */           paramString.getOutputStream().close();
/*      */         } catch (IOException localIOException7) {
/* 1077 */           (paramInt = 
/* 1078 */             localIOException7).printStackTrace();
/*      */         }
/*      */         try {
/* 1080 */           paramString.getInputStream().close();
/*      */         } catch (IOException localIOException8) {
/* 1082 */           (paramInt = 
/* 1083 */             localIOException8).printStackTrace();
/*      */         }
/*      */         try {
/* 1085 */           paramString.getErrorStream().close();
/*      */         } catch (IOException localIOException9) {
/* 1087 */           (paramInt = 
/* 1088 */             localIOException9).printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<String, String> a(int paramInt, boolean paramBoolean)
/*      */   {
/* 1100 */     paramBoolean = new HashMap(12);
/*      */     
/* 1102 */     if ((localObject = Thread.getAllStackTraces()) == null) {
/* 1103 */       return null;
/*      */     }
/*      */     
/* 1106 */     Thread.currentThread().getId();
/* 1107 */     StringBuilder localStringBuilder = new StringBuilder();
/* 1108 */     for (Object localObject = ((Map)localObject).entrySet().iterator(); ((Iterator)localObject).hasNext();) { Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
/* 1109 */       localStringBuilder.setLength(0);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1114 */       if ((localEntry.getValue() != null) && (((StackTraceElement[])localEntry.getValue()).length != 0)) { StackTraceElement[] arrayOfStackTraceElement;
/* 1115 */         int i = (arrayOfStackTraceElement = (StackTraceElement[])localEntry.getValue()).length; for (int j = 0; j < i; 
/*      */             
/*      */ 
/* 1118 */             j++)
/*      */         {
/* 1115 */           StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
/*      */           
/*      */ 
/*      */ 
/* 1119 */           if ((paramInt > 0) && (localStringBuilder.length() >= paramInt))
/*      */           {
/* 1121 */             localStringBuilder.append("\n[Stack over limit size :" + paramInt + " , has been cutted !]");
/*      */             
/* 1123 */             break;
/*      */           }
/*      */           
/* 1126 */           localStringBuilder.append(localStackTraceElement.toString()).append("\n");
/*      */         }
/*      */         
/* 1129 */         paramBoolean.put(((Thread)localEntry.getKey()).getName() + "(" + ((Thread)localEntry.getKey()).getId() + ")", localStringBuilder.toString());
/*      */       }
/*      */     }
/* 1132 */     return paramBoolean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static synchronized byte[] a(int paramInt)
/*      */   {
/*      */     try
/*      */     {
/* 1178 */       paramInt = null;
/*      */       try
/*      */       {
/* 1181 */         byte[] arrayOfByte = new byte[16];
/* 1182 */         (
/* 1183 */           paramInt = new DataInputStream(new FileInputStream(new File("/dev/urandom")))).readFully(arrayOfByte);
/* 1184 */         arrayOfByte = arrayOfByte;
/*      */         
/*      */ 
/*      */ 
/* 1188 */         paramInt.close();return arrayOfByte;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/* 1186 */         x.e("Failed to read from /dev/urandom : %s", new Object[] { localException1 });
/*      */       } finally {
/* 1188 */         if (paramInt != null) {
/* 1189 */           paramInt.close();
/*      */         }
/*      */       }
/*      */       
/*      */       Object localObject2;
/*      */       
/* 1195 */       (localObject2 = KeyGenerator.getInstance("AES")).init(128, new SecureRandom());
/*      */       
/* 1197 */       return (localObject2 = ((KeyGenerator)localObject2).generateKey()).getEncoded();
/*      */     } catch (Exception localException2) {
/* 1199 */       if (!x.b(paramInt = localException2)) {
/* 1200 */         paramInt.printStackTrace();
/*      */       }
/*      */     }
/* 1203 */     return null;
/*      */   }
/*      */   
/* 1206 */   private static boolean b = false;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   @TargetApi(19)
/*      */   public static byte[] a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
/*      */   {
/*      */     try
/*      */     {
/* 1219 */       localObject = new SecretKeySpec(paramArrayOfByte2, "AES");
/* 1220 */       Cipher localCipher = Cipher.getInstance("AES/GCM/NoPadding");
/*      */       
/* 1222 */       if ((Build.VERSION.SDK_INT < 21) || (b)) {
/* 1223 */         IvParameterSpec localIvParameterSpec = new IvParameterSpec(paramArrayOfByte2);
/* 1224 */         localCipher.init(paramInt, (Key)localObject, localIvParameterSpec);
/*      */       } else {
/* 1226 */         int i = localCipher.getBlockSize();
/* 1227 */         paramArrayOfByte2 = new GCMParameterSpec(i << 3, paramArrayOfByte2);
/*      */         try {
/* 1229 */           localCipher.init(paramInt, (Key)localObject, paramArrayOfByte2);
/*      */         } catch (InvalidAlgorithmParameterException paramInt) {
/* 1231 */           b = true;
/* 1232 */           throw paramInt;
/*      */         }
/*      */       }
/* 1235 */       return localCipher.doFinal(paramArrayOfByte1);
/*      */     } catch (Exception localException) { Object localObject;
/* 1237 */       if (!x.b(localObject = localException)) {
/* 1238 */         ((Exception)localObject).printStackTrace();
/*      */       }
/*      */     }
/* 1241 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static byte[] b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
/*      */   {
/*      */     try
/*      */     {
/* 1256 */       paramInt = (paramInt = KeyFactory.getInstance("RSA")).generatePublic(new X509EncodedKeySpec(paramArrayOfByte2));
/*      */       
/*      */ 
/* 1259 */       (
/*      */       
/*      */ 
/* 1262 */         paramArrayOfByte2 = Cipher.getInstance("RSA/ECB/PKCS1Padding")).init(1, paramInt);
/* 1263 */       return paramArrayOfByte2.doFinal(paramArrayOfByte1);
/*      */     } catch (Exception localException) {
/* 1265 */       if (!x.b(paramInt = localException)) {
/* 1266 */         paramInt.printStackTrace();
/*      */       }
/*      */     }
/* 1269 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean a(Context paramContext, String paramString, long paramLong)
/*      */   {
/* 1279 */     x.c("[Util] try to lock file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(android.os.Process.myPid()), Integer.valueOf(android.os.Process.myTid()) });
/*      */     try
/*      */     {
/* 1282 */       localObject = paramContext.getFilesDir() + File.separator + paramString;
/*      */       
/*      */ 
/* 1285 */       if ((localObject = new File((String)localObject)).exists())
/*      */       {
/* 1287 */         if (System.currentTimeMillis() - ((File)localObject).lastModified() < paramLong)
/*      */         {
/* 1289 */           return false;
/*      */         }
/*      */         
/* 1292 */         x.c("[Util] lock file(%s) is expired, unlock it", new Object[] { paramString });
/* 1293 */         b(paramContext, paramString);
/*      */       }
/*      */       
/* 1296 */       if (((File)localObject).createNewFile()) {
/* 1297 */         x.c("[Util] successfully locked file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(android.os.Process.myPid()), Integer.valueOf(android.os.Process.myTid()) });
/*      */         
/* 1299 */         return true;
/*      */       }
/* 1301 */       x.c("[Util] Failed to locked file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(android.os.Process.myPid()), Integer.valueOf(android.os.Process.myTid()) });
/*      */       
/* 1303 */       return false;
/*      */     }
/*      */     catch (Throwable localThrowable) {
/*      */       Object localObject;
/* 1307 */       x.a(localObject = localThrowable); }
/* 1308 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean b(Context paramContext, String paramString)
/*      */   {
/* 1318 */     x.c("[Util] try to unlock file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(android.os.Process.myPid()), Integer.valueOf(android.os.Process.myTid()) });
/*      */     try
/*      */     {
/* 1321 */       paramContext = paramContext.getFilesDir() + File.separator + paramString;
/*      */       
/*      */ 
/* 1324 */       if ((paramContext = new File(paramContext)).exists()) {
/* 1325 */         if (paramContext.delete()) {
/* 1326 */           x.c("[Util] successfully unlocked file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(android.os.Process.myPid()), Integer.valueOf(android.os.Process.myTid()) });
/*      */           
/* 1328 */           return true;
/*      */         }
/* 1330 */         return false;
/*      */       }
/*      */       
/* 1333 */       return true;
/*      */     }
/*      */     catch (Throwable localThrowable)
/*      */     {
/* 1337 */       x.a(paramContext = localThrowable); }
/* 1338 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String a(File paramFile)
/*      */   {
/* 1349 */     if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.canRead())) {
/* 1350 */       return null;
/*      */     }
/* 1352 */     Object localObject1 = null;
/*      */     try {
/* 1354 */       localObject2 = new StringBuilder();
/* 1355 */       localObject1 = new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), "utf-8"));
/*      */       
/* 1357 */       paramFile = null;
/* 1358 */       while ((paramFile = ((BufferedReader)localObject1).readLine()) != null) {
/* 1359 */         ((StringBuilder)localObject2).append(paramFile);
/* 1360 */         ((StringBuilder)localObject2).append("\n");
/*      */       }
/* 1362 */       paramFile = ((StringBuilder)localObject2).toString();
/*      */       
/*      */ 
/*      */ 
/*      */       try
/*      */       {
/* 1368 */         ((BufferedReader)localObject1).close();
/*      */ 
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/* 1373 */         x.a(localObject1 = 
/* 1374 */           localException1); } return paramFile;
/*      */     }
/*      */     catch (Throwable localThrowable)
/*      */     {
/*      */       Object localObject2;
/* 1366 */       paramFile = null;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1374 */       return null;
/*      */     }
/*      */     finally
/*      */     {
/* 1368 */       if (localObject1 != null) {
/*      */         try {
/* 1370 */           ((BufferedReader)localObject1).close();
/*      */         }
/*      */         catch (Exception localException3) {
/* 1373 */           x.a(localObject1 = 
/* 1374 */             localException3);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static BufferedReader b(File paramFile)
/*      */   {
/* 1410 */     if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.canRead())) {
/* 1411 */       return null;
/*      */     }
/* 1413 */     BufferedReader localBufferedReader = null;
/*      */     
/*      */     try
/*      */     {
/* 1417 */       return localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), "utf-8"));
/*      */     }
/*      */     catch (Throwable localThrowable) {
/* 1420 */       x.a(paramFile = localThrowable); }
/* 1421 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static BufferedReader a(String paramString1, String paramString2)
/*      */   {
/* 1433 */     if (paramString1 == null) {
/* 1434 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1438 */       if ((!(paramString1 = new File(paramString1, paramString2)).exists()) || (!paramString1.canRead())) {
/* 1439 */         return null;
/*      */       }
/* 1441 */       return b(paramString1);
/*      */     }
/*      */     catch (NullPointerException localNullPointerException) {
/* 1444 */       x.a(paramString1 = localNullPointerException); }
/* 1445 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Thread a(Runnable paramRunnable, String paramString)
/*      */   {
/*      */     try
/*      */     {
/* 1459 */       (paramRunnable = new Thread(paramRunnable)).setName(paramString);
/* 1460 */       paramRunnable.start();
/* 1461 */       return paramRunnable;
/*      */     } catch (Throwable paramRunnable) {
/* 1463 */       x.e("[Util] Failed to start a thread to execute task with message: %s", new Object[] { paramRunnable.getMessage() });
/*      */     }
/* 1465 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean a(Runnable paramRunnable)
/*      */   {
/* 1476 */     if (paramRunnable != null)
/*      */     {
/* 1478 */       if ((localObject = w.a()) != null) {
/* 1479 */         return ((w)localObject).a(paramRunnable);
/*      */       }
/* 1481 */       Object localObject = paramRunnable.getClass().getName().split("\\.");
/* 1482 */       if (a(paramRunnable, localObject[(localObject.length - 1)]) != null) {
/* 1483 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 1487 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean c(String paramString)
/*      */   {
/* 1497 */     String str = paramString; if (((paramString != null) && (str.trim().length() > 0) ? 0 : 1) != 0) {
/* 1498 */       return false;
/*      */     }
/* 1500 */     if (paramString.length() > 255) {
/* 1501 */       x.a("URL(%s)'s length is larger than 255.", new Object[] { paramString });
/* 1502 */       return false;
/*      */     }
/* 1504 */     if (!paramString.toLowerCase().startsWith("http")) {
/* 1505 */       x.a("URL(%s) is not start with \"http\".", new Object[] { paramString });
/* 1506 */       return false;
/*      */     }
/* 1508 */     if (!paramString.toLowerCase().contains("qq.com")) {
/* 1509 */       x.a("URL(%s) does not contain \"qq.com\".", new Object[] { paramString });
/* 1510 */       return false;
/*      */     }
/* 1512 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static SharedPreferences a(String paramString, Context paramContext)
/*      */   {
/* 1522 */     if (paramContext != null) {
/* 1523 */       return paramContext.getSharedPreferences(paramString, 0);
/*      */     }
/* 1525 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String b(String paramString1, String paramString2)
/*      */   {
/* 1548 */     if ((com.tencent.bugly.crashreport.common.info.a.b() != null) && (com.tencent.bugly.crashreport.common.info.a.b().E != null)) {
/* 1549 */       return com.tencent.bugly.crashreport.common.info.a.b().E.getString(paramString1, paramString2);
/*      */     }
/* 1551 */     return "";
/*      */   }
/*      */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/z.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */