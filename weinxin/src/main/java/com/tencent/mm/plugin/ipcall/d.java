package com.tencent.mm.plugin.ipcall;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class d
{
  public static boolean aDF()
  {
    GMTrace.i(11731568951296L, 87407);
    if (ap.zb())
    {
      if (com.tencent.mm.i.g.sV().getInt("WCOEntranceSwitch", 0) > 0)
      {
        ap.yY();
        c.vr().a(w.a.uAb, Boolean.valueOf(true));
        GMTrace.o(11731568951296L, 87407);
        return true;
      }
      ap.yY();
      c.vr().a(w.a.uAb, Boolean.valueOf(false));
      GMTrace.o(11731568951296L, 87407);
      return false;
    }
    GMTrace.o(11731568951296L, 87407);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ipcall/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */