package com.google.android.finsky.q;

import com.google.android.finsky.utils.FinskyLog;

public final class p
{
  public static void a(a parama)
  {
    parama.aa += 1;
    if (parama.aa > 1) {
      FinskyLog.e("%s has been injected %d times, please create a custom injector for the classand make sure one injection per instance.", new Object[] { parama.getClass().getSimpleName(), Integer.valueOf(parama.aa) });
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/q/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */