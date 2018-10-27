package com.google.android.finsky.be;

import android.os.Handler;
import com.google.wireless.android.finsky.dfe.e.a.cl;

public final class l
{
  public d a;
  public cl b;
  public final Runnable c = new m(this);
  public final Handler d;
  
  public l(Handler paramHandler)
  {
    this.d = paramHandler;
  }
  
  public final void a()
  {
    this.d.removeCallbacks(this.c);
    this.b = null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */