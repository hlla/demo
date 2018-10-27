package com.google.android.finsky.i;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.ao;

final class e
  implements Runnable
{
  e(c paramc, long paramLong1, long paramLong2, long paramLong3) {}
  
  public final void run()
  {
    if (!this.a.a.a())
    {
      this.a.a();
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.d;
    l1 = this.b - (l1 - l2);
    if (l1 <= 0L)
    {
      if ((!((Boolean)d.bt.b()).booleanValue()) || (!this.a.c.c()))
      {
        if (!this.a.b.a())
        {
          FinskyLog.c("Killing app as it has been scheduled for restart", new Object[0]);
          System.exit(0);
          return;
        }
        localc = this.a;
        l1 = ((Long)d.D.b()).longValue();
        l2 = this.c;
        l3 = SystemClock.elapsedRealtime();
        new Handler(Looper.getMainLooper()).postDelayed(new e(localc, l3, l1, l2), l2);
        return;
      }
      localc = this.a;
      l1 = ((Long)d.D.b()).longValue();
      l2 = this.c;
      l3 = SystemClock.elapsedRealtime();
      new Handler(Looper.getMainLooper()).postDelayed(new e(localc, l3, l1, l2), l2);
      return;
    }
    c localc = this.a;
    l2 = this.c;
    long l3 = SystemClock.elapsedRealtime();
    new Handler(Looper.getMainLooper()).postDelayed(new e(localc, l3, l1, l2), l2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/i/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */