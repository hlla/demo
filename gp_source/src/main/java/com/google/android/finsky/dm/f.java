package com.google.android.finsky.dm;

import android.os.Handler;
import java.util.Map;

final class f
  implements Runnable
{
  f(c paramc) {}
  
  public final void run()
  {
    Map localMap = this.a.a.a();
    this.a.c.post(new g(this, localMap));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dm/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */