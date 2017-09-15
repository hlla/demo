package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.storage.t;

public class SightParams
  implements Parcelable
{
  public static final Parcelable.Creator<SightParams> CREATOR;
  public int mode;
  public int nzc;
  public VideoTransPara nzd;
  public String nze;
  public String nzf;
  public String nzg;
  public String nzh;
  public String nzi;
  public boolean nzj;
  public int nzk;
  public int scene;
  
  static
  {
    GMTrace.i(18677873246208L, 139161);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(18677873246208L, 139161);
  }
  
  public SightParams(int paramInt1, int paramInt2)
  {
    GMTrace.i(18677202157568L, 139156);
    this.mode = 0;
    this.nzc = 2;
    this.nze = "";
    this.nzf = "";
    this.nzg = "";
    this.nzh = "";
    this.nzi = "";
    this.nzj = true;
    this.scene = -1;
    if (paramInt1 == 1) {
      this.nzd = d.Ev().Ew();
    }
    for (;;)
    {
      this.scene = paramInt1;
      this.mode = paramInt2;
      h.vJ();
      this.nzk = ((Integer)h.vI().vr().get(344066, Integer.valueOf(0))).intValue();
      GMTrace.o(18677202157568L, 139156);
      return;
      if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
        this.nzd = d.Ev().Ex();
      } else {
        this.nzd = d.Ev().Ex();
      }
    }
  }
  
  protected SightParams(Parcel paramParcel)
  {
    GMTrace.i(18677336375296L, 139157);
    this.mode = 0;
    this.nzc = 2;
    this.nze = "";
    this.nzf = "";
    this.nzg = "";
    this.nzh = "";
    this.nzi = "";
    this.nzj = true;
    this.scene = -1;
    this.mode = paramParcel.readInt();
    this.nzd = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.nze = paramParcel.readString();
    this.nzf = paramParcel.readString();
    this.nzg = paramParcel.readString();
    this.nzh = paramParcel.readString();
    this.nzk = paramParcel.readInt();
    this.nzc = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.nzj = bool;
      this.scene = paramParcel.readInt();
      GMTrace.o(18677336375296L, 139157);
      return;
    }
  }
  
  public int describeContents()
  {
    GMTrace.i(18677604810752L, 139159);
    GMTrace.o(18677604810752L, 139159);
    return 0;
  }
  
  public final SightParams h(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    GMTrace.i(18677470593024L, 139158);
    this.nzg = paramString1;
    this.nze = paramString2;
    this.nzf = paramString3;
    this.nzh = paramString4;
    GMTrace.o(18677470593024L, 139158);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(18677739028480L, 139160);
    paramParcel.writeInt(this.mode);
    paramParcel.writeParcelable(this.nzd, paramInt);
    paramParcel.writeString(this.nze);
    paramParcel.writeString(this.nzf);
    paramParcel.writeString(this.nzg);
    paramParcel.writeString(this.nzh);
    paramParcel.writeInt(this.nzk);
    paramParcel.writeInt(this.nzc);
    if (this.nzj) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.scene);
      GMTrace.o(18677739028480L, 139160);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/mmsight/SightParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */