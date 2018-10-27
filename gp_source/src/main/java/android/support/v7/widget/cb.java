package android.support.v7.widget;

import android.animation.ValueAnimator;

final class cb
  implements Runnable
{
  cb(ca paramca) {}
  
  public final void run()
  {
    ca localca = this.a;
    switch (localca.a)
    {
    default: 
      return;
    case 1: 
      localca.j.cancel();
    }
    localca.a = 3;
    ValueAnimator localValueAnimator = localca.j;
    localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 0.0F });
    localca.j.setDuration(500L);
    localca.j.start();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */