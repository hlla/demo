package com.airbnb.lottie.c.a;

import com.airbnb.lottie.a.a;
import com.airbnb.lottie.a.b;
import com.airbnb.lottie.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aa
{
  private final i a;
  private final JSONObject b;
  private final float c;
  private final z d;
  
  private aa(JSONObject paramJSONObject, float paramFloat, i parami, z paramz)
  {
    this.b = paramJSONObject;
    this.c = paramFloat;
    this.a = parami;
    this.d = paramz;
  }
  
  public static aa a(JSONObject paramJSONObject, float paramFloat, i parami, z paramz)
  {
    return new aa(paramJSONObject, paramFloat, parami, paramz);
  }
  
  public final ab a()
  {
    Object localObject1 = this.b;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).opt("k");
      if ((localObject1 instanceof JSONArray))
      {
        localObject2 = (JSONArray)localObject1;
        localObject1 = ((JSONArray)localObject2).opt(0);
        if (((localObject1 instanceof JSONObject)) && (((JSONObject)localObject1).has("t"))) {}
      }
      else
      {
        localObject1 = Collections.emptyList();
      }
    }
    for (;;)
    {
      if (this.b != null) {
        if (!((List)localObject1).isEmpty()) {
          localObject2 = ((a)((List)localObject1).get(0)).f;
        }
      }
      for (;;)
      {
        return new ab((List)localObject1, localObject2);
        localObject2 = this.d.a(this.b.opt("k"), this.c);
        continue;
        localObject2 = null;
      }
      i locali = this.a;
      float f = this.c;
      z localz = this.d;
      int j = ((JSONArray)localObject2).length();
      if (j == 0) {
        break;
      }
      localObject1 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        ((List)localObject1).add(b.a(((JSONArray)localObject2).optJSONObject(i), locali, f, localz));
        i += 1;
      }
      a.a((List)localObject1);
      continue;
      localObject1 = Collections.emptyList();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */