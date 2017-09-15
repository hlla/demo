package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public abstract class i
  extends Drawable
{
  public final Paint fu = new Paint(3);
  public float iW;
  final Bitmap mBitmap;
  private int tV = 160;
  private int tW = 119;
  public final BitmapShader tX;
  private final Matrix tY = new Matrix();
  final Rect tZ = new Rect();
  private final RectF ua = new RectF();
  private boolean ub = true;
  public boolean uc;
  private int ud;
  private int ue;
  
  i(Resources paramResources, Bitmap paramBitmap)
  {
    if (paramResources != null) {
      this.tV = paramResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap != null)
    {
      this.ud = this.mBitmap.getScaledWidth(this.tV);
      this.ue = this.mBitmap.getScaledHeight(this.tV);
      this.tX = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return;
    }
    this.ue = -1;
    this.ud = -1;
    this.tX = null;
  }
  
  private void bu()
  {
    this.iW = (Math.min(this.ue, this.ud) / 2);
  }
  
  public static boolean n(float paramFloat)
  {
    return paramFloat > 0.05F;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
  {
    throw new UnsupportedOperationException();
  }
  
  final void bs()
  {
    if (this.ub)
    {
      if (!this.uc) {
        break label220;
      }
      int i = Math.min(this.ud, this.ue);
      a(this.tW, i, i, getBounds(), this.tZ);
      i = Math.min(this.tZ.width(), this.tZ.height());
      int j = Math.max(0, (this.tZ.width() - i) / 2);
      int k = Math.max(0, (this.tZ.height() - i) / 2);
      this.tZ.inset(j, k);
      this.iW = (i * 0.5F);
    }
    for (;;)
    {
      this.ua.set(this.tZ);
      if (this.tX != null)
      {
        this.tY.setTranslate(this.ua.left, this.ua.top);
        this.tY.preScale(this.ua.width() / this.mBitmap.getWidth(), this.ua.height() / this.mBitmap.getHeight());
        this.tX.setLocalMatrix(this.tY);
        this.fu.setShader(this.tX);
      }
      this.ub = false;
      return;
      label220:
      a(this.tW, this.ud, this.ue, getBounds(), this.tZ);
    }
  }
  
  public final void bt()
  {
    this.uc = true;
    this.ub = true;
    bu();
    this.fu.setShader(this.tX);
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.mBitmap;
    if (localBitmap == null) {
      return;
    }
    bs();
    if (this.fu.getShader() == null)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.tZ, this.fu);
      return;
    }
    paramCanvas.drawRoundRect(this.ua, this.iW, this.iW, this.fu);
  }
  
  public int getAlpha()
  {
    return this.fu.getAlpha();
  }
  
  public ColorFilter getColorFilter()
  {
    return this.fu.getColorFilter();
  }
  
  public int getIntrinsicHeight()
  {
    return this.ue;
  }
  
  public int getIntrinsicWidth()
  {
    return this.ud;
  }
  
  public int getOpacity()
  {
    if ((this.tW != 119) || (this.uc)) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      localBitmap = this.mBitmap;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.fu.getAlpha() < 255) || (n(this.iW)));
    return -1;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.uc) {
      bu();
    }
    this.ub = true;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.fu.getAlpha())
    {
      this.fu.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.fu.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.fu.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.fu.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/b/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */