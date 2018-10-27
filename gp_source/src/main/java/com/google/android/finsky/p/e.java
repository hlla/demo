package com.google.android.finsky.p;

import android.os.Handler;
import java.util.Iterator;
import java.util.List;

final class e
  implements j
{
  e(d paramd, Handler paramHandler) {}
  
  public final void b(int paramInt)
  {
    Iterator localIterator = this.a.c.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      this.b.post(new f(localj, paramInt));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/p/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */