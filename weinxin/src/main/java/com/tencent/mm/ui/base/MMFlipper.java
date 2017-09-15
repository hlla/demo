package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public class MMFlipper
  extends ViewGroup
{
  private Interpolator eW;
  private VelocityTracker fk;
  private int iE;
  private int kTU;
  protected int vfQ;
  protected int vfR;
  public boolean vfT;
  protected int vho;
  private int vhp;
  private boolean vhq;
  public b vhr;
  public a vhs;
  int vht;
  int vhu;
  private float yN;
  private float yO;
  private Scroller yw;
  
  public MMFlipper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(3178410016768L, 23681);
    init(paramContext);
    GMTrace.o(3178410016768L, 23681);
  }
  
  public MMFlipper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3178544234496L, 23682);
    this.vhp = 0;
    this.kTU = 0;
    this.vhq = false;
    this.vfT = true;
    this.vht = -123454321;
    this.vhu = -123454321;
    init(paramContext);
    GMTrace.o(3178544234496L, 23682);
  }
  
  private void init(Context paramContext)
  {
    GMTrace.i(3178678452224L, 23683);
    this.eW = new c();
    this.yw = new Scroller(paramContext, this.eW);
    this.vfR = -1;
    int i = this.vhp;
    this.vfQ = i;
    this.vho = i;
    this.iE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    GMTrace.o(3178678452224L, 23683);
  }
  
  private void zL(int paramInt)
  {
    GMTrace.i(3179081105408L, 23686);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      int i = getWidth() * paramInt - getScrollX();
      this.yw.startScroll(getScrollX(), 0, i, 0, a.W(getContext(), (int)(Math.abs(i) * 1.3F)));
      if (this.vfQ != paramInt)
      {
        this.vhq = true;
        this.vho += paramInt - this.vfQ;
      }
      this.vfR = this.vfQ;
      this.vfQ = paramInt;
      invalidate();
    }
    GMTrace.o(3179081105408L, 23686);
  }
  
  public final void Aa(int paramInt)
  {
    GMTrace.i(3179215323136L, 23687);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.vhq = false;
    if (!this.yw.isFinished()) {
      this.yw.abortAnimation();
    }
    this.vfR = this.vfQ;
    this.vfQ = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    GMTrace.o(3179215323136L, 23687);
  }
  
  public final void Ab(int paramInt)
  {
    GMTrace.i(3179349540864L, 23688);
    this.vho = paramInt;
    GMTrace.o(3179349540864L, 23688);
  }
  
  public final void Ac(int paramInt)
  {
    GMTrace.i(3179483758592L, 23689);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.vhq = false;
    if (!this.yw.isFinished()) {
      this.yw.abortAnimation();
    }
    if (this.vhr != null) {
      this.vhr.sd(paramInt);
    }
    this.vfR = this.vfQ;
    this.vfQ = paramInt;
    this.vho = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    GMTrace.o(3179483758592L, 23689);
  }
  
  public final int bRH()
  {
    GMTrace.i(3179617976320L, 23690);
    v.d("MicroMsg.MMFlipper", "cur screen is %d", new Object[] { Integer.valueOf(this.vfQ) });
    int i = this.vfQ;
    GMTrace.o(3179617976320L, 23690);
    return i;
  }
  
  public void computeScroll()
  {
    GMTrace.i(3179752194048L, 23691);
    this.yw.getCurrX();
    if (this.yw.computeScrollOffset())
    {
      scrollTo(this.yw.getCurrX(), this.yw.getCurrY());
      postInvalidate();
      GMTrace.o(3179752194048L, 23691);
      return;
    }
    if (this.vhq)
    {
      this.vhq = false;
      if (this.vhr != null) {
        this.vhr.sd(this.vho);
      }
    }
    GMTrace.o(3179752194048L, 23691);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3180020629504L, 23693);
    boolean bool;
    if (!this.vfT)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      GMTrace.o(3180020629504L, 23693);
      return bool;
    }
    if (getChildCount() == 1)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      GMTrace.o(3180020629504L, 23693);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.kTU != 0))
    {
      GMTrace.o(3180020629504L, 23693);
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.kTU != 0)
    {
      GMTrace.o(3180020629504L, 23693);
      return true;
      i = (int)Math.abs(this.yN - f1);
      int j = (int)Math.abs(this.yO - f2);
      v.v("MicroMsg.MMFlipper", "xDif = " + i + ", yDif = " + j);
      if ((i > this.iE) && (j < this.iE)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label250;
        }
        this.kTU = 1;
        break;
      }
      label250:
      this.kTU = 0;
      continue;
      this.yN = f1;
      this.yO = f2;
      if (this.yw.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.kTU = i;
        break;
      }
      this.kTU = 0;
    }
    GMTrace.o(3180020629504L, 23693);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(3178812669952L, 23684);
    long l = bf.NB();
    int m = getChildCount();
    int j = 0;
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      int k = j;
      if (localView.getVisibility() != 8)
      {
        k = localView.getMeasuredWidth();
        v.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:" + k);
        localView.layout(j, 0, j + k, localView.getMeasuredHeight());
        k = j + k;
      }
      i += 1;
      j = k;
    }
    v.v("MicroMsg.MMFlipper", "use " + bf.aB(l) + " ms, flipper onLayout changed:" + paramBoolean + " Left,Top,Right,Bottom:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
    GMTrace.o(3178812669952L, 23684);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(3178946887680L, 23685);
    long l = bf.NB();
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.vhs != null) {
      this.vhs.cN(j, i);
    }
    this.vht = j;
    this.vhu = i;
    int k = getChildCount();
    i = 0;
    while (i < k)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    scrollTo(this.vfQ * j, 0);
    v.v("MicroMsg.MMFlipper", "flipper onMeasure:" + j + "," + View.MeasureSpec.getSize(paramInt2) + " childCount:" + k + ", use " + bf.aB(l));
    GMTrace.o(3178946887680L, 23685);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3179886411776L, 23692);
    if (getChildCount() == 1)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      GMTrace.o(3179886411776L, 23692);
      return bool;
    }
    if (this.fk == null) {
      this.fk = VelocityTracker.obtain();
    }
    this.fk.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    switch (i)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        GMTrace.o(3179886411776L, 23692);
        return true;
        if (!this.yw.isFinished()) {
          this.yw.abortAnimation();
        }
        this.yN = f;
        continue;
        i = (int)(this.yN - f);
        this.yN = f;
        scrollBy(i, 0);
      }
    }
    paramMotionEvent = this.fk;
    paramMotionEvent.computeCurrentVelocity(1000);
    i = (int)paramMotionEvent.getXVelocity();
    if ((i > 600) && (this.vfQ > 0)) {
      zL(this.vfQ - 1);
    }
    for (;;)
    {
      if (this.fk != null)
      {
        this.fk.recycle();
        this.fk = null;
      }
      this.kTU = 0;
      this.yN = 0.0F;
      this.yO = 0.0F;
      break;
      if ((i < 64936) && (this.vfQ < getChildCount() - 1))
      {
        zL(this.vfQ + 1);
      }
      else
      {
        i = getWidth();
        zL((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void cN(int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void sd(int paramInt);
  }
  
  private static final class c
    implements Interpolator
  {
    private float oGH;
    
    public c()
    {
      GMTrace.i(3186597298176L, 23742);
      this.oGH = 1.3F;
      this.oGH = 0.0F;
      GMTrace.o(3186597298176L, 23742);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      GMTrace.i(3186731515904L, 23743);
      paramFloat -= 1.0F;
      GMTrace.o(3186731515904L, 23743);
      return paramFloat * (paramFloat * paramFloat) + 1.0F;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MMFlipper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */