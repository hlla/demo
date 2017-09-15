package com.tencent.mm.booter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.z;
import com.tencent.mm.sdk.platformtools.v;

public final class e
{
  NetworkInfo gJH;
  WifiInfo gJI;
  
  public e()
  {
    GMTrace.i(13464588255232L, 100319);
    this.gJH = null;
    this.gJI = null;
    GMTrace.o(13464588255232L, 100319);
  }
  
  final boolean pV()
  {
    GMTrace.i(13464722472960L, 100320);
    try
    {
      Object localObject = (ConnectivityManager)z.getContext().getSystemService("connectivity");
      if (localObject == null)
      {
        v.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
        this.gJH = null;
        this.gJI = null;
        GMTrace.o(13464722472960L, 100320);
        return false;
      }
      try
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject == null)
        {
          v.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
          this.gJH = null;
          this.gJI = null;
          GMTrace.o(13464722472960L, 100320);
          return false;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          v.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
          localNetworkInfo = null;
        }
        if (localNetworkInfo.getType() == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label307;
          }
          localWifiInfo = ((WifiManager)z.getContext().getSystemService("wifi")).getConnectionInfo();
          if ((localWifiInfo == null) || (this.gJI == null) || (!this.gJI.getBSSID().equals(localWifiInfo.getBSSID())) || (!this.gJI.getSSID().equals(localWifiInfo.getSSID())) || (this.gJI.getNetworkId() != localWifiInfo.getNetworkId())) {
            break;
          }
          v.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
          GMTrace.o(13464722472960L, 100320);
          return false;
        }
        v.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:%s", new Object[] { localWifiInfo });
        v.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:%s", new Object[] { this.gJI });
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        NetworkInfo localNetworkInfo;
        int i;
        v.printErrStackTrace("MicroMsg.NetworkChangeMgr", localException2, "", new Object[0]);
        continue;
        WifiInfo localWifiInfo = null;
      }
    }
    if (i == 0)
    {
      v.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", new Object[] { localNetworkInfo });
      if (this.gJH != null) {
        v.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", new Object[] { this.gJH });
      }
    }
    this.gJH = localNetworkInfo;
    this.gJI = localWifiInfo;
    GMTrace.o(13464722472960L, 100320);
    return true;
    label307:
    if ((this.gJH != null) && (this.gJH.getExtraInfo() != null) && (localNetworkInfo.getExtraInfo() != null) && (this.gJH.getExtraInfo().equals(localNetworkInfo.getExtraInfo())) && (this.gJH.getSubtype() == localNetworkInfo.getSubtype()) && (this.gJH.getType() == localNetworkInfo.getType()))
    {
      v.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
      GMTrace.o(13464722472960L, 100320);
      return false;
    }
    if ((this.gJH != null) && (this.gJH.getExtraInfo() == null) && (localNetworkInfo.getExtraInfo() == null) && (this.gJH.getSubtype() == localNetworkInfo.getSubtype()) && (this.gJH.getType() == localNetworkInfo.getType()))
    {
      v.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
      GMTrace.o(13464722472960L, 100320);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */