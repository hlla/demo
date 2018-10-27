package com.google.android.finsky.dm;

import java.util.List;
import java.util.Map;

final class g
  implements Runnable
{
  g(f paramf, Map paramMap) {}
  
  public final void run()
  {
    c localc = this.a.a;
    localc.b = this.b;
    int j = localc.d.size();
    int i = 0;
    while (i < j)
    {
      ((Runnable)localc.d.get(i)).run();
      i += 1;
    }
    localc.d.clear();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dm/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */