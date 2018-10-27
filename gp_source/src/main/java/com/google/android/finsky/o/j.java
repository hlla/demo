package com.google.android.finsky.o;

import com.google.android.finsky.ag.c;
import com.google.android.finsky.ag.q;
import com.google.wireless.android.finsky.dfe.d.a.c.a.b;

public final class j
  implements a
{
  private b a;
  private com.google.android.finsky.ad.a b;
  
  public j(com.google.android.finsky.ad.a parama)
  {
    this.b = parama;
    this.a = new b();
  }
  
  public final int a()
  {
    return 3;
  }
  
  public final void a(com.google.wireless.android.finsky.dfe.d.a.a.a parama)
  {
    parama.b = this.a;
  }
  
  public final boolean b()
  {
    this.b.a();
    b localb = this.a;
    long l = ((Long)c.aj.a()).longValue();
    localb.c |= 0x1;
    localb.b = l;
    localb = this.a;
    int i = ((Integer)c.ai.a()).intValue();
    localb.c |= 0x2;
    localb.a = i;
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/o/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */