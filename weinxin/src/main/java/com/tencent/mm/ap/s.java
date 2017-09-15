package com.tencent.mm.ap;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class s
  implements com.tencent.mm.y.e
{
  private static s hNZ;
  private int hNz;
  private boolean hpu;
  
  public s()
  {
    GMTrace.i(12944494559232L, 96444);
    this.hpu = false;
    this.hNz = 3;
    GMTrace.o(12944494559232L, 96444);
  }
  
  private static void HX()
  {
    GMTrace.i(12945165647872L, 96449);
    h.vI().vr().set(81937, Long.valueOf(bf.Nz()));
    GMTrace.o(12945165647872L, 96449);
  }
  
  public static s Ib()
  {
    GMTrace.i(12944628776960L, 96445);
    if (hNZ == null) {
      hNZ = new s();
    }
    s locals = hNZ;
    GMTrace.o(12944628776960L, 96445);
    return locals;
  }
  
  private void release()
  {
    GMTrace.i(12944897212416L, 96447);
    this.hpu = false;
    h.vH().gXs.b(159, this);
    h.vH().gXs.b(160, this);
    GMTrace.o(12944897212416L, 96447);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(12945031430144L, 96448);
    if ((!(paramk instanceof com.tencent.mm.y.m)) || (((com.tencent.mm.y.m)paramk).BQ() != 8))
    {
      v.d("MicroMsg.RegionCodeUpdater", "another scene");
      GMTrace.o(12945031430144L, 96448);
      return;
    }
    int i = paramk.getType();
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        HX();
        paramString = t.Id().gl(8);
        if ((paramString == null) || (paramString.length == 0))
        {
          v.i("MicroMsg.RegionCodeUpdater", "error no pkg found.");
          release();
          GMTrace.o(12945031430144L, 96448);
          return;
        }
        paramString = paramString[0];
        v.i("MicroMsg.RegionCodeUpdater", "dkregcode Pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.fKC);
        if (5 != paramString.status)
        {
          release();
          GMTrace.o(12945031430144L, 96448);
          return;
        }
        paramString = new j(paramString.id, 8);
        h.vH().gXs.a(paramString, 0);
        GMTrace.o(12945031430144L, 96448);
        return;
      }
      paramInt1 = this.hNz - 1;
      this.hNz = paramInt1;
      if (paramInt1 <= 0)
      {
        h.vI().vr().set(81937, Long.valueOf((bf.NA() - 604800000L + 3600000L) / 1000L));
        this.hNz = 3;
      }
      release();
      GMTrace.o(12945031430144L, 96448);
      return;
    }
    if (i == 160)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        HX();
      }
      release();
    }
    GMTrace.o(12945031430144L, 96448);
  }
  
  public final void update()
  {
    GMTrace.i(12944762994688L, 96446);
    if ((!this.hpu) && (h.vI().isSDCardAvailable()))
    {
      release();
      this.hpu = true;
      h.vH().gXs.a(159, this);
      h.vH().gXs.a(160, this);
      k localk = new k(8);
      h.vH().gXs.a(localk, 0);
    }
    GMTrace.o(12944762994688L, 96446);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */