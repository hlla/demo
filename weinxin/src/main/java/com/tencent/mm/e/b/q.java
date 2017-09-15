package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public abstract class q
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gfD;
  private static final int gfE;
  private static final int gfF;
  public String field_deviceId;
  public ec field_moveTime;
  public String field_sessionName;
  private boolean gfA;
  private boolean gfB;
  private boolean gfC;
  
  static
  {
    GMTrace.i(17944507580416L, 133697);
    gaA = new String[0];
    gfD = "deviceId".hashCode();
    gfE = "sessionName".hashCode();
    gfF = "moveTime".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(17944507580416L, 133697);
  }
  
  public q()
  {
    GMTrace.i(17944104927232L, 133694);
    this.gfA = true;
    this.gfB = true;
    this.gfC = true;
    GMTrace.o(17944104927232L, 133694);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(17944239144960L, 133695);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(17944239144960L, 133695);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gfD == k) {
        this.field_deviceId = paramCursor.getString(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (gfE == k) {
          this.field_sessionName = paramCursor.getString(i);
        } else if (gfF == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_moveTime = ((ec)new ec().aD(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            v.e("MicroMsg.SDK.BaseBackupMoveTime", localIOException.getMessage());
          }
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(17944239144960L, 133695);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(17944373362688L, 133696);
    ContentValues localContentValues = new ContentValues();
    if (this.field_deviceId == null) {
      this.field_deviceId = "";
    }
    if (this.gfA) {
      localContentValues.put("deviceId", this.field_deviceId);
    }
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.gfB) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if ((this.gfC) && (this.field_moveTime != null)) {}
    try
    {
      localContentValues.put("moveTime", this.field_moveTime.toByteArray());
      if (this.uvp > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.uvp));
      }
      GMTrace.o(17944373362688L, 133696);
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        v.e("MicroMsg.SDK.BaseBackupMoveTime", localIOException.getMessage());
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */