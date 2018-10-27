package android.support.v4.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

final class ak
  extends AnimationSet
  implements Runnable
{
  private final View a;
  private boolean b;
  private final ViewGroup c;
  private boolean d;
  
  ak(Animation paramAnimation, ViewGroup paramViewGroup, View paramView)
  {
    super(false);
    this.c = paramViewGroup;
    this.a = paramView;
    addAnimation(paramAnimation);
  }
  
  public final boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    boolean bool = true;
    if (this.b) {
      bool = this.d ^ true;
    }
    while (super.getTransformation(paramLong, paramTransformation)) {
      return bool;
    }
    this.b = true;
    cn.a(this.c, this);
    return true;
  }
  
  public final boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
  {
    boolean bool = true;
    if (this.b) {
      bool = this.d ^ true;
    }
    while (super.getTransformation(paramLong, paramTransformation, paramFloat)) {
      return bool;
    }
    this.b = true;
    cn.a(this.c, this);
    return true;
  }
  
  public final void run()
  {
    this.c.endViewTransition(this.a);
    this.d = true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */