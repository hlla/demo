package com.airbnb.lottie.c.b;

import android.graphics.Path.FillType;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s
  implements b
{
  public final List a;
  public final String b;
  
  public s(String paramString, List paramList)
  {
    this.b = paramString;
    this.a = paramList;
  }
  
  public static b a(JSONObject paramJSONObject, com.airbnb.lottie.i parami)
  {
    Object localObject1 = paramJSONObject.optString("ty");
    int i;
    switch (((String)localObject1).hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      switch (i)
      {
      default: 
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("Unknown shape type ");
        paramJSONObject.append((String)localObject1);
        Log.w("LOTTIE", paramJSONObject.toString());
        return null;
      case 1: 
        localObject1 = paramJSONObject.optString("nm");
        localObject2 = new ArrayList();
        localObject3 = com.airbnb.lottie.c.a.b.a(paramJSONObject.optJSONObject("c"), parami);
        localObject4 = com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("w"), parami, true);
        localObject5 = com.airbnb.lottie.c.a.j.a(paramJSONObject.optJSONObject("o"), parami);
        localObject6 = w.values()[(paramJSONObject.optInt("lc") - 1)];
        localObject7 = x.values()[(paramJSONObject.optInt("lj") - 1)];
        if (paramJSONObject.has("d"))
        {
          localObject8 = paramJSONObject.optJSONArray("d");
          paramJSONObject = null;
          i = 0;
          if (i < ((JSONArray)localObject8).length())
          {
            localObject9 = ((JSONArray)localObject8).optJSONObject(i);
            localObject10 = ((JSONObject)localObject9).optString("n");
            if (((String)localObject10).equals("o")) {
              paramJSONObject = com.airbnb.lottie.c.a.d.a(((JSONObject)localObject9).optJSONObject("v"), parami, true);
            }
            for (;;)
            {
              i += 1;
              break;
              if (((String)localObject10).equals("d")) {}
              while (((String)localObject10).equals("g"))
              {
                ((List)localObject2).add(com.airbnb.lottie.c.a.d.a(((JSONObject)localObject9).optJSONObject("v"), parami, true));
                break;
              }
            }
          }
          if (((List)localObject2).size() == 1) {
            ((List)localObject2).add(((List)localObject2).get(0));
          }
        }
        for (;;)
        {
          return new u((String)localObject1, paramJSONObject, (List)localObject2, (com.airbnb.lottie.c.a.a)localObject3, (com.airbnb.lottie.c.a.i)localObject5, (com.airbnb.lottie.c.a.c)localObject4, (w)localObject6, (x)localObject7);
          continue;
          paramJSONObject = null;
        }
      case 12: 
        return new o(paramJSONObject.optString("nm"), com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("c"), parami, false), com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("o"), parami, false), com.airbnb.lottie.c.a.x.a(paramJSONObject.optJSONObject("tr"), parami));
      case 11: 
        return new j(paramJSONObject.optString("nm"), k.a(paramJSONObject.optInt("mm", 1)));
      case 10: 
        localObject3 = paramJSONObject.optString("nm");
        int j = paramJSONObject.optInt("sy");
        localObject4 = m.values();
        int k = localObject4.length;
        i = 0;
        while (i < k)
        {
          localObject2 = localObject4[i];
          localObject1 = localObject2;
          if (((m)localObject2).c == j) {
            break label625;
          }
          i += 1;
        }
        localObject1 = null;
        localObject4 = com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("pt"), parami, false);
        localObject5 = com.airbnb.lottie.c.a.l.a(paramJSONObject.optJSONObject("p"), parami);
        localObject6 = com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("r"), parami, false);
        localObject7 = com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("or"), parami, true);
        localObject8 = com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("os"), parami, false);
        if (localObject1 == m.b)
        {
          localObject2 = com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("ir"), parami, true);
          parami = com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("is"), parami, false);
          paramJSONObject = (JSONObject)localObject2;
        }
        for (;;)
        {
          return new l((String)localObject3, (m)localObject1, (com.airbnb.lottie.c.a.c)localObject4, (com.airbnb.lottie.c.a.y)localObject5, (com.airbnb.lottie.c.a.c)localObject6, paramJSONObject, (com.airbnb.lottie.c.a.c)localObject7, parami, (com.airbnb.lottie.c.a.c)localObject8);
          paramJSONObject = null;
          parami = null;
        }
      case 9: 
        return new y(paramJSONObject.optString("nm"), z.a(paramJSONObject.optInt("m", 1)), com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("s"), parami, false), com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("e"), parami, false), com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("o"), parami, false));
      case 8: 
        return new n(paramJSONObject.optString("nm"), com.airbnb.lottie.c.a.l.a(paramJSONObject.optJSONObject("p"), parami), com.airbnb.lottie.c.a.o.a(paramJSONObject.optJSONObject("s"), parami), com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("r"), parami, true));
      case 7: 
        return new a(paramJSONObject.optString("nm"), com.airbnb.lottie.c.a.l.a(paramJSONObject.optJSONObject("p"), parami), com.airbnb.lottie.c.a.o.a(paramJSONObject.optJSONObject("s"), parami));
      case 6: 
        parami = com.airbnb.lottie.c.a.r.a(paramJSONObject.optJSONObject("ks"), parami);
        return new t(paramJSONObject.optString("nm"), paramJSONObject.optInt("ind"), parami);
      case 5: 
        return com.airbnb.lottie.c.a.x.a(paramJSONObject, parami);
      case 4: 
        return e.a(paramJSONObject, parami);
      case 3: 
        localObject2 = paramJSONObject.optString("nm");
        localObject1 = paramJSONObject.optJSONObject("c");
        if (localObject1 != null) {}
        for (localObject1 = com.airbnb.lottie.c.a.b.a((JSONObject)localObject1, parami);; localObject1 = null)
        {
          localObject3 = paramJSONObject.optJSONObject("o");
          if (localObject3 != null) {}
          for (parami = com.airbnb.lottie.c.a.j.a((JSONObject)localObject3, parami);; parami = null)
          {
            boolean bool = paramJSONObject.optBoolean("fillEnabled");
            if (paramJSONObject.optInt("r", 1) != 1) {}
            for (paramJSONObject = Path.FillType.EVEN_ODD;; paramJSONObject = Path.FillType.WINDING) {
              return new r((String)localObject2, bool, paramJSONObject, (com.airbnb.lottie.c.a.a)localObject1, parami);
            }
          }
        }
      case 2: 
        label625:
        localObject6 = paramJSONObject.optString("nm");
        localObject2 = paramJSONObject.optJSONObject("g");
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((JSONObject)localObject2).has("k")) {
            localObject1 = ((JSONObject)localObject2).optJSONObject("k");
          }
        }
        if (localObject1 != null) {}
        for (localObject1 = com.airbnb.lottie.c.a.g.a((JSONObject)localObject1, parami);; localObject1 = null)
        {
          localObject2 = paramJSONObject.optJSONObject("o");
          if (localObject2 != null) {}
          for (localObject2 = com.airbnb.lottie.c.a.j.a((JSONObject)localObject2, parami);; localObject2 = null)
          {
            if (paramJSONObject.optInt("t", 1) != 1) {}
            for (localObject3 = g.b;; localObject3 = g.a)
            {
              localObject4 = paramJSONObject.optJSONObject("s");
              if (localObject4 != null) {}
              for (localObject4 = com.airbnb.lottie.c.a.o.a((JSONObject)localObject4, parami);; localObject4 = null)
              {
                localObject5 = paramJSONObject.optJSONObject("e");
                if (localObject5 != null) {}
                for (localObject5 = com.airbnb.lottie.c.a.o.a((JSONObject)localObject5, parami);; localObject5 = null)
                {
                  localObject7 = com.airbnb.lottie.c.a.d.a(paramJSONObject.optJSONObject("w"), parami, true);
                  localObject8 = w.values()[(paramJSONObject.optInt("lc") - 1)];
                  localObject9 = x.values()[(paramJSONObject.optInt("lj") - 1)];
                  localObject10 = new ArrayList();
                  if (paramJSONObject.has("d"))
                  {
                    JSONArray localJSONArray = paramJSONObject.optJSONArray("d");
                    paramJSONObject = null;
                    i = 0;
                    if (i < localJSONArray.length())
                    {
                      JSONObject localJSONObject = localJSONArray.optJSONObject(i);
                      String str = localJSONObject.optString("n");
                      if (str.equals("o")) {
                        paramJSONObject = com.airbnb.lottie.c.a.d.a(localJSONObject.optJSONObject("v"), parami, true);
                      }
                      for (;;)
                      {
                        i += 1;
                        break;
                        if (str.equals("d")) {}
                        while (str.equals("g"))
                        {
                          ((List)localObject10).add(com.airbnb.lottie.c.a.d.a(localJSONObject.optJSONObject("v"), parami, true));
                          break;
                        }
                      }
                    }
                    if (((List)localObject10).size() == 1) {
                      ((List)localObject10).add(((List)localObject10).get(0));
                    }
                  }
                  for (;;)
                  {
                    return new f((String)localObject6, (g)localObject3, (com.airbnb.lottie.c.a.f)localObject1, (com.airbnb.lottie.c.a.i)localObject2, (com.airbnb.lottie.c.a.n)localObject4, (com.airbnb.lottie.c.a.n)localObject5, (com.airbnb.lottie.c.a.c)localObject7, (w)localObject8, (x)localObject9, (List)localObject10, paramJSONObject);
                    continue;
                    paramJSONObject = null;
                  }
                }
              }
            }
          }
        }
      }
      localObject1 = paramJSONObject.optJSONArray("it");
      paramJSONObject = paramJSONObject.optString("nm");
      Object localObject2 = new ArrayList();
      i = 0;
      if (i < ((JSONArray)localObject1).length())
      {
        localObject3 = a(((JSONArray)localObject1).optJSONObject(i), parami);
        if (localObject3 == null) {}
        for (;;)
        {
          i += 1;
          break;
          ((List)localObject2).add(localObject3);
        }
      }
      return new s(paramJSONObject, (List)localObject2);
      if (!((String)localObject1).equals("tr")) {
        break;
      }
      i = 5;
      continue;
      if (!((String)localObject1).equals("tm")) {
        break;
      }
      i = 9;
      continue;
      if (!((String)localObject1).equals("st")) {
        break;
      }
      i = 1;
      continue;
      if (!((String)localObject1).equals("sr")) {
        break;
      }
      i = 10;
      continue;
      if (!((String)localObject1).equals("sh")) {
        break;
      }
      i = 6;
      continue;
      if (!((String)localObject1).equals("rp")) {
        break;
      }
      i = 12;
      continue;
      if (!((String)localObject1).equals("rc")) {
        break;
      }
      i = 8;
      continue;
      if (!((String)localObject1).equals("mm")) {
        break;
      }
      i = 11;
      continue;
      if (!((String)localObject1).equals("gs")) {
        break;
      }
      i = 2;
      continue;
      if (!((String)localObject1).equals("gr")) {
        break;
      }
      i = 0;
      continue;
      if (!((String)localObject1).equals("gf")) {
        break;
      }
      i = 4;
      continue;
      if (!((String)localObject1).equals("fl")) {
        break;
      }
      i = 3;
      continue;
      if (!((String)localObject1).equals("el")) {
        break;
      }
      i = 7;
    }
  }
  
  public final com.airbnb.lottie.a.a.c a(com.airbnb.lottie.k paramk, com.airbnb.lottie.c.c.a parama)
  {
    return new com.airbnb.lottie.a.a.d(paramk, parama, this);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeGroup{name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append("' Shapes: ");
    localStringBuilder.append(Arrays.toString(this.a.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */