package com.google.android.finsky.bc.a;

import android.os.Build.VERSION;
import android.support.v4.g.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.android.finsky.bd.a;
import com.google.android.finsky.bd.f;
import com.google.wireless.android.finsky.dfe.e.a.cc;
import com.google.wireless.android.finsky.dfe.e.a.cr;
import com.google.wireless.android.finsky.dfe.e.a.cs;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class r
  extends m
  implements f
{
  private static final AtomicInteger h = new AtomicInteger(1);
  private com.google.android.finsky.be.d a;
  private final w b;
  private final a c;
  private final com.google.android.finsky.bd.d d;
  
  public r(LayoutInflater paramLayoutInflater, cr paramcr, a parama, com.google.android.finsky.bd.d paramd)
  {
    super(paramLayoutInflater);
    this.b = new w(paramcr.a.length);
    paramLayoutInflater = paramcr.a;
    int j = paramLayoutInflater.length;
    int i = 0;
    while (i < j)
    {
      paramcr = paramLayoutInflater[i];
      this.b.b(paramcr.a, paramcr.b);
      i += 1;
    }
    this.c = parama;
    this.d = paramd;
  }
  
  public final int a()
  {
    return 2131625306;
  }
  
  public final View a(com.google.android.finsky.be.d paramd, ViewGroup paramViewGroup)
  {
    Object localObject = this.c.c;
    if (localObject == null)
    {
      paramViewGroup = this.g.inflate(a(), paramViewGroup, false);
      this.c.c = paramViewGroup;
    }
    for (;;)
    {
      this.a = paramd;
      paramd = this.d;
      paramd.e = this;
      localObject = paramd.l;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.google.android.finsky.bd.h localh = (com.google.android.finsky.bd.h)((Iterator)localObject).next();
          paramd.e.a(localh.a, localh.b);
        }
        paramd.l = null;
      }
      localObject = paramd.f;
      if (localObject != null)
      {
        paramd.e.a(((Integer)localObject).intValue());
        paramd.f = null;
      }
      return paramViewGroup;
      paramViewGroup = (ViewGroup)localObject;
      if (((View)localObject).getParent() != null)
      {
        ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
        paramViewGroup = (ViewGroup)localObject;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    View localView = this.c.c;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  public final void a(Button paramButton, int paramInt)
  {
    int j;
    if ((this.c.c != null) && (this.a != null)) {
      if (paramButton.getId() == -1)
      {
        if (Build.VERSION.SDK_INT >= 17) {
          break label118;
        }
        do
        {
          j = h.get();
          int k = j + 1;
          i = k;
          if (k > 16777215) {
            i = 1;
          }
        } while (!h.compareAndSet(j, i));
      }
    }
    label118:
    for (int i = j;; i = View.generateViewId())
    {
      paramButton.setId(i);
      this.e.a((cc)this.b.a(paramInt, null), paramButton, this.a);
      ((ViewGroup)this.c.c).addView(paramButton);
      return;
    }
  }
  
  public final void a(com.google.android.finsky.be.d paramd, View paramView)
  {
    throw new UnsupportedOperationException("FragmentFooterComponent does not support view configuration.");
  }
  
  public final void c()
  {
    View localView = this.c.c;
    if (localView != null) {
      ((ViewGroup)localView).removeAllViews();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */