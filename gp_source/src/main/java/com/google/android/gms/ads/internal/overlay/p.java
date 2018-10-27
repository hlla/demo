package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.overlay.a.c;

@com.google.android.gms.ads.internal.q.a.a
public final class p
  extends c
{
  private Activity a;
  private boolean b = false;
  private boolean c = false;
  private AdOverlayInfoParcel d;
  
  public p(Activity paramActivity, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    this.d = paramAdOverlayInfoParcel;
    this.a = paramActivity;
  }
  
  private final void a()
  {
    try
    {
      if (!this.b)
      {
        k localk = this.d.d;
        if (localk != null) {
          localk.B();
        }
        this.b = true;
      }
      return;
    }
    finally {}
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void a(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    AdOverlayInfoParcel localAdOverlayInfoParcel = this.d;
    if (localAdOverlayInfoParcel == null)
    {
      this.a.finish();
      return;
    }
    if (bool)
    {
      this.a.finish();
      return;
    }
    if (paramBundle != null) {}
    for (;;)
    {
      paramBundle = bt.A.a;
      paramBundle = this.a;
      localAdOverlayInfoParcel = this.d;
      if (a.a(paramBundle, localAdOverlayInfoParcel.b, localAdOverlayInfoParcel.l)) {
        break;
      }
      this.a.finish();
      return;
      paramBundle = localAdOverlayInfoParcel.a;
      if (paramBundle != null) {
        paramBundle.e();
      }
      if ((this.a.getIntent() != null) && (this.a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true)))
      {
        paramBundle = this.d.d;
        if (paramBundle != null) {
          paramBundle.C();
        }
      }
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama) {}
  
  public final void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.c);
  }
  
  public final void d() {}
  
  public final boolean e()
  {
    return false;
  }
  
  public final void f() {}
  
  public final void g() {}
  
  public final void h()
  {
    if (this.c) {
      this.a.finish();
    }
    k localk;
    do
    {
      return;
      this.c = true;
      localk = this.d.d;
    } while (localk == null);
    localk.E();
  }
  
  public final void i()
  {
    k localk = this.d.d;
    if (localk != null) {
      localk.D();
    }
    if (this.a.isFinishing()) {
      a();
    }
  }
  
  public final void j()
  {
    if (this.a.isFinishing()) {
      a();
    }
  }
  
  public final void k()
  {
    if (this.a.isFinishing()) {
      a();
    }
  }
  
  public final void l() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */