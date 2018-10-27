package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.a.i;
import com.android.volley.a.q;
import com.android.volley.k;
import com.android.volley.r;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.a.af;
import com.google.android.gms.ads.internal.util.a.v;
import java.io.File;
import java.util.Map;

@a
public final class ax
{
  private static r a;
  private static final Object b = new Object();
  
  static
  {
    new ay();
  }
  
  public ax(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext.getApplicationContext() != null) {
      localContext = paramContext.getApplicationContext();
    }
    a(localContext);
  }
  
  private static r a(Context paramContext)
  {
    for (;;)
    {
      synchronized (b)
      {
        if (a != null)
        {
          paramContext = a;
          return paramContext;
        }
        com.google.android.gms.ads.internal.f.n.a(paramContext);
        if (!((Boolean)com.google.android.gms.ads.internal.f.n.bT.a()).booleanValue())
        {
          localObject2 = new com.android.volley.a.e(new q());
          paramContext = new r(new i(new File(paramContext.getCacheDir(), "volley")), (k)localObject2);
          paramContext.a();
          a = paramContext;
        }
      }
      Object localObject2 = new ar(paramContext, new q());
      paramContext = new r(new i(new File(paramContext.getCacheDir(), "admob_volley"), 20971520), (k)localObject2);
      paramContext.a();
    }
  }
  
  public static v a(int paramInt, String paramString, Map paramMap, byte[] paramArrayOfByte)
  {
    be localbe = new be();
    bb localbb = new bb(paramString, localbe);
    com.google.android.gms.ads.internal.util.client.e locale = new com.google.android.gms.ads.internal.util.client.e(null);
    paramMap = new bc(paramInt, paramString, localbe, localbb, paramArrayOfByte, paramMap, locale);
    if (com.google.android.gms.ads.internal.util.client.e.b()) {}
    try
    {
      locale.a(paramString, "GET", paramMap.f(), paramMap.k());
      a.a(paramMap);
      return localbe;
    }
    catch (AuthFailureError paramString)
    {
      for (;;)
      {
        e.e(paramString.getMessage());
      }
    }
  }
  
  public static v a(String paramString)
  {
    af localaf = af.b();
    a.a(new bf(paramString, localaf));
    return localaf;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */