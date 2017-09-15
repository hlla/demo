package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class an
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gbQ;
  private static final int gfy;
  private static final int gmA;
  private static final int gmB;
  private static final int gmC;
  private static final int gmD;
  private static final int gmE;
  private static final int gmF;
  private static final int gmG;
  private static final int gmH;
  private static final int gmI;
  private static final int gmJ;
  private static final int gmK;
  private static final int gml;
  private static final int gmm;
  private static final int gmn;
  private static final int gmo;
  private static final int gmp;
  private static final int gmq;
  private static final int gmr;
  private static final int gms;
  private static final int gmt;
  private static final int gmu;
  private static final int gmv;
  private static final int gmw;
  private static final int gmx;
  private static final int gmy;
  private static final int gmz;
  public String field_BigIconUrl;
  public String field_MutiLanName;
  public int field_buttonType;
  public int field_count;
  public int field_flag;
  public int field_idx;
  public String field_lang;
  public long field_lastUseTime;
  public String field_packAuthInfo;
  public String field_packCopyright;
  public String field_packCoverUrl;
  public String field_packDesc;
  public long field_packExpire;
  public int field_packFlag;
  public String field_packGrayIconUrl;
  public String field_packIconUrl;
  public String field_packName;
  public String field_packPrice;
  public int field_packStatus;
  public long field_packTimeStamp;
  public int field_packType;
  public String field_productID;
  public int field_recommand;
  public int field_recommandType;
  public String field_recommandWord;
  public int field_sort;
  public int field_status;
  public int field_sync;
  public int field_type;
  private boolean gaM;
  private boolean gbu;
  private boolean gfw;
  private boolean glL;
  private boolean glM;
  private boolean glN;
  private boolean glO;
  private boolean glP;
  private boolean glQ;
  private boolean glR;
  private boolean glS;
  private boolean glT;
  private boolean glU;
  private boolean glV;
  private boolean glW;
  private boolean glX;
  private boolean glY;
  private boolean glZ;
  private boolean gma;
  private boolean gmb;
  private boolean gmc;
  private boolean gmd;
  private boolean gme;
  private boolean gmf;
  private boolean gmg;
  private boolean gmh;
  private boolean gmi;
  private boolean gmj;
  private boolean gmk;
  
  static
  {
    GMTrace.i(4174976647168L, 31106);
    gaA = new String[0];
    gml = "productID".hashCode();
    gmm = "packIconUrl".hashCode();
    gmn = "packGrayIconUrl".hashCode();
    gmo = "packCoverUrl".hashCode();
    gmp = "packName".hashCode();
    gmq = "packDesc".hashCode();
    gmr = "packAuthInfo".hashCode();
    gms = "packPrice".hashCode();
    gmt = "packType".hashCode();
    gmu = "packFlag".hashCode();
    gmv = "packExpire".hashCode();
    gmw = "packTimeStamp".hashCode();
    gmx = "packCopyright".hashCode();
    gbQ = "type".hashCode();
    gaP = "status".hashCode();
    gmy = "sort".hashCode();
    gmz = "lastUseTime".hashCode();
    gmA = "packStatus".hashCode();
    gfy = "flag".hashCode();
    gmB = "recommand".hashCode();
    gmC = "sync".hashCode();
    gmD = "idx".hashCode();
    gmE = "BigIconUrl".hashCode();
    gmF = "MutiLanName".hashCode();
    gmG = "recommandType".hashCode();
    gmH = "lang".hashCode();
    gmI = "recommandWord".hashCode();
    gmJ = "buttonType".hashCode();
    gmK = "count".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4174976647168L, 31106);
  }
  
  public an()
  {
    GMTrace.i(4174573993984L, 31103);
    this.glL = true;
    this.glM = true;
    this.glN = true;
    this.glO = true;
    this.glP = true;
    this.glQ = true;
    this.glR = true;
    this.glS = true;
    this.glT = true;
    this.glU = true;
    this.glV = true;
    this.glW = true;
    this.glX = true;
    this.gbu = true;
    this.gaM = true;
    this.glY = true;
    this.glZ = true;
    this.gma = true;
    this.gfw = true;
    this.gmb = true;
    this.gmc = true;
    this.gmd = true;
    this.gme = true;
    this.gmf = true;
    this.gmg = true;
    this.gmh = true;
    this.gmi = true;
    this.gmj = true;
    this.gmk = true;
    GMTrace.o(4174573993984L, 31103);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4174708211712L, 31104);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4174708211712L, 31104);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gml == k)
      {
        this.field_productID = paramCursor.getString(i);
        this.glL = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gmm == k) {
          this.field_packIconUrl = paramCursor.getString(i);
        } else if (gmn == k) {
          this.field_packGrayIconUrl = paramCursor.getString(i);
        } else if (gmo == k) {
          this.field_packCoverUrl = paramCursor.getString(i);
        } else if (gmp == k) {
          this.field_packName = paramCursor.getString(i);
        } else if (gmq == k) {
          this.field_packDesc = paramCursor.getString(i);
        } else if (gmr == k) {
          this.field_packAuthInfo = paramCursor.getString(i);
        } else if (gms == k) {
          this.field_packPrice = paramCursor.getString(i);
        } else if (gmt == k) {
          this.field_packType = paramCursor.getInt(i);
        } else if (gmu == k) {
          this.field_packFlag = paramCursor.getInt(i);
        } else if (gmv == k) {
          this.field_packExpire = paramCursor.getLong(i);
        } else if (gmw == k) {
          this.field_packTimeStamp = paramCursor.getLong(i);
        } else if (gmx == k) {
          this.field_packCopyright = paramCursor.getString(i);
        } else if (gbQ == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (gaP == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (gmy == k) {
          this.field_sort = paramCursor.getInt(i);
        } else if (gmz == k) {
          this.field_lastUseTime = paramCursor.getLong(i);
        } else if (gmA == k) {
          this.field_packStatus = paramCursor.getInt(i);
        } else if (gfy == k) {
          this.field_flag = paramCursor.getInt(i);
        } else if (gmB == k) {
          this.field_recommand = paramCursor.getInt(i);
        } else if (gmC == k) {
          this.field_sync = paramCursor.getInt(i);
        } else if (gmD == k) {
          this.field_idx = paramCursor.getInt(i);
        } else if (gmE == k) {
          this.field_BigIconUrl = paramCursor.getString(i);
        } else if (gmF == k) {
          this.field_MutiLanName = paramCursor.getString(i);
        } else if (gmG == k) {
          this.field_recommandType = paramCursor.getInt(i);
        } else if (gmH == k) {
          this.field_lang = paramCursor.getString(i);
        } else if (gmI == k) {
          this.field_recommandWord = paramCursor.getString(i);
        } else if (gmJ == k) {
          this.field_buttonType = paramCursor.getInt(i);
        } else if (gmK == k) {
          this.field_count = paramCursor.getInt(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4174708211712L, 31104);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4174842429440L, 31105);
    ContentValues localContentValues = new ContentValues();
    if (this.glL) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.glM) {
      localContentValues.put("packIconUrl", this.field_packIconUrl);
    }
    if (this.glN) {
      localContentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
    }
    if (this.glO) {
      localContentValues.put("packCoverUrl", this.field_packCoverUrl);
    }
    if (this.glP) {
      localContentValues.put("packName", this.field_packName);
    }
    if (this.glQ) {
      localContentValues.put("packDesc", this.field_packDesc);
    }
    if (this.glR) {
      localContentValues.put("packAuthInfo", this.field_packAuthInfo);
    }
    if (this.glS) {
      localContentValues.put("packPrice", this.field_packPrice);
    }
    if (this.glT) {
      localContentValues.put("packType", Integer.valueOf(this.field_packType));
    }
    if (this.glU) {
      localContentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
    }
    if (this.glV) {
      localContentValues.put("packExpire", Long.valueOf(this.field_packExpire));
    }
    if (this.glW) {
      localContentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
    }
    if (this.glX) {
      localContentValues.put("packCopyright", this.field_packCopyright);
    }
    if (this.gbu) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.glY) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.glZ) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.gma) {
      localContentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
    }
    if (this.gfw) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.gmb) {
      localContentValues.put("recommand", Integer.valueOf(this.field_recommand));
    }
    if (this.gmc) {
      localContentValues.put("sync", Integer.valueOf(this.field_sync));
    }
    if (this.gmd) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.gme) {
      localContentValues.put("BigIconUrl", this.field_BigIconUrl);
    }
    if (this.gmf) {
      localContentValues.put("MutiLanName", this.field_MutiLanName);
    }
    if (this.gmg) {
      localContentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
    }
    if (this.gmh) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.gmi) {
      localContentValues.put("recommandWord", this.field_recommandWord);
    }
    if (this.gmj) {
      localContentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
    }
    if (this.gmk) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4174842429440L, 31105);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */