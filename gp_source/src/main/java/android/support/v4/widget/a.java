package android.support.v4.widget;

import android.content.res.Resources;
import android.support.v4.view.ac;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a
  implements View.OnTouchListener
{
  private static final int f = ;
  public boolean a;
  public boolean b;
  public boolean c;
  public final b d = new b();
  public final View e;
  private int g;
  private boolean h;
  private final Interpolator i = new AccelerateInterpolator();
  private int j;
  private boolean k;
  private float[] l = { Float.MAX_VALUE, Float.MAX_VALUE };
  private float[] m = { Float.MAX_VALUE, Float.MAX_VALUE };
  private float[] n = { 0.0F, 0.0F };
  private float[] o = { 0.0F, 0.0F };
  private float[] p = { 0.0F, 0.0F };
  private Runnable q;
  
  public a(View paramView)
  {
    this.e = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    float f2 = paramView.density;
    float f1 = paramView.density;
    paramView = this.m;
    f2 = (int)(f2 * 1575.0F + 0.5F) / 1000.0F;
    paramView[0] = f2;
    paramView[1] = f2;
    paramView = this.n;
    f1 = (int)(f1 * 315.0F + 0.5F) / 1000.0F;
    paramView[0] = f1;
    paramView[1] = f1;
    this.j = 1;
    paramView = this.l;
    paramView[0] = Float.MAX_VALUE;
    paramView[1] = Float.MAX_VALUE;
    paramView = this.o;
    paramView[0] = 0.2F;
    paramView[1] = 0.2F;
    paramView = this.p;
    paramView[0] = 0.001F;
    paramView[1] = 0.001F;
    this.g = f;
    paramView = this.d;
    paramView.e = 500;
    paramView.d = 500;
  }
  
  private final float a(float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    if (paramFloat2 != 0.0F)
    {
      int i1 = this.j;
      switch (i1)
      {
      }
      do
      {
        paramFloat1 = 0.0F;
        do
        {
          return paramFloat1;
          if (paramFloat1 >= paramFloat2) {
            break;
          }
          if (paramFloat1 >= 0.0F) {
            return 1.0F - paramFloat1 / paramFloat2;
          }
          if (!this.a) {
            break;
          }
          paramFloat1 = f1;
        } while (i1 == 1);
      } while ((goto 44) || (paramFloat1 >= 0.0F));
      return paramFloat1 / -paramFloat2;
    }
    return 0.0F;
  }
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= paramFloat3)
    {
      if (paramFloat1 >= paramFloat2) {
        return paramFloat1;
      }
      return paramFloat2;
    }
    return paramFloat3;
  }
  
  private final float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = a(this.o[paramInt] * paramFloat2, 0.0F, this.l[paramInt]);
    float f2 = a(paramFloat1, f1);
    paramFloat1 = a(paramFloat2 - paramFloat1, f1) - f2;
    if (paramFloat1 < 0.0F) {
      paramFloat1 = -this.i.getInterpolation(-paramFloat1);
    }
    for (paramFloat1 = a(paramFloat1, -1.0F, 1.0F);; paramFloat1 = 0.0F)
    {
      if (paramFloat1 != 0.0F)
      {
        f2 = this.p[paramInt];
        paramFloat2 = this.n[paramInt];
        f1 = this.m[paramInt];
        paramFloat3 = f2 * paramFloat3;
        if (paramFloat1 > 0.0F) {
          return a(paramFloat1 * paramFloat3, paramFloat2, f1);
        }
        return -a(-paramFloat1 * paramFloat3, paramFloat2, f1);
      }
      return 0.0F;
      if (paramFloat1 > 0.0F)
      {
        paramFloat1 = this.i.getInterpolation(paramFloat1);
        break;
      }
    }
  }
  
  private final void c()
  {
    if (this.c)
    {
      this.a = false;
      return;
    }
    b localb = this.d;
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    int i1 = (int)(l1 - localb.f);
    int i2 = localb.d;
    if (i1 > i2) {
      i1 = i2;
    }
    for (;;)
    {
      localb.c = i1;
      localb.h = localb.a(l1);
      localb.g = l1;
      return;
      if (i1 < 0) {
        i1 = 0;
      }
    }
  }
  
  public final a a(boolean paramBoolean)
  {
    if ((this.k) && (!paramBoolean)) {
      c();
    }
    this.k = paramBoolean;
    return this;
  }
  
  public abstract void a(int paramInt);
  
  final boolean a()
  {
    boolean bool = false;
    b localb = this.d;
    float f1 = localb.j;
    int i1 = (int)(f1 / Math.abs(f1));
    f1 = localb.i;
    int i2 = (int)(f1 / Math.abs(f1));
    if ((i1 != 0) && (b(i1))) {
      bool = true;
    }
    while (i2 == 0) {
      return bool;
    }
    b();
    return false;
  }
  
  public abstract boolean b();
  
  public abstract boolean b(int paramInt);
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.k) {}
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
    case 2: 
      int i1;
      do
      {
        return false;
        this.b = true;
        this.h = false;
        float f1 = paramMotionEvent.getX();
        i1 = paramView.getWidth();
        int i2 = this.e.getWidth();
        f1 = a(0, f1, i1, i2);
        float f2 = paramMotionEvent.getY();
        i1 = paramView.getHeight();
        i2 = this.e.getHeight();
        f2 = a(1, f2, i1, i2);
        paramView = this.d;
        paramView.i = f1;
        paramView.j = f2;
      } while ((this.a) || (!a()));
      if (this.q == null) {
        this.q = new c(this);
      }
      this.a = true;
      this.c = true;
      if (!this.h)
      {
        i1 = this.g;
        if (i1 > 0) {
          ac.a(this.e, this.q, i1);
        }
      }
      for (;;)
      {
        this.h = true;
        return false;
        this.q.run();
      }
    }
    c();
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */