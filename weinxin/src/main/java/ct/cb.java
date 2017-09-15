package ct;

import android.content.Context;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class cb
  implements TencentHttpClient
{
  private static final List<String> a = Arrays.asList(new String[] { "lbssp.map.qq.com", "lbs.map.qq.com" });
  private static x b;
  
  public cb(Context paramContext, String paramString)
  {
    try
    {
      b.a.a(paramContext, "0M3006CS7U0ZC2K3", paramString, "test_uuid", a);
      b = b.a.a();
      return;
    }
    catch (l paramContext)
    {
      b.a.a("TxNewHttpClient", "<init>", paramContext);
    }
  }
  
  private static String a(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i].trim();
        int k = str1.indexOf("charset=");
        if (-1 != k) {
          str1 = str1.substring(k + 8, str1.length());
        }
      }
      else
      {
        return str1;
      }
      i += 1;
    }
  }
  
  public final Pair<byte[], String> postSync(String paramString, byte[] paramArrayOfByte)
  {
    if (b == null) {
      throw new IOException("can not init net sdk");
    }
    for (;;)
    {
      try
      {
        paramString = x.a(paramString, paramArrayOfByte);
        paramString.a("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
        paramString.a();
        paramString = x.a(paramString);
        if (paramString == null) {
          throw new IOException("null response");
        }
      }
      catch (ah paramString)
      {
        throw new IOException(paramString.getMessage());
        switch (paramString.a())
        {
        case -1: 
          throw new IOException("net sdk error: " + paramString.a());
        }
      }
      catch (Exception paramString)
      {
        throw new IOException(paramString.getMessage());
      }
      paramArrayOfByte = a(paramString.a("content-type"));
      return Pair.create(paramString.b(), paramArrayOfByte);
      paramString = Pair.create("{}".getBytes(), "utf-8");
      return paramString;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */