package com.google.android.finsky.cx;

import java.util.Locale;

public class d
{
  private final int a;
  public final Exception b;
  private final long c;
  
  public d(Exception paramException, int paramInt)
  {
    this.b = paramException;
    this.c = 0L;
    this.a = paramInt;
  }
  
  public String toString()
  {
    Locale localLocale = Locale.US;
    int i = this.a;
    if (i > 0) {}
    for (Object localObject = Integer.valueOf(i);; localObject = "na") {
      return String.format(localLocale, "network time: %d, HTTP status code: %s, exception %s", new Object[] { Long.valueOf(0L), localObject, this.b.toString() });
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cx/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */