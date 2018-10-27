package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.n;
import com.airbnb.lottie.c.b.g;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

public final class h
  implements e, b
{
  private final RectF a = new RectF();
  private final int b;
  private final com.airbnb.lottie.a.b.a c;
  private final com.airbnb.lottie.a.b.a d;
  private final android.support.v4.g.h e = new android.support.v4.g.h();
  private final k f;
  private final String g;
  private final com.airbnb.lottie.a.b.a h;
  private final Paint i = new Paint(1);
  private final Path j = new Path();
  private final List k = new ArrayList();
  private final android.support.v4.g.h l = new android.support.v4.g.h();
  private final Matrix m = new Matrix();
  private final com.airbnb.lottie.a.b.a n;
  private final g o;
  
  public h(k paramk, com.airbnb.lottie.c.c.a parama, com.airbnb.lottie.c.b.d paramd)
  {
    this.g = paramd.e;
    this.f = paramk;
    this.o = paramd.d;
    this.j.setFillType(paramd.b);
    this.b = ((int)(paramk.d.a() / 32L));
    this.c = paramd.c.a();
    this.c.a(this);
    parama.a(this.c);
    this.h = paramd.f.a();
    this.h.a(this);
    parama.a(this.h);
    this.n = paramd.g.a();
    this.n.a(this);
    parama.a(this.n);
    this.d = paramd.a.a();
    this.d.a(this);
    parama.a(this.d);
  }
  
  private final int c()
  {
    int i1 = Math.round(this.n.c * this.b);
    int i4 = Math.round(this.d.c * this.b);
    int i3 = Math.round(this.c.c * this.b);
    if (i1 != 0) {}
    for (int i2 = i1 * 527;; i2 = 17)
    {
      i1 = i2;
      if (i4 != 0) {
        i1 = i2 * 31 * i4;
      }
      i2 = i1;
      if (i3 != 0) {
        i2 = i1 * 31 * i3;
      }
      return i2;
    }
  }
  
  public final void a()
  {
    this.f.invalidateSelf();
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.j.reset();
    int i1 = 0;
    while (i1 < this.k.size())
    {
      this.j.addPath(((m)this.k.get(i1)).e(), paramMatrix);
      i1 += 1;
    }
    this.j.computeBounds(this.a, false);
    long l1;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int[] arrayOfInt;
    if (this.o == g.a)
    {
      l1 = c();
      localObject2 = (LinearGradient)this.e.a(l1, null);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = (PointF)this.n.a();
        localObject2 = (PointF)this.d.a();
        localObject3 = (com.airbnb.lottie.c.b.c)this.c.a();
        arrayOfInt = ((com.airbnb.lottie.c.b.c)localObject3).a;
        localObject3 = ((com.airbnb.lottie.c.b.c)localObject3).b;
        localObject1 = new LinearGradient(((PointF)localObject1).x, ((PointF)localObject1).y, ((PointF)localObject2).x, ((PointF)localObject2).y, arrayOfInt, (float[])localObject3, Shader.TileMode.CLAMP);
        this.e.b(l1, localObject1);
      }
    }
    for (;;)
    {
      this.m.set(paramMatrix);
      ((Shader)localObject1).setLocalMatrix(this.m);
      this.i.setShader((Shader)localObject1);
      i1 = ((Integer)this.h.a()).intValue();
      paramMatrix = this.i;
      float f1 = paramInt / 255.0F;
      paramMatrix.setAlpha((int)(i1 * f1 / 100.0F * 255.0F));
      paramCanvas.drawPath(this.j, this.i);
      com.airbnb.lottie.d.a();
      return;
      l1 = c();
      localObject2 = (RadialGradient)this.l.a(l1, null);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = (PointF)this.n.a();
        localObject2 = (PointF)this.d.a();
        localObject3 = (com.airbnb.lottie.c.b.c)this.c.a();
        arrayOfInt = ((com.airbnb.lottie.c.b.c)localObject3).a;
        localObject3 = ((com.airbnb.lottie.c.b.c)localObject3).b;
        f1 = ((PointF)localObject1).x;
        float f2 = ((PointF)localObject1).y;
        float f3 = ((PointF)localObject2).x;
        float f4 = ((PointF)localObject2).y;
        localObject1 = new RadialGradient(f1, f2, (float)Math.hypot(f3 - f1, f4 - f2), arrayOfInt, (float[])localObject3, Shader.TileMode.CLAMP);
        this.l.b(l1, localObject1);
      }
    }
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.j.reset();
    int i1 = 0;
    while (i1 < this.k.size())
    {
      this.j.addPath(((m)this.k.get(i1)).e(), paramMatrix);
      i1 += 1;
    }
    this.j.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter) {}
  
  public final void a(List paramList1, List paramList2)
  {
    int i1 = 0;
    if (i1 < paramList2.size())
    {
      paramList1 = (c)paramList2.get(i1);
      if (!(paramList1 instanceof m)) {}
      for (;;)
      {
        i1 += 1;
        break;
        this.k.add((m)paramList1);
      }
    }
  }
  
  public final String b()
  {
    return this.g;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */