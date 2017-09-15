package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class x
{
  public static String iay;
  
  static
  {
    GMTrace.i(331920441344L, 2473);
    iay = null;
    GMTrace.o(331920441344L, 2473);
  }
  
  public static final class a
    implements com.tencent.mm.y.e
  {
    public static int fBh;
    Queue<String> fAZ;
    Queue<String> fBa;
    Map<String, g.a> fBb;
    public boolean fBc;
    public boolean fBd;
    public boolean fBe;
    public int fBf;
    public long fBg;
    g.a fBj;
    public ai fBk;
    ad iaA;
    boolean iaB;
    public List<v> iaC;
    Queue<String> iaD;
    Queue<String> iaE;
    public d iaF;
    public g iaG;
    HandlerThread iaz;
    
    static
    {
      GMTrace.i(344671125504L, 2568);
      fBh = 0;
      GMTrace.o(344671125504L, 2568);
    }
    
    public a()
    {
      GMTrace.i(341584117760L, 2545);
      this.iaz = com.tencent.mm.sdk.f.e.cE("VideoService_runThread", 0);
      this.iaB = false;
      this.fBk = null;
      this.iaC = new ArrayList();
      this.fAZ = new LinkedList();
      this.fBa = new LinkedList();
      this.iaD = new LinkedList();
      this.iaE = new LinkedList();
      this.fBb = new HashMap();
      this.fBc = false;
      this.fBd = false;
      this.fBe = false;
      this.fBf = 0;
      this.fBg = 0L;
      this.iaF = null;
      this.iaG = null;
      this.fBj = new g.a();
      com.tencent.mm.kernel.h.vd().a(149, this);
      com.tencent.mm.kernel.h.vd().a(150, this);
      this.iaz.start();
      this.iaB = true;
      this.iaA = new ad(this.iaz.getLooper());
      this.fBk = new ai(this.iaz.getLooper(), new ai.a()
      {
        public final boolean oQ()
        {
          GMTrace.i(350710923264L, 2613);
          x.a.this.pq();
          GMTrace.o(350710923264L, 2613);
          return false;
        }
        
        public final String toString()
        {
          GMTrace.i(350845140992L, 2614);
          String str = super.toString() + "|scenePusher";
          GMTrace.o(350845140992L, 2614);
          return str;
        }
      }, false);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.VideoService", "create VideoService, start video send thread");
      GMTrace.o(341584117760L, 2545);
    }
    
    public final boolean Lu()
    {
      GMTrace.i(342120988672L, 2549);
      boolean bool;
      if (this.iaF != null)
      {
        bool = this.iaF.pd();
        this.fBe = false;
      }
      for (;;)
      {
        this.fBb.clear();
        this.fAZ.clear();
        this.fBa.clear();
        this.iaD.clear();
        this.iaE.clear();
        GMTrace.o(342120988672L, 2549);
        return bool;
        bool = false;
      }
    }
    
    public final void a(final int paramInt1, final int paramInt2, String paramString, final k paramk)
    {
      GMTrace.i(341718335488L, 2546);
      if ((this.iaz == null) || (!this.iaB) || (this.iaA == null))
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
        GMTrace.o(341718335488L, 2546);
        return;
      }
      this.iaA.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(326551732224L, 2433);
          x.a.fBh += 1;
          Object localObject;
          int i;
          if (paramk.getType() == 150)
          {
            x.a.this.fBc = false;
            localObject = ((d)paramk).fyw;
            x.iay = (String)localObject;
            i = ((d)paramk).fEO;
            x.a.this.iaF = null;
          }
          for (;;)
          {
            long l2 = 0L;
            long l1 = l2;
            if (localObject != null)
            {
              l1 = l2;
              if (x.a.this.fBb.get(localObject) != null)
              {
                l1 = ((g.a)x.a.this.fBb.get(localObject)).se();
                x.a.this.fBb.remove(localObject);
              }
            }
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + paramk.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + (String)localObject + " time:" + l1);
            if ((paramInt1 == 3) && (i != 0))
            {
              localObject = x.a.this;
              ((x.a)localObject).fBf -= 1;
              label250:
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + x.a.fBh + " stop:" + x.a.this.fBf + " running:" + x.a.this.fBe + " recving:" + x.a.this.fBc + " sending:" + x.a.this.fBd);
              if (x.a.this.fBf <= 0) {
                break label523;
              }
              x.a.this.pq();
            }
            for (;;)
            {
              x.a.fBh -= 1;
              GMTrace.o(326551732224L, 2433);
              return;
              if (paramk.getType() == 149)
              {
                x.a.this.fBd = false;
                x.a.this.iaG = null;
                if ((paramk instanceof g))
                {
                  localObject = ((g)paramk).fyw;
                  i = ((g)paramk).fEO;
                  break;
                }
                if (!(paramk instanceof h)) {
                  break label553;
                }
                localObject = ((h)paramk).fyw;
                i = 0;
                break;
              }
              com.tencent.mm.sdk.platformtools.v.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + paramk.getType());
              x.a.fBh -= 1;
              GMTrace.o(326551732224L, 2433);
              return;
              if (paramInt1 == 0) {
                break label250;
              }
              x.a.this.fBf = 0;
              break label250;
              label523:
              if ((!x.a.this.fBd) && (!x.a.this.fBc)) {
                x.a.this.pr();
              }
            }
            label553:
            localObject = null;
            i = 0;
          }
        }
        
        public final String toString()
        {
          GMTrace.i(326685949952L, 2434);
          String str = super.toString() + "|onSceneEnd";
          GMTrace.o(326685949952L, 2434);
          return str;
        }
      });
      GMTrace.o(341718335488L, 2546);
    }
    
    public final void pq()
    {
      GMTrace.i(16008551071744L, 119273);
      this.fBg = System.currentTimeMillis();
      Object localObject2;
      Object localObject1;
      if (((!this.fBc) && (this.fBa.size() + this.iaD.size() == 0)) || ((!this.fBd) && (this.fAZ.size() == 0)))
      {
        long l = bf.NB();
        Object localObject4 = o.KW().Ls();
        Object localObject3 = o.KW().Lp();
        localObject2 = o.KW().Lq();
        localObject1 = o.KW().Lr();
        if (localObject4 != null)
        {
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + ((List)localObject4).size());
          localObject4 = ((List)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            String str = (String)((Iterator)localObject4).next();
            if (this.fBb.containsKey(str))
            {
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "need sendList File is Already running:" + str);
            }
            else
            {
              this.fAZ.offer(str);
              this.fBb.put(str, null);
            }
          }
        }
        if (localObject3 != null)
        {
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + ((List)localObject3).size());
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            if (this.fBb.containsKey(localObject4))
            {
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "need recvList File is Already running:" + (String)localObject4);
            }
            else
            {
              this.fBa.offer(localObject4);
              this.fBb.put(localObject4, null);
            }
          }
        }
        if (localObject2 != null)
        {
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + ((List)localObject2).size());
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            if (this.fBb.containsKey(localObject3))
            {
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "online videoList File is Already running:" + (String)localObject3);
            }
            else
            {
              this.iaD.offer(localObject3);
              this.fBb.put(localObject3, null);
            }
          }
        }
        if (localObject1 != null)
        {
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "getNeedRunInfo hevc video list size: " + ((List)localObject1).size());
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (this.fBb.containsKey(localObject2))
            {
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "hevc videoList File is Already running:" + (String)localObject2);
            }
            else
            {
              this.iaE.offer(localObject2);
              this.fBb.put(localObject2, null);
            }
          }
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d hevc:%d]", new Object[] { Long.valueOf(bf.aB(l)), Integer.valueOf(this.fBb.size()), Integer.valueOf(this.fBa.size()), Integer.valueOf(this.iaD.size()), Integer.valueOf(this.fAZ.size()), Integer.valueOf(this.iaE.size()) });
        this.fBa.size();
        this.fAZ.size();
        this.iaD.size();
        this.iaE.size();
      }
      if ((this.iaE.size() == 0) || (!com.tencent.mm.modelcontrol.d.ED())) {}
      for (int i = 1; (!this.fBc) && (this.fBa.size() + this.iaD.size() == 0) && (i != 0) && (!this.fBd) && (this.fAZ.size() == 0); i = 0)
      {
        pr();
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "No Data Any More , Stop Service");
        GMTrace.o(16008551071744L, 119273);
        return;
      }
      boolean bool;
      if ((!this.fBc) && ((this.fBa.size() > 0) || (this.iaD.size() > 0) || (i == 0)))
      {
        if (this.iaD.size() > 0)
        {
          localObject1 = (String)this.iaD.poll();
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.VideoService", "Start Recv :" + (String)localObject1);
          if (!bf.mA((String)localObject1))
          {
            this.fBb.put(localObject1, new g.a());
            this.fBc = true;
            if (this.iaF != null) {
              break label1433;
            }
            bool = true;
            Assert.assertTrue("sceneDown should null", bool);
            this.iaF = new d((String)localObject1, true);
            com.tencent.mm.kernel.h.vd().a(this.iaF, 0);
          }
        }
        if ((!this.fBc) && (this.fBa.size() > 0))
        {
          localObject1 = (String)this.fBa.poll();
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.VideoService", "Start Recv :" + (String)localObject1);
          if (localObject1 != null)
          {
            this.fBb.put(localObject1, new g.a());
            this.fBc = true;
            if (this.iaF != null) {
              break label1439;
            }
            bool = true;
            label1117:
            Assert.assertTrue("sceneDown should null", bool);
            this.iaF = new d((String)localObject1);
            com.tencent.mm.kernel.h.vd().a(this.iaF, 0);
          }
        }
        if (!this.fBc)
        {
          localObject1 = (String)this.iaE.poll();
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.VideoService", "Start recv hecv: " + (String)localObject1);
          if (!bf.mA((String)localObject1))
          {
            this.fBb.put(localObject1, new g.a());
            this.fBc = true;
            if (this.iaF != null) {
              break label1445;
            }
            bool = true;
            label1236:
            Assert.assertTrue("sceneDown should null", bool);
            this.iaF = new d((String)localObject1, true);
            com.tencent.mm.kernel.h.vd().a(this.iaF, 0);
          }
        }
      }
      if ((!this.fBd) && (this.fAZ.size() > 0))
      {
        localObject1 = (String)this.fAZ.poll();
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.VideoService", "Start Send :" + (String)localObject1);
        if (localObject1 != null)
        {
          this.fBb.put(localObject1, new g.a());
          this.fBd = true;
          if (this.iaG == null) {}
          for (bool = true;; bool = false)
          {
            Assert.assertTrue("sceneUp should null", bool);
            if ((this.iaC == null) || (this.iaC.size() <= 0)) {
              break label1457;
            }
            localObject2 = this.iaC.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((v)((Iterator)localObject2).next()).lN((String)localObject1);
            }
            label1433:
            bool = false;
            break;
            label1439:
            bool = false;
            break label1117;
            label1445:
            bool = false;
            break label1236;
          }
          label1457:
          this.iaG = new g((String)localObject1);
          com.tencent.mm.kernel.h.vd().a(this.iaG, 0);
        }
      }
      GMTrace.o(16008551071744L, 119273);
    }
    
    public final void pr()
    {
      GMTrace.i(341852553216L, 2547);
      this.fBb.clear();
      this.fAZ.clear();
      this.fBa.clear();
      this.iaD.clear();
      this.iaE.clear();
      this.fBd = false;
      this.fBc = false;
      this.fBe = false;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.fBj.se());
      GMTrace.o(341852553216L, 2547);
    }
    
    public final void run()
    {
      GMTrace.i(341986770944L, 2548);
      if ((this.iaz == null) || (!this.iaB) || (this.iaA == null))
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
        GMTrace.o(341986770944L, 2548);
        return;
      }
      this.iaA.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(352053100544L, 2623);
          long l = System.currentTimeMillis() - x.a.this.fBg;
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VideoService", "Try Run service runningFlag:" + x.a.this.fBe + " timeWait:" + l + " sending:" + x.a.this.fBd + " recving:" + x.a.this.fBc);
          if (x.a.this.fBe)
          {
            if (l < 60000L)
            {
              GMTrace.o(352053100544L, 2623);
              return;
            }
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + x.a.this.fBe + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + x.a.this.fBd + " recving:" + x.a.this.fBc);
          }
          x.a.this.fBf = 3;
          x.a.this.fBe = true;
          x.a.this.fBd = false;
          x.a.this.fBc = false;
          x.a.this.iaG = null;
          x.a.this.iaF = null;
          x.a.this.fBj.gSE = SystemClock.elapsedRealtime();
          x.a.this.fBk.v(10L, 10L);
          GMTrace.o(352053100544L, 2623);
        }
        
        public final String toString()
        {
          GMTrace.i(352187318272L, 2624);
          String str = super.toString() + "|run";
          GMTrace.o(352187318272L, 2624);
          return str;
        }
      });
      GMTrace.o(341986770944L, 2548);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */