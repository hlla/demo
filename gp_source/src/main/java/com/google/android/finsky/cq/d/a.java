package com.google.android.finsky.cq.d;

import android.graphics.Rect;
import android.support.v7.widget.di;
import android.support.v7.widget.dl;
import android.support.v7.widget.dn;
import android.support.v7.widget.dq;
import android.support.v7.widget.dr;
import android.support.v7.widget.ds;
import android.support.v7.widget.eh;
import android.support.v7.widget.ff;
import android.support.v7.widget.fj;
import android.support.v7.widget.fp;
import android.support.v7.widget.fw;
import android.support.v7.widget.fz;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.finsky.cq.c.c;
import java.util.Arrays;

abstract class a
  implements o
{
  private int[] a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private float g;
  private int h;
  private final b i;
  private final f j;
  private final Rect k = new Rect();
  private View[] l;
  
  a(f paramf, b paramb)
  {
    this.j = paramf;
    this.i = paramb;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != 0) {}
    while (paramInt3 != 0)
    {
      int n = MeasureSpec.getMode(paramInt1);
      int m = paramInt1;
      if (n != 0) {
        m = MeasureSpec.makeMeasureSpec(Math.max(0, MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), n);
      }
      return m;
    }
    return paramInt1;
  }
  
  private final int a(int paramInt1, int paramInt2, com.google.android.finsky.cq.c.f paramf, ds paramds)
  {
    int m = paramInt1 + 1;
    if (this.j.a(paramInt1, m, paramf, paramds))
    {
      paramInt1 = b(paramInt1, paramf, paramds) + paramInt2;
      if (b(m, paramf, paramds) + paramInt1 <= this.h) {
        return paramInt1;
      }
      return 0;
    }
    return 0;
  }
  
  private final int a(int paramInt, com.google.android.finsky.cq.c.f paramf, ds paramds)
  {
    int m = paramf.f(paramInt, paramds);
    int i1 = m;
    if (m == -1)
    {
      paramf.a(0, 0, paramds);
      int n = paramInt - 1;
      if (n > 0) {
        if (!this.j.a(paramInt, n, paramf, paramds))
        {
          m = n + 1;
          paramf.a(m, 0, paramds);
        }
      }
      for (;;)
      {
        i1 = paramf.f(m, paramds);
        n = m;
        m = i1;
        for (;;)
        {
          i1 = m;
          if (n >= paramInt) {
            break;
          }
          m = a(n, m, paramf, paramds);
          n += 1;
          paramf.a(n, m, paramds);
        }
        m = n;
        if (paramf.f(n, paramds) == -1)
        {
          n -= 1;
          break;
          m = 0;
        }
      }
    }
    return i1;
  }
  
  private static int a(di paramdi)
  {
    if (paramdi.c() == 1) {
      return paramdi.e() - paramdi.j() - paramdi.i();
    }
    return paramdi.f() - paramdi.h() - paramdi.g();
  }
  
  private final int a(c paramc, int paramInt1, int paramInt2)
  {
    int n = paramc.j;
    int m = paramc.l;
    int[] arrayOfInt = this.a;
    m = arrayOfInt[(m + n)];
    n = arrayOfInt[n];
    if (paramInt2 == 0) {}
    for (paramInt2 = paramc.height;; paramInt2 = paramc.width) {
      return ff.a(m - n, paramInt1, 0, paramInt2, false);
    }
  }
  
  private final com.google.android.finsky.cq.c.a a(int paramInt, ds paramds, com.google.android.finsky.cq.c.f paramf, di paramdi)
  {
    com.google.android.finsky.cq.c.a locala = paramf.e(paramInt, paramds);
    this.h = locala.g;
    this.a = locala.a;
    this.b = locala.c;
    this.e = locala.f;
    this.d = locala.e;
    this.c = locala.d;
    b();
    a(paramInt, a(paramdi), locala.b ^ true, locala, paramf, paramds, paramdi);
    return locala;
  }
  
  private static com.google.android.finsky.cq.d.a.a a(View paramView)
  {
    switch (((c)paramView.getLayoutParams()).f)
    {
    default: 
      throw new IllegalArgumentException("Unknown layout gravity.");
    case 2: 
      return com.google.android.finsky.cq.d.a.a.a;
    case 1: 
      return com.google.android.finsky.cq.d.a.a.c;
    }
    return com.google.android.finsky.cq.d.a.a.b;
  }
  
  private final void a(int paramInt1, int paramInt2, boolean paramBoolean, com.google.android.finsky.cq.c.a parama, com.google.android.finsky.cq.c.f paramf, ds paramds, di paramdi)
  {
    if (paramBoolean) {}
    while (this.a[this.h] != paramInt2)
    {
      View localView = paramds.b.a(paramInt1, Long.MAX_VALUE).c;
      if (paramds.b() == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(paramds, paramdi, paramBoolean, localView);
        c localc = (c)localView.getLayoutParams();
        int m = localc.i;
        int n = localc.l;
        int i1 = localc.j;
        localc.a(this.h, 1, 0, a(), localc.h, localc.k, localc.e);
        ds.a(localView);
        paramdi.a(localView, this.k);
        if (paramdi.c() == 1) {
          if (paramdi.d())
          {
            this.b = this.k.right;
            this.c = this.k.left;
          }
        }
        for (;;)
        {
          int i2 = this.h;
          localc.a(i2, 1, i2 - 1, a(), localc.h, localc.k, localc.e);
          ds.a(localView);
          paramdi.a(localView, this.k);
          if (paramdi.c() == 1) {
            if (paramdi.d())
            {
              this.d = this.k.right;
              this.e = this.k.left;
            }
          }
          for (;;)
          {
            localc.a(m, n, i1, a(), localc.h, localc.k, localc.e);
            ds.a(localView);
            m = this.b;
            n = this.e;
            i1 = this.d;
            i2 = this.c;
            parama.c = m;
            parama.f = n;
            parama.e = i1;
            parama.d = i2;
            paramdi.a(localView, paramds);
            paramInt1 = this.i.a(paramInt1, this.h, paramInt2, paramf, paramds, this.b, this.e, this.d, this.c);
            if (this.h != paramInt1)
            {
              this.h = paramInt1;
              parama.a(this.h);
              this.a = parama.a;
              b();
            }
            this.a[0] = 0;
            m = this.b;
            n = this.e;
            paramInt1 = this.h;
            paramInt2 = paramInt2 - m - n - (paramInt1 - 1) * (this.d + this.c);
            int i3 = paramInt2 / paramInt1;
            int i4 = paramInt2 % paramInt1;
            paramInt1 = 0;
            m = 0;
            paramInt2 = 1;
            int i5 = this.h;
            if (paramInt2 <= i5)
            {
              if (paramInt2 != 1) {}
              for (n = this.d;; n = this.b)
              {
                if (paramInt2 != i5) {}
                for (i1 = this.c;; i1 = this.e)
                {
                  i1 += i3 + n;
                  i2 = paramInt1 + i4;
                  if (i2 <= 0)
                  {
                    paramInt1 = i2;
                    n = i1;
                  }
                  for (;;)
                  {
                    m += n;
                    this.a[paramInt2] = m;
                    paramInt2 += 1;
                    break;
                    n = i1;
                    paramInt1 = i2;
                    if (i5 - i2 < i4)
                    {
                      n = i1 + 1;
                      paramInt1 = i2 - i5;
                    }
                  }
                }
              }
            }
            parama.b = true;
            return;
            this.d = this.k.left;
            this.e = this.k.right;
            continue;
            this.d = this.k.top;
            this.e = this.k.bottom;
          }
          this.b = this.k.left;
          this.c = this.k.right;
          continue;
          this.b = this.k.top;
          this.c = this.k.bottom;
        }
      }
    }
  }
  
  private static void a(ds paramds, di paramdi, boolean paramBoolean, View paramView)
  {
    if (paramds.a.j != null)
    {
      if (!paramBoolean)
      {
        paramdi.e(paramView);
        return;
      }
      paramdi.d(paramView);
      return;
    }
    if (!paramBoolean)
    {
      paramdi.c(paramView);
      return;
    }
    paramdi.b(paramView);
  }
  
  private final void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, di paramdi)
  {
    paramdi.a(paramView, this.k);
    c localc = (c)paramView.getLayoutParams();
    int m;
    if (!paramBoolean1)
    {
      m = paramInt1;
      if (paramdi.c() != 1) {}
    }
    else
    {
      m = a(paramInt1, localc.leftMargin + this.k.left, localc.rightMargin + this.k.right);
    }
    if (paramBoolean1) {
      paramInt2 = a(paramInt2, localc.topMargin + this.k.top, localc.bottomMargin + this.k.bottom);
    }
    for (;;)
    {
      if (!paramBoolean2) {}
      for (paramBoolean1 = paramdi.b(paramView, m, paramInt2, localc);; paramBoolean1 = paramdi.a(paramView, m, paramInt2, localc))
      {
        if (paramBoolean1) {
          paramView.measure(m, paramInt2);
        }
        return;
      }
      if (paramdi.c() == 0) {
        break;
      }
    }
  }
  
  private final void a(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, di paramdi)
  {
    int m = paramdi.c();
    eh localeh = paramdi.b();
    c localc = (c)paramView.getLayoutParams();
    int n = a(localc, paramInt, m);
    int i1 = localeh.e();
    int i2 = localeh.g();
    if (m == 1) {}
    for (paramInt = localc.height;; paramInt = localc.width)
    {
      paramInt = ff.a(i1, i2, 0, paramInt, true);
      if (m == 1)
      {
        a(paramView, n, paramInt, paramBoolean1, paramBoolean2, paramdi);
        return;
      }
      a(paramView, paramInt, n, paramBoolean1, paramBoolean2, paramdi);
      return;
    }
  }
  
  private final int b(int paramInt, com.google.android.finsky.cq.c.f paramf, ds paramds)
  {
    paramInt = paramf.a(paramInt, paramds);
    int m = this.h;
    if (paramInt > m) {
      return m;
    }
    return paramInt;
  }
  
  private final void b()
  {
    View[] arrayOfView = this.l;
    if ((arrayOfView == null) || (arrayOfView.length < this.h)) {
      this.l = new View[this.h];
    }
  }
  
  public abstract int a();
  
  public void a(ds paramds, di paramdi, com.google.android.finsky.cq.c.f paramf, dq paramdq, int paramInt)
  {
    a(paramdq.a.d, paramds, paramf, paramdi);
    int m;
    if ((paramds.c.a() > 0) && (!paramds.c.e))
    {
      n = paramdq.a.d;
      m = a(n, paramf, paramds);
      if (paramInt != 1)
      {
        int i1 = paramds.c.a();
        paramInt = n;
        n = m;
        for (;;)
        {
          m = paramInt;
          if (paramInt >= i1 - 1) {
            break;
          }
          n = a(paramInt, n, paramf, paramds);
          m = paramInt;
          if (n == 0) {
            break;
          }
          paramInt += 1;
        }
        paramdq.a.d = m;
      }
    }
    else
    {
      b();
      return;
    }
    paramInt = n;
    int n = m;
    for (;;)
    {
      m = paramInt;
      if (n <= 0) {
        break;
      }
      m = paramInt;
      if (paramInt <= 0) {
        break;
      }
      paramInt -= 1;
      n -= b(paramInt, paramf, paramds);
    }
  }
  
  public void a(ds paramds, dr paramdr, di paramdi, com.google.android.finsky.cq.c.f paramf)
  {
    int i5 = paramds.a.b;
    Object localObject1 = a(i5, paramds, paramf, paramdi);
    a(i5, a(paramdi), ((com.google.android.finsky.cq.c.a)localObject1).b ^ true, (com.google.android.finsky.cq.c.a)localObject1, paramf, paramds, paramdi);
    int i9 = paramdi.c();
    eh localeh = paramdi.b();
    int i1 = paramds.b();
    if (i1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {}
      for (int m = a(i5, paramf, paramds) + b(i5, paramf, paramds);; m = this.h)
      {
        int i3 = 0;
        int n = m;
        if ((i3 >= this.h) || (!paramds.a.a(paramds.c))) {}
        label1567:
        for (;;)
        {
          Object localObject2;
          if (i3 != 0)
          {
            if (!bool) {}
            for (m = i3 - 1;; m = 0)
            {
              if (i1 == 1) {}
              for (n = i3;; n = -1)
              {
                if (i1 == 1) {}
                for (i1 = 1;; i1 = -1)
                {
                  int i2 = 0;
                  Object localObject3;
                  int i4;
                  int i6;
                  int i7;
                  int i8;
                  if (m != n)
                  {
                    localObject3 = this.l[m];
                    localObject2 = (c)((View)localObject3).getLayoutParams();
                    i4 = paramdi.a((View)localObject3);
                    i6 = b(i4, paramf, paramds);
                    if ((i6 != ((c)localObject2).l) || (i2 != ((c)localObject2).j)) {
                      ds.a((View)localObject3);
                    }
                    i7 = this.h;
                    i8 = a();
                    int i10 = paramf.c(i4, paramds);
                    localObject3 = paramf.d(i4, paramds);
                    if (this.i == b.a) {}
                    for (i4 = paramf.g(i4, paramds);; i4 = -1)
                    {
                      ((c)localObject2).a(i7, i6, i2, i8, i10, (String)localObject3, i4);
                      i2 += ((c)localObject2).l;
                      m += i1;
                      break;
                    }
                  }
                  this.f = 0;
                  this.g = 0.0F;
                  m = 0;
                  float f1;
                  if (m < i3)
                  {
                    localObject2 = this.l[m];
                    localObject3 = (c)((View)localObject2).getLayoutParams();
                    if (i9 == 1) {}
                    for (n = ((c)localObject3).height;; n = ((c)localObject3).width)
                    {
                      if (n == -1) {}
                      for (bool = true;; bool = false)
                      {
                        a((View)localObject2, localeh.h(), bool, false, paramdi);
                        n = localeh.e((View)localObject2);
                        if (n > this.f) {
                          this.f = n;
                        }
                        i2 = localeh.f((View)localObject2);
                        localObject2 = (c)((View)localObject2).getLayoutParams();
                        i4 = ((c)localObject2).l;
                        i1 = ((c)localObject2).j;
                        if (i1 != 0) {}
                        for (n = this.d;; n = this.b)
                        {
                          if (i1 + i4 != this.h) {}
                          for (i1 = this.c;; i1 = this.e)
                          {
                            f1 = (i2 - n - i1 - (i4 - 1) * (this.d + this.c)) / i4;
                            if (f1 <= this.g) {}
                            for (;;)
                            {
                              m += 1;
                              break;
                              this.g = f1;
                            }
                          }
                        }
                      }
                    }
                  }
                  if (localeh.h() != 1073741824)
                  {
                    f1 = this.g;
                    if (((com.google.android.finsky.cq.c.a)localObject1).b) {}
                    for (m = this.a[this.h];; m = 0)
                    {
                      n = this.h;
                      a(i5, Math.max(Math.round(f1 * n + this.b + this.e + (n - 1) * (this.d + this.c)), m), true, (com.google.android.finsky.cq.c.a)localObject1, paramf, paramds, paramdi);
                      this.f = 0;
                      m = 0;
                      if (m >= i3) {
                        break;
                      }
                      paramf = this.l[m];
                      a(paramf, 1073741824, false, true, paramdi);
                      n = localeh.e(paramf);
                      if (n <= this.f) {}
                      for (;;)
                      {
                        m += 1;
                        break;
                        this.f = n;
                      }
                    }
                  }
                  n = MeasureSpec.makeMeasureSpec(this.f, 1073741824);
                  m = 0;
                  if (m < i3)
                  {
                    paramf = this.l[m];
                    if (localeh.e(paramf) == this.f) {}
                    for (;;)
                    {
                      m += 1;
                      break;
                      if (a(paramf).a())
                      {
                        i1 = a((c)paramf.getLayoutParams(), 1073741824, i9);
                        if (i9 == 1) {
                          a(paramf, i1, n, true, true, paramdi);
                        } else {
                          a(paramf, n, i1, true, true, paramdi);
                        }
                      }
                    }
                  }
                  paramdr.a(this.f);
                  n = paramds.a.h;
                  if (i9 == 1) {
                    if (paramds.c() == -1)
                    {
                      i2 = n - this.f;
                      m = 0;
                      i4 = 0;
                      i1 = n;
                      n = i4;
                    }
                  }
                  for (;;)
                  {
                    i8 = 0;
                    i4 = i1;
                    i5 = i2;
                    i2 = n;
                    i1 = m;
                    n = i5;
                    m = i4;
                    if (i8 < i3)
                    {
                      paramds = this.l[i8];
                      paramf = (c)paramds.getLayoutParams();
                      if (i9 == 1) {
                        if (paramdi.d())
                        {
                          i1 = paramdi.i();
                          localObject1 = this.a;
                          i1 = i1 + localObject1[this.h] - localObject1[paramf.j];
                          i2 = i1 - localeh.f(paramds);
                        }
                      }
                      for (;;)
                      {
                        localObject1 = a(paramds);
                        i7 = localeh.e(paramds);
                        if (i9 == 1)
                        {
                          i5 = ((com.google.android.finsky.cq.d.a.a)localObject1).a(n, m, i7);
                          i7 = ((com.google.android.finsky.cq.d.a.a)localObject1).b(n, m, i7);
                          i6 = i1;
                          i4 = i2;
                        }
                        for (;;)
                        {
                          paramdi.a(paramds, i4, i5, i6, i7);
                          if ((!paramf.d.l()) && (!paramf.d.r())) {}
                          for (;;)
                          {
                            if (!paramds.hasFocusable()) {}
                            for (;;)
                            {
                              i8 += 1;
                              break;
                              paramdr.a(true);
                            }
                            paramdr.b();
                          }
                          if (paramdi.d())
                          {
                            i6 = ((com.google.android.finsky.cq.d.a.a)localObject1).a(i1, i2, i7);
                            i4 = ((com.google.android.finsky.cq.d.a.a)localObject1).b(i1, i2, i7);
                            i7 = m;
                            i5 = n;
                          }
                          else
                          {
                            i4 = ((com.google.android.finsky.cq.d.a.a)localObject1).a(i2, i1, i7);
                            i6 = ((com.google.android.finsky.cq.d.a.a)localObject1).b(i2, i1, i7);
                            i7 = m;
                            i5 = n;
                          }
                        }
                        i2 = paramdi.i() + this.a[paramf.j];
                        i1 = i2 + localeh.f(paramds);
                        continue;
                        n = paramdi.g() + this.a[paramf.j];
                        m = n + localeh.f(paramds);
                      }
                    }
                    Arrays.fill(this.l, null);
                    return;
                    i1 = this.f;
                    m = 0;
                    i1 = n + i1;
                    i2 = n;
                    n = 0;
                    continue;
                    if (paramds.c() == -1)
                    {
                      m = this.f;
                      i2 = 0;
                      i1 = 0;
                      i4 = n - m;
                      m = n;
                      n = i4;
                    }
                    else
                    {
                      m = this.f + n;
                      i2 = 0;
                      i1 = 0;
                    }
                  }
                }
              }
            }
          }
          paramdr.a();
          return;
          if (n > 0)
          {
            m = paramds.a.b;
            if (this.j.a(i5, m, paramf, paramds))
            {
              m = b(m, paramf, paramds);
              if (n >= m)
              {
                localObject2 = paramds.a();
                if (localObject2 != null) {
                  this.l[i3] = localObject2;
                }
              }
            }
            for (;;)
            {
              if (m == -1) {
                break label1567;
              }
              a(paramds, paramdi, bool, this.l[i3]);
              i3 += 1;
              n -= m;
              break;
              m = -1;
              continue;
              m = -1;
              continue;
              m = -1;
            }
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt, ds paramds, com.google.android.finsky.cq.c.f paramf)
  {
    return a(paramInt, paramf, paramds) == 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cq/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */