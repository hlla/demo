package com.tencent.mm.ah;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class h
  implements e, com.tencent.mm.y.f
{
  public static Set<Integer> hFQ;
  private Queue<d> fAZ;
  public boolean fBd;
  public boolean fBe;
  public int fBf;
  public long fBg;
  g.a fBj;
  public ai fBk;
  public LinkedList<k> hFR;
  public a hFS;
  public boolean hFT;
  private k.a hFU;
  
  static
  {
    GMTrace.i(3548314075136L, 26437);
    hFQ = new HashSet();
    GMTrace.o(3548314075136L, 26437);
  }
  
  public h()
  {
    GMTrace.i(3545361285120L, 26415);
    this.hFR = new LinkedList();
    this.hFS = null;
    this.hFT = false;
    this.hFU = new k.a()
    {
      public final void GG()
      {
        GMTrace.i(3530194681856L, 26302);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(3541334753280L, 26385);
            v.i("MicroMsg.ImgService", "on image upload end. queue size : " + h.this.hFR.size());
            h.this.hFT = false;
            if (h.this.hFR.size() > 0)
            {
              k localk = (k)h.this.hFR.poll();
              v.i("MicroMsg.ImgService", "upload image scene hashcode : " + localk.hashCode());
              com.tencent.mm.kernel.h.vH().gXs.a(localk, 0);
              h.this.hFT = true;
            }
            GMTrace.o(3541334753280L, 26385);
          }
        });
        GMTrace.o(3530194681856L, 26302);
      }
    };
    this.fAZ = new LinkedList();
    this.fBe = false;
    this.fBf = 0;
    this.fBg = 0L;
    this.fBd = false;
    this.fBj = new g.a();
    com.tencent.mm.kernel.h.vJ();
    this.fBk = new ai(com.tencent.mm.kernel.h.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(3512075288576L, 26167);
        try
        {
          h.this.pq();
          GMTrace.o(3512075288576L, 26167);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.e("MicroMsg.ImgService", "exception:%s", new Object[] { bf.g(localException) });
          }
        }
      }
      
      public final String toString()
      {
        GMTrace.i(3512209506304L, 26168);
        String str = super.toString() + "|scenePusher";
        GMTrace.o(3512209506304L, 26168);
        return str;
      }
    }, false);
    if (com.tencent.mm.kernel.h.vH().gXs != null) {
      com.tencent.mm.kernel.h.vH().gXs.a(110, this);
    }
    this.hFR.clear();
    this.hFT = false;
    GMTrace.o(3545361285120L, 26415);
  }
  
  private void a(final k paramk)
  {
    GMTrace.i(3545763938304L, 26418);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3530463117312L, 26304);
        v.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", new Object[] { Boolean.valueOf(h.this.hFT), Integer.valueOf(paramk.hashCode()) });
        if (h.this.hFT)
        {
          h.this.hFR.offer(paramk);
          GMTrace.o(3530463117312L, 26304);
          return;
        }
        com.tencent.mm.kernel.h.vH().gXs.a(paramk, 0);
        h.this.hFT = true;
        GMTrace.o(3530463117312L, 26304);
      }
    });
    GMTrace.o(3545763938304L, 26418);
  }
  
  public static boolean fV(int paramInt)
  {
    GMTrace.i(3545092849664L, 26413);
    boolean bool = hFQ.add(Integer.valueOf(paramInt));
    GMTrace.o(3545092849664L, 26413);
    return bool;
  }
  
  public static boolean fW(int paramInt)
  {
    GMTrace.i(3545227067392L, 26414);
    boolean bool = hFQ.remove(Integer.valueOf(paramInt));
    GMTrace.o(3545227067392L, 26414);
    return bool;
  }
  
  public static void fX(int paramInt)
  {
    GMTrace.i(3545898156032L, 26419);
    v.w("MicroMsg.ImgService", "setImgError, %d", new Object[] { Integer.valueOf(paramInt) });
    d locald = n.GT().fT(paramInt);
    if ((locald == null) || (locald.hEG <= 0L))
    {
      GMTrace.o(3545898156032L, 26419);
      return;
    }
    Object localObject = n.GT().fU((int)locald.hEG);
    if (localObject != null)
    {
      ((d)localObject).dv(-1);
      ((d)localObject).fRM = 264;
      n.GT().a((int)((d)localObject).hEG, (d)localObject);
    }
    for (localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(((d)localObject).hEO); ((ce)localObject).field_msgId != locald.hEO; localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(locald.hEO))
    {
      GMTrace.o(3545898156032L, 26419);
      return;
      locald.dv(-1);
      locald.fRM = 264;
      n.GT().a(paramInt, locald);
    }
    ((au)localObject).dv(5);
    com.tencent.mm.plugin.report.c.oRz.a(111L, 31L, 1L, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a((int)((ce)localObject).field_msgId, (au)localObject);
    GMTrace.o(3545898156032L, 26419);
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(3546435026944L, 26423);
    paramk = (k)paramk;
    if ((this.hFS != null) && (paramk != null) && (paramk.fCQ != null)) {
      this.hFS.a(paramk.fCQ.field_msgId, paramInt1, paramInt2);
    }
    GMTrace.o(3546435026944L, 26423);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.y.k paramk)
  {
    GMTrace.i(3546032373760L, 26420);
    v.d("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala;
    long l;
    if ((paramk instanceof k))
    {
      paramString = (k)paramk;
      if ((this.hFS != null) && (paramString != null) && (paramString.fCQ != null))
      {
        locala = this.hFS;
        l = paramString.fCQ.field_msgId;
        if (paramString.fCQ.field_status == 5) {
          break label142;
        }
      }
    }
    label142:
    for (boolean bool = true;; bool = false)
    {
      locala.b(l, bool);
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(3544824414208L, 26411);
          if (paramk.getType() != 110)
          {
            GMTrace.o(3544824414208L, 26411);
            return;
          }
          if (!(paramk instanceof k))
          {
            GMTrace.o(3544824414208L, 26411);
            return;
          }
          h.this.fBd = false;
          int i = (int)((k)paramk).hGc;
          h.hFQ.remove(Integer.valueOf(i));
          if (h.this.fBf > 0)
          {
            h.this.pq();
            GMTrace.o(3544824414208L, 26411);
            return;
          }
          h.this.pr();
          GMTrace.o(3544824414208L, 26411);
        }
        
        public final String toString()
        {
          GMTrace.i(3544958631936L, 26412);
          String str = super.toString() + "|onSceneEnd";
          GMTrace.o(3544958631936L, 26412);
          return str;
        }
      });
      GMTrace.o(3546032373760L, 26420);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    GMTrace.i(3545495502848L, 26416);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (m.a(str, paramString2, paramBoolean)) {}
      for (int i = 1;; i = 0)
      {
        v.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
        a(new k(3, paramString1, paramString2, str, i, this, paramInt1, this.hFU, paramInt2));
        break;
      }
    }
    GMTrace.o(3545495502848L, 26416);
  }
  
  public final void a(ArrayList<Integer> paramArrayList, String paramString1, String paramString2, ArrayList<String> paramArrayList1, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    GMTrace.i(3545629720576L, 26417);
    Iterator localIterator = paramArrayList1.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int k = ((Integer)paramArrayList.get(i)).intValue();
      if (m.a(str, paramString2, paramBoolean)) {}
      for (int j = 1;; j = 0)
      {
        paramArrayList1 = "";
        d locald = n.GT().fT(k);
        if (locald != null) {
          paramArrayList1 = locald.hER;
        }
        paramArrayList1 = new k(k, 3, paramString1, paramString2, str, j, this, paramInt1, paramArrayList1, "", paramInt2);
        paramArrayList1.hGz = new k.b(paramArrayList1, this.hFU);
        a(paramArrayList1);
        i += 1;
        break;
      }
    }
    GMTrace.o(3545629720576L, 26417);
  }
  
  public final void pq()
  {
    GMTrace.i(16021704409088L, 119371);
    this.fBg = System.currentTimeMillis();
    Object localObject2;
    Object localObject3;
    int j;
    if ((!this.fBd) && (this.fAZ.size() == 0))
    {
      localObject2 = n.GT();
      localObject1 = "select * " + " FROM ImgInfo2";
      localObject1 = (String)localObject1 + " WHERE iscomplete= 0 AND totalLen != 0 ";
      localObject3 = ((f)localObject2).hnp.a((String)localObject1, null, 0);
      j = ((Cursor)localObject3).getCount();
      v.d("MicroMsg.ImgInfoStorage", "getUnfinishInfo resCount:" + j);
      if (j != 0) {
        break label203;
      }
      ((Cursor)localObject3).close();
      localObject1 = null;
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label339;
      }
      v.i("MicroMsg.ImgService", "get need run info by search db, but size is 0.");
    }
    label203:
    int i;
    for (;;)
    {
      if ((this.fBd) || (this.fAZ.size() > 0)) {
        break label626;
      }
      pr();
      v.d("MicroMsg.ImgService", "No Data Any More , Stop Service");
      GMTrace.o(16021704409088L, 119371);
      return;
      localObject1 = new ArrayList();
      i = 0;
      if (i < j)
      {
        ((Cursor)localObject3).moveToPosition(i);
        d locald1 = new d();
        locald1.b((Cursor)localObject3);
        d locald2 = ((f)localObject2).fU((int)locald1.hEG);
        if (locald2 != null) {
          if ((locald2.fTG != 0L) || (locald2.hEO != 0L)) {
            ((List)localObject1).add(locald1);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((locald1.fTG != 0L) || (locald1.hEO != 0L)) {
            ((List)localObject1).add(locald1);
          }
        }
      }
      ((Cursor)localObject3).close();
      break;
      label339:
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        if (bf.mA(((d)localObject2).hEH))
        {
          v.i("MicroMsg.ImgService", "the process is killed while selecting pic");
        }
        else
        {
          localObject3 = n.GT().fU((int)((d)localObject2).hEG);
          if (localObject3 == null) {}
          for (i = (int)((d)localObject2).hEG;; i = (int)((d)localObject3).hEG)
          {
            if (!hFQ.contains(Integer.valueOf(i))) {
              break label468;
            }
            v.d("MicroMsg.ImgService", "File is Already running:" + ((d)localObject2).hEG);
            break;
          }
          label468:
          if (localObject3 != null)
          {
            if ((((d)localObject3).hEO <= 0L) || (((d)localObject3).fTG > 0L) || (((d)localObject2).offset > ((d)localObject2).hrb) || (((d)localObject2).status == -1) || (((d)localObject3).status == -1)) {}
          }
          else
          {
            for (;;)
            {
              if (((d)localObject2).hEN + 600 >= bf.Nz()) {
                break label598;
              }
              fX((int)((d)localObject2).hEG);
              break;
              if ((((d)localObject2).hEO <= 0L) || (((d)localObject2).fTG > 0L) || (((d)localObject2).offset > ((d)localObject2).hrb) || (((d)localObject2).status == -1)) {
                break;
              }
            }
            label598:
            this.fAZ.add(localObject2);
          }
        }
      }
      this.fAZ.size();
    }
    label626:
    Object localObject1 = null;
    if ((!this.fBd) && (this.fAZ.size() > 0))
    {
      label724:
      while (this.fAZ.size() > 0)
      {
        localObject1 = (d)this.fAZ.poll();
        localObject2 = n.GT().fU((int)((d)localObject1).hEG);
        if (localObject2 == null) {}
        for (i = (int)((d)localObject1).hEG;; i = (int)((d)localObject2).hEG)
        {
          if (!hFQ.contains(Integer.valueOf(i))) {
            break label724;
          }
          localObject1 = null;
          break;
        }
      }
      this.fBd = true;
      if ((localObject1 != null) && (((d)localObject1).hEG > 0L))
      {
        localObject2 = n.GT().fU((int)((d)localObject1).hEG);
        if (localObject2 == null) {
          break label807;
        }
        v.d("MicroMsg.ImgService", "try upload hdinfo ");
      }
    }
    for (localObject1 = new k((int)((d)localObject2).hEG, 1);; localObject1 = new k((int)((d)localObject1).hEG, 0))
    {
      com.tencent.mm.kernel.h.vH().gXs.a((com.tencent.mm.y.k)localObject1, 0);
      GMTrace.o(16021704409088L, 119371);
      return;
      label807:
      v.d("MicroMsg.ImgService", "try upload normalinfo ");
    }
  }
  
  public final void pr()
  {
    GMTrace.i(3546166591488L, 26421);
    this.fAZ.clear();
    this.fBe = false;
    v.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.fBj.se());
    GMTrace.o(3546166591488L, 26421);
  }
  
  public final void run()
  {
    GMTrace.i(3546300809216L, 26422);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3544421761024L, 26408);
        long l = System.currentTimeMillis() - h.this.fBg;
        if (h.this.fBe)
        {
          if (l < 60000L)
          {
            GMTrace.o(3544421761024L, 26408);
            return;
          }
          v.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + h.this.fBe + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + h.this.fBe);
        }
        h.this.fBe = true;
        h.this.fBf = 3;
        h.this.fBj.gSE = SystemClock.elapsedRealtime();
        h.this.fBk.v(10L, 10L);
        GMTrace.o(3544421761024L, 26408);
      }
      
      public final String toString()
      {
        GMTrace.i(3544555978752L, 26409);
        String str = super.toString() + "|run";
        GMTrace.o(3544555978752L, 26409);
        return str;
      }
    });
    GMTrace.o(3546300809216L, 26422);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt1, int paramInt2);
    
    public abstract void b(long paramLong, boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */