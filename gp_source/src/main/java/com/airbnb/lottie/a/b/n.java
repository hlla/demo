package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

public final class n
  extends a
{
  private final PointF d = new PointF();
  private final a e;
  private final a f;
  
  public n(a parama1, a parama2)
  {
    super(Collections.emptyList());
    this.e = parama1;
    this.f = parama2;
  }
  
  public final void a(float paramFloat)
  {
    this.e.a(paramFloat);
    this.f.a(paramFloat);
    this.d.set(((Float)this.e.a()).floatValue(), ((Float)this.f.a()).floatValue());
    int i = 0;
    while (i < this.b.size())
    {
      ((b)this.b.get(i)).a();
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */