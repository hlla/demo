package com.tencent.mm.u.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ap.j;
import com.tencent.mm.ap.t;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
  implements com.tencent.mm.y.e
{
  private static c hpv;
  private ArrayList<a> gUD;
  public SharedPreferences hgn;
  private final int hpr;
  private final String hps;
  private final long hpt;
  public volatile boolean hpu;
  
  private c()
  {
    GMTrace.i(611630186496L, 4557);
    this.hpr = 21;
    this.hps = "trace_config_last_update_time";
    this.hpt = 86400000L;
    this.hpu = false;
    this.hgn = aa.bIO();
    this.gUD = new ArrayList();
    GMTrace.o(611630186496L, 4557);
  }
  
  public static c AI()
  {
    GMTrace.i(611764404224L, 4558);
    if (hpv == null) {}
    try
    {
      if (hpv == null) {
        hpv = new c();
      }
      c localc = hpv;
      GMTrace.o(611764404224L, 4558);
      return localc;
    }
    finally {}
  }
  
  private void fo(int paramInt)
  {
    GMTrace.i(612032839680L, 4560);
    t.Id();
    Object localObject1 = com.tencent.mm.ap.n.HZ();
    Object localObject2 = t.Id().aS(paramInt, 21);
    label479:
    for (;;)
    {
      try
      {
        Object localObject3 = bg.q(com.tencent.mm.a.e.aT(new File(new File((String)localObject1), (String)localObject2).getPath()), "TraceConfig");
        if (localObject3 == null)
        {
          v.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
          GMTrace.o(612032839680L, 4560);
          return;
        }
        localObject2 = new HashMap();
        i = 0;
        Object localObject4 = new StringBuilder().append(".TraceConfig.Item");
        if (i == 0)
        {
          localObject1 = "";
          localObject1 = localObject1;
          localObject4 = (String)((Map)localObject3).get((String)localObject1 + ".$key");
          if (localObject4 != null)
          {
            i += 1;
            long l = bf.getLong((String)((Map)localObject3).get(localObject1), -1L);
            if (l < 0L) {
              break label479;
            }
            v.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i + " key: " + (String)localObject4 + "|value: " + l);
            ((Map)localObject2).put(localObject4, Long.valueOf(l));
          }
        }
        else
        {
          localObject1 = Integer.valueOf(i);
          continue;
        }
        localObject1 = this.hgn.edit();
        localObject3 = ((Map)localObject2).entrySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          ((SharedPreferences.Editor)localObject1).putLong((String)((Map.Entry)localObject4).getKey(), ((Long)((Map.Entry)localObject4).getValue()).longValue());
          continue;
        }
        com.tencent.mm.ap.m localm;
        localm.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
      }
      catch (IOException localIOException)
      {
        v.printErrStackTrace("MicroMsg.TraceConfigUpdater", localIOException, "", new Object[0]);
        localm = t.Id().aQ(paramInt, 21);
        localm.status = 2;
        t.Id().b(localm);
        GMTrace.o(612032839680L, 4560);
        return;
      }
      v.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + ((Map)localObject2).size());
      int j = this.gUD.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.gUD.get(i)).AE();
        i += 1;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(611898621952L, 4559);
    int i = paramk.getType();
    v.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if ((!(paramk instanceof com.tencent.mm.y.m)) || (((com.tencent.mm.y.m)paramk).BQ() != 21))
    {
      v.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
      GMTrace.o(611898621952L, 4559);
      return;
    }
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = t.Id().gl(21);
        if ((paramString == null) || (paramString.length == 0))
        {
          v.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
          release();
          GMTrace.o(611898621952L, 4559);
          return;
        }
        paramString = paramString[0];
        v.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.fKC);
        if (5 == paramString.status)
        {
          paramString = new j(paramString.id, 21);
          ap.vd().a(paramString, 0);
          GMTrace.o(611898621952L, 4559);
          return;
        }
        v.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
        this.hgn.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
        release();
        GMTrace.o(611898621952L, 4559);
        return;
      }
      release();
      GMTrace.o(611898621952L, 4559);
      return;
    }
    if (i == 160)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        fo(((j)paramk).hNR);
      }
      release();
    }
    GMTrace.o(611898621952L, 4559);
  }
  
  public final boolean a(a parama)
  {
    GMTrace.i(612301275136L, 4562);
    if ((parama != null) && (!this.gUD.contains(parama)))
    {
      boolean bool = this.gUD.add(parama);
      GMTrace.o(612301275136L, 4562);
      return bool;
    }
    GMTrace.o(612301275136L, 4562);
    return false;
  }
  
  public final void release()
  {
    GMTrace.i(612167057408L, 4561);
    v.i("MicroMsg.TraceConfigUpdater", "summer release");
    this.hpu = false;
    ap.vd().b(159, this);
    ap.vd().b(160, this);
    GMTrace.o(612167057408L, 4561);
  }
  
  public static abstract interface a
  {
    public abstract void AE();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */