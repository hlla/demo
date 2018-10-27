package android.support.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

final class bj
  extends AnimatorListenerAdapter
  implements a, af
{
  private boolean a = false;
  private final int b;
  private boolean c;
  private final ViewGroup d;
  private final boolean e;
  private final View f;
  
  bj(View paramView, int paramInt)
  {
    this.f = paramView;
    this.b = paramInt;
    this.d = ((ViewGroup)paramView.getParent());
    this.e = true;
    a(true);
  }
  
  private final void a(boolean paramBoolean)
  {
    if ((this.e) && (this.c != paramBoolean))
    {
      ViewGroup localViewGroup = this.d;
      if (localViewGroup != null)
      {
        this.c = paramBoolean;
        au.a(localViewGroup, paramBoolean);
      }
    }
  }
  
  private final void d()
  {
    if (!this.a)
    {
      ba.a(this.f, this.b);
      ViewGroup localViewGroup = this.d;
      if (localViewGroup != null) {
        localViewGroup.invalidate();
      }
    }
    a(false);
  }
  
  public final void a()
  {
    a(false);
  }
  
  public final void a(z paramz)
  {
    d();
    paramz.b(this);
  }
  
  public final void b()
  {
    a(true);
  }
  
  public final void c() {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.a = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    d();
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    if (!this.a) {
      ba.a(this.f, this.b);
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    if (!this.a) {
      ba.a(this.f, 0);
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */