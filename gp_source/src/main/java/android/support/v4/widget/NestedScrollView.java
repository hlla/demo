package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.ac;
import android.support.v4.view.t;
import android.support.v4.view.u;
import android.support.v4.view.w;
import android.support.v4.view.x;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView
  extends FrameLayout
  implements t, w
{
  private static final ah a = new ah();
  private static final int[] b = { 16843130 };
  private VelocityTracker A;
  private float B;
  private int c = -1;
  private final u d;
  private View e = null;
  private EdgeEffect f;
  private EdgeEffect g;
  private boolean h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = true;
  private int l;
  private long m;
  private int n;
  private int o;
  private int p;
  private int q;
  private ai r;
  private final x s;
  private NestedScrollView.SavedState t;
  private final int[] u = new int[2];
  private final int[] v = new int[2];
  private OverScroller w = new OverScroller(getContext());
  private boolean x = true;
  private final Rect y = new Rect();
  private int z;
  
  public NestedScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.z = localViewConfiguration.getScaledTouchSlop();
    this.p = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.o = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    this.s = new x();
    this.d = new u(this);
    setNestedScrollingEnabled(true);
    ac.a(this, a);
  }
  
  private final int a(Rect paramRect)
  {
    if (getChildCount() != 0)
    {
      int i4 = getHeight();
      int i1 = getScrollY();
      int i3 = i1 + i4;
      int i2 = getVerticalFadingEdgeLength();
      if (paramRect.top > 0) {
        i1 += i2;
      }
      for (;;)
      {
        View localView = getChildAt(0);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        if (paramRect.bottom < localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin) {}
        for (i2 = i3 - i2;; i2 = i3)
        {
          if ((paramRect.bottom > i2) && (paramRect.top > i1))
          {
            if (paramRect.height() > i4) {}
            for (i1 = paramRect.top - i1;; i1 = paramRect.bottom - i2)
            {
              i2 = localView.getBottom();
              return Math.min(i1, localLayoutParams.bottomMargin + i2 - i3);
            }
          }
          if (paramRect.top < i1)
          {
            if (paramRect.bottom < i2)
            {
              if (paramRect.height() > i4) {}
              for (i1 = -(i2 - paramRect.bottom);; i1 = -(i1 - paramRect.top)) {
                return Math.max(i1, -getScrollY());
              }
            }
            return 0;
          }
          return 0;
        }
      }
    }
    return 0;
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.c) {
      if (i1 != 0) {
        break label56;
      }
    }
    label56:
    for (i1 = 1;; i1 = 0)
    {
      this.l = ((int)paramMotionEvent.getY(i1));
      this.c = paramMotionEvent.getPointerId(i1);
      paramMotionEvent = this.A;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
      return;
    }
  }
  
  private final boolean a(int paramInt1, int paramInt2)
  {
    return this.d.a(paramInt1, paramInt2);
  }
  
  private final boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = getHeight();
    int i6 = getScrollY();
    int i7 = i6 + i1;
    if (paramInt1 != 33) {}
    for (int i4 = 0;; i4 = 1)
    {
      ArrayList localArrayList = getFocusables(2);
      int i8 = localArrayList.size();
      Object localObject1 = null;
      i1 = 0;
      int i5 = 0;
      if (i5 < i8)
      {
        localObject2 = (View)localArrayList.get(i5);
        int i3 = ((View)localObject2).getTop();
        int i9 = ((View)localObject2).getBottom();
        if (paramInt2 >= i9) {}
        while (i3 >= paramInt3)
        {
          i5 += 1;
          break;
        }
        int i2;
        if (paramInt2 >= i3) {
          i2 = 0;
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            localObject1 = localObject2;
            i1 = i2;
            break;
          }
          if ((i4 != 0) && (i3 < ((View)localObject1).getTop())) {
            i3 = 1;
          }
          for (;;)
          {
            if (i1 == 0)
            {
              if (i2 != 0)
              {
                localObject1 = localObject2;
                i1 = 1;
                break;
              }
              if (i3 != 0)
              {
                localObject1 = localObject2;
                break;
              }
              break;
            }
            if (i2 == 0) {
              break;
            }
            if (i3 != 0)
            {
              localObject1 = localObject2;
              break;
            }
            break;
            if (paramInt1 != 33)
            {
              if (i9 <= ((View)localObject1).getBottom()) {
                i3 = 0;
              } else {
                i3 = 1;
              }
            }
            else {
              i3 = 0;
            }
          }
          if (i9 < paramInt3) {
            i2 = 1;
          } else {
            i2 = 0;
          }
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this;
      }
      if (paramInt2 < i6) {
        if (paramInt1 != 33)
        {
          paramInt2 = paramInt3 - i7;
          label294:
          f(paramInt2);
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (localObject2 != findFocus()) {
          ((View)localObject2).requestFocus(paramInt1);
        }
        return bool;
        paramInt2 -= i6;
        break label294;
        if (paramInt3 > i7) {
          break;
        }
      }
    }
  }
  
  private final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getOverScrollMode();
    computeHorizontalScrollRange();
    computeHorizontalScrollExtent();
    computeVerticalScrollRange();
    computeVerticalScrollExtent();
    paramInt3 += paramInt1;
    boolean bool1;
    if (paramInt2 > 0)
    {
      paramInt1 = 0;
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      if (paramInt3 > paramInt4)
      {
        bool2 = true;
        paramInt2 = paramInt4;
      }
      for (;;)
      {
        if (!bool2) {}
        for (;;)
        {
          onOverScrolled(paramInt1, paramInt2, bool1, bool2);
          return (bool1) || (bool2);
          if (!c(1)) {
            this.w.springBack(paramInt1, paramInt2, 0, 0, 0, a());
          }
        }
        if (paramInt3 < 0)
        {
          bool2 = true;
          paramInt2 = 0;
        }
        else
        {
          bool2 = false;
          paramInt2 = paramInt3;
        }
      }
      if (paramInt2 < 0)
      {
        paramInt1 = 0;
        bool1 = true;
      }
      else
      {
        paramInt1 = paramInt2;
        bool1 = false;
      }
    }
  }
  
  private final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return this.d.a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  private final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return this.d.a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  private final boolean a(View paramView)
  {
    return a(paramView, 0, getHeight()) ^ true;
  }
  
  private final boolean a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.y);
    offsetDescendantRectToMyCoords(paramView, this.y);
    return (this.y.bottom + paramInt1 >= getScrollY()) && (this.y.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 != paramView2)
    {
      paramView1 = paramView1.getParent();
      return ((paramView1 instanceof ViewGroup)) && (a((View)paramView1, paramView2));
    }
    return true;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < paramInt3) && (paramInt1 >= 0))
    {
      int i1 = paramInt1;
      if (paramInt2 + paramInt1 > paramInt3) {
        i1 = paramInt3 - paramInt2;
      }
      return i1;
    }
    return 0;
  }
  
  private final void b()
  {
    if (this.A == null) {
      this.A = VelocityTracker.obtain();
    }
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    if (getChildCount() != 0)
    {
      if (AnimationUtils.currentAnimationTimeMillis() - this.m <= 250L) {
        break label149;
      }
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i1 = localView.getHeight();
      int i2 = localLayoutParams.topMargin;
      int i3 = localLayoutParams.bottomMargin;
      int i4 = getHeight();
      int i5 = getPaddingTop();
      int i6 = getPaddingBottom();
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, Math.max(0, i3 + (i1 + i2) - (i4 - i5 - i6))));
      this.n = getScrollY();
      this.w.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1);
      ac.e(this);
    }
    for (;;)
    {
      this.m = AnimationUtils.currentAnimationTimeMillis();
      return;
      label149:
      if (!this.w.isFinished()) {
        this.w.abortAnimation();
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  private final void b(View paramView)
  {
    paramView.getDrawingRect(this.y);
    offsetDescendantRectToMyCoords(paramView, this.y);
    int i1 = a(this.y);
    if (i1 != 0) {
      scrollBy(0, i1);
    }
  }
  
  private final void c()
  {
    VelocityTracker localVelocityTracker = this.A;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.A = null;
    }
  }
  
  private final boolean c(int paramInt)
  {
    return this.d.a(paramInt);
  }
  
  private final void d()
  {
    this.i = false;
    c();
    n_(0);
    EdgeEffect localEdgeEffect = this.g;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      this.f.onRelease();
    }
  }
  
  private final boolean d(int paramInt)
  {
    int i1 = getHeight();
    this.y.top = 0;
    this.y.bottom = i1;
    if (paramInt == 130)
    {
      int i2 = getChildCount();
      if (i2 > 0)
      {
        Object localObject = getChildAt(i2 - 1);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        Rect localRect = this.y;
        i2 = ((View)localObject).getBottom();
        localRect.bottom = (localLayoutParams.bottomMargin + i2 + getPaddingBottom());
        localObject = this.y;
        ((Rect)localObject).top = (((Rect)localObject).bottom - i1);
      }
    }
    return a(paramInt, this.y.top, this.y.bottom);
  }
  
  private final void e()
  {
    if (getOverScrollMode() != 2)
    {
      if (this.g == null)
      {
        Context localContext = getContext();
        this.g = new EdgeEffect(localContext);
        this.f = new EdgeEffect(localContext);
      }
      return;
    }
    this.g = null;
    this.f = null;
  }
  
  private final boolean e(int paramInt)
  {
    View localView1 = findFocus();
    if (localView1 == this) {
      localView1 = null;
    }
    for (;;)
    {
      View localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
      int i1 = getMaxScrollAmount();
      label56:
      int i2;
      if (localView2 == null) {
        if ((paramInt == 33) && (getScrollY() < i1))
        {
          i1 = getScrollY();
          if (i1 != 0)
          {
            i2 = i1;
            if (paramInt != 130) {
              i2 = -i1;
            }
            f(i2);
          }
        }
      }
      for (;;)
      {
        if ((localView1 != null) && (localView1.isFocused()) && (a(localView1)))
        {
          paramInt = getDescendantFocusability();
          setDescendantFocusability(131072);
          requestFocus();
          setDescendantFocusability(paramInt);
        }
        return true;
        return false;
        if (paramInt == 130)
        {
          if (getChildCount() > 0)
          {
            localView2 = getChildAt(0);
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView2.getLayoutParams();
            i2 = localView2.getBottom();
            i1 = Math.min(localLayoutParams.bottomMargin + i2 - (getScrollY() + getHeight() - getPaddingBottom()), i1);
            break label56;
          }
          break label56;
        }
        break label56;
        if (!a(localView2, i1, getHeight())) {
          break;
        }
        localView2.getDrawingRect(this.y);
        offsetDescendantRectToMyCoords(localView2, this.y);
        f(a(this.y));
        localView2.requestFocus(paramInt);
      }
    }
  }
  
  private final void f(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.x) {
        b(0, paramInt);
      }
    }
    else {
      return;
    }
    scrollBy(0, paramInt);
  }
  
  private final void g(int paramInt)
  {
    int i1 = getScrollY();
    boolean bool;
    if (i1 > 0) {
      if (i1 < a()) {
        bool = true;
      }
    }
    for (;;)
    {
      float f1 = paramInt;
      if (!dispatchNestedPreFling(0.0F, f1))
      {
        dispatchNestedFling(0.0F, f1, bool);
        if (getChildCount() > 0)
        {
          a(2, 1);
          this.w.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
          this.n = getScrollY();
          ac.e(this);
        }
      }
      return;
      if (paramInt < 0)
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        if (paramInt > 0) {
          break;
        }
        bool = false;
      }
    }
  }
  
  final int a()
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i1 = localView.getHeight();
      int i2 = localLayoutParams.topMargin;
      return Math.max(0, localLayoutParams.bottomMargin + (i1 + i2) - (getHeight() - getPaddingTop() - getPaddingBottom()));
    }
    return 0;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt1 = getScrollY();
    scrollBy(0, paramInt4);
    paramInt1 = getScrollY() - paramInt1;
    a(0, paramInt1, 0, paramInt4 - paramInt1, null, paramInt5);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    a(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    int i1 = 33;
    boolean bool2 = false;
    this.y.setEmpty();
    Object localObject;
    int i2;
    int i3;
    boolean bool1;
    if (getChildCount() > 0)
    {
      localObject = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      i2 = ((View)localObject).getHeight();
      i3 = localLayoutParams.topMargin;
      if (localLayoutParams.bottomMargin + (i2 + i3) > getHeight() - getPaddingTop() - getPaddingBottom()) {}
    }
    else
    {
      bool1 = bool2;
      if (isFocused())
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 4)
        {
          localObject = findFocus();
          paramKeyEvent = (KeyEvent)localObject;
          if (localObject == this) {
            paramKeyEvent = null;
          }
          paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
          bool1 = bool2;
          if (paramKeyEvent != null)
          {
            bool1 = bool2;
            if (paramKeyEvent != this)
            {
              bool1 = bool2;
              if (paramKeyEvent.requestFocus(130)) {
                bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
    }
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      return bool1;
      if (!paramKeyEvent.isAltPressed())
      {
        bool1 = e(33);
      }
      else
      {
        bool1 = d(33);
        continue;
        if (!paramKeyEvent.isShiftPressed()) {
          i1 = 130;
        }
        i2 = getHeight();
        if (i1 == 130)
        {
          this.y.top = (getScrollY() + i2);
          i3 = getChildCount();
          if (i3 > 0)
          {
            paramKeyEvent = getChildAt(i3 - 1);
            localObject = (FrameLayout.LayoutParams)paramKeyEvent.getLayoutParams();
            i3 = paramKeyEvent.getBottom();
            i3 = ((FrameLayout.LayoutParams)localObject).bottomMargin + i3 + getPaddingBottom();
            if (this.y.top + i2 > i3) {
              this.y.top = (i3 - i2);
            }
          }
        }
        for (;;)
        {
          paramKeyEvent = this.y;
          paramKeyEvent.bottom = (paramKeyEvent.top + i2);
          a(i1, this.y.top, this.y.bottom);
          return false;
          this.y.top = (getScrollY() - i2);
          if (this.y.top < 0) {
            this.y.top = 0;
          }
        }
        if (!paramKeyEvent.isAltPressed())
        {
          bool1 = e(130);
        }
        else
        {
          bool1 = d(130);
          continue;
          bool1 = false;
        }
      }
    }
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0x2) != 0;
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramLayoutParams);
  }
  
  public final void b(int paramInt)
  {
    b(-getScrollX(), paramInt - getScrollY());
  }
  
  public final void b(View paramView, int paramInt)
  {
    this.s.a = 0;
    n_(paramInt);
  }
  
  public final void b(View paramView, int paramInt1, int paramInt2)
  {
    this.s.a = paramInt1;
    a(2, paramInt2);
  }
  
  public void computeScroll()
  {
    if (this.w.computeScrollOffset())
    {
      this.w.getCurrX();
      int i3 = this.w.getCurrY();
      int i2 = i3 - this.n;
      int i1 = i2;
      if (a(0, i2, this.u, null, 1)) {
        i1 = i2 - this.u[1];
      }
      int i4;
      if (i1 != 0)
      {
        i2 = a();
        i4 = getScrollY();
        a(i1, getScrollX(), i4, i2);
        int i5 = getScrollY() - i4;
        if (!a(0, i5, 0, i1 - i5, null, 1))
        {
          i1 = getOverScrollMode();
          if (i1 != 0) {
            break label189;
          }
        }
      }
      for (;;)
      {
        e();
        if (i3 > 0) {
          if ((i3 >= i2) && (i4 < i2)) {
            this.f.onAbsorb((int)this.w.getCurrVelocity());
          }
        }
        label189:
        do
        {
          for (;;)
          {
            this.n = i3;
            ac.e(this);
            return;
            if (i4 <= 0) {
              break;
            }
            this.g.onAbsorb((int)this.w.getCurrVelocity());
          }
        } while ((i1 != 1) || (i2 <= 0));
      }
    }
    if (c(1)) {
      n_(1);
    }
    this.n = 0;
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange()
  {
    int i2 = getChildCount();
    int i1 = getHeight() - getPaddingBottom() - getPaddingTop();
    if (i2 != 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      i2 = localView.getBottom();
      i2 = localLayoutParams.bottomMargin + i2;
      int i3 = getScrollY();
      int i4 = Math.max(0, i2 - i1);
      if (i3 < 0) {
        i1 = i2 - i3;
      }
      do
      {
        return i1;
        i1 = i2;
      } while (i3 <= i4);
      return i2 + (i3 - i4);
    }
    return i1;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.d.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.d.a(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i5 = 0;
    super.draw(paramCanvas);
    int i8;
    int i9;
    int i2;
    int i7;
    int i6;
    if (this.g != null)
    {
      i8 = getScrollY();
      if (!this.g.isFinished())
      {
        i9 = paramCanvas.save();
        i2 = getWidth();
        i7 = getHeight();
        i6 = Math.min(0, i8);
        if ((Build.VERSION.SDK_INT >= 21) && (!getClipToPadding())) {
          break label376;
        }
        i2 -= getPaddingLeft() + getPaddingRight();
      }
    }
    label294:
    label376:
    for (int i1 = getPaddingLeft();; i1 = 0)
    {
      int i4;
      int i3;
      if (Build.VERSION.SDK_INT < 21)
      {
        i4 = i7;
        i3 = i6;
      }
      for (;;)
      {
        paramCanvas.translate(i1, i3);
        this.g.setSize(i2, i4);
        if (this.g.draw(paramCanvas)) {
          ac.e(this);
        }
        paramCanvas.restoreToCount(i9);
        if (!this.f.isFinished())
        {
          i9 = paramCanvas.save();
          i3 = getWidth();
          i6 = getHeight();
          i7 = Math.max(a(), i8) + i6;
          if (Build.VERSION.SDK_INT >= 21)
          {
            i1 = i3;
            i2 = i5;
            if (!getClipToPadding()) {}
          }
          else
          {
            i1 = i3 - (getPaddingLeft() + getPaddingRight());
            i2 = getPaddingLeft();
          }
          if (Build.VERSION.SDK_INT >= 21) {
            break label294;
          }
          i4 = i6;
          i3 = i7;
        }
        for (;;)
        {
          paramCanvas.translate(i2 - i1, i3);
          paramCanvas.rotate(180.0F, i1, 0.0F);
          this.f.setSize(i1, i4);
          if (this.f.draw(paramCanvas)) {
            ac.e(this);
          }
          paramCanvas.restoreToCount(i9);
          return;
          i3 = i7;
          i4 = i6;
          if (getClipToPadding())
          {
            i4 = i6 - (getPaddingTop() + getPaddingBottom());
            i3 = i7 - getPaddingBottom();
          }
        }
        i3 = i6;
        i4 = i7;
        if (getClipToPadding())
        {
          i4 = i7 - (getPaddingTop() + getPaddingBottom());
          i3 = i6 + getPaddingTop();
        }
      }
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() != 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i1 = getVerticalFadingEdgeLength();
      int i2 = getHeight();
      int i3 = getPaddingBottom();
      int i4 = localView.getBottom();
      i2 = localLayoutParams.bottomMargin + i4 - getScrollY() - (i2 - i3);
      if (i2 < i1) {
        return i2 / i1;
      }
      return 1.0F;
    }
    return 0.0F;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)(getHeight() * 0.5F);
  }
  
  public int getNestedScrollAxes()
  {
    return this.s.a;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() != 0)
    {
      int i1 = getVerticalFadingEdgeLength();
      int i2 = getScrollY();
      if (i2 < i1) {
        return i2 / i1;
      }
      return 1.0F;
    }
    return 0.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return c(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.d.a;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramInt1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = localMarginLayoutParams.topMargin;
    paramView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.bottomMargin + paramInt2, 0));
  }
  
  public final void n_(int paramInt)
  {
    this.d.b(paramInt);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.j = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      if (!this.i)
      {
        float f1 = paramMotionEvent.getAxisValue(9);
        if (f1 != 0.0F)
        {
          if (this.B == 0.0F)
          {
            paramMotionEvent = new TypedValue();
            Context localContext = getContext();
            if (!localContext.getTheme().resolveAttribute(16842829, paramMotionEvent, true)) {
              throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.B = paramMotionEvent.getDimension(localContext.getResources().getDisplayMetrics());
          }
          float f2 = this.B;
          int i2 = a();
          int i4 = getScrollY();
          int i3 = i4 - (int)(f1 * f2);
          int i1;
          if (i3 < 0) {
            i1 = 0;
          }
          while (i1 != i4)
          {
            super.scrollTo(getScrollX(), i1);
            return true;
            i1 = i2;
            if (i3 <= i2) {
              i1 = i3;
            }
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 2) {}
    while (!this.i)
    {
      switch (i1 & 0xFF)
      {
      }
      for (;;)
      {
        return this.i;
        this.i = false;
        this.c = -1;
        c();
        if (this.w.springBack(getScrollX(), getScrollY(), 0, 0, 0, a())) {
          ac.e(this);
        }
        n_(0);
        continue;
        a(paramMotionEvent);
        continue;
        i1 = this.c;
        if (i1 != -1)
        {
          int i2 = paramMotionEvent.findPointerIndex(i1);
          if (i2 == -1)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("Invalid pointerId=");
            paramMotionEvent.append(i1);
            paramMotionEvent.append(" in onInterceptTouchEvent");
            Log.e("NestedScrollView", paramMotionEvent.toString());
          }
          else
          {
            i1 = (int)paramMotionEvent.getY(i2);
            if ((Math.abs(i1 - this.l) > this.z) && ((getNestedScrollAxes() & 0x2) == 0))
            {
              this.i = true;
              this.l = i1;
              b();
              this.A.addMovement(paramMotionEvent);
              this.q = 0;
              paramMotionEvent = getParent();
              if (paramMotionEvent != null)
              {
                paramMotionEvent.requestDisallowInterceptTouchEvent(true);
                continue;
                i1 = (int)paramMotionEvent.getY();
                i2 = (int)paramMotionEvent.getX();
                if (getChildCount() > 0)
                {
                  int i3 = getScrollY();
                  localObject = getChildAt(0);
                  if ((i1 >= ((View)localObject).getTop() - i3) && (i1 < ((View)localObject).getBottom() - i3) && (i2 >= ((View)localObject).getLeft()) && (i2 < ((View)localObject).getRight())) {
                    break;
                  }
                }
                this.i = false;
                c();
              }
            }
          }
        }
      }
      this.l = i1;
      this.c = paramMotionEvent.getPointerId(0);
      Object localObject = this.A;
      if (localObject == null) {
        this.A = VelocityTracker.obtain();
      }
      for (;;)
      {
        this.A.addMovement(paramMotionEvent);
        this.w.computeScrollOffset();
        this.i = (this.w.isFinished() ^ true);
        a(2, 0);
        break;
        ((VelocityTracker)localObject).clear();
      }
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.k = false;
    View localView = this.e;
    if ((localView != null) && (a(localView, this))) {
      b(this.e);
    }
    this.e = null;
    if (!this.j)
    {
      if (this.t != null)
      {
        scrollTo(getScrollX(), this.t.a);
        this.t = null;
      }
      paramInt1 = i1;
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        paramInt1 = localView.getMeasuredHeight();
        paramInt3 = localLayoutParams.topMargin;
        paramInt1 = localLayoutParams.bottomMargin + (paramInt1 + paramInt3);
      }
      i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      paramInt3 = getScrollY();
      paramInt1 = b(paramInt3, paramInt4 - paramInt2 - i1 - i2, paramInt1);
      if (paramInt1 != paramInt3) {
        scrollTo(getScrollX(), paramInt1);
      }
    }
    scrollTo(getScrollX(), getScrollY());
    this.j = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.h) && (View.MeasureSpec.getMode(paramInt2) != 0) && (getChildCount() > 0))
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      paramInt2 = localView.getMeasuredHeight();
      int i1 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - localLayoutParams.topMargin - localLayoutParams.bottomMargin;
      if (paramInt2 < i1) {
        localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      g((int)paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    b(paramView2, paramInt, 0);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    boolean bool2 = false;
    if (paramInt != 2)
    {
      i1 = paramInt;
      if (paramInt != 1) {}
    }
    for (int i1 = 33;; i1 = 130)
    {
      if (paramRect != null) {}
      for (View localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i1);; localView = FocusFinder.getInstance().findNextFocus(this, null, i1))
      {
        boolean bool1 = bool2;
        if (localView != null)
        {
          bool1 = bool2;
          if (!a(localView)) {
            bool1 = localView.requestFocus(i1, paramRect);
          }
        }
        return bool1;
      }
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof NestedScrollView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (NestedScrollView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.t = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    NestedScrollView.SavedState localSavedState = new NestedScrollView.SavedState(super.onSaveInstanceState());
    localSavedState.a = getScrollY();
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ai localai = this.r;
    if (localai != null) {
      localai.a(this);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView != null) && (this != localView) && (a(localView, 0, paramInt4)))
    {
      localView.getDrawingRect(this.y);
      offsetDescendantRectToMyCoords(localView, this.y);
      f(a(this.y));
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return a(paramView1, paramView2, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    b(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    b();
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0) {
      this.q = 0;
    }
    localMotionEvent.offsetLocation(0.0F, this.q);
    switch (i1)
    {
    }
    for (;;)
    {
      paramMotionEvent = this.A;
      if (paramMotionEvent != null) {
        paramMotionEvent.addMovement(localMotionEvent);
      }
      localMotionEvent.recycle();
      return true;
      a(paramMotionEvent);
      this.l = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.c)));
      continue;
      i1 = paramMotionEvent.getActionIndex();
      this.l = ((int)paramMotionEvent.getY(i1));
      this.c = paramMotionEvent.getPointerId(i1);
      continue;
      if ((this.i) && (getChildCount() > 0) && (this.w.springBack(getScrollX(), getScrollY(), 0, 0, 0, a()))) {
        ac.e(this);
      }
      this.c = -1;
      d();
      continue;
      int i3 = paramMotionEvent.findPointerIndex(this.c);
      if (i3 == -1)
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("Invalid pointerId=");
        paramMotionEvent.append(this.c);
        paramMotionEvent.append(" in onTouchEvent");
        Log.e("NestedScrollView", paramMotionEvent.toString());
      }
      else
      {
        int i4 = (int)paramMotionEvent.getY(i3);
        int i2 = this.l - i4;
        i1 = i2;
        if (a(0, i2, this.u, this.v, 0))
        {
          i1 = i2 - this.u[1];
          localMotionEvent.offsetLocation(0.0F, this.v[1]);
          this.q += this.v[1];
        }
        ViewParent localViewParent;
        if (!this.i) {
          if (Math.abs(i1) > this.z)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
            this.i = true;
            if (i1 > 0) {
              i1 -= this.z;
            }
          }
        }
        while (this.i)
        {
          this.l = (i4 - this.v[1]);
          int i5 = getScrollY();
          i4 = a();
          i2 = getOverScrollMode();
          if (i2 == 0) {
            i2 = 1;
          }
          for (;;)
          {
            if ((a(i1, 0, getScrollY(), i4)) && (!c(0))) {
              this.A.clear();
            }
            int i6 = getScrollY() - i5;
            if (a(0, i6, 0, i1 - i6, this.v, 0))
            {
              i1 = this.l;
              i2 = this.v[1];
              this.l = (i1 - i2);
              localMotionEvent.offsetLocation(0.0F, i2);
              this.q += this.v[1];
              break;
            }
            if (i2 == 0) {
              break;
            }
            e();
            i2 = i5 + i1;
            if (i2 < 0)
            {
              aa.a(this.g, i1 / getHeight(), paramMotionEvent.getX(i3) / getWidth());
              if (!this.f.isFinished()) {
                this.f.onRelease();
              }
            }
            for (;;)
            {
              paramMotionEvent = this.g;
              if ((paramMotionEvent == null) || ((paramMotionEvent.isFinished()) && (this.f.isFinished()))) {
                break;
              }
              ac.e(this);
              break;
              if (i2 > i4)
              {
                aa.a(this.f, i1 / getHeight(), 1.0F - paramMotionEvent.getX(i3) / getWidth());
                if (!this.g.isFinished()) {
                  this.g.onRelease();
                }
              }
            }
            if (i2 != 1) {
              i2 = 0;
            } else if (i4 <= 0) {
              i2 = 0;
            } else {
              i2 = 1;
            }
          }
          i1 += this.z;
          continue;
        }
        paramMotionEvent = this.A;
        paramMotionEvent.computeCurrentVelocity(1000, this.o);
        i1 = (int)paramMotionEvent.getYVelocity(this.c);
        if (Math.abs(i1) > this.p) {
          g(-i1);
        }
        for (;;)
        {
          this.c = -1;
          d();
          break;
          if (this.w.springBack(getScrollX(), getScrollY(), 0, 0, 0, a())) {
            ac.e(this);
          }
        }
        if (getChildCount() == 0) {
          break;
        }
        boolean bool = this.w.isFinished() ^ true;
        this.i = bool;
        if (bool)
        {
          localViewParent = getParent();
          if (localViewParent != null) {
            localViewParent.requestDisallowInterceptTouchEvent(true);
          }
        }
        if (!this.w.isFinished()) {
          this.w.abortAnimation();
        }
        this.l = ((int)paramMotionEvent.getY());
        this.c = paramMotionEvent.getPointerId(0);
        a(2, 0);
      }
    }
    return false;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.k) {
      b(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      this.e = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i1 = a(paramRect);
    if (i1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramBoolean) {
          b(0, i1);
        }
      }
      else {
        return bool;
      }
      scrollBy(0, i1);
      return bool;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      c();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.k = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i7 = getWidth();
      int i8 = getPaddingLeft();
      int i9 = getPaddingRight();
      int i10 = localView.getWidth();
      int i11 = localLayoutParams.leftMargin;
      int i12 = localLayoutParams.rightMargin;
      int i1 = getHeight();
      int i2 = getPaddingTop();
      int i3 = getPaddingBottom();
      int i4 = localView.getHeight();
      int i5 = localLayoutParams.topMargin;
      int i6 = localLayoutParams.bottomMargin;
      paramInt1 = b(paramInt1, i7 - i8 - i9, i10 + i11 + i12);
      paramInt2 = b(paramInt2, i1 - i2 - i3, i6 + (i4 + i5));
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != this.h)
    {
      this.h = paramBoolean;
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }
  
  public void setOnScrollChangeListener(ai paramai)
  {
    this.r = paramai;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return a(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    n_(0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/NestedScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */