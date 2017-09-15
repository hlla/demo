package com.tencent.b.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import java.lang.reflect.Method;

public class p
{
  private static volatile p aQC = null;
  private boolean aQD = false;
  private Context context = null;
  
  private p(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    this.aQD = s.k(this.context, "android.permission.WRITE_SETTINGS");
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      paramContext = Settings.System.class.getDeclaredMethod("canWrite", new Class[] { Context.class });
      paramContext.setAccessible(true);
      this.aQD = ((Boolean)paramContext.invoke(null, new Object[] { this.context })).booleanValue();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static p S(Context paramContext)
  {
    if (aQC == null) {}
    try
    {
      if (aQC == null) {
        aQC = new p(paramContext);
      }
      return aQC;
    }
    finally {}
  }
  
  public final boolean n(String paramString1, String paramString2)
  {
    if (this.aQD) {
      try
      {
        boolean bool = Settings.System.putString(this.context.getContentResolver(), paramString1, paramString2);
        return bool;
      }
      catch (Exception paramString1) {}
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/b/a/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */