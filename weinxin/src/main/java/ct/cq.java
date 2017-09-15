package ct;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

final class cq
{
  public static final cq a = new cq();
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public final Bundle l = new Bundle();
  
  cq() {}
  
  private cq(cq paramcq)
  {
    if (paramcq.l.size() > 0)
    {
      this.l.putAll(paramcq.l);
      return;
    }
    this.b = paramcq.b;
    this.c = paramcq.c;
    this.d = paramcq.d;
    this.e = paramcq.e;
    this.f = paramcq.f;
    this.g = paramcq.g;
    this.h = paramcq.h;
    this.i = paramcq.i;
    this.j = paramcq.j;
    this.k = paramcq.k;
  }
  
  public cq(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("admin_level_1"))
      {
        String str1 = paramJSONObject.getString("nation");
        String str2 = paramJSONObject.getString("admin_level_1");
        String str3 = paramJSONObject.getString("admin_level_2");
        String str4 = paramJSONObject.getString("admin_level_3");
        String str5 = paramJSONObject.getString("locality");
        String str6 = paramJSONObject.getString("sublocality");
        paramJSONObject = paramJSONObject.getString("route");
        this.l.putString("nation", str1);
        this.l.putString("admin_level_1", str2);
        this.l.putString("admin_level_2", str3);
        this.l.putString("admin_level_3", str4);
        this.l.putString("locality", str5);
        this.l.putString("sublocality", str6);
        this.l.putString("route", paramJSONObject);
        return;
      }
      this.c = paramJSONObject.getString("name");
      this.d = paramJSONObject.getString("code");
      this.b = paramJSONObject.getString("nation");
      this.e = paramJSONObject.getString("province");
      this.f = paramJSONObject.getString("city");
      this.g = paramJSONObject.getString("district");
      this.h = paramJSONObject.getString("town");
      this.i = paramJSONObject.getString("village");
      this.j = paramJSONObject.getString("street");
      this.k = paramJSONObject.getString("street_no");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      b.a.a("TencentJson", "json error", paramJSONObject);
      throw paramJSONObject;
    }
  }
  
  public static cq a(cq paramcq)
  {
    if (paramcq == null) {
      return null;
    }
    return new cq(paramcq);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubnationData{");
    localStringBuilder.append("name=").append(this.c).append(",");
    localStringBuilder.append("code=").append(this.d).append(",");
    localStringBuilder.append("nation=").append(this.b).append(",");
    localStringBuilder.append("province=").append(this.e).append(",");
    localStringBuilder.append("city=").append(this.f).append(",");
    localStringBuilder.append("district=").append(this.g).append(",");
    localStringBuilder.append("town=").append(this.h).append(",");
    localStringBuilder.append("village=").append(this.i).append(",");
    localStringBuilder.append("street=").append(this.j).append(",");
    localStringBuilder.append("street_no=").append(this.k).append(",");
    localStringBuilder.append("bundle").append(this.l).append(",");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */