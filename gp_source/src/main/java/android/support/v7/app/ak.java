package android.support.v7.app;

import android.support.v7.view.menu.ag;
import android.support.v7.view.menu.p;
import android.view.Window;
import android.view.Window.Callback;

final class ak
  implements ag
{
  ak(aa paramaa) {}
  
  public final void a(p paramp, boolean paramBoolean)
  {
    this.a.b(paramp);
  }
  
  public final boolean a(p paramp)
  {
    Window.Callback localCallback = this.a.p.getCallback();
    if (localCallback != null) {
      localCallback.onMenuOpened(108, paramp);
    }
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */