package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class m
{
  private static final Object aqT = new Object();
  private static m aqU;
  
  public static m B(Context paramContext)
  {
    synchronized (aqT)
    {
      if (aqU == null) {
        aqU = new n(paramContext.getApplicationContext());
      }
      return aqU;
    }
  }
  
  public abstract boolean a(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract boolean a(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3);
  
  public abstract void b(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract void b(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */