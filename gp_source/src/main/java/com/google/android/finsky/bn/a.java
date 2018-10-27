package com.google.android.finsky.bn;

import com.google.common.util.concurrent.am;
import com.google.common.util.concurrent.ap;
import com.google.common.util.concurrent.az;
import com.google.common.util.concurrent.bd;
import java.util.concurrent.TimeUnit;

final class a
  extends z
  implements x
{
  public final ap a;
  private final w b;
  
  private a(w paramw, ap paramap)
  {
    this.b = paramw;
    this.a = paramap;
  }
  
  static a a(w paramw, ap paramap)
  {
    return new a(paramw, paramap);
  }
  
  private final y b(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    az localaz = new az(this);
    bd localbd = bd.e();
    return y.a(new j(localbd, this.a.a(new d(localaz, paramRunnable, localbd), paramLong1, paramLong2, paramTimeUnit)));
  }
  
  private final y b(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    paramRunnable = new am(paramRunnable);
    return y.a(new j(paramRunnable, this.a.a(new b(this, paramRunnable), paramLong, paramTimeUnit)));
  }
  
  public final w a()
  {
    return this.b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */