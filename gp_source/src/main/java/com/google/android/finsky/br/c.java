package com.google.android.finsky.br;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.android.volley.VolleyError;
import com.android.volley.w;
import com.android.volley.x;
import com.google.android.finsky.fd.a;
import com.google.android.finsky.fd.h;
import com.google.android.finsky.utils.FinskyLog;

public final class c
  extends y
  implements w, x, m, h
{
  public com.google.android.finsky.bq.b a;
  public a b;
  private l d;
  private int e;
  
  public c(q paramq)
  {
    super(paramq);
    ((t)com.google.android.finsky.dt.b.a(t.class)).a(this);
  }
  
  public final void a()
  {
    l.a(new d(this), this.c.d(), true);
  }
  
  public final void a(int paramInt, Intent paramIntent)
  {
    FinskyLog.b("result code=%d", new Object[] { Integer.valueOf(paramInt) });
    this.e = paramInt;
    this.d = l.a(this, this.c.d());
    if (paramInt == 1)
    {
      paramIntent = paramIntent.getStringExtra("consistencyToken");
      if (paramIntent != null) {
        this.a.a(this.c.a()).b(paramIntent);
      }
      b();
      this.c.d().b = true;
      return;
    }
    c();
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    this.d.b(paramVolleyError);
  }
  
  public final void b()
  {
    this.b.a(this);
    this.b.a(this.c.a(), 3);
  }
  
  public final void l_()
  {
    this.b.b(this);
    if (this.e == 1)
    {
      this.b.a(this.c.a(), this, this, "1");
      return;
    }
    c();
  }
  
  public final void m_()
  {
    this.b.b(this);
    l locall = this.d;
    locall.a(locall.c(2131952216));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */