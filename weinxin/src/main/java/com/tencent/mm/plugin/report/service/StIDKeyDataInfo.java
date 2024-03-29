package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;

class StIDKeyDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<StIDKeyDataInfo> CREATOR;
  public long key;
  public boolean oRZ;
  public long oST;
  public long value;
  
  static
  {
    GMTrace.i(13113206243328L, 97701);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(13113206243328L, 97701);
  }
  
  public StIDKeyDataInfo()
  {
    GMTrace.i(13112937807872L, 97699);
    GMTrace.o(13112937807872L, 97699);
  }
  
  protected StIDKeyDataInfo(Parcel paramParcel)
  {
    GMTrace.i(13113072025600L, 97700);
    this.oST = paramParcel.readLong();
    this.key = paramParcel.readLong();
    this.value = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.oRZ = bool;
      GMTrace.o(13113072025600L, 97700);
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    GMTrace.i(13112669372416L, 97697);
    GMTrace.o(13112669372416L, 97697);
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(13112803590144L, 97698);
    paramParcel.writeLong(this.oST);
    paramParcel.writeLong(this.key);
    paramParcel.writeLong(this.value);
    if (this.oRZ) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      GMTrace.o(13112803590144L, 97698);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/StIDKeyDataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */