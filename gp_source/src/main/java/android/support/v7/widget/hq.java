package android.support.v7.widget;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;

public final class hq
{
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramView.setTooltipText(paramCharSequence);
      return;
    }
    if ((hr.c != null) && (hr.c.a == paramView)) {
      hr.a(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((hr.b != null) && (hr.b.a == paramView)) {
        hr.b.a();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new hr(paramView, paramCharSequence);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */