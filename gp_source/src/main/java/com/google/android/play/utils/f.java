package com.google.android.play.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import com.google.android.play.utils.b.a;
import com.google.android.play.utils.b.j;

public final class f
{
  public static g a;
  
  public static int a(NetworkInfo paramNetworkInfo)
  {
    int j = 3;
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected()))
    {
      if (paramNetworkInfo.getType() != 1)
      {
        int i = j;
        if (paramNetworkInfo.getType() != 6)
        {
          if (paramNetworkInfo.getType() == 0) {
            i = j;
          }
        }
        else
        {
          switch (paramNetworkInfo.getSubtype())
          {
          default: 
            i = 5;
          case 13: 
            return i;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          case 12: 
          case 14: 
          case 15: 
            return 2;
          }
          return 1;
        }
        if (paramNetworkInfo.getType() != 9)
        {
          if (paramNetworkInfo.getType() != 7) {
            return 0;
          }
          return 7;
        }
        return 6;
      }
      return 4;
    }
    return 8;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    if (a == null)
    {
      PlayCommonLog.e("NetworkInfoCache instance is not set in NetworkInfoUtil", new Object[0]);
      return null;
    }
    return a.a(paramContext);
  }
  
  public static int b(Context paramContext)
  {
    if (!((Boolean)j.l.b()).booleanValue()) {
      return a(a(paramContext));
    }
    return ((Integer)j.q.b()).intValue();
  }
  
  @TargetApi(17)
  public static boolean c(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 17) {
      if (Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0) == 0) {}
    }
    while (Settings.Global.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0) != 0)
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */