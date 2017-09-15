package ct;

import android.os.Bundle;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class cm
{
  public int a;
  public final ArrayList<TencentPoi> b = new ArrayList();
  public cq c;
  
  cm() {}
  
  public cm(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("stat");
    if (paramJSONObject.has("subnation")) {
      this.c = new cq(paramJSONObject.optJSONObject("subnation"));
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject.optJSONArray("poilist");
      if (paramJSONObject != null) {
        try
        {
          int j = paramJSONObject.length();
          int i = 0;
          for (;;)
          {
            if (i < j)
            {
              cp localcp = new cp(paramJSONObject.getJSONObject(i));
              this.b.add(localcp);
              i += 1;
              continue;
              if (paramJSONObject.has("results"))
              {
                this.c = a(paramJSONObject.optJSONArray("results"));
                break;
              }
              this.c = cq.a;
              b.a.b("DetailsData", "DetailsData: unknown json " + paramJSONObject.toString());
            }
          }
        }
        catch (JSONException paramJSONObject)
        {
          b.a.a("DetailsData", "json error", paramJSONObject);
        }
      }
    }
  }
  
  private static cq a(@Nullable JSONArray paramJSONArray)
  {
    int i = 2;
    if (paramJSONArray == null) {
      localObject1 = null;
    }
    cq localcq;
    int j;
    Object localObject2;
    do
    {
      return (cq)localObject1;
      localcq = cq.a(cq.a);
      j = paramJSONArray.length();
      if (j > 0)
      {
        localObject1 = paramJSONArray.optJSONObject(0);
        localcq.b = ((JSONObject)localObject1).optString("n");
        localcq.e = ((JSONObject)localObject1).optString("p");
        localcq.f = ((JSONObject)localObject1).optString("c");
        localcq.g = ((JSONObject)localObject1).optString("d");
        localcq.d = ((JSONObject)localObject1).optString("adcode");
      }
      if (j > 1)
      {
        localObject1 = paramJSONArray.optJSONObject(1);
        localObject2 = ((JSONObject)localObject1).optString("address_name");
        localcq.l.putString("addrdesp.name", (String)localObject2);
        localObject2 = ((JSONObject)localObject1).optJSONObject("landmark");
        localObject1 = ((JSONObject)localObject1).optJSONObject("second_landmark");
        if (localObject2 != null) {
          localcq.l.putParcelable("addrdesp.landmark", new cl((JSONObject)localObject2));
        }
        if (localObject1 != null) {
          localcq.l.putParcelable("addrdesp.second_landmark", new cl((JSONObject)localObject1));
        }
      }
      localObject1 = localcq;
    } while (j <= 2);
    Object localObject1 = new ArrayList();
    if (i < j)
    {
      localObject2 = new cl(paramJSONArray.optJSONObject(i));
      ((ArrayList)localObject1).add(localObject2);
      if ("ST".equals(((cl)localObject2).b)) {
        localcq.j = ((cl)localObject2).a;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("ST_NO".equals(((cl)localObject2).b)) {
          localcq.k = ((cl)localObject2).a;
        }
      }
    }
    localcq.l.putParcelableArrayList("addrdesp.results", (ArrayList)localObject1);
    return localcq;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DetailsData{");
    localStringBuilder.append("subnation=").append(this.c).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */