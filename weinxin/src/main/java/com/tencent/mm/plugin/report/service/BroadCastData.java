package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;
import java.util.ArrayList;

class BroadCastData
  implements Parcelable
{
  public static final Parcelable.Creator<BroadCastData> CREATOR;
  ArrayList<KVReportDataInfo> oRV;
  ArrayList<StIDKeyDataInfo> oRW;
  ArrayList<GroupIDKeyDataInfo> oRX;
  
  static
  {
    GMTrace.i(13115890597888L, 97721);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(13115890597888L, 97721);
  }
  
  public BroadCastData()
  {
    GMTrace.i(13115219509248L, 97716);
    this.oRV = new ArrayList();
    this.oRW = new ArrayList();
    this.oRX = new ArrayList();
    GMTrace.o(13115219509248L, 97716);
  }
  
  protected BroadCastData(Parcel paramParcel)
  {
    GMTrace.i(13115487944704L, 97718);
    this.oRV = new ArrayList();
    this.oRW = new ArrayList();
    this.oRX = new ArrayList();
    paramParcel.readTypedList(this.oRV, KVReportDataInfo.CREATOR);
    paramParcel.readTypedList(this.oRW, StIDKeyDataInfo.CREATOR);
    paramParcel.readTypedList(this.oRX, GroupIDKeyDataInfo.CREATOR);
    GMTrace.o(13115487944704L, 97718);
  }
  
  public BroadCastData(BroadCastData paramBroadCastData)
  {
    GMTrace.i(13115353726976L, 97717);
    this.oRV = new ArrayList();
    this.oRW = new ArrayList();
    this.oRX = new ArrayList();
    if (paramBroadCastData == null)
    {
      GMTrace.o(13115353726976L, 97717);
      return;
    }
    this.oRV = new ArrayList(paramBroadCastData.oRV);
    this.oRW = new ArrayList(paramBroadCastData.oRW);
    this.oRX = new ArrayList(paramBroadCastData.oRX);
    GMTrace.o(13115353726976L, 97717);
  }
  
  public int describeContents()
  {
    GMTrace.i(13115622162432L, 97719);
    GMTrace.o(13115622162432L, 97719);
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(13115756380160L, 97720);
    paramParcel.writeTypedList(this.oRV);
    paramParcel.writeTypedList(this.oRW);
    paramParcel.writeTypedList(this.oRX);
    GMTrace.o(13115756380160L, 97720);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/BroadCastData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */