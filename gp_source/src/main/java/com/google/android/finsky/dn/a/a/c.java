package com.google.android.finsky.dn.a.a;

import com.google.android.finsky.dn.a.g;
import com.google.android.finsky.dn.a.h;

public final class c
  implements h
{
  private final com.google.android.gms.phenotype.core.b a;
  private final g[] b;
  
  public c(com.google.android.gms.phenotype.core.b paramb)
  {
    this.a = paramb;
    int i = this.a.a.length;
    this.b = new b[i];
    i -= 1;
    while (i >= 0)
    {
      this.b[i] = new b(this.a.a[i]);
      i -= 1;
    }
  }
  
  public final String a()
  {
    return this.a.c;
  }
  
  public final String b()
  {
    return this.a.b;
  }
  
  public final g[] c()
  {
    return this.b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */