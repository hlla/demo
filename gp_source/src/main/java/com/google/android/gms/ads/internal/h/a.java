package com.google.android.gms.ads.internal.h;

import android.view.View;
import com.google.android.gms.ads.internal.ae;
import com.google.android.gms.ads.internal.h.a.c;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends c
{
  private final String a;
  private final String b;
  private final ae c;
  
  public a(ae paramae, String paramString1, String paramString2)
  {
    this.c = paramae;
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama)
  {
    if (parama != null) {
      this.c.b((View)e.a(parama));
    }
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final void c()
  {
    this.c.S();
  }
  
  public final void d()
  {
    this.c.T();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */