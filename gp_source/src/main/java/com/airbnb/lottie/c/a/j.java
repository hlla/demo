package com.airbnb.lottie.c.a;

import org.json.JSONObject;

public final class j
{
  public static i a(JSONObject paramJSONObject, com.airbnb.lottie.i parami)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("x"))) {
      parami.a("Lottie doesn't support expressions.");
    }
    paramJSONObject = aa.a(paramJSONObject, 1.0F, parami, k.a).a();
    parami = (Integer)paramJSONObject.a;
    return new i(paramJSONObject.b, parami);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */