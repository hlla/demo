package com.google.android.play.dfe.api;

import android.net.Uri;
import com.android.volley.n;
import com.android.volley.r;
import com.android.volley.w;
import com.android.volley.x;
import com.google.android.finsky.ds.a.hz;
import com.google.android.finsky.ds.a.ms;
import com.google.android.play.utils.b.j;

public final class f
  implements d
{
  private static final float d = ((Float)j.M.b()).floatValue();
  private static final int e;
  private static final int f;
  private final e g;
  private final r h;
  
  static
  {
    ((Integer)j.G.b()).intValue();
    ((Integer)j.F.b()).intValue();
    ((Float)j.E.b()).floatValue();
    f = ((Integer)j.O.b()).intValue();
    e = ((Integer)j.N.b()).intValue();
  }
  
  public f(r paramr, e parame)
  {
    this.h = paramr;
    this.g = parame;
  }
  
  public final n a(x paramx, w paramw)
  {
    paramx = new b(b.toString(), this.g, hz.class, paramx, paramw);
    return this.h.a(paramx);
  }
  
  public final n a(x paramx, w paramw, boolean paramBoolean)
  {
    paramx = new b(c.toString(), this.g, ms.class, paramx, paramw);
    if (!paramBoolean) {
      paramx.g = new c(f, e, d, this.g);
    }
    return this.h.a(paramx);
  }
  
  public final void a()
  {
    b localb = new b(b.toString(), this.g, hz.class, null, null);
    this.h.a(new a(this.g.c, localb.c()));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/dfe/api/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */