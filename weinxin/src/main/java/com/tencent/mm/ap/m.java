package com.tencent.mm.ap;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;

public final class m
{
  private String fJq;
  public int fKC;
  int fRM;
  String hNY;
  private String hre;
  private String hrf;
  private int hrg;
  private int hrh;
  public int id;
  String name;
  int size;
  public int status;
  public int version;
  
  public m()
  {
    GMTrace.i(12941944422400L, 96425);
    this.fRM = -1;
    this.id = 0;
    this.version = 0;
    this.name = "";
    this.size = 0;
    this.hNY = "";
    this.status = 0;
    this.fKC = 0;
    this.hre = "";
    this.hrf = "";
    this.hrg = 0;
    this.hrh = 0;
    this.fJq = (this.id + "_" + this.fKC);
    GMTrace.o(12941944422400L, 96425);
  }
  
  public final String HY()
  {
    GMTrace.i(12942347075584L, 96428);
    if (this.hNY == null)
    {
      GMTrace.o(12942347075584L, 96428);
      return "";
    }
    String str = this.hNY;
    GMTrace.o(12942347075584L, 96428);
    return str;
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(12942078640128L, 96426);
    this.version = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.size = paramCursor.getInt(4);
    this.hNY = paramCursor.getString(5);
    this.status = paramCursor.getInt(6);
    this.hre = paramCursor.getString(8);
    this.hrf = paramCursor.getString(9);
    this.fKC = paramCursor.getInt(7);
    this.hrh = paramCursor.getInt(11);
    this.id = paramCursor.getInt(1);
    this.hrg = paramCursor.getInt(10);
    this.fJq = paramCursor.getString(0);
    GMTrace.o(12942078640128L, 96426);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(12942212857856L, 96427);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x2) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.fRM & 0x4) != 0) {
      localContentValues.put("version", Integer.valueOf(this.version));
    }
    if ((this.fRM & 0x8) != 0)
    {
      if (this.name == null)
      {
        str = "";
        localContentValues.put("name", str);
      }
    }
    else
    {
      if ((this.fRM & 0x10) != 0) {
        localContentValues.put("size", Integer.valueOf(this.size));
      }
      if ((this.fRM & 0x20) != 0) {
        localContentValues.put("packname", HY());
      }
      if ((this.fRM & 0x40) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.fRM & 0x80) != 0) {
        localContentValues.put("type", Integer.valueOf(this.fKC));
      }
      if ((this.fRM & 0x100) != 0)
      {
        if (this.hre != null) {
          break label343;
        }
        str = "";
        label198:
        localContentValues.put("reserved1", str);
      }
      if ((this.fRM & 0x200) != 0) {
        if (this.hrf != null) {
          break label351;
        }
      }
    }
    label343:
    label351:
    for (String str = "";; str = this.hrf)
    {
      localContentValues.put("reserved2", str);
      if ((this.fRM & 0x400) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hrg));
      }
      if ((this.fRM & 0x800) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hrh));
      }
      if ((this.fRM & 0x1) != 0) {
        localContentValues.put("localId", this.id + "_" + this.fKC);
      }
      GMTrace.o(12942212857856L, 96427);
      return localContentValues;
      str = this.name;
      break;
      str = this.hre;
      break label198;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */