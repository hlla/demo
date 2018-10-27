package com.google.android.finsky.ca;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.finsky.download.b;
import com.google.android.finsky.utils.FinskyLog;

public final class d
  extends a
{
  public final Context f;
  
  public d(Context paramContext, Handler paramHandler)
  {
    super(paramContext, paramHandler);
    this.f = paramContext;
  }
  
  public final void e(b paramb)
  {
    if ((this.a >= 0L) && (this.e >= 0L))
    {
      long l1 = paramb.n() - this.a;
      long l2 = 1000L * l1 / Math.max(1L, SystemClock.uptimeMillis() - this.e);
      paramb = this.d;
      a();
      if ((l2 >= 0L) && (l1 >= 0L)) {
        this.c.post(new e(this, paramb, l1, l2));
      }
    }
    else
    {
      return;
    }
    FinskyLog.c("Throughput or bytes transferred were calculated incorrectly or not at all", new Object[0]);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ca/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */