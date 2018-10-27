package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@a
public final class bv
{
  public final Date a;
  public final Set b;
  public final Bundle c;
  public final int d;
  public final boolean e;
  public final Set f;
  public final Location g;
  public final Map h;
  public final Bundle i;
  public final int j;
  public final Set k;
  public final int l;
  
  public bv(bw parambw)
  {
    this(parambw, (byte)0);
  }
  
  private bv(bw parambw, byte paramByte)
  {
    this.a = parambw.c;
    this.d = parambw.e;
    this.f = Collections.unmodifiableSet(parambw.b);
    this.g = parambw.g;
    this.i = parambw.i;
    this.h = Collections.unmodifiableMap(parambw.h);
    this.j = parambw.j;
    this.k = Collections.unmodifiableSet(parambw.l);
    this.c = parambw.d;
    this.b = Collections.unmodifiableSet(parambw.a);
    this.e = parambw.f;
    this.l = parambw.k;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */