package com.tencent.mm.compatible.h;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.t;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class a
{
  private static int gSe;
  
  static
  {
    GMTrace.i(13777315561472L, 102649);
    gSe = 0;
    GMTrace.o(13777315561472L, 102649);
  }
  
  public static void aE(boolean paramBoolean)
  {
    GMTrace.i(13777181343744L, 102648);
    SharedPreferences localSharedPreferences = aa.bIO();
    boolean bool = localSharedPreferences.getBoolean("settings_support_swipe", true);
    if (bool != paramBoolean) {
      localSharedPreferences.edit().putBoolean("settings_support_swipe", paramBoolean).commit();
    }
    v.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    GMTrace.o(13777181343744L, 102648);
  }
  
  public static boolean rX()
  {
    GMTrace.i(13777047126016L, 102647);
    Object localObject;
    if ((bf.ap(Build.VERSION.INCREMENTAL, "").toLowerCase().contains("flyme")) || (bf.ap(Build.DISPLAY, "").toLowerCase().contains("flyme")))
    {
      i = 1;
      if (i == 0) {
        break label117;
      }
      localObject = p.gQX;
      if (!aa.bIR()) {
        ((t)localObject).gRr = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "system_config_prefs", 4).getInt("update_swip_back_status", 0);
      }
      if (((t)localObject).gRr != 1) {
        break label112;
      }
    }
    label112:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label117;
      }
      GMTrace.o(13777047126016L, 102647);
      return false;
      i = 0;
      break;
    }
    label117:
    if (gSe == 0)
    {
      localObject = aa.bIO();
      if ((localObject == null) || (!((SharedPreferences)localObject).getBoolean("settings_support_swipe", true))) {
        break label164;
      }
    }
    label164:
    for (gSe = 1; gSe == 1; gSe = 2)
    {
      GMTrace.o(13777047126016L, 102647);
      return true;
    }
    GMTrace.o(13777047126016L, 102647);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */