package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.pluginsdk.k.a.d.l;
import com.tencent.mm.pluginsdk.k.a.d.m.a;
import com.tencent.mm.pluginsdk.k.a.e.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

final class d
  extends m.a<c>
{
  public d(c paramc)
  {
    super(paramc);
    GMTrace.i(856711757824L, 6383);
    GMTrace.o(856711757824L, 6383);
  }
  
  public final String Qo()
  {
    GMTrace.i(856845975552L, 6384);
    GMTrace.o(856845975552L, 6384);
    return "CheckResUpdate";
  }
  
  public final boolean Qu()
  {
    GMTrace.i(857114411008L, 6386);
    if (super.Qu())
    {
      j.u(((c)Qv()).sDz, 12L);
      GMTrace.o(857114411008L, 6386);
      return true;
    }
    j.u(((c)Qv()).sDz, 27L);
    GMTrace.o(857114411008L, 6386);
    return false;
  }
  
  protected final l a(com.tencent.mm.pluginsdk.k.a.d.j paramj)
  {
    GMTrace.i(857248628736L, 6387);
    c localc = (c)Qv();
    String str1 = i.Mo(localc.sDr);
    String str2 = localc.fFN;
    if ((localc.rUz) && (bf.mz(g.aV(i.Mo(localc.sDr))).equals(str2)))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
      paramj = new l(localc, a.By(str1));
      GMTrace.o(857248628736L, 6387);
      return paramj;
    }
    if ((!bf.bm(((c)Qv()).sDZ)) && (a.u(i.Mo(((c)Qv()).sDr), ((c)Qv()).sDZ)) && (bf.mz(g.aV(i.Mo(((c)Qv()).sDr))).equals(((c)Qv()).fFN)))
    {
      paramj = new l((k)Qv(), a.By(i.Mo(((c)Qv()).sDr)));
      GMTrace.o(857248628736L, 6387);
      return paramj;
    }
    paramj = super.a(paramj);
    v.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = " + paramj, new Object[] { localc.sDr });
    if (paramj.status == 2)
    {
      if ((!bf.mA(((c)Qv()).fFN)) && (((c)Qv()).fFN.equals(g.aV(getFilePath())))) {
        v.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[] { localc.sDr });
      }
    }
    else
    {
      GMTrace.o(857248628736L, 6387);
      return paramj;
    }
    v.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[] { localc.sDr });
    paramj = new l("CheckResUpdate", bDh(), getURL(), getFilePath(), paramj.gad, paramj.gac, new com.tencent.mm.pluginsdk.k.a.c.c());
    GMTrace.o(857248628736L, 6387);
    return paramj;
  }
  
  public final boolean dW(long paramLong)
  {
    GMTrace.i(856980193280L, 6385);
    if ((((c)Qv()).fileSize > 0L) && (((c)Qv()).fileSize != a.By(getFilePath()) + paramLong))
    {
      GMTrace.o(856980193280L, 6385);
      return false;
    }
    boolean bool = super.dW(paramLong);
    GMTrace.o(856980193280L, 6385);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */