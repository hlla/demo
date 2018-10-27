package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.g.v;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ac;
import com.google.android.gms.ads.internal.client.ba;
import com.google.android.gms.ads.internal.client.z;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.a.am;
import com.google.android.gms.ads.internal.formats.a.ap;
import com.google.android.gms.ads.internal.formats.a.as;
import com.google.android.gms.ads.internal.formats.a.au;
import com.google.android.gms.ads.internal.instream.InstreamAdConfigurationParcel;
import com.google.android.gms.ads.internal.instream.a.e;
import com.google.android.gms.ads.internal.mediation.client.b;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@a
public final class aj
  extends com.google.android.gms.ads.internal.client.ag
{
  private z a;
  private final String b;
  private final b c;
  private AdSizeParcel d;
  private final Context e;
  private ba f;
  private final u g;
  private InstreamAdConfigurationParcel h;
  private e i;
  private NativeAdOptionsParcel j;
  private com.google.android.gms.ads.internal.formats.a.ag k;
  private com.google.android.gms.ads.internal.formats.a.aj l;
  private v m;
  private v n;
  private as o;
  private au p;
  private PublisherAdViewOptions q;
  private final VersionInfoParcel r;
  
  public aj(Context paramContext, String paramString, b paramb, VersionInfoParcel paramVersionInfoParcel, u paramu)
  {
    this.e = paramContext;
    this.b = paramString;
    this.c = paramb;
    this.r = paramVersionInfoParcel;
    this.n = new v();
    this.m = new v();
    this.g = paramu;
  }
  
  public final ac a()
  {
    return new ag(this.e, this.b, this.c, this.r, this.a, this.k, this.p, this.i, this.l, this.n, this.m, this.j, this.h, this.f, this.g, this.o, this.d, this.q);
  }
  
  public final void a(PublisherAdViewOptions paramPublisherAdViewOptions)
  {
    this.q = paramPublisherAdViewOptions;
  }
  
  public final void a(ba paramba)
  {
    this.f = paramba;
  }
  
  public final void a(z paramz)
  {
    this.a = paramz;
  }
  
  public final void a(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    this.j = paramNativeAdOptionsParcel;
  }
  
  public final void a(com.google.android.gms.ads.internal.formats.a.ag paramag)
  {
    this.k = paramag;
  }
  
  public final void a(com.google.android.gms.ads.internal.formats.a.aj paramaj)
  {
    this.l = paramaj;
  }
  
  public final void a(as paramas, AdSizeParcel paramAdSizeParcel)
  {
    this.o = paramas;
    this.d = paramAdSizeParcel;
  }
  
  public final void a(au paramau)
  {
    this.p = paramau;
  }
  
  public final void a(InstreamAdConfigurationParcel paramInstreamAdConfigurationParcel)
  {
    this.h = paramInstreamAdConfigurationParcel;
  }
  
  public final void a(e parame)
  {
    this.i = parame;
  }
  
  public final void a(String paramString, ap paramap, am paramam)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
    }
    this.n.put(paramString, paramap);
    this.m.put(paramString, paramam);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */