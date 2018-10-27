package android.support.v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class i
  implements Animator.AnimatorListener
{
  i(g paramg, j paramj) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator) {}
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    this.a.a(1.0F, this.b, true);
    this.b.c();
    Object localObject = this.b;
    ((j)localObject).a(((j)localObject).a());
    localObject = this.a;
    if (((g)localObject).a)
    {
      ((g)localObject).a = false;
      paramAnimator.cancel();
      paramAnimator.setDuration(1332L);
      paramAnimator.start();
      this.b.a(false);
      return;
    }
    ((g)localObject).c += 1.0F;
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.a.c = 0.0F;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */