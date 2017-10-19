/*    */ package com.tencent.bugly.crashreport.crash;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.tencent.bugly.proguard.w;
/*    */ import com.tencent.bugly.proguard.x;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class d
/*    */ {
/* 23 */   private static d a = null;
/*    */   
/*    */   private com.tencent.bugly.crashreport.common.strategy.a b;
/*    */   
/*    */   private com.tencent.bugly.crashreport.common.info.a c;
/*    */   
/*    */   private b d;
/*    */   
/*    */   private Context e;
/*    */   
/*    */   private d(Context paramContext)
/*    */   {
/*    */     c localc;
/* 36 */     if ((localc = c.a()) == null) {
/* 37 */       return;
/*    */     }
/* 39 */     this.b = com.tencent.bugly.crashreport.common.strategy.a.a();
/* 40 */     this.c = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
/* 41 */     this.d = localc.o;
/* 42 */     this.e = paramContext;
/*    */     
/*    */ 
/* 45 */     w.a().a(new Runnable()
/*    */     {
/*    */       public final void run()
/*    */       {
/* 49 */         d.a(d.this);
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static d a(Context paramContext)
/*    */   {
/* 60 */     if (a == null) {
/* 61 */       a = new d(paramContext);
/*    */     }
/* 63 */     return a;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void a(Thread paramThread, final int paramInt, final String paramString1, final String paramString2, final String paramString3, final Map<String, String> paramMap)
/*    */   {
/* 72 */     w.a().a(new Runnable()
/*    */     {
/*    */       public final void run() {
/*    */         try {
/* 76 */           if (d.a() == null) {
/* 77 */             x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
/*    */             
/* 79 */             return;
/*    */           }
/* 81 */           d.a(d.a(), this.a, paramInt, paramString1, paramString2, paramString3, paramMap); return;
/*    */         } catch (Throwable localThrowable2) {
/*    */           Throwable localThrowable1;
/* 84 */           if (!x.b(localThrowable1 = 
/*    */           
/*    */ 
/*    */ 
/*    */ 
/* 89 */             localThrowable2)) {
/* 85 */             localThrowable1.printStackTrace();
/*    */           }
/* 87 */           x.e("[ExtraCrashManager] Crash error %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
/*    */         }
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/crash/d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */