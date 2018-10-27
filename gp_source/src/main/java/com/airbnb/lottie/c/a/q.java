package com.airbnb.lottie.c.a;

import android.graphics.Path;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.m;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.c.b.p;
import com.airbnb.lottie.d.g;
import java.util.List;

public final class q
  extends ac
{
  private final Path c = new Path();
  
  q(List paramList, p paramp)
  {
    super(paramList, paramp);
  }
  
  private final Path a(p paramp)
  {
    this.c.reset();
    g.a(paramp, this.c);
    return this.c;
  }
  
  public final a a()
  {
    if (!c()) {
      return new o(a((p)this.a));
    }
    return new m(this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */