package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class v
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gfX;
  private static final int ggJ;
  public String field_brandUserName;
  public String field_userId;
  private boolean gfJ;
  private boolean ggI;
  
  static
  {
    GMTrace.i(4139677384704L, 30843);
    gaA = new String[0];
    gfX = "brandUserName".hashCode();
    ggJ = "userId".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4139677384704L, 30843);
  }
  
  public v()
  {
    GMTrace.i(4139274731520L, 30840);
    this.gfJ = true;
    this.ggI = true;
    GMTrace.o(4139274731520L, 30840);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4139408949248L, 30841);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4139408949248L, 30841);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gfX == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
        this.gfJ = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (ggJ == k) {
          this.field_userId = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4139408949248L, 30841);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4139543166976L, 30842);
    ContentValues localContentValues = new ContentValues();
    if (this.gfJ) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.ggI) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4139543166976L, 30842);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */