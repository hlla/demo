package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public class AdDataParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  private final String a;
  private final String b;
  
  public AdDataParcel(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.b);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/AdDataParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */