package com.tencent.mm.pluginsdk.k.a.d;

import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.List;

public final class i
  implements c
{
  private final ad sER;
  public final SparseArray<List<d>> sES;
  public final Object sET;
  
  i(ad paramad)
  {
    GMTrace.i(869059788800L, 6475);
    this.sER = paramad;
    this.sES = new SparseArray();
    this.sET = new Object();
    GMTrace.o(869059788800L, 6475);
  }
  
  private List<d> Ms(String arg1)
  {
    GMTrace.i(869596659712L, 6479);
    int i = ???.hashCode();
    synchronized (this.sET)
    {
      List localList = (List)this.sES.get(i);
      GMTrace.o(869596659712L, 6479);
      return localList;
    }
  }
  
  public final void a(final e parame, final l paraml)
  {
    GMTrace.i(869194006528L, 6476);
    v.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = " + paraml);
    switch (paraml.status)
    {
    }
    for (;;)
    {
      GMTrace.o(869194006528L, 6476);
      return;
      final Object localObject = o.a.sFk.Mt(paraml.sDr);
      if (localObject != null)
      {
        ((q)localObject).field_status = 4;
        o.a.sFk.e((q)localObject);
      }
      localObject = Ms(parame.Qo());
      if (!bf.bV((List)localObject))
      {
        parame = parame.bDh();
        this.sER.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(861677813760L, 6420);
            Iterator localIterator = localObject.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (bf.mz(locald.Qo()).equals(paraml.groupId)) {
                locald.Jg(parame);
              }
            }
            GMTrace.o(861677813760L, 6420);
          }
        });
      }
      GMTrace.o(869194006528L, 6476);
      return;
      localObject = o.a.sFk.Mt(paraml.sDr);
      if (localObject != null)
      {
        ((q)localObject).field_status = 2;
        o.a.sFk.e((q)localObject);
      }
      v.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + parame.Qo());
      localObject = Ms(parame.Qo());
      if (bf.bV((List)localObject))
      {
        v.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
        GMTrace.o(869194006528L, 6476);
        return;
      }
      v.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + ((List)localObject).size());
      parame = parame.bDh();
      this.sER.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(863288426496L, 6432);
          Iterator localIterator = localObject.iterator();
          while (localIterator.hasNext())
          {
            d locald = (d)localIterator.next();
            if (bf.mz(locald.Qo()).equals(paraml.groupId)) {
              locald.a(parame, paraml);
            }
          }
          GMTrace.o(863288426496L, 6432);
        }
      });
      GMTrace.o(869194006528L, 6476);
      return;
      localObject = o.a.sFk.Mt(paraml.sDr);
      if (localObject != null)
      {
        ((q)localObject).field_status = 3;
        o.a.sFk.e((q)localObject);
      }
      localObject = Ms(parame.Qo());
      if (!bf.bV((List)localObject))
      {
        parame = parame.bDh();
        this.sER.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(867046522880L, 6460);
            Iterator localIterator = localObject.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (bf.mz(locald.Qo()).equals(paraml.groupId)) {
                locald.b(parame, paraml);
              }
            }
            GMTrace.o(867046522880L, 6460);
          }
        });
      }
    }
  }
  
  public final void n(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(869328224256L, 6477);
    v.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = o.a.sFk.Mt(paramString);
    if (paramString != null)
    {
      paramString.field_maxRetryTimes = paramInt1;
      paramString.field_retryTimes = paramInt2;
      o.a.sFk.e(paramString);
    }
    GMTrace.o(869328224256L, 6477);
  }
  
  public final void n(String paramString, long paramLong)
  {
    GMTrace.i(869462441984L, 6478);
    paramString = o.a.sFk.Mt(paramString);
    if (paramString != null)
    {
      paramString.field_contentLength = paramLong;
      o.a.sFk.e(paramString);
    }
    GMTrace.o(869462441984L, 6478);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */