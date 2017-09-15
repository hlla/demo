package com.c.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;

final class ac
  extends e
{
  private final WifiManager aPM;
  
  ac(WifiManager paramWifiManager, Handler paramHandler)
  {
    super(paramHandler);
    this.aPM = paramWifiManager;
  }
  
  final void ni()
  {
    this.aPM.startScan();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */