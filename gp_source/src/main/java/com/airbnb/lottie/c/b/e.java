package com.airbnb.lottie.c.b;

import android.graphics.Path.FillType;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.j;
import com.airbnb.lottie.c.a.n;
import com.airbnb.lottie.c.a.o;
import org.json.JSONException;
import org.json.JSONObject;

final class e
{
  static d a(JSONObject paramJSONObject, com.airbnb.lottie.i parami)
  {
    String str = paramJSONObject.optString("nm");
    Object localObject2 = paramJSONObject.optJSONObject("g");
    Object localObject1 = localObject2;
    int i;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((JSONObject)localObject2).has("k"))
      {
        i = ((JSONObject)localObject2).optInt("p");
        localObject1 = ((JSONObject)localObject2).optJSONObject("k");
      }
    }
    try
    {
      ((JSONObject)localObject1).put("p", i);
      if (localObject1 != null) {}
      for (localObject1 = com.airbnb.lottie.c.a.g.a((JSONObject)localObject1, parami);; localObject1 = null)
      {
        localObject2 = paramJSONObject.optJSONObject("o");
        if (localObject2 != null) {}
        for (localObject2 = j.a((JSONObject)localObject2, parami);; localObject2 = null)
        {
          if (paramJSONObject.optInt("r", 1) != 1) {}
          for (Path.FillType localFillType = Path.FillType.EVEN_ODD;; localFillType = Path.FillType.WINDING)
          {
            if (paramJSONObject.optInt("t", 1) != 1) {}
            for (g localg = g.b;; localg = g.a)
            {
              Object localObject3 = paramJSONObject.optJSONObject("s");
              if (localObject3 != null) {}
              for (localObject3 = o.a((JSONObject)localObject3, parami);; localObject3 = null)
              {
                paramJSONObject = paramJSONObject.optJSONObject("e");
                if (paramJSONObject != null) {}
                for (paramJSONObject = o.a(paramJSONObject, parami);; paramJSONObject = null) {
                  return new d(str, localg, localFillType, (f)localObject1, (com.airbnb.lottie.c.a.i)localObject2, (n)localObject3, paramJSONObject);
                }
              }
            }
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */