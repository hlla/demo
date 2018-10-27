package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.google.d.a.a.a.a.a.d;
import com.google.d.a.a.a.a.a.g;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class bj
  extends Service
{
  private static final HashMap f = new HashMap();
  private static final Object g = new Object();
  public bk a;
  private final ArrayList b;
  private bs c;
  private boolean d = false;
  private bl e;
  
  public bj()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.b = null;
      return;
    }
    this.b = new ArrayList();
  }
  
  private static bs a(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    bs localbs = (bs)f.get(paramComponentName);
    Object localObject = localbs;
    if (localbs == null) {
      if (Build.VERSION.SDK_INT >= 26) {
        break label54;
      }
    }
    for (paramContext = new bm(paramContext, paramComponentName);; paramContext = new br(paramContext, paramComponentName, paramInt))
    {
      f.put(paramComponentName, paramContext);
      localObject = paramContext;
      return (bs)localObject;
      label54:
      if (!paramBoolean) {
        break;
      }
    }
    throw new IllegalArgumentException("Can't be here without a job id");
  }
  
  public static void a(Context paramContext, ComponentName paramComponentName, int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("work must not be null");
    }
    synchronized (g)
    {
      paramContext = a(paramContext, paramComponentName, true, paramInt);
      paramContext.a(paramInt);
      paramContext.a(paramIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, Class paramClass, int paramInt, Intent paramIntent)
  {
    a(paramContext, new ComponentName(paramContext, paramClass), paramInt, paramIntent);
  }
  
  final void a()
  {
    ArrayList localArrayList1 = this.b;
    if (localArrayList1 != null) {
      try
      {
        this.a = null;
        ArrayList localArrayList2 = this.b;
        if (localArrayList2 == null) {
          if (!this.d) {
            this.c.c();
          }
        }
        for (;;)
        {
          return;
          if (localArrayList2.size() <= 0) {
            break;
          }
          a(false);
        }
        return;
      }
      finally {}
    }
  }
  
  public abstract void a(Intent paramIntent);
  
  final void a(boolean paramBoolean)
  {
    bs localbs;
    if (this.a == null)
    {
      this.a = new bk(this);
      localbs = this.c;
      if (localbs != null) {
        break label44;
      }
    }
    for (;;)
    {
      this.a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
      label44:
      if (paramBoolean) {
        localbs.b();
      }
    }
  }
  
  final bo b()
  {
    ??? = this.e;
    if (??? != null) {
      return ((bl)???).b();
    }
    synchronized (this.b)
    {
      if (this.b.size() > 0)
      {
        bo localbo = (bo)this.b.remove(0);
        return localbo;
      }
    }
    return null;
  }
  
  public Context createConfigurationContext(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new g(super.createConfigurationContext(paramConfiguration));
    }
    return null;
  }
  
  public AssetManager getAssets()
  {
    return d.c(this);
  }
  
  public Resources getResources()
  {
    return d.b(this);
  }
  
  public Resources.Theme getTheme()
  {
    return d.d(this);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = this.e;
    if (paramIntent != null) {
      return paramIntent.a();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.e = new bp(this);
      this.c = null;
      return;
    }
    this.e = null;
    this.c = a(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      try
      {
        this.d = true;
        this.c.c();
        return;
      }
      finally {}
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.b != null)
    {
      this.c.a();
      synchronized (this.b)
      {
        ArrayList localArrayList2 = this.b;
        Intent localIntent = paramIntent;
        if (paramIntent == null) {
          localIntent = new Intent();
        }
        localArrayList2.add(new bn(this, localIntent, paramInt2));
        a(true);
        return 3;
      }
    }
    return 2;
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    d.a(this, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */