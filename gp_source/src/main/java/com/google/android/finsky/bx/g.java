package com.google.android.finsky.bx;

import android.os.Handler;
import com.google.android.gms.car.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

final class g
  implements j
{
  g(b paramb) {}
  
  public final void a() {}
  
  public final void a(boolean paramBoolean)
  {
    b localb = this.a;
    localb.b = paramBoolean;
    if (localb.a.getCount() > 0L) {
      localb.a.countDown();
    }
    synchronized (localb.c)
    {
      ArrayList localArrayList = new ArrayList(localb.c);
      int j = localArrayList.size();
      int i = 0;
      if (i < j)
      {
        ??? = (h)localArrayList.get(i);
        localb.d.post(new f((h)???, paramBoolean));
        i += 1;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bx/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */