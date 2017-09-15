package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;

public final class ab
{
  int fRM;
  int hBB;
  int hBC;
  int hBD;
  int hBE;
  int hBF;
  int hBG;
  String hBH;
  String hBI;
  
  public ab()
  {
    GMTrace.i(4444620062720L, 33115);
    this.fRM = -1;
    this.hBB = 0;
    this.hBC = 0;
    this.hBD = 0;
    this.hBE = 0;
    this.hBF = 0;
    this.hBG = 0;
    this.hBH = "";
    this.hBI = "";
    GMTrace.o(4444620062720L, 33115);
  }
  
  public final ContentValues FM()
  {
    GMTrace.i(4444888498176L, 33117);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0) {
      localContentValues.put("grouopid", Integer.valueOf(this.hBB));
    }
    if ((this.fRM & 0x2) != 0) {
      localContentValues.put("membernum", Integer.valueOf(this.hBC));
    }
    if ((this.fRM & 0x4) != 0) {
      localContentValues.put("weixinnum", Integer.valueOf(this.hBD));
    }
    if ((this.fRM & 0x8) != 0) {
      localContentValues.put("insert_time", Integer.valueOf(this.hBE));
    }
    if ((this.fRM & 0x10) != 0) {
      localContentValues.put("lastupdate_time", Integer.valueOf(this.hBF));
    }
    if ((this.fRM & 0x20) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.hBG));
    }
    if ((this.fRM & 0x40) != 0) {
      localContentValues.put("updatekey", FN());
    }
    if ((this.fRM & 0x80) != 0) {
      localContentValues.put("groupname", FO());
    }
    GMTrace.o(4444888498176L, 33117);
    return localContentValues;
  }
  
  public final String FN()
  {
    GMTrace.i(4445022715904L, 33118);
    if (this.hBH == null)
    {
      GMTrace.o(4445022715904L, 33118);
      return "";
    }
    String str = this.hBH;
    GMTrace.o(4445022715904L, 33118);
    return str;
  }
  
  public final String FO()
  {
    GMTrace.i(4445156933632L, 33119);
    if (this.hBI == null)
    {
      GMTrace.o(4445156933632L, 33119);
      return "";
    }
    String str = this.hBI;
    GMTrace.o(4445156933632L, 33119);
    return str;
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4444754280448L, 33116);
    this.hBB = paramCursor.getInt(0);
    this.hBC = paramCursor.getInt(1);
    this.hBD = paramCursor.getInt(2);
    this.hBE = paramCursor.getInt(3);
    this.hBF = paramCursor.getInt(4);
    this.hBG = paramCursor.getInt(5);
    this.hBH = paramCursor.getString(6);
    this.hBI = paramCursor.getString(7);
    GMTrace.o(4444754280448L, 33116);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */