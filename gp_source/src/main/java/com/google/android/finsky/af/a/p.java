package com.google.android.finsky.af.a;

import com.google.android.finsky.af.e;
import com.google.android.finsky.af.f;
import com.google.android.finsky.utils.FinskyLog;
import java.util.concurrent.ExecutionException;

final class p
  implements f
{
  p(n paramn, com.google.common.base.n paramn1) {}
  
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
      n.a(this.a, this.b.a(parame.get()));
      return;
    }
    catch (ExecutionException parame)
    {
      n.a(this.a, parame.getCause());
      return;
    }
    catch (Exception parame)
    {
      n.b(this.a, parame);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/af/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */