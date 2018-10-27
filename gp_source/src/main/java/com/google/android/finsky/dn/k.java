package com.google.android.finsky.dn;

import java.util.HashSet;
import java.util.Set;

public abstract class k
  extends a
{
  public final Set b = new HashSet();
  
  protected final void a(a parama)
  {
    if (!(parama instanceof k)) {
      throw new IllegalArgumentException("Only process stable flag definitions should be set up from PsExpFlag");
    }
    super.a(parama);
    this.b.addAll(((k)parama).b());
  }
  
  protected Set b()
  {
    return this.b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */