package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.Path.FillType;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.c.a.q;
import com.airbnb.lottie.c.b.z;
import com.airbnb.lottie.d.h;
import com.airbnb.lottie.k;
import java.util.List;

public final class r
  implements m, b
{
  private boolean a;
  private final k b;
  private final String c;
  private final Path d = new Path();
  private final com.airbnb.lottie.a.b.a e;
  private t f;
  
  public r(k paramk, com.airbnb.lottie.c.c.a parama, com.airbnb.lottie.c.b.t paramt)
  {
    this.c = paramt.a;
    this.b = paramk;
    this.e = paramt.b.a();
    parama.a(this.e);
    this.e.a(this);
  }
  
  public final void a()
  {
    this.a = false;
    this.b.invalidateSelf();
  }
  
  public final void a(List paramList1, List paramList2)
  {
    int i = 0;
    if (i < paramList1.size())
    {
      paramList2 = (c)paramList1.get(i);
      if ((paramList2 instanceof t))
      {
        paramList2 = (t)paramList2;
        if (paramList2.d == z.b) {
          break label52;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label52:
        this.f = paramList2;
        this.f.a(this);
      }
    }
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final Path e()
  {
    if (this.a) {
      return this.d;
    }
    this.d.reset();
    this.d.set((Path)this.e.a());
    this.d.setFillType(Path.FillType.EVEN_ODD);
    h.a(this.d, this.f);
    this.a = true;
    return this.d;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */