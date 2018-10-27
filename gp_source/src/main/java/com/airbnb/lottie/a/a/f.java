package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.c.a.n;
import com.airbnb.lottie.c.a.y;
import com.airbnb.lottie.c.b.z;
import com.airbnb.lottie.d.h;
import com.airbnb.lottie.k;
import java.util.List;

public final class f
  implements m, b
{
  private boolean a;
  private final k b;
  private final String c;
  private final Path d = new Path();
  private final com.airbnb.lottie.a.b.a e;
  private final com.airbnb.lottie.a.b.a f;
  private t g;
  
  public f(k paramk, com.airbnb.lottie.c.c.a parama, com.airbnb.lottie.c.b.a parama1)
  {
    this.c = parama1.a;
    this.b = paramk;
    this.f = parama1.c.a();
    this.e = parama1.b.a();
    parama.a(this.f);
    parama.a(this.e);
    this.f.a(this);
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
        this.g = paramList2;
        this.g.a(this);
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
    PointF localPointF = (PointF)this.f.a();
    float f4 = localPointF.x / 2.0F;
    float f1 = localPointF.y / 2.0F;
    float f6 = f4 * 0.55228F;
    float f5 = f1 * 0.55228F;
    this.d.reset();
    float f2 = -f1;
    this.d.moveTo(0.0F, f2);
    float f7 = f6 + 0.0F;
    float f3 = -f5;
    this.d.cubicTo(f7, f2, f4, f3, f4, 0.0F);
    f5 += 0.0F;
    this.d.cubicTo(f4, f5, f7, f1, 0.0F, f1);
    f6 = -f6;
    f4 = -f4;
    this.d.cubicTo(f6, f1, f4, f5, f4, 0.0F);
    this.d.cubicTo(f4, f3, f6, f2, 0.0F, f2);
    localPointF = (PointF)this.e.a();
    this.d.offset(localPointF.x, localPointF.y);
    this.d.close();
    h.a(this.d, this.g);
    this.a = true;
    return this.d;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */