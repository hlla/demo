package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class cz
  extends c
{
  private static final int gCD;
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gcT;
  public String field_key;
  public int field_position;
  private boolean gCw;
  private boolean gcS;
  
  static
  {
    GMTrace.i(4145314529280L, 30885);
    gaA = new String[0];
    gcT = "key".hashCode();
    gCD = "position".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4145314529280L, 30885);
  }
  
  public cz()
  {
    GMTrace.i(4144911876096L, 30882);
    this.gcS = true;
    this.gCw = true;
    GMTrace.o(4144911876096L, 30882);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4145046093824L, 30883);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4145046093824L, 30883);
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
        if (gCD == k) {
          this.field_position = paramCursor.getInt(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4145046093824L, 30883);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4145180311552L, 30884);
    ContentValues localContentValues = new ContentValues();
    if (this.gcS) {
      localContentValues.put("key", this.field_key);
    }
    if (this.gCw) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4145180311552L, 30884);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */