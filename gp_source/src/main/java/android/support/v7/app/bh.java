package android.support.v7.app;

import android.support.v4.view.ac;
import android.support.v4.view.bd;
import android.support.v7.view.c;
import android.support.v7.widget.ActionBarContainer;
import android.view.View;

final class bh
  extends bd
{
  bh(bg parambg) {}
  
  public final void a(View paramView)
  {
    paramView = this.a;
    if (paramView.c)
    {
      paramView = paramView.d;
      if (paramView != null)
      {
        paramView.setTranslationY(0.0F);
        this.a.b.setTranslationY(0.0F);
      }
    }
    this.a.b.setVisibility(8);
    this.a.b.setTransitioning(false);
    paramView = this.a;
    paramView.g = null;
    c localc = paramView.j;
    if (localc != null)
    {
      localc.a(paramView.i);
      paramView.i = null;
      paramView.j = null;
    }
    paramView = this.a.n;
    if (paramView != null) {
      ac.x(paramView);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */