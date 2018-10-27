package android.support.v7.widget;

import android.view.View;

final class cu
  extends cx
{
  final int a(View paramView, int paramInt)
  {
    return 0;
  }
  
  public final int a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getVisibility() != 8)
    {
      paramInt2 = paramView.getBaseline();
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = Integer.MIN_VALUE;
      }
      return paramInt1;
    }
    return 0;
  }
  
  final String a()
  {
    return "BASELINE";
  }
  
  public final dc b()
  {
    return new cv();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */