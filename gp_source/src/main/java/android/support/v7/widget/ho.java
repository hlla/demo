package android.support.v7.widget;

import android.support.v7.view.menu.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window.Callback;

final class ho
  implements View.OnClickListener
{
  private final a a = new a(this.b.c.getContext(), this.b.b);
  
  ho(hn paramhn) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.b;
    Window.Callback localCallback = paramView.d;
    if ((localCallback != null) && (paramView.a)) {
      localCallback.onMenuItemSelected(0, this.a);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */