package android.support.design.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.f.a;

abstract class k
  extends AnimatorListenerAdapter
  implements ValueAnimator.AnimatorUpdateListener
{
  private float a;
  private float b;
  private boolean d;
  
  private k(b paramb) {}
  
  protected abstract float a();
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.c.v.a(this.a);
    this.d = false;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.d)
    {
      this.b = this.c.v.b;
      this.a = a();
      this.d = true;
    }
    a locala = this.c.v;
    float f = this.b;
    locala.a(f + (this.a - f) * paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/floatingactionbutton/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */