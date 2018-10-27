package com.google.android.finsky.dn.a;

import com.google.android.finsky.ag.q;
import com.google.android.finsky.dn.a;
import com.google.android.finsky.dn.g;
import com.google.android.finsky.dt.b;
import com.google.android.finsky.utils.FinskyLog;
import java.util.Map;

public abstract class d
  implements com.google.android.finsky.dn.e
{
  public com.google.android.finsky.accounts.c a;
  public com.google.android.finsky.utils.c b;
  public i c;
  public Map d;
  public Map e;
  private boolean f;
  
  public d()
  {
    ((p)b.a(p.class)).a(this);
    if (((Boolean)com.google.android.finsky.ag.c.av.a()).booleanValue()) {
      this.f = true;
    }
  }
  
  private static com.google.android.play.b.a.c a(g paramg)
  {
    if (paramg != null) {
      return paramg.b;
    }
    return null;
  }
  
  private static Object a(g paramg, String paramString)
  {
    if (paramg != null) {
      return paramg.c.get(paramString);
    }
    return null;
  }
  
  private final Object a(String paramString)
  {
    if (b(paramString)) {
      return this.d.get(paramString);
    }
    return this.e.get(paramString);
  }
  
  private final Object a(String paramString1, String paramString2, String paramString3, Class paramClass)
  {
    paramString1 = a.a(paramString1, paramString2);
    paramString3 = e(paramString1, paramString3);
    paramString2 = a(paramString1);
    if (paramString3 == null) {}
    try
    {
      return paramClass.cast(paramString2);
    }
    catch (ClassCastException paramString3)
    {
      FinskyLog.b(paramString3, "Unexpected experiment flag type found for flag %s", new Object[] { paramString1 });
    }
    paramString3 = paramClass.cast(paramString3);
    return paramString3;
    return paramClass.cast(paramString2);
  }
  
  private final boolean b(String paramString)
  {
    return this.d.containsKey(paramString);
  }
  
  private final Object e(String paramString1, String paramString2)
  {
    if (b(paramString1)) {
      return a(this.c.b(paramString2), paramString1);
    }
    return a(this.c.a(), paramString1);
  }
  
  public final long a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, this.a.cS());
  }
  
  public final long a(String paramString1, String paramString2, String paramString3)
  {
    return ((Long)a(paramString1, paramString2, paramString3, Long.class)).longValue();
  }
  
  public final int b(String paramString1, String paramString2)
  {
    return b(paramString1, paramString2, this.a.cS());
  }
  
  public final int b(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a.a(paramString1, paramString2);
    paramString2 = e(paramString1, paramString3);
    int j = ((Integer)a(paramString1)).intValue();
    if (paramString2 != null) {}
    try
    {
      long l = ((Long)paramString2).longValue();
      int k = (int)l;
      int i = k;
      if (l != k)
      {
        FinskyLog.e("Expected Integer value for flag %s but got Long instead", new Object[] { paramString1 });
        i = j;
      }
      return i;
    }
    catch (ClassCastException paramString2)
    {
      FinskyLog.b(paramString2, "Unexpected experiment flag type found for flag %s", new Object[] { paramString1 });
    }
    return j;
    return j;
  }
  
  public final void b()
  {
    this.b.newThread(new e(this)).start();
    this.b.newThread(new f(this)).start();
  }
  
  public final com.google.android.play.b.a.c c()
  {
    return a(this.c.a());
  }
  
  public final boolean c(String paramString1, String paramString2)
  {
    return c(paramString1, paramString2, this.a.cS());
  }
  
  public final boolean c(String paramString1, String paramString2, String paramString3)
  {
    return ((Boolean)a(paramString1, paramString2, paramString3, Boolean.class)).booleanValue();
  }
  
  public final String d(String paramString1, String paramString2)
  {
    return (String)a(paramString1, paramString2, this.a.cS(), String.class);
  }
  
  public final boolean d()
  {
    return this.f;
  }
  
  public final void e()
  {
    com.google.android.finsky.ag.c.av.a(Boolean.valueOf(false));
    this.f = false;
  }
  
  public final String f(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public final com.google.android.play.b.a.c g(String paramString)
  {
    return a(this.c.b(paramString));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */