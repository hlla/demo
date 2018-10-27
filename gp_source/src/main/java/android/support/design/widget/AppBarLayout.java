package android.support.design.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout.LayoutParams;

@i(a=AppBarLayout.Behavior.class)
@Deprecated
public class AppBarLayout
  extends android.support.design.appbar.AppBarLayout
{
  public AppBarLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static a b(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams))) {
      return new a((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new a((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new a(paramLayoutParams);
  }
  
  private static a f()
  {
    return new a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/widget/AppBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */