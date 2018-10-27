package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.q;
import com.airbnb.lottie.k;

public final class m
  extends a
{
  private final g g;
  private final Paint h = new Paint();
  private final RectF i = new RectF();
  
  m(k paramk, g paramg)
  {
    super(paramk, paramg);
    this.g = paramg;
    this.h.setAlpha(0);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setColor(paramg.m);
  }
  
  private final void a(Matrix paramMatrix)
  {
    RectF localRectF = this.i;
    g localg = this.g;
    localRectF.set(0.0F, 0.0F, localg.o, localg.n);
    paramMatrix.mapRect(this.i);
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    a(this.a);
    paramRectF.set(this.i);
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.h.setColorFilter(paramColorFilter);
  }
  
  public final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    int j = Color.alpha(this.g.m);
    if (j != 0)
    {
      float f1 = paramInt / 255.0F;
      float f2 = j / 255.0F;
      paramInt = (int)(((Integer)this.f.b.a()).intValue() * f2 / 100.0F * f1 * 255.0F);
      this.h.setAlpha(paramInt);
      if (paramInt > 0)
      {
        a(paramMatrix);
        paramCanvas.drawRect(this.i, this.h);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */