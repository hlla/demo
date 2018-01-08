package com.android.launcher2;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

public class WidgetCreationService
  extends IntentService
{
  public static final String DASHWIRE_ACTION_NAME = "com.dashwire.config.launcher.CONFIGURE_HOMESCREEN_RESULT";
  public static final String DASHWIRE_PERMISSION = "com.dashwire.config.launcher.SEND_HOMESCREEN_RESULT";
  public static final String FAVORITES = "Favorites";
  public static final String LAUNCHER_PACKAGE_NAME = "com.sec.android.app.launcher";
  public static final String SUCCESS = "success";
  
  public WidgetCreationService()
  {
    super("WidgetCreationService");
  }
  
  public WidgetCreationService(String paramString)
  {
    super(paramString);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  protected void onHandleIntent(Intent paramIntent) {}
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/WidgetCreationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */