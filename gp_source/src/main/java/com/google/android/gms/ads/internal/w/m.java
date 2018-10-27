package com.google.android.gms.ads.internal.w;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.webview.au;

@a
public abstract class m
{
  protected static boolean a(Context paramContext)
  {
    boolean bool2 = true;
    paramContext = paramContext.getApplicationInfo();
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.targetSdkVersion < 11) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  protected static boolean a(ad paramad)
  {
    return paramad.getAdSize().e();
  }
  
  public abstract l a(Context paramContext, ad paramad, int paramInt, boolean paramBoolean, com.google.android.gms.ads.internal.g.l paraml, ac paramac);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */