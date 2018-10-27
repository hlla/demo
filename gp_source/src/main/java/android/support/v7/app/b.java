package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class b
  extends ViewGroup.MarginLayoutParams
{
  public int a = 0;
  
  public b(int paramInt)
  {
    super(paramInt, -2);
    this.a = 8388627;
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.b);
    this.a = paramContext.getInt(a.c, 0);
    paramContext.recycle();
  }
  
  public b(b paramb)
  {
    super(paramb);
    this.a = paramb.a;
  }
  
  public b(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */