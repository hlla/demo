package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class dz
  extends c
{
  private static final int gIU;
  private static final int gIV;
  private static final int gIW;
  private static final int gIX;
  private static final int gIY;
  private static final int gIZ;
  private static final int gJa;
  private static final int gJb;
  private static final int gJc;
  private static final int gJd;
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gcB;
  private static final int gcP;
  private static final int gdB;
  private static final int gdC;
  private static final int gdj;
  private static final int ghK;
  private static final int ghw;
  private static final int gxn;
  public String field_appId;
  public String field_appInfo;
  public int field_appOpt;
  public String field_bigHeadURL;
  public String field_bindWxaInfo;
  public String field_brandIconURL;
  public String field_dynamicInfo;
  public String field_nickname;
  public String field_registerSource;
  public String field_reserved;
  public String field_roundedSquareIconURL;
  public String field_signature;
  public String field_smallHeadURL;
  public long field_syncTimeSecond;
  public String field_syncVersion;
  public String field_username;
  public int field_usernameHash;
  public String field_versionInfo;
  private boolean gIK;
  private boolean gIL;
  private boolean gIM;
  private boolean gIN;
  private boolean gIO;
  private boolean gIP;
  private boolean gIQ;
  private boolean gIR;
  private boolean gIS;
  private boolean gIT;
  private boolean gck;
  private boolean gcy;
  private boolean gdi;
  private boolean gdo;
  private boolean gdp;
  private boolean ghG;
  private boolean ghj;
  private boolean gxe;
  
  static
  {
    GMTrace.i(15353971212288L, 114396);
    gaA = new String[] { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
    gIU = "usernameHash".hashCode();
    gdj = "username".hashCode();
    gcB = "appId".hashCode();
    ghK = "nickname".hashCode();
    ghw = "brandIconURL".hashCode();
    gIV = "roundedSquareIconURL".hashCode();
    gIW = "bigHeadURL".hashCode();
    gIX = "smallHeadURL".hashCode();
    gcP = "signature".hashCode();
    gIY = "appOpt".hashCode();
    gIZ = "registerSource".hashCode();
    gdB = "appInfo".hashCode();
    gdC = "versionInfo".hashCode();
    gJa = "bindWxaInfo".hashCode();
    gJb = "dynamicInfo".hashCode();
    gxn = "reserved".hashCode();
    gJc = "syncTimeSecond".hashCode();
    gJd = "syncVersion".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(15353971212288L, 114396);
  }
  
  public dz()
  {
    GMTrace.i(15353568559104L, 114393);
    this.gIK = true;
    this.gdi = true;
    this.gck = true;
    this.ghG = true;
    this.ghj = true;
    this.gIL = true;
    this.gIM = true;
    this.gIN = true;
    this.gcy = true;
    this.gIO = true;
    this.gIP = true;
    this.gdo = true;
    this.gdp = true;
    this.gIQ = true;
    this.gIR = true;
    this.gxe = true;
    this.gIS = true;
    this.gIT = true;
    GMTrace.o(15353568559104L, 114393);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(15353702776832L, 114394);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(15353702776832L, 114394);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gIU == k)
      {
        this.field_usernameHash = paramCursor.getInt(i);
        this.gIK = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gdj == k) {
          this.field_username = paramCursor.getString(i);
        } else if (gcB == k) {
          this.field_appId = paramCursor.getString(i);
        } else if (ghK == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (ghw == k) {
          this.field_brandIconURL = paramCursor.getString(i);
        } else if (gIV == k) {
          this.field_roundedSquareIconURL = paramCursor.getString(i);
        } else if (gIW == k) {
          this.field_bigHeadURL = paramCursor.getString(i);
        } else if (gIX == k) {
          this.field_smallHeadURL = paramCursor.getString(i);
        } else if (gcP == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (gIY == k) {
          this.field_appOpt = paramCursor.getInt(i);
        } else if (gIZ == k) {
          this.field_registerSource = paramCursor.getString(i);
        } else if (gdB == k) {
          this.field_appInfo = paramCursor.getString(i);
        } else if (gdC == k) {
          this.field_versionInfo = paramCursor.getString(i);
        } else if (gJa == k) {
          this.field_bindWxaInfo = paramCursor.getString(i);
        } else if (gJb == k) {
          this.field_dynamicInfo = paramCursor.getString(i);
        } else if (gxn == k) {
          this.field_reserved = paramCursor.getString(i);
        } else if (gJc == k) {
          this.field_syncTimeSecond = paramCursor.getLong(i);
        } else if (gJd == k) {
          this.field_syncVersion = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(15353702776832L, 114394);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(15353836994560L, 114395);
    ContentValues localContentValues = new ContentValues();
    if (this.gIK) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.gdi) {
      localContentValues.put("username", this.field_username);
    }
    if (this.gck) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ghG) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.ghj) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.gIL) {
      localContentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
    }
    if (this.gIM) {
      localContentValues.put("bigHeadURL", this.field_bigHeadURL);
    }
    if (this.gIN) {
      localContentValues.put("smallHeadURL", this.field_smallHeadURL);
    }
    if (this.gcy) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.gIO) {
      localContentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
    }
    if (this.gIP) {
      localContentValues.put("registerSource", this.field_registerSource);
    }
    if (this.gdo) {
      localContentValues.put("appInfo", this.field_appInfo);
    }
    if (this.gdp) {
      localContentValues.put("versionInfo", this.field_versionInfo);
    }
    if (this.gIQ) {
      localContentValues.put("bindWxaInfo", this.field_bindWxaInfo);
    }
    if (this.gIR) {
      localContentValues.put("dynamicInfo", this.field_dynamicInfo);
    }
    if (this.gxe) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.gIS) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
    }
    if (this.gIT) {
      localContentValues.put("syncVersion", this.field_syncVersion);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(15353836994560L, 114395);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */