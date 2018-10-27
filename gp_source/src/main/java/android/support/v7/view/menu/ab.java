package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.e;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

final class ab
  extends w
  implements ActionProvider.VisibilityListener
{
  private e c;
  
  public ab(aa paramaa, Context paramContext, ActionProvider paramActionProvider)
  {
    super(paramaa, paramActionProvider);
  }
  
  public final View a(MenuItem paramMenuItem)
  {
    return this.b.onCreateActionView(paramMenuItem);
  }
  
  public final void a(e parame)
  {
    this.c = parame;
    this.b.setVisibilityListener(this);
  }
  
  public final boolean b()
  {
    return this.b.overridesItemVisibility();
  }
  
  public final boolean c()
  {
    return this.b.isVisible();
  }
  
  public final void onActionProviderVisibilityChanged(boolean paramBoolean)
  {
    e locale = this.c;
    if (locale != null) {
      locale.a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */