package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.g;

public class DataItemAssetParcelable
  implements SafeParcelable, g
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new b();
  final String ahk;
  final String azV;
  final int mVersionCode;
  
  DataItemAssetParcelable(int paramInt, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.ahk = paramString1;
    this.azV = paramString2;
  }
  
  public DataItemAssetParcelable(g paramg)
  {
    this.mVersionCode = 1;
    this.ahk = ((String)w.Z(paramg.getId()));
    this.azV = ((String)w.Z(paramg.mE()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getId()
  {
    return this.ahk;
  }
  
  public final String mE()
  {
    return this.azV;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.ahk == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.azV);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.ahk);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/DataItemAssetParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */