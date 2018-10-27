package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.af;
import com.google.android.gms.ads.internal.client.al;
import com.google.android.gms.ads.internal.client.ay;
import com.google.android.gms.ads.internal.client.bc;
import com.google.android.gms.ads.internal.f.k;
import com.google.android.gms.ads.internal.formats.a.i;
import com.google.android.gms.ads.internal.formats.ag;
import com.google.android.gms.ads.internal.formats.ai;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.p;
import com.google.android.gms.ads.internal.overlay.v;
import com.google.android.gms.ads.internal.reward.client.f;
import com.google.android.gms.ads.internal.reward.d;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.e;
import java.util.HashMap;

@com.google.android.gms.ads.internal.q.a.a
@Keep
@DynamiteApi
public class ClientApi
  extends ay
{
  public af createAdLoaderBuilder(com.google.android.gms.ads.internal.j.a parama, String paramString, com.google.android.gms.ads.internal.mediation.client.b paramb, int paramInt)
  {
    parama = (Context)e.a(parama);
    com.google.android.gms.ads.internal.util.n localn = bt.A.e;
    return new aj(parama, paramString, paramb, new VersionInfoParcel(paramInt, com.google.android.gms.ads.internal.util.n.l(parama)), u.a(parama));
  }
  
  public com.google.android.gms.ads.internal.overlay.a.b createAdOverlay(com.google.android.gms.ads.internal.j.a parama)
  {
    parama = (Activity)e.a(parama);
    AdOverlayInfoParcel localAdOverlayInfoParcel = AdOverlayInfoParcel.a(parama.getIntent());
    if (localAdOverlayInfoParcel != null)
    {
      switch (localAdOverlayInfoParcel.n)
      {
      default: 
        return new com.google.android.gms.ads.internal.overlay.o(parama);
      case 4: 
        return new p(parama, localAdOverlayInfoParcel);
      case 3: 
        return new v(parama);
      case 2: 
        return new com.google.android.gms.ads.internal.overlay.u(parama);
      }
      return new com.google.android.gms.ads.internal.overlay.n(parama);
    }
    return new com.google.android.gms.ads.internal.overlay.o(parama);
  }
  
  public al createBannerAdManager(com.google.android.gms.ads.internal.j.a parama, AdSizeParcel paramAdSizeParcel, String paramString, com.google.android.gms.ads.internal.mediation.client.b paramb, int paramInt)
  {
    parama = (Context)e.a(parama);
    com.google.android.gms.ads.internal.util.n localn = bt.A.e;
    return new w(parama, paramAdSizeParcel, paramString, paramb, new VersionInfoParcel(paramInt, com.google.android.gms.ads.internal.util.n.l(parama)), u.a(parama));
  }
  
  public com.google.android.gms.ads.internal.p.a.c createInAppPurchaseManager(com.google.android.gms.ads.internal.j.a parama)
  {
    return null;
  }
  
  public al createInterstitialAdManager(com.google.android.gms.ads.internal.j.a parama, AdSizeParcel paramAdSizeParcel, String paramString, com.google.android.gms.ads.internal.mediation.client.b paramb, int paramInt)
  {
    parama = (Context)e.a(parama);
    com.google.android.gms.ads.internal.f.n.a(parama);
    Object localObject = bt.A.e;
    localObject = new VersionInfoParcel(paramInt, com.google.android.gms.ads.internal.util.n.l(parama));
    boolean bool = "reward_mb".equals(paramAdSizeParcel.a);
    com.google.android.gms.ads.internal.f.c localc;
    if (!bool)
    {
      localc = com.google.android.gms.ads.internal.f.n.aL;
      if (!((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a(localc)).booleanValue()) {}
    }
    for (;;)
    {
      return new ak(parama, paramAdSizeParcel, paramString, paramb, (VersionInfoParcel)localObject, u.a(parama));
      if (bool)
      {
        localc = com.google.android.gms.ads.internal.f.n.aM;
        ((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a(localc)).booleanValue();
      }
    }
  }
  
  public i createNativeAdViewDelegate(com.google.android.gms.ads.internal.j.a parama1, com.google.android.gms.ads.internal.j.a parama2)
  {
    return new ag((FrameLayout)e.a(parama1), (FrameLayout)e.a(parama2));
  }
  
  public com.google.android.gms.ads.internal.formats.a.o createNativeAdViewHolderDelegate(com.google.android.gms.ads.internal.j.a parama1, com.google.android.gms.ads.internal.j.a parama2, com.google.android.gms.ads.internal.j.a parama3)
  {
    return new ai((View)e.a(parama1), (HashMap)e.a(parama2), (HashMap)e.a(parama3));
  }
  
  public f createRewardedVideoAd(com.google.android.gms.ads.internal.j.a parama, com.google.android.gms.ads.internal.mediation.client.b paramb, int paramInt)
  {
    parama = (Context)e.a(parama);
    Object localObject = bt.A.e;
    localObject = new VersionInfoParcel(paramInt, com.google.android.gms.ads.internal.util.n.l(parama));
    return new d(parama, u.a(parama), paramb, (VersionInfoParcel)localObject);
  }
  
  public f createRewardedVideoAdSku(com.google.android.gms.ads.internal.j.a parama, int paramInt)
  {
    parama = (Context)e.a(parama);
    com.google.android.gms.ads.internal.f.n.a(parama);
    Object localObject = com.google.android.gms.ads.internal.f.n.aq;
    if (((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a((com.google.android.gms.ads.internal.f.c)localObject)).booleanValue())
    {
      localObject = bt.A.e;
      localObject = new VersionInfoParcel(paramInt, com.google.android.gms.ads.internal.util.n.l(parama));
      return new d(com.google.android.gms.ads.internal.reward.c.a(parama), u.a(parama), new ac(), (VersionInfoParcel)localObject);
    }
    return null;
  }
  
  public al createSearchAdManager(com.google.android.gms.ads.internal.j.a parama, AdSizeParcel paramAdSizeParcel, String paramString, int paramInt)
  {
    parama = (Context)e.a(parama);
    com.google.android.gms.ads.internal.util.n localn = bt.A.e;
    return new bn(parama, paramAdSizeParcel, paramString, new VersionInfoParcel(paramInt, com.google.android.gms.ads.internal.util.n.l(parama)));
  }
  
  public bc getMobileAdsSettingsManager(com.google.android.gms.ads.internal.j.a parama)
  {
    return null;
  }
  
  public bc getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.ads.internal.j.a parama, int paramInt)
  {
    parama = (Context)e.a(parama);
    com.google.android.gms.ads.internal.util.n localn = bt.A.e;
    return aw.a(parama, new VersionInfoParcel(paramInt, com.google.android.gms.ads.internal.util.n.l(parama)));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/ClientApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */