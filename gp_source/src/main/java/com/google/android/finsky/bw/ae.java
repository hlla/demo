package com.google.android.finsky.bw;

import android.view.View;
import android.view.animation.Animation;

public final class ae
  implements Runnable
{
  public ae(View paramView, ag paramag) {}
  
  public final void run()
  {
    Animation localAnimation = ac.b(this.b.getContext(), 150L, new af(this));
    this.b.startAnimation(localAnimation);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */