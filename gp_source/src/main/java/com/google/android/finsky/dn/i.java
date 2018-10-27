package com.google.android.finsky.dn;

import com.google.android.finsky.dn.c.b;
import com.google.android.finsky.dn.c.c;
import com.google.android.finsky.dn.c.d;
import com.google.android.finsky.dn.c.e;
import com.google.android.finsky.dn.c.f;
import com.google.android.finsky.dn.c.g;
import com.google.android.finsky.dn.c.h;
import java.util.Set;

public final class i
  extends k
{
  public i()
  {
    a();
    a(new c());
    a(new b());
    a(new e());
    a(new d());
    a(new com.google.android.finsky.dn.c.a());
    a(new h());
    a(new com.google.android.finsky.dn.c.i());
    a(new f());
    a(new g());
  }
  
  protected final void a()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    a("TestNetwork", "use_dfe_v2", localBoolean);
    this.b.add(k.a("TestNetwork", "use_dfe_v2"));
    a("Phenotype", "non_cache_clearing", localBoolean);
    a("TopCharts", "enforce_peeking_on_inline_top_charts", localBoolean);
  }
  
  public final Set b()
  {
    return super.b();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */