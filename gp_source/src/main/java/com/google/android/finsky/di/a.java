package com.google.android.finsky.di;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.UUID;

public final class a
{
  public static final UUID a = UUID.fromString("41217664-9172-527a-b3d5-edabb50a7d69");
  public final Method b;
  public final Method c;
  public final Method d;
  public final boolean e;
  public final Handler f;
  public final Method g;
  public final Object h;
  private Handler i;
  private final Context j;
  private final Method k;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    this.j = paramContext.getApplicationContext();
    this.f = new Handler(Looper.getMainLooper());
    if (android.support.v4.os.a.b())
    {
      this.h = paramContext.getSystemService("storagestats");
      paramContext = this.h;
      if (paramContext == null) {}
      for (this.g = null;; this.g = k.a(paramContext))
      {
        this.b = k.a("getAppBytes");
        this.d = k.a("getDataBytes");
        this.c = k.a("getCacheBytes");
        if (this.h != null) {
          if (this.g != null) {
            if (this.b != null) {
              if (this.d != null) {
                if (this.c == null) {}
              }
            }
          }
        }
        for (;;)
        {
          this.e = bool1;
          this.k = null;
          return;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
        }
      }
    }
    this.k = k.a(paramContext);
    if (this.k != null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.e = bool1;
      this.h = null;
      this.g = null;
      this.b = null;
      this.d = null;
      this.c = null;
      return;
    }
  }
  
  public final void a(String paramString, j paramj)
  {
    if (!this.e) {
      paramj.a(paramString, 1600, null);
    }
    Object localObject;
    h localh;
    if (!android.support.v4.os.a.b())
    {
      localObject = this.j.getPackageManager();
      localh = new h(this, paramj, paramString);
    }
    try
    {
      this.k.invoke(localObject, new Object[] { paramString, localh });
      return;
    }
    catch (Exception localException)
    {
      this.f.post(new c(paramj, paramString, localException));
    }
    if (this.i == null)
    {
      localObject = com.google.android.finsky.utils.c.a("Package size fetching thread");
      ((HandlerThread)localObject).start();
      this.i = new Handler(((HandlerThread)localObject).getLooper());
    }
    this.i.post(new b(this, paramString, paramj));
    return;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/di/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */