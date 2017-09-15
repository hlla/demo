package com.tencent.recovery;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.recovery.config.Express;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import com.tencent.recovery.handler.RecoveryMessageHandler;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.service.RecoveryReportService;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;

public class Recovery
{
  private static Application application;
  public static Context context;
  public static RecoveryMessageHandler wNN;
  public static long wNO;
  private static CommonOptions wNP;
  public static String wNQ;
  private static boolean wNR = false;
  public static boolean wNS = false;
  public static int wNT = 0;
  private static Application.ActivityLifecycleCallbacks wNU = new Application.ActivityLifecycleCallbacks()
  {
    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
    {
      if (Recovery.wNS) {}
      while (Recovery.wNN.hasMessages(3)) {
        return;
      }
      Recovery.wNN.removeCallbacksAndMessages(null);
      paramAnonymousActivity = Util.ft(Recovery.context);
      paramAnonymousBundle = Recovery.context.getSharedPreferences(Recovery.wNQ, 0).edit();
      paramAnonymousBundle.putInt("KeyComponentOnCreateForeground", 1);
      paramAnonymousBundle.putInt("KeyComponentOnCreateExceptionType", 4096);
      paramAnonymousBundle.apply();
      paramAnonymousBundle = OptionFactory.dh(paramAnonymousActivity, 1);
      Recovery.wNN.sendEmptyMessageDelayed(3, paramAnonymousBundle.jaz);
      RecoveryLog.i("Recovery", "%s markActivityOnCreated %s", new Object[] { paramAnonymousActivity, Long.valueOf(System.currentTimeMillis() - Recovery.wNO) });
    }
    
    public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
    
    public final void onActivityPaused(Activity paramAnonymousActivity) {}
    
    public final void onActivityResumed(Activity paramAnonymousActivity) {}
    
    public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
    
    public final void onActivityStarted(Activity paramAnonymousActivity)
    {
      Recovery.wNT += 1;
    }
    
    public final void onActivityStopped(Activity paramAnonymousActivity)
    {
      int i = Recovery.wNT - 1;
      Recovery.wNT = i;
      if (i == 0)
      {
        RecoveryLog.i("Recovery", "%s onActivityStopped: activityForegroundCount is 0", new Object[] { Util.ft(Recovery.context) });
        Recovery.CJ(16);
      }
    }
  };
  
  public static void CJ(int paramInt)
  {
    if (context == null) {}
    while (wNS) {
      return;
    }
    cdl();
    Object localObject = Util.ft(context);
    SharedPreferences localSharedPreferences = context.getSharedPreferences(wNQ, 0);
    RecoveryLog.i("Recovery", "%s Recovery.normal %s %d", new Object[] { localObject, Integer.toHexString(paramInt), Long.valueOf(System.currentTimeMillis() - wNO) });
    wNN.removeCallbacksAndMessages(null);
    localObject = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).remove("KeyComponentOnCreateExceptionType");
    ((SharedPreferences.Editor)localObject).putInt("KeyComponentOnCreateNormalType", paramInt);
    ((SharedPreferences.Editor)localObject).apply();
    destroy();
  }
  
  public static void a(Application paramApplication, Context paramContext)
  {
    application = paramApplication;
    context = paramContext;
    wNP = OptionFactory.fq(paramContext);
    if (application != null) {
      application.registerActivityLifecycleCallbacks(wNU);
    }
    String str = Util.ft(paramContext);
    if (RecoveryLogic.fp(paramContext))
    {
      if (wNP.wOq) {
        RecoveryLog.If();
      }
      RecoveryLog.a(new RecoveryFileLog(context));
      cdl();
      RecoveryLog.i("Recovery", "recovery process, no need to do any thing", new Object[0]);
      return;
    }
    RecoveryLog.i("Recovery", "%s attachBaseContext start ============================== %d", new Object[] { str, Long.valueOf(System.currentTimeMillis() - wNO) });
    wNQ = "recovery-" + str;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(wNQ, 0);
    Object localObject2 = localSharedPreferences.getString("KeyRecoveryVersion", "");
    Object localObject1 = localSharedPreferences.edit();
    paramApplication = (Application)localObject1;
    if (!((String)localObject2).equals(wNP.clientVersion))
    {
      ((SharedPreferences.Editor)localObject1).clear();
      ((SharedPreferences.Editor)localObject1).putString("KeyRecoveryVersion", wNP.clientVersion);
      ((SharedPreferences.Editor)localObject1).apply();
      RecoveryLog.i("Recovery", "recovery sp version not equal lastVersion %s currentVersion %s", new Object[] { localObject2, wNP.clientVersion });
      paramApplication = localSharedPreferences.edit();
    }
    localObject1 = new RecoveryContext();
    ((RecoveryContext)localObject1).f(localSharedPreferences);
    localObject2 = new RecoveryStatusItem();
    ((RecoveryStatusItem)localObject2).processName = str;
    ((RecoveryStatusItem)localObject2).clientVersion = wNP.clientVersion;
    ((RecoveryStatusItem)localObject2).mpX = wNP.mpX;
    ((RecoveryStatusItem)localObject2).timestamp = System.currentTimeMillis();
    int i;
    if (localSharedPreferences.contains("KeyAppOnCreateExceptionType"))
    {
      RecoveryLog.i("Recovery", "contains KeyAppOnCreateExceptionType", new Object[0]);
      ((RecoveryStatusItem)localObject2).wNX = localSharedPreferences.getInt("KeyAppOnCreateForeground", 17);
      ((RecoveryStatusItem)localObject2).wOa = localSharedPreferences.getInt("KeyAppOnCreateExceptionType", 4096);
      ((RecoveryStatusItem)localObject2).wNZ = 1;
      switch (((RecoveryStatusItem)localObject2).wOa)
      {
      default: 
        i = 0;
        label402:
        if (i != 0)
        {
          if (((RecoveryContext)localObject1).wNV.size() > 15) {
            ((RecoveryContext)localObject1).wNV.remove(0);
          }
          ((RecoveryContext)localObject1).wNV.add(localObject2);
          RecoveryLogic.a(paramContext, (RecoveryStatusItem)localObject2, RecoveryReportService.class.getName());
        }
        paramApplication.remove("KeyAppOnCreateForeground");
        paramApplication.remove("KeyAppOnCreateExceptionType");
        paramApplication.remove("KeyAppOnCreateNormalType");
        paramApplication.remove("KeyComponentOnCreateForeground");
        paramApplication.remove("KeyComponentOnCreateExceptionType");
        paramApplication.remove("KeyComponentOnCreateNormalType");
        i = RecoveryLogic.bp(paramContext, str);
        RecoveryLog.i("Recovery", "processStartFlag %s %s", new Object[] { str, Integer.toHexString(i) });
        if (OptionFactory.dh(str, i).wOu.cY(((RecoveryContext)localObject1).wNV))
        {
          RecoveryLogic.a(paramContext, wNP, (RecoveryContext)localObject1);
          ((RecoveryContext)localObject1).clear();
          cdl();
        }
        break;
      }
    }
    for (;;)
    {
      ((RecoveryContext)localObject1).a(paramApplication);
      paramApplication.apply();
      RecoveryLog.i("Recovery", "%s attachBaseContext end ============================== %d", new Object[] { str, Long.valueOf(System.currentTimeMillis() - wNO) });
      return;
      if (localSharedPreferences.contains("KeyComponentOnCreateExceptionType"))
      {
        RecoveryLog.i("Recovery", "contains KeyComponentOnCreateExceptionType", new Object[0]);
        ((RecoveryStatusItem)localObject2).wNX = localSharedPreferences.getInt("KeyAppOnCreateForeground", 17);
        ((RecoveryStatusItem)localObject2).wOa = localSharedPreferences.getInt("KeyComponentOnCreateExceptionType", 4096);
        ((RecoveryStatusItem)localObject2).wNZ = 16;
        break;
      }
      ((RecoveryContext)localObject1).clear();
      if (localSharedPreferences.contains("KeyAppOnCreateNormalType"))
      {
        if (localSharedPreferences.contains("KeyComponentOnCreateNormalType"))
        {
          RecoveryLog.i("Recovery", "contains KeyComponentOnCreateNormalType", new Object[0]);
          ((RecoveryStatusItem)localObject2).wNX = localSharedPreferences.getInt("KeyAppOnCreateForeground", 17);
          ((RecoveryStatusItem)localObject2).wOa = localSharedPreferences.getInt("KeyComponentOnCreateNormalType", 273);
          ((RecoveryStatusItem)localObject2).wNZ = 16;
          break;
        }
        RecoveryLog.i("Recovery", "contains KeyAppOnCreateNormalType", new Object[0]);
        ((RecoveryStatusItem)localObject2).wNX = localSharedPreferences.getInt("KeyAppOnCreateForeground", 17);
        ((RecoveryStatusItem)localObject2).wOa = localSharedPreferences.getInt("KeyAppOnCreateNormalType", 273);
        ((RecoveryStatusItem)localObject2).wNZ = 1;
        break;
      }
      RecoveryLog.i("Recovery", "DefaultNormal", new Object[0]);
      ((RecoveryStatusItem)localObject2).wNX = 17;
      ((RecoveryStatusItem)localObject2).wOa = 273;
      ((RecoveryStatusItem)localObject2).wNZ = 1;
      break;
      i = 1;
      break label402;
      paramApplication.putInt("KeyAppOnCreateForeground", i);
      paramApplication.putInt("KeyComponentOnCreateForeground", i);
      paramApplication.putInt("KeyAppOnCreateExceptionType", 4096);
    }
  }
  
  public static void cdi()
  {
    if (wNS) {}
    while (wNR) {
      return;
    }
    wNR = true;
    Object localObject = Util.ft(context);
    int i = RecoveryLogic.bp(context, (String)localObject);
    RecoveryLog.i("Recovery", "%s markApplicationOnCreateNormal %d", new Object[] { localObject, Long.valueOf(System.currentTimeMillis() - wNO) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(wNQ, 0).edit();
    localEditor.remove("KeyAppOnCreateExceptionType");
    localEditor.putInt("KeyAppOnCreateNormalType", 256);
    if (RecoveryLogic.bp(context, (String)localObject) == 16)
    {
      localEditor.putInt("KeyComponentOnCreateForeground", i);
      localEditor.putInt("KeyComponentOnCreateExceptionType", 4096);
      localObject = OptionFactory.dh((String)localObject, i);
      wNN.sendEmptyMessageDelayed(2, ((ProcessOptions)localObject).jaz);
    }
    localEditor.apply();
  }
  
  public static void cdj()
  {
    if (context == null) {}
    while (wNS) {
      return;
    }
    cdl();
    RecoveryLog.i("Recovery", "%s Recovery.crash %d", new Object[] { Util.ft(context), Long.valueOf(System.currentTimeMillis() - wNO) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(wNQ, 0).edit();
    if (wNR) {
      localEditor.putInt("KeyComponentOnCreateExceptionType", 65536);
    }
    for (;;)
    {
      localEditor.apply();
      destroy();
      return;
      localEditor.putInt("KeyAppOnCreateExceptionType", 65536);
    }
  }
  
  public static void cdk()
  {
    if (context == null) {}
    while (wNS) {
      return;
    }
    cdl();
    RecoveryLog.i("Recovery", "%s Recovery.anr %d", new Object[] { Util.ft(context), Long.valueOf(System.currentTimeMillis() - wNO) });
    SharedPreferences.Editor localEditor = context.getSharedPreferences(wNQ, 0).edit();
    if (wNR) {
      localEditor.putInt("KeyComponentOnCreateExceptionType", 1048576);
    }
    for (;;)
    {
      localEditor.apply();
      destroy();
      return;
      localEditor.putInt("KeyAppOnCreateExceptionType", 1048576);
    }
  }
  
  private static void cdl()
  {
    if (context == null) {}
    while (wNS) {
      return;
    }
    RecoveryLog.i("Recovery", "%s markFinalStatus", new Object[] { Util.ft(context) });
    wNS = true;
  }
  
  private static void destroy()
  {
    if (application != null) {
      application.unregisterActivityLifecycleCallbacks(wNU);
    }
  }
  
  public static void eF()
  {
    RecoveryLog.i("Recovery", "initStatic Run", new Object[0]);
    Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()));
    try
    {
      System.loadLibrary("recovery");
      wNO = System.currentTimeMillis();
      wNN = new RecoveryMessageHandler();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        RecoveryLog.printErrStackTrace("Recovery", localException, "load recovery library", new Object[0]);
      }
    }
  }
  
  public static Context getContext()
  {
    return context;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/Recovery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */