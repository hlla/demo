package com.google.android.finsky.cb;

import com.android.volley.VolleyError;
import com.google.android.finsky.eu.g;
import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.finsky.dfe.nano.gn;

final class d
  implements g
{
  d(a parama) {}
  
  public final void a(VolleyError paramVolleyError)
  {
    FinskyLog.d("Unable to preload experiments: %s", new Object[] { paramVolleyError });
    this.a.c();
  }
  
  public final void a(gn paramgn)
  {
    this.a.c();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cb/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */