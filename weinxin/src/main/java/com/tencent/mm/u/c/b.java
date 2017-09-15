package com.tencent.mm.u.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.protocal.c.tp;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import com.tencent.mm.y.u.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class b
{
  public static boolean aaI;
  
  static
  {
    GMTrace.i(636460466176L, 4742);
    aaI = false;
    GMTrace.o(636460466176L, 4742);
  }
  
  static void Au()
  {
    GMTrace.i(634715635712L, 4729);
    if (!h.vG().uV())
    {
      v.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
      GMTrace.o(634715635712L, 4729);
      return;
    }
    Object localObject = (Long)h.vI().vr().get(w.a.uzz, null);
    long l1;
    int i;
    if (localObject == null)
    {
      l1 = 0L;
      if (l1 != 0L) {
        break label139;
      }
      i = new Random().nextInt(86400);
      fm(i);
      Aw();
      Ax();
      v.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        break label272;
      }
      v.v("MicroMsg.ABTestUpdater", "No need to update");
      GMTrace.o(634715635712L, 4729);
      return;
      l1 = ((Long)localObject).longValue();
      break;
      label139:
      localObject = (Integer)h.vI().vr().get(w.a.uzA, null);
      label173:
      long l2;
      long l3;
      if ((localObject == null) || (((Integer)localObject).intValue() == 0))
      {
        i = 86400;
        l2 = i;
        l3 = System.currentTimeMillis() / 1000L;
        if (l3 <= l1 + l2) {
          break label261;
        }
      }
      label261:
      for (boolean bool = true;; bool = false)
      {
        v.i("MicroMsg.ABTestUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
        if (l3 <= l1 + l2) {
          break label267;
        }
        i = 1;
        break;
        i = ((Integer)localObject).intValue();
        break label173;
      }
      label267:
      i = 0;
    }
    label272:
    if (aaI)
    {
      v.i("MicroMsg.ABTestUpdater", "Updating");
      GMTrace.o(634715635712L, 4729);
      return;
    }
    update();
    GMTrace.o(634715635712L, 4729);
  }
  
  static void Av()
  {
    GMTrace.i(634849853440L, 4730);
    if (!h.vG().uV())
    {
      v.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
      GMTrace.o(634849853440L, 4730);
      return;
    }
    if (aaI)
    {
      v.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
      GMTrace.o(634849853440L, 4730);
      return;
    }
    v.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
    update();
    GMTrace.o(634849853440L, 4730);
  }
  
  public static void Aw()
  {
    GMTrace.i(635118288896L, 4732);
    long l = System.currentTimeMillis() / 1000L;
    h.vI().vr().a(w.a.uzz, Long.valueOf(l));
    GMTrace.o(635118288896L, 4732);
  }
  
  public static void Ax()
  {
    GMTrace.i(635386724352L, 4734);
    h.vI().vr().jV(true);
    GMTrace.o(635386724352L, 4734);
  }
  
  public static void fm(int paramInt)
  {
    GMTrace.i(635252506624L, 4733);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        h.vI().vr().a(w.a.uzA, Integer.valueOf(i));
        GMTrace.o(635252506624L, 4733);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
  
  public static void fn(int paramInt)
  {
    GMTrace.i(16087068442624L, 119858);
    h.vI().vr().a(w.a.uzy, Integer.valueOf(paramInt));
    GMTrace.o(16087068442624L, 119858);
  }
  
  private static void update()
  {
    GMTrace.i(634984071168L, 4731);
    aaI = true;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hrV = new to();
    ((b.a)localObject1).hrW = new tp();
    ((b.a)localObject1).uri = "/cgi-bin/mmux-bin/getabtest";
    ((b.a)localObject1).hrU = 1801;
    com.tencent.mm.y.b localb = ((b.a)localObject1).BE();
    localObject1 = (to)localb.hrS.hsa;
    Object localObject2 = (Integer)h.vI().vr().get(w.a.uzy, null);
    if (localObject2 == null) {}
    for (int i = 0;; i = ((Integer)localObject2).intValue())
    {
      ((to)localObject1).tAk = i;
      ((to)localObject1).tAl = c.Az().bKy();
      ((to)localObject1).tAl.addAll(c.AA().bKy());
      localObject2 = ((to)localObject1).tAl.iterator();
      qc localqc;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + localqc.trS + ":" + localqc.priority + "|") {
        localqc = (qc)((Iterator)localObject2).next();
      }
    }
    v.i("MicroMsg.ABTestUpdater", "update abtest: %s", new Object[] { localObject1 });
    u.a(localb, new u.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.b paramAnonymousb, k paramAnonymousk)
      {
        GMTrace.i(636728901632L, 4744);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          v.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
          b.Aw();
          b.fm(86400);
          b.Ax();
          GMTrace.o(636728901632L, 4744);
          return 0;
        }
        paramAnonymousString = (tp)paramAnonymousb.hrT.hsa;
        b.Aw();
        b.fn(paramAnonymousString.ttV);
        b.fm(paramAnonymousString.tAo);
        b.x(paramAnonymousString.tAp);
        b.w(paramAnonymousString.tAn);
        b.Ax();
        v.i("MicroMsg.ABTestUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.tAo) });
        b.aaI = false;
        GMTrace.o(636728901632L, 4744);
        return 0;
      }
    }, true);
    GMTrace.o(634984071168L, 4731);
  }
  
  public static void w(List<com.tencent.mm.bd.b> paramList)
  {
    GMTrace.i(16086800007168L, 119856);
    if ((paramList == null) || (paramList.size() == 0))
    {
      v.w("MicroMsg.ABTestUpdater", "No Exp");
      GMTrace.o(16086800007168L, 119856);
      return;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a.a locala = a.gC(n.a((com.tencent.mm.bd.b)paramList.next()));
      localLinkedList1.addAll(locala.how);
      localLinkedList2.addAll(locala.hox);
    }
    c.Az().i(localLinkedList1, 0);
    c.AA().i(localLinkedList2, 1);
    GMTrace.o(16086800007168L, 119856);
  }
  
  public static void x(List<Integer> paramList)
  {
    GMTrace.i(16086934224896L, 119857);
    if (bf.bV(paramList))
    {
      v.w("MicroMsg.ABTestUpdater", "No expired Exp");
      GMTrace.o(16086934224896L, 119857);
      return;
    }
    Object localObject1 = c.Az();
    Object localObject2;
    Object localObject3;
    if (!bf.bV(paramList))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        if (localObject3 != null)
        {
          com.tencent.mm.storage.c localc = new com.tencent.mm.storage.c();
          localc.field_expId = String.valueOf(localObject3);
          ((d)localObject1).a(localc, new String[] { "expId" });
        }
      }
    }
    localObject1 = c.AA();
    if (!bf.bV(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (Integer)paramList.next();
        if (localObject2 != null)
        {
          localObject3 = new com.tencent.mm.storage.a();
          ((com.tencent.mm.storage.a)localObject3).field_expId = String.valueOf(localObject2);
          ((com.tencent.mm.storage.b)localObject1).a((com.tencent.mm.sdk.e.c)localObject3, new String[] { "expId" });
        }
      }
    }
    GMTrace.o(16086934224896L, 119857);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */