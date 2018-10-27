package android.support.v7.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.ac;
import android.view.MotionEvent;
import java.util.ArrayList;

final class ca
  extends fe
  implements fl
{
  private static final int[] p = new int[0];
  private static final int[] q = { 16842919 };
  private final fm A = new cc(this);
  private float B;
  private final int[] C = new int[2];
  private final int D;
  private final int E;
  public int a = 0;
  public int b;
  public int c;
  public boolean d = false;
  public boolean e = false;
  public RecyclerView f;
  public int g = 0;
  public int h = 0;
  public final int i;
  public final ValueAnimator j = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  public int k = 0;
  public int l;
  public final StateListDrawable m;
  public int n;
  public final Drawable o;
  private int r = 0;
  private final Runnable s = new cb(this);
  private float t;
  private final int[] u = new int[2];
  private final StateListDrawable v;
  private final int w;
  private final Drawable x;
  private final int y;
  private final int z;
  
  ca(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.m = paramStateListDrawable1;
    this.o = paramDrawable1;
    this.v = paramStateListDrawable2;
    this.x = paramDrawable2;
    this.D = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.E = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.w = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.y = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.i = paramInt2;
    this.z = paramInt3;
    this.m.setAlpha(255);
    this.o.setAlpha(255);
    this.j.addListener(new cd(this));
    this.j.addUpdateListener(new ce(this));
    paramStateListDrawable1 = this.f;
    if (paramStateListDrawable1 != paramRecyclerView)
    {
      if (paramStateListDrawable1 != null)
      {
        paramStateListDrawable1.b(this);
        paramStateListDrawable1 = this.f;
        paramStateListDrawable1.y.remove(this);
        if (paramStateListDrawable1.f == this) {
          paramStateListDrawable1.f = null;
        }
        this.f.b(this.A);
        d();
      }
      this.f = paramRecyclerView;
      paramRecyclerView = this.f;
      if (paramRecyclerView != null)
      {
        paramStateListDrawable1 = paramRecyclerView.u;
        if (paramStateListDrawable1 != null) {
          paramStateListDrawable1.a("Cannot add item decoration during a scroll  or layout");
        }
        if (paramRecyclerView.r.isEmpty()) {
          paramRecyclerView.setWillNotDraw(false);
        }
        paramRecyclerView.r.add(this);
        paramRecyclerView.n();
        paramRecyclerView.requestLayout();
        this.f.y.add(this);
        this.f.a(this.A);
      }
    }
  }
  
  private static int a(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (i1 != 0)
    {
      paramInt3 = paramInt1 - paramInt3;
      paramInt1 = (int)((paramFloat2 - paramFloat1) / i1 * paramInt3);
      paramInt2 += paramInt1;
      if ((paramInt2 >= paramInt3) || (paramInt2 < 0)) {
        paramInt1 = 0;
      }
      return paramInt1;
    }
    return 0;
  }
  
  private final boolean a(float paramFloat1, float paramFloat2)
  {
    if (!b()) {
      if (paramFloat1 < this.h - this.D) {}
    }
    for (;;)
    {
      int i1 = this.l;
      int i2 = this.n / 2;
      if ((paramFloat2 >= i1 - i2) && (paramFloat2 <= i1 + i2)) {
        return true;
      }
      do
      {
        return false;
      } while (paramFloat1 > this.D / 2);
    }
  }
  
  private final void b(int paramInt)
  {
    d();
    this.f.postDelayed(this.s, paramInt);
  }
  
  private final boolean b()
  {
    boolean bool = true;
    if (ac.h(this.f) != 1) {
      bool = false;
    }
    return bool;
  }
  
  private final boolean b(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= this.g - this.w)
    {
      int i1 = this.b;
      int i2 = this.c / 2;
      if ((paramFloat1 >= i1 - i2) && (paramFloat1 <= i1 + i2)) {
        return true;
      }
    }
    return false;
  }
  
  private final void c()
  {
    switch (this.a)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      this.j.cancel();
    }
    this.a = 1;
    ValueAnimator localValueAnimator = this.j;
    localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 1.0F });
    this.j.setDuration(500L);
    this.j.setStartDelay(0L);
    this.j.start();
  }
  
  private final void d()
  {
    this.f.removeCallbacks(this.s);
  }
  
  public final void a() {}
  
  final void a(int paramInt)
  {
    if ((paramInt == 2) && (this.k != 2))
    {
      this.m.setState(q);
      d();
    }
    if (paramInt == 0) {
      this.f.invalidate();
    }
    for (;;)
    {
      if (this.k != 2) {
        if (paramInt == 1) {
          b(1500);
        }
      }
      for (;;)
      {
        this.k = paramInt;
        return;
        if (paramInt == 2) {
          break;
        }
        this.m.setState(p);
        b(1200);
      }
      c();
    }
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, fw paramfw)
  {
    if ((this.h != this.f.getWidth()) || (this.g != this.f.getHeight()))
    {
      this.h = this.f.getWidth();
      this.g = this.f.getHeight();
      a(0);
    }
    for (;;)
    {
      return;
      if (this.a != 0)
      {
        if (!this.e) {}
        while (this.d)
        {
          int i2 = this.g;
          int i1 = this.w;
          i2 -= i1;
          int i4 = this.b;
          int i3 = this.c;
          i4 -= i3 / 2;
          this.v.setBounds(0, 0, i3, i1);
          this.x.setBounds(0, 0, this.h, this.y);
          paramCanvas.translate(0.0F, i2);
          this.x.draw(paramCanvas);
          paramCanvas.translate(i4, 0.0F);
          this.v.draw(paramCanvas);
          paramCanvas.translate(-i4, -i2);
          return;
          i2 = this.h;
          i1 = this.D;
          i2 -= i1;
          i4 = this.l;
          i3 = this.n;
          i4 -= i3 / 2;
          this.m.setBounds(0, 0, i1, i3);
          this.o.setBounds(0, 0, this.E, this.g);
          if (b())
          {
            this.o.draw(paramCanvas);
            paramCanvas.translate(this.D, i4);
            paramCanvas.scale(-1.0F, 1.0F);
            this.m.draw(paramCanvas);
            paramCanvas.scale(1.0F, 1.0F);
            paramCanvas.translate(-this.D, -i4);
          }
          else
          {
            paramCanvas.translate(i2, 0.0F);
            this.o.draw(paramCanvas);
            paramCanvas.translate(0.0F, i4);
            this.m.draw(paramCanvas);
            paramCanvas.translate(-i2, -i4);
          }
        }
      }
    }
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    int i1 = this.k;
    boolean bool3;
    if (i1 == 1)
    {
      bool1 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      bool3 = b(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (paramMotionEvent.getAction() != 0) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      if (bool1) {}
      while (bool3)
      {
        if (bool3)
        {
          this.r = 1;
          this.t = ((int)paramMotionEvent.getX());
        }
        for (;;)
        {
          a(2);
          bool1 = true;
          break;
          if (bool1)
          {
            this.r = 2;
            this.B = ((int)paramMotionEvent.getY());
          }
        }
      }
      bool1 = bool2;
      continue;
      if (i1 != 2) {
        bool1 = bool2;
      }
    }
  }
  
  public final void b(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    boolean bool2;
    if (this.k != 0)
    {
      if (paramMotionEvent.getAction() != 0) {
        break label104;
      }
      bool1 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      bool2 = b(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (!bool1) {
        break label96;
      }
      if (!bool2) {
        break label73;
      }
      this.r = 1;
      this.t = ((int)paramMotionEvent.getX());
    }
    label72:
    label73:
    label96:
    label104:
    float f1;
    do
    {
      do
      {
        do
        {
          do
          {
            break label72;
            break label72;
            for (;;)
            {
              a(2);
              return;
              if (bool1)
              {
                this.r = 2;
                this.B = ((int)paramMotionEvent.getY());
              }
            }
          } while (!bool2);
          break;
          if ((paramMotionEvent.getAction() == 1) && (this.k == 2))
          {
            this.B = 0.0F;
            this.t = 0.0F;
            a(1);
            this.r = 0;
            return;
          }
        } while ((paramMotionEvent.getAction() != 2) || (this.k != 2));
        c();
        if (this.r == 1)
        {
          f1 = paramMotionEvent.getX();
          int[] arrayOfInt = this.u;
          i1 = this.z;
          arrayOfInt[0] = i1;
          arrayOfInt[1] = (this.h - i1);
          f1 = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], f1));
          if (Math.abs(this.b - f1) >= 2.0F)
          {
            i1 = a(this.t, f1, arrayOfInt, this.f.computeHorizontalScrollRange(), this.f.computeHorizontalScrollOffset(), this.h);
            if (i1 != 0) {
              this.f.scrollBy(i1, 0);
            }
            this.t = f1;
          }
        }
      } while (this.r != 2);
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.C;
      i1 = this.z;
      paramMotionEvent[0] = i1;
      paramMotionEvent[1] = (this.g - i1);
      f1 = Math.max(paramMotionEvent[0], Math.min(paramMotionEvent[1], f1));
    } while (Math.abs(this.l - f1) < 2.0F);
    int i1 = a(this.B, f1, paramMotionEvent, this.f.computeVerticalScrollRange(), this.f.computeVerticalScrollOffset(), this.g);
    if (i1 != 0) {
      this.f.scrollBy(0, i1);
    }
    this.B = f1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */