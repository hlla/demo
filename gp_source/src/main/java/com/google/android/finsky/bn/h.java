package com.google.android.finsky.bn;

import com.google.common.util.concurrent.bd;
import com.google.common.util.concurrent.w;
import java.util.concurrent.TimeUnit;

final class h
  implements Runnable
{
  public final Runnable a = this;
  
  h(a parama, Runnable paramRunnable, bd parambd, j paramj, long paramLong, TimeUnit paramTimeUnit) {}
  
  public final void run()
  {
    this.b.execute(new i(this, this.c, this.e, this.f, this.d, this.g));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */