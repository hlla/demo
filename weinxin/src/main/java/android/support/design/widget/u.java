package android.support.design.widget;

import android.view.animation.Interpolator;

final class u
{
  final e ll;
  
  u(e parame)
  {
    this.ll = parame;
  }
  
  public final void a(final c paramc)
  {
    this.ll.a(new u.e.b()
    {
      public final void au()
      {
        paramc.a(u.this);
      }
    });
  }
  
  public final void e(float paramFloat1, float paramFloat2)
  {
    this.ll.e(paramFloat1, paramFloat2);
  }
  
  public final void e(int paramInt1, int paramInt2)
  {
    this.ll.e(paramInt1, paramInt2);
  }
  
  public final void setDuration(int paramInt)
  {
    this.ll.setDuration(paramInt);
  }
  
  public final void setInterpolator(Interpolator paramInterpolator)
  {
    this.ll.setInterpolator(paramInterpolator);
  }
  
  static abstract interface a
  {
    public abstract void aq();
  }
  
  static class b
    implements u.a
  {
    public void aq() {}
  }
  
  static abstract interface c
  {
    public abstract void a(u paramu);
  }
  
  static abstract interface d
  {
    public abstract u av();
  }
  
  static abstract class e
  {
    abstract void a(a parama);
    
    abstract void a(b paramb);
    
    abstract int aw();
    
    abstract float ax();
    
    abstract void cancel();
    
    abstract void e(float paramFloat1, float paramFloat2);
    
    abstract void e(int paramInt1, int paramInt2);
    
    abstract float getAnimatedFraction();
    
    abstract long getDuration();
    
    abstract boolean isRunning();
    
    abstract void setDuration(int paramInt);
    
    abstract void setInterpolator(Interpolator paramInterpolator);
    
    abstract void start();
    
    static abstract interface a
    {
      public abstract void onAnimationEnd();
    }
    
    static abstract interface b
    {
      public abstract void au();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */