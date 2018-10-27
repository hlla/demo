package com.airbnb.lottie.c.a;

import android.util.Log;
import com.airbnb.lottie.c.k;
import java.util.Collections;
import org.json.JSONObject;

public final class x
{
  public static w a(JSONObject paramJSONObject, com.airbnb.lottie.i parami)
  {
    Object localObject7 = null;
    Object localObject1 = paramJSONObject.optJSONObject("a");
    if (localObject1 != null) {}
    for (localObject1 = new l(((JSONObject)localObject1).opt("k"), parami);; localObject1 = new l())
    {
      Object localObject2 = paramJSONObject.optJSONObject("p");
      if (localObject2 != null) {}
      for (localObject2 = l.a((JSONObject)localObject2, parami);; localObject2 = null)
      {
        Object localObject3 = paramJSONObject.optJSONObject("s");
        if (localObject3 == null) {}
        for (localObject3 = new p(Collections.emptyList(), new k());; localObject3 = new p(((ab)localObject3).b, (k)((ab)localObject3).a))
        {
          Object localObject5 = paramJSONObject.optJSONObject("r");
          Object localObject4 = localObject5;
          if (localObject5 == null) {
            localObject4 = paramJSONObject.optJSONObject("rz");
          }
          if (localObject4 == null) {
            a("rotation");
          }
          for (localObject4 = null;; localObject4 = d.a((JSONObject)localObject4, parami, false))
          {
            localObject5 = paramJSONObject.optJSONObject("o");
            if (localObject5 != null) {}
            for (localObject5 = j.a((JSONObject)localObject5, parami);; localObject5 = new i(Collections.emptyList(), Integer.valueOf(100)))
            {
              Object localObject6 = paramJSONObject.optJSONObject("so");
              if (localObject6 != null) {}
              for (localObject6 = d.a((JSONObject)localObject6, parami, false);; localObject6 = null)
              {
                JSONObject localJSONObject = paramJSONObject.optJSONObject("eo");
                paramJSONObject = (JSONObject)localObject7;
                if (localJSONObject != null) {
                  paramJSONObject = d.a(localJSONObject, parami, false);
                }
                return new w((l)localObject1, (y)localObject2, (p)localObject3, (c)localObject4, (i)localObject5, (c)localObject6, paramJSONObject, (byte)0);
              }
            }
          }
          localObject3 = aa.a((JSONObject)localObject3, 1.0F, parami, com.airbnb.lottie.c.l.a).a();
        }
        a("position");
      }
      Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
    }
  }
  
  private static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Missing transform for ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */