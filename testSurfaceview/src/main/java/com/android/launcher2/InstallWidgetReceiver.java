package com.android.launcher2;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class InstallWidgetReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_INSTALL_WIDGET = "com.android.launcher.action.INSTALL_WIDGET";
  public static final String ACTION_SUPPORTS_CLIPDATA_MIMETYPE = "com.android.launcher.action.SUPPORTS_CLIPDATA_MIMETYPE";
  public static final String EXTRA_APPWIDGET_COMPONENT = "com.android.launcher.extra.widget.COMPONENT";
  public static final String EXTRA_APPWIDGET_CONFIGURATION_DATA = "com.android.launcher.extra.widget.CONFIGURATION_DATA";
  public static final String EXTRA_APPWIDGET_CONFIGURATION_DATA_MIME_TYPE = "com.android.launcher.extra.widget.CONFIGURATION_DATA_MIME_TYPE";
  public static final String LAUNCHER_ACTION_INSTALL_WIDGET = "com.sec.launcher.action.INSTALL_WIDGET";
  public static final String LAUNCHER_EXTRA_APPWIDGET_COMPONENT = "com.sec.launcher.intent.extra.COMPONENT";
  public static final String LAUNCHER_EXTRA_APPWIDGET_DUPALLOWED = "com.sec.launcher.intent.extra.DUPLICATE";
  public static final String LAUNCHER_EXTRA_APPWIDGET_SIZEX = "com.sec.launcher.intent.extra.sizeX";
  public static final String LAUNCHER_EXTRA_APPWIDGET_SIZEY = "com.sec.launcher.intent.extra.sizeY";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramContext.getSharedPreferences("ExtraStuff", 0).getBoolean("replace", false)) {
      replaceDummyWidget(paramContext, paramIntent.getStringExtra("package"), paramIntent.getStringExtra("class"), paramIntent.getIntExtra("spanX", 3), paramIntent.getIntExtra("spanY", 3), paramIntent.getIntExtra("cellX", 0), paramIntent.getIntExtra("cellY", 0), paramIntent.getIntExtra("screen", 6));
    }
  }
  
  public void replaceDummyWidget(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = new LauncherAppWidgetHost(paramContext, 1024).allocateAppWidgetId();
    paramString1 = new ComponentName(paramString1, paramString2);
    AppWidgetManager.getInstance(paramContext).bindAppWidgetIdIfAllowed(i, paramString1);
    paramString1 = new HomeWidgetItem(paramString1, i);
    paramString1.mScreen = paramInt5;
    paramString1.cellX = paramInt3;
    paramString1.cellY = paramInt4;
    paramString1.spanX = paramInt1;
    paramString1.spanY = paramInt2;
    if (paramString1.appWidgetId == -1) {
      return;
    }
    LauncherModel.addItemToDatabase(paramContext, paramString1, -100L, paramString1.mScreen, paramString1.cellX, paramString1.cellY, false);
    paramContext = (LauncherApplication)paramContext.getApplicationContext();
    paramContext.getModel().setRefreshRequired(true);
    paramContext.getModel().startLoaderFromBackground(true);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/InstallWidgetReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */