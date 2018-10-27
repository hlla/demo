package android.support.f;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import java.util.Map;

public final class m
  extends bh
{
  public m() {}
  
  public m(int paramInt)
  {
    if ((paramInt & 0xFFFFFFFC) != 0) {
      throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
    this.q = paramInt;
  }
  
  private static float a(ap paramap, float paramFloat)
  {
    float f = paramFloat;
    if (paramap != null)
    {
      paramap = (Float)paramap.b.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramap != null) {
        f = paramap.floatValue();
      }
    }
    return f;
  }
  
  private final Animator a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 != paramFloat2)
    {
      ba.a(paramView, paramFloat1);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, ba.b, new float[] { paramFloat2 });
      localObjectAnimator.addListener(new o(paramView));
      a(new n(paramView));
      return localObjectAnimator;
    }
    return null;
  }
  
  public final Animator a(View paramView, ap paramap)
  {
    float f1 = 0.0F;
    float f2 = a(paramap, 0.0F);
    if (f2 == 1.0F) {}
    for (;;)
    {
      return a(paramView, f1, 1.0F);
      f1 = f2;
    }
  }
  
  public final void a(ap paramap)
  {
    super.a(paramap);
    Map localMap = paramap.b;
    paramap = paramap.c;
    localMap.put("android:fade:transitionAlpha", Float.valueOf(ba.a.a(paramap)));
  }
  
  public final Animator b(View paramView, ap paramap)
  {
    ba.a.b(paramView);
    return a(paramView, a(paramap, 1.0F), 0.0F);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */