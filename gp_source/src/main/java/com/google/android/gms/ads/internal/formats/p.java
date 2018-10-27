package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.ads.internal.client.bi;
import com.google.android.gms.ads.internal.client.bk;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.formats.a.ax;
import com.google.android.gms.ads.internal.formats.a.ba;
import com.google.android.gms.ads.internal.util.n;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class p
  extends ba
  implements w
{
  public t a;
  private String b;
  private com.google.android.gms.ads.internal.formats.a.e c;
  private a d;
  private String e;
  private String f;
  private Bundle g;
  private String h;
  private List i;
  private final Object j = new Object();
  private com.google.android.gms.ads.internal.j.a k;
  private String l;
  private String m;
  private double n;
  private String o;
  private bo p;
  private View q;
  
  public p(String paramString1, List paramList, String paramString2, com.google.android.gms.ads.internal.formats.a.e parame, String paramString3, String paramString4, double paramDouble, String paramString5, String paramString6, a parama, bo parambo, View paramView, com.google.android.gms.ads.internal.j.a parama1, String paramString7, Bundle paramBundle)
  {
    this.h = paramString1;
    this.i = paramList;
    this.e = paramString2;
    this.c = parame;
    this.f = paramString3;
    this.b = paramString4;
    this.n = paramDouble;
    this.o = paramString5;
    this.m = paramString6;
    this.d = parama;
    this.p = parambo;
    this.q = paramView;
    this.k = parama1;
    this.l = paramString7;
    this.g = paramBundle;
  }
  
  public final String a()
  {
    return this.h;
  }
  
  public final void a(Bundle paramBundle)
  {
    synchronized (this.j)
    {
      t localt = this.a;
      if (localt == null)
      {
        com.google.android.gms.ads.internal.util.e.c("#001 Attempt to perform click before app native ad initialized.");
        return;
      }
      localt.b(paramBundle);
      return;
    }
  }
  
  public final void a(bi parambi) {}
  
  public final void a(bk parambk) {}
  
  public final void a(ax paramax)
  {
    this.a.a(paramax);
  }
  
  public final void a(t paramt)
  {
    synchronized (this.j)
    {
      this.a = paramt;
      return;
    }
  }
  
  public final String b()
  {
    return "6";
  }
  
  public final boolean b(Bundle paramBundle)
  {
    synchronized (this.j)
    {
      t localt = this.a;
      if (localt == null)
      {
        com.google.android.gms.ads.internal.util.e.c("#002 Attempt to record impression before native ad initialized.");
        return false;
      }
      boolean bool = localt.a(paramBundle);
      return bool;
    }
  }
  
  public final String c()
  {
    return "";
  }
  
  public final void c(Bundle paramBundle)
  {
    synchronized (this.j)
    {
      t localt = this.a;
      if (localt == null)
      {
        com.google.android.gms.ads.internal.util.e.c("#003 Attempt to report touch event before native ad initialized.");
        return;
      }
      localt.c(paramBundle);
      return;
    }
  }
  
  public final a d()
  {
    return this.d;
  }
  
  public final View e()
  {
    return this.q;
  }
  
  public final List f()
  {
    return this.i;
  }
  
  public final List g()
  {
    return null;
  }
  
  public final boolean h()
  {
    return false;
  }
  
  public final String i()
  {
    return this.e;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.e j()
  {
    return this.c;
  }
  
  public final String k()
  {
    return this.f;
  }
  
  public final String l()
  {
    return this.b;
  }
  
  public final double m()
  {
    return this.n;
  }
  
  public final String n()
  {
    return this.o;
  }
  
  public final String o()
  {
    return this.m;
  }
  
  public final bo p()
  {
    return this.p;
  }
  
  public final com.google.android.gms.ads.internal.j.a q()
  {
    return com.google.android.gms.dynamic.e.a(this.a);
  }
  
  public final com.google.android.gms.ads.internal.j.a r()
  {
    return this.k;
  }
  
  public final String s()
  {
    return this.l;
  }
  
  public final Bundle t()
  {
    return this.g;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.a u()
  {
    return this.d;
  }
  
  public final void v()
  {
    n.a.post(new q(this));
  }
  
  public final void w()
  {
    synchronized (this.j)
    {
      t localt = this.a;
      if (localt == null) {
        return;
      }
      localt.f();
      return;
    }
  }
  
  public final void x()
  {
    synchronized (this.j)
    {
      t localt = this.a;
      if (localt == null) {
        return;
      }
      localt.g();
      return;
    }
  }
  
  public final void y()
  {
    this.a.d();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */