package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.mediation.client.b;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

@com.google.android.gms.ads.internal.q.a.a
public final class e
  extends RemoteCreator
{
  public e()
  {
    super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
  }
  
  public final af a(Context paramContext, String paramString, b paramb)
  {
    try
    {
      com.google.android.gms.ads.internal.j.a locala = com.google.android.gms.dynamic.e.a(paramContext);
      paramContext = ag.a(((ai)b(paramContext)).a(locala, paramString, paramb));
      return paramContext;
    }
    catch (RemoteCreator.RemoteCreatorException paramContext)
    {
      k.e("Could not create remote builder for AdLoader.", paramContext);
      return null;
    }
    catch (RemoteException paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */