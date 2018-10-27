package com.google.android.gms.ads.internal.w.b;

import android.content.Context;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.w.n;
import java.util.Map;

@com.google.android.gms.ads.internal.q.a.a
public final class f
  implements com.google.android.gms.ads.internal.gmsg.u
{
  private boolean a;
  
  private static int a(Context paramContext, Map paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      com.google.android.gms.ads.internal.util.client.a locala = com.google.android.gms.ads.internal.client.u.h.a;
      i = com.google.android.gms.ads.internal.util.client.a.a(paramContext, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      paramContext = new StringBuilder(String.valueOf(paramString).length() + 34 + String.valueOf(paramMap).length());
      paramContext.append("Could not parse ");
      paramContext.append(paramString);
      paramContext.append(" in a video GMSG: ");
      paramContext.append(paramMap);
      e.e(paramContext.toString());
    }
    return paramInt;
  }
  
  private static void a(n paramn, Map paramMap)
  {
    String str1 = (String)paramMap.get("minBufferMs");
    String str2 = (String)paramMap.get("maxBufferMs");
    String str3 = (String)paramMap.get("bufferForPlaybackMs");
    paramMap = (String)paramMap.get("bufferForPlaybackAfterRebufferMs");
    if (str1 != null) {}
    try
    {
      paramn.setLowWaterMark(Integer.parseInt(str1));
      if (str2 != null) {
        paramn.setHighWaterMark(Integer.parseInt(str2));
      }
      if (str3 != null) {
        paramn.setBufferForPlayback(Integer.parseInt(str3));
      }
      if (paramMap != null) {
        paramn.setBufferForPlaybackAfterRebuffer(Integer.parseInt(paramMap));
      }
      return;
    }
    catch (NumberFormatException paramn)
    {
      e.e(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[] { str1, str2 }));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */