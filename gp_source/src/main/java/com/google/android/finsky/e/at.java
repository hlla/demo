package com.google.android.finsky.e;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.fm;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.libraries.performance.primes.bz;
import com.google.android.libraries.performance.primes.cj;
import com.google.android.libraries.performance.primes.ck;
import com.google.wireless.android.a.b.a.a.am;
import f.a.a.a.a.b.ai;

public final class at
  extends fm
  implements ah, aj
{
  private final x a;
  private boolean b = false;
  private af c;
  private final int d;
  private final cj e;
  
  public at(cj paramcj, x paramx, af paramaf, int paramInt)
  {
    this.e = paramcj;
    this.a = paramx;
    this.c = paramaf;
    this.d = paramInt;
  }
  
  public final void a(int paramInt, ai paramai)
  {
    am localam = new am();
    localam.c = paramai;
    localam.b = paramInt;
    localam.a |= 0x1;
    FinskyLog.b("JankReport: %s, pageType: %d", new Object[] { localam, Integer.valueOf(this.d) });
    paramai = this.c;
    d locald = new d(18);
    locald.a.T = localam;
    paramai.a(locald.e(this.d));
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 1) {
      a(ar.b);
    }
    while (paramInt != 0) {
      return;
    }
    b(ar.b);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public final void a(af paramaf)
  {
    this.c = paramaf;
  }
  
  public final void a(bz parambz)
  {
    if (!this.b)
    {
      this.b = true;
      this.e.a.a(cj.a(parambz));
    }
  }
  
  public final void b(bz parambz)
  {
    if (this.b)
    {
      this.a.c = this;
      this.b = false;
      this.e.a.a(cj.a(parambz), true, null);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */