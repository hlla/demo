package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.j;
import com.google.android.finsky.utils.n;
import com.google.android.play.layout.PlayTextView;
import com.google.common.a.be;
import com.google.wireless.android.finsky.dfe.e.a.cj;
import java.util.GregorianCalendar;

public final class i
  extends m
{
  private final cj a;
  private final j b;
  
  public i(LayoutInflater paramLayoutInflater, cj paramcj, j paramj)
  {
    super(paramLayoutInflater);
    this.a = paramcj;
    this.b = paramj;
  }
  
  public final int a()
  {
    return 2131625310;
  }
  
  public final void a(d paramd, View paramView)
  {
    j localj = this.b;
    long l = this.a.a;
    GregorianCalendar localGregorianCalendar;
    if (localj.a != null)
    {
      localGregorianCalendar = new GregorianCalendar();
      localGregorianCalendar.setTimeInMillis(l);
    }
    for (int i = n.a(localj.a, localGregorianCalendar);; i = -1)
    {
      this.e.a(this.a.b, (PlayTextView)paramView, paramd, be.a(Integer.valueOf(i).toString()));
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */