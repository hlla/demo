package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.ads.m;

@a
public final class bn
  extends m
{
  public bn(bk parambk)
  {
    try
    {
      parambk.a();
      return;
    }
    catch (RemoteException parambk)
    {
      k.c("", parambk);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */