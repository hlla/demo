package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.b;
import android.support.v4.view.a.f;
import android.support.v4.view.a.f.c;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView
  extends FrameLayout
  implements p, r, w
{
  private static final a Dh = new a();
  private static final int[] Di = { 16843130 };
  private long CV;
  private i CW;
  private i CX;
  private boolean CY = true;
  private boolean CZ = false;
  private View Da = null;
  private boolean Db;
  private boolean Dc = true;
  private final int[] Dd = new int[2];
  private final int[] De = new int[2];
  private int Df;
  private SavedState Dg;
  private final s Dj;
  private final android.support.v4.view.q Dk;
  private float Dl;
  public b Dm;
  private final Rect eq = new Rect();
  private VelocityTracker fk;
  private int fl = -1;
  private q iB = q.a(getContext(), null);
  private boolean iC = false;
  private int iD;
  private int iE;
  private int yP;
  private int yQ;
  
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
    this.iE = localViewConfiguration.getScaledTouchSlop();
    this.yP = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.yQ = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Di, paramInt, 0);
    boolean bool = paramContext.getBoolean(0, false);
    if (bool != this.Db)
    {
      this.Db = bool;
      requestLayout();
    }
    paramContext.recycle();
    this.Dj = new s(this);
    this.Dk = new android.support.v4.view.q(this);
    setNestedScrollingEnabled(true);
    z.a(this, Dh);
  }
  
  private static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (a((View)paramView1, paramView2));
  }
  
  private boolean aC(View paramView)
  {
    boolean bool = false;
    if (!d(paramView, 0, getHeight())) {
      bool = true;
    }
    return bool;
  }
  
  private void aD(View paramView)
  {
    paramView.getDrawingRect(this.eq);
    offsetDescendantRectToMyCoords(paramView, this.eq);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.eq);
    if (i != 0) {
      scrollBy(0, i);
    }
  }
  
  private void ai(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.Dc) {
        smoothScrollBy(0, paramInt);
      }
    }
    else {
      return;
    }
    scrollBy(0, paramInt);
  }
  
  private void ak(int paramInt)
  {
    int i = getScrollY();
    if (((i > 0) || (paramInt > 0)) && ((i < cy()) || (paramInt < 0))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!dispatchNestedPreFling(0.0F, paramInt))
      {
        dispatchNestedFling(0.0F, paramInt, bool);
        if (bool) {
          fling(paramInt);
        }
      }
      return;
    }
  }
  
  private boolean arrowScroll(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int j = (int)(0.5F * getHeight());
    if ((localView2 != null) && (d(localView2, j, getHeight())))
    {
      localView2.getDrawingRect(this.eq);
      offsetDescendantRectToMyCoords(localView2, this.eq);
      ai(computeScrollDeltaToGetChildRectOnScreen(this.eq));
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()) && (aC(localView1)))
      {
        paramInt = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(paramInt);
      }
      return true;
    }
    int i;
    if ((paramInt == 33) && (getScrollY() < j)) {
      i = getScrollY();
    }
    while (i == 0)
    {
      return false;
      i = j;
      if (paramInt == 130)
      {
        i = j;
        if (getChildCount() > 0)
        {
          int k = getChildAt(0).getBottom();
          int m = getScrollY() + getHeight() - getPaddingBottom();
          i = j;
          if (k - m < j) {
            i = k - m;
          }
        }
      }
    }
    if (paramInt == 130) {}
    for (;;)
    {
      ai(i);
      break;
      i = -i;
    }
  }
  
  private void cA()
  {
    if (z.C(this) != 2)
    {
      if (this.CW == null)
      {
        Context localContext = getContext();
        this.CW = new i(localContext);
        this.CX = new i(localContext);
      }
      return;
    }
    this.CW = null;
    this.CX = null;
  }
  
  private int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int m = getHeight();
    int i = getScrollY();
    int k = i + m;
    int n = getVerticalFadingEdgeLength();
    int j = i;
    if (paramRect.top > 0) {
      j = i + n;
    }
    i = k;
    if (paramRect.bottom < getChildAt(0).getHeight()) {
      i = k - n;
    }
    if ((paramRect.bottom > i) && (paramRect.top > j)) {
      if (paramRect.height() > m)
      {
        j = paramRect.top - j + 0;
        i = Math.min(j, getChildAt(0).getBottom() - i);
      }
    }
    for (;;)
    {
      return i;
      j = paramRect.bottom - i + 0;
      break;
      if ((paramRect.top < j) && (paramRect.bottom < i))
      {
        if (paramRect.height() > m) {}
        for (i = 0 - (i - paramRect.bottom);; i = 0 - (j - paramRect.top))
        {
          i = Math.max(i, -getScrollY());
          break;
        }
      }
      i = 0;
    }
  }
  
  private void cw()
  {
    if (this.fk == null) {
      this.fk = VelocityTracker.obtain();
    }
  }
  
  private void cx()
  {
    if (this.fk != null)
    {
      this.fk.recycle();
      this.fk = null;
    }
  }
  
  private int cy()
  {
    int i = 0;
    if (getChildCount() > 0) {
      i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
    }
    return i;
  }
  
  private void cz()
  {
    this.iC = false;
    cx();
    stopNestedScroll();
    if (this.CW != null)
    {
      this.CW.cr();
      this.CX.cr();
    }
  }
  
  private static int d(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramInt2 >= paramInt3) || (paramInt1 < 0)) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt1;
    } while (paramInt2 + paramInt1 <= paramInt3);
    return paramInt3 - paramInt2;
  }
  
  private boolean d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool3 = false;
    z.C(this);
    computeHorizontalScrollRange();
    computeHorizontalScrollExtent();
    computeVerticalScrollRange();
    computeVerticalScrollExtent();
    paramInt1 = paramInt3 + paramInt1;
    paramInt2 = paramInt4 + paramInt2;
    paramInt3 = paramInt5 + 0;
    boolean bool1;
    if (paramInt1 > 0)
    {
      bool1 = true;
      paramInt1 = 0;
    }
    for (;;)
    {
      boolean bool2;
      if (paramInt2 > paramInt3)
      {
        paramInt2 = paramInt3;
        bool2 = true;
      }
      for (;;)
      {
        if (bool2) {
          this.iB.f(paramInt1, paramInt2, cy());
        }
        onOverScrolled(paramInt1, paramInt2, bool1, bool2);
        if (!bool1)
        {
          bool1 = bool3;
          if (!bool2) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
        if (paramInt1 >= 0) {
          break label140;
        }
        bool1 = true;
        paramInt1 = 0;
        break;
        if (paramInt2 < 0)
        {
          bool2 = true;
          paramInt2 = 0;
        }
        else
        {
          bool2 = false;
        }
      }
      label140:
      bool1 = false;
    }
  }
  
  private boolean d(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.eq);
    offsetDescendantRectToMyCoords(paramView, this.eq);
    return (this.eq.bottom + paramInt1 >= getScrollY()) && (this.eq.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private boolean e(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getHeight();
    int i1 = getScrollY();
    int i2 = i1 + i;
    int k;
    Object localObject1;
    int m;
    label53:
    Object localObject2;
    int n;
    int i4;
    int j;
    if (paramInt1 == 33)
    {
      k = 1;
      ArrayList localArrayList = getFocusables(2);
      localObject1 = null;
      i = 0;
      int i3 = localArrayList.size();
      m = 0;
      if (m >= i3) {
        break label237;
      }
      localObject2 = (View)localArrayList.get(m);
      n = ((View)localObject2).getTop();
      i4 = ((View)localObject2).getBottom();
      if ((paramInt2 >= i4) || (n >= paramInt3)) {
        break label312;
      }
      if ((paramInt2 >= n) || (i4 >= paramInt3)) {
        break label143;
      }
      j = 1;
      label115:
      if (localObject1 != null) {
        break label149;
      }
      localObject1 = localObject2;
      i = j;
    }
    label143:
    label149:
    label210:
    label237:
    label312:
    for (;;)
    {
      m += 1;
      break label53;
      k = 0;
      break;
      j = 0;
      break label115;
      if (((k != 0) && (n < ((View)localObject1).getTop())) || ((k == 0) && (i4 > ((View)localObject1).getBottom()))) {}
      for (n = 1;; n = 0)
      {
        if (i == 0) {
          break label210;
        }
        if ((j == 0) || (n == 0)) {
          break label312;
        }
        localObject1 = localObject2;
        break;
      }
      if (j != 0)
      {
        localObject1 = localObject2;
        i = 1;
      }
      else if (n != 0)
      {
        localObject1 = localObject2;
        continue;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this;
        }
        boolean bool;
        if ((paramInt2 >= i1) && (paramInt3 <= i2))
        {
          bool = false;
          if (localObject2 != findFocus()) {
            ((View)localObject2).requestFocus(paramInt1);
          }
          return bool;
        }
        if (k != 0) {
          paramInt2 -= i1;
        }
        for (;;)
        {
          ai(paramInt2);
          bool = true;
          break;
          paramInt2 = paramInt3 - i2;
        }
      }
    }
  }
  
  private boolean fullScroll(int paramInt)
  {
    if (paramInt == 130) {}
    for (int i = 1;; i = 0)
    {
      int j = getHeight();
      this.eq.top = 0;
      this.eq.bottom = j;
      if (i != 0)
      {
        i = getChildCount();
        if (i > 0)
        {
          View localView = getChildAt(i - 1);
          this.eq.bottom = (localView.getBottom() + getPaddingBottom());
          this.eq.top = (this.eq.bottom - j);
        }
      }
      return e(paramInt, this.eq.top, this.eq.bottom);
    }
  }
  
  private void h(MotionEvent paramMotionEvent)
  {
    int i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (o.c(paramMotionEvent, i) == this.fl) {
      if (i != 0) {
        break label64;
      }
    }
    label64:
    for (i = 1;; i = 0)
    {
      this.iD = ((int)o.e(paramMotionEvent, i));
      this.fl = o.c(paramMotionEvent, i);
      if (this.fk != null) {
        this.fk.clear();
      }
      return;
    }
  }
  
  private void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.CV > 250L)
    {
      paramInt1 = getHeight();
      int i = getPaddingBottom();
      int j = getPaddingTop();
      i = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - i - j));
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, i));
      q localq = this.iB;
      i = getScrollX();
      localq.Dw.a(localq.Dv, i, paramInt1, 0, paramInt2 - paramInt1);
      z.F(this);
    }
    for (;;)
    {
      this.CV = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!this.iB.isFinished()) {
        this.iB.abortAnimation();
      }
      scrollBy(paramInt1, paramInt2);
    }
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
  
  public final void aj(int paramInt)
  {
    smoothScrollBy(0 - getScrollX(), paramInt - getScrollY());
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll()
  {
    int k;
    int n;
    int i1;
    int i;
    if (this.iB.computeScrollOffset())
    {
      int j = getScrollX();
      k = getScrollY();
      int m = this.iB.getCurrX();
      n = this.iB.getCurrY();
      if ((j != m) || (k != n))
      {
        i1 = cy();
        i = z.C(this);
        if ((i != 0) && ((i != 1) || (i1 <= 0))) {
          break label128;
        }
        i = 1;
        d(m - j, n - k, j, k, i1);
        if (i != 0)
        {
          cA();
          if ((n > 0) || (k <= 0)) {
            break label133;
          }
          this.CW.ag((int)this.iB.getCurrVelocity());
        }
      }
    }
    label128:
    label133:
    while ((n < i1) || (k >= i1))
    {
      return;
      i = 0;
      break;
    }
    this.CX.ag((int)this.iB.getCurrVelocity());
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange()
  {
    int j = getChildCount();
    int i = getHeight() - getPaddingBottom() - getPaddingTop();
    if (j == 0) {}
    int k;
    int m;
    do
    {
      return i;
      j = getChildAt(0).getBottom();
      k = getScrollY();
      m = Math.max(0, j - i);
      if (k < 0) {
        return j - k;
      }
      i = j;
    } while (k <= m);
    return j + (k - m);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.Dk.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.Dk.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.Dk.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.Dk.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.CW != null)
    {
      int i = getScrollY();
      int j;
      int k;
      int m;
      if (!this.CW.isFinished())
      {
        j = paramCanvas.save();
        k = getWidth();
        m = getPaddingLeft();
        int n = getPaddingRight();
        paramCanvas.translate(getPaddingLeft(), Math.min(0, i));
        this.CW.setSize(k - m - n, getHeight());
        if (this.CW.draw(paramCanvas)) {
          z.F(this);
        }
        paramCanvas.restoreToCount(j);
      }
      if (!this.CX.isFinished())
      {
        j = paramCanvas.save();
        k = getWidth() - getPaddingLeft() - getPaddingRight();
        m = getHeight();
        paramCanvas.translate(-k + getPaddingLeft(), Math.max(cy(), i) + m);
        paramCanvas.rotate(180.0F, k, 0.0F);
        this.CX.setSize(k, m);
        if (this.CX.draw(paramCanvas)) {
          z.F(this);
        }
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  public final boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    this.eq.setEmpty();
    View localView = getChildAt(0);
    int i;
    boolean bool1;
    if (localView != null)
    {
      i = localView.getHeight();
      if (getHeight() < i + getPaddingTop() + getPaddingBottom())
      {
        i = 1;
        if (i != 0) {
          break label151;
        }
        bool1 = bool2;
        if (isFocused())
        {
          bool1 = bool2;
          if (paramKeyEvent.getKeyCode() != 4)
          {
            localView = findFocus();
            paramKeyEvent = localView;
            if (localView == this) {
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
      }
    }
    label151:
    do
    {
      return bool1;
      i = 0;
      break;
      i = 0;
      break;
      bool1 = bool2;
    } while (paramKeyEvent.getAction() != 0);
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    case 19: 
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(33);
      }
      return fullScroll(33);
    case 20: 
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(130);
      }
      return fullScroll(130);
    }
    int j;
    label265:
    int k;
    if (paramKeyEvent.isShiftPressed())
    {
      i = 33;
      if (i != 130) {
        break label383;
      }
      j = 1;
      k = getHeight();
      if (j == 0) {
        break label388;
      }
      this.eq.top = (getScrollY() + k);
      j = getChildCount();
      if (j > 0)
      {
        paramKeyEvent = getChildAt(j - 1);
        if (this.eq.top + k > paramKeyEvent.getBottom()) {
          this.eq.top = (paramKeyEvent.getBottom() - k);
        }
      }
    }
    for (;;)
    {
      this.eq.bottom = (k + this.eq.top);
      e(i, this.eq.top, this.eq.bottom);
      return false;
      i = 130;
      break;
      label383:
      j = 0;
      break label265;
      label388:
      this.eq.top = (getScrollY() - k);
      if (this.eq.top < 0) {
        this.eq.top = 0;
      }
    }
  }
  
  public void fling(int paramInt)
  {
    if (getChildCount() > 0)
    {
      int k = getHeight() - getPaddingBottom() - getPaddingTop();
      int m = getChildAt(0).getHeight();
      q localq = this.iB;
      int i = getScrollX();
      int j = getScrollY();
      m = Math.max(0, m - k);
      k /= 2;
      localq.Dw.a(localq.Dv, i, j, 0, paramInt, 0, 0, 0, m, 0, k);
      z.F(this);
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    j = getChildAt(0).getBottom() - getScrollY() - (j - k);
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public int getNestedScrollAxes()
  {
    return this.Dj.xn;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getScrollY();
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.Dk.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.Dk.xk;
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
  
  public void onAttachedToWindow()
  {
    this.CZ = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((o.g(paramMotionEvent) & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      if (!this.iC)
      {
        float f = o.f(paramMotionEvent, 9);
        if (f != 0.0F)
        {
          if (this.Dl == 0.0F)
          {
            paramMotionEvent = new TypedValue();
            Context localContext = getContext();
            if (!localContext.getTheme().resolveAttribute(16842829, paramMotionEvent, true)) {
              throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.Dl = paramMotionEvent.getDimension(localContext.getResources().getDisplayMetrics());
          }
          int i = (int)(f * this.Dl);
          int j = cy();
          int m = getScrollY();
          int k = m - i;
          if (k < 0) {
            i = 0;
          }
          while (i != m)
          {
            super.scrollTo(getScrollX(), i);
            return true;
            i = j;
            if (k <= j) {
              i = k;
            }
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.iC)) {
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      return this.iC;
      i = this.fl;
      if (i != -1)
      {
        int j = o.b(paramMotionEvent, i);
        if (j == -1)
        {
          new StringBuilder("Invalid pointerId=").append(i).append(" in onInterceptTouchEvent");
        }
        else
        {
          i = (int)o.e(paramMotionEvent, j);
          if ((Math.abs(i - this.iD) > this.iE) && ((getNestedScrollAxes() & 0x2) == 0))
          {
            this.iC = true;
            this.iD = i;
            cw();
            this.fk.addMovement(paramMotionEvent);
            this.Df = 0;
            paramMotionEvent = getParent();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              continue;
              j = (int)paramMotionEvent.getY();
              i = (int)paramMotionEvent.getX();
              if (getChildCount() > 0)
              {
                int k = getScrollY();
                View localView = getChildAt(0);
                if ((j >= localView.getTop() - k) && (j < localView.getBottom() - k) && (i >= localView.getLeft()) && (i < localView.getRight())) {
                  i = 1;
                }
              }
              for (;;)
              {
                if (i != 0) {
                  break label298;
                }
                this.iC = false;
                cx();
                break;
                i = 0;
                continue;
                i = 0;
              }
              label298:
              this.iD = j;
              this.fl = o.c(paramMotionEvent, 0);
              if (this.fk == null)
              {
                this.fk = VelocityTracker.obtain();
                label326:
                this.fk.addMovement(paramMotionEvent);
                this.iB.computeScrollOffset();
                if (this.iB.isFinished()) {
                  break label377;
                }
              }
              for (;;)
              {
                this.iC = bool;
                startNestedScroll(2);
                break;
                this.fk.clear();
                break label326;
                label377:
                bool = false;
              }
              this.iC = false;
              this.fl = -1;
              cx();
              if (this.iB.f(getScrollX(), getScrollY(), cy())) {
                z.F(this);
              }
              stopNestedScroll();
              continue;
              h(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.CY = false;
    if ((this.Da != null) && (a(this.Da, this))) {
      aD(this.Da);
    }
    this.Da = null;
    if (!this.CZ)
    {
      if (this.Dg != null)
      {
        scrollTo(getScrollX(), this.Dg.Dn);
        this.Dg = null;
      }
      if (getChildCount() <= 0) {
        break label153;
      }
      paramInt1 = getChildAt(0).getMeasuredHeight();
      paramInt1 = Math.max(0, paramInt1 - (paramInt4 - paramInt2 - getPaddingBottom() - getPaddingTop()));
      if (getScrollY() <= paramInt1) {
        break label158;
      }
      scrollTo(getScrollX(), paramInt1);
    }
    for (;;)
    {
      scrollTo(getScrollX(), getScrollY());
      this.CZ = true;
      return;
      label153:
      paramInt1 = 0;
      break;
      label158:
      if (getScrollY() < 0) {
        scrollTo(getScrollX(), 0);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.Db) {}
    View localView;
    do
    {
      do
      {
        return;
      } while ((View.MeasureSpec.getMode(paramInt2) == 0) || (getChildCount() <= 0));
      localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
    } while (localView.getMeasuredHeight() >= paramInt2);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 1073741824));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ak((int)paramFloat2);
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
    dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt, null);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getScrollY();
    scrollBy(0, paramInt4);
    paramInt1 = getScrollY() - paramInt1;
    dispatchNestedScroll(0, paramInt1, 0, paramInt4 - paramInt1, null);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.Dj.xn = paramInt;
    startNestedScroll(2);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i;
    View localView;
    if (paramInt == 2)
    {
      i = 130;
      if (paramRect != null) {
        break label44;
      }
      localView = FocusFinder.getInstance().findNextFocus(this, null, i);
      label24:
      if (localView != null) {
        break label58;
      }
    }
    label44:
    label58:
    while (aC(localView))
    {
      return false;
      i = paramInt;
      if (paramInt != 1) {
        break;
      }
      i = 33;
      break;
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i);
      break label24;
    }
    return localView.requestFocus(i, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Dg = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.Dn = getScrollY();
    return localSavedState;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Dm != null) {
      this.Dm.b(this);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView)) {}
    while (!d(localView, 0, paramInt4)) {
      return;
    }
    localView.getDrawingRect(this.eq);
    offsetDescendantRectToMyCoords(localView, this.eq);
    ai(computeScrollDeltaToGetChildRectOnScreen(this.eq));
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.Dj.xn = 0;
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    cw();
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i = o.d(paramMotionEvent);
    if (i == 0) {
      this.Df = 0;
    }
    localMotionEvent.offsetLocation(0.0F, this.Df);
    int k;
    int m;
    int j;
    switch (i)
    {
    case 4: 
    default: 
    case 0: 
    case 2: 
      ViewParent localViewParent;
      for (;;)
      {
        if (this.fk != null) {
          this.fk.addMovement(localMotionEvent);
        }
        localMotionEvent.recycle();
        return true;
        if (getChildCount() == 0) {
          return false;
        }
        if (!this.iB.isFinished()) {}
        for (boolean bool = true;; bool = false)
        {
          this.iC = bool;
          if (bool)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
          }
          if (!this.iB.isFinished()) {
            this.iB.abortAnimation();
          }
          this.iD = ((int)paramMotionEvent.getY());
          this.fl = o.c(paramMotionEvent, 0);
          startNestedScroll(2);
          break;
        }
        k = o.b(paramMotionEvent, this.fl);
        if (k != -1) {
          break;
        }
        new StringBuilder("Invalid pointerId=").append(this.fl).append(" in onTouchEvent");
      }
      m = (int)o.e(paramMotionEvent, k);
      j = this.iD - m;
      i = j;
      if (dispatchNestedPreScroll(0, j, this.De, this.Dd))
      {
        i = j - this.De[1];
        localMotionEvent.offsetLocation(0.0F, this.Dd[1]);
        this.Df += this.Dd[1];
      }
      if ((!this.iC) && (Math.abs(i) > this.iE))
      {
        localViewParent = getParent();
        if (localViewParent != null) {
          localViewParent.requestDisallowInterceptTouchEvent(true);
        }
        this.iC = true;
        if (i > 0) {
          i -= this.iE;
        }
      }
      break;
    }
    label374:
    while (this.iC)
    {
      this.iD = (m - this.Dd[1]);
      int n = getScrollY();
      m = cy();
      j = z.C(this);
      if ((j == 0) || ((j == 1) && (m > 0))) {}
      for (j = 1;; j = 0)
      {
        if ((d(0, i, 0, getScrollY(), m)) && (!hasNestedScrollingParent())) {
          this.fk.clear();
        }
        int i1 = getScrollY() - n;
        if (!dispatchNestedScroll(0, i1, 0, i - i1, this.Dd)) {
          break label546;
        }
        this.iD -= this.Dd[1];
        localMotionEvent.offsetLocation(0.0F, this.Dd[1]);
        this.Df += this.Dd[1];
        break;
        i += this.iE;
        break label374;
      }
      label546:
      if (j == 0) {
        break;
      }
      cA();
      j = n + i;
      if (j < 0)
      {
        this.CW.h(i / getHeight(), o.d(paramMotionEvent, k) / getWidth());
        if (!this.CX.isFinished()) {
          this.CX.cr();
        }
      }
      while ((this.CW != null) && ((!this.CW.isFinished()) || (!this.CX.isFinished())))
      {
        z.F(this);
        break;
        if (j > m)
        {
          this.CX.h(i / getHeight(), 1.0F - o.d(paramMotionEvent, k) / getWidth());
          if (!this.CW.isFinished()) {
            this.CW.cr();
          }
        }
      }
      if (this.iC)
      {
        paramMotionEvent = this.fk;
        paramMotionEvent.computeCurrentVelocity(1000, this.yQ);
        i = (int)y.b(paramMotionEvent, this.fl);
        if (Math.abs(i) <= this.yP) {
          break label763;
        }
        ak(-i);
      }
      for (;;)
      {
        this.fl = -1;
        cz();
        break;
        label763:
        if (this.iB.f(getScrollX(), getScrollY(), cy())) {
          z.F(this);
        }
      }
      if ((this.iC) && (getChildCount() > 0) && (this.iB.f(getScrollX(), getScrollY(), cy()))) {
        z.F(this);
      }
      this.fl = -1;
      cz();
      break;
      i = o.e(paramMotionEvent);
      this.iD = ((int)o.e(paramMotionEvent, i));
      this.fl = o.c(paramMotionEvent, i);
      break;
      h(paramMotionEvent);
      this.iD = ((int)o.e(paramMotionEvent, o.b(paramMotionEvent, this.fl)));
      break;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.CY) {
      aD(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      this.Da = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramBoolean) {
          break;
        }
        scrollBy(0, i);
      }
      return bool;
    }
    smoothScrollBy(0, i);
    return bool;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      cx();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.CY = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = d(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
      paramInt2 = d(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.Dk.setNestedScrollingEnabled(paramBoolean);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.Dk.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    this.Dk.stopNestedScroll();
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int Dn;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.Dn = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.Dn + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.Dn);
    }
  }
  
  static final class a
    extends android.support.v4.view.a
  {
    public final void a(View paramView, b paramb)
    {
      super.a(paramView, paramb);
      paramView = (NestedScrollView)paramView;
      paramb.setClassName(ScrollView.class.getName());
      if (paramView.isEnabled())
      {
        int i = NestedScrollView.a(paramView);
        if (i > 0)
        {
          paramb.setScrollable(true);
          if (paramView.getScrollY() > 0) {
            paramb.addAction(8192);
          }
          if (paramView.getScrollY() < i) {
            paramb.addAction(4096);
          }
        }
      }
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = (NestedScrollView)paramView;
      paramAccessibilityEvent.setClassName(ScrollView.class.getName());
      paramAccessibilityEvent = android.support.v4.view.a.a.a(paramAccessibilityEvent);
      if (NestedScrollView.a(paramView) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramAccessibilityEvent.setScrollable(bool);
        int i = paramView.getScrollX();
        f.Aq.g(paramAccessibilityEvent.Ar, i);
        i = paramView.getScrollY();
        f.Aq.h(paramAccessibilityEvent.Ar, i);
        i = paramView.getScrollX();
        f.Aq.j(paramAccessibilityEvent.Ar, i);
        i = NestedScrollView.a(paramView);
        f.Aq.k(paramAccessibilityEvent.Ar, i);
        return;
      }
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      paramView = (NestedScrollView)paramView;
      if (!paramView.isEnabled()) {
        return false;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 4096: 
        paramInt = Math.min(paramView.getHeight() - paramView.getPaddingBottom() - paramView.getPaddingTop() + paramView.getScrollY(), NestedScrollView.a(paramView));
        if (paramInt != paramView.getScrollY())
        {
          paramView.aj(paramInt);
          return true;
        }
        return false;
      }
      paramInt = paramView.getHeight();
      int i = paramView.getPaddingBottom();
      int j = paramView.getPaddingTop();
      paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
      if (paramInt != paramView.getScrollY())
      {
        paramView.aj(paramInt);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(NestedScrollView paramNestedScrollView);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/NestedScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */