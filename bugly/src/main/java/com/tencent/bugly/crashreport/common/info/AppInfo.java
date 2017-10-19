/*     */ package com.tencent.bugly.crashreport.common.info;
/*     */ 
/*     */ import android.app.ActivityManager;
/*     */ import android.app.ActivityManager.MemoryInfo;
/*     */ import android.content.Context;
/*     */ import android.content.pm.ApplicationInfo;
/*     */ import android.content.pm.PackageInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.content.pm.Signature;
/*     */ import android.os.Bundle;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.FileReader;
/*     */ import java.math.BigInteger;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.Principal;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.CertificateFactory;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AppInfo
/*     */ {
/*     */   private static ActivityManager a;
/*     */   
/*     */   static
/*     */   {
/*  54 */     "@buglyAllChannel@".split(",");
/*  55 */     "@buglyAllChannelPriority@".split(",");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String a(Context paramContext)
/*     */   {
/*  66 */     if (paramContext == null) {
/*  67 */       return null;
/*     */     }
/*     */     try {
/*  70 */       return paramContext.getPackageName();
/*     */     } catch (Throwable localThrowable) {
/*  72 */       if (!x.a(paramContext = localThrowable)) {
/*  73 */         paramContext.printStackTrace();
/*     */       }
/*     */     }
/*  76 */     return "fail";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static PackageInfo b(Context paramContext)
/*     */   {
/*     */     try
/*     */     {
/*  87 */       localObject = a(paramContext);
/*  88 */       return paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
/*     */     } catch (Throwable localThrowable) { Object localObject;
/*  90 */       if (!x.a(localObject = localThrowable))
/*  91 */         ((Throwable)localObject).printStackTrace();
/*     */     }
/*  93 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean a(Context paramContext, String paramString)
/*     */   {
/* 101 */     if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 109 */       if ((paramContext = (paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096)).requestedPermissions) != null) {
/* 110 */         for (Object localObject : paramContext) {
/* 111 */           if (paramString.equals(localObject)) {
/* 112 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable) {
/* 118 */       if (!x.a(paramContext = 
/*     */       
/*     */ 
/*     */ 
/* 122 */         localThrowable)) {
/* 119 */         paramContext.printStackTrace();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 124 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String a(int paramInt)
/*     */   {
/* 135 */     FileReader localFileReader = null;
/*     */     try {
/* 137 */       localFileReader = new FileReader("/proc/" + paramInt + "/cmdline");
/* 138 */       localObject = new char['Ȁ'];
/* 139 */       localFileReader.read((char[])localObject);
/* 140 */       for (int i = 0; i < localObject.length;)
/*     */       {
/* 142 */         if (localObject[i] == 0) break;
/* 143 */         i++;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 148 */       localObject = localObject = (localObject = new String((char[])localObject)).substring(0, i);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 156 */         localFileReader.close();
/*     */       }
/*     */       catch (Throwable localThrowable1) {}
/*     */       
/*     */ 
/* 161 */       return (String)localObject;
/*     */     }
/*     */     catch (Throwable localThrowable2)
/*     */     {
/*     */       Object localObject;
/* 151 */       ((Throwable)localObject).printStackTrace();
/*     */       
/* 153 */       return String.valueOf(paramInt);
/*     */     } finally {
/*     */       try {
/* 156 */         if (localFileReader != null) {
/* 157 */           localFileReader.close();
/*     */         }
/*     */       }
/*     */       catch (Throwable localThrowable4) {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String c(Context paramContext)
/*     */   {
/* 173 */     if (paramContext == null) {
/* 174 */       return null;
/*     */     }
/*     */     try {
/* 177 */       localObject = paramContext.getPackageManager();
/* 178 */       paramContext = paramContext.getApplicationInfo();
/* 179 */       if ((localObject != null) && (paramContext != null))
/*     */       {
/* 181 */         if ((paramContext = ((PackageManager)localObject).getApplicationLabel(paramContext)) != null)
/* 182 */           return paramContext.toString();
/*     */       }
/*     */     } catch (Throwable localThrowable) {
/*     */       Object localObject;
/* 186 */       if (!x.a(localObject = 
/*     */       
/*     */ 
/* 189 */         localThrowable)) {
/* 187 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/*     */     }
/* 190 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<String, String> d(Context paramContext)
/*     */   {
/* 200 */     if (paramContext == null) {
/* 201 */       return null;
/*     */     }
/* 203 */     HashMap localHashMap = null;
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 208 */       if ((paramContext = (localObject = paramContext.getPackageManager()).getApplicationInfo(paramContext.getPackageName(), 128)).metaData != null) {
/* 209 */         localHashMap = new HashMap();
/*     */         
/*     */ 
/* 212 */         if ((localObject = paramContext.metaData.get("BUGLY_DISABLE")) != null) {
/* 213 */           localHashMap.put("BUGLY_DISABLE", localObject.toString());
/*     */         }
/*     */         
/*     */ 
/* 217 */         if ((localObject = paramContext.metaData.get("BUGLY_APPID")) != null) {
/* 218 */           localHashMap.put("BUGLY_APPID", localObject.toString());
/*     */         }
/*     */         
/*     */ 
/* 222 */         if ((localObject = paramContext.metaData.get("BUGLY_APP_CHANNEL")) != null) {
/* 223 */           localHashMap.put("BUGLY_APP_CHANNEL", localObject.toString());
/*     */         }
/*     */         
/*     */ 
/* 227 */         if ((localObject = paramContext.metaData.get("BUGLY_APP_VERSION")) != null) {
/* 228 */           localHashMap.put("BUGLY_APP_VERSION", localObject.toString());
/*     */         }
/*     */         
/*     */ 
/* 232 */         if ((localObject = paramContext.metaData.get("BUGLY_ENABLE_DEBUG")) != null) {
/* 233 */           localHashMap.put("BUGLY_ENABLE_DEBUG", localObject.toString());
/*     */         }
/*     */         
/*     */ 
/* 237 */         if ((paramContext = paramContext.metaData.get("com.tencent.rdm.uuid")) != null) {
/* 238 */           localHashMap.put("com.tencent.rdm.uuid", paramContext.toString());
/*     */         }
/*     */       }
/* 241 */       return localHashMap;
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 243 */       if (!x.a(localObject = localThrowable))
/* 244 */         ((Throwable)localObject).printStackTrace();
/*     */     }
/* 246 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<String> a(Map<String, String> paramMap)
/*     */   {
/* 257 */     if (paramMap == null) {
/* 258 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 262 */       if (((paramMap = (String)paramMap.get("BUGLY_DISABLE")) == null) || (paramMap.length() == 0)) {
/* 263 */         return null;
/*     */       }
/* 265 */       paramMap = paramMap.split(",");
/* 266 */       for (int i = 0; i < paramMap.length; i++) {
/* 267 */         paramMap[i] = paramMap[i].trim();
/*     */       }
/* 269 */       return Arrays.asList(paramMap);
/*     */     } catch (Throwable localThrowable) {
/* 271 */       if (!x.a(paramMap = localThrowable))
/* 272 */         paramMap.printStackTrace();
/*     */     }
/* 274 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String a(byte[] paramArrayOfByte)
/*     */   {
/* 285 */     StringBuilder localStringBuilder = new StringBuilder();
/* 286 */     if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
/*     */       try
/*     */       {
/* 289 */         if ((localObject1 = CertificateFactory.getInstance("X.509")) == null) {
/* 290 */           return null;
/*     */         }
/*     */         
/*     */ 
/* 294 */         if ((paramArrayOfByte = (X509Certificate)((CertificateFactory)localObject1).generateCertificate(new ByteArrayInputStream(paramArrayOfByte))) == null) {
/* 295 */           return null;
/*     */         }
/*     */         
/* 298 */         localStringBuilder.append("Issuer|");
/*     */         
/* 300 */         if ((localObject1 = paramArrayOfByte.getIssuerDN()) != null) {
/* 301 */           localStringBuilder.append(((Principal)localObject1).toString());
/*     */         } else {
/* 303 */           localStringBuilder.append("unknown");
/*     */         }
/* 305 */         localStringBuilder.append("\n");
/*     */         
/* 307 */         localStringBuilder.append("SerialNumber|");
/* 308 */         Object localObject2 = paramArrayOfByte.getSerialNumber();
/* 309 */         if (localObject1 != null) {
/* 310 */           localStringBuilder.append(((BigInteger)localObject2).toString(16));
/*     */         } else {
/* 312 */           localStringBuilder.append("unknown");
/*     */         }
/* 314 */         localStringBuilder.append("\n");
/*     */         
/* 316 */         localStringBuilder.append("NotBefore|");
/* 317 */         localObject2 = paramArrayOfByte.getNotBefore();
/* 318 */         if (localObject1 != null) {
/* 319 */           localStringBuilder.append(((Date)localObject2).toString());
/*     */         } else {
/* 321 */           localStringBuilder.append("unknown");
/*     */         }
/* 323 */         localStringBuilder.append("\n");
/*     */         
/* 325 */         localStringBuilder.append("NotAfter|");
/* 326 */         localObject2 = paramArrayOfByte.getNotAfter();
/* 327 */         if (localObject1 != null) {
/* 328 */           localStringBuilder.append(((Date)localObject2).toString());
/*     */         } else {
/* 330 */           localStringBuilder.append("unknown");
/*     */         }
/* 332 */         localStringBuilder.append("\n");
/*     */         
/* 334 */         localStringBuilder.append("SHA1|");
/*     */         
/*     */ 
/* 337 */         if (((localObject1 = z.a((localObject1 = MessageDigest.getInstance("SHA1")).digest(paramArrayOfByte.getEncoded()))) != null) && (((String)localObject1).length() > 0)) {
/* 338 */           localStringBuilder.append(((String)localObject1).toString());
/*     */         } else {
/* 340 */           localStringBuilder.append("unknown");
/*     */         }
/* 342 */         localStringBuilder.append("\n");
/*     */         
/* 344 */         localStringBuilder.append("MD5|");
/*     */         
/*     */ 
/* 347 */         if (((paramArrayOfByte = z.a((localObject1 = MessageDigest.getInstance("MD5")).digest(paramArrayOfByte.getEncoded()))) != null) && (paramArrayOfByte.length() > 0)) {
/* 348 */           localStringBuilder.append(paramArrayOfByte.toString());
/*     */         } else {
/* 350 */           localStringBuilder.append("unknown");
/*     */         }
/*     */       } catch (CertificateException localCertificateException) {
/* 353 */         if (!x.a(localObject1 = 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 360 */           localCertificateException))
/* 354 */           ((CertificateException)localObject1).printStackTrace();
/*     */       } catch (Throwable localThrowable) {
/*     */         Object localObject1;
/* 357 */         if (!x.a(localObject1 = 
/*     */         
/*     */ 
/* 360 */           localThrowable)) {
/* 358 */           ((Throwable)localObject1).printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 362 */     if (localStringBuilder.length() == 0) {
/* 363 */       return "unknown";
/*     */     }
/* 365 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String e(Context paramContext)
/*     */   {
/*     */     Object localObject;
/*     */     
/*     */ 
/* 375 */     if ((localObject = a(paramContext)) == null) {
/* 376 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 380 */       paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 64);
/*     */     }
/*     */     catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/* 383 */       return null;
/*     */     }
/* 385 */     if (paramContext == null) {
/* 386 */       return null;
/*     */     }
/*     */     
/* 389 */     if (((localObject = paramContext.signatures) == null) || (localObject.length == 0)) {
/* 390 */       return null;
/*     */     }
/* 392 */     return a(paramContext.signatures[0].toByteArray());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean f(Context paramContext)
/*     */   {
/* 402 */     if (paramContext == null) {
/* 403 */       return false;
/*     */     }
/* 405 */     if (a == null) {
/* 406 */       a = (ActivityManager)paramContext.getSystemService("activity");
/*     */     }
/*     */     try {
/* 409 */       paramContext = new ActivityManager.MemoryInfo();
/* 410 */       a.getMemoryInfo(paramContext);
/* 411 */       if (paramContext.lowMemory) {
/* 412 */         x.c("Memory is low.", new Object[0]);
/* 413 */         return true;
/*     */       }
/* 415 */       return false;
/*     */     }
/*     */     catch (Throwable localThrowable) {
/* 418 */       if (!x.a(paramContext = localThrowable))
/* 419 */         paramContext.printStackTrace();
/*     */     }
/* 421 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/common/info/AppInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */