package com.google.android.finsky.au;

import com.android.volley.VolleyError;
import com.android.volley.w;
import com.google.android.finsky.utils.FinskyLog;

final class c
  implements w
{
  c(a parama) {}
  
  public final void a(VolleyError paramVolleyError)
  {
    FinskyLog.d("Error pinging deeplink click: %s", new Object[] { paramVolleyError });
    this.a.a(521, paramVolleyError);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/au/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */