package android.support.v7.widget;

import android.os.Build.VERSION;
import android.support.v4.view.ac;
import android.support.v4.view.u;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.util.ArrayList;

final class fy
  implements Runnable
{
  public int a;
  public int b;
  public OverScroller c;
  private boolean e = false;
  private Interpolator f = RecyclerView.N;
  private boolean g = false;
  
  fy(RecyclerView paramRecyclerView)
  {
    this.c = new OverScroller(paramRecyclerView.getContext(), RecyclerView.N);
  }
  
  final int a(int paramInt1, int paramInt2)
  {
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = (int)Math.sqrt(0.0D);
    paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
    if (i <= j) {}
    for (paramInt1 = this.d.getHeight();; paramInt1 = this.d.getWidth())
    {
      float f1 = paramInt1;
      float f2 = paramInt1 / 2;
      float f3 = (float)Math.sin((Math.min(1.0F, paramInt2 / f1) - 0.5F) * 0.47123894F);
      if (k > 0)
      {
        paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / k) * 1000.0F) * 4;
        return Math.min(paramInt1, 2000);
      }
      if (i > j) {}
      for (paramInt1 = i;; paramInt1 = j)
      {
        paramInt1 = (int)((paramInt1 / f1 + 1.0F) * 300.0F);
        break;
      }
    }
  }
  
  final void a()
  {
    if (this.e)
    {
      this.g = true;
      return;
    }
    this.d.removeCallbacks(this);
    ac.a(this.d, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, RecyclerView.N);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (this.f != paramInterpolator)
    {
      this.f = paramInterpolator;
      this.c = new OverScroller(this.d.getContext(), paramInterpolator);
    }
    this.d.b(2);
    this.b = 0;
    this.a = 0;
    this.c.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
    if (Build.VERSION.SDK_INT < 23) {
      this.c.computeScrollOffset();
    }
    a();
  }
  
  public final void b()
  {
    this.d.removeCallbacks(this);
    this.c.abortAnimation();
  }
  
  public final void run()
  {
    Object localObject1 = this.d;
    if (((RecyclerView)localObject1).u == null)
    {
      b();
      return;
    }
    this.g = false;
    this.e = true;
    ((RecyclerView)localObject1).d();
    Object localObject2 = this.c;
    localObject1 = this.d.u.n;
    Object localObject3;
    int i6;
    int i7;
    int m;
    int k;
    int i;
    if (((OverScroller)localObject2).computeScrollOffset())
    {
      localObject3 = this.d.E;
      i6 = ((OverScroller)localObject2).getCurrX();
      i7 = ((OverScroller)localObject2).getCurrY();
      m = i6 - this.a;
      k = i7 - this.b;
      this.a = i6;
      this.b = i7;
      if (!this.d.a(m, k, (int[])localObject3, null, 1)) {
        break label1023;
      }
      i = localObject3[0];
      k -= localObject3[1];
      m -= i;
    }
    label365:
    label411:
    label464:
    label770:
    label1023:
    for (;;)
    {
      localObject3 = this.d;
      int j;
      int i4;
      int i5;
      int i3;
      int i2;
      int i1;
      int n;
      if (((RecyclerView)localObject3).g != null)
      {
        ((RecyclerView)localObject3).a(m, k, ((RecyclerView)localObject3).F);
        localObject3 = this.d;
        int[] arrayOfInt = ((RecyclerView)localObject3).F;
        i = arrayOfInt[0];
        j = arrayOfInt[1];
        i4 = m - i;
        i5 = k - j;
        if (localObject1 == null)
        {
          i3 = i5;
          i2 = i4;
          i1 = j;
          n = i;
        }
      }
      for (;;)
      {
        if (!this.d.r.isEmpty()) {
          this.d.invalidate();
        }
        if (this.d.getOverScrollMode() != 2) {
          this.d.c(m, k);
        }
        if (this.d.a(n, i1, i2, i3, null, 1))
        {
          if (n != 0) {}
          for (;;)
          {
            this.d.f(n, i1);
            do
            {
              if (!RecyclerView.a(this.d)) {
                this.d.invalidate();
              }
              if (k != 0) {
                if (!this.d.u.o()) {
                  i = 0;
                }
              }
              for (;;)
              {
                if (m != 0) {
                  if (!this.d.u.n()) {
                    j = 0;
                  }
                }
                for (;;)
                {
                  if (m != 0) {
                    if (j != 0) {
                      i = 1;
                    }
                  }
                  for (;;)
                  {
                    if (((OverScroller)localObject2).isFinished())
                    {
                      this.d.b(0);
                      if (RecyclerView.b) {
                        this.d.A.a();
                      }
                      this.d.n_(1);
                      if (localObject1 == null) {}
                      for (;;)
                      {
                        this.e = false;
                        if (!this.g) {
                          break;
                        }
                        a();
                        return;
                        if (!((ft)localObject1).b) {}
                        for (;;)
                        {
                          if (this.g) {
                            break label464;
                          }
                          ((ft)localObject1).d();
                          break;
                          ((ft)localObject1).a(0, 0);
                        }
                      }
                    }
                    if (i != 0) {}
                    for (;;)
                    {
                      a();
                      localObject2 = this.d;
                      localObject3 = ((RecyclerView)localObject2).n;
                      if (localObject3 == null) {
                        break label411;
                      }
                      ((ck)localObject3).a((RecyclerView)localObject2, m, k);
                      break label411;
                      if (!this.d.r().a(1)) {
                        break;
                      }
                    }
                    if (i == 0)
                    {
                      i = 0;
                    }
                    else
                    {
                      i = 1;
                      continue;
                      if (k != 0) {
                        break label365;
                      }
                      i = 1;
                    }
                  }
                  if (n == m)
                  {
                    j = 1;
                  }
                  else
                  {
                    j = 0;
                    continue;
                    j = 0;
                  }
                }
                if (i1 == k)
                {
                  i = 1;
                }
                else
                {
                  i = 0;
                  continue;
                  i = 0;
                }
              }
            } while (i1 == 0);
          }
        }
        if (i2 != 0) {}
        for (;;)
        {
          j = (int)((OverScroller)localObject2).getCurrVelocity();
          if (i2 == i6) {
            i = 0;
          }
          for (;;)
          {
            if (i3 == i7) {
              j = 0;
            }
            for (;;)
            {
              if (this.d.getOverScrollMode() != 2)
              {
                localObject3 = this.d;
                if (i >= 0) {
                  break label770;
                }
                ((RecyclerView)localObject3).g();
                ((RecyclerView)localObject3).x.onAbsorb(-i);
              }
              for (;;)
              {
                if (j < 0)
                {
                  ((RecyclerView)localObject3).i();
                  ((RecyclerView)localObject3).J.onAbsorb(-j);
                }
                for (;;)
                {
                  if (i != 0) {}
                  for (;;)
                  {
                    ac.e((View)localObject3);
                    do
                    {
                      if (i != 0) {}
                      while ((i2 == i6) || (((OverScroller)localObject2).getFinalX() == 0))
                      {
                        if (j != 0) {}
                        for (;;)
                        {
                          ((OverScroller)localObject2).abortAnimation();
                          break;
                          if (i3 != i7) {
                            if (((OverScroller)localObject2).getFinalY() != 0) {
                              break;
                            }
                          }
                        }
                      }
                      break;
                    } while (j == 0);
                  }
                  if (j > 0)
                  {
                    ((RecyclerView)localObject3).j();
                    ((RecyclerView)localObject3).j.onAbsorb(j);
                  }
                }
                if (i > 0)
                {
                  ((RecyclerView)localObject3).h();
                  ((RecyclerView)localObject3).D.onAbsorb(i);
                }
              }
              if (i3 < 0) {
                j = -j;
              } else if (i3 <= 0) {
                j = 0;
              }
            }
            if (i2 < 0) {
              i = -j;
            } else if (i2 > 0) {
              i = j;
            } else {
              i = 0;
            }
          }
          if (i3 == 0) {
            break;
          }
        }
        n = i;
        i1 = j;
        i2 = i4;
        i3 = i5;
        if (!((ft)localObject1).b)
        {
          n = i;
          i1 = j;
          i2 = i4;
          i3 = i5;
          if (((ft)localObject1).d)
          {
            n = ((RecyclerView)localObject3).G.a();
            if (n == 0)
            {
              ((ft)localObject1).d();
              n = i;
              i1 = j;
              i2 = i4;
              i3 = i5;
            }
            else if (((ft)localObject1).f >= n)
            {
              ((ft)localObject1).f = (n - 1);
              ((ft)localObject1).a(m - i4, k - i5);
              n = i;
              i1 = j;
              i2 = i4;
              i3 = i5;
            }
            else
            {
              ((ft)localObject1).a(m - i4, k - i5);
              n = i;
              i1 = j;
              i2 = i4;
              i3 = i5;
              continue;
              n = 0;
              i1 = 0;
              i2 = 0;
              i3 = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/fy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */