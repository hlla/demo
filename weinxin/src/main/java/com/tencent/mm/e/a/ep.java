package com.tencent.mm.e.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.b.b;

public final class ep
  extends b
{
  public a fIm;
  public b fIn;
  
  public ep()
  {
    this((byte)0);
    GMTrace.i(4242622382080L, 31610);
    GMTrace.o(4242622382080L, 31610);
  }
  
  private ep(byte paramByte)
  {
    GMTrace.i(4242756599808L, 31611);
    this.fIm = new a();
    this.fIn = new b();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4242756599808L, 31611);
  }
  
  public static final class a
  {
    public String bssid;
    public int fIo;
    public String ssid;
    public int version;
    
    public a()
    {
      GMTrace.i(4216181489664L, 31413);
      this.version = 1;
      GMTrace.o(4216181489664L, 31413);
    }
  }
  
  public static final class b
  {
    public int fIp;
    public int fIq;
    public String fIr;
    
    public b()
    {
      GMTrace.i(4327045332992L, 32239);
      this.fIp = 0;
      this.fIq = 0;
      GMTrace.o(4327045332992L, 32239);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/ep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */