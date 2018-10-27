package com.google.android.gms.ads.internal.f;

import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.v.f;
import java.util.regex.Pattern;

@a
public final class p
{
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (paramString2 == null) {}
    }
    try
    {
      bool1 = Pattern.matches(paramString1, paramString2);
      return bool1;
    }
    catch (RuntimeException paramString1)
    {
      bt.A.i.a(paramString1, "NonagonUtil.isPatternMatched");
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/f/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */