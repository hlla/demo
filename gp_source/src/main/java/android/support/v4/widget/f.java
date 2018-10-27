package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

final class f
  extends OvalShape
{
  private RadialGradient a;
  private Paint b = new Paint();
  
  f(e parame, int paramInt)
  {
    parame.b = paramInt;
    a((int)rect().width());
  }
  
  private final void a(int paramInt)
  {
    float f1 = paramInt / 2;
    float f2 = this.c.b;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.a = new RadialGradient(f1, f1, f2, new int[] { 1023410176, 0 }, null, localTileMode);
    this.b.setShader(this.a);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    int i = this.c.getWidth() / 2;
    float f1 = i;
    float f2 = this.c.getHeight() / 2;
    paramCanvas.drawCircle(f1, f2, f1, this.b);
    paramCanvas.drawCircle(f1, f2, i - this.c.b, paramPaint);
  }
  
  protected final void onResize(float paramFloat1, float paramFloat2)
  {
    super.onResize(paramFloat1, paramFloat2);
    a((int)paramFloat1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */