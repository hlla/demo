package com.google.android.finsky.bc;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.Drawable;

final class o
  extends Animatable2.AnimationCallback
{
  private int a = 1;
  
  o(double paramDouble) {}
  
  public final void onAnimationEnd(Drawable paramDrawable)
  {
    double d = this.b;
    if (d != 0.0D)
    {
      int i = this.a;
      this.a = (i + 1);
      if (i >= d) {}
    }
    else
    {
      ((Animatable)paramDrawable).start();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */