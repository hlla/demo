package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryStatusItem> CREATOR = new Parcelable.Creator() {};
  public String clientVersion;
  public String mpX;
  public String processName;
  public long timestamp;
  public int wNX;
  public int wNZ;
  public int wOa;
  
  public final boolean UU(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = paramString.split(",");
      this.processName = paramString[0];
      this.mpX = paramString[1];
      this.clientVersion = paramString[2];
      this.wNX = Integer.valueOf(paramString[3]).intValue();
      this.wOa = Integer.valueOf(paramString[4]).intValue();
      this.wNZ = Integer.valueOf(paramString[5]).intValue();
      this.timestamp = Long.valueOf(paramString[6]).longValue();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public final String cdp()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.mpX);
    localStringBuffer.append(",");
    localStringBuffer.append(this.clientVersion);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wNX);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wOa);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wNZ);
    localStringBuffer.append(",");
    localStringBuffer.append(this.timestamp);
    return localStringBuffer.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.mpX);
    paramParcel.writeString(this.clientVersion);
    paramParcel.writeInt(this.wNX);
    paramParcel.writeInt(this.wOa);
    paramParcel.writeInt(this.wNZ);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/model/RecoveryStatusItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */