package com.google.android.finsky.q;

import com.google.android.finsky.utils.FinskyLog;

final class f
  implements Runnable
{
  f(a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    a locala = this.a;
    if (locala.an)
    {
      FinskyLog.a("onSaveInstanceState() called, not firing onReady().", new Object[0]);
      locala = this.a;
      locala.N = true;
      locala.O = this.b;
      return;
    }
    locala.a(this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/q/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */