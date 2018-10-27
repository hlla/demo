package com.google.android.finsky.ca;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.t;
import com.google.android.gms.internal.bf;
import com.google.android.gms.internal.bj;

final class e
  implements Runnable
{
  e(d paramd, c paramc, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    Object localObject1 = this.a.b();
    Object localObject2 = this.d;
    if (localObject2 == null) {
      break label29;
    }
    label29:
    NetworkInfo localNetworkInfo;
    do
    {
      do
      {
        FinskyLog.c("Missing start or end network state", new Object[0]);
        return;
      } while (localObject1 == null);
      localNetworkInfo = ((c)localObject2).a;
    } while ((localNetworkInfo == null) || (((c)localObject1).a == null));
    if (localNetworkInfo.getType() != ((c)localObject1).a.getType())
    {
      FinskyLog.a("Network type has changed (%d to %d)", new Object[] { Integer.valueOf(((c)localObject2).a.getType()), Integer.valueOf(((c)localObject1).a.getType()) });
      return;
    }
    label140:
    String str;
    switch (((c)localObject2).a.getType())
    {
    default: 
    case 1: 
      do
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("bytes_transferred", Long.toString(this.c));
        localObject2 = this.a.f;
        long l = this.b;
        if (!com.google.android.gms.d.a.a) {
          break;
        }
        localObject2 = new q((Context)localObject2).a(com.google.android.gms.d.a.b).a(bf.a).b();
        ((p)localObject2).e();
        try
        {
          bf.b.a((p)localObject2, Long.valueOf(l), (Bundle)localObject1).a(new com.google.android.gms.d.c((p)localObject2));
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          str = String.valueOf(localRuntimeException);
          localObject2 = new StringBuilder(String.valueOf(str).length() + 95);
          ((StringBuilder)localObject2).append("Exception in logNetworkStats.  This call should always fail silently, so we will swallow this: ");
          ((StringBuilder)localObject2).append(str);
          Log.w("Herrevad", ((StringBuilder)localObject2).toString());
          return;
        }
        localObject2 = ((c)localObject2).b;
      } while ((localObject2 != null) && (str.b != null) && (((WifiInfo)localObject2).getSSID().equals(str.b.getSSID())));
      FinskyLog.a("Wifi network changed", new Object[0]);
      return;
    }
    int j = ((c)localObject2).a.getSubtype();
    int k = str.a.getSubtype();
    if (j != k) {}
    for (int i = 0;; i = 1)
    {
      if (j != k) {
        FinskyLog.a("Network subtype has changed (%d to %d)", new Object[] { Integer.valueOf(((c)localObject2).a.getSubtype()), Integer.valueOf(str.a.getSubtype()) });
      }
      if (i == 0) {
        break;
      }
      break label140;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ca/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */