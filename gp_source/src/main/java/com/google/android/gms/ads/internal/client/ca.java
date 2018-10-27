package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.q.a.a;

@a
public final class ca
{
  public static final Object a = new Object();
  private static ca c;
  public bc b;
  
  public static ca a()
  {
    synchronized (a)
    {
      if (c != null)
      {
        ca localca = c;
        return localca;
      }
      c = new ca();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */