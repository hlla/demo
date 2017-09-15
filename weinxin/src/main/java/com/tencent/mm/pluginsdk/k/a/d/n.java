package com.tencent.mm.pluginsdk.k.a.d;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n
{
  public static void bDy()
  {
    GMTrace.i(867717611520L, 6465);
    if (com.tencent.mm.kernel.h.vG().uV())
    {
      com.tencent.mm.kernel.h.vG();
      if (!a.uP()) {}
    }
    else
    {
      GMTrace.o(867717611520L, 6465);
      return;
    }
    if (getNetworkType() == 0)
    {
      GMTrace.o(867717611520L, 6465);
      return;
    }
    long l = bf.Nz();
    if (bf.a((Long)com.tencent.mm.kernel.h.vI().vr().get(w.a.uAE, null), 0L) < l)
    {
      com.tencent.mm.kernel.h.vI().vr().a(w.a.uAE, Long.valueOf(7200L + l));
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
      o.a.sFk.vL().D(new Runnable()
      {
        public final void run()
        {
          Object localObject1 = null;
          q localq = null;
          GMTrace.i(883018432512L, 6579);
          Object localObject2 = o.a.sFk;
          int i = n.getNetworkType();
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", new Object[] { Integer.valueOf(i) });
          if (i == 0)
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
            GMTrace.o(883018432512L, 6579);
            return;
          }
          if (!((o)localObject2).rWt)
          {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
            GMTrace.o(883018432512L, 6579);
            return;
          }
          long l;
          if (((o)localObject2).rWt)
          {
            l = bf.NA();
            localObject2 = ((o)localObject2).sFh.Kl();
            if (localObject2 != null) {
              break label165;
            }
            localObject1 = localq;
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", new Object[] { Long.valueOf(bf.aA(l)) });
            if (!bf.bV((List)localObject1)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
            GMTrace.o(883018432512L, 6579);
            return;
            label165:
            if (((Cursor)localObject2).getCount() <= 0)
            {
              ((Cursor)localObject2).close();
              localObject1 = localq;
            }
            else
            {
              localObject1 = new LinkedList();
              ((Cursor)localObject2).moveToFirst();
              do
              {
                localq = new q();
                localq.b((Cursor)localObject2);
                ((List)localObject1).add(localq);
              } while (((Cursor)localObject2).moveToNext());
              ((Cursor)localObject2).close();
            }
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localq = (q)((Iterator)localObject1).next();
            if (!bf.mA(localq.field_groupId1))
            {
              int j = localq.field_groupId1.hashCode();
              localObject2 = p.bDz().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                g localg = (g)((Iterator)localObject2).next();
                if (j == bf.mz(localg.Qo()).hashCode()) {
                  localg.bwH().a(localq, i);
                }
              }
            }
          }
          GMTrace.o(883018432512L, 6579);
        }
      });
    }
    GMTrace.o(867717611520L, 6465);
  }
  
  public static int getNetworkType()
  {
    GMTrace.i(867851829248L, 6466);
    switch (com.tencent.mm.compatible.d.v.rR())
    {
    default: 
      GMTrace.o(867851829248L, 6466);
      return 2;
    case 0: 
      GMTrace.o(867851829248L, 6466);
      return 0;
    }
    GMTrace.o(867851829248L, 6466);
    return 1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */