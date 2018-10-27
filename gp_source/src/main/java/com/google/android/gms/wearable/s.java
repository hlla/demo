package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.wearable.internal.h;
import com.google.d.a.a.a.a.a.d;
import com.google.d.a.a.a.a.a.g;

public class s
  extends Service
  implements a
{
  private IBinder a;
  private Looper b;
  public ComponentName d;
  public v e;
  public Intent f;
  public final Object g = new Object();
  public boolean h;
  public h i = new h(new t());
  
  public final void a(Channel paramChannel) {}
  
  public void a(f paramf) {}
  
  public void a(n paramn) {}
  
  public final void b(Channel paramChannel) {}
  
  public final void c(Channel paramChannel) {}
  
  public Context createConfigurationContext(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new g(super.createConfigurationContext(paramConfiguration));
    }
    return null;
  }
  
  public final void d(Channel paramChannel) {}
  
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
  
  public final IBinder onBind(Intent paramIntent)
  {
    if (!"com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      return null;
    }
    return this.a;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.d = new ComponentName(this, getClass().getName());
    Object localObject;
    if (Log.isLoggable("WearableLS", 3))
    {
      localObject = String.valueOf(this.d);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 10);
      localStringBuilder.append("onCreate: ");
      localStringBuilder.append((String)localObject);
      Log.d("WearableLS", localStringBuilder.toString());
    }
    if (this.b == null)
    {
      localObject = new HandlerThread("WearableListenerService");
      ((HandlerThread)localObject).start();
      this.b = ((HandlerThread)localObject).getLooper();
    }
    this.e = new v(this, this.b);
    this.f = new Intent("com.google.android.gms.wearable.BIND_LISTENER");
    this.f.setComponent(this.d);
    this.a = new w(this);
  }
  
  public void onDestroy()
  {
    Object localObject2;
    if (Log.isLoggable("WearableLS", 3))
    {
      ??? = String.valueOf(this.d);
      localObject2 = new StringBuilder(String.valueOf(???).length() + 11);
      ((StringBuilder)localObject2).append("onDestroy: ");
      ((StringBuilder)localObject2).append((String)???);
      Log.d("WearableLS", ((StringBuilder)localObject2).toString());
    }
    synchronized (this.g)
    {
      this.h = true;
      localObject2 = this.e;
      if (localObject2 == null)
      {
        localObject2 = String.valueOf(this.d);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject2).length() + 111);
        localStringBuilder.append("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=");
        localStringBuilder.append((String)localObject2);
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    ((v)localObject3).getLooper().quit();
    ((v)localObject3).a("quit");
    super.onDestroy();
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    d.a(this, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/wearable/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */