package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class ar
  implements Parcelable.Creator<AddLocalCapabilityResponse>
{
  static void a(AddLocalCapabilityResponse paramAddLocalCapabilityResponse, Parcel paramParcel)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramAddLocalCapabilityResponse.versionCode);
    b.c(paramParcel, 2, paramAddLocalCapabilityResponse.statusCode);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */