package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class cn
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gbQ;
  private static final int gcE;
  private static final int gcG;
  private static final int gcH;
  private static final int gnz;
  private static final int goU;
  private static final int goW;
  private static final int goX;
  private static final int gpd;
  private static final int gpz;
  private static final int gqE;
  private static final int gqO;
  private static final int gzE;
  private static final int gzF;
  public String field_cdnKey;
  public String field_cdnUrl;
  public String field_dataId;
  public int field_errCode;
  public int field_fileType;
  public boolean field_isThumb;
  public int field_localId;
  public String field_mediaId;
  public int field_offset;
  public String field_path;
  public int field_recordLocalId;
  public int field_status;
  public String field_toUser;
  public int field_totalLen;
  public int field_type;
  private boolean gaM;
  private boolean gbu;
  private boolean gcn;
  private boolean gcp;
  private boolean gcq;
  private boolean gnc;
  private boolean goP;
  private boolean goR;
  private boolean goS;
  private boolean gpb;
  private boolean gpl;
  private boolean gql;
  private boolean gqv;
  private boolean gzC;
  private boolean gzD;
  
  static
  {
    GMTrace.i(4175513518080L, 31110);
    gaA = new String[] { "CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)" };
    gpd = "localId".hashCode();
    gzE = "recordLocalId".hashCode();
    gpz = "toUser".hashCode();
    goU = "dataId".hashCode();
    gcE = "mediaId".hashCode();
    goX = "path".hashCode();
    gnz = "cdnUrl".hashCode();
    goW = "cdnKey".hashCode();
    gcG = "totalLen".hashCode();
    gzF = "isThumb".hashCode();
    gcH = "offset".hashCode();
    gbQ = "type".hashCode();
    gqE = "fileType".hashCode();
    gaP = "status".hashCode();
    gqO = "errCode".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4175513518080L, 31110);
  }
  
  public cn()
  {
    GMTrace.i(4175110864896L, 31107);
    this.gpb = true;
    this.gzC = true;
    this.gpl = true;
    this.goP = true;
    this.gcn = true;
    this.goS = true;
    this.gnc = true;
    this.goR = true;
    this.gcp = true;
    this.gzD = true;
    this.gcq = true;
    this.gbu = true;
    this.gql = true;
    this.gaM = true;
    this.gqv = true;
    GMTrace.o(4175110864896L, 31107);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4175245082624L, 31108);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4175245082624L, 31108);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gpd == k)
      {
        this.field_localId = paramCursor.getInt(i);
        this.gpb = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gzE == k)
        {
          this.field_recordLocalId = paramCursor.getInt(i);
        }
        else if (gpz == k)
        {
          this.field_toUser = paramCursor.getString(i);
        }
        else if (goU == k)
        {
          this.field_dataId = paramCursor.getString(i);
        }
        else if (gcE == k)
        {
          this.field_mediaId = paramCursor.getString(i);
        }
        else if (goX == k)
        {
          this.field_path = paramCursor.getString(i);
        }
        else if (gnz == k)
        {
          this.field_cdnUrl = paramCursor.getString(i);
        }
        else if (goW == k)
        {
          this.field_cdnKey = paramCursor.getString(i);
        }
        else if (gcG == k)
        {
          this.field_totalLen = paramCursor.getInt(i);
        }
        else
        {
          if (gzF == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              this.field_isThumb = bool;
              break;
            }
          }
          if (gcH == k) {
            this.field_offset = paramCursor.getInt(i);
          } else if (gbQ == k) {
            this.field_type = paramCursor.getInt(i);
          } else if (gqE == k) {
            this.field_fileType = paramCursor.getInt(i);
          } else if (gaP == k) {
            this.field_status = paramCursor.getInt(i);
          } else if (gqO == k) {
            this.field_errCode = paramCursor.getInt(i);
          } else if (gaJ == k) {
            this.uvp = paramCursor.getLong(i);
          }
        }
      }
    }
    GMTrace.o(4175245082624L, 31108);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4175379300352L, 31109);
    ContentValues localContentValues = new ContentValues();
    if (this.gpb) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.gzC) {
      localContentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.gpl) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.goP) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.gcn) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.goS) {
      localContentValues.put("path", this.field_path);
    }
    if (this.gnc) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.goR) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.gcp) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.gzD) {
      localContentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
    }
    if (this.gcq) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.gbu) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.gql) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.gqv) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4175379300352L, 31109);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */