package com.google.android.finsky.af.a;

import com.google.android.finsky.af.e;
import com.google.android.finsky.af.f;
import com.google.android.finsky.utils.FinskyLog;
import java.util.concurrent.ExecutionException;

final class s
  implements f
{
  s(r paramr) {}
  
  public final void a(e parame)
  {
    n localn = this.a.a;
    localn.b = null;
    if (!localn.isCancelled())
    {
      if (!parame.isDone()) {
        FinskyLog.e("Future not done but listener called", new Object[0]);
      }
      if (parame.isCancelled()) {
        localn.cancel(false);
      }
    }
    else
    {
      return;
    }
    try
    {
      n.b(this.a.a, parame.get());
      return;
    }
    catch (ExecutionException parame)
    {
      n.c(this.a.a, parame.getCause());
      return;
    }
    catch (InterruptedException parame)
    {
      n.d(this.a.a, parame);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */