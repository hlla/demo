package android.support.d.a;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.support.v4.content.a.b;

final class n
  extends q
{
  public float a = 1.0F;
  public b b;
  public int c = 0;
  public float d = 1.0F;
  public b e;
  public Paint.Cap f = Paint.Cap.BUTT;
  public Paint.Join g = Paint.Join.MITER;
  public float h = 4.0F;
  public float i = 0.0F;
  public int[] j;
  public float k = 1.0F;
  public float l = 0.0F;
  public float m = 0.0F;
  
  public n() {}
  
  public n(n paramn)
  {
    super(paramn);
    this.j = paramn.j;
    this.e = paramn.e;
    this.i = paramn.i;
    this.d = paramn.d;
    this.b = paramn.b;
    this.c = paramn.c;
    this.a = paramn.a;
    this.m = paramn.m;
    this.k = paramn.k;
    this.l = paramn.l;
    this.f = paramn.f;
    this.g = paramn.g;
    this.h = paramn.h;
  }
  
  public final boolean a(int[] paramArrayOfInt)
  {
    return this.b.a(paramArrayOfInt) | this.e.a(paramArrayOfInt);
  }
  
  public final boolean b()
  {
    return (this.b.b()) || (this.e.b());
  }
  
  final float getFillAlpha()
  {
    return this.a;
  }
  
  final int getFillColor()
  {
    return this.b.a;
  }
  
  final float getStrokeAlpha()
  {
    return this.d;
  }
  
  final int getStrokeColor()
  {
    return this.e.a;
  }
  
  final float getStrokeWidth()
  {
    return this.i;
  }
  
  final float getTrimPathEnd()
  {
    return this.k;
  }
  
  final float getTrimPathOffset()
  {
    return this.l;
  }
  
  final float getTrimPathStart()
  {
    return this.m;
  }
  
  final void setFillAlpha(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  final void setFillColor(int paramInt)
  {
    this.b.a = paramInt;
  }
  
  final void setStrokeAlpha(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  final void setStrokeColor(int paramInt)
  {
    this.e.a = paramInt;
  }
  
  final void setStrokeWidth(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  final void setTrimPathEnd(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  final void setTrimPathOffset(float paramFloat)
  {
    this.l = paramFloat;
  }
  
  final void setTrimPathStart(float paramFloat)
  {
    this.m = paramFloat;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */