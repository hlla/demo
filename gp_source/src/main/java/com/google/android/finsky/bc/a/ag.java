package com.google.android.finsky.bc.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.finsky.bc.g;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.wireless.android.finsky.dfe.e.a.dd;
import com.google.wireless.android.finsky.dfe.e.a.do;
import com.google.wireless.android.finsky.dfe.e.a.dp;

public final class ag
  extends m
{
  private final do a;
  private final g b;
  
  public ag(LayoutInflater paramLayoutInflater, do paramdo, g paramg)
  {
    super(paramLayoutInflater);
    this.a = paramdo;
    this.b = paramg;
  }
  
  public final int a()
  {
    return 2131625303;
  }
  
  public final void a(d paramd, View paramView)
  {
    ProgressBar localProgressBar = (ProgressBar)paramView;
    h localh = this.e;
    dp localdp = this.a.a;
    g localg = this.b;
    dd localdd;
    Drawable localDrawable;
    if (localdp != null)
    {
      paramView = localdp.b;
      if (paramView != null)
      {
        paramView = h.a(localProgressBar, paramView);
        if (paramView != null) {
          localProgressBar.setIndeterminateDrawable(paramView);
        }
      }
      localdd = localdp.a;
      if (localdd != null)
      {
        localDrawable = localProgressBar.getIndeterminateDrawable();
        if (localdd == null) {
          break label140;
        }
        paramView = localDrawable;
        if ((localdd.a & 0x1) == 0) {}
      }
    }
    label140:
    for (paramView = h.a(localDrawable, localdd.b, h.a(localdd.c));; paramView = null)
    {
      localProgressBar.setIndeterminateDrawable(paramView);
      localh.a(localdp.c, localProgressBar, paramd, localg);
      localProgressBar.setVisibility(0);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */