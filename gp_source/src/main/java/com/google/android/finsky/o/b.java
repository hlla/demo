package com.google.android.finsky.o;

import com.google.android.finsky.utils.bg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  public final Set a = new HashSet();
  private final com.google.android.finsky.api.i b;
  private final Map c;
  
  b(com.google.android.finsky.api.i parami)
  {
    this(parami, new HashMap());
  }
  
  private b(com.google.android.finsky.api.i parami, Map paramMap)
  {
    this.b = parami;
    this.c = paramMap;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    bg.a();
    this.a.add(paramString2);
    h localh = (h)this.c.get(paramString1);
    paramString2 = localh;
    if (localh == null)
    {
      paramString2 = new h(this.b.a(paramString1));
      this.c.put(paramString1, paramString2);
    }
    bg.a();
    paramString2.a.add(new i(com.google.android.finsky.utils.i.a(), paramString3));
    paramString2.a();
    paramString2.b();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/o/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */