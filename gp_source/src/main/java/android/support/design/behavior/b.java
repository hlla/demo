package android.support.design.behavior;

import android.support.v4.view.ac;
import android.support.v4.widget.az;
import android.support.v4.widget.bc;
import android.view.View;
import android.view.ViewParent;

final class b
  extends bc
{
  private int a = -1;
  private int b;
  
  b(SwipeDismissBehavior paramSwipeDismissBehavior) {}
  
  public final int a(View paramView)
  {
    return paramView.getWidth();
  }
  
  public final void a(int paramInt)
  {
    c localc = this.c.d;
    if (localc != null) {
      localc.a(paramInt);
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    this.a = -1;
    int i = paramView.getWidth();
    int j;
    int k;
    if (paramFloat1 != 0.0F)
    {
      j = ac.h(paramView);
      k = this.c.e;
      if (k != 2) {}
    }
    for (;;)
    {
      j = paramView.getLeft();
      k = this.b;
      if (j >= k) {
        i += k;
      }
      boolean bool;
      for (;;)
      {
        bool = true;
        label67:
        if (this.c.f.a(i, paramView.getTop())) {
          ac.a(paramView, new d(this.c, paramView, bool));
        }
        c localc;
        do
        {
          do
          {
            return;
          } while (!bool);
          localc = this.c.d;
        } while (localc == null);
        localc.a(paramView);
        return;
        i = k - i;
      }
      if (k != 0) {
        if (k == 1) {}
      }
      int m;
      do
      {
        for (;;)
        {
          i = this.b;
          bool = false;
          break label67;
          if (j != 1)
          {
            if (paramFloat1 >= 0.0F) {
              continue;
            }
            break;
          }
          if (paramFloat1 > 0.0F)
          {
            break;
            if (j != 1)
            {
              if (paramFloat1 <= 0.0F) {
                continue;
              }
              break;
            }
            if (paramFloat1 < 0.0F) {
              break;
            }
          }
        }
        j = paramView.getLeft();
        k = this.b;
        m = paramView.getWidth();
        paramFloat1 = this.c.c;
        m = Math.round(m * paramFloat1);
      } while (Math.abs(j - k) < m);
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2)
  {
    float f1 = this.b + paramView.getWidth() * this.c.b;
    float f2 = this.b + paramView.getWidth() * this.c.a;
    float f3 = paramInt1;
    if (f3 > f1)
    {
      if (f3 < f2)
      {
        paramView.setAlpha(SwipeDismissBehavior.a(1.0F - (f3 - f1) / (f2 - f1)));
        return;
      }
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(1.0F);
  }
  
  public final boolean a(View paramView, int paramInt)
  {
    return (this.a == -1) && (this.c.b(paramView));
  }
  
  public final void b(View paramView, int paramInt)
  {
    this.a = paramInt;
    this.b = paramView.getLeft();
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public final int c(View paramView, int paramInt)
  {
    int j = ac.h(paramView);
    if (j != 1) {}
    for (int i = 0;; i = 1)
    {
      int k = this.c.e;
      if (k != 0) {
        if (k != 1)
        {
          j = this.b - paramView.getWidth();
          i = this.b + paramView.getWidth();
        }
      }
      for (;;)
      {
        return Math.min(Math.max(j, paramInt), i);
        if (j != 1)
        {
          j = this.b - paramView.getWidth();
          i = this.b;
        }
        else
        {
          j = this.b;
          i = paramView.getWidth() + j;
          continue;
          if (i != 0)
          {
            j = this.b - paramView.getWidth();
            i = this.b;
          }
          else
          {
            j = this.b;
            i = paramView.getWidth() + j;
          }
        }
      }
    }
  }
  
  public final int d(View paramView, int paramInt)
  {
    return paramView.getTop();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/behavior/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */