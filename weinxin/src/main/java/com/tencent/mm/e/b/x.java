package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class x
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbL;
  private static final int ggX;
  private static final int ggY;
  private static final int ggZ;
  private static final int gha;
  private static final int ghb;
  private static final int ghc;
  private static final int ghd;
  public int field_qyUin;
  public int field_userFlag;
  public String field_userName;
  public int field_userUin;
  public long field_wwCorpId;
  public int field_wwExposeTimes;
  public int field_wwMaxExposeTimes;
  public long field_wwUserVid;
  private boolean gbp;
  private boolean ggQ;
  private boolean ggR;
  private boolean ggS;
  private boolean ggT;
  private boolean ggU;
  private boolean ggV;
  private boolean ggW;
  
  static
  {
    GMTrace.i(4162897051648L, 31016);
    gaA = new String[0];
    gbL = "userName".hashCode();
    ggX = "qyUin".hashCode();
    ggY = "userUin".hashCode();
    ggZ = "userFlag".hashCode();
    gha = "wwExposeTimes".hashCode();
    ghb = "wwMaxExposeTimes".hashCode();
    ghc = "wwCorpId".hashCode();
    ghd = "wwUserVid".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4162897051648L, 31016);
  }
  
  public x()
  {
    GMTrace.i(4162494398464L, 31013);
    this.gbp = true;
    this.ggQ = true;
    this.ggR = true;
    this.ggS = true;
    this.ggT = true;
    this.ggU = true;
    this.ggV = true;
    this.ggW = true;
    GMTrace.o(4162494398464L, 31013);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4162628616192L, 31014);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4162628616192L, 31014);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gbL == k)
      {
        this.field_userName = paramCursor.getString(i);
        this.gbp = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (ggX == k) {
          this.field_qyUin = paramCursor.getInt(i);
        } else if (ggY == k) {
          this.field_userUin = paramCursor.getInt(i);
        } else if (ggZ == k) {
          this.field_userFlag = paramCursor.getInt(i);
        } else if (gha == k) {
          this.field_wwExposeTimes = paramCursor.getInt(i);
        } else if (ghb == k) {
          this.field_wwMaxExposeTimes = paramCursor.getInt(i);
        } else if (ghc == k) {
          this.field_wwCorpId = paramCursor.getLong(i);
        } else if (ghd == k) {
          this.field_wwUserVid = paramCursor.getLong(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4162628616192L, 31014);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4162762833920L, 31015);
    ContentValues localContentValues = new ContentValues();
    if (this.gbp) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.ggQ) {
      localContentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
    }
    if (this.ggR) {
      localContentValues.put("userUin", Integer.valueOf(this.field_userUin));
    }
    if (this.ggS) {
      localContentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
    }
    if (this.ggT) {
      localContentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
    }
    if (this.ggU) {
      localContentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
    }
    if (this.ggV) {
      localContentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
    }
    if (this.ggW) {
      localContentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4162762833920L, 31015);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */