package com.tencent.mm.ui.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR;
  final String mMessage;
  final String whC;
  final int whD;
  final Parcelable whE;
  final short whF;
  final int whG;
  
  static
  {
    GMTrace.i(2864877404160L, 21345);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(2864877404160L, 21345);
  }
  
  Snack(Parcel paramParcel)
  {
    GMTrace.i(2864474750976L, 21342);
    this.mMessage = paramParcel.readString();
    this.whC = paramParcel.readString();
    this.whD = paramParcel.readInt();
    this.whE = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.whF = ((short)paramParcel.readInt());
    this.whG = ((Integer)paramParcel.readParcelable(paramParcel.getClass().getClassLoader())).intValue();
    GMTrace.o(2864474750976L, 21342);
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    GMTrace.i(2864340533248L, 21341);
    this.mMessage = paramString1;
    this.whC = paramString2;
    this.whD = paramInt1;
    this.whE = paramParcelable;
    this.whF = paramShort;
    this.whG = paramInt2;
    GMTrace.o(2864340533248L, 21341);
  }
  
  public int describeContents()
  {
    GMTrace.i(2864743186432L, 21344);
    GMTrace.o(2864743186432L, 21344);
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(2864608968704L, 21343);
    paramParcel.writeString(this.mMessage);
    paramParcel.writeString(this.whC);
    paramParcel.writeInt(this.whD);
    paramParcel.writeParcelable(this.whE, 0);
    paramParcel.writeInt(this.whF);
    paramParcel.writeInt(this.whG);
    GMTrace.o(2864608968704L, 21343);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/snackbar/Snack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */