package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.formats.a.v;
import com.google.android.gms.ads.internal.util.n;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class i
  extends v
  implements w
{
  public com.google.android.gms.ads.internal.formats.a.e a;
  public a b;
  public String c;
  public String d;
  public t e;
  public Bundle f;
  public String g;
  public List h;
  public com.google.android.gms.ads.internal.j.a i;
  public String j;
  public String k;
  public double l;
  public String m;
  public bo n;
  public View o;
  private Object p = new Object();
  
  public i(String paramString1, List paramList, String paramString2, com.google.android.gms.ads.internal.formats.a.e parame, String paramString3, double paramDouble, String paramString4, String paramString5, a parama, Bundle paramBundle, bo parambo, View paramView, com.google.android.gms.ads.internal.j.a parama1, String paramString6)
  {
    this.g = paramString1;
    this.h = paramList;
    this.c = paramString2;
    this.a = parame;
    this.d = paramString3;
    this.l = paramDouble;
    this.m = paramString4;
    this.k = paramString5;
    this.b = parama;
    this.f = paramBundle;
    this.n = parambo;
    this.o = paramView;
    this.i = parama1;
    this.j = paramString6;
  }
  
  public final String a()
  {
    return this.g;
  }
  
  public final void a(Bundle paramBundle)
  {
    synchronized (this.p)
    {
      t localt = this.e;
      if (localt == null)
      {
        com.google.android.gms.ads.internal.util.e.c("#001 Attempt to perform click before app native ad initialized.");
        return;
      }
      localt.b(paramBundle);
      return;
    }
  }
  
  public final void a(t paramt)
  {
    synchronized (this.p)
    {
      this.e = paramt;
      return;
    }
  }
  
  public final String b()
  {
    return "2";
  }
  
  public final boolean b(Bundle paramBundle)
  {
    synchronized (this.p)
    {
      t localt = this.e;
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
    synchronized (this.p)
    {
      t localt = this.e;
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
    return this.b;
  }
  
  public final View e()
  {
    return this.o;
  }
  
  public final List f()
  {
    return this.h;
  }
  
  public final String g()
  {
    return this.c;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.e h()
  {
    return this.a;
  }
  
  public final String i()
  {
    return this.d;
  }
  
  public final double j()
  {
    return this.l;
  }
  
  public final String k()
  {
    return this.m;
  }
  
  public final String l()
  {
    return this.k;
  }
  
  public final bo m()
  {
    return this.n;
  }
  
  public final com.google.android.gms.ads.internal.j.a n()
  {
    return com.google.android.gms.dynamic.e.a(this.e);
  }
  
  public final Bundle o()
  {
    return this.f;
  }
  
  public final com.google.android.gms.ads.internal.j.a p()
  {
    return this.i;
  }
  
  public final String q()
  {
    return this.j;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.a r()
  {
    return this.b;
  }
  
  public final void s()
  {
    n.a.post(new j(this));
    this.g = null;
    this.h = null;
    this.c = null;
    this.a = null;
    this.d = null;
    this.l = 0.0D;
    this.m = null;
    this.k = null;
    this.b = null;
    this.f = null;
    this.p = null;
    this.n = null;
    this.o = null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */