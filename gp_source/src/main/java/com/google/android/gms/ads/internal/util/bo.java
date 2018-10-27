package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.google.android.gms.ads.internal.q.e;
import com.google.android.gms.ads.internal.util.client.k;
import java.util.concurrent.Callable;

@com.google.android.gms.ads.internal.q.a.a
public final class bo
{
  public static Object a(Context paramContext, Callable paramCallable)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    try
    {
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitDiskReads().permitDiskWrites().build());
      paramCallable = paramCallable.call();
      StrictMode.setThreadPolicy(localThreadPolicy);
      return paramCallable;
    }
    finally
    {
      try
      {
        k.c("Unexpected exception.", paramCallable);
        com.google.android.gms.ads.internal.q.a.a(paramContext).a(paramCallable, "StrictModeUtil.runWithLaxStrictMode");
        return null;
      }
      finally
      {
        StrictMode.setThreadPolicy(localThreadPolicy);
      }
    }
  }
  
  public static Object a(Callable paramCallable)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    try
    {
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitDiskReads().permitDiskWrites().build());
      paramCallable = paramCallable.call();
      return paramCallable;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */