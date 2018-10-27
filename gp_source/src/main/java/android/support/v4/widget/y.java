package android.support.v4.widget;

import android.view.View;
import java.util.List;

final class y
  extends bc
{
  public final int a;
  public az b;
  private final Runnable d = new z(this);
  
  y(DrawerLayout paramDrawerLayout, int paramInt)
  {
    this.a = paramInt;
  }
  
  public final int a(View paramView)
  {
    if (DrawerLayout.d(paramView)) {
      return paramView.getWidth();
    }
    return 0;
  }
  
  public final void a(int paramInt)
  {
    DrawerLayout localDrawerLayout = this.c;
    Object localObject1 = this.b.a;
    int i = localDrawerLayout.h.b;
    int j = localDrawerLayout.j.b;
    if (i == 1) {
      i = 1;
    }
    for (;;)
    {
      if (localObject1 == null) {}
      while (i != localDrawerLayout.f)
      {
        localDrawerLayout.f = i;
        localObject1 = localDrawerLayout.i;
        if (localObject1 == null) {
          break;
        }
        paramInt = ((List)localObject1).size() - 1;
        while (paramInt >= 0)
        {
          ((u)localDrawerLayout.i.get(paramInt)).g_(i);
          paramInt -= 1;
        }
        if (paramInt == 0)
        {
          float f = ((v)((View)localObject1).getLayoutParams()).c;
          Object localObject2;
          if (f == 0.0F)
          {
            localObject2 = (v)((View)localObject1).getLayoutParams();
            if ((((v)localObject2).d & 0x1) == 1)
            {
              ((v)localObject2).d = 0;
              localObject2 = localDrawerLayout.i;
              if (localObject2 != null)
              {
                paramInt = ((List)localObject2).size() - 1;
                while (paramInt >= 0)
                {
                  ((u)localDrawerLayout.i.get(paramInt)).b_((View)localObject1);
                  paramInt -= 1;
                }
              }
              localDrawerLayout.a((View)localObject1, false);
              if (localDrawerLayout.hasWindowFocus())
              {
                localObject1 = localDrawerLayout.getRootView();
                if (localObject1 != null) {
                  ((View)localObject1).sendAccessibilityEvent(32);
                }
              }
            }
          }
          else if (f == 1.0F)
          {
            localObject2 = (v)((View)localObject1).getLayoutParams();
            if ((((v)localObject2).d & 0x1) == 0)
            {
              ((v)localObject2).d = 1;
              localObject2 = localDrawerLayout.i;
              if (localObject2 != null)
              {
                paramInt = ((List)localObject2).size() - 1;
                while (paramInt >= 0)
                {
                  ((u)localDrawerLayout.i.get(paramInt)).c_((View)localObject1);
                  paramInt -= 1;
                }
              }
              localDrawerLayout.a((View)localObject1, true);
              if (localDrawerLayout.hasWindowFocus()) {
                localDrawerLayout.sendAccessibilityEvent(32);
              }
            }
          }
        }
      }
      if (j != 1)
      {
        if (i == 2) {
          i = 2;
        } else if (j != 2) {
          i = 0;
        } else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) != 1) {}
    for (View localView = this.c.a(5);; localView = this.c.a(3))
    {
      if ((localView != null) && (this.c.a(localView) == 0)) {
        this.b.a(localView, paramInt2);
      }
      return;
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = 0;
    paramFloat2 = DrawerLayout.b(paramView);
    int k = paramView.getWidth();
    int i;
    if (!this.c.a(paramView, 3))
    {
      j = this.c.getWidth();
      if (paramFloat1 < 0.0F) {
        i = j - k;
      }
    }
    for (;;)
    {
      this.b.a(i, paramView.getTop());
      this.c.invalidate();
      return;
      i = j;
      if (paramFloat1 == 0.0F)
      {
        if (paramFloat2 > 0.5F) {
          break;
        }
        i = j;
        continue;
        i = j;
        if (paramFloat1 <= 0.0F)
        {
          if (paramFloat1 != 0.0F) {}
          while (paramFloat2 <= 0.5F)
          {
            i = -k;
            break;
          }
          i = j;
        }
      }
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2)
  {
    paramInt2 = paramView.getWidth();
    if (this.c.a(paramView, 3)) {}
    for (float f = (paramInt2 + paramInt1) / paramInt2;; f = (this.c.getWidth() - paramInt1) / paramInt2)
    {
      this.c.a_(paramView, f);
      if (f == 0.0F) {}
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        paramView.setVisibility(paramInt1);
        this.c.invalidate();
        return;
      }
    }
  }
  
  public final boolean a(View paramView, int paramInt)
  {
    return (DrawerLayout.d(paramView)) && (this.c.a(paramView, this.a)) && (this.c.a(paramView) == 0);
  }
  
  public final void b()
  {
    this.c.removeCallbacks(this.d);
  }
  
  public final void b(View paramView, int paramInt)
  {
    ((v)paramView.getLayoutParams()).b = false;
    c();
  }
  
  public final int c(View paramView, int paramInt)
  {
    if (this.c.a(paramView, 3)) {
      return Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
    }
    int i = this.c.getWidth();
    return Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
  }
  
  final void c()
  {
    int i = 3;
    if (this.a == 3) {
      i = 5;
    }
    View localView = this.c.a(i);
    if (localView != null) {
      this.c.f(localView);
    }
  }
  
  public final int d(View paramView, int paramInt)
  {
    return paramView.getTop();
  }
  
  public final void d()
  {
    this.c.postDelayed(this.d, 160L);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */