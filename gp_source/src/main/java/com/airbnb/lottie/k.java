package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.c.c.g;
import com.airbnb.lottie.c.c.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class k
  extends Drawable
  implements Drawable.Callback
{
  public static final String a = k.class.getSimpleName();
  public final com.airbnb.lottie.d.c b = new com.airbnb.lottie.d.c();
  public final Set c = new HashSet();
  public i d;
  public com.airbnb.lottie.c.c.d e;
  public boolean f;
  public b g;
  public com.airbnb.lottie.b.a h;
  public c i;
  public com.airbnb.lottie.b.b j;
  public String k;
  public boolean l;
  public float m = 1.0F;
  public boolean n;
  public y o;
  private int p = 255;
  private final ArrayList q = new ArrayList();
  private final Matrix r = new Matrix();
  private float s = 1.0F;
  
  public k()
  {
    this.b.setRepeatCount(0);
    this.b.setInterpolator(new LinearInterpolator());
    this.b.addUpdateListener(new l(this));
  }
  
  private final void e()
  {
    i locali = this.d;
    if (locali != null)
    {
      float f1 = this.m;
      setBounds(0, 0, (int)(locali.a.width() * f1), (int)(f1 * this.d.a.height()));
    }
  }
  
  public final void a()
  {
    com.airbnb.lottie.b.b localb = this.j;
    if (localb != null) {
      localb.a();
    }
  }
  
  public final void a(float paramFloat)
  {
    com.airbnb.lottie.d.c localc = this.b;
    localc.c = paramFloat;
    localc.a(paramFloat, localc.b);
  }
  
  public final void a(int paramInt)
  {
    i locali = this.d;
    if (locali == null)
    {
      this.q.add(new n(this, paramInt));
      return;
    }
    a(paramInt / locali.b());
  }
  
  public final void a(boolean paramBoolean)
  {
    com.airbnb.lottie.d.c localc = this.b;
    if (!paramBoolean) {}
    for (int i1 = 0;; i1 = -1)
    {
      localc.setRepeatCount(i1);
      return;
    }
  }
  
  public final boolean a(i parami)
  {
    if (this.d != parami)
    {
      a();
      this.e = null;
      this.j = null;
      invalidateSelf();
      this.d = parami;
      c(this.s);
      d(this.m);
      e();
      b();
      if (this.e != null)
      {
        localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          p localp = (p)localIterator.next();
          this.e.a(null, null, localp.a);
        }
      }
      Iterator localIterator = new ArrayList(this.q).iterator();
      while (localIterator.hasNext())
      {
        ((q)localIterator.next()).a();
        localIterator.remove();
      }
      this.q.clear();
      parami.a(this.l);
      parami = this.b;
      parami.b(parami.d);
      return true;
    }
    return false;
  }
  
  final void b()
  {
    Object localObject1 = this.d;
    Object localObject2 = ((i)localObject1).a;
    localObject1 = new g(Collections.emptyList(), (i)localObject1, "root", -1L, com.airbnb.lottie.c.c.i.c, -1L, null, Collections.emptyList(), new com.airbnb.lottie.c.a.w(new com.airbnb.lottie.c.a.l(), new com.airbnb.lottie.c.a.l(), new com.airbnb.lottie.c.a.p(), com.airbnb.lottie.c.a.d.a(), new com.airbnb.lottie.c.a.i(), com.airbnb.lottie.c.a.d.a(), com.airbnb.lottie.c.a.d.a(), (byte)0), 0, 0, 0, 0.0F, 0.0F, ((Rect)localObject2).width(), ((Rect)localObject2).height(), null, null, Collections.emptyList(), j.c, null, (byte)0);
    localObject2 = this.d;
    this.e = new com.airbnb.lottie.c.c.d(this, (g)localObject1, ((i)localObject2).h, (i)localObject2);
  }
  
  public final void b(float paramFloat)
  {
    com.airbnb.lottie.d.c localc = this.b;
    localc.b = paramFloat;
    localc.a(localc.c, paramFloat);
  }
  
  public final void b(int paramInt)
  {
    i locali = this.d;
    if (locali == null)
    {
      this.q.add(new o(this, paramInt));
      return;
    }
    b(paramInt / locali.b());
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.e == null)
    {
      this.q.add(new m(this, paramBoolean));
      return;
    }
    if (!paramBoolean)
    {
      com.airbnb.lottie.d.c localc = this.b;
      float f1 = localc.d;
      localc.start();
      localc.a(f1);
      return;
    }
    this.b.start();
  }
  
  public final void c(float paramFloat)
  {
    this.s = paramFloat;
    Object localObject = this.b;
    if (paramFloat < 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.airbnb.lottie.d.c)localObject).a = bool;
      ((com.airbnb.lottie.d.c)localObject).a(((com.airbnb.lottie.d.c)localObject).c, ((com.airbnb.lottie.d.c)localObject).b);
      localObject = this.d;
      if (localObject != null) {
        this.b.setDuration(((float)((i)localObject).a() / Math.abs(paramFloat)));
      }
      return;
    }
  }
  
  public final boolean c()
  {
    return (this.o == null) && (this.d.b.b() > 0);
  }
  
  public final void d()
  {
    this.q.clear();
    this.b.cancel();
  }
  
  public final void d(float paramFloat)
  {
    this.m = paramFloat;
    e();
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f2;
    if (this.e != null)
    {
      f1 = this.m;
      f2 = Math.min(paramCanvas.getWidth() / this.d.a.width(), paramCanvas.getHeight() / this.d.a.height());
      if (f1 <= f2) {
        break label200;
      }
    }
    for (float f1 = this.m / f2;; f1 = 1.0F)
    {
      if (f1 > 1.0F)
      {
        paramCanvas.save();
        float f3 = this.d.a.width() / 2.0F;
        float f4 = this.d.a.height() / 2.0F;
        float f5 = f3 * f2;
        float f6 = f4 * f2;
        float f7 = this.m;
        paramCanvas.translate(f3 * f7 - f5, f4 * f7 - f6);
        paramCanvas.scale(f1, f1, f5, f6);
      }
      this.r.reset();
      this.r.preScale(f2, f2);
      this.e.a(paramCanvas, this.r, this.p);
      d.a();
      if (f1 > 1.0F) {
        paramCanvas.restore();
      }
      return;
      label200:
      f2 = f1;
    }
  }
  
  public int getAlpha()
  {
    return this.p;
  }
  
  public int getIntrinsicHeight()
  {
    i locali = this.d;
    if (locali != null) {
      return (int)(locali.a.height() * this.m);
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    i locali = this.d;
    if (locali != null) {
      return (int)(locali.a.width() * this.m);
    }
    return -1;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public void invalidateSelf()
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null) {
      localCallback.invalidateDrawable(this);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    throw new UnsupportedOperationException("Use addColorFilter instead.");
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */