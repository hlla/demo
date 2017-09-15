package com.tencent.mm.network;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class u
{
  public HttpsURLConnection ieI;
  
  public u(String paramString)
  {
    this(new URL(paramString));
    GMTrace.i(13646721712128L, 101676);
    GMTrace.o(13646721712128L, 101676);
  }
  
  private u(URL paramURL)
  {
    GMTrace.i(13646855929856L, 101677);
    this.ieI = null;
    try
    {
      this.ieI = ((HttpsURLConnection)paramURL.openConnection());
      GMTrace.o(13646855929856L, 101677);
      return;
    }
    catch (MalformedURLException paramURL)
    {
      v.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", new Object[] { paramURL.getMessage() });
      v.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bf.g(paramURL) });
      GMTrace.o(13646855929856L, 101677);
      return;
    }
    catch (IOException paramURL)
    {
      v.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", new Object[] { paramURL.getMessage() });
      v.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bf.g(paramURL) });
      GMTrace.o(13646855929856L, 101677);
      return;
    }
    catch (Exception paramURL)
    {
      v.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + paramURL.getMessage());
      v.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", new Object[] { bf.g(paramURL) });
      GMTrace.o(13646855929856L, 101677);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */