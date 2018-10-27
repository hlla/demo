package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.ArrayList;
import java.util.List;

@a
public final class h
{
  public Location a;
  private AdDataParcel b;
  private long c;
  private List d;
  private String e;
  private Bundle f;
  private Bundle g;
  private int h;
  private boolean i;
  private boolean j;
  private List k;
  private boolean l;
  private Bundle m;
  private String n;
  private String o;
  private String p;
  private SearchAdRequestParcel q;
  private int r;
  private String s;
  private int t;
  
  public h()
  {
    this.c = -1L;
    this.g = new Bundle();
    this.h = -1;
    this.k = new ArrayList();
    this.j = false;
    this.r = -1;
    this.l = false;
    this.n = null;
    this.q = null;
    this.a = null;
    this.e = null;
    this.m = new Bundle();
    this.f = new Bundle();
    this.d = new ArrayList();
    this.o = null;
    this.p = null;
    this.i = false;
    this.t = -1;
    this.s = null;
  }
  
  public h(AdRequestParcel paramAdRequestParcel)
  {
    this.c = paramAdRequestParcel.b;
    this.g = paramAdRequestParcel.f;
    this.h = paramAdRequestParcel.g;
    this.k = paramAdRequestParcel.j;
    this.j = paramAdRequestParcel.i;
    this.r = paramAdRequestParcel.s;
    this.l = paramAdRequestParcel.l;
    this.n = paramAdRequestParcel.o;
    this.q = paramAdRequestParcel.r;
    this.a = paramAdRequestParcel.k;
    this.e = paramAdRequestParcel.d;
    this.m = paramAdRequestParcel.n;
    this.f = paramAdRequestParcel.e;
    this.d = paramAdRequestParcel.c;
    this.o = paramAdRequestParcel.p;
    this.p = paramAdRequestParcel.q;
    this.i = paramAdRequestParcel.h;
    this.b = paramAdRequestParcel.a;
    this.t = paramAdRequestParcel.t;
    this.s = paramAdRequestParcel.m;
  }
  
  public final AdRequestParcel a()
  {
    return new AdRequestParcel(8, this.c, this.g, this.h, this.k, this.j, this.r, this.l, this.n, this.q, this.a, this.e, this.m, this.f, this.d, this.o, this.p, this.i, this.b, this.t, this.s);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */