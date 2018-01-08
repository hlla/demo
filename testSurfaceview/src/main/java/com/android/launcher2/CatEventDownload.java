package com.android.launcher2;

import android.content.Intent;
import android.os.Parcelable;
import java.lang.reflect.Constructor;

public class CatEventDownload
{
  public static final int EVENT_IDLE_SCREEN_AVAILABLE = 5;
  public static final String STK_EVENT_ACTION = "android.intent.action.stk.event";
  private static Class sClass;
  private static Object sStaticInstace = null;
  private Object instance = null;
  
  static
  {
    sClass = null;
    try
    {
      sClass = Class.forName("com.android.internal.telephony.cat.CatEventDownload");
      return;
    }
    catch (Exception localException)
    {
      sClass = null;
    }
  }
  
  public CatEventDownload(int paramInt)
  {
    if (sClass != null) {}
    try
    {
      this.instance = sClass.getConstructor(new Class[] { Integer.TYPE }).newInstance(new Object[] { Integer.valueOf(5) });
      return;
    }
    catch (Exception localException) {}
  }
  
  public void putExtra(Intent paramIntent, String paramString)
  {
    if (this.instance != null) {
      paramIntent.putExtra(paramString, (Parcelable)this.instance);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CatEventDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */