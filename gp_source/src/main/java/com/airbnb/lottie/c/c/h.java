package com.airbnb.lottie.c.c;

import android.graphics.Color;
import com.airbnb.lottie.c.a.aa;
import com.airbnb.lottie.c.a.ab;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.c;
import com.airbnb.lottie.c.a.r;
import com.airbnb.lottie.c.a.t;
import com.airbnb.lottie.c.a.u;
import com.airbnb.lottie.c.a.v;
import com.airbnb.lottie.c.a.w;
import com.airbnb.lottie.c.a.x;
import com.airbnb.lottie.c.b.s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
{
  public static g a(JSONObject paramJSONObject, com.airbnb.lottie.i parami)
  {
    String str1 = paramJSONObject.optString("nm");
    String str2 = paramJSONObject.optString("refId");
    if ((str1.endsWith(".ai")) || (paramJSONObject.optString("cl", "").equals("ai"))) {
      parami.a("Convert your Illustrator layers to shape layers.");
    }
    long l1 = paramJSONObject.optLong("ind");
    int i = paramJSONObject.optInt("ty", -1);
    if (i < i.g.ordinal()) {}
    for (Object localObject1 = i.values()[i];; localObject1 = i.g)
    {
      Object localObject2;
      if (localObject1 == i.f) {
        if (!com.airbnb.lottie.d.h.a(parami, 8))
        {
          localObject2 = i.g;
          parami.a("Text is only supported on bodymovin >= 4.8.0");
        }
      }
      for (;;)
      {
        long l2 = paramJSONObject.optLong("parent", -1L);
        int j;
        int k;
        if (localObject2 == i.e)
        {
          j = (int)(paramJSONObject.optInt("sw") * parami.c);
          k = (int)(paramJSONObject.optInt("sh") * parami.c);
        }
        for (int m = Color.parseColor(paramJSONObject.optString("sc"));; m = 0)
        {
          w localw = x.a(paramJSONObject.optJSONObject("ks"), parami);
          j localj = j.values()[paramJSONObject.optInt("tt")];
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Object localObject3 = paramJSONObject.optJSONArray("masksProperties");
          if (localObject3 == null) {}
          label410:
          label433:
          label456:
          label473:
          int n;
          label839:
          label876:
          do
          {
            ArrayList localArrayList3 = new ArrayList();
            localObject1 = paramJSONObject.optJSONArray("shapes");
            if (localObject1 == null)
            {
              localObject1 = paramJSONObject.optJSONObject("t");
              Object localObject5;
              if (localObject1 != null)
              {
                localObject3 = ((JSONObject)localObject1).optJSONObject("d");
                if ((localObject3 != null) && (((JSONObject)localObject3).has("x"))) {
                  parami.a("Lottie doesn't support expressions.");
                }
                localObject3 = aa.a((JSONObject)localObject3, 1.0F, parami, u.a).a();
                t localt = new t(((ab)localObject3).b, (com.airbnb.lottie.c.d)((ab)localObject3).a);
                localObject1 = ((JSONObject)localObject1).optJSONArray("a").optJSONObject(0);
                if ((localObject1 != null) && (((JSONObject)localObject1).has("a")))
                {
                  localObject5 = ((JSONObject)localObject1).optJSONObject("a");
                  localObject1 = ((JSONObject)localObject5).optJSONObject("fc");
                  if (localObject1 != null)
                  {
                    localObject1 = b.a((JSONObject)localObject1, parami);
                    localObject3 = ((JSONObject)localObject5).optJSONObject("sc");
                    if (localObject3 != null)
                    {
                      localObject3 = b.a((JSONObject)localObject3, parami);
                      localObject4 = ((JSONObject)localObject5).optJSONObject("sw");
                      if (localObject4 != null)
                      {
                        localObject4 = com.airbnb.lottie.c.a.d.a((JSONObject)localObject4, parami, true);
                        localObject5 = ((JSONObject)localObject5).optJSONObject("t");
                        if (localObject5 != null)
                        {
                          localObject5 = com.airbnb.lottie.c.a.d.a((JSONObject)localObject5, parami, true);
                          localObject1 = new v((com.airbnb.lottie.c.a.a)localObject1, (com.airbnb.lottie.c.a.a)localObject3, (c)localObject4, (c)localObject5);
                          localObject3 = localObject1;
                          localObject1 = localt;
                        }
                      }
                    }
                  }
                }
              }
              for (;;)
              {
                if (paramJSONObject.has("ef")) {
                  parami.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape.");
                }
                float f3 = (float)paramJSONObject.optDouble("sr", 1.0D);
                float f4 = (float)paramJSONObject.optDouble("st") / parami.b();
                if (localObject2 == i.c) {
                  i = (int)(paramJSONObject.optInt("w") * parami.c);
                }
                for (n = (int)(paramJSONObject.optInt("h") * parami.c);; n = 0)
                {
                  float f5 = (float)paramJSONObject.optLong("ip") / f3;
                  float f2 = (float)paramJSONObject.optLong("op") / f3;
                  if (f5 > 0.0F)
                  {
                    localObject4 = Float.valueOf(0.0F);
                    localArrayList2.add(new com.airbnb.lottie.a.a(parami, localObject4, localObject4, null, 0.0F, Float.valueOf(f5)));
                  }
                  float f1 = f2;
                  if (f2 <= 0.0F) {
                    f1 = (float)(parami.d + 1L);
                  }
                  localObject4 = Float.valueOf(1.0F);
                  localArrayList2.add(new com.airbnb.lottie.a.a(parami, localObject4, localObject4, null, f5, Float.valueOf(f1)));
                  localObject4 = Float.valueOf(0.0F);
                  localArrayList2.add(new com.airbnb.lottie.a.a(parami, localObject4, localObject4, null, f1, Float.valueOf(Float.MAX_VALUE)));
                  if (paramJSONObject.has("tm")) {}
                  for (paramJSONObject = com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("tm"), parami, false);; paramJSONObject = null) {
                    return new g(localArrayList3, parami, str1, l1, (i)localObject2, l2, str2, localArrayList1, localw, j, k, m, f3, f4, i, n, (t)localObject1, (v)localObject3, localArrayList2, localj, paramJSONObject, (byte)0);
                  }
                  i = 0;
                }
                localObject5 = null;
                break label456;
                localObject4 = null;
                break label433;
                localObject3 = null;
                break label410;
                localObject1 = null;
                break;
                localObject1 = new v(null, null, null, null);
                break label473;
                localObject1 = null;
                localObject3 = null;
              }
            }
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localObject3 = s.a(((JSONArray)localObject1).optJSONObject(i), parami);
              if (localObject3 != null) {
                break label876;
              }
            }
            for (;;)
            {
              i += 1;
              break label839;
              break;
              localArrayList3.add(localObject3);
            }
            n = 0;
          } while (n >= ((JSONArray)localObject3).length());
          Object localObject4 = ((JSONArray)localObject3).optJSONObject(n);
          localObject1 = ((JSONObject)localObject4).optString("mode");
          switch (((String)localObject1).hashCode())
          {
          default: 
            label960:
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              localObject1 = com.airbnb.lottie.c.b.i.d;
            }
            for (;;)
            {
              localArrayList1.add(new com.airbnb.lottie.c.b.h((com.airbnb.lottie.c.b.i)localObject1, r.a(((JSONObject)localObject4).optJSONObject("pt"), parami), com.airbnb.lottie.c.a.j.a(((JSONObject)localObject4).optJSONObject("o"), parami)));
              n += 1;
              break;
              localObject1 = com.airbnb.lottie.c.b.i.b;
              continue;
              localObject1 = com.airbnb.lottie.c.b.i.c;
              continue;
              localObject1 = com.airbnb.lottie.c.b.i.a;
            }
            if (!((String)localObject1).equals("s")) {
              break label960;
            }
            i = 1;
            continue;
            if (!((String)localObject1).equals("i")) {
              break label960;
            }
            i = 2;
            continue;
            if (!((String)localObject1).equals("a")) {
              break label960;
            }
            i = 0;
          }
          j = 0;
          k = 0;
        }
        localObject2 = localObject1;
        continue;
        localObject2 = localObject1;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */