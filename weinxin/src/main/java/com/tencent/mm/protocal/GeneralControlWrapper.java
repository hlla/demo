package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.sdk.platformtools.v;

public class GeneralControlWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<GeneralControlWrapper> CREATOR;
  public static final GeneralControlWrapper sXq;
  public static final GeneralControlWrapper sXr;
  public int sXs;
  
  static
  {
    GMTrace.i(4081829543936L, 30412);
    sXq = new GeneralControlWrapper(10);
    sXr = new GeneralControlWrapper(1);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(4081829543936L, 30412);
  }
  
  public GeneralControlWrapper(int paramInt)
  {
    GMTrace.i(4080621584384L, 30403);
    this.sXs = paramInt;
    v.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    GMTrace.o(4080621584384L, 30403);
  }
  
  public GeneralControlWrapper(Parcel paramParcel)
  {
    GMTrace.i(4081561108480L, 30410);
    this.sXs = paramParcel.readInt();
    GMTrace.o(4081561108480L, 30410);
  }
  
  public GeneralControlWrapper(tj paramtj)
  {
    GMTrace.i(4080487366656L, 30402);
    this.sXs = paramtj.tzH;
    v.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    GMTrace.o(4080487366656L, 30402);
  }
  
  public final boolean bGY()
  {
    GMTrace.i(17828409245696L, 132832);
    if ((this.sXs & 0x2000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = " + bool);
      GMTrace.o(17828409245696L, 132832);
      return bool;
    }
  }
  
  public final boolean bGZ()
  {
    GMTrace.i(4080755802112L, 30404);
    if ((this.sXs & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = " + bool);
      GMTrace.o(4080755802112L, 30404);
      return bool;
    }
  }
  
  public final boolean bHa()
  {
    GMTrace.i(4080890019840L, 30405);
    if ((this.sXs & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = " + bool);
      GMTrace.o(4080890019840L, 30405);
      return bool;
    }
  }
  
  public final boolean bHb()
  {
    GMTrace.i(4081024237568L, 30406);
    if ((this.sXs & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + bool);
      GMTrace.o(4081024237568L, 30406);
      return bool;
    }
  }
  
  public int describeContents()
  {
    GMTrace.i(4081292673024L, 30408);
    GMTrace.o(4081292673024L, 30408);
    return 0;
  }
  
  public String toString()
  {
    GMTrace.i(4081158455296L, 30407);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[bitset=0x");
    ((StringBuilder)localObject).append(Integer.toHexString(this.sXs));
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    GMTrace.o(4081158455296L, 30407);
    return (String)localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(4081426890752L, 30409);
    paramParcel.writeInt(this.sXs);
    GMTrace.o(4081426890752L, 30409);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/GeneralControlWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */