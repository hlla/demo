package com.google.android.finsky.bn;

import com.google.common.util.concurrent.aa;
import com.google.common.util.concurrent.al;
import com.google.common.util.concurrent.an;
import com.google.common.util.concurrent.at;
import java.util.concurrent.TimeUnit;

final class j
  extends aa
  implements an
{
  public volatile an a;
  
  j(al paramal, an paraman)
  {
    super(paramal);
    this.a = paraman;
    paramal.a(new k(this), at.a);
  }
  
  public final long getDelay(TimeUnit paramTimeUnit)
  {
    return this.a.getDelay(paramTimeUnit);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bn/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */