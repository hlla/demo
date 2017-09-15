package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.h;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class j
{
  public static void run()
  {
    GMTrace.i(495531851776L, 3692);
    int i = g.sV().getInt("EnableForgroundService", 0);
    ap.yY();
    int j = h.aw(c.uH(), 101);
    if ((b.bIk()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = d.sXk;
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = b.bIk();
      }
      if (f.fuN == 1) {
        bool2 = false;
      }
      aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", bool2).commit();
      v.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(d.sXk), Integer.valueOf(f.fuN) });
      GMTrace.o(495531851776L, 3692);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */