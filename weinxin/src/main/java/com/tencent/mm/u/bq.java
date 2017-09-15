package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.Map;

public final class bq
  implements d
{
  public bq()
  {
    GMTrace.i(644379312128L, 4801);
    GMTrace.o(644379312128L, 4801);
  }
  
  public final d.b b(d.a parama)
  {
    GMTrace.i(644513529856L, 4802);
    parama = parama.hsc;
    if (parama == null)
    {
      v.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
      GMTrace.o(644513529856L, 4802);
      return null;
    }
    try
    {
      parama = bg.q("<root>" + parama.tdz + "</root>", "root");
      int i = Integer.valueOf((String)parama.get(".root.newcount")).intValue();
      int j = Integer.valueOf((String)parama.get(".root.version")).intValue();
      ap.yY();
      parama = c.vr();
      if (j == bf.f((Integer)parama.get(12305, null)))
      {
        v.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
        GMTrace.o(644513529856L, 4802);
        return null;
      }
      parama.set(12304, Integer.valueOf(i));
      parama.set(12305, Integer.valueOf(j));
    }
    catch (Exception parama)
    {
      for (;;)
      {
        v.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", new Object[] { bf.g(parama) });
      }
    }
    GMTrace.o(644513529856L, 4802);
    return null;
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(644647747584L, 4803);
    GMTrace.o(644647747584L, 4803);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */