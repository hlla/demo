package com.google.android.gms.ads.internal.gmsg;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  implements u
{
  private final b a;
  
  public a(b paramb)
  {
    this.a = paramb;
  }
  
  private static Bundle a(String paramString)
  {
    if (paramString != null)
    {
      Bundle localBundle;
      for (;;)
      {
        Object localObject;
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          Iterator localIterator = localJSONObject.keys();
          localBundle = new Bundle();
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          localObject = localJSONObject.get(paramString);
          if (localObject == null) {
            continue;
          }
          if ((localObject instanceof Boolean))
          {
            localBundle.putBoolean(paramString, ((Boolean)localObject).booleanValue());
            continue;
          }
          if (!(localObject instanceof Double)) {
            break label114;
          }
        }
        catch (JSONException paramString)
        {
          e.c("Failed to convert ad metadata to JSON.", paramString);
          return null;
        }
        localBundle.putDouble(paramString, ((Double)localObject).doubleValue());
        continue;
        label114:
        if ((localObject instanceof Integer))
        {
          localBundle.putInt(paramString, ((Integer)localObject).intValue());
        }
        else if ((localObject instanceof Long))
        {
          localBundle.putLong(paramString, ((Long)localObject).longValue());
        }
        else
        {
          if (!(localObject instanceof String))
          {
            paramString = String.valueOf(paramString);
            if (paramString.length() == 0) {}
            for (paramString = new String("Unsupported type for key:");; paramString = "Unsupported type for key:".concat(paramString))
            {
              e.e(paramString);
              break;
            }
          }
          localBundle.putString(paramString, (String)localObject);
        }
      }
      return localBundle;
    }
    return null;
  }
  
  public final void a(Object paramObject, Map paramMap)
  {
    if (this.a != null)
    {
      if ((String)paramMap.get("name") == null) {
        e.d("Ad metadata with no name parameter.");
      }
      paramObject = a((String)paramMap.get("info"));
      if (paramObject == null) {
        e.c("Failed to convert ad metadata to Bundle.");
      }
    }
    else
    {
      return;
    }
    this.a.a((Bundle)paramObject);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/gmsg/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */