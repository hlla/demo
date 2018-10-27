package com.google.android.gms.ads.internal.a;

import com.google.android.gms.ads.internal.gmsg.u;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.webview.i;
import org.json.JSONObject;

@a
public final class l
  implements y
{
  public final d a;
  private final u b = new o(this);
  private final i c;
  private final u d = new n(this);
  private final u e = new m(this);
  
  public l(d paramd, i parami)
  {
    this.a = paramd;
    this.c = parami;
    paramd = this.c;
    paramd.a("/updateActiveView", this.e);
    paramd.a("/untrackActiveViewUnit", this.d);
    paramd.a("/visibilityChanged", this.b);
    paramd = String.valueOf(this.a.a.f);
    if (paramd.length() == 0) {}
    for (paramd = new String("Custom JS tracking ad unit: ");; paramd = "Custom JS tracking ad unit: ".concat(paramd))
    {
      e.b(paramd);
      return;
    }
  }
  
  public final void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.c.b("AFMA_updateActiveView", paramJSONObject);
      return;
    }
    this.a.c(this);
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final void b()
  {
    i locali = this.c;
    locali.b("/visibilityChanged", this.b);
    locali.b("/untrackActiveViewUnit", this.d);
    locali.b("/updateActiveView", this.e);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */