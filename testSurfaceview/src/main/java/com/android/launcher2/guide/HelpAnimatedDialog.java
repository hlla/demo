package com.android.launcher2.guide;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;

public class HelpAnimatedDialog
{
  private static View mGoalAnimationView;
  private int flashCount = 0;
  private Animation mFadingAnimation;
  private Animation.AnimationListener mFadingAnimationListener = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      HelpAnimatedDialog.mGoalAnimationView.startAnimation(HelpAnimatedDialog.this.mFlashingAnimation);
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private Animation mFlashingAnimation;
  private Animation.AnimationListener mFlashingAnimationListener = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (HelpAnimatedDialog.this.flashCount != 2) {
        HelpAnimatedDialog.mGoalAnimationView.startAnimation(HelpAnimatedDialog.this.mFadingAnimation);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation)
    {
      HelpAnimatedDialog.access$208(HelpAnimatedDialog.this);
    }
  };
  private View.OnTouchListener mImageTouch = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if (paramAnonymousMotionEvent.getAction() == 0)
      {
        paramAnonymousView.setAlpha(0.0F);
        paramAnonymousView.clearAnimation();
      }
      if (paramAnonymousMotionEvent.getAction() == 1) {
        paramAnonymousView.setAlpha(1.0F);
      }
      if (paramAnonymousMotionEvent.getAction() == 2) {
        paramAnonymousView.setAlpha(1.0F);
      }
      return false;
    }
  };
  private Animation mShowAnimation;
  private Animation.AnimationListener mShowAnimationListener = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      HelpAnimatedDialog.mGoalAnimationView.startAnimation(HelpAnimatedDialog.this.mFadingAnimation);
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  
  public HelpAnimatedDialog() {}
  
  public HelpAnimatedDialog(Context paramContext, View paramView)
  {
    init(paramContext, paramView);
  }
  
  private void init(Context paramContext, View paramView)
  {
    mGoalAnimationView = paramView;
    mGoalAnimationView.setOnTouchListener(this.mImageTouch);
    this.mShowAnimation = AnimationUtils.loadAnimation(paramContext, 2130968590);
    if (this.mShowAnimation != null) {
      this.mShowAnimation.setAnimationListener(this.mShowAnimationListener);
    }
    this.mFadingAnimation = AnimationUtils.loadAnimation(paramContext, 2130968588);
    if (this.mFadingAnimation != null) {
      this.mFadingAnimation.setAnimationListener(this.mFadingAnimationListener);
    }
    this.mFlashingAnimation = AnimationUtils.loadAnimation(paramContext, 2130968589);
    if (this.mFlashingAnimation != null) {
      this.mFlashingAnimation.setAnimationListener(this.mFlashingAnimationListener);
    }
  }
  
  public static void setAlpha()
  {
    if ((mGoalAnimationView != null) && (mGoalAnimationView.getAlpha() != 1.0F)) {
      mGoalAnimationView.setAlpha(1.0F);
    }
  }
  
  public void start()
  {
    mGoalAnimationView.startAnimation(this.mShowAnimation);
    this.mShowAnimation.start();
  }
  
  public void startZoom(float paramFloat1, float paramFloat2, View paramView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, 1, paramFloat1, 1, paramFloat2);
    localScaleAnimation.setDuration(300L);
    paramView.startAnimation(localScaleAnimation);
    localScaleAnimation.start();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/HelpAnimatedDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */