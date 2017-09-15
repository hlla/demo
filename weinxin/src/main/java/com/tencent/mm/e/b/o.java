package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class o
  extends c
{
  public static final String[] gaA;
  private static final int gaI;
  private static final int gaJ;
  private static final int gbQ;
  private static final int gcB;
  private static final int gfs;
  private static final int gft;
  private static final int gfu;
  private static final int gfv;
  public String field_appId;
  public String field_description;
  public long field_msgId;
  public String field_source;
  public String field_title;
  public int field_type;
  public String field_xml;
  private boolean gaE;
  private boolean gbu;
  private boolean gck;
  private boolean gfo;
  private boolean gfp;
  private boolean gfq;
  private boolean gfr;
  
  static
  {
    GMTrace.i(4137261465600L, 30825);
    gaA = new String[0];
    gaI = "msgId".hashCode();
    gfs = "xml".hashCode();
    gcB = "appId".hashCode();
    gft = "title".hashCode();
    gfu = "description".hashCode();
    gfv = "source".hashCode();
    gbQ = "type".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4137261465600L, 30825);
  }
  
  public o()
  {
    GMTrace.i(4136858812416L, 30822);
    this.gaE = true;
    this.gfo = true;
    this.gck = true;
    this.gfp = true;
    this.gfq = true;
    this.gfr = true;
    this.gbu = true;
    GMTrace.o(4136858812416L, 30822);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4136993030144L, 30823);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4136993030144L, 30823);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gaI == k)
      {
        this.field_msgId = paramCursor.getLong(i);
        this.gaE = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gfs == k) {
          this.field_xml = paramCursor.getString(i);
        } else if (gcB == k) {
          this.field_appId = paramCursor.getString(i);
        } else if (gft == k) {
          this.field_title = paramCursor.getString(i);
        } else if (gfu == k) {
          this.field_description = paramCursor.getString(i);
        } else if (gfv == k) {
          this.field_source = paramCursor.getString(i);
        } else if (gbQ == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4136993030144L, 30823);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4137127247872L, 30824);
    ContentValues localContentValues = new ContentValues();
    if (this.gaE) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.gfo) {
      localContentValues.put("xml", this.field_xml);
    }
    if (this.gck) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.gfp) {
      localContentValues.put("title", this.field_title);
    }
    if (this.gfq) {
      localContentValues.put("description", this.field_description);
    }
    if (this.gfr) {
      localContentValues.put("source", this.field_source);
    }
    if (this.gbu) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4137127247872L, 30824);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */