package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class f
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbL;
  private static final int gci;
  private static final int gcj;
  public int field_scene;
  public String field_ticket;
  public String field_userName;
  private boolean gbp;
  private boolean gcg;
  private boolean gch;
  
  static
  {
    GMTrace.i(4172292292608L, 31086);
    gaA = new String[0];
    gbL = "userName".hashCode();
    gci = "scene".hashCode();
    gcj = "ticket".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4172292292608L, 31086);
  }
  
  public f()
  {
    GMTrace.i(4171755421696L, 31082);
    this.gbp = true;
    this.gcg = true;
    this.gch = true;
    GMTrace.o(4171755421696L, 31082);
  }
  
  public static c.a pw()
  {
    GMTrace.i(4171889639424L, 31083);
    c.a locala = new c.a();
    locala.hXn = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.uvr.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "scene";
    locala.uvr.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "ticket";
    locala.uvr.put("ticket", "TEXT");
    localStringBuilder.append(" ticket TEXT");
    locala.columns[3] = "rowid";
    locala.uvs = localStringBuilder.toString();
    GMTrace.o(4171889639424L, 31083);
    return locala;
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4172023857152L, 31084);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4172023857152L, 31084);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gbL == k) {
        this.field_userName = paramCursor.getString(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (gci == k) {
          this.field_scene = paramCursor.getInt(i);
        } else if (gcj == k) {
          this.field_ticket = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4172023857152L, 31084);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4172158074880L, 31085);
    ContentValues localContentValues = new ContentValues();
    if (this.gbp) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.gcg) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.gch) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4172158074880L, 31085);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */