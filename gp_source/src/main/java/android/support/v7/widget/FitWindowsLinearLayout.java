package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout
  extends LinearLayout
  implements cf
{
  private cg a;
  
  public FitWindowsLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FitWindowsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    cg localcg = this.a;
    if (localcg != null) {
      localcg.a(paramRect);
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public void setOnFitSystemWindowsListener(cg paramcg)
  {
    this.a = paramcg;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/FitWindowsLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */