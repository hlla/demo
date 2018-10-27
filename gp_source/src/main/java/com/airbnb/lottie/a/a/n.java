package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.c.a.y;
import com.airbnb.lottie.c.b.l;
import com.airbnb.lottie.c.b.z;
import com.airbnb.lottie.d.h;
import com.airbnb.lottie.k;
import java.util.List;

public final class n
  implements m, b
{
  private final com.airbnb.lottie.a.b.a a;
  private final com.airbnb.lottie.a.b.a b;
  private boolean c;
  private final k d;
  private final String e;
  private final com.airbnb.lottie.a.b.a f;
  private final com.airbnb.lottie.a.b.a g;
  private final Path h = new Path();
  private final com.airbnb.lottie.a.b.a i;
  private final com.airbnb.lottie.a.b.a j;
  private final com.airbnb.lottie.a.b.a k;
  private t l;
  private final com.airbnb.lottie.c.b.m m;
  
  public n(k paramk, com.airbnb.lottie.c.c.a parama, l paraml)
  {
    this.d = paramk;
    this.e = paraml.c;
    this.m = paraml.i;
    this.i = paraml.f.a();
    this.j = paraml.g.a();
    this.k = paraml.h.a();
    this.f = paraml.d.a();
    this.g = paraml.e.a();
    if (this.m != com.airbnb.lottie.c.b.m.b) {
      this.a = null;
    }
    for (this.b = null;; this.b = paraml.b.a())
    {
      parama.a(this.i);
      parama.a(this.j);
      parama.a(this.k);
      parama.a(this.f);
      parama.a(this.g);
      if (this.m == com.airbnb.lottie.c.b.m.b)
      {
        parama.a(this.a);
        parama.a(this.b);
      }
      this.i.a(this);
      this.j.a(this);
      this.k.a(this);
      this.f.a(this);
      this.g.a(this);
      if (this.m == com.airbnb.lottie.c.b.m.b)
      {
        this.f.a(this);
        this.g.a(this);
      }
      return;
      this.a = paraml.a.a();
    }
  }
  
  public final void a()
  {
    this.c = false;
    this.d.invalidateSelf();
  }
  
  public final void a(List paramList1, List paramList2)
  {
    int n = 0;
    if (n < paramList1.size())
    {
      paramList2 = (c)paramList1.get(n);
      if ((paramList2 instanceof t))
      {
        paramList2 = (t)paramList2;
        if (paramList2.d == z.b) {
          break label52;
        }
      }
      for (;;)
      {
        n += 1;
        break;
        label52:
        this.l = paramList2;
        this.l.a(this);
      }
    }
  }
  
  public final String b()
  {
    return this.e;
  }
  
  public final Path e()
  {
    if (this.c) {
      return this.h;
    }
    this.h.reset();
    float f1;
    double d2;
    float f2;
    float f6;
    double d3;
    float f3;
    float f4;
    float f7;
    double d4;
    label488:
    label563:
    float f5;
    switch (o.a[this.m.ordinal()])
    {
    default: 
      this.h.close();
      h.a(this.h, this.l);
      this.c = true;
      return this.h;
    case 1: 
      f1 = ((Float)this.i.a()).floatValue();
      localObject = this.k;
      if (localObject != null) {}
      for (d1 = ((Float)((com.airbnb.lottie.a.b.a)localObject).a()).floatValue();; d1 = 0.0D)
      {
        d1 = Math.toRadians(d1 - 90.0D);
        d2 = f1;
        float f18 = (float)(6.283185307179586D / d2);
        float f8 = f18 / 2.0F;
        float f19 = f1 - (int)f1;
        if (f19 != 0.0F) {
          d1 += (1.0F - f19) * f8;
        }
        for (;;)
        {
          float f9 = ((Float)this.f.a()).floatValue();
          float f10 = ((Float)this.a.a()).floatValue();
          localObject = this.b;
          if (localObject != null) {}
          for (f1 = ((Float)((com.airbnb.lottie.a.b.a)localObject).a()).floatValue() / 100.0F;; f1 = 0.0F)
          {
            localObject = this.g;
            if (localObject != null) {}
            for (f2 = ((Float)((com.airbnb.lottie.a.b.a)localObject).a()).floatValue() / 100.0F;; f2 = 0.0F)
            {
              if (f19 != 0.0F)
              {
                f6 = f10 + (f9 - f10) * f19;
                d3 = f6;
                f3 = (float)(Math.cos(d1) * d3);
                f4 = (float)(d3 * Math.sin(d1));
                this.h.moveTo(f3, f4);
                d1 = f18 * f19 / 2.0F + d1;
              }
              for (;;)
              {
                d2 = Math.ceil(d2);
                d2 += d2;
                int i1 = 0;
                n = 0;
                float f12 = f3;
                float f11 = f4;
                d3 = i1;
                if (d3 >= d2)
                {
                  localObject = (PointF)this.j.a();
                  this.h.offset(((PointF)localObject).x, ((PointF)localObject).y);
                  this.h.close();
                  break;
                }
                if (n == 0) {}
                for (f3 = f10;; f3 = f9)
                {
                  if (f6 != 0.0F) {
                    if (d3 == -2.0D + d2) {
                      f7 = f18 * f19 / 2.0F;
                    }
                  }
                  for (;;)
                  {
                    if (f6 != 0.0F) {
                      if (d3 == -1.0D + d2) {
                        f4 = f6;
                      }
                    }
                    for (;;)
                    {
                      d4 = f4;
                      float f15 = (float)(Math.cos(d1) * d4);
                      float f16 = (float)(d4 * Math.sin(d1));
                      float f17;
                      float f14;
                      label572:
                      float f13;
                      if (f1 != 0.0F)
                      {
                        d4 = (float)(Math.atan2(f11, f12) - 1.5707963267948966D);
                        float f21 = (float)Math.cos(d4);
                        f17 = (float)Math.sin(d4);
                        d4 = (float)(Math.atan2(f16, f15) - 1.5707963267948966D);
                        float f20 = (float)Math.cos(d4);
                        f14 = (float)Math.sin(d4);
                        if (n == 0)
                        {
                          f4 = f2;
                          if (n == 0)
                          {
                            f5 = f1;
                            if (n == 0)
                            {
                              f13 = f9;
                              label581:
                              f13 = f4 * f13 * 0.47829F;
                              f4 = f13 * f21;
                              f17 = f13 * f17;
                              f5 = f3 * f5 * 0.47829F;
                              f3 = f5 * f20;
                              f5 *= f14;
                              if (f19 == 0.0F)
                              {
                                f14 = f4;
                                f4 = f3;
                                f13 = f17;
                                f3 = f14;
                                label652:
                                this.h.cubicTo(f12 - f3, f11 - f13, f4 + f15, f5 + f16, f15, f16);
                              }
                            }
                          }
                        }
                      }
                      for (;;)
                      {
                        d3 = f7;
                        i1 += 1;
                        n ^= 0x1;
                        d1 += d3;
                        f11 = f16;
                        f12 = f15;
                        break;
                        if (i1 == 0)
                        {
                          f13 = f17 * f19;
                          f14 = f4 * f19;
                          f4 = f3;
                          f3 = f14;
                          break label652;
                        }
                        if (d3 == -1.0D + d2)
                        {
                          f5 *= f19;
                          f14 = f3 * f19;
                          f3 = f4;
                          f13 = f17;
                          f4 = f14;
                          break label652;
                        }
                        f13 = f4;
                        f4 = f3;
                        f3 = f13;
                        f13 = f17;
                        break label652;
                        f13 = f10;
                        break label581;
                        f5 = f2;
                        break label572;
                        f4 = f1;
                        break label563;
                        if (f2 != 0.0F) {
                          break label488;
                        }
                        this.h.lineTo(f15, f16);
                      }
                      f4 = f3;
                      continue;
                      f4 = f3;
                    }
                    f7 = f8;
                    continue;
                    f7 = f8;
                  }
                }
                d3 = f9;
                f3 = (float)(Math.cos(d1) * d3);
                f4 = (float)(d3 * Math.sin(d1));
                this.h.moveTo(f3, f4);
                d1 = f8 + d1;
                f6 = 0.0F;
              }
            }
          }
        }
      }
    }
    int n = (int)Math.floor(((Float)this.i.a()).floatValue());
    Object localObject = this.k;
    if (localObject != null) {}
    for (double d1 = ((Float)((com.airbnb.lottie.a.b.a)localObject).a()).floatValue();; d1 = 0.0D)
    {
      d1 = Math.toRadians(d1 - 90.0D);
      d4 = n;
      f5 = ((Float)this.g.a()).floatValue() / 100.0F;
      f6 = ((Float)this.f.a()).floatValue();
      d2 = f6;
      f1 = (float)(Math.cos(d1) * d2);
      f2 = (float)(Math.sin(d1) * d2);
      this.h.moveTo(f1, f2);
      d3 = (float)(6.283185307179586D / d4);
      d4 = Math.ceil(d4);
      n = 0;
      d1 += d3;
      if (n >= d4)
      {
        localObject = (PointF)this.j.a();
        this.h.offset(((PointF)localObject).x, ((PointF)localObject).y);
        this.h.close();
        break;
      }
      f4 = (float)(Math.cos(d1) * d2);
      f3 = (float)(Math.sin(d1) * d2);
      if (f5 != 0.0F)
      {
        double d6 = (float)(Math.atan2(f2, f1) - 1.5707963267948966D);
        double d5 = Math.cos(d6);
        d6 = Math.sin(d6);
        double d8 = (float)(Math.atan2(f3, f4) - 1.5707963267948966D);
        double d7 = Math.cos(d8);
        d8 = Math.sin(d8);
        f7 = f6 * f5 * 0.25F;
        this.h.cubicTo(f1 - (float)d5 * f7, f2 - (float)d6 * f7, (float)d7 * f7 + f4, f7 * (float)d8 + f3, f4, f3);
      }
      for (;;)
      {
        n += 1;
        d1 += d3;
        f1 = f4;
        f2 = f3;
        break;
        this.h.lineTo(f4, f3);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */