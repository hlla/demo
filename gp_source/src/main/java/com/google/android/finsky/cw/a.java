package com.google.android.finsky.cw;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.utils.FinskyLog;

public final class a
{
  public final ConnectivityManager a;
  public final long b;
  public final long c;
  private final com.google.android.finsky.ba.a d;
  private final c e;
  
  public a(Context paramContext, c paramc, com.google.android.finsky.ba.a parama)
  {
    this.a = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    this.e = paramc;
    this.d = parama;
    this.b = a(paramContext.getContentResolver());
    this.c = Math.min(b(paramContext.getContentResolver()), this.b);
  }
  
  private static long a(ContentResolver paramContentResolver)
  {
    label26:
    do
    {
      try
      {
        l1 = Settings.Secure.getLong(paramContentResolver, "download_manager_max_bytes_over_mobile");
        if (l1 > 0L) {
          break label26;
        }
      }
      catch (Settings.SettingNotFoundException paramContentResolver)
      {
        long l1;
        long l2;
        for (;;) {}
      }
      return ((Long)d.bS.b()).longValue();
      l2 = ((Long)d.bS.b()).longValue();
    } while (l1 >= l2);
    return l1;
  }
  
  private static long b(ContentResolver paramContentResolver)
  {
    label26:
    do
    {
      try
      {
        l1 = Settings.Secure.getLong(paramContentResolver, "download_manager_recommended_max_bytes_over_mobile");
        if (l1 > 0L) {
          break label26;
        }
      }
      catch (Settings.SettingNotFoundException paramContentResolver)
      {
        long l1;
        long l2;
        for (;;) {}
      }
      return ((Long)d.bT.b()).longValue();
      l2 = ((Long)d.bT.b()).longValue();
    } while (l1 >= l2);
    return l1;
  }
  
  @Deprecated
  public final boolean a()
  {
    Object localObject = this.d;
    if (!((com.google.android.finsky.ba.a)localObject).b)
    {
      if (((com.google.android.finsky.ba.a)localObject).c) {
        break label50;
      }
      if (!f()) {
        localObject = this.a.getNetworkInfo(1);
      }
    }
    return (localObject == null) || (!((NetworkInfo)localObject).isConnected());
    label50:
    boolean bool = c();
    FinskyLog.a("Wear network status: has network %s, unmetered %s", new Object[] { Boolean.valueOf(e()), Boolean.valueOf(bool) });
    return bool ^ true;
  }
  
  public final boolean b()
  {
    if (!this.d.c)
    {
      NetworkInfo localNetworkInfo = this.a.getNetworkInfo(1);
      return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
    }
    boolean bool = c();
    FinskyLog.a("Wear network status: has network %s, unmetered %s", new Object[] { Boolean.valueOf(e()), Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean c()
  {
    return (e()) && (!this.a.isActiveNetworkMetered());
  }
  
  public final boolean d()
  {
    boolean bool = false;
    if (this.a.getNetworkInfo(0) != null) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean e()
  {
    NetworkInfo localNetworkInfo = this.a.getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
  
  public final boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.e.cY().a(12629326L))
    {
      NetworkInfo localNetworkInfo = this.a.getActiveNetworkInfo();
      bool1 = bool2;
      if (localNetworkInfo != null)
      {
        bool1 = bool2;
        if (localNetworkInfo.isConnected())
        {
          bool1 = bool2;
          if (localNetworkInfo.getType() == 9) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cw/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */