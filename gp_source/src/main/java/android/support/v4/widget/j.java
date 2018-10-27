package android.support.v4.widget;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;

final class j
{
  public int a = 255;
  public Path b;
  public int c;
  public final Paint d = new Paint();
  public float e = 1.0F;
  public int f;
  public final Paint g = new Paint();
  public int[] h;
  public int i;
  public float j = 0.0F;
  public final Paint k = new Paint();
  public float l;
  public float m = 0.0F;
  public boolean n;
  public float o = 0.0F;
  public float p;
  public float q;
  public float r;
  public float s = 5.0F;
  public final RectF t = new RectF();
  private int u;
  
  j()
  {
    this.k.setStrokeCap(Paint.Cap.SQUARE);
    this.k.setAntiAlias(true);
    this.k.setStyle(Paint.Style.STROKE);
    this.d.setStyle(Paint.Style.FILL);
    this.d.setAntiAlias(true);
    this.g.setColor(0);
  }
  
  final int a()
  {
    return (this.u + 1) % this.h.length;
  }
  
  final void a(float paramFloat)
  {
    this.s = paramFloat;
    this.k.setStrokeWidth(paramFloat);
  }
  
  final void a(int paramInt)
  {
    this.u = paramInt;
    this.i = this.h[this.u];
  }
  
  final void a(boolean paramBoolean)
  {
    if (this.n != paramBoolean) {
      this.n = paramBoolean;
    }
  }
  
  final void a(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
    a(0);
  }
  
  final int b()
  {
    return this.h[this.u];
  }
  
  final void c()
  {
    this.r = this.o;
    this.p = this.j;
    this.q = this.m;
  }
  
  final void d()
  {
    this.r = 0.0F;
    this.p = 0.0F;
    this.q = 0.0F;
    this.o = 0.0F;
    this.j = 0.0F;
    this.m = 0.0F;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */