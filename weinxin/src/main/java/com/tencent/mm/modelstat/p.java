package com.tencent.mm.modelstat;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ag.e;
import com.tencent.mm.u.am;
import com.tencent.mm.y.d.c;
import java.util.HashMap;

public class p
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private k hXd;
  private l hXe;
  private com.tencent.mm.network.w hXf;
  private f hXg;
  private com.tencent.mm.network.m hxS;
  
  static
  {
    GMTrace.i(1381637292032L, 10294);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(1393582669824L, 10383);
        String[] arrayOfString = l.gUn;
        GMTrace.o(1393582669824L, 10383);
        return arrayOfString;
      }
    });
    GMTrace.o(1381637292032L, 10294);
  }
  
  public p()
  {
    GMTrace.i(1380160897024L, 10283);
    this.hXd = new k();
    this.hXf = new com.tencent.mm.network.w();
    this.hXg = null;
    this.hxS = new m.a()
    {
      public final void cU(int paramAnonymousInt)
      {
        GMTrace.i(1391032532992L, 10364);
        if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
        {
          GMTrace.o(1391032532992L, 10364);
          return;
        }
        h.vL().e(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(1393851105280L, 10385);
            if (!h.vG().uV())
            {
              GMTrace.o(1393851105280L, 10385);
              return;
            }
            p.Kg().Ka();
            GMTrace.o(1393851105280L, 10385);
          }
          
          public final String toString()
          {
            GMTrace.i(1393985323008L, 10386);
            String str = super.toString() + "|onNetworkChange";
            GMTrace.o(1393985323008L, 10386);
            return str;
          }
        }, 3000L);
        v.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        n.gH(2);
        GMTrace.o(1391032532992L, 10364);
      }
    };
    GMTrace.o(1380160897024L, 10283);
  }
  
  public static f Kg()
  {
    GMTrace.i(1380295114752L, 10284);
    h.vG().uQ();
    if (Kh().hXg == null) {
      Kh().hXg = new f(com.tencent.mm.storage.w.hgg);
    }
    f localf = Kh().hXg;
    GMTrace.o(1380295114752L, 10284);
    return localf;
  }
  
  private static p Kh()
  {
    GMTrace.i(1380429332480L, 10285);
    p localp = (p)com.tencent.mm.u.l.o(p.class);
    GMTrace.o(1380429332480L, 10285);
    return localp;
  }
  
  public static l Ki()
  {
    GMTrace.i(1380563550208L, 10286);
    h.vG().uQ();
    if (Kh().hXe == null) {
      Kh().hXe = new l(h.vI().gXW);
    }
    l locall = Kh().hXe;
    GMTrace.o(1380563550208L, 10286);
    return locall;
  }
  
  public static void e(com.tencent.mm.network.e parame)
  {
    GMTrace.i(1380697767936L, 10287);
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.SubCoreStat", "dknetstat setNetworkMoniter  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bf.bJP() });
      if (parame != null) {
        parame.a(Kh().hXd);
      }
      GMTrace.o(1380697767936L, 10287);
      return;
    }
  }
  
  public static void f(com.tencent.mm.network.e parame)
  {
    GMTrace.i(1380831985664L, 10288);
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.SubCoreStat", "setKVReportMonitor  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bf.bJP() });
      if (parame != null) {
        parame.a(Kh().hXf);
      }
      GMTrace.o(1380831985664L, 10288);
      return;
    }
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(1381368856576L, 10292);
    d.c.a(Integer.valueOf(9998), this.hXd);
    h.vH().a(this.hxS);
    com.tencent.mm.u.ag.a.hlB = new ag.e()
    {
      public final void aH(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(1371034091520L, 10215);
        v.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), bf.bJP() });
        m.r(paramAnonymousInt1, paramAnonymousInt2, 0);
        GMTrace.o(1371034091520L, 10215);
      }
    };
    GMTrace.o(1381368856576L, 10292);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(1381503074304L, 10293);
    GMTrace.o(1381503074304L, 10293);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(1381234638848L, 10291);
    GMTrace.o(1381234638848L, 10291);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(1380966203392L, 10289);
    h.vH().b(this.hxS);
    d.c.aA(Integer.valueOf(9998));
    this.hXd = new k();
    com.tencent.mm.u.ag.a.hlB = null;
    GMTrace.o(1380966203392L, 10289);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(1381100421120L, 10290);
    HashMap localHashMap = gJh;
    GMTrace.o(1381100421120L, 10290);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelstat/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */