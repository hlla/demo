package com.tencent.mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.n;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bf;
import java.lang.reflect.Field;
import java.util.Map;

public class f
  extends n
{
  protected static c.a gTF;
  public static String sBA;
  public static String sBx;
  public static String sBy;
  public static String sBz;
  
  static
  {
    GMTrace.i(814164738048L, 6066);
    sBx = "wxce6f23b478a3a2a2";
    sBy = "wx7302cee7c7d6d7d6";
    sBz = "wx6fa7e3bab7e15415";
    sBA = "wx3cc22b542de028d4";
    c.a locala = new c.a();
    locala.hXn = new Field[26];
    locala.columns = new String[27];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.uvr.put("appId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "appId";
    locala.columns[1] = "appName";
    locala.uvr.put("appName", "TEXT");
    localStringBuilder.append(" appName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appDiscription";
    locala.uvr.put("appDiscription", "TEXT");
    localStringBuilder.append(" appDiscription TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "appIconUrl";
    locala.uvr.put("appIconUrl", "TEXT");
    localStringBuilder.append(" appIconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "appStoreUrl";
    locala.uvr.put("appStoreUrl", "TEXT");
    localStringBuilder.append(" appStoreUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "appVersion";
    locala.uvr.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "appWatermarkUrl";
    locala.uvr.put("appWatermarkUrl", "TEXT");
    localStringBuilder.append(" appWatermarkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "packageName";
    locala.uvr.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.uvr.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "signature";
    locala.uvr.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "modifyTime";
    locala.uvr.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "appName_en";
    locala.uvr.put("appName_en", "TEXT");
    localStringBuilder.append(" appName_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "appName_tw";
    locala.uvr.put("appName_tw", "TEXT");
    localStringBuilder.append(" appName_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "appName_hk";
    locala.uvr.put("appName_hk", "TEXT");
    localStringBuilder.append(" appName_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "appDiscription_en";
    locala.uvr.put("appDiscription_en", "TEXT");
    localStringBuilder.append(" appDiscription_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "appDiscription_tw";
    locala.uvr.put("appDiscription_tw", "TEXT");
    localStringBuilder.append(" appDiscription_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "appType";
    locala.uvr.put("appType", "TEXT");
    localStringBuilder.append(" appType TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "openId";
    locala.uvr.put("openId", "TEXT");
    localStringBuilder.append(" openId TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "authFlag";
    locala.uvr.put("authFlag", "INTEGER");
    localStringBuilder.append(" authFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "appInfoFlag";
    locala.uvr.put("appInfoFlag", "INTEGER default '-1' ");
    localStringBuilder.append(" appInfoFlag INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "lvbuff";
    locala.uvr.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[21] = "serviceAppType";
    locala.uvr.put("serviceAppType", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "serviceAppInfoFlag";
    locala.uvr.put("serviceAppInfoFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppInfoFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "serviceShowFlag";
    locala.uvr.put("serviceShowFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceShowFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[24] = "appSupportContentType";
    locala.uvr.put("appSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" appSupportContentType LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[25] = "svrAppSupportContentType";
    locala.uvr.put("svrAppSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" svrAppSupportContentType LONG default '0' ");
    locala.columns[26] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(814164738048L, 6066);
  }
  
  public f()
  {
    GMTrace.i(813090996224L, 6058);
    this.field_appId = "";
    this.field_appName = "";
    this.field_appDiscription = "";
    this.field_appIconUrl = "";
    this.field_appStoreUrl = "";
    this.field_appVersion = 0;
    this.field_appWatermarkUrl = "";
    this.field_packageName = "";
    this.field_status = 4;
    this.field_signature = "";
    this.field_modifyTime = 0L;
    this.field_appName_en = "";
    this.field_appName_tw = "";
    this.field_appName_hk = "";
    this.field_appDiscription_en = "";
    this.field_appDiscription_tw = "";
    this.field_appInfoFlag = 0;
    this.field_appType = "";
    this.field_openId = "";
    this.field_authFlag = 0;
    this.field_appInfoFlag = 0;
    bC("");
    bB("");
    bD("");
    bH("");
    bI("");
    bJ("");
    GMTrace.o(813090996224L, 6058);
  }
  
  public final boolean bCM()
  {
    GMTrace.i(813225213952L, 6059);
    if (bf.mA(this.field_appType))
    {
      GMTrace.o(813225213952L, 6059);
      return false;
    }
    String[] arrayOfString = this.field_appType.split(",");
    if ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      GMTrace.o(813225213952L, 6059);
      return false;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals("1"))
      {
        GMTrace.o(813225213952L, 6059);
        return true;
      }
      i += 1;
    }
    GMTrace.o(813225213952L, 6059);
    return false;
  }
  
  public final boolean bCN()
  {
    GMTrace.i(813359431680L, 6060);
    if (this.field_serviceAppType == 0)
    {
      GMTrace.o(813359431680L, 6060);
      return false;
    }
    GMTrace.o(813359431680L, 6060);
    return true;
  }
  
  public final boolean bCO()
  {
    GMTrace.i(813493649408L, 6061);
    if ((this.field_serviceAppInfoFlag & 0x2) != 0)
    {
      GMTrace.o(813493649408L, 6061);
      return true;
    }
    GMTrace.o(813493649408L, 6061);
    return false;
  }
  
  public final boolean bCP()
  {
    GMTrace.i(813627867136L, 6062);
    if (sBy.equals(this.field_appId))
    {
      GMTrace.o(813627867136L, 6062);
      return true;
    }
    GMTrace.o(813627867136L, 6062);
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    GMTrace.i(813896302592L, 6064);
    if (paramObject == null)
    {
      GMTrace.o(813896302592L, 6064);
      return false;
    }
    if (paramObject == this)
    {
      GMTrace.o(813896302592L, 6064);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      GMTrace.o(813896302592L, 6064);
      return false;
    }
    boolean bool = ((f)paramObject).field_appId.equals(this.field_appId);
    GMTrace.o(813896302592L, 6064);
    return bool;
  }
  
  public int hashCode()
  {
    GMTrace.i(814030520320L, 6065);
    if (!bf.mA(this.field_appId))
    {
      i = this.field_appId.hashCode();
      GMTrace.o(814030520320L, 6065);
      return i;
    }
    int i = super.hashCode();
    GMTrace.o(814030520320L, 6065);
    return i;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(813762084864L, 6063);
    if ((!bf.mA(this.field_appType)) && ((this.field_appType.startsWith("1")) || (this.field_appType.startsWith("6")))) {
      this.field_appType = ("," + this.field_appType);
    }
    ContentValues localContentValues = super.pv();
    GMTrace.o(813762084864L, 6063);
    return localContentValues;
  }
  
  protected final c.a sY()
  {
    GMTrace.i(812956778496L, 6057);
    c.a locala = gTF;
    GMTrace.o(812956778496L, 6057);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */