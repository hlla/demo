package android.support.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.g.a;
import android.support.v4.g.v;
import java.util.ArrayList;

final class ab
  extends AnimatorListenerAdapter
{
  ab(z paramz, a parama) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.b.remove(paramAnimator);
    this.a.b.remove(paramAnimator);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.b.add(paramAnimator);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */