package com.google.android.finsky.u;

import com.android.volley.w;
import com.android.volley.x;

public final class a
{
  private final void a(boolean paramBoolean, com.google.android.finsky.api.d paramd, com.google.android.finsky.deviceconfig.d paramd1, long paramLong, x paramx, w paramw)
  {
    paramd.a(paramLong, new b(paramx), paramw);
  }
  
  public final void a(com.google.android.finsky.api.d paramd, com.google.android.finsky.deviceconfig.d paramd1, long paramLong, x paramx, w paramw)
  {
    a(paramd, paramd1, paramLong, paramx, paramw, false);
  }
  
  public final void a(com.google.android.finsky.api.d paramd, com.google.android.finsky.deviceconfig.d paramd1, long paramLong, x paramx, w paramw, boolean paramBoolean)
  {
    if (paramd.b() != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramd1.a(paramd, new c(this, paramd, paramd1, paramLong, paramx, paramw), bool, paramBoolean);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/u/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */