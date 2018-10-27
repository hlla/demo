package com.google.android.finsky.x.a;

import android.net.Uri;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.api.h;
import com.google.android.finsky.ay.b;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;
import com.google.wireless.android.finsky.dfe.nano.cd;

public final class a
  implements b, com.google.android.finsky.x.a
{
  private final com.google.android.finsky.ay.a a;
  private final c b;
  private final com.google.android.finsky.recoverymode.a c;
  private cd d;
  
  public a(com.google.android.finsky.ay.a parama, com.google.android.finsky.recoverymode.a parama1, c paramc)
  {
    this.a = parama;
    this.c = parama1;
    this.b = paramc;
    this.a.a(this);
  }
  
  public final Uri a()
  {
    if ((!this.c.b()) && (!((Boolean)d.aj.b()).booleanValue()))
    {
      if ((((Boolean)d.al.b()).booleanValue()) || (!this.b.cY().a(12658126L))) {}
      cd localcd;
      do
      {
        if ((((Boolean)d.ak.b()).booleanValue()) || (!this.b.cY().a(12658208L))) {
          return h.g;
        }
        return Uri.parse((String)d.he.b());
        if (this.d == null) {
          this.d = this.a.a();
        }
        localcd = this.d;
      } while ((localcd.a == null) && (localcd.b == null));
      return Uri.parse((String)d.lA.b());
    }
    return h.g;
  }
  
  public final void b()
  {
    this.d = this.a.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/x/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */