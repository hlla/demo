package com.tencent.mm.av;

import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.ff;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.af;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bn;
import com.tencent.mm.y.d.c;
import java.util.HashMap;
import java.util.List;

public class l
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  public static int[] hXw;
  public static int hXx;
  private final int fxc;
  private n hXo;
  private g hXp;
  private c hXq;
  private d hXr;
  private i hXs;
  private k hXt;
  private final long hXu;
  private final int hXv;
  private com.tencent.mm.sdk.b.c hXy;
  
  static
  {
    GMTrace.i(1417876078592L, 10564);
    hXw = new int['Ϩ'];
    hXx = 0;
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(1413715329024L, 10533);
        String[] arrayOfString = i.gUn;
        GMTrace.o(1413715329024L, 10533);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(1410896756736L, 10512);
        String[] arrayOfString = k.gUn;
        GMTrace.o(1410896756736L, 10512);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(1422305263616L, 10597);
        String[] arrayOfString = m.gUn;
        GMTrace.o(1422305263616L, 10597);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(1422036828160L, 10595);
        String[] arrayOfString = g.gUn;
        GMTrace.o(1422036828160L, 10595);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(1424586964992L, 10614);
        String[] arrayOfString = c.gUn;
        GMTrace.o(1424586964992L, 10614);
        return arrayOfString;
      }
    });
    GMTrace.o(1417876078592L, 10564);
  }
  
  public l()
  {
    GMTrace.i(1416399683584L, 10553);
    this.hXo = new n();
    this.hXr = new d();
    this.hXu = 259200000L;
    this.fxc = 0;
    this.hXv = 2;
    this.hXy = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(1416399683584L, 10553);
  }
  
  public static i KA()
  {
    GMTrace.i(1416936554496L, 10557);
    h.vG().uQ();
    if (Kx().hXs == null)
    {
      localObject = Kx();
      ap.yY();
      ((l)localObject).hXs = new i(com.tencent.mm.u.c.wO());
    }
    Object localObject = Kx().hXs;
    GMTrace.o(1416936554496L, 10557);
    return (i)localObject;
  }
  
  public static k KB()
  {
    GMTrace.i(1417070772224L, 10558);
    h.vG().uQ();
    if (Kx().hXt == null)
    {
      localObject = Kx();
      ap.yY();
      ((l)localObject).hXt = new k(com.tencent.mm.u.c.wO());
    }
    Object localObject = Kx().hXt;
    GMTrace.o(1417070772224L, 10558);
    return (k)localObject;
  }
  
  private static l Kx()
  {
    GMTrace.i(1416533901312L, 10554);
    l locall2 = (l)ap.yR().gs(l.class.getName());
    l locall1 = locall2;
    if (locall2 == null)
    {
      locall1 = new l();
      ap.yR().a(l.class.getName(), locall1);
    }
    GMTrace.o(1416533901312L, 10554);
    return locall1;
  }
  
  public static g Ky()
  {
    GMTrace.i(1416668119040L, 10555);
    h.vG().uQ();
    if (Kx().hXp == null)
    {
      localObject = Kx();
      ap.yY();
      ((l)localObject).hXp = new g(com.tencent.mm.u.c.wO());
      localObject = Kz();
      Kx().hXp.a((j.a)localObject, ap.vL().nIe.getLooper());
    }
    Object localObject = Kx().hXp;
    GMTrace.o(1416668119040L, 10555);
    return (g)localObject;
  }
  
  public static c Kz()
  {
    GMTrace.i(1416802336768L, 10556);
    h.vG().uQ();
    if (Kx().hXq == null)
    {
      localObject = Kx();
      ap.yY();
      ((l)localObject).hXq = new c(com.tencent.mm.u.c.wO());
    }
    Object localObject = Kx().hXq;
    GMTrace.o(1416802336768L, 10556);
    return (c)localObject;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(1417607643136L, 10562);
    d.c.a(Integer.valueOf(37), this.hXo);
    d.c.a(Integer.valueOf(40), this.hXr);
    com.tencent.mm.sdk.b.a.uql.b(this.hXy);
    int i = Kz().Kn();
    long l = System.currentTimeMillis();
    ap.yY();
    if ((l - bf.a((Long)com.tencent.mm.u.c.vr().get(340225, null), 0L) > 259200000L) && (i > 0))
    {
      Object localObject = Kz().Ko();
      int j = ((List)localObject).size();
      String str = (String)((List)localObject).get(0);
      i = 1;
      while (i < j)
      {
        str = str + ", " + (String)((List)localObject).get(i);
        i += 1;
      }
      localObject = new jv();
      ((jv)localObject).fQa.userName = null;
      ((jv)localObject).fQa.aIO = str;
      ((jv)localObject).fQa.type = 0;
      com.tencent.mm.sdk.b.a.uql.m((b)localObject);
      ap.yY();
      com.tencent.mm.u.c.vr().set(340225, Long.valueOf(System.currentTimeMillis()));
    }
    GMTrace.o(1417607643136L, 10562);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(1417741860864L, 10563);
    GMTrace.o(1417741860864L, 10563);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(1417473425408L, 10561);
    GMTrace.o(1417473425408L, 10561);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(1417204989952L, 10559);
    d.c.aA(Integer.valueOf(37));
    d.c.aA(Integer.valueOf(40));
    com.tencent.mm.sdk.b.a.uql.c(this.hXy);
    ap.getNotification().qi();
    GMTrace.o(1417204989952L, 10559);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(1417339207680L, 10560);
    HashMap localHashMap = gJh;
    GMTrace.o(1417339207680L, 10560);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/av/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */