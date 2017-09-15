package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;

public class WxaExposedParams
  implements Parcelable
{
  public static final Parcelable.Creator<WxaExposedParams> CREATOR;
  public String appId;
  public String fER;
  public int fFi;
  public String iFx;
  public String iFy;
  public String iFz;
  public String iconUrl;
  public int izA;
  public int izB;
  public String username;
  
  static
  {
    GMTrace.i(18660961812480L, 139035);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(18660961812480L, 139035);
  }
  
  protected WxaExposedParams(Parcel paramParcel)
  {
    GMTrace.i(18660424941568L, 139031);
    this.appId = paramParcel.readString();
    this.username = paramParcel.readString();
    this.fER = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.izA = paramParcel.readInt();
    this.izB = paramParcel.readInt();
    this.iFx = paramParcel.readString();
    this.fFi = paramParcel.readInt();
    this.iFy = paramParcel.readString();
    this.iFz = paramParcel.readString();
    GMTrace.o(18660424941568L, 139031);
  }
  
  public WxaExposedParams(a parama)
  {
    GMTrace.i(18660290723840L, 139030);
    this.appId = parama.appId;
    this.username = parama.username;
    this.fER = parama.fER;
    this.iconUrl = parama.iconUrl;
    this.izA = parama.izA;
    this.izB = parama.izB;
    this.iFx = parama.iFx;
    this.fFi = parama.fFi;
    this.iFy = parama.iFy;
    this.iFz = parama.iFz;
    GMTrace.o(18660290723840L, 139030);
  }
  
  public int describeContents()
  {
    GMTrace.i(18660693377024L, 139033);
    GMTrace.o(18660693377024L, 139033);
    return 0;
  }
  
  public String toString()
  {
    GMTrace.i(18660827594752L, 139034);
    String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.fER + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.izA + ", pkgVersion=" + this.izB + ", pkgMD5='" + this.iFx + '\'' + ", from=" + this.fFi + ", pageId='" + this.iFy + '\'' + ", errorUrl='" + this.iFz + '\'' + '}';
    GMTrace.o(18660827594752L, 139034);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(18660559159296L, 139032);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.fER);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.izA);
    paramParcel.writeInt(this.izB);
    paramParcel.writeString(this.iFx);
    paramParcel.writeInt(this.fFi);
    paramParcel.writeString(this.iFy);
    paramParcel.writeString(this.iFz);
    GMTrace.o(18660559159296L, 139032);
  }
  
  public static final class a
  {
    public String appId;
    public String fER;
    public int fFi;
    public String iFx;
    public String iFy;
    public String iFz;
    public String iconUrl;
    public int izA;
    public int izB;
    public String username;
    
    public a()
    {
      GMTrace.i(18659619635200L, 139025);
      this.appId = "";
      this.username = "";
      this.fER = "";
      this.iconUrl = "";
      this.izB = -1;
      this.izA = -1;
      this.iFx = "";
      this.fFi = 0;
      this.iFy = "";
      this.iFz = "";
      GMTrace.o(18659619635200L, 139025);
    }
    
    public final WxaExposedParams RI()
    {
      GMTrace.i(18659753852928L, 139026);
      WxaExposedParams localWxaExposedParams = new WxaExposedParams(this);
      GMTrace.o(18659753852928L, 139026);
      return localWxaExposedParams;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/appbrand/config/WxaExposedParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */