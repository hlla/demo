package com.google.android.gms.ads.internal.b;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.f.k;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.util.e;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  private b a = null;
  private final Object b = new Object();
  private boolean c = false;
  
  public final void a(Context paramContext)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (!this.c)
        {
          localObject1 = paramContext.getApplicationContext();
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = paramContext;
          }
          if (!(localObject2 instanceof Application)) {
            break label151;
          }
          localObject1 = (Application)localObject2;
          if (localObject1 == null) {
            break label142;
          }
          if (this.a != null)
          {
            localObject2 = this.a;
            if (!((b)localObject2).c)
            {
              ((Application)localObject1).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject2);
              if ((paramContext instanceof Activity)) {
                ((b)localObject2).a((Activity)paramContext);
              }
              paramContext = n.bf;
              ((b)localObject2).e = ((Long)u.h.e.a(paramContext)).longValue();
              ((b)localObject2).c = true;
            }
            this.c = true;
          }
        }
        else
        {
          return;
        }
        this.a = new b();
      }
      label142:
      e.e("Can not cast Context to Application");
      return;
      label151:
      Object localObject1 = null;
    }
  }
  
  public final void a(d paramd)
  {
    for (;;)
    {
      b localb;
      synchronized (this.b)
      {
        if (this.a != null) {
          localb = this.a;
        }
      }
      synchronized (localb.d)
      {
        localb.b.add(paramd);
        return;
        this.a = new b();
        continue;
        paramd = finally;
        throw paramd;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */