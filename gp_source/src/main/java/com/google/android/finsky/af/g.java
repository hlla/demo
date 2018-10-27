package com.google.android.finsky.af;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public abstract class g
  extends FutureTask
  implements e
{
  public g(Runnable paramRunnable, Object paramObject)
  {
    super(paramRunnable, paramObject);
  }
  
  public g(Callable paramCallable)
  {
    super(paramCallable);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */