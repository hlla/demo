package android.support.v7.widget;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ac;
import android.support.v4.view.v;
import android.support.v4.view.x;
import android.support.v7.view.menu.ag;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements v, bi
{
  private static final int[] f = { 2130968579, 16842841 };
  private Drawable A;
  private int B = 0;
  public ActionBarContainer a;
  public boolean b;
  public ViewPropertyAnimator c;
  public boolean d;
  public final AnimatorListenerAdapter e = new e(this);
  private int g;
  private h h;
  private final Runnable i = new g(this);
  private final Rect j = new Rect();
  private final Rect k = new Rect();
  private ContentFrameLayout l;
  private final Rect m = new Rect();
  private bj n;
  private OverScroller o;
  private boolean p;
  private boolean q;
  private int r;
  private boolean s;
  private final Rect t = new Rect();
  private final Rect u = new Rect();
  private final Rect v = new Rect();
  private final Rect w = new Rect();
  private int x;
  private final x y;
  private final Runnable z = new f(this);
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.y = new x();
  }
  
  private final void a(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(f);
    this.g = localTypedArray.getDimensionPixelSize(0, 0);
    this.A = localTypedArray.getDrawable(1);
    if (this.A == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      setWillNotDraw(bool1);
      localTypedArray.recycle();
      if (paramContext.getApplicationInfo().targetSdkVersion < 19) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.s = bool1;
        this.o = new OverScroller(paramContext);
        return;
      }
    }
  }
  
  private static boolean a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramView = (i)paramView.getLayoutParams();
    if (paramView.leftMargin != paramRect.left) {
      paramView.leftMargin = paramRect.left;
    }
    for (boolean bool = true;; bool = false)
    {
      if (paramView.topMargin != paramRect.top)
      {
        paramView.topMargin = paramRect.top;
        bool = true;
      }
      if (paramView.rightMargin != paramRect.right)
      {
        paramView.rightMargin = paramRect.right;
        bool = true;
      }
      if ((paramBoolean) && (paramView.bottomMargin != paramRect.bottom))
      {
        paramView.bottomMargin = paramRect.bottom;
        return true;
      }
      return bool;
    }
  }
  
  private final void i()
  {
    if (this.l == null)
    {
      this.l = ((ContentFrameLayout)findViewById(2131427368));
      this.a = ((ActionBarContainer)findViewById(2131427369));
      localObject = findViewById(2131427367);
      if (!(localObject instanceof bj)) {
        break label58;
      }
    }
    for (Object localObject = (bj)localObject;; localObject = ((Toolbar)localObject).getWrapper())
    {
      this.n = ((bj)localObject);
      return;
      label58:
      if (!(localObject instanceof Toolbar)) {
        break;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can't make a decor toolbar out of ");
    localStringBuilder.append(localObject.getClass().getSimpleName());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  final void a()
  {
    removeCallbacks(this.z);
    removeCallbacks(this.i);
    ViewPropertyAnimator localViewPropertyAnimator = this.c;
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
  }
  
  public final void a(int paramInt)
  {
    i();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      this.n.f();
      return;
    case 109: 
      setOverlayMode(true);
      return;
    }
    this.n.g();
  }
  
  public final void a(Menu paramMenu, ag paramag)
  {
    i();
    this.n.a(paramMenu, paramag);
  }
  
  public final boolean b()
  {
    i();
    return this.n.h();
  }
  
  public final boolean c()
  {
    i();
    return this.n.i();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof i;
  }
  
  public final boolean d()
  {
    i();
    return this.n.j();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.A != null) && (!this.s)) {
      if (this.a.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i1 = (int)(this.a.getBottom() + this.a.getTranslationY() + 0.5F);; i1 = 0)
    {
      this.A.setBounds(0, i1, getWidth(), this.A.getIntrinsicHeight() + i1);
      this.A.draw(paramCanvas);
      return;
    }
  }
  
  public final boolean e()
  {
    i();
    return this.n.k();
  }
  
  public final boolean f()
  {
    i();
    return this.n.l();
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    i();
    ac.w(this);
    boolean bool = a(this.a, paramRect, false);
    this.k.set(paramRect);
    id.a(this, this.k, this.j);
    if (!this.v.equals(this.k))
    {
      this.v.set(this.k);
      bool = true;
    }
    if (!this.u.equals(this.j)) {
      this.u.set(this.j);
    }
    for (;;)
    {
      requestLayout();
      do
      {
        return true;
      } while (!bool);
    }
  }
  
  public final void g()
  {
    i();
    this.n.m();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new i(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    ActionBarContainer localActionBarContainer = this.a;
    if (localActionBarContainer != null) {
      return -(int)localActionBarContainer.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.y.a;
  }
  
  public CharSequence getTitle()
  {
    i();
    return this.n.e();
  }
  
  public final void h()
  {
    i();
    this.n.n();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a(getContext());
    ac.x(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    getPaddingRight();
    paramInt4 = getPaddingTop();
    getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        i locali = (i)localView.getLayoutParams();
        int i1 = localView.getMeasuredWidth();
        int i2 = localView.getMeasuredHeight();
        int i3 = locali.leftMargin + paramInt3;
        int i4 = locali.topMargin + paramInt4;
        localView.layout(i3, i4, i1 + i3, i2 + i4);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    i();
    measureChildWithMargins(this.a, paramInt1, 0, paramInt2, 0);
    Object localObject = (i)this.a.getLayoutParams();
    int i5 = Math.max(0, this.a.getMeasuredWidth() + ((i)localObject).leftMargin + ((i)localObject).rightMargin);
    int i1 = this.a.getMeasuredHeight();
    int i2 = ((i)localObject).topMargin;
    int i4 = Math.max(0, ((i)localObject).bottomMargin + (i1 + i2));
    int i3 = View.combineMeasuredStates(0, this.a.getMeasuredState());
    int i6 = ac.w(this) & 0x100;
    if (i6 != 0)
    {
      i2 = this.g;
      i1 = i2;
      if (this.p)
      {
        i1 = i2;
        if (this.a.getTabContainer() != null) {
          i1 = i2 + this.g;
        }
      }
    }
    for (;;)
    {
      this.m.set(this.j);
      this.t.set(this.k);
      if (this.d)
      {
        localObject = this.t;
        ((Rect)localObject).top = (i1 + ((Rect)localObject).top);
        localObject = this.t;
      }
      for (((Rect)localObject).bottom = ((Rect)localObject).bottom;; ((Rect)localObject).bottom = ((Rect)localObject).bottom)
      {
        a(this.l, this.m, true);
        if (!this.w.equals(this.t))
        {
          this.w.set(this.t);
          this.l.a(this.t);
        }
        measureChildWithMargins(this.l, paramInt1, 0, paramInt2, 0);
        localObject = (i)this.l.getLayoutParams();
        i1 = Math.max(i5, this.l.getMeasuredWidth() + ((i)localObject).leftMargin + ((i)localObject).rightMargin);
        i2 = this.l.getMeasuredHeight();
        i5 = ((i)localObject).topMargin;
        i2 = Math.max(i4, ((i)localObject).bottomMargin + (i2 + i5));
        i3 = View.combineMeasuredStates(i3, this.l.getMeasuredState());
        i4 = getPaddingLeft();
        i5 = getPaddingRight();
        i2 = Math.max(i2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i1 + (i4 + i5), getSuggestedMinimumWidth()), paramInt1, i3), View.resolveSizeAndState(i2, paramInt2, i3 << 16));
        return;
        if (i6 != 0) {
          break;
        }
        localObject = this.m;
        ((Rect)localObject).top = (i1 + ((Rect)localObject).top);
        localObject = this.m;
      }
      if (this.a.getVisibility() != 8) {
        i1 = this.a.getMeasuredHeight();
      } else {
        i1 = 0;
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.q)
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        this.o.fling(0, 0, 0, (int)paramFloat2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.o.getFinalY() <= this.a.getHeight()) {
          break label84;
        }
        a();
        this.i.run();
      }
    }
    for (;;)
    {
      this.b = true;
      bool1 = true;
      return bool1;
      label84:
      a();
      this.z.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.r += paramInt2;
    setActionBarHideOffset(this.r);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.y.a = paramInt;
    this.r = getActionBarHideOffset();
    a();
    paramView1 = this.h;
    if (paramView1 != null) {
      paramView1.p();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) != 0) && (this.a.getVisibility() == 0)) {
      return this.q;
    }
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.q) && (!this.b))
    {
      if (this.r > this.a.getHeight()) {
        break label60;
      }
      a();
      postDelayed(this.z, 600L);
    }
    for (;;)
    {
      paramView = this.h;
      if (paramView != null) {
        paramView.q();
      }
      return;
      label60:
      a();
      postDelayed(this.i, 600L);
    }
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    super.onWindowSystemUiVisibilityChanged(paramInt);
    i();
    int i1 = this.x;
    this.x = paramInt;
    int i2 = paramInt & 0x100;
    h localh = this.h;
    if (localh == null)
    {
      if ((((i1 ^ paramInt) & 0x100) != 0) && (this.h != null)) {
        ac.x(this);
      }
      return;
    }
    if (i2 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localh.e(bool);
      if ((paramInt & 0x4) == 0) {}
      while (i2 == 0)
      {
        this.h.n();
        break;
      }
      this.h.o();
      break;
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.B = paramInt;
    h localh = this.h;
    if (localh != null) {
      localh.c(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    a();
    paramInt = Math.max(0, Math.min(paramInt, this.a.getHeight()));
    this.a.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(h paramh)
  {
    this.h = paramh;
    if (getWindowToken() != null)
    {
      this.h.c(this.B);
      int i1 = this.x;
      if (i1 != 0)
      {
        onWindowSystemUiVisibilityChanged(i1);
        ac.x(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.q)
    {
      this.q = paramBoolean;
      if (!paramBoolean)
      {
        a();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    i();
    this.n.a(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    i();
    this.n.a(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    i();
    this.n.b(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.d = paramBoolean;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (getContext().getApplicationInfo().targetSdkVersion < 19) {
        bool1 = true;
      }
    }
    this.s = bool1;
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    i();
    this.n.a(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    i();
    this.n.a(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ActionBarOverlayLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */