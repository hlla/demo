package com.google.android.finsky.br;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.android.volley.VolleyError;
import com.google.android.finsky.accounts.c;
import com.google.android.finsky.api.d;
import com.google.android.finsky.api.i;
import com.google.android.finsky.dt.b;

public final class w
  extends Fragment
  implements com.android.volley.w, com.android.volley.x, m
{
  public c a;
  private l aa;
  public i b;
  public x c;
  public com.google.android.finsky.fd.a d;
  
  public final void a(Activity paramActivity)
  {
    ((t)b.a(t.class)).a(this);
    super.a(paramActivity);
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.J = true;
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    this.aa.b(paramVolleyError);
  }
  
  public final void b()
  {
    this.b.a(this.c.a()).c(this.c.e().a, false, this, this);
  }
  
  public final void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    paramBundle = j();
    x localx = this.c;
    if (localx == null)
    {
      this.c = new x(this, paramBundle);
      this.aa = l.a(this, this.c.d(), false);
      b();
      return;
    }
    localx.e.a = paramBundle;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */