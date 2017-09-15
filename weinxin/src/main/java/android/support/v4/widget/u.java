package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class u
{
  private static final Interpolator yp = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  int EK;
  float[] EL;
  float[] EM;
  float[] EN;
  float[] EO;
  private int[] EP;
  private int[] EQ;
  private int[] ER;
  private int ES;
  private float ET;
  float EU;
  int EV;
  int EW;
  private final a EX;
  View EY;
  private boolean EZ;
  private final ViewGroup Fa;
  private final Runnable Fb = new Runnable()
  {
    public final void run()
    {
      u.this.ao(0);
    }
  };
  private VelocityTracker fk;
  private int fl = -1;
  private q iB;
  public int iE;
  
  private u(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (parama == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.Fa = paramViewGroup;
    this.EX = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.EV = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.iE = paramViewGroup.getScaledTouchSlop();
    this.ET = paramViewGroup.getScaledMaximumFlingVelocity();
    this.EU = paramViewGroup.getScaledMinimumFlingVelocity();
    this.iB = q.a(paramContext, yp);
  }
  
  public static u a(ViewGroup paramViewGroup, float paramFloat, a parama)
  {
    paramViewGroup = a(paramViewGroup, parama);
    paramViewGroup.iE = ((int)(paramViewGroup.iE * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static u a(ViewGroup paramViewGroup, a parama)
  {
    return new u(paramViewGroup.getContext(), paramViewGroup, parama);
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    if ((this.EL == null) || (this.EL.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.EL != null)
      {
        System.arraycopy(this.EL, 0, localObject, 0, this.EL.length);
        System.arraycopy(this.EM, 0, arrayOfFloat1, 0, this.EM.length);
        System.arraycopy(this.EN, 0, arrayOfFloat2, 0, this.EN.length);
        System.arraycopy(this.EO, 0, arrayOfFloat3, 0, this.EO.length);
        System.arraycopy(this.EP, 0, arrayOfInt1, 0, this.EP.length);
        System.arraycopy(this.EQ, 0, arrayOfInt2, 0, this.EQ.length);
        System.arraycopy(this.ER, 0, arrayOfInt3, 0, this.ER.length);
      }
      this.EL = ((float[])localObject);
      this.EM = arrayOfFloat1;
      this.EN = arrayOfFloat2;
      this.EO = arrayOfFloat3;
      this.EP = arrayOfInt1;
      this.EQ = arrayOfInt2;
      this.ER = arrayOfInt3;
    }
    Object localObject = this.EL;
    this.EN[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.EM;
    this.EO[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.EP;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.Fa.getLeft() + this.EV) {
      j = 1;
    }
    int i = j;
    if (k < this.Fa.getTop() + this.EV) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.Fa.getRight() - this.EV) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.Fa.getBottom() - this.EV) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.ES |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.EP[paramInt1] & paramInt2) != paramInt2) || ((this.EW & paramInt2) == 0) || ((this.ER[paramInt1] & paramInt2) == paramInt2) || ((this.EQ[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.iE) && (paramFloat2 <= this.iE))) {}
    while (((this.EQ[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.iE)) {
      return false;
    }
    return true;
  }
  
  private void am(int paramInt)
  {
    if (this.EL == null) {
      return;
    }
    this.EL[paramInt] = 0.0F;
    this.EM[paramInt] = 0.0F;
    this.EN[paramInt] = 0.0F;
    this.EO[paramInt] = 0.0F;
    this.EP[paramInt] = 0;
    this.EQ[paramInt] = 0;
    this.ER[paramInt] = 0;
    this.ES &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean ap(int paramInt)
  {
    if (!an(paramInt))
    {
      new StringBuilder("Ignoring pointerId=").append(paramInt).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      return false;
    }
    return true;
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    if (a(paramFloat1, paramFloat2, paramInt, 1)) {}
    for (;;)
    {
      int i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 4)) {
        i = j | 0x4;
      }
      j = i;
      if (a(paramFloat1, paramFloat2, paramInt, 2)) {
        j = i | 0x2;
      }
      i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 8)) {
        i = j | 0x8;
      }
      if (i != 0)
      {
        int[] arrayOfInt = this.EQ;
        arrayOfInt[paramInt] |= i;
        this.EX.n(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private boolean b(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    label20:
    int j;
    label72:
    label78:
    do
    {
      do
      {
        return false;
        int i;
        if (this.EX.s(paramView) > 0)
        {
          i = 1;
          if (this.EX.K() <= 0) {
            break label72;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i == 0) || (j == 0)) {
            break label78;
          }
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= this.iE * this.iE) {
            break;
          }
          return true;
          i = 0;
          break label20;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(paramFloat1) <= this.iE);
      return true;
    } while ((j == 0) || (Math.abs(paramFloat2) <= this.iE));
    return true;
  }
  
  private void cI()
  {
    this.fk.computeCurrentVelocity(1000, this.ET);
    i(e(y.a(this.fk, this.fl), this.EU, this.ET), e(y.b(this.fk, this.fl), this.EU, this.ET));
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    do
    {
      return paramFloat2;
      if (f <= paramFloat3) {
        break;
      }
      paramFloat2 = paramFloat3;
    } while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }
  
  private boolean e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.EY.getLeft();
    int j = this.EY.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iB.abortAnimation();
      ao(0);
      return false;
    }
    View localView = this.EY;
    paramInt3 = h(paramInt3, (int)this.EU, (int)this.ET);
    paramInt4 = h(paramInt4, (int)this.EU, (int)this.ET);
    int k = Math.abs(paramInt1);
    int m = Math.abs(paramInt2);
    int n = Math.abs(paramInt3);
    int i1 = Math.abs(paramInt4);
    int i2 = n + i1;
    int i3 = k + m;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = n / i2;
      if (paramInt4 == 0) {
        break label237;
      }
    }
    label237:
    for (float f2 = i1 / i2;; f2 = m / i3)
    {
      paramInt3 = g(paramInt1, paramInt3, this.EX.s(localView));
      paramInt4 = g(paramInt2, paramInt4, this.EX.K());
      float f3 = paramInt3;
      paramInt3 = (int)(f2 * paramInt4 + f1 * f3);
      this.iB.startScroll(i, j, paramInt1, paramInt2, paramInt3);
      ao(2);
      return true;
      f1 = k / i3;
      break;
    }
  }
  
  public static boolean f(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  private int g(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.Fa.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
      return Math.min(paramInt1, 600);
    }
  }
  
  private static int h(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      paramInt2 = 0;
    }
    do
    {
      return paramInt2;
      if (i <= paramInt3) {
        break;
      }
      paramInt2 = paramInt3;
    } while (paramInt1 > 0);
    return -paramInt3;
    return paramInt1;
  }
  
  private void i(float paramFloat1, float paramFloat2)
  {
    this.EZ = true;
    this.EX.a(this.EY, paramFloat1, paramFloat2);
    this.EZ = false;
    if (this.EK == 1) {
      ao(0);
    }
  }
  
  private void i(MotionEvent paramMotionEvent)
  {
    int j = o.f(paramMotionEvent);
    int i = 0;
    while (i < j)
    {
      int k = o.c(paramMotionEvent, i);
      float f1 = o.d(paramMotionEvent, i);
      float f2 = o.e(paramMotionEvent, i);
      this.EN[k] = f1;
      this.EO[k] = f2;
      i += 1;
    }
  }
  
  private boolean o(View paramView, int paramInt)
  {
    if ((paramView == this.EY) && (this.fl == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.EX.b(paramView, paramInt)))
    {
      this.fl = paramInt;
      n(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public final void abort()
  {
    cancel();
    if (this.EK == 2)
    {
      this.iB.getCurrX();
      this.iB.getCurrY();
      this.iB.abortAnimation();
      int i = this.iB.getCurrX();
      int j = this.iB.getCurrY();
      this.EX.a(this.EY, i, j);
    }
    ao(0);
  }
  
  public final boolean an(int paramInt)
  {
    return (this.ES & 1 << paramInt) != 0;
  }
  
  final void ao(int paramInt)
  {
    this.Fa.removeCallbacks(this.Fb);
    if (this.EK != paramInt)
    {
      this.EK = paramInt;
      this.EX.j(paramInt);
      if (this.EK == 0) {
        this.EY = null;
      }
    }
  }
  
  public final boolean cH()
  {
    boolean bool2 = false;
    if (this.EK == 2)
    {
      boolean bool3 = this.iB.computeScrollOffset();
      int i = this.iB.getCurrX();
      int j = this.iB.getCurrY();
      int k = i - this.EY.getLeft();
      int m = j - this.EY.getTop();
      if (k != 0) {
        z.k(this.EY, k);
      }
      if (m != 0) {
        z.j(this.EY, m);
      }
      if ((k != 0) || (m != 0)) {
        this.EX.a(this.EY, i, j);
      }
      bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i == this.iB.getFinalX())
        {
          bool1 = bool3;
          if (j == this.iB.getFinalY())
          {
            this.iB.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.Fa.post(this.Fb);
      }
    }
    boolean bool1 = bool2;
    if (this.EK == 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final void cancel()
  {
    this.fl = -1;
    if (this.EL != null)
    {
      Arrays.fill(this.EL, 0.0F);
      Arrays.fill(this.EM, 0.0F);
      Arrays.fill(this.EN, 0.0F);
      Arrays.fill(this.EO, 0.0F);
      Arrays.fill(this.EP, 0);
      Arrays.fill(this.EQ, 0);
      Arrays.fill(this.ER, 0);
      this.ES = 0;
    }
    if (this.fk != null)
    {
      this.fk.recycle();
      this.fk = null;
    }
  }
  
  public final boolean e(View paramView, int paramInt1, int paramInt2)
  {
    this.EY = paramView;
    this.fl = -1;
    boolean bool = e(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.EK == 0) && (this.EY != null)) {
      this.EY = null;
    }
    return bool;
  }
  
  public final boolean j(MotionEvent paramMotionEvent)
  {
    int j = o.d(paramMotionEvent);
    int i = o.e(paramMotionEvent);
    if (j == 0) {
      cancel();
    }
    if (this.fk == null) {
      this.fk = VelocityTracker.obtain();
    }
    this.fk.addMovement(paramMotionEvent);
    switch (j)
    {
    }
    while (this.EK == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = o.c(paramMotionEvent, 0);
      a(f1, f2, i);
      paramMotionEvent = r((int)f1, (int)f2);
      if ((paramMotionEvent == this.EY) && (this.EK == 2)) {
        o(paramMotionEvent, i);
      }
      if ((this.EP[i] & this.EW) != 0)
      {
        this.EX.cq();
        continue;
        j = o.c(paramMotionEvent, i);
        f1 = o.d(paramMotionEvent, i);
        f2 = o.e(paramMotionEvent, i);
        a(f1, f2, j);
        if (this.EK == 0)
        {
          if ((this.EP[j] & this.EW) != 0) {
            this.EX.cq();
          }
        }
        else if (this.EK == 2)
        {
          paramMotionEvent = r((int)f1, (int)f2);
          if (paramMotionEvent == this.EY)
          {
            o(paramMotionEvent, j);
            continue;
            if ((this.EL != null) && (this.EM != null))
            {
              int k = o.f(paramMotionEvent);
              i = 0;
              if (i < k)
              {
                int m = o.c(paramMotionEvent, i);
                float f3;
                float f4;
                View localView;
                if (ap(m))
                {
                  f1 = o.d(paramMotionEvent, i);
                  f2 = o.e(paramMotionEvent, i);
                  f3 = f1 - this.EL[m];
                  f4 = f2 - this.EM[m];
                  localView = r((int)f1, (int)f2);
                  if ((localView == null) || (!b(localView, f3, f4))) {
                    break label551;
                  }
                }
                label551:
                for (j = 1;; j = 0)
                {
                  if (j != 0)
                  {
                    int n = localView.getLeft();
                    int i1 = (int)f3;
                    i1 = this.EX.d(localView, i1 + n);
                    int i2 = localView.getTop();
                    int i3 = (int)f4;
                    i3 = this.EX.c(localView, i3 + i2);
                    int i4 = this.EX.s(localView);
                    int i5 = this.EX.K();
                    if (((i4 == 0) || ((i4 > 0) && (i1 == n))) && ((i5 == 0) || ((i5 > 0) && (i3 == i2)))) {
                      break label557;
                    }
                  }
                  b(f3, f4, m);
                  if ((this.EK == 1) || ((j != 0) && (o(localView, m)))) {
                    break label557;
                  }
                  i += 1;
                  break;
                }
              }
              label557:
              i(paramMotionEvent);
              continue;
              am(o.c(paramMotionEvent, i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    return false;
  }
  
  public final void k(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int m = o.d(paramMotionEvent);
    int k = o.e(paramMotionEvent);
    if (m == 0) {
      cancel();
    }
    if (this.fk == null) {
      this.fk = VelocityTracker.obtain();
    }
    this.fk.addMovement(paramMotionEvent);
    float f1;
    float f2;
    switch (m)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
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
              i = o.c(paramMotionEvent, 0);
              paramMotionEvent = r((int)f1, (int)f2);
              a(f1, f2, i);
              o(paramMotionEvent, i);
            } while ((this.EP[i] & this.EW) == 0);
            this.EX.cq();
            return;
            i = o.c(paramMotionEvent, k);
            f1 = o.d(paramMotionEvent, k);
            f2 = o.e(paramMotionEvent, k);
            a(f1, f2, i);
            if (this.EK != 0) {
              break;
            }
            o(r((int)f1, (int)f2), i);
          } while ((this.EP[i] & this.EW) == 0);
          this.EX.cq();
          return;
          j = (int)f1;
          k = (int)f2;
        } while (!f(this.EY, j, k));
        o(this.EY, i);
        return;
        if (this.EK != 1) {
          break;
        }
      } while (!ap(this.fl));
      i = o.b(paramMotionEvent, this.fl);
      f1 = o.d(paramMotionEvent, i);
      f2 = o.e(paramMotionEvent, i);
      m = (int)(f1 - this.EN[this.fl]);
      int n = (int)(f2 - this.EO[this.fl]);
      j = this.EY.getLeft() + m;
      k = this.EY.getTop() + n;
      int i2 = this.EY.getLeft();
      int i1 = this.EY.getTop();
      i = j;
      if (m != 0)
      {
        i = this.EX.d(this.EY, j);
        z.k(this.EY, i - i2);
      }
      j = k;
      if (n != 0)
      {
        j = this.EX.c(this.EY, k);
        z.j(this.EY, j - i1);
      }
      if ((m != 0) || (n != 0)) {
        this.EX.a(this.EY, i, j);
      }
      i(paramMotionEvent);
      return;
      k = o.f(paramMotionEvent);
      i = j;
      while (i < k)
      {
        j = o.c(paramMotionEvent, i);
        if (ap(j))
        {
          f1 = o.d(paramMotionEvent, i);
          f2 = o.e(paramMotionEvent, i);
          float f3 = f1 - this.EL[j];
          float f4 = f2 - this.EM[j];
          b(f3, f4, j);
          if (this.EK == 1) {
            break;
          }
          View localView = r((int)f1, (int)f2);
          if ((b(localView, f3, f4)) && (o(localView, j))) {
            break;
          }
        }
        i += 1;
      }
      i(paramMotionEvent);
      return;
    case 6: 
      j = o.c(paramMotionEvent, k);
      if ((this.EK == 1) && (j == this.fl))
      {
        k = o.f(paramMotionEvent);
        if (i >= k) {
          break label785;
        }
        m = o.c(paramMotionEvent, i);
        if (m == this.fl) {
          break label740;
        }
        f1 = o.d(paramMotionEvent, i);
        f2 = o.e(paramMotionEvent, i);
        if ((r((int)f1, (int)f2) != this.EY) || (!o(this.EY, m))) {
          break label740;
        }
      }
      break;
    }
    label740:
    label785:
    for (i = this.fl;; i = -1)
    {
      if (i == -1) {
        cI();
      }
      am(j);
      return;
      i += 1;
      break;
      if (this.EK == 1) {
        cI();
      }
      cancel();
      return;
      if (this.EK == 1) {
        i(0.0F, 0.0F);
      }
      cancel();
      return;
    }
  }
  
  public final void n(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.Fa) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Fa + ")");
    }
    this.EY = paramView;
    this.fl = paramInt;
    this.EX.f(paramView, paramInt);
    ao(1);
  }
  
  public final boolean q(int paramInt1, int paramInt2)
  {
    if (!this.EZ) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return e(paramInt1, paramInt2, (int)y.a(this.fk, this.fl), (int)y.b(this.fk, this.fl));
  }
  
  public final View r(int paramInt1, int paramInt2)
  {
    int i = this.Fa.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.Fa.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public static abstract class a
  {
    public int K()
    {
      return 0;
    }
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public void a(View paramView, int paramInt1, int paramInt2) {}
    
    public abstract boolean b(View paramView, int paramInt);
    
    public int c(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void cq() {}
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void f(View paramView, int paramInt) {}
    
    public void j(int paramInt) {}
    
    public void n(int paramInt1, int paramInt2) {}
    
    public int s(View paramView)
    {
      return 0;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */