package com.google.android.gms.ads.internal.util.b;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  public static HttpURLConnection a(String paramString, int paramInt)
  {
    paramString = new URL(paramString);
    int i = 0;
    i += 1;
    Object localObject;
    HttpURLConnection localHttpURLConnection;
    String str;
    if (i <= 20)
    {
      localObject = paramString.openConnection();
      ((URLConnection)localObject).setConnectTimeout(paramInt);
      ((URLConnection)localObject).setReadTimeout(paramInt);
      if (!(localObject instanceof HttpURLConnection)) {
        throw new IOException("Invalid protocol.");
      }
      localHttpURLConnection = (HttpURLConnection)localObject;
      localObject = new com.google.android.gms.ads.internal.util.client.e();
      ((com.google.android.gms.ads.internal.util.client.e)localObject).a(localHttpURLConnection, null);
      localHttpURLConnection.setInstanceFollowRedirects(false);
      int j = localHttpURLConnection.getResponseCode();
      ((com.google.android.gms.ads.internal.util.client.e)localObject).a(localHttpURLConnection, j);
      if (j / 100 != 3) {
        break label282;
      }
      str = localHttpURLConnection.getHeaderField("Location");
      if (str == null) {
        throw new IOException("Missing Location header in redirect");
      }
      localObject = new URL(paramString, str);
      paramString = ((URL)localObject).getProtocol();
      if (paramString == null) {
        throw new IOException("Protocol is null");
      }
      if ((!paramString.equals("http")) && (!paramString.equals("https")))
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          break label272;
        }
      }
    }
    label272:
    for (paramString = new String("Unsupported scheme: ");; paramString = "Unsupported scheme: ".concat(paramString))
    {
      throw new IOException(paramString);
      paramString = String.valueOf(str);
      if (paramString.length() == 0) {}
      for (paramString = new String("Redirecting to ");; paramString = "Redirecting to ".concat(paramString))
      {
        com.google.android.gms.ads.internal.util.e.b(paramString);
        localHttpURLConnection.disconnect();
        paramString = (String)localObject;
        break;
      }
      throw new IOException("Too many redirects (20)");
    }
    label282:
    return localHttpURLConnection;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */