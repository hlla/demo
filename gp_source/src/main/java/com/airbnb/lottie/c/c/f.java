package com.airbnb.lottie.c.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.airbnb.lottie.b.b;
import com.airbnb.lottie.i;
import com.airbnb.lottie.k;

public final class f
  extends a
{
  private final float g;
  private final Rect h = new Rect();
  private final Paint i = new Paint(3);
  private final Rect j = new Rect();
  
  f(k paramk, g paramg, float paramFloat)
  {
    super(paramk, paramg);
    this.g = paramFloat;
  }
  
  private final Bitmap c()
  {
    String str = this.b.k;
    k localk = this.c;
    b localb;
    if (localk.getCallback() != null)
    {
      localb = localk.j;
      if (localb == null) {
        if (localk.j == null) {
          localk.j = new b(localk.getCallback(), localk.k, localk.i, localk.d.f);
        }
      }
    }
    for (Object localObject = localk.j;; localObject = null)
    {
      if (localObject != null) {
        return ((b)localObject).a(str);
      }
      return null;
      localObject = localk.getCallback();
      if (localObject != null) {
        if ((localObject instanceof View)) {
          localObject = ((View)localObject).getContext();
        }
      }
      for (;;)
      {
        if ((localObject == null) && (localb.a == null)) {
          break label163;
        }
        if (localObject == null) {}
        while (!localb.a.equals(localObject))
        {
          localk.j.a();
          localk.j = null;
          break;
        }
        break;
        localObject = null;
        continue;
        localObject = null;
      }
      label163:
      break;
    }
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    paramMatrix = c();
    if (paramMatrix != null)
    {
      paramRectF.set(paramRectF.left, paramRectF.top, Math.min(paramRectF.right, paramMatrix.getWidth()), Math.min(paramRectF.bottom, paramMatrix.getHeight()));
      this.a.mapRect(paramRectF);
    }
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.i.setColorFilter(paramColorFilter);
  }
  
  public final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    Bitmap localBitmap = c();
    if (localBitmap != null)
    {
      this.i.setAlpha(paramInt);
      paramCanvas.save();
      paramCanvas.concat(paramMatrix);
      this.j.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      this.h.set(0, 0, (int)(localBitmap.getWidth() * this.g), (int)(localBitmap.getHeight() * this.g));
      paramCanvas.drawBitmap(localBitmap, this.j, this.h, this.i);
      paramCanvas.restore();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */