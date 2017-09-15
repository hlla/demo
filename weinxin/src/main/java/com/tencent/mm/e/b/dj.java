package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class dj
  extends c
{
  private static final int gEB;
  public static final String[] gaA;
  private static final int gaI;
  private static final int gaJ;
  private static final int gbV;
  public String field_cmsgId;
  public String field_content;
  public long field_msgId;
  private boolean gEA;
  private boolean gaE;
  private boolean gbz;
  
  static
  {
    GMTrace.i(4160212697088L, 30996);
    gaA = new String[0];
    gaI = "msgId".hashCode();
    gEB = "cmsgId".hashCode();
    gbV = "content".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4160212697088L, 30996);
  }
  
  public dj()
  {
    GMTrace.i(4159810043904L, 30993);
    this.gaE = true;
    this.gEA = true;
    this.gbz = true;
    GMTrace.o(4159810043904L, 30993);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4159944261632L, 30994);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4159944261632L, 30994);
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
        if (gEB == k) {
          this.field_cmsgId = paramCursor.getString(i);
        } else if (gbV == k) {
          this.field_content = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4159944261632L, 30994);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4160078479360L, 30995);
    ContentValues localContentValues = new ContentValues();
    if (this.gaE) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.gEA) {
      localContentValues.put("cmsgId", this.field_cmsgId);
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.gbz) {
      localContentValues.put("content", this.field_content);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4160078479360L, 30995);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */