package android.support.design.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.View;

final class a
  extends GradientDrawable
{
  public final RectF a;
  private final Paint b = new Paint(1);
  private int c;
  
  a()
  {
    this.b.setStyle(Paint.Style.FILL_AND_STROKE);
    this.b.setColor(-1);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.a = new RectF();
  }
  
  final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 != this.a.left) || (paramFloat2 != this.a.top) || (paramFloat3 != this.a.right) || (paramFloat4 != this.a.bottom))
    {
      this.a.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Drawable.Callback localCallback = getCallback();
    if (!(localCallback instanceof View)) {
      if (Build.VERSION.SDK_INT >= 21) {
        this.c = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      }
    }
    for (;;)
    {
      super.draw(paramCanvas);
      paramCanvas.drawRect(this.a, this.b);
      if (!(getCallback() instanceof View)) {
        paramCanvas.restoreToCount(this.c);
      }
      return;
      this.c = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
      continue;
      ((View)localCallback).setLayerType(2, null);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/textfield/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */