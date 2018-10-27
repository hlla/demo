package com.google.android.finsky.dn.a.a;

import com.google.android.finsky.dn.a.i;
import com.google.android.finsky.dn.f;
import com.google.android.finsky.dn.g;
import com.google.android.finsky.utils.bg;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends com.google.android.finsky.dn.a.d
  implements com.google.android.finsky.dn.b
{
  public e f;
  
  public d()
  {
    ((o)com.google.android.finsky.dt.b.a(o.class)).a(this);
  }
  
  private static g a(g paramg, Map paramMap)
  {
    if (paramg != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(paramMap);
      localHashMap.putAll(paramg.c);
      return new g(localHashMap, paramg.b, paramg.d, paramg.e);
    }
    return new g(paramMap, null, null, null);
  }
  
  public final g a()
  {
    return a(this.c.a(), this.e);
  }
  
  public final g a(String paramString)
  {
    return a(this.c.b(paramString), this.d);
  }
  
  public final void a(String paramString, f paramf)
  {
    k localk = this.f.a(paramString);
    localk.a(paramf);
    bg.a(localk, new Void[0]);
    bg.a(this.f.b(paramString), new Void[0]);
  }
  
  public final void a(String paramString, Map paramMap)
  {
    e locale = this.f;
    new m(locale.c, locale.a, "com.google.android.finsky.stable", paramMap, e.c(paramString)).a();
  }
  
  public final void b(String paramString)
  {
    e locale = this.f;
    new l(locale.c, locale.a, "com.google.android.finsky.stable", e.c(paramString)).a();
  }
  
  public final void b(String paramString, f paramf)
  {
    e locale = this.f;
    bg.a(new j(locale.c, locale.b, locale.a, paramString, paramf), new Void[0]);
  }
  
  public final void b(String paramString, Map paramMap)
  {
    e locale = this.f;
    new m(locale.c, locale.a, "com.google.android.finsky.regular", paramMap, e.c(paramString)).a();
  }
  
  public final void c(String paramString)
  {
    e locale = this.f;
    new l(locale.c, locale.a, "com.google.android.finsky.regular", e.c(paramString)).a();
  }
  
  public final void d(String paramString)
  {
    bg.a(this.f.b(paramString), new Void[0]);
    e(paramString);
  }
  
  public final void e(String paramString)
  {
    bg.a(this.f.a(paramString), new Void[0]);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */