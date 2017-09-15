package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class cx
  extends c
{
  private static final int gCl;
  private static final int gCm;
  private static final int gCn;
  private static final int gCo;
  private static final int gCp;
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbN;
  private static final int gpd;
  private static final int gqC;
  public long field_createTime;
  public int field_fileDuration;
  public long field_fileLength;
  public String field_fileMd5;
  public String field_fileName;
  public int field_fileNameHash;
  public int field_fileStatus;
  public int field_localId;
  private boolean gCg;
  private boolean gCh;
  private boolean gCi;
  private boolean gCj;
  private boolean gCk;
  private boolean gbr;
  private boolean gpb;
  private boolean gqj;
  
  static
  {
    GMTrace.i(4112431185920L, 30640);
    gaA = new String[] { "CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)" };
    gpd = "localId".hashCode();
    gqC = "fileName".hashCode();
    gCl = "fileNameHash".hashCode();
    gCm = "fileMd5".hashCode();
    gCn = "fileLength".hashCode();
    gCo = "fileStatus".hashCode();
    gCp = "fileDuration".hashCode();
    gbN = "createTime".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4112431185920L, 30640);
  }
  
  public cx()
  {
    GMTrace.i(4112028532736L, 30637);
    this.gpb = true;
    this.gqj = true;
    this.gCg = true;
    this.gCh = true;
    this.gCi = true;
    this.gCj = true;
    this.gCk = true;
    this.gbr = true;
    GMTrace.o(4112028532736L, 30637);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4112162750464L, 30638);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4112162750464L, 30638);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
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
        if (gqC == k) {
          this.field_fileName = paramCursor.getString(i);
        } else if (gCl == k) {
          this.field_fileNameHash = paramCursor.getInt(i);
        } else if (gCm == k) {
          this.field_fileMd5 = paramCursor.getString(i);
        } else if (gCn == k) {
          this.field_fileLength = paramCursor.getLong(i);
        } else if (gCo == k) {
          this.field_fileStatus = paramCursor.getInt(i);
        } else if (gCp == k) {
          this.field_fileDuration = paramCursor.getInt(i);
        } else if (gbN == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4112162750464L, 30638);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4112296968192L, 30639);
    ContentValues localContentValues = new ContentValues();
    if (this.gpb) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.gqj) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.gCg) {
      localContentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
    }
    if (this.field_fileMd5 == null) {
      this.field_fileMd5 = "";
    }
    if (this.gCh) {
      localContentValues.put("fileMd5", this.field_fileMd5);
    }
    if (this.gCi) {
      localContentValues.put("fileLength", Long.valueOf(this.field_fileLength));
    }
    if (this.gCj) {
      localContentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
    }
    if (this.gCk) {
      localContentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
    }
    if (this.gbr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4112296968192L, 30639);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */