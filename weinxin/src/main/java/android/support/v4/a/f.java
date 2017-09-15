package android.support.v4.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;

final class f
  implements c
{
  private TimeInterpolator nC;
  
  public final g aB()
  {
    return new b(ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }));
  }
  
  public final void v(View paramView)
  {
    if (this.nC == null) {
      this.nC = new ValueAnimator().getInterpolator();
    }
    paramView.animate().setInterpolator(this.nC);
  }
  
  static final class a
    implements Animator.AnimatorListener
  {
    final b nD;
    final g nE;
    
    public a(b paramb, g paramg)
    {
      this.nD = paramb;
      this.nE = paramg;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.nD.aC();
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      this.nD.a(this.nE);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  static final class b
    implements g
  {
    final Animator nF;
    
    public b(Animator paramAnimator)
    {
      this.nF = paramAnimator;
    }
    
    public final void a(b paramb)
    {
      this.nF.addListener(new f.a(paramb, this));
    }
    
    public final void a(final d paramd)
    {
      if ((this.nF instanceof ValueAnimator)) {
        ((ValueAnimator)this.nF).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            paramd.b(f.b.this);
          }
        });
      }
    }
    
    public final void cancel()
    {
      this.nF.cancel();
    }
    
    public final float getAnimatedFraction()
    {
      return ((ValueAnimator)this.nF).getAnimatedFraction();
    }
    
    public final void setDuration(long paramLong)
    {
      this.nF.setDuration(paramLong);
    }
    
    public final void start()
    {
      this.nF.start();
    }
    
    public final void w(View paramView)
    {
      this.nF.setTarget(paramView);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */