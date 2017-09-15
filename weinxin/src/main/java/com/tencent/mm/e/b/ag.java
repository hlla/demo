package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class ag
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gdj;
  private static final int gkK;
  public byte[] field_cmdbuf;
  public String field_username;
  private boolean gdi;
  private boolean gkJ;
  
  static
  {
    GMTrace.i(13361777475584L, 99553);
    gaA = new String[0];
    gdj = "username".hashCode();
    gkK = "cmdbuf".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(13361777475584L, 99553);
  }
  
  public ag()
  {
    GMTrace.i(13361374822400L, 99550);
    this.gdi = true;
    this.gkJ = true;
    GMTrace.o(13361374822400L, 99550);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(13361509040128L, 99551);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(13361509040128L, 99551);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gdj == k)
      {
        this.field_username = paramCursor.getString(i);
        this.gdi = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gkK == k) {
          this.field_cmdbuf = paramCursor.getBlob(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(13361509040128L, 99551);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(13361643257856L, 99552);
    ContentValues localContentValues = new ContentValues();
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.gdi) {
      localContentValues.put("username", this.field_username);
    }
    if (this.gkJ) {
      localContentValues.put("cmdbuf", this.field_cmdbuf);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(13361643257856L, 99552);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */