package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import java.util.Map;

@a
public final class ab
  implements u
{
  private final ac a;
  
  public ab(ac paramac)
  {
    this.a = paramac;
  }
  
  public final void a(Object paramObject, Map paramMap)
  {
    boolean bool1 = "1".equals(paramMap.get("transparentBackground"));
    boolean bool2 = "1".equals(paramMap.get("blur"));
    try
    {
      if (paramMap.get("blurRadius") != null) {}
      for (f = Float.parseFloat((String)paramMap.get("blurRadius"));; f = 0.0F)
      {
        this.a.d(bool1);
        this.a.a(bool2, f);
        return;
      }
    }
    catch (NumberFormatException paramObject)
    {
      for (;;)
      {
        e.c("Fail to parse float", (Throwable)paramObject);
        float f = 0.0F;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/gmsg/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */