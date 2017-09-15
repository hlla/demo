package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class dh
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gcB;
  private static final int gdj;
  private static final int geH;
  public String field_appId;
  public String field_openId;
  public String field_username;
  private boolean gck;
  private boolean gdi;
  private boolean gel;
  
  static
  {
    GMTrace.i(4146388271104L, 30893);
    gaA = new String[0];
    geH = "openId".hashCode();
    gcB = "appId".hashCode();
    gdj = "username".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4146388271104L, 30893);
  }
  
  public dh()
  {
    GMTrace.i(4145985617920L, 30890);
    this.gel = true;
    this.gck = true;
    this.gdi = true;
    GMTrace.o(4145985617920L, 30890);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4146119835648L, 30891);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4146119835648L, 30891);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (geH == k)
      {
        this.field_openId = paramCursor.getString(i);
        this.gel = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gcB == k) {
          this.field_appId = paramCursor.getString(i);
        } else if (gdj == k) {
          this.field_username = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4146119835648L, 30891);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4146254053376L, 30892);
    ContentValues localContentValues = new ContentValues();
    if (this.gel) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.gck) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.gdi) {
      localContentValues.put("username", this.field_username);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4146254053376L, 30892);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */