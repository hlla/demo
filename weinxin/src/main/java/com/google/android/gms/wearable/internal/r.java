package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class r
  implements Parcelable.Creator<GetDataItemResponse>
{
  static void a(GetDataItemResponse paramGetDataItemResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramGetDataItemResponse.versionCode);
    b.c(paramParcel, 2, paramGetDataItemResponse.statusCode);
    b.a(paramParcel, 3, paramGetDataItemResponse.aHc, paramInt);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */