package com.google.android.finsky.q;

import com.google.android.finsky.fd.h;
import com.google.android.finsky.utils.FinskyLog;

final class l
  implements Runnable
{
  l(a parama, boolean[] paramArrayOfBoolean, h paramh, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.d[0] != 0)
    {
      FinskyLog.c("Timeout waiting for UserSettings, continuing start anyways.", new Object[0]);
      ((com.google.android.finsky.fd.a)this.a.at.a()).b(this.c);
      this.a.h(this.b);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/q/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */