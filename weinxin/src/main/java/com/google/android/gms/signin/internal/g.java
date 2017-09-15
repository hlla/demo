package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class g
  implements Parcelable.Creator<RecordConsentRequest>
{
  static void a(RecordConsentRequest paramRecordConsentRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramRecordConsentRequest.mVersionCode);
    b.a(paramParcel, 2, paramRecordConsentRequest.akV, paramInt);
    b.a(paramParcel, 3, paramRecordConsentRequest.aDk, paramInt);
    b.a(paramParcel, 4, paramRecordConsentRequest.alT);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/signin/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */