package com.google.android.finsky.q;

import com.android.volley.VolleyError;
import com.google.android.finsky.billing.iab.ai;
import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.eu.g;
import com.google.android.finsky.selfupdate.e;
import com.google.android.finsky.selfupdate.r;
import com.google.wireless.android.finsky.dfe.nano.gn;

final class h
  implements g
{
  h(a parama, boolean[] paramArrayOfBoolean, com.google.android.finsky.bo.f paramf, com.google.android.finsky.api.d paramd, String paramString, boolean paramBoolean) {}
  
  public final void a(VolleyError paramVolleyError)
  {
    this.a.L();
    this.a.a(paramVolleyError);
  }
  
  public final void a(gn paramgn)
  {
    Object localObject = this.e;
    if (localObject[0] != 0)
    {
      new com.google.android.finsky.i.f(this.a.getApplicationContext(), (com.google.android.finsky.i.a)this.a.K.a()).a(10000, new i());
      return;
    }
    localObject[0] = 1;
    localObject = new DfeToc(paramgn);
    ((com.google.android.finsky.ev.a)this.a.ar.a()).a((DfeToc)localObject);
    localObject = ((r)this.a.am.a()).a(this.d);
    ((e)localObject).a(((e)localObject).a(paramgn), this.c, this.d, ((com.google.android.finsky.e.a)this.a.J.a()).a(null), true);
    ai.a(this.b, paramgn.c);
    paramgn = this.a;
    boolean bool = this.f;
    paramgn.d("Restrict limited or Edu user");
    ((com.google.android.finsky.ba.d)paramgn.al.a()).a(new j(paramgn, bool));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/q/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */