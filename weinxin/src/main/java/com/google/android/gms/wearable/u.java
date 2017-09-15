package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class u
  implements Parcelable.Creator<ConnectionConfiguration>
{
  static void a(ConnectionConfiguration paramConnectionConfiguration, Parcel paramParcel)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramConnectionConfiguration.mVersionCode);
    b.a(paramParcel, 2, paramConnectionConfiguration.mName);
    b.a(paramParcel, 3, paramConnectionConfiguration.aFI);
    b.c(paramParcel, 4, paramConnectionConfiguration.aoA);
    b.c(paramParcel, 5, paramConnectionConfiguration.aFJ);
    b.a(paramParcel, 6, paramConnectionConfiguration.aFK);
    b.a(paramParcel, 7, paramConnectionConfiguration.ahM);
    b.a(paramParcel, 8, paramConnectionConfiguration.aFL);
    b.a(paramParcel, 9, paramConnectionConfiguration.aFM);
    b.a(paramParcel, 10, paramConnectionConfiguration.aFN);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */