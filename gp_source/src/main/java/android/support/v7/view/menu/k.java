package android.support.v7.view.menu;

import android.view.MenuItem;

final class k
  implements Runnable
{
  k(j paramj, l paraml, MenuItem paramMenuItem, p paramp) {}
  
  public final void run()
  {
    l locall = this.d;
    if (locall != null)
    {
      this.a.a.b = true;
      locall.a.a(false);
      this.a.a.b = false;
    }
    if ((this.b.isEnabled()) && (this.b.hasSubMenu())) {
      this.c.a(this.b, null, 4);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */