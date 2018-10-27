package com.google.android.gms.ads.internal.mediation.client;

import android.location.Location;
import java.util.Date;
import java.util.Set;

@com.google.android.gms.ads.internal.q.a.a
public final class x
  implements com.google.android.gms.ads.mediation.a
{
  private final Date a;
  private final int b;
  private final boolean c;
  private final boolean d;
  private final Set e;
  private final Location f;
  private final int g;
  
  public x(Date paramDate, int paramInt1, Set paramSet, Location paramLocation, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    this.a = paramDate;
    this.b = paramInt1;
    this.e = paramSet;
    this.f = paramLocation;
    this.d = paramBoolean1;
    this.g = paramInt2;
    this.c = paramBoolean2;
  }
  
  @Deprecated
  public final Date a()
  {
    return this.a;
  }
  
  @Deprecated
  public final int b()
  {
    return this.b;
  }
  
  public final Set c()
  {
    return this.e;
  }
  
  public final Location d()
  {
    return this.f;
  }
  
  public final boolean e()
  {
    return this.d;
  }
  
  public final int f()
  {
    return this.g;
  }
  
  @Deprecated
  public final boolean g()
  {
    return this.c;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */