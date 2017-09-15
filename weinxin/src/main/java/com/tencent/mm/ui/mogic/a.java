package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.widget.q;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Arrays;

public final class a
{
  private static final Interpolator yp;
  public int EK;
  public float[] EL;
  public float[] EM;
  public float[] EN;
  public float[] EO;
  public int[] EP;
  private int[] EQ;
  private int[] ER;
  public int ES;
  public float ET;
  public float EU;
  private int EV;
  public int EW;
  public View EY;
  public boolean EZ;
  public final ViewGroup Fa;
  public final Runnable Fb;
  public VelocityTracker fk;
  public int fl;
  public q iB;
  private int iE;
  public final a whv;
  
  static
  {
    GMTrace.i(1859586621440L, 13855);
    yp = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        GMTrace.i(1860794580992L, 13864);
        paramAnonymousFloat -= 1.0F;
        GMTrace.o(1860794580992L, 13864);
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    GMTrace.o(1859586621440L, 13855);
  }
  
  private a(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    GMTrace.i(1857304920064L, 13838);
    this.fl = -1;
    this.Fb = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1856096960512L, 13829);
        a.this.ao(0);
        GMTrace.o(1856096960512L, 13829);
      }
    };
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (parama == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.Fa = paramViewGroup;
    this.whv = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.EV = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.iE = paramViewGroup.getScaledTouchSlop();
    this.ET = paramViewGroup.getScaledMaximumFlingVelocity();
    this.EU = paramViewGroup.getScaledMinimumFlingVelocity();
    this.iB = q.a(paramContext, yp);
    GMTrace.o(1857304920064L, 13838);
  }
  
  public static a a(ViewGroup paramViewGroup, a parama)
  {
    GMTrace.i(1857170702336L, 13837);
    paramViewGroup = new a(paramViewGroup.getContext(), paramViewGroup, parama);
    GMTrace.o(1857170702336L, 13837);
    return paramViewGroup;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    GMTrace.i(1859049750528L, 13851);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.EP[paramInt1] & paramInt2) != paramInt2) || ((this.EW & paramInt2) == 0) || ((this.ER[paramInt1] & paramInt2) == paramInt2) || ((this.EQ[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.iE) && (paramFloat2 <= this.iE)))
    {
      GMTrace.o(1859049750528L, 13851);
      return false;
    }
    if (((this.EQ[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.iE))
    {
      GMTrace.o(1859049750528L, 13851);
      return true;
    }
    GMTrace.o(1859049750528L, 13851);
    return false;
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    GMTrace.i(1857976008704L, 13843);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      GMTrace.o(1857976008704L, 13843);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        GMTrace.o(1857976008704L, 13843);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      GMTrace.o(1857976008704L, 13843);
      return paramFloat1;
    }
    GMTrace.o(1857976008704L, 13843);
    return paramFloat1;
  }
  
  private int g(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1857707573248L, 13841);
    if (paramInt1 == 0)
    {
      GMTrace.o(1857707573248L, 13841);
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
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      GMTrace.o(1857707573248L, 13841);
      return paramInt1;
    }
  }
  
  private static int h(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1857841790976L, 13842);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      GMTrace.o(1857841790976L, 13842);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        GMTrace.o(1857841790976L, 13842);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      GMTrace.o(1857841790976L, 13842);
      return paramInt1;
    }
    GMTrace.o(1857841790976L, 13842);
    return paramInt1;
  }
  
  public final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    GMTrace.i(1858378661888L, 13846);
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
    int j = 0;
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
    GMTrace.o(1858378661888L, 13846);
  }
  
  public final void am(int paramInt)
  {
    GMTrace.i(1858244444160L, 13845);
    if (this.EL == null)
    {
      GMTrace.o(1858244444160L, 13845);
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
    GMTrace.o(1858244444160L, 13845);
  }
  
  final void ao(int paramInt)
  {
    GMTrace.i(1858647097344L, 13848);
    if (this.EK != paramInt)
    {
      this.EK = paramInt;
      this.whv.j(paramInt);
      if (paramInt == 0) {
        this.EY = null;
      }
    }
    GMTrace.o(1858647097344L, 13848);
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    GMTrace.i(1858915532800L, 13850);
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
        arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
      }
      GMTrace.o(1858915532800L, 13850);
      return;
      j = 0;
    }
  }
  
  public final void cI()
  {
    GMTrace.i(1859318185984L, 13853);
    this.fk.computeCurrentVelocity(1000, this.ET);
    i(e(y.a(this.fk, this.fl), this.EU, this.ET), e(y.b(this.fk, this.fl), this.EU, this.ET));
    GMTrace.o(1859318185984L, 13853);
  }
  
  public final void cancel()
  {
    GMTrace.i(1857439137792L, 13839);
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
    GMTrace.o(1857439137792L, 13839);
  }
  
  public final boolean e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1857573355520L, 13840);
    int i = this.EY.getLeft();
    int j = this.EY.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iB.abortAnimation();
      ao(0);
      GMTrace.o(1857573355520L, 13840);
      return false;
    }
    int m = h(paramInt3, (int)this.EU, (int)this.ET);
    int k = h(paramInt4, (int)this.EU, (int)this.ET);
    int n = Math.abs(paramInt1);
    int i1 = Math.abs(paramInt2);
    int i2 = Math.abs(m);
    int i3 = Math.abs(k);
    int i4 = i2 + i3;
    int i5 = n + i1;
    float f1;
    if (m != 0)
    {
      f1 = i2 / i4;
      if (k == 0) {
        break label308;
      }
    }
    label308:
    for (float f2 = i3 / i4;; f2 = i1 / i5)
    {
      m = g(paramInt1, m, this.whv.bZd());
      k = g(paramInt2, k, 0);
      float f3 = m;
      k = (int)(f2 * k + f1 * f3);
      v.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(k) });
      this.iB.startScroll(i, j, paramInt1, paramInt2, k);
      ao(2);
      GMTrace.o(1857573355520L, 13840);
      return true;
      f1 = n / i5;
      break;
    }
  }
  
  public final void i(float paramFloat1, float paramFloat2)
  {
    GMTrace.i(1858110226432L, 13844);
    this.EZ = true;
    this.whv.a(this.EY, paramFloat1, paramFloat2);
    this.EZ = false;
    if (this.EK == 1) {
      ao(0);
    }
    GMTrace.o(1858110226432L, 13844);
  }
  
  public final void i(MotionEvent paramMotionEvent)
  {
    GMTrace.i(1858512879616L, 13847);
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
    GMTrace.o(1858512879616L, 13847);
  }
  
  public final boolean l(View paramView, float paramFloat)
  {
    GMTrace.i(1859183968256L, 13852);
    if (paramView == null)
    {
      GMTrace.o(1859183968256L, 13852);
      return false;
    }
    int i;
    if (this.whv.bZd() > 0) {
      i = 1;
    }
    while (i != 0) {
      if (Math.abs(paramFloat) > this.iE)
      {
        GMTrace.o(1859183968256L, 13852);
        return true;
        i = 0;
      }
      else
      {
        GMTrace.o(1859183968256L, 13852);
        return false;
      }
    }
    GMTrace.o(1859183968256L, 13852);
    return false;
  }
  
  public final boolean o(View paramView, int paramInt)
  {
    GMTrace.i(1858781315072L, 13849);
    if ((paramView == this.EY) && (this.fl == paramInt))
    {
      GMTrace.o(1858781315072L, 13849);
      return true;
    }
    if ((paramView != null) && (this.whv.BV(paramInt)))
    {
      this.fl = paramInt;
      if (paramView.getParent() != this.Fa) {
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Fa + ")");
      }
      this.EY = paramView;
      this.fl = paramInt;
      ao(1);
      GMTrace.o(1858781315072L, 13849);
      return true;
    }
    GMTrace.o(1858781315072L, 13849);
    return false;
  }
  
  public final View r(int paramInt1, int paramInt2)
  {
    GMTrace.i(1859452403712L, 13854);
    int i = this.Fa.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.Fa.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        GMTrace.o(1859452403712L, 13854);
        return localView;
      }
      i -= 1;
    }
    GMTrace.o(1859452403712L, 13854);
    return null;
  }
  
  public static abstract class a
  {
    public a()
    {
      GMTrace.i(1870055604224L, 13933);
      GMTrace.o(1870055604224L, 13933);
    }
    
    public abstract boolean BV(int paramInt);
    
    public void a(View paramView, float paramFloat1, float paramFloat2)
    {
      GMTrace.i(1870458257408L, 13936);
      GMTrace.o(1870458257408L, 13936);
    }
    
    public int bZd()
    {
      GMTrace.i(1870592475136L, 13937);
      GMTrace.o(1870592475136L, 13937);
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      GMTrace.i(1870860910592L, 13939);
      GMTrace.o(1870860910592L, 13939);
      return 0;
    }
    
    public void eg(int paramInt1, int paramInt2)
    {
      GMTrace.i(1870324039680L, 13935);
      GMTrace.o(1870324039680L, 13935);
    }
    
    public void j(int paramInt)
    {
      GMTrace.i(1870189821952L, 13934);
      GMTrace.o(1870189821952L, 13934);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/mogic/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */