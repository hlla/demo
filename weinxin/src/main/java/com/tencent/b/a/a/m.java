package com.tencent.b.a.a;

import android.content.Context;
import android.util.DisplayMetrics;
import org.json.JSONArray;
import org.json.JSONObject;

final class m
{
  private int aQx = 0;
  private JSONObject aQy = null;
  protected Context context = null;
  
  m(Context paramContext, JSONObject paramJSONObject)
  {
    this.context = paramContext;
    this.aQx = ((int)(System.currentTimeMillis() / 1000L));
    this.aQy = paramJSONObject;
  }
  
  final JSONObject nQ()
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("ky", "AVF4T76RVR81");
        localJSONObject1.put("et", 2);
        localJSONObject1.put("ts", this.aQx);
        localJSONObject1.put("si", this.aQx);
        s.a(localJSONObject1, "ui", s.V(this.context));
        s.a(localJSONObject1, "mc", s.W(this.context));
        localObject1 = i.R(this.context).nP();
        if (s.aK((String)localObject1))
        {
          localJSONObject1.put("mid", localObject1);
          localObject1 = new b(this.context);
          localJSONObject2 = new JSONObject();
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        JSONObject localJSONObject2;
        return localJSONObject1;
      }
      try
      {
        if (b.aPV != null)
        {
          b.a locala = b.aPV;
          localJSONObject2.put("sr", locala.aQa.widthPixels + "*" + locala.aQa.heightPixels);
          s.a(localJSONObject2, "av", locala.aPY);
          s.a(localJSONObject2, "ch", locala.aQe);
          s.a(localJSONObject2, "mf", locala.aQc);
          s.a(localJSONObject2, "sv", locala.aPZ);
          s.a(localJSONObject2, "ov", Integer.toString(locala.aQb));
          localJSONObject2.put("os", 1);
          s.a(localJSONObject2, "op", locala.aQf);
          s.a(localJSONObject2, "lg", locala.aQd);
          s.a(localJSONObject2, "md", locala.model);
          s.a(localJSONObject2, "tz", locala.timezone);
          if (locala.aQh != 0) {
            localJSONObject2.put("jb", locala.aQh);
          }
          s.a(localJSONObject2, "sd", locala.aQg);
          s.a(localJSONObject2, "apn", locala.packageName);
          if (s.U(locala.ctx))
          {
            localObject2 = new JSONObject();
            s.a((JSONObject)localObject2, "bs", s.X(locala.ctx));
            s.a((JSONObject)localObject2, "ss", s.Y(locala.ctx));
            if (((JSONObject)localObject2).length() > 0) {
              s.a(localJSONObject2, "wf", ((JSONObject)localObject2).toString());
            }
          }
          Object localObject2 = s.Z(locala.ctx);
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
            s.a(localJSONObject2, "wflist", ((JSONArray)localObject2).toString());
          }
          s.a(localJSONObject2, "ram", locala.aQi);
          s.a(localJSONObject2, "rom", locala.aQj);
          s.a(localJSONObject2, "im", locala.imsi);
        }
        s.a(localJSONObject2, "cn", ((b)localObject1).aPX);
        if (((b)localObject1).aPW != null) {
          localJSONObject2.put("tn", ((b)localObject1).aPW);
        }
        localJSONObject1.put("ev", localJSONObject2);
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      if (this.aQy == null) {
        break;
      }
      localJSONObject1.put("ext", this.aQy);
      return localJSONObject1;
      localJSONObject1.put("mid", "0");
    }
    return localJSONObject1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/b/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */