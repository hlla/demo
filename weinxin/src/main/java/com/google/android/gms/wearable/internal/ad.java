package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class ad
  implements Parcelable.Creator<NodeParcelable>
{
  static void a(NodeParcelable paramNodeParcelable, Parcel paramParcel)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramNodeParcelable.mVersionCode);
    b.a(paramParcel, 2, paramNodeParcelable.ahk);
    b.a(paramParcel, 3, paramNodeParcelable.aDg);
    b.c(paramParcel, 4, paramNodeParcelable.aHg);
    b.a(paramParcel, 5, paramNodeParcelable.aHh);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */