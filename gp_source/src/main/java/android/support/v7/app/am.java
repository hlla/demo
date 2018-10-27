package android.support.v7.app;

import android.support.v4.view.ac;
import android.support.v4.view.az;
import android.support.v4.view.bd;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;
import android.widget.PopupWindow;

final class am
  extends bd
{
  am(al paramal) {}
  
  public final void a(View paramView)
  {
    this.a.a.d.setVisibility(8);
    paramView = this.a.a;
    PopupWindow localPopupWindow = paramView.c;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
    for (;;)
    {
      this.a.a.d.removeAllViews();
      this.a.a.h.a(null);
      this.a.a.h = null;
      return;
      if ((paramView.d.getParent() instanceof View)) {
        ac.x((View)this.a.a.d.getParent());
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */