package com.google.android.finsky.cq.d;

import android.support.v7.widget.di;
import android.support.v7.widget.dm;
import android.support.v7.widget.dn;
import android.support.v7.widget.dq;
import android.support.v7.widget.dr;
import android.support.v7.widget.ds;
import android.support.v7.widget.eh;
import android.support.v7.widget.fj;
import android.support.v7.widget.fz;
import android.view.View;
import com.google.android.finsky.cq.c.c;
import com.google.android.finsky.cq.c.f;

final class r
  implements o
{
  public final void a(ds paramds, di paramdi, f paramf, dq paramdq, int paramInt) {}
  
  public final void a(ds paramds, dr paramdr, di paramdi, f paramf)
  {
    View localView = paramds.a();
    if (localView == null)
    {
      paramdr.a();
      return;
    }
    if (paramds.a.j != null)
    {
      bool2 = paramdi.a();
      if (paramds.c() != -1) {}
      for (bool1 = false;; bool1 = true)
      {
        if (bool2 != bool1) {
          paramdi.e(localView);
        }
        for (;;)
        {
          c localc = (c)localView.getLayoutParams();
          localc.a(-1, -1, -1, 0, paramf.c(paramdi.a(localView), paramds), null, -1);
          paramdi.a(localView, 0, 0);
          paramf = paramdi.b();
          paramdr.a(paramf.e(localView));
          int i = paramds.a.h;
          int n = paramdr.a.a;
          int j;
          int k;
          int m;
          if (paramdi.c() == 1) {
            if (paramdi.d())
            {
              j = paramdi.e() - paramdi.j();
              k = j - paramf.f(localView);
              if (paramds.c() != -1)
              {
                m = i + n;
                n = i;
                i = j;
                j = n;
              }
            }
          }
          for (;;)
          {
            paramdi.a(localView, k, j, i, m);
            if ((localc.d.l()) || (localc.d.r())) {
              paramdr.b();
            }
            paramdr.a(localView.hasFocusable());
            return;
            n = i - n;
            m = i;
            i = j;
            j = n;
            continue;
            k = paramdi.i();
            j = paramf.f(localView) + k;
            break;
            j = paramdi.g();
            m = j + paramf.f(localView);
            if (paramds.c() != -1)
            {
              k = i;
              i += n;
            }
            else
            {
              k = i - n;
            }
          }
          paramdi.d(localView);
        }
      }
    }
    boolean bool2 = paramdi.a();
    if (paramds.c() != -1) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      if (bool2 != bool1)
      {
        paramdi.c(localView);
        break;
      }
      paramdi.b(localView);
      break;
    }
  }
  
  public final boolean a(int paramInt, ds paramds, f paramf)
  {
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cq/d/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */