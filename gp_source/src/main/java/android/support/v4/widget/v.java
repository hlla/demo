package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class v
  extends ViewGroup.MarginLayoutParams
{
  public int a = 0;
  public boolean b;
  public float c;
  public int d;
  
  public v()
  {
    super(-1, -1);
  }
  
  public v(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.b);
    this.a = paramContext.getInt(0, 0);
    paramContext.recycle();
  }
  
  public v(v paramv)
  {
    super(paramv);
    this.a = paramv.a;
  }
  
  public v(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public v(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */