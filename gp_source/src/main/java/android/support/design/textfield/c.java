package android.support.design.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

final class c
  extends AnimatorListenerAdapter
{
  c(b paramb, int paramInt1, TextView paramTextView1, int paramInt2, TextView paramTextView2) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.b = this.c;
    paramAnimator.a = null;
    paramAnimator = this.d;
    if (paramAnimator != null)
    {
      paramAnimator.setVisibility(4);
      if (this.b == 1)
      {
        paramAnimator = this.a.h;
        if (paramAnimator != null) {
          paramAnimator.setText(null);
        }
      }
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.e;
    if (paramAnimator != null) {
      paramAnimator.setVisibility(0);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/textfield/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */