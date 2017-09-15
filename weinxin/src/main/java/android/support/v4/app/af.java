package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class af
{
  public static final int sK;
  private static final Object sL = new Object();
  private static String sM;
  private static Set<String> sN = new HashSet();
  private static final Object sP = new Object();
  private static h sQ;
  public static final b sR;
  public final Context mContext;
  public final NotificationManager sO;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {
      sR = new e();
    }
    for (;;)
    {
      sK = sR.bn();
      return;
      if (Build.VERSION.SDK_INT >= 5) {
        sR = new d();
      } else {
        sR = new c();
      }
    }
  }
  
  private af(Context paramContext)
  {
    this.mContext = paramContext;
    this.sO = ((NotificationManager)this.mContext.getSystemService("notification"));
  }
  
  public static af h(Context paramContext)
  {
    return new af(paramContext);
  }
  
  public static Set<String> i(Context paramContext)
  {
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    HashSet localHashSet;
    if ((paramContext != null) && (!paramContext.equals(sM)))
    {
      ??? = paramContext.split(":");
      localHashSet = new HashSet(???.length);
      int j = ???.length;
      int i = 0;
      while (i < j)
      {
        ComponentName localComponentName = ComponentName.unflattenFromString(???[i]);
        if (localComponentName != null) {
          localHashSet.add(localComponentName.getPackageName());
        }
        i += 1;
      }
    }
    synchronized (sL)
    {
      sN = localHashSet;
      sM = paramContext;
      return sN;
    }
  }
  
  public final void a(i parami)
  {
    synchronized (sP)
    {
      if (sQ == null) {
        sQ = new h(this.mContext.getApplicationContext());
      }
      sQ.mHandler.obtainMessage(0, parami).sendToTarget();
      return;
    }
  }
  
  private static final class a
    implements af.i
  {
    final int id;
    final String packageName;
    final boolean sS;
    final String tag;
    
    public a(String paramString1, int paramInt, String paramString2)
    {
      this.packageName = paramString1;
      this.id = paramInt;
      this.tag = null;
      this.sS = false;
    }
    
    public final void a(r paramr)
    {
      if (this.sS)
      {
        paramr.l(this.packageName);
        return;
      }
      paramr.b(this.packageName, this.id, this.tag);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
      localStringBuilder.append("packageName:").append(this.packageName);
      localStringBuilder.append(", id:").append(this.id);
      localStringBuilder.append(", tag:").append(this.tag);
      localStringBuilder.append(", all:").append(this.sS);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(NotificationManager paramNotificationManager, String paramString, int paramInt);
    
    public abstract void a(NotificationManager paramNotificationManager, String paramString, int paramInt, Notification paramNotification);
    
    public abstract int bn();
  }
  
  static class c
    implements af.b
  {
    public void a(NotificationManager paramNotificationManager, String paramString, int paramInt)
    {
      paramNotificationManager.cancel(paramInt);
    }
    
    public void a(NotificationManager paramNotificationManager, String paramString, int paramInt, Notification paramNotification)
    {
      paramNotificationManager.notify(paramInt, paramNotification);
    }
    
    public int bn()
    {
      return 1;
    }
  }
  
  static class d
    extends af.c
  {
    public final void a(NotificationManager paramNotificationManager, String paramString, int paramInt)
    {
      paramNotificationManager.cancel(null, paramInt);
    }
    
    public final void a(NotificationManager paramNotificationManager, String paramString, int paramInt, Notification paramNotification)
    {
      paramNotificationManager.notify(null, paramInt, paramNotification);
    }
  }
  
  static final class e
    extends af.d
  {
    public final int bn()
    {
      return 33;
    }
  }
  
  private static final class f
    implements af.i
  {
    final int id;
    final String packageName;
    final Notification sT;
    final String tag;
    
    public f(String paramString1, int paramInt, String paramString2, Notification paramNotification)
    {
      this.packageName = paramString1;
      this.id = paramInt;
      this.tag = null;
      this.sT = paramNotification;
    }
    
    public final void a(r paramr)
    {
      paramr.a(this.packageName, this.id, this.tag, this.sT);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("NotifyTask[");
      localStringBuilder.append("packageName:").append(this.packageName);
      localStringBuilder.append(", id:").append(this.id);
      localStringBuilder.append(", tag:").append(this.tag);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  private static final class g
  {
    final ComponentName sU;
    final IBinder sV;
    
    public g(ComponentName paramComponentName, IBinder paramIBinder)
    {
      this.sU = paramComponentName;
      this.sV = paramIBinder;
    }
  }
  
  private static final class h
    implements ServiceConnection, Handler.Callback
  {
    private final Context mContext;
    final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Map<ComponentName, a> sW = new HashMap();
    private Set<String> sX = new HashSet();
    
    public h(Context paramContext)
    {
      this.mContext = paramContext;
      this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
      this.mHandlerThread.start();
      this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
    }
    
    private void a(a parama)
    {
      if (parama.sY)
      {
        this.mContext.unbindService(this);
        parama.sY = false;
      }
      parama.sZ = null;
    }
    
    private void b(a parama)
    {
      if (this.mHandler.hasMessages(3, parama.sU)) {
        return;
      }
      parama.retryCount += 1;
      if (parama.retryCount > 6)
      {
        new StringBuilder("Giving up on delivering ").append(parama.ta.size()).append(" tasks to ").append(parama.sU).append(" after ").append(parama.retryCount).append(" retries");
        parama.ta.clear();
        return;
      }
      int i = (1 << parama.retryCount - 1) * 1000;
      if (Log.isLoggable("NotifManCompat", 3)) {
        new StringBuilder("Scheduling retry for ").append(i).append(" ms");
      }
      parama = this.mHandler.obtainMessage(3, parama.sU);
      this.mHandler.sendMessageDelayed(parama, i);
    }
    
    private void c(a parama)
    {
      if (Log.isLoggable("NotifManCompat", 3)) {
        new StringBuilder("Processing component ").append(parama.sU).append(", ").append(parama.ta.size()).append(" queued tasks");
      }
      if (parama.ta.isEmpty()) {}
      for (;;)
      {
        return;
        boolean bool;
        if (parama.sY)
        {
          bool = true;
          if ((!bool) || (parama.sZ == null)) {
            b(parama);
          }
        }
        else
        {
          localObject = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(parama.sU);
          parama.sY = this.mContext.bindService((Intent)localObject, this, af.sK);
          if (parama.sY) {
            parama.retryCount = 0;
          }
          for (;;)
          {
            bool = parama.sY;
            break;
            new StringBuilder("Unable to bind to listener ").append(parama.sU);
            this.mContext.unbindService(this);
          }
        }
        Object localObject = (af.i)parama.ta.peek();
        if (localObject != null) {}
        try
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder("Sending task ").append(localObject);
          }
          ((af.i)localObject).a(parama.sZ);
          parama.ta.remove();
        }
        catch (DeadObjectException localDeadObjectException)
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder("Remote service has died: ").append(parama.sU);
          }
          if (parama.ta.isEmpty()) {
            continue;
          }
          b(parama);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            new StringBuilder("RemoteException communicating with ").append(parama.sU);
          }
        }
      }
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      Object localObject1;
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 0: 
        paramMessage = (af.i)paramMessage.obj;
        Object localObject2 = af.i(this.mContext);
        if (!((Set)localObject2).equals(this.sX))
        {
          this.sX = ((Set)localObject2);
          Object localObject3 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
          localObject1 = new HashSet();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject3).next();
            if (((Set)localObject2).contains(localResolveInfo.serviceInfo.packageName))
            {
              ComponentName localComponentName = new ComponentName(localResolveInfo.serviceInfo.packageName, localResolveInfo.serviceInfo.name);
              if (localResolveInfo.serviceInfo.permission != null) {
                new StringBuilder("Permission present on component ").append(localComponentName).append(", not adding listener record.");
              } else {
                ((Set)localObject1).add(localComponentName);
              }
            }
          }
          localObject2 = ((Set)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ComponentName)((Iterator)localObject2).next();
            if (!this.sW.containsKey(localObject3))
            {
              if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Adding listener record for ").append(localObject3);
              }
              this.sW.put(localObject3, new a((ComponentName)localObject3));
            }
          }
          localObject2 = this.sW.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            if (!((Set)localObject1).contains(((Map.Entry)localObject3).getKey()))
            {
              if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Removing listener record for ").append(((Map.Entry)localObject3).getKey());
              }
              a((a)((Map.Entry)localObject3).getValue());
              ((Iterator)localObject2).remove();
            }
          }
        }
        localObject1 = this.sW.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          ((a)localObject2).ta.add(paramMessage);
          c((a)localObject2);
        }
        return true;
      case 1: 
        localObject1 = (af.g)paramMessage.obj;
        paramMessage = ((af.g)localObject1).sU;
        localObject1 = ((af.g)localObject1).sV;
        paramMessage = (a)this.sW.get(paramMessage);
        if (paramMessage != null)
        {
          paramMessage.sZ = r.a.a((IBinder)localObject1);
          paramMessage.retryCount = 0;
          c(paramMessage);
        }
        return true;
      case 2: 
        paramMessage = (ComponentName)paramMessage.obj;
        paramMessage = (a)this.sW.get(paramMessage);
        if (paramMessage != null) {
          a(paramMessage);
        }
        return true;
      }
      paramMessage = (ComponentName)paramMessage.obj;
      paramMessage = (a)this.sW.get(paramMessage);
      if (paramMessage != null) {
        c(paramMessage);
      }
      return true;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (Log.isLoggable("NotifManCompat", 3)) {
        new StringBuilder("Connected to service ").append(paramComponentName);
      }
      this.mHandler.obtainMessage(1, new af.g(paramComponentName, paramIBinder)).sendToTarget();
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (Log.isLoggable("NotifManCompat", 3)) {
        new StringBuilder("Disconnected from service ").append(paramComponentName);
      }
      this.mHandler.obtainMessage(2, paramComponentName).sendToTarget();
    }
    
    private static final class a
    {
      public int retryCount = 0;
      public final ComponentName sU;
      public boolean sY = false;
      public r sZ;
      public LinkedList<af.i> ta = new LinkedList();
      
      public a(ComponentName paramComponentName)
      {
        this.sU = paramComponentName;
      }
    }
  }
  
  private static abstract interface i
  {
    public abstract void a(r paramr);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */