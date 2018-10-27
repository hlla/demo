package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.mediation.client.b;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class f
  extends RemoteCreator
{
  public f()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  public final al a(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, b paramb, int paramInt)
  {
    try
    {
      com.google.android.gms.ads.internal.j.a locala = e.a(paramContext);
      paramContext = am.a(((ao)b(paramContext)).a(locala, paramAdSizeParcel, paramString, paramb, paramInt));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      k.b("Could not create remote AdManager.", paramContext);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */