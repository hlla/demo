package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.bd.a;
import com.google.android.finsky.bd.g;
import com.google.android.finsky.be.w;
import com.google.wireless.android.finsky.dfe.e.a.ct;

public final class s
  extends m
  implements g
{
  private View a;
  private final a b;
  private final ct c;
  private final com.google.android.finsky.bd.d d;
  private final w h;
  
  public s(LayoutInflater paramLayoutInflater, ct paramct, a parama, w paramw, com.google.android.finsky.bd.d paramd)
  {
    super(paramLayoutInflater);
    this.b = parama;
    this.c = paramct;
    this.h = paramw;
    this.d = paramd;
  }
  
  public final int a()
  {
    return 2131625295;
  }
  
  public final View a(com.google.android.finsky.be.d paramd, ViewGroup paramViewGroup)
  {
    Object localObject = this.b.e;
    if (localObject == null)
    {
      paramViewGroup = this.g.inflate(a(), paramViewGroup, false);
      this.b.e = paramViewGroup;
    }
    for (;;)
    {
      a(paramd, paramViewGroup);
      paramd = this.d;
      paramd.g = this;
      localObject = paramd.i;
      if (localObject != null)
      {
        paramd.g.a((String)localObject);
        paramd.i = null;
      }
      localObject = paramd.j;
      if (localObject != null)
      {
        paramd.g.a(((Integer)localObject).intValue());
        paramd.j = null;
      }
      localObject = paramd.h;
      if (localObject != null)
      {
        paramd.g.b(((Integer)localObject).intValue());
        paramd.h = null;
      }
      localObject = paramd.d;
      if (localObject != null)
      {
        paramd.g.a((View)localObject);
        paramd.d = null;
      }
      return paramViewGroup;
      if (((View)localObject).getParent() != null)
      {
        ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
        paramViewGroup = (ViewGroup)localObject;
      }
      else
      {
        paramViewGroup = (ViewGroup)localObject;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    View localView = this.b.e;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  public final void a(View paramView)
  {
    if (this.b.e != null)
    {
      View localView = this.a;
      if ((localView != null) && (localView.getParent() != null)) {
        ((ViewGroup)this.a.getParent()).removeView(this.a);
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      ((LinearLayout)this.b.e.findViewById(2131428551)).addView(paramView);
      this.a = paramView;
    }
  }
  
  public final void a(com.google.android.finsky.be.d paramd, View paramView)
  {
    this.e.a(this.c.a, (ImageView)paramView.findViewById(2131429328), paramd);
    this.e.a(this.c.b, (TextView)paramView.findViewById(2131429458), paramd, this.h);
  }
  
  public final void a(String paramString)
  {
    View localView = this.b.e;
    if (localView != null) {
      ((TextView)localView.findViewById(2131429458)).setText(paramString);
    }
  }
  
  public final void b(int paramInt)
  {
    View localView = this.b.e;
    if (localView != null) {
      localView.findViewById(2131429328).setVisibility(paramInt);
    }
  }
  
  public final void c()
  {
    if (this.b.e != null)
    {
      View localView = this.a;
      if (localView != null)
      {
        ((ViewGroup)localView.getParent()).removeView(this.a);
        this.a = null;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */