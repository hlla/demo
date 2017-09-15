package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class ag
  implements Parcelable.Creator<PutDataResponse>
{
  static void a(PutDataResponse paramPutDataResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramPutDataResponse.versionCode);
    b.c(paramParcel, 2, paramPutDataResponse.statusCode);
    b.a(paramParcel, 3, paramPutDataResponse.aHc, paramInt);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */