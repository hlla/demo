package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.c.a.c;
import com.airbnb.lottie.c.a.i;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.a.p;
import com.airbnb.lottie.c.a.w;
import com.airbnb.lottie.c.a.y;
import com.airbnb.lottie.c.k;

public final class q
{
  public final a a;
  public final a b;
  public final a c;
  private final a d;
  private final Matrix e = new Matrix();
  private final a f;
  private final a g;
  private final a h;
  
  public q(w paramw)
  {
    this.d = paramw.a.a();
    this.f = paramw.d.a();
    this.h = paramw.f.a();
    this.g = paramw.e.a();
    this.b = paramw.c.a();
    c localc = paramw.g;
    if (localc == null) {}
    for (this.c = null;; this.c = localc.a())
    {
      paramw = paramw.b;
      if (paramw == null)
      {
        this.a = null;
        return;
      }
      this.a = paramw.a();
      return;
    }
  }
  
  public final Matrix a()
  {
    this.e.reset();
    Object localObject = (PointF)this.f.a();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.e.preTranslate(((PointF)localObject).x, ((PointF)localObject).y);
    }
    float f1 = ((Float)this.g.a()).floatValue();
    if (f1 != 0.0F) {
      this.e.preRotate(f1);
    }
    localObject = (k)this.h.a();
    f1 = ((k)localObject).a;
    if ((f1 != 1.0F) || (((k)localObject).b != 1.0F)) {
      this.e.preScale(f1, ((k)localObject).b);
    }
    localObject = (PointF)this.d.a();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.e.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    }
    return this.e;
  }
  
  public final Matrix a(float paramFloat)
  {
    PointF localPointF1 = (PointF)this.f.a();
    PointF localPointF2 = (PointF)this.d.a();
    k localk = (k)this.h.a();
    float f1 = ((Float)this.g.a()).floatValue();
    this.e.reset();
    this.e.preTranslate(localPointF1.x * paramFloat, localPointF1.y * paramFloat);
    double d1 = paramFloat;
    this.e.preScale((float)Math.pow(localk.a, d1), (float)Math.pow(localk.b, d1));
    this.e.preRotate(f1 * paramFloat, localPointF2.x, localPointF2.y);
    return this.e;
  }
  
  public final void a(b paramb)
  {
    this.d.a(paramb);
    this.f.a(paramb);
    this.h.a(paramb);
    this.g.a(paramb);
    this.b.a(paramb);
    a locala = this.c;
    if (locala != null) {
      locala.a(paramb);
    }
    locala = this.a;
    if (locala != null) {
      locala.a(paramb);
    }
  }
  
  public final void a(com.airbnb.lottie.c.c.a parama)
  {
    parama.a(this.d);
    parama.a(this.f);
    parama.a(this.h);
    parama.a(this.g);
    parama.a(this.b);
    a locala = this.c;
    if (locala != null) {
      parama.a(locala);
    }
    locala = this.a;
    if (locala != null) {
      parama.a(locala);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */