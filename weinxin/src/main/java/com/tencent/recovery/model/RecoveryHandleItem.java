package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryHandleItem
  extends RecoveryPersistentItem
{
  public static final Parcelable.Creator<RecoveryHandleItem> CREATOR = new Parcelable.Creator() {};
  public String arH;
  public String clientVersion;
  public String mpX;
  public String processName;
  public long timestamp;
  public String wOm;
  
  public final boolean UU(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = paramString.split(",");
      this.mpX = paramString[0];
      this.clientVersion = paramString[1];
      this.arH = paramString[2];
      this.processName = paramString[3];
      this.wOm = paramString[4];
      this.timestamp = Long.valueOf(paramString[5]).longValue();
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public final String cdp()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.mpX);
    localStringBuffer.append(",");
    localStringBuffer.append(this.clientVersion);
    localStringBuffer.append(",");
    localStringBuffer.append(this.arH);
    localStringBuffer.append(",");
    localStringBuffer.append(this.processName);
    localStringBuffer.append(",");
    localStringBuffer.append(this.wOm);
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
    paramParcel.writeString(this.mpX);
    paramParcel.writeString(this.clientVersion);
    paramParcel.writeString(this.arH);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.wOm);
    paramParcel.writeLong(this.timestamp);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/model/RecoveryHandleItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */