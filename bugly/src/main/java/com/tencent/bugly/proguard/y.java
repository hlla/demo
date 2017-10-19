/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Process;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
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
/*     */ public final class y
/*     */ {
/*  29 */   private static SimpleDateFormat b = null;
/*  30 */   public static boolean a = true;
/*  31 */   private static int c = 5120;
/*     */   
/*     */   private static StringBuilder d;
/*     */   private static StringBuilder e;
/*     */   private static boolean f;
/*     */   private static a g;
/*     */   private static String h;
/*     */   private static String i;
/*     */   private static Context j;
/*     */   private static String k;
/*     */   private static boolean l;
/*     */   private static int m;
/*  43 */   private static final Object n = new Object();
/*     */   
/*     */   static {
/*     */     try {
/*  47 */       b = new SimpleDateFormat("MM-dd HH:mm:ss");
/*     */       
/*     */ 
/*  50 */       return;
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean b(String paramString1, String paramString2, String paramString3)
/*     */   {
/*     */     try
/*     */     {
/*  64 */       if (((localObject = com.tencent.bugly.crashreport.common.info.a.b()) != null) && (((com.tencent.bugly.crashreport.common.info.a)localObject).D != null))
/*  65 */         return ((com.tencent.bugly.crashreport.common.info.a)localObject).D.appendLogToNative(paramString1, paramString2, paramString3);
/*     */     } catch (Throwable localThrowable) {
/*     */       Object localObject;
/*  68 */       if (!x.a(localObject = 
/*     */       
/*     */ 
/*  71 */         localThrowable)) {
/*  69 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized void a(Context paramContext)
/*     */   {
/*  82 */     if ((l) || (paramContext == null) || (!a)) {
/*  83 */       return;
/*     */     }
/*     */     try {
/*  86 */       e = new StringBuilder(0);
/*  87 */       d = new StringBuilder(0);
/*  88 */       j = paramContext;
/*     */       
/*  90 */       h = (paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext)).d;
/*  91 */       paramContext.getClass();i = "";
/*  92 */       k = j.getFilesDir().getPath() + "/buglylog_" + h + "_" + i + ".txt";
/*     */       
/*     */ 
/*  95 */       m = Process.myPid();
/*     */     }
/*     */     catch (Throwable paramContext) {}
/*     */     
/*  99 */     l = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void a(int paramInt)
/*     */   {
/* 108 */     synchronized (n) {
/* 109 */       c = paramInt;
/* 110 */       if (paramInt < 0) {
/* 111 */         c = 0;
/* 112 */       } else if (paramInt > 10240) {
/* 113 */         c = 10240;
/*     */       }
/* 115 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void a(String paramString1, String paramString2, Throwable paramThrowable)
/*     */   {
/* 126 */     if (paramThrowable == null) {
/* 127 */       return;
/*     */     }
/*     */     
/* 130 */     String str = (str = paramThrowable.getMessage()) == null ? "" : str;
/* 131 */     paramThrowable = str + '\n' + z.b(paramThrowable);
/* 132 */     a(paramString1, paramString2, paramThrowable);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized void a(String paramString1, String arg1, String paramString3)
/*     */   {
/* 143 */     if ((!l) || (!a)) {
/* 144 */       return;
/*     */     }
/*     */     
/*     */ 
/* 148 */     b(paramString1, ???, paramString3);
/*     */     
/* 150 */     long l1 = Process.myTid();
/* 151 */     long l2 = l1;paramString3 = paramString3;??? = ???;paramString1 = paramString1;d.setLength(0); if (paramString3.length() > 30720) paramString3 = paramString3.substring(paramString3.length() - 30720, paramString3.length() - 1); Object localObject = new Date(); if (b != null) localObject = b.format((Date)localObject); else localObject = ((Date)localObject).toString(); d.append((String)localObject).append(" ").append(m).append(" ").append(l2).append(" ").append(paramString1).append(" ").append(???).append(": ").append(paramString3).append("\001\r\n");paramString1 = d.toString();
/*     */     
/* 153 */     synchronized (n) {
/* 154 */       e.append(paramString1);
/* 155 */       if (e.length() <= c) {
/* 156 */         return;
/*     */       }
/* 158 */       if (f)
/*     */       {
/* 160 */         return;
/*     */       }
/*     */       
/* 163 */       f = true;
/* 164 */       w.a().a(new Runnable()
/*     */       {
/*     */         public final void run() {
/* 167 */           synchronized () {
/*     */             try {
/* 169 */               if (y.c() == null)
/*     */               {
/* 171 */                 y.a(new y.a(y.d()));
/* 172 */               } else if ((y.a.a(y.c()) == null) || (y.a.a(y.c()).length() + y.e().length() > y.a.b(y.c())))
/*     */               {
/*     */ 
/* 175 */                 y.a.c(y.c());
/*     */               }
/* 177 */               if (y.a.d(y.c()))
/*     */               {
/* 179 */                 y.c().a(y.e().toString());
/* 180 */                 y.e().setLength(0);
/*     */               }
/*     */               else {
/* 183 */                 y.e().setLength(0);
/* 184 */                 y.e().append(this.a);
/*     */               }
/* 186 */               y.a(false);
/*     */             }
/*     */             catch (Throwable localThrowable) {}
/*     */             
/* 190 */             return;
/*     */           }
/*     */         }
/*     */       }); return;
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
/*     */   public static byte[] a()
/*     */   {
/* 221 */     if (!a) {
/* 222 */       return null;
/*     */     }
/* 224 */     synchronized (n)
/*     */     {
/*     */       try
/*     */       {
/*     */         Object localObject1;
/* 229 */         if ((g != null) && (a.d(g))) {
/* 230 */           localObject1 = a.a(g);
/*     */         } else {
/* 232 */           localObject1 = null;
/*     */         }
/* 234 */         if ((e.length() == 0) && (localObject1 == null)) {
/* 235 */           return null;
/*     */         }
/*     */         
/* 238 */         return localObject1 = z.a((File)localObject1, e.toString(), "BuglyLog.txt");
/*     */       }
/*     */       catch (Throwable localThrowable) {
/* 241 */         return null;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static class a
/*     */   {
/*     */     private boolean a;
/*     */     
/*     */     private File b;
/*     */     private String c;
/*     */     private long d;
/* 254 */     private long e = 30720L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public a(String paramString)
/*     */     {
/* 262 */       if ((paramString == null) || (paramString.equals(""))) {
/* 263 */         return;
/*     */       }
/* 265 */       this.c = paramString;
/* 266 */       this.a = a();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private boolean a()
/*     */     {
/*     */       try
/*     */       {
/* 276 */         this.b = new File(this.c);
/* 277 */         boolean bool; if (this.b.exists())
/*     */         {
/* 279 */           if (!(bool = this.b.delete())) {
/* 280 */             this.a = false;
/* 281 */             return false;
/*     */           }
/*     */         }
/*     */         
/* 285 */         if (!(bool = this.b.createNewFile())) {
/* 286 */           this.a = false;
/* 287 */           return false;
/*     */         }
/*     */       } catch (Throwable localThrowable) {
/* 290 */         this.a = false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 295 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public final boolean a(String paramString)
/*     */     {
/* 305 */       if (!this.a) {
/* 306 */         return false;
/*     */       }
/* 308 */       FileOutputStream localFileOutputStream = null;
/*     */       try {
/* 310 */         localFileOutputStream = new FileOutputStream(this.b, true);
/* 311 */         paramString = paramString.getBytes("UTF-8");
/* 312 */         localFileOutputStream.write(paramString);
/* 313 */         localFileOutputStream.flush();
/* 314 */         localFileOutputStream.close();
/* 315 */         this.d += paramString.length;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 320 */           localFileOutputStream.close();
/*     */         }
/*     */         catch (IOException localIOException1) {}
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 328 */         return true;
/*     */       }
/*     */       catch (Throwable paramString)
/*     */       {
/* 317 */         this.a = false;
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 325 */         return false;
/*     */       }
/*     */       finally
/*     */       {
/* 320 */         if (localFileOutputStream != null) {
/*     */           try {
/* 322 */             localFileOutputStream.close();
/*     */           }
/*     */           catch (IOException localIOException3) {}
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/y.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */