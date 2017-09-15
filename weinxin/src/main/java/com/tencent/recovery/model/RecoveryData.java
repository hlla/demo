package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RecoveryData
  implements Parcelable
{
  public static final Parcelable.Creator<RecoveryData> CREATOR = new Parcelable.Creator() {};
  public String clientVersion;
  public String mpX;
  public String processName;
  public String wOk;
  public List<RecoveryStatusItem> wOl;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.mpX);
    paramParcel.writeString(this.clientVersion);
    paramParcel.writeString(this.wOk);
    paramParcel.writeList(this.wOl);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/model/RecoveryData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */