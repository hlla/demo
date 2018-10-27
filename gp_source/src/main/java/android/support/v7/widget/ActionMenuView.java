package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ag;
import android.support.v7.view.menu.ah;
import android.support.v7.view.menu.d;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.q;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
  extends dj
  implements ah, android.support.v7.view.menu.r
{
  public p a;
  public q b;
  public v c;
  public j d;
  public boolean e;
  private ag f;
  private boolean g;
  private int h;
  private int i;
  private int j;
  private Context k;
  private int l;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.j = ((int)(56.0F * f1));
    this.i = ((int)(f1 * 4.0F));
    this.k = paramContext;
    this.l = 0;
  }
  
  protected static t a()
  {
    t localt = new t();
    localt.g = 16;
    return localt;
  }
  
  protected static t a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof t)) {}
      for (paramLayoutParams = new t((t)paramLayoutParams);; paramLayoutParams = new t(paramLayoutParams))
      {
        if (paramLayoutParams.g <= 0) {
          paramLayoutParams.g = 16;
        }
        return paramLayoutParams;
      }
    }
    return a();
  }
  
  private final boolean a(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt != 0)
    {
      View localView1 = getChildAt(paramInt - 1);
      View localView2 = getChildAt(paramInt);
      boolean bool1 = bool2;
      if (paramInt < getChildCount())
      {
        bool1 = bool2;
        if ((localView1 instanceof r)) {
          bool1 = ((r)localView1).d();
        }
      }
      if ((paramInt > 0) && ((localView2 instanceof r))) {
        return ((r)localView2).c() | bool1;
      }
      return bool1;
    }
    return false;
  }
  
  public final void a(ag paramag, q paramq)
  {
    this.f = paramag;
    this.b = paramq;
  }
  
  public final void a(p paramp)
  {
    this.a = paramp;
  }
  
  public final boolean a(android.support.v7.view.menu.t paramt)
  {
    return this.a.a(paramt, null, 0);
  }
  
  public final void b()
  {
    j localj = this.d;
    if (localj != null) {
      localj.e();
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof t));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public Menu getMenu()
  {
    if (this.a == null)
    {
      Object localObject = getContext();
      this.a = new p((Context)localObject);
      this.a.a(new u(this));
      this.d = new j((Context)localObject);
      this.d.b();
      j localj = this.d;
      ag localag = this.f;
      localObject = localag;
      if (localag == null) {
        localObject = new s();
      }
      localj.a = ((ag)localObject);
      this.a.a(this.d, this.k);
      this.d.a(this);
    }
    return this.a;
  }
  
  public Drawable getOverflowIcon()
  {
    getMenu();
    j localj = this.d;
    n localn = localj.i;
    if (localn != null) {
      return localn.getDrawable();
    }
    if (localj.l) {
      return localj.k;
    }
    return null;
  }
  
  public int getPopupTheme()
  {
    return this.l;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.d;
    if (paramConfiguration != null)
    {
      paramConfiguration.a(false);
      if (this.d.g())
      {
        this.d.d();
        this.d.c();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.g)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i2 = getChildCount();
    int i1 = (paramInt4 - paramInt2) / 2;
    int i3 = getDividerWidth();
    int i4 = paramInt3 - paramInt1;
    paramInt2 = i4 - getPaddingRight() - getPaddingLeft();
    paramBoolean = id.a(this);
    paramInt1 = 0;
    paramInt4 = 0;
    paramInt3 = 0;
    t localt;
    int m;
    int n;
    if (paramInt3 < i2)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localt = (t)localView.getLayoutParams();
        if (localt.e)
        {
          m = localView.getMeasuredWidth();
          paramInt4 = m;
          if (a(paramInt3)) {
            paramInt4 = m + i3;
          }
          int i5 = localView.getMeasuredHeight();
          if (paramBoolean)
          {
            m = getPaddingLeft();
            m = localt.leftMargin + m;
            n = m + paramInt4;
            label175:
            int i6 = i1 - i5 / 2;
            localView.layout(m, i6, n, i5 + i6);
            paramInt2 -= paramInt4;
            paramInt4 = 1;
          }
        }
      }
      for (;;)
      {
        paramInt3 += 1;
        break;
        n = getWidth() - getPaddingRight() - localt.rightMargin;
        m = n - paramInt4;
        break label175;
        m = localView.getMeasuredWidth();
        n = localt.leftMargin;
        paramInt2 -= localt.rightMargin + (m + n);
        a(paramInt3);
        paramInt1 += 1;
      }
    }
    if (i2 != 1) {}
    label333:
    label443:
    label446:
    label456:
    label566:
    label569:
    while (paramInt4 != 0)
    {
      paramInt1 -= (paramInt4 ^ 0x1);
      if (paramInt1 > 0) {}
      for (paramInt1 = paramInt2 / paramInt1;; paramInt1 = 0)
      {
        paramInt3 = Math.max(0, paramInt1);
        if (paramBoolean)
        {
          paramInt1 = getWidth() - getPaddingRight();
          paramInt2 = 0;
          if (paramInt2 < i2)
          {
            localView = getChildAt(paramInt2);
            localt = (t)localView.getLayoutParams();
            if (localView.getVisibility() == 8) {
              break label446;
            }
            if (localt.e) {
              break label443;
            }
            paramInt1 -= localt.rightMargin;
            paramInt4 = localView.getMeasuredWidth();
            m = localView.getMeasuredHeight();
            n = i1 - m / 2;
            localView.layout(paramInt1 - paramInt4, n, paramInt1, m + n);
            paramInt1 -= localt.leftMargin + paramInt4 + paramInt3;
          }
          for (;;)
          {
            paramInt2 += 1;
            break label333;
            break;
          }
        }
        paramInt1 = getPaddingLeft();
        paramInt2 = 0;
        if (paramInt2 < i2)
        {
          localView = getChildAt(paramInt2);
          localt = (t)localView.getLayoutParams();
          if (localView.getVisibility() == 8) {
            break label569;
          }
          if (localt.e) {
            break label566;
          }
          paramInt1 += localt.leftMargin;
          paramInt4 = localView.getMeasuredWidth();
          m = localView.getMeasuredHeight();
          n = i1 - m / 2;
          localView.layout(paramInt1, n, paramInt1 + paramInt4, m + n);
          paramInt1 = localt.rightMargin + paramInt4 + paramInt3 + paramInt1;
        }
        for (;;)
        {
          paramInt2 += 1;
          break label456;
          break;
        }
      }
    }
    View localView = getChildAt(0);
    paramInt1 = localView.getMeasuredWidth();
    paramInt2 = localView.getMeasuredHeight();
    paramInt3 = i4 / 2 - paramInt1 / 2;
    paramInt4 = i1 - paramInt2 / 2;
    localView.layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.g;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.g = bool1;
      if (bool2 != this.g) {
        this.h = 0;
      }
      int m = View.MeasureSpec.getSize(paramInt1);
      Object localObject1;
      if (this.g)
      {
        localObject1 = this.a;
        if ((localObject1 != null) && (m != this.h))
        {
          this.h = m;
          ((p)localObject1).b(true);
        }
      }
      int n = getChildCount();
      if (!this.g) {
        m = 0;
      }
      for (;;)
      {
        if (m < n)
        {
          localObject1 = (t)getChildAt(m).getLayoutParams();
          ((t)localObject1).rightMargin = 0;
          ((t)localObject1).leftMargin = 0;
          m += 1;
        }
        else
        {
          super.onMeasure(paramInt1, paramInt2);
          return;
          if (n > 0)
          {
            int i10 = View.MeasureSpec.getMode(paramInt2);
            paramInt1 = View.MeasureSpec.getSize(paramInt1);
            int i9 = View.MeasureSpec.getSize(paramInt2);
            m = getPaddingLeft();
            n = getPaddingRight();
            int i7 = getPaddingTop() + getPaddingBottom();
            int i11 = getChildMeasureSpec(paramInt2, i7, -2);
            int i12 = paramInt1 - (m + n);
            paramInt2 = this.j;
            paramInt1 = i12 / paramInt2;
            if (paramInt1 == 0)
            {
              setMeasuredDimension(i12, 0);
              return;
            }
            int i13 = paramInt2 + i12 % paramInt2 / paramInt1;
            int i14 = getChildCount();
            n = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i1 = 0;
            long l1 = 0L;
            int i5 = 0;
            Object localObject2;
            int i6;
            int i8;
            long l2;
            while (i5 < i14)
            {
              localObject2 = getChildAt(i5);
              if (((View)localObject2).getVisibility() == 8)
              {
                paramInt2 = i2;
                m = n;
                n = paramInt1;
                paramInt1 = i4;
                i5 += 1;
                i4 = paramInt1;
                paramInt1 = n;
                i2 = paramInt2;
                n = m;
              }
              else
              {
                bool2 = localObject2 instanceof ActionMenuItemView;
                i6 = i4 + 1;
                if (bool2)
                {
                  paramInt2 = this.i;
                  ((View)localObject2).setPadding(paramInt2, 0, paramInt2, 0);
                }
                t localt1 = (t)((View)localObject2).getLayoutParams();
                localt1.c = false;
                localt1.d = 0;
                localt1.a = 0;
                localt1.b = false;
                localt1.leftMargin = 0;
                localt1.rightMargin = 0;
                if (bool2) {
                  if (((ActionMenuItemView)localObject2).b()) {
                    bool1 = true;
                  }
                }
                for (;;)
                {
                  localt1.f = bool1;
                  if (!localt1.e) {}
                  for (m = paramInt1;; m = 1)
                  {
                    t localt2 = (t)((View)localObject2).getLayoutParams();
                    i8 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11) - i7, View.MeasureSpec.getMode(i11));
                    if (bool2) {}
                    for (localObject1 = (ActionMenuItemView)localObject2;; localObject1 = null)
                    {
                      if (localObject1 != null) {
                        if (((ActionMenuItemView)localObject1).b()) {
                          paramInt2 = 1;
                        }
                      }
                      for (;;)
                      {
                        if (m <= 0) {
                          m = 0;
                        }
                        for (;;)
                        {
                          if (localt2.e) {
                            bool1 = false;
                          }
                          for (;;)
                          {
                            localt2.b = bool1;
                            localt2.a = m;
                            ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(m * i13, 1073741824), i8);
                            i2 = Math.max(i2, m);
                            if (localt1.b) {}
                            for (paramInt2 = i3 + 1;; paramInt2 = i3)
                            {
                              if (!localt1.e) {}
                              for (;;)
                              {
                                paramInt1 -= m;
                                n = Math.max(n, ((View)localObject2).getMeasuredHeight());
                                if (m == 1)
                                {
                                  l2 = 1 << i5;
                                  m = n;
                                  n = paramInt1;
                                  i3 = paramInt2;
                                  l1 = l2 | l1;
                                  paramInt1 = i6;
                                  paramInt2 = i2;
                                  break;
                                }
                                m = n;
                                n = paramInt1;
                                i3 = paramInt2;
                                paramInt1 = i6;
                                paramInt2 = i2;
                                break;
                                i1 = 1;
                              }
                            }
                            if (paramInt2 != 0) {
                              bool1 = true;
                            } else {
                              bool1 = false;
                            }
                          }
                          if (paramInt2 == 0) {}
                          while (m >= 2)
                          {
                            ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(i13 * m, Integer.MIN_VALUE), i8);
                            int i15 = ((View)localObject2).getMeasuredWidth();
                            m = i15 / i13;
                            i4 = m;
                            if (i15 % i13 != 0) {
                              i4 = m + 1;
                            }
                            m = i4;
                            if (paramInt2 == 0) {
                              break;
                            }
                            m = i4;
                            if (i4 >= 2) {
                              break;
                            }
                            m = 2;
                            break;
                          }
                          m = 0;
                        }
                        paramInt2 = 0;
                        continue;
                        paramInt2 = 0;
                      }
                    }
                  }
                  bool1 = false;
                  continue;
                  bool1 = false;
                }
              }
            }
            if (i1 == 0) {
              i5 = 0;
            }
            for (;;)
            {
              paramInt2 = 0;
              i6 = paramInt1;
              for (paramInt1 = paramInt2;; paramInt1 = paramInt2)
              {
                if (i3 <= 0) {
                  break label1626;
                }
                if (i6 <= 0) {
                  break label1623;
                }
                paramInt2 = Integer.MAX_VALUE;
                m = 0;
                l2 = 0L;
                i7 = 0;
                if (i7 < i14)
                {
                  localObject1 = (t)getChildAt(i7).getLayoutParams();
                  if (!((t)localObject1).b)
                  {
                    i8 = m;
                    m = paramInt2;
                    paramInt2 = i8;
                  }
                  for (;;)
                  {
                    i8 = i7 + 1;
                    i7 = m;
                    m = paramInt2;
                    paramInt2 = i7;
                    i7 = i8;
                    break;
                    i8 = ((t)localObject1).a;
                    if (i8 < paramInt2)
                    {
                      l2 = 1L << i7;
                      paramInt2 = 1;
                      m = i8;
                    }
                    else if (i8 == paramInt2)
                    {
                      l2 |= 1L << i7;
                      i8 = m + 1;
                      m = paramInt2;
                      paramInt2 = i8;
                    }
                    else
                    {
                      i8 = paramInt2;
                      paramInt2 = m;
                      m = i8;
                    }
                  }
                }
                l1 |= l2;
                if (m > i6) {
                  break;
                }
                m = 0;
                paramInt1 = i6;
                if (m < i14)
                {
                  localObject1 = getChildAt(m);
                  localObject2 = (t)((View)localObject1).getLayoutParams();
                  long l3 = 1 << m;
                  if ((l2 & l3) == 0L)
                  {
                    if (((t)localObject2).a == paramInt2 + 1) {
                      l1 |= l3;
                    }
                    for (;;)
                    {
                      m += 1;
                      break;
                    }
                  }
                  if (i5 == 0) {}
                  for (;;)
                  {
                    ((t)localObject2).a += 1;
                    ((t)localObject2).c = true;
                    paramInt1 -= 1;
                    break;
                    if ((((t)localObject2).f) && (paramInt1 == 1))
                    {
                      i6 = this.i;
                      ((View)localObject1).setPadding(i6 + i13, 0, i6, 0);
                    }
                  }
                }
                paramInt2 = 1;
                i6 = paramInt1;
              }
              label1285:
              label1579:
              label1585:
              label1588:
              label1591:
              label1623:
              label1626:
              for (;;)
              {
                if (i1 != 0) {
                  paramInt2 = 0;
                }
                for (;;)
                {
                  float f2;
                  float f1;
                  if (i6 > 0) {
                    if (l1 != 0L)
                    {
                      if (i6 < i4 - 1) {}
                      while ((paramInt2 != 0) || (i2 > 1))
                      {
                        f2 = Long.bitCount(l1);
                        if (paramInt2 != 0) {
                          break label1591;
                        }
                        f1 = f2;
                        if ((1L & l1) != 0L)
                        {
                          f1 = f2;
                          if (!((t)getChildAt(0).getLayoutParams()).f) {
                            f1 = f2 - 0.5F;
                          }
                        }
                        paramInt2 = i14 - 1;
                        if ((1 << paramInt2 & l1) == 0L) {
                          break label1588;
                        }
                        if (((t)getChildAt(paramInt2).getLayoutParams()).f) {
                          break label1585;
                        }
                        f1 = -0.5F + f1;
                        if (f1 <= 0.0F) {
                          break label1579;
                        }
                        m = (int)(i6 * i13 / f1);
                        i1 = 0;
                        paramInt2 = paramInt1;
                        if (i1 >= i14) {
                          break;
                        }
                        if ((1 << i1 & l1) != 0L)
                        {
                          localObject1 = getChildAt(i1);
                          localObject2 = (t)((View)localObject1).getLayoutParams();
                          if ((localObject1 instanceof ActionMenuItemView))
                          {
                            ((t)localObject2).d = m;
                            ((t)localObject2).c = true;
                            if (i1 == 0) {
                              if (!((t)localObject2).f)
                              {
                                ((t)localObject2).leftMargin = (-m / 2);
                                paramInt1 = 1;
                              }
                            }
                          }
                        }
                        for (;;)
                        {
                          i1 += 1;
                          break;
                          paramInt1 = 1;
                          continue;
                          paramInt1 = 1;
                          continue;
                          if (((t)localObject2).e)
                          {
                            ((t)localObject2).d = m;
                            ((t)localObject2).c = true;
                            ((t)localObject2).rightMargin = (-m / 2);
                            paramInt1 = 1;
                          }
                          else
                          {
                            if (i1 != 0) {
                              ((t)localObject2).leftMargin = (m / 2);
                            }
                            if (i1 != i14 - 1) {
                              ((t)localObject2).rightMargin = (m / 2);
                            } else {}
                          }
                        }
                      }
                      paramInt2 = paramInt1;
                    }
                  }
                  for (;;)
                  {
                    if (paramInt2 != 0)
                    {
                      paramInt1 = 0;
                      while (paramInt1 < i14)
                      {
                        localObject1 = getChildAt(paramInt1);
                        localObject2 = (t)((View)localObject1).getLayoutParams();
                        if (((t)localObject2).c)
                        {
                          paramInt2 = ((t)localObject2).a;
                          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(((t)localObject2).d + paramInt2 * i13, 1073741824), i11);
                        }
                        paramInt1 += 1;
                      }
                    }
                    if (i10 != 1073741824) {}
                    for (;;)
                    {
                      setMeasuredDimension(i12, n);
                      return;
                      n = i9;
                    }
                    m = 0;
                    break label1285;
                    break;
                    break;
                    f1 = f2;
                    break;
                    paramInt2 = paramInt1;
                    continue;
                    paramInt2 = paramInt1;
                  }
                  if (i4 == 1) {
                    paramInt2 = 1;
                  } else {
                    paramInt2 = 0;
                  }
                }
              }
              if (i4 == 2) {
                i5 = 1;
              } else {
                i5 = 0;
              }
            }
          }
          m = 0;
        }
      }
    }
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.d.g = paramBoolean;
  }
  
  public void setOnMenuItemClickListener(v paramv)
  {
    this.c = paramv;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    getMenu();
    j localj = this.d;
    n localn = localj.i;
    if (localn != null)
    {
      localn.setImageDrawable(paramDrawable);
      return;
    }
    localj.l = true;
    localj.k = paramDrawable;
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.l != paramInt)
    {
      this.l = paramInt;
      if (paramInt == 0) {
        this.k = getContext();
      }
    }
    else
    {
      return;
    }
    this.k = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setPresenter(j paramj)
  {
    this.d = paramj;
    this.d.a(this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */