package android.support.v4.view;

import android.support.v4.c.a.b;
import android.util.Log;
import android.view.MenuItem;

public final class p
{
  public static MenuItem a(MenuItem paramMenuItem, d paramd)
  {
    if (!(paramMenuItem instanceof b))
    {
      Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
      return paramMenuItem;
    }
    return ((b)paramMenuItem).a(paramd);
  }
  
  @Deprecated
  public static MenuItem a(MenuItem paramMenuItem, r paramr)
  {
    return paramMenuItem.setOnActionExpandListener(new q(paramr));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */