package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.dz;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class WxaAttributes
  extends dz
{
  public static final String iES;
  public static final c.a iFd;
  private a iFe;
  private b iFf;
  private c iFg;
  private List<WxaEntryInfo> iFh;
  
  static
  {
    GMTrace.i(15537983717376L, 115767);
    c.a locala = new c.a();
    locala.hXn = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "usernameHash";
    locala.uvr.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "usernameHash";
    locala.columns[1] = "username";
    locala.uvr.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.uvr.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "nickname";
    locala.uvr.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "brandIconURL";
    locala.uvr.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "roundedSquareIconURL";
    locala.uvr.put("roundedSquareIconURL", "TEXT");
    localStringBuilder.append(" roundedSquareIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "bigHeadURL";
    locala.uvr.put("bigHeadURL", "TEXT");
    localStringBuilder.append(" bigHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "smallHeadURL";
    locala.uvr.put("smallHeadURL", "TEXT");
    localStringBuilder.append(" smallHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "signature";
    locala.uvr.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "appOpt";
    locala.uvr.put("appOpt", "INTEGER default '0' ");
    localStringBuilder.append(" appOpt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "registerSource";
    locala.uvr.put("registerSource", "TEXT");
    localStringBuilder.append(" registerSource TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "appInfo";
    locala.uvr.put("appInfo", "TEXT");
    localStringBuilder.append(" appInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "versionInfo";
    locala.uvr.put("versionInfo", "TEXT");
    localStringBuilder.append(" versionInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "bindWxaInfo";
    locala.uvr.put("bindWxaInfo", "TEXT");
    localStringBuilder.append(" bindWxaInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "dynamicInfo";
    locala.uvr.put("dynamicInfo", "TEXT");
    localStringBuilder.append(" dynamicInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "reserved";
    locala.uvr.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "syncTimeSecond";
    locala.uvr.put("syncTimeSecond", "LONG default '0' ");
    localStringBuilder.append(" syncTimeSecond LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "syncVersion";
    locala.uvr.put("syncVersion", "TEXT");
    localStringBuilder.append(" syncVersion TEXT");
    locala.columns[18] = "rowid";
    locala.uvs = localStringBuilder.toString();
    iFd = locala;
    iES = i.a(locala, "WxaAttributesTable");
    GMTrace.o(15537983717376L, 115767);
  }
  
  public WxaAttributes()
  {
    GMTrace.i(15537178411008L, 115761);
    this.iFh = null;
    GMTrace.o(15537178411008L, 115761);
  }
  
  public final a RE()
  {
    GMTrace.i(15537446846464L, 115763);
    if ((this.iFe == null) && (!bf.mA(this.field_appInfo))) {}
    try
    {
      localObject = new JSONObject(this.field_appInfo);
      this.iFe = new a();
      JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("RunningFlagInfo");
      if (localJSONObject != null)
      {
        this.iFe.iBG = localJSONObject.optLong("RunningFlag");
        this.iFe.iFi = localJSONObject.optString("AppOpenForbiddenUrl");
      }
      localJSONObject = ((JSONObject)localObject).optJSONObject("Network");
      if (localJSONObject != null)
      {
        this.iFe.iFk = r.g(localJSONObject.optJSONArray("RequestDomain"));
        this.iFe.iFl = r.g(localJSONObject.optJSONArray("WsRequestDomain"));
        this.iFe.iFm = r.g(localJSONObject.optJSONArray("UploadDomain"));
        this.iFe.iFn = r.g(localJSONObject.optJSONArray("DownloadDomain"));
      }
      this.iFe.iFo = ((JSONObject)localObject).optString("Template");
      this.iFe.iFj = ((JSONObject)localObject).optInt("WechatPluginApp", 0);
      this.iFe.iFp = ((JSONObject)localObject).optString("fromBusinessUsername");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        this.iFe = null;
      }
    }
    localObject = this.iFe;
    GMTrace.o(15537446846464L, 115763);
    return (a)localObject;
  }
  
  public final b RF()
  {
    int i = 0;
    GMTrace.i(15537581064192L, 115764);
    if (this.iFf == null) {
      try
      {
        Object localObject1 = new JSONObject(this.field_dynamicInfo);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new JSONObject();
        }
        this.iFf = new b();
        Object localObject3 = ((JSONObject)localObject2).optJSONObject("NewSetting");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new JSONObject();
        }
        this.iFf.iFq.iFs = ((JSONObject)localObject1).optInt("MaxLocalstorageSize", 5);
        this.iFf.iFq.iFt = ((JSONObject)localObject1).optInt("MaxCodeSize", 5);
        this.iFf.iFq.iEo = ((JSONObject)localObject1).optInt("MaxWebviewDepth", 5);
        this.iFf.iFq.iEp = ((JSONObject)localObject1).optInt("MaxBackgroundLifespan", 600);
        this.iFf.iFq.iEq = ((JSONObject)localObject1).optInt("MaxRequestConcurrent", 5);
        this.iFf.iFq.iEr = ((JSONObject)localObject1).optInt("MaxUploadConcurrent", 5);
        this.iFf.iFq.iEs = ((JSONObject)localObject1).optInt("MaxDownloadConcurrent", 5);
        this.iFf.iFq.iFu = ((JSONObject)localObject1).optInt("MaxFileStorageSize", 10);
        this.iFf.iFq.iFv = ((JSONObject)localObject1).optInt("BackgroundNetworkInterruptedTimeout", 5);
        localObject3 = this.iFf.iFq;
        if (((JSONObject)localObject1).optInt("CanKeepAliveByAudioPlay", 0) > 0)
        {
          bool = true;
          ((WxaAttributes.b.a)localObject3).iEB = bool;
          this.iFf.iFq.iEC = ((JSONObject)localObject1).optInt("LifeSpanBeforeSuspend", 5);
          this.iFf.iFq.iED = ((JSONObject)localObject1).optInt("LifeSpanAfterSuspend", 300);
          localObject1 = ((JSONObject)localObject2).optJSONArray("NewCategories");
          if (localObject1 == null) {
            break label415;
          }
          this.iFf.iFr = new LinkedList();
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 != null) {
              this.iFf.iFr.add(new Pair(((JSONObject)localObject2).optString("first"), ((JSONObject)localObject2).optString("second")));
            }
            i += 1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localb = null;
          continue;
          boolean bool = false;
        }
      }
    }
    label415:
    b localb = this.iFf;
    GMTrace.o(15537581064192L, 115764);
    return localb;
  }
  
  public final c RG()
  {
    GMTrace.i(15537715281920L, 115765);
    if ((this.iFg == null) && (!bf.mA(this.field_versionInfo))) {}
    try
    {
      Object localObject = new JSONObject(this.field_versionInfo);
      this.iFg = new c();
      this.iFg.fWv = ((JSONObject)localObject).optInt("AppVersion", 0);
      this.iFg.iFw = ((JSONObject)localObject).optInt("VersionState", -1);
      this.iFg.iyf = ((JSONObject)localObject).optString("VersionMD5");
      localObject = this.iFg;
      GMTrace.o(15537715281920L, 115765);
      return (c)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.iFg = null;
      }
    }
  }
  
  public final List<WxaEntryInfo> RH()
  {
    GMTrace.i(15537849499648L, 115766);
    if ((this.iFh == null) && (!bf.mA(this.field_bindWxaInfo))) {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
        if (localJSONArray != null)
        {
          this.iFh = new LinkedList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              String str = localJSONObject.optString("username");
              if (!bf.mA(str))
              {
                WxaEntryInfo localWxaEntryInfo = new WxaEntryInfo();
                localWxaEntryInfo.username = str;
                localWxaEntryInfo.title = localJSONObject.optString("title");
                localWxaEntryInfo.iconUrl = localJSONObject.optString("icon_url");
                this.iFh.add(localWxaEntryInfo);
              }
            }
            i += 1;
          }
        }
        localList = this.iFh;
      }
      catch (Exception localException)
      {
        this.iFh = null;
      }
    }
    List localList;
    GMTrace.o(15537849499648L, 115766);
    return localList;
  }
  
  protected final c.a sY()
  {
    GMTrace.i(15537312628736L, 115762);
    c.a locala = iFd;
    GMTrace.o(15537312628736L, 115762);
    return locala;
  }
  
  public final String toString()
  {
    GMTrace.i(18659485417472L, 139024);
    String str = "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_brandIconURL='" + this.field_brandIconURL + '\'' + ", field_roundedSquareIconURL='" + this.field_roundedSquareIconURL + '\'' + ", field_bigHeadURL='" + this.field_bigHeadURL + '\'' + ", field_smallHeadURL='" + this.field_smallHeadURL + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_appOpt=" + this.field_appOpt + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + '}';
    GMTrace.o(18659485417472L, 139024);
    return str;
  }
  
  public static final class WxaEntryInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaEntryInfo> CREATOR;
    public String hvg;
    public String iconUrl;
    public String title;
    public String username;
    
    static
    {
      GMTrace.i(17509910577152L, 130459);
      CREATOR = new Parcelable.Creator() {};
      GMTrace.o(17509910577152L, 130459);
    }
    
    public WxaEntryInfo()
    {
      GMTrace.i(17509642141696L, 130457);
      GMTrace.o(17509642141696L, 130457);
    }
    
    protected WxaEntryInfo(Parcel paramParcel)
    {
      GMTrace.i(17509776359424L, 130458);
      this.username = paramParcel.readString();
      this.title = paramParcel.readString();
      this.hvg = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      GMTrace.o(17509776359424L, 130458);
    }
    
    public final int describeContents()
    {
      GMTrace.i(17509373706240L, 130455);
      GMTrace.o(17509373706240L, 130455);
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      GMTrace.i(17509507923968L, 130456);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.hvg);
      paramParcel.writeString(this.iconUrl);
      GMTrace.o(17509507923968L, 130456);
    }
  }
  
  public static final class a
  {
    public long iBG;
    public String iFi;
    public int iFj;
    public List<String> iFk;
    public List<String> iFl;
    public List<String> iFm;
    public List<String> iFn;
    public String iFo;
    public String iFp;
    
    public a()
    {
      GMTrace.i(15536775757824L, 115758);
      this.iBG = 0L;
      this.iFj = 0;
      GMTrace.o(15536775757824L, 115758);
    }
  }
  
  public static final class b
  {
    public a iFq;
    public List<Pair<String, String>> iFr;
    
    public b()
    {
      GMTrace.i(15539325894656L, 115777);
      this.iFq = new a();
      GMTrace.o(15539325894656L, 115777);
    }
    
    public static final class a
    {
      public boolean iEB;
      public int iEC;
      public int iED;
      public int iEo;
      public int iEp;
      public int iEq;
      public int iEr;
      public int iEs;
      public int iFs;
      public int iFt;
      public int iFu;
      public int iFv;
      
      public a()
      {
        GMTrace.i(15539728547840L, 115780);
        GMTrace.o(15539728547840L, 115780);
      }
    }
  }
  
  public static final class c
  {
    public int fWv;
    public int iFw;
    public String iyf;
    
    public c()
    {
      GMTrace.i(15539460112384L, 115778);
      GMTrace.o(15539460112384L, 115778);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/appbrand/config/WxaAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */