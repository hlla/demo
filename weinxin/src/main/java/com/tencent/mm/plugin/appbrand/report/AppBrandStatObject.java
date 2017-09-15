package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;

public final class AppBrandStatObject
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandStatObject> CREATOR;
  public String appId;
  public String fCE;
  public int fWA;
  public int fWB;
  public String fWC;
  public transient String jeM;
  public int jeN;
  public int scene;
  
  static
  {
    GMTrace.i(10629909839872L, 79199);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(10629909839872L, 79199);
  }
  
  public AppBrandStatObject()
  {
    GMTrace.i(10629372968960L, 79195);
    GMTrace.o(10629372968960L, 79195);
  }
  
  protected AppBrandStatObject(Parcel paramParcel)
  {
    GMTrace.i(10629775622144L, 79198);
    this.appId = paramParcel.readString();
    this.fWB = paramParcel.readInt();
    this.fWC = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.fCE = paramParcel.readString();
    this.jeN = paramParcel.readInt();
    this.fWA = paramParcel.readInt();
    GMTrace.o(10629775622144L, 79198);
  }
  
  public final int describeContents()
  {
    GMTrace.i(10629507186688L, 79196);
    GMTrace.o(10629507186688L, 79196);
    return 0;
  }
  
  public final String toString()
  {
    GMTrace.i(16167464861696L, 120457);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appId : ").append(this.appId).append(",");
    ((StringBuilder)localObject).append("preScene : ").append(this.fWB).append(",");
    ((StringBuilder)localObject).append("preSceneNote : ").append(this.fWC).append(",");
    ((StringBuilder)localObject).append("scene : ").append(this.scene).append(",");
    ((StringBuilder)localObject).append("sceneNote : ").append(this.fCE).append(",");
    ((StringBuilder)localObject).append("usedState : ").append(this.jeN).append(",");
    localObject = ((StringBuilder)localObject).toString();
    GMTrace.o(16167464861696L, 120457);
    return (String)localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(10629641404416L, 79197);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.fWB);
    paramParcel.writeString(this.fWC);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.fCE);
    paramParcel.writeInt(this.jeN);
    paramParcel.writeInt(this.fWA);
    GMTrace.o(10629641404416L, 79197);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/appbrand/report/AppBrandStatObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */