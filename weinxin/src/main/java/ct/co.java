package ct;

import org.json.JSONException;
import org.json.JSONObject;

final class co
{
  public double a;
  public double b;
  public double c;
  public float d;
  public String e;
  public String f;
  
  co() {}
  
  public co(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getDouble("latitude");
      this.b = paramJSONObject.getDouble("longitude");
      this.c = paramJSONObject.getDouble("altitude");
      this.d = ((float)paramJSONObject.getDouble("accuracy"));
      this.e = paramJSONObject.optString("name");
      this.f = paramJSONObject.optString("addr");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      b.a.a("TencentJson", "json error", paramJSONObject);
      throw paramJSONObject;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */