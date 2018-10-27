package android.support.design.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.a.a;

public class b
  extends Drawable
{
  public float a;
  public int b;
  public int c;
  public boolean d = true;
  public final Paint e = new Paint(1);
  public final Rect f = new Rect();
  public float g;
  public int h;
  public int i;
  private ColorStateList j;
  private int k;
  private final RectF l = new RectF();
  private final c m = new c(this);
  
  public b()
  {
    this.e.setStyle(Paint.Style.STROKE);
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.k = paramColorStateList.getColorForState(getState(), this.k);
    }
    this.j = paramColorStateList;
    this.d = true;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.d)
    {
      localObject1 = this.e;
      Object localObject2 = this.f;
      copyBounds((Rect)localObject2);
      f1 = this.a / ((Rect)localObject2).height();
      int n = a.a(this.i, this.k);
      int i1 = a.a(this.h, this.k);
      int i2 = a.a(a.b(this.h, 0), this.k);
      int i3 = a.a(a.b(this.b, 0), this.k);
      int i4 = a.a(this.b, this.k);
      int i5 = a.a(this.c, this.k);
      float f2 = ((Rect)localObject2).top;
      float f3 = ((Rect)localObject2).bottom;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { n, i1, i2, i3, i4, i5 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject2));
      this.d = false;
    }
    float f1 = this.e.getStrokeWidth() / 2.0F;
    Object localObject1 = this.l;
    copyBounds(this.f);
    ((RectF)localObject1).set(this.f);
    ((RectF)localObject1).left += f1;
    ((RectF)localObject1).top += f1;
    ((RectF)localObject1).right -= f1;
    ((RectF)localObject1).bottom -= f1;
    paramCanvas.save();
    paramCanvas.rotate(this.g, ((RectF)localObject1).centerX(), ((RectF)localObject1).centerY());
    paramCanvas.drawOval((RectF)localObject1, this.e);
    paramCanvas.restore();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.m;
  }
  
  public int getOpacity()
  {
    if (this.a > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int n = Math.round(this.a);
    paramRect.set(n, n, n, n);
    return true;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = this.j;
    if (localColorStateList == null) {}
    for (;;)
    {
      if (super.isStateful()) {}
      do
      {
        return true;
        return false;
      } while (localColorStateList.isStateful());
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.d = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = this.j;
    if (localColorStateList != null)
    {
      int n = localColorStateList.getColorForState(paramArrayOfInt, this.k);
      if (n != this.k)
      {
        this.d = true;
        this.k = n;
      }
    }
    if (this.d) {
      invalidateSelf();
    }
    return this.d;
  }
  
  public void setAlpha(int paramInt)
  {
    this.e.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */