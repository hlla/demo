package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.JsonWriter;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.common.util.b;
import com.google.android.gms.common.util.d;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

@a
public final class e
{
  public static boolean a = false;
  public static boolean b;
  public static Object c = new Object();
  private static b d = d.a;
  private static final Set f = new HashSet(Arrays.asList(new String[0]));
  private final List e;
  
  static
  {
    b = false;
  }
  
  public e()
  {
    this(null);
  }
  
  public e(String paramString)
  {
    if (!b())
    {
      paramString = new ArrayList();
      this.e = paramString;
      return;
    }
    String str = UUID.randomUUID().toString();
    if (paramString == null)
    {
      paramString = String.valueOf(str);
      if (paramString.length() == 0) {}
      for (paramString = new String("network_request_");; paramString = "network_request_".concat(paramString))
      {
        paramString = Arrays.asList(new String[] { paramString });
        break;
      }
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() == 0) {}
    for (paramString = new String("ad_request_");; paramString = "ad_request_".concat(paramString))
    {
      str = String.valueOf(str);
      if (str.length() == 0) {}
      for (str = new String("network_request_");; str = "network_request_".concat(str))
      {
        paramString = Arrays.asList(new String[] { paramString, str });
        break;
      }
    }
  }
  
  private static void a(JsonWriter paramJsonWriter, Map paramMap)
  {
    if (paramMap != null)
    {
      paramJsonWriter.name("headers").beginArray();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        if (!f.contains(str1)) {
          if ((((Map.Entry)localObject).getValue() instanceof List))
          {
            localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str2 = (String)((Iterator)localObject).next();
              paramJsonWriter.beginObject();
              paramJsonWriter.name("name").value(str1);
              paramJsonWriter.name("value").value(str2);
              paramJsonWriter.endObject();
            }
          }
          else if ((((Map.Entry)localObject).getValue() instanceof String))
          {
            paramJsonWriter.beginObject();
            paramJsonWriter.name("name").value(str1);
            paramJsonWriter.name("value").value((String)((Map.Entry)localObject).getValue());
            paramJsonWriter.endObject();
          }
          else
          {
            k.c("Connection headers should be either Map<String, String> or Map<String, List<String>>");
          }
        }
      }
      paramJsonWriter.endArray();
    }
  }
  
  private final void a(String paramString, j paramj)
  {
    StringWriter localStringWriter = new StringWriter();
    JsonWriter localJsonWriter = new JsonWriter(localStringWriter);
    for (;;)
    {
      try
      {
        localJsonWriter.beginObject();
        localJsonWriter.name("timestamp").value(d.a());
        localJsonWriter.name("event").value(paramString);
        localJsonWriter.name("components").beginArray();
        paramString = this.e.iterator();
        if (paramString.hasNext()) {
          continue;
        }
        localJsonWriter.endArray();
        paramj.a(localJsonWriter);
        localJsonWriter.endObject();
        localJsonWriter.flush();
        localJsonWriter.close();
      }
      catch (IOException paramString)
      {
        k.c("unable to log", paramString);
        continue;
      }
      c(localStringWriter.toString());
      return;
      localJsonWriter.value((String)paramString.next());
    }
  }
  
  public static boolean a()
  {
    synchronized (c)
    {
      boolean bool = b;
      return bool;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if ((Build.VERSION.SDK_INT < 17) || (((Boolean)n.ag.a()).booleanValue())) {}
    try
    {
      int i = Settings.Global.getInt(paramContext.getContentResolver(), "development_settings_enabled", 0);
      return i != 0;
    }
    catch (Exception paramContext)
    {
      k.e("Fail to determine debug setting.", paramContext);
    }
    return false;
    return false;
    return false;
  }
  
  private final void b(String paramString1, String paramString2, Map paramMap, byte[] paramArrayOfByte)
  {
    a("onNetworkRequest", new f(paramString1, paramString2, paramMap, paramArrayOfByte));
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    Object localObject1 = c;
    boolean bool1 = bool2;
    try
    {
      if (b)
      {
        bool1 = bool2;
        if (a) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  private static void c(String paramString)
  {
    try
    {
      k.d("GMA Debug BEGIN");
      int i = 0;
      if (i < paramString.length())
      {
        int j = i + 4000;
        String str = String.valueOf(paramString.substring(i, Math.min(j, paramString.length())));
        if (str.length() == 0) {}
        for (str = new String("GMA Debug CONTENT ");; str = "GMA Debug CONTENT ".concat(str))
        {
          k.d(str);
          i = j;
          break;
        }
      }
      k.d("GMA Debug FINISH");
      return;
    }
    finally {}
  }
  
  public final void a(String paramString)
  {
    if ((b()) && (paramString != null)) {
      a(paramString.getBytes());
    }
  }
  
  public final void a(String paramString1, String paramString2, Map paramMap, byte[] paramArrayOfByte)
  {
    if (b()) {
      b(paramString1, paramString2, paramMap, paramArrayOfByte);
    }
  }
  
  public final void a(HttpURLConnection paramHttpURLConnection, int paramInt)
  {
    Object localObject = null;
    if (b()) {
      if (paramHttpURLConnection.getHeaderFields() == null) {
        break label62;
      }
    }
    label62:
    for (HashMap localHashMap = new HashMap(paramHttpURLConnection.getHeaderFields());; localHashMap = null)
    {
      a(localHashMap, paramInt);
      if (paramInt < 200) {}
      for (;;)
      {
        try
        {
          paramHttpURLConnection = paramHttpURLConnection.getResponseMessage();
          b(paramHttpURLConnection);
          return;
        }
        catch (IOException paramHttpURLConnection)
        {
          paramHttpURLConnection = String.valueOf(paramHttpURLConnection.getMessage());
          if (paramHttpURLConnection.length() != 0) {
            break;
          }
        }
        if (paramInt < 300) {}
      }
    }
    for (paramHttpURLConnection = new String("Can not get error message from error HttpURLConnection\n");; paramHttpURLConnection = "Can not get error message from error HttpURLConnection\n".concat(paramHttpURLConnection))
    {
      k.e(paramHttpURLConnection);
      paramHttpURLConnection = (HttpURLConnection)localObject;
      break;
    }
  }
  
  public final void a(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    if (b()) {
      if (paramHttpURLConnection.getRequestProperties() == null) {
        break label57;
      }
    }
    label57:
    for (HashMap localHashMap = new HashMap(paramHttpURLConnection.getRequestProperties());; localHashMap = null)
    {
      b(new String(paramHttpURLConnection.getURL().toString()), new String(paramHttpURLConnection.getRequestMethod()), localHashMap, paramArrayOfByte);
      return;
    }
  }
  
  public final void a(Map paramMap, int paramInt)
  {
    a("onNetworkResponse", new g(paramInt, paramMap));
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    a("onNetworkResponseBody", new h(paramArrayOfByte));
  }
  
  public final void b(String paramString)
  {
    a("onNetworkRequestError", new i(paramString));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/client/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */