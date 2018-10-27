package com.google.android.finsky.af.a;

import com.google.android.finsky.af.a;
import com.google.android.finsky.af.e;
import com.google.android.finsky.af.f;
import com.google.android.finsky.utils.FinskyLog;
import java.util.concurrent.ExecutionException;

final class r
  implements f
{
  r(n paramn, a parama) {}
  
  public final void a(e parame)
  {
    n localn = this.a;
    localn.a = null;
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
      this.a.b = this.b.a(parame.get());
      this.a.b.a(new s(this));
      return;
    }
    catch (ExecutionException parame)
    {
      n.e(this.a, parame.getCause());
      return;
    }
    catch (Exception parame)
    {
      n.f(this.a, parame);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */