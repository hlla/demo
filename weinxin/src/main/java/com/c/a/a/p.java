package com.c.a.a;

import android.os.SystemClock;

class p
{
  final long aMa;
  final long aMb;
  final int what;
  
  p(int paramInt)
  {
    this(paramInt, System.currentTimeMillis(), SystemClock.elapsedRealtime());
  }
  
  private p(int paramInt, long paramLong1, long paramLong2)
  {
    this.what = paramInt;
    this.aMa = paramLong1;
    this.aMb = paramLong2;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */