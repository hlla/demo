package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public final class ao
  extends ViewGroup.LayoutParams
{
  public int a;
  public int b;
  public boolean c;
  public boolean d;
  public int e;
  public float f = 0.0F;
  
  public ao()
  {
    super(-1, -1);
  }
  
  public ao(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.a);
    this.b = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */