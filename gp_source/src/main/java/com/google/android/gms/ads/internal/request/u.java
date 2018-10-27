package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.IconAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.instream.InstreamAdConfigurationParcel;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@a
public final class u
{
  public final boolean A;
  public final boolean B;
  public final boolean C;
  public final int D;
  public final Bundle E;
  public final NativeAdOptionsParcel F;
  public final String G;
  public final List H;
  public final List I;
  public final int J;
  public final boolean K;
  public final int L;
  public final PackageInfo M;
  public final Future N;
  public final String O;
  public final float P;
  public final int Q;
  public final int R;
  public final String S;
  public final String T;
  public final String U;
  public final Bundle V;
  public final int W;
  public final boolean X;
  public final VersionInfoParcel Y;
  public final String Z;
  public final Bundle a;
  public final Future aa;
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
  public final String l;
  public final Bundle m;
  public final long n;
  public final String o;
  public final List p;
  public final boolean q;
  public final List r;
  public final ArrayList s;
  public final Bundle t;
  public final IconAdOptionsParcel u;
  public final InstreamAdConfigurationParcel v;
  public final Bundle w;
  public final boolean x;
  public final boolean y;
  public final boolean z;
  
  public u(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, List paramList1, List paramList2, Bundle paramBundle3, boolean paramBoolean1, int paramInt1, int paramInt2, float paramFloat1, String paramString4, long paramLong, String paramString5, List paramList3, String paramString6, NativeAdOptionsParcel paramNativeAdOptionsParcel, String paramString7, float paramFloat2, boolean paramBoolean2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, Future paramFuture1, String paramString8, boolean paramBoolean5, int paramInt5, Bundle paramBundle4, String paramString9, IconAdOptionsParcel paramIconAdOptionsParcel, boolean paramBoolean6, Bundle paramBundle5, boolean paramBoolean7, Future paramFuture2, List paramList4, String paramString10, List paramList5, int paramInt6, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, ArrayList paramArrayList, String paramString11, InstreamAdConfigurationParcel paramInstreamAdConfigurationParcel, Bundle paramBundle6)
  {
    this.a = paramBundle1;
    this.b = paramAdRequestParcel;
    this.c = paramAdSizeParcel;
    this.d = paramString1;
    this.k = paramApplicationInfo;
    this.M = paramPackageInfo;
    this.S = paramString2;
    this.T = paramString3;
    this.Y = paramVersionInfoParcel;
    this.V = paramBundle2;
    this.X = paramBoolean1;
    this.R = paramInt1;
    this.Q = paramInt2;
    this.P = paramFloat1;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      this.J = 3;
      this.I = paramList1;
    }
    for (this.H = paramList2;; this.H = null)
    {
      this.m = paramBundle3;
      this.Z = paramString4;
      this.n = paramLong;
      this.O = paramString5;
      this.r = paramList3;
      this.U = paramString6;
      this.F = paramNativeAdOptionsParcel;
      this.g = paramString7;
      this.j = paramFloat2;
      this.h = paramBoolean2;
      this.W = paramInt3;
      this.e = paramInt4;
      this.x = paramBoolean3;
      this.y = paramBoolean4;
      this.aa = paramFuture1;
      this.i = paramString8;
      this.K = paramBoolean5;
      this.L = paramInt5;
      this.E = paramBundle4;
      this.o = paramString9;
      this.u = paramIconAdOptionsParcel;
      this.z = paramBoolean6;
      this.w = paramBundle5;
      this.B = paramBoolean7;
      this.N = paramFuture2;
      this.f = paramList4;
      this.G = paramString10;
      this.p = paramList5;
      this.D = paramInt6;
      this.A = paramBoolean8;
      this.q = paramBoolean9;
      this.C = paramBoolean10;
      this.s = paramArrayList;
      this.l = paramString11;
      this.v = paramInstreamAdConfigurationParcel;
      this.t = paramBundle6;
      return;
      this.J = 0;
      this.I = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */