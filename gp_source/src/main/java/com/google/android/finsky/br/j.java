package com.google.android.finsky.br;

import com.android.volley.VolleyError;
import com.android.volley.w;
import com.google.android.finsky.e.d;
import com.google.android.finsky.e.i;
import com.google.android.finsky.e.u;
import com.google.android.finsky.pagesystem.b;

final class j
  implements w
{
  j(g paramg) {}
  
  public final void a(VolleyError paramVolleyError)
  {
    g localg = this.a;
    d locald = new d(537);
    locald.b(Integer.valueOf(1));
    if (paramVolleyError != null) {
      locald.a(paramVolleyError);
    }
    localg.a.cV().a(locald.a);
    this.a.a(paramVolleyError);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */