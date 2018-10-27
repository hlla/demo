package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.util.e;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  private static boolean a(Context paramContext, Intent paramIntent, q paramq)
  {
    try
    {
      Object localObject = String.valueOf(paramIntent.toURI());
      if (((String)localObject).length() == 0) {}
      for (localObject = new String("Launching an intent: ");; localObject = "Launching an intent: ".concat((String)localObject))
      {
        e.a((String)localObject);
        localObject = bt.A.e;
        com.google.android.gms.ads.internal.util.n.a(paramContext, paramIntent);
        if (paramq == null) {
          break;
        }
        paramq.f();
        break;
      }
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      e.e(paramContext.getMessage());
      return false;
    }
  }
  
  public static boolean a(Context paramContext, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, q paramq)
  {
    Intent localIntent;
    if (paramAdLauncherIntentInfoParcel != null)
    {
      com.google.android.gms.ads.internal.f.n.a(paramContext);
      localIntent = paramAdLauncherIntentInfoParcel.b;
      if (localIntent != null) {
        return a(paramContext, localIntent, paramq);
      }
      localIntent = new Intent();
      if (TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.f))
      {
        e.e("Open GMSG did not contain a URL.");
        return false;
      }
      if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.d)) {
        localIntent.setDataAndType(Uri.parse(paramAdLauncherIntentInfoParcel.f), paramAdLauncherIntentInfoParcel.d);
      }
    }
    for (;;)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.e)) {
        localIntent.setPackage(paramAdLauncherIntentInfoParcel.e);
      }
      if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.a))
      {
        String[] arrayOfString = paramAdLauncherIntentInfoParcel.a.split("/", 2);
        if (arrayOfString.length < 2)
        {
          paramContext = String.valueOf(paramAdLauncherIntentInfoParcel.a);
          if (paramContext.length() == 0) {}
          for (paramContext = new String("Could not parse component name from open GMSG: ");; paramContext = "Could not parse component name from open GMSG: ".concat(paramContext))
          {
            e.e(paramContext);
            return false;
          }
        }
        localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
      }
      paramAdLauncherIntentInfoParcel = paramAdLauncherIntentInfoParcel.c;
      if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel)) {}
      try
      {
        i = Integer.parseInt(paramAdLauncherIntentInfoParcel);
        localIntent.addFlags(i);
        if (((Boolean)com.google.android.gms.ads.internal.f.n.Z.a()).booleanValue())
        {
          localIntent.addFlags(268435456);
          localIntent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        }
        for (;;)
        {
          return a(paramContext, localIntent, paramq);
          if (((Boolean)com.google.android.gms.ads.internal.f.n.af.a()).booleanValue())
          {
            paramAdLauncherIntentInfoParcel = bt.A.e;
            com.google.android.gms.ads.internal.util.n.b(paramContext, localIntent);
          }
        }
        localIntent.setData(Uri.parse(paramAdLauncherIntentInfoParcel.f));
        continue;
        e.e("No intent data for launcher overlay.");
        return false;
      }
      catch (NumberFormatException paramAdLauncherIntentInfoParcel)
      {
        for (;;)
        {
          e.e("Could not parse intent flags.");
          int i = 0;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */