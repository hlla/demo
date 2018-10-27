package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.formats.a.ax;
import com.google.android.gms.ads.internal.mediation.client.n;
import com.google.android.gms.ads.internal.mediation.client.q;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.ads.internal.zxxz.aa;
import com.google.android.gms.common.internal.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@a
public final class s
  extends x
{
  private boolean g = false;
  private final u h;
  private n i;
  private q j;
  private t k;
  private boolean l = false;
  private final Object m = new Object();
  private com.google.android.gms.ads.internal.mediation.client.t n;
  
  private s(Context paramContext, u paramu, aa paramaa, v paramv)
  {
    super(paramContext, paramu, null, paramaa, null, paramv, null, null);
    this.h = paramu;
  }
  
  public s(Context paramContext, u paramu, aa paramaa, n paramn, v paramv)
  {
    this(paramContext, paramu, paramaa, paramv);
    this.i = paramn;
  }
  
  public s(Context paramContext, u paramu, aa paramaa, q paramq, v paramv)
  {
    this(paramContext, paramu, paramaa, paramv);
    this.j = paramq;
  }
  
  public s(Context paramContext, u paramu, aa paramaa, com.google.android.gms.ads.internal.mediation.client.t paramt, v paramv)
  {
    this(paramContext, paramu, paramaa, paramv);
    this.n = paramt;
  }
  
  private static HashMap a(Map paramMap)
  {
    HashMap localHashMap1 = new HashMap();
    if (paramMap != null)
    {
      try
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          View localView = (View)((WeakReference)localEntry.getValue()).get();
          if (localView != null) {
            localHashMap1.put((String)localEntry.getKey(), localView);
          }
        }
      }
      finally {}
      return localHashMap2;
    }
    return localHashMap2;
  }
  
  private final void e(View paramView)
  {
    Object localObject;
    do
    {
      try
      {
        localObject = this.n;
        if (localObject == null)
        {
          localObject = this.i;
          if (localObject == null) {}
          while (((n)localObject).k())
          {
            localObject = this.j;
            if ((localObject == null) || (((q)localObject).i())) {
              break;
            }
            this.j.a(com.google.android.gms.dynamic.e.a(paramView));
            this.h.e();
            return;
          }
          this.i.a(com.google.android.gms.dynamic.e.a(paramView));
          this.h.e();
          return;
        }
      }
      catch (RemoteException paramView)
      {
        com.google.android.gms.ads.internal.util.e.e("Failed to call performClick", paramView);
        return;
      }
    } while (((com.google.android.gms.ads.internal.mediation.client.t)localObject).q());
    this.n.a(com.google.android.gms.dynamic.e.a(paramView));
    this.h.e();
  }
  
  public final View a(View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    t localt;
    for (;;)
    {
      synchronized (this.m)
      {
        localt = this.k;
        if (localt != null) {
          break;
        }
        try
        {
          paramOnClickListener = this.n;
          if (paramOnClickListener != null) {
            break label92;
          }
          paramOnClickListener = this.i;
          if (paramOnClickListener != null) {
            break label82;
          }
          paramOnClickListener = this.j;
          if (paramOnClickListener == null) {
            break label77;
          }
          paramOnClickListener = paramOnClickListener.k();
        }
        catch (RemoteException paramOnClickListener)
        {
          com.google.android.gms.ads.internal.util.e.e("Failed to call getAdChoicesContent", paramOnClickListener);
          paramOnClickListener = null;
          continue;
        }
        if (paramOnClickListener != null)
        {
          paramOnClickListener = (View)com.google.android.gms.dynamic.e.a(paramOnClickListener);
          return paramOnClickListener;
        }
        return null;
      }
      label77:
      paramOnClickListener = null;
      continue;
      label82:
      paramOnClickListener = paramOnClickListener.n();
      continue;
      label92:
      paramOnClickListener = paramOnClickListener.l();
    }
    paramOnClickListener = localt.a(paramOnClickListener, paramBoolean);
    return paramOnClickListener;
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    synchronized (this.m)
    {
      t localt = this.k;
      if (localt == null) {
        return;
      }
      localt.a(paramMotionEvent);
    }
  }
  
  public final void a(View paramView)
  {
    synchronized (this.m)
    {
      t localt = this.k;
      if (localt == null) {
        return;
      }
      localt.a(paramView);
    }
  }
  
  public final void a(View paramView, Map paramMap)
  {
    z.a("recordImpression must be called on the main UI thread.");
    for (;;)
    {
      t localt;
      synchronized (this.m)
      {
        this.e = true;
        localt = this.k;
        if (localt != null) {
          break label160;
        }
        try
        {
          paramView = this.n;
          if (paramView != null) {
            break label130;
          }
          paramView = this.i;
          if (paramView != null) {
            continue;
          }
          paramView = this.j;
          if ((paramView != null) && (!paramView.h()))
          {
            this.j.g();
            this.h.M();
          }
        }
        catch (RemoteException paramView)
        {
          com.google.android.gms.ads.internal.util.e.e("Failed to call recordImpression", paramView);
          continue;
        }
        return;
        if (paramView.j()) {
          continue;
        }
        this.i.i();
        this.h.M();
      }
      label130:
      if (!paramView.p())
      {
        this.n.r();
        this.h.M();
        continue;
        label160:
        localt.a(paramView, paramMap);
        this.h.M();
      }
    }
  }
  
  public final void a(View paramView1, Map paramMap, Bundle paramBundle, View paramView2)
  {
    z.a("performClick must be called on the main UI thread.");
    do
    {
      synchronized (this.m)
      {
        if (!this.g)
        {
          t localt = this.k;
          if (localt == null)
          {
            e(paramView1);
            return;
          }
          localt.a(paramView1, paramMap, paramBundle, paramView2);
          this.h.e();
        }
      }
    } while (!b());
  }
  
  public final void a(View paramView, Map paramMap1, Map paramMap2, View.OnTouchListener arg4, View.OnClickListener paramOnClickListener)
  {
    for (;;)
    {
      synchronized (this.m)
      {
        this.l = true;
        paramMap1 = a(paramMap1);
        paramMap2 = a(paramMap2);
        try
        {
          paramOnClickListener = this.n;
          if (paramOnClickListener != null) {
            break label152;
          }
          paramOnClickListener = this.i;
          if (paramOnClickListener != null) {
            break label117;
          }
          paramOnClickListener = this.j;
          if (paramOnClickListener != null) {
            continue;
          }
        }
        catch (RemoteException paramView)
        {
          com.google.android.gms.ads.internal.util.e.e("Failed to call prepareAd", paramView);
          continue;
        }
        this.l = false;
        return;
        paramOnClickListener.a(com.google.android.gms.dynamic.e.a(paramView), com.google.android.gms.dynamic.e.a(paramMap1), com.google.android.gms.dynamic.e.a(paramMap2));
        this.j.b(com.google.android.gms.dynamic.e.a(paramView));
      }
      label117:
      paramOnClickListener.a(com.google.android.gms.dynamic.e.a(paramView), com.google.android.gms.dynamic.e.a(paramMap1), com.google.android.gms.dynamic.e.a(paramMap2));
      this.i.b(com.google.android.gms.dynamic.e.a(paramView));
      continue;
      label152:
      paramOnClickListener.a(com.google.android.gms.dynamic.e.a(paramView), com.google.android.gms.dynamic.e.a(paramMap1), com.google.android.gms.dynamic.e.a(paramMap2));
    }
  }
  
  public final void a(ax paramax)
  {
    synchronized (this.m)
    {
      t localt = this.k;
      if (localt == null) {
        return;
      }
      localt.a(paramax);
    }
  }
  
  public final void a(t paramt)
  {
    synchronized (this.m)
    {
      this.k = paramt;
      return;
    }
  }
  
  public final boolean a()
  {
    synchronized (this.m)
    {
      t localt = this.k;
      if (localt == null)
      {
        bool = this.h.V();
        return bool;
      }
      boolean bool = localt.a();
      return bool;
    }
  }
  
  public final void b(View paramView)
  {
    for (;;)
    {
      Object localObject2;
      synchronized (this.m)
      {
        try
        {
          localObject2 = this.n;
          if (localObject2 != null) {
            break label75;
          }
          localObject2 = this.i;
          if (localObject2 != null) {
            continue;
          }
          localObject2 = this.j;
          if (localObject2 != null) {
            ((q)localObject2).c(com.google.android.gms.dynamic.e.a(paramView));
          }
        }
        catch (RemoteException paramView)
        {
          com.google.android.gms.ads.internal.util.e.e("Failed to call untrackView", paramView);
          continue;
        }
        return;
        ((n)localObject2).c(com.google.android.gms.dynamic.e.a(paramView));
      }
      label75:
      ((com.google.android.gms.ads.internal.mediation.client.t)localObject2).b(com.google.android.gms.dynamic.e.a(paramView));
    }
  }
  
  public final boolean b()
  {
    synchronized (this.m)
    {
      t localt = this.k;
      if (localt == null)
      {
        bool = this.h.X();
        return bool;
      }
      boolean bool = localt.b();
      return bool;
    }
  }
  
  public final boolean c()
  {
    synchronized (this.m)
    {
      t localt = this.k;
      if (localt == null)
      {
        bool = this.h.W();
        return bool;
      }
      boolean bool = localt.c();
      return bool;
    }
  }
  
  public final void d()
  {
    synchronized (this.m)
    {
      t localt = this.k;
      if (localt == null) {
        return;
      }
      localt.d();
    }
  }
  
  public final void e()
  {
    z.a("recordDownloadedImpression must be called on main UI thread.");
    synchronized (this.m)
    {
      this.d = true;
      t localt = this.k;
      if (localt == null) {
        return;
      }
      localt.e();
    }
  }
  
  public final void f()
  {
    this.g = true;
    t localt = this.k;
    if (localt != null) {
      localt.f();
    }
  }
  
  public final void g()
  {
    z.a("recordCustomClickGesture must be called on the main UI thread.");
    for (;;)
    {
      synchronized (this.m)
      {
        Object localObject2 = this.k;
        if (localObject2 != null) {
          break label80;
        }
        if (this.g)
        {
          if (b())
          {
            localObject2 = this.f;
            if (localObject2 != null) {
              e(((al)localObject2).c());
            }
            return;
          }
          com.google.android.gms.ads.internal.util.e.e("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
          return;
        }
      }
      com.google.android.gms.ads.internal.util.e.e("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
      return;
      label80:
      ((t)localObject3).g();
      this.h.e();
    }
  }
  
  public final boolean h()
  {
    synchronized (this.m)
    {
      boolean bool = this.l;
      return bool;
    }
  }
  
  public final t i()
  {
    synchronized (this.m)
    {
      t localt = this.k;
      return localt;
    }
  }
  
  public final i j()
  {
    return null;
  }
  
  public final void k() {}
  
  public final void l() {}
  
  public final void m()
  {
    t localt = this.k;
    if (localt != null) {
      localt.m();
    }
  }
  
  public final void n()
  {
    t localt = this.k;
    if (localt != null) {
      localt.n();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */