package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

final class h
  implements g
{
  private static final int h = ViewConfiguration.getDoubleTapTimeout();
  private static final int i = ;
  private static final int j = ViewConfiguration.getTapTimeout();
  public MotionEvent a;
  public boolean b;
  public GestureDetector.OnDoubleTapListener c;
  public final Handler d = new i(this);
  public boolean e;
  public final GestureDetector.OnGestureListener f;
  public boolean g;
  private boolean k;
  private boolean l;
  private int m;
  private float n;
  private float o;
  private boolean p;
  private boolean q;
  private float r;
  private float s;
  private int t;
  private int u;
  private MotionEvent v;
  private int w;
  private VelocityTracker x;
  
  h(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.f = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      this.c = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null");
    }
    if (this.f == null) {
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    this.q = true;
    paramContext = ViewConfiguration.get(paramContext);
    int i1 = paramContext.getScaledTouchSlop();
    int i2 = paramContext.getScaledDoubleTapSlop();
    this.u = paramContext.getScaledMinimumFlingVelocity();
    this.t = paramContext.getScaledMaximumFlingVelocity();
    this.w = (i1 * i1);
    this.m = (i2 * i2);
  }
  
  public final void a()
  {
    this.q = true;
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (this.x == null) {
      this.x = VelocityTracker.obtain();
    }
    this.x.addMovement(paramMotionEvent);
    int i5 = i1 & 0xFF;
    if (i5 == 6) {}
    label355:
    int i2;
    for (i1 = paramMotionEvent.getActionIndex();; i2 = -1)
    {
      int i4 = paramMotionEvent.getPointerCount();
      int i3 = 0;
      float f1 = 0.0F;
      float f3;
      for (float f2 = 0.0F;; f2 = f3)
      {
        if (i3 >= i4)
        {
          if (i5 == 6) {}
          for (i1 = i4 - 1;; i2 = i4)
          {
            f3 = i1;
            f2 /= f3;
            f1 /= f3;
            boolean bool2;
            Object localObject;
            switch (i5)
            {
            case 4: 
            default: 
            case 5: 
            case 6: 
            case 0: 
            case 3: 
            case 2: 
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return false;
                      this.r = f2;
                      this.n = f2;
                      this.s = f1;
                      this.o = f1;
                      this.d.removeMessages(1);
                      this.d.removeMessages(2);
                      this.d.removeMessages(3);
                      this.p = false;
                      this.l = false;
                      this.k = false;
                      this.b = false;
                    } while (!this.e);
                    this.e = false;
                    return false;
                    this.r = f2;
                    this.n = f2;
                    this.s = f1;
                    this.o = f1;
                    this.x.computeCurrentVelocity(1000, this.t);
                    i3 = paramMotionEvent.getActionIndex();
                    i1 = paramMotionEvent.getPointerId(i3);
                    f1 = this.x.getXVelocity(i1);
                    f2 = this.x.getYVelocity(i1);
                    i1 = 0;
                    while (i1 < i4)
                    {
                      if (i1 != i3)
                      {
                        i5 = paramMotionEvent.getPointerId(i1);
                        f3 = this.x.getXVelocity(i5);
                        if (this.x.getYVelocity(i5) * f2 + f3 * f1 < 0.0F) {
                          break label355;
                        }
                      }
                      i1 += 1;
                    }
                    this.x.clear();
                    return false;
                    if (this.c != null)
                    {
                      bool2 = this.d.hasMessages(3);
                      if (bool2) {
                        this.d.removeMessages(3);
                      }
                      localMotionEvent = this.a;
                      if (localMotionEvent != null)
                      {
                        localObject = this.v;
                        if (localObject != null) {}
                      }
                      else
                      {
                        this.d.sendEmptyMessageDelayed(3, h);
                        i1 = 0;
                      }
                    }
                    for (;;)
                    {
                      this.r = f2;
                      this.n = f2;
                      this.s = f1;
                      this.o = f1;
                      localMotionEvent = this.a;
                      if (localMotionEvent != null) {
                        localMotionEvent.recycle();
                      }
                      this.a = MotionEvent.obtain(paramMotionEvent);
                      this.l = true;
                      this.k = true;
                      this.g = true;
                      this.e = false;
                      this.b = false;
                      if (this.q)
                      {
                        this.d.removeMessages(2);
                        this.d.sendEmptyMessageAtTime(2, this.a.getDownTime() + j + i);
                      }
                      this.d.sendEmptyMessageAtTime(1, this.a.getDownTime() + j);
                      return this.f.onDown(paramMotionEvent) | i1;
                      if ((!bool2) || (!this.k) || (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() > h)) {
                        break;
                      }
                      i1 = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
                      i3 = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
                      if (i1 * i1 + i3 * i3 >= this.m) {
                        break;
                      }
                      this.p = true;
                      boolean bool1 = this.c.onDoubleTap(this.a) | this.c.onDoubleTapEvent(paramMotionEvent);
                      continue;
                      bool1 = false;
                    }
                    this.d.removeMessages(1);
                    this.d.removeMessages(2);
                    this.d.removeMessages(3);
                    this.x.recycle();
                    this.x = null;
                    this.p = false;
                    this.g = false;
                    this.l = false;
                    this.k = false;
                    this.b = false;
                  } while (!this.e);
                  this.e = false;
                  return false;
                } while (this.e);
                f3 = this.r - f2;
                f4 = this.s - f1;
                if (this.p) {
                  return this.c.onDoubleTapEvent(paramMotionEvent);
                }
                if (this.l)
                {
                  i2 = (int)(f2 - this.n);
                  i3 = (int)(f1 - this.o);
                  i2 = i2 * i2 + i3 * i3;
                  if (i2 > this.w)
                  {
                    bool2 = this.f.onScroll(this.a, paramMotionEvent, f3, f4);
                    this.r = f2;
                    this.s = f1;
                    this.l = false;
                    this.d.removeMessages(3);
                    this.d.removeMessages(1);
                    this.d.removeMessages(2);
                  }
                  for (;;)
                  {
                    if (i2 <= this.w) {
                      return bool2;
                    }
                    this.k = false;
                    return bool2;
                    bool2 = false;
                  }
                }
              } while ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F));
              bool2 = this.f.onScroll(this.a, paramMotionEvent, f3, f4);
              this.r = f2;
              this.s = f1;
              return bool2;
            }
            this.g = false;
            MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
            if (this.p) {
              bool2 = this.c.onDoubleTapEvent(paramMotionEvent);
            }
            for (;;)
            {
              paramMotionEvent = this.v;
              if (paramMotionEvent != null) {
                paramMotionEvent.recycle();
              }
              this.v = localMotionEvent;
              paramMotionEvent = this.x;
              if (paramMotionEvent != null)
              {
                paramMotionEvent.recycle();
                this.x = null;
              }
              this.p = false;
              this.b = false;
              this.d.removeMessages(1);
              this.d.removeMessages(2);
              return bool2;
              if (this.e)
              {
                this.d.removeMessages(3);
                this.e = false;
                bool2 = false;
              }
              else if (this.l)
              {
                boolean bool3 = this.f.onSingleTapUp(paramMotionEvent);
                bool2 = bool3;
                if (this.b)
                {
                  localObject = this.c;
                  bool2 = bool3;
                  if (localObject != null)
                  {
                    ((GestureDetector.OnDoubleTapListener)localObject).onSingleTapConfirmed(paramMotionEvent);
                    bool2 = bool3;
                  }
                }
              }
              else
              {
                localObject = this.x;
                i2 = paramMotionEvent.getPointerId(0);
                ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.t);
                f1 = ((VelocityTracker)localObject).getYVelocity(i2);
                f2 = ((VelocityTracker)localObject).getXVelocity(i2);
                if ((Math.abs(f1) > this.u) || (Math.abs(f2) > this.u)) {
                  bool2 = this.f.onFling(this.a, paramMotionEvent, f2, f1);
                } else {
                  bool2 = false;
                }
              }
            }
          }
        }
        float f4 = f1;
        f3 = f2;
        if (i2 != i3)
        {
          f3 = f2 + paramMotionEvent.getX(i3);
          f4 = f1 + paramMotionEvent.getY(i3);
        }
        i3 += 1;
        f1 = f4;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */