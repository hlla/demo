package android.support.v7.app;

import android.support.v7.view.menu.p;
import android.support.v7.view.menu.q;
import android.support.v7.widget.bj;
import android.view.MenuItem;
import android.view.Window.Callback;

final class bb
  implements q
{
  bb(ax paramax) {}
  
  public final void a(p paramp)
  {
    ax localax = this.a;
    if (localax.c != null)
    {
      if (!localax.a.i()) {
        break label40;
      }
      this.a.c.onPanelClosed(108, paramp);
    }
    label40:
    while (!this.a.c.onPreparePanel(0, null, paramp)) {
      return;
    }
    this.a.c.onMenuOpened(108, paramp);
  }
  
  public final boolean a(p paramp, MenuItem paramMenuItem)
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */