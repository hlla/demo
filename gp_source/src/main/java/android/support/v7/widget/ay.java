package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

final class ay
  implements PopupWindow.OnDismissListener
{
  ay(av paramav, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
  
  public final void onDismiss()
  {
    ViewTreeObserver localViewTreeObserver = this.a.d.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeGlobalOnLayoutListener(this.b);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */