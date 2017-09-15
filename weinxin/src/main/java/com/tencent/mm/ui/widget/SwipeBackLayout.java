package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.b.a;
import com.tencent.mm.ui.base.b.b;
import com.tencent.mm.ui.mogic.a;
import com.tencent.mm.ui.mogic.a.a;
import com.tencent.mm.ui.tools.j.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SwipeBackLayout
  extends FrameLayout
{
  private float BC;
  public View Ih;
  private Rect gG;
  public boolean mEnable;
  private boolean pd;
  public boolean wrX;
  private float wvA;
  public Drawable wvB;
  public boolean wvC;
  private boolean wvD;
  public boolean wvE;
  public boolean wvF;
  private boolean wvG;
  public a wvH;
  private float wvw;
  private int wvx;
  private int wvy;
  public a wvz;
  
  public SwipeBackLayout(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(1621887025152L, 12084);
    GMTrace.o(1621887025152L, 12084);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(1622021242880L, 12085);
    GMTrace.o(1622021242880L, 12085);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1622155460608L, 12086);
    this.wvw = 0.3F;
    this.mEnable = true;
    this.gG = new Rect();
    this.wvC = true;
    this.wvD = false;
    this.wvE = false;
    this.wvF = false;
    this.wrX = false;
    this.wvG = false;
    this.wvH = null;
    this.wvB = getResources().getDrawable(a.f.hbI);
    setFocusable(true);
    setDescendantFocusability(262144);
    init();
    GMTrace.o(1622155460608L, 12086);
  }
  
  public final boolean caE()
  {
    GMTrace.i(1622558113792L, 12089);
    caF();
    boolean bool = this.wrX;
    GMTrace.o(1622558113792L, 12089);
    return bool;
  }
  
  public final boolean caF()
  {
    GMTrace.i(1622826549248L, 12091);
    if (!this.wrX)
    {
      GMTrace.o(1622826549248L, 12091);
      return false;
    }
    if (Float.compare(this.Ih.getLeft(), 0.01F) <= 0)
    {
      this.wrX = false;
      GMTrace.o(1622826549248L, 12091);
      return false;
    }
    GMTrace.o(1622826549248L, 12091);
    return true;
  }
  
  public void computeScroll()
  {
    GMTrace.i(1623497637888L, 12096);
    this.BC = Math.max(0.0F, 1.0F - this.wvA);
    a locala = this.wvz;
    if (locala.EK == 2)
    {
      boolean bool2 = locala.iB.computeScrollOffset();
      i = locala.iB.getCurrX();
      int j = locala.iB.getCurrY();
      int k = i - locala.EY.getLeft();
      int m = j - locala.EY.getTop();
      if (k != 0) {
        locala.EY.offsetLeftAndRight(k);
      }
      if (m != 0) {
        locala.EY.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        locala.whv.eg(i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == locala.iB.getFinalX())
        {
          bool1 = bool2;
          if (j == locala.iB.getFinalY())
          {
            locala.iB.abortAnimation();
            bool1 = locala.iB.isFinished();
          }
        }
      }
      if (!bool1) {
        locala.Fa.post(locala.Fb);
      }
    }
    if (locala.EK == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        z.F(this);
      }
      GMTrace.o(1623497637888L, 12096);
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(1622960766976L, 12092);
    boolean bool;
    if (!this.mEnable)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      GMTrace.o(1622960766976L, 12092);
      return bool;
    }
    if (caF())
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      GMTrace.o(1622960766976L, 12092);
      return bool;
    }
    float f1;
    float f2;
    int k;
    int m;
    int n;
    label629:
    label664:
    label673:
    float f3;
    View localView;
    for (;;)
    {
      try
      {
        if (this.wvz.EK != 1) {
          break;
        }
        locala = this.wvz;
        j = o.d(paramMotionEvent);
        i = o.e(paramMotionEvent);
        if (j == 0) {
          locala.cancel();
        }
        if (locala.fk == null) {
          locala.fk = VelocityTracker.obtain();
        }
        locala.fk.addMovement(paramMotionEvent);
        switch (j)
        {
        }
      }
      catch (NullPointerException paramMotionEvent)
      {
        v.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an NullPointerException", new Object[0]);
        GMTrace.o(1622960766976L, 12092);
        return false;
        i = (int)f1;
        k = (int)f2;
        paramMotionEvent = locala.EY;
        if ((paramMotionEvent == null) || (i < paramMotionEvent.getLeft()) || (i >= paramMotionEvent.getRight()) || (k < paramMotionEvent.getTop()) || (k >= paramMotionEvent.getBottom())) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        locala.o(locala.EY, j);
        continue;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        v.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an IllegalArgumentException", new Object[0]);
        GMTrace.o(1622960766976L, 12092);
        return false;
        i = 0;
        continue;
        if (locala.EK != 1) {
          break label664;
        }
        i = o.b(paramMotionEvent, locala.fl);
        f1 = o.d(paramMotionEvent, i);
        f2 = o.e(paramMotionEvent, i);
        m = (int)(f1 - locala.EN[locala.fl]);
        n = (int)(f2 - locala.EO[locala.fl]);
        k = locala.EY.getLeft() + m;
        j = locala.EY.getTop() + n;
        int i2 = locala.EY.getLeft();
        int i1 = locala.EY.getTop();
        i = k;
        if (m == 0) {
          continue;
        }
        i = locala.whv.d(locala.EY, k);
        locala.EY.offsetLeftAndRight(i - i2);
        if (n == 0) {
          break label1452;
        }
        locala.EY.offsetTopAndBottom(0 - i1);
        j = 0;
        break label1452;
        locala.whv.eg(i, j);
        locala.i(paramMotionEvent);
        continue;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        v.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an ArrayIndexOutOfBoundsException", new Object[0]);
        GMTrace.o(1622960766976L, 12092);
        return false;
      }
      GMTrace.o(1622960766976L, 12092);
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = o.c(paramMotionEvent, 0);
      paramMotionEvent = locala.r((int)f1, (int)f2);
      locala.a(f1, f2, i);
      locala.o(paramMotionEvent, i);
      i = locala.EP[i];
      if ((locala.EW & i) != 0)
      {
        continue;
        j = o.c(paramMotionEvent, i);
        f1 = o.d(paramMotionEvent, i);
        f2 = o.e(paramMotionEvent, i);
        locala.a(f1, f2, j);
        if (locala.EK == 0)
        {
          locala.o(locala.r((int)f1, (int)f2), j);
        }
        else
        {
          j = o.f(paramMotionEvent);
          i = 0;
          if (i < j)
          {
            k = o.c(paramMotionEvent, i);
            f1 = o.d(paramMotionEvent, i);
            f2 = o.e(paramMotionEvent, i);
            f3 = f1 - locala.EL[k];
            locala.b(f3, f2 - locala.EM[k], k);
            if (locala.EK != 1)
            {
              localView = locala.r((int)f1, (int)f2);
              if ((!locala.l(localView, f3)) || (!locala.o(localView, k))) {
                break label1465;
              }
            }
          }
          locala.i(paramMotionEvent);
          continue;
          m = o.c(paramMotionEvent, i);
          if ((locala.EK == 1) && (m == locala.fl))
          {
            k = -1;
            n = o.f(paramMotionEvent);
            i = 0;
            label828:
            j = k;
            if (i < n)
            {
              j = o.c(paramMotionEvent, i);
              if (j == locala.fl) {
                break label1474;
              }
              f1 = o.d(paramMotionEvent, i);
              f2 = o.e(paramMotionEvent, i);
              if ((locala.r((int)f1, (int)f2) != locala.EY) || (!locala.o(locala.EY, j))) {
                break label1474;
              }
              j = locala.fl;
            }
            if (j == -1) {
              locala.cI();
            }
          }
          locala.am(m);
          continue;
          if (locala.EK == 1) {
            locala.cI();
          }
          locala.cancel();
          continue;
          if (locala.EK == 1) {
            locala.i(0.0F, 0.0F);
          }
          locala.cancel();
        }
      }
    }
    a locala = this.wvz;
    int j = o.d(paramMotionEvent);
    int i = o.e(paramMotionEvent);
    if (j == 0) {
      locala.cancel();
    }
    if (locala.fk == null) {
      locala.fk = VelocityTracker.obtain();
    }
    locala.fk.addMovement(paramMotionEvent);
    switch (j)
    {
    case 4: 
      label1076:
      if (locala.EK != 1) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        GMTrace.o(1622960766976L, 12092);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = o.c(paramMotionEvent, 0);
        locala.a(f1, f2, i);
        localView = locala.r((int)f1, (int)f2);
        if ((localView == locala.EY) && (locala.EK == 2)) {
          locala.o(localView, i);
        }
        if ((locala.EP[i] & locala.EW) == 0) {
          break label1076;
        }
        break label1076;
        j = o.c(paramMotionEvent, i);
        f1 = o.d(paramMotionEvent, i);
        f2 = o.e(paramMotionEvent, i);
        locala.a(f1, f2, j);
        if ((locala.EK == 0) || (locala.EK != 2)) {
          break label1076;
        }
        localView = locala.r((int)f1, (int)f2);
        if (localView != locala.EY) {
          break label1076;
        }
        locala.o(localView, j);
        break label1076;
        j = o.f(paramMotionEvent);
        i = 0;
      }
      for (;;)
      {
        if (i < j)
        {
          k = o.c(paramMotionEvent, i);
          f1 = o.d(paramMotionEvent, i);
          f2 = o.e(paramMotionEvent, i);
          f3 = f1 - locala.EL[k];
          locala.b(f3, f2 - locala.EM[k], k);
          if (locala.EK != 1)
          {
            localView = locala.r((int)f1, (int)f2);
            if ((localView == null) || (!locala.l(localView, f3)) || (!locala.o(localView, k))) {
              break label1486;
            }
          }
        }
        locala.i(paramMotionEvent);
        break label1076;
        locala.am(o.c(paramMotionEvent, i));
        break label1076;
        locala.cancel();
        break label1076;
        super.dispatchTouchEvent(paramMotionEvent);
        GMTrace.o(1622960766976L, 12092);
        return true;
        label1452:
        if (m != 0) {
          break;
        }
        if (n == 0) {
          break label629;
        }
        break;
        label1465:
        i += 1;
        break label673;
        label1474:
        i += 1;
        break label828;
        break label1076;
        label1486:
        i += 1;
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    GMTrace.i(1623363420160L, 12095);
    if (paramView == this.Ih) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((Float.compare(this.BC, 0.0F) > 0) && (i != 0) && (this.wvz.EK != 0))
      {
        Rect localRect = this.gG;
        paramView.getHitRect(localRect);
        this.wvB.setBounds(localRect.left - this.wvB.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
        this.wvB.setAlpha((int)(this.BC * 255.0F));
        this.wvB.draw(paramCanvas);
      }
      GMTrace.o(1623363420160L, 12095);
      return bool;
    }
  }
  
  public final void init()
  {
    GMTrace.i(1622289678336L, 12087);
    this.wvz = a.a(this, new b());
    this.wvz.EW = 1;
    float f = getResources().getDisplayMetrics().density;
    this.wvz.EU = (100.0F * f);
    this.wvz.ET = (f * 300.0F);
    this.wvx = 0;
    this.wvy = 0;
    GMTrace.o(1622289678336L, 12087);
  }
  
  public final void lR(boolean paramBoolean)
  {
    GMTrace.i(1622423896064L, 12088);
    v.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", new Object[] { Boolean.valueOf(paramBoolean) });
    this.wvE = paramBoolean;
    GMTrace.o(1622423896064L, 12088);
  }
  
  public void onFinishInflate()
  {
    GMTrace.i(1622692331520L, 12090);
    this.Ih = this;
    GMTrace.o(1622692331520L, 12090);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1623094984704L, 12093);
    this.pd = true;
    if (this.Ih != null) {
      this.Ih.layout(this.wvx, this.wvy, this.wvx + this.Ih.getMeasuredWidth(), this.wvy + this.Ih.getMeasuredHeight());
    }
    this.pd = false;
    GMTrace.o(1623094984704L, 12093);
  }
  
  public void requestLayout()
  {
    GMTrace.i(1623229202432L, 12094);
    if (!this.pd) {
      super.requestLayout();
    }
    GMTrace.o(1623229202432L, 12094);
  }
  
  public static abstract interface a
  {
    public abstract void VD();
    
    public abstract void VE();
    
    public abstract void onCancel();
  }
  
  private final class b
    extends a.a
    implements b.a
  {
    int wvI;
    int wvJ;
    int wvK;
    
    public b()
    {
      GMTrace.i(1643093426176L, 12242);
      this.wvI = 0;
      this.wvJ = 0;
      this.wvK = 0;
      GMTrace.o(1643093426176L, 12242);
    }
    
    public final boolean BV(int paramInt)
    {
      GMTrace.i(1643227643904L, 12243);
      a locala = SwipeBackLayout.a(SwipeBackLayout.this);
      if ((locala.ES & 1 << paramInt) != 0) {}
      for (int i = 1; (i != 0) && ((locala.EP[paramInt] & 0x1) != 0); i = 0)
      {
        GMTrace.o(1643227643904L, 12243);
        return true;
      }
      GMTrace.o(1643227643904L, 12243);
      return false;
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      GMTrace.i(1643630297088L, 12246);
      int i = paramView.getWidth();
      this.wvJ = 0;
      this.wvK = 0;
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.e(SwipeBackLayout.this) > SwipeBackLayout.h(SwipeBackLayout.this)))) {}
      int j;
      for (i = i + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth() + 10;; i = 0)
      {
        this.wvJ = i;
        v.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.wvJ), Integer.valueOf(this.wvK), Boolean.valueOf(SwipeBackLayout.b(SwipeBackLayout.this)) });
        SwipeBackLayout.b(SwipeBackLayout.this, true);
        if (!SwipeBackLayout.b(SwipeBackLayout.this)) {
          break label249;
        }
        paramView = SwipeBackLayout.a(SwipeBackLayout.this);
        i = this.wvJ;
        j = this.wvK;
        if (paramView.EZ) {
          break;
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
      }
      paramView.e(i, j, (int)y.a(paramView.fk, paramView.fl), (int)y.b(paramView.fk, paramView.fl));
      SwipeBackLayout.this.invalidate();
      GMTrace.o(1643630297088L, 12246);
      return;
      label249:
      SwipeBackLayout.c(SwipeBackLayout.this, true);
      GMTrace.o(1643630297088L, 12246);
    }
    
    public final int bZd()
    {
      GMTrace.i(1643361861632L, 12244);
      GMTrace.o(1643361861632L, 12244);
      return 1;
    }
    
    public final int d(View paramView, int paramInt)
    {
      GMTrace.i(1643764514816L, 12247);
      if (SwipeBackLayout.b(SwipeBackLayout.this))
      {
        paramInt = Math.max(this.wvI, paramInt);
        this.wvI = 0;
        paramInt = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
        GMTrace.o(1643764514816L, 12247);
        return paramInt;
      }
      this.wvI = Math.max(this.wvI, paramInt);
      GMTrace.o(1643764514816L, 12247);
      return 0;
    }
    
    public final void eg(int paramInt1, int paramInt2)
    {
      GMTrace.i(1643496079360L, 12245);
      if (!SwipeBackLayout.b(SwipeBackLayout.this))
      {
        GMTrace.o(1643496079360L, 12245);
        return;
      }
      SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.c(SwipeBackLayout.this).getWidth() + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth())));
      SwipeBackLayout.a(SwipeBackLayout.this, paramInt1);
      SwipeBackLayout.b(SwipeBackLayout.this, paramInt2);
      SwipeBackLayout.this.invalidate();
      if ((Float.compare(SwipeBackLayout.e(SwipeBackLayout.this), 1.0F) >= 0) && (!SwipeBackLayout.f(SwipeBackLayout.this)))
      {
        SwipeBackLayout.a(SwipeBackLayout.this, true);
        ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(1617055186944L, 12048);
            if (SwipeBackLayout.g(SwipeBackLayout.this) != null)
            {
              SwipeBackLayout.g(SwipeBackLayout.this).VD();
              v.d("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
            }
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            GMTrace.o(1617055186944L, 12048);
          }
        });
      }
      for (;;)
      {
        if (SwipeBackLayout.a(SwipeBackLayout.this).EK == 1) {
          j.ax(SwipeBackLayout.e(SwipeBackLayout.this));
        }
        GMTrace.o(1643496079360L, 12245);
        return;
        if (Float.compare(SwipeBackLayout.e(SwipeBackLayout.this), 0.01F) <= 0) {
          SwipeBackLayout.b(SwipeBackLayout.this, false);
        }
      }
    }
    
    public final void j(int paramInt)
    {
      GMTrace.i(1643898732544L, 12248);
      v.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(SwipeBackLayout.i(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.j(SwipeBackLayout.this)) });
      if (1 == paramInt)
      {
        v.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
        if ((SwipeBackLayout.this.getContext() instanceof Activity)) {
          ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(a.d.transparent);
        }
        if (SwipeBackLayout.g(SwipeBackLayout.this) != null) {
          SwipeBackLayout.g(SwipeBackLayout.this).VE();
        }
        SwipeBackLayout.a(SwipeBackLayout.this, false);
        if (SwipeBackLayout.b(SwipeBackLayout.this)) {
          j.ax(0.0F);
        }
      }
      if ((paramInt == 0) && (!SwipeBackLayout.j(SwipeBackLayout.this)))
      {
        v.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
        if (SwipeBackLayout.g(SwipeBackLayout.this) != null) {
          SwipeBackLayout.g(SwipeBackLayout.this).onCancel();
        }
        j.ax(1.0F);
      }
      Activity localActivity;
      boolean bool;
      if ((1 == paramInt) && (SwipeBackLayout.k(SwipeBackLayout.this)) && ((SwipeBackLayout.this.getContext() instanceof Activity)) && (!SwipeBackLayout.b(SwipeBackLayout.this)) && (!SwipeBackLayout.i(SwipeBackLayout.this)))
      {
        v.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
        SwipeBackLayout.d(SwipeBackLayout.this, true);
        localActivity = (Activity)SwipeBackLayout.this.getContext();
        if (d.ep(16)) {
          v.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        }
      }
      else
      {
        if (2 == paramInt)
        {
          v.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", new Object[] { Integer.valueOf(this.wvJ) });
          if (this.wvJ <= 0) {
            break label587;
          }
          bool = true;
          label337:
          j.u(bool, this.wvJ);
        }
        GMTrace.o(1643898732544L, 12248);
        return;
      }
      for (;;)
      {
        int i;
        try
        {
          Class[] arrayOfClass = Activity.class.getDeclaredClasses();
          int j = arrayOfClass.length;
          i = 0;
          Object localObject1 = null;
          if (i < j)
          {
            localObject2 = arrayOfClass[i];
            if (!((Class)localObject2).getSimpleName().contains("TranslucentConversionListener")) {
              break label599;
            }
            localObject1 = localObject2;
            break label599;
          }
          if (this == null) {
            break label593;
          }
          localObject2 = new b.b();
          ((b.b)localObject2).vdQ = new WeakReference(this);
          localObject2 = Proxy.newProxyInstance(((Class)localObject1).getClassLoader(), new Class[] { localObject1 }, (InvocationHandler)localObject2);
          if (!d.ep(21)) {
            break label532;
          }
          localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1 });
          ((Method)localObject1).setAccessible(true);
          ((Method)localObject1).invoke(localActivity, new Object[] { localObject2 });
        }
        catch (Throwable localThrowable)
        {
          v.printErrStackTrace("MicroMsg.ActivityUtil", localThrowable, "call convertActivityToTranslucent Fail: %s", new Object[] { localThrowable.getMessage() });
        }
        break;
        label532:
        Method localMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localThrowable, ActivityOptions.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localActivity, new Object[] { localObject2, null });
        break;
        label587:
        bool = false;
        break label337;
        label593:
        Object localObject2 = null;
        continue;
        label599:
        i += 1;
      }
    }
    
    public final void kD(final boolean paramBoolean)
    {
      GMTrace.i(1644032950272L, 12249);
      ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1613833961472L, 12024);
          v.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(SwipeBackLayout.b.this.wvJ) });
          SwipeBackLayout.d(SwipeBackLayout.this, paramBoolean);
          if (paramBoolean) {
            if (SwipeBackLayout.b.this.wvJ > 0)
            {
              j.ax(0.0F);
              SwipeBackLayout.this.lR(paramBoolean);
              if ((paramBoolean) && (SwipeBackLayout.j(SwipeBackLayout.this)))
              {
                if (SwipeBackLayout.b.this.wvJ != 0) {
                  break label192;
                }
                com.tencent.mm.ui.tools.j.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, 0.0F, new j.a()
                {
                  public final void bZy()
                  {
                    GMTrace.i(1615713009664L, 12038);
                    onAnimationEnd();
                    GMTrace.o(1615713009664L, 12038);
                  }
                  
                  public final void onAnimationEnd()
                  {
                    GMTrace.i(1615578791936L, 12037);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    GMTrace.o(1615578791936L, 12037);
                  }
                });
              }
            }
          }
          for (;;)
          {
            SwipeBackLayout.c(SwipeBackLayout.this, false);
            GMTrace.o(1613833961472L, 12024);
            return;
            j.ax(1.0F);
            break;
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            break;
            label192:
            com.tencent.mm.ui.tools.j.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, SwipeBackLayout.b.this.wvJ, new j.a()
            {
              public final void bZy()
              {
                GMTrace.i(1634771927040L, 12180);
                onAnimationEnd();
                GMTrace.o(1634771927040L, 12180);
              }
              
              public final void onAnimationEnd()
              {
                GMTrace.i(1634637709312L, 12179);
                SwipeBackLayout.a(SwipeBackLayout.this, true);
                ae.v(new Runnable()
                {
                  public final void run()
                  {
                    GMTrace.i(1641751248896L, 12232);
                    if (SwipeBackLayout.g(SwipeBackLayout.this) != null)
                    {
                      SwipeBackLayout.g(SwipeBackLayout.this).VD();
                      v.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                    }
                    j.ax(1.0F);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    GMTrace.o(1641751248896L, 12232);
                  }
                });
                GMTrace.o(1634637709312L, 12179);
              }
            });
            j.u(true, SwipeBackLayout.b.this.wvJ);
          }
        }
      });
      GMTrace.o(1644032950272L, 12249);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/SwipeBackLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */