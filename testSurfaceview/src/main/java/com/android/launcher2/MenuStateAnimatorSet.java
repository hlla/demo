package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import java.util.List;

public class MenuStateAnimatorSet
{
  private AnimatorListenerAdapter mStateChangeAnimatorListener;
  private AnimatorSet mStateChangeAnimatorSet;
  
  public void buildAndStart(List<Animator> paramList)
  {
    this.mStateChangeAnimatorSet = new AnimatorSet();
    this.mStateChangeAnimatorSet.playTogether(paramList);
    this.mStateChangeAnimatorSet.setDuration(300L);
    if (this.mStateChangeAnimatorListener != null) {
      this.mStateChangeAnimatorSet.addListener(this.mStateChangeAnimatorListener);
    }
    this.mStateChangeAnimatorSet.start();
  }
  
  public void end()
  {
    if (this.mStateChangeAnimatorSet != null) {
      this.mStateChangeAnimatorSet.end();
    }
  }
  
  public void setListenerAdapter(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.mStateChangeAnimatorListener = paramAnimatorListenerAdapter;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MenuStateAnimatorSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */