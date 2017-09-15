package com.google.android.gms.c;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.regex.Pattern;

public final class t
{
  private static Pattern aAl = null;
  
  public static boolean J(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
  }
  
  public static int ca(int paramInt)
  {
    return paramInt / 1000;
  }
  
  public static boolean cb(int paramInt)
  {
    return paramInt % 1000 / 100 == 3;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */