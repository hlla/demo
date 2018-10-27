package com.google.android.finsky.af.a;

import com.google.android.finsky.af.a;
import com.google.android.finsky.af.e;
import com.google.android.finsky.af.f;
import com.google.android.finsky.af.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

class j
  extends g
{
  private boolean a = false;
  private final Executor b;
  private final List c = new ArrayList();
  private final List d = new ArrayList();
  
  j(Runnable paramRunnable, Object paramObject, Executor paramExecutor)
  {
    super(paramRunnable, paramObject);
    this.b = paramExecutor;
  }
  
  j(Callable paramCallable, Executor paramExecutor)
  {
    super(paramCallable);
    this.b = paramExecutor;
  }
  
  private final void a(f paramf, Executor paramExecutor)
  {
    paramExecutor.execute(new k(this, paramf));
  }
  
  public final e a(a parama)
  {
    return new n(this, parama, this.b);
  }
  
  public final e a(com.google.common.base.n paramn)
  {
    return new n(this, paramn, this.b);
  }
  
  public final void a(f paramf)
  {
    try
    {
      if (!this.a)
      {
        this.c.add(new l(paramf, this.b));
        return;
      }
      a(paramf, this.b);
      return;
    }
    finally {}
  }
  
  public final void a(Runnable paramRunnable)
  {
    try
    {
      if (!this.a)
      {
        this.d.add(new m(paramRunnable, this.b));
        return;
      }
      this.b.execute(paramRunnable);
      return;
    }
    finally {}
  }
  
  protected void done()
  {
    try
    {
      if (!this.a)
      {
        this.a = true;
        Iterator localIterator = this.c.iterator();
        Object localObject3;
        while (localIterator.hasNext())
        {
          localObject3 = (l)localIterator.next();
          a(((l)localObject3).b, ((l)localObject3).a);
        }
        localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (m)localIterator.next();
          Runnable localRunnable = ((m)localObject3).b;
          ((m)localObject3).a.execute(localRunnable);
        }
      }
    }
    finally {}
    try
    {
      this.c.clear();
      this.d.clear();
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */