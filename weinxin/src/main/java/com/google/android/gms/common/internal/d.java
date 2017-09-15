package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class d
  implements Parcelable.Creator<ValidateAccountRequest>
{
  static void a(ValidateAccountRequest paramValidateAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramValidateAccountRequest.mVersionCode);
    b.c(paramParcel, 2, paramValidateAccountRequest.apJ);
    b.a(paramParcel, 3, paramValidateAccountRequest.apt);
    b.a(paramParcel, 4, paramValidateAccountRequest.apu, paramInt);
    b.a(paramParcel, 5, paramValidateAccountRequest.apK);
    b.a(paramParcel, 6, paramValidateAccountRequest.apL);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */