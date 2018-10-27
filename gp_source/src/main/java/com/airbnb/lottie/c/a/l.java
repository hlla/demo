package com.airbnb.lottie.c.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.j;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.d.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  implements y
{
  private PointF a;
  private final List b = new ArrayList();
  
  public l()
  {
    this.a = new PointF(0.0F, 0.0F);
  }
  
  l(Object paramObject, com.airbnb.lottie.i parami)
  {
    if ((paramObject instanceof JSONArray))
    {
      JSONArray localJSONArray = (JSONArray)paramObject;
      Object localObject1 = localJSONArray.opt(0);
      if (((localObject1 instanceof JSONObject)) && (((JSONObject)localObject1).has("t")))
      {
        int k = localJSONArray.length();
        int j = 0;
        if (j < k)
        {
          localObject1 = localJSONArray.optJSONObject(j);
          paramObject = m.a;
          com.airbnb.lottie.a.a locala = com.airbnb.lottie.a.b.a((JSONObject)localObject1, parami, parami.c, (z)paramObject);
          paramObject = ((JSONObject)localObject1).optJSONArray("ti");
          localObject1 = ((JSONObject)localObject1).optJSONArray("to");
          if (paramObject == null)
          {
            paramObject = null;
            localObject1 = null;
          }
          for (;;)
          {
            com.airbnb.lottie.a.b.i locali = new com.airbnb.lottie.a.b.i(parami, (PointF)locala.f, (PointF)locala.c, locala.d, locala.e, locala.b);
            Object localObject2 = locala.c;
            int i;
            if (localObject2 != null)
            {
              Object localObject3 = locala.f;
              if (localObject3 != null) {
                if (((PointF)localObject3).equals(((PointF)localObject2).x, ((PointF)locala.c).y)) {
                  i = 1;
                }
              }
            }
            for (;;)
            {
              if (locali.c == null) {}
              for (;;)
              {
                this.b.add(locali);
                j += 1;
                break;
                if (i == 0) {
                  locali.g = h.a((PointF)locala.f, (PointF)locala.c, (PointF)localObject1, (PointF)paramObject);
                }
              }
              i = 0;
              continue;
              i = 0;
              continue;
              i = 0;
            }
            if (localObject1 != null)
            {
              localObject1 = com.airbnb.lottie.d.b.a((JSONArray)localObject1, parami.c);
              paramObject = com.airbnb.lottie.d.b.a((JSONArray)paramObject, parami.c);
            }
            else
            {
              paramObject = null;
              localObject1 = null;
            }
          }
        }
        com.airbnb.lottie.a.a.a(this.b);
        return;
      }
    }
    this.a = com.airbnb.lottie.d.b.a((JSONArray)paramObject, parami.c);
  }
  
  public static y a(JSONObject paramJSONObject, com.airbnb.lottie.i parami)
  {
    if (paramJSONObject.has("k")) {
      return new l(paramJSONObject.opt("k"), parami);
    }
    return new s(d.a(paramJSONObject.optJSONObject("x"), parami, true), d.a(paramJSONObject.optJSONObject("y"), parami, true));
  }
  
  public final com.airbnb.lottie.a.b.a a()
  {
    if ((this.b.isEmpty() ^ true)) {
      return new j(this.b);
    }
    return new o(this.a);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initialPoint=");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */