package android.support.v7.view.menu;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.ec;
import android.view.MenuItem;
import java.util.List;

final class j
  implements ec
{
  j(g paramg) {}
  
  public final void a(p paramp, MenuItem paramMenuItem)
  {
    this.a.e.removeCallbacksAndMessages(paramp);
  }
  
  public final void b(p paramp, MenuItem paramMenuItem)
  {
    this.a.e.removeCallbacksAndMessages(null);
    int j = this.a.c.size();
    int i = 0;
    while (i < j)
    {
      if (paramp == ((l)this.a.c.get(i)).a) {
        break label152;
      }
      i += 1;
    }
    i = -1;
    label146:
    label152:
    for (;;)
    {
      if (i != -1)
      {
        i += 1;
        if (i >= this.a.c.size()) {
          break label146;
        }
      }
      for (l locall = (l)this.a.c.get(i);; locall = null)
      {
        paramMenuItem = new k(this, locall, paramMenuItem, paramp);
        long l = SystemClock.uptimeMillis();
        this.a.e.postAtTime(paramMenuItem, paramp, l + 200L);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */