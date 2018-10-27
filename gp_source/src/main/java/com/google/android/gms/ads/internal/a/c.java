package com.google.android.gms.ads.internal.a;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.js.y;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.webview.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@com.google.android.gms.ads.internal.q.a.a
public final class c
  implements k
{
  public final WeakHashMap a = new WeakHashMap();
  public final Object b = new Object();
  private final ArrayList c = new ArrayList();
  private final Context d;
  private final y e;
  private final VersionInfoParcel f;
  
  public c(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    this.d = paramContext.getApplicationContext();
    this.f = paramVersionInfoParcel;
    paramContext = paramContext.getApplicationContext();
    com.google.android.gms.ads.internal.f.c localc = n.bE;
    this.e = new y(paramContext, paramVersionInfoParcel, (String)u.h.e.a(localc));
  }
  
  private final boolean d(com.google.android.gms.ads.internal.v.a parama)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        parama = (d)this.a.get(parama);
        if (parama == null) {
          break label46;
        }
        if (parama.c())
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label46:
      bool = false;
    }
  }
  
  public final void a(d paramd)
  {
    synchronized (this.b)
    {
      if (!paramd.c())
      {
        this.c.remove(paramd);
        Iterator localIterator = this.a.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((Map.Entry)localIterator.next()).getValue() == paramd) {
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public final void a(AdSizeParcel paramAdSizeParcel, com.google.android.gms.ads.internal.v.a parama)
  {
    a(paramAdSizeParcel, parama, parama.g.getView());
  }
  
  public final void a(AdSizeParcel paramAdSizeParcel, com.google.android.gms.ads.internal.v.a parama, View paramView)
  {
    a(paramAdSizeParcel, parama, new j(paramView, parama), null);
  }
  
  public final void a(AdSizeParcel paramAdSizeParcel, com.google.android.gms.ads.internal.v.a parama, View paramView, i parami)
  {
    a(paramAdSizeParcel, parama, new j(paramView, parama), parami);
  }
  
  public final void a(AdSizeParcel paramAdSizeParcel, com.google.android.gms.ads.internal.v.a parama, an arg3, i parami)
  {
    synchronized (this.b)
    {
      if (!d(parama)) {
        paramAdSizeParcel = new d(this.d, paramAdSizeParcel, parama, this.f, ???);
      }
    }
    synchronized (paramAdSizeParcel.e)
    {
      paramAdSizeParcel.b = this;
      this.a.put(parama, paramAdSizeParcel);
      this.c.add(paramAdSizeParcel);
      if (parami == null) {
        paramAdSizeParcel.b(new p(paramAdSizeParcel, this.e, this.d));
      }
      for (;;)
      {
        return;
        paramAdSizeParcel.b(new l(paramAdSizeParcel, parami));
      }
      paramAdSizeParcel = finally;
      throw paramAdSizeParcel;
      paramAdSizeParcel = (d)this.a.get(parama);
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.v.a parama)
  {
    synchronized (this.b)
    {
      parama = (d)this.a.get(parama);
      if (parama == null) {
        return;
      }
      parama.b();
    }
  }
  
  public final void b(com.google.android.gms.ads.internal.v.a arg1)
  {
    d locald;
    synchronized (this.b)
    {
      locald = (d)this.a.get(???);
      if (locald == null) {}
    }
    synchronized (locald.e)
    {
      locald.c = true;
      locald.a(3);
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public final void c(com.google.android.gms.ads.internal.v.a arg1)
  {
    d locald;
    synchronized (this.b)
    {
      locald = (d)this.a.get(???);
      if (locald == null) {}
    }
    synchronized (locald.e)
    {
      locald.c = false;
      locald.a(3);
      return;
      ??? = finally;
      throw ???;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */