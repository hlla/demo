package com.google.android.finsky.cq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.g.w;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.dl;
import android.support.v7.widget.dn;
import android.support.v7.widget.dp;
import android.support.v7.widget.dq;
import android.support.v7.widget.dr;
import android.support.v7.widget.ds;
import android.support.v7.widget.eh;
import android.support.v7.widget.ff;
import android.support.v7.widget.fj;
import android.support.v7.widget.fp;
import android.support.v7.widget.fw;
import android.support.v7.widget.fz;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.finsky.utils.FinskyLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends dp
  implements com.google.android.finsky.cq.c.f
{
  public final t r;
  @SuppressLint({"UseSparseArrays"})
  public final Map s = new HashMap();
  private int t = -1;
  private final com.google.android.finsky.cq.d.p u;
  private final com.google.android.finsky.cq.c.i v;
  private final com.google.android.finsky.cq.c.i w;
  private final com.google.android.finsky.cq.c.g x;
  
  c(Context paramContext, t paramt, com.google.android.finsky.cq.d.p paramp, com.google.android.finsky.cq.c.g paramg, com.google.android.finsky.cq.c.i parami1, com.google.android.finsky.cq.c.i parami2)
  {
    this.r = paramt;
    this.u = paramp;
    this.x = paramg;
    this.v = parami1;
    this.w = parami2;
  }
  
  private final void E()
  {
    this.v.a.a(-1);
    this.s.clear();
  }
  
  private final com.google.android.finsky.cq.c.a a(int paramInt, Object paramObject, com.google.android.finsky.cq.c.i parami, ds paramds)
  {
    Object localObject2 = (com.google.android.finsky.cq.c.a)parami.a.a(paramObject);
    Object localObject1 = localObject2;
    int i;
    if (localObject2 == null)
    {
      i = parami.b.size();
      if (i != 0) {
        break label127;
      }
      FinskyLog.e("No spare values!", new Object[0]);
    }
    label127:
    for (localObject1 = parami.c.a();; localObject1 = parami.b.remove(i - 1))
    {
      localObject1 = (com.google.android.finsky.cq.c.a)localObject1;
      localObject2 = this.x;
      localObject2.getClass();
      ((com.google.android.finsky.cq.c.a)localObject1).a(((Integer)a(paramInt, new h((com.google.android.finsky.cq.c.g)localObject2), new i(this), Integer.class, paramds)).intValue());
      parami.a.a(paramObject, localObject1);
      return (com.google.android.finsky.cq.c.a)localObject1;
    }
  }
  
  private static Object a(int paramInt, com.google.android.finsky.utils.b.a parama1, com.google.android.finsky.utils.b.a parama2, Class paramClass, ds paramds)
  {
    if (paramds.c.e)
    {
      Object localObject = parama1.a(paramInt);
      parama1 = (com.google.android.finsky.utils.b.a)localObject;
      if (localObject == com.google.android.finsky.cq.c.g.a(paramClass))
      {
        int i = paramds.a(paramInt);
        if (i == -1)
        {
          parama1 = new StringBuilder(101);
          parama1.append("Cannot find cache item for pre layout position. It is not cached, not in the adapter. Pos:");
          parama1.append(paramInt);
          throw new RuntimeException(parama1.toString());
        }
        parama1 = parama2.a(i);
      }
      return parama1;
    }
    return parama2.a(paramInt);
  }
  
  private final com.google.android.finsky.cq.d.o h(int paramInt, ds paramds)
  {
    paramInt = b(paramInt, paramds);
    paramds = this.u;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown layout strategy type.");
    case 4: 
      return (com.google.android.finsky.cq.d.o)paramds.e.a();
    case 3: 
      return (com.google.android.finsky.cq.d.o)paramds.a.a();
    case 2: 
      return (com.google.android.finsky.cq.d.o)paramds.c.a();
    case 1: 
      return (com.google.android.finsky.cq.d.o)paramds.b.a();
    }
    return (com.google.android.finsky.cq.d.o)paramds.d.a();
  }
  
  public final void A()
  {
    E();
  }
  
  public final void B()
  {
    E();
  }
  
  public final void C()
  {
    E();
  }
  
  public final void D()
  {
    E();
  }
  
  public final int a(int paramInt, ds paramds)
  {
    com.google.android.finsky.cq.c.g localg = this.x;
    localg.getClass();
    return ((Integer)a(paramInt, new d(localg), new e(this), Integer.class, paramds)).intValue();
  }
  
  public final fj a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new c.c(paramContext, paramAttributeSet);
  }
  
  public final fj a(ViewGroup.LayoutParams paramLayoutParams)
  {
    return com.google.android.finsky.cq.c.d.a(paramLayoutParams);
  }
  
  protected final View a(ds paramds, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    eh localeh = this.c;
    int j = localeh.b();
    int k = localeh.c();
    if (paramInt2 > paramInt1) {}
    for (int i = 1;; i = -1)
    {
      Object localObject2 = null;
      Object localObject3;
      if (paramInt1 != paramInt2)
      {
        View localView = d(paramInt1);
        int m = a(localView);
        if (m < 0) {}
        for (;;)
        {
          paramInt1 += i;
          break;
          if (m < paramInt3) {
            if (h(m, paramds).a(m, paramds, this))
            {
              if (!((fj)localView.getLayoutParams()).d.l())
              {
                if (localeh.a(localView) < k)
                {
                  localObject3 = localView;
                  if (localeh.b(localView) >= j) {
                    break label183;
                  }
                }
                if (localObject1 == null) {
                  localObject1 = localView;
                }
              }
              else if (localObject2 == null)
              {
                localObject2 = localView;
              }
            }
            else {}
          }
        }
      }
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        label183:
        return (View)localObject3;
      }
      return (View)localObject2;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, ds paramds)
  {
    if (!paramds.c.e) {
      this.s.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
  }
  
  protected final void a(ds paramds, dq paramdq, int paramInt)
  {
    h(paramdq.a.d, paramds).a(paramds, this, this, paramdq, paramInt);
  }
  
  protected final void a(ds paramds, dr paramdr)
  {
    h(paramds.a.b, paramds).a(paramds, paramdr, this, this);
  }
  
  public final void a(fp paramfp, fw paramfw)
  {
    if (paramfw.a() != 0) {
      if (this.b == 1) {
        break label276;
      }
    }
    label276:
    for (int i = this.g;; i = this.p)
    {
      int j = this.t;
      if (i == j) {}
      for (;;)
      {
        if (paramfw.e)
        {
          j = w();
          i = 0;
          while (i < j)
          {
            com.google.android.finsky.cq.c.c localc = (com.google.android.finsky.cq.c.c)d(i).getLayoutParams();
            int k = localc.d.c();
            com.google.android.finsky.cq.c.g localg = this.x;
            localg.d.put(k, localc.i);
            localg.g.put(k, localc.l);
            localg.e.put(k, localc.j);
            localg.h.put(k, localc.g);
            localg.c.put(k, localc.h);
            localg.f.b(k, localc.k);
            localg.b.put(k, localc.e);
            i += 1;
          }
        }
        super.a(paramfp, paramfw);
        paramfp = this.x;
        paramfp.d.clear();
        paramfp.g.clear();
        paramfp.e.clear();
        paramfp.h.clear();
        paramfp.c.clear();
        paramfp.f.c();
        paramfp.b.clear();
        return;
        if (j != -1) {
          this.m.n();
        }
        this.t = i;
      }
    }
  }
  
  public final boolean a(fj paramfj)
  {
    return paramfj instanceof com.google.android.finsky.cq.c.c;
  }
  
  public final int b(int paramInt, ds paramds)
  {
    com.google.android.finsky.cq.c.g localg = this.x;
    localg.getClass();
    return ((Integer)a(paramInt, new j(localg), new k(this), Integer.class, paramds)).intValue();
  }
  
  public final int b(fp paramfp, fw paramfw)
  {
    if (o()) {
      return this.r.b();
    }
    return 1;
  }
  
  public final int c(int paramInt, ds paramds)
  {
    com.google.android.finsky.cq.c.g localg = this.x;
    localg.getClass();
    return ((Integer)a(paramInt, new l(localg), new m(this), Integer.class, paramds)).intValue();
  }
  
  public final int c(fp paramfp, fw paramfw)
  {
    if (n()) {
      return this.r.b();
    }
    return 1;
  }
  
  public final String d(int paramInt, ds paramds)
  {
    com.google.android.finsky.cq.c.g localg = this.x;
    localg.getClass();
    return (String)a(paramInt, new n(localg), new o(this), String.class, paramds);
  }
  
  final b e(int paramInt)
  {
    int i = f(paramInt);
    Object localObject = this.r.l(i);
    if (localObject == null)
    {
      localObject = new StringBuilder(54);
      ((StringBuilder)localObject).append("GridSpanSizeLookup is not provided for pos:");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (b)localObject;
  }
  
  public final com.google.android.finsky.cq.c.a e(int paramInt, ds paramds)
  {
    if (b(paramInt, paramds) == 2)
    {
      String str = d(paramInt, paramds);
      if (str != null) {
        return a(paramInt, str, this.w, paramds);
      }
    }
    return a(paramInt, Integer.valueOf(c(paramInt, paramds)), this.v, paramds);
  }
  
  final int f(int paramInt)
  {
    return this.r.j(paramInt);
  }
  
  public final int f(int paramInt, ds paramds)
  {
    com.google.android.finsky.cq.c.g localg = this.x;
    localg.getClass();
    return ((Integer)a(paramInt, new p(localg), new q(this), Integer.class, paramds)).intValue();
  }
  
  public final int g(int paramInt, ds paramds)
  {
    Object localObject = this.x;
    localObject.getClass();
    localObject = new f((com.google.android.finsky.cq.c.g)localObject);
    g localg = new g(this);
    if (paramds.c.e)
    {
      int i = ((com.google.android.finsky.utils.b.b)localObject).a(paramInt);
      if (i == ((Integer)com.google.android.finsky.cq.c.g.a(Integer.class)).intValue())
      {
        i = paramds.a(paramInt);
        if (i == -1)
        {
          paramds = new StringBuilder(101);
          paramds.append("Cannot find cache item for pre layout position. It is not cached, not in the adapter. Pos:");
          paramds.append(paramInt);
          throw new RuntimeException(paramds.toString());
        }
        return localg.a(i);
      }
      return i;
    }
    return localg.a(paramInt);
  }
  
  public final fj l()
  {
    return com.google.android.finsky.cq.c.d.a(this.b);
  }
  
  public final void z()
  {
    E();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cq/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */