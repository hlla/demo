/*     */ package com.tencent.bugly.crashreport.crash.jni;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.tencent.bugly.crashreport.common.info.a;
/*     */ import com.tencent.bugly.crashreport.crash.CrashDetailBean;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public final class b
/*     */ {
/*  38 */   private static String a = null;
/*     */   
/*     */ 
/*     */ 
/*     */   private static Map<String, Integer> c(String paramString)
/*     */   {
/*  44 */     if (paramString == null) {
/*  45 */       return null;
/*     */     }
/*     */     try
/*     */     {
/*  49 */       HashMap localHashMap = new HashMap();
/*     */       String[] arrayOfString1;
/*  51 */       int i = (arrayOfString1 = arrayOfString1 = paramString.split(",")).length; for (int j = 0; j < i; j++) { String str;
/*     */         String[] arrayOfString2;
/*  53 */         if ((arrayOfString2 = (str = arrayOfString1[j]).split(":")).length != 2) {
/*  54 */           x.e("error format at %s", new Object[] { str });
/*  55 */           return null;
/*     */         }
/*     */         
/*  58 */         int k = Integer.parseInt(arrayOfString2[1]);
/*  59 */         localHashMap.put(arrayOfString2[0], Integer.valueOf(k));
/*     */       }
/*     */       
/*  62 */       return localHashMap;
/*     */     } catch (Exception localException) {
/*  64 */       x.e("error format intStateStr %s", new Object[] { paramString });
/*  65 */       localException.printStackTrace(); }
/*  66 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   protected static String a(String paramString)
/*     */   {
/*  72 */     if (paramString == null) {
/*  73 */       return "";
/*     */     }
/*     */     String[] arrayOfString;
/*  76 */     if (((arrayOfString = paramString.split("\n")) == null) || (arrayOfString.length == 0)) {
/*  77 */       return paramString;
/*     */     }
/*     */     
/*  80 */     paramString = new StringBuilder();
/*  81 */     int i = (arrayOfString = arrayOfString).length; for (int j = 0; j < i; j++) { String str;
/*  82 */       if (!(str = arrayOfString[j]).contains("java.lang.Thread.getStackTrace(")) {
/*  83 */         paramString.append(str).append("\n");
/*     */       }
/*     */     }
/*  86 */     return paramString.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static CrashDetailBean a(Context paramContext, Map<String, String> paramMap, NativeExceptionHandler paramNativeExceptionHandler)
/*     */   {
/*  95 */     if (paramMap == null) {
/*  96 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 100 */     if ((paramContext = a.a(paramContext)) == null) {
/* 101 */       x.e("abnormal com info not created", new Object[0]);
/* 102 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 106 */     if (((paramContext = (String)paramMap.get("intStateStr")) == null) || (paramContext.trim().length() <= 0)) {
/* 107 */       x.e("no intStateStr", new Object[0]);
/* 108 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 112 */     if ((paramContext = c(paramContext)) == null) {
/* 113 */       x.e("parse intSateMap fail", new Object[] { Integer.valueOf(paramMap.size()) });
/* 114 */       return null;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 119 */       ((Integer)paramContext.get("sino")).intValue();
/* 120 */       ((Integer)paramContext.get("sud")).intValue();
/*     */       
/*     */       String str1;
/* 123 */       if ((str1 = (String)paramMap.get("soVersion")) == null) {
/* 124 */         x.e("error format at version", new Object[0]);
/* 125 */         return null;
/*     */       }
/*     */       
/*     */ 
/* 129 */       String str2 = (str2 = (String)paramMap.get("errorAddr")) == null ? "unknown" : str2;
/*     */       
/*     */ 
/* 132 */       String str3 = (str3 = (String)paramMap.get("codeMsg")) == null ? "unknown" : str3;
/*     */       
/*     */ 
/* 135 */       String str4 = (str4 = (String)paramMap.get("tombPath")) == null ? "unknown" : str4;
/*     */       
/*     */ 
/* 138 */       String str5 = (str5 = (String)paramMap.get("signalName")) == null ? "unknown" : str5;
/*     */       
/* 140 */       paramMap.get("errnoMsg");
/*     */       
/*     */ 
/* 143 */       String str6 = (str6 = (String)paramMap.get("stack")) == null ? "unknown" : str6;
/*     */       
/*     */ 
/* 146 */       if ((localObject1 = (String)paramMap.get("jstack")) != null) {
/* 147 */         str6 = str6 + "java:\n" + (String)localObject1;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 152 */       Object localObject1 = (Integer)paramContext.get("sico");
/* 153 */       str5 = str5;
/* 154 */       if ((localObject1 != null) && (((Integer)localObject1).intValue() > 0))
/*     */       {
/*     */ 
/* 157 */         str5 = str5 + "(" + str3 + ")";
/* 158 */         str3 = "KERNEL";
/*     */       }
/*     */       else {
/* 161 */         str3 = str3;
/*     */       }
/*     */       
/* 164 */       localObject1 = (String)paramMap.get("nativeLog");
/*     */       
/* 166 */       byte[] arrayOfByte = null;
/* 167 */       if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
/* 168 */         arrayOfByte = z.a(null, (String)localObject1, "BuglyNativeLog.txt");
/*     */       }
/*     */       
/*     */ 
/* 172 */       if ((localObject1 = (String)paramMap.get("sendingProcess")) == null) {
/* 173 */         localObject1 = "unknown";
/*     */       }
/*     */       Object localObject2;
/* 176 */       if ((localObject2 = (Integer)paramContext.get("spd")) != null) {
/* 177 */         localObject1 = (String)localObject1 + "(" + localObject2 + ")";
/*     */       }
/*     */       
/*     */ 
/* 181 */       if ((localObject2 = (String)paramMap.get("threadName")) == null) {
/* 182 */         localObject2 = "unknown";
/*     */       }
/*     */       Object localObject3;
/* 185 */       if ((localObject3 = (Integer)paramContext.get("et")) != null) {
/* 186 */         localObject2 = (String)localObject2 + "(" + localObject3 + ")";
/*     */       }
/*     */       
/*     */ 
/* 190 */       if ((localObject3 = (String)paramMap.get("processName")) == null) {
/* 191 */         localObject3 = "unknown";
/*     */       }
/*     */       
/* 194 */       if ((localObject4 = (Integer)paramContext.get("ep")) != null) {
/* 195 */         localObject3 = (String)localObject3 + "(" + localObject4 + ")";
/*     */       }
/*     */       
/* 198 */       Object localObject4 = null;
/*     */       String str7;
/* 200 */       if ((str7 = (String)paramMap.get("key-value")) != null) {
/* 201 */         localObject4 = new HashMap();
/*     */         String[] arrayOfString1;
/* 203 */         String[] arrayOfString2; int i = (arrayOfString2 = arrayOfString1 = str7.split("\n")).length; for (int j = 0; j < i; j++) { String str8;
/*     */           String[] arrayOfString3;
/* 205 */           if ((arrayOfString3 = (str8 = arrayOfString2[j]).split("=")).length == 2) {
/* 206 */             ((Map)localObject4).put(arrayOfString3[0], arrayOfString3[1]);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 211 */       long l1 = ((Integer)paramContext.get("ets")).intValue();
/* 212 */       long l2 = ((Integer)paramContext.get("etms")).intValue();
/* 213 */       long l3 = l1 * 1000L + l2 / 1000L;
/*     */       
/* 215 */       paramContext = str2;
/* 216 */       str2 = a(str6);
/*     */       
/* 218 */       str6 = (String)paramMap.get("sysLogPath");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 223 */       if ((paramContext = paramNativeExceptionHandler.packageCrashDatas((String)localObject3, (String)localObject2, l3, str5, paramContext, str2, str3, (String)localObject1, str4, str6, str1, arrayOfByte, (Map)localObject4, false)) != null)
/*     */       {
/* 225 */         if ((paramNativeExceptionHandler = (String)paramMap.get("userId")) != null) {
/* 226 */           x.c("[Native record info] userId: %s", new Object[] { paramNativeExceptionHandler });
/* 227 */           paramContext.m = paramNativeExceptionHandler;
/*     */         }
/*     */         
/* 230 */         if ((paramNativeExceptionHandler = (String)paramMap.get("sysLog")) != null) {
/* 231 */           paramContext.w = paramNativeExceptionHandler;
/*     */         }
/*     */         
/* 234 */         if ((paramNativeExceptionHandler = (String)paramMap.get("appVersion")) != null) {
/* 235 */           x.c("[Native record info] appVersion: %s", new Object[] { paramNativeExceptionHandler });
/* 236 */           paramContext.f = paramNativeExceptionHandler;
/*     */         }
/*     */         
/* 239 */         if ((paramNativeExceptionHandler = (String)paramMap.get("isAppForeground")) != null) {
/* 240 */           x.c("[Native record info] isAppForeground: %s", new Object[] { paramNativeExceptionHandler });
/* 241 */           paramContext.M = paramNativeExceptionHandler.equalsIgnoreCase("true");
/*     */         }
/*     */         
/* 244 */         if ((paramMap = (String)paramMap.get("launchTime")) != null) {
/* 245 */           x.c("[Native record info] launchTime: %s", new Object[] { paramMap });
/*     */           try {
/* 247 */             paramContext.L = Long.parseLong(paramMap);
/*     */           } catch (NumberFormatException localNumberFormatException) {
/* 249 */             if (!x.a(paramMap = 
/*     */             
/*     */ 
/* 252 */               localNumberFormatException)) {
/* 250 */               paramMap.printStackTrace();
/*     */             }
/*     */           }
/*     */         }
/* 254 */         paramContext.y = null;
/* 255 */         paramContext.k = true;
/*     */       }
/* 257 */       return paramContext;
/*     */     } catch (Throwable paramContext) {
/* 259 */       x.e("error format", new Object[0]);
/* 260 */       paramContext.printStackTrace();
/*     */     }
/* 262 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   private static String a(BufferedInputStream paramBufferedInputStream)
/*     */     throws IOException
/*     */   {
/* 269 */     if (paramBufferedInputStream == null) {
/* 270 */       return null;
/*     */     }
/*     */     
/* 273 */     StringBuilder localStringBuilder = new StringBuilder();
/* 274 */     int i = 0;
/* 275 */     while ((i = paramBufferedInputStream.read()) != -1) {
/* 276 */       if (i == 0) {
/* 277 */         return localStringBuilder.toString();
/*     */       }
/*     */       
/* 280 */       localStringBuilder.append((char)i);
/*     */     }
/*     */     
/*     */ 
/* 284 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static CrashDetailBean a(Context paramContext, String paramString, NativeExceptionHandler paramNativeExceptionHandler)
/*     */   {
/* 292 */     if ((paramContext == null) || (paramString == null) || (paramNativeExceptionHandler == null)) {
/* 293 */       x.e("get eup record file args error", new Object[0]);
/* 294 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 298 */     if ((!(paramString = new File(paramString, "rqd_record.eup")).exists()) || (!paramString.canRead())) {
/* 299 */       return null;
/*     */     }
/*     */     
/* 302 */     BufferedInputStream localBufferedInputStream = null;
/*     */     
/*     */     try
/*     */     {
/* 306 */       if (((paramString = a(localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramString)))) == null) || (!paramString.equals("NATIVE_RQD_REPORT"))) {
/* 307 */         x.e("record read fail! %s", new Object[] { paramString });
/* 308 */         try { localBufferedInputStream.close();
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
/*     */         }
/*     */         catch (IOException localIOException1)
/*     */         {
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
/* 336 */           (localObject1 = 
/* 337 */             localIOException1).printStackTrace(); }
/* 337 */         return null;
/*     */       }
/* 311 */       paramString = new HashMap();
/* 312 */       localObject1 = null;
/* 313 */       Object localObject2 = null;
/* 314 */       while ((localObject1 = a(localBufferedInputStream)) != null) {
/* 315 */         if (localObject2 == null) {
/* 316 */           localObject2 = localObject1;
/*     */         } else {
/* 318 */           paramString.put(localObject2, localObject1);
/* 319 */           localObject2 = null;
/*     */         }
/*     */       }
/* 322 */       if (localObject2 != null) {
/* 323 */         x.e("record not pair! drop! %s", new Object[] { localObject2 });
/* 324 */         try { localBufferedInputStream.close();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         catch (IOException localIOException2)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 336 */           (paramString = 
/* 337 */             localIOException2).printStackTrace(); }
/* 337 */         return null;
/*     */       }
/* 327 */       paramContext = a(paramContext, paramString, paramNativeExceptionHandler);
/*     */       
/*     */ 
/*     */       try
/*     */       {
/* 332 */         localBufferedInputStream.close();
/*     */       }
/*     */       catch (IOException localIOException3)
/*     */       {
/* 336 */         (paramString = 
/* 337 */           localIOException3).printStackTrace(); }
/* 337 */       return paramContext; } catch (IOException localIOException4) { Object localObject1; return null;
/*     */     }
/*     */     finally
/*     */     {
/* 332 */       if (localBufferedInputStream != null) {
/*     */         try {
/* 334 */           localBufferedInputStream.close();
/*     */         } catch (IOException localIOException6) {
/* 336 */           (paramString = 
/* 337 */             localIOException6).printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static String b(String paramString1, String paramString2)
/*     */   {
/* 344 */     if ((paramString1 = z.a(paramString1, "reg_record.txt")) == null) {
/* 345 */       return null;
/*     */     }
/*     */     try {
/* 348 */       localObject = new StringBuilder();
/*     */       String str;
/* 350 */       if (((str = paramString1.readLine()) == null) || (!str.startsWith(paramString2)))
/*     */       {
/*     */         Exception localException1;
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
/* 386 */         return null;
/*     */       }
/* 353 */       paramString2 = "                ";
/* 354 */       int i = 18;
/* 355 */       int j = 0;
/* 356 */       int k = 0;
/* 357 */       while ((str = paramString1.readLine()) != null) {
/* 358 */         if (k % 4 == 0) {
/* 359 */           if (k > 0) {
/* 360 */             ((StringBuilder)localObject).append("\n");
/*     */           }
/* 362 */           ((StringBuilder)localObject).append("  ");
/*     */         } else {
/* 364 */           if (str.length() > 16) {
/* 365 */             i = 28;
/*     */           }
/* 367 */           ((StringBuilder)localObject).append(paramString2.substring(0, i - j));
/*     */         }
/* 369 */         j = str.length();
/* 370 */         ((StringBuilder)localObject).append(str);
/* 371 */         k++;
/*     */       }
/* 373 */       ((StringBuilder)localObject).append("\n");
/* 374 */       return ((StringBuilder)localObject).toString();
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/*     */       Object localObject;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 386 */       return null;
/*     */     }
/*     */     finally
/*     */     {
/* 380 */       if (paramString1 != null) {
/*     */         try {
/* 382 */           paramString1.close();
/*     */         }
/*     */         catch (Exception localException5) {
/* 385 */           x.a(paramString1 = 
/* 386 */             localException5);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static String c(String paramString1, String paramString2) {
/* 393 */     if ((paramString1 = z.a(paramString1, "map_record.txt")) == null) {
/* 394 */       return null;
/*     */     }
/*     */     try {
/* 397 */       localObject = new StringBuilder();
/*     */       String str;
/* 399 */       if (((str = paramString1.readLine()) == null) || (!str.startsWith(paramString2)))
/*     */       {
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
/* 419 */         return null;
/*     */       }
/* 402 */       while ((str = paramString1.readLine()) != null) {
/* 403 */         ((StringBuilder)localObject).append("  ");
/* 404 */         ((StringBuilder)localObject).append(str);
/* 405 */         ((StringBuilder)localObject).append("\n");
/*     */       }
/* 407 */       return ((StringBuilder)localObject).toString();
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/*     */       Object localObject;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 419 */       return null;
/*     */     }
/*     */     finally
/*     */     {
/* 413 */       if (paramString1 != null) {
/*     */         try {
/* 415 */           paramString1.close();
/*     */         }
/*     */         catch (Exception localException4) {
/* 418 */           x.a(paramString1 = 
/* 419 */             localException4);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String a(String paramString1, String paramString2)
/*     */   {
/* 432 */     if ((paramString1 == null) || (paramString2 == null)) {
/* 433 */       return null;
/*     */     }
/* 435 */     StringBuilder localStringBuilder = new StringBuilder();
/*     */     
/*     */     String str;
/* 438 */     if (((str = b(paramString1, paramString2)) != null) && (!str.isEmpty())) {
/* 439 */       localStringBuilder.append("Register infos:\n");
/* 440 */       localStringBuilder.append(str);
/*     */     }
/*     */     
/*     */ 
/* 444 */     if (((paramString1 = c(paramString1, paramString2)) != null) && (!paramString1.isEmpty())) {
/* 445 */       if (localStringBuilder.length() > 0) {
/* 446 */         localStringBuilder.append("\n");
/*     */       }
/* 448 */       localStringBuilder.append("System SO infos:\n");
/* 449 */       localStringBuilder.append(paramString1);
/*     */     }
/*     */     
/* 452 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String b(String paramString)
/*     */   {
/* 462 */     if (paramString == null) {
/* 463 */       return null;
/*     */     }
/*     */     
/* 466 */     if ((paramString = new File(paramString, "backup_record.txt")).exists()) {
/* 467 */       return paramString.getAbsolutePath();
/*     */     }
/* 469 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void a(boolean paramBoolean, String paramString)
/*     */   {
/* 476 */     if (paramString != null) {
/*     */       File localFile;
/* 478 */       if (((localFile = new File(paramString, "rqd_record.eup")).exists()) && (localFile.canWrite())) {
/* 479 */         localFile.delete();
/* 480 */         x.c("delete record file %s", new Object[] { localFile.getAbsoluteFile() });
/*     */       }
/*     */       
/* 483 */       if (((localFile = new File(paramString, "reg_record.txt")).exists()) && (localFile.canWrite())) {
/* 484 */         localFile.delete();
/* 485 */         x.c("delete record file %s", new Object[] { localFile.getAbsoluteFile() });
/*     */       }
/*     */       
/* 488 */       if (((localFile = new File(paramString, "map_record.txt")).exists()) && (localFile.canWrite())) {
/* 489 */         localFile.delete();
/* 490 */         x.c("delete record file %s", new Object[] { localFile.getAbsoluteFile() });
/*     */       }
/*     */       
/* 493 */       if (((localFile = new File(paramString, "backup_record.txt")).exists()) && (localFile.canWrite())) {
/* 494 */         localFile.delete();
/* 495 */         x.c("delete record file %s", new Object[] { localFile.getAbsoluteFile() });
/*     */       }
/* 497 */       if (a != null)
/*     */       {
/* 499 */         if (((localFile = new File(a)).exists()) && (localFile.canWrite())) {
/* 500 */           localFile.delete();
/* 501 */           x.c("delete record file %s", new Object[] { localFile.getAbsoluteFile() });
/*     */         }
/*     */       }
/*     */       
/* 505 */       if (paramBoolean)
/*     */       {
/* 507 */         if (((paramBoolean = new File(paramString)).canRead()) && (paramBoolean.isDirectory()))
/*     */         {
/* 509 */           if ((paramBoolean = paramBoolean.listFiles()) != null) {
/* 510 */             paramBoolean = paramBoolean;paramString = paramBoolean.length; for (String str = 0; str < paramString; str++) { Object localObject;
/* 511 */               if (((localObject = paramBoolean[str]).canRead()) && (((File)localObject).canWrite()) && (((File)localObject).length() == 0L)) {
/* 512 */                 ((File)localObject).delete();
/* 513 */                 x.c("delete invalid record file %s", new Object[] { ((File)localObject).getAbsoluteFile() });
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
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
/*     */   public static String a(String paramString1, int paramInt, String paramString2)
/*     */   {
/* 531 */     if ((paramString1 == null) || (paramInt <= 0)) {
/* 532 */       return null;
/*     */     }
/*     */     Object localObject1;
/* 535 */     if ((!(localObject1 = new File(paramString1)).exists()) || (!((File)localObject1).canRead())) {
/* 536 */       return null;
/*     */     }
/* 538 */     a = paramString1;
/* 539 */     x.a("Read system log from native record file(length: %s bytes): %s", new Object[] { Long.valueOf(((File)localObject1).length()), ((File)localObject1).getAbsolutePath() });
/*     */     
/* 541 */     if (paramString2 == null)
/*     */     {
/* 543 */       paramString1 = z.a(new File(paramString1));
/*     */     } else {
/* 545 */       BufferedReader localBufferedReader = null;
/*     */       try {
/* 547 */         Object localObject2 = new StringBuilder();
/* 548 */         localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File)localObject1), "utf-8"));
/*     */         
/*     */ 
/* 551 */         while ((paramString1 = localBufferedReader.readLine()) != null)
/*     */         {
/*     */ 
/* 554 */           if ((localObject1 = Pattern.compile(paramString2 + "[ ]*:")).matcher(paramString1).find()) {
/* 555 */             ((StringBuilder)localObject2).append(paramString1);
/* 556 */             ((StringBuilder)localObject2).append("\n");
/*     */           }
/*     */         }
/* 559 */         paramString1 = ((StringBuilder)localObject2).toString();
/*     */         
/*     */ 
/*     */ 
/*     */         try
/*     */         {
/* 565 */           localBufferedReader.close();
/*     */ 
/*     */         }
/*     */         catch (Exception localException1)
/*     */         {
/* 570 */           x.a(localObject2 = 
/* 571 */             localException1);
/*     */         }
/*     */         
/*     */ 
/* 575 */         if (paramString1 == null) {
/*     */           return paramString1;
/*     */         }
/*     */       }
/*     */       catch (Throwable localThrowable)
/*     */       {
/* 571 */         return null;
/*     */       }
/*     */       finally
/*     */       {
/* 565 */         if (localBufferedReader != null)
/*     */           try {
/* 567 */             localBufferedReader.close();
/*     */           }
/*     */           catch (Exception localException3) {
/* 570 */             x.a(paramInt = 
/* 571 */               localException3);
/*     */           }
/*     */       }
/*     */     }
/* 575 */     if (paramString1.length() > paramInt) {
/* 576 */       paramString1 = paramString1.substring(paramString1.length() - paramInt);
/*     */     }
/* 578 */     return paramString1;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/jni/b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */