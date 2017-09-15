package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class r
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gfE;
  private static final int gfH;
  public String field_msgListDataId;
  public String field_sessionName;
  private boolean gfB;
  private boolean gfG;
  
  static
  {
    GMTrace.i(17946118193152L, 133709);
    gaA = new String[0];
    gfH = "msgListDataId".hashCode();
    gfE = "sessionName".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(17946118193152L, 133709);
  }
  
  public r()
  {
    GMTrace.i(17945715539968L, 133706);
    this.gfG = true;
    this.gfB = true;
    GMTrace.o(17945715539968L, 133706);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(17945849757696L, 133707);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(17945849757696L, 133707);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gfH == k)
      {
        this.field_msgListDataId = paramCursor.getString(i);
        this.gfG = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gfE == k) {
          this.field_sessionName = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(17945849757696L, 133707);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(17945983975424L, 133708);
    ContentValues localContentValues = new ContentValues();
    if (this.gfG) {
      localContentValues.put("msgListDataId", this.field_msgListDataId);
    }
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.gfB) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(17945983975424L, 133708);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */