package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.e.i;

public final class e
{
  private final long asB;
  private final int asC;
  private final i<String, Long> asD;
  
  public e()
  {
    this.asB = 60000L;
    this.asC = 10;
    this.asD = new i(10);
  }
  
  public e(long paramLong)
  {
    this.asB = paramLong;
    this.asC = 1024;
    this.asD = new i();
  }
  
  public final Long Y(String paramString)
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = this.asB;
    for (;;)
    {
      int i;
      try
      {
        if (this.asD.size() >= this.asC)
        {
          i = this.asD.size() - 1;
          if (i >= 0)
          {
            if (l2 - ((Long)this.asD.valueAt(i)).longValue() > l1) {
              this.asD.removeAt(i);
            }
          }
          else
          {
            l1 /= 2L;
            new StringBuilder("The max capacity ").append(this.asC).append(" is not enough. Current durationThreshold is: ").append(l1);
          }
        }
        else
        {
          paramString = (Long)this.asD.put(paramString, Long.valueOf(l2));
          return paramString;
        }
      }
      finally {}
      i -= 1;
    }
  }
  
  public final boolean Z(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.asD.remove(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/stats/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */