package com.google.android.finsky.ay.a;

import com.android.volley.VolleyError;
import com.android.volley.w;
import com.google.android.finsky.utils.FinskyLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class d
  implements w
{
  d(a parama) {}
  
  public final void a(VolleyError paramVolleyError)
  {
    FinskyLog.a(paramVolleyError, "Error getting device settings.", new Object[0]);
    this.a.e.set(false);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ay/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */