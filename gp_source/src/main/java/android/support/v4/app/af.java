package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.view.ac;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class af
  extends ah
{
  public View a;
  
  af(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    super(paramAnimationListener);
    this.a = paramView;
  }
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if ((ac.L(this.a)) || (Build.VERSION.SDK_INT >= 24)) {
      this.a.post(new ag(this));
    }
    for (;;)
    {
      super.onAnimationEnd(paramAnimation);
      return;
      this.a.setLayerType(0, null);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */