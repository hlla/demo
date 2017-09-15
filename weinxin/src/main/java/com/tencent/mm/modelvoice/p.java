package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;

public final class p
{
  public String clientId;
  public int fRM;
  public String fRV;
  public long fTG;
  public String fyw;
  int gxu;
  String gxv;
  int hJz;
  public int hYB;
  public String hZN;
  public int hZP;
  public long hZS;
  public long hZT;
  public int hZW;
  int hZX;
  public int hrb;
  String iaK;
  int iaR;
  public int ibS;
  long ibT;
  public int status;
  
  public p()
  {
    GMTrace.i(539152613376L, 4017);
    this.fRM = -1;
    this.iaR = 0;
    this.fyw = "";
    this.fRV = "";
    this.clientId = "";
    this.fTG = 0L;
    this.hYB = 0;
    this.hZP = 0;
    this.hrb = 0;
    this.status = 0;
    this.hZS = 0L;
    this.hZT = 0L;
    this.ibS = 0;
    this.hZW = 0;
    this.hZN = "";
    this.hZX = 0;
    this.iaK = "";
    this.gxv = "";
    this.gxu = 0;
    this.hJz = 0;
    this.ibT = 0L;
    GMTrace.o(539152613376L, 4017);
  }
  
  public final boolean LC()
  {
    GMTrace.i(538615742464L, 4013);
    if ((this.status == 5) || (this.status == 6))
    {
      GMTrace.o(538615742464L, 4013);
      return true;
    }
    GMTrace.o(538615742464L, 4013);
    return false;
  }
  
  public final boolean LD()
  {
    GMTrace.i(538749960192L, 4014);
    if (((this.status > 1) && (this.status <= 3)) || (this.status == 8))
    {
      GMTrace.o(538749960192L, 4014);
      return true;
    }
    GMTrace.o(538749960192L, 4014);
    return false;
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(539018395648L, 4016);
    this.fyw = paramCursor.getString(0);
    this.fRV = paramCursor.getString(1);
    this.fTG = paramCursor.getLong(2);
    this.hYB = paramCursor.getInt(3);
    this.hZP = paramCursor.getInt(4);
    this.hrb = paramCursor.getInt(5);
    this.status = paramCursor.getInt(6);
    this.hZS = paramCursor.getLong(7);
    this.hZT = paramCursor.getLong(8);
    this.clientId = paramCursor.getString(9);
    this.ibS = paramCursor.getInt(10);
    this.hZW = paramCursor.getInt(11);
    this.hZN = paramCursor.getString(12);
    this.hZX = paramCursor.getInt(13);
    this.iaK = paramCursor.getString(14);
    this.gxv = paramCursor.getString(15);
    this.gxu = paramCursor.getInt(16);
    this.hJz = paramCursor.getInt(17);
    this.ibT = paramCursor.getLong(18);
    GMTrace.o(539018395648L, 4016);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(538884177920L, 4015);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0) {
      localContentValues.put("FileName", this.fyw);
    }
    if ((this.fRM & 0x2) != 0) {
      localContentValues.put("User", this.fRV);
    }
    if ((this.fRM & 0x4) != 0) {
      localContentValues.put("MsgId", Long.valueOf(this.fTG));
    }
    if ((this.fRM & 0x8) != 0) {
      localContentValues.put("NetOffset", Integer.valueOf(this.hYB));
    }
    if ((this.fRM & 0x10) != 0) {
      localContentValues.put("FileNowSize", Integer.valueOf(this.hZP));
    }
    if ((this.fRM & 0x20) != 0) {
      localContentValues.put("TotalLen", Integer.valueOf(this.hrb));
    }
    if ((this.fRM & 0x40) != 0) {
      localContentValues.put("Status", Integer.valueOf(this.status));
    }
    if ((this.fRM & 0x80) != 0) {
      localContentValues.put("CreateTime", Long.valueOf(this.hZS));
    }
    if ((this.fRM & 0x100) != 0) {
      localContentValues.put("LastModifyTime", Long.valueOf(this.hZT));
    }
    if ((this.fRM & 0x200) != 0) {
      localContentValues.put("ClientId", this.clientId);
    }
    if ((this.fRM & 0x400) != 0) {
      localContentValues.put("VoiceLength", Integer.valueOf(this.ibS));
    }
    if ((this.fRM & 0x800) != 0) {
      localContentValues.put("MsgLocalId", Integer.valueOf(this.hZW));
    }
    if ((this.fRM & 0x1000) != 0) {
      localContentValues.put("Human", this.hZN);
    }
    if ((this.fRM & 0x2000) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.hZX));
    }
    if ((this.fRM & 0x4000) != 0) {
      localContentValues.put("reserved2", this.iaK);
    }
    if ((this.fRM & 0x8000) != 0) {
      localContentValues.put("MsgSource", this.gxv);
    }
    if ((this.fRM & 0x10000) != 0) {
      localContentValues.put("MsgFlag", Integer.valueOf(this.gxu));
    }
    if ((this.fRM & 0x20000) != 0) {
      localContentValues.put("MsgSeq", Integer.valueOf(this.hJz));
    }
    if ((this.fRM & 0x40000) != 0) {
      localContentValues.put("MasterBufId", Long.valueOf(this.ibT));
    }
    GMTrace.o(538884177920L, 4015);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */