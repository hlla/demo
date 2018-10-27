package android.support.v7.app;

import android.support.v7.view.menu.p;
import android.support.v7.widget.bh;
import android.support.v7.widget.bi;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;

final class af
  implements bh
{
  af(aa paramaa) {}
  
  public final void a() {}
  
  public final void b()
  {
    Object localObject = this.a;
    bi localbi = ((aa)localObject).g;
    if (localbi != null) {
      localbi.h();
    }
    if (((aa)localObject).c != null)
    {
      ((aa)localObject).p.getDecorView().removeCallbacks(((aa)localObject).o);
      if (!((aa)localObject).c.isShowing()) {}
    }
    try
    {
      ((aa)localObject).c.dismiss();
      ((aa)localObject).c = null;
      ((aa)localObject).o();
      localObject = ((aa)localObject).d(0);
      if (localObject != null)
      {
        localObject = ((ar)localObject).l;
        if (localObject != null) {
          ((p)localObject).close();
        }
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */