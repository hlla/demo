package com.google.android.finsky.au;

import android.content.Intent;
import android.support.design.snackbar.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.finsky.e.af;
import com.google.android.finsky.pagesystem.b;

final class d
  implements OnClickListener
{
  d(a parama, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a;
    paramView.ag = true;
    paramView.bg.a(new com.google.android.finsky.e.f(paramView.ah));
    paramView = (com.google.android.finsky.at.d)this.a.aa.a();
    a locala = this.a;
    paramView.a(locala.aY, locala.bg, this.b);
    if (this.a.ab.cY().a(12631833L))
    {
      paramView = this.a;
      Snackbar.a(paramView.U, paramView.c(2131952099), 0).d();
      paramView = this.a;
      paramView.bh.a(paramView.ba, paramView.bg);
      return;
    }
    this.a.am();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/au/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */