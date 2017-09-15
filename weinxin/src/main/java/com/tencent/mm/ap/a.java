package com.tencent.mm.ap;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;

public final class a
{
  int fRM;
  public int hNy;
  private String hre;
  private String hrf;
  private int hrg;
  private int hrh;
  private String path;
  public String username;
  
  public a()
  {
    GMTrace.i(12939260067840L, 96405);
    this.fRM = -1;
    this.username = "";
    this.hNy = 0;
    this.path = "";
    this.hre = "";
    this.hrf = "";
    this.hrg = 0;
    this.hrh = 0;
    GMTrace.o(12939260067840L, 96405);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(12939394285568L, 96406);
    this.username = paramCursor.getString(0);
    this.hNy = paramCursor.getInt(1);
    this.path = paramCursor.getString(2);
    this.hre = paramCursor.getString(3);
    this.hrf = paramCursor.getString(4);
    this.hrg = paramCursor.getInt(5);
    this.hrh = paramCursor.getInt(6);
    GMTrace.o(12939394285568L, 96406);
  }
  
  public final String getUsername()
  {
    GMTrace.i(12939662721024L, 96408);
    if (this.username == null)
    {
      GMTrace.o(12939662721024L, 96408);
      return "";
    }
    String str = this.username;
    GMTrace.o(12939662721024L, 96408);
    return str;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(12939528503296L, 96407);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.fRM & 0x2) != 0) {
      localContentValues.put("bgflag", Integer.valueOf(this.hNy));
    }
    if ((this.fRM & 0x4) != 0)
    {
      if (this.path == null)
      {
        str = "";
        localContentValues.put("path", str);
      }
    }
    else
    {
      if ((this.fRM & 0x8) != 0)
      {
        if (this.hre != null) {
          break label201;
        }
        str = "";
        label103:
        localContentValues.put("reserved1", str);
      }
      if ((this.fRM & 0x10) != 0) {
        if (this.hrf != null) {
          break label209;
        }
      }
    }
    label201:
    label209:
    for (String str = "";; str = this.hrf)
    {
      localContentValues.put("reserved2", str);
      if ((this.fRM & 0x20) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hrg));
      }
      if ((this.fRM & 0x40) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hrh));
      }
      GMTrace.o(12939528503296L, 96407);
      return localContentValues;
      str = this.path;
      break;
      str = this.hre;
      break label103;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */