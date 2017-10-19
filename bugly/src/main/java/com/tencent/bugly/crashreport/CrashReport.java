/*      */ package com.tencent.bugly.crashreport;
/*      */ 
/*      */ import android.annotation.SuppressLint;
/*      */ import android.content.Context;
/*      */ import android.os.Build;
import android.os.Build.VERSION;
/*      */ import android.util.Log;
/*      */ import android.webkit.WebSettings;
/*      */ import android.webkit.WebView;
/*      */ import com.tencent.bugly.BuglyStrategy;
/*      */ import com.tencent.bugly.BuglyStrategy.a;
/*      */ import com.tencent.bugly.CrashModule;
/*      */ import com.tencent.bugly.crashreport.common.info.a;
/*      */ import com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier;
/*      */ import com.tencent.bugly.crashreport.crash.c;
/*      */ import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
/*      */ import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
/*      */ import com.tencent.bugly.proguard.w;
/*      */ import com.tencent.bugly.proguard.x;
/*      */ import com.tencent.bugly.proguard.z;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class CrashReport
/*      */ {
/*      */   private static Context a;
/*      */   
/*      */   public static void enableBugly(boolean paramBoolean)
/*      */   {
/*   48 */     com.tencent.bugly.b.a = paramBoolean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void initCrashReport(Context paramContext)
/*      */   {
/*   58 */     a = paramContext;
/*   59 */     com.tencent.bugly.b.a(CrashModule.getInstance());
/*   60 */     com.tencent.bugly.b.a(paramContext);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void initCrashReport(Context paramContext, UserStrategy paramUserStrategy)
/*      */   {
/*   70 */     a = paramContext;
/*   71 */     com.tencent.bugly.b.a(CrashModule.getInstance());
/*   72 */     com.tencent.bugly.b.a(paramContext, paramUserStrategy);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void initCrashReport(Context paramContext, String paramString, boolean paramBoolean)
/*      */   {
/*   84 */     BuglyStrategy localBuglyStrategy = null;paramBoolean = paramBoolean;paramString = paramString;paramContext = paramContext; if (paramContext != null) { a = paramContext;com.tencent.bugly.b.a(CrashModule.getInstance());com.tencent.bugly.b.a(paramContext, paramString, paramBoolean, localBuglyStrategy);
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
/*      */   public static void initCrashReport(Context paramContext, String paramString, boolean paramBoolean, UserStrategy paramUserStrategy)
/*      */   {
/*   97 */     if (paramContext == null) {
/*   98 */       return;
/*      */     }
/*  100 */     a = paramContext;
/*  101 */     com.tencent.bugly.b.a(CrashModule.getInstance());
/*  102 */     com.tencent.bugly.b.a(paramContext, paramString, paramBoolean, paramUserStrategy);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getBuglyVersion(Context paramContext)
/*      */   {
/*  112 */     if (paramContext == null) {
/*  113 */       x.d("Please call with context.", new Object[0]);
/*  114 */       return "unknown";
/*      */     }
/*  116 */     a.a(paramContext);
/*  117 */     return a.c();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void testJavaCrash()
/*      */   {
/*  124 */     if (!com.tencent.bugly.b.a) {
/*  125 */       Log.w(x.a, "Can not test Java crash because bugly is disable.");
/*  126 */       return;
/*      */     }
/*  128 */     if (!CrashModule.hasInitialized()) {
/*  129 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!"); return;
/*      */     }
/*      */     
/*      */     a locala;
/*      */     
/*  134 */     if ((locala = a.b()) != null) {
/*  135 */       locala.b(24096);
/*      */     }
/*  137 */     throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void testNativeCrash()
/*      */   {
/*  145 */     if (!com.tencent.bugly.b.a) {
/*  146 */       Log.w(x.a, "Can not test native crash because bugly is disable.");
/*  147 */       return;
/*      */     }
/*  149 */     if (!CrashModule.hasInitialized()) {
/*  150 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  152 */       return;
/*      */     }
/*  154 */     x.a("start to create a native crash for test!", new Object[0]);
/*  155 */     c.a().j();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void testANRCrash()
/*      */   {
/*  162 */     if (!com.tencent.bugly.b.a) {
/*  163 */       Log.w(x.a, "Can not test ANR crash because bugly is disable.");
/*  164 */       return;
/*      */     }
/*  166 */     if (!CrashModule.hasInitialized()) {
/*  167 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  169 */       return;
/*      */     }
/*  171 */     x.a("start to create a anr crash for test!", new Object[0]);
/*  172 */     c.a().k();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void postCatchedException(Throwable paramThrowable)
/*      */   {
/*  179 */     Thread localThread = Thread.currentThread();paramThrowable = paramThrowable;postCatchedException(paramThrowable, localThread, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void postCatchedException(Throwable paramThrowable, Thread paramThread)
/*      */   {
/*  188 */     postCatchedException(paramThrowable, paramThread, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void postCatchedException(Throwable paramThrowable, Thread paramThread, boolean paramBoolean)
/*      */   {
/*  199 */     if (!com.tencent.bugly.b.a) {
/*  200 */       Log.w(x.a, "Can not post crash caught because bugly is disable.");
/*  201 */       return;
/*      */     }
/*  203 */     if (!CrashModule.hasInitialized()) {
/*  204 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  206 */       return;
/*      */     }
/*      */     
/*  209 */     if (paramThrowable == null) {
/*  210 */       x.d("throwable is null, just return", new Object[0]);
/*  211 */       return;
/*      */     }
/*      */     
/*  214 */     if (paramThread == null) {
/*  215 */       paramThread = Thread.currentThread();
/*      */     }
/*  217 */     c.a().a(paramThread, paramThrowable, false, null, null, paramBoolean);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void closeNativeReport()
/*      */   {
/*  225 */     if (!com.tencent.bugly.b.a) {
/*  226 */       Log.w(x.a, "Can not close native report because bugly is disable.");
/*  227 */       return;
/*      */     }
/*  229 */     if (!CrashModule.hasInitialized()) {
/*  230 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  232 */       return;
/*      */     }
/*      */     
/*  235 */     c.a().f();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void startCrashReport()
/*      */   {
/*  242 */     if (!com.tencent.bugly.b.a) {
/*  243 */       Log.w(x.a, "Can not start crash report because bugly is disable.");
/*  244 */       return;
/*      */     }
/*  246 */     if (!CrashModule.hasInitialized()) {
/*  247 */       Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  249 */       return;
/*      */     }
/*  251 */     c.a().c();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void closeCrashReport()
/*      */   {
/*  258 */     if (!com.tencent.bugly.b.a) {
/*  259 */       Log.w(x.a, "Can not close crash report because bugly is disable.");
/*  260 */       return;
/*      */     }
/*  262 */     if (!CrashModule.hasInitialized()) {
/*  263 */       Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  265 */       return;
/*      */     }
/*  267 */     c.a().d();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void closeBugly()
/*      */   {
/*  274 */     if (!com.tencent.bugly.b.a) {
/*  275 */       Log.w(x.a, "Can not close bugly because bugly is disable.");
/*  276 */       return;
/*      */     }
/*  278 */     if (!CrashModule.hasInitialized()) {
/*  279 */       Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  281 */       return;
/*      */     }
/*  283 */     if (a == null) {
/*      */       return;
/*      */     }
/*      */     
/*      */     Object localObject;
/*  288 */     if ((localObject = BuglyBroadcastRecevier.getInstance()) != null) {
/*  289 */       ((BuglyBroadcastRecevier)localObject).unregister(a);
/*      */     }
/*      */     
/*  292 */     closeCrashReport();
/*      */     
/*  294 */     com.tencent.bugly.crashreport.biz.b.a(a);
/*      */     
/*      */ 
/*  297 */     if ((localObject = w.a()) != null) {
/*  298 */       ((w)localObject).b();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setUserSceneTag(Context paramContext, int paramInt)
/*      */   {
/*  308 */     if (!com.tencent.bugly.b.a) {
/*  309 */       Log.w(x.a, "Can not set tag caught because bugly is disable.");
/*  310 */       return;
/*      */     }
/*  312 */     if (paramContext == null) {
/*  313 */       Log.e(x.a, "setTag args context should not be null");
/*  314 */       return;
/*      */     }
/*      */     
/*  317 */     if (paramInt <= 0) {
/*  318 */       x.d("setTag args tagId should > 0", new Object[0]);
/*      */     }
/*      */     
/*  321 */     a.a(paramContext).a(paramInt);
/*  322 */     x.b("[param] set user scene tag: %d", new Object[] { Integer.valueOf(paramInt) });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getUserSceneTagId(Context paramContext)
/*      */   {
/*  331 */     if (!com.tencent.bugly.b.a) {
/*  332 */       Log.w(x.a, "Can not get user scene tag because bugly is disable.");
/*  333 */       return -1;
/*      */     }
/*  335 */     if (paramContext == null) {
/*  336 */       Log.e(x.a, "getUserSceneTagId args context should not be null");
/*  337 */       return -1;
/*      */     }
/*      */     
/*  340 */     return a.a(paramContext).F();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getUserData(Context paramContext, String paramString)
/*      */   {
/*  351 */     if (!com.tencent.bugly.b.a) {
/*  352 */       Log.w(x.a, "Can not get user data because bugly is disable.");
/*  353 */       return "unknown";
/*      */     }
/*  355 */     if (paramContext == null) {
/*  356 */       Log.e(x.a, "getUserDataValue args context should not be null");
/*  357 */       return "unknown";
/*      */     }
/*      */     
/*  360 */     if (z.a(paramString)) {
/*  361 */       return null;
/*      */     }
/*      */     
/*  364 */     return a.a(paramContext).g(paramString);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void putUserData(Context paramContext, String paramString1, String paramString2)
/*      */   {
/*  376 */     if (!com.tencent.bugly.b.a) {
/*  377 */       Log.w(x.a, "Can not put user data because bugly is disable.");
/*  378 */       return;
/*      */     }
/*  380 */     if (paramContext == null) {
/*  381 */       Log.w(x.a, "putUserData args context should not be null");
/*  382 */       return;
/*      */     }
/*      */     
/*  385 */     if (paramString1 == null) {
/*  386 */       new StringBuilder().append(paramString1).toString();
/*  387 */       x.d("putUserData args key should not be null or empty", new Object[0]);
/*  388 */       return;
/*      */     }
/*      */     
/*  391 */     if (paramString2 == null) {
/*  392 */       new StringBuilder().append(paramString2).toString();
/*  393 */       x.d("putUserData args value should not be null", new Object[0]);
/*  394 */       return;
/*      */     }
/*      */     
/*  397 */     if (!paramString1.matches("[a-zA-Z[0-9]]+")) {
/*  398 */       x.d("putUserData args key should match [a-zA-Z[0-9]]+  {" + paramString1 + "}", new Object[0]);
/*  399 */       return;
/*      */     }
/*      */     
/*  402 */     if (paramString2.length() > 200) {
/*  403 */       x.d("user data value length over limit %d, it will be cutted!", new Object[] { Integer.valueOf(200) });
/*      */       
/*  405 */       paramString2 = paramString2.substring(0, 200);
/*      */     }
/*      */     
/*      */     Object localObject;
/*  409 */     if ((localObject = a.a(paramContext)).C().contains(paramString1))
/*      */     {
/*      */ 
/*      */ 
/*  413 */       if ((localObject = NativeCrashHandler.getInstance()) != null) {
/*  414 */         ((NativeCrashHandler)localObject).putKeyValueToNative(paramString1, paramString2);
/*      */       }
/*  416 */       a.a(paramContext).b(paramString1, paramString2);
/*  417 */       x.c("replace KV %s %s", new Object[] { paramString1, paramString2 });
/*  418 */       return;
/*      */     }
/*      */     
/*      */ 
/*  422 */     if (((a)localObject).B() >= 10) {
/*  423 */       x.d("user data size is over limit %d, it will be cutted!", new Object[] { Integer.valueOf(10) });
/*      */       
/*  425 */       return;
/*      */     }
/*      */     
/*  428 */     if (paramString1.length() > 50) {
/*  429 */       x.d("user data key length over limit %d , will drop this new key %s", new Object[] { Integer.valueOf(50), paramString1 });
/*      */       
/*  431 */       paramString1 = paramString1.substring(0, 50);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  436 */     if ((localObject = NativeCrashHandler.getInstance()) != null) {
/*  437 */       ((NativeCrashHandler)localObject).putKeyValueToNative(paramString1, paramString2);
/*      */     }
/*  439 */     a.a(paramContext).b(paramString1, paramString2);
/*  440 */     x.b("[param] set user data: %s - %s", new Object[] { paramString1, paramString2 });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String removeUserData(Context paramContext, String paramString)
/*      */   {
/*  450 */     if (!com.tencent.bugly.b.a) {
/*  451 */       Log.w(x.a, "Can not remove user data because bugly is disable.");
/*  452 */       return "unknown";
/*      */     }
/*  454 */     if (paramContext == null) {
/*  455 */       Log.e(x.a, "removeUserData args context should not be null");
/*  456 */       return "unknown";
/*      */     }
/*      */     
/*  459 */     if (z.a(paramString)) {
/*  460 */       return null;
/*      */     }
/*      */     
/*  463 */     x.b("[param] remove user data: %s", new Object[] { paramString });
/*  464 */     return a.a(paramContext).f(paramString);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Set<String> getAllUserDataKeys(Context paramContext)
/*      */   {
/*  474 */     if (!com.tencent.bugly.b.a) {
/*  475 */       Log.w(x.a, "Can not get all keys of user data because bugly is disable.");
/*  476 */       return new HashSet();
/*      */     }
/*  478 */     if (paramContext == null) {
/*  479 */       Log.e(x.a, "getAllUserDataKeys args context should not be null");
/*  480 */       return new HashSet();
/*      */     }
/*      */     
/*  483 */     return a.a(paramContext).C();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getUserDatasSize(Context paramContext)
/*      */   {
/*  493 */     if (!com.tencent.bugly.b.a) {
/*  494 */       Log.w(x.a, "Can not get size of user data because bugly is disable.");
/*  495 */       return -1;
/*      */     }
/*  497 */     if (paramContext == null) {
/*  498 */       Log.e(x.a, "getUserDatasSize args context should not be null");
/*  499 */       return -1;
/*      */     }
/*      */     
/*  502 */     return a.a(paramContext).B();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getAppID()
/*      */   {
/*  511 */     if (!com.tencent.bugly.b.a) {
/*  512 */       Log.w(x.a, "Can not get App ID because bugly is disable.");
/*  513 */       return "unknown";
/*      */     }
/*  515 */     if (!CrashModule.hasInitialized()) {
/*  516 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  518 */       return "unknown";
/*      */     }
/*      */     
/*  521 */     return a.a(a).f();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setUserId(String paramString)
/*      */   {
/*  530 */     if (!com.tencent.bugly.b.a) {
/*  531 */       Log.w(x.a, "Can not set user ID because bugly is disable.");
/*  532 */       return;
/*      */     }
/*  534 */     if (!CrashModule.hasInitialized()) {
/*  535 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  537 */       return;
/*      */     }
/*  539 */     setUserId(a, paramString);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setUserId(Context paramContext, String paramString)
/*      */   {
/*  550 */     if (!com.tencent.bugly.b.a) {
/*  551 */       Log.w(x.a, "Can not set user ID because bugly is disable.");
/*  552 */       return;
/*      */     }
/*  554 */     if (paramContext == null) {
/*  555 */       Log.e(x.a, "Context should not be null when bugly has not been initialed!");
/*  556 */       return;
/*      */     }
/*  558 */     if (paramString == null) {
/*  559 */       x.d("userId should not be null", new Object[0]); return;
/*      */     }
/*      */     Object localObject;
/*  562 */     if (paramString.length() > 100) {
/*  563 */       localObject = paramString.substring(0, 100);
/*  564 */       x.d("userId %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), localObject });
/*      */       
/*  566 */       paramString = (String)localObject;
/*      */     }
/*      */     
/*      */ 
/*  570 */     if (paramString.equals(a.a(paramContext).g())) {
/*  571 */       return;
/*      */     }
/*      */     
/*  574 */     a.a(paramContext).b(paramString);
/*      */     
/*  576 */     x.b("[user] set userId : %s", new Object[] { paramString });
/*      */     
/*      */ 
/*      */ 
/*  580 */     if ((localObject = NativeCrashHandler.getInstance()) != null) {
/*  581 */       ((NativeCrashHandler)localObject).setNativeUserId(paramString);
/*      */     }
/*      */     
/*      */ 
/*  585 */     if (CrashModule.hasInitialized())
/*      */     {
/*  587 */       com.tencent.bugly.crashreport.biz.b.a();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getUserId()
/*      */   {
/*  597 */     if (!com.tencent.bugly.b.a) {
/*  598 */       Log.w(x.a, "Can not get user ID because bugly is disable.");
/*  599 */       return "unknown";
/*      */     }
/*  601 */     if (!CrashModule.hasInitialized()) {
/*  602 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  604 */       return "unknown";
/*      */     }
/*      */     
/*  607 */     return a.a(a).g();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getAppVer()
/*      */   {
/*  616 */     if (!com.tencent.bugly.b.a) {
/*  617 */       Log.w(x.a, "Can not get app version because bugly is disable.");
/*  618 */       return "unknown";
/*      */     }
/*  620 */     if (!CrashModule.hasInitialized()) {
/*  621 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  623 */       return "unknown";
/*      */     }
/*      */     
/*  626 */     return a.a(a).j;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getAppChannel()
/*      */   {
/*  635 */     if (!com.tencent.bugly.b.a) {
/*  636 */       Log.w(x.a, "Can not get App channel because bugly is disable.");
/*  637 */       return "unknown";
/*      */     }
/*  639 */     if (!CrashModule.hasInitialized()) {
/*  640 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  642 */       return "unknown";
/*      */     }
/*      */     
/*  645 */     return a.a(a).l;
/*      */   }
/*      */   
/*      */   public static void setContext(Context paramContext) {
/*  649 */     a = paramContext;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isLastSessionCrash()
/*      */   {
/*  658 */     if (!com.tencent.bugly.b.a) {
/*  659 */       Log.w(x.a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
/*      */       
/*  661 */       return false;
/*      */     }
/*  663 */     if (!CrashModule.hasInitialized()) {
/*  664 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  666 */       return false;
/*      */     }
/*      */     
/*  669 */     return c.a().b();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setSdkExtraData(Context paramContext, String paramString1, String paramString2)
/*      */   {
/*  679 */     if (!com.tencent.bugly.b.a) {
/*  680 */       Log.w(x.a, "Can not put SDK extra data because bugly is disable.");
/*  681 */       return;
/*      */     }
/*  683 */     if ((paramContext == null) || (z.a(paramString1)) || (z.a(paramString2))) {
/*  684 */       return;
/*      */     }
/*  686 */     a.a(paramContext).a(paramString1, paramString2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<String, String> getSdkExtraData()
/*      */   {
/*  695 */     if (!com.tencent.bugly.b.a) {
/*  696 */       Log.w(x.a, "Can not get SDK extra data because bugly is disable.");
/*  697 */       return new HashMap();
/*      */     }
/*  699 */     if (!CrashModule.hasInitialized()) {
/*  700 */       Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
/*      */       
/*  702 */       return null;
/*      */     }
/*  704 */     return a.a(a).A;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<String, String> getSdkExtraData(Context paramContext)
/*      */   {
/*  713 */     if (!com.tencent.bugly.b.a) {
/*  714 */       Log.w(x.a, "Can not get SDK extra data because bugly is disable.");
/*  715 */       return new HashMap();
/*      */     }
/*  717 */     if (paramContext == null) {
/*  718 */       x.d("Context should not be null.", new Object[0]);
/*  719 */       return null;
/*      */     }
/*  721 */     return a.a(paramContext).A;
/*      */   }
/*      */   
/*      */   private static void putSdkData(Context paramContext, String paramString1, String paramString2)
/*      */   {
/*  726 */     if ((paramContext == null) || (z.a(paramString1)) || (z.a(paramString2))) {
/*  727 */       return;
/*      */     }
/*      */     
/*  730 */     if ((paramString1 = paramString1.replace("[a-zA-Z[0-9]]+", "")).length() > 100) {
/*  731 */       Log.w(x.a, String.format("putSdkData key length over limit %d, will be cutted.", new Object[] { Integer.valueOf(50) }));
/*      */       
/*  733 */       paramString1 = paramString1.substring(0, 50);
/*      */     }
/*  735 */     if (paramString2.length() > 500) {
/*  736 */       Log.w(x.a, String.format("putSdkData value length over limit %d, will be cutted!", new Object[] { Integer.valueOf(200) }));
/*      */       
/*  738 */       paramString2 = paramString2.substring(0, 200);
/*      */     }
/*      */     
/*  741 */     a.a(paramContext).c(paramString1, paramString2);
/*  742 */     x.b(String.format("[param] putSdkData data: %s - %s", new Object[] { paramString1, paramString2 }), new Object[0]);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void setIsAppForeground(Context paramContext, boolean paramBoolean)
/*      */   {
/*  749 */     if (!com.tencent.bugly.b.a) {
/*  750 */       Log.w(x.a, "Can not set 'isAppForeground' because bugly is disable.");
/*  751 */       return;
/*      */     }
/*  753 */     if (paramContext == null) {
/*  754 */       x.d("Context should not be null.", new Object[0]);
/*  755 */       return;
/*      */     }
/*  757 */     if (paramBoolean) {
/*  758 */       x.c("App is in foreground.", new Object[0]);
/*      */     } else {
/*  760 */       x.c("App is in background.", new Object[0]);
/*      */     }
/*  762 */     a.a(paramContext).a(paramBoolean);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void setIsDevelopmentDevice(Context paramContext, boolean paramBoolean)
/*      */   {
/*  769 */     if (!com.tencent.bugly.b.a) {
/*  770 */       Log.w(x.a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
/*  771 */       return;
/*      */     }
/*  773 */     if (paramContext == null) {
/*  774 */       x.d("Context should not be null.", new Object[0]);
/*  775 */       return;
/*      */     }
/*  777 */     if (paramBoolean) {
/*  778 */       x.c("This is a development device.", new Object[0]);
/*      */     } else {
/*  780 */       x.c("This is not a development device.", new Object[0]);
/*      */     }
/*  782 */     a.a(paramContext).y = paramBoolean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setSessionIntervalMills(long paramLong)
/*      */   {
/*  791 */     if (!com.tencent.bugly.b.a) {
/*  792 */       Log.w(x.a, "Can not set 'SessionIntervalMills' because bugly is disable.");
/*  793 */       return;
/*      */     }
/*  795 */     com.tencent.bugly.crashreport.biz.b.a(paramLong);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setAppVersion(Context paramContext, String paramString)
/*      */   {
/*  805 */     if (!com.tencent.bugly.b.a) {
/*  806 */       Log.w(x.a, "Can not set App version because bugly is disable.");
/*  807 */       return;
/*      */     }
/*  809 */     if (paramContext == null) {
/*  810 */       Log.w(x.a, "setAppVersion args context should not be null");
/*  811 */       return;
/*      */     }
/*  813 */     if (paramString == null) {
/*  814 */       Log.w(x.a, "App version is null, will not set");
/*  815 */       return;
/*      */     }
/*  817 */     a.a(paramContext).j = paramString;
/*      */     
/*      */ 
/*  820 */     if ((paramContext = NativeCrashHandler.getInstance()) != null) {
/*  821 */       paramContext.setNativeAppVersion(paramString);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setAppChannel(Context paramContext, String paramString)
/*      */   {
/*  832 */     if (!com.tencent.bugly.b.a) {
/*  833 */       Log.w(x.a, "Can not set App channel because Bugly is disable.");
/*  834 */       return;
/*      */     }
/*  836 */     if (paramContext == null) {
/*  837 */       Log.w(x.a, "setAppChannel args context should not be null");
/*  838 */       return;
/*      */     }
/*  840 */     if (paramString == null) {
/*  841 */       Log.w(x.a, "App channel is null, will not set");
/*  842 */       return;
/*      */     }
/*  844 */     a.a(paramContext).l = paramString;
/*      */     
/*      */ 
/*  847 */     if ((paramContext = NativeCrashHandler.getInstance()) != null) {
/*  848 */       paramContext.setNativeAppChannel(paramString);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setAppPackage(Context paramContext, String paramString)
/*      */   {
/*  859 */     if (!com.tencent.bugly.b.a) {
/*  860 */       Log.w(x.a, "Can not set App package because bugly is disable.");
/*  861 */       return;
/*      */     }
/*  863 */     if (paramContext == null) {
/*  864 */       Log.w(x.a, "setAppPackage args context should not be null");
/*  865 */       return;
/*      */     }
/*  867 */     if (paramString == null) {
/*  868 */       Log.w(x.a, "App package is null, will not set");
/*  869 */       return;
/*      */     }
/*  871 */     a.a(paramContext).c = paramString;
/*      */     
/*      */ 
/*  874 */     if ((paramContext = NativeCrashHandler.getInstance()) != null) {
/*  875 */       paramContext.setNativeAppPackage(paramString);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setCrashFilter(String paramString)
/*      */   {
/*  885 */     if (!com.tencent.bugly.b.a) {
/*  886 */       Log.w(x.a, "Can not set App package because bugly is disable.");
/*  887 */       return;
/*      */     }
/*  889 */     Log.w(x.a, "Set crash stack filter: " + paramString);
/*  890 */     c.m = paramString;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setCrashRegularFilter(String paramString)
/*      */   {
/*  899 */     if (!com.tencent.bugly.b.a) {
/*  900 */       Log.w(x.a, "Can not set App package because bugly is disable.");
/*  901 */       return;
/*      */     }
/*  903 */     Log.w(x.a, "Set crash stack filter: " + paramString);
/*  904 */     c.n = paramString;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setBuglyDbName(String paramString)
/*      */   {
/*  913 */     if (!com.tencent.bugly.b.a) {
/*  914 */       Log.w(x.a, "Can not set DB name because bugly is disable.");
/*  915 */       return;
/*      */     }
/*  917 */     Log.i(x.a, "Set Bugly DB name: " + paramString);
/*  918 */     com.tencent.bugly.proguard.q.a = paramString;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setAuditEnable(Context paramContext, boolean paramBoolean)
/*      */   {
/*  928 */     if (!com.tencent.bugly.b.a) {
/*  929 */       Log.w(x.a, "Can not set App package because bugly is disable.");
/*  930 */       return;
/*      */     }
/*  932 */     if (paramContext == null) {
/*  933 */       Log.w(x.a, "setAppPackage args context should not be null");
/*  934 */       return;
/*      */     }
/*  936 */     Log.i(x.a, "Set audit enable: " + paramBoolean);
/*  937 */     a.a(paramContext).B = paramBoolean;
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
/*      */   public static boolean setJavascriptMonitor(WebView paramWebView, boolean paramBoolean)
/*      */   {
/*  955 */     return setJavascriptMonitor(paramWebView, paramBoolean, false);
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
/*      */   @SuppressLint({"SetJavaScriptEnabled"})
/*      */   public static boolean setJavascriptMonitor(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2)
/*      */   {
/*  975 */     if (paramWebView == null) {
/*  976 */       Log.w(x.a, "WebView is null.");
/*  977 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1008 */     setJavascriptMonitor( = new WebViewInterface()
/*      */     {
/*      */       public final String getUrl()
/*      */       {
/*  982 */         return this.a.getUrl();
/*      */       }
/*      */       
/*      */ 
/*      */       public final void setJavaScriptEnabled(boolean paramAnonymousBoolean)
/*      */       {
/*  988 */         if (!(paramAnonymousBoolean = this.a.getSettings()).getJavaScriptEnabled()) {
/*  989 */           paramAnonymousBoolean.setJavaScriptEnabled(true);
/*      */         }
/*      */       }
/*      */       
/*      */       public final void loadUrl(String paramAnonymousString)
/*      */       {
/*  995 */         this.a.loadUrl(paramAnonymousString);
/*      */       }
/*      */       
/*      */       public final void addJavascriptInterface(H5JavaScriptInterface paramAnonymousH5JavaScriptInterface, String paramAnonymousString)
/*      */       {
/* 1000 */         this.a.addJavascriptInterface(paramAnonymousH5JavaScriptInterface, paramAnonymousString);
/*      */       }
/*      */       
/*      */       public final CharSequence getContentDescription()
/*      */       {
/* 1005 */         return this.a.getContentDescription();
/*      */       }
/*      */       
/* 1008 */     }, paramBoolean1, paramBoolean2);
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
/*      */   public static boolean setJavascriptMonitor(WebViewInterface paramWebViewInterface, boolean paramBoolean)
/*      */   {
/* 1026 */     return setJavascriptMonitor(paramWebViewInterface, paramBoolean, false);
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
/*      */   @SuppressLint({"SetJavaScriptEnabled"})
/*      */   public static boolean setJavascriptMonitor(WebViewInterface paramWebViewInterface, boolean paramBoolean1, boolean paramBoolean2)
/*      */   {
/* 1047 */     if (paramWebViewInterface == null) {
/* 1048 */       Log.w(x.a, "WebViewInterface is null.");
/* 1049 */       return false;
/*      */     }
/* 1051 */     if (!CrashModule.hasInitialized()) {
/* 1052 */       x.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
/*      */       
/* 1054 */       return false;
/*      */     }
/* 1056 */     x.a("Set Javascript exception monitor of webview.", new Object[0]);
/* 1057 */     if (!com.tencent.bugly.b.a) {
/* 1058 */       Log.w(x.a, "Can not set JavaScript monitor because bugly is disable.");
/* 1059 */       return false;
/*      */     }
/* 1061 */     x.c("URL of webview is %s", new Object[] { paramWebViewInterface.getUrl() });
/*      */     
/*      */ 
/*      */ 
/* 1065 */     if (!paramBoolean2)
/*      */     {
/* 1067 */       if ((paramBoolean2 = Build.VERSION.SDK_INT) < 19) {
/* 1068 */         x.e("This interface is only available for Android 4.4 or later.", new Object[0]);
/* 1069 */         return false;
/*      */       }
/*      */     }
/*      */     
/* 1073 */     x.a("Enable the javascript needed by webview monitor.", new Object[0]);
/* 1074 */     paramWebViewInterface.setJavaScriptEnabled(true);
/*      */     
/* 1076 */     if ((paramBoolean2 = H5JavaScriptInterface.getInstance(paramWebViewInterface)) != null) {
/* 1077 */       x.a("Add a secure javascript interface to the webview.", new Object[0]);
/* 1078 */       paramWebViewInterface.addJavascriptInterface(paramBoolean2, "exceptionUploader");
/*      */     }
/* 1080 */     if (paramBoolean1) {
/* 1081 */       x.a("Inject bugly.js(v%s) to the webview.", new Object[] { com.tencent.bugly.crashreport.crash.h5.b.b() });
/*      */       
/* 1083 */       if ((paramBoolean1 = com.tencent.bugly.crashreport.crash.h5.b.a()) == null) {
/* 1084 */         x.e("Failed to inject Bugly.js.", new Object[] { com.tencent.bugly.crashreport.crash.h5.b.b() });
/* 1085 */         return false;
/*      */       }
/* 1087 */       paramWebViewInterface.loadUrl("javascript:" + paramBoolean1);
/*      */     }
/* 1089 */     return true;
/*      */   }
/*      */   
/*      */   public static abstract interface WebViewInterface { public abstract String getUrl();
/*      */     
/*      */     public abstract void setJavaScriptEnabled(boolean paramBoolean);
/*      */     
/*      */     public abstract void loadUrl(String paramString);
/*      */     
/*      */     public abstract void addJavascriptInterface(H5JavaScriptInterface paramH5JavaScriptInterface, String paramString);
/*      */     
/*      */     public abstract CharSequence getContentDescription(); }
/*      */   
/*      */   public static class CrashHandleCallback extends BuglyStrategy.a
/*      */   {}
/*      */   
/*      */   public static class UserStrategy extends BuglyStrategy { private CrashReport.CrashHandleCallback a;
/*      */     
/*      */     public UserStrategy(Context paramContext) {}
/*      */     
/* 1109 */     public synchronized CrashReport.CrashHandleCallback getCrashHandleCallback() { return this.a; }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public synchronized void setCrashHandleCallback(CrashReport.CrashHandleCallback paramCrashHandleCallback)
/*      */     {
/* 1119 */       this.a = paramCrashHandleCallback;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/CrashReport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */