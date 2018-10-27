package android.a.b;

import android.a.a.a.a;
import android.a.a.a.e;
import android.a.a.b.b;
import android.a.a.b.f;
import java.util.Iterator;
import java.util.Map.Entry;

public class t
{
  public static final Object a = new Object();
  public int b = 0;
  public volatile Object c = a;
  public final Object d = new Object();
  public volatile Object e = a;
  public final Runnable f = new u(this);
  private boolean g;
  private boolean h;
  private b i = new b();
  private int j = -1;
  
  private static void a(String paramString)
  {
    if (!a.a().b())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot invoke ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" on a background");
      localStringBuilder.append(" thread");
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  private final void b(w paramw)
  {
    if (paramw.a)
    {
      if (paramw.a()) {
        break label20;
      }
      paramw.a(false);
    }
    label20:
    int k;
    int m;
    do
    {
      return;
      k = paramw.b;
      m = this.j;
    } while (k >= m);
    paramw.b = m;
    paramw.c.a(this.c);
  }
  
  public void a() {}
  
  public final void a(n paramn, z paramz)
  {
    if (paramn.P_().a() != l.b)
    {
      v localv = new v(this, paramn, paramz);
      paramz = (w)this.i.a(paramz, localv);
      if ((paramz != null) && (!paramz.a(paramn))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
      if (paramz == null) {
        paramn.P_().a(localv);
      }
    }
  }
  
  final void a(w paramw)
  {
    if (this.h)
    {
      this.g = true;
      return;
    }
    this.h = true;
    this.g = false;
    w localw;
    if (paramw != null)
    {
      b(paramw);
      localw = null;
    }
    for (;;)
    {
      paramw = localw;
      if (this.g) {
        break;
      }
      this.h = false;
      return;
      f localf = this.i.a();
      do
      {
        localw = paramw;
        if (!localf.hasNext()) {
          break;
        }
        b((w)((Map.Entry)localf.next()).getValue());
      } while (!this.g);
      localw = paramw;
    }
  }
  
  public void a(z paramz)
  {
    a("removeObserver");
    paramz = (w)this.i.b(paramz);
    if (paramz != null)
    {
      paramz.b();
      paramz.a(false);
    }
  }
  
  public void a(Object paramObject)
  {
    a("setValue");
    this.j += 1;
    this.c = paramObject;
    a(null);
  }
  
  public void b() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */