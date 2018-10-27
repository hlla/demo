package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.wireless.android.finsky.dfe.e.a.ds;

public final class ah
  extends m
{
  private final ds a;
  private final w b;
  
  public ah(LayoutInflater paramLayoutInflater, ds paramds, w paramw)
  {
    super(paramLayoutInflater);
    this.a = paramds;
    this.b = paramw;
  }
  
  public final int a()
  {
    return 2131625300;
  }
  
  public final void a(d paramd, View paramView)
  {
    this.e.a(this.a.d, (TextView)paramView.findViewById(2131429479), paramd, this.b);
    this.e.a(this.a.c, (TextView)paramView.findViewById(2131428899), paramd, this.b);
    this.e.a(this.a.a, (TextView)paramView.findViewById(2131427856), paramd, this.b);
    this.e.a(this.a.b, (TextView)paramView.findViewById(2131428214), paramd, this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */