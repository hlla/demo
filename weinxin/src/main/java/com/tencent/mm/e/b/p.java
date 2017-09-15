package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class p
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gcB;
  private static final int gfy;
  private static final int gfz;
  public String field_appId;
  public long field_flag;
  public int field_sortId;
  private boolean gck;
  private boolean gfw;
  private boolean gfx;
  
  static
  {
    GMTrace.i(4116860370944L, 30673);
    gaA = new String[0];
    gfy = "flag".hashCode();
    gcB = "appId".hashCode();
    gfz = "sortId".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4116860370944L, 30673);
  }
  
  public p()
  {
    GMTrace.i(4116457717760L, 30670);
    this.gfw = true;
    this.gck = true;
    this.gfx = true;
    GMTrace.o(4116457717760L, 30670);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4116591935488L, 30671);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4116591935488L, 30671);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gfy == k) {
        this.field_flag = paramCursor.getLong(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (gcB == k) {
          this.field_appId = paramCursor.getString(i);
        } else if (gfz == k) {
          this.field_sortId = paramCursor.getInt(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4116591935488L, 30671);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4116726153216L, 30672);
    ContentValues localContentValues = new ContentValues();
    if (this.gfw) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_appId == null) {
      this.field_appId = "";
    }
    if (this.gck) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.gfx) {
      localContentValues.put("sortId", Integer.valueOf(this.field_sortId));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4116726153216L, 30672);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */