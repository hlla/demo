package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class a
  implements Parcelable.Creator<ConnectionEvent>
{
  static void a(ConnectionEvent paramConnectionEvent, Parcel paramParcel)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramConnectionEvent.mVersionCode);
    b.a(paramParcel, 2, paramConnectionEvent.arN);
    b.a(paramParcel, 4, paramConnectionEvent.arP);
    b.a(paramParcel, 5, paramConnectionEvent.arQ);
    b.a(paramParcel, 6, paramConnectionEvent.arR);
    b.a(paramParcel, 7, paramConnectionEvent.arS);
    b.a(paramParcel, 8, paramConnectionEvent.arT);
    b.a(paramParcel, 10, paramConnectionEvent.arV);
    b.a(paramParcel, 11, paramConnectionEvent.arW);
    b.c(paramParcel, 12, paramConnectionEvent.arO);
    b.a(paramParcel, 13, paramConnectionEvent.arU);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/stats/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */