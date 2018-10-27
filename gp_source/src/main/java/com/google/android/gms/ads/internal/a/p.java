package com.google.android.gms.ads.internal.a;

import android.content.Context;
import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.ads.internal.js.al;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.c.c;
import org.json.JSONObject;

@a
public final class p
  implements y
{
  public final d a;
  public final com.google.android.gms.ads.internal.gmsg.u b = new w(this);
  public boolean c;
  public final ae d;
  public final com.google.android.gms.ads.internal.gmsg.u e = new v(this);
  public final com.google.android.gms.ads.internal.gmsg.u f = new u(this);
  private final Context g;
  private al h;
  
  public p(d paramd, com.google.android.gms.ads.internal.js.y paramy, Context paramContext)
  {
    new x(this);
    this.a = paramd;
    this.g = paramContext;
    this.d = new ae(this.g);
    this.h = paramy.a();
    this.h.a(new q(this), new r(this));
    paramd = String.valueOf(this.a.a.f);
    if (paramd.length() == 0) {}
    for (paramd = new String("Core JS tracking ad unit: ");; paramd = "Core JS tracking ad unit: ".concat(paramd))
    {
      com.google.android.gms.ads.internal.util.e.b(paramd);
      return;
    }
  }
  
  public final void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.h.a(new s(paramJSONObject), new c());
  }
  
  public final boolean a()
  {
    return this.c;
  }
  
  public final void b()
  {
    this.h.a(new t(this), new c());
    this.h.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */