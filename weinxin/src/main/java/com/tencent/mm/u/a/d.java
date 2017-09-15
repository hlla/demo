package com.tencent.mm.u.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;

public final class d
  implements com.tencent.mm.y.d
{
  public d()
  {
    GMTrace.i(692295041024L, 5158);
    GMTrace.o(692295041024L, 5158);
  }
  
  public final d.b b(d.a parama)
  {
    GMTrace.i(692429258752L, 5159);
    parama = parama.hsc;
    if ((parama == null) || (parama.tdz == null))
    {
      v.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
      GMTrace.o(692429258752L, 5159);
      return null;
    }
    String str = n.a(parama.tdz);
    h.vI().vr().set(328193, str);
    parama = g.Ae();
    long l = System.currentTimeMillis();
    try
    {
      parama.gv(str);
      str = (String)h.vI().vr().get(328197, null);
      if ((bf.mA(str)) || ((parama.hoh != null) && (!str.equals(parama.hoh.hod))))
      {
        h.vI().vr().set(328197, parama.hoh.hod);
        h.vI().vr().set(328195, Boolean.valueOf(false));
        h.vI().vr().set(328194, Boolean.valueOf(false));
        h.vI().vr().set(328196, Boolean.valueOf(false));
        v.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        v.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { parama.toString() });
      }
    }
    v.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    if (g.Ae().Ac()) {
      f.gx(g.Ae().hoh.hod);
    }
    GMTrace.o(692429258752L, 5159);
    return null;
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(692563476480L, 5160);
    GMTrace.o(692563476480L, 5160);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */