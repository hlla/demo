package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class d
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gba;
  private static final int gbb;
  private static final int gbc;
  private static final int gbd;
  private static final int gbe;
  private static final int gbk;
  private static final int gbl;
  private static final int gbm;
  private static final int gbn;
  public String field_business;
  public long field_endTime;
  public String field_expId;
  public String field_layerId;
  public boolean field_needReport;
  public int field_prioritylevel;
  public String field_rawXML;
  public long field_sequence;
  public long field_startTime;
  private boolean gaS;
  private boolean gaT;
  private boolean gaU;
  private boolean gaV;
  private boolean gaW;
  private boolean gbg;
  private boolean gbh;
  private boolean gbi;
  private boolean gbj;
  
  static
  {
    GMTrace.i(4132698062848L, 30791);
    gaA = new String[0];
    gbk = "layerId".hashCode();
    gbl = "business".hashCode();
    gba = "expId".hashCode();
    gbb = "sequence".hashCode();
    gbc = "prioritylevel".hashCode();
    gbd = "startTime".hashCode();
    gbe = "endTime".hashCode();
    gbm = "needReport".hashCode();
    gbn = "rawXML".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4132698062848L, 30791);
  }
  
  public d()
  {
    GMTrace.i(4132295409664L, 30788);
    this.gbg = true;
    this.gbh = true;
    this.gaS = true;
    this.gaT = true;
    this.gaU = true;
    this.gaV = true;
    this.gaW = true;
    this.gbi = true;
    this.gbj = true;
    GMTrace.o(4132295409664L, 30788);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4132429627392L, 30789);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4132429627392L, 30789);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gbk == k)
      {
        this.field_layerId = paramCursor.getString(i);
        this.gbg = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gbl == k)
        {
          this.field_business = paramCursor.getString(i);
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
          if (gbm == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              this.field_needReport = bool;
              break;
            }
          }
          if (gbn == k) {
            this.field_rawXML = paramCursor.getString(i);
          } else if (gaJ == k) {
            this.uvp = paramCursor.getLong(i);
          }
        }
      }
    }
    GMTrace.o(4132429627392L, 30789);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4132563845120L, 30790);
    ContentValues localContentValues = new ContentValues();
    if (this.gbg) {
      localContentValues.put("layerId", this.field_layerId);
    }
    if (this.gbh) {
      localContentValues.put("business", this.field_business);
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
    if (this.gbi) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.gbj) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4132563845120L, 30790);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */