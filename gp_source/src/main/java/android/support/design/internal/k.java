package android.support.design.internal;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class k
{
  public m a = null;
  public ValueAnimator b = null;
  public final ArrayList c = new ArrayList();
  private final Animator.AnimatorListener d = new l(this);
  
  public final void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new m(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.d);
    this.c.add(paramArrayOfInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */