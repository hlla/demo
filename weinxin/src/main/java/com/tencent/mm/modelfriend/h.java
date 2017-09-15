package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;

public final class h
{
  String aIO;
  int fRM;
  int gkh;
  public long gkj;
  private String gkk;
  int gkq;
  String gkr;
  String gks;
  String gtH;
  String hAE;
  int hAF;
  String hAe;
  String hAf;
  String signature;
  public int status;
  private int type;
  String username;
  
  public h()
  {
    GMTrace.i(4446096457728L, 33126);
    this.fRM = -1;
    this.gkj = 0L;
    this.hAE = "";
    this.hAF = 0;
    this.status = 0;
    this.username = "";
    this.aIO = "";
    this.hAe = "";
    this.hAf = "";
    this.gkh = 0;
    this.gkq = 0;
    this.gkr = "";
    this.gks = "";
    this.signature = "";
    this.gtH = "";
    this.type = 0;
    this.gkk = "";
    GMTrace.o(4446096457728L, 33126);
  }
  
  public final String EV()
  {
    GMTrace.i(4446767546368L, 33131);
    if (this.aIO == null)
    {
      GMTrace.o(4446767546368L, 33131);
      return "";
    }
    String str = this.aIO;
    GMTrace.o(4446767546368L, 33131);
    return str;
  }
  
  public final String Fe()
  {
    GMTrace.i(4446499110912L, 33129);
    if (this.hAE == null)
    {
      GMTrace.o(4446499110912L, 33129);
      return "";
    }
    String str = this.hAE;
    GMTrace.o(4446499110912L, 33129);
    return str;
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4446230675456L, 33127);
    this.gkj = paramCursor.getLong(0);
    this.hAE = paramCursor.getString(1);
    this.hAF = paramCursor.getInt(2);
    this.status = paramCursor.getInt(3);
    this.username = paramCursor.getString(4);
    this.aIO = paramCursor.getString(5);
    this.hAe = paramCursor.getString(6);
    this.hAf = paramCursor.getString(7);
    this.gkh = paramCursor.getInt(8);
    this.gkq = paramCursor.getInt(9);
    this.gkr = paramCursor.getString(10);
    this.gks = paramCursor.getString(11);
    this.signature = paramCursor.getString(12);
    this.gtH = paramCursor.getString(13);
    this.type = paramCursor.getInt(14);
    this.gkk = paramCursor.getString(15);
    GMTrace.o(4446230675456L, 33127);
  }
  
  public final String getUsername()
  {
    GMTrace.i(4446633328640L, 33130);
    if (this.username == null)
    {
      GMTrace.o(4446633328640L, 33130);
      return "";
    }
    String str = this.username;
    GMTrace.o(4446633328640L, 33130);
    return str;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4446364893184L, 33128);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0) {
      localContentValues.put("fbid", Long.valueOf(this.gkj));
    }
    if ((this.fRM & 0x2) != 0) {
      localContentValues.put("fbname", Fe());
    }
    if ((this.fRM & 0x4) != 0) {
      localContentValues.put("fbimgkey", Integer.valueOf(this.hAF));
    }
    if ((this.fRM & 0x8) != 0) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if ((this.fRM & 0x10) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.fRM & 0x20) != 0) {
      localContentValues.put("nickname", EV());
    }
    if ((this.fRM & 0x40) != 0)
    {
      if (this.hAe == null)
      {
        str = "";
        localContentValues.put("nicknamepyinitial", str);
      }
    }
    else
    {
      if ((this.fRM & 0x80) != 0)
      {
        if (this.hAf != null) {
          break label426;
        }
        str = "";
        label190:
        localContentValues.put("nicknamequanpin", str);
      }
      if ((this.fRM & 0x100) != 0) {
        localContentValues.put("sex", Integer.valueOf(this.gkh));
      }
      if ((this.fRM & 0x200) != 0) {
        localContentValues.put("personalcard", Integer.valueOf(this.gkq));
      }
      if ((this.fRM & 0x400) != 0)
      {
        if (this.gkr != null) {
          break label434;
        }
        str = "";
        label266:
        localContentValues.put("province", str);
      }
      if ((this.fRM & 0x800) != 0)
      {
        if (this.gks != null) {
          break label442;
        }
        str = "";
        label294:
        localContentValues.put("city", str);
      }
      if ((this.fRM & 0x1000) != 0)
      {
        if (this.signature != null) {
          break label450;
        }
        str = "";
        label322:
        localContentValues.put("signature", str);
      }
      if ((this.fRM & 0x2000) != 0)
      {
        if (this.gtH != null) {
          break label458;
        }
        str = "";
        label350:
        localContentValues.put("alias", str);
      }
      if ((this.fRM & 0x4000) != 0) {
        localContentValues.put("type", Integer.valueOf(this.type));
      }
      if ((this.fRM & 0x8000) != 0) {
        if (this.gkk != null) {
          break label466;
        }
      }
    }
    label426:
    label434:
    label442:
    label450:
    label458:
    label466:
    for (String str = "";; str = this.gkk)
    {
      localContentValues.put("email", str);
      GMTrace.o(4446364893184L, 33128);
      return localContentValues;
      str = this.hAe;
      break;
      str = this.hAf;
      break label190;
      str = this.gkr;
      break label266;
      str = this.gks;
      break label294;
      str = this.signature;
      break label322;
      str = this.gtH;
      break label350;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */