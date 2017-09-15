package com.tencent.mm.x;

import android.content.ContentValues;
import com.tencent.gmtrace.GMTrace;

public final class f
{
  int fRM;
  int hqY;
  int hqZ;
  String hra;
  int hrb;
  int hrc;
  int hrd;
  String hre;
  String hrf;
  int hrg;
  int hrh;
  String username;
  
  public f()
  {
    GMTrace.i(380507258880L, 2835);
    this.fRM = -1;
    reset();
    GMTrace.o(380507258880L, 2835);
  }
  
  public final String Bq()
  {
    GMTrace.i(380909912064L, 2838);
    if (this.hra == null)
    {
      GMTrace.o(380909912064L, 2838);
      return "";
    }
    String str = this.hra;
    GMTrace.o(380909912064L, 2838);
    return str;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(380775694336L, 2837);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0)
    {
      if (this.username == null)
      {
        str = "";
        localContentValues.put("username", str);
      }
    }
    else
    {
      if ((this.fRM & 0x2) != 0) {
        localContentValues.put("imgwidth", Integer.valueOf(this.hqY));
      }
      if ((this.fRM & 0x4) != 0) {
        localContentValues.put("imgheigth", Integer.valueOf(this.hqZ));
      }
      if ((this.fRM & 0x8) != 0) {
        localContentValues.put("imgformat", Bq());
      }
      if ((this.fRM & 0x10) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.hrb));
      }
      if ((this.fRM & 0x20) != 0) {
        localContentValues.put("startpos", Integer.valueOf(this.hrc));
      }
      if ((this.fRM & 0x40) != 0) {
        localContentValues.put("headimgtype", Integer.valueOf(this.hrd));
      }
      if ((this.fRM & 0x80) != 0)
      {
        if (this.hre != null) {
          break label299;
        }
        str = "";
        label197:
        localContentValues.put("reserved1", str);
      }
      if ((this.fRM & 0x100) != 0) {
        if (this.hrf != null) {
          break label307;
        }
      }
    }
    label299:
    label307:
    for (String str = "";; str = this.hrf)
    {
      localContentValues.put("reserved2", str);
      if ((this.fRM & 0x200) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hrg));
      }
      if ((this.fRM & 0x400) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hrh));
      }
      GMTrace.o(380775694336L, 2837);
      return localContentValues;
      str = this.username;
      break;
      str = this.hre;
      break label197;
    }
  }
  
  public final void reset()
  {
    GMTrace.i(380641476608L, 2836);
    this.username = "";
    this.hqY = 0;
    this.hqZ = 0;
    this.hra = "";
    this.hrb = 0;
    this.hrc = 0;
    this.hrd = 0;
    this.hre = "";
    this.hrf = "";
    this.hrg = 0;
    this.hrh = 0;
    GMTrace.o(380641476608L, 2836);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */