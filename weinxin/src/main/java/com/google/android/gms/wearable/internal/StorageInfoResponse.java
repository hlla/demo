package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class StorageInfoResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<StorageInfoResponse> CREATOR = new al();
  public final long aHi;
  public final List<PackageStorageInfo> aHj;
  public final int statusCode;
  public final int versionCode;
  
  StorageInfoResponse(int paramInt1, int paramInt2, long paramLong, List<PackageStorageInfo> paramList)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.aHi = paramLong;
    this.aHj = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    al.a(this, paramParcel);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/StorageInfoResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */