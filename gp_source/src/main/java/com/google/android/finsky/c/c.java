package com.google.android.finsky.c;

import com.android.volley.VolleyError;
import com.android.volley.w;
import com.google.android.finsky.e.d;
import com.google.android.finsky.e.i;
import com.google.android.finsky.e.u;
import com.google.android.finsky.utils.FinskyLog;

final class c
  implements w
{
  c(a parama) {}
  
  public final void a(VolleyError paramVolleyError)
  {
    FinskyLog.d("Error pinging ad click: %s", new Object[] { paramVolleyError.toString() });
    d locald = new d(520);
    locald.a(paramVolleyError);
    this.a.b.cV().a(locald.a, null, -1L);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */