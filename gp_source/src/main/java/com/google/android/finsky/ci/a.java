package com.google.android.finsky.ci;

import java.util.concurrent.Executor;

public class a
{
  public final Executor a;
  
  public a(Executor paramExecutor)
  {
    this.a = paramExecutor;
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.a.execute(new b(paramRunnable));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ci/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */