package com.google.android.gms.ads.internal.overlay.a;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends RemoteCreator
{
  public a()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public final b a(Activity paramActivity)
  {
    try
    {
      com.google.android.gms.ads.internal.j.a locala = com.google.android.gms.dynamic.e.a(paramActivity);
      paramActivity = c.a(((e)b(paramActivity)).a(locala));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      k.e("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException paramActivity)
    {
      k.e("Could not create remote AdOverlay.", paramActivity);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */