package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class am
{
  public static final class a
    implements com.tencent.mm.y.e
  {
    public static int fBh;
    Queue<Long> fAZ;
    Queue<Long> fBa;
    Map<Long, g.a> fBb;
    public boolean fBc;
    public boolean fBd;
    public boolean fBe;
    public int fBf;
    public long fBg;
    g.a fBj;
    public ai fBk;
    public HashMap<Long, String> sCD;
    
    static
    {
      GMTrace.i(801279836160L, 5970);
      fBh = 0;
      GMTrace.o(801279836160L, 5970);
    }
    
    public a()
    {
      GMTrace.i(797790175232L, 5944);
      this.sCD = new HashMap();
      this.fAZ = new LinkedList();
      this.fBa = new LinkedList();
      this.fBb = new HashMap();
      this.fBc = false;
      this.fBd = false;
      this.fBe = false;
      this.fBf = 0;
      this.fBg = 0L;
      this.fBj = new g.a();
      this.fBk = new ai(ap.vL().nIe.getLooper(), new ai.a()
      {
        public final boolean oQ()
        {
          GMTrace.i(796179562496L, 5932);
          am.a.this.pq();
          GMTrace.o(796179562496L, 5932);
          return false;
        }
        
        public final String toString()
        {
          GMTrace.i(796313780224L, 5933);
          String str = super.toString() + "|scenePusher";
          GMTrace.o(796313780224L, 5933);
          return str;
        }
      }, false);
      ap.vd().a(220, this);
      ap.vd().a(221, this);
      ap.vd().a(222, this);
      GMTrace.o(797790175232L, 5944);
    }
    
    private boolean bCZ()
    {
      GMTrace.i(17854044831744L, 133023);
      for (;;)
      {
        try
        {
          localObject2 = an.abF().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
          if (localObject2 != null) {
            continue;
          }
          localArrayList = null;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          ArrayList localArrayList;
          int j;
          int i;
          v.printErrStackTrace("MicroMsg.SceneAppMsg", localIllegalStateException, "", new Object[0]);
          Object localObject1 = an.abF();
          Object localObject2 = " update appattach set status = 198 , lastModifyTime = " + bf.Nz() + " where status = 101";
          ((c)localObject1).gUp.eE("appattach", (String)localObject2);
          ((c)localObject1).doNotify();
          localObject1 = null;
          continue;
          long l = System.currentTimeMillis() / 1000L;
          localObject2 = bf.ev(l);
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          b localb = (b)((Iterator)localObject1).next();
          if (!this.fBb.containsKey(Long.valueOf(localb.uvp))) {
            continue;
          }
          v.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + localb.uvp);
          continue;
          v.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + localb.field_fileFullPath + " status:" + localb.field_status + " create:(" + bf.ev(localb.field_createTime) + "," + bf.ev(localb.field_createTime / 1000L) + ", last:" + bf.ev(localb.field_lastModifyTime) + " now:" + bf.ev(l) + " " + (l - localb.field_lastModifyTime));
          if (!localb.field_isUpload) {
            continue;
          }
          if ((l - localb.field_lastModifyTime <= 600L) || (localb.field_status != 101L)) {
            continue;
          }
          v.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + localb.field_fileFullPath + " last:" + bf.ev(localb.field_lastModifyTime) + " now:" + (String)localObject2);
          l.ee(localb.uvp);
          continue;
          this.fAZ.offer(Long.valueOf(localb.uvp));
          this.fBb.put(Long.valueOf(localb.uvp), null);
          continue;
          v.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.fBb.size() + " [recv:" + this.fBa.size() + ",send:" + this.fAZ.size() + "]");
          if (this.fBa.size() + this.fAZ.size() != 0) {
            continue;
          }
          GMTrace.o(17854044831744L, 133023);
          return false;
          GMTrace.o(17854044831744L, 133023);
        }
        if ((localArrayList != null) && (localArrayList.size() != 0)) {
          continue;
        }
        GMTrace.o(17854044831744L, 133023);
        return false;
        j = ((Cursor)localObject2).getCount();
        v.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:" + j);
        if (j == 0)
        {
          ((Cursor)localObject2).close();
          localArrayList = null;
        }
        else
        {
          localArrayList = new ArrayList();
          i = 0;
          if (i < j)
          {
            ((Cursor)localObject2).moveToPosition(i);
            localb = new b();
            localb.b((Cursor)localObject2);
            localArrayList.add(localb);
            i += 1;
          }
          else
          {
            ((Cursor)localObject2).close();
          }
        }
      }
      return true;
    }
    
    public static void c(long paramLong, String paramString1, String paramString2)
    {
      GMTrace.i(798461263872L, 5949);
      ap.vd().a(new ah(paramLong, paramString1, paramString2), 0);
      GMTrace.o(798461263872L, 5949);
    }
    
    public static void eg(long paramLong)
    {
      GMTrace.i(798192828416L, 5947);
      ap.vd().a(new ah(paramLong, null, null), 0);
      GMTrace.o(798192828416L, 5947);
    }
    
    public static void t(long paramLong, String paramString)
    {
      GMTrace.i(798327046144L, 5948);
      ap.vd().a(new ah(paramLong, paramString, null), 0);
      GMTrace.o(798327046144L, 5948);
    }
    
    public final void a(final int paramInt1, final int paramInt2, String paramString, final k paramk)
    {
      GMTrace.i(798595481600L, 5950);
      v.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[] { Integer.valueOf(paramk.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(829465559040L, 6180);
          am.a.fBh += 1;
          long l1;
          int i;
          long l2;
          Object localObject1;
          if (paramk.getType() == 222)
          {
            v.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + paramInt1 + " errCode:" + paramInt2);
            l1 = -1L;
            i = 0;
            long l3 = 0L;
            l2 = l3;
            if (l1 != -1L)
            {
              l2 = l3;
              if (am.a.this.fBb.get(Long.valueOf(l1)) != null)
              {
                l2 = ((g.a)am.a.this.fBb.get(Long.valueOf(l1))).se();
                am.a.this.fBb.remove(Long.valueOf(l1));
              }
            }
            v.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + paramk.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " rowid:" + l1 + " time:" + l2);
            if ((paramInt1 != 3) || (i == 0)) {
              break label699;
            }
            localObject1 = am.a.this;
            ((am.a)localObject1).fBf -= 1;
            label260:
            v.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + am.a.fBh + " stop:" + am.a.this.fBf + " running:" + am.a.this.fBe + " recving:" + am.a.this.fBc + " sending:" + am.a.this.fBd);
            if (am.a.this.fBf <= 0) {
              break label717;
            }
            am.a.this.pq();
          }
          for (;;)
          {
            am.a.fBh -= 1;
            GMTrace.o(829465559040L, 6180);
            return;
            if (paramk.getType() == 221)
            {
              am.a.this.fBc = false;
              l1 = ((ab)paramk).sCc;
              i = ((ab)paramk).fEO;
              break;
            }
            if (paramk.getType() == 220)
            {
              am.a.this.fBd = false;
              l2 = ((ak)paramk).sCc;
              int j = ((ak)paramk).fEO;
              localObject1 = (ak)paramk;
              label488:
              Object localObject2;
              if (((ak)localObject1).sBZ == null)
              {
                localObject1 = null;
                localObject2 = (ak)paramk;
                if (((ak)localObject2).sBZ != null) {
                  break label637;
                }
                l1 = 0L;
                label507:
                localObject2 = (String)am.a.this.sCD.remove(Long.valueOf(l1));
                if (bf.mA(((ak)paramk).hGf)) {
                  break label649;
                }
              }
              label637:
              label649:
              for (i = 1;; i = 0)
              {
                if ((i == 0) && (!bf.mA((String)localObject1)))
                {
                  b localb = new b();
                  an.abF().b(l2, localb);
                  if (localb.uvp == l2)
                  {
                    l.a(localb.field_msgInfoId, (String)localObject1, null);
                    v.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                    am.a.t(localb.field_msgInfoId, (String)localObject2);
                  }
                }
                i = j;
                l1 = l2;
                break;
                localObject1 = ((ak)localObject1).sBZ.field_mediaSvrId;
                break label488;
                l1 = ((ak)localObject2).sBZ.field_msgInfoId;
                break label507;
              }
            }
            v.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + paramk.getType());
            am.a.fBh -= 1;
            GMTrace.o(829465559040L, 6180);
            return;
            label699:
            if (paramInt1 == 0) {
              break label260;
            }
            am.a.this.fBf = 0;
            break label260;
            label717:
            if ((!am.a.this.fBd) && (!am.a.this.fBc)) {
              am.a.this.pr();
            }
          }
        }
        
        public final String toString()
        {
          GMTrace.i(829599776768L, 6181);
          String str = super.toString() + "|onSceneEnd";
          GMTrace.o(829599776768L, 6181);
          return str;
        }
      });
      GMTrace.o(798595481600L, 5950);
    }
    
    protected final void finalize()
    {
      GMTrace.i(797924392960L, 5945);
      ap.vd().b(220, this);
      ap.vd().b(221, this);
      ap.vd().b(222, this);
      this.sCD.clear();
      super.finalize();
      GMTrace.o(797924392960L, 5945);
    }
    
    public final void pq()
    {
      GMTrace.i(16011503861760L, 119295);
      v.d("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene recving[%b][%d], sending[%b][%d]", new Object[] { Boolean.valueOf(this.fBc), Integer.valueOf(this.fBa.size()), Boolean.valueOf(this.fBd), Integer.valueOf(this.fAZ.size()) });
      this.fBg = System.currentTimeMillis();
      if (((!this.fBc) && (this.fBa.size() == 0)) || ((!this.fBd) && (this.fAZ.size() == 0))) {
        bCZ();
      }
      if ((!this.fBc) && (this.fBa.size() == 0) && (!this.fBd) && (this.fAZ.size() == 0))
      {
        pr();
        v.d("MicroMsg.SceneAppMsg", "summerbig No Data Any More , Stop Service");
        GMTrace.o(16011503861760L, 119295);
        return;
      }
      long l;
      b localb;
      Object localObject;
      if ((!this.fBd) && (this.fAZ.size() > 0))
      {
        l = bf.a((Long)this.fAZ.poll(), -1L);
        v.i("MicroMsg.SceneAppMsg", "summerbig Start Send :" + l);
        if (l != -1L)
        {
          this.fBb.put(Long.valueOf(l), new g.a());
          this.fBd = true;
          localb = new b();
          if (!an.abF().b(l, localb))
          {
            v.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, getAttachInfo fail, infoId = " + l);
            ap.yY();
            localObject = com.tencent.mm.u.c.wT().cA(localb.field_msgInfoId);
            ((au)localObject).dv(5);
            ap.yY();
            com.tencent.mm.u.c.wT().a(((ce)localObject).field_msgId, (au)localObject);
            this.fBd = false;
            GMTrace.o(16011503861760L, 119295);
            return;
          }
          if (localb.field_type != 8L) {
            break label591;
          }
          ap.yY();
          localObject = com.tencent.mm.u.c.wT().cA(localb.field_msgInfoId);
          if (((ce)localObject).field_msgId == 0L)
          {
            v.e("MicroMsg.SceneAppMsg", "getEmoticonMd5 fail, msg is null :" + localb.field_msgInfoId);
            localObject = null;
          }
          while (localObject == null)
          {
            v.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, send emoji, emoticonMd5 can not be null");
            ap.yY();
            localObject = com.tencent.mm.u.c.wT().cA(localb.field_msgInfoId);
            ((au)localObject).dv(5);
            ap.yY();
            com.tencent.mm.u.c.wT().a(((ce)localObject).field_msgId, (au)localObject);
            this.fBd = false;
            GMTrace.o(16011503861760L, 119295);
            return;
            f.a locala = f.a.ek(((ce)localObject).field_content);
            if (locala != null) {
              localObject = locala.hhi;
            } else {
              localObject = aj.RC(((ce)localObject).field_content).fFN;
            }
          }
        }
      }
      for (;;)
      {
        localObject = new ak(l, (String)localObject, (String)this.sCD.get(Long.valueOf(localb.field_msgInfoId)));
        ap.vd().a((k)localObject, 0);
        GMTrace.o(16011503861760L, 119295);
        return;
        label591:
        localObject = null;
      }
    }
    
    public final void pr()
    {
      GMTrace.i(798729699328L, 5951);
      this.fBb.clear();
      this.fAZ.clear();
      this.fBa.clear();
      this.fBd = false;
      this.fBc = false;
      this.fBe = false;
      v.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.fBj.se());
      GMTrace.o(798729699328L, 5951);
    }
    
    public final void run()
    {
      GMTrace.i(798863917056L, 5952);
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(820875624448L, 6116);
          long l = System.currentTimeMillis() - am.a.this.fBg;
          v.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + am.a.this.fBe + " timeWait:" + l + " sending:" + am.a.this.fBd + " recving:" + am.a.this.fBc);
          if (am.a.this.fBe)
          {
            if (l < 180000L)
            {
              GMTrace.o(820875624448L, 6116);
              return;
            }
            v.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + am.a.this.fBe + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + am.a.this.fBd + " recving:" + am.a.this.fBc);
          }
          am.a.this.fBe = true;
          am.a.this.fBd = false;
          am.a.this.fBf = 4;
          am.a.this.fBc = false;
          am.a.this.fBj.gSE = SystemClock.elapsedRealtime();
          am.a.this.fBk.v(10L, 10L);
          GMTrace.o(820875624448L, 6116);
        }
        
        public final String toString()
        {
          GMTrace.i(821009842176L, 6117);
          String str = super.toString() + "|run";
          GMTrace.o(821009842176L, 6117);
          return str;
        }
      });
      GMTrace.o(798863917056L, 5952);
    }
    
    public final void s(long paramLong, String paramString)
    {
      GMTrace.i(798058610688L, 5946);
      this.sCD.put(Long.valueOf(paramLong), paramString);
      GMTrace.o(798058610688L, 5946);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */