package com.google.android.finsky.d;

import android.os.SystemClock;

final class l
{
  private long a = Long.MIN_VALUE;
  private final long b = 200L;
  
  public final boolean a()
  {
    long l = SystemClock.elapsedRealtime();
    if (this.a + this.b <= l)
    {
      this.a = l;
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */