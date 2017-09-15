package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import com.tencent.gmtrace.GMTrace;

public final class q
{
  int fRM;
  public int hBf;
  private int hBg;
  private int hnl;
  private String hnn;
  private String hno;
  public int huN;
  public String username;
  
  public q()
  {
    GMTrace.i(4443009449984L, 33103);
    this.fRM = -1;
    this.username = "";
    this.hBf = 0;
    this.huN = 0;
    this.hnl = 0;
    this.hBg = 0;
    this.hnn = "";
    this.hno = "";
    GMTrace.o(4443009449984L, 33103);
  }
  
  public final String getUsername()
  {
    GMTrace.i(4443277885440L, 33105);
    if (this.username == null)
    {
      GMTrace.o(4443277885440L, 33105);
      return "";
    }
    String str = this.username;
    GMTrace.o(4443277885440L, 33105);
    return str;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4443143667712L, 33104);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.fRM & 0x2) != 0) {
      localContentValues.put("friendtype", Integer.valueOf(this.hBf));
    }
    if ((this.fRM & 0x4) != 0) {
      localContentValues.put("updatetime", Integer.valueOf(this.huN));
    }
    if ((this.fRM & 0x8) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.hnl));
    }
    if ((this.fRM & 0x10) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.hBg));
    }
    if ((this.fRM & 0x20) != 0)
    {
      if (this.hnn == null)
      {
        str = "";
        localContentValues.put("reserved3", str);
      }
    }
    else if ((this.fRM & 0x40) != 0) {
      if (this.hno != null) {
        break label197;
      }
    }
    label197:
    for (String str = "";; str = this.hno)
    {
      localContentValues.put("reserved4", str);
      GMTrace.o(4443143667712L, 33104);
      return localContentValues;
      str = this.hnn;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */