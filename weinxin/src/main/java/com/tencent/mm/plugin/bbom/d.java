package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.ContentResolver;
import android.content.IntentFilter;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;

public final class d
  implements com.tencent.mm.plugin.zero.a.a
{
  private AddrBookObserver jOd;
  private WatchDogPushReceiver jOe;
  private TrafficStatsReceiver jOf;
  
  public d()
  {
    GMTrace.i(8023133126656L, 59777);
    GMTrace.o(8023133126656L, 59777);
  }
  
  public final void a(Service paramService)
  {
    GMTrace.i(8023267344384L, 59778);
    this.jOd = new AddrBookObserver(paramService);
    paramService.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.a.bCd(), true, this.jOd);
    this.jOe = new WatchDogPushReceiver();
    paramService.registerReceiver(this.jOe, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
    this.jOf = new TrafficStatsReceiver();
    paramService.registerReceiver(this.jOf, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
    TrafficStatsReceiver.at(paramService);
    GMTrace.o(8023267344384L, 59778);
  }
  
  public final void b(Service paramService)
  {
    GMTrace.i(8023401562112L, 59779);
    paramService.getContentResolver().unregisterContentObserver(this.jOd);
    paramService.unregisterReceiver(this.jOe);
    paramService.unregisterReceiver(this.jOf);
    TrafficStatsReceiver.au(paramService);
    GMTrace.o(8023401562112L, 59779);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/bbom/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */