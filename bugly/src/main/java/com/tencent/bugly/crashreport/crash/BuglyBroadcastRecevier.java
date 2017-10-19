/*     */ package com.tencent.bugly.crashreport.crash;
/*     */ 
/*     */ import android.content.BroadcastReceiver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.IntentFilter;
/*     */ import com.tencent.bugly.proguard.u;
/*     */ import com.tencent.bugly.proguard.x;
/*     */ import com.tencent.bugly.proguard.z;
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
/*     */ public class BuglyBroadcastRecevier
/*     */   extends BroadcastReceiver
/*     */ {
/*     */   private IntentFilter a;
/*     */   private Context b;
/*     */   private String c;
/*  32 */   private static BuglyBroadcastRecevier d = null;
/*  33 */   private boolean e = true;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized BuglyBroadcastRecevier getInstance()
/*     */   {
/*  41 */     if (d == null) {
/*  42 */       d = new BuglyBroadcastRecevier();
/*     */     }
/*  44 */     return d;
/*     */   }
/*     */   
/*     */   public BuglyBroadcastRecevier() {
/*  48 */     this.a = new IntentFilter();
/*     */   }
/*     */   
/*     */   protected void finalize()
/*     */     throws Throwable
/*     */   {
/*  54 */     super.finalize();
/*  55 */     if (this.b != null) {
/*  56 */       this.b.unregisterReceiver(this);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void addFilter(String paramString)
/*     */   {
/*  67 */     if (!this.a.hasAction(paramString)) {
/*  68 */       this.a.addAction(paramString);
/*     */     }
/*  70 */     x.c("add action %s", new Object[] { paramString });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void register(final Context paramContext)
/*     */   {
/*  79 */     this.b = paramContext;
/*  80 */     paramContext = this;
/*  81 */     z.a(new Runnable()
/*     */     {
/*     */       public final void run()
/*     */       {
/*     */         try {
/*  86 */           x.a(BuglyBroadcastRecevier.a().getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
/*  87 */           synchronized (paramContext) {
/*  88 */             BuglyBroadcastRecevier.b(BuglyBroadcastRecevier.this).registerReceiver(BuglyBroadcastRecevier.a(), BuglyBroadcastRecevier.a(BuglyBroadcastRecevier.this));
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*  93 */           return;
/*     */         }
/*     */         catch (Throwable localThrowable)
/*     */         {
/*  91 */           
/*  92 */             (??? = localThrowable).printStackTrace();
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void unregister(Context paramContext)
/*     */   {
/*     */     try
/*     */     {
/* 105 */       x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
/* 106 */       paramContext.unregisterReceiver(this);
/* 107 */       this.b = paramContext; return;
/*     */     } catch (Throwable localThrowable) {
/* 109 */       if (!x.a(paramContext = 
/*     */       
/*     */ 
/* 112 */         localThrowable)) {
/* 110 */         paramContext.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final void onReceive(Context paramContext, Intent paramIntent)
/*     */   {
/*     */     try {
/* 118 */       a(paramContext, paramIntent); return;
/*     */     } catch (Throwable localThrowable) {
/* 120 */       if (!x.a(paramContext = 
/*     */       
/*     */ 
/* 123 */         localThrowable)) {
/* 121 */         paramContext.printStackTrace();
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
/*     */   private synchronized boolean a(Context paramContext, Intent paramIntent)
/*     */   {
/* 134 */     if ((paramContext == null) || (paramIntent == null) || (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")))
/*     */     {
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     if (this.e)
/*     */     {
/* 141 */       this.e = false;
/* 142 */       return true;
/*     */     }
/*     */     
/* 145 */     paramIntent = com.tencent.bugly.crashreport.common.info.b.e(this.b);
/* 146 */     x.c("is Connect BC " + paramIntent, new Object[0]);
/* 147 */     x.a("network %s changed to %s", new Object[] { this.c, paramIntent });
/*     */     
/* 149 */     if (paramIntent == null)
/*     */     {
/* 151 */       this.c = null;
/* 152 */       return true;
/*     */     }
/* 154 */     String str = this.c;
/* 155 */     this.c = paramIntent;
/*     */     
/*     */ 
/* 158 */     long l = System.currentTimeMillis();
/* 159 */     com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
/* 160 */     u localu = u.a();
/* 161 */     paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
/*     */     
/* 163 */     if ((locala == null) || (localu == null) || (paramContext == null)) {
/* 164 */       x.d("not inited BC not work", new Object[0]);
/* 165 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 169 */     if (!paramIntent.equals(str)) {
/* 170 */       if (l - localu.a(c.a) > 30000L)
/*     */       {
/*     */ 
/* 173 */         x.a("try to upload crash on network changed.", new Object[0]);
/*     */         
/* 175 */         if ((paramContext = c.a()) != null) {
/* 176 */           paramContext.a(0L);
/*     */         }
/*     */       }
/* 179 */       if (l - localu.a(1001) > 30000L)
/*     */       {
/* 181 */         x.a("try to upload userinfo on network changed.", new Object[0]);
/*     */         
/* 183 */         com.tencent.bugly.crashreport.biz.b.a.b();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 189 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/BuglyBroadcastRecevier.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */