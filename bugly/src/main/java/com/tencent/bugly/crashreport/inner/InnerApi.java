/*    */ package com.tencent.bugly.crashreport.inner;
/*    */ 
/*    */ import com.tencent.bugly.crashreport.crash.d;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InnerApi
/*    */ {
/*    */   public static void postU3dCrashAsync(String paramString1, String paramString2, String paramString3)
/*    */   {
/* 29 */     if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
/* 30 */       x.e("post u3d fail args null", new Object[0]);
/*    */     }
/*    */     
/* 33 */     x.a("post u3d crash %s %s", new Object[] { paramString1, paramString2 });
/* 34 */     d.a(Thread.currentThread(), 4, paramString1, paramString2, paramString3, null);
/*    */   }
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
/*    */   public static void postCocos2dxCrashAsync(int paramInt, String paramString1, String paramString2, String paramString3)
/*    */   {
/* 48 */     if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
/* 49 */       x.e("post cocos2d-x fail args null", new Object[0]);
/* 50 */       return;
/*    */     }
/* 52 */     if ((paramInt != 5) && (paramInt != 6))
/*    */     {
/* 54 */       x.e("post cocos2d-x fail category illeagle: %d", new Object[] { Integer.valueOf(paramInt) });
/* 55 */       return;
/*    */     }
/*    */     
/* 58 */     x.a("post cocos2d-x crash %s %s", new Object[] { paramString1, paramString2 });
/* 59 */     d.a(Thread.currentThread(), paramInt, paramString1, paramString2, paramString3, null);
/*    */   }
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
/*    */   public static void postH5CrashAsync(Thread paramThread, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
/*    */   {
/* 75 */     if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
/* 76 */       x.e("post h5 fail args null", new Object[0]);
/* 77 */       return;
/*    */     }
/*    */     
/* 80 */     x.a("post h5 crash %s %s", new Object[] { paramString1, paramString2 });
/* 81 */     d.a(paramThread, 8, paramString1, paramString2, paramString3, paramMap);
/*    */   }
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/inner/InnerApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */