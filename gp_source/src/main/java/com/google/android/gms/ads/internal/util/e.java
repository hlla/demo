package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.client.k;

@a
public final class e
  extends k
{
  public static void a(String paramString)
  {
    if (a()) {
      Log.v("Ads", paramString);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (a()) {
      Log.v("Ads", paramString, paramThrowable);
    }
  }
  
  public static boolean a()
  {
    return (a(2)) && (((Boolean)n.at.a()).booleanValue());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */