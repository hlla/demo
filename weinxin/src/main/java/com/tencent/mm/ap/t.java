package com.tencent.mm.ap;

import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import java.util.HashMap;
import java.util.Map;

public class t
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private n hOa;
  private b hOb;
  private o hOc;
  private p hOd;
  private q hOe;
  private r hOf;
  private l hOg;
  private ai hOh;
  
  static
  {
    GMTrace.i(12948252655616L, 96472);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(12949594832896L, 96482);
        String[] arrayOfString = n.gUn;
        GMTrace.o(12949594832896L, 96482);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("CHATTINGBGINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(12937917890560L, 96395);
        String[] arrayOfString = b.gUn;
        GMTrace.o(12937917890560L, 96395);
        return arrayOfString;
      }
    });
    GMTrace.o(12948252655616L, 96472);
  }
  
  public t()
  {
    GMTrace.i(12947044696064L, 96463);
    this.hOc = new o();
    this.hOd = new p();
    this.hOe = new q();
    this.hOf = new r();
    this.hOg = null;
    this.hOh = new ai(h.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(12948521091072L, 96474);
        v.d("MicroMsg.SubCorePacakge", "dkregcode Update RegonCode here TRULY!");
        s.Ib().update();
        GMTrace.o(12948521091072L, 96474);
        return false;
      }
      
      public final String toString()
      {
        GMTrace.i(12948655308800L, 96475);
        String str = super.toString() + "|regCodeUpdater";
        GMTrace.o(12948655308800L, 96475);
        return str;
      }
    }, false);
    GMTrace.o(12947044696064L, 96463);
  }
  
  private static t Ic()
  {
    GMTrace.i(12947178913792L, 96464);
    t localt = (t)com.tencent.mm.u.l.o(t.class);
    GMTrace.o(12947178913792L, 96464);
    return localt;
  }
  
  public static n Id()
  {
    GMTrace.i(12947313131520L, 96465);
    h.vG().uQ();
    if (Ic().hOa == null) {
      Ic().hOa = new n(h.vI().gXW);
    }
    n localn = Ic().hOa;
    GMTrace.o(12947313131520L, 96465);
    return localn;
  }
  
  public static b Ie()
  {
    GMTrace.i(12947447349248L, 96466);
    h.vG().uQ();
    if (Ic().hOb == null) {
      Ic().hOb = new b(h.vI().gXW);
    }
    b localb = Ic().hOb;
    GMTrace.o(12947447349248L, 96466);
    return localb;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(12947715784704L, 96468);
    if (paramBoolean)
    {
      v.d("MicroMsg.SubCorePacakge", "dkregcode Update RegonCode here !");
      this.hOh.v(10000L, 10000L);
    }
    com.tencent.mm.sdk.b.a.uql.b(this.hOc);
    com.tencent.mm.sdk.b.a.uql.b(this.hOd);
    com.tencent.mm.sdk.b.a.uql.b(this.hOe);
    com.tencent.mm.sdk.b.a.uql.b(this.hOf);
    if (this.hOg != null) {
      this.hOg.hNU.clear();
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.uql.b(this.hOg.hNV);
      com.tencent.mm.sdk.b.a.uql.b(this.hOg.hNW);
      GMTrace.o(12947715784704L, 96468);
      return;
      this.hOg = new l();
    }
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(12948118437888L, 96471);
    GMTrace.o(12948118437888L, 96471);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(12947984220160L, 96470);
    GMTrace.o(12947984220160L, 96470);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(12947581566976L, 96467);
    com.tencent.mm.sdk.b.a.uql.c(this.hOc);
    com.tencent.mm.sdk.b.a.uql.c(this.hOd);
    com.tencent.mm.sdk.b.a.uql.c(this.hOe);
    com.tencent.mm.sdk.b.a.uql.c(this.hOf);
    com.tencent.mm.sdk.b.a.uql.c(this.hOg.hNV);
    com.tencent.mm.sdk.b.a.uql.c(this.hOg.hNW);
    GMTrace.o(12947581566976L, 96467);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(12947850002432L, 96469);
    HashMap localHashMap = gJh;
    GMTrace.o(12947850002432L, 96469);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */