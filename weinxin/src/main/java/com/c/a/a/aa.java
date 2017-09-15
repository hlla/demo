package com.c.a.a;

import java.util.TimeZone;

final class aa
{
  static long p(long paramLong)
  {
    return (TimeZone.getDefault().getOffset(paramLong) + paramLong) / 1000L;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */