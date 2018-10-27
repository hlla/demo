package android.support.v7.c.a;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class m
  extends Drawable
{
  private static final float b = (float)Math.toRadians(45.0D);
  public float a;
  private float c;
  private float d;
  private float e;
  private float f;
  private int g = 2;
  private float h;
  private final Paint i = new Paint();
  private final Path j = new Path();
  private final int k;
  private boolean l;
  private boolean m = false;
  
  public m(Context paramContext)
  {
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeJoin(Paint.Join.MITER);
    this.i.setStrokeCap(Paint.Cap.BUTT);
    this.i.setAntiAlias(true);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, android.support.v7.a.a.aQ, 2130968866, 2132017329);
    a(paramContext.getColor(android.support.v7.a.a.aU, 0));
    float f1 = paramContext.getDimension(android.support.v7.a.a.aY, 0.0F);
    if (this.i.getStrokeWidth() != f1)
    {
      this.i.setStrokeWidth(f1);
      this.h = ((float)(f1 / 2.0F * Math.cos(b)));
      invalidateSelf();
    }
    boolean bool = paramContext.getBoolean(android.support.v7.a.a.aX, true);
    if (this.l != bool)
    {
      this.l = bool;
      invalidateSelf();
    }
    f1 = Math.round(paramContext.getDimension(android.support.v7.a.a.aW, 0.0F));
    if (f1 != this.e)
    {
      this.e = f1;
      invalidateSelf();
    }
    this.k = paramContext.getDimensionPixelSize(android.support.v7.a.a.aV, 0);
    this.f = Math.round(paramContext.getDimension(android.support.v7.a.a.aT, 0.0F));
    this.c = Math.round(paramContext.getDimension(android.support.v7.a.a.aR, 0.0F));
    this.d = paramContext.getDimension(android.support.v7.a.a.aS, 0.0F);
    paramContext.recycle();
  }
  
  public final void a(float paramFloat)
  {
    if (this.a != paramFloat)
    {
      this.a = paramFloat;
      invalidateSelf();
    }
  }
  
  public final void a(int paramInt)
  {
    if (paramInt != this.i.getColor())
    {
      this.i.setColor(paramInt);
      invalidateSelf();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.m != paramBoolean)
    {
      this.m = paramBoolean;
      invalidateSelf();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int n;
    switch (this.g)
    {
    case 2: 
    default: 
      if (android.support.v4.a.a.a.g(this) == 1) {
        n = 1;
      }
      break;
    }
    for (;;)
    {
      float f1 = this.c;
      f1 *= f1;
      double d1 = Math.sqrt(f1 + f1);
      float f6 = this.f;
      float f7 = this.a;
      float f8 = (float)d1;
      float f4 = (this.d - f6) * f7 + f6;
      float f5 = Math.round((this.h + 0.0F) * f7 + 0.0F);
      float f9 = b;
      float f3 = this.a;
      if (n == 0) {}
      for (f1 = -180.0F;; f1 = 0.0F)
      {
        if (n == 0) {}
        for (float f2 = 0.0F;; f2 = 180.0F)
        {
          d1 = (f8 - f6) * f7 + f6;
          double d2 = (f9 + 0.0F) * f3 + 0.0F;
          f6 = (float)Math.round(Math.cos(d2) * d1);
          f7 = (float)Math.round(Math.sin(d2) * d1);
          this.j.rewind();
          f8 = this.e + this.i.getStrokeWidth();
          f8 += (-this.h - f8) * this.a;
          f9 = -f4 / 2.0F;
          this.j.moveTo(f9 + f5, 0.0F);
          this.j.rLineTo(f4 - (f5 + f5), 0.0F);
          this.j.moveTo(f9, f8);
          this.j.rLineTo(f6, f7);
          this.j.moveTo(f9, -f8);
          this.j.rLineTo(f6, -f7);
          this.j.close();
          paramCanvas.save();
          f4 = this.i.getStrokeWidth();
          int i1 = localRect.height();
          f5 = this.e;
          i1 = (int)(i1 - 3.0F * f4 - (f5 + f5)) / 4;
          paramCanvas.translate(localRect.centerX(), f4 * 1.5F + f5 + (i1 + i1));
          if (this.l) {
            if ((n ^ this.m) == 0)
            {
              n = 1;
              paramCanvas.rotate(n * ((f2 - f1) * f3 + f1));
            }
          }
          for (;;)
          {
            paramCanvas.drawPath(this.j, this.i);
            paramCanvas.restore();
            return;
            n = -1;
            break;
            if (n != 0) {
              paramCanvas.rotate(180.0F);
            }
          }
        }
      }
      n = 0;
      continue;
      n = 0;
      continue;
      if (android.support.v4.a.a.a.g(this) == 0)
      {
        n = 1;
      }
      else
      {
        n = 0;
        continue;
        n = 1;
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.k;
  }
  
  public int getIntrinsicWidth()
  {
    return this.k;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.i.getAlpha())
    {
      this.i.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.i.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/c/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */