package com.google.android.gms.ads.internal.util.c;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@com.google.android.gms.ads.internal.q.a.a
public class e
  implements a
{
  private final BlockingQueue a = new LinkedBlockingQueue();
  public int b = 0;
  private final Object c = new Object();
  private Object d;
  
  public final void a(d paramd, b paramb)
  {
    for (;;)
    {
      int i;
      synchronized (this.c)
      {
        i = this.b;
        if (i == 1)
        {
          paramd.a(this.d);
          return;
        }
        if (i == -1) {
          paramb.a();
        }
      }
      if (i == 0) {
        this.a.add(new f(paramd, paramb));
      }
    }
  }
  
  public final void a(Object paramObject)
  {
    synchronized (this.c)
    {
      if (this.b != 0) {
        throw new UnsupportedOperationException();
      }
    }
    this.d = paramObject;
    this.b = 1;
    Iterator localIterator = this.a.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.a.clear();
        return;
      }
      ((f)localIterator.next()).b.a(paramObject);
    }
  }
  
  public final void d()
  {
    synchronized (this.c)
    {
      if (this.b == 0)
      {
        this.b = -1;
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext())
        {
          this.a.clear();
          return;
        }
        ((f)localIterator.next()).a.a();
      }
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */