package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class ce
  extends BroadcastReceiver
{
  private static Handler f;
  private static final Comparator<ScanResult> j = new Comparator() {};
  private volatile boolean a;
  private final bk b;
  private final WifiManager c;
  private long d;
  private HashSet<String> e;
  private List<ScanResult> g;
  private final Runnable h;
  private final Object i = new Object();
  
  public ce(bk parambk)
  {
    this.b = parambk;
    this.c = parambk.b();
    this.e = new HashSet();
    this.h = new Runnable()
    {
      public final void run()
      {
        ce.a(ce.this);
        ce.this.a(ce.b(ce.this).g().m);
        b.a.b("TxWifiProvider", "Interval:" + ce.b(ce.this).g().m);
      }
    };
  }
  
  private void a(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      e();
    }
    for (;;)
    {
      long l = this.d;
      this.c.getWifiState();
      paramList = new ck(paramList, l);
      this.b.c(paramList);
      return;
      if (da.a)
      {
        da.a = false;
        e();
      }
    }
  }
  
  private boolean c()
  {
    if (!da.a(this.b)) {
      return false;
    }
    return da.a(this.c);
  }
  
  private void d()
  {
    Thread.currentThread().getName();
    if (this.e == null) {
      this.e = new HashSet();
    }
    ScanResult localScanResult;
    if (this.e.size() == 0)
    {
      localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        this.e.add(localScanResult.toString());
      }
      this.d = System.currentTimeMillis();
      b.a.b("TxWifiProvider", "first receiver");
      a(this.g);
      return;
    }
    int k = this.e.size();
    if (k != this.g.size())
    {
      this.e.clear();
      localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        this.e.add(localScanResult.BSSID + localScanResult.level);
      }
      this.d = System.currentTimeMillis();
      b.a.b("TxWifiProvider", "size not same");
      a(this.g);
      return;
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      localScanResult = (ScanResult)localIterator.next();
      this.e.add(localScanResult.BSSID + localScanResult.level);
    }
    if (k != this.e.size())
    {
      this.e.clear();
      localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        localScanResult = (ScanResult)localIterator.next();
        this.e.add(localScanResult.BSSID + localScanResult.level);
      }
      this.d = System.currentTimeMillis();
      b.a.b("TxWifiProvider", "size same,but mac is not same");
      a(this.g);
      return;
    }
    b.a.b("TxWifiProvider", "size same,mac and rssi same");
  }
  
  private void e()
  {
    k = 1;
    m = this.c.getWifiState();
    if (m == 3) {
      a(0L);
    }
    for (;;)
    {
      m = k;
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          m = k;
          if (!this.b.c().isProviderEnabled("network"))
          {
            boolean bool = this.b.c().isProviderEnabled("gps");
            m = k;
            if (!bool) {
              m = 5;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Message localMessage;
          m = k;
        }
      }
      localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12001;
      localMessage.arg2 = m;
      this.b.c(localMessage);
      return;
      if (m == 1)
      {
        k = 0;
        if (this.g != null) {
          this.g.clear();
        }
        this.b.c(ck.a);
      }
      else
      {
        k = -1;
      }
    }
  }
  
  public final void a()
  {
    synchronized (this.i)
    {
      if (!this.a) {
        return;
      }
      this.a = false;
      f.removeCallbacksAndMessages(null);
    }
    try
    {
      this.b.a.unregisterReceiver(this);
      b.a.b("TxWifiProvider", "unregisterReceiver success");
      this.d = 0L;
      this.e = null;
      if (this.g != null) {
        this.g.clear();
      }
      if (this.e != null) {
        this.e.clear();
      }
      b.a.a("TxWifiProvider", "shutdown: state=[shutdown]");
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.a.b("TxWifiProvider", "unregisterReceiver failed");
      }
    }
  }
  
  public final void a(long paramLong)
  {
    b.a.b("TxWifiProvider", "ScanInterval:" + paramLong);
    Handler localHandler = f;
    Runnable localRunnable = this.h;
    localHandler.removeCallbacks(localRunnable);
    localHandler.postDelayed(localRunnable, paramLong);
  }
  
  public final void a(Handler paramHandler)
  {
    if (this.a) {
      return;
    }
    this.a = true;
    f = paramHandler;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
    try
    {
      this.b.a.registerReceiver(this, localIntentFilter, null, paramHandler);
      a(0L);
      b.a.a("TxWifiProvider", "startup: state=[start]");
      return;
    }
    catch (Exception paramHandler)
    {
      for (;;)
      {
        b.a.a("TxWifiProvider", "listenWifiState: failed", paramHandler);
      }
    }
  }
  
  public final int b()
  {
    if (c()) {
      return 0;
    }
    return 1;
  }
  
  public final void onReceive(Context arg1, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      synchronized (this.i)
      {
        paramIntent = paramIntent.getAction();
        b.a.a("TxWifiProvider", "onReceive " + paramIntent);
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramIntent)) {
          e();
        }
        if (("android.net.wifi.WIFI_STATE_CHANGED".equals(paramIntent)) || ("android.net.wifi.SCAN_RESULTS".equals(paramIntent)))
        {
          paramIntent = da.b(this.c);
          if ((paramIntent != null) && (paramIntent.size() > 0))
          {
            this.g = new ArrayList(paramIntent);
            cf.a(this.g);
            if ((this.g != null) && (this.g.size() > 0))
            {
              Collections.sort(this.g, j);
              d();
            }
          }
        }
        return;
      }
      return;
    }
    catch (Exception ???)
    {
      b.a.b("TxWifiProvider", ???.toString());
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */