package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.x;
import java.util.Arrays;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class AdRequestParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new i();
  public final AdDataParcel a;
  @Deprecated
  public final long b;
  public final List c;
  public final String d;
  public final Bundle e;
  public final Bundle f;
  @Deprecated
  public final int g;
  @Deprecated
  public final boolean h;
  public final boolean i;
  public final List j;
  public final Location k;
  public final boolean l;
  public final String m;
  public final Bundle n;
  public final String o;
  public final String p;
  public final String q;
  public final SearchAdRequestParcel r;
  public final int s;
  public final int t;
  public final int u;
  
  public AdRequestParcel(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List paramList1, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, SearchAdRequestParcel paramSearchAdRequestParcel, Location paramLocation, String paramString2, Bundle paramBundle2, Bundle paramBundle3, List paramList2, String paramString3, String paramString4, boolean paramBoolean3, AdDataParcel paramAdDataParcel, int paramInt4, String paramString5)
  {
    this.u = paramInt1;
    this.b = paramLong;
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    this.f = localBundle;
    this.g = paramInt2;
    this.j = paramList1;
    this.i = paramBoolean1;
    this.s = paramInt3;
    this.l = paramBoolean2;
    this.o = paramString1;
    this.r = paramSearchAdRequestParcel;
    this.k = paramLocation;
    this.d = paramString2;
    paramBundle1 = paramBundle2;
    if (paramBundle2 == null) {
      paramBundle1 = new Bundle();
    }
    this.n = paramBundle1;
    this.e = paramBundle3;
    this.c = paramList2;
    this.p = paramString3;
    this.q = paramString4;
    this.h = paramBoolean3;
    this.a = paramAdDataParcel;
    this.t = paramInt4;
    this.m = paramString5;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof AdRequestParcel))
    {
      paramObject = (AdRequestParcel)paramObject;
      bool1 = bool2;
      if (this.u == ((AdRequestParcel)paramObject).u)
      {
        bool1 = bool2;
        if (this.b == ((AdRequestParcel)paramObject).b)
        {
          bool1 = bool2;
          if (x.a(this.f, ((AdRequestParcel)paramObject).f))
          {
            bool1 = bool2;
            if (this.g == ((AdRequestParcel)paramObject).g)
            {
              bool1 = bool2;
              if (x.a(this.j, ((AdRequestParcel)paramObject).j))
              {
                bool1 = bool2;
                if (this.i == ((AdRequestParcel)paramObject).i)
                {
                  bool1 = bool2;
                  if (this.s == ((AdRequestParcel)paramObject).s)
                  {
                    bool1 = bool2;
                    if (this.l == ((AdRequestParcel)paramObject).l)
                    {
                      bool1 = bool2;
                      if (x.a(this.o, ((AdRequestParcel)paramObject).o))
                      {
                        bool1 = bool2;
                        if (x.a(this.r, ((AdRequestParcel)paramObject).r))
                        {
                          bool1 = bool2;
                          if (x.a(this.k, ((AdRequestParcel)paramObject).k))
                          {
                            bool1 = bool2;
                            if (x.a(this.d, ((AdRequestParcel)paramObject).d))
                            {
                              bool1 = bool2;
                              if (x.a(this.n, ((AdRequestParcel)paramObject).n))
                              {
                                bool1 = bool2;
                                if (x.a(this.e, ((AdRequestParcel)paramObject).e))
                                {
                                  bool1 = bool2;
                                  if (x.a(this.c, ((AdRequestParcel)paramObject).c))
                                  {
                                    bool1 = bool2;
                                    if (x.a(this.p, ((AdRequestParcel)paramObject).p))
                                    {
                                      bool1 = bool2;
                                      if (x.a(this.q, ((AdRequestParcel)paramObject).q))
                                      {
                                        bool1 = bool2;
                                        if (this.h == ((AdRequestParcel)paramObject).h)
                                        {
                                          bool1 = bool2;
                                          if (this.t == ((AdRequestParcel)paramObject).t)
                                          {
                                            bool1 = bool2;
                                            if (x.a(this.m, ((AdRequestParcel)paramObject).m)) {
                                              bool1 = true;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.u), Long.valueOf(this.b), this.f, Integer.valueOf(this.g), this.j, Boolean.valueOf(this.i), Integer.valueOf(this.s), Boolean.valueOf(this.l), this.o, this.r, this.k, this.d, this.n, this.e, this.c, this.p, this.q, Boolean.valueOf(this.h), Integer.valueOf(this.t), this.m });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.u);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.f);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.g);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.j);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.i);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.s);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8, this.l);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 9, this.o);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 10, this.r, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 11, this.k, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 12, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 13, this.n);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 14, this.e);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 15, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 16, this.p);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 17, this.q);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 18, this.h);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 19, this.a, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20, this.t);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 21, this.m);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/AdRequestParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */