package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.formats.f;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public class NativeAdOptionsParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new af();
  public final int a;
  public final int b;
  public final boolean c;
  public final boolean d;
  public final int e;
  public final VideoOptionsParcel f;
  private final boolean g;
  
  public NativeAdOptionsParcel(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3, VideoOptionsParcel paramVideoOptionsParcel, boolean paramBoolean3)
  {
    this.e = paramInt1;
    this.d = paramBoolean1;
    this.b = paramInt2;
    this.c = paramBoolean2;
    this.a = paramInt3;
    this.f = paramVideoOptionsParcel;
    this.g = paramBoolean3;
  }
  
  public NativeAdOptionsParcel(f paramf) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.e);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.f, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.g);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/NativeAdOptionsParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */