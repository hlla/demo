package android.support.v4.app;

import android.a.a.a.a;
import android.a.a.a.e;
import android.a.b.n;
import android.a.b.t;
import android.a.b.y;
import android.a.b.z;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.content.h;
import android.support.v4.content.j;
import android.support.v4.g.f;

public final class bw
  extends y
  implements j
{
  public final Bundle g;
  public final int h;
  public final h i;
  public bx j;
  private n k;
  private h l;
  
  bw(int paramInt, Bundle paramBundle, h paramh1, h paramh2)
  {
    this.h = paramInt;
    this.g = paramBundle;
    this.i = paramh1;
    this.l = paramh2;
    paramBundle = this.i;
    if (paramBundle.i != null) {
      throw new IllegalStateException("There is already a listener registered");
    }
    paramBundle.i = this;
    paramBundle.h = paramInt;
  }
  
  final h a(n paramn, bu parambu)
  {
    parambu = new bx(this.i, parambu);
    a(paramn, parambu);
    bx localbx = this.j;
    if (localbx != null) {
      a(localbx);
    }
    this.k = paramn;
    this.j = parambu;
    return this.i;
  }
  
  final h a(boolean paramBoolean)
  {
    this.i.b();
    this.i.e = true;
    Object localObject = this.j;
    if (localObject != null)
    {
      a((z)localObject);
      if (paramBoolean) {
        break label109;
      }
    }
    for (;;)
    {
      h localh = this.i;
      j localj = localh.i;
      if (localj == null) {
        throw new IllegalStateException("No listener register");
      }
      if (localj != this) {
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
      }
      localh.i = null;
      if ((localObject == null) || (((bx)localObject).b))
      {
        localObject = localh;
        if (!paramBoolean) {}
      }
      else
      {
        localh.k();
        localObject = this.l;
      }
      return (h)localObject;
      label109:
      if (((bx)localObject).b) {
        ((bx)localObject).a.f_();
      }
    }
  }
  
  protected final void a()
  {
    h localh = this.i;
    localh.l = true;
    localh.k = false;
    localh.e = false;
    localh.g();
  }
  
  public final void a(z paramz)
  {
    super.a(paramz);
    this.k = null;
    this.j = null;
  }
  
  public final void a(Object paramObject)
  {
    super.a(paramObject);
    paramObject = this.l;
    if (paramObject != null)
    {
      ((h)paramObject).k();
      this.l = null;
    }
  }
  
  protected final void b()
  {
    h localh = this.i;
    localh.l = false;
    localh.h();
  }
  
  public final void b(Object paramObject)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      a(paramObject);
    }
    for (;;)
    {
      return;
      synchronized (this.d)
      {
        Object localObject2 = this.e;
        Object localObject3 = t.a;
        this.e = paramObject;
        if (localObject2 != localObject3) {
          continue;
        }
        a.a().b(this.f);
        return;
      }
    }
  }
  
  final void c()
  {
    n localn = this.k;
    bx localbx = this.j;
    if ((localn != null) && (localbx != null))
    {
      super.a(localbx);
      a(localn, localbx);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" : ");
    f.a(this.i, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */