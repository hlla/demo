package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class bd
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gbd;
  private static final int gcB;
  private static final int gci;
  private static final int gez;
  private static final int gni;
  private static final int gqA;
  private static final int gqB;
  private static final int gqC;
  private static final int gqD;
  private static final int gqE;
  private static final int gqF;
  private static final int gqG;
  private static final int gqH;
  private static final int gqI;
  private static final int gqJ;
  private static final int gqK;
  private static final int gqL;
  private static final int gqM;
  private static final int gqN;
  private static final int gqO;
  private static final int gqP;
  private static final int gqQ;
  private static final int gqy;
  private static final int gqz;
  public String field_appId;
  public boolean field_autoDownload;
  public boolean field_autoInstall;
  public String field_channelId;
  public long field_downloadId;
  public String field_downloadUrl;
  public int field_downloadUrlHashCode;
  public long field_downloadedSize;
  public int field_downloaderType;
  public int field_errCode;
  public String field_fileName;
  public String field_filePath;
  public long field_fileSize;
  public int field_fileType;
  public String field_md5;
  public String field_packageName;
  public int field_scene;
  public String field_secondaryUrl;
  public boolean field_showNotification;
  public long field_startSize;
  public int field_startState;
  public long field_startTime;
  public int field_status;
  public long field_sysDownloadId;
  public long field_totalSize;
  private boolean gaM;
  private boolean gaV;
  private boolean gcg;
  private boolean gck;
  private boolean ged;
  private boolean gmL;
  private boolean gqf;
  private boolean gqg;
  private boolean gqh;
  private boolean gqi;
  private boolean gqj;
  private boolean gqk;
  private boolean gql;
  private boolean gqm;
  private boolean gqn;
  private boolean gqo;
  private boolean gqp;
  private boolean gqq;
  private boolean gqr;
  private boolean gqs;
  private boolean gqt;
  private boolean gqu;
  private boolean gqv;
  private boolean gqw;
  private boolean gqx;
  
  static
  {
    GMTrace.i(4150683238400L, 30925);
    gaA = new String[0];
    gqy = "downloadId".hashCode();
    gqz = "downloadUrl".hashCode();
    gqA = "secondaryUrl".hashCode();
    gqB = "fileSize".hashCode();
    gqC = "fileName".hashCode();
    gqD = "filePath".hashCode();
    gqE = "fileType".hashCode();
    gaP = "status".hashCode();
    gni = "md5".hashCode();
    gqF = "autoInstall".hashCode();
    gqG = "showNotification".hashCode();
    gqH = "sysDownloadId".hashCode();
    gqI = "downloaderType".hashCode();
    gcB = "appId".hashCode();
    gqJ = "downloadUrlHashCode".hashCode();
    gez = "packageName".hashCode();
    gqK = "downloadedSize".hashCode();
    gqL = "totalSize".hashCode();
    gqM = "autoDownload".hashCode();
    gqN = "channelId".hashCode();
    gci = "scene".hashCode();
    gqO = "errCode".hashCode();
    gbd = "startTime".hashCode();
    gqP = "startSize".hashCode();
    gqQ = "startState".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4150683238400L, 30925);
  }
  
  public bd()
  {
    GMTrace.i(4150280585216L, 30922);
    this.gqf = true;
    this.gqg = true;
    this.gqh = true;
    this.gqi = true;
    this.gqj = true;
    this.gqk = true;
    this.gql = true;
    this.gaM = true;
    this.gmL = true;
    this.gqm = true;
    this.gqn = true;
    this.gqo = true;
    this.gqp = true;
    this.gck = true;
    this.gqq = true;
    this.ged = true;
    this.gqr = true;
    this.gqs = true;
    this.gqt = true;
    this.gqu = true;
    this.gcg = true;
    this.gqv = true;
    this.gaV = true;
    this.gqw = true;
    this.gqx = true;
    GMTrace.o(4150280585216L, 30922);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4150414802944L, 30923);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4150414802944L, 30923);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gqy == k)
      {
        this.field_downloadId = paramCursor.getLong(i);
        this.gqf = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gqz == k)
        {
          this.field_downloadUrl = paramCursor.getString(i);
        }
        else if (gqA == k)
        {
          this.field_secondaryUrl = paramCursor.getString(i);
        }
        else if (gqB == k)
        {
          this.field_fileSize = paramCursor.getLong(i);
        }
        else if (gqC == k)
        {
          this.field_fileName = paramCursor.getString(i);
        }
        else if (gqD == k)
        {
          this.field_filePath = paramCursor.getString(i);
        }
        else if (gqE == k)
        {
          this.field_fileType = paramCursor.getInt(i);
        }
        else if (gaP == k)
        {
          this.field_status = paramCursor.getInt(i);
        }
        else if (gni == k)
        {
          this.field_md5 = paramCursor.getString(i);
        }
        else
        {
          boolean bool;
          if (gqF == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_autoInstall = bool;
              break;
            }
          }
          if (gqG == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_showNotification = bool;
              break;
            }
          }
          if (gqH == k)
          {
            this.field_sysDownloadId = paramCursor.getLong(i);
          }
          else if (gqI == k)
          {
            this.field_downloaderType = paramCursor.getInt(i);
          }
          else if (gcB == k)
          {
            this.field_appId = paramCursor.getString(i);
          }
          else if (gqJ == k)
          {
            this.field_downloadUrlHashCode = paramCursor.getInt(i);
          }
          else if (gez == k)
          {
            this.field_packageName = paramCursor.getString(i);
          }
          else if (gqK == k)
          {
            this.field_downloadedSize = paramCursor.getLong(i);
          }
          else if (gqL == k)
          {
            this.field_totalSize = paramCursor.getLong(i);
          }
          else
          {
            if (gqM == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_autoDownload = bool;
                break;
              }
            }
            if (gqN == k) {
              this.field_channelId = paramCursor.getString(i);
            } else if (gci == k) {
              this.field_scene = paramCursor.getInt(i);
            } else if (gqO == k) {
              this.field_errCode = paramCursor.getInt(i);
            } else if (gbd == k) {
              this.field_startTime = paramCursor.getLong(i);
            } else if (gqP == k) {
              this.field_startSize = paramCursor.getLong(i);
            } else if (gqQ == k) {
              this.field_startState = paramCursor.getInt(i);
            } else if (gaJ == k) {
              this.uvp = paramCursor.getLong(i);
            }
          }
        }
      }
    }
    GMTrace.o(4150414802944L, 30923);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4150549020672L, 30924);
    ContentValues localContentValues = new ContentValues();
    if (this.gqf) {
      localContentValues.put("downloadId", Long.valueOf(this.field_downloadId));
    }
    if (this.field_downloadUrl == null) {
      this.field_downloadUrl = "";
    }
    if (this.gqg) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.field_secondaryUrl == null) {
      this.field_secondaryUrl = "";
    }
    if (this.gqh) {
      localContentValues.put("secondaryUrl", this.field_secondaryUrl);
    }
    if (this.gqi) {
      localContentValues.put("fileSize", Long.valueOf(this.field_fileSize));
    }
    if (this.field_fileName == null) {
      this.field_fileName = "";
    }
    if (this.gqj) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.gqk) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.gql) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.field_md5 == null) {
      this.field_md5 = "";
    }
    if (this.gmL) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.gqm) {
      localContentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
    }
    if (this.gqn) {
      localContentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
    }
    if (this.gqo) {
      localContentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
    }
    if (this.gqp) {
      localContentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.gck) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.gqq) {
      localContentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
    }
    if (this.field_packageName == null) {
      this.field_packageName = "";
    }
    if (this.ged) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.gqr) {
      localContentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
    }
    if (this.gqs) {
      localContentValues.put("totalSize", Long.valueOf(this.field_totalSize));
    }
    if (this.gqt) {
      localContentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
    }
    if (this.field_channelId == null) {
      this.field_channelId = "";
    }
    if (this.gqu) {
      localContentValues.put("channelId", this.field_channelId);
    }
    if (this.gcg) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.gqv) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.gaV) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.gqw) {
      localContentValues.put("startSize", Long.valueOf(this.field_startSize));
    }
    if (this.gqx) {
      localContentValues.put("startState", Integer.valueOf(this.field_startState));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4150549020672L, 30924);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */