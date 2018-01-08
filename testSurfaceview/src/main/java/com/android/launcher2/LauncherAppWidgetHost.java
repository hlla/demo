package com.android.launcher2;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;

public class LauncherAppWidgetHost
  extends AppWidgetHost
{
  public LauncherAppWidgetHost(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected AppWidgetHostView onCreateView(Context paramContext, int paramInt, AppWidgetProviderInfo paramAppWidgetProviderInfo)
  {
    return new LauncherAppWidgetHostView(paramContext);
  }
  
  public void stopListening()
  {
    super.stopListening();
    clearViews();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/LauncherAppWidgetHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */