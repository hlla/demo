/*      */ package com.tencent.bugly.crashreport.common.info;
/*      */ 
/*      */ import android.content.Context;
/*      */ import android.net.ConnectivityManager;
/*      */ import android.net.NetworkInfo;
/*      */ import android.net.wifi.WifiInfo;
/*      */ import android.net.wifi.WifiManager;
/*      */ import android.os.Build;
/*      */ import android.os.Build.VERSION;
/*      */ import android.os.Environment;
/*      */ import android.os.StatFs;
/*      */ import android.provider.Settings.Secure;
/*      */ import android.telephony.TelephonyManager;
/*      */ import com.tencent.bugly.proguard.x;
/*      */ import com.tencent.bugly.proguard.z;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.File;
/*      */ import java.io.FileReader;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.Locale;
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
/*      */ public final class b
/*      */ {
/*      */   public static String a()
/*      */   {
/*      */     try
/*      */     {
/*   44 */       return Build.MODEL;
/*      */     } catch (Throwable localThrowable2) { Throwable localThrowable1;
/*   46 */       if (!x.a(localThrowable1 = localThrowable2)) {
/*   47 */         localThrowable1.printStackTrace();
/*      */       }
/*      */     }
/*   50 */     return "fail";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String b()
/*      */   {
/*      */     try
/*      */     {
/*   60 */       return Build.VERSION.RELEASE;
/*      */     } catch (Throwable localThrowable2) { Throwable localThrowable1;
/*   62 */       if (!x.a(localThrowable1 = localThrowable2)) {
/*   63 */         localThrowable1.printStackTrace();
/*      */       }
/*      */     }
/*   66 */     return "fail";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int c()
/*      */   {
/*      */     try
/*      */     {
/*   76 */       return Build.VERSION.SDK_INT;
/*      */     } catch (Throwable localThrowable2) { Throwable localThrowable1;
/*   78 */       if (!x.a(localThrowable1 = localThrowable2)) {
/*   79 */         localThrowable1.printStackTrace();
/*      */       }
/*      */     }
/*   82 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String a(Context paramContext)
/*      */   {
/*   92 */     if (paramContext == null) {
/*   93 */       return null;
/*      */     }
/*   95 */     if (!AppInfo.a(paramContext, "android.permission.READ_PHONE_STATE")) {
/*   96 */       x.d("no READ_PHONE_STATE permission to get IMEI", new Object[0]);
/*   97 */       return null;
/*      */     }
/*   99 */     String str = null;
/*      */     
/*      */ 
/*      */     try
/*      */     {
/*  104 */       if ((str = (paramContext = (TelephonyManager)paramContext.getSystemService("phone")).getDeviceId()) != null) {
/*  105 */         str = str.toLowerCase();
/*      */       }
/*      */     }
/*      */     catch (Throwable paramContext) {
/*  109 */       x.a("Failed to get IMEI.", new Object[0]);
/*      */     }
/*  111 */     return str;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String b(Context paramContext)
/*      */   {
/*  121 */     if (paramContext == null) {
/*  122 */       return null;
/*      */     }
/*  124 */     if (!AppInfo.a(paramContext, "android.permission.READ_PHONE_STATE")) {
/*  125 */       x.d("no READ_PHONE_STATE permission to get IMSI", new Object[0]);
/*  126 */       return null;
/*      */     }
/*  128 */     String str = null;
/*      */     
/*      */ 
/*      */     try
/*      */     {
/*  133 */       if ((str = (paramContext = (TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId()) != null) {
/*  134 */         str = str.toLowerCase();
/*      */       }
/*      */     }
/*      */     catch (Throwable paramContext) {
/*  138 */       x.a("Failed to get IMSI.", new Object[0]);
/*      */     }
/*  140 */     return str;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String c(Context paramContext)
/*      */   {
/*  150 */     String str = "fail";
/*  151 */     if (paramContext == null) {
/*  152 */       return str;
/*      */     }
/*      */     try
/*      */     {
/*  156 */       str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
/*  157 */       if (str == null) {
/*  158 */         str = "null";
/*      */       } else {
/*  160 */         str = str.toLowerCase();
/*      */       }
/*      */     } catch (Throwable localThrowable) {
/*  163 */       if (!x.a(paramContext = 
/*      */       
/*      */ 
/*  166 */         localThrowable)) {
/*  164 */         x.a("Failed to get Android ID.", new Object[0]);
/*      */       }
/*      */     }
/*  167 */     return str;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String d(Context paramContext)
/*      */   {
/*  177 */     String str = "fail";
/*  178 */     if (paramContext == null) {
/*  179 */       return str;
/*      */     }
/*      */     
/*      */     try
/*      */     {
/*  184 */       if ((paramContext = (WifiManager)paramContext.getSystemService("wifi")) != null)
/*      */       {
/*  186 */         if ((paramContext = paramContext.getConnectionInfo()) != null) {
/*  187 */           str = paramContext.getMacAddress();
/*  188 */           if (str == null) {
/*  189 */             str = "null";
/*      */           } else {
/*  191 */             str = str.toLowerCase();
/*      */           }
/*      */         }
/*      */       }
/*      */     } catch (Throwable localThrowable) {
/*  196 */       if (!x.a(paramContext = 
/*      */       
/*      */ 
/*  199 */         localThrowable)) {
/*  197 */         paramContext.printStackTrace();
/*      */       }
/*      */     }
/*  200 */     return str;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean o()
/*      */   {
/*      */     try
/*      */     {
/*  210 */       if (Environment.getExternalStorageState().equals("mounted"))
/*  211 */         return true;
/*      */     } catch (Throwable localThrowable2) {
/*      */       Throwable localThrowable1;
/*  214 */       if (!x.a(localThrowable1 = 
/*      */       
/*      */ 
/*  217 */         localThrowable2)) {
/*  215 */         localThrowable1.printStackTrace();
/*      */       }
/*      */     }
/*  218 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static String p()
/*      */   {
/*  225 */     Object localObject1 = "/system/build.prop";
/*  226 */     FileReader localFileReader = null;
/*  227 */     Object localObject3 = null;
/*      */     try {
/*  229 */       localFileReader = new FileReader((String)localObject1);
/*  230 */       localObject3 = new BufferedReader(localFileReader, 2048);
/*  231 */       localObject1 = null;
/*      */       
/*  233 */       while ((localObject4 = ((BufferedReader)localObject3).readLine()) != null)
/*      */       {
/*  235 */         if ((localObject4 = ((String)localObject4).split("=", 2)).length == 2) {
/*  236 */           if (localObject4[0].equals("ro.product.cpu.abilist")) {
/*  237 */             localObject1 = localObject4[1];
/*  238 */             break; }
/*  239 */           if (localObject4[0].equals("ro.product.cpu.abi")) {
/*  240 */             localObject1 = localObject4[1];
/*  241 */             break;
/*      */           }
/*      */         }
/*      */       }
/*  245 */       if (localObject1 != null) {
/*  246 */         localObject1 = localObject1.split(",")[0];
/*      */       }
/*  248 */       localObject4 = localObject1;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       try
/*      */       {
/*  256 */         ((BufferedReader)localObject3).close();
/*      */       }
/*      */       catch (IOException localIOException1)
/*      */       {
/*  260 */         if (!x.a(localObject1 = 
/*      */         
/*      */ 
/*  263 */           localIOException1)) {
/*  261 */           ((IOException)localObject1).printStackTrace();
/*      */         }
/*      */       }
/*      */       try {
/*  265 */         localFileReader.close();
/*      */       }
/*      */       catch (IOException localIOException2)
/*      */       {
/*  269 */         if (!x.a(localObject1 = 
/*      */         
/*      */ 
/*  272 */           localIOException2))
/*  270 */           ((IOException)localObject1).printStackTrace();
/*      */       }
/*  272 */       return (String)localObject4;
/*      */     }
/*      */     catch (Throwable localThrowable)
/*      */     {
/*      */       Object localObject4;
/*  251 */       ((Throwable)localObject1).printStackTrace();
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
/*  272 */       return null;
/*      */     }
/*      */     finally
/*      */     {
/*  256 */       if (localObject3 != null) {
/*      */         try {
/*  258 */           ((BufferedReader)localObject3).close();
/*      */         } catch (IOException localIOException5) {
/*  260 */           if (!x.a(localObject3 = 
/*      */           
/*      */ 
/*  263 */             localIOException5)) {
/*  261 */             ((IOException)localObject3).printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*  265 */       if (localFileReader != null) {
/*      */         try {
/*  267 */           localFileReader.close();
/*      */         } catch (IOException localIOException6) {
/*  269 */           if (!x.a(localObject3 = 
/*      */           
/*      */ 
/*  272 */             localIOException6)) {
/*  270 */             ((IOException)localObject3).printStackTrace();
/*      */           }
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
/*      */   public static String a(boolean paramBoolean)
/*      */   {
/*      */     try
/*      */     {
/*  286 */       localObject = null;
/*  287 */       if (paramBoolean) {
/*  288 */         localObject = p();
/*      */       }
/*  290 */       if (localObject == null) {
/*  291 */         localObject = System.getProperty("os.arch");
/*      */       }
/*  293 */       return (String)localObject;
/*      */     } catch (Throwable localThrowable) { Object localObject;
/*  295 */       if (!x.a(localObject = localThrowable)) {
/*  296 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*  299 */     return "fail";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long d()
/*      */   {
/*  307 */     long l1 = -1L;
/*      */     try {
/*  309 */       localObject = Environment.getDataDirectory();
/*      */       
/*  311 */       long l2 = (localObject = new StatFs(((File)localObject).getPath())).getBlockSize();
/*      */       long l3;
/*  313 */       l1 = (l3 = ((StatFs)localObject).getBlockCount()) * l2;
/*      */     } catch (Throwable localThrowable) { Object localObject;
/*  315 */       if (!x.a(localObject = 
/*      */       
/*      */ 
/*  318 */         localThrowable)) {
/*  316 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*  319 */     return l1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long e()
/*      */   {
/*  327 */     long l1 = -1L;
/*      */     try {
/*  329 */       localObject = Environment.getDataDirectory();
/*      */       
/*  331 */       long l2 = (localObject = new StatFs(((File)localObject).getPath())).getBlockSize();
/*      */       long l3;
/*  333 */       l1 = (l3 = ((StatFs)localObject).getAvailableBlocks()) * l2;
/*      */     } catch (Throwable localThrowable) { Object localObject;
/*  335 */       if (!x.a(localObject = 
/*      */       
/*      */ 
/*  338 */         localThrowable)) {
/*  336 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*  339 */     return l1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static long f()
/*      */   {
/*  346 */     Object localObject1 = "/proc/meminfo";
/*  347 */     FileReader localFileReader = null;
/*  348 */     Object localObject3 = null;
/*      */     try {
/*  350 */       localFileReader = new FileReader((String)localObject1);
/*      */       
/*      */ 
/*  353 */       if ((localObject1 = (localObject3 = new BufferedReader(localFileReader, 2048)).readLine()) == null) {
/*  354 */         try { ((BufferedReader)localObject3).close();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         }
/*      */         catch (IOException localIOException1)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  371 */           if (!x.a(localObject1 = 
/*      */           
/*      */ 
/*  374 */             localIOException1)) {
/*  372 */             ((IOException)localObject1).printStackTrace();
/*      */           }
/*      */         }
/*      */         try {
/*  376 */           localFileReader.close();
/*      */         }
/*      */         catch (IOException localIOException2)
/*      */         {
/*  380 */           if (!x.a(localObject1 = 
/*      */           
/*      */ 
/*  383 */             localIOException2))
/*  381 */             ((IOException)localObject1).printStackTrace();
/*      */         }
/*  383 */         return -1L;
/*      */       }
/*  359 */       long l = Long.parseLong(localObject1 = (localObject1 = (localObject1 = ((String)localObject1).split(":\\s+", 2))[1].toLowerCase()).replace("kb", "").trim()) << 10;
/*  360 */       try { ((BufferedReader)localObject3).close();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*      */       catch (IOException localIOException3)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  371 */         if (!x.a(localObject1 = 
/*      */         
/*      */ 
/*  374 */           localIOException3)) {
/*  372 */           ((IOException)localObject1).printStackTrace();
/*      */         }
/*      */       }
/*      */       try {
/*  376 */         localFileReader.close();
/*      */       }
/*      */       catch (IOException localIOException4)
/*      */       {
/*  380 */         if (!x.a(localObject1 = 
/*      */         
/*      */ 
/*  383 */           localIOException4))
/*  381 */           ((IOException)localObject1).printStackTrace();
/*      */       }
/*  383 */       return l;
/*      */     }
/*      */     catch (Throwable localThrowable)
/*      */     {
/*  363 */       ((Throwable)localObject1).printStackTrace();
/*      */     }
/*      */     finally
/*      */     {
/*  367 */       if (localObject3 != null) {
/*      */         try {
/*  369 */           ((BufferedReader)localObject3).close();
/*      */         } catch (IOException localIOException7) {
/*  371 */           if (!x.a(localObject3 = 
/*      */           
/*      */ 
/*  374 */             localIOException7)) {
/*  372 */             ((IOException)localObject3).printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*  376 */       if (localFileReader != null) {
/*      */         try {
/*  378 */           localFileReader.close();
/*      */         } catch (IOException localIOException8) {
/*  380 */           if (!x.a(localObject3 = 
/*      */           
/*      */ 
/*  383 */             localIOException8)) {
/*  381 */             ((IOException)localObject3).printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  387 */     return -2L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static long g()
/*      */   {
/*  394 */     Object localObject1 = "/proc/meminfo";
/*  395 */     FileReader localFileReader = null;
/*  396 */     Object localObject3 = null;
/*      */     try {
/*  398 */       localFileReader = new FileReader((String)localObject1);
/*  399 */       (
/*  400 */         localObject3 = new BufferedReader(localFileReader, 2048)).readLine();
/*      */       
/*  402 */       if ((localObject1 = ((BufferedReader)localObject3).readLine()) == null) {
/*  403 */         try { ((BufferedReader)localObject3).close();
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
/*      */         }
/*      */         catch (IOException localIOException1)
/*      */         {
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
/*  440 */           if (!x.a(localObject1 = 
/*      */           
/*      */ 
/*  443 */             localIOException1)) {
/*  441 */             ((IOException)localObject1).printStackTrace();
/*      */           }
/*      */         }
/*      */         try {
/*  445 */           localFileReader.close();
/*      */         }
/*      */         catch (IOException localIOException2)
/*      */         {
/*  449 */           if (!x.a(localObject1 = 
/*      */           
/*      */ 
/*  452 */             localIOException2))
/*  450 */             ((IOException)localObject1).printStackTrace();
/*      */         }
/*  452 */         return -1L;
/*      */       }
/*  407 */       localObject1 = (localObject1 = (localObject1 = ((String)localObject1).split(":\\s+", 2))[1].toLowerCase()).replace("kb", "").trim();
/*  408 */       long l = 0L + (Long.parseLong((String)localObject1) << 10);
/*      */       
/*      */ 
/*      */ 
/*  412 */       if ((localObject1 = ((BufferedReader)localObject3).readLine()) == null) {
/*  413 */         try { ((BufferedReader)localObject3).close();
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
/*      */         }
/*      */         catch (IOException localIOException3)
/*      */         {
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
/*  440 */           if (!x.a(localObject1 = 
/*      */           
/*      */ 
/*  443 */             localIOException3)) {
/*  441 */             ((IOException)localObject1).printStackTrace();
/*      */           }
/*      */         }
/*      */         try {
/*  445 */           localFileReader.close();
/*      */         }
/*      */         catch (IOException localIOException4)
/*      */         {
/*  449 */           if (!x.a(localObject1 = 
/*      */           
/*      */ 
/*  452 */             localIOException4))
/*  450 */             ((IOException)localObject1).printStackTrace();
/*      */         }
/*  452 */         return -1L;
/*      */       }
/*  417 */       localObject1 = (localObject1 = (localObject1 = ((String)localObject1).split(":\\s+", 2))[1].toLowerCase()).replace("kb", "").trim();
/*  418 */       l += (Long.parseLong((String)localObject1) << 10);
/*      */       
/*      */ 
/*  421 */       if ((localObject1 = ((BufferedReader)localObject3).readLine()) == null) {
/*  422 */         try { ((BufferedReader)localObject3).close();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         }
/*      */         catch (IOException localIOException5)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  440 */           if (!x.a(localObject1 = 
/*      */           
/*      */ 
/*  443 */             localIOException5)) {
/*  441 */             ((IOException)localObject1).printStackTrace();
/*      */           }
/*      */         }
/*      */         try {
/*  445 */           localFileReader.close();
/*      */         }
/*      */         catch (IOException localIOException6)
/*      */         {
/*  449 */           if (!x.a(localObject1 = 
/*      */           
/*      */ 
/*  452 */             localIOException6))
/*  450 */             ((IOException)localObject1).printStackTrace();
/*      */         }
/*  452 */         return -1L;
/*      */       }
/*  426 */       localObject1 = (localObject1 = (localObject1 = ((String)localObject1).split(":\\s+", 2))[1].toLowerCase()).replace("kb", "").trim();
/*  427 */       l += (Long.parseLong((String)localObject1) << 10);
/*      */       try {
/*  429 */         ((BufferedReader)localObject3).close();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*      */       catch (IOException localIOException7)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  440 */         if (!x.a(localObject1 = 
/*      */         
/*      */ 
/*  443 */           localIOException7)) {
/*  441 */           ((IOException)localObject1).printStackTrace();
/*      */         }
/*      */       }
/*      */       try {
/*  445 */         localFileReader.close();
/*      */       }
/*      */       catch (IOException localIOException8)
/*      */       {
/*  449 */         if (!x.a(localObject1 = 
/*      */         
/*      */ 
/*  452 */           localIOException8))
/*  450 */           ((IOException)localObject1).printStackTrace();
/*      */       }
/*  452 */       return l;
/*      */     }
/*      */     catch (Throwable localThrowable)
/*      */     {
/*  432 */       ((Throwable)localObject1).printStackTrace();
/*      */     }
/*      */     finally
/*      */     {
/*  436 */       if (localObject3 != null) {
/*      */         try {
/*  438 */           ((BufferedReader)localObject3).close();
/*      */         } catch (IOException localIOException11) {
/*  440 */           if (!x.a(localObject3 = 
/*      */           
/*      */ 
/*  443 */             localIOException11)) {
/*  441 */             ((IOException)localObject3).printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*  445 */       if (localFileReader != null) {
/*      */         try {
/*  447 */           localFileReader.close();
/*      */         } catch (IOException localIOException12) {
/*  449 */           if (!x.a(localObject3 = 
/*      */           
/*      */ 
/*  452 */             localIOException12)) {
/*  450 */             ((IOException)localObject3).printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  456 */     return -2L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long h()
/*      */   {
/*  466 */     if (!o()) {
/*  467 */       return 0L;
/*      */     }
/*      */     
/*      */     try
/*      */     {
/*  472 */       int i = (localObject = new StatFs(Environment.getExternalStorageDirectory().getPath())).getBlockSize();
/*      */       long l;
/*  474 */       return (l = ((StatFs)localObject).getBlockCount()) * i;
/*      */     } catch (Throwable localThrowable) { Object localObject;
/*  476 */       if (!x.a(localObject = localThrowable)) {
/*  477 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*  480 */     return -2L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long i()
/*      */   {
/*  489 */     if (!o()) {
/*  490 */       return 0L;
/*      */     }
/*      */     
/*      */     try
/*      */     {
/*  495 */       int i = (localObject = new StatFs(Environment.getExternalStorageDirectory().getPath())).getBlockSize();
/*      */       long l;
/*  497 */       return (l = ((StatFs)localObject).getAvailableBlocks()) * i;
/*      */     } catch (Throwable localThrowable) { Object localObject;
/*  499 */       if (!x.a(localObject = localThrowable)) {
/*  500 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*  503 */     return -2L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static String j()
/*      */   {
/*  510 */     String str = "fail";
/*      */     try {
/*  512 */       str = Locale.getDefault().getCountry();
/*      */     } catch (Throwable localThrowable2) { Throwable localThrowable1;
/*  514 */       if (!x.a(localThrowable1 = 
/*      */       
/*      */ 
/*  517 */         localThrowable2)) {
/*  515 */         localThrowable1.printStackTrace();
/*      */       }
/*      */     }
/*  518 */     return str;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static String k()
/*      */   {
/*  525 */     String str = "fail";
/*      */     try {
/*  527 */       str = Build.BRAND;
/*      */     } catch (Throwable localThrowable2) { Throwable localThrowable1;
/*  529 */       if (!x.a(localThrowable1 = 
/*      */       
/*      */ 
/*  532 */         localThrowable2)) {
/*  530 */         localThrowable1.printStackTrace();
/*      */       }
/*      */     }
/*  533 */     return str;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String e(Context paramContext)
/*      */   {
/*  542 */     String str = "unknown";
/*      */     
/*      */ 
/*      */     try
/*      */     {
/*  547 */       if ((localObject = (localObject = (ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
/*  548 */         return null;
/*      */       }
/*  550 */       if (((NetworkInfo)localObject).getType() == 1) {
/*  551 */         str = "WIFI";
/*  552 */       } else if (((NetworkInfo)localObject).getType() == 0)
/*      */       {
/*      */ 
/*  555 */         if ((paramContext = (TelephonyManager)paramContext.getSystemService("phone")) != null)
/*      */         {
/*  557 */           switch (paramContext = paramContext.getNetworkType())
/*      */           {
/*      */           case 1: 
/*  559 */             str = "GPRS";
/*  560 */             break;
/*      */           case 2: 
/*  562 */             str = "EDGE";
/*  563 */             break;
/*      */           case 3: 
/*  565 */             str = "UMTS";
/*  566 */             break;
/*      */           case 8: 
/*  568 */             str = "HSDPA";
/*  569 */             break;
/*      */           case 9: 
/*  571 */             str = "HSUPA";
/*  572 */             break;
/*      */           case 10: 
/*  574 */             str = "HSPA";
/*  575 */             break;
/*      */           case 4: 
/*  577 */             str = "CDMA";
/*  578 */             break;
/*      */           case 5: 
/*  580 */             str = "EVDO_0";
/*  581 */             break;
/*      */           case 6: 
/*  583 */             str = "EVDO_A";
/*  584 */             break;
/*      */           case 7: 
/*  586 */             str = "1xRTT";
/*  587 */             break;
/*      */           case 11: 
/*  589 */             str = "iDen";
/*  590 */             break;
/*      */           case 12: 
/*  592 */             str = "EVDO_B";
/*  593 */             break;
/*      */           case 13: 
/*  595 */             str = "LTE";
/*  596 */             break;
/*      */           case 14: 
/*  598 */             str = "eHRPD";
/*  599 */             break;
/*      */           case 15: 
/*  601 */             str = "HSPA+";
/*  602 */             break;
/*      */           default: 
/*  604 */             str = "MOBILE(" + paramContext + ")";
/*      */           } }
/*      */       }
/*      */     } catch (Exception localException) {
/*      */       Object localObject;
/*  609 */       if (!x.a(localObject = 
/*      */       
/*      */ 
/*  612 */         localException)) {
/*  610 */         ((Exception)localObject).printStackTrace();
/*      */       }
/*      */     }
/*  613 */     return str;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static String f(Context paramContext)
/*      */   {
/*      */     String str;
/*      */     
/*      */ 
/*  623 */     if ((!z.a(str = z.a(paramContext, "ro.miui.ui.version.name"))) && (!str.equals("fail"))) {
/*  624 */       return "XiaoMi/MIUI/" + str;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  629 */     if ((!z.a(str = z.a(paramContext, "ro.build.version.emui"))) && (!str.equals("fail"))) {
/*  630 */       return "HuaWei/EMOTION/" + str;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  635 */     if ((!z.a(str = z.a(paramContext, "ro.lenovo.series"))) && (!str.equals("fail"))) {
/*  636 */       str = z.a(paramContext, "ro.build.version.incremental");
/*  637 */       return "Lenovo/VIBE/" + str;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  642 */     if ((!z.a(str = z.a(paramContext, "ro.build.nubia.rom.name"))) && (!str.equals("fail"))) {
/*  643 */       return "Zte/NUBIA/" + str + "_" + z.a(paramContext, "ro.build.nubia.rom.code");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  649 */     if ((!z.a(str = z.a(paramContext, "ro.meizu.product.model"))) && (!str.equals("fail"))) {
/*  650 */       return "Meizu/FLYME/" + z.a(paramContext, "ro.build.display.id");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  655 */     if ((!z.a(str = z.a(paramContext, "ro.build.version.opporom"))) && (!str.equals("fail"))) {
/*  656 */       return "Oppo/COLOROS/" + str;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  661 */     if ((!z.a(str = z.a(paramContext, "ro.vivo.os.build.display.id"))) && (!str.equals("fail"))) {
/*  662 */       return "vivo/FUNTOUCH/" + str;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  667 */     if ((!z.a(str = z.a(paramContext, "ro.aa.romver"))) && (!str.equals("fail"))) {
/*  668 */       return "htc/" + str + "/" + z.a(paramContext, "ro.build.description");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  673 */     if ((!z.a(str = z.a(paramContext, "ro.lewa.version"))) && (!str.equals("fail"))) {
/*  674 */       return "tcl/" + str + "/" + z.a(paramContext, "ro.build.display.id");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  679 */     if ((!z.a(str = z.a(paramContext, "ro.gn.gnromvernumber"))) && (!str.equals("fail"))) {
/*  680 */       return "amigo/" + str + "/" + z.a(paramContext, "ro.build.display.id");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  685 */     if ((!z.a(str = z.a(paramContext, "ro.build.tyd.kbstyle_version"))) && (!str.equals("fail"))) {
/*  686 */       return "dido/" + str;
/*      */     }
/*      */     
/*      */ 
/*  690 */     return z.a(paramContext, "ro.build.fingerprint") + "/" + z.a(paramContext, "ro.build.rom.id");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String g(Context paramContext)
/*      */   {
/*  699 */     return z.a(paramContext, "ro.board.platform");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean h(Context paramContext)
/*      */   {
/*  709 */     boolean bool1 = false;
/*  710 */     boolean bool2 = false;
/*      */     try {
/*  712 */       bool2 = new File("/system/app/Superuser.apk").exists();
/*      */     } catch (Throwable localThrowable) {
/*  714 */       if (!x.b(localObject = 
/*      */       
/*      */ 
/*  717 */         localThrowable)) {
/*  715 */         ((Throwable)localObject).printStackTrace();
/*      */       }
/*      */     }
/*      */     
/*  719 */     Object localObject = null;
/*      */     
/*      */ 
/*  722 */     if (((paramContext = z.a(paramContext, new String[] { "/system/bin/sh", "-c", "type su" })) != null) && (paramContext.size() > 0)) {
/*  723 */       for (paramContext = paramContext.iterator(); paramContext.hasNext();) { String str;
/*  724 */         x.c(str = (String)paramContext.next(), new Object[0]);
/*  725 */         if (str.contains("not found")) {
/*  726 */           localObject = Boolean.valueOf(false);
/*      */         }
/*      */       }
/*  729 */       if (localObject == null) {
/*  730 */         localObject = Boolean.valueOf(true);
/*      */       }
/*      */     }
/*  733 */     localObject = Boolean.valueOf(localObject == null ? false : ((Boolean)localObject).booleanValue());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  738 */     if (((paramContext = (Build.TAGS != null) && (Build.TAGS.contains("test-keys")) ? 1 : 0) != 0) || (bool2) || (((Boolean)localObject).booleanValue())) {
/*  739 */       bool1 = true;
/*      */     }
/*  741 */     return bool1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String l()
/*      */   {
/*  750 */     Object localObject1 = null;
/*      */     try {
/*  752 */       StringBuilder localStringBuilder = new StringBuilder();
/*  753 */       if (new File("/sys/block/mmcblk0/device/type").exists())
/*      */       {
/*      */ 
/*  756 */         if ((str = (localObject1 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/type"))).readLine()) != null) {
/*  757 */           localStringBuilder.append(str);
/*      */         }
/*  759 */         ((BufferedReader)localObject1).close();
/*      */       }
/*  761 */       localStringBuilder.append(",");
/*  762 */       if (new File("/sys/block/mmcblk0/device/name").exists())
/*      */       {
/*      */ 
/*  765 */         if ((str = (localObject1 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/name"))).readLine()) != null) {
/*  766 */           localStringBuilder.append(str);
/*      */         }
/*  768 */         ((BufferedReader)localObject1).close();
/*      */       }
/*  770 */       localStringBuilder.append(",");
/*  771 */       if (new File("/sys/block/mmcblk0/device/cid").exists())
/*      */       {
/*      */ 
/*  774 */         if ((str = (localObject1 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/cid"))).readLine()) != null) {
/*  775 */           localStringBuilder.append(str);
/*      */         }
/*      */       }
/*  778 */       String str = localStringBuilder.toString();
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  783 */       if (localObject1 != null)
/*      */         try {
/*  785 */           ((BufferedReader)localObject1).close();
/*      */         } catch (IOException localIOException1) {
/*  787 */           x.a(localObject1 = 
/*  788 */             localIOException1); } return str;
/*      */     }
/*      */     catch (Throwable localThrowable)
/*      */     {
/*  779 */       
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  788 */         localThrowable;
/*  781 */       if (localObject1 != null)
/*      */       {
/*      */         try
/*      */         {
/*  785 */           ((BufferedReader)localObject1).close();
/*      */         } catch (IOException localIOException2) {
/*  787 */           x.a(localObject1 = 
/*  788 */             localIOException2); } } return null;
/*      */     }
/*      */     finally
/*      */     {
/*  783 */       localObject2 = 
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  788 */         finally;
/*  783 */       if (localObject1 != null)
/*      */         try {
/*  785 */           ((BufferedReader)localObject1).close();
/*      */         } catch (IOException localIOException3) {
/*  787 */           x.a(localObject1 = 
/*  788 */             localIOException3); } throw ((Throwable)localObject2);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String i(Context paramContext)
/*      */   {
/*  800 */     StringBuilder localStringBuilder = new StringBuilder();
/*      */     
/*      */     String str;
/*  803 */     if ((str = z.a(paramContext, "ro.genymotion.version")) != null) {
/*  804 */       localStringBuilder.append("ro.genymotion.version");
/*  805 */       localStringBuilder.append("|");
/*  806 */       localStringBuilder.append(str);
/*  807 */       localStringBuilder.append("\n");
/*      */     }
/*      */     
/*      */ 
/*  811 */     if ((str = z.a(paramContext, "androVM.vbox_dpi")) != null) {
/*  812 */       localStringBuilder.append("androVM.vbox_dpi");
/*  813 */       localStringBuilder.append("|");
/*  814 */       localStringBuilder.append(str);
/*  815 */       localStringBuilder.append("\n");
/*      */     }
/*      */     
/*      */ 
/*  819 */     if ((str = z.a(paramContext, "qemu.sf.fake_camera")) != null) {
/*  820 */       localStringBuilder.append("qemu.sf.fake_camera");
/*  821 */       localStringBuilder.append("|");
/*  822 */       localStringBuilder.append(str);
/*      */     }
/*  824 */     return localStringBuilder.toString();
/*      */   }
/*      */   
/*  827 */   private static String a = null;
/*  828 */   private static String b = null;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String j(Context paramContext)
/*      */   {
/*  837 */     StringBuilder localStringBuilder = new StringBuilder();
/*      */     
/*  839 */     if (a == null) {
/*  840 */       a = z.a(paramContext, "ro.secure");
/*      */     }
/*  842 */     if (a != null) {
/*  843 */       localStringBuilder.append("ro.secure");
/*  844 */       localStringBuilder.append("|");
/*  845 */       localStringBuilder.append(a);
/*  846 */       localStringBuilder.append("\n");
/*      */     }
/*      */     
/*  849 */     if (b == null) {
/*  850 */       b = z.a(paramContext, "ro.debuggable");
/*      */     }
/*  852 */     if (b != null) {
/*  853 */       localStringBuilder.append("ro.debuggable");
/*  854 */       localStringBuilder.append("|");
/*  855 */       localStringBuilder.append(b);
/*  856 */       localStringBuilder.append("\n");
/*      */     }
/*  858 */     paramContext = null;
/*      */     try
/*      */     {
/*  861 */       paramContext = new BufferedReader(new FileReader("/proc/self/status"));
/*  862 */       localObject2 = null;
/*  863 */       while (((localObject2 = paramContext.readLine()) != null) && 
/*  864 */         (!((String)localObject2).startsWith("TracerPid:"))) {}
/*  865 */       if (localObject2 != null)
/*      */       {
/*      */ 
/*      */ 
/*  869 */         localObject2 = ((String)localObject2).substring(10).trim();
/*  870 */         localStringBuilder.append("tracer_pid");
/*  871 */         localStringBuilder.append("|");
/*  872 */         localStringBuilder.append((String)localObject2);
/*      */       }
/*  874 */       localObject2 = localStringBuilder.toString();
/*      */       
/*      */       try
/*      */       {
/*  878 */         paramContext.close();
/*      */       }
/*      */       catch (IOException localIOException1)
/*      */       {
/*  882 */         x.a(paramContext = 
/*  883 */           localIOException1); } return (String)localObject2;
/*      */     }
/*      */     catch (Throwable localThrowable) {}finally
/*      */     {
/*      */       Object localObject2;
/*  878 */       if (paramContext != null)
/*      */         try {
/*  880 */           paramContext.close();
/*      */         } catch (IOException localIOException3) {
/*  882 */           x.a(paramContext = 
/*  883 */             localIOException3);
/*      */         }
/*      */     }
/*  886 */     return ((StringBuilder)localObject1).toString();
/*      */   }
/*      */   
/*      */   /* Error */
/*      */   public static String m()
/*      */   {
/*      */     // Byte code:
/*      */     //   0: new 130	java/lang/StringBuilder
/*      */     //   3: dup
/*      */     //   4: invokespecial 201	java/lang/StringBuilder:<init>	()V
/*      */     //   7: astore_0
/*      */     //   8: aconst_null
/*      */     //   9: astore_1
/*      */     //   10: new 121	java/io/File
/*      */     //   13: dup
/*      */     //   14: ldc 14
/*      */     //   16: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
/*      */     //   19: invokevirtual 182	java/io/File:exists	()Z
/*      */     //   22: ifeq +53 -> 75
/*      */     //   25: new 120	java/io/BufferedReader
/*      */     //   28: dup
/*      */     //   29: new 122	java/io/FileReader
/*      */     //   32: dup
/*      */     //   33: ldc 14
/*      */     //   35: invokespecial 184	java/io/FileReader:<init>	(Ljava/lang/String;)V
/*      */     //   38: invokespecial 177	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
/*      */     //   41: dup
/*      */     //   42: astore_1
/*      */     //   43: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
/*      */     //   46: dup
/*      */     //   47: astore_2
/*      */     //   48: ifnull +23 -> 71
/*      */     //   51: aload_0
/*      */     //   52: ldc 48
/*      */     //   54: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   57: pop
/*      */     //   58: aload_0
/*      */     //   59: ldc 102
/*      */     //   61: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   64: pop
/*      */     //   65: aload_0
/*      */     //   66: aload_2
/*      */     //   67: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   70: pop
/*      */     //   71: aload_1
/*      */     //   72: invokevirtual 179	java/io/BufferedReader:close	()V
/*      */     //   75: aload_0
/*      */     //   76: ldc 2
/*      */     //   78: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   81: pop
/*      */     //   82: new 121	java/io/File
/*      */     //   85: dup
/*      */     //   86: ldc 16
/*      */     //   88: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
/*      */     //   91: invokevirtual 182	java/io/File:exists	()Z
/*      */     //   94: ifeq +53 -> 147
/*      */     //   97: new 120	java/io/BufferedReader
/*      */     //   100: dup
/*      */     //   101: new 122	java/io/FileReader
/*      */     //   104: dup
/*      */     //   105: ldc 16
/*      */     //   107: invokespecial 184	java/io/FileReader:<init>	(Ljava/lang/String;)V
/*      */     //   110: invokespecial 177	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
/*      */     //   113: dup
/*      */     //   114: astore_1
/*      */     //   115: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
/*      */     //   118: dup
/*      */     //   119: astore_2
/*      */     //   120: ifnull +23 -> 143
/*      */     //   123: aload_0
/*      */     //   124: ldc 99
/*      */     //   126: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   129: pop
/*      */     //   130: aload_0
/*      */     //   131: ldc 102
/*      */     //   133: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   136: pop
/*      */     //   137: aload_0
/*      */     //   138: aload_2
/*      */     //   139: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   142: pop
/*      */     //   143: aload_1
/*      */     //   144: invokevirtual 179	java/io/BufferedReader:close	()V
/*      */     //   147: aload_0
/*      */     //   148: ldc 2
/*      */     //   150: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   153: pop
/*      */     //   154: new 121	java/io/File
/*      */     //   157: dup
/*      */     //   158: ldc 15
/*      */     //   160: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
/*      */     //   163: invokevirtual 182	java/io/File:exists	()Z
/*      */     //   166: ifeq +53 -> 219
/*      */     //   169: new 120	java/io/BufferedReader
/*      */     //   172: dup
/*      */     //   173: new 122	java/io/FileReader
/*      */     //   176: dup
/*      */     //   177: ldc 15
/*      */     //   179: invokespecial 184	java/io/FileReader:<init>	(Ljava/lang/String;)V
/*      */     //   182: invokespecial 177	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
/*      */     //   185: dup
/*      */     //   186: astore_1
/*      */     //   187: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
/*      */     //   190: dup
/*      */     //   191: astore_2
/*      */     //   192: ifnull +23 -> 215
/*      */     //   195: aload_0
/*      */     //   196: ldc 53
/*      */     //   198: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   201: pop
/*      */     //   202: aload_0
/*      */     //   203: ldc 102
/*      */     //   205: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   208: pop
/*      */     //   209: aload_0
/*      */     //   210: aload_2
/*      */     //   211: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   214: pop
/*      */     //   215: aload_1
/*      */     //   216: invokevirtual 179	java/io/BufferedReader:close	()V
/*      */     //   219: aload_1
/*      */     //   220: ifnull +60 -> 280
/*      */     //   223: aload_1
/*      */     //   224: invokevirtual 179	java/io/BufferedReader:close	()V
/*      */     //   227: goto +53 -> 280
/*      */     //   230: dup
/*      */     //   231: astore_2
/*      */     //   232: invokestatic 170	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
/*      */     //   235: pop
/*      */     //   236: goto +44 -> 280
/*      */     //   239: pop
/*      */     //   240: aload_1
/*      */     //   241: ifnull +39 -> 280
/*      */     //   244: aload_1
/*      */     //   245: invokevirtual 179	java/io/BufferedReader:close	()V
/*      */     //   248: goto +32 -> 280
/*      */     //   251: dup
/*      */     //   252: astore_2
/*      */     //   253: invokestatic 170	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
/*      */     //   256: pop
/*      */     //   257: goto +23 -> 280
/*      */     //   260: astore_0
/*      */     //   261: aload_1
/*      */     //   262: ifnull +16 -> 278
/*      */     //   265: aload_1
/*      */     //   266: invokevirtual 179	java/io/BufferedReader:close	()V
/*      */     //   269: goto +9 -> 278
/*      */     //   272: dup
/*      */     //   273: astore_1
/*      */     //   274: invokestatic 170	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
/*      */     //   277: pop
/*      */     //   278: aload_0
/*      */     //   279: athrow
/*      */     //   280: aload_0
/*      */     //   281: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*      */     //   284: areturn
/*      */     // Line number table:
/*      */     //   Java source line #896	-> byte code offset #0
/*      */     //   Java source line #897	-> byte code offset #8
/*      */     //   Java source line #899	-> byte code offset #10
/*      */     //   Java source line #901	-> byte code offset #25
/*      */     //   Java source line #902	-> byte code offset #42
/*      */     //   Java source line #903	-> byte code offset #47
/*      */     //   Java source line #904	-> byte code offset #51
/*      */     //   Java source line #905	-> byte code offset #58
/*      */     //   Java source line #906	-> byte code offset #65
/*      */     //   Java source line #908	-> byte code offset #71
/*      */     //   Java source line #910	-> byte code offset #75
/*      */     //   Java source line #911	-> byte code offset #82
/*      */     //   Java source line #913	-> byte code offset #97
/*      */     //   Java source line #914	-> byte code offset #114
/*      */     //   Java source line #915	-> byte code offset #119
/*      */     //   Java source line #916	-> byte code offset #123
/*      */     //   Java source line #917	-> byte code offset #130
/*      */     //   Java source line #918	-> byte code offset #137
/*      */     //   Java source line #920	-> byte code offset #143
/*      */     //   Java source line #922	-> byte code offset #147
/*      */     //   Java source line #923	-> byte code offset #154
/*      */     //   Java source line #925	-> byte code offset #169
/*      */     //   Java source line #927	-> byte code offset #186
/*      */     //   Java source line #928	-> byte code offset #191
/*      */     //   Java source line #929	-> byte code offset #195
/*      */     //   Java source line #930	-> byte code offset #202
/*      */     //   Java source line #931	-> byte code offset #209
/*      */     //   Java source line #933	-> byte code offset #215
/*      */     //   Java source line #938	-> byte code offset #219
/*      */     //   Java source line #940	-> byte code offset #223
/*      */     //   Java source line #943	-> byte code offset #227
/*      */     //   Java source line #941	-> byte code offset #230
/*      */     //   Java source line #942	-> byte code offset #231
/*      */     //   Java source line #943	-> byte code offset #236
/*      */     //   Java source line #935	-> byte code offset #239
/*      */     //   Java source line #938	-> byte code offset #240
/*      */     //   Java source line #940	-> byte code offset #244
/*      */     //   Java source line #943	-> byte code offset #248
/*      */     //   Java source line #941	-> byte code offset #251
/*      */     //   Java source line #942	-> byte code offset #252
/*      */     //   Java source line #943	-> byte code offset #257
/*      */     //   Java source line #938	-> byte code offset #260
/*      */     //   Java source line #940	-> byte code offset #265
/*      */     //   Java source line #943	-> byte code offset #269
/*      */     //   Java source line #941	-> byte code offset #272
/*      */     //   Java source line #942	-> byte code offset #273
/*      */     //   Java source line #943	-> byte code offset #278
/*      */     //   Java source line #946	-> byte code offset #280
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	signature
/*      */     //   7	203	0	localStringBuilder	StringBuilder
/*      */     //   260	21	0	localObject1	Object
/*      */     //   9	265	1	localObject2	Object
/*      */     //   47	206	2	localObject3	Object
/*      */     //   230	1	4	localIOException1	IOException
/*      */     //   239	1	5	localThrowable	Throwable
/*      */     //   251	1	6	localIOException2	IOException
/*      */     //   272	1	7	localIOException3	IOException
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   223	227	230	java/io/IOException
/*      */     //   10	219	239	java/lang/Throwable
/*      */     //   244	248	251	java/io/IOException
/*      */     //   10	219	260	finally
/*      */     //   265	269	272	java/io/IOException
/*      */   }
/*      */   
/*      */   public static String k(Context paramContext)
/*      */   {
/*  956 */     StringBuilder localStringBuilder = new StringBuilder();
/*      */     
/*      */     String str;
/*  959 */     if ((str = z.a(paramContext, "gsm.sim.state")) != null) {
/*  960 */       localStringBuilder.append("gsm.sim.state");
/*  961 */       localStringBuilder.append("|");
/*  962 */       localStringBuilder.append(str);
/*      */     }
/*  964 */     localStringBuilder.append("\n");
/*      */     
/*      */ 
/*  967 */     if ((str = z.a(paramContext, "gsm.sim.state2")) != null) {
/*  968 */       localStringBuilder.append("gsm.sim.state2");
/*  969 */       localStringBuilder.append("|");
/*  970 */       localStringBuilder.append(str);
/*      */     }
/*  972 */     return localStringBuilder.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long n()
/*      */   {
/*  982 */     float f = 0.0F;
/*  983 */     Object localObject2 = null;
/*      */     
/*      */     try
/*      */     {
/*      */       Object localObject3;
/*  988 */       if ((localObject3 = (localObject2 = new BufferedReader(new FileReader("/proc/uptime"))).readLine()) != null) {
/*  989 */         localObject3 = localObject3.split(" ")[0];
/*  990 */         f = (float)(System.currentTimeMillis() / 1000L) - Float.parseFloat((String)localObject3);
/*      */       }
/*      */       
/*      */       try
/*      */       {
/*  995 */         ((BufferedReader)localObject2).close();
/*      */       }
/*      */       catch (IOException localIOException1)
/*      */       {
/*  999 */         x.a(localObject3 = 
/* 1000 */           localIOException1);
/*      */       }
/*      */       
/* 1003 */       return localObject1;
/*      */     }
/*      */     catch (Throwable localThrowable) {}finally
/*      */     {
/*  995 */       if (localObject2 != null) {
/*      */         try {
/*  997 */           ((BufferedReader)localObject2).close();
/*      */         } catch (IOException localIOException3) {
/*  999 */           x.a(localObject2 = 
/* 1000 */             localIOException3);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/common/info/b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */