package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.al;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ch
  implements View.OnAttachStateChangeListener, View.OnTouchListener
{
  public boolean a;
  public final View b;
  private int c;
  private Runnable d;
  private final int e;
  private final float f;
  private final int g;
  private final int[] h = new int[2];
  private Runnable i;
  
  public ch(View paramView)
  {
    this.b = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.f = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.g = ViewConfiguration.getTapTimeout();
    this.e = ((this.g + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  public abstract al a();
  
  public boolean b()
  {
    al localal = a();
    if ((localal != null) && (!localal.d())) {
      localal.b();
    }
    return true;
  }
  
  protected boolean c()
  {
    al localal = a();
    if ((localal != null) && (localal.d())) {
      localal.c();
    }
    return true;
  }
  
  final void d()
  {
    Runnable localRunnable = this.i;
    if (localRunnable != null) {
      this.b.removeCallbacks(localRunnable);
    }
    localRunnable = this.d;
    if (localRunnable != null) {
      this.b.removeCallbacks(localRunnable);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.a;
    boolean bool1;
    int j;
    if (!bool2)
    {
      paramView = this.b;
      if (paramView.isEnabled()) {
        switch (paramMotionEvent.getActionMasked())
        {
        default: 
          bool1 = false;
        }
      }
      for (;;)
      {
        if (bool1)
        {
          long l = SystemClock.uptimeMillis();
          paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.b.onTouchEvent(paramView);
          paramView.recycle();
        }
        for (;;)
        {
          this.a = bool1;
          return (bool1) || (bool2);
        }
        this.c = paramMotionEvent.getPointerId(0);
        if (this.d == null) {
          this.d = new ci(this);
        }
        paramView.postDelayed(this.d, this.g);
        if (this.i == null) {
          this.i = new cj(this);
        }
        paramView.postDelayed(this.i, this.e);
        break;
        j = paramMotionEvent.findPointerIndex(this.c);
        if (j >= 0)
        {
          float f1 = paramMotionEvent.getX(j);
          float f2 = paramMotionEvent.getY(j);
          float f3 = this.f;
          float f4 = -f3;
          if (f1 < f4) {}
          while ((f2 < f4) || (f1 >= paramView.getRight() - paramView.getLeft() + f3) || (f2 >= paramView.getBottom() - paramView.getTop() + f3))
          {
            d();
            paramView.getParent().requestDisallowInterceptTouchEvent(true);
            if (b())
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          break;
        }
        bool1 = false;
        continue;
        d();
        break;
        bool1 = false;
      }
    }
    paramView = this.b;
    Object localObject = a();
    if ((localObject != null) && (((al)localObject).d()))
    {
      localObject = (bx)((al)localObject).e();
      if ((localObject != null) && (((bx)localObject).isShown()))
      {
        MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        int[] arrayOfInt = this.h;
        paramView.getLocationOnScreen(arrayOfInt);
        localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
        paramView = this.h;
        ((View)localObject).getLocationOnScreen(paramView);
        localMotionEvent.offsetLocation(-paramView[0], -paramView[1]);
        bool1 = ((bx)localObject).a(localMotionEvent, this.c);
        localMotionEvent.recycle();
        j = paramMotionEvent.getActionMasked();
        if (j != 1) {
          break label521;
        }
        j = 0;
      }
    }
    for (;;)
    {
      if (!bool1) {}
      while (j == 0)
      {
        if (c())
        {
          bool1 = false;
          break;
        }
        bool1 = true;
        break;
      }
      bool1 = true;
      break;
      label521:
      if (j != 3) {
        j = 1;
      } else {
        j = 0;
      }
    }
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.a = false;
    this.c = -1;
    paramView = this.d;
    if (paramView != null) {
      this.b.removeCallbacks(paramView);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */