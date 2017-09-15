package com.tencent.mm.pluginsdk.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;

public class PayInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PayInfo> CREATOR;
  public String appId;
  public String fFR;
  public String fJy;
  public int fLJ;
  public String fLL;
  public String fLM;
  public String fOW;
  public String fQU;
  public int fRh;
  public int fRl;
  public int fRm;
  public String iAN;
  public String kck;
  public String mpX;
  public boolean mpc;
  public String partnerId;
  public String rOg;
  public int sWA;
  public int sWB;
  public long sWC;
  public int sWD;
  public String sWE;
  public String sWF;
  public int sWG;
  public int sWu;
  public boolean sWv;
  public String sWw;
  public String sWx;
  public Bundle sWy;
  public int sWz;
  
  static
  {
    GMTrace.i(1229434388480L, 9160);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(1229434388480L, 9160);
  }
  
  public PayInfo()
  {
    GMTrace.i(1228763299840L, 9155);
    this.fRm = -1;
    this.fRl = 0;
    this.sWu = 0;
    this.mpc = false;
    this.sWv = true;
    this.sWz = 0;
    this.sWA = 0;
    this.sWC = 0L;
    this.fQU = "";
    this.sWD = -1;
    this.sWG = 1;
    GMTrace.o(1228763299840L, 9155);
  }
  
  public PayInfo(Parcel paramParcel)
  {
    GMTrace.i(1228897517568L, 9156);
    this.fRm = -1;
    this.fRl = 0;
    this.sWu = 0;
    this.mpc = false;
    this.sWv = true;
    this.sWz = 0;
    this.sWA = 0;
    this.sWC = 0L;
    this.fQU = "";
    this.sWD = -1;
    this.sWG = 1;
    this.fRl = paramParcel.readInt();
    this.sWu = paramParcel.readInt();
    this.fJy = paramParcel.readString();
    this.mpX = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.rOg = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.sWw = paramParcel.readString();
    this.fFR = paramParcel.readString();
    this.fOW = paramParcel.readString();
    this.fRh = paramParcel.readInt();
    this.fRm = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.mpc = bool1;
      if (paramParcel.readInt() != 1) {
        break label308;
      }
    }
    label308:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.sWv = bool1;
      this.sWy = paramParcel.readBundle();
      this.sWz = paramParcel.readInt();
      this.fLL = paramParcel.readString();
      this.fLM = paramParcel.readString();
      this.fLJ = paramParcel.readInt();
      this.sWC = paramParcel.readLong();
      this.fQU = paramParcel.readString();
      this.sWE = paramParcel.readString();
      this.sWF = paramParcel.readString();
      this.sWG = paramParcel.readInt();
      this.kck = paramParcel.readString();
      this.iAN = paramParcel.readString();
      GMTrace.o(1228897517568L, 9156);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    GMTrace.i(1229031735296L, 9157);
    GMTrace.o(1229031735296L, 9157);
    return 0;
  }
  
  public String toString()
  {
    GMTrace.i(1229300170752L, 9159);
    String str = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[] { Integer.valueOf(this.fRl), this.fJy, this.mpX, this.appId, this.rOg, this.partnerId, this.sWw, this.fFR, this.fQU });
    GMTrace.o(1229300170752L, 9159);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    GMTrace.i(1229165953024L, 9158);
    paramParcel.writeInt(this.fRl);
    paramParcel.writeInt(this.sWu);
    paramParcel.writeString(this.fJy);
    paramParcel.writeString(this.mpX);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.rOg);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.sWw);
    paramParcel.writeString(this.fFR);
    paramParcel.writeString(this.fOW);
    paramParcel.writeInt(this.fRh);
    paramParcel.writeInt(this.fRm);
    if (this.mpc)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.sWv) {
        break label246;
      }
    }
    label246:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.sWy);
      paramParcel.writeInt(this.sWz);
      paramParcel.writeString(this.fLL);
      paramParcel.writeString(this.fLM);
      paramParcel.writeInt(this.fLJ);
      paramParcel.writeLong(this.sWC);
      paramParcel.writeString(this.fQU);
      paramParcel.writeString(this.sWE);
      paramParcel.writeString(this.sWF);
      paramParcel.writeInt(this.sWG);
      paramParcel.writeString(this.kck);
      paramParcel.writeString(this.iAN);
      GMTrace.o(1229165953024L, 9158);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/wallet/PayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */