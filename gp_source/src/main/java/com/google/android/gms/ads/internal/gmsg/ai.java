package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class ai
  implements u
{
  private final Object a = new Object();
  private final Map b = new HashMap();
  
  public final void a(Object paramObject, Map paramMap)
  {
    String str1 = (String)paramMap.get("id");
    String str2 = (String)paramMap.get("fail");
    paramObject = (String)paramMap.get("fail_reason");
    ??? = (String)paramMap.get("fail_stack");
    String str3 = (String)paramMap.get("result");
    if (TextUtils.isEmpty((CharSequence)???)) {}
    for (paramMap = "Unknown Fail Reason.";; paramMap = (Map)paramObject)
    {
      if (TextUtils.isEmpty((CharSequence)???)) {
        paramObject = "";
      }
      for (;;)
      {
        synchronized (this.a)
        {
          localaj = (aj)this.b.remove(str1);
          if (localaj == null) {
            break label253;
          }
          if (!TextUtils.isEmpty(str2))
          {
            paramMap = String.valueOf(paramMap);
            paramObject = String.valueOf(paramObject);
            if (((String)paramObject).length() == 0)
            {
              paramObject = new String(paramMap);
              localaj.a((String)paramObject);
              return;
            }
            paramObject = paramMap.concat((String)paramObject);
            continue;
          }
          if (str3 == null) {
            break label242;
          }
          try
          {
            paramMap = new JSONObject(str3);
            if (e.a())
            {
              paramObject = String.valueOf(paramMap.toString(2));
              if (((String)paramObject).length() != 0) {
                break label232;
              }
              paramObject = new String("Result GMSG: ");
              e.a((String)paramObject);
            }
            localaj.a(paramMap);
          }
          catch (JSONException paramObject)
          {
            localaj.a(((JSONException)paramObject).getMessage());
            continue;
          }
          return;
        }
        label232:
        paramObject = "Result GMSG: ".concat((String)paramObject);
        continue;
        label242:
        localaj.a(null);
        return;
        label253:
        paramObject = String.valueOf(str1);
        if (((String)paramObject).length() == 0) {}
        for (paramObject = new String("Received result for unexpected method invocation: ");; paramObject = "Received result for unexpected method invocation: ".concat((String)paramObject))
        {
          e.e((String)paramObject);
          return;
        }
        paramObject = String.valueOf(???);
        if (((String)paramObject).length() == 0) {
          paramObject = new String("\n");
        } else {
          paramObject = "\n".concat((String)paramObject);
        }
      }
    }
  }
  
  public final void a(String paramString, aj paramaj)
  {
    synchronized (this.a)
    {
      this.b.put(paramString, paramaj);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/gmsg/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */