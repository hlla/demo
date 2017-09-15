package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

final class f
{
  private static long uph;
  private static long upi;
  ai fyz;
  private boolean gUE;
  boolean lEf;
  public long upj;
  public long upk;
  private String upl;
  private j upm;
  
  static
  {
    GMTrace.i(3564554420224L, 26558);
    uph = 125829120L;
    upi = 314572800L;
    GMTrace.o(3564554420224L, 26558);
  }
  
  public f(j paramj)
  {
    GMTrace.i(3563212242944L, 26548);
    this.fyz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(3580257894400L, 26675);
        f.this.jK(true);
        GMTrace.o(3580257894400L, 26675);
        return true;
      }
    }, true);
    this.upj = 0L;
    this.upk = 0L;
    this.upl = null;
    this.gUE = false;
    this.lEf = false;
    this.upm = paramj;
    GMTrace.o(3563212242944L, 26548);
  }
  
  public static boolean OW(String paramString)
  {
    GMTrace.i(3563749113856L, 26552);
    if (i.OY(paramString) > uph)
    {
      v.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
      GMTrace.o(3563749113856L, 26552);
      return true;
    }
    GMTrace.o(3563749113856L, 26552);
    return false;
  }
  
  public final void cy(String paramString, int paramInt)
  {
    GMTrace.i(3563346460672L, 26549);
    if (bf.mA(paramString))
    {
      GMTrace.o(3563346460672L, 26549);
      return;
    }
    if (!paramString.equals(this.upl)) {
      stop();
    }
    v.i("MicroMsg.TrafficStatistic", "pack size: " + paramInt);
    v.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[] { Long.valueOf(uph) });
    uph = Math.max(paramInt * 4, uph);
    uph = Math.min(upi, uph);
    v.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[] { Long.valueOf(uph) });
    if (!this.gUE)
    {
      if (this.upm.mContext != null) {
        this.lEf = al.isWifi(this.upm.mContext);
      }
      this.fyz.v(30000L, 30000L);
      this.gUE = true;
      this.upl = paramString;
    }
    GMTrace.o(3563346460672L, 26549);
  }
  
  public final void jK(boolean paramBoolean)
  {
    long l = 0L;
    GMTrace.i(3563614896128L, 26551);
    if ((paramBoolean) || (this.upj + this.upk >= 524288L))
    {
      if (this.upj + this.upk > 0L)
      {
        Intent localIntent = new Intent();
        localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        localIntent.putExtra("intent_extra_flow_stat_upstream", this.upj);
        localIntent.putExtra("intent_extra_flow_stat_downstream", this.upk);
        if (this.upm.mContext != null) {
          this.lEf = al.isWifi(this.upm.mContext);
        }
        localIntent.putExtra("intent_extra_flow_stat_is_wifi", this.lEf);
        if (this.upm.mContext != null) {
          this.upm.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        }
      }
      if (!bf.mA(this.upl)) {
        break label206;
      }
      v.e("MicroMsg.TrafficStatistic", "traffic is null!");
    }
    for (;;)
    {
      if ((l >= uph) && (this.upm.qtT == 2))
      {
        v.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
        this.upm.cancel();
      }
      GMTrace.o(3563614896128L, 26551);
      return;
      label206:
      l = i.l(this.upl, this.upj, this.upk);
      this.upj = 0L;
      this.upk = 0L;
    }
  }
  
  public final void stop()
  {
    GMTrace.i(3563480678400L, 26550);
    jK(true);
    this.fyz.KI();
    this.gUE = false;
    GMTrace.o(3563480678400L, 26550);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/updater/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */