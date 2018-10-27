package android.support.v7.view;

import android.support.v4.view.az;
import android.support.v4.view.bc;
import android.support.v4.view.bd;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public final class l
{
  public final ArrayList a = new ArrayList();
  public boolean b;
  public bc c;
  private long d = -1L;
  private Interpolator e;
  private final bd f = new m(this);
  
  public final l a(az paramaz)
  {
    if (!this.b) {
      this.a.add(paramaz);
    }
    return this;
  }
  
  public final l a(bc parambc)
  {
    if (!this.b) {
      this.c = parambc;
    }
    return this;
  }
  
  public final l a(Interpolator paramInterpolator)
  {
    if (!this.b) {
      this.e = paramInterpolator;
    }
    return this;
  }
  
  public final void a()
  {
    if (!this.b)
    {
      ArrayList localArrayList = this.a;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        az localaz = (az)localArrayList.get(i);
        long l = this.d;
        if (l >= 0L) {
          localaz.a(l);
        }
        Interpolator localInterpolator = this.e;
        if (localInterpolator != null) {
          localaz.a(localInterpolator);
        }
        if (this.c != null) {
          localaz.a(this.f);
        }
        localaz.b();
        i += 1;
      }
      this.b = true;
    }
  }
  
  public final void b()
  {
    if (this.b)
    {
      ArrayList localArrayList = this.a;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((az)localArrayList.get(i)).a();
        i += 1;
      }
      this.b = false;
    }
  }
  
  public final l c()
  {
    if (!this.b) {
      this.d = 250L;
    }
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */