package android.support.v7.app;

import android.support.v7.view.menu.ag;
import android.support.v7.view.menu.p;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;

final class as
  implements ag
{
  as(aa paramaa) {}
  
  public final void a(p paramp, boolean paramBoolean)
  {
    p localp = paramp.l();
    aa localaa = this.a;
    if (localp != paramp) {}
    for (Object localObject = localp;; localObject = paramp)
    {
      localObject = localaa.a((Menu)localObject);
      if (localObject != null)
      {
        if (localp != paramp)
        {
          this.a.a(((ar)localObject).d, (ar)localObject, localp);
          this.a.a((ar)localObject, true);
        }
      }
      else {
        return;
      }
      this.a.a((ar)localObject, paramBoolean);
      return;
    }
  }
  
  public final boolean a(p paramp)
  {
    if (paramp == null)
    {
      Object localObject = this.a;
      if (((aa)localObject).j)
      {
        localObject = ((aa)localObject).p.getCallback();
        if ((localObject != null) && (!this.a.m)) {
          ((Window.Callback)localObject).onMenuOpened(108, paramp);
        }
      }
    }
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */