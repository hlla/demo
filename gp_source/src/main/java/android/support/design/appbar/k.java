package android.support.design.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.internal.n;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

final class k
{
  private static final int[] a = { 16843848 };
  
  static void a(View paramView)
  {
    paramView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
  }
  
  static void a(View paramView, float paramFloat)
  {
    int i = paramView.getResources().getInteger(2131492867);
    StateListAnimator localStateListAnimator = new StateListAnimator();
    long l = i;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(l);
    localStateListAnimator.addState(new int[] { 16842766, 2130969530, -2130969531 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { paramFloat }).setDuration(l);
    localStateListAnimator.addState(new int[] { 16842766 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(0L);
    localStateListAnimator.addState(new int[0], localObjectAnimator);
    paramView.setStateListAnimator(localStateListAnimator);
  }
  
  static void a(View paramView, AttributeSet paramAttributeSet)
  {
    Context localContext = paramView.getContext();
    paramAttributeSet = n.a(localContext, paramAttributeSet, a, 0, 2132018424, new int[0]);
    try
    {
      if (paramAttributeSet.hasValue(0)) {
        paramView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(localContext, paramAttributeSet.getResourceId(0, 0)));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */