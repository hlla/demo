package com.google.android.finsky.ap;

import com.google.android.finsky.af.f;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.bg;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class c
  implements f
{
  public c(a parama, String paramString) {}
  
  public final void a(com.google.android.finsky.af.e parame)
  {
    int i = 0;
    bg.a();
    try
    {
      parame = (e)parame.get();
      if (parame != null)
      {
        Object localObject = this.a.d;
        localObject = (d[])((List)localObject).toArray(new d[((List)localObject).size()]);
        int j = localObject.length;
        while (i < j)
        {
          localObject[i].a(parame);
          i += 1;
        }
      }
    }
    catch (InterruptedException parame)
    {
      for (;;)
      {
        FinskyLog.d("Failed to fetch data usages stats for %s: %s", new Object[] { this.b, parame });
        parame = null;
      }
      return;
    }
    catch (ExecutionException parame)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ap/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */