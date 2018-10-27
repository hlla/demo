package android.support.design.appbar;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.d.a;
import android.support.v4.view.ac;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

class e
  extends i
{
  private int a = -1;
  public OverScroller b;
  private Runnable c;
  private boolean d;
  private int e;
  private int f = -1;
  private VelocityTracker g;
  
  public e() {}
  
  public e(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void d()
  {
    if (this.g == null) {
      this.g = VelocityTracker.obtain();
    }
  }
  
  int a()
  {
    return c();
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = c();
    if ((paramInt2 != 0) && (i >= paramInt2) && (i <= paramInt3))
    {
      paramInt1 = a.a(paramInt1, paramInt2, paramInt3);
      if (i != paramInt1)
      {
        a_(paramInt1);
        return i - paramInt1;
      }
    }
    return 0;
  }
  
  int a(View paramView)
  {
    return paramView.getHeight();
  }
  
  void a(CoordinatorLayout paramCoordinatorLayout, View paramView) {}
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.f < 0) {
      this.f = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() != 2) || (!this.d)) {
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      paramCoordinatorLayout = this.g;
      if (paramCoordinatorLayout != null) {
        paramCoordinatorLayout.addMovement(paramMotionEvent);
      }
      bool = this.d;
      return bool;
      int i = this.a;
      if (i != -1)
      {
        i = paramMotionEvent.findPointerIndex(i);
        if (i != -1)
        {
          i = (int)paramMotionEvent.getY(i);
          if (Math.abs(i - this.e) > this.f)
          {
            this.d = true;
            this.e = i;
            continue;
            this.d = false;
            this.a = -1;
            paramCoordinatorLayout = this.g;
            if (paramCoordinatorLayout != null)
            {
              paramCoordinatorLayout.recycle();
              this.g = null;
              continue;
              this.d = false;
              i = (int)paramMotionEvent.getX();
              int j = (int)paramMotionEvent.getY();
              if ((b()) && (paramCoordinatorLayout.a(paramView, i, j)))
              {
                this.e = j;
                this.a = paramMotionEvent.getPointerId(0);
                d();
              }
            }
          }
        }
      }
    }
  }
  
  final int a_(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    return a(paramCoordinatorLayout, paramView, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCoordinatorLayout, paramView, a() - paramInt1, paramInt2, paramInt3);
  }
  
  int b(View paramView)
  {
    return -paramView.getHeight();
  }
  
  boolean b()
  {
    return false;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if (this.f < 0) {
      this.f = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      paramCoordinatorLayout = this.g;
      if (paramCoordinatorLayout != null) {
        paramCoordinatorLayout.addMovement(paramMotionEvent);
      }
      return true;
      Object localObject = this.g;
      if (localObject != null)
      {
        ((VelocityTracker)localObject).addMovement(paramMotionEvent);
        this.g.computeCurrentVelocity(1000);
        f1 = this.g.getYVelocity(this.a);
        i = -a(paramView);
        localObject = this.c;
        if (localObject != null)
        {
          paramView.removeCallbacks((Runnable)localObject);
          this.c = null;
        }
        if (this.b == null) {
          this.b = new OverScroller(paramView.getContext());
        }
        this.b.fling(0, c(), 0, Math.round(f1), 0, 0, i, 0);
        if (!this.b.computeScrollOffset()) {
          break label380;
        }
        this.c = new f(this, paramCoordinatorLayout, paramView);
        ac.a(paramView, this.c);
      }
      for (;;)
      {
        this.d = false;
        this.a = -1;
        paramCoordinatorLayout = this.g;
        if (paramCoordinatorLayout == null) {
          break;
        }
        paramCoordinatorLayout.recycle();
        this.g = null;
        break;
        i = paramMotionEvent.findPointerIndex(this.a);
        if (i != -1)
        {
          int k = (int)paramMotionEvent.getY(i);
          int j = this.e - k;
          i = j;
          int n;
          if (!this.d)
          {
            int m = Math.abs(j);
            n = this.f;
            i = j;
            if (m > n)
            {
              this.d = true;
              if (j > 0) {
                break label368;
              }
            }
          }
          label368:
          for (i = j + n; this.d; i = j - n)
          {
            this.e = k;
            b(paramCoordinatorLayout, paramView, i, b(paramView), 0);
            break;
          }
        }
        return false;
        label380:
        a(paramCoordinatorLayout, paramView);
      }
      float f1 = paramMotionEvent.getX();
      int i = (int)paramMotionEvent.getY();
      if ((!paramCoordinatorLayout.a(paramView, (int)f1, i)) || (!b())) {
        break;
      }
      this.e = i;
      this.a = paramMotionEvent.getPointerId(0);
      d();
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */