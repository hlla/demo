package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class AdResponseParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new x();
  public final boolean A;
  public final boolean B;
  public final boolean C;
  public final boolean D;
  public final boolean E;
  public final List F;
  public final long G;
  public final List H;
  public final boolean I;
  public final String J;
  public final int K;
  public final String L;
  public final long M;
  public final int N;
  public final List O;
  public final RewardItemParcel P;
  public final List Q;
  public final SafeBrowsingConfigParcel R;
  public boolean S;
  public String T;
  public final boolean U;
  public String V;
  private LargeParcelTeleporter W;
  private Bundle X;
  private AdRequestInfoParcel Y;
  private final int Z;
  public final String a;
  public final String b;
  public final String c;
  public final AutoClickProtectionConfigurationParcel d;
  public final String e;
  public String f;
  public final List g;
  public final boolean h;
  public final boolean i;
  public String j;
  public final String k;
  public final String l;
  public final List m;
  public final int n;
  public final long o;
  public final String p;
  public final List q;
  public final long r;
  public final boolean s;
  public final boolean t;
  public final boolean u;
  public final boolean v;
  public final boolean w;
  public final boolean x;
  public final boolean y;
  public final boolean z;
  
  public AdResponseParcel(int paramInt)
  {
    this(19, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0, false, null, false, null, null, false);
  }
  
  public AdResponseParcel(int paramInt, long paramLong)
  {
    this(19, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0, false, null, false, null, null, false);
  }
  
  AdResponseParcel(int paramInt1, String paramString1, String paramString2, List paramList1, int paramInt2, List paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, LargeParcelTeleporter paramLargeParcelTeleporter, String paramString7, String paramString8, boolean paramBoolean8, boolean paramBoolean9, RewardItemParcel paramRewardItemParcel, List paramList4, List paramList5, boolean paramBoolean10, AutoClickProtectionConfigurationParcel paramAutoClickProtectionConfigurationParcel, boolean paramBoolean11, String paramString9, List paramList6, boolean paramBoolean12, String paramString10, SafeBrowsingConfigParcel paramSafeBrowsingConfigParcel, String paramString11, boolean paramBoolean13, boolean paramBoolean14, Bundle paramBundle, boolean paramBoolean15, int paramInt4, boolean paramBoolean16, List paramList7, boolean paramBoolean17, String paramString12, String paramString13, boolean paramBoolean18)
  {
    this.Z = paramInt1;
    this.e = paramString1;
    this.f = paramString2;
    if (paramList1 != null) {}
    for (paramString1 = Collections.unmodifiableList(paramList1);; paramString1 = null)
    {
      this.g = paramString1;
      this.n = paramInt2;
      if (paramList2 != null) {}
      for (paramString1 = Collections.unmodifiableList(paramList2);; paramString1 = null)
      {
        this.q = paramString1;
        this.r = paramLong1;
        this.y = paramBoolean1;
        this.G = paramLong2;
        if (paramList3 != null) {}
        for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
        {
          this.F = paramString1;
          this.M = paramLong3;
          this.K = paramInt3;
          this.b = paramString3;
          this.o = paramLong4;
          this.k = paramString4;
          this.x = paramBoolean2;
          this.L = paramString5;
          this.a = paramString6;
          this.v = paramBoolean3;
          this.z = paramBoolean4;
          this.U = paramBoolean5;
          this.h = paramBoolean6;
          this.i = paramBoolean13;
          this.D = paramBoolean7;
          this.W = paramLargeParcelTeleporter;
          this.j = paramString7;
          this.p = paramString8;
          if (this.f == null)
          {
            paramString1 = this.W;
            if (paramString1 != null)
            {
              paramString1 = (StringParcel)paramString1.a(StringParcel.CREATOR);
              if (paramString1 != null) {
                break label384;
              }
            }
          }
          for (;;)
          {
            this.w = paramBoolean8;
            this.A = paramBoolean9;
            this.P = paramRewardItemParcel;
            this.Q = paramList4;
            this.O = paramList5;
            this.E = paramBoolean10;
            this.d = paramAutoClickProtectionConfigurationParcel;
            this.s = paramBoolean11;
            this.V = paramString9;
            this.H = paramList6;
            this.I = paramBoolean12;
            this.c = paramString10;
            this.R = paramSafeBrowsingConfigParcel;
            this.l = paramString11;
            this.B = paramBoolean14;
            this.X = paramBundle;
            this.u = paramBoolean15;
            this.N = paramInt4;
            this.C = paramBoolean16;
            if (paramList7 != null) {}
            for (paramString1 = Collections.unmodifiableList(paramList7);; paramString1 = null)
            {
              this.m = paramString1;
              this.t = paramBoolean17;
              this.J = paramString12;
              this.T = paramString13;
              this.S = paramBoolean18;
              return;
            }
            label384:
            if (!TextUtils.isEmpty(paramString1.a)) {
              this.f = paramString1.a;
            }
          }
        }
      }
    }
  }
  
  public AdResponseParcel(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString1, String paramString2, List paramList1, List paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString7, boolean paramBoolean8, boolean paramBoolean9, RewardItemParcel paramRewardItemParcel, List paramList4, List paramList5, boolean paramBoolean10, AutoClickProtectionConfigurationParcel paramAutoClickProtectionConfigurationParcel, boolean paramBoolean11, String paramString8, List paramList6, boolean paramBoolean12, String paramString9, SafeBrowsingConfigParcel paramSafeBrowsingConfigParcel, String paramString10, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, List paramList7, boolean paramBoolean17, String paramString11, String paramString12, boolean paramBoolean18)
  {
    this(19, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, null, null, paramString7, paramBoolean8, paramBoolean9, paramRewardItemParcel, paramList4, paramList5, paramBoolean10, paramAutoClickProtectionConfigurationParcel, paramBoolean11, paramString8, paramList6, paramBoolean12, paramString9, paramSafeBrowsingConfigParcel, paramString10, paramBoolean13, paramBoolean14, null, paramBoolean15, 0, paramBoolean16, paramList7, paramBoolean17, paramString11, paramString12, paramBoolean18);
    this.Y = paramAdRequestInfoParcel;
  }
  
  public AdResponseParcel(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString1, String paramString2, List paramList1, List paramList2, long paramLong1, boolean paramBoolean1, List paramList3, long paramLong2, int paramInt1, String paramString3, long paramLong3, String paramString4, String paramString5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString6, boolean paramBoolean6, boolean paramBoolean7, RewardItemParcel paramRewardItemParcel, List paramList4, List paramList5, boolean paramBoolean8, AutoClickProtectionConfigurationParcel paramAutoClickProtectionConfigurationParcel, boolean paramBoolean9, String paramString7, List paramList6, boolean paramBoolean10, String paramString8, SafeBrowsingConfigParcel paramSafeBrowsingConfigParcel, String paramString9, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, int paramInt2, boolean paramBoolean14, List paramList7, boolean paramBoolean15, String paramString10, String paramString11, boolean paramBoolean16)
  {
    this(19, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, -1L, paramList3, paramLong2, paramInt1, paramString3, paramLong3, paramString4, false, null, paramString5, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, null, null, paramString6, paramBoolean6, paramBoolean7, paramRewardItemParcel, paramList4, paramList5, paramBoolean8, paramAutoClickProtectionConfigurationParcel, paramBoolean9, paramString7, paramList6, paramBoolean10, paramString8, paramSafeBrowsingConfigParcel, paramString9, paramBoolean11, paramBoolean12, null, paramBoolean13, paramInt2, paramBoolean14, paramList7, paramBoolean15, paramString10, paramString11, paramBoolean16);
    this.Y = paramAdRequestInfoParcel;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AdRequestInfoParcel localAdRequestInfoParcel = this.Y;
    if ((localAdRequestInfoParcel != null) && (localAdRequestInfoParcel.ad >= 9) && (!TextUtils.isEmpty(this.f)))
    {
      this.W = new LargeParcelTeleporter(new StringParcel(this.f));
      this.f = null;
    }
    int i1 = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.Z);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.e);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.f);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.g);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.n);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.q);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.r);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8, this.y);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 9, this.G);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 10, this.F);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 11, this.M);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 12, this.K);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 13, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 14, this.o);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 15, this.k);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 18, this.x);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 19, this.L);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 21, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 22, this.v);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 23, this.z);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 24, this.U);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 25, this.h);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 26, this.D);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 28, this.W, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 29, this.j);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 30, this.p);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 31, this.w);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 32, this.A);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 33, this.P, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 34, this.Q);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 35, this.O);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 36, this.E);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 37, this.d, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 38, this.s);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 39, this.V);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 40, this.H);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 42, this.I);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 43, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 44, this.R, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 45, this.l);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 46, this.i);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 47, this.B);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 48, this.X);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 49, this.u);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 50, this.N);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 51, this.C);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 52, this.m);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 53, this.t);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 54, this.J);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 55, this.T);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 56, this.S);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/AdResponseParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */