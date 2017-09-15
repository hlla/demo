package android.support.design.widget;

import android.content.res.Resources;
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
import android.support.design.a.c;
import android.support.v7.c.a.a;

final class o
  extends a
{
  static final double iS = Math.cos(Math.toRadians(45.0D));
  float fF;
  final Paint iT;
  final Paint iU;
  final RectF iV;
  float iW;
  Path iX;
  float iY;
  float iZ;
  float ja;
  float jb;
  private boolean jc = true;
  private final int jd;
  private final int je;
  private final int jf;
  boolean jg = true;
  private boolean jh = false;
  
  public o(Resources paramResources, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    this.jd = paramResources.getColor(a.c.aa);
    this.je = paramResources.getColor(a.c.Z);
    this.jf = paramResources.getColor(a.c.Y);
    this.iT = new Paint(5);
    this.iT.setStyle(Paint.Style.FILL);
    this.iW = Math.round(paramFloat1);
    this.iV = new RectF();
    this.iU = new Paint(this.iT);
    this.iU.setAntiAlias(false);
    d(paramFloat2, paramFloat3);
  }
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - iS) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - iS) * paramFloat2);
    }
    return f;
  }
  
  private static int k(float paramFloat)
  {
    int j = Math.round(paramFloat);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  final void d(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F)) {
      throw new IllegalArgumentException("invalid shadow size");
    }
    float f = k(paramFloat1);
    paramFloat2 = k(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.jh) {
        this.jh = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.jb == paramFloat1) && (this.iZ == paramFloat2)) {
      return;
    }
    this.jb = paramFloat1;
    this.iZ = paramFloat2;
    this.ja = Math.round(paramFloat1 * 1.5F);
    this.iY = paramFloat2;
    this.jc = true;
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    float f1;
    float f2;
    float f3;
    int i;
    int k;
    if (this.jc)
    {
      Object localObject = getBounds();
      f1 = this.iZ * 1.5F;
      this.iV.set(((Rect)localObject).left + this.iZ, ((Rect)localObject).top + f1, ((Rect)localObject).right - this.iZ, ((Rect)localObject).bottom - f1);
      this.mDrawable.setBounds((int)this.iV.left, (int)this.iV.top, (int)this.iV.right, (int)this.iV.bottom);
      localObject = new RectF(-this.iW, -this.iW, this.iW, this.iW);
      RectF localRectF = new RectF((RectF)localObject);
      localRectF.inset(-this.ja, -this.ja);
      if (this.iX == null)
      {
        this.iX = new Path();
        this.iX.setFillType(Path.FillType.EVEN_ODD);
        this.iX.moveTo(-this.iW, 0.0F);
        this.iX.rLineTo(-this.ja, 0.0F);
        this.iX.arcTo(localRectF, 180.0F, 90.0F, false);
        this.iX.arcTo((RectF)localObject, 270.0F, -90.0F, false);
        this.iX.close();
        f1 = -localRectF.top;
        if (f1 > 0.0F)
        {
          f2 = this.iW / f1;
          f3 = (1.0F - f2) / 2.0F;
          localPaint = this.iT;
          i = this.jd;
          j = this.je;
          k = this.jf;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
        }
        Paint localPaint = this.iU;
        f1 = ((RectF)localObject).top;
        f2 = localRectF.top;
        i = this.jd;
        j = this.je;
        k = this.jf;
        localObject = Shader.TileMode.CLAMP;
        localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
        this.iU.setAntiAlias(false);
        this.jc = false;
      }
    }
    else
    {
      k = paramCanvas.save();
      paramCanvas.rotate(this.fF, this.iV.centerX(), this.iV.centerY());
      f1 = -this.iW - this.ja;
      f2 = this.iW;
      if (this.iV.width() - 2.0F * f2 <= 0.0F) {
        break label1061;
      }
      i = 1;
      label535:
      if (this.iV.height() - 2.0F * f2 <= 0.0F) {
        break label1067;
      }
    }
    label1061:
    label1067:
    for (int j = 1;; j = 0)
    {
      float f6 = this.jb;
      float f7 = this.jb;
      f3 = this.jb;
      float f8 = this.jb;
      float f4 = this.jb;
      float f5 = this.jb;
      f3 = f2 / (f3 - f8 * 0.5F + f2);
      f6 = f2 / (f6 - f7 * 0.25F + f2);
      f4 = f2 / (f2 + (f4 - f5 * 1.0F));
      int m = paramCanvas.save();
      paramCanvas.translate(this.iV.left + f2, this.iV.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.drawPath(this.iX, this.iT);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.iV.width() - 2.0F * f2, -this.iW, this.iU);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.save();
      paramCanvas.translate(this.iV.right - f2, this.iV.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.iX, this.iT);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        f5 = this.iV.width();
        f7 = -this.iW;
        paramCanvas.drawRect(0.0F, f1, f5 - 2.0F * f2, this.ja + f7, this.iU);
      }
      paramCanvas.restoreToCount(m);
      i = paramCanvas.save();
      paramCanvas.translate(this.iV.left + f2, this.iV.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.iX, this.iT);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f4, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.iV.height() - 2.0F * f2, -this.iW, this.iU);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.iV.right - f2, this.iV.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.iX, this.iT);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.iV.height() - 2.0F * f2, -this.iW, this.iU);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.restoreToCount(k);
      super.draw(paramCanvas);
      return;
      this.iX.reset();
      break;
      i = 0;
      break label535;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(a(this.iZ, this.iW, this.jg));
    int j = (int)Math.ceil(b(this.iZ, this.iW, this.jg));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    this.jc = true;
  }
  
  public final void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    this.iT.setAlpha(paramInt);
    this.iU.setAlpha(paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */