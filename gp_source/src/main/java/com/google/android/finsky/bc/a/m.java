package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.bw.l;
import com.google.android.finsky.dt.b;

public abstract class m
{
  public h e;
  public l f;
  public final LayoutInflater g;
  
  public m(LayoutInflater paramLayoutInflater)
  {
    ((o)b.a(o.class)).a(this);
    this.g = paramLayoutInflater;
  }
  
  public abstract int a();
  
  public View a(d paramd, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.g.inflate(a(), paramViewGroup, false);
    a(paramd, paramViewGroup);
    return paramViewGroup;
  }
  
  public abstract void a(d paramd, View paramView);
  
  public int b()
  {
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */