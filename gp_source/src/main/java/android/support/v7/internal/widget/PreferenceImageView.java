package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.ap;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class PreferenceImageView
  extends ImageView
{
  private int a = Integer.MAX_VALUE;
  private int b = Integer.MAX_VALUE;
  
  public PreferenceImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PreferenceImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ap.N, paramInt, 0);
    setMaxWidth(paramContext.getDimensionPixelSize(ap.P, Integer.MAX_VALUE));
    setMaxHeight(paramContext.getDimensionPixelSize(ap.O, Integer.MAX_VALUE));
    paramContext.recycle();
  }
  
  public int getMaxHeight()
  {
    return this.a;
  }
  
  public int getMaxWidth()
  {
    return this.b;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j;
    int k;
    if (i == Integer.MIN_VALUE)
    {
      j = View.MeasureSpec.getSize(paramInt1);
      k = getMaxWidth();
      if (k != Integer.MAX_VALUE) {}
    }
    for (;;)
    {
      i = View.MeasureSpec.getMode(paramInt2);
      if (i == Integer.MIN_VALUE)
      {
        j = View.MeasureSpec.getSize(paramInt2);
        k = getMaxHeight();
        if (k != Integer.MAX_VALUE) {}
      }
      for (;;)
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
        if (k < j) {}
        while (i == 0)
        {
          paramInt2 = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
          break;
        }
        continue;
        if (i == 0) {
          break;
        }
      }
      if (k < j) {}
      while (i == 0)
      {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
        break;
      }
      continue;
      if (i == 0) {
        break;
      }
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
    super.setMaxHeight(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.b = paramInt;
    super.setMaxWidth(paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/internal/widget/PreferenceImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */