package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class s
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbd;
  private static final int gbe;
  private static final int gfE;
  public long field_endTime;
  public String field_sessionName;
  public long field_startTime;
  private boolean gaV;
  private boolean gaW;
  private boolean gfB;
  
  static
  {
    GMTrace.i(17945044451328L, 133701);
    gaA = new String[0];
    gfE = "sessionName".hashCode();
    gbd = "startTime".hashCode();
    gbe = "endTime".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(17945044451328L, 133701);
  }
  
  public s()
  {
    GMTrace.i(17944641798144L, 133698);
    this.gfB = true;
    this.gaV = true;
    this.gaW = true;
    GMTrace.o(17944641798144L, 133698);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(17944776015872L, 133699);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(17944776015872L, 133699);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gfE == k) {
        this.field_sessionName = paramCursor.getString(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (gbd == k) {
          this.field_startTime = paramCursor.getLong(i);
        } else if (gbe == k) {
          this.field_endTime = paramCursor.getLong(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(17944776015872L, 133699);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(17944910233600L, 133700);
    ContentValues localContentValues = new ContentValues();
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.gfB) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if (this.gaV) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.gaW) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(17944910233600L, 133700);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */