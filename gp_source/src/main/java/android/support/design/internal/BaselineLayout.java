package android.support.design.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout
  extends ViewGroup
{
  private int a = -1;
  
  public BaselineLayout(Context paramContext)
  {
    super(paramContext, null, 0);
  }
  
  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getBaseline()
  {
    return this.a;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    paramInt4 = getPaddingTop();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      int n;
      int i1;
      int i2;
      if (localView.getVisibility() != 8)
      {
        n = localView.getMeasuredWidth();
        i1 = localView.getMeasuredHeight();
        i2 = k + (paramInt3 - paramInt1 - m - k - n) / 2;
        if (this.a == -1) {
          break label149;
        }
        if (localView.getBaseline() == -1) {
          break label143;
        }
        paramInt2 = this.a + paramInt4 - localView.getBaseline();
      }
      for (;;)
      {
        localView.layout(i2, paramInt2, n + i2, i1 + paramInt2);
        i += 1;
        break;
        label143:
        paramInt2 = paramInt4;
        continue;
        label149:
        paramInt2 = paramInt4;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i4 = getChildCount();
    int i1 = 0;
    int j = -1;
    int k = -1;
    int i = 0;
    int i3 = 0;
    if (i1 < i4)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 8) {}
      for (;;)
      {
        i1 += 1;
        break;
        measureChild(localView, paramInt1, paramInt2);
        int i5 = localView.getBaseline();
        int n = j;
        m = k;
        if (i5 != -1)
        {
          m = Math.max(k, i5);
          n = Math.max(j, localView.getMeasuredHeight() - i5);
        }
        i3 = Math.max(i3, localView.getMeasuredWidth());
        i = Math.max(i, localView.getMeasuredHeight());
        i2 = View.combineMeasuredStates(i2, localView.getMeasuredState());
        j = n;
        k = m;
      }
    }
    int m = i;
    if (k != -1)
    {
      m = Math.max(i, Math.max(j, getPaddingBottom()) + k);
      this.a = k;
    }
    i = Math.max(m, getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), paramInt1, i2), View.resolveSizeAndState(i, paramInt2, i2 << 16));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/BaselineLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */