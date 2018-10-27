package com.google.android.finsky.af.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class t
  implements Executor
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  
  public final void execute(Runnable paramRunnable)
  {
    a.post(paramRunnable);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */