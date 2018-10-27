package com.airbnb.lottie.c.a;

import com.airbnb.lottie.i;
import org.json.JSONObject;

public final class d
{
  public static c a()
  {
    return new c();
  }
  
  public static c a(JSONObject paramJSONObject, i parami, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f = parami.c;; f = 1.0F)
    {
      if ((paramJSONObject != null) && (paramJSONObject.has("x"))) {
        parami.a("Lottie doesn't support expressions.");
      }
      paramJSONObject = aa.a(paramJSONObject, f, parami, e.a).a();
      return new c(paramJSONObject.b, (Float)paramJSONObject.a);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */