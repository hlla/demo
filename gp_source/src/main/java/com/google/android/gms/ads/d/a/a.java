package com.google.android.gms.ads.d.a;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.d;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends RemoteCreator
{
  private static final a a = new a();
  
  private a()
  {
    super("com.google.android.gms.ads.measurement.GmpMeasurementReporterCreatorImpl");
  }
  
  public static b a(Context paramContext)
  {
    int i = d.a(paramContext, 8200000);
    if (i == 2) {
      throw new GooglePlayServicesNotAvailableException(2);
    }
    if (i == 0)
    {
      paramContext = a.c(paramContext);
      if (paramContext == null) {
        throw new GooglePlayServicesNotAvailableException(8);
      }
    }
    else
    {
      throw new GooglePlayServicesNotAvailableException(1);
    }
    return paramContext;
  }
  
  private final b c(Context paramContext)
  {
    try
    {
      com.google.android.gms.ads.internal.j.a locala = com.google.android.gms.dynamic.e.a(paramContext);
      paramContext = c.a(((e)b(paramContext)).a(locala));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      com.google.android.gms.ads.internal.util.e.b("Could not create remote GmpMeasurementReporter.", paramContext);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */