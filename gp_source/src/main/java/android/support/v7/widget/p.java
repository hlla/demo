package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.menu.ad;
import android.view.View;

final class p
  extends ad
{
  public p(j paramj, Context paramContext, android.support.v7.view.menu.p paramp, View paramView)
  {
    super(paramContext, paramp, paramView, true);
    this.b = 8388613;
    a(paramj.m);
  }
  
  protected final void e()
  {
    android.support.v7.view.menu.p localp = this.d.c;
    if (localp != null) {
      localp.close();
    }
    this.d.j = null;
    super.e();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */