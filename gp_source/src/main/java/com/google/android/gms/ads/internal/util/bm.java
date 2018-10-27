package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.common.util.b;

@a
public final class bm
{
  private long a = Long.MIN_VALUE;
  private Object b = new Object();
  private long c;
  
  public bm(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final boolean a()
  {
    synchronized (this.b)
    {
      long l = bt.A.l.b();
      if (this.a + this.c <= l)
      {
        this.a = l;
        return true;
      }
      return false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */