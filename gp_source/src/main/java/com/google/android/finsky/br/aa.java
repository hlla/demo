package com.google.android.finsky.br;

import android.content.Intent;
import com.android.volley.VolleyError;
import com.android.volley.w;
import com.android.volley.x;
import com.google.android.finsky.dt.b;
import com.google.android.finsky.fd.a;
import com.google.android.finsky.utils.FinskyLog;

public final class aa
  extends y
  implements w, x, m
{
  public a a;
  private l b;
  
  public aa(q paramq)
  {
    super(paramq);
    ((t)b.a(t.class)).a(this);
  }
  
  public final void a()
  {
    l.a(new ab(this), this.c.d(), true);
  }
  
  public final void a(int paramInt, Intent paramIntent)
  {
    FinskyLog.a("resultCode=%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      this.b = l.a(this, this.c.d());
      b();
      return;
    }
    c();
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    this.b.b(paramVolleyError);
  }
  
  public final void b()
  {
    this.a.a(this.c.a(), this, this, "1");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */