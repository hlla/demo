package com.tencent.mm.network.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.v;
import java.net.InetAddress;

public final class c
{
  private InetAddress ifN;
  private int port;
  private int type;
  
  private c(InetAddress paramInetAddress, int paramInt1, int paramInt2)
  {
    GMTrace.i(13662559404032L, 101794);
    this.ifN = paramInetAddress;
    this.port = paramInt1;
    this.type = paramInt2;
    GMTrace.o(13662559404032L, 101794);
  }
  
  public static c ml(String paramString)
  {
    GMTrace.i(13662827839488L, 101796);
    if (paramString == null)
    {
      GMTrace.o(13662827839488L, 101796);
      return null;
    }
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length != 3))
    {
      GMTrace.o(13662827839488L, 101796);
      return null;
    }
    try
    {
      paramString = new c(p.Pj(paramString[0]), Integer.parseInt(paramString[1]), Integer.parseInt(paramString[2]));
      GMTrace.o(13662827839488L, 101796);
      return paramString;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.InAddress", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13662827839488L, 101796);
    }
    return null;
  }
  
  public final String toString()
  {
    GMTrace.i(13662693621760L, 101795);
    String str = "hc";
    if (this.type == 2) {
      str = "dns";
    }
    for (;;)
    {
      str = this.ifN.getHostAddress() + ":" + this.port + "(" + str + ")";
      GMTrace.o(13662693621760L, 101795);
      return str;
      if (this.type == 3) {
        str = "svrdns";
      } else if (this.type == 4) {
        str = "waphc";
      } else if (this.type == 5) {
        str = "newdns";
      } else if (this.type == 6) {
        str = "auth";
      } else if (this.type == 7) {
        str = "debug";
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */