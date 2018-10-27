package com.google.android.gms.ads.internal.v;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.v;
import com.google.android.gms.ads.internal.mediation.c;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.i;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  public final com.google.android.gms.ads.internal.mediation.b A;
  public final com.google.android.gms.ads.internal.mediation.client.e B;
  public final String C;
  public final String D;
  public final c E;
  public final com.google.android.gms.ads.internal.mediation.e F;
  public final List G;
  public final v H;
  public final int I;
  public final long J;
  public final List K;
  public final RewardItemParcel L;
  public final List M;
  public final boolean N;
  public final String O;
  public final boolean P;
  public final JSONObject a;
  public final long b;
  public final com.google.android.gms.ads.internal.d.a c;
  public final AdRequestParcel d;
  public final AdSizeParcel e;
  public final long f;
  public final i g;
  public final List h;
  public final String i;
  public final String j;
  public final List k;
  public final int l;
  public final List m;
  public final boolean n;
  public final boolean o;
  public boolean p = false;
  public boolean q;
  public boolean r = false;
  public boolean s = false;
  public boolean t = false;
  public final boolean u;
  public boolean v = false;
  public boolean w = false;
  public final boolean x;
  public final boolean y;
  public final List z;
  
  public a(AdRequestParcel paramAdRequestParcel, i parami, List paramList1, int paramInt1, List paramList2, List paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean1, com.google.android.gms.ads.internal.mediation.b paramb, com.google.android.gms.ads.internal.mediation.client.e parame, String paramString2, c paramc, com.google.android.gms.ads.internal.mediation.e parame1, AdSizeParcel paramAdSizeParcel, long paramLong2, long paramLong3, String paramString3, JSONObject paramJSONObject, v paramv, RewardItemParcel paramRewardItemParcel, List paramList4, List paramList5, boolean paramBoolean2, String paramString4, List paramList6, String paramString5, com.google.android.gms.ads.internal.d.a parama, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, List paramList7, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.d = paramAdRequestParcel;
    this.g = parami;
    this.h = a(paramList1);
    this.l = paramInt1;
    this.m = a(paramList2);
    this.z = a(paramList3);
    this.I = paramInt2;
    this.J = paramLong1;
    this.O = paramString1;
    this.u = paramBoolean1;
    this.A = paramb;
    this.B = parame;
    this.C = paramString2;
    this.E = paramc;
    this.F = parame1;
    this.e = paramAdSizeParcel;
    this.f = paramLong2;
    this.b = paramLong3;
    this.i = paramString3;
    this.a = paramJSONObject;
    this.H = paramv;
    this.L = paramRewardItemParcel;
    this.M = a(paramList4);
    this.K = a(paramList5);
    this.y = paramBoolean2;
    this.D = paramString4;
    this.G = a(paramList6);
    this.j = paramString5;
    this.c = parama;
    this.o = paramBoolean3;
    this.P = paramBoolean4;
    this.x = paramBoolean5;
    this.k = a(paramList7);
    this.n = paramBoolean6;
    this.N = paramBoolean7;
  }
  
  public a(b paramb)
  {
    this(localAdRequestParcel, null, localList1, i1, localList2, localList3, i2, l1, (String)localObject1, bool1, null, null, null, localc, null, localAdSizeParcel, l2, l3, str1, localJSONObject, null, localRewardItemParcel, localList4, localList4, bool2, null, (List)localObject2, str2, locala, bool3, bool4, bool5, paramb, bool6, localAdResponseParcel.S);
  }
  
  private static List a(List paramList)
  {
    if (paramList != null) {
      return Collections.unmodifiableList(paramList);
    }
    return null;
  }
  
  public final boolean a()
  {
    i locali = this.g;
    if ((locali != null) && (locali.getAdWebViewClient() != null)) {
      return this.g.getAdWebViewClient().b();
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/v/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */