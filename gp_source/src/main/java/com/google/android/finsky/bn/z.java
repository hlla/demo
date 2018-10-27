package com.google.android.finsky.bn;

import com.google.common.util.concurrent.ab;
import com.google.common.util.concurrent.v;
import java.util.concurrent.Callable;

abstract class z
  extends ab
  implements w
{
  protected abstract w a();
  
  public final v a(Runnable paramRunnable)
  {
    return a().a(paramRunnable);
  }
  
  public final v a(Runnable paramRunnable, Object paramObject)
  {
    return a().a(paramRunnable, paramObject);
  }
  
  public final v a(Callable paramCallable)
  {
    return a().a(paramCallable);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */