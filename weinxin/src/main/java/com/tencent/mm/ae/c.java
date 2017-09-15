package com.tencent.mm.ae;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.bj.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.protocal.c.xd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ag.b.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import com.tencent.mm.y.u.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

final class c
  implements ag.b
{
  private f<String, Integer> hDm;
  public Map<String, ag.b.a> hDn;
  public Queue<xc> hDo;
  public Queue<a> hDp;
  public long hDq;
  final int hDr;
  final int hDs;
  public ai hDt;
  public final ai hDu;
  private long hqC;
  public boolean hqr;
  
  c()
  {
    GMTrace.i(4092030091264L, 30488);
    this.hqr = false;
    this.hDm = new f(200);
    this.hDn = new HashMap();
    this.hDo = new LinkedList();
    this.hDp = new LinkedList();
    this.hDq = 0L;
    this.hDr = 500;
    this.hDs = 10000;
    this.hqC = 0L;
    this.hDt = new ai(ap.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(4089345736704L, 30468);
        v.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
        c.this.pq();
        GMTrace.o(4089345736704L, 30468);
        return false;
      }
    }, false);
    this.hDu = new ai(ap.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(4091761655808L, 30486);
        if (c.this.hDp.isEmpty())
        {
          v.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
          GMTrace.o(4091761655808L, 30486);
          return false;
        }
        long l1 = bf.NA();
        int i;
        ArrayList localArrayList;
        int j;
        label73:
        c.a locala;
        final boolean bool;
        if (c.this.hqr)
        {
          i = 5;
          localArrayList = new ArrayList(i * 2);
          j = 0;
          if (j >= i) {
            break label910;
          }
          locala = (c.a)c.this.hDp.peek();
          if (locala != null) {
            break label178;
          }
          v.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
          bool = false;
        }
        for (;;)
        {
          label110:
          int k = localArrayList.size();
          if (k > 0)
          {
            ap.yY();
            long l2 = com.tencent.mm.u.c.wO().cs(Thread.currentThread().getId());
            final Object localObject1 = d.Gt();
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                ((b)localObject1).jm((String)localArrayList.get(j));
                j += 1;
                continue;
                i = 15;
                break;
                label178:
                final Object localObject2 = locala.hDB.tCk;
                localObject1 = locala.hDB.tCl;
                k = locala.hDC;
                int m = ((LinkedList)localObject2).size();
                if (m <= k)
                {
                  c.this.hDp.poll();
                  if (c.this.hDp.isEmpty())
                  {
                    v.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                    c.this.hDq = 0L;
                    c.this.hDt.v(0L, 0L);
                    bool = false;
                    break label110;
                  }
                  v.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                  j += 1;
                  break label73;
                }
                final Object localObject3 = (amb)((LinkedList)localObject2).get(k);
                m = ((Integer)((LinkedList)localObject1).get(k)).intValue();
                localObject2 = bf.ap(n.a(((amb)localObject3).trH), "");
                final String str = bf.ap(((amb)localObject3).hAq, "");
                localArrayList.add(localObject2);
                localArrayList.add(str);
                switch (m)
                {
                default: 
                  v.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s", new Object[] { Integer.valueOf(m), localObject2, str });
                  j.ew((String)localObject2);
                  bool = false;
                  label462:
                  localObject3 = (ag.b.a)c.this.hDn.remove(localObject2);
                  if (!bf.mA(str)) {
                    break;
                  }
                }
                for (localObject1 = null;; localObject1 = (ag.b.a)c.this.hDn.remove(str))
                {
                  if ((localObject3 != null) || (localObject1 != null)) {
                    new ad(Looper.getMainLooper()).post(new Runnable()
                    {
                      public final void run()
                      {
                        GMTrace.i(4089882607616L, 30472);
                        if (localObject3 != null) {
                          localObject3.p(localObject2, bool);
                        }
                        if ((localObject1 != null) && (!bf.mA(str))) {
                          localObject1.p(str, bool);
                        }
                        GMTrace.o(4089882607616L, 30472);
                      }
                    });
                  }
                  locala.hDC += 1;
                  break;
                  if ((locala.hDB.tCm == null) || (locala.hDB.tCm.size() <= k) || (!((String)localObject2).equals(((bjc)locala.hDB.tCm.get(k)).username))) {
                    if (locala.hDB.tCm == null)
                    {
                      localObject1 = "null";
                      label617:
                      v.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", new Object[] { localObject1, Integer.valueOf(k), localObject2 });
                    }
                  }
                  for (localObject1 = "";; localObject1 = bf.ap(((bjc)locala.hDB.tCm.get(k)).uhf, ""))
                  {
                    v.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", new Object[] { localObject2, str, localObject1 });
                    com.tencent.mm.plugin.subapp.b.imc.a((amb)localObject3, (String)localObject1);
                    bool = true;
                    break;
                    localObject1 = Integer.valueOf(locala.hDB.tCm.size());
                    break label617;
                  }
                  v.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s", new Object[] { Integer.valueOf(m), localObject2, str });
                  j.ew((String)localObject2);
                  bool = false;
                  break label462;
                }
              }
            }
            ap.yY();
            com.tencent.mm.u.c.wO().aD(l2);
          }
          v.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.hqr + " ret: " + bool + " maxCnt: " + i + " deleteCount: " + k + " take: " + (bf.NA() - l1) + "ms");
          GMTrace.o(4091761655808L, 30486);
          return bool;
          label910:
          bool = true;
        }
      }
    }, true);
    GMTrace.o(4092030091264L, 30488);
  }
  
  private void Gr()
  {
    GMTrace.i(4092701179904L, 30493);
    Object localObject1 = d.Gt();
    long l = this.hDq;
    Object localObject4 = ((b)localObject1).hnp.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[] { String.valueOf(l), "80" }, 0);
    if (localObject4 == null)
    {
      GMTrace.o(4092701179904L, 30493);
      return;
    }
    int i = ((Cursor)localObject4).getCount();
    v.i("MicroMsg.GetContactService", "getFromDb count:%d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      ((Cursor)localObject4).close();
      GMTrace.o(4092701179904L, 30493);
      return;
    }
    localObject1 = new LinkedList();
    Object localObject2 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject3;
    Object localObject5;
    if (((Cursor)localObject4).moveToNext())
    {
      Object localObject6 = new a();
      ((a)localObject6).username = ((Cursor)localObject4).getString(0);
      ((a)localObject6).hDk = ((Cursor)localObject4).getLong(1);
      ((a)localObject6).type = ((Cursor)localObject4).getInt(2);
      ((a)localObject6).hDl = ((Cursor)localObject4).getInt(3);
      ((a)localObject6).hnl = ((Cursor)localObject4).getInt(4);
      ((a)localObject6).hBg = ((Cursor)localObject4).getInt(5);
      ((a)localObject6).hnn = ((Cursor)localObject4).getString(6);
      ((a)localObject6).hno = ((Cursor)localObject4).getString(7);
      localObject3 = ((a)localObject6).getUsername();
      localObject5 = bf.mz(((a)localObject6).zJ());
      i = bf.f(Integer.valueOf(((a)localObject6).hBg));
      String str = bf.mz(((a)localObject6).Gq());
      this.hDq = ((a)localObject6).hDk;
      localObject6 = (String)localObject3 + "#" + (String)localObject5;
      int j = bf.a((Integer)this.hDm.get(localObject6), 0);
      if (j < 3)
      {
        this.hDm.k(localObject6, Integer.valueOf(j + 1));
        if (i == 1)
        {
          localLinkedList2.add(new Pair(new avu().OU((String)localObject3), new avu().OU(str)));
          v.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", new Object[] { localObject3, Integer.valueOf(i), str });
          label454:
          if ((((LinkedList)localObject1).size() < 20) && (!((Cursor)localObject4).isLast())) {
            break label938;
          }
          localObject3 = new xc();
          ((xc)localObject3).thh = ((LinkedList)localObject1);
          ((xc)localObject3).tCc = ((LinkedList)localObject1).size();
          ((xc)localObject3).tCg = ((LinkedList)localObject2);
          ((xc)localObject3).tCf = ((LinkedList)localObject2).size();
          this.hDo.add(localObject3);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          v.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", new Object[] { Integer.valueOf(this.hDo.size()), Integer.valueOf(((xc)localObject3).thh.size()) });
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      ((LinkedList)localObject1).add(new avu().OU((String)localObject3));
      ((LinkedList)localObject2).add(new avu().OU((String)localObject5));
      v.i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", new Object[] { localObject3, localObject5 });
      break label454;
      localLinkedList1.add(localObject3);
      if (!this.hDn.containsKey(localObject3)) {
        break label454;
      }
      localObject5 = (ag.b.a)this.hDn.get(localObject3);
      if (localObject5 != null) {
        ((ag.b.a)localObject5).p((String)localObject3, false);
      }
      this.hDn.remove(localObject3);
      break label454;
      ((Cursor)localObject4).close();
      localObject1 = localLinkedList2.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        localObject3 = new xc();
        localObject4 = new LinkedList();
        ((LinkedList)localObject4).add(((Pair)localObject2).first);
        ((xc)localObject3).thh = ((LinkedList)localObject4);
        ((xc)localObject3).tCc = ((LinkedList)localObject4).size();
        ((xc)localObject3).tCh = 1;
        ((xc)localObject3).tCi = ((avu)((Pair)localObject2).second);
        this.hDo.add(localObject3);
      }
      localLinkedList2.clear();
      i = 0;
      while (i < localLinkedList1.size())
      {
        localObject1 = (String)localLinkedList1.get(i);
        boolean bool = o.dH((String)localObject1);
        v.w("MicroMsg.GetContactService", "getFromDb try getContact Too much usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool) });
        if (bool) {
          d.Gt().jm((String)localObject1);
        }
        i += 1;
      }
      GMTrace.o(4092701179904L, 30493);
      return;
      label938:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private static boolean ab(String paramString1, String paramString2)
  {
    GMTrace.i(4092566962176L, 30492);
    if (bf.mA(paramString1))
    {
      GMTrace.o(4092566962176L, 30492);
      return false;
    }
    Object localObject = m.xL();
    String str = m.xM();
    if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
    {
      v.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      GMTrace.o(4092566962176L, 30492);
      return false;
    }
    localObject = new a();
    ((a)localObject).username = paramString1;
    ((a)localObject).hnn = bf.mz(paramString2);
    ((a)localObject).hDk = bf.NA();
    boolean bool = d.Gt().a((a)localObject);
    GMTrace.o(4092566962176L, 30492);
    return bool;
  }
  
  public final void J(String paramString1, String paramString2)
  {
    GMTrace.i(4092298526720L, 30490);
    v.i("MicroMsg.GetContactService", "dkverify add Contact :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bf.bJP());
    if (ab(paramString1, paramString2)) {
      this.hDt.v(500L, 500L);
    }
    GMTrace.o(4092298526720L, 30490);
  }
  
  public final void K(String paramString1, String paramString2)
  {
    boolean bool = false;
    GMTrace.i(15353434341376L, 114392);
    if (bf.mA(paramString1)) {}
    for (;;)
    {
      if (bool) {
        this.hDt.v(500L, 500L);
      }
      GMTrace.o(15353434341376L, 114392);
      return;
      Object localObject = m.xL();
      String str = m.xM();
      if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
      {
        v.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      }
      else
      {
        localObject = new a();
        ((a)localObject).username = paramString1;
        ((a)localObject).hno = bf.mz(paramString2);
        ((a)localObject).hBg = bf.f(Integer.valueOf(1));
        ((a)localObject).hDk = bf.NA();
        bool = d.Gt().a((a)localObject);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, ag.b.a parama)
  {
    GMTrace.i(4092432744448L, 30491);
    v.i("MicroMsg.GetContactService", "dkverify getNow :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bf.bJP());
    if (ab(paramString1, paramString2))
    {
      this.hDn.put(paramString1, parama);
      this.hDt.v(0L, 0L);
    }
    GMTrace.o(4092432744448L, 30491);
  }
  
  public final void gc(String paramString)
  {
    GMTrace.i(4092164308992L, 30489);
    this.hDn.remove(paramString);
    GMTrace.o(4092164308992L, 30489);
  }
  
  public final void pq()
  {
    for (;;)
    {
      long l;
      try
      {
        GMTrace.i(4092835397632L, 30494);
        if (com.tencent.mm.plugin.subapp.b.imc.oB())
        {
          v.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
          GMTrace.o(4092835397632L, 30494);
          return;
        }
        l = bf.NA();
        if ((this.hqr) && (l - this.hqC > 600000L))
        {
          v.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l - this.hqC) });
          this.hqr = false;
        }
        if (this.hqr)
        {
          v.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.hqr + " ret");
          GMTrace.o(4092835397632L, 30494);
          continue;
        }
        localObject3 = (xc)this.hDo.poll();
      }
      finally {}
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        Gr();
        localObject3 = (xc)this.hDo.poll();
        if ((localObject3 != null) && (((xc)localObject3).thh != null))
        {
          localObject2 = localObject3;
          if (((xc)localObject3).thh.size() != 0) {}
        }
        else
        {
          v.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
          GMTrace.o(4092835397632L, 30494);
          continue;
        }
      }
      this.hqC = l;
      this.hqr = true;
      Object localObject3 = new b.a();
      ((b.a)localObject3).hrV = ((com.tencent.mm.bd.a)localObject2);
      ((b.a)localObject3).hrW = new xd();
      ((b.a)localObject3).uri = "/cgi-bin/micromsg-bin/getcontact";
      ((b.a)localObject3).hrU = 182;
      u.a(((b.a)localObject3).BE(), new u.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.b paramAnonymousb, k paramAnonymousk)
        {
          GMTrace.i(4093103833088L, 30496);
          if (paramAnonymousk.getType() != 182)
          {
            GMTrace.o(4093103833088L, 30496);
            return 0;
          }
          c.this.hqr = false;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            v.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " will retry");
            c.this.hDt.v(10000L, 10000L);
            GMTrace.o(4093103833088L, 30496);
            return 0;
          }
          if ((!c.this.hDo.isEmpty()) && (c.this.hDt.bJg())) {
            c.this.hDt.v(500L, 500L);
          }
          if (paramAnonymousb != null)
          {
            paramAnonymousk = new c.a(c.this);
            paramAnonymousk.errType = paramAnonymousInt1;
            paramAnonymousk.errCode = paramAnonymousInt2;
            paramAnonymousk.fOW = paramAnonymousString;
            paramAnonymousk.hDB = ((xd)paramAnonymousb.hrT.hsa);
            c.this.hDp.add(paramAnonymousk);
          }
          if ((!c.this.hDp.isEmpty()) && (c.this.hDu.bJg())) {
            c.this.hDu.v(50L, 50L);
          }
          GMTrace.o(4093103833088L, 30496);
          return 0;
        }
      }, true);
      GMTrace.o(4092835397632L, 30494);
    }
  }
  
  final class a
  {
    int errCode;
    int errType;
    String fOW;
    xd hDB;
    int hDC;
    
    a()
    {
      GMTrace.i(4091895873536L, 30487);
      this.hDC = 0;
      GMTrace.o(4091895873536L, 30487);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ae/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */