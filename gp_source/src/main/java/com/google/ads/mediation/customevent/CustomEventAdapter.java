package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.mediation.l;
import com.google.ads.mediation.n;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter
  implements l, n
{
  private d a;
  private e b;
  
  private static Object f()
  {
    try
    {
      Object localObject1 = Class.forName(null).newInstance();
      return localObject1;
    }
    finally
    {
      String str = ((Throwable)localObject2).getMessage();
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(null).length() + 46 + String.valueOf(str).length());
      localStringBuilder.append("Could not instantiate custom event adapter: ");
      localStringBuilder.append(null);
      localStringBuilder.append(". ");
      localStringBuilder.append(str);
      k.e(localStringBuilder.toString());
    }
    return null;
  }
  
  public final void a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((d)localObject).a();
    }
    localObject = this.b;
    if (localObject != null) {
      ((e)localObject).a();
    }
  }
  
  public final Class b()
  {
    return com.google.android.gms.ads.mediation.customevent.f.class;
  }
  
  public final Class c()
  {
    return f.class;
  }
  
  public final View d()
  {
    return null;
  }
  
  public final void e()
  {
    this.b.c();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/mediation/customevent/CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */