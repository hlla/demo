package com.google.android.finsky.dn.a.a;

import com.google.android.finsky.dn.a.g;
import com.google.android.finsky.dn.a.n;
import com.google.android.gms.phenotype.core.a;

public final class b
  implements g
{
  private final n[] a;
  
  public b(a parama)
  {
    int i = parama.b.length;
    this.a = new n[i];
    i -= 1;
    while (i >= 0)
    {
      this.a[i] = new i(parama.b[i]);
      i -= 1;
    }
  }
  
  public final n[] a()
  {
    return this.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */