package com.google.android.gms.ads.internal.mediation.client;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.q;
import com.google.android.gms.ads.internal.mediation.client.rtb.j;
import com.google.android.gms.ads.internal.mediation.client.rtb.o;
import com.google.android.gms.ads.mediation.b;
import com.google.android.gms.ads.mediation.customevent.f;
import java.lang.reflect.Constructor;
import java.util.Map;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends c
{
  public Map a;
  
  static
  {
    new o();
  }
  
  private final e d(String paramString)
  {
    try
    {
      Object localObject1 = Class.forName(paramString, false, a.class.getClassLoader());
      if (com.google.ads.mediation.k.class.isAssignableFrom((Class)localObject1)) {
        break label115;
      }
      if (!b.class.isAssignableFrom((Class)localObject1))
      {
        localObject1 = new StringBuilder(String.valueOf(paramString).length() + 64);
        ((StringBuilder)localObject1).append("Could not instantiate mediation adapter: ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" (not a valid adapter).");
        com.google.android.gms.ads.internal.util.client.k.e(((StringBuilder)localObject1).toString());
        throw new RemoteException();
      }
    }
    finally
    {
      return e(paramString);
    }
    return new y((b)((Class)localObject2).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    label115:
    Object localObject3 = (com.google.ads.mediation.k)((Class)localObject2).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    localObject3 = new ad((com.google.ads.mediation.k)localObject3, (q)this.a.get(((com.google.ads.mediation.k)localObject3).b()));
    return (e)localObject3;
  }
  
  private final e e(String paramString)
  {
    try
    {
      com.google.android.gms.ads.internal.util.client.k.b("Reflection failed, retrying using direct instantiation");
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(paramString)) {
        break label167;
      }
      if ("com.google.ads.mediation.AdUrlAdapter".equals(paramString)) {
        break label152;
      }
      if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(paramString)) {
        break label80;
      }
      boolean bool = "com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString);
      if (bool) {
        break label51;
      }
    }
    finally
    {
      for (;;)
      {
        label51:
        label80:
        y localy1;
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 43);
        localStringBuilder.append("Could not instantiate mediation adapter: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(". ");
        com.google.android.gms.ads.internal.util.client.k.e(localStringBuilder.toString(), localThrowable);
      }
    }
    throw new RemoteException();
    return new ad(new com.google.ads.mediation.customevent.CustomEventAdapter(), (f)this.a.get(f.class));
    localy1 = new y(new com.google.android.gms.ads.mediation.customevent.CustomEventAdapter());
    return localy1;
    label152:
    return new y(new AdUrlAdapter());
    label167:
    y localy2 = new y(new AdMobAdapter());
    return localy2;
  }
  
  public final e a(String paramString)
  {
    return d(paramString);
  }
  
  public final j b(String paramString)
  {
    return o.a(paramString);
  }
  
  public final boolean c(String paramString)
  {
    try
    {
      boolean bool = com.google.android.gms.ads.mediation.customevent.a.class.isAssignableFrom(Class.forName(paramString, false, a.class.getClassLoader()));
      return bool;
    }
    finally
    {
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 80);
      localStringBuilder.append("Could not load custom event implementation class: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", assuming old implementation.");
      com.google.android.gms.ads.internal.util.client.k.e(localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */