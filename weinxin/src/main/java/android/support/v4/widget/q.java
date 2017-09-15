package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.Scroller;

public final class q
{
  Object Dv;
  a Dw;
  
  private q(int paramInt, Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInt >= 14) {
      this.Dw = new d();
    }
    for (;;)
    {
      this.Dv = this.Dw.b(paramContext, paramInterpolator);
      return;
      if (paramInt >= 9) {
        this.Dw = new c();
      } else {
        this.Dw = new b();
      }
    }
  }
  
  public static q a(Context paramContext, Interpolator paramInterpolator)
  {
    return new q(Build.VERSION.SDK_INT, paramContext, paramInterpolator);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.Dw.a(this.Dv, 0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public final void abortAnimation()
  {
    this.Dw.O(this.Dv);
  }
  
  public final boolean computeScrollOffset()
  {
    return this.Dw.N(this.Dv);
  }
  
  public final boolean f(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.Dw.a(this.Dv, paramInt1, paramInt2, 0, 0, 0, paramInt3);
  }
  
  public final float getCurrVelocity()
  {
    return this.Dw.M(this.Dv);
  }
  
  public final int getCurrX()
  {
    return this.Dw.K(this.Dv);
  }
  
  public final int getCurrY()
  {
    return this.Dw.L(this.Dv);
  }
  
  public final int getFinalX()
  {
    return this.Dw.P(this.Dv);
  }
  
  public final int getFinalY()
  {
    return this.Dw.Q(this.Dv);
  }
  
  public final boolean isFinished()
  {
    return this.Dw.H(this.Dv);
  }
  
  public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.Dw.a(this.Dv, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  static abstract interface a
  {
    public abstract boolean H(Object paramObject);
    
    public abstract int K(Object paramObject);
    
    public abstract int L(Object paramObject);
    
    public abstract float M(Object paramObject);
    
    public abstract boolean N(Object paramObject);
    
    public abstract void O(Object paramObject);
    
    public abstract int P(Object paramObject);
    
    public abstract int Q(Object paramObject);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
    
    public abstract boolean a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
    
    public abstract Object b(Context paramContext, Interpolator paramInterpolator);
  }
  
  static final class b
    implements q.a
  {
    public final boolean H(Object paramObject)
    {
      return ((Scroller)paramObject).isFinished();
    }
    
    public final int K(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrX();
    }
    
    public final int L(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrY();
    }
    
    public final float M(Object paramObject)
    {
      return 0.0F;
    }
    
    public final boolean N(Object paramObject)
    {
      return ((Scroller)paramObject).computeScrollOffset();
    }
    
    public final void O(Object paramObject)
    {
      ((Scroller)paramObject).abortAnimation();
    }
    
    public final int P(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalX();
    }
    
    public final int Q(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalY();
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      ((Scroller)paramObject).startScroll(paramInt1, paramInt2, 0, paramInt4);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ((Scroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      ((Scroller)paramObject).fling(0, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      ((Scroller)paramObject).fling(paramInt1, paramInt2, 0, paramInt4, 0, 0, 0, paramInt8);
    }
    
    public final boolean a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      return false;
    }
    
    public final Object b(Context paramContext, Interpolator paramInterpolator)
    {
      if (paramInterpolator != null) {
        return new Scroller(paramContext, paramInterpolator);
      }
      return new Scroller(paramContext);
    }
  }
  
  static class c
    implements q.a
  {
    public final boolean H(Object paramObject)
    {
      return ((OverScroller)paramObject).isFinished();
    }
    
    public final int K(Object paramObject)
    {
      return ((OverScroller)paramObject).getCurrX();
    }
    
    public final int L(Object paramObject)
    {
      return ((OverScroller)paramObject).getCurrY();
    }
    
    public float M(Object paramObject)
    {
      return 0.0F;
    }
    
    public final boolean N(Object paramObject)
    {
      return ((OverScroller)paramObject).computeScrollOffset();
    }
    
    public final void O(Object paramObject)
    {
      ((OverScroller)paramObject).abortAnimation();
    }
    
    public final int P(Object paramObject)
    {
      return ((OverScroller)paramObject).getFinalX();
    }
    
    public final int Q(Object paramObject)
    {
      return ((OverScroller)paramObject).getFinalY();
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, 0, paramInt4);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      ((OverScroller)paramObject).fling(0, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      ((OverScroller)paramObject).fling(paramInt1, paramInt2, 0, paramInt4, 0, 0, 0, paramInt8, 0, paramInt10);
    }
    
    public final boolean a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      return ((OverScroller)paramObject).springBack(paramInt1, paramInt2, 0, 0, 0, paramInt6);
    }
    
    public final Object b(Context paramContext, Interpolator paramInterpolator)
    {
      if (paramInterpolator != null) {
        return new OverScroller(paramContext, paramInterpolator);
      }
      return new OverScroller(paramContext);
    }
  }
  
  static final class d
    extends q.c
  {
    public final float M(Object paramObject)
    {
      return ((OverScroller)paramObject).getCurrVelocity();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */