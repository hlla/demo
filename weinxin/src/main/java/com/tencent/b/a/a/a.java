package com.tencent.b.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  public static String aPR = "ts";
  public static String aPS = "times";
  public static String aPT = "mfreq";
  public static String aPU = "mdays";
  long aPN = 0L;
  int aPO = 0;
  int aPP = 100;
  int aPQ = 3;
  
  a() {}
  
  a(String paramString)
  {
    if (!s.aJ(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.isNull(aPR)) {
          this.aPN = paramString.getLong(aPR);
        }
        if (!paramString.isNull(aPT)) {
          this.aPP = paramString.getInt(aPT);
        }
        if (!paramString.isNull(aPS)) {
          this.aPO = paramString.getInt(aPS);
        }
        if (!paramString.isNull(aPU))
        {
          this.aPQ = paramString.getInt(aPU);
          return;
        }
      }
      catch (JSONException paramString) {}
    }
  }
  
  public final String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(aPR, this.aPN);
      localJSONObject.put(aPS, this.aPO);
      localJSONObject.put(aPT, this.aPP);
      localJSONObject.put(aPU, this.aPQ);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/b/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */