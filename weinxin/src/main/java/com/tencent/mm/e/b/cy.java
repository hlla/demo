package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class cy
  extends c
{
  private static final int gCA;
  private static final int gCB;
  private static final int gCC;
  private static final int gCD;
  private static final int gCx;
  private static final int gCy;
  private static final int gCz;
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gcT;
  private static final int gfy;
  private static final int gqC;
  public String field_cnValue;
  public int field_eggIndex;
  public String field_enValue;
  public String field_fileName;
  public int field_flag;
  public String field_key;
  public int field_position;
  public String field_qqValue;
  public String field_thValue;
  public String field_twValue;
  private boolean gCq;
  private boolean gCr;
  private boolean gCs;
  private boolean gCt;
  private boolean gCu;
  private boolean gCv;
  private boolean gCw;
  private boolean gcS;
  private boolean gfw;
  private boolean gqj;
  
  static
  {
    GMTrace.i(4151756980224L, 30933);
    gaA = new String[0];
    gcT = "key".hashCode();
    gCx = "cnValue".hashCode();
    gCy = "qqValue".hashCode();
    gCz = "twValue".hashCode();
    gCA = "enValue".hashCode();
    gCB = "thValue".hashCode();
    gqC = "fileName".hashCode();
    gCC = "eggIndex".hashCode();
    gCD = "position".hashCode();
    gfy = "flag".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4151756980224L, 30933);
  }
  
  public cy()
  {
    GMTrace.i(4151354327040L, 30930);
    this.gcS = true;
    this.gCq = true;
    this.gCr = true;
    this.gCs = true;
    this.gCt = true;
    this.gCu = true;
    this.gqj = true;
    this.gCv = true;
    this.gCw = true;
    this.gfw = true;
    GMTrace.o(4151354327040L, 30930);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4151488544768L, 30931);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4151488544768L, 30931);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gcT == k)
      {
        this.field_key = paramCursor.getString(i);
        this.gcS = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gCx == k) {
          this.field_cnValue = paramCursor.getString(i);
        } else if (gCy == k) {
          this.field_qqValue = paramCursor.getString(i);
        } else if (gCz == k) {
          this.field_twValue = paramCursor.getString(i);
        } else if (gCA == k) {
          this.field_enValue = paramCursor.getString(i);
        } else if (gCB == k) {
          this.field_thValue = paramCursor.getString(i);
        } else if (gqC == k) {
          this.field_fileName = paramCursor.getString(i);
        } else if (gCC == k) {
          this.field_eggIndex = paramCursor.getInt(i);
        } else if (gCD == k) {
          this.field_position = paramCursor.getInt(i);
        } else if (gfy == k) {
          this.field_flag = paramCursor.getInt(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4151488544768L, 30931);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4151622762496L, 30932);
    ContentValues localContentValues = new ContentValues();
    if (this.gcS) {
      localContentValues.put("key", this.field_key);
    }
    if (this.gCq) {
      localContentValues.put("cnValue", this.field_cnValue);
    }
    if (this.gCr) {
      localContentValues.put("qqValue", this.field_qqValue);
    }
    if (this.gCs) {
      localContentValues.put("twValue", this.field_twValue);
    }
    if (this.gCt) {
      localContentValues.put("enValue", this.field_enValue);
    }
    if (this.gCu) {
      localContentValues.put("thValue", this.field_thValue);
    }
    if (this.gqj) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.gCv) {
      localContentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
    }
    if (this.gCw) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.gfw) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4151622762496L, 30932);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */