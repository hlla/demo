package com.google.android.gms.ads.internal.reward.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.b;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class h
  extends b
{
  public volatile f a;
  public volatile i b;
  public volatile m c;
  private volatile g d;
  
  public h(g paramg)
  {
    this.d = paramg;
  }
  
  public final void a(Bundle paramBundle)
  {
    if (this.c != null) {
      this.c.a(paramBundle);
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama)
  {
    if (this.a != null) {
      this.a.f();
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, int paramInt)
  {
    if (this.a != null) {
      this.a.g();
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, RewardItemParcel paramRewardItemParcel)
  {
    if (this.d != null) {
      this.d.a_(paramRewardItemParcel);
    }
  }
  
  public final void b(com.google.android.gms.ads.internal.j.a parama)
  {
    if (this.b != null) {
      this.b.a(e.a(parama).getClass().getName());
    }
  }
  
  public final void b(com.google.android.gms.ads.internal.j.a parama, int paramInt)
  {
    if (this.b != null)
    {
      i locali = this.b;
      e.a(parama).getClass().getName();
      locali.a(paramInt);
    }
  }
  
  public final void c(com.google.android.gms.ads.internal.j.a parama)
  {
    if (this.d != null) {
      this.d.bg_();
    }
  }
  
  public final void d(com.google.android.gms.ads.internal.j.a parama)
  {
    if (this.d != null) {
      this.d.bh_();
    }
  }
  
  public final void e(com.google.android.gms.ads.internal.j.a parama)
  {
    if (this.d != null) {
      this.d.bj_();
    }
  }
  
  public final void f(com.google.android.gms.ads.internal.j.a parama)
  {
    if (this.d != null) {
      this.d.bk_();
    }
  }
  
  public final void g(com.google.android.gms.ads.internal.j.a parama)
  {
    if (this.d != null) {
      this.d.bl_();
    }
  }
  
  public final void h(com.google.android.gms.ads.internal.j.a parama)
  {
    if (this.d != null) {
      this.d.bi_();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/mediation/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */