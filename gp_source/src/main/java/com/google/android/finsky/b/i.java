package com.google.android.finsky.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.android.finsky.dfemodel.v;
import com.google.android.finsky.frameworkviews.r;
import com.google.android.finsky.navigationmanager.c;

public abstract class i
  extends BaseAdapter
  implements v, r
{
  public final Context b;
  public int c;
  public final LayoutInflater d;
  public final c e;
  
  public i(Context paramContext, c paramc)
  {
    this.b = paramContext;
    this.e = paramc;
    this.d = LayoutInflater.from(paramContext);
    this.c = 1;
  }
  
  private final void a(int paramInt)
  {
    this.c = paramInt;
    notifyDataSetChanged();
  }
  
  public final View a(int paramInt, ViewGroup paramViewGroup)
  {
    return this.d.inflate(paramInt, paramViewGroup, false);
  }
  
  public abstract void a();
  
  public abstract String b();
  
  public abstract boolean c();
  
  public final void d()
  {
    if (this.c == 2) {
      a();
    }
    a(1);
  }
  
  public void e()
  {
    if (c())
    {
      a(1);
      return;
    }
    a(0);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */