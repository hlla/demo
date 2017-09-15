package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class g
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gbN;
  private static final int gbQ;
  private static final int gcB;
  private static final int gcC;
  private static final int gcD;
  private static final int gcE;
  private static final int gcF;
  private static final int gcG;
  private static final int gcH;
  private static final int gcI;
  private static final int gcJ;
  private static final int gcK;
  private static final int gcL;
  private static final int gcM;
  private static final int gcN;
  private static final int gcO;
  private static final int gcP;
  private static final int gcQ;
  private static final int gcR;
  public String field_appId;
  public String field_clientAppDataId;
  public long field_createTime;
  public String field_fakeAeskey;
  public String field_fakeSignature;
  public String field_fileFullPath;
  public String field_fullXml;
  public boolean field_isUpload;
  public int field_isUseCdn;
  public long field_lastModifyTime;
  public String field_mediaId;
  public String field_mediaSvrId;
  public long field_msgInfoId;
  public long field_netTimes;
  public long field_offset;
  public long field_sdkVer;
  public String field_signature;
  public long field_status;
  public long field_totalLen;
  public long field_type;
  private boolean gaM;
  private boolean gbr;
  private boolean gbu;
  private boolean gcA;
  private boolean gck;
  private boolean gcl;
  private boolean gcm;
  private boolean gcn;
  private boolean gco;
  private boolean gcp;
  private boolean gcq;
  private boolean gcr;
  private boolean gcs;
  private boolean gct;
  private boolean gcu;
  private boolean gcv;
  private boolean gcw;
  private boolean gcx;
  private boolean gcy;
  private boolean gcz;
  
  static
  {
    GMTrace.i(4171621203968L, 31081);
    gaA = new String[0];
    gcB = "appId".hashCode();
    gcC = "sdkVer".hashCode();
    gcD = "mediaSvrId".hashCode();
    gcE = "mediaId".hashCode();
    gcF = "clientAppDataId".hashCode();
    gbQ = "type".hashCode();
    gcG = "totalLen".hashCode();
    gcH = "offset".hashCode();
    gaP = "status".hashCode();
    gcI = "isUpload".hashCode();
    gbN = "createTime".hashCode();
    gcJ = "lastModifyTime".hashCode();
    gcK = "fileFullPath".hashCode();
    gcL = "fullXml".hashCode();
    gcM = "msgInfoId".hashCode();
    gcN = "netTimes".hashCode();
    gcO = "isUseCdn".hashCode();
    gcP = "signature".hashCode();
    gcQ = "fakeAeskey".hashCode();
    gcR = "fakeSignature".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4171621203968L, 31081);
  }
  
  public g()
  {
    GMTrace.i(4171218550784L, 31078);
    this.gck = true;
    this.gcl = true;
    this.gcm = true;
    this.gcn = true;
    this.gco = true;
    this.gbu = true;
    this.gcp = true;
    this.gcq = true;
    this.gaM = true;
    this.gcr = true;
    this.gbr = true;
    this.gcs = true;
    this.gct = true;
    this.gcu = true;
    this.gcv = true;
    this.gcw = true;
    this.gcx = true;
    this.gcy = true;
    this.gcz = true;
    this.gcA = true;
    GMTrace.o(4171218550784L, 31078);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4171352768512L, 31079);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4171352768512L, 31079);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gcB == k) {
        this.field_appId = paramCursor.getString(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (gcC == k)
        {
          this.field_sdkVer = paramCursor.getLong(i);
        }
        else if (gcD == k)
        {
          this.field_mediaSvrId = paramCursor.getString(i);
        }
        else if (gcE == k)
        {
          this.field_mediaId = paramCursor.getString(i);
        }
        else if (gcF == k)
        {
          this.field_clientAppDataId = paramCursor.getString(i);
        }
        else if (gbQ == k)
        {
          this.field_type = paramCursor.getLong(i);
        }
        else if (gcG == k)
        {
          this.field_totalLen = paramCursor.getLong(i);
        }
        else if (gcH == k)
        {
          this.field_offset = paramCursor.getLong(i);
        }
        else if (gaP == k)
        {
          this.field_status = paramCursor.getLong(i);
        }
        else
        {
          if (gcI == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              this.field_isUpload = bool;
              break;
            }
          }
          if (gbN == k) {
            this.field_createTime = paramCursor.getLong(i);
          } else if (gcJ == k) {
            this.field_lastModifyTime = paramCursor.getLong(i);
          } else if (gcK == k) {
            this.field_fileFullPath = paramCursor.getString(i);
          } else if (gcL == k) {
            this.field_fullXml = paramCursor.getString(i);
          } else if (gcM == k) {
            this.field_msgInfoId = paramCursor.getLong(i);
          } else if (gcN == k) {
            this.field_netTimes = paramCursor.getLong(i);
          } else if (gcO == k) {
            this.field_isUseCdn = paramCursor.getInt(i);
          } else if (gcP == k) {
            this.field_signature = paramCursor.getString(i);
          } else if (gcQ == k) {
            this.field_fakeAeskey = paramCursor.getString(i);
          } else if (gcR == k) {
            this.field_fakeSignature = paramCursor.getString(i);
          } else if (gaJ == k) {
            this.uvp = paramCursor.getLong(i);
          }
        }
      }
    }
    GMTrace.o(4171352768512L, 31079);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4171486986240L, 31080);
    ContentValues localContentValues = new ContentValues();
    if (this.gck) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.gcl) {
      localContentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
    }
    if (this.gcm) {
      localContentValues.put("mediaSvrId", this.field_mediaSvrId);
    }
    if (this.gcn) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.gco) {
      localContentValues.put("clientAppDataId", this.field_clientAppDataId);
    }
    if (this.gbu) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.gcp) {
      localContentValues.put("totalLen", Long.valueOf(this.field_totalLen));
    }
    if (this.gcq) {
      localContentValues.put("offset", Long.valueOf(this.field_offset));
    }
    if (this.gaM) {
      localContentValues.put("status", Long.valueOf(this.field_status));
    }
    if (this.gcr) {
      localContentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
    }
    if (this.gbr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.gcs) {
      localContentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
    }
    if (this.gct) {
      localContentValues.put("fileFullPath", this.field_fileFullPath);
    }
    if (this.gcu) {
      localContentValues.put("fullXml", this.field_fullXml);
    }
    if (this.gcv) {
      localContentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
    }
    if (this.gcw) {
      localContentValues.put("netTimes", Long.valueOf(this.field_netTimes));
    }
    if (this.gcx) {
      localContentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
    }
    if (this.gcy) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.gcz) {
      localContentValues.put("fakeAeskey", this.field_fakeAeskey);
    }
    if (this.gcA) {
      localContentValues.put("fakeSignature", this.field_fakeSignature);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4171486986240L, 31080);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */