package com.android.launcher2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ChangeCallAppReceiver
  extends BroadcastReceiver
{
  public static final String CHANGE_TPHONE_MODE = "com.sec.android.favoriteapp.CHANGE_TPHONE_MODE";
  private static HomeView mHomeView;
  
  public void init(HomeView paramHomeView)
  {
    mHomeView = paramHomeView;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while (!"com.sec.android.favoriteapp.CHANGE_TPHONE_MODE".equals(paramIntent.getAction()));
      Log.i("ChangeCallAppReceiver", "broadcastReceived: com.sec.android.favoriteapp.CHANGE_TPHONE_MODE");
    } while (mHomeView == null);
    mHomeView.getModel().ChangeTphoneMode(mHomeView);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/ChangeCallAppReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */