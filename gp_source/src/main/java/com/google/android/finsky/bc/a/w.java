package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.wireless.android.finsky.dfe.e.a.cz;

public final class w
  extends m
{
  private final cz a;
  private final com.google.android.finsky.be.w b;
  
  public w(LayoutInflater paramLayoutInflater, cz paramcz, com.google.android.finsky.be.w paramw)
  {
    super(paramLayoutInflater);
    this.a = paramcz;
    this.b = paramw;
  }
  
  public final int a()
  {
    return 2131625295;
  }
  
  public final void a(d paramd, View paramView)
  {
    this.e.a(this.a.c, (ImageView)paramView.findViewById(2131429328), paramd);
    this.e.a(this.a.b, (ImageView)paramView.findViewById(2131428024), paramd);
    this.e.a(this.a.e, (ImageView)paramView.findViewById(2131429544), paramd);
    this.e.a(this.a.a, (ImageView)paramView.findViewById(2131427550), paramd);
    this.e.a(this.a.d, (TextView)paramView.findViewById(2131429458), paramd, this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */