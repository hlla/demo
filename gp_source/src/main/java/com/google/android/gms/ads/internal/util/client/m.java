package com.google.android.gms.ads.internal.util.client;

import com.google.android.gms.ads.internal.client.u;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@com.google.android.gms.ads.internal.q.a.a
public final class m
  implements d
{
  private final String a;
  
  public m()
  {
    this(null);
  }
  
  public m(String paramString)
  {
    this.a = paramString;
  }
  
  public final void a(String paramString)
  {
    for (;;)
    {
      int i;
      String str3;
      try
      {
        localObject1 = String.valueOf(paramString);
        if (((String)localObject1).length() == 0)
        {
          localObject1 = new String("Pinging URL: ");
          k.b((String)localObject1);
          localObject1 = (HttpURLConnection)new URL(paramString).openConnection();
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object localObject1;
        String str1 = localIndexOutOfBoundsException.getMessage();
        localObject2 = new StringBuilder(String.valueOf(paramString).length() + 32 + String.valueOf(str1).length());
        ((StringBuilder)localObject2).append("Error while parsing ping URL: ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(". ");
        ((StringBuilder)localObject2).append(str1);
        k.e(((StringBuilder)localObject2).toString());
        return;
      }
      catch (IOException localIOException)
      {
        String str2 = localIOException.getMessage();
        localObject2 = new StringBuilder(String.valueOf(paramString).length() + 27 + String.valueOf(str2).length());
        ((StringBuilder)localObject2).append("Error while pinging URL: ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(". ");
        ((StringBuilder)localObject2).append(str2);
        k.e(((StringBuilder)localObject2).toString());
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        str3 = localRuntimeException.getMessage();
        Object localObject2 = new StringBuilder(String.valueOf(paramString).length() + 27 + String.valueOf(str3).length());
        ((StringBuilder)localObject2).append("Error while pinging URL: ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(". ");
        ((StringBuilder)localObject2).append(str3);
        k.e(((StringBuilder)localObject2).toString());
        return;
      }
      try
      {
        localObject2 = u.h.a;
        a.a((HttpURLConnection)localObject1, this.a);
        localObject2 = new e();
        ((e)localObject2).a((HttpURLConnection)localObject1, null);
        i = ((HttpURLConnection)localObject1).getResponseCode();
        ((e)localObject2).a((HttpURLConnection)localObject1, i);
        if (i >= 200) {
          break label389;
        }
        localObject2 = new StringBuilder(String.valueOf(paramString).length() + 65);
        ((StringBuilder)localObject2).append("Received non-success response code ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" from pinging URL: ");
        ((StringBuilder)localObject2).append(paramString);
        k.e(((StringBuilder)localObject2).toString());
        ((HttpURLConnection)localObject1).disconnect();
        return;
      }
      finally
      {
        str3.disconnect();
      }
      localObject1 = "Pinging URL: ".concat((String)localObject1);
      continue;
      label389:
      if (i >= 300) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/client/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */