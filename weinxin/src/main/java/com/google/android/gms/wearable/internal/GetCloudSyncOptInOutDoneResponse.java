package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncOptInOutDoneResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetCloudSyncOptInOutDoneResponse> CREATOR = new l();
  public final boolean aGW;
  public final int statusCode;
  public final int versionCode;
  
  GetCloudSyncOptInOutDoneResponse(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.aGW = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/GetCloudSyncOptInOutDoneResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */