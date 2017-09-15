package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class al
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int glD;
  private static final int glE;
  public int field_bakLogId;
  public String field_valueStr;
  private boolean glB;
  private boolean glC;
  
  static
  {
    GMTrace.i(13104079437824L, 97633);
    gaA = new String[0];
    glD = "bakLogId".hashCode();
    glE = "valueStr".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(13104079437824L, 97633);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(13103811002368L, 97631);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(13103811002368L, 97631);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (glD == k) {
        this.field_bakLogId = paramCursor.getInt(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (glE == k) {
          this.field_valueStr = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(13103811002368L, 97631);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(13103945220096L, 97632);
    ContentValues localContentValues = new ContentValues();
    if (this.glB) {
      localContentValues.put("bakLogId", Integer.valueOf(this.field_bakLogId));
    }
    if (this.glC) {
      localContentValues.put("valueStr", this.field_valueStr);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(13103945220096L, 97632);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */