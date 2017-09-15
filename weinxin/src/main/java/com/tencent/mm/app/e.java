package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;

public final class e
{
  public static int ae(Context paramContext)
  {
    GMTrace.i(14014209851392L, 104414);
    if (paramContext == null)
    {
      GMTrace.o(14014209851392L, 104414);
      return 0;
    }
    try
    {
      int i = paramContext.getSharedPreferences("crash_status_file", 4).getInt("channel", -1);
      GMTrace.o(14014209851392L, 104414);
      return i;
    }
    catch (Throwable paramContext)
    {
      GMTrace.o(14014209851392L, 104414);
    }
    return 0;
  }
  
  public static int af(Context paramContext)
  {
    GMTrace.i(14014344069120L, 104415);
    if (paramContext == null)
    {
      GMTrace.o(14014344069120L, 104415);
      return 0;
    }
    try
    {
      int i = paramContext.getSharedPreferences("crash_status_file", 4).getInt("googleplaysizelimit", 1024);
      GMTrace.o(14014344069120L, 104415);
      return i;
    }
    catch (Throwable paramContext)
    {
      GMTrace.o(14014344069120L, 104415);
    }
    return 0;
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(14014478286848L, 104416);
    try
    {
      Object localObject = paramContext.getSharedPreferences("crash_status_file", 4);
      paramContext = ((SharedPreferences)localObject).getString("crashlist", "");
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("crashlist", paramContext + ";" + paramString1 + "," + paramString2);
      ((SharedPreferences.Editor)localObject).commit();
      GMTrace.o(14014478286848L, 104416);
      return;
    }
    catch (Throwable paramContext)
    {
      GMTrace.o(14014478286848L, 104416);
    }
  }
  
  public static abstract interface a
  {
    public abstract void cS(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */