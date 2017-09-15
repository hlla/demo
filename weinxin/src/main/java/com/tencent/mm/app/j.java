package com.tencent.mm.app;

import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bn.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.h;

public final class j
{
  static j fwo;
  HandlerThread fwp;
  d fwq;
  ad handler;
  
  public j(String paramString)
  {
    GMTrace.i(12977914773504L, 96693);
    this.fwp = e.cE(paramString, 10);
    this.fwp.start();
    this.handler = new ad(this.fwp.getLooper());
    this.fwq = new h(c.c(this.handler), paramString);
    GMTrace.o(12977914773504L, 96693);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */