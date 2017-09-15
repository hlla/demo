package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.sdk.platformtools.v;

public class SightCaptureResult
  implements Parcelable
{
  public static final Parcelable.Creator<SightCaptureResult> CREATOR;
  public boolean nyS;
  public boolean nyT;
  public boolean nyU;
  public String nyV;
  public String nyW;
  public String nyX;
  public String nyY;
  public int nyZ;
  public akp nza;
  public String nzb;
  
  static
  {
    GMTrace.i(18675859980288L, 139146);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(18675859980288L, 139146);
  }
  
  protected SightCaptureResult(Parcel paramParcel)
  {
    GMTrace.i(18675457327104L, 139143);
    this.nyS = false;
    this.nyT = false;
    this.nyU = true;
    this.nyV = "";
    this.nyW = "";
    this.nyX = "";
    this.nyY = "";
    this.nyZ = 0;
    this.nza = new akp();
    this.nzb = "";
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.nyS = bool;
      if (paramParcel.readByte() == 0) {
        break label209;
      }
      bool = true;
      label96:
      this.nyT = bool;
      if (paramParcel.readByte() == 0) {
        break label214;
      }
    }
    label209:
    label214:
    for (boolean bool = true;; bool = false)
    {
      this.nyU = bool;
      this.nyV = paramParcel.readString();
      this.nyW = paramParcel.readString();
      this.nyX = paramParcel.readString();
      this.nyY = paramParcel.readString();
      this.nyZ = paramParcel.readInt();
      this.nzb = paramParcel.readString();
      try
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.nza = new akp();
        this.nza.aD(arrayOfByte);
        GMTrace.o(18675457327104L, 139143);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.SightCaptureResult", "read ext info error: %s", new Object[] { paramParcel.getMessage() });
        GMTrace.o(18675457327104L, 139143);
      }
      bool = false;
      break;
      bool = false;
      break label96;
    }
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString)
  {
    GMTrace.i(18675323109376L, 139142);
    this.nyS = false;
    this.nyT = false;
    this.nyU = true;
    this.nyV = "";
    this.nyW = "";
    this.nyX = "";
    this.nyY = "";
    this.nyZ = 0;
    this.nza = new akp();
    this.nzb = "";
    this.nyU = paramBoolean;
    this.nzb = paramString;
    this.nyS = false;
    this.nyT = true;
    GMTrace.o(18675323109376L, 139142);
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, akp paramakp)
  {
    GMTrace.i(18675188891648L, 139141);
    this.nyS = false;
    this.nyT = false;
    this.nyU = true;
    this.nyV = "";
    this.nyW = "";
    this.nyX = "";
    this.nyY = "";
    this.nyZ = 0;
    this.nza = new akp();
    this.nzb = "";
    this.nyU = paramBoolean;
    this.nyV = paramString1;
    this.nyW = paramString2;
    this.nyX = paramString3;
    this.nyZ = paramInt;
    this.nza = paramakp;
    this.nyY = paramString4;
    this.nyS = true;
    this.nyT = false;
    GMTrace.o(18675188891648L, 139141);
  }
  
  public int describeContents()
  {
    GMTrace.i(18675591544832L, 139144);
    GMTrace.o(18675591544832L, 139144);
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    GMTrace.i(18675725762560L, 139145);
    if (this.nyS)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.nyT) {
        break label139;
      }
      paramInt = 1;
      label34:
      paramParcel.writeByte((byte)paramInt);
      if (!this.nyU) {
        break label144;
      }
    }
    label139:
    label144:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.nyV);
      paramParcel.writeString(this.nyW);
      paramParcel.writeString(this.nyX);
      paramParcel.writeString(this.nyY);
      paramParcel.writeInt(this.nyZ);
      paramParcel.writeString(this.nzb);
      try
      {
        byte[] arrayOfByte = this.nza.toByteArray();
        paramParcel.writeInt(arrayOfByte.length);
        paramParcel.writeByteArray(arrayOfByte);
        GMTrace.o(18675725762560L, 139145);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.SightCaptureResult", "write ext info error");
        GMTrace.o(18675725762560L, 139145);
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label34;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/mmsight/SightCaptureResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */