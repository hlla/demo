package android.support.v7.widget;

import android.graphics.PointF;
import android.os.Parcelable;
import android.support.v4.view.ac;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends ff
  implements fv
{
  public int a = 2;
  public int b = 1;
  public eh c;
  public boolean d = false;
  private final dl r = new dl();
  private final dm s = new dm();
  private dn t;
  private LinearLayoutManager.SavedState u = null;
  private int v = -1;
  private int w = Integer.MIN_VALUE;
  private boolean x = false;
  private boolean y = true;
  
  public LinearLayoutManager()
  {
    this(1, false);
  }
  
  public LinearLayoutManager(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {}
    while (paramInt == 1)
    {
      a(null);
      if ((paramInt == this.b) && (this.c != null))
      {
        a(null);
        if (paramBoolean != this.x)
        {
          this.x = paramBoolean;
          v();
        }
        return;
      }
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("invalid orientation");
      }
      for (localObject = new ei(this);; localObject = new ej(this))
      {
        this.c = ((eh)localObject);
        this.r.c = this.c;
        this.b = paramInt;
        v();
        break;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invalid orientation:");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private final void E()
  {
    if ((this.b == 1) || (!d()))
    {
      this.d = this.x;
      return;
    }
    this.d = (this.x ^ true);
  }
  
  private final boolean F()
  {
    return (this.c.g() == 0) && (this.c.d() == 0);
  }
  
  private final View G()
  {
    if (this.d) {}
    for (int i = w() - 1;; i = 0) {
      return d(i);
    }
  }
  
  private final View H()
  {
    if (!this.d) {}
    for (int i = w() - 1;; i = 0) {
      return d(i);
    }
  }
  
  private final View I()
  {
    return g(0, w());
  }
  
  private final View J()
  {
    return g(w() - 1, -1);
  }
  
  private final int a(int paramInt, fp paramfp, fw paramfw, boolean paramBoolean)
  {
    int i = this.c.c() - paramInt;
    if (i > 0)
    {
      int j = -d(-i, paramfp, paramfw);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.c.c() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.c.a(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private final int a(fp paramfp, dn paramdn, fw paramfw, boolean paramBoolean)
  {
    int k = paramdn.a;
    int i = paramdn.k;
    if (i == Integer.MIN_VALUE) {}
    for (;;)
    {
      int j = paramdn.a + paramdn.c;
      dm localdm = this.s;
      if (paramdn.d) {}
      for (;;)
      {
        if (paramdn.a(paramfw))
        {
          localdm.a = 0;
          localdm.b = false;
          localdm.d = false;
          localdm.c = false;
          a(paramfp, paramfw, paramdn, localdm);
          if (!localdm.b)
          {
            i = paramdn.h;
            int m = localdm.a;
            paramdn.h = (i + paramdn.g * m);
            if ((localdm.d) && (this.t.j == null)) {
              break label234;
            }
            paramdn.a -= m;
            i = j - m;
            label155:
            j = paramdn.k;
            if (j != Integer.MIN_VALUE)
            {
              paramdn.k = (j + m);
              j = paramdn.a;
              if (j < 0) {
                paramdn.k = (j + paramdn.k);
              }
              a(paramfp, paramdn);
            }
            j = i;
            if (!paramBoolean) {
              break;
            }
            j = i;
            if (!localdm.c) {
              break;
            }
          }
        }
        label234:
        do
        {
          return k - paramdn.a;
          if (!paramfw.e) {
            break;
          }
          i = j;
          break label155;
        } while (j <= 0);
      }
      if (k < 0) {
        paramdn.k = (i + k);
      }
      a(paramfp, paramdn);
    }
  }
  
  private final View a(boolean paramBoolean)
  {
    if (this.d) {
      return a(w() - 1, -1, paramBoolean, true);
    }
    return a(0, w(), paramBoolean, true);
  }
  
  private final void a(int paramInt1, int paramInt2, boolean paramBoolean, fw paramfw)
  {
    int i = -1;
    int j = 1;
    this.t.d = F();
    this.t.c = h(paramfw);
    paramfw = this.t;
    paramfw.g = paramInt1;
    dn localdn2;
    if (paramInt1 == 1)
    {
      paramfw.c += this.c.f();
      paramfw = H();
      localdn1 = this.t;
      if (!this.d) {}
      for (paramInt1 = j;; paramInt1 = -1)
      {
        localdn1.e = paramInt1;
        paramInt1 = a(paramfw);
        localdn2 = this.t;
        localdn1.b = (paramInt1 + localdn2.e);
        localdn2.h = this.c.b(paramfw);
        paramInt1 = this.c.b(paramfw) - this.c.c();
        paramfw = this.t;
        paramfw.a = paramInt2;
        if (paramBoolean) {
          paramfw.a -= paramInt1;
        }
        paramfw.k = paramInt1;
        return;
      }
    }
    paramfw = G();
    dn localdn1 = this.t;
    localdn1.c += this.c.b();
    localdn1 = this.t;
    if (!this.d) {}
    for (paramInt1 = i;; paramInt1 = 1)
    {
      localdn1.e = paramInt1;
      paramInt1 = a(paramfw);
      localdn2 = this.t;
      localdn1.b = (paramInt1 + localdn2.e);
      localdn2.h = this.c.a(paramfw);
      paramInt1 = -this.c.a(paramfw) + this.c.b();
      break;
    }
  }
  
  private final void a(dl paramdl)
  {
    e(paramdl.d, paramdl.a);
  }
  
  private final void a(fp paramfp, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      int i = paramInt1;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          a(paramInt2, paramfp);
          paramInt2 -= 1;
        }
      }
      while (i > paramInt2)
      {
        a(i, paramfp);
        i -= 1;
      }
    }
  }
  
  private final void a(fp paramfp, dn paramdn)
  {
    int i;
    int j;
    int k;
    if ((paramdn.i) && (!paramdn.d))
    {
      if (paramdn.g != -1) {
        break label171;
      }
      i = paramdn.k;
      j = w();
      if (i >= 0)
      {
        k = this.c.d() - i;
        if (this.d) {
          break label116;
        }
        j -= 1;
        i = j;
        while (i >= 0)
        {
          paramdn = d(i);
          if ((this.c.a(paramdn) >= k) && (this.c.d(paramdn) >= k)) {
            i -= 1;
          } else {
            a(paramfp, j, i);
          }
        }
      }
    }
    for (;;)
    {
      return;
      label116:
      i = 0;
      while (i < j)
      {
        paramdn = d(i);
        if ((this.c.a(paramdn) < k) || (this.c.d(paramdn) < k)) {
          break label163;
        }
        i += 1;
      }
      continue;
      label163:
      a(paramfp, 0, i);
      return;
      label171:
      k = paramdn.k;
      if (k >= 0)
      {
        j = w();
        if (this.d)
        {
          j -= 1;
          i = j;
          while (i >= 0)
          {
            paramdn = d(i);
            if ((this.c.b(paramdn) > k) || (this.c.c(paramdn) > k)) {
              break label247;
            }
            i -= 1;
          }
          continue;
          label247:
          a(paramfp, j, i);
        }
        else
        {
          i = 0;
          while (i < j)
          {
            paramdn = d(i);
            if ((this.c.b(paramdn) > k) || (this.c.c(paramdn) > k)) {
              break label303;
            }
            i += 1;
          }
        }
      }
    }
    label303:
    a(paramfp, 0, i);
  }
  
  private final int b(int paramInt, fp paramfp, fw paramfw, boolean paramBoolean)
  {
    int i = paramInt - this.c.b();
    if (i > 0)
    {
      int j = -d(i, paramfp, paramfw);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.c.b();
        i = j;
        if (paramInt > 0)
        {
          this.c.a(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private final View b(boolean paramBoolean)
  {
    if (this.d) {
      return a(0, w(), paramBoolean, true);
    }
    return a(w() - 1, -1, paramBoolean, true);
  }
  
  private final void b(dl paramdl)
  {
    f(paramdl.d, paramdl.a);
  }
  
  private final int d(int paramInt, fp paramfp, fw paramfw)
  {
    if ((w() != 0) && (paramInt != 0))
    {
      this.t.i = true;
      p();
      if (paramInt > 0) {}
      for (int i = 1;; i = -1)
      {
        int j = Math.abs(paramInt);
        a(i, j, true, paramfw);
        dn localdn = this.t;
        int k = localdn.k;
        k = a(paramfp, localdn, paramfw, false) + k;
        if (k >= 0)
        {
          if (j > k) {
            paramInt = i * k;
          }
          this.c.a(-paramInt);
          this.t.f = paramInt;
          return paramInt;
        }
        return 0;
      }
    }
    return 0;
  }
  
  private final View d(fp paramfp, fw paramfw)
  {
    return a(paramfp, paramfw, 0, w(), paramfw.a());
  }
  
  private final View e(fp paramfp, fw paramfw)
  {
    return a(paramfp, paramfw, w() - 1, -1, paramfw.a());
  }
  
  private final void e(int paramInt1, int paramInt2)
  {
    this.t.a = (this.c.c() - paramInt2);
    dn localdn = this.t;
    if (!this.d) {}
    for (int i = 1;; i = -1)
    {
      localdn.e = i;
      localdn.b = paramInt1;
      localdn.g = 1;
      localdn.h = paramInt2;
      localdn.k = Integer.MIN_VALUE;
      return;
    }
  }
  
  private final void f(int paramInt1, int paramInt2)
  {
    this.t.a = (paramInt2 - this.c.b());
    dn localdn = this.t;
    localdn.b = paramInt1;
    if (!this.d) {}
    for (paramInt1 = -1;; paramInt1 = 1)
    {
      localdn.e = paramInt1;
      localdn.g = -1;
      localdn.h = paramInt2;
      localdn.k = Integer.MIN_VALUE;
      return;
    }
  }
  
  private final View g(int paramInt1, int paramInt2)
  {
    p();
    if (paramInt2 > paramInt1) {}
    while (paramInt2 < paramInt1)
    {
      int j = this.c.a(d(paramInt1));
      int k = this.c.b();
      if (j < k) {}
      for (int i = 16388;; i = 4097)
      {
        if (j < k) {}
        for (j = 16644;; j = 4161)
        {
          if (this.b == 0) {
            return this.i.a(paramInt1, paramInt2, j, i);
          }
          return this.o.a(paramInt1, paramInt2, j, i);
        }
      }
    }
    return d(paramInt1);
  }
  
  private final int h(fw paramfw)
  {
    if (paramfw.m != -1) {
      return this.c.e();
    }
    return 0;
  }
  
  private final int i(fw paramfw)
  {
    int j = 0;
    int i = j;
    eh localeh;
    View localView1;
    View localView2;
    boolean bool1;
    if (w() != 0)
    {
      p();
      localeh = this.c;
      localView1 = a(this.y ^ true);
      localView2 = b(this.y ^ true);
      bool1 = this.y;
      boolean bool2 = this.d;
      i = j;
      if (w() != 0)
      {
        i = j;
        if (paramfw.a() != 0)
        {
          i = j;
          if (localView1 != null)
          {
            i = j;
            if (localView2 != null)
            {
              i = Math.min(a(localView1), a(localView2));
              j = Math.max(a(localView1), a(localView2));
              if (!bool2) {
                break label209;
              }
            }
          }
        }
      }
    }
    label209:
    for (j = Math.max(0, paramfw.a() - j - 1);; j = Math.max(0, i))
    {
      i = j;
      if (bool1) {
        i = Math.round(j * (Math.abs(localeh.b(localView2) - localeh.a(localView1)) / (Math.abs(a(localView1) - a(localView2)) + 1)) + (localeh.b() - localeh.a(localView1)));
      }
      return i;
    }
  }
  
  private final int j(fw paramfw)
  {
    int j = 0;
    int i = j;
    View localView1;
    View localView2;
    if (w() != 0)
    {
      p();
      eh localeh = this.c;
      localView1 = a(this.y ^ true);
      localView2 = b(this.y ^ true);
      boolean bool = this.y;
      i = j;
      if (w() != 0)
      {
        i = j;
        if (paramfw.a() != 0)
        {
          i = j;
          if (localView1 != null)
          {
            i = j;
            if (localView2 != null)
            {
              if (!bool) {
                break label118;
              }
              i = localeh.b(localView2);
              j = localeh.a(localView1);
              i = Math.min(localeh.e(), i - j);
            }
          }
        }
      }
    }
    return i;
    label118:
    return Math.abs(a(localView1) - a(localView2)) + 1;
  }
  
  private final int k(fw paramfw)
  {
    int j = 0;
    int i = j;
    if (w() != 0)
    {
      p();
      eh localeh = this.c;
      View localView1 = a(this.y ^ true);
      View localView2 = b(this.y ^ true);
      boolean bool = this.y;
      i = j;
      if (w() != 0)
      {
        i = j;
        if (paramfw.a() != 0)
        {
          i = j;
          if (localView1 != null)
          {
            i = j;
            if (localView2 != null)
            {
              if (!bool) {
                break label134;
              }
              i = (int)((localeh.b(localView2) - localeh.a(localView1)) / (Math.abs(a(localView1) - a(localView2)) + 1) * paramfw.a());
            }
          }
        }
      }
    }
    return i;
    label134:
    return paramfw.a();
  }
  
  public final int a(int paramInt, fp paramfp, fw paramfw)
  {
    if (this.b != 1) {
      return d(paramInt, paramfp, paramfw);
    }
    return 0;
  }
  
  public final View a(int paramInt)
  {
    int i = w();
    if (i != 0)
    {
      int j = paramInt - a(d(0));
      View localView1;
      if ((j >= 0) && (j < i))
      {
        View localView2 = d(j);
        localView1 = localView2;
        if (a(localView2) == paramInt) {}
      }
      else
      {
        localView1 = super.a(paramInt);
      }
      return localView1;
    }
    return null;
  }
  
  public final View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 320;
    p();
    if (!paramBoolean1) {}
    for (int i = 320;; i = 24579)
    {
      if (!paramBoolean2) {
        j = 0;
      }
      if (this.b == 0) {
        return this.i.a(paramInt1, paramInt2, i, j);
      }
      return this.o.a(paramInt1, paramInt2, i, j);
    }
  }
  
  View a(fp paramfp, fw paramfw, int paramInt1, int paramInt2, int paramInt3)
  {
    paramfp = null;
    p();
    int j = this.c.b();
    int k = this.c.c();
    if (paramInt2 > paramInt1) {}
    for (int i = 1;; i = -1)
    {
      paramfw = null;
      Object localObject;
      if (paramInt1 != paramInt2)
      {
        View localView = d(paramInt1);
        int m = a(localView);
        if (m < 0) {}
        for (;;)
        {
          paramInt1 += i;
          break;
          if (m < paramInt3) {
            if (!((fj)localView.getLayoutParams()).d.l())
            {
              if (this.c.a(localView) < k)
              {
                localObject = localView;
                if (this.c.b(localView) >= j) {
                  break label161;
                }
              }
              if (paramfp == null) {
                paramfp = localView;
              }
            }
            else if (paramfw == null)
            {
              paramfw = localView;
            }
          }
        }
      }
      if (paramfp != null)
      {
        localObject = paramfp;
        label161:
        return (View)localObject;
      }
      return paramfw;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.v = paramInt1;
    this.w = paramInt2;
    LinearLayoutManager.SavedState localSavedState = this.u;
    if (localSavedState != null) {
      localSavedState.c = -1;
    }
    v();
  }
  
  public final void a(int paramInt1, int paramInt2, fw paramfw, fi paramfi)
  {
    if (this.b != 0) {}
    for (;;)
    {
      if ((w() != 0) && (paramInt2 != 0))
      {
        p();
        if (paramInt2 <= 0) {
          break label81;
        }
      }
      label81:
      for (paramInt1 = 1;; paramInt1 = -1)
      {
        a(paramInt1, Math.abs(paramInt2), true, paramfw);
        dn localdn = this.t;
        paramInt1 = localdn.b;
        if ((paramInt1 >= 0) && (paramInt1 < paramfw.a())) {
          paramfi.a(paramInt1, Math.max(0, localdn.k));
        }
        return;
      }
      paramInt2 = paramInt1;
    }
  }
  
  public final void a(int paramInt, fi paramfi)
  {
    LinearLayoutManager.SavedState localSavedState = this.u;
    boolean bool1;
    int i;
    if ((localSavedState != null) && (localSavedState.a()))
    {
      localSavedState = this.u;
      bool1 = localSavedState.a;
      i = localSavedState.c;
    }
    for (;;)
    {
      if (!bool1) {}
      for (int j = 1;; j = -1)
      {
        int m = 0;
        int k = i;
        i = m;
        while ((i < this.a) && (k >= 0) && (k < paramInt))
        {
          paramfi.a(k, 0);
          k += j;
          i += 1;
        }
      }
      E();
      boolean bool2 = this.d;
      j = this.v;
      i = j;
      bool1 = bool2;
      if (j == -1) {
        if (bool2)
        {
          i = paramInt - 1;
          bool1 = bool2;
        }
        else
        {
          i = 0;
          bool1 = bool2;
        }
      }
    }
  }
  
  public final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof LinearLayoutManager.SavedState))
    {
      this.u = ((LinearLayoutManager.SavedState)paramParcelable);
      v();
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new dt(paramRecyclerView.getContext());
    paramRecyclerView.f = paramInt;
    a(paramRecyclerView);
  }
  
  public void a(fp paramfp, fw paramfw)
  {
    if (((this.u != null) || (this.v != -1)) && (paramfw.a() == 0))
    {
      b(paramfp);
      return;
    }
    Object localObject1 = this.u;
    if ((localObject1 != null) && (((LinearLayoutManager.SavedState)localObject1).a())) {
      this.v = this.u.c;
    }
    p();
    this.t.i = false;
    E();
    localObject1 = x();
    Object localObject2 = this.r;
    int i;
    if ((!((dl)localObject2).e) || (this.v != -1) || (this.u != null))
    {
      ((dl)localObject2).a();
      localObject2 = this.r;
      ((dl)localObject2).b = this.d;
      if (!paramfw.e)
      {
        i = this.v;
        if (i != -1) {}
      }
      else if (w() != 0)
      {
        localObject1 = x();
        if (localObject1 == null) {
          label164:
          if (((dl)localObject2).b) {
            if (this.d)
            {
              localObject1 = d(paramfp, paramfw);
              label187:
              if (localObject1 == null) {
                break label1592;
              }
              ((dl)localObject2).b((View)localObject1, a((View)localObject1));
              if ((!paramfw.e) && (u()) && ((this.c.a((View)localObject1) >= this.c.c()) || (this.c.b((View)localObject1) < this.c.b())))
              {
                if (((dl)localObject2).b)
                {
                  i = this.c.c();
                  label273:
                  ((dl)localObject2).a = i;
                }
              }
              else {
                label279:
                this.r.e = true;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      int j = h(paramfw);
      int k = this.t.f;
      if (k >= 0) {}
      for (i = j;; i = 0)
      {
        if (k >= 0) {
          j = 0;
        }
        int m = this.c.b() + j;
        int n = this.c.f() + i;
        j = n;
        k = m;
        if (paramfw.e)
        {
          i = this.v;
          if (i != -1) {
            break label1344;
          }
          k = m;
          j = n;
        }
        label1344:
        do
        {
          do
          {
            localObject1 = this.r;
            if (((dl)localObject1).b) {
              if (!this.d) {
                i = -1;
              }
            }
            for (;;)
            {
              a(paramfp, paramfw, (dl)localObject1, i);
              i = w() - 1;
              for (;;)
              {
                if (i < 0)
                {
                  this.t.d = F();
                  localObject1 = this.r;
                  int i1;
                  if (((dl)localObject1).b)
                  {
                    b((dl)localObject1);
                    localObject1 = this.t;
                    ((dn)localObject1).c = k;
                    a(paramfp, (dn)localObject1, paramfw, false);
                    localObject1 = this.t;
                    k = ((dn)localObject1).h;
                    n = ((dn)localObject1).b;
                    m = ((dn)localObject1).a;
                    i = j;
                    if (m > 0) {
                      i = j + m;
                    }
                    a(this.r);
                    localObject1 = this.t;
                    ((dn)localObject1).c = i;
                    ((dn)localObject1).b += ((dn)localObject1).e;
                    a(paramfp, (dn)localObject1, paramfw, false);
                    localObject1 = this.t;
                    m = ((dn)localObject1).h;
                    i1 = ((dn)localObject1).a;
                    i = m;
                    j = k;
                    if (i1 > 0)
                    {
                      f(n, k);
                      localObject1 = this.t;
                      ((dn)localObject1).c = i1;
                      a(paramfp, (dn)localObject1, paramfw, false);
                      j = this.t.h;
                      i = m;
                    }
                  }
                  for (;;)
                  {
                    if (w() <= 0)
                    {
                      m = j;
                      k = i;
                    }
                    for (;;)
                    {
                      if (!paramfw.j) {}
                      for (;;)
                      {
                        if (paramfw.e)
                        {
                          this.r.a();
                          return;
                        }
                        paramfp = this.c;
                        paramfp.a = paramfp.e();
                        return;
                        if ((w() != 0) && (!paramfw.e) && (u()))
                        {
                          localObject1 = paramfp.f;
                          int i2 = ((List)localObject1).size();
                          int i3 = a(d(0));
                          i = 0;
                          j = 0;
                          n = 0;
                          while (n < i2)
                          {
                            localObject2 = (fz)((List)localObject1).get(n);
                            if (((fz)localObject2).l())
                            {
                              i1 = j;
                              j = i;
                              i = i1;
                              i1 = n + 1;
                              n = j;
                              j = i;
                              i = n;
                              n = i1;
                            }
                            else
                            {
                              if (((fz)localObject2).c() >= i3) {}
                              for (bool = false;; bool = true)
                              {
                                if (bool != this.d)
                                {
                                  i1 = this.c.e(((fz)localObject2).c) + i;
                                  i = j;
                                  j = i1;
                                  break;
                                }
                                i1 = this.c.e(((fz)localObject2).c) + j;
                                j = i;
                                i = i1;
                                break;
                              }
                            }
                          }
                          this.t.j = ((List)localObject1);
                          if (i > 0)
                          {
                            f(a(G()), m);
                            localObject1 = this.t;
                            ((dn)localObject1).c = i;
                            ((dn)localObject1).a = 0;
                            ((dn)localObject1).a(null);
                            a(paramfp, this.t, paramfw, false);
                          }
                          if (j > 0)
                          {
                            e(a(H()), k);
                            localObject1 = this.t;
                            ((dn)localObject1).c = j;
                            ((dn)localObject1).a = 0;
                            ((dn)localObject1).a(null);
                            a(paramfp, this.t, paramfw, false);
                          }
                          this.t.j = null;
                        }
                      }
                      if (this.d)
                      {
                        k = a(i, paramfp, paramfw, true);
                        m = j + k;
                        j = b(m, paramfp, paramfw, false);
                        m += j;
                        k = i + k + j;
                      }
                      else
                      {
                        k = b(j, paramfp, paramfw, true);
                        i += k;
                        n = a(i, paramfp, paramfw, false);
                        m = j + k + n;
                        k = i + n;
                      }
                    }
                    a((dl)localObject1);
                    localObject1 = this.t;
                    ((dn)localObject1).c = j;
                    a(paramfp, (dn)localObject1, paramfw, false);
                    localObject1 = this.t;
                    m = ((dn)localObject1).h;
                    n = ((dn)localObject1).b;
                    j = ((dn)localObject1).a;
                    i = k;
                    if (j > 0) {
                      i = k + j;
                    }
                    b(this.r);
                    localObject1 = this.t;
                    ((dn)localObject1).c = i;
                    ((dn)localObject1).b += ((dn)localObject1).e;
                    a(paramfp, (dn)localObject1, paramfw, false);
                    localObject1 = this.t;
                    k = ((dn)localObject1).h;
                    i1 = ((dn)localObject1).a;
                    i = m;
                    j = k;
                    if (i1 > 0)
                    {
                      e(n, m);
                      localObject1 = this.t;
                      ((dn)localObject1).c = i1;
                      a(paramfp, (dn)localObject1, paramfw, false);
                      i = this.t.h;
                      j = k;
                    }
                  }
                }
                super.a(paramfp, i, d(i));
                i -= 1;
              }
              i = 1;
              continue;
              if (!this.d) {
                i = 1;
              } else {
                i = -1;
              }
            }
            j = n;
            k = m;
          } while (this.w == Integer.MIN_VALUE);
          localObject1 = a(i);
          j = n;
          k = m;
        } while (localObject1 == null);
        if (this.d) {}
        for (i = this.c.c() - this.c.b((View)localObject1) - this.w;; i = this.w - (i - j))
        {
          if (i <= 0)
          {
            j = n - i;
            k = m;
            break;
          }
          k = m + i;
          j = n;
          break;
          i = this.c.a((View)localObject1);
          j = this.c.b();
        }
      }
      i = this.c.b();
      break label273;
      localObject1 = e(paramfp, paramfw);
      break label187;
      if (this.d)
      {
        localObject1 = e(paramfp, paramfw);
        break label187;
      }
      localObject1 = d(paramfp, paramfw);
      break label187;
      fj localfj = (fj)((View)localObject1).getLayoutParams();
      if ((localfj.d.l()) || (localfj.d.c() < 0) || (localfj.d.c() >= paramfw.a())) {
        break label164;
      }
      ((dl)localObject2).a((View)localObject1, a((View)localObject1));
      break label279;
      label1592:
      ((dl)localObject2).b();
      ((dl)localObject2).d = 0;
      break label279;
      if (i < 0) {}
      while (i >= paramfw.a())
      {
        this.v = -1;
        this.w = Integer.MIN_VALUE;
        break;
      }
      ((dl)localObject2).d = this.v;
      localObject1 = this.u;
      if ((localObject1 != null) && (((LinearLayoutManager.SavedState)localObject1).a()))
      {
        ((dl)localObject2).b = this.u.a;
        if (((dl)localObject2).b)
        {
          ((dl)localObject2).a = (this.c.c() - this.u.b);
          break label279;
        }
        ((dl)localObject2).a = (this.c.b() + this.u.b);
        break label279;
      }
      if (this.w == Integer.MIN_VALUE)
      {
        localObject1 = a(this.v);
        if (localObject1 != null)
        {
          if (this.c.e((View)localObject1) > this.c.e())
          {
            ((dl)localObject2).b();
            break label279;
          }
          if (this.c.a((View)localObject1) - this.c.b() < 0)
          {
            ((dl)localObject2).a = this.c.b();
            ((dl)localObject2).b = false;
            break label279;
          }
          if (this.c.c() - this.c.b((View)localObject1) < 0)
          {
            ((dl)localObject2).a = this.c.c();
            ((dl)localObject2).b = true;
            break label279;
          }
          if (((dl)localObject2).b) {}
          for (i = this.c.b((View)localObject1) + this.c.a();; i = this.c.a((View)localObject1))
          {
            ((dl)localObject2).a = i;
            break;
          }
        }
        if (w() > 0)
        {
          i = a(d(0));
          if (this.v < i) {
            break label1968;
          }
        }
        label1968:
        for (bool = false;; bool = true)
        {
          if (bool == this.d) {}
          for (bool = true;; bool = false)
          {
            ((dl)localObject2).b = bool;
            ((dl)localObject2).b();
            break;
          }
        }
      }
      boolean bool = this.d;
      ((dl)localObject2).b = bool;
      if (bool)
      {
        ((dl)localObject2).a = (this.c.c() - this.w);
        break label279;
      }
      ((dl)localObject2).a = (this.c.b() + this.w);
      break label279;
      if ((localObject1 != null) && ((this.c.a((View)localObject1) >= this.c.c()) || (this.c.b((View)localObject1) <= this.c.b()))) {
        this.r.a((View)localObject1, a((View)localObject1));
      }
    }
  }
  
  void a(fp paramfp, fw paramfw, dl paramdl, int paramInt) {}
  
  void a(fp paramfp, fw paramfw, dn paramdn, dm paramdm)
  {
    paramfp = paramdn.a(paramfp);
    if (paramfp == null)
    {
      paramdm.b = true;
      return;
    }
    paramfw = (fj)paramfp.getLayoutParams();
    if (paramdn.j == null)
    {
      bool2 = this.d;
      if (paramdn.g != -1) {}
      for (bool1 = false;; bool1 = true)
      {
        if (bool2 != bool1) {
          super.a(paramfp, 0, false);
        }
        for (;;)
        {
          a(paramfp, 0, 0);
          paramdm.a = this.c.e(paramfp);
          int j;
          int i;
          int m;
          int k;
          if (this.b == 1) {
            if (!d())
            {
              j = i();
              i = this.c.f(paramfp) + j;
              if (paramdn.g == -1)
              {
                m = paramdn.h;
                k = m - paramdm.a;
              }
            }
          }
          for (;;)
          {
            a(paramfp, j, k, i, m);
            if ((paramfw.d.l()) || (paramfw.d.r())) {
              paramdm.d = true;
            }
            paramdm.c = paramfp.hasFocusable();
            return;
            k = paramdn.h;
            m = k + paramdm.a;
            continue;
            i = this.p - j();
            j = i - this.c.f(paramfp);
            break;
            k = g();
            m = k + this.c.f(paramfp);
            if (paramdn.g == -1)
            {
              i = paramdn.h;
              j = i - paramdm.a;
            }
            else
            {
              j = paramdn.h;
              i = paramdm.a + j;
            }
          }
          super.a(paramfp, -1, false);
        }
      }
    }
    boolean bool2 = this.d;
    if (paramdn.g != -1) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      if (bool2 != bool1)
      {
        super.a(paramfp, 0, true);
        break;
      }
      super.a(paramfp, -1, true);
      break;
    }
  }
  
  public final void a(fw paramfw)
  {
    super.a(paramfw);
    this.u = null;
    this.v = -1;
    this.w = Integer.MIN_VALUE;
    this.r.a();
  }
  
  public final void a(AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramAccessibilityEvent);
    if (w() > 0)
    {
      paramAccessibilityEvent.setFromIndex(s());
      paramAccessibilityEvent.setToIndex(t());
    }
  }
  
  public final void a(String paramString)
  {
    if (this.u == null) {
      super.a(paramString);
    }
  }
  
  public final int b(int paramInt, fp paramfp, fw paramfw)
  {
    if (this.b != 0) {
      return d(paramInt, paramfp, paramfw);
    }
    return 0;
  }
  
  public final int b(fw paramfw)
  {
    return i(paramfw);
  }
  
  public final PointF b(int paramInt)
  {
    int i = 1;
    int j = 0;
    if (w() != 0)
    {
      if (paramInt >= a(d(0))) {}
      for (;;)
      {
        paramInt = i;
        if (j != this.d) {
          paramInt = -1;
        }
        if (this.b == 0) {
          return new PointF(paramInt, 0.0F);
        }
        return new PointF(0.0F, paramInt);
        j = 1;
      }
    }
    return null;
  }
  
  public final int c()
  {
    return this.b;
  }
  
  public final int c(fw paramfw)
  {
    return i(paramfw);
  }
  
  public final View c(int paramInt, fp paramfp, fw paramfw)
  {
    E();
    if (w() != 0)
    {
      switch (paramInt)
      {
      default: 
        paramInt = Integer.MIN_VALUE;
      }
      for (;;)
      {
        if (paramInt != Integer.MIN_VALUE)
        {
          p();
          p();
          a(paramInt, (int)(this.c.e() * 0.33333334F), false, paramfw);
          dn localdn = this.t;
          localdn.k = Integer.MIN_VALUE;
          localdn.i = false;
          a(paramfp, localdn, paramfw, true);
          if (paramInt == -1) {
            if (this.d) {
              paramfp = J();
            }
          }
          for (;;)
          {
            if (paramInt != -1) {}
            for (paramfw = H();; paramfw = G())
            {
              if (paramfw.hasFocusable())
              {
                if (paramfp != null) {
                  return paramfw;
                }
                return null;
              }
              return paramfp;
            }
            paramfp = I();
            continue;
            if (this.d) {
              paramfp = I();
            } else {
              paramfp = J();
            }
          }
        }
        return null;
        if (this.b != 1)
        {
          if (!d()) {
            paramInt = -1;
          } else {
            paramInt = 1;
          }
        }
        else
        {
          paramInt = -1;
          continue;
          if (this.b == 1)
          {
            paramInt = 1;
          }
          else
          {
            paramInt = Integer.MIN_VALUE;
            continue;
            if (this.b == 0)
            {
              paramInt = 1;
            }
            else
            {
              paramInt = Integer.MIN_VALUE;
              continue;
              if (this.b == 1)
              {
                paramInt = -1;
              }
              else
              {
                paramInt = Integer.MIN_VALUE;
                continue;
                if (this.b == 0)
                {
                  paramInt = -1;
                }
                else
                {
                  paramInt = Integer.MIN_VALUE;
                  continue;
                  if (this.b != 1)
                  {
                    if (!d()) {
                      paramInt = 1;
                    } else {
                      paramInt = -1;
                    }
                  }
                  else {
                    paramInt = 1;
                  }
                }
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  public final void c(int paramInt)
  {
    this.v = paramInt;
    this.w = Integer.MIN_VALUE;
    LinearLayoutManager.SavedState localSavedState = this.u;
    if (localSavedState != null) {
      localSavedState.c = -1;
    }
    v();
  }
  
  public final int d(fw paramfw)
  {
    return j(paramfw);
  }
  
  protected boolean d()
  {
    boolean bool = true;
    if (ac.h(this.m) != 1) {
      bool = false;
    }
    return bool;
  }
  
  public final int e(fw paramfw)
  {
    return j(paramfw);
  }
  
  public final int f(fw paramfw)
  {
    return k(paramfw);
  }
  
  public final int g(fw paramfw)
  {
    return k(paramfw);
  }
  
  public final boolean k()
  {
    return true;
  }
  
  public fj l()
  {
    return new fj(-2, -2);
  }
  
  public final Parcelable m()
  {
    LinearLayoutManager.SavedState localSavedState = this.u;
    if (localSavedState != null) {
      return new LinearLayoutManager.SavedState(localSavedState);
    }
    localSavedState = new LinearLayoutManager.SavedState();
    if (w() > 0)
    {
      p();
      boolean bool = this.d;
      localSavedState.a = bool;
      if (bool)
      {
        localView = H();
        localSavedState.b = (this.c.c() - this.c.b(localView));
        localSavedState.c = a(localView);
        return localSavedState;
      }
      View localView = G();
      localSavedState.c = a(localView);
      localSavedState.b = (this.c.a(localView) - this.c.b());
      return localSavedState;
    }
    localSavedState.c = -1;
    return localSavedState;
  }
  
  public boolean n()
  {
    return this.b == 0;
  }
  
  public final boolean o()
  {
    boolean bool = true;
    if (this.b != 1) {
      bool = false;
    }
    return bool;
  }
  
  final void p()
  {
    if (this.t == null) {
      this.t = q();
    }
  }
  
  dn q()
  {
    return new dn();
  }
  
  final boolean r()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.h != 1073741824)
    {
      bool1 = bool2;
      if (this.q != 1073741824)
      {
        int j = w();
        int i = 0;
        bool1 = bool2;
        if (i < j)
        {
          ViewGroup.LayoutParams localLayoutParams = d(i).getLayoutParams();
          if (localLayoutParams.width >= 0) {}
          while (localLayoutParams.height >= 0)
          {
            i += 1;
            break;
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int s()
  {
    View localView = a(0, w(), false, true);
    if (localView != null) {
      return a(localView);
    }
    return -1;
  }
  
  public final int t()
  {
    int i = -1;
    View localView = a(w() - 1, -1, false, true);
    if (localView != null) {
      i = a(localView);
    }
    return i;
  }
  
  public final boolean u()
  {
    return this.u == null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/LinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */