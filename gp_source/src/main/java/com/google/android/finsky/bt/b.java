package com.google.android.finsky.bt;

import com.android.volley.VolleyError;
import com.google.android.finsky.e.d;
import com.google.android.finsky.e.u;

public final class b
{
  public final com.google.android.finsky.api.i a;
  private final com.google.android.finsky.e.i b;
  
  public b(com.google.android.finsky.api.i parami, com.google.android.finsky.e.i parami1)
  {
    this.a = parami;
    this.b = parami1;
  }
  
  final void a(VolleyError paramVolleyError)
  {
    d locald = new d(533);
    if (paramVolleyError != null) {
      locald.a(paramVolleyError);
    }
    this.b.cV().a(locald.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bt/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */