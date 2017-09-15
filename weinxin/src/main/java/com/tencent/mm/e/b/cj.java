package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class cj
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gcB;
  private static final int gez;
  private static final int gzl;
  private static final int gzm;
  private static final int gzn;
  public String field_appId;
  public int field_msgState;
  public int field_msgTypeFlag;
  public String field_packageName;
  public int field_sceneFlag;
  public int field_status;
  private boolean gaM;
  private boolean gck;
  private boolean ged;
  private boolean gzi;
  private boolean gzj;
  private boolean gzk;
  
  static
  {
    GMTrace.i(4118470983680L, 30685);
    gaA = new String[0];
    gcB = "appId".hashCode();
    gez = "packageName".hashCode();
    gaP = "status".hashCode();
    gzl = "sceneFlag".hashCode();
    gzm = "msgTypeFlag".hashCode();
    gzn = "msgState".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4118470983680L, 30685);
  }
  
  public cj()
  {
    GMTrace.i(4118068330496L, 30682);
    this.gck = true;
    this.ged = true;
    this.gaM = true;
    this.gzi = true;
    this.gzj = true;
    this.gzk = true;
    GMTrace.o(4118068330496L, 30682);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4118202548224L, 30683);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4118202548224L, 30683);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gcB == k)
      {
        this.field_appId = paramCursor.getString(i);
        this.gck = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gez == k) {
          this.field_packageName = paramCursor.getString(i);
        } else if (gaP == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (gzl == k) {
          this.field_sceneFlag = paramCursor.getInt(i);
        } else if (gzm == k) {
          this.field_msgTypeFlag = paramCursor.getInt(i);
        } else if (gzn == k) {
          this.field_msgState = paramCursor.getInt(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4118202548224L, 30683);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4118336765952L, 30684);
    ContentValues localContentValues = new ContentValues();
    if (this.gck) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ged) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.gzi) {
      localContentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
    }
    if (this.gzj) {
      localContentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
    }
    if (this.gzk) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4118336765952L, 30684);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */