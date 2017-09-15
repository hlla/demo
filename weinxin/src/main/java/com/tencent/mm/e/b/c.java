package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;

public abstract class c
  extends com.tencent.mm.sdk.e.c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaY;
  private static final int gaZ;
  private static final int gba;
  private static final int gbb;
  private static final int gbc;
  private static final int gbd;
  private static final int gbe;
  private static final int gbf;
  public String field_abtestkey;
  public long field_endTime;
  public String field_expId;
  public boolean field_noReport;
  public int field_prioritylevel;
  public long field_sequence;
  public long field_startTime;
  public String field_value;
  private boolean gaQ;
  private boolean gaR;
  private boolean gaS;
  private boolean gaT;
  private boolean gaU;
  private boolean gaV;
  private boolean gaW;
  private boolean gaX;
  
  static
  {
    GMTrace.i(4137798336512L, 30829);
    gaA = new String[0];
    gaY = "abtestkey".hashCode();
    gaZ = "value".hashCode();
    gba = "expId".hashCode();
    gbb = "sequence".hashCode();
    gbc = "prioritylevel".hashCode();
    gbd = "startTime".hashCode();
    gbe = "endTime".hashCode();
    gbf = "noReport".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4137798336512L, 30829);
  }
  
  public c()
  {
    GMTrace.i(4137395683328L, 30826);
    this.gaQ = true;
    this.gaR = true;
    this.gaS = true;
    this.gaT = true;
    this.gaU = true;
    this.gaV = true;
    this.gaW = true;
    this.gaX = true;
    GMTrace.o(4137395683328L, 30826);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4137529901056L, 30827);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4137529901056L, 30827);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gaY == k)
      {
        this.field_abtestkey = paramCursor.getString(i);
        this.gaQ = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gaZ == k)
        {
          this.field_value = paramCursor.getString(i);
        }
        else if (gba == k)
        {
          this.field_expId = paramCursor.getString(i);
        }
        else if (gbb == k)
        {
          this.field_sequence = paramCursor.getLong(i);
        }
        else if (gbc == k)
        {
          this.field_prioritylevel = paramCursor.getInt(i);
        }
        else if (gbd == k)
        {
          this.field_startTime = paramCursor.getLong(i);
        }
        else if (gbe == k)
        {
          this.field_endTime = paramCursor.getLong(i);
        }
        else
        {
          if (gbf == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              this.field_noReport = bool;
              break;
            }
          }
          if (gaJ == k) {
            this.uvp = paramCursor.getLong(i);
          }
        }
      }
    }
    GMTrace.o(4137529901056L, 30827);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4137664118784L, 30828);
    ContentValues localContentValues = new ContentValues();
    if (this.gaQ) {
      localContentValues.put("abtestkey", this.field_abtestkey);
    }
    if (this.gaR) {
      localContentValues.put("value", this.field_value);
    }
    if (this.gaS) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.gaT) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.gaU) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.gaV) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.gaW) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.gaX) {
      localContentValues.put("noReport", Boolean.valueOf(this.field_noReport));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4137664118784L, 30828);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */