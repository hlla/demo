package com.google.android.finsky.af.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

final class d
  extends j
{
  private final AtomicInteger a;
  private final Iterable b;
  
  d(Iterable paramIterable, boolean paramBoolean, Executor paramExecutor)
  {
    super(e.a, paramExecutor);
    paramExecutor = new f(this, paramBoolean);
    this.b = paramIterable;
    paramIterable = this.b.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      paramIterable.next();
      i += 1;
    }
    if (i > 0) {}
    for (;;)
    {
      this.a = new AtomicInteger(i);
      paramIterable = this.b.iterator();
      while (paramIterable.hasNext()) {
        ((com.google.android.finsky.af.e)paramIterable.next()).a(paramExecutor);
      }
      set(Collections.emptyList());
    }
  }
  
  private final void a()
  {
    if ((!isDone()) && (this.a.decrementAndGet() == 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.b.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          com.google.android.finsky.af.e locale = (com.google.android.finsky.af.e)localIterator.next();
          try
          {
            if (!locale.isCancelled()) {
              localArrayList.add(locale.get());
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            localArrayList.add(null);
            continue;
            localArrayList.add(null);
          }
          catch (ExecutionException localExecutionException)
          {
            for (;;) {}
          }
        }
      }
      set(localArrayList);
    }
  }
  
  public final void run()
  {
    a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */