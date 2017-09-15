package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;

public final class LaunchParamsOptional
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParamsOptional> CREATOR;
  public String hpB;
  public String hpC;
  
  static
  {
    GMTrace.i(14411896979456L, 107377);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(14411896979456L, 107377);
  }
  
  public LaunchParamsOptional()
  {
    GMTrace.i(14411628544000L, 107375);
    GMTrace.o(14411628544000L, 107375);
  }
  
  public LaunchParamsOptional(Parcel paramParcel)
  {
    GMTrace.i(14411762761728L, 107376);
    this.hpB = paramParcel.readString();
    this.hpC = paramParcel.readString();
    GMTrace.o(14411762761728L, 107376);
  }
  
  public final int describeContents()
  {
    GMTrace.i(14411360108544L, 107373);
    GMTrace.o(14411360108544L, 107373);
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(14411494326272L, 107374);
    paramParcel.writeString(this.hpB);
    paramParcel.writeString(this.hpC);
    GMTrace.o(14411494326272L, 107374);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelappbrand/LaunchParamsOptional.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */