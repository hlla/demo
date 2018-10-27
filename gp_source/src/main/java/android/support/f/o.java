package android.support.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.ac;
import android.view.View;

final class o
  extends AnimatorListenerAdapter
{
  private boolean a = false;
  private final View b;
  
  o(View paramView)
  {
    this.b = paramView;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ba.a(this.b, 1.0F);
    if (this.a) {
      this.b.setLayerType(0, null);
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    if ((ac.A(this.b)) && (this.b.getLayerType() == 0))
    {
      this.a = true;
      this.b.setLayerType(2, null);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */