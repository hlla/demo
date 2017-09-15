package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PutDataResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<PutDataResponse> CREATOR = new ag();
  public final DataItemParcelable aHc;
  public final int statusCode;
  public final int versionCode;
  
  PutDataResponse(int paramInt1, int paramInt2, DataItemParcelable paramDataItemParcelable)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.aHc = paramDataItemParcelable;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ag.a(this, paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/PutDataResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */