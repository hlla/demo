package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

final class v
  extends u.e
{
  static final Handler ji = new Handler(Looper.getMainLooper());
  boolean lp;
  private final int[] lq = new int[2];
  private final float[] lr = new float[2];
  int ls = 200;
  u.e.a lt;
  u.e.b lu;
  float lv;
  final Runnable lw = new Runnable()
  {
    public final void run()
    {
      v localv = v.this;
      if (localv.lp)
      {
        float f2 = (float)(SystemClock.uptimeMillis() - localv.mStartTime) / localv.ls;
        float f1 = f2;
        if (localv.mInterpolator != null) {
          f1 = localv.mInterpolator.getInterpolation(f2);
        }
        localv.lv = f1;
        if (localv.lu != null) {
          localv.lu.au();
        }
        if (SystemClock.uptimeMillis() >= localv.mStartTime + localv.ls)
        {
          localv.lp = false;
          if (localv.lt != null) {
            localv.lt.onAnimationEnd();
          }
        }
      }
      if (localv.lp) {
        v.ji.postDelayed(localv.lw, 10L);
      }
    }
  };
  Interpolator mInterpolator;
  long mStartTime;
  
  public final void a(u.e.a parama)
  {
    this.lt = parama;
  }
  
  public final void a(u.e.b paramb)
  {
    this.lu = paramb;
  }
  
  public final int aw()
  {
    return a.a(this.lq[0], this.lq[1], this.lv);
  }
  
  public final float ax()
  {
    return a.b(this.lr[0], this.lr[1], this.lv);
  }
  
  public final void cancel()
  {
    this.lp = false;
    ji.removeCallbacks(this.lw);
  }
  
  public final void e(float paramFloat1, float paramFloat2)
  {
    this.lr[0] = paramFloat1;
    this.lr[1] = paramFloat2;
  }
  
  public final void e(int paramInt1, int paramInt2)
  {
    this.lq[0] = paramInt1;
    this.lq[1] = paramInt2;
  }
  
  public final float getAnimatedFraction()
  {
    return this.lv;
  }
  
  public final long getDuration()
  {
    return this.ls;
  }
  
  public final boolean isRunning()
  {
    return this.lp;
  }
  
  public final void setDuration(int paramInt)
  {
    this.ls = paramInt;
  }
  
  public final void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public final void start()
  {
    if (this.lp) {
      return;
    }
    if (this.mInterpolator == null) {
      this.mInterpolator = new AccelerateDecelerateInterpolator();
    }
    this.mStartTime = SystemClock.uptimeMillis();
    this.lp = true;
    ji.postDelayed(this.lw, 10L);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */