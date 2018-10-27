package com.google.android.finsky.bw;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public final class ac
{
  public static Animator a(View paramView, float paramFloat1, float paramFloat2, long paramLong, AnimatorListener paramAnimatorListener)
  {
    paramView = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { paramFloat1, paramFloat2 });
    paramView.setStartDelay(0L);
    paramView.setDuration(paramLong);
    paramView.setInterpolator(new AccelerateDecelerateInterpolator());
    if (paramAnimatorListener != null) {
      paramView.addListener(paramAnimatorListener);
    }
    return paramView;
  }
  
  public static Animation a(Context paramContext, long paramLong, AnimationListener paramAnimationListener)
  {
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130771992);
    paramContext.setStartOffset(0L);
    paramContext.setDuration(paramLong);
    if (paramAnimationListener != null) {
      paramContext.setAnimationListener(paramAnimationListener);
    }
    return paramContext;
  }
  
  public static void a(Context paramContext, TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_X, new float[] { 0.0F, 1.0F });
    paramTextView.setInterpolator(new ad(paramContext.getResources().getDimension(2131167268)));
    paramTextView.start();
  }
  
  public static void a(View paramView)
  {
    a(paramView, 0.0F, 1.0F, 150L, null).start();
  }
  
  public static Animation b(Context paramContext, long paramLong, AnimationListener paramAnimationListener)
  {
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130771985);
    paramContext.setStartOffset(0L);
    paramContext.setDuration(paramLong);
    if (paramAnimationListener != null) {
      paramContext.setAnimationListener(paramAnimationListener);
    }
    return paramContext;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */