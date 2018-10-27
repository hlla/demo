package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.c.a.i;
import com.airbnb.lottie.c.b.z;
import com.airbnb.lottie.d;
import com.airbnb.lottie.d.h;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements e, com.airbnb.lottie.a.b.b
{
  public final Paint a = new Paint(1);
  private final List b;
  private final com.airbnb.lottie.a.b.a c;
  private final float[] d;
  private final k e;
  private final com.airbnb.lottie.a.b.a f;
  private final Path g = new Path();
  private final List h = new ArrayList();
  private final PathMeasure i = new PathMeasure();
  private final RectF j = new RectF();
  private final Path k = new Path();
  private final com.airbnb.lottie.a.b.a l;
  
  a(k paramk, com.airbnb.lottie.c.c.a parama, Paint.Cap paramCap, Paint.Join paramJoin, i parami, com.airbnb.lottie.c.a.c paramc1, List paramList, com.airbnb.lottie.c.a.c paramc2)
  {
    this.e = paramk;
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeCap(paramCap);
    this.a.setStrokeJoin(paramJoin);
    this.f = parami.a();
    this.l = paramc1.a();
    if (paramc2 == null) {}
    for (this.c = null;; this.c = paramc2.a())
    {
      this.b = new ArrayList(paramList.size());
      this.d = new float[paramList.size()];
      int m = 0;
      while (m < paramList.size())
      {
        this.b.add(((com.airbnb.lottie.c.a.c)paramList.get(m)).a());
        m += 1;
      }
      parama.a(this.f);
      parama.a(this.l);
      m = 0;
      while (m < this.b.size())
      {
        parama.a((com.airbnb.lottie.a.b.a)this.b.get(m));
        m += 1;
      }
      paramk = this.c;
      if (paramk != null) {
        parama.a(paramk);
      }
      this.f.a(this);
      this.l.a(this);
      m = n;
      while (m < paramList.size())
      {
        ((com.airbnb.lottie.a.b.a)this.b.get(m)).a(this);
        m += 1;
      }
      paramk = this.c;
      if (paramk != null) {
        paramk.a(this);
      }
      return;
    }
  }
  
  public final void a()
  {
    this.e.invalidateSelf();
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    int m = ((Integer)this.f.a()).intValue();
    Object localObject = this.a;
    float f1 = paramInt / 255.0F;
    ((Paint)localObject).setAlpha((int)(m * f1 / 100.0F * 255.0F));
    this.a.setStrokeWidth(((Float)this.l.a()).floatValue() * h.a(paramMatrix));
    if (this.a.getStrokeWidth() <= 0.0F)
    {
      d.a();
      return;
    }
    if (this.b.isEmpty())
    {
      d.a();
      paramInt = 0;
      if (paramInt < this.h.size())
      {
        localObject = (b)this.h.get(paramInt);
        t localt = ((b)localObject).b;
        if (localt == null)
        {
          this.g.reset();
          m = ((b)localObject).a.size() - 1;
          while (m >= 0)
          {
            this.g.addPath(((m)((b)localObject).a.get(m)).e(), paramMatrix);
            m -= 1;
          }
          d.a();
          paramCanvas.drawPath(this.g, this.a);
          d.a();
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if (localt != null)
          {
            this.g.reset();
            m = ((b)localObject).a.size() - 1;
            while (m >= 0)
            {
              this.g.addPath(((m)((b)localObject).a.get(m)).e(), paramMatrix);
              m -= 1;
            }
            this.i.setPath(this.g, false);
            for (f1 = this.i.getLength(); this.i.nextContour(); f1 = this.i.getLength() + f1) {}
            float f2 = ((Float)((b)localObject).b.b.a()).floatValue() * f1 / 360.0F;
            float f5 = ((Float)((b)localObject).b.c.a()).floatValue() * f1 / 100.0F + f2;
            float f6 = ((Float)((b)localObject).b.a.a()).floatValue() * f1 / 100.0F + f2;
            m = ((b)localObject).a.size() - 1;
            f2 = 0.0F;
            if (m >= 0)
            {
              this.k.set(((m)((b)localObject).a.get(m)).e());
              this.k.transform(paramMatrix);
              this.i.setPath(this.k, false);
              float f7 = this.i.getLength();
              float f4;
              if (f6 > f1)
              {
                f4 = f6 - f1;
                if (f4 < f2 + f7) {
                  break label680;
                }
              }
              label680:
              while (f2 >= f4)
              {
                f4 = f2 + f7;
                if (f4 < f5) {}
                for (;;)
                {
                  m -= 1;
                  f2 += f7;
                  break;
                  if (f2 <= f6)
                  {
                    if (f4 > f6) {}
                    while (f5 >= f2)
                    {
                      if (f5 >= f2) {}
                      for (f3 = (f5 - f2) / f7;; f3 = 0.0F)
                      {
                        if (f6 <= f4) {}
                        for (f4 = (f6 - f2) / f7;; f4 = 1.0F)
                        {
                          h.a(this.k, f3, f4, 0.0F);
                          paramCanvas.drawPath(this.k, this.a);
                          break;
                        }
                      }
                    }
                    paramCanvas.drawPath(this.k, this.a);
                  }
                }
              }
              if (f5 > f1) {}
              for (float f3 = (f5 - f1) / f7;; f3 = 0.0F)
              {
                f4 = Math.min(f4 / f7, 1.0F);
                h.a(this.k, f3, f4, 0.0F);
                paramCanvas.drawPath(this.k, this.a);
                break;
              }
            }
            d.a();
          }
          else
          {
            d.a();
          }
        }
      }
      d.a();
      return;
    }
    f1 = h.a(paramMatrix);
    paramInt = 0;
    if (paramInt < this.b.size())
    {
      this.d[paramInt] = ((Float)((com.airbnb.lottie.a.b.a)this.b.get(paramInt)).a()).floatValue();
      if (paramInt % 2 == 0)
      {
        localObject = this.d;
        if (localObject[paramInt] < 1.0F) {
          localObject[paramInt] = 1.0F;
        }
      }
      for (;;)
      {
        localObject = this.d;
        localObject[paramInt] *= f1;
        paramInt += 1;
        break;
        localObject = this.d;
        if (localObject[paramInt] < 0.1F) {
          localObject[paramInt] = 0.1F;
        }
      }
    }
    localObject = this.c;
    if (localObject != null) {}
    for (f1 = ((Float)((com.airbnb.lottie.a.b.a)localObject).a()).floatValue();; f1 = 0.0F)
    {
      this.a.setPathEffect(new DashPathEffect(this.d, f1));
      d.a();
      paramInt = 0;
      break;
    }
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.g.reset();
    int m = 0;
    while (m < this.h.size())
    {
      b localb = (b)this.h.get(m);
      int n = 0;
      while (n < localb.a.size())
      {
        this.g.addPath(((m)localb.a.get(n)).e(), paramMatrix);
        n += 1;
      }
      m += 1;
    }
    this.g.computeBounds(this.j, false);
    float f1 = ((Float)this.l.a()).floatValue();
    paramMatrix = this.j;
    f1 /= 2.0F;
    paramMatrix.set(paramMatrix.left - f1, this.j.top - f1, this.j.right + f1, f1 + this.j.bottom);
    paramRectF.set(this.j);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
    d.a();
  }
  
  public final void a(List paramList1, List paramList2)
  {
    c localc = null;
    int m = paramList1.size() - 1;
    Object localObject1 = null;
    Object localObject2;
    if (m >= 0)
    {
      localObject2 = (c)paramList1.get(m);
      if ((localObject2 instanceof t))
      {
        localObject2 = (t)localObject2;
        if (((t)localObject2).d == z.a) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        m -= 1;
        break;
      }
    }
    if (localObject1 == null) {}
    for (;;)
    {
      m = paramList2.size() - 1;
      paramList1 = localc;
      while (m >= 0)
      {
        localc = (c)paramList2.get(m);
        if ((localc instanceof t))
        {
          localObject2 = (t)localc;
          if (((t)localObject2).d == z.a) {}
        }
        else
        {
          if (!(localc instanceof m))
          {
            m -= 1;
            continue;
          }
          if (paramList1 == null) {
            paramList1 = new b((t)localObject1);
          }
          for (;;)
          {
            paramList1.a.add((m)localc);
            break;
          }
        }
        if (paramList1 == null) {}
        for (;;)
        {
          paramList1 = new b((t)localObject2);
          ((t)localObject2).a(this);
          break;
          this.h.add(paramList1);
        }
      }
      if (paramList1 != null) {
        this.h.add(paramList1);
      }
      return;
      ((t)localObject1).a(this);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */