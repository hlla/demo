package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

class ViewPropertyAnimatorCompatJellybeanMr2
{
  public static Interpolator getInterpolator(View paramView)
  {
    return (Interpolator)paramView.animate().getInterpolator();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/android/support/v4/view/ViewPropertyAnimatorCompatJellybeanMr2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */