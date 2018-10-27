package com.google.android.finsky.cb;

import android.os.Handler;
import com.google.android.finsky.utils.FinskyLog;

final class f
  implements com.google.android.finsky.dn.f
{
  f(e parame) {}
  
  public final void a()
  {
    a locala = this.a.a;
    locala.n = true;
    if (locala.t) {
      locala.s.removeCallbacks(locala.c);
    }
    this.a.a.d();
  }
  
  public final void a(Exception paramException)
  {
    FinskyLog.d("Failed to preload experiments flags: %s", new Object[] { paramException });
    paramException = this.a.a;
    if (paramException.t) {
      paramException.s.removeCallbacks(paramException.c);
    }
    this.a.a.d();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cb/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */