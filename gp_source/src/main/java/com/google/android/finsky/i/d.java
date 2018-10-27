package com.google.android.finsky.i;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.play.utils.b.a;

final class d
  implements Runnable
{
  d(c paramc) {}
  
  public final void run()
  {
    c localc = this.a;
    localc.d = false;
    long l1 = ((Long)com.google.android.finsky.ag.d.D.b()).longValue();
    long l2 = ((Integer)com.google.android.finsky.ag.d.C.b()).intValue();
    long l3 = SystemClock.elapsedRealtime();
    new Handler(Looper.getMainLooper()).postDelayed(new e(localc, l3, l1, l2), l2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/i/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */