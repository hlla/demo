package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.wireless.android.finsky.dfe.e.a.ed;

public final class at
  extends m
{
  public final ed a;
  private final w b;
  
  public at(LayoutInflater paramLayoutInflater, ed paramed, w paramw)
  {
    super(paramLayoutInflater);
    this.a = paramed;
    this.b = paramw;
  }
  
  public final int a()
  {
    return 2131625310;
  }
  
  public final void a(d paramd, View paramView)
  {
    paramView = (TextView)paramView;
    this.e.a(this.a.b, paramView, paramd, this.b);
    if (this.a.a != null)
    {
      paramView.setBackgroundResource(2131231280);
      paramView.setOnClickListener(new au(this, paramd));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */