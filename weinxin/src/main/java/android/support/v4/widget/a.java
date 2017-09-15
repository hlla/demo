package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a
  implements View.OnTouchListener
{
  private static final int AM = ;
  private float[] AA = { Float.MAX_VALUE, Float.MAX_VALUE };
  private int AB;
  private int AC;
  private float[] AD = { 0.0F, 0.0F };
  private float[] AE = { 0.0F, 0.0F };
  private float[] AF = { Float.MAX_VALUE, Float.MAX_VALUE };
  private boolean AG;
  public boolean AH;
  public boolean AI;
  public boolean AJ;
  private boolean AK;
  private boolean AL;
  public final a Ax = new a();
  private final Interpolator Ay = new AccelerateInterpolator();
  private float[] Az = { 0.0F, 0.0F };
  private Runnable lw;
  public final View nw;
  
  public a(View paramView)
  {
    this.nw = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * paramView.density + 0.5F);
    int j = (int)(paramView.density * 315.0F + 0.5F);
    float f = i;
    this.AF[0] = (f / 1000.0F);
    this.AF[1] = (f / 1000.0F);
    f = j;
    this.AE[0] = (f / 1000.0F);
    this.AE[1] = (f / 1000.0F);
    this.AB = 1;
    this.AA[0] = Float.MAX_VALUE;
    this.AA[1] = Float.MAX_VALUE;
    this.Az[0] = 0.2F;
    this.Az[1] = 0.2F;
    this.AD[0] = 0.001F;
    this.AD[1] = 0.001F;
    this.AC = AM;
    this.Ax.AN = 500;
    this.Ax.AO = 500;
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = d(this.Az[paramInt] * paramFloat2, 0.0F, this.AA[paramInt]);
    float f2 = g(paramFloat1, f1);
    paramFloat1 = g(paramFloat2 - paramFloat1, f1) - f2;
    if (paramFloat1 < 0.0F) {
      paramFloat1 = -this.Ay.getInterpolation(-paramFloat1);
    }
    for (paramFloat1 = d(paramFloat1, -1.0F, 1.0F);; paramFloat1 = 0.0F)
    {
      if (paramFloat1 != 0.0F) {
        break label102;
      }
      return 0.0F;
      if (paramFloat1 > 0.0F)
      {
        paramFloat1 = this.Ay.getInterpolation(paramFloat1);
        break;
      }
    }
    label102:
    f2 = this.AD[paramInt];
    paramFloat2 = this.AE[paramInt];
    f1 = this.AF[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return d(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -d(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  private void cj()
  {
    if (this.AH)
    {
      this.AJ = false;
      return;
    }
    a locala = this.Ax;
    long l = AnimationUtils.currentAnimationTimeMillis();
    int i = (int)(l - locala.mStartTime);
    int j = locala.AO;
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      locala.AW = i;
      locala.AV = locala.e(l);
      locala.AU = l;
      return;
      if (i < 0) {
        i = 0;
      }
    }
  }
  
  public static float d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  private float g(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {}
    do
    {
      do
      {
        do
        {
          return 0.0F;
          switch (this.AB)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!this.AJ) || (this.AB != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
  }
  
  public abstract void ad(int paramInt);
  
  public abstract boolean ae(int paramInt);
  
  public final boolean aj()
  {
    a locala = this.Ax;
    int i = (int)(locala.AQ / Math.abs(locala.AQ));
    int j = (int)(locala.AP / Math.abs(locala.AP));
    if ((i == 0) || (!ae(i)))
    {
      if (j != 0) {}
      return false;
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.AK) {}
    for (;;)
    {
      return false;
      switch (o.d(paramMotionEvent))
      {
      }
      while ((this.AL) && (this.AJ))
      {
        return true;
        this.AI = true;
        this.AG = false;
        float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.nw.getWidth());
        float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.nw.getHeight());
        paramView = this.Ax;
        paramView.AP = f1;
        paramView.AQ = f2;
        if ((!this.AJ) && (aj()))
        {
          if (this.lw == null) {
            this.lw = new b();
          }
          this.AJ = true;
          this.AH = true;
          if ((!this.AG) && (this.AC > 0)) {
            z.a(this.nw, this.lw, this.AC);
          }
          for (;;)
          {
            this.AG = true;
            break;
            this.lw.run();
          }
          cj();
        }
      }
    }
  }
  
  public final a s(boolean paramBoolean)
  {
    if ((this.AK) && (!paramBoolean)) {
      cj();
    }
    this.AK = paramBoolean;
    return this;
  }
  
  private static final class a
  {
    int AN;
    int AO;
    float AP;
    float AQ;
    long AR = 0L;
    int AS = 0;
    int AT = 0;
    long AU = -1L;
    float AV;
    int AW;
    long mStartTime = Long.MIN_VALUE;
    
    final float e(long paramLong)
    {
      if (paramLong < this.mStartTime) {
        return 0.0F;
      }
      if ((this.AU < 0L) || (paramLong < this.AU)) {
        return a.d((float)(paramLong - this.mStartTime) / this.AN, 0.0F, 1.0F) * 0.5F;
      }
      long l = this.AU;
      float f1 = this.AV;
      float f2 = this.AV;
      return a.d((float)(paramLong - l) / this.AW, 0.0F, 1.0F) * f2 + (1.0F - f1);
    }
  }
  
  private final class b
    implements Runnable
  {
    public b() {}
    
    public final void run()
    {
      if (!a.this.AJ) {
        return;
      }
      if (a.this.AH)
      {
        a.this.AH = false;
        locala = a.this.Ax;
        locala.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        locala.AU = -1L;
        locala.AR = locala.mStartTime;
        locala.AV = 0.5F;
        locala.AS = 0;
        locala.AT = 0;
      }
      a.a locala = a.this.Ax;
      if ((locala.AU > 0L) && (AnimationUtils.currentAnimationTimeMillis() > locala.AU + locala.AW)) {}
      for (int i = 1; (i != 0) || (!a.this.aj()); i = 0)
      {
        a.this.AJ = false;
        return;
      }
      if (a.this.AI)
      {
        a.this.AI = false;
        a locala1 = a.this;
        l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        locala1.nw.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      if (locala.AR == 0L) {
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = locala.e(l1);
      f = f * 4.0F + -4.0F * f * f;
      long l2 = l1 - locala.AR;
      locala.AR = l1;
      locala.AS = ((int)((float)l2 * f * locala.AP));
      locala.AT = ((int)((float)l2 * f * locala.AQ));
      i = locala.AT;
      a.this.ad(i);
      z.a(a.this.nw, this);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */