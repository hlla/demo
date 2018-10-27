package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.c.a.y;
import com.airbnb.lottie.c.b.z;
import com.airbnb.lottie.d.h;
import com.airbnb.lottie.k;
import java.util.List;

public final class p
  implements m, b
{
  private final com.airbnb.lottie.a.b.a a;
  private boolean b;
  private final k c;
  private final String d;
  private final Path e = new Path();
  private final com.airbnb.lottie.a.b.a f;
  private final RectF g = new RectF();
  private final com.airbnb.lottie.a.b.a h;
  private t i;
  
  public p(k paramk, com.airbnb.lottie.c.c.a parama, com.airbnb.lottie.c.b.n paramn)
  {
    this.d = paramn.b;
    this.c = paramk;
    this.f = paramn.c.a();
    this.h = paramn.d.a();
    this.a = paramn.a.a();
    parama.a(this.f);
    parama.a(this.h);
    parama.a(this.a);
    this.f.a(this);
    this.h.a(this);
    this.a.a(this);
  }
  
  public final void a()
  {
    this.b = false;
    this.c.invalidateSelf();
  }
  
  public final void a(List paramList1, List paramList2)
  {
    int j = 0;
    if (j < paramList1.size())
    {
      paramList2 = (c)paramList1.get(j);
      if ((paramList2 instanceof t))
      {
        paramList2 = (t)paramList2;
        if (paramList2.d == z.b) {
          break label52;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        label52:
        this.i = paramList2;
        this.i.a(this);
      }
    }
  }
  
  public final String b()
  {
    return this.d;
  }
  
  public final Path e()
  {
    if (this.b) {
      return this.e;
    }
    this.e.reset();
    Object localObject = (PointF)this.h.a();
    float f3 = ((PointF)localObject).x / 2.0F;
    float f4 = ((PointF)localObject).y / 2.0F;
    localObject = this.a;
    if (localObject != null) {}
    for (float f1 = ((Float)((com.airbnb.lottie.a.b.a)localObject).a()).floatValue();; f1 = 0.0F)
    {
      float f2 = Math.min(f3, f4);
      if (f1 > f2) {
        f1 = f2;
      }
      for (;;)
      {
        localObject = (PointF)this.f.a();
        this.e.moveTo(((PointF)localObject).x + f3, ((PointF)localObject).y - f4 + f1);
        this.e.lineTo(((PointF)localObject).x + f3, ((PointF)localObject).y + f4 - f1);
        if (f1 > 0.0F)
        {
          f2 = f1 + f1;
          this.g.set(((PointF)localObject).x + f3 - f2, ((PointF)localObject).y + f4 - f2, ((PointF)localObject).x + f3, ((PointF)localObject).y + f4);
          this.e.arcTo(this.g, 0.0F, 90.0F, false);
        }
        this.e.lineTo(((PointF)localObject).x - f3 + f1, ((PointF)localObject).y + f4);
        if (f1 > 0.0F)
        {
          f2 = f1 + f1;
          this.g.set(((PointF)localObject).x - f3, ((PointF)localObject).y + f4 - f2, f2 + (((PointF)localObject).x - f3), ((PointF)localObject).y + f4);
          this.e.arcTo(this.g, 90.0F, 90.0F, false);
        }
        this.e.lineTo(((PointF)localObject).x - f3, ((PointF)localObject).y - f4 + f1);
        if (f1 > 0.0F)
        {
          f2 = f1 + f1;
          this.g.set(((PointF)localObject).x - f3, ((PointF)localObject).y - f4, ((PointF)localObject).x - f3 + f2, f2 + (((PointF)localObject).y - f4));
          this.e.arcTo(this.g, 180.0F, 90.0F, false);
        }
        this.e.lineTo(((PointF)localObject).x + f3 - f1, ((PointF)localObject).y - f4);
        if (f1 > 0.0F)
        {
          f1 += f1;
          this.g.set(((PointF)localObject).x + f3 - f1, ((PointF)localObject).y - f4, f3 + ((PointF)localObject).x, ((PointF)localObject).y - f4 + f1);
          this.e.arcTo(this.g, 270.0F, 90.0F, false);
        }
        this.e.close();
        h.a(this.e, this.i);
        this.b = true;
        return this.e;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */