package com.google.android.finsky.br;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.android.volley.VolleyError;
import com.google.android.finsky.api.o;
import com.google.android.finsky.layoutswitcher.e;
import com.google.wireless.android.a.b.a.a.bt;

public final class l
  extends p
{
  private boolean a;
  private m c;
  
  public static l a(m paramm, u paramu)
  {
    return a(paramm, paramu, false);
  }
  
  public static l a(m paramm, u paramu, boolean paramBoolean)
  {
    l locall = new l();
    locall.c = paramm;
    locall.a = paramBoolean;
    paramu.a(locall, false);
    return locall;
  }
  
  protected final void R()
  {
    ((t)com.google.android.finsky.dt.b.a(t.class)).a(this);
  }
  
  protected final int V()
  {
    return 0;
  }
  
  protected final void W()
  {
    m localm = this.c;
    if (localm != null) {
      localm.b();
    }
  }
  
  public final void b(VolleyError paramVolleyError)
  {
    a(o.a(j(), paramVolleyError));
  }
  
  public final void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.bf.b(0);
    if (this.a) {
      W();
    }
  }
  
  public final bt getPlayStoreUiElement()
  {
    return com.google.android.finsky.e.u.a(25);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */