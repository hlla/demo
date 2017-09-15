package com.tencent.mm.plugin.bbom;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ay.a;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements r
{
  private static List<ai> jOn;
  private boolean jOo;
  private boolean jOp;
  private List<au> jOq;
  
  static
  {
    GMTrace.i(8021388296192L, 59764);
    jOn = new ArrayList();
    GMTrace.o(8021388296192L, 59764);
  }
  
  public n()
  {
    this(false);
    GMTrace.i(8020851425280L, 59760);
    GMTrace.o(8020851425280L, 59760);
  }
  
  public n(boolean paramBoolean)
  {
    GMTrace.i(8020985643008L, 59761);
    this.jOo = false;
    this.jOp = false;
    this.jOq = new LinkedList();
    this.jOo = paramBoolean;
    this.jOp = false;
    this.jOq = new LinkedList();
    GMTrace.o(8020985643008L, 59761);
  }
  
  public static void a(ai paramai)
  {
    GMTrace.i(8020582989824L, 59758);
    synchronized (jOn)
    {
      if (!jOn.contains(paramai)) {
        jOn.add(paramai);
      }
      GMTrace.o(8020582989824L, 59758);
      return;
    }
  }
  
  public static void b(ai paramai)
  {
    GMTrace.i(8020717207552L, 59759);
    synchronized (jOn)
    {
      jOn.remove(paramai);
      GMTrace.o(8020717207552L, 59759);
      return;
    }
  }
  
  public final void a(final au paramau, final bu parambu)
  {
    GMTrace.i(8021254078464L, 59763);
    if (this.jOo)
    {
      v.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
      GMTrace.o(8021254078464L, 59763);
      return;
    }
    if (jOn.isEmpty())
    {
      v.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
      GMTrace.o(8021254078464L, 59763);
      return;
    }
    if ((paramau.field_isSend != 0) || (paramau.field_status == 4))
    {
      v.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
      GMTrace.o(8021254078464L, 59763);
      return;
    }
    ??? = com.tencent.mm.platformtools.n.a(parambu.tdx);
    ap.yY();
    ??? = c.wZ().AF(new ay.a((String)???).RT(""));
    if ((??? != null) && (!((ay)???).bMI()))
    {
      v.d("MicroMsg.SyncMessageNotifier", "account no notification");
      GMTrace.o(8021254078464L, 59763);
      return;
    }
    if (!this.jOp)
    {
      this.jOp = true;
      final Object localObject2 = new ArrayList();
      synchronized (jOn)
      {
        Iterator localIterator = jOn.iterator();
        if (localIterator.hasNext()) {
          ((List)localObject2).add((ai)localIterator.next());
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ai)((Iterator)???).next();
        new ad(((ai)localObject2).getLooper()).post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(8027964964864L, 59813);
            if (parambu.mrC == 49)
            {
              f.a locala = f.a.ek(j.c(parambu));
              if ((locala.hiA == 1) && (!bf.mA(locala.hiB)) && (!bf.mA(locala.hiC)))
              {
                localObject2.a(39, locala.hiC, "", locala.hiB, null, null);
                GMTrace.o(8027964964864L, 59813);
                return;
              }
              localObject2.a(paramau);
              GMTrace.o(8027964964864L, 59813);
              return;
            }
            localObject2.a(paramau);
            GMTrace.o(8027964964864L, 59813);
          }
        });
      }
      GMTrace.o(8021254078464L, 59763);
      return;
    }
    this.jOq.add(paramau);
    GMTrace.o(8021254078464L, 59763);
  }
  
  public final void acL()
  {
    GMTrace.i(8021119860736L, 59762);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.jOq);
    this.jOq.clear();
    if (localLinkedList.size() == 0)
    {
      GMTrace.o(8021119860736L, 59762);
      return;
    }
    final Object localObject2 = new ArrayList();
    synchronized (jOn)
    {
      Iterator localIterator = jOn.iterator();
      if (localIterator.hasNext()) {
        ((List)localObject2).add((ai)localIterator.next());
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (ai)((Iterator)???).next();
      new ad(((ai)localObject2).getLooper()).post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(8030649319424L, 59833);
          localObject2.p(localList);
          GMTrace.o(8030649319424L, 59833);
        }
      });
    }
    GMTrace.o(8021119860736L, 59762);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/bbom/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */