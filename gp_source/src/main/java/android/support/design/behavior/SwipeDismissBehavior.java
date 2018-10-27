package android.support.design.behavior;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.h;
import android.support.v4.widget.az;
import android.support.v4.widget.bc;
import android.view.MotionEvent;
import android.view.View;

public class SwipeDismissBehavior
  extends h
{
  public float a = 0.5F;
  public float b = 0.0F;
  public float c = 0.5F;
  public c d;
  public int e = 2;
  public az f;
  private final bc g = new b(this);
  private boolean h;
  
  public static float a(float paramFloat)
  {
    return Math.min(Math.max(0.0F, paramFloat), 1.0F);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.h;
    boolean bool1 = bool3;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool3;
    }
    for (;;)
    {
      if (bool1)
      {
        if (this.f == null) {
          this.f = az.a(paramCoordinatorLayout, this.g);
        }
        bool2 = this.f.a(paramMotionEvent);
      }
      return bool2;
      this.h = paramCoordinatorLayout.a(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = this.h;
      continue;
      this.h = false;
      bool1 = bool3;
    }
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    paramCoordinatorLayout = this.f;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.b(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean b(View paramView)
  {
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/behavior/SwipeDismissBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */