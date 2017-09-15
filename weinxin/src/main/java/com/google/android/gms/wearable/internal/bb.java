package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class bb
  implements Parcelable.Creator<ChannelImpl>
{
  static void a(ChannelImpl paramChannelImpl, Parcel paramParcel)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramChannelImpl.mVersionCode);
    b.a(paramParcel, 2, paramChannelImpl.aGM);
    b.a(paramParcel, 3, paramChannelImpl.aFN);
    b.a(paramParcel, 4, paramChannelImpl.aGN);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */