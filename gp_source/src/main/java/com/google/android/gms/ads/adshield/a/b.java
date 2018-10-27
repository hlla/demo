package com.google.android.gms.ads.adshield.a;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class b
  extends RemoteCreator
{
  private static final b a = new b();
  
  private b()
  {
    super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
  }
  
  public static c a(String paramString, Context paramContext)
  {
    Object localObject;
    if (com.google.android.gms.common.d.a(paramContext, 12800000) == 0)
    {
      c localc = a.a(paramString, paramContext, false);
      localObject = localc;
      if (localc != null) {}
    }
    else
    {
      localObject = new a(paramString, paramContext, false);
    }
    return (c)localObject;
  }
  
  private final c a(String paramString, Context paramContext, boolean paramBoolean)
  {
    com.google.android.gms.ads.internal.j.a locala = e.a(paramContext);
    try
    {
      paramString = d.a(((f)b(paramContext)).a(paramString, locala));
      return paramString;
    }
    catch (RemoteException paramString)
    {
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/adshield/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */