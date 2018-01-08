package com.android.launcher2.guide;

import android.content.res.Configuration;
import android.os.Bundle;

public abstract interface GuiderLifecycleListener
{
  public abstract void dismissHelpDialog();
  
  public abstract void finish();
  
  public abstract void onActivityCreated(Bundle paramBundle);
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void showCompleteDialog();
  
  public abstract void showHelpDialog();
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/GuiderLifecycleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */