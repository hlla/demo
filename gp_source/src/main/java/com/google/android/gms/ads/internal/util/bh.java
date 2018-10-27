package com.google.android.gms.ads.internal.util;

import android.util.JsonReader;
import android.util.JsonToken;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class bh
{
  static
  {
    new bi();
  }
  
  public static List a(JsonReader paramJsonReader)
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      localArrayList.add(paramJsonReader.nextString());
    }
    paramJsonReader.endArray();
    return localArrayList;
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localArrayList.add(paramJSONArray.getString(i));
        i += 1;
      }
      return localArrayList;
    }
    return localArrayList;
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = paramJSONObject.getJSONObject(paramString);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject2 = new JSONObject();
      paramJSONObject.put(paramString, localJSONObject2);
      return localJSONObject2;
    }
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String... paramVarArgs)
  {
    int i = 0;
    int j = paramVarArgs.length - 1;
    if (i >= j) {}
    for (;;)
    {
      if (paramJSONObject != null) {
        return paramJSONObject.optJSONObject(paramVarArgs[j]);
      }
      return null;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONObject(paramVarArgs[i]);
        i += 1;
        break;
      }
      paramJSONObject = null;
    }
  }
  
  public static Map b(JsonReader paramJsonReader)
  {
    HashMap localHashMap = new HashMap();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext()) {
      localHashMap.put(paramJsonReader.nextName(), paramJsonReader.nextString());
    }
    paramJsonReader.endObject();
    return localHashMap;
  }
  
  public static JSONObject c(JsonReader paramJsonReader)
  {
    Object localObject = new JSONObject();
    paramJsonReader.beginObject();
    JsonToken localJsonToken;
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      localJsonToken = paramJsonReader.peek();
      if (JsonToken.BEGIN_ARRAY.equals(localJsonToken))
      {
        ((JSONObject)localObject).put(str, d(paramJsonReader));
      }
      else if (JsonToken.BEGIN_OBJECT.equals(localJsonToken))
      {
        ((JSONObject)localObject).put(str, c(paramJsonReader));
      }
      else if (JsonToken.BOOLEAN.equals(localJsonToken))
      {
        ((JSONObject)localObject).put(str, paramJsonReader.nextBoolean());
      }
      else if (JsonToken.NUMBER.equals(localJsonToken))
      {
        ((JSONObject)localObject).put(str, paramJsonReader.nextDouble());
      }
      else
      {
        if (!JsonToken.STRING.equals(localJsonToken)) {
          break label150;
        }
        ((JSONObject)localObject).put(str, paramJsonReader.nextString());
      }
    }
    paramJsonReader.endObject();
    return (JSONObject)localObject;
    label150:
    paramJsonReader = String.valueOf(localJsonToken);
    localObject = new StringBuilder(String.valueOf(paramJsonReader).length() + 23);
    ((StringBuilder)localObject).append("unexpected json token: ");
    ((StringBuilder)localObject).append(paramJsonReader);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public static JSONArray d(JsonReader paramJsonReader)
  {
    Object localObject = new JSONArray();
    paramJsonReader.beginArray();
    JsonToken localJsonToken;
    while (paramJsonReader.hasNext())
    {
      localJsonToken = paramJsonReader.peek();
      if (JsonToken.BEGIN_ARRAY.equals(localJsonToken))
      {
        ((JSONArray)localObject).put(d(paramJsonReader));
      }
      else if (JsonToken.BEGIN_OBJECT.equals(localJsonToken))
      {
        ((JSONArray)localObject).put(c(paramJsonReader));
      }
      else if (JsonToken.BOOLEAN.equals(localJsonToken))
      {
        ((JSONArray)localObject).put(paramJsonReader.nextBoolean());
      }
      else if (JsonToken.NUMBER.equals(localJsonToken))
      {
        ((JSONArray)localObject).put(paramJsonReader.nextDouble());
      }
      else
      {
        if (!JsonToken.STRING.equals(localJsonToken)) {
          break label140;
        }
        ((JSONArray)localObject).put(paramJsonReader.nextString());
      }
    }
    paramJsonReader.endArray();
    return (JSONArray)localObject;
    label140:
    paramJsonReader = String.valueOf(localJsonToken);
    localObject = new StringBuilder(String.valueOf(paramJsonReader).length() + 23);
    ((StringBuilder)localObject).append("unexpected json token: ");
    ((StringBuilder)localObject).append(paramJsonReader);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */