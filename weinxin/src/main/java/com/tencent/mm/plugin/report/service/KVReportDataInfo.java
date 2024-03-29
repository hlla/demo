package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;

class KVReportDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<KVReportDataInfo> CREATOR;
  public boolean oRZ;
  public long oSr;
  public boolean oSs;
  public String value;
  
  static
  {
    GMTrace.i(13112132501504L, 97693);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(13112132501504L, 97693);
  }
  
  public KVReportDataInfo()
  {
    GMTrace.i(13111595630592L, 97689);
    GMTrace.o(13111595630592L, 97689);
  }
  
  protected KVReportDataInfo(Parcel paramParcel)
  {
    GMTrace.i(13111998283776L, 97692);
    this.oSr = paramParcel.readLong();
    this.value = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.oSs = bool1;
      if (paramParcel.readInt() != 1) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.oRZ = bool1;
      GMTrace.o(13111998283776L, 97692);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    GMTrace.i(13111729848320L, 97690);
    GMTrace.o(13111729848320L, 97690);
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    GMTrace.i(13111864066048L, 97691);
    paramParcel.writeLong(this.oSr);
    paramParcel.writeString(this.value);
    if (this.oSs)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.oRZ) {
        break label68;
      }
    }
    label68:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      GMTrace.o(13111864066048L, 97691);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/KVReportDataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */