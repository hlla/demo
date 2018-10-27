package android.support.v7.app;

import android.support.v7.view.menu.ag;
import android.support.v7.view.menu.p;
import android.support.v7.widget.bj;
import android.view.Window.Callback;

final class ba
  implements ag
{
  private boolean a;
  
  ba(ax paramax) {}
  
  public final void a(p paramp, boolean paramBoolean)
  {
    if (!this.a)
    {
      this.a = true;
      this.b.a.n();
      Window.Callback localCallback = this.b.c;
      if (localCallback != null) {
        localCallback.onPanelClosed(108, paramp);
      }
      this.a = false;
    }
  }
  
  public final boolean a(p paramp)
  {
    Window.Callback localCallback = this.b.c;
    if (localCallback != null)
    {
      localCallback.onMenuOpened(108, paramp);
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */