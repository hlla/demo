package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.c.a.a;
import android.support.v4.c.a.b;
import android.view.Menu;
import android.view.MenuItem;

public final class n
{
  public static Menu a(Context paramContext, a parama)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new o(paramContext, parama);
    }
    throw new UnsupportedOperationException();
  }
  
  public static MenuItem a(Context paramContext, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new j(paramContext, paramb);
    }
    if (Build.VERSION.SDK_INT >= 14) {
      return new i(paramContext, paramb);
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */