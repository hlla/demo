package com.google.android.finsky.af.a;

import java.util.concurrent.Executor;

final class a
  extends j
{
  a(Object paramObject, Executor paramExecutor)
  {
    super(new b(), paramExecutor);
    set(paramObject);
  }
  
  a(Throwable paramThrowable, Executor paramExecutor)
  {
    super(new c(), paramExecutor);
    setException(paramThrowable);
  }
  
  public final void run() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */