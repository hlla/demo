package com.google.android.finsky.cy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.bg;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.t;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends BroadcastReceiver
{
  public static final List b = new ArrayList();
  private static NetworkInfo c;
  private static final Object d = new Object();
  public d a;
  
  public e()
  {
    ((h)com.google.android.finsky.dt.b.a(h.class)).a(this);
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    synchronized (d)
    {
      if (c != null)
      {
        paramContext = c;
        return paramContext;
      }
      b(paramContext);
    }
  }
  
  public static void a()
  {
    synchronized (d)
    {
      c = null;
      return;
    }
  }
  
  public static void a(f paramf)
  {
    if (!b.contains(paramf)) {
      b.add(paramf);
    }
  }
  
  private static void b(Context paramContext)
  {
    synchronized (d)
    {
      c = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return;
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    b(paramContext);
    paramIntent = this.a;
    com.google.android.finsky.bo.f localf;
    long[] arrayOfLong;
    int i;
    if (paramIntent != null)
    {
      bg.a();
      localf = paramIntent.a.d.cY();
      arrayOfLong = a.a;
      int j = arrayOfLong.length;
      i = 0;
      if (i < j) {
        break label96;
      }
      FinskyLog.a("Network quality prediction is disabled", new Object[0]);
    }
    for (;;)
    {
      i = b.size() - 1;
      while (i >= 0)
      {
        ((f)b.get(i)).b();
        i -= 1;
      }
      label96:
      if (!localf.a(arrayOfLong[i]))
      {
        i += 1;
        break;
      }
      if (paramIntent.b == null) {
        paramIntent.b = new q(paramContext.getApplicationContext()).a(com.google.android.gms.herrevad.a.a).b();
      }
      paramIntent.b.e();
      com.google.android.gms.herrevad.a.b.a(paramIntent.b).a(paramIntent);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cy/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */