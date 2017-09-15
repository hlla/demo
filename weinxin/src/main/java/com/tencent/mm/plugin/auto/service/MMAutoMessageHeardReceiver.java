package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mm.u.af;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public class MMAutoMessageHeardReceiver
  extends BroadcastReceiver
{
  public MMAutoMessageHeardReceiver()
  {
    GMTrace.i(5211808595968L, 38831);
    GMTrace.o(5211808595968L, 38831);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(5211942813696L, 38832);
    paramContext = r.i(paramIntent, "key_username");
    if (paramContext == null)
    {
      GMTrace.o(5211942813696L, 38832);
      return;
    }
    v.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", new Object[] { paramContext });
    ap.getNotification().cancelNotification(paramContext);
    ap.yY();
    c.wW().Rn(paramContext);
    GMTrace.o(5211942813696L, 38832);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/auto/service/MMAutoMessageHeardReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */