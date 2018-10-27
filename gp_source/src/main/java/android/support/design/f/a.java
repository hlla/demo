package android.support.design.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.d;
import android.support.v7.c.a.l;

public final class a
  extends l
{
  private static final double e = Math.cos(Math.toRadians(45.0D));
  public boolean a = true;
  public float b;
  public float c;
  private final RectF f;
  private float g;
  private final Paint h;
  private Path i;
  private boolean j = true;
  private final Paint k;
  private boolean l = false;
  private float m;
  private final int n;
  private final int o;
  private float p;
  private final int q;
  
  public a(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    this.q = d.c(paramContext, 2131099774);
    this.o = d.c(paramContext, 2131099773);
    this.n = d.c(paramContext, 2131099772);
    this.h = new Paint(5);
    this.h.setStyle(Paint.Style.FILL);
    this.g = Math.round(paramFloat1);
    this.f = new RectF();
    this.k = new Paint(this.h);
    this.k.setAntiAlias(false);
    a(paramFloat2, paramFloat3);
  }
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - e) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f1 = paramFloat1;
    if (paramBoolean) {
      f1 = (float)(paramFloat1 + (1.0D - e) * paramFloat2);
    }
    return f1;
  }
  
  private static int b(float paramFloat)
  {
    int i2 = Math.round(paramFloat);
    int i1 = i2;
    if (i2 % 2 == 1) {
      i1 = i2 - 1;
    }
    return i1;
  }
  
  public final void a(float paramFloat)
  {
    a(paramFloat, this.m);
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 >= 0.0F) && (paramFloat2 >= 0.0F))
    {
      float f1 = b(paramFloat1);
      paramFloat2 = b(paramFloat2);
      paramFloat1 = f1;
      if (f1 > paramFloat2)
      {
        if (this.l) {
          break label96;
        }
        this.l = true;
      }
      label96:
      for (paramFloat1 = paramFloat2;; paramFloat1 = paramFloat2)
      {
        if ((this.b != paramFloat1) || (this.m != paramFloat2))
        {
          this.b = paramFloat1;
          this.m = paramFloat2;
          this.p = Math.round(paramFloat1 * 1.5F);
          this.j = true;
          invalidateSelf();
        }
        return;
      }
    }
    throw new IllegalArgumentException("invalid shadow size");
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject1;
    float f1;
    float f2;
    RectF localRectF;
    Object localObject2;
    if (this.j)
    {
      localObject1 = getBounds();
      f1 = this.m * 1.5F;
      this.f.set(((Rect)localObject1).left + this.m, ((Rect)localObject1).top + f1, ((Rect)localObject1).right - this.m, ((Rect)localObject1).bottom - f1);
      this.d.setBounds((int)this.f.left, (int)this.f.top, (int)this.f.right, (int)this.f.bottom);
      f1 = this.g;
      f2 = -f1;
      localObject1 = new RectF(f2, f2, f1, f1);
      localRectF = new RectF((RectF)localObject1);
      f1 = -this.p;
      localRectF.inset(f1, f1);
      localObject2 = this.i;
      if (localObject2 != null) {
        break label1003;
      }
      this.i = new Path();
    }
    for (;;)
    {
      this.i.setFillType(Path.FillType.EVEN_ODD);
      this.i.moveTo(-this.g, 0.0F);
      this.i.rLineTo(-this.p, 0.0F);
      this.i.arcTo(localRectF, 180.0F, 90.0F, false);
      this.i.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
      this.i.close();
      f1 = -localRectF.top;
      if (f1 > 0.0F)
      {
        f2 = this.g / f1;
        localObject2 = this.h;
        i1 = this.q;
        i2 = this.o;
        i3 = this.n;
        f3 = (1.0F - f2) / 2.0F;
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        ((Paint)localObject2).setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i1, i2, i3 }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
      }
      localObject2 = this.k;
      f1 = ((RectF)localObject1).top;
      f2 = localRectF.top;
      int i1 = this.q;
      int i2 = this.o;
      int i3 = this.n;
      localObject1 = Shader.TileMode.CLAMP;
      ((Paint)localObject2).setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i1, i2, i3 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject1));
      this.k.setAntiAlias(false);
      this.j = false;
      i1 = paramCanvas.save();
      paramCanvas.rotate(this.c, this.f.centerX(), this.f.centerY());
      f1 = this.g;
      f2 = -f1 - this.p;
      float f3 = f1 + f1;
      float f8 = this.f.width() - f3;
      float f4 = this.f.height() - f3;
      float f6 = this.b;
      float f5 = f1 / (f6 - 0.5F * f6 + f1);
      f6 = f1 / (f6 - 0.25F * f6 + f1);
      float f7 = f1 / (0.0F + f1);
      i2 = paramCanvas.save();
      paramCanvas.translate(this.f.left + f1, this.f.top + f1);
      paramCanvas.scale(f5, f6);
      paramCanvas.drawPath(this.i, this.h);
      if (f8 > 0.0F)
      {
        paramCanvas.scale(1.0F / f5, 1.0F);
        paramCanvas.drawRect(0.0F, f2, this.f.width() - f3, -this.g, this.k);
      }
      paramCanvas.restoreToCount(i2);
      i2 = paramCanvas.save();
      paramCanvas.translate(this.f.right - f1, this.f.bottom - f1);
      paramCanvas.scale(f5, f7);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.i, this.h);
      if (f8 > 0.0F)
      {
        paramCanvas.scale(1.0F / f5, 1.0F);
        f8 = this.f.width();
        float f9 = -this.g;
        paramCanvas.drawRect(0.0F, f2, f8 - f3, this.p + f9, this.k);
      }
      paramCanvas.restoreToCount(i2);
      i2 = paramCanvas.save();
      paramCanvas.translate(this.f.left + f1, this.f.bottom - f1);
      paramCanvas.scale(f5, f7);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.i, this.h);
      if (f4 > 0.0F)
      {
        paramCanvas.scale(1.0F / f7, 1.0F);
        paramCanvas.drawRect(0.0F, f2, this.f.height() - f3, -this.g, this.k);
      }
      paramCanvas.restoreToCount(i2);
      i2 = paramCanvas.save();
      paramCanvas.translate(this.f.right - f1, this.f.top + f1);
      paramCanvas.scale(f5, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.i, this.h);
      if (f4 > 0.0F)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f2, this.f.height() - f3, -this.g, this.k);
      }
      paramCanvas.restoreToCount(i2);
      paramCanvas.restoreToCount(i1);
      super.draw(paramCanvas);
      return;
      label1003:
      ((Path)localObject2).reset();
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i1 = (int)Math.ceil(a(this.m, this.g, this.a));
    int i2 = (int)Math.ceil(b(this.m, this.g, this.a));
    paramRect.set(i2, i1, i2, i1);
    return true;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    this.j = true;
  }
  
  public final void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    this.h.setAlpha(paramInt);
    this.k.setAlpha(paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */