package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class n
  implements Parcelable.Creator<GetCloudSyncSettingResponse>
{
  static void a(GetCloudSyncSettingResponse paramGetCloudSyncSettingResponse, Parcel paramParcel)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramGetCloudSyncSettingResponse.versionCode);
    b.c(paramParcel, 2, paramGetCloudSyncSettingResponse.statusCode);
    b.a(paramParcel, 3, paramGetCloudSyncSettingResponse.enabled);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */