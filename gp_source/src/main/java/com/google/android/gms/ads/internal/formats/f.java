package com.google.android.gms.ads.internal.formats;

import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.instream.a.b;
import com.google.android.gms.ads.internal.instream.a.c;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.common.internal.z;
import java.util.Collections;

@com.google.android.gms.ads.internal.q.a.a
public final class f
  extends b
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, e, v
{
  private t a;
  private boolean b;
  private boolean c;
  private i d;
  
  public f(i parami)
  {
    this.d = parami;
    this.b = false;
    this.c = false;
  }
  
  private static void a(c paramc, int paramInt)
  {
    try
    {
      paramc.a(paramInt);
      return;
    }
    catch (RemoteException paramc)
    {
      com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", paramc);
    }
  }
  
  private final void h()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((i)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView((View)this.d);
      }
    }
  }
  
  private final void i()
  {
    t localt = this.a;
    if (localt != null)
    {
      i locali = this.d;
      if (locali != null) {
        localt.b(locali.getView(), Collections.emptyMap());
      }
    }
  }
  
  public final void a()
  {
    n.a.post(new g(this));
  }
  
  public final void a(t paramt)
  {
    this.a = paramt;
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, c paramc)
  {
    z.a("#008 Must be called on the main UI thread.");
    if (this.b)
    {
      com.google.android.gms.ads.internal.util.e.c("Instream ad is destroyed already.");
      a(paramc, 2);
      return;
    }
    if (this.d.getVideoController() == null)
    {
      com.google.android.gms.ads.internal.util.e.c("Instream internal error: can not get video controller.");
      a(paramc, 0);
      return;
    }
    if (this.c)
    {
      com.google.android.gms.ads.internal.util.e.c("Instream ad should not be used again.");
      a(paramc, 1);
      return;
    }
    this.c = true;
    h();
    ((ViewGroup)com.google.android.gms.dynamic.e.a(parama)).addView(this.d.getView(), new ViewGroup.LayoutParams(-1, -1));
    parama = bt.A.E;
    com.google.android.gms.ads.internal.util.d.a.a(this.d.getView(), this);
    parama = bt.A.E;
    com.google.android.gms.ads.internal.util.d.a.a(this.d.getView(), this);
    i();
    try
    {
      paramc.a();
      return;
    }
    catch (RemoteException parama)
    {
      com.google.android.gms.ads.internal.util.e.f("#007 Could not call remote method.", parama);
    }
  }
  
  public final String b()
  {
    return "";
  }
  
  public final String c()
  {
    return "";
  }
  
  public final a d()
  {
    return null;
  }
  
  public final View e()
  {
    i locali = this.d;
    if (locali != null) {
      return locali.getView();
    }
    return null;
  }
  
  public final bo f()
  {
    z.a("#008 Must be called on the main UI thread.");
    if (this.b) {
      com.google.android.gms.ads.internal.util.e.c("Instream ad is destroyed already.");
    }
    i locali;
    do
    {
      return null;
      locali = this.d;
    } while (locali == null);
    return locali.getVideoController();
  }
  
  public final void g()
  {
    z.a("#008 Must be called on the main UI thread.");
    if (!this.b)
    {
      h();
      t localt = this.a;
      if (localt != null)
      {
        localt.l();
        this.a.k();
      }
      this.a = null;
      this.d = null;
      this.b = true;
    }
  }
  
  public final void onGlobalLayout()
  {
    i();
  }
  
  public final void onScrollChanged()
  {
    i();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */