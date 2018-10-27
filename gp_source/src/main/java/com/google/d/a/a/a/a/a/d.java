package com.google.d.a.a.a.a.a;

import android.content.ContentProvider;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.common.base.u;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public final class d
{
  public static a a;
  private static final Object b = new Object();
  private static WeakReference c;
  private static Configuration d;
  private static Resources e;
  private static FutureTask f;
  private static final CountDownLatch g = new CountDownLatch(1);
  private static final WeakHashMap h = new WeakHashMap();
  
  private static u a()
  {
    Object localObject;
    if (Thread.interrupted())
    {
      localObject = String.valueOf(Thread.currentThread().getName()).concat(" interrupted; falling back to original resources.");
      Log.w("filteredResources", (String)localObject);
      new InterruptedException((String)localObject);
      localObject = com.google.common.base.a.a;
    }
    do
    {
      do
      {
        return (u)localObject;
        try
        {
          l1 = SystemClock.elapsedRealtime();
          l2 = g.getCount();
          g.await();
          if (l2 > 0L) {
            break label175;
          }
          if (!f.isDone()) {
            break;
          }
          i = 0;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            long l1;
            long l2;
            u localu;
            Log.w("filteredResources", String.valueOf(Thread.currentThread().getName()).concat(" interrupted during resource loading; falling back to original resources."));
            Thread.currentThread().interrupt();
            return com.google.common.base.a.a;
            int i = 1;
            continue;
            i = 1;
          }
        }
        catch (ExecutionException localExecutionException) {}
        localu = (u)f.get();
        l2 = SystemClock.elapsedRealtime();
        localObject = localu;
      } while (i == 0);
      localObject = localu;
    } while (a == null);
    new Thread(new e(l2 - l1)).start();
    return localu;
    label175:
    return com.google.common.base.a.a;
  }
  
  public static void a(ContentProvider paramContentProvider)
  {
    a(paramContentProvider, null);
  }
  
  public static void a(ContentProvider paramContentProvider, a parama)
  {
    try
    {
      paramContentProvider = paramContentProvider.getContext();
      if (paramContentProvider == null) {
        throw new RuntimeException("Can't init resources using null context");
      }
    }
    finally {}
    a(paramContentProvider, parama);
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    synchronized (h)
    {
      Pair localPair = (Pair)h.get(paramContext);
      if (localPair == null) {}
      while (((Integer)localPair.first).intValue() != paramInt)
      {
        h.put(paramContext, new Pair(Integer.valueOf(paramInt), null));
        return;
      }
      return;
    }
  }
  
  public static void a(Context paramContext, a parama)
  {
    try
    {
      a = parama;
      if (f == null)
      {
        f = new FutureTask(new f(paramContext, parama));
        new Thread(f).start();
        g.countDown();
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static Resources b(Context paramContext)
  {
    Configuration localConfiguration;
    do
    {
      synchronized (b)
      {
        localConfiguration = e(paramContext).getResources().getConfiguration();
        if (d == null)
        {
          u localu = a();
          if (localu.a())
          {
            paramContext = (Resources)((b)localu.b()).a(paramContext).second;
            c = new WeakReference(paramContext.getAssets());
            d = new Configuration(localConfiguration);
            e = paramContext;
            return paramContext;
          }
          paramContext = e(paramContext).getResources();
          return paramContext;
        }
      }
    } while ((!d.equals(localConfiguration)) || (e == null) || (c == null) || (c.get() != e.getAssets()));
    paramContext = e;
    return paramContext;
  }
  
  public static AssetManager c(Context paramContext)
  {
    u localu = a();
    if (localu.a()) {
      return (AssetManager)((b)localu.b()).a(paramContext).first;
    }
    return e(paramContext).getAssets();
  }
  
  public static Resources.Theme d(Context paramContext)
  {
    for (;;)
    {
      Object localObject;
      synchronized (h)
      {
        localObject = (Pair)h.get(paramContext);
        if ((localObject != null) && (((Pair)localObject).second != null))
        {
          if (Build.VERSION.SDK_INT < 21)
          {
            paramContext = (Resources.Theme)((Pair)localObject).second;
            return paramContext;
          }
          if (((Resources.Theme)((Pair)localObject).second).getResources().getAssets() == paramContext.getResources().getAssets()) {
            continue;
          }
        }
        if (localObject != null) {
          break label183;
        }
        localObject = paramContext.getApplicationInfo();
        i = ((ApplicationInfo)localObject).theme;
        if (i != 0) {
          break label180;
        }
        i = ((ApplicationInfo)localObject).targetSdkVersion;
        if (i < 11) {
          break label173;
        }
        if (i < 14) {
          break label166;
        }
        if (i > 23)
        {
          i = 16974143;
          localObject = b(paramContext).newTheme();
          ((Resources.Theme)localObject).applyStyle(i, true);
          h.put(paramContext, new Pair(Integer.valueOf(i), localObject));
          return (Resources.Theme)localObject;
        }
      }
      int i = 16974120;
      continue;
      label166:
      i = 16973931;
      continue;
      label173:
      i = 16973829;
      continue;
      label180:
      continue;
      label183:
      i = ((Integer)((Pair)localObject).first).intValue();
    }
  }
  
  private static Context e(Context paramContext)
  {
    while ((paramContext instanceof ContextWrapper)) {
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    return paramContext;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/d/a/a/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */