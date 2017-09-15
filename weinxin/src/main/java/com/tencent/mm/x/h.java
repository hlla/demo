package com.tencent.mm.x;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;

public final class h
{
  public int fRM;
  public int gkg;
  int hri;
  public String hrj;
  public String hrk;
  private int hrl;
  int hrm;
  public String username;
  
  public h()
  {
    GMTrace.i(379165081600L, 2825);
    this.fRM = -1;
    this.username = "";
    this.gkg = 0;
    this.hri = 0;
    this.hrj = "";
    this.hrk = "";
    this.hrl = 0;
    this.hrm = 0;
    GMTrace.o(379165081600L, 2825);
  }
  
  public final ContentValues Br()
  {
    GMTrace.i(379433517056L, 2827);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.fRM & 0x2) != 0) {
      localContentValues.put("imgflag", Integer.valueOf(this.gkg));
    }
    if ((this.fRM & 0x4) != 0) {
      localContentValues.put("lastupdatetime", Integer.valueOf(this.hri));
    }
    if ((this.fRM & 0x8) != 0) {
      localContentValues.put("reserved1", Bs());
    }
    if ((this.fRM & 0x10) != 0) {
      localContentValues.put("reserved2", Bt());
    }
    if ((this.fRM & 0x20) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.hrl));
    }
    if ((this.fRM & 0x40) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.hrm));
    }
    GMTrace.o(379433517056L, 2827);
    return localContentValues;
  }
  
  public final String Bs()
  {
    GMTrace.i(379701952512L, 2829);
    if (this.hrk == null)
    {
      GMTrace.o(379701952512L, 2829);
      return "";
    }
    String str = this.hrk;
    GMTrace.o(379701952512L, 2829);
    return str;
  }
  
  public final String Bt()
  {
    GMTrace.i(379836170240L, 2830);
    if (this.hrj == null)
    {
      GMTrace.o(379836170240L, 2830);
      return "";
    }
    String str = this.hrj;
    GMTrace.o(379836170240L, 2830);
    return str;
  }
  
  public final void Bu()
  {
    GMTrace.i(380104605696L, 2832);
    this.hrm = ((int)(bf.Nz() / 60L));
    this.fRM |= 0x40;
    GMTrace.o(380104605696L, 2832);
  }
  
  public final void aV(boolean paramBoolean)
  {
    GMTrace.i(379970387968L, 2831);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.hrl = i;
      GMTrace.o(379970387968L, 2831);
      return;
    }
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(379299299328L, 2826);
    this.username = paramCursor.getString(0);
    this.gkg = paramCursor.getInt(1);
    this.hri = paramCursor.getInt(2);
    this.hrk = paramCursor.getString(3);
    this.hrj = paramCursor.getString(4);
    this.hrl = paramCursor.getInt(5);
    this.hrm = paramCursor.getInt(6);
    GMTrace.o(379299299328L, 2826);
  }
  
  public final String getUsername()
  {
    GMTrace.i(379567734784L, 2828);
    if (this.username == null)
    {
      GMTrace.o(379567734784L, 2828);
      return "";
    }
    String str = this.username;
    GMTrace.o(379567734784L, 2828);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */