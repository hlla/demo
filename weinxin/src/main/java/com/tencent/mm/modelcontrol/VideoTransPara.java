package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;

public class VideoTransPara
  implements Parcelable
{
  public static final Parcelable.Creator<VideoTransPara> CREATOR;
  public int audioSampleRate;
  public int duration;
  public int gPu;
  public int height;
  public int hzG;
  public int hzH;
  public int hzt;
  public int hzu;
  public int hzv;
  public int hzw;
  public boolean isDefault;
  public int width;
  
  static
  {
    GMTrace.i(4103975469056L, 30577);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(4103975469056L, 30577);
  }
  
  public VideoTransPara()
  {
    GMTrace.i(4103304380416L, 30572);
    this.hzH = 0;
    GMTrace.o(4103304380416L, 30572);
  }
  
  protected VideoTransPara(Parcel paramParcel)
  {
    GMTrace.i(4103438598144L, 30573);
    this.hzH = 0;
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.gPu = paramParcel.readInt();
    this.hzG = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.hzu = paramParcel.readInt();
    this.hzt = paramParcel.readInt();
    this.audioSampleRate = paramParcel.readInt();
    this.hzv = paramParcel.readInt();
    this.hzw = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {
      bool = true;
    }
    this.isDefault = bool;
    this.hzH = paramParcel.readInt();
    GMTrace.o(4103438598144L, 30573);
  }
  
  public int describeContents()
  {
    GMTrace.i(4103707033600L, 30575);
    GMTrace.o(4103707033600L, 30575);
    return 0;
  }
  
  public String toString()
  {
    GMTrace.i(4103841251328L, 30576);
    String str = "[isDefault " + this.isDefault + "width " + this.width + " height " + this.height + " fps " + this.gPu + " video bitrate " + this.hzG + " iFrame " + this.hzu + " audio bitrate " + this.hzt + " audioSampleRate " + this.audioSampleRate + " duration " + this.duration + " profile index " + this.hzv + " preset index " + this.hzw + " thumbSize " + this.hzH + "]";
    GMTrace.o(4103841251328L, 30576);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(4103572815872L, 30574);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.gPu);
    paramParcel.writeInt(this.hzG);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.hzu);
    paramParcel.writeInt(this.hzt);
    paramParcel.writeInt(this.audioSampleRate);
    paramParcel.writeInt(this.hzv);
    paramParcel.writeInt(this.hzw);
    if (this.isDefault) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hzH);
      GMTrace.o(4103572815872L, 30574);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcontrol/VideoTransPara.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */