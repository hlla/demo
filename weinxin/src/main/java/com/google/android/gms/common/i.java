package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class i
  implements Parcelable.Creator<ConnectionResult>
{
  static void a(ConnectionResult paramConnectionResult, Parcel paramParcel, int paramInt)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramConnectionResult.mVersionCode);
    b.c(paramParcel, 2, paramConnectionResult.alZ);
    b.a(paramParcel, 3, paramConnectionResult.ama, paramInt);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */