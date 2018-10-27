package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.d;
import android.support.v4.view.ac;
import android.support.v4.view.s;
import android.support.v4.view.u;
import android.support.v4.view.v;
import android.support.v4.view.x;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListView;

public class SwipeRefreshLayout
  extends ViewGroup
  implements s, v
{
  private static final int[] l = { 16842766 };
  private static final String m = SwipeRefreshLayout.class.getSimpleName();
  private int A;
  private boolean B;
  private final u C;
  private final x D;
  private final int[] E = new int[2];
  private final int[] F = new int[2];
  private Animation.AnimationListener G = new am(this);
  private Animation H;
  private Animation I;
  private View J;
  private float K = -1.0F;
  private float L;
  private int M;
  public e a;
  public int b;
  public int c;
  public au d;
  public boolean e;
  public int f;
  public g g;
  public boolean h = false;
  public boolean i;
  public int j;
  public boolean k;
  private int n = -1;
  private Animation o;
  private Animation p;
  private final Animation q = new ar(this);
  private final Animation r = new as(this);
  private at s;
  private int t;
  private int u = -1;
  private int v;
  private final DecelerateInterpolator w;
  private float x;
  private float y;
  private boolean z;
  
  public SwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.M = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.A = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.w = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.t = ((int)(localDisplayMetrics.density * 40.0F));
    this.a = new e(getContext());
    this.g = new g(getContext());
    this.g.a(1);
    this.a.setImageDrawable(this.g);
    this.a.setVisibility(8);
    addView(this.a);
    setChildrenDrawingOrderEnabled(true);
    this.j = ((int)(localDisplayMetrics.density * 64.0F));
    this.K = this.j;
    this.D = new x();
    this.C = new u(this);
    setNestedScrollingEnabled(true);
    int i1 = -this.t;
    this.b = i1;
    this.f = i1;
    b(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, l);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private final Animation a(int paramInt1, int paramInt2)
  {
    ap localap = new ap(this, paramInt1, paramInt2);
    localap.setDuration(300L);
    e locale = this.a;
    locale.a = null;
    locale.clearAnimation();
    this.a.startAnimation(localap);
    return localap;
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.n) {
      if (i1 != 0) {
        break label33;
      }
    }
    label33:
    for (i1 = 1;; i1 = 0)
    {
      this.n = paramMotionEvent.getPointerId(i1);
      return;
    }
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.h != paramBoolean1)
    {
      this.e = paramBoolean2;
      b();
      this.h = paramBoolean1;
      if (this.h)
      {
        int i1 = this.b;
        Animation.AnimationListener localAnimationListener = this.G;
        this.c = i1;
        this.q.reset();
        this.q.setDuration(200L);
        this.q.setInterpolator(this.w);
        if (localAnimationListener != null) {
          this.a.a = localAnimationListener;
        }
        this.a.clearAnimation();
        this.a.startAnimation(this.q);
      }
    }
    else
    {
      return;
    }
    a(this.G);
  }
  
  private static boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private final void b()
  {
    if (this.J == null)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (localView.equals(this.a)) {
          i1 += 1;
        } else {
          this.J = localView;
        }
      }
    }
  }
  
  private final void c(float paramFloat)
  {
    this.g.a(true);
    float f2 = Math.min(1.0F, Math.abs(paramFloat / this.K));
    float f3 = (float)Math.max(f2 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.K;
    int i1 = this.v;
    if (i1 <= 0) {}
    for (float f1 = this.j;; f1 = i1)
    {
      double d1 = Math.max(0.0F, Math.min(f4 - f5, f1 + f1) / f1) / 4.0F;
      f4 = (float)(d1 - Math.pow(d1, 2.0D));
      f4 += f4;
      f5 = f1 * f4;
      i1 = this.f;
      int i2 = (int)(f1 * f2 + (f5 + f5));
      if (this.a.getVisibility() != 0) {
        this.a.setVisibility(0);
      }
      this.a.setScaleX(1.0F);
      this.a.setScaleY(1.0F);
      if (paramFloat < this.K) {
        if ((this.g.getAlpha() > 76) && (!a(this.p))) {
          this.p = a(this.g.getAlpha(), 76);
        }
      }
      for (;;)
      {
        this.g.b(Math.min(0.8F, f3 * 0.8F));
        this.g.a(Math.min(1.0F, f3));
        g localg = this.g;
        localg.b.m = ((f3 * 0.4F - 0.25F + (f4 + f4)) * 0.5F);
        localg.invalidateSelf();
        a(i2 + i1 - this.b);
        return;
        if ((this.g.getAlpha() < 255) && (!a(this.o))) {
          this.o = a(this.g.getAlpha(), 255);
        }
      }
    }
  }
  
  private final boolean c()
  {
    Object localObject = this.s;
    if (localObject != null) {
      return ((at)localObject).a();
    }
    localObject = this.J;
    if ((localObject instanceof ListView))
    {
      localObject = (ListView)localObject;
      if (Build.VERSION.SDK_INT >= 19) {
        return ((ListView)localObject).canScrollList(-1);
      }
      if (((ListView)localObject).getChildCount() != 0)
      {
        int i1 = ((ListView)localObject).getFirstVisiblePosition();
        int i2 = ((ListView)localObject).getChildAt(0).getTop();
        if ((i1 > 0) || (i2 < ((ListView)localObject).getListPaddingTop())) {
          return true;
        }
      }
      return false;
    }
    return ((View)localObject).canScrollVertically(-1);
  }
  
  private final void d(float paramFloat)
  {
    if (paramFloat > this.K)
    {
      a(true, true);
      return;
    }
    this.h = false;
    this.g.b(0.0F);
    aq localaq = new aq(this);
    this.c = this.b;
    this.r.reset();
    this.r.setDuration(200L);
    this.r.setInterpolator(this.w);
    e locale = this.a;
    locale.a = localaq;
    locale.clearAnimation();
    this.a.startAnimation(this.r);
    this.g.a(false);
  }
  
  private final void e(float paramFloat)
  {
    float f1 = this.x;
    float f2 = this.M;
    if ((paramFloat - f1 > f2) && (!this.z))
    {
      this.y = (f1 + f2);
      this.z = true;
      this.g.setAlpha(76);
    }
  }
  
  final void a()
  {
    this.a.clearAnimation();
    this.g.stop();
    this.a.setVisibility(8);
    this.a.getBackground().setAlpha(255);
    this.g.setAlpha(255);
    a(this.f - this.b);
    this.b = this.a.getTop();
  }
  
  final void a(float paramFloat)
  {
    this.a.setScaleX(paramFloat);
    this.a.setScaleY(paramFloat);
  }
  
  final void a(int paramInt)
  {
    this.a.bringToFront();
    ac.e(this.a, paramInt);
    this.b = this.a.getTop();
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    this.I = new ao(this);
    this.I.setDuration(150L);
    e locale = this.a;
    locale.a = paramAnimationListener;
    locale.clearAnimation();
    this.a.startAnimation(this.I);
  }
  
  final void b(float paramFloat)
  {
    int i1 = this.c;
    a(i1 + (int)((this.f - i1) * paramFloat) - this.a.getTop());
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.C.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.C.a(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.C.a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.C.a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i2 = this.u;
    int i1 = paramInt2;
    if (i2 >= 0)
    {
      if (paramInt2 == paramInt1 - 1) {
        break label34;
      }
      i1 = paramInt2;
      if (paramInt2 >= i2) {
        i1 = paramInt2 + 1;
      }
    }
    return i1;
    label34:
    return i2;
  }
  
  public int getNestedScrollAxes()
  {
    return this.D.a;
  }
  
  public int getProgressCircleDiameter()
  {
    return this.t;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.j;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.f;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.C.a(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.C.a;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    b();
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool1 = bool2;
    if (isEnabled())
    {
      bool1 = bool2;
      if (!c())
      {
        bool1 = bool2;
        if (!this.h)
        {
          bool1 = bool2;
          if (!this.B) {
            switch (i1)
            {
            }
          }
        }
      }
    }
    for (;;)
    {
      bool1 = this.z;
      do
      {
        do
        {
          return bool1;
          a(this.f - this.a.getTop());
          this.n = paramMotionEvent.getPointerId(0);
          this.z = false;
          i1 = paramMotionEvent.findPointerIndex(this.n);
          bool1 = bool2;
        } while (i1 < 0);
        this.x = paramMotionEvent.getY(i1);
        break;
        a(paramMotionEvent);
        break;
        i1 = this.n;
        if (i1 == -1)
        {
          Log.e(m, "Got ACTION_MOVE event but don't have an active pointer id.");
          return false;
        }
        i1 = paramMotionEvent.findPointerIndex(i1);
        bool1 = bool2;
      } while (i1 < 0);
      e(paramMotionEvent.getY(i1));
      continue;
      this.z = false;
      this.n = -1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() != 0)
    {
      if (this.J == null) {
        b();
      }
      Object localObject = this.J;
      if (localObject != null)
      {
        paramInt3 = getPaddingLeft();
        paramInt4 = getPaddingTop();
        ((View)localObject).layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
        paramInt3 = this.a.getMeasuredWidth();
        paramInt2 = this.a.getMeasuredHeight();
        localObject = this.a;
        paramInt1 /= 2;
        paramInt3 /= 2;
        paramInt4 = this.b;
        ((e)localObject).layout(paramInt1 - paramInt3, paramInt4, paramInt1 + paramInt3, paramInt4 + paramInt2);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.J == null) {
      b();
    }
    View localView = this.J;
    if (localView != null)
    {
      localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.a.measure(View.MeasureSpec.makeMeasureSpec(this.t, 1073741824), View.MeasureSpec.makeMeasureSpec(this.t, 1073741824));
      this.u = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount()) {
        if (getChildAt(paramInt1) != this.a) {
          paramInt1 += 1;
        } else {
          this.u = paramInt1;
        }
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (paramInt2 <= 0) {}
    float f1;
    do
    {
      paramView = this.F;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      return;
      f1 = this.L;
    } while (f1 <= 0.0F);
    float f2 = paramInt2;
    if (f2 > f1)
    {
      paramArrayOfInt[1] = (paramInt2 - (int)f1);
      this.L = 0.0F;
    }
    for (;;)
    {
      c(this.L);
      break;
      this.L = (f1 - f2);
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.E);
    paramInt1 = this.E[1] + paramInt4;
    if ((paramInt1 < 0) && (!c()))
    {
      float f1 = this.L;
      this.L = (Math.abs(paramInt1) + f1);
      c(this.L);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.D.a = paramInt;
    startNestedScroll(paramInt & 0x2);
    this.L = 0.0F;
    this.B = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.h) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.D.a = 0;
    this.B = false;
    float f1 = this.L;
    if (f1 > 0.0F)
    {
      d(f1);
      this.L = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool1 = bool2;
    if (isEnabled())
    {
      bool1 = bool2;
      if (!c())
      {
        bool1 = bool2;
        if (!this.h)
        {
          bool1 = bool2;
          if (!this.B)
          {
            bool1 = bool2;
            switch (i1)
            {
            }
          }
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      float f1;
      do
      {
        return bool1;
        i1 = paramMotionEvent.findPointerIndex(this.n);
        if (i1 < 0)
        {
          Log.e(m, "Got ACTION_UP event but don't have an active pointer id.");
          return false;
        }
        if (this.z)
        {
          f1 = paramMotionEvent.getY(i1);
          float f2 = this.y;
          this.z = false;
          d((f1 - f2) * 0.5F);
        }
        this.n = -1;
        return false;
        a(paramMotionEvent);
        break;
        i1 = paramMotionEvent.getActionIndex();
        if (i1 < 0)
        {
          Log.e(m, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
          return false;
        }
        this.n = paramMotionEvent.getPointerId(i1);
        break;
        i1 = paramMotionEvent.findPointerIndex(this.n);
        if (i1 < 0)
        {
          Log.e(m, "Got ACTION_MOVE event but have an invalid active pointer id.");
          return false;
        }
        f1 = paramMotionEvent.getY(i1);
        e(f1);
        if (!this.z) {
          break;
        }
        f1 = (f1 - this.y) * 0.5F;
        bool1 = bool2;
      } while (f1 <= 0.0F);
      c(f1);
      continue;
      this.n = paramMotionEvent.getPointerId(0);
      this.z = false;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      View localView = this.J;
      if ((localView == null) || (ac.F(localView))) {
        super.requestDisallowInterceptTouchEvent(paramBoolean);
      }
      do
      {
        return;
      } while ((this.J instanceof AbsListView));
    }
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    b();
    g localg = this.g;
    localg.b.a(paramVarArgs);
    localg.b.a(0);
    localg.invalidateSelf();
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    Context localContext = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i1 = 0;
    while (i1 < paramVarArgs.length)
    {
      arrayOfInt[i1] = d.c(localContext, paramVarArgs[i1]);
      i1 += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    this.K = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {
      a();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.C.a(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(at paramat)
  {
    this.s = paramat;
  }
  
  public void setOnRefreshListener(au paramau)
  {
    this.d = paramau;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    this.a.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(d.c(getContext(), paramInt));
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.h != paramBoolean))
    {
      this.h = paramBoolean;
      a(this.j + this.f - this.b);
      this.e = false;
      Animation.AnimationListener localAnimationListener = this.G;
      this.a.setVisibility(0);
      this.g.setAlpha(255);
      this.H = new an(this);
      this.H.setDuration(this.A);
      if (localAnimationListener != null) {
        this.a.a = localAnimationListener;
      }
      this.a.clearAnimation();
      this.a.startAnimation(this.H);
      return;
    }
    a(paramBoolean, false);
  }
  
  public void setSize(int paramInt)
  {
    if (paramInt == 0) {}
    while (paramInt == 1)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      if (paramInt == 0) {}
      for (this.t = ((int)(localDisplayMetrics.density * 56.0F));; this.t = ((int)(localDisplayMetrics.density * 40.0F)))
      {
        this.a.setImageDrawable(null);
        this.g.a(paramInt);
        this.a.setImageDrawable(this.g);
        return;
      }
    }
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    this.v = paramInt;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.C.a(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    this.C.b(0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/SwipeRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */