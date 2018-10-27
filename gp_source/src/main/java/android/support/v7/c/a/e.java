package android.support.v7.c.a;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build.VERSION;

final class e
  extends g
{
  private final ObjectAnimator a;
  private final boolean b;
  
  e(AnimationDrawable paramAnimationDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = paramAnimationDrawable.getNumberOfFrames();
    if (paramBoolean1) {}
    for (int i = j - 1;; i = 0)
    {
      if (!paramBoolean1) {
        j -= 1;
      }
      for (;;)
      {
        f localf = new f(paramAnimationDrawable, paramBoolean1);
        paramAnimationDrawable = ObjectAnimator.ofInt(paramAnimationDrawable, "currentIndex", new int[] { i, j });
        if (Build.VERSION.SDK_INT >= 18) {
          paramAnimationDrawable.setAutoCancel(true);
        }
        paramAnimationDrawable.setDuration(localf.a);
        paramAnimationDrawable.setInterpolator(localf);
        this.b = paramBoolean2;
        this.a = paramAnimationDrawable;
        return;
        j = 0;
      }
    }
  }
  
  public final void a()
  {
    this.a.start();
  }
  
  public final void b()
  {
    this.a.cancel();
  }
  
  public final boolean c()
  {
    return this.b;
  }
  
  public final void d()
  {
    this.a.reverse();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/c/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */