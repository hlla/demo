package com.tencent.tinker.loader.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;

public abstract class ApplicationLike
  implements ApplicationLifeCycle
{
  private final Application application;
  private final long applicationStartElapsedTime;
  private final long applicationStartMillisTime;
  private final int tinkerFlags;
  private final boolean tinkerLoadVerifyFlag;
  private final Intent tinkerResultIntent;
  
  public ApplicationLike(Application paramApplication, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, Intent paramIntent)
  {
    this.application = paramApplication;
    this.tinkerFlags = paramInt;
    this.tinkerLoadVerifyFlag = paramBoolean;
    this.applicationStartElapsedTime = paramLong1;
    this.applicationStartMillisTime = paramLong2;
    this.tinkerResultIntent = paramIntent;
  }
  
  public Application getApplication()
  {
    return this.application;
  }
  
  public long getApplicationStartElapsedTime()
  {
    return this.applicationStartElapsedTime;
  }
  
  public long getApplicationStartMillisTime()
  {
    return this.applicationStartMillisTime;
  }
  
  public AssetManager getAssets(AssetManager paramAssetManager)
  {
    return paramAssetManager;
  }
  
  public Context getBaseContext(Context paramContext)
  {
    return paramContext;
  }
  
  public ClassLoader getClassLoader(ClassLoader paramClassLoader)
  {
    return paramClassLoader;
  }
  
  public Resources getResources(Resources paramResources)
  {
    return paramResources;
  }
  
  public Object getSystemService(String paramString, Object paramObject)
  {
    return paramObject;
  }
  
  public final int getTinkerFlags()
  {
    return this.tinkerFlags;
  }
  
  public final boolean getTinkerLoadVerifyFlag()
  {
    return this.tinkerLoadVerifyFlag;
  }
  
  public final Intent getTinkerResultIntent()
  {
    return this.tinkerResultIntent;
  }
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public void onLowMemory() {}
  
  public void onTerminate() {}
  
  public void onTrimMemory(int paramInt) {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/app/ApplicationLike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */