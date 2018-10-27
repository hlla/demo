package com.google.android.finsky.cb;

import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.ax;
import com.google.android.finsky.selfupdate.r;
import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.a.b.a.a.f;
import com.google.wireless.android.finsky.dfe.nano.gb;

final class g
  implements com.google.android.finsky.eg.e
{
  g(a parama, f paramf, af paramaf) {}
  
  public final void a(VolleyError paramVolleyError)
  {
    FinskyLog.c("Self-update check failed with error: %s", new Object[] { paramVolleyError });
    com.google.android.finsky.e.d locald = new com.google.android.finsky.e.d(119).a(this.b);
    ax.a(locald, paramVolleyError, false);
    this.c.a(locald);
    if ((paramVolleyError instanceof AuthFailureError))
    {
      this.a.b();
      return;
    }
    paramVolleyError = this.a;
    paramVolleyError.p.a(null, false, paramVolleyError.k, paramVolleyError.r, false);
  }
  
  public final void a(gb paramgb)
  {
    Object localObject = this.a;
    localObject = ((a)localObject).v.a(((a)localObject).k);
    int i = ((com.google.android.finsky.selfupdate.e)localObject).a(paramgb);
    if (i > 0) {
      this.b.a(i);
    }
    this.c.a(new com.google.android.finsky.e.d(119).a(this.b));
    paramgb = this.a;
    int j;
    int k;
    if (((com.google.android.finsky.selfupdate.e)localObject).a(i, paramgb.g, paramgb.k, this.c, false))
    {
      if (((Boolean)com.google.android.finsky.ag.d.bd.b()).booleanValue()) {
        break label228;
      }
      i = this.a.q;
      j = ((Integer)com.google.android.finsky.ag.d.bh.b()).intValue();
      k = ((Integer)com.google.android.finsky.ag.d.bg.b()).intValue();
      if (j > 0) {
        break label181;
      }
    }
    label181:
    while ((k <= 0) || (i < j) || (i > k))
    {
      paramgb = this.a;
      paramgb.p.a(paramgb.g, true, paramgb.k, paramgb.r, false);
      return;
    }
    FinskyLog.c("Scheduling emergency hygiene, %d <= %d <= %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
    label228:
    FinskyLog.a("Self-update started or running - defer hygiene", new Object[0]);
    paramgb = this.a;
    paramgb.p.a(paramgb.g, true, paramgb.k, paramgb.r, true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cb/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */