package com.tencent.mm.c.b;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class i
  implements com.tencent.mm.y.e
{
  public static int fBh;
  public static boolean fBi;
  Queue<String> fAZ;
  Queue<p> fBa;
  Map<String, g.a> fBb;
  public boolean fBc;
  public boolean fBd;
  public boolean fBe;
  public int fBf;
  public long fBg;
  g.a fBj;
  public ai fBk;
  
  static
  {
    GMTrace.i(4488106606592L, 33439);
    fBh = 0;
    fBi = true;
    GMTrace.o(4488106606592L, 33439);
  }
  
  public i()
  {
    GMTrace.i(4485422252032L, 33419);
    this.fAZ = new LinkedList();
    this.fBa = new LinkedList();
    this.fBb = new HashMap();
    this.fBc = false;
    this.fBd = false;
    this.fBe = false;
    this.fBf = 0;
    this.fBg = 0L;
    this.fBj = new g.a();
    this.fBk = new ai(com.tencent.mm.kernel.h.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(4482737897472L, 33399);
        v.d("MicroMsg.SceneVoiceService", "onTimerExpired");
        i.this.pq();
        GMTrace.o(4482737897472L, 33399);
        return false;
      }
      
      public final String toString()
      {
        GMTrace.i(4482872115200L, 33400);
        String str = super.toString() + "|scenePusher";
        GMTrace.o(4482872115200L, 33400);
        return str;
      }
    }, false);
    com.tencent.mm.kernel.h.vd().a(127, this);
    com.tencent.mm.kernel.h.vd().a(128, this);
    GMTrace.o(4485422252032L, 33419);
  }
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final k paramk)
  {
    GMTrace.i(4485556469760L, 33420);
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(4488643477504L, 33443);
        i.fBh += 1;
        Object localObject;
        int i;
        if (paramk.getType() == 128)
        {
          i.this.fBc = false;
          localObject = ((com.tencent.mm.modelvoice.e)paramk).fyw;
          i = ((com.tencent.mm.modelvoice.e)paramk).fEO;
          long l2 = 0L;
          long l1 = l2;
          if (localObject != null)
          {
            l1 = l2;
            if (i.this.fBb.get(localObject) != null)
            {
              l1 = ((g.a)i.this.fBb.get(localObject)).se();
              i.this.fBb.remove(localObject);
            }
          }
          v.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + paramk.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + (String)localObject + " time:" + l1);
          if ((paramInt1 != 3) || (i == 0)) {
            break label443;
          }
          localObject = i.this;
          ((i)localObject).fBf -= 1;
          label236:
          v.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.fBh + " stop:" + i.this.fBf + " running:" + i.this.fBe + " recving:" + i.this.fBc + " sending:" + i.this.fBd);
          if (i.this.fBf <= 0) {
            break label461;
          }
          i.this.pq();
        }
        for (;;)
        {
          i.fBh -= 1;
          GMTrace.o(4488643477504L, 33443);
          return;
          if (paramk.getType() == 127)
          {
            i.this.fBd = false;
            localObject = ((f)paramk).fyw;
            i = ((f)paramk).fEO;
            break;
          }
          v.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + paramk.getType());
          i.fBh -= 1;
          GMTrace.o(4488643477504L, 33443);
          return;
          label443:
          if (paramInt1 == 0) {
            break label236;
          }
          i.this.fBf = 0;
          break label236;
          label461:
          if ((!i.this.fBd) && (!i.this.fBc))
          {
            i.this.pr();
            v.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(i.fBi) });
            if ((i.fBi) && (paramInt1 == 4)) {
              com.tencent.mm.kernel.h.vL().e(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(16692121960448L, 124366);
                  v.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                  i.this.run();
                  GMTrace.o(16692121960448L, 124366);
                }
              }, 10000L);
            }
          }
        }
      }
      
      public final String toString()
      {
        GMTrace.i(4488777695232L, 33444);
        String str = super.toString() + "|onSceneEnd";
        GMTrace.o(4488777695232L, 33444);
        return str;
      }
    });
    GMTrace.o(4485556469760L, 33420);
  }
  
  public final void pq()
  {
    GMTrace.i(16085323612160L, 119845);
    this.fBg = System.currentTimeMillis();
    Object localObject2;
    if (((!this.fBc) && (this.fBa.size() == 0)) || ((!this.fBd) && (this.fAZ.size() == 0)))
    {
      localObject2 = q.LE();
      if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
        break label131;
      }
    }
    label131:
    Object localObject1;
    while ((!this.fBc) && (this.fBa.size() == 0) && (!this.fBd) && (this.fAZ.size() == 0))
    {
      pr();
      v.i("MicroMsg.SceneVoiceService", "No Data Any More , Stop Service");
      GMTrace.o(16085323612160L, 119845);
      return;
      long l = System.currentTimeMillis() / 1000L;
      localObject1 = bf.ev(l);
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        p localp = (p)((Iterator)localObject2).next();
        if (this.fBb.containsKey(localp.fyw))
        {
          v.d("MicroMsg.SceneVoiceService", "File is Already running:" + localp.fyw);
        }
        else
        {
          v.i("MicroMsg.SceneVoiceService", "Get file:" + localp.fyw + " status:" + localp.status + " user" + localp.fRV + " human:" + localp.hZN + " create:" + bf.ev(localp.hZS) + " last:" + bf.ev(localp.hZT) + " now:" + bf.ev(l) + " " + (l - localp.hZT));
          if (localp.LC())
          {
            if ((l - localp.hZT > 80L) && (localp.status == 5))
            {
              v.e("MicroMsg.SceneVoiceService", "time out file: " + localp.fyw + " last:" + bf.ev(localp.hZT) + " now:" + (String)localObject1 + " msgLocalId:" + localp.hZW + " status:" + localp.status);
              if (localp.hZW == 0)
              {
                localp.hZT = (System.currentTimeMillis() / 1000L);
                localp.fRM = 320;
                m.Lz().a(localp.fyw, localp);
              }
            }
            else
            {
              if ((l - localp.hZT > 300L) && (localp.status == 6))
              {
                v.e("MicroMsg.SceneVoiceService", "time out file: " + localp.fyw + " last:" + bf.ev(localp.hZT) + " now:" + (String)localObject1 + " msgLocalId:" + localp.hZW + " status:" + localp.status);
                if (localp.hZW != 0) {
                  break label741;
                }
                localp.hZT = (System.currentTimeMillis() / 1000L);
                localp.fRM = 320;
                m.Lz().a(localp.fyw, localp);
              }
              if (localp.hZP < localp.hYB) {
                break label753;
              }
              v.i("MicroMsg.SceneVoiceService", "file: " + localp.fyw + " stat:" + localp.status + " now:" + localp.hZP + " net:" + localp.hYB);
              continue;
            }
            q.lB(localp.fyw);
            continue;
            label741:
            q.lB(localp.fyw);
            continue;
            label753:
            this.fBa.offer(localp);
            this.fBb.put(localp.fyw, null);
          }
          else if (localp.LD())
          {
            v.i("MicroMsg.SceneVoiceService", "now " + l + "info.getLastModifyTime()  " + localp.hZT + "  info.getStatus() " + localp.status + "  info.getCreateTime() " + localp.hZS);
            if ((l - localp.hZT > 10L) && ((localp.status == 2) || (localp.status == 1)))
            {
              v.e("MicroMsg.SceneVoiceService", "time out file: " + localp.fyw + " last:" + bf.ev(localp.hZT) + " now:" + (String)localObject1);
              q.lB(localp.fyw);
            }
            else if ((l - localp.hZS > 600L) && (localp.status == 3))
            {
              v.e("MicroMsg.SceneVoiceService", "time out file: " + localp.fyw + " last:" + bf.ev(localp.hZT) + " now:" + (String)localObject1);
              q.lB(localp.fyw);
            }
            else if (localp.fRV.length() <= 0)
            {
              v.e("MicroMsg.SceneVoiceService", "Create a new ChatRoom? , set username first :" + localp.fyw);
            }
            else
            {
              this.fAZ.offer(localp.fyw);
              this.fBb.put(localp.fyw, null);
            }
          }
        }
      }
      v.i("MicroMsg.SceneVoiceService", "GetNeedRun procing:" + this.fBb.size() + " [recv:" + this.fBa.size() + ",send:" + this.fAZ.size() + "]");
      this.fBa.size();
      this.fAZ.size();
    }
    if ((!this.fBc) && (this.fBa.size() > 0))
    {
      localObject1 = (p)this.fBa.poll();
      localObject2 = ((p)localObject1).fyw;
      int i;
      if (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cC(((p)localObject1).fTG))
      {
        v.i("MicroMsg.SceneVoiceService", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(((p)localObject1).fTG) });
        i = 1;
      }
      while (i != 0) {
        if (bf.mz(((p)localObject1).fyw).length() > 0)
        {
          m.Lz().gR(((p)localObject1).fyw);
          GMTrace.o(16085323612160L, 119845);
          return;
          i = 0;
        }
        else
        {
          v.i("MicroMsg.SceneVoiceService", "[oneliang] the length of voice info file name is zero");
          GMTrace.o(16085323612160L, 119845);
          return;
        }
      }
      v.i("MicroMsg.SceneVoiceService", "Start Recv :" + (String)localObject2);
      if (localObject2 != null)
      {
        this.fBb.put(localObject2, new g.a());
        this.fBc = true;
        localObject1 = new com.tencent.mm.modelvoice.e((p)localObject1);
        com.tencent.mm.kernel.h.vd().a((k)localObject1, 0);
      }
    }
    if ((!this.fBd) && (this.fAZ.size() > 0))
    {
      localObject1 = (String)this.fAZ.poll();
      v.i("MicroMsg.SceneVoiceService", "Start Send :" + (String)localObject1);
      if (localObject1 != null)
      {
        this.fBb.put(localObject1, new g.a());
        this.fBd = true;
        localObject1 = new f((String)localObject1);
        com.tencent.mm.kernel.h.vd().a((k)localObject1, 0);
      }
    }
    GMTrace.o(16085323612160L, 119845);
  }
  
  public final void pr()
  {
    GMTrace.i(4485690687488L, 33421);
    this.fBb.clear();
    this.fAZ.clear();
    this.fBa.clear();
    this.fBd = false;
    this.fBc = false;
    this.fBe = false;
    v.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.fBj.se());
    GMTrace.o(4485690687488L, 33421);
  }
  
  public final void run()
  {
    GMTrace.i(4485824905216L, 33422);
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(4485153816576L, 33417);
        long l = System.currentTimeMillis() - i.this.fBg;
        v.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.this.fBe + " timeWait:" + l + " sending:" + i.this.fBd + " recving:" + i.this.fBc);
        if (i.this.fBe)
        {
          if (l < 60000L)
          {
            GMTrace.o(4485153816576L, 33417);
            return;
          }
          v.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.this.fBe + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.this.fBd + " recving:" + i.this.fBc);
        }
        i.this.fBe = true;
        i.this.fBd = false;
        i.this.fBf = 3;
        i.this.fBc = false;
        i.this.fBj.gSE = SystemClock.elapsedRealtime();
        i.this.fBk.v(10L, 10L);
        GMTrace.o(4485153816576L, 33417);
      }
      
      public final String toString()
      {
        GMTrace.i(4485288034304L, 33418);
        String str = super.toString() + "|run";
        GMTrace.o(4485288034304L, 33418);
        return str;
      }
    });
    GMTrace.o(4485824905216L, 33422);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/c/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */