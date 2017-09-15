package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.IDKey;
import java.util.ArrayList;

class GroupIDKeyDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GroupIDKeyDataInfo> CREATOR;
  ArrayList<IDKey> oRY;
  public boolean oRZ;
  
  static
  {
    GMTrace.i(13120588218368L, 97756);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(13120588218368L, 97756);
  }
  
  protected GroupIDKeyDataInfo(Parcel paramParcel)
  {
    GMTrace.i(13120454000640L, 97755);
    this.oRY = new ArrayList();
    paramParcel.readTypedList(this.oRY, IDKey.CREATOR);
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.oRZ = bool;
      GMTrace.o(13120454000640L, 97755);
      return;
      bool = false;
    }
  }
  
  GroupIDKeyDataInfo(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    GMTrace.i(13120051347456L, 97752);
    this.oRY = new ArrayList();
    this.oRY = paramArrayList;
    this.oRZ = false;
    GMTrace.o(13120051347456L, 97752);
  }
  
  public int describeContents()
  {
    GMTrace.i(13120185565184L, 97753);
    GMTrace.o(13120185565184L, 97753);
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(13120319782912L, 97754);
    paramParcel.writeTypedList(this.oRY);
    if (this.oRZ) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      GMTrace.o(13120319782912L, 97754);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/GroupIDKeyDataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */