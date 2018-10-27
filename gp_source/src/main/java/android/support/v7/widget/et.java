package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

final class et
  implements y
{
  et(RecyclerView paramRecyclerView) {}
  
  private final void c(z paramz)
  {
    switch (paramz.a)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      this.a.u.A();
      return;
    case 8: 
      this.a.u.D();
      return;
    case 4: 
      this.a.u.C();
      return;
    }
    this.a.u.B();
  }
  
  public final fz a(int paramInt)
  {
    fz localfz = this.a.a(paramInt, true);
    if (localfz != null)
    {
      if (!this.a.k.d(localfz.c)) {
        return localfz;
      }
      return null;
    }
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2, true);
    Object localObject = this.a;
    ((RecyclerView)localObject).s = true;
    localObject = ((RecyclerView)localObject).G;
    ((fw)localObject).a += paramInt2;
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = this.a;
    int j = ((RecyclerView)localObject).k.b();
    int i = paramInt1 + paramInt2;
    paramInt2 = 0;
    if (paramInt2 >= j)
    {
      paramObject = ((RecyclerView)localObject).B;
      paramInt2 = ((fp)paramObject).b.size() - 1;
      if (paramInt2 >= 0)
      {
        localObject = (fz)((fp)paramObject).b.get(paramInt2);
        if (localObject == null) {}
        for (;;)
        {
          paramInt2 -= 1;
          break;
          j = ((fz)localObject).l;
          if ((j >= paramInt1) && (j < i))
          {
            ((fz)localObject).c(2);
            ((fp)paramObject).a(paramInt2);
          }
        }
      }
      this.a.t = true;
      return;
    }
    View localView = ((RecyclerView)localObject).k.c(paramInt2);
    fz localfz = RecyclerView.b(localView);
    if (localfz == null) {}
    for (;;)
    {
      paramInt2 += 1;
      break;
      if (!localfz.b())
      {
        int k = localfz.l;
        if ((k >= paramInt1) && (k < i))
        {
          localfz.c(2);
          localfz.a(paramObject);
          ((fj)localView.getLayoutParams()).b = true;
        }
      }
    }
  }
  
  public final void a(z paramz)
  {
    c(paramz);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2, false);
    this.a.s = true;
  }
  
  public final void b(z paramz)
  {
    c(paramz);
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = this.a;
    int j = localRecyclerView.k.b();
    int i = 0;
    if (i >= j)
    {
      localObject = localRecyclerView.B;
      j = ((fp)localObject).b.size();
      i = 0;
      if (i < j)
      {
        fz localfz = (fz)((fp)localObject).b.get(i);
        if (localfz == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localfz.l >= paramInt1) {
            localfz.a(paramInt2, true);
          }
        }
      }
      localRecyclerView.requestLayout();
      this.a.s = true;
      return;
    }
    Object localObject = RecyclerView.b(localRecyclerView.k.c(i));
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      if ((!((fz)localObject).b()) && (((fz)localObject).l >= paramInt1))
      {
        ((fz)localObject).a(paramInt2, false);
        localRecyclerView.G.l = true;
      }
    }
  }
  
  public final void d(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = this.a;
    int n = localRecyclerView.k.b();
    if (paramInt1 < paramInt2) {}
    for (int i = -1;; i = 1)
    {
      if (paramInt1 < paramInt2) {}
      for (int j = paramInt2;; j = paramInt1)
      {
        if (paramInt1 < paramInt2) {}
        for (int k = paramInt1;; k = paramInt2)
        {
          int m = 0;
          int i1;
          if (m >= n)
          {
            localObject = localRecyclerView.B;
            n = ((fp)localObject).b.size();
            m = 0;
            if (m < n)
            {
              fz localfz = (fz)((fp)localObject).b.get(m);
              if (localfz == null) {}
              for (;;)
              {
                m += 1;
                break;
                i1 = localfz.l;
                if ((i1 >= k) && (i1 <= j)) {
                  if (i1 == paramInt1) {
                    localfz.a(paramInt2 - paramInt1, false);
                  } else {
                    localfz.a(i, false);
                  }
                }
              }
            }
            localRecyclerView.requestLayout();
            this.a.s = true;
            return;
          }
          Object localObject = RecyclerView.b(localRecyclerView.k.c(m));
          if (localObject == null) {}
          do
          {
            m += 1;
            break;
            i1 = ((fz)localObject).l;
          } while ((i1 < k) || (i1 > j));
          if (i1 == paramInt1) {
            ((fz)localObject).a(paramInt2 - paramInt1, false);
          }
          for (;;)
          {
            localRecyclerView.G.l = true;
            break;
            ((fz)localObject).a(i, false);
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */