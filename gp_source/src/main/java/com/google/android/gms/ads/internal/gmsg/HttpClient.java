package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.common.annotation.KeepName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@a
@Keep
@KeepName
public class HttpClient
  implements u
{
  private final Context a;
  private final VersionInfoParcel b;
  
  public HttpClient(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    this.a = paramContext;
    this.b = paramVersionInfoParcel;
  }
  
  private static y a(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    String str1 = paramJSONObject.optString("http_request_id");
    Object localObject2 = paramJSONObject.optString("url");
    String str2 = paramJSONObject.optString("post_body", null);
    try
    {
      localObject2 = new URL((String)localObject2);
      localObject1 = localObject2;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        e.c("Error constructing http request.", localMalformedURLException);
      }
    }
    localObject2 = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("headers");
    if (paramJSONObject == null) {
      paramJSONObject = new JSONArray();
    }
    for (;;)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null) {
          ((ArrayList)localObject2).add(new x(localJSONObject.optString("key"), localJSONObject.optString("value")));
        }
        i += 1;
      }
      return new y(str1, (URL)localObject1, (ArrayList)localObject2, str2);
    }
  }
  
  /* Error */
  private final z a(y paramy)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: getfield 99	com/google/android/gms/ads/internal/gmsg/y:d	Ljava/net/URL;
    //   6: invokevirtual 103	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   9: checkcast 105	java/net/HttpURLConnection
    //   12: astore 4
    //   14: getstatic 111	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   17: getfield 115	com/google/android/gms/ads/internal/bt:e	Lcom/google/android/gms/ads/internal/util/n;
    //   20: aload_0
    //   21: getfield 20	com/google/android/gms/ads/internal/gmsg/HttpClient:a	Landroid/content/Context;
    //   24: aload_0
    //   25: getfield 22	com/google/android/gms/ads/internal/gmsg/HttpClient:b	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   28: getfield 120	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:a	Ljava/lang/String;
    //   31: aload 4
    //   33: invokevirtual 125	com/google/android/gms/ads/internal/util/n:a	(Landroid/content/Context;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
    //   36: aload_1
    //   37: getfield 128	com/google/android/gms/ads/internal/gmsg/y:a	Ljava/util/ArrayList;
    //   40: invokevirtual 132	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore 5
    //   45: aload 5
    //   47: invokeinterface 138 1 0
    //   52: ifne +320 -> 372
    //   55: aload_1
    //   56: getfield 140	com/google/android/gms/ads/internal/gmsg/y:c	Ljava/lang/String;
    //   59: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifne +49 -> 111
    //   65: aload 4
    //   67: iconst_1
    //   68: invokevirtual 150	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   71: aload_1
    //   72: getfield 140	com/google/android/gms/ads/internal/gmsg/y:c	Ljava/lang/String;
    //   75: invokevirtual 156	java/lang/String:getBytes	()[B
    //   78: astore_3
    //   79: aload 4
    //   81: aload_3
    //   82: arraylength
    //   83: invokevirtual 160	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   86: new 162	java/io/BufferedOutputStream
    //   89: dup
    //   90: aload 4
    //   92: invokevirtual 166	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   95: invokespecial 169	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   98: astore 5
    //   100: aload 5
    //   102: aload_3
    //   103: invokevirtual 173	java/io/BufferedOutputStream:write	([B)V
    //   106: aload 5
    //   108: invokevirtual 176	java/io/BufferedOutputStream:close	()V
    //   111: new 178	com/google/android/gms/ads/internal/util/client/e
    //   114: dup
    //   115: invokespecial 179	com/google/android/gms/ads/internal/util/client/e:<init>	()V
    //   118: astore 5
    //   120: aload 5
    //   122: aload 4
    //   124: aload_3
    //   125: invokevirtual 182	com/google/android/gms/ads/internal/util/client/e:a	(Ljava/net/HttpURLConnection;[B)V
    //   128: new 48	java/util/ArrayList
    //   131: dup
    //   132: invokespecial 49	java/util/ArrayList:<init>	()V
    //   135: astore_3
    //   136: aload 4
    //   138: invokevirtual 186	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   141: ifnonnull +91 -> 232
    //   144: aload_1
    //   145: getfield 188	com/google/android/gms/ads/internal/gmsg/y:b	Ljava/lang/String;
    //   148: astore_1
    //   149: aload 4
    //   151: invokevirtual 191	java/net/HttpURLConnection:getResponseCode	()I
    //   154: istore_2
    //   155: getstatic 111	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   158: getfield 115	com/google/android/gms/ads/internal/bt:e	Lcom/google/android/gms/ads/internal/util/n;
    //   161: astore 6
    //   163: new 193	com/google/android/gms/ads/internal/gmsg/aa
    //   166: dup
    //   167: aload_1
    //   168: iload_2
    //   169: aload_3
    //   170: new 195	java/io/InputStreamReader
    //   173: dup
    //   174: aload 4
    //   176: invokevirtual 199	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   179: invokespecial 202	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   182: invokestatic 205	com/google/android/gms/ads/internal/util/n:a	(Ljava/io/InputStreamReader;)Ljava/lang/String;
    //   185: invokespecial 208	com/google/android/gms/ads/internal/gmsg/aa:<init>	(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;)V
    //   188: astore_1
    //   189: aload 5
    //   191: aload 4
    //   193: aload_1
    //   194: getfield 211	com/google/android/gms/ads/internal/gmsg/aa:d	I
    //   197: invokevirtual 214	com/google/android/gms/ads/internal/util/client/e:a	(Ljava/net/HttpURLConnection;I)V
    //   200: aload 5
    //   202: aload_1
    //   203: getfield 215	com/google/android/gms/ads/internal/gmsg/aa:a	Ljava/lang/String;
    //   206: invokevirtual 217	com/google/android/gms/ads/internal/util/client/e:a	(Ljava/lang/String;)V
    //   209: new 219	com/google/android/gms/ads/internal/gmsg/z
    //   212: dup
    //   213: iconst_1
    //   214: aload_1
    //   215: aconst_null
    //   216: invokespecial 222	com/google/android/gms/ads/internal/gmsg/z:<init>	(ZLcom/google/android/gms/ads/internal/gmsg/aa;Ljava/lang/String;)V
    //   219: astore_3
    //   220: aload 4
    //   222: ifnull +8 -> 230
    //   225: aload 4
    //   227: invokevirtual 225	java/net/HttpURLConnection:disconnect	()V
    //   230: aload_3
    //   231: areturn
    //   232: aload 4
    //   234: invokevirtual 186	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   237: invokeinterface 231 1 0
    //   242: invokeinterface 234 1 0
    //   247: astore 6
    //   249: aload 6
    //   251: invokeinterface 138 1 0
    //   256: ifeq -112 -> 144
    //   259: aload 6
    //   261: invokeinterface 238 1 0
    //   266: checkcast 240	java/util/Map$Entry
    //   269: astore 7
    //   271: aload 7
    //   273: invokeinterface 243 1 0
    //   278: checkcast 245	java/util/List
    //   281: invokeinterface 246 1 0
    //   286: astore 8
    //   288: aload 8
    //   290: invokeinterface 138 1 0
    //   295: ifeq -46 -> 249
    //   298: aload 8
    //   300: invokeinterface 238 1 0
    //   305: checkcast 152	java/lang/String
    //   308: astore 9
    //   310: aload_3
    //   311: new 68	com/google/android/gms/ads/internal/gmsg/x
    //   314: dup
    //   315: aload 7
    //   317: invokeinterface 249 1 0
    //   322: checkcast 152	java/lang/String
    //   325: aload 9
    //   327: invokespecial 75	com/google/android/gms/ads/internal/gmsg/x:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: invokevirtual 79	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   333: pop
    //   334: goto -46 -> 288
    //   337: astore_1
    //   338: aload_1
    //   339: astore_3
    //   340: aload 4
    //   342: astore_1
    //   343: new 219	com/google/android/gms/ads/internal/gmsg/z
    //   346: dup
    //   347: iconst_0
    //   348: aconst_null
    //   349: aload_3
    //   350: invokevirtual 253	java/lang/Exception:toString	()Ljava/lang/String;
    //   353: invokespecial 222	com/google/android/gms/ads/internal/gmsg/z:<init>	(ZLcom/google/android/gms/ads/internal/gmsg/aa;Ljava/lang/String;)V
    //   356: astore 4
    //   358: aload 4
    //   360: astore_3
    //   361: aload_1
    //   362: ifnull -132 -> 230
    //   365: aload_1
    //   366: invokevirtual 225	java/net/HttpURLConnection:disconnect	()V
    //   369: aload 4
    //   371: areturn
    //   372: aload 5
    //   374: invokeinterface 238 1 0
    //   379: checkcast 68	com/google/android/gms/ads/internal/gmsg/x
    //   382: astore 6
    //   384: aload 4
    //   386: aload 6
    //   388: getfield 254	com/google/android/gms/ads/internal/gmsg/x:a	Ljava/lang/String;
    //   391: aload 6
    //   393: getfield 255	com/google/android/gms/ads/internal/gmsg/x:b	Ljava/lang/String;
    //   396: invokevirtual 258	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: goto -354 -> 45
    //   402: astore_3
    //   403: aload 4
    //   405: astore_1
    //   406: aload_1
    //   407: ifnull +7 -> 414
    //   410: aload_1
    //   411: invokevirtual 225	java/net/HttpURLConnection:disconnect	()V
    //   414: aload_3
    //   415: athrow
    //   416: astore_3
    //   417: aconst_null
    //   418: astore_1
    //   419: goto -76 -> 343
    //   422: astore_3
    //   423: aconst_null
    //   424: astore_1
    //   425: goto -19 -> 406
    //   428: astore_3
    //   429: goto -23 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	HttpClient
    //   0	432	1	paramy	y
    //   154	15	2	i	int
    //   1	360	3	localObject1	Object
    //   402	13	3	localObject2	Object
    //   416	1	3	localException	Exception
    //   422	1	3	localObject3	Object
    //   428	1	3	localObject4	Object
    //   12	392	4	localObject5	Object
    //   43	330	5	localObject6	Object
    //   161	231	6	localObject7	Object
    //   269	47	7	localEntry	java.util.Map.Entry
    //   286	13	8	localIterator	Iterator
    //   308	18	9	str	String
    // Exception table:
    //   from	to	target	type
    //   14	45	337	java/lang/Exception
    //   45	55	337	java/lang/Exception
    //   55	111	337	java/lang/Exception
    //   111	144	337	java/lang/Exception
    //   144	220	337	java/lang/Exception
    //   232	249	337	java/lang/Exception
    //   249	288	337	java/lang/Exception
    //   288	334	337	java/lang/Exception
    //   372	399	337	java/lang/Exception
    //   14	45	402	finally
    //   45	55	402	finally
    //   55	111	402	finally
    //   111	144	402	finally
    //   144	220	402	finally
    //   232	249	402	finally
    //   249	288	402	finally
    //   288	334	402	finally
    //   372	399	402	finally
    //   2	14	416	java/lang/Exception
    //   2	14	422	finally
    //   343	358	428	finally
  }
  
  private static JSONObject a(aa paramaa)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("http_request_id", paramaa.c);
        Object localObject = paramaa.a;
        if (localObject == null)
        {
          localObject = new JSONArray();
          Iterator localIterator = paramaa.b.iterator();
          if (!localIterator.hasNext())
          {
            localJSONObject.put("headers", localObject);
            localJSONObject.put("response_code", paramaa.d);
            return localJSONObject;
          }
          x localx = (x)localIterator.next();
          ((JSONArray)localObject).put(new JSONObject().put("key", localx.a).put("value", localx.b));
          continue;
        }
        localJSONObject.put("body", localObject);
      }
      catch (JSONException paramaa)
      {
        e.c("Error constructing JSON for http response.", paramaa);
        return localJSONObject;
      }
    }
  }
  
  @Keep
  @KeepName
  public JSONObject send(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      str = paramJSONObject.optString("http_request_id");
      try
      {
        paramJSONObject = a(a(paramJSONObject));
        if (!paramJSONObject.b)
        {
          localJSONObject.put("response", new JSONObject().put("http_request_id", str));
          localJSONObject.put("success", false);
          localJSONObject.put("reason", paramJSONObject.c);
          return localJSONObject;
        }
        localJSONObject.put("response", a(paramJSONObject.a));
        localJSONObject.put("success", true);
        return localJSONObject;
      }
      catch (Exception paramJSONObject) {}
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        String str = "";
      }
    }
    e.c("Error executing http request.", paramJSONObject);
    try
    {
      localJSONObject.put("response", new JSONObject().put("http_request_id", str));
      localJSONObject.put("success", false);
      localJSONObject.put("reason", paramJSONObject.toString());
      return localJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      e.c("Error executing http request.", paramJSONObject);
      return localJSONObject;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/gmsg/HttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */