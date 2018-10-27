package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public final class InterstitialAdParameterParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ap();
  public final int a;
  public final boolean b;
  public final float c;
  public final boolean d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  private final String i;
  
  InterstitialAdParameterParcel(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, float paramFloat, int paramInt, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.h = paramBoolean1;
    this.d = paramBoolean2;
    this.i = paramString;
    this.b = paramBoolean3;
    this.c = paramFloat;
    this.a = paramInt;
    this.e = paramBoolean4;
    this.g = paramBoolean5;
    this.f = paramBoolean6;
  }
  
  public InterstitialAdParameterParcel(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat, int paramInt, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this(paramBoolean1, paramBoolean2, null, paramBoolean3, paramFloat, paramInt, paramBoolean4, paramBoolean5, paramBoolean6);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.h);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.i);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8, this.e);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 9, this.g);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 10, this.f);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/InterstitialAdParameterParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */