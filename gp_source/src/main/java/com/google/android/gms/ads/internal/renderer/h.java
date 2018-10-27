package com.google.android.gms.ads.internal.renderer;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.v.b;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class h
  extends com.google.android.gms.ads.internal.util.a
{
  public final f a;
  private final AdResponseParcel b;
  private final b c;
  
  public h(b paramb, f paramf)
  {
    this.c = paramb;
    this.b = this.c.e;
    this.a = paramf;
  }
  
  public final void a()
  {
    Object localObject2 = this.c;
    Object localObject3 = ((b)localObject2).d;
    Object localObject1 = ((AdRequestInfoParcel)localObject3).b;
    Object localObject4 = this.b;
    int i = ((AdResponseParcel)localObject4).K;
    long l1 = ((AdResponseParcel)localObject4).M;
    localObject3 = ((AdRequestInfoParcel)localObject3).X;
    long l2 = ((AdResponseParcel)localObject4).G;
    AdSizeParcel localAdSizeParcel = ((b)localObject2).g;
    l2 = ((AdResponseParcel)localObject4).r;
    l2 = ((b)localObject2).f;
    long l3 = ((AdResponseParcel)localObject4).o;
    localObject4 = ((AdResponseParcel)localObject4).k;
    JSONObject localJSONObject = ((b)localObject2).a;
    AdResponseParcel localAdResponseParcel = ((b)localObject2).e;
    boolean bool1 = localAdResponseParcel.E;
    Object localObject5 = localAdResponseParcel.d;
    localObject5 = ((b)localObject2).c;
    boolean bool2 = localAdResponseParcel.u;
    boolean bool3 = ((b)localObject2).j;
    boolean bool4 = localAdResponseParcel.C;
    boolean bool5 = localAdResponseParcel.t;
    localObject2 = localAdResponseParcel.J;
    localObject1 = new com.google.android.gms.ads.internal.v.a((AdRequestParcel)localObject1, null, null, 0, null, null, i, l1, (String)localObject3, false, null, null, null, null, null, localAdSizeParcel, l2, l3, (String)localObject4, localJSONObject, null, null, null, null, bool1, null, null, null, (com.google.android.gms.ads.internal.d.a)localObject5, bool2, bool3, bool4, null, bool5, localAdResponseParcel.S);
    n.a.post(new i(this, (com.google.android.gms.ads.internal.v.a)localObject1));
  }
  
  public final void be_() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/renderer/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */