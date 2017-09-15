package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class t
  implements Parcelable.Creator<Status>
{
  static void a(Status paramStatus, Parcel paramParcel, int paramInt)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramStatus.alZ);
    b.c(paramParcel, 1000, paramStatus.mVersionCode);
    b.a(paramParcel, 2, paramStatus.amR);
    b.a(paramParcel, 3, paramStatus.ama, paramInt);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/api/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */