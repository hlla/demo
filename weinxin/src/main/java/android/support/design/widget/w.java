package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;

final class w
  extends u.e
{
  final ValueAnimator ly = new ValueAnimator();
  
  public final void a(final u.e.a parama)
  {
    this.ly.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        parama.onAnimationEnd();
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
  }
  
  public final void a(final u.e.b paramb)
  {
    this.ly.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramb.au();
      }
    });
  }
  
  public final int aw()
  {
    return ((Integer)this.ly.getAnimatedValue()).intValue();
  }
  
  public final float ax()
  {
    return ((Float)this.ly.getAnimatedValue()).floatValue();
  }
  
  public final void cancel()
  {
    this.ly.cancel();
  }
  
  public final void e(float paramFloat1, float paramFloat2)
  {
    this.ly.setFloatValues(new float[] { paramFloat1, paramFloat2 });
  }
  
  public final void e(int paramInt1, int paramInt2)
  {
    this.ly.setIntValues(new int[] { paramInt1, paramInt2 });
  }
  
  public final float getAnimatedFraction()
  {
    return this.ly.getAnimatedFraction();
  }
  
  public final long getDuration()
  {
    return this.ly.getDuration();
  }
  
  public final boolean isRunning()
  {
    return this.ly.isRunning();
  }
  
  public final void setDuration(int paramInt)
  {
    this.ly.setDuration(paramInt);
  }
  
  public final void setInterpolator(Interpolator paramInterpolator)
  {
    this.ly.setInterpolator(paramInterpolator);
  }
  
  public final void start()
  {
    this.ly.start();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */