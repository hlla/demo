package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class m
  implements Parcelable.Creator<GetCloudSyncOptInStatusResponse>
{
  static void a(GetCloudSyncOptInStatusResponse paramGetCloudSyncOptInStatusResponse, Parcel paramParcel)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramGetCloudSyncOptInStatusResponse.versionCode);
    b.c(paramParcel, 2, paramGetCloudSyncOptInStatusResponse.statusCode);
    b.a(paramParcel, 3, paramGetCloudSyncOptInStatusResponse.aGX);
    b.a(paramParcel, 4, paramGetCloudSyncOptInStatusResponse.aGY);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */