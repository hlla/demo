package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.android.finsky.dialogbuilderlayout.DateSpinner;
import com.google.android.play.layout.PlayTextView;
import com.google.wireless.android.finsky.dfe.e.a.ck;

public final class j
  extends m
{
  public DateSpinner a;
  public final ck b;
  public PlayTextView c;
  public final com.google.android.finsky.be.j d;
  private final w h;
  
  public j(LayoutInflater paramLayoutInflater, ck paramck, com.google.android.finsky.be.j paramj, w paramw)
  {
    super(paramLayoutInflater);
    this.b = paramck;
    this.d = paramj;
    this.h = paramw;
  }
  
  public final int a()
  {
    return 2131625289;
  }
  
  public final void a(d paramd, View paramView)
  {
    this.a = ((DateSpinner)paramView.findViewById(2131427826));
    this.c = ((PlayTextView)paramView.findViewById(2131428049));
    paramView = this.d.a;
    if (paramView == null) {
      this.e.a(this.b.a, this.c, paramd, this.h);
    }
    for (;;)
    {
      this.a.setOnDateChangedListener(new k(this));
      return;
      this.a.setCalendarDate(paramView);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */