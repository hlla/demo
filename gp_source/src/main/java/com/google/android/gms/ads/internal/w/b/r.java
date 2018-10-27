package com.google.android.gms.ads.internal.w.b;

import com.google.android.gms.ads.internal.gmsg.u;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import java.util.Map;

@a
public final class r
  implements u
{
  private static Integer a(Map paramMap, String paramString)
  {
    if (paramMap.containsKey(paramString)) {}
    try
    {
      int i = Integer.parseInt((String)paramMap.get(paramString));
      return Integer.valueOf(i);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramMap = (String)paramMap.get(paramString);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 39 + String.valueOf(paramMap).length());
      localStringBuilder.append("Precache invalid numeric parameter '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("': ");
      localStringBuilder.append(paramMap);
      e.e(localStringBuilder.toString());
    }
    return null;
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */