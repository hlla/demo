package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import java.io.IOException;

public class InstanceIDListenerService
  extends Service
{
  static String ACTION = "action";
  private static String asV = "gcm.googleapis.com/refresh";
  private static String atA;
  private static String atz = "google.com/iid";
  int atB;
  int atC;
  MessengerCompat atx = new MessengerCompat(new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      InstanceIDListenerService.a(InstanceIDListenerService.this, paramAnonymousMessage, MessengerCompat.c(paramAnonymousMessage));
    }
  });
  BroadcastReceiver aty = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        paramAnonymousIntent.getStringExtra("registration_id");
        new StringBuilder("Received GSF callback using dynamic receiver: ").append(paramAnonymousIntent.getExtras());
      }
      InstanceIDListenerService.this.f(paramAnonymousIntent);
      InstanceIDListenerService.this.stop();
    }
  };
  
  static
  {
    atA = "CMD";
  }
  
  static void H(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.android.gms.iid.InstanceID");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra(atA, "SYNC");
    paramContext.startService(localIntent);
  }
  
  static void a(Context paramContext, e parame)
  {
    parame.kI();
    parame = new Intent("com.google.android.gms.iid.InstanceID");
    parame.putExtra(atA, "RST");
    parame.setPackage(paramContext.getPackageName());
    paramContext.startService(parame);
  }
  
  public final void f(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("subtype");
    Object localObject1;
    Object localObject2;
    if (str == null)
    {
      localObject1 = a.G(this);
      localObject2 = paramIntent.getStringExtra(atA);
      if ((paramIntent.getStringExtra("error") == null) && (paramIntent.getStringExtra("registration_id") == null)) {
        break label84;
      }
      if (Log.isLoggable("InstanceID", 3)) {}
      a.kE().i(paramIntent);
    }
    label84:
    label271:
    do
    {
      do
      {
        return;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("subtype", str);
        localObject1 = a.a(this, (Bundle)localObject1);
        break;
        if (Log.isLoggable("InstanceID", 3)) {
          new StringBuilder("Service command ").append(str).append(" ").append((String)localObject2).append(" ").append(paramIntent.getExtras());
        }
        if (paramIntent.getStringExtra("unregistered") != null)
        {
          localObject2 = a.kD();
          if (str == null) {}
          for (localObject1 = "";; localObject1 = str)
          {
            ((e)localObject2).ac((String)localObject1);
            a.kE().i(paramIntent);
            return;
          }
        }
        if (asV.equals(paramIntent.getStringExtra("from")))
        {
          a.kD().ac(str);
          return;
        }
        if ("RST".equals(localObject2))
        {
          ((a)localObject1).atv = 0L;
          paramIntent = a.atr;
          str = ((a)localObject1).atu;
          paramIntent.ab(str + "|");
          ((a)localObject1).att = null;
          return;
        }
        if (!"RST_FULL".equals(localObject2)) {
          break label271;
        }
      } while (a.kD().isEmpty());
      a.kD().kI();
      return;
      if ("SYNC".equals(localObject2))
      {
        a.kD().ac(str);
        return;
      }
    } while (!"PING".equals(localObject2));
    try
    {
      com.google.android.gms.gcm.a.D(this).a(atz, d.kH(), paramIntent.getExtras());
      return;
    }
    catch (IOException paramIntent) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))) {
      return this.atx.getBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
    localIntentFilter.addCategory(getPackageName());
    registerReceiver(this.aty, localIntentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
  }
  
  public void onDestroy()
  {
    unregisterReceiver(this.aty);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    try
    {
      this.atB += 1;
      if (paramInt2 > this.atC) {
        this.atC = paramInt2;
      }
      if (paramIntent == null)
      {
        stop();
        return 2;
      }
    }
    finally {}
    try
    {
      if ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))
      {
        if (Build.VERSION.SDK_INT <= 18)
        {
          Intent localIntent = (Intent)paramIntent.getParcelableExtra("GSF");
          if (localIntent != null)
          {
            startService(localIntent);
            return 1;
          }
        }
        f(paramIntent);
      }
      stop();
      if (paramIntent.getStringExtra("from") != null) {
        GcmReceiver.c(paramIntent);
      }
      return 2;
    }
    finally
    {
      stop();
    }
  }
  
  final void stop()
  {
    try
    {
      this.atB -= 1;
      if (this.atB == 0) {
        stopSelf(this.atC);
      }
      if (Log.isLoggable("InstanceID", 3)) {
        new StringBuilder("Stop ").append(this.atB).append(" ").append(this.atC);
      }
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/iid/InstanceIDListenerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */