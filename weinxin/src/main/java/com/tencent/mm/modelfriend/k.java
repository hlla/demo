package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import com.tencent.gmtrace.GMTrace;

public final class k
{
  int fRM;
  public int gkh;
  int gkq;
  String gkr;
  String gks;
  String signature;
  String username;
  
  public k()
  {
    GMTrace.i(4425829580800L, 32975);
    this.fRM = -1;
    this.username = "";
    this.gkh = 0;
    this.gkq = 0;
    this.gkr = "";
    this.gks = "";
    this.signature = "";
    GMTrace.o(4425829580800L, 32975);
  }
  
  public final String getUsername()
  {
    GMTrace.i(4426098016256L, 32977);
    if (this.username == null)
    {
      GMTrace.o(4426098016256L, 32977);
      return "";
    }
    String str = this.username;
    GMTrace.o(4426098016256L, 32977);
    return str;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4425963798528L, 32976);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.fRM & 0x2) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.gkh));
    }
    if ((this.fRM & 0x4) != 0) {
      localContentValues.put("personalcard", Integer.valueOf(this.gkq));
    }
    if ((this.fRM & 0x8) != 0)
    {
      if (this.gkr == null)
      {
        str = "";
        localContentValues.put("province", str);
      }
    }
    else
    {
      if ((this.fRM & 0x10) != 0)
      {
        if (this.gks != null) {
          break label178;
        }
        str = "";
        label126:
        localContentValues.put("city", str);
      }
      if ((this.fRM & 0x20) != 0) {
        if (this.signature != null) {
          break label186;
        }
      }
    }
    label178:
    label186:
    for (String str = "";; str = this.signature)
    {
      localContentValues.put("signature", str);
      GMTrace.o(4425963798528L, 32976);
      return localContentValues;
      str = this.gkr;
      break;
      str = this.gks;
      break label126;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */