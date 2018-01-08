package com.android.launcher2;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

abstract class LauncherAnimatorUpdateListener
  implements ValueAnimator.AnimatorUpdateListener
{
  abstract void onAnimationUpdate(float paramFloat1, float paramFloat2);
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    onAnimationUpdate(1.0F - f, f);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/LauncherAnimatorUpdateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */