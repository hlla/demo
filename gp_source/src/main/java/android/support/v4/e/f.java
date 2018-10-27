package android.support.v4.e;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.os.Handler;

final class f
  implements Runnable
{
  f(Context paramContext, a parama, Handler paramHandler, s params) {}
  
  public final void run()
  {
    try
    {
      Object localObject = b.a(this.c, this.d);
      int i = ((q)localObject).b;
      if (i == 0)
      {
        localObject = ((q)localObject).a;
        if (localObject != null)
        {
          int j = localObject.length;
          if (j != 0)
          {
            i = 0;
            int k;
            for (;;)
            {
              if (i >= j)
              {
                localObject = b.a(this.c, (r[])localObject);
                if (localObject == null)
                {
                  this.b.post(new n(this));
                  return;
                }
                this.b.post(new o(this, (Typeface)localObject));
                return;
              }
              k = localObject[i].b;
              if (k != 0) {
                break;
              }
              i += 1;
            }
            if (k < 0)
            {
              this.b.post(new l(this));
              return;
            }
            this.b.post(new m(this, k));
            return;
          }
        }
        this.b.post(new k(this));
        return;
      }
      switch (i)
      {
      default: 
        this.b.post(new j(this));
        return;
      case 2: 
        this.b.post(new i(this));
        return;
      }
      this.b.post(new h(this));
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      this.b.post(new g(this));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */