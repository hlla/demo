package android.support.v4.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.g.u;
import android.support.v4.view.b.b;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public final class g
  extends Drawable
  implements Animatable
{
  private static final int[] d = { -16777216 };
  private static final Interpolator e = new LinearInterpolator();
  private static final Interpolator f = new b();
  public boolean a;
  public final j b;
  public float c;
  private Animator g;
  private Resources h;
  private float i;
  
  public g(Context paramContext)
  {
    this.h = ((Context)u.a(paramContext)).getResources();
    this.b = new j();
    this.b.a(d);
    this.b.a(2.5F);
    invalidateSelf();
    paramContext = this.b;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new h(this, paramContext));
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(e);
    localValueAnimator.addListener(new i(this, paramContext));
    this.g = localValueAnimator;
  }
  
  private final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    j localj = this.b;
    float f1 = this.h.getDisplayMetrics().density;
    localj.a(paramFloat2 * f1);
    localj.l = (paramFloat1 * f1);
    localj.a(0);
    localj.f = ((int)(paramFloat3 * f1));
    localj.c = ((int)(f1 * paramFloat4));
  }
  
  static void a(float paramFloat, j paramj)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (-0.75F + paramFloat) / 0.25F;
      int i1 = paramj.b();
      int j = paramj.h[paramj.a()];
      int k = i1 >> 24 & 0xFF;
      int m = i1 >> 16 & 0xFF;
      int n = i1 >> 8 & 0xFF;
      i1 &= 0xFF;
      int i2 = (int)(((j >> 24 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((j >> 16 & 0xFF) - m) * paramFloat);
      int i4 = (int)(((j >> 8 & 0xFF) - n) * paramFloat);
      paramj.i = ((int)(paramFloat * ((j & 0xFF) - i1)) + i1 | k + i2 << 24 | m + i3 << 16 | i4 + n << 8);
      return;
    }
    paramj.i = paramj.b();
  }
  
  public final void a(float paramFloat)
  {
    j localj = this.b;
    if (paramFloat != localj.e) {
      localj.e = paramFloat;
    }
    invalidateSelf();
  }
  
  final void a(float paramFloat, j paramj, boolean paramBoolean)
  {
    if (!this.a)
    {
      if (paramFloat != 1.0F) {}
      for (;;)
      {
        float f3 = paramj.q;
        if (paramFloat < 0.5F)
        {
          f2 = paramj.r;
          f1 = f.getInterpolation(paramFloat / 0.5F) * 0.79F + 0.01F + f2;
          float f4 = this.c;
          paramj.o = f2;
          paramj.j = f1;
          paramj.m = (0.20999998F * paramFloat + f3);
          this.i = ((paramFloat + f4) * 216.0F);
        }
        do
        {
          return;
          f1 = paramj.r + 0.79F;
          f2 = f1 - ((1.0F - f.getInterpolation((-0.5F + paramFloat) / 0.5F)) * 0.79F + 0.01F);
          break;
        } while (!paramBoolean);
      }
    }
    a(paramFloat, paramj);
    double d1 = Math.floor(paramj.q / 0.8F);
    float f1 = paramj.r;
    float f2 = paramj.p;
    paramj.o = (f1 + (-0.01F + f2 - f1) * paramFloat);
    paramj.j = f2;
    f1 = paramj.q;
    paramj.m = (((float)(d1 + 1.0D) - f1) * paramFloat + f1);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt != 0) {
      a(7.5F, 2.5F, 10.0F, 5.0F);
    }
    for (;;)
    {
      invalidateSelf();
      return;
      a(11.0F, 3.0F, 12.0F, 6.0F);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
    invalidateSelf();
  }
  
  public final void b(float paramFloat)
  {
    j localj = this.b;
    localj.o = 0.0F;
    localj.j = paramFloat;
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.i, ((Rect)localObject).exactCenterX(), ((Rect)localObject).exactCenterY());
    j localj = this.b;
    RectF localRectF = localj.t;
    float f2 = localj.l;
    float f1 = localj.s / 2.0F + f2;
    if (f2 <= 0.0F) {
      f1 = Math.min(((Rect)localObject).width(), ((Rect)localObject).height()) / 2.0F - Math.max(localj.f * localj.e / 2.0F, localj.s / 2.0F);
    }
    localRectF.set(((Rect)localObject).centerX() - f1, ((Rect)localObject).centerY() - f1, ((Rect)localObject).centerX() + f1, f1 + ((Rect)localObject).centerY());
    f1 = localj.o;
    f2 = localj.m;
    f1 = (f1 + f2) * 360.0F;
    f2 = (localj.j + f2) * 360.0F - f1;
    localj.k.setColor(localj.i);
    localj.k.setAlpha(localj.a);
    float f3 = localj.s / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, localj.g);
    f3 = -f3;
    localRectF.inset(f3, f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, localj.k);
    if (localj.n)
    {
      localObject = localj.b;
      if (localObject != null) {
        break label540;
      }
      localj.b = new Path();
      localj.b.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height());
      int j = localj.f;
      float f4 = localj.e;
      localj.b.moveTo(0.0F, 0.0F);
      localj.b.lineTo(localj.f * localj.e, 0.0F);
      localObject = localj.b;
      int k = localj.f;
      float f5 = localj.e;
      ((Path)localObject).lineTo(k * f5 / 2.0F, f5 * localj.c);
      localj.b.offset(f3 / 2.0F + localRectF.centerX() - j * f4 / 2.0F, localRectF.centerY() + localj.s / 2.0F);
      localj.b.close();
      localj.d.setColor(localj.i);
      localj.d.setAlpha(localj.a);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(localj.b, localj.d);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
      label540:
      ((Path)localObject).reset();
    }
  }
  
  public final int getAlpha()
  {
    return this.b.a;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    return this.g.isRunning();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.b.a = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.k.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public final void start()
  {
    this.g.cancel();
    this.b.c();
    j localj = this.b;
    if (localj.j == localj.o)
    {
      localj.a(0);
      this.b.d();
      this.g.setDuration(1332L);
      this.g.start();
      return;
    }
    this.a = true;
    this.g.setDuration(666L);
    this.g.start();
  }
  
  public final void stop()
  {
    this.g.cancel();
    this.i = 0.0F;
    this.b.a(false);
    this.b.a(0);
    this.b.d();
    invalidateSelf();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */