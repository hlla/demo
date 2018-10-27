package com.google.android.gms.ads.internal.util.a;

import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.v.f;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@a
public class af
  implements v
{
  private Throwable a;
  private boolean b;
  private boolean c;
  private final w d = new w();
  private final Object e = new Object();
  private Object f;
  
  private final boolean a()
  {
    return (this.a != null) || (this.b);
  }
  
  public static af b()
  {
    return new af();
  }
  
  public final void a(Runnable paramRunnable, Executor paramExecutor)
  {
    this.d.a(paramRunnable, paramExecutor);
  }
  
  public final void a(Throwable paramThrowable)
  {
    synchronized (this.e)
    {
      if (!this.c)
      {
        if (a())
        {
          bt.A.i.b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
          return;
        }
        this.a = paramThrowable;
        this.e.notifyAll();
        this.d.a();
        return;
      }
    }
  }
  
  public final void b(Object paramObject)
  {
    synchronized (this.e)
    {
      if (!this.c)
      {
        if (!a())
        {
          this.b = true;
          this.f = paramObject;
          this.e.notifyAll();
          this.d.a();
          return;
        }
        bt.A.i.b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
        return;
      }
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (this.e)
      {
        if (!a())
        {
          this.c = true;
          this.b = true;
          this.e.notifyAll();
          this.d.a();
          return true;
        }
        return false;
      }
    }
    return false;
  }
  
  public Object get()
  {
    synchronized (this.e)
    {
      if (a()) {}
      for (;;)
      {
        Object localObject2 = this.a;
        if (localObject2 == null)
        {
          if (this.c) {
            break label66;
          }
          localObject2 = this.f;
          return localObject2;
          try
          {
            this.e.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            throw localInterruptedException;
          }
        }
      }
    }
    throw new ExecutionException(localThrowable);
    label66:
    throw new CancellationException("SettableFuture was cancelled.");
  }
  
  public Object get(long paramLong, TimeUnit paramTimeUnit)
  {
    synchronized (this.e)
    {
      if (a()) {}
      for (;;)
      {
        paramTimeUnit = this.a;
        if (paramTimeUnit == null)
        {
          if (!this.b) {
            break label90;
          }
          if (this.c) {
            break label100;
          }
          paramTimeUnit = this.f;
          return paramTimeUnit;
          try
          {
            paramLong = paramTimeUnit.toMillis(paramLong);
            if (paramLong != 0L) {
              this.e.wait(paramLong);
            }
          }
          catch (InterruptedException paramTimeUnit)
          {
            throw paramTimeUnit;
          }
        }
      }
    }
    throw new ExecutionException(paramTimeUnit);
    label90:
    throw new TimeoutException("SettableFuture timed out.");
    label100:
    throw new CancellationException("SettableFuture was cancelled.");
  }
  
  public boolean isCancelled()
  {
    synchronized (this.e)
    {
      boolean bool = this.c;
      return bool;
    }
  }
  
  public boolean isDone()
  {
    synchronized (this.e)
    {
      boolean bool = a();
      return bool;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */