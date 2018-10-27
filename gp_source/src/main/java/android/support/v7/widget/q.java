package android.support.v7.widget;

import android.support.v7.view.menu.ag;
import android.support.v7.view.menu.ap;
import android.support.v7.view.menu.d;
import android.support.v7.view.menu.p;
import android.view.MenuItem;

final class q
  implements ag
{
  q(j paramj) {}
  
  public final void a(p paramp, boolean paramBoolean)
  {
    if ((paramp instanceof ap)) {
      paramp.l().a(false);
    }
    ag localag = this.a.a;
    if (localag != null) {
      localag.a(paramp, paramBoolean);
    }
  }
  
  public final boolean a(p paramp)
  {
    if (paramp != null)
    {
      ((ap)paramp).getItem().getItemId();
      ag localag = this.a.a;
      if (localag != null) {
        return localag.a(paramp);
      }
      return false;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */