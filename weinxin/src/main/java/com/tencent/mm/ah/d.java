package com.tencent.mm.ah;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class d
{
  int cFR;
  public int fRM;
  public long fTG;
  int gxA;
  public long hEG;
  public String hEH;
  String hEI;
  public String hEJ;
  public int hEK;
  int hEL;
  private String hEM;
  int hEN;
  public long hEO;
  int hEP;
  public int hEQ;
  public String hER;
  int hES;
  private boolean hET;
  private boolean hEU;
  private boolean hEV;
  private boolean hEW;
  private boolean hEX;
  private boolean hEY;
  private boolean hEZ;
  private boolean hFa;
  private boolean hFb;
  private boolean hFc;
  private boolean hFd;
  private boolean hFe;
  boolean hFf;
  private boolean hFg;
  boolean hFh;
  private boolean hFi;
  private boolean hFj;
  private boolean hFk;
  private boolean hFl;
  public int hrb;
  public int offset;
  public int status;
  
  public d()
  {
    GMTrace.i(3531268423680L, 26310);
    this.fRM = -2;
    this.hEH = "";
    this.hEI = "";
    this.hEJ = "";
    this.hEM = "";
    this.hEQ = 0;
    this.gxA = 0;
    this.hER = "";
    this.hES = 1;
    GMTrace.o(3531268423680L, 26310);
  }
  
  public final String GA()
  {
    GMTrace.i(3533013254144L, 26323);
    String str = this.hEH;
    GMTrace.o(3533013254144L, 26323);
    return str;
  }
  
  public final boolean GB()
  {
    GMTrace.i(3533818560512L, 26329);
    if ((this.hrb != 0) && (this.hrb == this.offset))
    {
      GMTrace.o(3533818560512L, 26329);
      return true;
    }
    GMTrace.o(3533818560512L, 26329);
    return false;
  }
  
  public final boolean GC()
  {
    GMTrace.i(3533952778240L, 26330);
    if (this.hEQ > 0)
    {
      GMTrace.o(3533952778240L, 26330);
      return true;
    }
    GMTrace.o(3533952778240L, 26330);
    return false;
  }
  
  public final void GD()
  {
    GMTrace.i(3534758084608L, 26336);
    this.hET = false;
    this.hEU = false;
    this.hEV = false;
    this.hEW = false;
    this.hEX = false;
    this.hEY = false;
    this.hEZ = false;
    this.hFa = false;
    this.hFb = false;
    this.hFc = false;
    this.hFd = false;
    this.hFe = false;
    this.hFf = false;
    this.hFg = false;
    this.hFh = false;
    this.hFi = false;
    this.hFj = false;
    this.hFk = false;
    this.hFl = false;
    GMTrace.o(3534758084608L, 26336);
  }
  
  public final long Gy()
  {
    GMTrace.i(3531939512320L, 26315);
    long l = this.hEO;
    GMTrace.o(3531939512320L, 26315);
    return l;
  }
  
  public final long Gz()
  {
    GMTrace.i(3532207947776L, 26317);
    long l = this.hEG;
    GMTrace.o(3532207947776L, 26317);
    return l;
  }
  
  public final void ag(long paramLong)
  {
    GMTrace.i(3532073730048L, 26316);
    this.hEO = paramLong;
    this.hFb = true;
    GMTrace.o(3532073730048L, 26316);
  }
  
  public final void ah(long paramLong)
  {
    GMTrace.i(3532342165504L, 26318);
    this.hEG = paramLong;
    this.hET = true;
    GMTrace.o(3532342165504L, 26318);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(3534221213696L, 26332);
    this.hEG = paramCursor.getInt(0);
    this.fTG = paramCursor.getLong(1);
    this.offset = paramCursor.getInt(2);
    this.hrb = paramCursor.getInt(3);
    this.hEH = paramCursor.getString(4);
    this.hEJ = paramCursor.getString(5);
    this.hEN = paramCursor.getInt(6);
    this.hEO = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.hEP = paramCursor.getInt(9);
    this.hEQ = paramCursor.getInt(10);
    this.cFR = paramCursor.getInt(11);
    this.hER = paramCursor.getString(12);
    this.gxA = paramCursor.getInt(14);
    this.hES = paramCursor.getInt(15);
    this.hEM = paramCursor.getString(16);
    this.hEK = paramCursor.getInt(17);
    this.hEI = paramCursor.getString(18);
    this.hEL = paramCursor.getInt(19);
    GMTrace.o(3534221213696L, 26332);
  }
  
  public final void dv(int paramInt)
  {
    GMTrace.i(3531536859136L, 26312);
    this.status = paramInt;
    this.hFc = true;
    GMTrace.o(3531536859136L, 26312);
  }
  
  public final void fM(int paramInt)
  {
    GMTrace.i(3531671076864L, 26313);
    this.hEP = paramInt;
    this.hFd = true;
    GMTrace.o(3531671076864L, 26313);
  }
  
  public final void fN(int paramInt)
  {
    GMTrace.i(3531805294592L, 26314);
    this.hEN = paramInt;
    this.hFa = true;
    GMTrace.o(3531805294592L, 26314);
  }
  
  public final void fO(int paramInt)
  {
    GMTrace.i(3532879036416L, 26322);
    this.hrb = paramInt;
    this.hEW = true;
    GMTrace.o(3532879036416L, 26322);
  }
  
  public final void fP(int paramInt)
  {
    GMTrace.i(3533550125056L, 26327);
    this.hEQ = paramInt;
    this.hFe = true;
    GMTrace.o(3533550125056L, 26327);
  }
  
  public final void fQ(int paramInt)
  {
    GMTrace.i(3533684342784L, 26328);
    this.hEL = paramInt;
    this.hFl = true;
    GMTrace.o(3533684342784L, 26328);
  }
  
  public final void fR(int paramInt)
  {
    GMTrace.i(3534355431424L, 26333);
    if (this.hES != paramInt) {
      this.hFi = true;
    }
    this.hES = paramInt;
    GMTrace.o(3534355431424L, 26333);
  }
  
  public final void fS(int paramInt)
  {
    GMTrace.i(3534489649152L, 26334);
    this.hEK = paramInt;
    this.hFk = true;
    GMTrace.o(3534489649152L, 26334);
  }
  
  public final void jo(String paramString)
  {
    GMTrace.i(3531402641408L, 26311);
    this.hEM = paramString;
    this.hFj = true;
    GMTrace.o(3531402641408L, 26311);
  }
  
  public final void jp(String paramString)
  {
    GMTrace.i(3533147471872L, 26324);
    this.hEH = paramString;
    this.hEX = true;
    GMTrace.o(3533147471872L, 26324);
  }
  
  public final void jq(String paramString)
  {
    GMTrace.i(3533281689600L, 26325);
    this.hEI = paramString;
    this.hEY = true;
    GMTrace.o(3533281689600L, 26325);
  }
  
  public final void jr(String paramString)
  {
    GMTrace.i(3533415907328L, 26326);
    this.hEJ = paramString;
    this.hEZ = true;
    GMTrace.o(3533415907328L, 26326);
  }
  
  public final void js(String paramString)
  {
    GMTrace.i(3534086995968L, 26331);
    if (((this.hER == null) && (paramString != null)) || ((this.hER != null) && (!this.hER.equals(paramString)))) {
      this.hFg = true;
    }
    this.hER = paramString;
    GMTrace.o(3534086995968L, 26331);
  }
  
  public final long pI()
  {
    GMTrace.i(3532476383232L, 26319);
    long l = this.fTG;
    GMTrace.o(3532476383232L, 26319);
    return l;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(3534623866880L, 26335);
    ContentValues localContentValues = new ContentValues();
    if (this.hET) {
      localContentValues.put("id", Long.valueOf(this.hEG));
    }
    if (this.hEU) {
      localContentValues.put("msgSvrId", Long.valueOf(this.fTG));
    }
    if (this.hEV) {
      localContentValues.put("offset", Integer.valueOf(this.offset));
    }
    if (this.hEW) {
      localContentValues.put("totalLen", Integer.valueOf(this.hrb));
    }
    if (this.hEX) {
      localContentValues.put("bigImgPath", this.hEH);
    }
    if (this.hEY) {
      localContentValues.put("midImgPath", this.hEI);
    }
    if (this.hEZ) {
      localContentValues.put("thumbImgPath", this.hEJ);
    }
    if (this.hFa) {
      localContentValues.put("createtime", Integer.valueOf(this.hEN));
    }
    if (this.hFb) {
      localContentValues.put("msglocalid", Long.valueOf(this.hEO));
    }
    if (this.hFc) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if (this.hFd) {
      localContentValues.put("nettimes", Integer.valueOf(this.hEP));
    }
    if (this.hFe) {
      localContentValues.put("reserved1", Integer.valueOf(this.hEQ));
    }
    if (this.hFf) {
      localContentValues.put("reserved2", Integer.valueOf(this.cFR));
    }
    if (this.hFg) {
      localContentValues.put("reserved3", this.hER);
    }
    if (this.hFh) {
      localContentValues.put("hashdthumb", Integer.valueOf(this.gxA));
    }
    if (this.hFi) {
      if (this.offset >= this.hrb) {
        break label421;
      }
    }
    label421:
    for (int i = 0;; i = 1)
    {
      localContentValues.put("iscomplete", Integer.valueOf(i));
      if (this.hFj) {
        localContentValues.put("origImgMD5", this.hEM);
      }
      if (this.hFk) {
        localContentValues.put("compressType", Integer.valueOf(this.hEK));
      }
      if (this.hFl) {
        localContentValues.put("forwardType", Integer.valueOf(this.hEL));
      }
      GMTrace.o(3534623866880L, 26335);
      return localContentValues;
    }
  }
  
  public final void setOffset(int paramInt)
  {
    int i = 0;
    GMTrace.i(3532744818688L, 26321);
    if (this.offset != paramInt) {
      this.hEV = true;
    }
    this.offset = paramInt;
    v.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.hEO), Integer.valueOf(this.hrb) });
    if (paramInt < this.hrb) {}
    for (paramInt = i;; paramInt = 1)
    {
      fR(paramInt);
      GMTrace.o(3532744818688L, 26321);
      return;
    }
  }
  
  public final void y(long paramLong)
  {
    GMTrace.i(3532610600960L, 26320);
    if (this.fTG != paramLong) {
      this.hEU = true;
    }
    this.fTG = paramLong;
    GMTrace.o(3532610600960L, 26320);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */