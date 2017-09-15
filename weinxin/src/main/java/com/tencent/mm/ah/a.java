package com.tencent.mm.ah;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.u;
import com.tencent.mm.e.a.u.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Stack;

public final class a
  implements c.a
{
  private a hEa;
  public Stack<Long> hEb;
  long hEc;
  public int hEd;
  boolean hEe;
  public long hEf;
  public int hEg;
  public boolean hEh;
  public long hEi;
  public long hEj;
  public int hEk;
  public int hEl;
  public ai hEm;
  com.tencent.mm.sdk.b.c hEn;
  com.tencent.mm.sdk.b.c hEo;
  
  public a(Looper paramLooper)
  {
    GMTrace.i(3511001546752L, 26159);
    this.hEc = 0L;
    this.hEd = 0;
    this.hEe = false;
    this.hEf = 0L;
    this.hEg = 0;
    this.hEh = false;
    this.hEi = 0L;
    this.hEj = 0L;
    this.hEm = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(3539187269632L, 26369);
        long l1 = TrafficStats.getUidRxBytes(a.this.hEk);
        long l2 = TrafficStats.getUidTxBytes(a.this.hEk);
        long l3 = l1 - a.this.hEi + (l2 - a.this.hEj);
        v.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + l3 / 1024L);
        if (l3 <= 20480L)
        {
          a.this.hEh = false;
          a.this.start();
        }
        for (;;)
        {
          GMTrace.o(3539187269632L, 26369);
          return true;
          a.this.hEi = l1;
          a.this.hEj = l2;
          a.this.hEm.v(1000L, 1000L);
        }
      }
    }, false);
    this.hEn = new com.tencent.mm.sdk.b.c() {};
    this.hEo = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(u arg1)
      {
        GMTrace.i(3540261011456L, 26377);
        a.this.hEl = ???.fCS.mode;
        v.d("MicroMsg.AutoGetBigImgLogic", "mode = " + a.this.hEl);
        com.tencent.mm.modelcontrol.c.Es();
        if (!com.tencent.mm.modelcontrol.c.Et()) {}
        synchronized (a.this.hEb)
        {
          a.this.hEb.clear();
          GMTrace.o(3540261011456L, 26377);
          return false;
        }
      }
    };
    this.hEa = new a(this, paramLooper);
    this.hEb = new Stack();
    this.hEk = Process.myUid();
    paramLooper = (Integer)com.tencent.mm.kernel.h.vI().vr().get(327681, null);
    if ((paramLooper == null) || (3 == paramLooper.intValue())) {}
    for (int i = 1;; i = paramLooper.intValue())
    {
      this.hEl = i;
      com.tencent.mm.sdk.b.a.uql.b(this.hEn);
      com.tencent.mm.sdk.b.a.uql.b(this.hEo);
      GMTrace.o(3511001546752L, 26159);
      return;
    }
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    GMTrace.i(3511538417664L, 26163);
    if (paramBoolean)
    {
      if (al.isWifi(aa.getContext()))
      {
        v.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
        GMTrace.o(3511538417664L, 26163);
        return;
      }
      long l1 = bf.a((Long)com.tencent.mm.kernel.h.vI().vr().get(w.a.uyI, null), 0L);
      long l2 = bf.PY((String)DateFormat.format("M", System.currentTimeMillis()));
      v.d("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
      com.tencent.mm.kernel.h.vI().vr().a(w.a.uyI, Long.valueOf(l1 + 1L));
      com.tencent.mm.kernel.h.vI().vr().a(w.a.uyJ, Long.valueOf(l2));
      GMTrace.o(3511538417664L, 26163);
      return;
    }
    v.i("MicroMsg.AutoGetBigImgLogic", "imglocalId " + paramLong1 + " msglocalid " + paramLong2 + " false");
    GMTrace.o(3511538417664L, 26163);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    GMTrace.i(3511806853120L, 26165);
    v.i("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " has been canceled");
    GMTrace.o(3511806853120L, 26165);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, k paramk)
  {
    GMTrace.i(3511404199936L, 26162);
    GMTrace.o(3511404199936L, 26162);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object arg7, int paramInt3, int paramInt4, String paramString, k paramk)
  {
    GMTrace.i(3511672635392L, 26164);
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      v.e("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
    }
    for (;;)
    {
      this.hEc = 0L;
      com.tencent.mm.modelcontrol.c.Es();
      if (!com.tencent.mm.modelcontrol.c.Et())
      {
        v.d("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.hEb)
        {
          this.hEb.clear();
          GMTrace.o(3511672635392L, 26164);
          return;
          a(paramLong1, paramLong2, true);
        }
      }
    }
    this.hEi = TrafficStats.getUidRxBytes(this.hEk);
    this.hEj = TrafficStats.getUidTxBytes(this.hEk);
    this.hEm.v(1000L, 1000L);
    GMTrace.o(3511672635392L, 26164);
  }
  
  public final void aX(boolean paramBoolean)
  {
    GMTrace.i(3511269982208L, 26161);
    v.d("MicroMsg.AutoGetBigImgLogic", "is foreground: " + paramBoolean);
    this.hEe = paramBoolean;
    this.hEf = System.currentTimeMillis();
    GMTrace.o(3511269982208L, 26161);
  }
  
  public final void start()
  {
    GMTrace.i(3511135764480L, 26160);
    this.hEa.sendEmptyMessage(1);
    GMTrace.o(3511135764480L, 26160);
  }
  
  static final class a
    extends ad
  {
    private WeakReference<a> hEq;
    
    public a(a parama, Looper paramLooper)
    {
      super();
      GMTrace.i(3530999988224L, 26308);
      this.hEq = new WeakReference(parama);
      GMTrace.o(3530999988224L, 26308);
    }
    
    public final void handleMessage(Message arg1)
    {
      GMTrace.i(3531134205952L, 26309);
      a locala = (a)this.hEq.get();
      if ((locala != null) && (1 == ???.what))
      {
        if ((!locala.hEe) && (System.currentTimeMillis() - locala.hEf > 1200000L))
        {
          v.d("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
          GMTrace.o(3531134205952L, 26309);
          return;
        }
        if ((locala.hEc != 0L) || (locala.hEb.size() <= 0) || (locala.hEg != 0) || (locala.hEh))
        {
          v.d("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + locala.hEc + " size: " + locala.hEb.size() + " cnt: " + locala.hEg + " pauseOnMonitor: " + locala.hEh);
          GMTrace.o(3531134205952L, 26309);
          return;
        }
        d locald;
        synchronized (locala.hEb)
        {
          locala.hEc = ((Long)locala.hEb.pop()).longValue();
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(locala.hEc);
          locald = n.GT().ai(???.field_msgSvrId);
          if (locald.gxA == 1)
          {
            v.d("MicroMsg.AutoGetBigImgLogic", locala.hEc + " already has hd thumb");
            locala.hEc = 0L;
            locala.start();
            GMTrace.o(3531134205952L, 26309);
            return;
          }
        }
        v.d("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + locala1.hEc + "  image_" + ???.field_msgId);
        g.Em().hxZ.add("image_" + ???.field_msgId);
        n.GU().a(locald.hEG, ???.field_msgId, 0, Long.valueOf(locala1.hEc), locala1.hEd, locala1);
      }
      GMTrace.o(3531134205952L, 26309);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */