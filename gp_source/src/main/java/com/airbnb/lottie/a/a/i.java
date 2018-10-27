package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.v4.g.h;
import com.airbnb.lottie.c.a.n;
import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.c.b.g;
import com.airbnb.lottie.c.b.w;
import com.airbnb.lottie.c.b.x;
import com.airbnb.lottie.k;

public final class i
  extends a
{
  private final RectF b = new RectF();
  private final int c;
  private final com.airbnb.lottie.a.b.a d;
  private final com.airbnb.lottie.a.b.a e;
  private final h f = new h();
  private final String g;
  private final h h = new h();
  private final com.airbnb.lottie.a.b.a i;
  private final g j;
  
  public i(k paramk, com.airbnb.lottie.c.c.a parama, com.airbnb.lottie.c.b.f paramf)
  {
    super(paramk, parama, paramf.a.a(), paramf.f.a(), paramf.i, paramf.k, paramf.g, paramf.b);
    this.g = paramf.h;
    this.j = paramf.e;
    this.c = ((int)(paramk.d.a() / 32L));
    this.d = paramf.d.a();
    this.d.a(this);
    parama.a(this.d);
    this.i = paramf.j.a();
    this.i.a(this);
    parama.a(this.i);
    this.e = paramf.c.a();
    this.e.a(this);
    parama.a(this.e);
  }
  
  private final int c()
  {
    int k = Math.round(this.i.c * this.c);
    int i1 = Math.round(this.e.c * this.c);
    int n = Math.round(this.d.c * this.c);
    if (k != 0) {}
    for (int m = k * 527;; m = 17)
    {
      k = m;
      if (i1 != 0) {
        k = m * 31 * i1;
      }
      m = k;
      if (n != 0) {
        m = k * 31 * n;
      }
      return m;
    }
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    a(this.b, paramMatrix);
    Paint localPaint;
    long l;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int[] arrayOfInt;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    if (this.j == g.a)
    {
      localPaint = this.a;
      l = c();
      localObject2 = (LinearGradient)this.f.a(l, null);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = (PointF)this.i.a();
        localObject2 = (PointF)this.e.a();
        localObject3 = (c)this.d.a();
        arrayOfInt = ((c)localObject3).a;
        localObject3 = ((c)localObject3).b;
        f1 = this.b.left;
        f2 = this.b.width();
        f3 = ((PointF)localObject1).x;
        f4 = this.b.top;
        f5 = this.b.height();
        f6 = ((PointF)localObject1).y;
        float f7 = this.b.left;
        float f8 = this.b.width();
        float f9 = ((PointF)localObject2).x;
        float f10 = this.b.top;
        float f11 = this.b.height();
        float f12 = ((PointF)localObject2).y;
        localObject1 = new LinearGradient((int)(f2 / 2.0F + f1 + f3), (int)(f5 / 2.0F + f4 + f6), (int)(f8 / 2.0F + f7 + f9), (int)(f11 / 2.0F + f10 + f12), arrayOfInt, (float[])localObject3, Shader.TileMode.CLAMP);
        this.f.b(l, localObject1);
      }
      localPaint.setShader((Shader)localObject1);
    }
    for (;;)
    {
      super.a(paramCanvas, paramMatrix, paramInt);
      return;
      localPaint = this.a;
      l = c();
      localObject2 = (RadialGradient)this.h.a(l, null);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = (PointF)this.i.a();
        localObject2 = (PointF)this.e.a();
        localObject3 = (c)this.d.a();
        arrayOfInt = ((c)localObject3).a;
        localObject3 = ((c)localObject3).b;
        int k = (int)(this.b.left + this.b.width() / 2.0F + ((PointF)localObject1).x);
        f1 = this.b.top;
        f2 = this.b.height() / 2.0F;
        int m = (int)(((PointF)localObject1).y + (f1 + f2));
        f1 = this.b.left;
        f2 = this.b.width();
        f3 = ((PointF)localObject2).x;
        f4 = this.b.top;
        f5 = this.b.height();
        f6 = ((PointF)localObject2).y;
        double d1 = Math.hypot((int)(f1 + f2 / 2.0F + f3) - k, (int)(f5 / 2.0F + f4 + f6) - m);
        localObject1 = new RadialGradient(k, m, (float)d1, arrayOfInt, (float[])localObject3, Shader.TileMode.CLAMP);
        this.h.b(l, localObject1);
      }
      localPaint.setShader((Shader)localObject1);
    }
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter) {}
  
  public final String b()
  {
    return this.g;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */