package android.support.design.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;

public class d
  extends LinearLayout.LayoutParams
{
  public int a = 1;
  public Interpolator b;
  
  public d()
  {
    super(-1, -2);
  }
  
  public d(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, h.b);
    this.a = paramAttributeSet.getInt(h.c, 0);
    if (paramAttributeSet.hasValue(h.d)) {
      this.b = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(h.d, 0));
    }
    paramAttributeSet.recycle();
  }
  
  public d(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public d(LinearLayout.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */