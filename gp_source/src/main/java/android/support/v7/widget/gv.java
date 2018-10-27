package android.support.v7.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

final class gv
  extends TouchDelegate
{
  private final Rect a;
  private boolean b;
  private final View c;
  private final int d;
  private final Rect e;
  private final Rect f;
  
  public gv(Rect paramRect1, Rect paramRect2, View paramView)
  {
    super(paramRect1, paramView);
    this.d = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.f = new Rect();
    this.e = new Rect();
    this.a = new Rect();
    a(paramRect1, paramRect2);
    this.c = paramView;
  }
  
  public final void a(Rect paramRect1, Rect paramRect2)
  {
    this.f.set(paramRect1);
    this.e.set(paramRect1);
    paramRect1 = this.e;
    int i = -this.d;
    paramRect1.inset(i, i);
    this.a.set(paramRect2);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    int k = (int)paramMotionEvent.getX();
    int m = (int)paramMotionEvent.getY();
    boolean bool1;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
      i = j;
    }
    for (;;)
    {
      if (!bool1) {
        return false;
      }
      if (i == 0) {
        paramMotionEvent.setLocation(k - this.a.left, m - this.a.top);
      }
      for (;;)
      {
        return this.c.dispatchTouchEvent(paramMotionEvent);
        if (this.a.contains(k, m)) {
          break;
        }
        paramMotionEvent.setLocation(this.c.getWidth() / 2, this.c.getHeight() / 2);
      }
      if (this.f.contains(k, m))
      {
        this.b = true;
        bool1 = true;
        i = j;
      }
      else
      {
        bool1 = false;
        i = j;
        continue;
        bool1 = this.b;
        this.b = false;
        i = j;
        continue;
        boolean bool2 = this.b;
        i = j;
        bool1 = bool2;
        if (bool2)
        {
          i = j;
          bool1 = bool2;
          if (!this.e.contains(k, m))
          {
            i = 0;
            bool1 = bool2;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */