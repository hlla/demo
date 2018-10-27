package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.c.a.i;
import com.airbnb.lottie.c.b.r;
import com.airbnb.lottie.d;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

public final class g
  implements e, b
{
  private final com.airbnb.lottie.a.b.a a;
  private final k b;
  private final String c;
  private final com.airbnb.lottie.a.b.a d;
  private final Paint e = new Paint(1);
  private final Path f = new Path();
  private final List g = new ArrayList();
  
  public g(k paramk, com.airbnb.lottie.c.c.a parama, r paramr)
  {
    this.c = paramr.c;
    this.b = paramk;
    if ((paramr.a != null) && (paramr.d != null))
    {
      this.f.setFillType(paramr.b);
      this.a = paramr.a.a();
      this.a.a(this);
      parama.a(this.a);
      this.d = paramr.d.a();
      this.d.a(this);
      parama.a(this.d);
      return;
    }
    this.a = null;
    this.d = null;
  }
  
  public final void a()
  {
    this.b.invalidateSelf();
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.e.setColor(((Integer)this.a.a()).intValue());
    int i = ((Integer)this.d.a()).intValue();
    Paint localPaint = this.e;
    float f1 = paramInt / 255.0F;
    localPaint.setAlpha((int)(i * f1 / 100.0F * 255.0F));
    this.f.reset();
    paramInt = 0;
    while (paramInt < this.g.size())
    {
      this.f.addPath(((m)this.g.get(paramInt)).e(), paramMatrix);
      paramInt += 1;
    }
    paramCanvas.drawPath(this.f, this.e);
    d.a();
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.f.reset();
    int i = 0;
    while (i < this.g.size())
    {
      this.f.addPath(((m)this.g.get(i)).e(), paramMatrix);
      i += 1;
    }
    this.f.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
  }
  
  public final void a(List paramList1, List paramList2)
  {
    int i = 0;
    if (i < paramList2.size())
    {
      paramList1 = (c)paramList2.get(i);
      if (!(paramList1 instanceof m)) {}
      for (;;)
      {
        i += 1;
        break;
        this.g.add((m)paramList1);
      }
    }
  }
  
  public final String b()
  {
    return this.c;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */