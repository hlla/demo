package com.tencent.mm.ap;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.n;

public final class c
  implements com.tencent.mm.y.e
{
  private static c hNA;
  private int hNz;
  private boolean hpu;
  
  public c()
  {
    GMTrace.i(12937112584192L, 96389);
    this.hpu = false;
    this.hNz = 3;
    GMTrace.o(12937112584192L, 96389);
  }
  
  public static c HW()
  {
    GMTrace.i(12937246801920L, 96390);
    if (hNA == null) {
      hNA = new c();
    }
    c localc = hNA;
    GMTrace.o(12937246801920L, 96390);
    return localc;
  }
  
  private void release()
  {
    GMTrace.i(12937515237376L, 96392);
    this.hpu = false;
    h.vH().gXs.b(159, this);
    GMTrace.o(12937515237376L, 96392);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(12937649455104L, 96393);
    if (paramk.getType() == 159)
    {
      v.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label82;
      }
      h.vI().vr().set(81938, Long.valueOf(bf.Nz()));
    }
    for (;;)
    {
      release();
      GMTrace.o(12937649455104L, 96393);
      return;
      label82:
      paramInt1 = this.hNz - 1;
      this.hNz = paramInt1;
      if (paramInt1 < 0)
      {
        h.vI().vr().set(81938, Long.valueOf((bf.NA() - 86400000L + 3600000L) / 1000L));
        this.hNz = 3;
      }
    }
  }
  
  public final void update()
  {
    GMTrace.i(12937381019648L, 96391);
    v.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.hpu);
    v.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + h.vI().isSDCardAvailable());
    if ((!this.hpu) && (h.vI().isSDCardAvailable()))
    {
      release();
      this.hpu = true;
      h.vH().gXs.a(159, this);
      k localk = new k(7);
      h.vH().gXs.a(localk, 0);
    }
    GMTrace.o(12937381019648L, 96391);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */