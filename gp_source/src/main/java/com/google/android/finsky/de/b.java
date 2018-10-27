package com.google.android.finsky.de;

import com.google.android.finsky.af.e;
import com.google.android.finsky.af.f;
import com.google.android.finsky.installqueue.InstallConstraint;
import com.google.android.finsky.installqueue.TimeWindow;
import com.google.android.finsky.installqueue.d;
import com.google.android.finsky.installqueue.g;
import com.google.android.finsky.installqueue.k;
import com.google.android.finsky.installqueue.n;
import com.google.android.finsky.utils.FinskyLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

final class b
  implements f
{
  b(a parama, com.google.wireless.android.finsky.dfe.r.a.a parama1) {}
  
  public final void a(e parame)
  {
    try
    {
      Object localObject1 = (List)parame.get();
      if (!((List)localObject1).isEmpty())
      {
        parame = new d().a(2).b();
        long l1 = TimeUnit.SECONDS.toMillis(this.b.c);
        long l2 = TimeUnit.SECONDS.toMillis(this.b.b);
        Object localObject2 = new d().a(3);
        ((d)localObject2).b = new TimeWindow(l1, l2);
        localObject2 = ((d)localObject2).b();
        ArrayList localArrayList = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext())
          {
            ((g)this.a.a.a()).a(localArrayList);
            return;
          }
          localArrayList.add(new k(((n)((Iterator)localObject1).next()).g).a(new InstallConstraint[] { parame, localObject2 }).a());
        }
      }
      return;
    }
    catch (InterruptedException parame)
    {
      FinskyLog.b(parame, "Unexpected exception", new Object[0]);
      return;
    }
    catch (ExecutionException parame)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/de/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */