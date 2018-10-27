package com.google.android.gms.ads.internal.signals;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public final class SignalConfigurationParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new i();
  public final String a;
  public final String b;
  
  public SignalConfigurationParcel(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.a = paramString2;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.a);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/signals/SignalConfigurationParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */