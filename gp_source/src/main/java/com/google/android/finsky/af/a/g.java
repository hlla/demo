package com.google.android.finsky.af.a;

import com.google.android.finsky.af.c;
import com.google.android.finsky.af.e;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class g
  implements com.google.android.finsky.af.d
{
  private final Executor a;
  
  public g(Executor paramExecutor)
  {
    this.a = paramExecutor;
  }
  
  public final c a(ExecutorService paramExecutorService)
  {
    return new h(paramExecutorService, this.a);
  }
  
  public final e a(Iterable paramIterable)
  {
    return new d(paramIterable, true, this.a);
  }
  
  public final e a(Object paramObject)
  {
    return new a(paramObject, this.a);
  }
  
  public final e a(Throwable paramThrowable)
  {
    return new a(paramThrowable, this.a);
  }
  
  public final com.google.android.finsky.af.g a(Runnable paramRunnable)
  {
    return new j(paramRunnable, null, this.a);
  }
  
  public final com.google.android.finsky.af.g a(Callable paramCallable)
  {
    return new j(paramCallable, this.a);
  }
  
  public final e b(Iterable paramIterable)
  {
    return new d(paramIterable, false, this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */