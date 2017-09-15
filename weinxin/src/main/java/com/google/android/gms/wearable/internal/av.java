package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class av
  implements Parcelable.Creator<AncsNotificationParcelable>
{
  static void a(AncsNotificationParcelable paramAncsNotificationParcelable, Parcel paramParcel)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramAncsNotificationParcelable.mVersionCode);
    b.c(paramParcel, 2, paramAncsNotificationParcelable.dX);
    b.a(paramParcel, 3, paramAncsNotificationParcelable.aAU);
    b.a(paramParcel, 4, paramAncsNotificationParcelable.aGz);
    b.a(paramParcel, 5, paramAncsNotificationParcelable.aGA);
    b.a(paramParcel, 6, paramAncsNotificationParcelable.aGB);
    b.a(paramParcel, 7, paramAncsNotificationParcelable.aGC);
    if (paramAncsNotificationParcelable.aDg == null) {}
    for (String str = paramAncsNotificationParcelable.aAU;; str = paramAncsNotificationParcelable.aDg)
    {
      b.a(paramParcel, 8, str);
      b.a(paramParcel, 9, paramAncsNotificationParcelable.aGD);
      b.a(paramParcel, 10, paramAncsNotificationParcelable.aGE);
      b.a(paramParcel, 11, paramAncsNotificationParcelable.aGF);
      b.a(paramParcel, 12, paramAncsNotificationParcelable.aGG);
      b.u(paramParcel, i);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */