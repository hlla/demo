package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import com.google.android.finsky.bc.g;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.play.image.FifeImageView;
import com.google.wireless.android.finsky.dfe.e.a.db;

public final class y
  extends m
{
  public final db a;
  private final g b;
  
  public y(LayoutInflater paramLayoutInflater, db paramdb, g paramg)
  {
    super(paramLayoutInflater);
    this.a = paramdb;
    this.b = paramg;
  }
  
  public final int a()
  {
    return 2131625297;
  }
  
  public final void a(d paramd, View paramView)
  {
    paramView = (FifeImageView)paramView;
    this.e.a(this.a.b, paramView, paramd, this.b);
    if (this.a.a != null) {
      paramView.setOnClickListener(new z(this, paramd));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */