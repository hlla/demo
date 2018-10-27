package com.google.android.finsky.da;

import com.google.android.finsky.accounts.c;
import com.google.common.base.x;
import java.util.HashSet;
import java.util.Set;

public final class g
{
  public final c a;
  public final Set b = new HashSet();
  public final k c;
  
  public g(c paramc, k paramk)
  {
    this.a = paramc;
    this.c = ((k)x.a(paramk));
  }
  
  public final void a(i parami)
  {
    this.b.add(parami);
  }
  
  public final void b(i parami)
  {
    this.b.remove(parami);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/da/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */