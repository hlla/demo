package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.IconAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.instream.InstreamAdConfigurationParcel;
import com.google.android.gms.ads.internal.util.a.h;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@com.google.android.gms.ads.internal.q.a.a
public final class AdRequestInfoParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new v();
  public final boolean A;
  public final boolean B;
  public final boolean C;
  public final boolean D;
  public final int E;
  public final Bundle F;
  public final NativeAdOptionsParcel G;
  public final String H;
  public final List I;
  public final List J;
  public final int K;
  public final boolean L;
  public final int M;
  public final PackageInfo N;
  public final String O;
  public final String P;
  public final String Q;
  public final String R;
  public final String S;
  public final String T;
  public final float U;
  public final int V;
  public final int W;
  public final String X;
  public final String Y;
  public final String Z;
  public final Bundle a;
  public final Bundle aa;
  public final int ab;
  public final boolean ac;
  public final int ad;
  public final VersionInfoParcel ae;
  public final String af;
  public final String ag;
  public final AdRequestParcel b;
  public final AdSizeParcel c;
  public final String d;
  public final int e;
  public final List f;
  public final String g;
  public final boolean h;
  public final String i;
  public final float j;
  public final ApplicationInfo k;
  public final long l;
  public final String m;
  public final Bundle n;
  public final long o;
  public final String p;
  public final List q;
  public final boolean r;
  public final List s;
  public final ArrayList t;
  public final Bundle u;
  public final IconAdOptionsParcel v;
  public final InstreamAdConfigurationParcel w;
  public final Bundle x;
  public final boolean y;
  public final boolean z;
  
  AdRequestInfoParcel(int paramInt1, Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, int paramInt2, List paramList1, Bundle paramBundle3, boolean paramBoolean1, int paramInt3, int paramInt4, float paramFloat1, String paramString5, long paramLong1, String paramString6, List paramList2, String paramString7, NativeAdOptionsParcel paramNativeAdOptionsParcel, List paramList3, long paramLong2, String paramString8, float paramFloat2, boolean paramBoolean2, int paramInt5, int paramInt6, boolean paramBoolean3, boolean paramBoolean4, String paramString9, String paramString10, boolean paramBoolean5, int paramInt7, Bundle paramBundle4, String paramString11, IconAdOptionsParcel paramIconAdOptionsParcel, boolean paramBoolean6, Bundle paramBundle5, String paramString12, String paramString13, String paramString14, boolean paramBoolean7, List paramList4, String paramString15, List paramList5, int paramInt8, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, ArrayList paramArrayList, String paramString16, InstreamAdConfigurationParcel paramInstreamAdConfigurationParcel, String paramString17, Bundle paramBundle6)
  {
    this.ad = paramInt1;
    this.a = paramBundle1;
    this.b = paramAdRequestParcel;
    this.c = paramAdSizeParcel;
    this.d = paramString1;
    this.k = paramApplicationInfo;
    this.N = paramPackageInfo;
    this.O = paramString2;
    this.X = paramString3;
    this.Y = paramString4;
    this.ae = paramVersionInfoParcel;
    this.aa = paramBundle2;
    this.K = paramInt2;
    this.J = paramList1;
    if (paramList3 == null) {}
    for (paramBundle1 = Collections.emptyList();; paramBundle1 = Collections.unmodifiableList(paramList3))
    {
      this.I = paramBundle1;
      this.n = paramBundle3;
      this.ac = paramBoolean1;
      this.W = paramInt3;
      this.V = paramInt4;
      this.U = paramFloat1;
      this.af = paramString5;
      this.o = paramLong1;
      this.P = paramString6;
      if (paramList2 == null) {}
      for (paramBundle1 = Collections.emptyList();; paramBundle1 = Collections.unmodifiableList(paramList2))
      {
        this.s = paramBundle1;
        this.Z = paramString7;
        this.G = paramNativeAdOptionsParcel;
        this.l = paramLong2;
        this.g = paramString8;
        this.j = paramFloat2;
        this.h = paramBoolean2;
        this.ab = paramInt5;
        this.e = paramInt6;
        this.y = paramBoolean3;
        this.z = paramBoolean4;
        this.ag = paramString9;
        this.i = paramString10;
        this.L = paramBoolean5;
        this.M = paramInt7;
        this.F = paramBundle4;
        this.p = paramString11;
        this.v = paramIconAdOptionsParcel;
        this.A = paramBoolean6;
        this.x = paramBundle5;
        this.T = paramString12;
        this.S = paramString13;
        this.Q = paramString14;
        this.C = paramBoolean7;
        this.f = paramList4;
        this.H = paramString15;
        this.q = paramList5;
        this.E = paramInt8;
        this.B = paramBoolean8;
        this.r = paramBoolean9;
        this.D = paramBoolean10;
        this.t = paramArrayList;
        this.m = paramString16;
        this.w = paramInstreamAdConfigurationParcel;
        this.R = paramString17;
        this.u = paramBundle6;
        return;
      }
    }
  }
  
  private AdRequestInfoParcel(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, int paramInt1, List paramList1, List paramList2, Bundle paramBundle3, boolean paramBoolean1, int paramInt2, int paramInt3, float paramFloat1, String paramString5, long paramLong1, String paramString6, List paramList3, String paramString7, NativeAdOptionsParcel paramNativeAdOptionsParcel, long paramLong2, String paramString8, float paramFloat2, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, boolean paramBoolean4, String paramString9, String paramString10, boolean paramBoolean5, int paramInt6, Bundle paramBundle4, String paramString11, IconAdOptionsParcel paramIconAdOptionsParcel, boolean paramBoolean6, Bundle paramBundle5, String paramString12, String paramString13, String paramString14, boolean paramBoolean7, List paramList4, String paramString15, List paramList5, int paramInt7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, ArrayList paramArrayList, String paramString16, InstreamAdConfigurationParcel paramInstreamAdConfigurationParcel, String paramString17, Bundle paramBundle6)
  {
    this(24, paramBundle1, paramAdRequestParcel, paramAdSizeParcel, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramVersionInfoParcel, paramBundle2, paramInt1, paramList1, paramBundle3, paramBoolean1, paramInt2, paramInt3, paramFloat1, paramString5, paramLong1, paramString6, paramList3, paramString7, paramNativeAdOptionsParcel, paramList2, paramLong2, paramString8, paramFloat2, paramBoolean2, paramInt4, paramInt5, paramBoolean3, paramBoolean4, paramString9, paramString10, paramBoolean5, paramInt6, paramBundle4, paramString11, paramIconAdOptionsParcel, paramBoolean6, paramBundle5, paramString12, paramString13, paramString14, paramBoolean7, paramList4, paramString15, paramList5, paramInt7, paramBoolean8, paramBoolean9, paramBoolean10, paramArrayList, paramString16, paramInstreamAdConfigurationParcel, paramString17, paramBundle6);
  }
  
  public AdRequestInfoParcel(u paramu, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramu.a, paramu.b, paramu.c, paramu.d, paramu.k, paramu.M, (String)h.a(paramu.N, ""), paramu.S, paramu.T, paramu.Y, paramu.V, paramu.J, paramu.I, paramu.H, paramu.m, paramu.X, paramu.R, paramu.Q, paramu.P, paramu.Z, paramu.n, paramu.O, paramu.r, paramu.U, paramu.F, paramLong, paramu.g, paramu.j, paramu.h, paramu.W, paramu.e, paramu.x, paramu.y, (String)h.a(paramu.aa, "", 1L, TimeUnit.SECONDS), paramu.i, paramu.K, paramu.L, paramu.E, paramu.o, paramu.u, paramu.z, paramu.w, null, null, null, paramu.B, paramu.f, paramu.G, paramu.p, paramu.D, paramu.A, paramu.q, paramu.C, paramu.s, paramu.l, paramu.v, null, paramu.t);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i2 = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.ad);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.b, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.c, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.k, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.N, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8, this.O);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 9, this.X);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 10, this.Y);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 11, this.ae, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 12, this.aa);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 13, this.K);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 14, this.J);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 15, this.n);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 16, this.ac);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 18, this.W);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 19, this.V);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20, this.U);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 21, this.af);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 25, this.o);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 26, this.P);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 27, this.s);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 28, this.Z);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 29, this.G, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 30, this.I);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 31, this.l);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 33, this.g);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 34, this.j);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 35, this.ab);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 36, this.e);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 37, this.y);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 38, this.z);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 39, this.ag);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 40, this.h);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 41, this.i);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 42, this.L);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 43, this.M);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 44, this.F);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 45, this.p);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 46, this.v, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 47, this.A);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 48, this.x);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 49, this.T);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 50, this.S);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 51, this.Q);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 52, this.C);
    List localList = this.f;
    if (localList != null)
    {
      int i3 = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 53);
      int i4 = localList.size();
      paramParcel.writeInt(i4);
      int i1 = 0;
      while (i1 < i4)
      {
        paramParcel.writeInt(((Integer)localList.get(i1)).intValue());
        i1 += 1;
      }
      com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i3);
    }
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 54, this.H);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 55, this.q);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 56, this.E);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 57, this.B);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 58, this.r);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 59, this.D);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 60, this.t);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 61, this.m);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 63, this.w, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 64, this.R);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 65, this.u);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/AdRequestInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */