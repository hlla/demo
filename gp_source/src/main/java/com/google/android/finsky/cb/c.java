package com.google.android.finsky.cb;

import android.os.Handler;

final class c
  implements Runnable
{
  c(a parama) {}
  
  public final void run()
  {
    a locala = this.a;
    locala.s.removeCallbacks(locala.c);
    this.a.d();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cb/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */