package com.google.android.gms.ads.internal.mediation.client.rtb;

import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.mediation.a.e;
import java.lang.reflect.Constructor;

@a
public class o
{
  public static j a(String paramString)
  {
    try
    {
      paramString = new p((e)Class.forName(paramString, false, o.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      return paramString;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/rtb/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */