package com.google.android.gms.ads.internal.v;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.d.h;
import com.google.android.gms.ads.internal.mediation.c;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.bp;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class b
{
  public final JSONObject a;
  public final long b;
  public final com.google.android.gms.ads.internal.d.a c;
  public final AdRequestInfoParcel d;
  public final AdResponseParcel e;
  public final long f;
  public final AdSizeParcel g;
  public final int h;
  public final c i;
  public final boolean j;
  
  public b(AdRequestInfoParcel paramAdRequestInfoParcel, AdResponseParcel paramAdResponseParcel, int paramInt, long paramLong1, long paramLong2, h paramh)
  {
    this.d = paramAdRequestInfoParcel;
    this.e = paramAdResponseParcel;
    this.i = null;
    this.g = null;
    this.h = paramInt;
    this.f = paramLong1;
    this.b = paramLong2;
    this.a = null;
    this.c = new com.google.android.gms.ads.internal.d.a(paramh);
    this.j = false;
  }
  
  public b(AdRequestInfoParcel paramAdRequestInfoParcel, AdResponseParcel paramAdResponseParcel, c paramc, AdSizeParcel paramAdSizeParcel, int paramInt, long paramLong1, long paramLong2, JSONObject paramJSONObject, com.google.android.gms.ads.internal.d.a parama, Boolean paramBoolean)
  {
    this.d = paramAdRequestInfoParcel;
    this.e = paramAdResponseParcel;
    this.i = paramc;
    this.g = paramAdSizeParcel;
    this.h = paramInt;
    this.f = paramLong1;
    this.b = paramLong2;
    this.a = paramJSONObject;
    this.c = parama;
    if (paramBoolean != null)
    {
      this.j = paramBoolean.booleanValue();
      return;
    }
    this.j = bp.b(paramAdRequestInfoParcel.b.n);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/v/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */