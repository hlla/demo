package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.f.i;
import com.google.android.gms.ads.internal.f.j;
import com.google.android.gms.ads.internal.f.k;
import com.google.android.gms.ads.internal.reward.client.s;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Random;

@com.google.android.gms.ads.internal.q.a.a
public final class u
{
  public static u h = new u();
  public final com.google.android.gms.ads.internal.util.client.a a;
  public final m b;
  public final i c;
  public final j d;
  public final k e;
  public final VersionInfoParcel f;
  public final Random g;
  public final String i;
  
  protected u()
  {
    this(locala, new m(localf, locale, localcb, locals, locala1), new i(), new j(), new k(), com.google.android.gms.ads.internal.util.client.a.c(), new VersionInfoParcel(0, 12451000, true), new Random());
  }
  
  private u(com.google.android.gms.ads.internal.util.client.a parama, m paramm, i parami, j paramj, k paramk, String paramString, VersionInfoParcel paramVersionInfoParcel, Random paramRandom)
  {
    this.a = parama;
    this.b = paramm;
    this.c = parami;
    this.d = paramj;
    this.e = paramk;
    this.i = paramString;
    this.f = paramVersionInfoParcel;
    this.g = paramRandom;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */