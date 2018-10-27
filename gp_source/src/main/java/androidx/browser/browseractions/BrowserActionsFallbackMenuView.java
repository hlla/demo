package androidx.browser.browseractions;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

public class BrowserActionsFallbackMenuView
  extends LinearLayout
{
  private final int a = getResources().getDimensionPixelOffset(2131165329);
  private final int b = getResources().getDimensionPixelOffset(2131165330);
  
  public BrowserActionsFallbackMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = getResources().getDisplayMetrics().widthPixels;
    int i = this.b;
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(paramInt1 - (i + i), this.a), 1073741824), paramInt2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/androidx/browser/browseractions/BrowserActionsFallbackMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */