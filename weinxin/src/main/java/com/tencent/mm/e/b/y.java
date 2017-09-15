package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class y
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gbQ;
  private static final int gdE;
  private static final int gdh;
  private static final int gdj;
  private static final int ggD;
  private static final int ghA;
  private static final int ghB;
  private static final int ghC;
  private static final int ghD;
  private static final int ghr;
  private static final int ghs;
  private static final int ght;
  private static final int ghu;
  private static final int ghv;
  private static final int ghw;
  private static final int ghx;
  private static final int ghy;
  private static final int ghz;
  public int field_acceptType;
  public String field_attrSyncVersion;
  public int field_bitFlag;
  public int field_brandFlag;
  public String field_brandIconURL;
  public String field_brandInfo;
  public String field_brandList;
  public String field_brandListContent;
  public String field_brandListVersion;
  public String field_enterpriseFather;
  public String field_extInfo;
  public int field_hadAlert;
  public long field_incrementUpdateTime;
  public String field_kfWorkerId;
  public int field_specialType;
  public int field_status;
  public int field_type;
  public long field_updateTime;
  public String field_username;
  private boolean gaM;
  private boolean gbu;
  private boolean gdd;
  private boolean gdi;
  private boolean gdr;
  private boolean ggr;
  private boolean ghe;
  private boolean ghf;
  private boolean ghg;
  private boolean ghh;
  private boolean ghi;
  private boolean ghj;
  private boolean ghk;
  private boolean ghl;
  private boolean ghm;
  private boolean ghn;
  private boolean gho;
  private boolean ghp;
  private boolean ghq;
  
  static
  {
    GMTrace.i(4117397241856L, 30677);
    gaA = new String[0];
    gdj = "username".hashCode();
    ghr = "brandList".hashCode();
    ghs = "brandListVersion".hashCode();
    ght = "brandListContent".hashCode();
    gdE = "brandFlag".hashCode();
    ghu = "extInfo".hashCode();
    ghv = "brandInfo".hashCode();
    ghw = "brandIconURL".hashCode();
    gdh = "updateTime".hashCode();
    ghx = "hadAlert".hashCode();
    ghy = "acceptType".hashCode();
    gbQ = "type".hashCode();
    gaP = "status".hashCode();
    ghz = "enterpriseFather".hashCode();
    ghA = "kfWorkerId".hashCode();
    ghB = "specialType".hashCode();
    ghC = "attrSyncVersion".hashCode();
    ghD = "incrementUpdateTime".hashCode();
    ggD = "bitFlag".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4117397241856L, 30677);
  }
  
  public y()
  {
    GMTrace.i(4116994588672L, 30674);
    this.gdi = true;
    this.ghe = true;
    this.ghf = true;
    this.ghg = true;
    this.gdr = true;
    this.ghh = true;
    this.ghi = true;
    this.ghj = true;
    this.gdd = true;
    this.ghk = true;
    this.ghl = true;
    this.gbu = true;
    this.gaM = true;
    this.ghm = true;
    this.ghn = true;
    this.gho = true;
    this.ghp = true;
    this.ghq = true;
    this.ggr = true;
    GMTrace.o(4116994588672L, 30674);
  }
  
  public void b(Cursor paramCursor)
  {
    GMTrace.i(4117128806400L, 30675);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4117128806400L, 30675);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gdj == k)
      {
        this.field_username = paramCursor.getString(i);
        this.gdi = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (ghr == k) {
          this.field_brandList = paramCursor.getString(i);
        } else if (ghs == k) {
          this.field_brandListVersion = paramCursor.getString(i);
        } else if (ght == k) {
          this.field_brandListContent = paramCursor.getString(i);
        } else if (gdE == k) {
          this.field_brandFlag = paramCursor.getInt(i);
        } else if (ghu == k) {
          this.field_extInfo = paramCursor.getString(i);
        } else if (ghv == k) {
          this.field_brandInfo = paramCursor.getString(i);
        } else if (ghw == k) {
          this.field_brandIconURL = paramCursor.getString(i);
        } else if (gdh == k) {
          this.field_updateTime = paramCursor.getLong(i);
        } else if (ghx == k) {
          this.field_hadAlert = paramCursor.getInt(i);
        } else if (ghy == k) {
          this.field_acceptType = paramCursor.getInt(i);
        } else if (gbQ == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (gaP == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (ghz == k) {
          this.field_enterpriseFather = paramCursor.getString(i);
        } else if (ghA == k) {
          this.field_kfWorkerId = paramCursor.getString(i);
        } else if (ghB == k) {
          this.field_specialType = paramCursor.getInt(i);
        } else if (ghC == k) {
          this.field_attrSyncVersion = paramCursor.getString(i);
        } else if (ghD == k) {
          this.field_incrementUpdateTime = paramCursor.getLong(i);
        } else if (ggD == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4117128806400L, 30675);
  }
  
  public ContentValues pv()
  {
    GMTrace.i(4117263024128L, 30676);
    ContentValues localContentValues = new ContentValues();
    if (this.gdi) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_brandList == null) {
      this.field_brandList = "";
    }
    if (this.ghe) {
      localContentValues.put("brandList", this.field_brandList);
    }
    if (this.ghf) {
      localContentValues.put("brandListVersion", this.field_brandListVersion);
    }
    if (this.ghg) {
      localContentValues.put("brandListContent", this.field_brandListContent);
    }
    if (this.gdr) {
      localContentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
    }
    if (this.ghh) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.ghi) {
      localContentValues.put("brandInfo", this.field_brandInfo);
    }
    if (this.ghj) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.gdd) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ghk) {
      localContentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
    }
    if (this.ghl) {
      localContentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
    }
    if (this.gbu) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ghm) {
      localContentValues.put("enterpriseFather", this.field_enterpriseFather);
    }
    if (this.ghn) {
      localContentValues.put("kfWorkerId", this.field_kfWorkerId);
    }
    if (this.gho) {
      localContentValues.put("specialType", Integer.valueOf(this.field_specialType));
    }
    if (this.ghp) {
      localContentValues.put("attrSyncVersion", this.field_attrSyncVersion);
    }
    if (this.ghq) {
      localContentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
    }
    if (this.ggr) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4117263024128L, 30676);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */