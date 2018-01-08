package com.android.launcher2;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;

public class AppWidgetBinder
{
  private static final int REQUEST_APPWIDGET_BIND = 100;
  private static final String TAG = "AppWidgetBinder";
  private LauncherAppWidgetHost mHost;
  private Launcher mLauncher;
  private AppWidgetManager mManager;
  
  public AppWidgetBinder(Launcher paramLauncher, AppWidgetManager paramAppWidgetManager, LauncherAppWidgetHost paramLauncherAppWidgetHost)
  {
    this.mLauncher = paramLauncher;
    this.mManager = paramAppWidgetManager;
    this.mHost = paramLauncherAppWidgetHost;
  }
  
  private void onBindFailed(Callback paramCallback, int paramInt)
  {
    if (paramCallback != null) {
      paramCallback.onBindFail();
    }
    this.mHost.deleteAppWidgetId(paramInt);
  }
  
  private void onBindSuccessful(Callback paramCallback, int paramInt)
  {
    if (paramCallback != null) {
      paramCallback.onBindSuccess(paramInt);
    }
  }
  
  public void allocateBindNew(ComponentName paramComponentName, final Callback paramCallback)
  {
    final int i = this.mHost.allocateAppWidgetId();
    if (this.mManager.bindAppWidgetIdIfAllowed(i, paramComponentName))
    {
      onBindSuccessful(paramCallback, i);
      return;
    }
    Intent localIntent = new Intent("android.appwidget.action.APPWIDGET_BIND");
    localIntent.putExtra("appWidgetId", i);
    localIntent.putExtra("appWidgetProvider", paramComponentName);
    if (this.mLauncher != null)
    {
      this.mLauncher.startActivityForResult(localIntent, 100, new Launcher.ActivityResultCallback()
      {
        public void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          if (paramAnonymousInt1 == 100)
          {
            if (paramAnonymousInt2 == -1)
            {
              AppWidgetBinder.this.onBindSuccessful(paramCallback, i);
              return;
            }
            AppWidgetBinder.this.onBindFailed(paramCallback, i);
            return;
          }
          throw new IllegalArgumentException("AppWidgetBinder.allocateBindNew: invalid requestCode");
        }
      });
      return;
    }
    Log.d("AppWidgetBinder", "AppWidgetBinder.allocateBindNew: launcher == null");
  }
  
  public static abstract interface Callback
  {
    public abstract void onBindFail();
    
    public abstract void onBindSuccess(int paramInt);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AppWidgetBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */