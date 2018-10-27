package android.support.v7.app;

import android.support.v7.view.menu.p;
import android.view.Menu;
import android.view.Window.Callback;

final class ay
  implements Runnable
{
  ay(ax paramax) {}
  
  public final void run()
  {
    ax localax = this.a;
    Menu localMenu = localax.n();
    if ((localMenu instanceof p)) {}
    for (localp = (p)localMenu;; localp = null)
    {
      if (localp == null) {}
      for (;;)
      {
        try
        {
          localMenu.clear();
          if ((!localax.c.onCreatePanelMenu(0, localMenu)) || (!localax.c.onPreparePanel(0, null, localMenu))) {
            localMenu.clear();
          }
          return;
        }
        finally
        {
          if (localp == null) {
            continue;
          }
          localp.f();
        }
        localp.e();
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */