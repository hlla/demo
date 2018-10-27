package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.airbnb.lottie.c.b.u;
import com.airbnb.lottie.c.b.w;
import com.airbnb.lottie.c.b.x;
import com.airbnb.lottie.k;

public final class s
  extends a
{
  private final com.airbnb.lottie.a.b.a b;
  private final String c;
  
  public s(k paramk, com.airbnb.lottie.c.c.a parama, u paramu)
  {
    super(paramk, parama, paramu.a.a(), paramu.c.a(), paramu.g, paramu.h, paramu.d, paramu.f);
    this.c = paramu.e;
    this.b = paramu.b.a();
    this.b.a(this);
    parama.a(this.b);
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.a.setColor(((Integer)this.b.a()).intValue());
    super.a(paramCanvas, paramMatrix, paramInt);
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
  
  public final String b()
  {
    return this.c;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */