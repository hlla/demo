package com.tencent.mm.plugin.subapp.c;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class j
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
  
  static
  {
    GMTrace.i(5832431370240L, 43455);
    fBh = 0;
    GMTrace.o(5832431370240L, 43455);
  }
  
  public j()
  {
    GMTrace.i(5829747015680L, 43435);
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
        GMTrace.i(5839142256640L, 43505);
        v.d("MicroMsg.VoiceRemindService", "onTimerExpired");
        try
        {
          j.this.pq();
          GMTrace.o(5839142256640L, 43505);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.VoiceRemindService", localException, "", new Object[0]);
          }
        }
      }
    }, false);
    ap.vd().a(329, this);
    GMTrace.o(5829747015680L, 43435);
  }
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.y.k paramk)
  {
    GMTrace.i(5829881233408L, 43436);
    ap.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(5839947563008L, 43511);
        j.fBh += 1;
        Object localObject;
        int i;
        if (paramk.getType() == 128)
        {
          j.this.fBc = false;
          localObject = ((com.tencent.mm.modelvoice.e)paramk).fyw;
          i = ((com.tencent.mm.modelvoice.e)paramk).fEO;
          long l2 = 0L;
          long l1 = l2;
          if (localObject != null)
          {
            l1 = l2;
            if (j.this.fBb.get(localObject) != null)
            {
              l1 = ((g.a)j.this.fBb.get(localObject)).se();
              j.this.fBb.remove(localObject);
            }
          }
          v.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + paramk.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + (String)localObject + " time:" + l1);
          if ((paramInt1 != 3) || (i == 0)) {
            break label444;
          }
          localObject = j.this;
          ((j)localObject).fBf -= 1;
          label236:
          v.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.fBh + " stop:" + j.this.fBf + " running:" + j.this.fBe + " recving:" + j.this.fBc + " sending:" + j.this.fBd);
          if (j.this.fBf <= 0) {
            break label462;
          }
          j.this.pq();
        }
        for (;;)
        {
          j.fBh -= 1;
          GMTrace.o(5839947563008L, 43511);
          return;
          if (paramk.getType() == 329)
          {
            j.this.fBd = false;
            localObject = ((b)paramk).fyw;
            i = ((b)paramk).fEO;
            break;
          }
          v.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + paramk.getType());
          j.fBh -= 1;
          GMTrace.o(5839947563008L, 43511);
          return;
          label444:
          if (paramInt1 == 0) {
            break label236;
          }
          j.this.fBf = 0;
          break label236;
          label462:
          if ((!j.this.fBd) && (!j.this.fBc)) {
            j.this.pr();
          }
        }
      }
    });
    GMTrace.o(5829881233408L, 43436);
  }
  
  public final void pq()
  {
    GMTrace.i(16029757472768L, 119431);
    this.fBg = System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    int i;
    g localg;
    if (((!this.fBc) && (this.fBa.size() == 0)) || ((!this.fBd) && (this.fAZ.size() == 0)))
    {
      localObject1 = d.bmR();
      localObject2 = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo";
      localObject2 = (String)localObject2 + " WHERE status<97  order by createtime";
      localObject2 = ((k)localObject1).gUp.a((String)localObject2, null, 2);
      localObject1 = null;
      int j = 0;
      i = 0;
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject1 = new ArrayList();
        do
        {
          localg = new g();
          localg.b((Cursor)localObject2);
          ((List)localObject1).add(localg);
          j = i + 1;
          i = j;
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
      v.d("MicroMsg.VoiceRemindStorage", "getUnfinishInfo resCount:" + j);
      if (localObject1 != null) {
        break label299;
      }
      v.d("MicroMsg.VoiceRemindService", "getNeedRunInfo null ");
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label329;
      }
    }
    for (;;)
    {
      if ((this.fBc) || (this.fBa.size() != 0) || (this.fBd) || (this.fAZ.size() != 0)) {
        break label1303;
      }
      pr();
      v.d("MicroMsg.VoiceRemindService", "No Data Any More , Stop Service");
      GMTrace.o(16029757472768L, 119431);
      return;
      label299:
      v.d("MicroMsg.VoiceRemindService", "getNeedRunInfo " + ((List)localObject1).size());
      break;
      label329:
      long l = System.currentTimeMillis() / 1000L;
      localObject2 = bf.ev(l);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localg = (g)((Iterator)localObject1).next();
        if (this.fBb.containsKey(localg.field_filename))
        {
          v.d("MicroMsg.VoiceRemindService", "File is Already running:" + localg.field_filename);
        }
        else
        {
          v.d("MicroMsg.VoiceRemindService", "Get file:" + localg.field_filename + " status:" + localg.field_status + " user" + localg.field_user + " human:" + localg.field_human + " create:" + bf.ev(localg.field_createtime) + " last:" + bf.ev(localg.field_lastmodifytime) + " now:" + bf.ev(l) + " " + (l - localg.field_lastmodifytime));
          if ((localg.field_status == 5) || (localg.field_status == 6)) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0)
            {
              if ((l - localg.field_lastmodifytime > 80L) && (localg.field_status == 5))
              {
                v.e("MicroMsg.VoiceRemindService", "time out file: " + localg.field_filename + " last:" + bf.ev(localg.field_lastmodifytime) + " now:" + (String)localObject2);
                h.lB(localg.field_filename);
                break;
                i = 0;
                continue;
              }
              if ((l - localg.field_lastmodifytime > 300L) && (localg.field_status == 6))
              {
                v.e("MicroMsg.VoiceRemindService", "time out file: " + localg.field_filename + " last:" + bf.ev(localg.field_lastmodifytime) + " now:" + (String)localObject2);
                h.lB(localg.field_filename);
                break;
              }
              if (localg.field_filenowsize >= localg.field_offset)
              {
                v.d("MicroMsg.VoiceRemindService", "file: " + localg.field_filename + " stat:" + localg.field_status + " now:" + localg.field_filenowsize + " net:" + localg.field_offset);
                break;
              }
              this.fBa.offer(localg.field_filename);
              this.fBb.put(localg.field_filename, null);
            }
          }
          if (localg.LD())
          {
            v.d("MicroMsg.VoiceRemindService", "now " + l + "info.getLastModifyTime()  " + localg.field_lastmodifytime + "  info.getStatus() " + localg.field_status + "  info.getCreateTime() " + localg.field_createtime);
            if ((l - localg.field_lastmodifytime > 10L) && ((localg.field_status == 2) || (localg.field_status == 1)))
            {
              v.e("MicroMsg.VoiceRemindService", "time out file: " + localg.field_filename + " last:" + bf.ev(localg.field_lastmodifytime) + " now:" + (String)localObject2);
              h.lB(localg.field_filename);
            }
            else if ((l - localg.field_createtime > 600L) && (localg.field_status == 3))
            {
              v.e("MicroMsg.VoiceRemindService", "time out file: " + localg.field_filename + " last:" + bf.ev(localg.field_lastmodifytime) + " now:" + (String)localObject2);
              h.lB(localg.field_filename);
            }
            else if (localg.field_user.length() <= 0)
            {
              v.e("MicroMsg.VoiceRemindService", "Create a new ChatRoom? , set username first :" + localg.field_filename);
            }
            else
            {
              this.fAZ.offer(localg.field_filename);
              this.fBb.put(localg.field_filename, null);
            }
          }
        }
      }
      v.d("MicroMsg.VoiceRemindService", "GetNeedRun procing:" + this.fBb.size() + " [recv:" + this.fBa.size() + ",send:" + this.fAZ.size() + "]");
      this.fBa.size();
      this.fAZ.size();
    }
    label1303:
    if ((!this.fBc) && (this.fBa.size() > 0))
    {
      localObject1 = (String)this.fBa.poll();
      v.d("MicroMsg.VoiceRemindService", "Start Recv :" + (String)localObject1);
      if (localObject1 != null)
      {
        this.fBb.put(localObject1, new g.a());
        this.fBc = true;
        v.d("MicroMsg.VoiceRemindService", "tiger download voice");
      }
    }
    if ((!this.fBd) && (this.fAZ.size() > 0))
    {
      localObject1 = (String)this.fAZ.poll();
      v.d("MicroMsg.VoiceRemindService", "Start Send :" + (String)localObject1);
      if (localObject1 != null)
      {
        this.fBb.put(localObject1, new g.a());
        this.fBd = true;
        localObject1 = new b((String)localObject1);
        ap.vd().a((com.tencent.mm.y.k)localObject1, 0);
      }
    }
    GMTrace.o(16029757472768L, 119431);
  }
  
  public final void pr()
  {
    GMTrace.i(5830015451136L, 43437);
    this.fBb.clear();
    this.fAZ.clear();
    this.fBa.clear();
    this.fBd = false;
    this.fBc = false;
    this.fBe = false;
    v.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.fBj.se());
    GMTrace.o(5830015451136L, 43437);
  }
  
  public final void run()
  {
    GMTrace.i(5830149668864L, 43438);
    ap.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(5846255796224L, 43558);
        long l = System.currentTimeMillis() - j.this.fBg;
        v.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.this.fBe + " timeWait:" + l + " sending:" + j.this.fBd + " recving:" + j.this.fBc);
        if (j.this.fBe)
        {
          if (l < 60000L)
          {
            GMTrace.o(5846255796224L, 43558);
            return;
          }
          v.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.this.fBe + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + j.this.fBd + " recving:" + j.this.fBc);
        }
        j.this.fBe = true;
        j.this.fBd = false;
        j.this.fBf = 3;
        j.this.fBc = false;
        j.this.fBj.gSE = SystemClock.elapsedRealtime();
        j.this.fBk.v(10L, 10L);
        GMTrace.o(5846255796224L, 43558);
      }
    });
    GMTrace.o(5830149668864L, 43438);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */