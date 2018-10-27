package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.ads.internal.client.bo;
import com.google.android.gms.ads.internal.formats.a.z;
import com.google.android.gms.ads.internal.util.n;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class k
  extends z
  implements w
{
  public String a;
  public a b;
  public String c;
  public String d;
  public t e;
  public Bundle f;
  public String g;
  public List h;
  public com.google.android.gms.ads.internal.j.a i;
  public String j;
  public com.google.android.gms.ads.internal.formats.a.e k;
  public bo l;
  public View m;
  private Object n = new Object();
  
  public k(String paramString1, List paramList, String paramString2, com.google.android.gms.ads.internal.formats.a.e parame, String paramString3, String paramString4, a parama, Bundle paramBundle, bo parambo, View paramView, com.google.android.gms.ads.internal.j.a parama1, String paramString5)
  {
    this.g = paramString1;
    this.h = paramList;
    this.c = paramString2;
    this.k = parame;
    this.d = paramString3;
    this.a = paramString4;
    this.b = parama;
    this.f = paramBundle;
    this.l = parambo;
    this.m = paramView;
    this.i = parama1;
    this.j = paramString5;
  }
  
  public final String a()
  {
    return this.g;
  }
  
  public final void a(Bundle paramBundle)
  {
    synchronized (this.n)
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
    synchronized (this.n)
    {
      this.e = paramt;
      return;
    }
  }
  
  public final String b()
  {
    return "1";
  }
  
  public final boolean b(Bundle paramBundle)
  {
    synchronized (this.n)
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
    synchronized (this.n)
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
    return this.m;
  }
  
  public final List f()
  {
    return this.h;
  }
  
  public final com.google.android.gms.ads.internal.j.a g()
  {
    return this.i;
  }
  
  public final String h()
  {
    return this.j;
  }
  
  public final String i()
  {
    return this.c;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.e j()
  {
    return this.k;
  }
  
  public final String k()
  {
    return this.d;
  }
  
  public final String l()
  {
    return this.a;
  }
  
  public final bo m()
  {
    return this.l;
  }
  
  public final com.google.android.gms.ads.internal.j.a n()
  {
    return com.google.android.gms.dynamic.e.a(this.e);
  }
  
  public final Bundle o()
  {
    return this.f;
  }
  
  public final com.google.android.gms.ads.internal.formats.a.a p()
  {
    return this.b;
  }
  
  public final void q()
  {
    n.a.post(new l(this));
    this.g = null;
    this.h = null;
    this.c = null;
    this.k = null;
    this.d = null;
    this.a = null;
    this.b = null;
    this.f = null;
    this.n = null;
    this.l = null;
    this.m = null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */