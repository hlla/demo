package com.c.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import java.util.List;

final class ab
  extends c
{
  private static ab aPF;
  WifiManager aJq;
  private final BroadcastReceiver aPG = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("android.net.wifi.SCAN_RESULTS"))
      {
        paramAnonymousContext = ab.this;
        try
        {
          paramAnonymousIntent = paramAnonymousContext.aJq.getScanResults();
          if ((paramAnonymousIntent == null) || (paramAnonymousIntent.isEmpty())) {
            throw new Exception("WifiScanMsg: null or empty scan result list");
          }
          paramAnonymousContext.c(new ab.a(paramAnonymousIntent));
          return;
        }
        catch (Exception paramAnonymousContext) {}
      }
    }
  };
  private final IntentFilter aPH = new IntentFilter("android.net.wifi.SCAN_RESULTS");
  private ac aPI;
  private long aPJ = 10000L;
  
  private boolean isAvailable()
  {
    return this.aJq != null;
  }
  
  static ab nJ()
  {
    if (aPF == null) {
      aPF = new ab();
    }
    return aPF;
  }
  
  final void O(Context paramContext)
  {
    this.aJq = ((WifiManager)paramContext.getSystemService("wifi"));
  }
  
  final void P(Context paramContext)
  {
    if (!isAvailable()) {
      return;
    }
    paramContext.unregisterReceiver(this.aPG);
    this.aPI.stop();
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    if (!isAvailable()) {
      return;
    }
    paramContext.registerReceiver(this.aPG, this.aPH, null, paramHandler);
    this.aPJ = parama.aJl;
    parama = this.aJq;
    if (paramHandler != null) {}
    for (;;)
    {
      this.aPI = new ac(parama, paramHandler);
      this.aPI.b(this.aPJ, 0L);
      return;
      paramHandler = new Handler(paramContext.getMainLooper());
    }
  }
  
  final void a(Handler paramHandler, d.a parama)
  {
    if (parama != null) {}
    for (;;)
    {
      try
      {
        super.a(paramHandler, parama);
        return;
      }
      finally {}
      parama = new d.a(10000L);
    }
  }
  
  final void ne() {}
  
  final void nf()
  {
    if ((!isAvailable()) || (!this.aJi) || (this.aPJ >= 90000L)) {
      return;
    }
    this.aPI.b(90000L, 0L);
  }
  
  final void ng()
  {
    if ((!isAvailable()) || (!this.aJi) || (this.aPJ >= 90000L)) {
      return;
    }
    this.aPI.b(this.aPJ, 0L);
  }
  
  static final class a
    extends p
  {
    final List<ScanResult> aPL;
    
    a(List<ScanResult> paramList)
    {
      super();
      this.aPL = paramList;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */