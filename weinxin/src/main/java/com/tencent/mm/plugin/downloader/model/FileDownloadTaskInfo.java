package com.tencent.mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;

public class FileDownloadTaskInfo
  implements Parcelable
{
  public static Parcelable.Creator<FileDownloadTaskInfo> CREATOR;
  public String appId;
  public String fFN;
  public long fKX;
  public long fKY;
  public int fLx;
  public long id;
  public boolean kFr;
  public String path;
  public int status;
  public String url;
  
  static
  {
    GMTrace.i(18602040229888L, 138596);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(18602040229888L, 138596);
  }
  
  public FileDownloadTaskInfo()
  {
    GMTrace.i(18601771794432L, 138594);
    this.id = -1L;
    this.url = "";
    this.status = 0;
    this.path = "";
    this.fFN = "";
    this.appId = "";
    this.fKX = 0L;
    this.fKY = 0L;
    this.kFr = false;
    this.fLx = 2;
    GMTrace.o(18601771794432L, 138594);
  }
  
  public FileDownloadTaskInfo(Parcel paramParcel)
  {
    GMTrace.i(18601906012160L, 138595);
    this.id = -1L;
    this.url = "";
    this.status = 0;
    this.path = "";
    this.fFN = "";
    this.appId = "";
    this.fKX = 0L;
    this.fKY = 0L;
    this.kFr = false;
    this.fLx = 2;
    this.id = paramParcel.readLong();
    this.url = paramParcel.readString();
    this.status = paramParcel.readInt();
    this.path = paramParcel.readString();
    this.fFN = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.fKX = paramParcel.readLong();
    this.fKY = paramParcel.readLong();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.kFr = bool;
      this.fLx = paramParcel.readInt();
      GMTrace.o(18601906012160L, 138595);
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    GMTrace.i(18601503358976L, 138592);
    GMTrace.o(18601503358976L, 138592);
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(18601637576704L, 138593);
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.status);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.fFN);
    paramParcel.writeString(this.appId);
    paramParcel.writeLong(this.fKX);
    paramParcel.writeLong(this.fKY);
    if (this.kFr) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.fLx);
      GMTrace.o(18601637576704L, 138593);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/model/FileDownloadTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */