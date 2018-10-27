package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class cb
  extends RemoteCreator
{
  public cb()
  {
    super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
  }
  
  public final bc a(Context paramContext)
  {
    try
    {
      com.google.android.gms.ads.internal.j.a locala = e.a(paramContext);
      paramContext = bd.a(((bf)b(paramContext)).a(locala));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      k.e("Could not get remote MobileAdsSettingManager.", paramContext);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException paramContext)
    {
      k.e("Could not get remote MobileAdsSettingManager.", paramContext);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */