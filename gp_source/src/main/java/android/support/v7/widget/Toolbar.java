package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.view.k;
import android.support.v4.view.o;
import android.support.v7.app.b;
import android.support.v7.view.menu.ag;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.q;
import android.support.v7.view.menu.t;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private int A;
  private final v B = new hg(this);
  private ImageButton C;
  private final Runnable D = new hh(this);
  private CharSequence E;
  private int F;
  private final int[] G = new int[2];
  private final ArrayList H = new ArrayList();
  private int I;
  private int J;
  private int K;
  private int L;
  private CharSequence M;
  private int N;
  private hn O;
  public ag a;
  public int b;
  public ImageButton c;
  public CharSequence d;
  public Drawable e;
  public gd f;
  public View g;
  public hj h;
  public final ArrayList i = new ArrayList();
  public q j;
  public ActionMenuView k;
  public hl l;
  public j m;
  public Context n;
  public int o;
  public int p;
  public TextView q;
  public int r;
  public TextView s;
  private boolean t;
  private int u;
  private int v;
  private boolean w;
  private boolean x;
  private int y = 8388627;
  private ImageView z;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969684);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = hf.a(getContext(), paramAttributeSet, android.support.v7.a.a.do, paramInt, 0);
    this.r = paramContext.g(android.support.v7.a.a.dN, 0);
    this.p = paramContext.g(android.support.v7.a.a.dE, 0);
    this.y = paramContext.c(android.support.v7.a.a.dp, this.y);
    this.b = paramContext.c(android.support.v7.a.a.dq, 48);
    int i1 = paramContext.d(android.support.v7.a.a.dH, 0);
    paramInt = i1;
    if (paramContext.g(android.support.v7.a.a.dM)) {
      paramInt = paramContext.d(android.support.v7.a.a.dM, i1);
    }
    this.I = paramInt;
    this.L = paramInt;
    this.J = paramInt;
    this.K = paramInt;
    paramInt = paramContext.d(android.support.v7.a.a.dK, -1);
    if (paramInt >= 0) {
      this.K = paramInt;
    }
    paramInt = paramContext.d(android.support.v7.a.a.dJ, -1);
    if (paramInt >= 0) {
      this.J = paramInt;
    }
    paramInt = paramContext.d(android.support.v7.a.a.dL, -1);
    if (paramInt >= 0) {
      this.L = paramInt;
    }
    paramInt = paramContext.d(android.support.v7.a.a.dI, -1);
    if (paramInt >= 0) {
      this.I = paramInt;
    }
    this.A = paramContext.e(android.support.v7.a.a.dz, -1);
    paramInt = paramContext.d(android.support.v7.a.a.dv, Integer.MIN_VALUE);
    i1 = paramContext.d(android.support.v7.a.a.dt, Integer.MIN_VALUE);
    int i2 = paramContext.e(7, 0);
    int i3 = paramContext.e(8, 0);
    h();
    paramAttributeSet = this.f;
    paramAttributeSet.d = false;
    if (i2 != Integer.MIN_VALUE)
    {
      paramAttributeSet.b = i2;
      paramAttributeSet.f = i2;
    }
    if (i3 != Integer.MIN_VALUE)
    {
      paramAttributeSet.c = i3;
      paramAttributeSet.g = i3;
    }
    if (paramInt != Integer.MIN_VALUE) {}
    for (;;)
    {
      paramAttributeSet.a(paramInt, i1);
      do
      {
        this.v = paramContext.d(android.support.v7.a.a.dw, Integer.MIN_VALUE);
        this.u = paramContext.d(android.support.v7.a.a.du, Integer.MIN_VALUE);
        this.e = paramContext.a(android.support.v7.a.a.ds);
        this.d = paramContext.c(android.support.v7.a.a.dr);
        paramAttributeSet = paramContext.c(android.support.v7.a.a.dG);
        if (!TextUtils.isEmpty(paramAttributeSet)) {
          setTitle(paramAttributeSet);
        }
        paramAttributeSet = paramContext.c(android.support.v7.a.a.dD);
        if (!TextUtils.isEmpty(paramAttributeSet)) {
          setSubtitle(paramAttributeSet);
        }
        this.n = getContext();
        setPopupTheme(paramContext.g(android.support.v7.a.a.dC, 0));
        paramAttributeSet = paramContext.a(android.support.v7.a.a.dB);
        if (paramAttributeSet != null) {
          setNavigationIcon(paramAttributeSet);
        }
        paramAttributeSet = paramContext.c(android.support.v7.a.a.dA);
        if (!TextUtils.isEmpty(paramAttributeSet)) {
          setNavigationContentDescription(paramAttributeSet);
        }
        paramAttributeSet = paramContext.a(android.support.v7.a.a.dx);
        if (paramAttributeSet != null) {
          setLogo(paramAttributeSet);
        }
        paramAttributeSet = paramContext.c(android.support.v7.a.a.dy);
        if (!TextUtils.isEmpty(paramAttributeSet)) {
          setLogoDescription(paramAttributeSet);
        }
        if (paramContext.g(android.support.v7.a.a.dO)) {
          setTitleTextColor(paramContext.b(android.support.v7.a.a.dO, -1));
        }
        if (paramContext.g(android.support.v7.a.a.dF)) {
          setSubtitleTextColor(paramContext.b(android.support.v7.a.a.dF, -1));
        }
        paramContext.c.recycle();
        return;
      } while (i1 == Integer.MIN_VALUE);
    }
  }
  
  private final int a(int paramInt)
  {
    int i2 = ac.h(this);
    int i1 = k.a(paramInt, i2) & 0x7;
    paramInt = i1;
    switch (i1)
    {
    case 2: 
    case 4: 
    default: 
      if (i2 == 1) {
        paramInt = 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      return paramInt;
    }
    return 3;
  }
  
  private final int a(View paramView, int paramInt)
  {
    hk localhk = (hk)paramView.getLayoutParams();
    int i3 = paramView.getMeasuredHeight();
    if (paramInt > 0) {}
    for (paramInt = (i3 - paramInt) / 2;; paramInt = 0)
    {
      int i2 = localhk.a & 0x70;
      int i1 = i2;
      switch (i2)
      {
      default: 
        i1 = this.y & 0x70;
      }
      switch (i1)
      {
      default: 
        i1 = getPaddingTop();
        i2 = getPaddingBottom();
        int i4 = getHeight();
        paramInt = (i4 - i1 - i2 - i3) / 2;
        if (paramInt < localhk.topMargin) {
          paramInt = localhk.topMargin;
        }
        for (;;)
        {
          return paramInt + i1;
          i2 = i4 - i2 - i3 - paramInt - i1;
          if (i2 < localhk.bottomMargin) {
            paramInt = Math.max(0, paramInt - (localhk.bottomMargin - i2));
          }
        }
      case 80: 
        return getHeight() - getPaddingBottom() - i3 - localhk.bottomMargin - paramInt;
      }
      return getPaddingTop() - paramInt;
    }
  }
  
  private final int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int i2 = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int i3 = Math.max(0, i1) + Math.max(0, i2);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramArrayOfInt[1] = Math.max(0, -i2);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + i3 + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + i3;
  }
  
  private final int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    hk localhk = (hk)paramView.getLayoutParams();
    int i1 = localhk.leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i1) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i1, paramView.getMeasuredHeight() + paramInt2);
    return localhk.rightMargin + i1 + paramInt1;
  }
  
  private static hk a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof hk)) {
      return new hk((hk)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof b)) {
      return new hk((b)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new hk((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new hk(paramLayoutParams);
  }
  
  private final void a()
  {
    if (this.z == null) {
      this.z = new AppCompatImageView(getContext());
    }
  }
  
  private final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    if (paramInt3 == 1073741824) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      paramView.measure(i1, paramInt1);
      return;
      paramInt1 = paramInt2;
      if (paramInt4 >= 0)
      {
        paramInt1 = paramInt4;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt4);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
  }
  
  private final void a(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = g();
    }
    for (;;)
    {
      ((hk)localObject).b = 1;
      if ((paramBoolean) && (this.g != null))
      {
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.i.add(paramView);
        return;
      }
      addView(paramView, (ViewGroup.LayoutParams)localObject);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = a((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (hk)localObject;
      }
    }
  }
  
  private final void a(List paramList, int paramInt)
  {
    int i3 = ac.h(this);
    int i2 = getChildCount();
    int i1 = k.a(paramInt, ac.h(this));
    paramList.clear();
    View localView;
    hk localhk;
    if (i3 == 1)
    {
      paramInt = i2 - 1;
      if (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localhk = (hk)localView.getLayoutParams();
        if (localhk.b != 0) {}
        for (;;)
        {
          paramInt -= 1;
          break;
          if ((a(localView)) && (a(localhk.a) == i1)) {
            paramList.add(localView);
          }
        }
      }
    }
    else
    {
      paramInt = 0;
      if (paramInt < i2)
      {
        localView = getChildAt(paramInt);
        localhk = (hk)localView.getLayoutParams();
        if (localhk.b != 0) {}
        for (;;)
        {
          paramInt += 1;
          break;
          if ((a(localView)) && (a(localhk.a) == i1)) {
            paramList.add(localView);
          }
        }
      }
    }
  }
  
  private final boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private static int b(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = o.a(paramView);
    return o.b(paramView) + i1;
  }
  
  private final int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    hk localhk = (hk)paramView.getLayoutParams();
    int i1 = localhk.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i1);
    paramArrayOfInt[1] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i1, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (localhk.leftMargin + i1);
  }
  
  private static int c(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = paramView.topMargin;
    return paramView.bottomMargin + i1;
  }
  
  private final boolean d(View paramView)
  {
    return (paramView.getParent() == this) || (this.i.contains(paramView));
  }
  
  protected static hk g()
  {
    return new hk();
  }
  
  private final void i()
  {
    f();
    Object localObject = this.k;
    if (((ActionMenuView)localObject).a == null)
    {
      localObject = (p)((ActionMenuView)localObject).getMenu();
      if (this.h == null) {
        this.h = new hj(this);
      }
      this.k.setExpandedActionViewsExclusive(true);
      ((p)localObject).a(this.h, this.n);
    }
  }
  
  private final void j()
  {
    if (this.C == null)
    {
      this.C = new al(getContext(), null, 2130969683);
      hk localhk = g();
      localhk.a = (this.b & 0x70 | 0x800003);
      this.C.setLayoutParams(localhk);
    }
  }
  
  public final boolean b()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = ((ActionMenuView)localObject).d;
      if ((localObject != null) && (((j)localObject).g())) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean c()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = ((ActionMenuView)localObject).d;
      if ((localObject != null) && (((j)localObject).c())) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof hk));
  }
  
  public final boolean d()
  {
    hj localhj = this.h;
    return (localhj != null) && (localhj.a != null);
  }
  
  public final void e()
  {
    Object localObject = this.h;
    if (localObject != null) {}
    for (localObject = ((hj)localObject).a;; localObject = null)
    {
      if (localObject != null) {
        ((t)localObject).collapseActionView();
      }
      return;
    }
  }
  
  final void f()
  {
    if (this.k == null)
    {
      this.k = new ActionMenuView(getContext());
      this.k.setPopupTheme(this.o);
      this.k.setOnMenuItemClickListener(this.B);
      this.k.a(this.a, this.j);
      hk localhk = g();
      localhk.a = (this.b & 0x70 | 0x800005);
      this.k.setLayoutParams(localhk);
      a(this.k, false);
    }
  }
  
  public int getContentInsetEnd()
  {
    gd localgd = this.f;
    if (localgd != null)
    {
      if (!localgd.e) {
        return localgd.g;
      }
      return localgd.f;
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    int i2 = this.u;
    int i1 = i2;
    if (i2 == Integer.MIN_VALUE) {
      i1 = getContentInsetEnd();
    }
    return i1;
  }
  
  public int getContentInsetLeft()
  {
    gd localgd = this.f;
    if (localgd != null) {
      return localgd.f;
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    gd localgd = this.f;
    if (localgd != null) {
      return localgd.g;
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    gd localgd = this.f;
    if (localgd != null)
    {
      if (!localgd.e) {
        return localgd.f;
      }
      return localgd.g;
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    int i2 = this.v;
    int i1 = i2;
    if (i2 == Integer.MIN_VALUE) {
      i1 = getContentInsetStart();
    }
    return i1;
  }
  
  public int getCurrentContentInsetEnd()
  {
    Object localObject = this.k;
    if (localObject == null) {}
    do
    {
      return getContentInsetEnd();
      localObject = ((ActionMenuView)localObject).a;
    } while ((localObject == null) || (!((p)localObject).hasVisibleItems()));
    return Math.max(getContentInsetEnd(), Math.max(this.u, 0));
  }
  
  public int getCurrentContentInsetLeft()
  {
    if (ac.h(this) == 1) {
      return getCurrentContentInsetEnd();
    }
    return getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight()
  {
    if (ac.h(this) == 1) {
      return getCurrentContentInsetStart();
    }
    return getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null) {
      return Math.max(getContentInsetStart(), Math.max(this.v, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    ImageView localImageView = this.z;
    if (localImageView != null) {
      return localImageView.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    ImageView localImageView = this.z;
    if (localImageView != null) {
      return localImageView.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    i();
    return this.k.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    ImageButton localImageButton = this.C;
    if (localImageButton != null) {
      return localImageButton.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    ImageButton localImageButton = this.C;
    if (localImageButton != null) {
      return localImageButton.getDrawable();
    }
    return null;
  }
  
  public Drawable getOverflowIcon()
  {
    i();
    return this.k.getOverflowIcon();
  }
  
  public int getPopupTheme()
  {
    return this.o;
  }
  
  public CharSequence getSubtitle()
  {
    return this.E;
  }
  
  public CharSequence getTitle()
  {
    return this.M;
  }
  
  public int getTitleMarginBottom()
  {
    return this.I;
  }
  
  public int getTitleMarginEnd()
  {
    return this.J;
  }
  
  public int getTitleMarginStart()
  {
    return this.K;
  }
  
  public int getTitleMarginTop()
  {
    return this.L;
  }
  
  public bj getWrapper()
  {
    if (this.O == null) {
      this.O = new hn(this, true);
    }
    return this.O;
  }
  
  final void h()
  {
    if (this.f == null) {
      this.f = new gd();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.D);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 9) {
      this.w = false;
    }
    boolean bool;
    if (!this.w)
    {
      bool = super.onHoverEvent(paramMotionEvent);
      if (i1 == 9) {
        break label53;
      }
    }
    for (;;)
    {
      if ((i1 == 10) || (i1 == 3)) {
        this.w = false;
      }
      return true;
      label53:
      if (!bool) {
        this.w = true;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i4 = ac.h(this);
    int i6 = getWidth();
    int i8 = getHeight();
    int i3 = getPaddingLeft();
    int i7 = getPaddingRight();
    int i5 = getPaddingTop();
    int i9 = getPaddingBottom();
    paramInt3 = i6 - i7;
    int[] arrayOfInt = this.G;
    arrayOfInt[1] = 0;
    arrayOfInt[0] = 0;
    paramInt1 = ac.s(this);
    if (paramInt1 >= 0) {}
    for (int i2 = Math.min(paramInt1, paramInt4 - paramInt2);; i2 = 0)
    {
      if (!a(this.C))
      {
        paramInt1 = i3;
        paramInt2 = paramInt3;
      }
      for (;;)
      {
        if (!a(this.c)) {}
        for (;;)
        {
          if (!a(this.k)) {}
          for (;;)
          {
            int i1 = getCurrentContentInsetLeft();
            paramInt4 = getCurrentContentInsetRight();
            arrayOfInt[0] = Math.max(0, i1 - paramInt1);
            arrayOfInt[1] = Math.max(0, paramInt4 - (paramInt3 - paramInt2));
            paramInt1 = Math.max(paramInt1, i1);
            paramInt2 = Math.min(paramInt2, paramInt3 - paramInt4);
            if (!a(this.g)) {}
            for (;;)
            {
              if (!a(this.z))
              {
                paramInt4 = paramInt2;
                paramInt3 = paramInt1;
              }
              for (;;)
              {
                paramBoolean = a(this.s);
                boolean bool = a(this.q);
                Object localObject1;
                if (paramBoolean) {
                  localObject1 = (hk)this.s.getLayoutParams();
                }
                for (paramInt1 = ((hk)localObject1).topMargin + this.s.getMeasuredHeight() + ((hk)localObject1).bottomMargin;; paramInt1 = 0)
                {
                  if (bool)
                  {
                    localObject1 = (hk)this.q.getLayoutParams();
                    paramInt2 = ((hk)localObject1).topMargin;
                    i1 = this.q.getMeasuredHeight();
                    paramInt1 = ((hk)localObject1).bottomMargin + (paramInt2 + i1) + paramInt1;
                  }
                  for (;;)
                  {
                    label321:
                    Object localObject2;
                    if (paramBoolean) {
                      if (!paramBoolean)
                      {
                        localObject1 = this.q;
                        if (!bool)
                        {
                          localObject2 = this.s;
                          label332:
                          localObject1 = (hk)((View)localObject1).getLayoutParams();
                          localObject2 = (hk)((View)localObject2).getLayoutParams();
                          if ((paramBoolean) && (this.s.getMeasuredWidth() > 0))
                          {
                            paramInt2 = 1;
                            label368:
                            switch (this.y & 0x70)
                            {
                            default: 
                              i1 = (i8 - i5 - i9 - paramInt1) / 2;
                              if (i1 < ((hk)localObject1).topMargin + this.L)
                              {
                                paramInt1 = ((hk)localObject1).topMargin + this.L;
                                label440:
                                paramInt1 = i5 + paramInt1;
                                label445:
                                if (i4 != 1) {
                                  if (paramInt2 != 0)
                                  {
                                    i1 = this.K;
                                    label461:
                                    i4 = i1 - arrayOfInt[0];
                                    i1 = paramInt3 + Math.max(0, i4);
                                    arrayOfInt[0] = Math.max(0, -i4);
                                    if (paramBoolean)
                                    {
                                      localObject1 = (hk)this.s.getLayoutParams();
                                      paramInt3 = this.s.getMeasuredWidth() + i1;
                                      i4 = this.s.getMeasuredHeight() + paramInt1;
                                      this.s.layout(i1, paramInt1, paramInt3, i4);
                                      i5 = this.J;
                                      paramInt1 = ((hk)localObject1).bottomMargin;
                                      paramInt3 = i5 + paramInt3;
                                      paramInt1 += i4;
                                      label569:
                                      if (bool)
                                      {
                                        localObject1 = (hk)this.q.getLayoutParams();
                                        i4 = paramInt1 + ((hk)localObject1).topMargin;
                                        paramInt1 = this.q.getMeasuredWidth() + i1;
                                        i5 = this.q.getMeasuredHeight();
                                        this.q.layout(i1, i4, paramInt1, i5 + i4);
                                        i4 = this.J;
                                        i5 = ((hk)localObject1).bottomMargin;
                                        i4 += paramInt1;
                                        label651:
                                        paramInt1 = paramInt4;
                                        if (paramInt2 != 0)
                                        {
                                          i1 = Math.max(paramInt3, i4);
                                          paramInt1 = paramInt4;
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                              break;
                            }
                          }
                        }
                      }
                    }
                    for (;;)
                    {
                      a(this.H, 3);
                      paramInt3 = this.H.size();
                      paramInt2 = 0;
                      while (paramInt2 < paramInt3)
                      {
                        i1 = a((View)this.H.get(paramInt2), i1, arrayOfInt, i2);
                        paramInt2 += 1;
                      }
                      a(this.H, 5);
                      paramInt4 = this.H.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt1;
                      paramInt1 = paramInt3;
                      for (;;)
                      {
                        if (paramInt1 >= paramInt4)
                        {
                          a(this.H, 1);
                          localObject1 = this.H;
                          i4 = arrayOfInt[0];
                          paramInt4 = arrayOfInt[1];
                          i5 = ((List)localObject1).size();
                          paramInt3 = 0;
                          paramInt1 = 0;
                          while (paramInt3 < i5)
                          {
                            localObject2 = (View)((List)localObject1).get(paramInt3);
                            hk localhk = (hk)((View)localObject2).getLayoutParams();
                            i4 = localhk.leftMargin - i4;
                            paramInt4 = localhk.rightMargin - paramInt4;
                            i8 = Math.max(0, i4);
                            i9 = Math.max(0, paramInt4);
                            i4 = Math.max(0, -i4);
                            paramInt4 = Math.max(0, -paramInt4);
                            int i10 = ((View)localObject2).getMeasuredWidth();
                            paramInt3 += 1;
                            paramInt1 += i10 + i8 + i9;
                          }
                          paramInt3 = (i6 - i3 - i7) / 2 + i3 - paramInt1 / 2;
                          paramInt4 = paramInt3 + paramInt1;
                          if (paramInt3 < i1) {
                            paramInt1 = i1;
                          }
                          for (;;)
                          {
                            paramInt4 = this.H.size();
                            paramInt3 = 0;
                            paramInt2 = paramInt1;
                            paramInt1 = paramInt3;
                            while (paramInt1 < paramInt4)
                            {
                              paramInt2 = a((View)this.H.get(paramInt1), paramInt2, arrayOfInt, i2);
                              paramInt1 += 1;
                            }
                            this.H.clear();
                            return;
                            paramInt1 = paramInt3;
                            if (paramInt4 > paramInt2) {
                              paramInt1 = paramInt3 - (paramInt4 - paramInt2);
                            }
                          }
                        }
                        paramInt2 = b((View)this.H.get(paramInt1), paramInt2, arrayOfInt, i2);
                        paramInt1 += 1;
                      }
                      i4 = i1;
                      break label651;
                      paramInt3 = i1;
                      break label569;
                      i1 = 0;
                      break label461;
                      if (paramInt2 != 0) {}
                      for (i1 = this.K;; i1 = 0)
                      {
                        i1 -= arrayOfInt[1];
                        paramInt4 -= Math.max(0, i1);
                        arrayOfInt[1] = Math.max(0, -i1);
                        if (paramBoolean)
                        {
                          localObject1 = (hk)this.s.getLayoutParams();
                          i4 = paramInt4 - this.s.getMeasuredWidth();
                          i1 = this.s.getMeasuredHeight() + paramInt1;
                          this.s.layout(i4, paramInt1, paramInt4, i1);
                          i5 = this.J;
                          paramInt1 = ((hk)localObject1).bottomMargin;
                          i4 -= i5;
                          paramInt1 += i1;
                        }
                        for (;;)
                        {
                          if (bool)
                          {
                            localObject1 = (hk)this.q.getLayoutParams();
                            paramInt1 += ((hk)localObject1).topMargin;
                            i1 = this.q.getMeasuredWidth();
                            i5 = this.q.getMeasuredHeight();
                            this.q.layout(paramInt4 - i1, paramInt1, paramInt4, i5 + paramInt1);
                            paramInt1 = this.J;
                            i1 = ((hk)localObject1).bottomMargin;
                          }
                          for (i5 = paramInt4 - paramInt1;; i5 = paramInt4)
                          {
                            i1 = paramInt3;
                            paramInt1 = paramInt4;
                            if (paramInt2 == 0) {
                              break;
                            }
                            paramInt1 = Math.min(i4, i5);
                            i1 = paramInt3;
                            break;
                          }
                          i4 = paramInt4;
                        }
                      }
                      paramInt1 = i8 - i9 - paramInt1 - i1 - i5;
                      if (paramInt1 < ((hk)localObject1).bottomMargin + this.I)
                      {
                        paramInt1 = Math.max(0, i1 - (((hk)localObject2).bottomMargin + this.I - paramInt1));
                        break label440;
                      }
                      paramInt1 = i1;
                      break label440;
                      paramInt1 = i8 - i9 - ((hk)localObject2).bottomMargin - this.I - paramInt1;
                      break label445;
                      paramInt1 = getPaddingTop();
                      i1 = ((hk)localObject1).topMargin;
                      paramInt1 = this.L + (i1 + paramInt1);
                      break label445;
                      if (bool)
                      {
                        if (this.q.getMeasuredWidth() <= 0)
                        {
                          paramInt2 = 0;
                          break label368;
                        }
                        paramInt2 = 1;
                        break label368;
                      }
                      paramInt2 = 0;
                      break label368;
                      localObject2 = this.q;
                      break label332;
                      localObject1 = this.s;
                      break label321;
                      if (bool) {
                        break;
                      }
                      i1 = paramInt3;
                      paramInt1 = paramInt4;
                    }
                  }
                }
                if (i4 != 1)
                {
                  paramInt3 = a(this.z, paramInt1, arrayOfInt, i2);
                  paramInt4 = paramInt2;
                }
                else
                {
                  paramInt4 = b(this.z, paramInt2, arrayOfInt, i2);
                  paramInt3 = paramInt1;
                }
              }
              if (i4 != 1) {
                paramInt1 = a(this.g, paramInt1, arrayOfInt, i2);
              } else {
                paramInt2 = b(this.g, paramInt2, arrayOfInt, i2);
              }
            }
            if (i4 != 1) {
              paramInt2 = b(this.k, paramInt2, arrayOfInt, i2);
            } else {
              paramInt1 = a(this.k, paramInt1, arrayOfInt, i2);
            }
          }
          if (i4 != 1) {
            paramInt1 = a(this.c, paramInt1, arrayOfInt, i2);
          } else {
            paramInt2 = b(this.c, paramInt2, arrayOfInt, i2);
          }
        }
        if (i4 != 1)
        {
          paramInt1 = a(this.C, i3, arrayOfInt, i2);
          paramInt2 = paramInt3;
        }
        else
        {
          paramInt2 = b(this.C, paramInt3, arrayOfInt, i2);
          paramInt1 = i3;
        }
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof Toolbar.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    Toolbar.SavedState localSavedState = (Toolbar.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.e);
    paramParcelable = this.k;
    if (paramParcelable != null) {}
    for (paramParcelable = paramParcelable.a;; paramParcelable = null)
    {
      int i1 = localSavedState.a;
      if ((i1 == 0) || (this.h == null)) {}
      while (localSavedState.b)
      {
        removeCallbacks(this.D);
        post(this.D);
        return;
        if (paramParcelable != null)
        {
          paramParcelable = paramParcelable.findItem(i1);
          if (paramParcelable != null) {
            paramParcelable.expandActionView();
          }
        }
      }
      break;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    h();
    gd localgd = this.f;
    if (paramInt == 1) {}
    for (;;)
    {
      if (bool != localgd.e)
      {
        localgd.e = bool;
        if (!localgd.d)
        {
          localgd.f = localgd.b;
          localgd.g = localgd.c;
        }
      }
      else
      {
        return;
      }
      if (!bool)
      {
        i1 = localgd.h;
        paramInt = i1;
        if (i1 == Integer.MIN_VALUE) {
          paramInt = localgd.b;
        }
        localgd.f = paramInt;
        i1 = localgd.a;
        paramInt = i1;
        if (i1 == Integer.MIN_VALUE) {
          paramInt = localgd.c;
        }
        localgd.g = paramInt;
        return;
      }
      int i1 = localgd.a;
      paramInt = i1;
      if (i1 == Integer.MIN_VALUE) {
        paramInt = localgd.b;
      }
      localgd.f = paramInt;
      i1 = localgd.h;
      paramInt = i1;
      if (i1 == Integer.MIN_VALUE) {
        paramInt = localgd.c;
      }
      localgd.g = paramInt;
      return;
      bool = false;
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Toolbar.SavedState localSavedState = new Toolbar.SavedState(super.onSaveInstanceState());
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((hj)localObject).a;
      if (localObject != null) {
        localSavedState.a = ((t)localObject).getItemId();
      }
    }
    localSavedState.b = b();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0) {
      this.x = false;
    }
    boolean bool;
    if (!this.x)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      if (i1 == 0) {
        break label48;
      }
    }
    for (;;)
    {
      if ((i1 == 1) || (i1 == 3)) {
        this.x = false;
      }
      return true;
      label48:
      if (!bool) {
        this.x = true;
      }
    }
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.t = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = Integer.MIN_VALUE;
    }
    if (i1 != this.u)
    {
      this.u = i1;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = Integer.MIN_VALUE;
    }
    if (i1 != this.v)
    {
      this.v = i1;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(android.support.v7.b.a.a.b(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      a();
      if (!d(this.z)) {
        a(this.z, true);
      }
    }
    for (;;)
    {
      ImageView localImageView = this.z;
      if (localImageView != null) {
        localImageView.setImageDrawable(paramDrawable);
      }
      return;
      localImageView = this.z;
      if ((localImageView != null) && (d(localImageView)))
      {
        removeView(this.z);
        this.i.remove(this.z);
      }
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      a();
    }
    ImageView localImageView = this.z;
    if (localImageView != null) {
      localImageView.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getContext().getText(paramInt);; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      return;
    }
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      j();
    }
    ImageButton localImageButton = this.C;
    if (localImageButton != null) {
      localImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(android.support.v7.b.a.a.b(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      j();
      if (!d(this.C)) {
        a(this.C, true);
      }
    }
    for (;;)
    {
      ImageButton localImageButton = this.C;
      if (localImageButton != null) {
        localImageButton.setImageDrawable(paramDrawable);
      }
      return;
      localImageButton = this.C;
      if ((localImageButton != null) && (d(localImageButton)))
      {
        removeView(this.C);
        this.i.remove(this.C);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    j();
    this.C.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(hl paramhl)
  {
    this.l = paramhl;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    i();
    this.k.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.o != paramInt)
    {
      this.o = paramInt;
      if (paramInt == 0) {
        this.n = getContext();
      }
    }
    else
    {
      return;
    }
    this.n = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.q == null)
      {
        localObject = getContext();
        this.q = new bb((Context)localObject);
        this.q.setSingleLine();
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        int i1 = this.p;
        if (i1 != 0) {
          this.q.setTextAppearance((Context)localObject, i1);
        }
        i1 = this.F;
        if (i1 != 0) {
          this.q.setTextColor(i1);
        }
      }
      if (!d(this.q)) {
        a(this.q, true);
      }
    }
    for (;;)
    {
      localObject = this.q;
      if (localObject != null) {
        ((TextView)localObject).setText(paramCharSequence);
      }
      this.E = paramCharSequence;
      return;
      localObject = this.q;
      if ((localObject != null) && (d((View)localObject)))
      {
        removeView(this.q);
        this.i.remove(this.q);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.F = paramInt;
    TextView localTextView = this.q;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.s == null)
      {
        localObject = getContext();
        this.s = new bb((Context)localObject);
        this.s.setSingleLine();
        this.s.setEllipsize(TextUtils.TruncateAt.END);
        int i1 = this.r;
        if (i1 != 0) {
          this.s.setTextAppearance((Context)localObject, i1);
        }
        i1 = this.N;
        if (i1 != 0) {
          this.s.setTextColor(i1);
        }
      }
      if (!d(this.s)) {
        a(this.s, true);
      }
    }
    for (;;)
    {
      localObject = this.s;
      if (localObject != null) {
        ((TextView)localObject).setText(paramCharSequence);
      }
      this.M = paramCharSequence;
      return;
      localObject = this.s;
      if ((localObject != null) && (d((View)localObject)))
      {
        removeView(this.s);
        this.i.remove(this.s);
      }
    }
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.I = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.J = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.K = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.L = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.N = paramInt;
    TextView localTextView = this.s;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/Toolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */