package com.tencent.b.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class g
{
  String aMq = null;
  String aQl = null;
  String aQm = "0";
  long aQn = 0L;
  
  static g aI(String paramString)
  {
    g localg = new g();
    if (s.aJ(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("ui")) {
        localg.aMq = paramString.getString("ui");
      }
      if (!paramString.isNull("mc")) {
        localg.aQl = paramString.getString("mc");
      }
      if (!paramString.isNull("mid")) {
        localg.aQm = paramString.getString("mid");
      }
      if (!paramString.isNull("ts")) {
        localg.aQn = paramString.getLong("ts");
      }
      return localg;
    }
    catch (JSONException paramString) {}
    return localg;
  }
  
  private JSONObject nN()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      s.a(localJSONObject, "ui", this.aMq);
      s.a(localJSONObject, "mc", this.aQl);
      s.a(localJSONObject, "mid", this.aQm);
      localJSONObject.put("ts", this.aQn);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  final int a(g paramg)
  {
    if (paramg == null) {}
    do
    {
      do
      {
        return 1;
        if ((!s.aK(this.aQm)) || (!s.aK(paramg.aQm))) {
          break;
        }
        if (this.aQm.equals(paramg.aQm)) {
          return 0;
        }
      } while (this.aQn >= paramg.aQn);
      return -1;
    } while (s.aK(this.aQm));
    return -1;
  }
  
  public final String toString()
  {
    return nN().toString();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/b/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */