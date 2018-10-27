package com.google.android.gms.ads.internal.util.a;

import com.google.android.gms.ads.internal.q.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@a
final class w
{
  private boolean a = false;
  private final List b = new ArrayList();
  private final Object c = new Object();
  
  public final void a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.c)
    {
      if (!this.a)
      {
        localArrayList.addAll(this.b);
        this.b.clear();
        this.a = true;
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((Runnable)localArrayList.get(i)).run();
          i += 1;
        }
      }
      return;
    }
  }
  
  public final void a(Runnable paramRunnable, Executor paramExecutor)
  {
    synchronized (this.c)
    {
      if (!this.a)
      {
        this.b.add(new x(paramExecutor, paramRunnable));
        return;
      }
      paramExecutor.execute(paramRunnable);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */