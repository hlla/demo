package com.tencent.mm.permission;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ap.j;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;

public final class a
  implements e
{
  private static a igQ;
  private boolean igR;
  private int igS;
  
  public a()
  {
    GMTrace.i(3494895419392L, 26039);
    this.igR = false;
    this.igS = 3;
    GMTrace.o(3494895419392L, 26039);
  }
  
  private static void HX()
  {
    GMTrace.i(3495566508032L, 26044);
    if (!ap.zb())
    {
      GMTrace.o(3495566508032L, 26044);
      return;
    }
    ap.yY();
    c.vr().set(327944, Long.valueOf(bf.NA()));
    GMTrace.o(3495566508032L, 26044);
  }
  
  public static a Ni()
  {
    GMTrace.i(3495029637120L, 26040);
    if (igQ == null) {
      igQ = new a();
    }
    a locala = igQ;
    GMTrace.o(3495029637120L, 26040);
    return locala;
  }
  
  private void release()
  {
    GMTrace.i(3495298072576L, 26042);
    this.igR = false;
    ap.vd().b(159, this);
    ap.vd().b(160, this);
    GMTrace.o(3495298072576L, 26042);
  }
  
  public final void Nj()
  {
    GMTrace.i(3495163854848L, 26041);
    if (!ap.zb())
    {
      GMTrace.o(3495163854848L, 26041);
      return;
    }
    if (!this.igR)
    {
      ap.yY();
      if (c.isSDCardAvailable()) {}
    }
    else
    {
      v.e("MicroMsg.PermissionConfigUpdater", "not to update, isUpdating: %s", new Object[] { Boolean.valueOf(this.igR) });
      GMTrace.o(3495163854848L, 26041);
      return;
    }
    ap.yY();
    long l = ((Long)c.vr().get(327944, Long.valueOf(0L))).longValue();
    if (bf.NA() - l < 86400000L)
    {
      GMTrace.o(3495163854848L, 26041);
      return;
    }
    release();
    this.igR = true;
    com.tencent.mm.ap.k localk = new com.tencent.mm.ap.k(23);
    ap.vd().a(localk, 0);
    ap.vd().a(159, this);
    ap.vd().a(160, this);
    GMTrace.o(3495163854848L, 26041);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(3495432290304L, 26043);
    if ((!(paramk instanceof com.tencent.mm.y.m)) || (((com.tencent.mm.y.m)paramk).BQ() != 23))
    {
      v.d("MicroMsg.PermissionConfigUpdater", "another scene");
      GMTrace.o(3495432290304L, 26043);
      return;
    }
    int i = paramk.getType();
    if (159 == i)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        HX();
        paramString = com.tencent.mm.ap.t.Id().gl(23);
        if ((paramString == null) || (paramString.length == 0))
        {
          v.i("MicroMsg.PermissionConfigUpdater", "error no pkg found.");
          release();
          GMTrace.o(3495432290304L, 26043);
          return;
        }
        paramString = paramString[0];
        v.i("MicroMsg.PermissionConfigUpdater", "permission, pkgId: %d, version: %d, status: %d, type: %d", new Object[] { Integer.valueOf(paramString.id), Integer.valueOf(paramString.version), Integer.valueOf(paramString.status), Integer.valueOf(paramString.fKC) });
        if (5 != paramString.status)
        {
          release();
          GMTrace.o(3495432290304L, 26043);
          return;
        }
        paramString = new j(paramString.id, 23);
        ap.vd().a(paramString, 0);
        GMTrace.o(3495432290304L, 26043);
        return;
      }
      paramInt1 = this.igS - 1;
      this.igS = paramInt1;
      if (paramInt1 <= 0)
      {
        if (ap.zb())
        {
          ap.yY();
          c.vr().set(327944, Long.valueOf(bf.NA() - 86400000L + 3600000L));
        }
        this.igS = 3;
      }
      release();
      GMTrace.o(3495432290304L, 26043);
      return;
    }
    if (160 == i)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        HX();
      }
      release();
    }
    GMTrace.o(3495432290304L, 26043);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/permission/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */