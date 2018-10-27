package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class dt
  extends ft
{
  private final float h = a(paramContext.getResources().getDisplayMetrics());
  private final DecelerateInterpolator i = new DecelerateInterpolator();
  private int j = 0;
  private int k = 0;
  private final LinearInterpolator l = new LinearInterpolator();
  private PointF m;
  
  public dt(Context paramContext) {}
  
  private final int b(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.h);
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 - paramInt2;
    if (paramInt1 * paramInt2 > 0) {
      return paramInt2;
    }
    return 0;
  }
  
  public float a(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    switch (paramInt5)
    {
    default: 
      throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    case 0: 
      paramInt3 -= paramInt1;
      paramInt1 = paramInt3;
      if (paramInt3 <= 0)
      {
        paramInt2 = paramInt4 - paramInt2;
        paramInt1 = paramInt2;
        if (paramInt2 >= 0) {
          paramInt1 = 0;
        }
      }
      return paramInt1;
    case 1: 
      return paramInt4 - paramInt2;
    }
    return paramInt3 - paramInt1;
  }
  
  public int a(View paramView, int paramInt)
  {
    ff localff = this.a;
    if ((localff != null) && (localff.o()))
    {
      fj localfj = (fj)paramView.getLayoutParams();
      return a(ff.i(paramView) - localfj.topMargin, ff.k(paramView) + localfj.bottomMargin, localff.g(), localff.g - localff.h(), paramInt);
    }
    return 0;
  }
  
  public void a() {}
  
  protected final void a(int paramInt1, int paramInt2, fw paramfw, fu paramfu)
  {
    if (this.c.u.w() != 0)
    {
      this.j = b(this.j, paramInt1);
      this.k = b(this.k, paramInt2);
      if ((this.j == 0) && (this.k == 0))
      {
        paramfw = a(this.f);
        if ((paramfw == null) || ((paramfw.x == 0.0F) && (paramfw.y == 0.0F)))
        {
          paramfu.f = this.f;
          d();
        }
      }
      else
      {
        return;
      }
      float f = (float)Math.sqrt(paramfw.x * paramfw.x + paramfw.y * paramfw.y);
      paramfw.x /= f;
      paramfw.y /= f;
      this.m = paramfw;
      this.j = ((int)(paramfw.x * 10000.0F));
      this.k = ((int)(paramfw.y * 10000.0F));
      paramInt1 = b(10000);
      paramfu.a((int)(this.j * 1.2F), (int)(this.k * 1.2F), (int)(paramInt1 * 1.2F), this.l);
      return;
    }
    d();
  }
  
  public void a(View paramView, fw paramfw, fu paramfu)
  {
    int i1 = 0;
    paramfw = this.m;
    int n = i1;
    if (paramfw != null)
    {
      n = i1;
      if (paramfw.x != 0.0F) {
        if (this.m.x <= 0.0F) {
          break label117;
        }
      }
    }
    label117:
    for (n = 1;; n = -1)
    {
      n = b(paramView, n);
      i1 = a(paramView, c());
      int i2 = (int)Math.ceil(b((int)Math.sqrt(n * n + i1 * i1)) / 0.3356D);
      if (i2 > 0) {
        paramfu.a(-n, -i1, i2, this.i);
      }
      return;
    }
  }
  
  public int b(View paramView, int paramInt)
  {
    ff localff = this.a;
    if ((localff != null) && (localff.n()))
    {
      fj localfj = (fj)paramView.getLayoutParams();
      return a(ff.h(paramView) - localfj.leftMargin, ff.j(paramView) + localfj.rightMargin, localff.i(), localff.p - localff.j(), paramInt);
    }
    return 0;
  }
  
  public void b()
  {
    this.k = 0;
    this.j = 0;
    this.m = null;
  }
  
  public int c()
  {
    int i1 = 0;
    PointF localPointF = this.m;
    int n = i1;
    if (localPointF != null)
    {
      n = i1;
      if (localPointF.y != 0.0F)
      {
        if (this.m.y > 0.0F) {
          break label40;
        }
        n = -1;
      }
    }
    return n;
    label40:
    return 1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */