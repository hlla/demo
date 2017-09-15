package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class al
  implements Parcelable.Creator<StorageInfoResponse>
{
  static void a(StorageInfoResponse paramStorageInfoResponse, Parcel paramParcel)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramStorageInfoResponse.versionCode);
    b.c(paramParcel, 2, paramStorageInfoResponse.statusCode);
    b.a(paramParcel, 3, paramStorageInfoResponse.aHi);
    b.b(paramParcel, 4, paramStorageInfoResponse.aHj);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */