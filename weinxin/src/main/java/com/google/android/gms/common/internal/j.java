package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class j
  implements Parcelable.Creator<GetServiceRequest>
{
  static void a(GetServiceRequest paramGetServiceRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramGetServiceRequest.version);
    b.c(paramParcel, 2, paramGetServiceRequest.apA);
    b.c(paramParcel, 3, paramGetServiceRequest.apB);
    b.a(paramParcel, 4, paramGetServiceRequest.apC);
    b.a(paramParcel, 5, paramGetServiceRequest.apD);
    b.a(paramParcel, 6, paramGetServiceRequest.apE, paramInt);
    b.a(paramParcel, 7, paramGetServiceRequest.apF);
    b.a(paramParcel, 8, paramGetServiceRequest.apG, paramInt);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */