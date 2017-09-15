package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class k
{
  public static boolean aK(Context paramContext)
  {
    GMTrace.i(13499082211328L, 100576);
    if (paramContext == null)
    {
      v.e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
      GMTrace.o(13499082211328L, 100576);
      return false;
    }
    boolean bool = paramContext.getSharedPreferences("system_config_prefs", 4).getBoolean("settings_fully_exit", true);
    GMTrace.o(13499082211328L, 100576);
    return bool;
  }
  
  public static boolean aL(Context paramContext)
  {
    GMTrace.i(13499350646784L, 100578);
    if (paramContext == null)
    {
      v.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
      GMTrace.o(13499350646784L, 100578);
      return false;
    }
    boolean bool = paramContext.getSharedPreferences("system_config_prefs_showdown", 4).getBoolean("shut_down_weixin", false);
    GMTrace.o(13499350646784L, 100578);
    return bool;
  }
  
  public static void e(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(13498947993600L, 100575);
    if (paramContext == null)
    {
      v.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
      GMTrace.o(13498947993600L, 100575);
      return;
    }
    paramContext.getSharedPreferences("system_config_prefs", 4).edit().putBoolean("settings_fully_exit", paramBoolean).commit();
    v.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to " + paramBoolean);
    GMTrace.o(13498947993600L, 100575);
  }
  
  public static void f(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(13499216429056L, 100577);
    if (paramContext == null)
    {
      v.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
      GMTrace.o(13499216429056L, 100577);
      return;
    }
    paramContext.getSharedPreferences("system_config_prefs_showdown", 4).edit().putBoolean("shut_down_weixin", paramBoolean).commit();
    v.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to " + paramBoolean);
    GMTrace.o(13499216429056L, 100577);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kernel/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */