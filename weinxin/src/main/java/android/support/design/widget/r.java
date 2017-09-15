package android.support.design.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class r
{
  WeakReference<View> fh;
  final ArrayList<a> jA = new ArrayList();
  a jB = null;
  public Animation jC = null;
  private Animation.AnimationListener jD = new Animation.AnimationListener()
  {
    public final void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (r.this.jC == paramAnonymousAnimation) {
        r.this.jC = null;
      }
    }
    
    public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public final void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  
  public final void a(int[] paramArrayOfInt, Animation paramAnimation)
  {
    paramArrayOfInt = new a(paramArrayOfInt, paramAnimation);
    paramAnimation.setAnimationListener(this.jD);
    this.jA.add(paramArrayOfInt);
  }
  
  final View an()
  {
    if (this.fh == null) {
      return null;
    }
    return (View)this.fh.get();
  }
  
  static final class a
  {
    final int[] jF;
    final Animation mAnimation;
    
    public a(int[] paramArrayOfInt, Animation paramAnimation)
    {
      this.jF = paramArrayOfInt;
      this.mAnimation = paramAnimation;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */