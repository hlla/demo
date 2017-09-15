package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.Map;
import junit.framework.Assert;

public final class bj
  implements d
{
  public bj()
  {
    GMTrace.i(649076932608L, 4836);
    GMTrace.o(649076932608L, 4836);
  }
  
  public final d.b b(d.a parama)
  {
    boolean bool2 = true;
    GMTrace.i(649211150336L, 4837);
    parama = parama.hsc;
    if (parama != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (parama.tdz == null) {
        break label113;
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      parama = (String)bg.q(n.a(parama.tdz), "tips").get(".tips.tip.url");
      v.v("MicroMsg.SoftwareMsgExtension", "url:" + parama);
      ap.yY();
      c.vr().set(12308, parama);
      GMTrace.o(649211150336L, 4837);
      return null;
      bool1 = false;
      break;
    }
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(649345368064L, 4838);
    GMTrace.o(649345368064L, 4838);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */