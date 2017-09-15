package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;
import java.lang.reflect.Field;

public class CookieSyncManager
{
  private static android.webkit.CookieSyncManager wQK;
  private static CookieSyncManager wQL;
  private static boolean wQM = false;
  
  private CookieSyncManager(Context paramContext)
  {
    ac localac = ac.ceR();
    if ((localac != null) && (localac.ceS()))
    {
      localac.ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[] { Context.class }, new Object[] { paramContext });
      wQM = true;
    }
  }
  
  public static CookieSyncManager createInstance(Context paramContext)
  {
    try
    {
      wQK = android.webkit.CookieSyncManager.createInstance(paramContext);
      if ((wQL == null) || (!wQM)) {
        wQL = new CookieSyncManager(paramContext.getApplicationContext());
      }
      paramContext = wQL;
      return paramContext;
    }
    finally {}
  }
  
  public static CookieSyncManager getInstance()
  {
    try
    {
      if (wQL == null) {
        throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
      }
    }
    finally {}
    CookieSyncManager localCookieSyncManager = wQL;
    return localCookieSyncManager;
  }
  
  public void startSync()
  {
    Object localObject = ac.ceR();
    if ((localObject != null) && (((ac)localObject).ceS()))
    {
      ((ac)localObject).ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
      return;
    }
    wQK.startSync();
    try
    {
      localObject = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
      ((Field)localObject).setAccessible(true);
      ((Thread)((Field)localObject).get(wQK)).setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopSync()
  {
    ac localac = ac.ceR();
    if ((localac != null) && (localac.ceS()))
    {
      localac.ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
      return;
    }
    wQK.stopSync();
  }
  
  public void sync()
  {
    ac localac = ac.ceR();
    if ((localac != null) && (localac.ceS()))
    {
      localac.ceT().wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
      return;
    }
    wQK.sync();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/CookieSyncManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */