package com.tencent.mm.ah.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b
  implements com.tencent.mm.ah.a.c.b
{
  public b()
  {
    GMTrace.i(13718125543424L, 102208);
    GMTrace.o(13718125543424L, 102208);
  }
  
  public final com.tencent.mm.ah.a.d.b jJ(String paramString)
  {
    GMTrace.i(13718259761152L, 102209);
    v.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[] { paramString });
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setConnectTimeout(15000);
      paramString.setReadTimeout(20000);
      if (paramString == null) {
        v.i("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
      }
      if (paramString.getResponseCode() >= 300)
      {
        paramString.disconnect();
        v.w("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
        GMTrace.o(13718259761152L, 102209);
        return null;
      }
      Object localObject = paramString.getInputStream();
      String str = paramString.getContentType();
      localObject = e.g((InputStream)localObject);
      paramString.disconnect();
      paramString = new com.tencent.mm.ah.a.d.b((byte[])localObject, str);
      GMTrace.o(13718259761152L, 102209);
      return paramString;
    }
    catch (InterruptedException paramString)
    {
      v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bf.g(paramString) });
      paramString = new com.tencent.mm.ah.a.d.b(null, null);
      GMTrace.o(13718259761152L, 102209);
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      for (;;)
      {
        v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bf.g(paramString) });
      }
    }
    catch (SSLHandshakeException paramString)
    {
      for (;;)
      {
        v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bf.g(paramString) });
      }
    }
    catch (SocketException paramString)
    {
      for (;;)
      {
        v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bf.g(paramString) });
      }
    }
    catch (SocketTimeoutException paramString)
    {
      for (;;)
      {
        v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bf.g(paramString) });
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bf.g(paramString) });
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bf.g(paramString) });
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */