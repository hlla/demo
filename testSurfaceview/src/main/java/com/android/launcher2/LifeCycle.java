package com.android.launcher2;

public abstract interface LifeCycle
{
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void onStop();
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/LifeCycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */