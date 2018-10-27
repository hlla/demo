package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.bd;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.f.k;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.mediation.client.b;
import com.google.android.gms.ads.internal.util.af;
import com.google.android.gms.ads.internal.util.ah;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.v.f;

@com.google.android.gms.ads.internal.q.a.a
public final class aw
  extends bd
{
  private static aw d;
  private static final Object e = new Object();
  public final Context a;
  private boolean b;
  private VersionInfoParcel c;
  
  private aw(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    new Object();
    this.a = paramContext;
    this.c = paramVersionInfoParcel;
    this.b = false;
  }
  
  public static aw a(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    synchronized (e)
    {
      if (d != null)
      {
        paramContext = d;
        return paramContext;
      }
      d = new aw(paramContext.getApplicationContext(), paramVersionInfoParcel);
    }
  }
  
  public final void a()
  {
    synchronized (e)
    {
      if (!this.b)
      {
        this.b = true;
        n.a(this.a);
        bt.A.i.a(this.a, this.c);
        bt.A.k.a(this.a);
        return;
      }
      com.google.android.gms.ads.internal.util.e.e("Mobile ads is initialized already.");
      return;
    }
  }
  
  public final void a(float paramFloat)
  {
    bt.A.j.a(paramFloat);
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, String paramString)
  {
    if (parama != null)
    {
      parama = (Context)com.google.android.gms.dynamic.e.a(parama);
      if (parama == null)
      {
        com.google.android.gms.ads.internal.util.e.c("Context is null. Failed to open debug menu.");
        return;
      }
      parama = new ah(parama);
      parama.a = paramString;
      parama.b = this.c.a;
      parama.a();
      return;
    }
    com.google.android.gms.ads.internal.util.e.c("Wrapped context is null. Failed to open debug menu.");
  }
  
  public final void a(b paramb) {}
  
  public final void a(String paramString)
  {
    n.a(this.a);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = n.av;
      if (((Boolean)u.h.e.a(paramString)).booleanValue()) {
        paramString = bt.A.m;
      }
    }
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.j.a parama)
  {
    boolean bool1;
    boolean bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      n.a(this.a);
      paramString = n.av;
      bool1 = ((Boolean)u.h.e.a(paramString)).booleanValue();
      paramString = n.bw;
      bool2 = ((Boolean)u.h.e.a(paramString)).booleanValue();
      paramString = n.bw;
      if (!((Boolean)u.h.e.a(paramString)).booleanValue()) {
        break label104;
      }
      new ax(this, (Runnable)com.google.android.gms.dynamic.e.a(parama));
    }
    for (;;)
    {
      paramString = bt.A.m;
      label104:
      do
      {
        return;
      } while (!(bool1 | bool2));
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    bt.A.j.a(paramBoolean);
  }
  
  public final float b()
  {
    return bt.A.j.a();
  }
  
  public final void b(String paramString) {}
  
  public final boolean c()
  {
    return bt.A.j.b();
  }
  
  public final String d()
  {
    return this.c.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */