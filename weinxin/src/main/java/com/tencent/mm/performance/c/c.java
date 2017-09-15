package com.tencent.mm.performance.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bl.b;
import com.tencent.mm.performance.a.a.a;
import com.tencent.mm.performance.d.a;
import com.tencent.mm.performance.d.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class c
  extends a
{
  public static String TYPE;
  public HashSet<c> ifY;
  public long ige;
  public HashMap<WeakReference<Object>, Integer> igf;
  public HashSet<a> igg;
  public long igh;
  public boolean igi;
  private ad igj;
  
  static
  {
    GMTrace.i(13131191418880L, 97835);
    TYPE = "MemoryLeakController";
    GMTrace.o(13131191418880L, 97835);
  }
  
  public c()
  {
    GMTrace.i(13130117677056L, 97827);
    this.ige = -1L;
    this.igh = 0L;
    this.igi = true;
    this.igj = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(13128238628864L, 97813);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          GMTrace.o(13128238628864L, 97813);
          return;
          v.d("MicroMsg.WxPerformace", "gc==" + Thread.currentThread().getName());
          b.bNV();
          c.this.ige = System.currentTimeMillis();
        }
      }
    };
    GMTrace.o(13130117677056L, 97827);
  }
  
  private void a(d<Object> paramd)
  {
    GMTrace.i(13130251894784L, 97828);
    ??? = paramd.get();
    if (??? == null)
    {
      GMTrace.o(13130251894784L, 97828);
      return;
    }
    boolean bool = ??? instanceof Activity;
    synchronized (this.ifY)
    {
      Iterator localIterator = this.ifY.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).a(paramd, bool);
      }
    }
    GMTrace.o(13130251894784L, 97828);
  }
  
  public final String Nc()
  {
    GMTrace.i(13130386112512L, 97829);
    String str = TYPE;
    GMTrace.o(13130386112512L, 97829);
    return str;
  }
  
  public final void Nd()
  {
    GMTrace.i(13130520330240L, 97830);
    if ((this.igg == null) || (this.igg.isEmpty()))
    {
      GMTrace.o(13130520330240L, 97830);
      return;
    }
    long l1 = System.currentTimeMillis();
    Iterator localIterator2;
    Object localObject4;
    Object localObject3;
    try
    {
      if (!this.igf.isEmpty())
      {
        Iterator localIterator1 = null;
        localIterator2 = this.igf.keySet().iterator();
        if (localIterator2.hasNext())
        {
          localObject4 = (WeakReference)localIterator2.next();
          localObject3 = localIterator1;
          if (((WeakReference)localObject4).get() != null) {
            break label590;
          }
          localObject3 = localIterator1;
          if (localIterator1 == null) {
            localObject3 = new ArrayList();
          }
          ((ArrayList)localObject3).add(localObject4);
          break label590;
        }
        if (localIterator1 != null)
        {
          localIterator1 = localIterator1.iterator();
          while (localIterator1.hasNext())
          {
            localObject3 = (WeakReference)localIterator1.next();
            this.igf.remove(localObject3);
          }
        }
      }
      localIterator2 = this.igg.iterator();
    }
    finally {}
    Object localObject2 = null;
    int i = 0;
    int j = 0;
    for (;;)
    {
      int k;
      if (localIterator2.hasNext())
      {
        localObject4 = (a)localIterator2.next();
        long l2 = ((a)localObject4).igo;
        if (((a)localObject4).igm.get() != null) {
          break label602;
        }
        if (((a)localObject4).igl.get() == null)
        {
          localObject3 = localObject2;
          if (localObject2 == null) {
            localObject3 = new ArrayList();
          }
          ((ArrayList)localObject3).add(localObject4);
          localObject2 = localObject3;
          continue;
        }
        if ((this.igh - l2 <= 8L) || (l1 - ((a)localObject4).ign < 180000L)) {
          break label587;
        }
        if (this.igf.containsKey(((a)localObject4).igl))
        {
          k = ((Integer)this.igf.get(((a)localObject4).igl)).intValue();
          if (k >= 3)
          {
            a(((a)localObject4).igl);
            v.d("MicroMsg.WxPerformace", "memoryleak activity ===" + ((a)localObject4).igl.get());
            if (localObject2 != null) {
              break label584;
            }
            localObject2 = new ArrayList();
          }
        }
      }
      label554:
      label584:
      for (;;)
      {
        ((ArrayList)localObject2).add(localObject4);
        break;
        i = 1;
        this.igf.put(((a)localObject4).igl, Integer.valueOf(k + 1));
        break;
        if (((a)localObject4).ign >= this.ige - 5000L) {
          break label597;
        }
        this.igf.put(((a)localObject4).igl, Integer.valueOf(1));
        break;
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (a)((Iterator)localObject2).next();
            this.igg.remove(localObject3);
          }
        }
        if (this.igi)
        {
          if (i == 0) {
            break label554;
          }
          this.igj.sendEmptyMessage(1);
        }
        for (;;)
        {
          GMTrace.o(13130520330240L, 97830);
          return;
          if ((j != 0) && (l1 - this.ige > 30000L)) {
            this.igj.sendEmptyMessage(1);
          }
        }
      }
      label587:
      break label599;
      label590:
      localObject2 = localObject3;
      break;
      label597:
      i = 1;
      label599:
      continue;
      label602:
      j = 1;
    }
  }
  
  private final class a
  {
    public d<Object> igl;
    public WeakReference<Object> igm;
    public long ign;
    public long igo;
    
    public a()
    {
      GMTrace.i(13129446588416L, 97822);
      this.ign = 0L;
      this.igo = 0L;
      GMTrace.o(13129446588416L, 97822);
    }
  }
  
  private final class b
    extends a.a
  {
    public b()
    {
      GMTrace.i(13131325636608L, 97836);
      GMTrace.o(13131325636608L, 97836);
    }
    
    public final void b(Activity paramActivity, Bundle paramBundle)
    {
      GMTrace.i(13131594072064L, 97838);
      super.b(paramActivity, paramBundle);
      paramActivity = c.this;
      paramActivity.igh += 1L;
      if (c.this.igh < 0L) {
        c.this.igh = 0L;
      }
      GMTrace.o(13131594072064L, 97838);
    }
    
    public final void q(Activity paramActivity)
    {
      GMTrace.i(13131459854336L, 97837);
      super.q(paramActivity);
      c localc = c.this;
      WeakReference localWeakReference = new WeakReference(new Object());
      paramActivity = new d(paramActivity.toString(), paramActivity);
      try
      {
        c.a locala = new c.a(localc);
        locala.igl = paramActivity;
        locala.igm = localWeakReference;
        locala.ign = System.currentTimeMillis();
        locala.igo = localc.igh;
        localc.igg.add(locala);
        GMTrace.o(13131459854336L, 97837);
        return;
      }
      finally {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(d<Object> paramd, boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/performance/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */