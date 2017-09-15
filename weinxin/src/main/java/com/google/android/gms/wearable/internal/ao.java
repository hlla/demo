package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.api.k.b;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.wearable.a.a;
import com.google.android.gms.wearable.b.a;
import com.google.android.gms.wearable.k.a;
import com.google.android.gms.wearable.n.b;
import com.google.android.gms.wearable.n.c;
import com.google.android.gms.wearable.q.a;
import com.google.android.gms.wearable.r.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ao
  extends com.google.android.gms.common.internal.k<x>
{
  private final y<n.b> aHA = new y();
  private final y<n.c> aHB = new y();
  private final Map<String, y<a.a>> aHC = new HashMap();
  final ExecutorService aHu = Executors.newCachedThreadPool();
  private final y<r.a> aHv = new y();
  private final y<q.a> aHw = new y();
  private final y<b.a> aHx = new y();
  private final y<com.google.android.gms.wearable.c.b> aHy = new y();
  private final y<k.a> aHz = new y();
  
  public ao(Context paramContext, Looper paramLooper, com.google.android.gms.common.api.c.b paramb, c.c paramc, h paramh)
  {
    super(paramContext, paramLooper, 14, paramh, paramb, paramc);
  }
  
  protected final void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if ((!Log.isLoggable("WearableClient", 2)) || (paramInt1 == 0))
    {
      this.aHv.u(paramIBinder);
      this.aHw.u(paramIBinder);
      this.aHy.u(paramIBinder);
      this.aHz.u(paramIBinder);
      this.aHA.u(paramIBinder);
      this.aHB.u(paramIBinder);
      synchronized (this.aHC)
      {
        Iterator localIterator = this.aHC.values().iterator();
        if (localIterator.hasNext()) {
          ((y)localIterator.next()).u(paramIBinder);
        }
      }
    }
    super.a(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  public final void a(c.e parame)
  {
    int i = 7887000;
    if (!jl()) {
      try
      {
        Object localObject = this.mContext.getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
        if (localObject != null) {
          i = ((Bundle)localObject).getInt("com.google.android.wearable.api.version", 7887000);
        }
        if (i < b.amc)
        {
          new StringBuilder("Android Wear out of date. Requires API version ").append(b.amc).append(" but found ").append(i);
          Context localContext1 = this.mContext;
          Context localContext2 = this.mContext;
          localObject = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
          if (localContext2.getPackageManager().resolveActivity((Intent)localObject, 65536) != null) {}
          for (;;)
          {
            a(parame, new ConnectionResult(6, PendingIntent.getActivity(localContext1, 0, (Intent)localObject, 0)));
            return;
            localObject = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
          }
        }
        super.a(parame);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        a(parame, new ConnectionResult(16, null));
        return;
      }
    }
  }
  
  public final void disconnect()
  {
    this.aHv.a(this);
    this.aHw.a(this);
    this.aHy.a(this);
    this.aHz.a(this);
    this.aHA.a(this);
    this.aHB.a(this);
    synchronized (this.aHC)
    {
      Iterator localIterator = this.aHC.values().iterator();
      if (localIterator.hasNext()) {
        ((y)localIterator.next()).a(this);
      }
    }
    super.disconnect();
  }
  
  protected final String jT()
  {
    if (com.google.android.gms.common.k.kC().a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn")) {
      return "com.google.android.wearable.app.cn";
    }
    return "com.google.android.gms";
  }
  
  public final boolean jl()
  {
    return !com.google.android.gms.common.k.kC().a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn");
  }
  
  protected final String jm()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  protected final String jn()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */