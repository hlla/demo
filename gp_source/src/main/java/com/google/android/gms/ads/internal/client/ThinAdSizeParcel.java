package com.google.android.gms.ads.internal.client;

import android.os.Parcel;

@com.google.android.gms.ads.internal.q.a.a
public class ThinAdSizeParcel
  extends AdSizeParcel
{
  public ThinAdSizeParcel(AdSizeParcel paramAdSizeParcel)
  {
    super(paramAdSizeParcel.a, paramAdSizeParcel.b, paramAdSizeParcel.c, paramAdSizeParcel.e, paramAdSizeParcel.i, paramAdSizeParcel.j, paramAdSizeParcel.h, paramAdSizeParcel.f, paramAdSizeParcel.d, paramAdSizeParcel.g);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.i);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/ThinAdSizeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */