package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class dk
  extends ViewGroup.MarginLayoutParams
{
  public int g = -1;
  public float h;
  
  public dk(int paramInt)
  {
    super(paramInt, -2);
    this.h = 0.0F;
  }
  
  public dk(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.ba);
    this.h = paramContext.getFloat(a.bc, 0.0F);
    this.g = paramContext.getInt(a.bb, -1);
    paramContext.recycle();
  }
  
  public dk(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */