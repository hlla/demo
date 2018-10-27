package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ac;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public final class az
{
  private static final Interpolator w = new ba();
  public View a;
  public int b;
  public int c;
  public float[] d;
  public float[] e;
  public float[] f;
  public float[] g;
  public float h;
  public int i;
  public int j;
  private int k = -1;
  private final bc l;
  private int[] m;
  private int[] n;
  private int[] o;
  private float p;
  private final ViewGroup q;
  private int r;
  private boolean s;
  private OverScroller t;
  private final Runnable u = new bb(this);
  private VelocityTracker v;
  
  private az(Context paramContext, ViewGroup paramViewGroup, bc parambc)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (parambc != null)
    {
      this.q = paramViewGroup;
      this.l = parambc;
      paramViewGroup = ViewConfiguration.get(paramContext);
      this.c = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
      this.i = paramViewGroup.getScaledTouchSlop();
      this.p = paramViewGroup.getScaledMaximumFlingVelocity();
      this.h = paramViewGroup.getScaledMinimumFlingVelocity();
      this.t = new OverScroller(paramContext, w);
      return;
    }
    throw new IllegalArgumentException("Callback may not be null");
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 >= paramFloat2)
    {
      if (f1 > paramFloat3)
      {
        paramFloat2 = paramFloat3;
        if (paramFloat1 <= 0.0F) {
          paramFloat2 = -paramFloat3;
        }
        return paramFloat2;
      }
      return paramFloat1;
    }
    return 0.0F;
  }
  
  private final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 0)
    {
      int i1 = this.q.getWidth();
      float f1 = i1 / 2;
      float f2 = (float)Math.sin((Math.min(1.0F, Math.abs(paramInt1) / i1) - 0.5F) * 0.47123894F);
      paramInt2 = Math.abs(paramInt2);
      if (paramInt2 > 0) {}
      for (paramInt1 = Math.round(Math.abs((f2 * f1 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
        return Math.min(paramInt1, 600);
      }
    }
    return 0;
  }
  
  public static az a(ViewGroup paramViewGroup, float paramFloat, bc parambc)
  {
    paramViewGroup = a(paramViewGroup, parambc);
    paramViewGroup.i = ((int)(paramViewGroup.i * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static az a(ViewGroup paramViewGroup, bc parambc)
  {
    return new az(paramViewGroup.getContext(), paramViewGroup, parambc);
  }
  
  private final void a(float paramFloat1, float paramFloat2)
  {
    this.s = true;
    this.l.a(this.a, paramFloat1, paramFloat2);
    this.s = false;
    if (this.b == 1) {
      b(0);
    }
  }
  
  private final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i2 = 0;
    Object localObject2 = this.d;
    if ((localObject2 == null) || (localObject2.length <= paramInt))
    {
      i1 = paramInt + 1;
      localObject1 = new float[i1];
      float[] arrayOfFloat1 = new float[i1];
      float[] arrayOfFloat2 = new float[i1];
      float[] arrayOfFloat3 = new float[i1];
      int[] arrayOfInt1 = new int[i1];
      int[] arrayOfInt2 = new int[i1];
      int[] arrayOfInt3 = new int[i1];
      if (localObject2 != null)
      {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        localObject2 = this.e;
        System.arraycopy(localObject2, 0, arrayOfFloat1, 0, localObject2.length);
        localObject2 = this.f;
        System.arraycopy(localObject2, 0, arrayOfFloat2, 0, localObject2.length);
        localObject2 = this.g;
        System.arraycopy(localObject2, 0, arrayOfFloat3, 0, localObject2.length);
        localObject2 = this.o;
        System.arraycopy(localObject2, 0, arrayOfInt1, 0, localObject2.length);
        localObject2 = this.m;
        System.arraycopy(localObject2, 0, arrayOfInt2, 0, localObject2.length);
        localObject2 = this.n;
        System.arraycopy(localObject2, 0, arrayOfInt3, 0, localObject2.length);
      }
      this.d = ((float[])localObject1);
      this.e = arrayOfFloat1;
      this.f = arrayOfFloat2;
      this.g = arrayOfFloat3;
      this.o = arrayOfInt1;
      this.m = arrayOfInt2;
      this.n = arrayOfInt3;
    }
    Object localObject1 = this.d;
    this.f[paramInt] = paramFloat1;
    localObject1[paramInt] = paramFloat1;
    localObject1 = this.e;
    this.g[paramInt] = paramFloat2;
    localObject1[paramInt] = paramFloat2;
    localObject1 = this.o;
    int i4 = (int)paramFloat1;
    int i3 = (int)paramFloat2;
    if (i4 < this.q.getLeft() + this.c) {
      i2 = 1;
    }
    int i1 = i2;
    if (i3 < this.q.getTop() + this.c) {
      i1 = i2 | 0x4;
    }
    i2 = i1;
    if (i4 > this.q.getRight() - this.c) {
      i2 = i1 | 0x2;
    }
    i1 = i2;
    if (i3 > this.q.getBottom() - this.c) {
      i1 = i2 | 0x8;
    }
    localObject1[paramInt] = i1;
    this.r |= 1 << paramInt;
  }
  
  private final boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    boolean bool1 = bool2;
    if ((this.o[paramInt1] & paramInt2) == paramInt2)
    {
      bool1 = bool2;
      if ((this.j & paramInt2) != 0)
      {
        bool1 = bool2;
        if ((this.n[paramInt1] & paramInt2) != paramInt2)
        {
          paramInt1 = this.m[paramInt1] & paramInt2;
          bool1 = bool2;
          if (paramInt1 != paramInt2)
          {
            float f1 = this.i;
            if (paramFloat1 <= f1)
            {
              bool1 = bool2;
              if (paramFloat2 <= f1) {}
            }
            else
            {
              bool1 = bool2;
              if (paramInt1 == 0)
              {
                bool1 = bool2;
                if (paramFloat1 > f1) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.a.getLeft();
    int i2 = this.a.getTop();
    paramInt1 -= i1;
    paramInt2 -= i2;
    if (paramInt1 != 0) {}
    while (paramInt2 != 0)
    {
      Object localObject = this.a;
      paramInt3 = b(paramInt3, (int)this.h, (int)this.p);
      paramInt4 = b(paramInt4, (int)this.h, (int)this.p);
      int i3 = Math.abs(paramInt1);
      int i4 = Math.abs(paramInt2);
      int i5 = Math.abs(paramInt3);
      int i6 = Math.abs(paramInt4);
      int i7 = i5 + i6;
      int i8 = i3 + i4;
      if (paramInt3 == 0) {}
      for (float f1 = i3 / i8;; f1 = i5 / i7)
      {
        if (paramInt4 == 0) {}
        for (float f2 = i4 / i8;; f2 = i6 / i7)
        {
          paramInt3 = a(paramInt1, paramInt3, this.l.a((View)localObject));
          paramInt4 = a(paramInt2, paramInt4, this.l.a());
          localObject = this.t;
          float f3 = paramInt3;
          ((OverScroller)localObject).startScroll(i1, i2, paramInt1, paramInt2, (int)(f2 * paramInt4 + f1 * f3));
          b(2);
          return true;
        }
      }
    }
    this.t.abortAnimation();
    b(0);
    return false;
  }
  
  private final boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView != null)
    {
      int i2 = this.l.a(paramView);
      if (this.l.a() <= 0) {}
      for (int i1 = 0;; i1 = 1)
      {
        if (i2 <= 0) {
          if (i2 > 0) {
            if (Math.abs(paramFloat1) <= this.i) {}
          }
        }
        do
        {
          do
          {
            return true;
            return false;
            if (i1 == 0) {
              break;
            }
          } while (Math.abs(paramFloat2) > this.i);
          return false;
          return false;
          if (i1 == 0) {
            break;
          }
          i1 = this.i;
        } while (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > i1 * i1);
        return false;
      }
    }
    return false;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = Math.abs(paramInt1);
    if (i1 >= paramInt2)
    {
      if (i1 > paramInt3)
      {
        paramInt2 = paramInt3;
        if (paramInt1 <= 0) {
          paramInt2 = -paramInt3;
        }
        return paramInt2;
      }
      return paramInt1;
    }
    return 0;
  }
  
  private final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  private final boolean b(View paramView, int paramInt)
  {
    if (paramView != this.a) {}
    while (this.k != paramInt)
    {
      if ((paramView != null) && (this.l.a(paramView, paramInt)))
      {
        this.k = paramInt;
        a(paramView, paramInt);
        return true;
      }
      return false;
    }
    return true;
  }
  
  private final void c()
  {
    this.v.computeCurrentVelocity(1000, this.p);
    a(a(this.v.getXVelocity(this.k), this.h, this.p), a(this.v.getYVelocity(this.k), this.h, this.p));
  }
  
  private final void c(int paramInt)
  {
    if ((this.d != null) && (a(paramInt)))
    {
      this.d[paramInt] = 0.0F;
      this.e[paramInt] = 0.0F;
      this.f[paramInt] = 0.0F;
      this.g[paramInt] = 0.0F;
      this.o[paramInt] = 0;
      this.m[paramInt] = 0;
      this.n[paramInt] = 0;
      this.r &= (1 << paramInt ^ 0xFFFFFFFF);
    }
  }
  
  private final void c(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getPointerCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramMotionEvent.getPointerId(i1);
      if (d(i3))
      {
        float f1 = paramMotionEvent.getX(i1);
        float f2 = paramMotionEvent.getY(i1);
        this.f[i3] = f1;
        this.g[i3] = f2;
      }
      i1 += 1;
    }
  }
  
  private final boolean d(int paramInt)
  {
    if (!a(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Ignoring pointerId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" because ACTION_DOWN was not received ");
      localStringBuilder.append("for this pointer before ACTION_MOVE. It likely happened because ");
      localStringBuilder.append(" ViewDragHelper did not receive all the events in the event stream.");
      Log.e("ViewDragHelper", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public final void a()
  {
    this.k = -1;
    Object localObject = this.d;
    if (localObject != null)
    {
      Arrays.fill((float[])localObject, 0.0F);
      Arrays.fill(this.e, 0.0F);
      Arrays.fill(this.f, 0.0F);
      Arrays.fill(this.g, 0.0F);
      Arrays.fill(this.o, 0);
      Arrays.fill(this.m, 0);
      Arrays.fill(this.n, 0);
      this.r = 0;
    }
    localObject = this.v;
    if (localObject != null)
    {
      ((VelocityTracker)localObject).recycle();
      this.v = null;
    }
  }
  
  public final void a(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.q)
    {
      paramView = new StringBuilder();
      paramView.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
      paramView.append(this.q);
      paramView.append(")");
      throw new IllegalArgumentException(paramView.toString());
    }
    this.a = paramView;
    this.k = paramInt;
    this.l.b(paramView, paramInt);
    b(1);
  }
  
  public final boolean a(int paramInt)
  {
    return (this.r & 1 << paramInt) != 0;
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    if (!this.s) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return a(paramInt1, paramInt2, (int)this.v.getXVelocity(this.k), (int)this.v.getYVelocity(this.k));
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getActionMasked();
    int i1 = paramMotionEvent.getActionIndex();
    if (i2 == 0) {
      a();
    }
    if (this.v == null) {
      this.v = VelocityTracker.obtain();
    }
    this.v.addMovement(paramMotionEvent);
    switch (i2)
    {
    }
    for (;;)
    {
      return this.b == 1;
      c(paramMotionEvent.getPointerId(i1));
      continue;
      i2 = paramMotionEvent.getPointerId(i1);
      float f1 = paramMotionEvent.getX(i1);
      float f2 = paramMotionEvent.getY(i1);
      a(f1, f2, i2);
      i1 = this.b;
      if (i1 == 0)
      {
        if ((this.o[i2] & this.j) != 0) {
          this.l.d();
        }
      }
      else if (i1 == 2)
      {
        paramMotionEvent = b((int)f1, (int)f2);
        if (paramMotionEvent == this.a)
        {
          b(paramMotionEvent, i2);
          continue;
          if ((this.d != null) && (this.e != null))
          {
            int i3 = paramMotionEvent.getPointerCount();
            i2 = 0;
            int i4;
            float f3;
            float f4;
            View localView;
            if (i2 < i3)
            {
              i4 = paramMotionEvent.getPointerId(i2);
              if (!d(i4)) {
                break label446;
              }
              f1 = paramMotionEvent.getX(i2);
              f2 = paramMotionEvent.getY(i2);
              f3 = f1 - this.d[i4];
              f4 = f2 - this.e[i4];
              localView = b((int)f1, (int)f2);
              if (localView == null) {
                break label500;
              }
              if (!a(localView, f3, f4)) {
                break label494;
              }
              i1 = 1;
            }
            for (;;)
            {
              int i5;
              int i6;
              int i7;
              int i8;
              int i9;
              int i10;
              if (i1 != 0)
              {
                i5 = localView.getLeft();
                i6 = this.l.c(localView, (int)f3 + i5);
                i7 = localView.getTop();
                i8 = this.l.d(localView, (int)f4 + i7);
                i9 = this.l.a(localView);
                i10 = this.l.a();
                if (i9 != 0) {
                  break label479;
                }
              }
              for (;;)
              {
                if (i10 == 0)
                {
                  label410:
                  c(paramMotionEvent);
                  break;
                }
                if (i10 <= 0) {}
                label446:
                label479:
                do
                {
                  do
                  {
                    b(f3, f4, i4);
                    if (this.b == 1) {
                      break label410;
                    }
                    if (i1 == 0) {}
                    while (!b(localView, i4))
                    {
                      i2 += 1;
                      break;
                    }
                    break label410;
                  } while (i8 != i7);
                  break label410;
                } while ((i9 <= 0) || (i6 != i5));
              }
              label494:
              i1 = 0;
              continue;
              label500:
              i1 = 0;
            }
            a();
            continue;
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            i1 = paramMotionEvent.getPointerId(0);
            a(f1, f2, i1);
            paramMotionEvent = b((int)f1, (int)f2);
            if ((paramMotionEvent == this.a) && (this.b == 2)) {
              b(paramMotionEvent, i1);
            }
            if ((this.o[i1] & this.j) != 0) {
              this.l.d();
            }
          }
        }
      }
    }
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2)
  {
    this.a = paramView;
    this.k = -1;
    boolean bool = a(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.b == 0) && (this.a != null)) {
      this.a = null;
    }
    return bool;
  }
  
  public final View b(int paramInt1, int paramInt2)
  {
    int i1 = this.q.getChildCount() - 1;
    if (i1 >= 0)
    {
      View localView = this.q.getChildAt(i1);
      if (paramInt1 < localView.getLeft()) {}
      while ((paramInt1 >= localView.getRight()) || (paramInt2 < localView.getTop()) || (paramInt2 >= localView.getBottom()))
      {
        i1 -= 1;
        break;
      }
      return localView;
    }
    return null;
  }
  
  final void b(int paramInt)
  {
    this.q.removeCallbacks(this.u);
    if (this.b != paramInt)
    {
      this.b = paramInt;
      this.l.a(paramInt);
      if (this.b == 0) {
        this.a = null;
      }
    }
  }
  
  public final void b(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    int i1 = 0;
    int i4 = paramMotionEvent.getActionMasked();
    int i3 = paramMotionEvent.getActionIndex();
    if (i4 == 0) {
      a();
    }
    if (this.v == null) {
      this.v = VelocityTracker.obtain();
    }
    this.v.addMovement(paramMotionEvent);
    switch (i4)
    {
    case 4: 
    default: 
    case 0: 
    case 6: 
    case 5: 
    case 3: 
    case 2: 
      label259:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              f1 = paramMotionEvent.getX();
              f2 = paramMotionEvent.getY();
              i1 = paramMotionEvent.getPointerId(0);
              paramMotionEvent = b((int)f1, (int)f2);
              a(f1, f2, i1);
              b(paramMotionEvent, i1);
            } while ((this.o[i1] & this.j) == 0);
            this.l.d();
            return;
            i2 = paramMotionEvent.getPointerId(i3);
            if ((this.b == 1) && (i2 == this.k))
            {
              i3 = paramMotionEvent.getPointerCount();
              if (i1 < i3)
              {
                i4 = paramMotionEvent.getPointerId(i1);
                View localView;
                if (i4 != this.k)
                {
                  f1 = paramMotionEvent.getX(i1);
                  f2 = paramMotionEvent.getY(i1);
                  localObject = b((int)f1, (int)f2);
                  localView = this.a;
                  if (localObject == localView) {
                    break label259;
                  }
                }
                while (!b(localView, i4))
                {
                  i1 += 1;
                  break;
                }
                if (this.k != -1) {}
              }
              else
              {
                c();
              }
            }
            c(i2);
            return;
            i1 = paramMotionEvent.getPointerId(i3);
            f1 = paramMotionEvent.getX(i3);
            f2 = paramMotionEvent.getY(i3);
            a(f1, f2, i1);
            if (this.b != 0) {
              break;
            }
            b(b((int)f1, (int)f2), i1);
          } while ((this.o[i1] & this.j) == 0);
          this.l.d();
          return;
          i2 = (int)f1;
          i3 = (int)f2;
          paramMotionEvent = this.a;
        } while ((paramMotionEvent == null) || (i2 < paramMotionEvent.getLeft()) || (i2 >= paramMotionEvent.getRight()) || (i3 < paramMotionEvent.getTop()) || (i3 >= paramMotionEvent.getBottom()));
        b(this.a, i1);
        return;
        if (this.b == 1) {
          a(0.0F, 0.0F);
        }
        a();
        return;
        if (this.b != 1) {
          break;
        }
      } while (!d(this.k));
      i1 = paramMotionEvent.findPointerIndex(this.k);
      float f1 = paramMotionEvent.getX(i1);
      float f2 = paramMotionEvent.getY(i1);
      Object localObject = this.f;
      i1 = this.k;
      i4 = (int)(f1 - localObject[i1]);
      int i5 = (int)(f2 - this.g[i1]);
      i2 = this.a.getLeft() + i4;
      i3 = this.a.getTop() + i5;
      int i7 = this.a.getLeft();
      int i6 = this.a.getTop();
      i1 = i2;
      if (i4 != 0)
      {
        i1 = this.l.c(this.a, i2);
        ac.f(this.a, i1 - i7);
      }
      i2 = i3;
      if (i5 != 0)
      {
        i2 = this.l.d(this.a, i3);
        ac.e(this.a, i2 - i6);
      }
      if (i4 != 0) {}
      for (;;)
      {
        this.l.a(this.a, i1, i2);
        do
        {
          c(paramMotionEvent);
          return;
        } while (i5 == 0);
      }
      i3 = paramMotionEvent.getPointerCount();
      i1 = i2;
      if (i1 < i3)
      {
        i2 = paramMotionEvent.getPointerId(i1);
        if (d(i2))
        {
          f1 = paramMotionEvent.getX(i1);
          f2 = paramMotionEvent.getY(i1);
          float f3 = f1 - this.d[i2];
          float f4 = f2 - this.e[i2];
          b(f3, f4, i2);
          if (this.b == 1) {
            break label804;
          }
          localObject = b((int)f1, (int)f2);
          if (a((View)localObject, f3, f4)) {
            break label793;
          }
        }
        label793:
        while (!b((View)localObject, i2))
        {
          i1 += 1;
          break;
        }
      }
      label804:
      c(paramMotionEvent);
      return;
    }
    if (this.b == 1) {
      c();
    }
    a();
  }
  
  public final boolean b()
  {
    boolean bool;
    int i1;
    int i2;
    int i4;
    if (this.b == 2)
    {
      bool = this.t.computeScrollOffset();
      i1 = this.t.getCurrX();
      i2 = this.t.getCurrY();
      int i3 = i1 - this.a.getLeft();
      i4 = i2 - this.a.getTop();
      if (i3 != 0) {
        ac.f(this.a, i3);
      }
      if (i4 != 0) {
        ac.e(this.a, i4);
      }
      if (i3 == 0) {
        break label163;
      }
    }
    for (;;)
    {
      this.l.a(this.a, i1, i2);
      label163:
      do
      {
        if ((bool) && (i1 == this.t.getFinalX()) && (i2 == this.t.getFinalY())) {
          this.t.abortAnimation();
        }
        for (;;)
        {
          this.q.post(this.u);
          do
          {
            return this.b == 2;
          } while (bool);
        }
      } while (i4 == 0);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */