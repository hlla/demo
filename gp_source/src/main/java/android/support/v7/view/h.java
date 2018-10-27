package android.support.v7.view;

import android.content.Context;
import android.support.v4.c.a.a;
import android.support.v4.g.v;
import android.support.v7.view.menu.aj;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public final class h
  implements c
{
  private final ArrayList a;
  private final Context b;
  private final v c;
  private final ActionMode.Callback d;
  
  public h(Context paramContext, ActionMode.Callback paramCallback)
  {
    this.b = paramContext;
    this.d = paramCallback;
    this.a = new ArrayList();
    this.c = new v();
  }
  
  private final Menu a(Menu paramMenu)
  {
    Menu localMenu2 = (Menu)this.c.get(paramMenu);
    Menu localMenu1 = localMenu2;
    if (localMenu2 == null)
    {
      localMenu1 = aj.a(this.b, (a)paramMenu);
      this.c.put(paramMenu, localMenu1);
    }
    return localMenu1;
  }
  
  public final void a(b paramb)
  {
    this.d.onDestroyActionMode(b(paramb));
  }
  
  public final boolean a(b paramb, Menu paramMenu)
  {
    return this.d.onCreateActionMode(b(paramb), a(paramMenu));
  }
  
  public final boolean a(b paramb, MenuItem paramMenuItem)
  {
    return this.d.onActionItemClicked(b(paramb), aj.a(this.b, (android.support.v4.c.a.b)paramMenuItem));
  }
  
  public final ActionMode b(b paramb)
  {
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      g localg = (g)this.a.get(i);
      if (localg == null) {}
      while (localg.a != paramb)
      {
        i += 1;
        break;
      }
      return localg;
    }
    paramb = new g(this.b, paramb);
    this.a.add(paramb);
    return paramb;
  }
  
  public final boolean b(b paramb, Menu paramMenu)
  {
    return this.d.onPrepareActionMode(b(paramb), a(paramMenu));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */