package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.f.b;
import com.google.android.gms.ads.internal.util.client.k;

@com.google.android.gms.ads.internal.q.a.a
public final class r
  implements b
{
  private final a a;
  
  public r(a parama)
  {
    this.a = parama;
  }
  
  public final String a()
  {
    String str = null;
    a locala = this.a;
    if (locala != null) {}
    try
    {
      str = locala.a();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      k.e("Could not forward getType to RewardItem", localRemoteException);
    }
    return null;
  }
  
  public final int b()
  {
    int i = 0;
    a locala = this.a;
    if (locala != null) {}
    try
    {
      i = locala.b();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      k.e("Could not forward getAmount to RewardItem", localRemoteException);
    }
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/client/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */