package com.airbnb.lottie;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v4.g.w;
import android.util.DisplayMetrics;
import android.util.Log;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.c.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public static a a(Context paramContext, String paramString, s params)
  {
    try
    {
      InputStream localInputStream = paramContext.getAssets().open(paramString);
      paramContext = new e(paramContext.getResources(), params);
      paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[] { localInputStream });
      return paramContext;
    }
    catch (IOException paramContext)
    {
      params = new StringBuilder();
      params.append("Unable to find file ");
      params.append(paramString);
      throw new IllegalStateException(params.toString(), paramContext);
    }
  }
  
  public static i a(Resources paramResources, InputStream paramInputStream)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramInputStream.available()];
      paramInputStream.read(arrayOfByte);
      paramResources = a(paramResources, new JSONObject(new String(arrayOfByte, "UTF-8")));
      return paramResources;
    }
    catch (IOException paramResources)
    {
      Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to find file.", paramResources));
      return null;
    }
    catch (JSONException paramResources)
    {
      for (;;)
      {
        Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to load JSON.", paramResources));
        com.airbnb.lottie.d.h.a(paramInputStream);
      }
    }
    finally
    {
      com.airbnb.lottie.d.h.a(paramInputStream);
    }
  }
  
  public static i a(Resources paramResources, JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    int k = 0;
    float f = paramResources.getDisplayMetrics().density;
    int i = paramJSONObject.optInt("w", -1);
    int j = paramJSONObject.optInt("h", -1);
    if (i == -1) {
      paramResources = (Resources)localObject1;
    }
    for (;;)
    {
      long l1 = paramJSONObject.optLong("ip", 0L);
      long l2 = paramJSONObject.optLong("op", 0L);
      double d = paramJSONObject.optDouble("fr", 0.0D);
      localObject1 = paramJSONObject.optString("v").split("[.]");
      i = Integer.parseInt(localObject1[0]);
      j = Integer.parseInt(localObject1[1]);
      int m = Integer.parseInt(localObject1[2]);
      i locali = new i(paramResources, l1, l2, (float)d, f, i, j, m);
      paramResources = paramJSONObject.optJSONArray("assets");
      if (paramResources != null)
      {
        j = paramResources.length();
        i = 0;
        while (i < j)
        {
          localObject1 = paramResources.optJSONObject(i);
          if (((JSONObject)localObject1).has("p"))
          {
            ((JSONObject)localObject1).optInt("w");
            ((JSONObject)localObject1).optInt("h");
            localObject1 = new r(((JSONObject)localObject1).optString("id"), ((JSONObject)localObject1).optString("p"));
            locali.f.put(((r)localObject1).b, localObject1);
          }
          i += 1;
        }
      }
      if (paramResources == null) {}
      for (;;)
      {
        paramResources = paramJSONObject.optJSONObject("fonts");
        if (paramResources == null) {}
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        for (;;)
        {
          localObject2 = paramJSONObject.optJSONArray("chars");
          if (localObject2 == null) {}
          for (;;)
          {
            paramResources = paramJSONObject.optJSONArray("layers");
            if (paramResources != null)
            {
              m = paramResources.length();
              j = 0;
              i = k;
              while (i < m)
              {
                paramJSONObject = com.airbnb.lottie.c.c.h.a(paramResources.optJSONObject(i), locali);
                k = j;
                if (paramJSONObject.e == com.airbnb.lottie.c.c.i.a) {
                  k = j + 1;
                }
                localObject1 = locali.h;
                localObject2 = locali.g;
                ((List)localObject1).add(paramJSONObject);
                ((android.support.v4.g.h)localObject2).b(paramJSONObject.c, paramJSONObject);
                i += 1;
                j = k;
              }
              if (j > 4)
              {
                paramResources = new StringBuilder();
                paramResources.append("You have ");
                paramResources.append(j);
                paramResources.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                locali.a(paramResources.toString());
              }
            }
            return locali;
            m = ((JSONArray)localObject2).length();
            i = 0;
            while (i < m)
            {
              paramResources = ((JSONArray)localObject2).optJSONObject(i);
              char c = paramResources.optString("ch").charAt(0);
              paramResources.optInt("size");
              d = paramResources.optDouble("w");
              localObject3 = paramResources.optString("style");
              localObject4 = paramResources.optString("fFamily");
              localObject5 = paramResources.optJSONObject("data");
              localObject1 = Collections.emptyList();
              paramResources = (Resources)localObject1;
              if (localObject5 != null)
              {
                localObject5 = ((JSONObject)localObject5).optJSONArray("shapes");
                paramResources = (Resources)localObject1;
                if (localObject5 != null)
                {
                  paramResources = new ArrayList(((JSONArray)localObject5).length());
                  j = 0;
                  while (j < ((JSONArray)localObject5).length())
                  {
                    paramResources.add((com.airbnb.lottie.c.b.s)com.airbnb.lottie.c.b.s.a(((JSONArray)localObject5).optJSONObject(j), locali));
                    j += 1;
                  }
                }
              }
              paramResources = new com.airbnb.lottie.c.g(paramResources, c, d, (String)localObject3, (String)localObject4);
              locali.b.b(paramResources.hashCode(), paramResources);
              i += 1;
            }
          }
          paramResources = paramResources.optJSONArray("list");
          if (paramResources != null)
          {
            j = paramResources.length();
            i = 0;
            while (i < j)
            {
              localObject1 = paramResources.optJSONObject(i);
              localObject2 = ((JSONObject)localObject1).optString("fFamily");
              localObject3 = ((JSONObject)localObject1).optString("fName");
              localObject4 = ((JSONObject)localObject1).optString("fStyle");
              ((JSONObject)localObject1).optDouble("ascent");
              localObject1 = new f((String)localObject2, (String)localObject3, (String)localObject4);
              locali.e.put(((f)localObject1).b, localObject1);
              i += 1;
            }
          }
        }
        m = paramResources.length();
        i = 0;
        while (i < m)
        {
          localObject2 = paramResources.optJSONObject(i);
          localObject3 = ((JSONObject)localObject2).optJSONArray("layers");
          if (localObject3 != null)
          {
            localObject1 = new ArrayList(((JSONArray)localObject3).length());
            localObject4 = new android.support.v4.g.h();
            j = 0;
            while (j < ((JSONArray)localObject3).length())
            {
              localObject5 = com.airbnb.lottie.c.c.h.a(((JSONArray)localObject3).optJSONObject(j), locali);
              ((android.support.v4.g.h)localObject4).b(((com.airbnb.lottie.c.c.g)localObject5).c, localObject5);
              ((List)localObject1).add(localObject5);
              j += 1;
            }
            localObject2 = ((JSONObject)localObject2).optString("id");
            locali.m.put(localObject2, localObject1);
          }
          i += 1;
        }
      }
      paramResources = (Resources)localObject1;
      if (j != -1) {
        paramResources = new Rect(0, 0, (int)(i * f), (int)(j * f));
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */