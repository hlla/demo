package com.google.android.finsky.bo.a;

import android.support.v4.g.h;
import com.google.android.finsky.utils.FinskyLog;

public final class d
{
  public static final h a;
  public static final h b = new h(807);
  private static int c;
  private static int d;
  
  static
  {
    a = new h(147);
    e.a();
    if (d != b.a()) {
      FinskyLog.e("Mismatch in recognized targets count. Expected: %d, Actual: %d", new Object[] { Integer.valueOf(d), Integer.valueOf(b.a()) });
    }
    if (c != a.a()) {
      FinskyLog.e("Mismatch in process stable targets count. Expected: %d, Actual: %d", new Object[] { Integer.valueOf(c), Integer.valueOf(a.a()) });
    }
  }
  
  static void a(long paramLong, String paramString)
  {
    a(paramLong, paramString, false);
  }
  
  private static void a(long paramLong, String paramString, boolean paramBoolean)
  {
    h localh = a;
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = null)
    {
      localh.c(paramLong, localBoolean);
      c += 1;
      c(paramLong, paramString);
      return;
    }
  }
  
  static void b(long paramLong, String paramString)
  {
    a(paramLong, paramString, true);
  }
  
  static void c(long paramLong, String paramString)
  {
    b.c(paramLong, paramString);
    d += 1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bo/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */