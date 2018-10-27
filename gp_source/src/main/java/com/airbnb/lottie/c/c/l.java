package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.a.a.d;
import com.airbnb.lottie.c.b.s;
import com.airbnb.lottie.k;
import java.util.Collections;

public final class l
  extends a
{
  private final d g;
  
  l(k paramk, g paramg)
  {
    super(paramk, paramg);
    this.g = new d(paramk, this, new s(paramg.d, paramg.l));
    this.g.a(Collections.emptyList(), Collections.emptyList());
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    this.g.a(paramRectF, this.a);
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.g.a(paramString1, paramString2, paramColorFilter);
  }
  
  final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.g.a(paramCanvas, paramMatrix, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */