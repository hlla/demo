package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.formats.a.ad;
import com.google.android.gms.ads.internal.util.client.k;
import java.util.Arrays;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class m
  extends ad
  implements v
{
  public final String a;
  public t b;
  private final a c;
  private final android.support.v4.g.v d;
  private final Object e = new Object();
  private final android.support.v4.g.v f;
  private bo g;
  private View h;
  
  public m(String paramString, android.support.v4.g.v paramv1, android.support.v4.g.v paramv2, a parama, bo parambo, View paramView)
  {
    this.a = paramString;
    this.d = paramv1;
    this.f = paramv2;
    this.c = parama;
    this.g = parambo;
    this.h = paramView;
  }
  
  public final String a(String paramString)
  {
    return (String)this.f.get(paramString);
  }
  
  public final List a()
  {
    int n = 0;
    String[] arrayOfString = new String[this.d.size() + this.f.size()];
    int j = 0;
    int i = 0;
    int k;
    int m;
    for (;;)
    {
      k = n;
      m = i;
      if (j >= this.d.size()) {
        break;
      }
      arrayOfString[i] = ((String)this.d.b(j));
      i += 1;
      j += 1;
    }
    while (k < this.f.size())
    {
      arrayOfString[m] = ((String)this.f.b(k));
      k += 1;
      m += 1;
    }
    return Arrays.asList(arrayOfString);
  }
  
  public final void a(t paramt)
  {
    synchronized (this.e)
    {
      this.b = paramt;
      return;
    }
  }
  
  public final boolean a(com.google.android.gms.ads.internal.j.a parama)
  {
    if (this.b == null) {
      k.c("Attempt to call renderVideoInMediaView before ad initialized.");
    }
    while (this.h == null) {
      return false;
    }
    n localn = new n(this);
    parama = (FrameLayout)com.google.android.gms.dynamic.e.a(parama);
    this.b.a(parama, localn);
    return true;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.e b(String paramString)
  {
    return (com.google.android.gms.ads.internal.formats.a.e)this.d.get(paramString);
  }
  
  public final String b()
  {
    return "3";
  }
  
  public final String c()
  {
    return this.a;
  }
  
  public final void c(String paramString)
  {
    synchronized (this.e)
    {
      t localt = this.b;
      if (localt == null)
      {
        k.c("#001 Attempt to perform click before app native ad initialized.");
        return;
      }
      localt.a(null, paramString, null, null, null, false);
      return;
    }
  }
  
  public final a d()
  {
    return this.c;
  }
  
  public final View e()
  {
    return this.h;
  }
  
  public final com.google.android.gms.ads.internal.j.a f()
  {
    return com.google.android.gms.dynamic.e.a(this.b);
  }
  
  public final bo g()
  {
    return this.g;
  }
  
  public final void h()
  {
    synchronized (this.e)
    {
      t localt = this.b;
      if (localt == null)
      {
        k.c("#002 Attempt to record impression before native ad initialized.");
        return;
      }
      localt.a(null, null);
      return;
    }
  }
  
  public final com.google.android.gms.ads.internal.j.a i()
  {
    return com.google.android.gms.dynamic.e.a(this.b.p().getApplicationContext());
  }
  
  public final void j()
  {
    com.google.android.gms.ads.internal.util.n.a.post(new o(this));
    this.g = null;
    this.h = null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */