package ct;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;

public final class x
{
  public static aa a(z paramz)
  {
    bd.b();
    System.currentTimeMillis();
    try
    {
      paramz = new ac(paramz).a();
      System.currentTimeMillis();
      bd.b();
      return paramz;
    }
    catch (Throwable paramz)
    {
      for (;;)
      {
        paramz = new aa();
        paramz.a = -19;
      }
    }
  }
  
  public static z a(String paramString, byte[] paramArrayOfByte)
  {
    return b(paramString, paramArrayOfByte);
  }
  
  private static z b(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      URL localURL = new URL(be.c(paramString));
      int i = localURL.getPort();
      z localz = new z(localURL.getHost(), new int[] { i });
      if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().startsWith("https://"))) {
        localz.a = true;
      }
      localz.g = localURL.getFile();
      localz.j = paramArrayOfByte;
      localz.d = paramString;
      return localz;
    }
    catch (MalformedURLException paramArrayOfByte)
    {
      throw new ah("url format error:" + paramString);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */