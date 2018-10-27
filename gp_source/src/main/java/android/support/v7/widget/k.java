package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.ap;
import android.support.v7.view.menu.t;
import android.view.View;

final class k
  extends ad
{
  public k(j paramj, Context paramContext, ap paramap, View paramView)
  {
    super(paramContext, paramap, paramView, false);
    if (!((t)paramap.getItem()).f())
    {
      paramap = paramj.i;
      paramContext = paramap;
      if (paramap == null) {
        paramContext = (View)paramj.d;
      }
      this.a = paramContext;
    }
    a(paramj.m);
  }
  
  protected final void e()
  {
    this.d.f = null;
    super.e();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */