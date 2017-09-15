package android.support.design.widget;

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
import android.support.v4.b.b;

class d
  extends Drawable
{
  int fA;
  int fB;
  private ColorStateList fC;
  private int fD;
  boolean fE = true;
  float fF;
  final Paint fu = new Paint(1);
  final Rect fv = new Rect();
  final RectF fw = new RectF();
  float fx;
  int fy;
  int fz;
  
  public d()
  {
    this.fu.setStyle(Paint.Style.STROKE);
  }
  
  final void c(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      this.fD = paramColorStateList.getColorForState(getState(), this.fD);
    }
    this.fC = paramColorStateList;
    this.fE = true;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.fE)
    {
      localObject1 = this.fu;
      Object localObject2 = this.fv;
      copyBounds((Rect)localObject2);
      f1 = this.fx / ((Rect)localObject2).height();
      int i = b.i(this.fy, this.fD);
      int j = b.i(this.fz, this.fD);
      int k = b.i(b.j(this.fz, 0), this.fD);
      int m = b.i(b.j(this.fB, 0), this.fD);
      int n = b.i(this.fB, this.fD);
      int i1 = b.i(this.fA, this.fD);
      float f2 = ((Rect)localObject2).top;
      float f3 = ((Rect)localObject2).bottom;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject2));
      this.fE = false;
    }
    float f1 = this.fu.getStrokeWidth() / 2.0F;
    Object localObject1 = this.fw;
    copyBounds(this.fv);
    ((RectF)localObject1).set(this.fv);
    ((RectF)localObject1).left += f1;
    ((RectF)localObject1).top += f1;
    ((RectF)localObject1).right -= f1;
    ((RectF)localObject1).bottom -= f1;
    paramCanvas.save();
    paramCanvas.rotate(this.fF, ((RectF)localObject1).centerX(), ((RectF)localObject1).centerY());
    paramCanvas.drawOval((RectF)localObject1, this.fu);
    paramCanvas.restore();
  }
  
  public int getOpacity()
  {
    if (this.fx > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = Math.round(this.fx);
    paramRect.set(i, i, i, i);
    return true;
  }
  
  public boolean isStateful()
  {
    return ((this.fC != null) && (this.fC.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.fE = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.fC != null)
    {
      int i = this.fC.getColorForState(paramArrayOfInt, this.fD);
      if (i != this.fD)
      {
        this.fE = true;
        this.fD = i;
      }
    }
    if (this.fE) {
      invalidateSelf();
    }
    return this.fE;
  }
  
  public void setAlpha(int paramInt)
  {
    this.fu.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.fu.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */