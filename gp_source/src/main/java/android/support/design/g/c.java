package android.support.design.g;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.design.internal.o;
import android.support.v4.g.r;
import android.support.v4.g.s;
import android.support.v4.g.t;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ac;
import android.support.v4.view.am;
import android.support.v4.view.ar;
import android.support.v4.view.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@am
public class c
  extends HorizontalScrollView
{
  private static final r L = new t(16);
  private final int A;
  private final int B;
  private ValueAnimator C;
  private final int D;
  private f E;
  private final ArrayList F = new ArrayList();
  private k G;
  private boolean H;
  private final h I;
  private ColorStateList J;
  private int K;
  private final r M = new s(12);
  private final ArrayList N = new ArrayList();
  public boolean a;
  public int b;
  public final int c;
  public int d;
  public boolean e;
  public int f;
  public int g = Integer.MAX_VALUE;
  public int h;
  public int i;
  public int j;
  public int k;
  public ColorStateList l;
  public Drawable m;
  public int n;
  public ColorStateList o;
  public float p;
  public float q;
  public final RectF r = new RectF();
  public boolean s;
  public ViewPager t;
  private e u;
  private int v;
  private f w;
  private l x;
  private z y;
  private DataSetObserver z;
  
  public c(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969627);
  }
  
  public c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.I = new h(this, paramContext);
    super.addView(this.I, 0, new FrameLayout.LayoutParams(-2, -1));
    TypedArray localTypedArray = android.support.design.internal.n.a(paramContext, paramAttributeSet, a.a, paramInt, 2132018432, new int[] { a.x });
    this.I.b(localTypedArray.getDimensionPixelSize(a.l, -1));
    this.I.a(localTypedArray.getColor(a.i, 0));
    setSelectedTabIndicator(android.support.design.d.a.b(paramContext, localTypedArray, a.g));
    setSelectedTabIndicatorGravity(localTypedArray.getInt(a.k, 0));
    setTabIndicatorFullWidth(localTypedArray.getBoolean(a.j, true));
    paramInt = localTypedArray.getDimensionPixelSize(a.q, 0);
    this.h = paramInt;
    this.i = paramInt;
    this.k = paramInt;
    this.j = paramInt;
    this.j = localTypedArray.getDimensionPixelSize(a.t, this.j);
    this.k = localTypedArray.getDimensionPixelSize(a.u, this.k);
    this.i = localTypedArray.getDimensionPixelSize(a.s, this.i);
    this.h = localTypedArray.getDimensionPixelSize(a.r, this.h);
    this.n = localTypedArray.getResourceId(a.x, 2132018132);
    paramAttributeSet = paramContext.obtainStyledAttributes(this.n, android.support.v7.a.a.da);
    try
    {
      this.q = paramAttributeSet.getDimensionPixelSize(0, 0);
      this.o = android.support.design.d.a.a(paramContext, paramAttributeSet, 3);
      paramAttributeSet.recycle();
      if (localTypedArray.hasValue(a.y)) {
        this.o = android.support.design.d.a.a(paramContext, localTypedArray, a.y);
      }
      if (localTypedArray.hasValue(a.w))
      {
        paramInt = localTypedArray.getColor(21, 0);
        this.o = b(this.o.getDefaultColor(), paramInt);
      }
      this.J = android.support.design.d.a.a(paramContext, localTypedArray, a.e);
      o.a(localTypedArray.getInt(a.f, -1), null);
      this.l = android.support.design.d.a.a(paramContext, localTypedArray, a.v);
      this.K = localTypedArray.getInt(a.h, 300);
      this.B = localTypedArray.getDimensionPixelSize(a.o, -1);
      this.A = localTypedArray.getDimensionPixelSize(a.n, -1);
      this.c = localTypedArray.getResourceId(a.b, 0);
      this.v = localTypedArray.getDimensionPixelSize(a.c, 0);
      this.b = localTypedArray.getInt(a.p, 1);
      this.d = localTypedArray.getInt(a.d, 0);
      this.a = localTypedArray.getBoolean(a.m, false);
      this.s = localTypedArray.getBoolean(a.z, false);
      localTypedArray.recycle();
      paramContext = getResources();
      this.p = paramContext.getDimensionPixelSize(2131165579);
      this.D = paramContext.getDimensionPixelSize(2131165577);
      e();
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private final int a(int paramInt, float paramFloat)
  {
    int i1 = 0;
    int i2 = 0;
    View localView2;
    if (this.b == 0)
    {
      localView2 = this.I.getChildAt(paramInt);
      paramInt += 1;
      if (paramInt >= this.I.getChildCount()) {
        break label126;
      }
    }
    label126:
    for (View localView1 = this.I.getChildAt(paramInt);; localView1 = null)
    {
      if (localView2 != null) {}
      for (paramInt = localView2.getWidth();; paramInt = 0)
      {
        i1 = i2;
        if (localView1 != null) {
          i1 = localView1.getWidth();
        }
        i2 = localView2.getLeft() + paramInt / 2 - getWidth() / 2;
        paramInt = (int)((i1 + paramInt) * 0.5F * paramFloat);
        if (ac.h(this) != 0)
        {
          i1 = i2 - paramInt;
          return i1;
        }
        return paramInt + i2;
      }
    }
  }
  
  private final void a(f paramf)
  {
    if (!this.F.contains(paramf)) {
      this.F.add(paramf);
    }
  }
  
  private final void a(ViewPager paramViewPager, boolean paramBoolean)
  {
    Object localObject1 = this.t;
    if (localObject1 != null)
    {
      Object localObject2 = this.x;
      if (localObject2 != null) {
        ((ViewPager)localObject1).b((ar)localObject2);
      }
      localObject1 = this.u;
      if (localObject1 != null)
      {
        localObject2 = this.t.c;
        if (localObject2 != null) {
          ((List)localObject2).remove(localObject1);
        }
      }
    }
    localObject1 = this.w;
    if (localObject1 != null)
    {
      b((f)localObject1);
      this.w = null;
    }
    if (paramViewPager != null)
    {
      this.t = paramViewPager;
      if (this.x == null) {
        this.x = new l(this);
      }
      localObject1 = this.x;
      ((l)localObject1).b = 0;
      ((l)localObject1).a = 0;
      paramViewPager.a((ar)localObject1);
      this.w = new n(paramViewPager);
      a(this.w);
      localObject1 = paramViewPager.getAdapter();
      if (localObject1 != null) {
        a((z)localObject1, true);
      }
      if (this.u == null) {
        this.u = new e(this);
      }
      localObject1 = this.u;
      ((e)localObject1).a = true;
      if (paramViewPager.c == null) {
        paramViewPager.c = new ArrayList();
      }
      paramViewPager.c.add(localObject1);
      c(paramViewPager.getCurrentItem());
    }
    for (;;)
    {
      this.H = paramBoolean;
      return;
      this.t = null;
      a(null, false);
    }
  }
  
  private final void a(View paramView)
  {
    if ((paramView instanceof b))
    {
      paramView = (b)paramView;
      k localk = a();
      if (!TextUtils.isEmpty(paramView.getContentDescription())) {
        localk.b(paramView.getContentDescription());
      }
      b(localk, this.N.isEmpty());
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  private final void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.b == 1) && (this.d == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private static ColorStateList b(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private final void b(f paramf)
  {
    this.F.remove(paramf);
  }
  
  private final void b(k paramk, boolean paramBoolean)
  {
    int i1 = this.N.size();
    if (paramk.c != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    paramk.d = i1;
    this.N.add(i1, paramk);
    int i2 = this.N.size();
    i1 += 1;
    for (;;)
    {
      if (i1 >= i2)
      {
        m localm = paramk.f;
        h localh = this.I;
        i1 = paramk.d;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(localLayoutParams);
        localh.addView(localm, i1, localLayoutParams);
        if (paramBoolean) {
          paramk.a();
        }
        return;
      }
      ((k)this.N.get(i1)).d = i1;
      i1 += 1;
    }
  }
  
  private final void c(int paramInt)
  {
    a(paramInt, 0.0F, true, true);
  }
  
  private final void d()
  {
    int i2 = this.N.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((k)this.N.get(i1)).b();
      i1 += 1;
    }
  }
  
  private final void d(int paramInt)
  {
    h localh;
    int i2;
    int i1;
    if (paramInt != -1)
    {
      if ((getWindowToken() != null) && (ac.I(this)))
      {
        localh = this.I;
        i2 = localh.getChildCount();
        i1 = 0;
      }
    }
    else {
      for (;;)
      {
        if (i1 >= i2)
        {
          i1 = getScrollX();
          i2 = a(paramInt, 0.0F);
          if (i1 != i2)
          {
            if (this.C == null)
            {
              this.C = new ValueAnimator();
              this.C.setInterpolator(android.support.design.a.a.c);
              this.C.setDuration(this.K);
              this.C.addUpdateListener(new d(this));
            }
            this.C.setIntValues(new int[] { i1, i2 });
            this.C.start();
          }
          this.I.b(paramInt, this.K);
          return;
        }
        if (localh.getChildAt(i1).getWidth() <= 0) {
          break;
        }
        i1 += 1;
      }
    }
    c(paramInt);
  }
  
  private final void e()
  {
    if (this.b == 0) {}
    for (int i1 = Math.max(0, this.v - this.j);; i1 = 0)
    {
      ac.a(this.I, i1, 0, 0, 0);
      switch (this.b)
      {
      }
      for (;;)
      {
        a(true);
        return;
        this.I.setGravity(1);
        continue;
        this.I.setGravity(8388611);
      }
    }
  }
  
  private final void e(int paramInt)
  {
    int i2 = this.I.getChildCount();
    if (paramInt < i2)
    {
      int i1 = 0;
      if (i1 < i2)
      {
        View localView = this.I.getChildAt(i1);
        if (i1 == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          localView.setSelected(bool);
          localView.setActivated(bool);
          i1 += 1;
          break;
        }
      }
    }
  }
  
  private final int f()
  {
    int i2 = this.B;
    int i1 = i2;
    if (i2 == -1)
    {
      if (this.b == 0) {
        i1 = this.D;
      }
    }
    else {
      return i1;
    }
    return 0;
  }
  
  public k a()
  {
    k localk = b();
    localk.c = this;
    Object localObject1 = this.M;
    if (localObject1 != null) {}
    for (localObject1 = (m)((r)localObject1).a();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new m(this, getContext());
      }
      ((m)localObject2).a(localk);
      ((m)localObject2).setFocusable(true);
      ((m)localObject2).setMinimumWidth(f());
      if (TextUtils.isEmpty(localk.a)) {
        ((m)localObject2).setContentDescription(localk.e);
      }
      for (;;)
      {
        localk.f = ((m)localObject2);
        return localk;
        ((m)localObject2).setContentDescription(localk.a);
      }
    }
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Math.round(paramInt + paramFloat);
    if ((i1 >= 0) && (i1 < this.I.getChildCount()))
    {
      if (paramBoolean2)
      {
        localObject = this.I;
        ValueAnimator localValueAnimator = ((h)localObject).a;
        if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
          ((h)localObject).a.cancel();
        }
        ((h)localObject).b = paramInt;
        ((h)localObject).c = paramFloat;
        ((h)localObject).a();
      }
      Object localObject = this.C;
      if ((localObject != null) && (((ValueAnimator)localObject).isRunning())) {
        this.C.cancel();
      }
      scrollTo(a(paramInt, paramFloat), 0);
      if (paramBoolean1) {
        e(i1);
      }
    }
  }
  
  final void a(k paramk, boolean paramBoolean)
  {
    k localk = this.G;
    int i1;
    if (localk != paramk)
    {
      if (paramk != null) {}
      for (i1 = paramk.d;; i1 = -1)
      {
        if (!paramBoolean) {}
        label128:
        label157:
        for (;;)
        {
          this.G = paramk;
          if (localk != null)
          {
            i1 = this.F.size() - 1;
            while (i1 >= 0)
            {
              ((f)this.F.get(i1)).a();
              i1 -= 1;
            }
          }
          if (paramk == null) {
            break;
          }
          i1 = this.F.size() - 1;
          while (i1 >= 0)
          {
            ((f)this.F.get(i1)).a(paramk);
            i1 -= 1;
          }
          if ((localk != null) && (localk.d != -1)) {
            d(i1);
          }
          for (;;)
          {
            if (i1 == -1) {
              break label157;
            }
            e(i1);
            break;
            if (i1 == -1) {
              break label128;
            }
            c(i1);
          }
        }
      }
    }
    if (localk != null)
    {
      i1 = this.F.size() - 1;
      while (i1 >= 0)
      {
        ((f)this.F.get(i1)).b();
        i1 -= 1;
      }
      d(paramk.d);
    }
  }
  
  final void a(z paramz, boolean paramBoolean)
  {
    z localz = this.y;
    if (localz != null)
    {
      DataSetObserver localDataSetObserver = this.z;
      if (localDataSetObserver != null) {
        localz.b(localDataSetObserver);
      }
    }
    this.y = paramz;
    if ((paramBoolean) && (paramz != null))
    {
      if (this.z == null) {
        this.z = new g(this);
      }
      paramz.a(this.z);
    }
    c();
  }
  
  final void a(boolean paramBoolean)
  {
    int i1 = 0;
    if (i1 < this.I.getChildCount())
    {
      View localView = this.I.getChildAt(i1);
      localView.setMinimumWidth(f());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (!paramBoolean) {}
      for (;;)
      {
        i1 += 1;
        break;
        localView.requestLayout();
      }
    }
  }
  
  public boolean a(k paramk)
  {
    return L.a(paramk);
  }
  
  public final void a_(int paramInt1, int paramInt2)
  {
    setTabTextColors(b(paramInt1, paramInt2));
  }
  
  public void addView(View paramView)
  {
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramView);
  }
  
  final int b(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  public k b()
  {
    k localk2 = (k)L.a();
    k localk1 = localk2;
    if (localk2 == null) {
      localk1 = new k();
    }
    return localk1;
  }
  
  final void c()
  {
    int i1 = this.I.getChildCount() - 1;
    if (i1 >= 0)
    {
      localObject = (m)this.I.getChildAt(i1);
      this.I.removeViewAt(i1);
      if (localObject == null) {}
      for (;;)
      {
        requestLayout();
        i1 -= 1;
        break;
        ((m)localObject).a(null);
        ((m)localObject).setSelected(false);
        this.M.a(localObject);
      }
    }
    Object localObject = this.N.iterator();
    while (((Iterator)localObject).hasNext())
    {
      k localk = (k)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      localk.c = null;
      localk.f = null;
      localk.e = null;
      localk.a = null;
      localk.d = -1;
      localk.b = null;
      a(localk);
    }
    this.G = null;
    localObject = this.y;
    if (localObject != null)
    {
      int i2 = ((z)localObject).a();
      i1 = 0;
      while (i1 < i2)
      {
        b(a().a(this.y.c(i1)), false);
        i1 += 1;
      }
      localObject = this.t;
      if ((localObject != null) && (i2 > 0))
      {
        i1 = ((ViewPager)localObject).getCurrentItem();
        if ((i1 != getSelectedTabPosition()) && (i1 < getTabCount())) {
          a(j_(i1), true);
        }
      }
    }
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getSelectedTabPosition()
  {
    k localk = this.G;
    if (localk != null) {
      return localk.d;
    }
    return -1;
  }
  
  public int getTabCount()
  {
    return this.N.size();
  }
  
  public int getTabGravity()
  {
    return this.d;
  }
  
  public ColorStateList getTabIconTint()
  {
    return this.J;
  }
  
  public int getTabIndicatorGravity()
  {
    return this.f;
  }
  
  public int getTabMode()
  {
    return this.b;
  }
  
  public ColorStateList getTabRippleColor()
  {
    return this.l;
  }
  
  public Drawable getTabSelectedIndicator()
  {
    return this.m;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.o;
  }
  
  public k j_(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getTabCount())) {
      return (k)this.N.get(paramInt);
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.t == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        a((ViewPager)localViewParent, true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.H)
    {
      setupWithViewPager(null);
      this.H = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = 0;
    while (i1 < this.I.getChildCount())
    {
      Object localObject = this.I.getChildAt(i1);
      if ((localObject instanceof m))
      {
        localObject = (m)localObject;
        Drawable localDrawable = ((m)localObject).a;
        if (localDrawable != null)
        {
          localDrawable.setBounds(((m)localObject).getLeft(), ((m)localObject).getTop(), ((m)localObject).getRight(), ((m)localObject).getBottom());
          ((m)localObject).a.draw(paramCanvas);
        }
      }
      i1 += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = this.N.size();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2)
      {
        i1 = b(48) + getPaddingTop() + getPaddingBottom();
        switch (View.MeasureSpec.getMode(paramInt2))
        {
        }
        for (;;)
        {
          int i3 = View.MeasureSpec.getSize(paramInt1);
          if (View.MeasureSpec.getMode(paramInt1) != 0)
          {
            i2 = this.A;
            i1 = i2;
            if (i2 <= 0) {
              i1 = i3 - b(56);
            }
            this.g = i1;
          }
          super.onMeasure(paramInt1, paramInt2);
          View localView;
          if (getChildCount() == 1) {
            localView = getChildAt(0);
          }
          switch (this.b)
          {
          default: 
          case 0: 
            do
            {
              return;
            } while (localView.getMeasuredWidth() >= getMeasuredWidth());
          }
          do
          {
            paramInt1 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
            localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
            return;
          } while (localView.getMeasuredWidth() != getMeasuredWidth());
          return;
          paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i1, View.MeasureSpec.getSize(paramInt2)), 1073741824);
          continue;
          paramInt2 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
        }
      }
      this.N.get(i1);
      i1 += 1;
    }
  }
  
  public void setInlineLabel(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      int i1 = 0;
      if (i1 < this.I.getChildCount())
      {
        Object localObject = this.I.getChildAt(i1);
        if ((localObject instanceof m))
        {
          localObject = (m)localObject;
          ((m)localObject).setOrientation(((m)localObject).g.a ^ true);
          TextView localTextView = ((m)localObject).c;
          if ((localTextView == null) && (((m)localObject).b == null)) {
            break label95;
          }
          ((m)localObject).a(localTextView, ((m)localObject).b);
        }
        for (;;)
        {
          i1 += 1;
          break;
          label95:
          ((m)localObject).a(((m)localObject).f, ((m)localObject).e);
        }
      }
      e();
    }
  }
  
  public void setInlineLabelResource(int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  @Deprecated
  public void setOnTabSelectedListener(f paramf)
  {
    f localf = this.E;
    if (localf != null) {
      b(localf);
    }
    this.E = paramf;
    if (paramf != null) {
      a(paramf);
    }
  }
  
  public void setSelectedTabIndicator(int paramInt)
  {
    if (paramInt != 0)
    {
      setSelectedTabIndicator(android.support.v7.b.a.a.b(getContext(), paramInt));
      return;
    }
    setSelectedTabIndicator(null);
  }
  
  public void setSelectedTabIndicator(Drawable paramDrawable)
  {
    if (this.m != paramDrawable)
    {
      this.m = paramDrawable;
      ac.e(this.I);
    }
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    this.I.a(paramInt);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      ac.e(this.I);
    }
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.I.b(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      e();
    }
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    if (this.J != paramColorStateList)
    {
      this.J = paramColorStateList;
      d();
    }
  }
  
  public void setTabIconTintResource(int paramInt)
  {
    setTabIconTint(android.support.v7.b.a.a.a(getContext(), paramInt));
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    this.e = paramBoolean;
    ac.e(this.I);
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.b)
    {
      this.b = paramInt;
      e();
    }
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    if (this.l != paramColorStateList)
    {
      this.l = paramColorStateList;
      int i1 = 0;
      if (i1 < this.I.getChildCount())
      {
        paramColorStateList = this.I.getChildAt(i1);
        if (!(paramColorStateList instanceof m)) {}
        for (;;)
        {
          i1 += 1;
          break;
          ((m)paramColorStateList).a(getContext());
        }
      }
    }
  }
  
  public void setTabRippleColorResource(int paramInt)
  {
    setTabRippleColor(android.support.v7.b.a.a.a(getContext(), paramInt));
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    if (this.o != paramColorStateList)
    {
      this.o = paramColorStateList;
      d();
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(z paramz)
  {
    a(paramz, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (this.s != paramBoolean)
    {
      this.s = paramBoolean;
      int i1 = 0;
      if (i1 < this.I.getChildCount())
      {
        View localView = this.I.getChildAt(i1);
        if (!(localView instanceof m)) {}
        for (;;)
        {
          i1 += 1;
          break;
          ((m)localView).a(getContext());
        }
      }
    }
  }
  
  public void setUnboundedRippleResource(int paramInt)
  {
    setUnboundedRipple(getResources().getBoolean(paramInt));
  }
  
  public void setupWithViewPager(ViewPager paramViewPager)
  {
    a(paramViewPager, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    boolean bool = false;
    if (Math.max(0, this.I.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight()) > 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */