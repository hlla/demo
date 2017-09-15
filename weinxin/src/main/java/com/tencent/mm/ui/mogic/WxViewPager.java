package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.c;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.a;
import android.support.v4.view.a.f;
import android.support.v4.view.ae;
import android.support.v4.view.g;
import android.support.v4.view.o;
import android.support.v4.view.u;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.gmtrace.GMTrace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import junit.framework.Assert;

public class WxViewPager
  extends ViewGroup
{
  private static final e whz;
  private static final int[] ym;
  private static final Comparator<b> yo;
  private static final Interpolator yp;
  private final ArrayList<b> eh;
  private final Rect eq;
  public VelocityTracker fk;
  private int fl;
  public boolean iC;
  private int iE;
  private boolean pd;
  public long qjJ;
  private final b whx;
  private d why;
  public float xC;
  private float xD;
  private int xV;
  private Drawable yA;
  private int yB;
  private int yC;
  private float yD;
  private float yE;
  private int yF;
  private int yG;
  private boolean yH;
  private boolean yI;
  private int yJ;
  private boolean yK;
  private int yL;
  private int yM;
  public float yN;
  public float yO;
  private int yP;
  private int yQ;
  private int yR;
  private int yS;
  public boolean yT;
  private i yU;
  private i yV;
  private boolean yW;
  private boolean yX;
  private boolean yY;
  private int yZ;
  private int yn;
  public u yr;
  public int ys;
  private int yt;
  private Parcelable yu;
  private ClassLoader yv;
  public Scroller yw;
  public int yz;
  private ViewPager.e zb;
  private ViewPager.e zc;
  private ViewPager.f ze;
  private int zf;
  private ArrayList<View> zg;
  private final Runnable zi;
  
  static
  {
    GMTrace.i(1869921386496L, 13932);
    ym = new int[] { 16842931 };
    yo = new Comparator() {};
    yp = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        GMTrace.i(1857036484608L, 13836);
        paramAnonymousFloat -= 1.0F;
        GMTrace.o(1857036484608L, 13836);
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    whz = new e();
    GMTrace.o(1869921386496L, 13932);
  }
  
  public WxViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1860928798720L, 13865);
    this.eh = new ArrayList();
    this.whx = new b();
    this.eq = new Rect();
    this.yt = -1;
    this.yu = null;
    this.yv = null;
    this.yD = -3.4028235E38F;
    this.yE = Float.MAX_VALUE;
    this.yJ = 1;
    this.fl = -1;
    this.yW = true;
    this.yX = false;
    this.zi = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1855157436416L, 13822);
        WxViewPager.a(WxViewPager.this);
        WxViewPager.this.populate();
        GMTrace.o(1855157436416L, 13822);
      }
    };
    this.xV = 0;
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    paramContext = getContext();
    this.yw = new Scroller(paramContext, yp);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.iE = ae.a(paramAttributeSet);
    this.yP = ((int)(400.0F * f));
    this.yQ = paramAttributeSet.getScaledMaximumFlingVelocity();
    this.yU = new i(paramContext);
    this.yV = new i(paramContext);
    this.yR = ((int)(25.0F * f));
    this.yS = ((int)(2.0F * f));
    this.yL = ((int)(16.0F * f));
    z.a(this, new c());
    if (z.G(this) == 0) {
      z.i(this, 1);
    }
    GMTrace.o(1860928798720L, 13865);
  }
  
  private b BX(int paramInt)
  {
    GMTrace.i(1864552677376L, 13892);
    int i = 0;
    while (i < this.eh.size())
    {
      b localb = (b)this.eh.get(i);
      if (localb.position == paramInt)
      {
        GMTrace.o(1864552677376L, 13892);
        return localb;
      }
      i += 1;
    }
    GMTrace.o(1864552677376L, 13892);
    return null;
  }
  
  private void Z(int paramInt)
  {
    GMTrace.i(1863344717824L, 13883);
    int i;
    Object localObject2;
    if (this.ys != paramInt) {
      if (this.ys < paramInt)
      {
        i = 66;
        localObject2 = BX(this.ys);
        this.ys = paramInt;
      }
    }
    for (int j = i;; j = 2)
    {
      if (this.yr == null)
      {
        bR();
        GMTrace.o(1863344717824L, 13883);
        return;
        i = 17;
        break;
      }
      if (this.yI)
      {
        bR();
        GMTrace.o(1863344717824L, 13883);
        return;
      }
      if (getWindowToken() == null)
      {
        GMTrace.o(1863344717824L, 13883);
        return;
      }
      paramInt = this.yJ;
      int i3 = Math.max(0, this.ys - paramInt);
      int i1 = this.yr.getCount();
      int i2 = Math.min(i1 - 1, paramInt + this.ys);
      Object localObject1;
      if (i1 != this.yn) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.yn + ", found: " + i1 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.yr.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < this.eh.size())
      {
        localObject1 = (b)this.eh.get(paramInt);
        if (((b)localObject1).position >= this.ys) {
          if (((b)localObject1).position != this.ys) {
            break label1301;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i1 > 0)) {}
        for (Object localObject3 = eh(this.ys, paramInt);; localObject3 = localObject1)
        {
          label370:
          int i4;
          float f2;
          label383:
          float f3;
          int k;
          label405:
          float f1;
          if (localObject3 != null)
          {
            int n = paramInt - 1;
            int m;
            Object localObject4;
            if (n >= 0)
            {
              localObject1 = (b)this.eh.get(n);
              i4 = bP();
              if (i4 > 0) {
                break label567;
              }
              f2 = 0.0F;
              i = this.ys;
              f3 = 0.0F;
              m = i - 1;
              k = paramInt;
              localObject4 = localObject1;
              if (m < 0) {
                break label717;
              }
              if ((f3 < f2) || (m >= i3)) {
                break label597;
              }
              if (localObject4 == null) {
                break label717;
              }
              localObject1 = localObject4;
              paramInt = n;
              f1 = f3;
              i = k;
              if (m == ((b)localObject4).position)
              {
                localObject1 = localObject4;
                paramInt = n;
                f1 = f3;
                i = k;
                if (!((b)localObject4).zl)
                {
                  this.eh.remove(n);
                  this.yr.a(this, m, ((b)localObject4).zk);
                  paramInt = n - 1;
                  i = k - 1;
                  if (paramInt < 0) {
                    break label588;
                  }
                  localObject1 = (b)this.eh.get(paramInt);
                  f1 = f3;
                }
              }
            }
            for (;;)
            {
              m -= 1;
              localObject4 = localObject1;
              n = paramInt;
              f3 = f1;
              k = i;
              break label405;
              paramInt += 1;
              break;
              localObject1 = null;
              break label370;
              label567:
              f2 = 2.0F - ((b)localObject3).zm + getPaddingLeft() / i4;
              break label383;
              label588:
              localObject1 = null;
              f1 = f3;
              continue;
              label597:
              if ((localObject4 != null) && (m == ((b)localObject4).position))
              {
                f1 = f3 + ((b)localObject4).zm;
                paramInt = n - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (b)this.eh.get(paramInt);
                  i = k;
                }
                else
                {
                  localObject1 = null;
                  i = k;
                }
              }
              else
              {
                f1 = f3 + eh(m, n + 1).zm;
                i = k + 1;
                if (n >= 0)
                {
                  localObject1 = (b)this.eh.get(n);
                  paramInt = n;
                }
                else
                {
                  localObject1 = null;
                  paramInt = n;
                }
              }
            }
            label717:
            f1 = ((b)localObject3).zm;
            paramInt = k + 1;
            if (f1 < 2.0F) {
              if (paramInt < this.eh.size())
              {
                localObject1 = (b)this.eh.get(paramInt);
                if (i4 > 0) {
                  break label883;
                }
                f2 = 0.0F;
                label765:
                i = this.ys;
                i += 1;
                label777:
                if (i >= i1) {
                  break label1026;
                }
                if ((f1 < f2) || (i <= i2)) {
                  break label904;
                }
                if (localObject1 == null) {
                  break label1026;
                }
                if ((i != ((b)localObject1).position) || (((b)localObject1).zl)) {
                  break label1291;
                }
                this.eh.remove(paramInt);
                this.yr.a(this, i, ((b)localObject1).zk);
                if (paramInt >= this.eh.size()) {
                  break label898;
                }
                localObject1 = (b)this.eh.get(paramInt);
              }
            }
          }
          label883:
          label898:
          label904:
          label1026:
          label1291:
          for (;;)
          {
            i += 1;
            break label777;
            localObject1 = null;
            break;
            f2 = getPaddingRight() / i4 + 2.0F;
            break label765;
            localObject1 = null;
            continue;
            if ((localObject1 != null) && (i == ((b)localObject1).position))
            {
              f3 = ((b)localObject1).zm;
              paramInt += 1;
              if (paramInt < this.eh.size()) {}
              for (localObject1 = (b)this.eh.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
            }
            localObject1 = eh(i, paramInt);
            paramInt += 1;
            f3 = ((b)localObject1).zm;
            if (paramInt < this.eh.size()) {}
            for (localObject1 = (b)this.eh.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            a((b)localObject3, k, (b)localObject2);
            localObject2 = this.yr;
            if (localObject3 != null) {}
            for (localObject1 = ((b)localObject3).zk;; localObject1 = null)
            {
              ((u)localObject2).d(localObject1);
              this.yr.ba();
              i = getChildCount();
              paramInt = 0;
              while (paramInt < i)
              {
                localObject2 = getChildAt(paramInt);
                localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
                ((LayoutParams)localObject1).zq = paramInt;
                if ((!((LayoutParams)localObject1).zo) && (((LayoutParams)localObject1).zm == 0.0F))
                {
                  localObject2 = dy((View)localObject2);
                  if (localObject2 != null)
                  {
                    ((LayoutParams)localObject1).zm = ((b)localObject2).zm;
                    ((LayoutParams)localObject1).position = ((b)localObject2).position;
                  }
                }
                paramInt += 1;
              }
            }
            bR();
            if (hasFocus())
            {
              localObject1 = findFocus();
              if (localObject1 != null) {}
              for (localObject1 = dz((View)localObject1); (localObject1 == null) || (((b)localObject1).position != this.ys); localObject1 = null)
              {
                paramInt = 0;
                while (paramInt < getChildCount())
                {
                  localObject1 = getChildAt(paramInt);
                  localObject2 = dy((View)localObject1);
                  if ((localObject2 != null) && (((b)localObject2).position == this.ys) && (((View)localObject1).requestFocus(j))) {
                    break;
                  }
                  paramInt += 1;
                }
              }
            }
            GMTrace.o(1863344717824L, 13883);
            return;
          }
        }
        label1301:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    GMTrace.i(1867908120576L, 13917);
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        GMTrace.o(1867908120576L, 13917);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      GMTrace.o(1867908120576L, 13917);
      return paramRect;
    }
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2)
  {
    GMTrace.i(1865626419200L, 13900);
    int i;
    int j;
    int i2;
    int n;
    View localView;
    int k;
    int m;
    label140:
    int i4;
    if (this.yZ > 0)
    {
      int i1 = getScrollX();
      i = getPaddingLeft();
      j = getPaddingRight();
      i2 = getWidth();
      int i3 = getChildCount();
      n = 0;
      if (n < i3)
      {
        localView = getChildAt(n);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.zo) {
          break label431;
        }
        switch (localLayoutParams.gravity & 0x7)
        {
        case 2: 
        case 4: 
        default: 
          k = i;
          m = j;
          j = i;
          i = m;
          i4 = k + i1 - localView.getLeft();
          k = i;
          m = j;
          if (i4 != 0)
          {
            localView.offsetLeftAndRight(i4);
            m = j;
            k = i;
          }
          break;
        }
      }
    }
    for (;;)
    {
      n += 1;
      i = m;
      j = k;
      break;
      k = localView.getWidth();
      m = k + i;
      k = i;
      i = j;
      j = m;
      break label140;
      k = Math.max((i2 - localView.getMeasuredWidth()) / 2, i);
      m = i;
      i = j;
      j = m;
      break label140;
      k = i2 - j - localView.getMeasuredWidth();
      i4 = localView.getMeasuredWidth();
      m = i;
      i = j + i4;
      j = m;
      break label140;
      if (this.zb != null) {
        this.zb.a(paramInt1, paramFloat, paramInt2);
      }
      if (this.zc != null) {
        this.zc.a(paramInt1, paramFloat, paramInt2);
      }
      if (this.ze != null)
      {
        paramInt2 = getScrollX();
        i = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          localView = getChildAt(paramInt1);
          if (!((LayoutParams)localView.getLayoutParams()).zo)
          {
            paramFloat = (localView.getLeft() - paramInt2) / bP();
            this.ze.h(localView, paramFloat);
          }
          paramInt1 += 1;
        }
      }
      this.yY = true;
      GMTrace.o(1865626419200L, 13900);
      return;
      label431:
      k = j;
      m = i;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    GMTrace.i(1862136758272L, 13874);
    b localb = BX(paramInt1);
    int i = 0;
    if (localb != null) {
      i = (int)(bP() * Math.max(this.yD, Math.min(localb.zn, this.yE)));
    }
    if (paramBoolean1)
    {
      if (getChildCount() == 0) {
        setScrollingCacheEnabled(false);
      }
      int j;
      int k;
      int m;
      for (;;)
      {
        if ((paramBoolean2) && (this.zb != null)) {
          this.zb.V(paramInt1);
        }
        if ((!paramBoolean2) || (this.zc == null)) {
          break label405;
        }
        this.zc.V(paramInt1);
        GMTrace.o(1862136758272L, 13874);
        return;
        j = getScrollX();
        k = getScrollY();
        i -= j;
        m = 0 - k;
        if ((i != 0) || (m != 0)) {
          break;
        }
        r(false);
        populate();
        X(0);
      }
      setScrollingCacheEnabled(true);
      X(2);
      int n = bP();
      int i1 = n / 2;
      float f3 = Math.min(1.0F, 1.0F * Math.abs(i) / n);
      float f1 = i1;
      float f2 = i1;
      f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
      paramInt2 = Math.abs(paramInt2);
      if (paramInt2 > 0) {}
      for (paramInt2 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt2)) * 4;; paramInt2 = (int)((Math.abs(i) / (f1 * 1.0F + this.yz) + 3.0F) * 100.0F))
      {
        paramInt2 = Math.min(paramInt2, 600);
        this.yw.startScroll(j, k, i, m, paramInt2);
        z.F(this);
        break;
        f1 = n;
      }
    }
    if ((paramBoolean2) && (this.zb != null)) {
      this.zb.V(paramInt1);
    }
    if ((paramBoolean2) && (this.zc != null)) {
      this.zc.V(paramInt1);
    }
    r(false);
    scrollTo(i, 0);
    ab(i);
    label405:
    GMTrace.o(1862136758272L, 13874);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(1861868322816L, 13872);
    a(paramInt, paramBoolean1, paramBoolean2, 0);
    GMTrace.o(1861868322816L, 13872);
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    GMTrace.i(1862002540544L, 13873);
    if ((this.yr == null) || (this.yr.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      GMTrace.o(1862002540544L, 13873);
      return;
    }
    if ((!paramBoolean2) && (this.ys == paramInt1) && (this.eh.size() != 0))
    {
      setScrollingCacheEnabled(false);
      GMTrace.o(1862002540544L, 13873);
      return;
    }
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      paramInt1 = this.yJ;
      if ((i <= this.ys + paramInt1) && (i >= this.ys - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.eh.size())
      {
        ((b)this.eh.get(paramInt1)).zl = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.yr.getCount()) {
        i = this.yr.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.ys != i) {
      paramBoolean2 = true;
    }
    if (this.yW)
    {
      this.ys = i;
      if ((paramBoolean2) && (this.zb != null)) {
        this.zb.V(i);
      }
      if ((paramBoolean2) && (this.zc != null)) {
        this.zc.V(i);
      }
      requestLayout();
      GMTrace.o(1862002540544L, 13873);
      return;
    }
    Z(i);
    a(i, paramBoolean1, paramInt2, paramBoolean2);
    GMTrace.o(1862002540544L, 13873);
  }
  
  private void a(b paramb1, int paramInt, b paramb2)
  {
    GMTrace.i(1863613153280L, 13885);
    int k = this.yr.getCount();
    int i = bP();
    if (i > 0) {}
    float f1;
    float f3;
    int j;
    for (float f2 = this.yz / i;; f2 = 0.0F)
    {
      if (paramb2 == null) {
        break label382;
      }
      i = paramb2.position;
      if (i >= paramb1.position) {
        break;
      }
      f1 = paramb2.zn;
      f3 = paramb2.zm;
      j = 0;
      f1 = f1 + f3 + f2;
      i += 1;
      if ((i > paramb1.position) || (j >= this.eh.size())) {
        break label382;
      }
      for (paramb2 = (b)this.eh.get(j); (i > paramb2.position) && (j < this.eh.size() - 1); paramb2 = (b)this.eh.get(j)) {
        j += 1;
      }
    }
    for (;;)
    {
      if (i < paramb2.position)
      {
        i += 1;
        f1 = 1.0F + f2 + f1;
      }
      else
      {
        paramb2.zn = f1;
        f1 += paramb2.zm + f2;
        i += 1;
        break;
        if (i > paramb1.position)
        {
          j = this.eh.size();
          f1 = paramb2.zn;
          j -= 1;
          i -= 1;
          if ((i >= paramb1.position) && (j >= 0)) {
            for (paramb2 = (b)this.eh.get(j); (i < paramb2.position) && (j > 0); paramb2 = (b)this.eh.get(j)) {
              j -= 1;
            }
          }
        }
        for (;;)
        {
          if (i > paramb2.position)
          {
            i -= 1;
            f1 -= 1.0F + f2;
          }
          else
          {
            f1 -= paramb2.zm + f2;
            paramb2.zn = f1;
            i -= 1;
            break;
            label382:
            int m = this.eh.size();
            f3 = paramb1.zn;
            i = paramb1.position - 1;
            if (paramb1.position == 0)
            {
              f1 = paramb1.zn;
              this.yD = f1;
              if (paramb1.position != k - 1) {
                break label515;
              }
              f1 = paramb1.zn + paramb1.zm - 1.0F;
              label448:
              this.yE = f1;
              j = paramInt - 1;
              f1 = f3;
            }
            for (;;)
            {
              if (j < 0) {
                break label568;
              }
              paramb2 = (b)this.eh.get(j);
              for (;;)
              {
                if (i > paramb2.position)
                {
                  i -= 1;
                  f1 -= 1.0F + f2;
                  continue;
                  f1 = -3.4028235E38F;
                  break;
                  label515:
                  f1 = Float.MAX_VALUE;
                  break label448;
                }
              }
              f1 -= paramb2.zm + f2;
              paramb2.zn = f1;
              if (paramb2.position == 0) {
                this.yD = f1;
              }
              i -= 1;
              j -= 1;
            }
            label568:
            f1 = paramb1.zn + paramb1.zm + f2;
            j = paramb1.position + 1;
            i = paramInt + 1;
            paramInt = j;
            while (i < m)
            {
              paramb1 = (b)this.eh.get(i);
              while (paramInt < paramb1.position)
              {
                paramInt += 1;
                f1 += 1.0F + f2;
              }
              if (paramb1.position == k - 1) {
                this.yE = (paramb1.zm + f1 - 1.0F);
              }
              paramb1.zn = f1;
              f1 += paramb1.zm + f2;
              paramInt += 1;
              i += 1;
            }
            this.yX = false;
            GMTrace.o(1863613153280L, 13885);
            return;
          }
        }
      }
    }
  }
  
  private boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1867505467392L, 13914);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (a(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop())))
        {
          GMTrace.o(1867505467392L, 13914);
          return true;
        }
        i -= 1;
      }
    }
    if ((paramBoolean) && (z.g(paramView, -paramInt1)))
    {
      GMTrace.o(1867505467392L, 13914);
      return true;
    }
    GMTrace.o(1867505467392L, 13914);
    return false;
  }
  
  private boolean ab(int paramInt)
  {
    GMTrace.i(1865492201472L, 13899);
    if (this.eh.size() == 0)
    {
      this.yY = false;
      a(0, 0.0F, 0);
      if (!this.yY) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      GMTrace.o(1865492201472L, 13899);
      return false;
    }
    b localb = bZe();
    int j = bP();
    int k = this.yz;
    float f = this.yz / j;
    int i = localb.position;
    f = (paramInt / j - localb.zn) / (localb.zm + f);
    paramInt = (int)((k + j) * f);
    this.yY = false;
    a(i, f, paramInt);
    if (!this.yY) {
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    GMTrace.o(1865492201472L, 13899);
    return true;
  }
  
  private boolean arrowScroll(int paramInt)
  {
    GMTrace.i(1867773902848L, 13916);
    View localView = findFocus();
    Object localObject;
    int j;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label326;
      }
      if (paramInt != 17) {
        break label272;
      }
      i = a(this.eq, localView).left;
      j = a(this.eq, (View)localObject).left;
      if ((localObject != null) && (i >= j))
      {
        bool = bV();
        label98:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        GMTrace.o(1867773902848L, 13916);
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label372;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label379;
      }
      if (localObject != this) {}
    }
    label272:
    label326:
    label366:
    label372:
    label379:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ").append(localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label98;
        if (paramInt == 66)
        {
          i = a(this.eq, localView).left;
          j = a(this.eq, (View)localObject).left;
          if ((localObject == null) || (i > j))
          {
            bool = localView.requestFocus();
            break label98;
            if ((paramInt == 17) || (paramInt == 1))
            {
              bool = bV();
              break label98;
            }
            if ((paramInt != 66) && (paramInt != 2)) {
              break label366;
            }
          }
          bool = bW();
          break label98;
        }
        bool = false;
        break label98;
      }
      localObject = localView;
      break;
    }
  }
  
  private int bP()
  {
    GMTrace.i(1861465669632L, 13869);
    int i = getMeasuredWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    GMTrace.o(1861465669632L, 13869);
    return i - j - k;
  }
  
  private void bR()
  {
    GMTrace.i(1863478935552L, 13884);
    if (this.zf != 0)
    {
      if (this.zg == null) {
        this.zg = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.zg.add(localView);
          i += 1;
        }
        this.zg.clear();
      }
      Collections.sort(this.zg, whz);
    }
    GMTrace.o(1863478935552L, 13884);
  }
  
  private boolean bV()
  {
    GMTrace.i(1868042338304L, 13918);
    if (this.ys > 0)
    {
      k(this.ys - 1, true);
      GMTrace.o(1868042338304L, 13918);
      return true;
    }
    GMTrace.o(1868042338304L, 13918);
    return false;
  }
  
  private boolean bW()
  {
    GMTrace.i(1868176556032L, 13919);
    if ((this.yr != null) && (this.ys < this.yr.getCount() - 1))
    {
      k(this.ys + 1, true);
      GMTrace.o(1868176556032L, 13919);
      return true;
    }
    GMTrace.o(1868176556032L, 13919);
    return false;
  }
  
  private b bZe()
  {
    GMTrace.i(1866297507840L, 13905);
    int i = bP();
    float f1;
    float f2;
    label45:
    int k;
    float f3;
    float f4;
    int j;
    Object localObject;
    label62:
    b localb;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label209;
      }
      f2 = this.yz / i;
      k = -1;
      f3 = 0.0F;
      f4 = 0.0F;
      j = 1;
      localObject = null;
      i = 0;
      if (i >= this.eh.size()) {
        break label256;
      }
      localb = (b)this.eh.get(i);
      if ((j != 0) || (localb.position == k + 1)) {
        break label268;
      }
      localb = this.whx;
      localb.zn = (f4 + f3 + f2);
      localb.position = (k + 1);
      localb.zm = 1.0F;
      i -= 1;
    }
    label209:
    label226:
    label256:
    label268:
    for (;;)
    {
      f3 = localb.zn;
      f4 = localb.zm;
      if ((j != 0) || (f1 >= f3))
      {
        if ((f1 >= f4 + f3 + f2) && (i != this.eh.size() - 1)) {
          break label226;
        }
        GMTrace.o(1866297507840L, 13905);
        return localb;
        f1 = 0.0F;
        break;
        f2 = 0.0F;
        break label45;
      }
      GMTrace.o(1866297507840L, 13905);
      return (b)localObject;
      k = localb.position;
      f4 = localb.zm;
      j = 0;
      i += 1;
      localObject = localb;
      break label62;
      GMTrace.o(1866297507840L, 13905);
      return (b)localObject;
    }
  }
  
  private void cz()
  {
    GMTrace.i(1867102814208L, 13911);
    this.iC = false;
    this.yK = false;
    if (this.fk != null)
    {
      this.fk.recycle();
      this.fk = null;
    }
    GMTrace.o(1867102814208L, 13911);
  }
  
  private b dy(View paramView)
  {
    GMTrace.i(1864284241920L, 13890);
    int i = 0;
    while (i < this.eh.size())
    {
      b localb = (b)this.eh.get(i);
      if (this.yr.a(paramView, localb.zk))
      {
        GMTrace.o(1864284241920L, 13890);
        return localb;
      }
      i += 1;
    }
    GMTrace.o(1864284241920L, 13890);
    return null;
  }
  
  private b dz(View paramView)
  {
    GMTrace.i(1864418459648L, 13891);
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View)))
      {
        GMTrace.o(1864418459648L, 13891);
        return null;
      }
      paramView = (View)localViewParent;
    }
    paramView = dy(paramView);
    GMTrace.o(1864418459648L, 13891);
    return paramView;
  }
  
  private b eh(int paramInt1, int paramInt2)
  {
    GMTrace.i(1862942064640L, 13880);
    b localb = new b();
    localb.position = paramInt1;
    localb.zk = this.yr.b(this, paramInt1);
    localb.zm = 1.0F;
    if ((paramInt2 < 0) || (paramInt2 >= this.eh.size())) {
      this.eh.add(localb);
    }
    for (;;)
    {
      GMTrace.o(1862942064640L, 13880);
      return localb;
      this.eh.add(paramInt2, localb);
    }
  }
  
  private void h(MotionEvent paramMotionEvent)
  {
    GMTrace.i(1866968596480L, 13910);
    int i = o.e(paramMotionEvent);
    if (o.c(paramMotionEvent, i) == this.fl) {
      if (i != 0) {
        break label74;
      }
    }
    label74:
    for (i = 1;; i = 0)
    {
      this.yN = o.d(paramMotionEvent, i);
      this.fl = o.c(paramMotionEvent, i);
      if (this.fk != null) {
        this.fk.clear();
      }
      GMTrace.o(1866968596480L, 13910);
      return;
    }
  }
  
  private boolean o(float paramFloat)
  {
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    GMTrace.i(1866163290112L, 13904);
    float f1 = this.yN;
    this.yN = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = bP();
    paramFloat = k * this.yD;
    f1 = k;
    float f3 = this.yE;
    b localb1 = (b)this.eh.get(0);
    b localb2 = (b)this.eh.get(this.eh.size() - 1);
    if (localb1.position != 0) {
      paramFloat = localb1.zn * k;
    }
    for (int i = 0;; i = 1)
    {
      if (localb2.position != this.yr.getCount() - 1)
      {
        f1 = localb2.zn * k;
        j = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i != 0)
          {
            bool1 = this.yU.u(Math.abs(paramFloat - f2) / k);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.yN += f1 - (int)f1;
          scrollTo((int)f1, getScrollY());
          ab((int)f1);
          GMTrace.o(1866163290112L, 13904);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (j != 0) {
              bool1 = this.yV.u(Math.abs(f2 - f1) / k);
            }
          }
          else
          {
            f1 = f2;
          }
        }
        f1 *= f3;
      }
    }
  }
  
  private void r(boolean paramBoolean)
  {
    GMTrace.i(1865760636928L, 13901);
    if (this.xV == 2) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        this.yw.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.yw.getCurrX();
        int n = this.yw.getCurrY();
        if ((j != m) || (k != n)) {
          scrollTo(m, n);
        }
      }
      this.yI = false;
      int k = 0;
      j = i;
      i = k;
      while (i < this.eh.size())
      {
        b localb = (b)this.eh.get(i);
        if (localb.zl)
        {
          localb.zl = false;
          j = 1;
        }
        i += 1;
      }
    }
    if (j != 0)
    {
      if (paramBoolean)
      {
        z.a(this, this.zi);
        GMTrace.o(1865760636928L, 13901);
        return;
      }
      this.zi.run();
    }
    GMTrace.o(1865760636928L, 13901);
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    GMTrace.i(1867237031936L, 13912);
    if (this.yH != paramBoolean) {
      this.yH = paramBoolean;
    }
    GMTrace.o(1867237031936L, 13912);
  }
  
  public final void BW(int paramInt)
  {
    GMTrace.i(1862539411456L, 13877);
    int i = paramInt;
    if (paramInt <= 0)
    {
      new StringBuilder("Requested offscreen page limit ").append(paramInt).append(" too small; defaulting to 1");
      i = 1;
    }
    if (i != this.yJ)
    {
      this.yJ = i;
      populate();
    }
    GMTrace.o(1862539411456L, 13877);
  }
  
  public final void X(int paramInt)
  {
    GMTrace.i(1861197234176L, 13867);
    if (this.xV == paramInt)
    {
      GMTrace.o(1861197234176L, 13867);
      return;
    }
    this.xV = paramInt;
    if (this.ze != null)
    {
      int i;
      int j;
      if (paramInt != 0)
      {
        i = 1;
        int m = getChildCount();
        j = 0;
        label53:
        if (j >= m) {
          break label95;
        }
        if (i == 0) {
          break label89;
        }
      }
      label89:
      for (int k = 2;; k = 0)
      {
        z.a(getChildAt(j), k, null);
        j += 1;
        break label53;
        i = 0;
        break;
      }
    }
    label95:
    if (this.zb != null) {
      this.zb.W(paramInt);
    }
    GMTrace.o(1861197234176L, 13867);
  }
  
  public final void Y(int paramInt)
  {
    GMTrace.i(1861599887360L, 13870);
    this.yI = false;
    if (!this.yW) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      GMTrace.o(1861599887360L, 13870);
      return;
    }
  }
  
  public void a(u paramu)
  {
    GMTrace.i(1861331451904L, 13868);
    if (this.yr != null)
    {
      this.yr.unregisterDataSetObserver(this.why);
      int i = 0;
      while (i < this.eh.size())
      {
        b localb = (b)this.eh.get(i);
        this.yr.a(this, localb.position, localb.zk);
        i += 1;
      }
      this.yr.ba();
      this.eh.clear();
      int j;
      for (i = 0; i < getChildCount(); i = j + 1)
      {
        j = i;
        if (!((LayoutParams)getChildAt(i).getLayoutParams()).zo)
        {
          removeViewAt(i);
          j = i - 1;
        }
      }
      this.ys = 0;
      scrollTo(0, 0);
    }
    this.yr = paramu;
    this.yn = 0;
    if (this.yr != null)
    {
      if (this.why == null) {
        this.why = new d((byte)0);
      }
      this.yr.registerDataSetObserver(this.why);
      this.yI = false;
      boolean bool = this.yW;
      this.yW = true;
      this.yn = this.yr.getCount();
      if (this.yt >= 0)
      {
        this.yr.a(this.yu, this.yv);
        a(this.yt, false, true);
        this.yt = -1;
        this.yu = null;
        this.yv = null;
        GMTrace.o(1861331451904L, 13868);
        return;
      }
      if (!bool)
      {
        populate();
        GMTrace.o(1861331451904L, 13868);
        return;
      }
      requestLayout();
    }
    GMTrace.o(1861331451904L, 13868);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    GMTrace.i(1868310773760L, 13920);
    Assert.assertNotNull(paramArrayList);
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          b localb = dy(localView);
          if ((localb != null) && (localb.position == this.ys)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if ((k != 262144) || (j == paramArrayList.size()))
    {
      if (!isFocusable())
      {
        GMTrace.o(1868310773760L, 13920);
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode()))
      {
        GMTrace.o(1868310773760L, 13920);
        return;
      }
      if (paramArrayList != null) {
        paramArrayList.add(this);
      }
    }
    GMTrace.o(1868310773760L, 13920);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    GMTrace.i(1868444991488L, 13921);
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = dy(localView);
        if ((localb != null) && (localb.position == this.ys)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
    GMTrace.o(1868444991488L, 13921);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    GMTrace.i(1864015806464L, 13888);
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      Assert.assertNotNull(paramLayoutParams);
      LayoutParams localLayoutParams = (LayoutParams)paramLayoutParams;
      localLayoutParams.zo |= paramView instanceof a;
      if (this.pd)
      {
        if ((localLayoutParams != null) && (localLayoutParams.zo)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.zp = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        GMTrace.o(1864015806464L, 13888);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      GMTrace.o(1864015806464L, 13888);
      return;
    }
  }
  
  public void b(ViewPager.e parame)
  {
    GMTrace.i(1862270976000L, 13875);
    this.zb = parame;
    GMTrace.o(1862270976000L, 13875);
  }
  
  final void bQ()
  {
    GMTrace.i(1863076282368L, 13881);
    int i2 = this.yr.getCount();
    this.yn = i2;
    int i;
    int j;
    int k;
    int n;
    int m;
    label76:
    Object localObject;
    if ((this.eh.size() < this.yJ * 2 + 1) && (this.eh.size() < i2))
    {
      i = 1;
      j = this.ys;
      k = 0;
      n = 0;
      m = i;
      i = j;
      j = k;
      k = n;
      if (k >= this.eh.size()) {
        break label279;
      }
      localObject = (b)this.eh.get(k);
      n = this.yr.j(((b)localObject).zk);
      if (n == -1) {
        break label372;
      }
      if (n != -2) {
        break label227;
      }
      this.eh.remove(k);
      m = k - 1;
      k = j;
      if (j == 0) {
        k = 1;
      }
      this.yr.a(this, ((b)localObject).position, ((b)localObject).zk);
      if (this.ys != ((b)localObject).position) {
        break label393;
      }
      j = Math.max(0, Math.min(this.ys, i2 - 1));
      i = k;
      k = 1;
    }
    for (;;)
    {
      n = k;
      int i1 = j;
      k = m + 1;
      j = i;
      i = i1;
      m = n;
      break label76;
      i = 0;
      break;
      label227:
      if (((b)localObject).position != n)
      {
        if (((b)localObject).position == this.ys) {
          i = n;
        }
        ((b)localObject).position = n;
        n = i;
        i1 = 1;
        m = k;
        i = j;
        j = n;
        k = i1;
        continue;
        label279:
        if (j != 0) {
          this.yr.ba();
        }
        Collections.sort(this.eh, yo);
        if (m != 0)
        {
          k = getChildCount();
          j = 0;
          while (j < k)
          {
            localObject = (LayoutParams)getChildAt(j).getLayoutParams();
            if (!((LayoutParams)localObject).zo) {
              ((LayoutParams)localObject).zm = 0.0F;
            }
            j += 1;
          }
          a(i, false, true);
          requestLayout();
        }
        GMTrace.o(1863076282368L, 13881);
      }
      else
      {
        label372:
        n = i;
        i1 = m;
        m = k;
        i = j;
        j = n;
        k = i1;
        continue;
        label393:
        j = i;
        n = 1;
        i = k;
        k = n;
      }
    }
  }
  
  public int bSt()
  {
    GMTrace.i(1866431725568L, 13906);
    int i = ((b)this.eh.get(0)).position;
    GMTrace.o(1866431725568L, 13906);
    return i;
  }
  
  public int bSu()
  {
    GMTrace.i(1866565943296L, 13907);
    int i = ((b)this.eh.get(this.eh.size() - 1)).position;
    GMTrace.o(1866565943296L, 13907);
    return i;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    GMTrace.i(1867371249664L, 13913);
    if (this.yr == null)
    {
      GMTrace.o(1867371249664L, 13913);
      return false;
    }
    int i = bP();
    int j = getScrollX();
    if (paramInt < 0)
    {
      if (j > (int)(i * this.yD))
      {
        GMTrace.o(1867371249664L, 13913);
        return true;
      }
      GMTrace.o(1867371249664L, 13913);
      return false;
    }
    if (paramInt > 0)
    {
      if (j < (int)(i * this.yE))
      {
        GMTrace.o(1867371249664L, 13913);
        return true;
      }
      GMTrace.o(1867371249664L, 13913);
      return false;
    }
    GMTrace.o(1867371249664L, 13913);
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    GMTrace.i(1869116080128L, 13926);
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams)))
    {
      GMTrace.o(1869116080128L, 13926);
      return true;
    }
    GMTrace.o(1869116080128L, 13926);
    return false;
  }
  
  public void computeScroll()
  {
    GMTrace.i(1865357983744L, 13898);
    if ((!this.yw.isFinished()) && (this.yw.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.yw.getCurrX();
      int m = this.yw.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!ab(k))
        {
          this.yw.abortAnimation();
          scrollTo(0, m);
        }
      }
      z.F(this);
      GMTrace.o(1865357983744L, 13898);
      return;
    }
    r(true);
    GMTrace.o(1865357983744L, 13898);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    GMTrace.i(1867639685120L, 13915);
    boolean bool;
    if (!super.dispatchKeyEvent(paramKeyEvent))
    {
      if (paramKeyEvent.getAction() == 0) {}
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool = false;
      }
    }
    for (;;)
    {
      if (!bool) {
        break label142;
      }
      GMTrace.o(1867639685120L, 13915);
      return true;
      bool = arrowScroll(17);
      continue;
      bool = arrowScroll(66);
      continue;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      if (g.a(paramKeyEvent))
      {
        bool = arrowScroll(2);
      }
      else
      {
        if (!g.a(paramKeyEvent, 1)) {
          break;
        }
        bool = arrowScroll(1);
      }
    }
    label142:
    GMTrace.o(1867639685120L, 13915);
    return false;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    GMTrace.i(1868713426944L, 13923);
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      boolean bool = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      GMTrace.o(1868713426944L, 13923);
      return bool;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = dy(localView);
        if ((localb != null) && (localb.position == this.ys) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)))
        {
          GMTrace.o(1868713426944L, 13923);
          return true;
        }
      }
      i += 1;
    }
    GMTrace.o(1868713426944L, 13923);
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    GMTrace.i(1866700161024L, 13908);
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = z.C(this);
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.yr != null) && (this.yr.getCount() > 1)))
    {
      int j;
      if (!this.yU.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.yD * m);
        this.yU.setSize(i, m);
        j = this.yU.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.yV.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.yE + 1.0F) * k);
        this.yV.setSize(n - i1 - i2, k);
        bool = j | this.yV.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        z.F(this);
      }
      GMTrace.o(1866700161024L, 13908);
      return;
      this.yU.finish();
      this.yV.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    GMTrace.i(1862807846912L, 13879);
    super.drawableStateChanged();
    Drawable localDrawable = this.yA;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
    GMTrace.o(1862807846912L, 13879);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    GMTrace.i(1868847644672L, 13924);
    LayoutParams localLayoutParams = new LayoutParams();
    GMTrace.o(1868847644672L, 13924);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    GMTrace.i(1869250297856L, 13927);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    GMTrace.o(1869250297856L, 13927);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    GMTrace.i(1868981862400L, 13925);
    paramLayoutParams = generateDefaultLayoutParams();
    GMTrace.o(1868981862400L, 13925);
    return paramLayoutParams;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    GMTrace.i(1862405193728L, 13876);
    int i = paramInt2;
    if (this.zf == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    paramInt1 = ((LayoutParams)((View)this.zg.get(i)).getLayoutParams()).zq;
    GMTrace.o(1862405193728L, 13876);
    return paramInt1;
  }
  
  public final void k(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(1861734105088L, 13871);
    this.yI = false;
    a(paramInt, paramBoolean, false);
    GMTrace.o(1861734105088L, 13871);
  }
  
  protected void onAttachedToWindow()
  {
    GMTrace.i(1864686895104L, 13893);
    super.onAttachedToWindow();
    this.yW = true;
    GMTrace.o(1864686895104L, 13893);
  }
  
  protected void onDetachedFromWindow()
  {
    GMTrace.i(1861063016448L, 13866);
    removeCallbacks(this.zi);
    super.onDetachedFromWindow();
    GMTrace.o(1861063016448L, 13866);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(1866834378752L, 13909);
    super.onDraw(paramCanvas);
    if ((this.yz > 0) && (this.yA != null) && (this.eh.size() > 0) && (this.yr != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f3 = this.yz / m;
      Object localObject = (b)this.eh.get(0);
      float f1 = ((b)localObject).zn;
      int n = this.eh.size();
      int i = ((b)localObject).position;
      int i1 = ((b)this.eh.get(n - 1)).position;
      int j = 0;
      if (i < i1)
      {
        while ((i > ((b)localObject).position) && (j < n))
        {
          localObject = this.eh;
          j += 1;
          localObject = (b)((ArrayList)localObject).get(j);
        }
        float f2;
        if (i == ((b)localObject).position) {
          f2 = (((b)localObject).zn + ((b)localObject).zm) * m;
        }
        for (f1 = ((b)localObject).zn + ((b)localObject).zm + f3;; f1 += 1.0F + f3)
        {
          if (this.yz + f2 > k)
          {
            this.yA.setBounds((int)f2, this.yB, (int)(this.yz + f2 + 0.5F), this.yC);
            this.yA.draw(paramCanvas);
          }
          if (f2 > k + m) {
            break label306;
          }
          i += 1;
          break;
          f2 = (1.0F + f1) * m;
        }
      }
    }
    label306:
    GMTrace.o(1866834378752L, 13909);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(1865894854656L, 13902);
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      this.iC = false;
      this.yK = false;
      this.fl = -1;
      if (this.fk != null)
      {
        this.fk.recycle();
        this.fk = null;
      }
      GMTrace.o(1865894854656L, 13902);
      return false;
    }
    if (i != 0)
    {
      if (this.iC)
      {
        GMTrace.o(1865894854656L, 13902);
        return true;
      }
      if (this.yK)
      {
        GMTrace.o(1865894854656L, 13902);
        return false;
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (this.fk == null) {
        this.fk = VelocityTracker.obtain();
      }
      this.fk.addMovement(paramMotionEvent);
      boolean bool = this.iC;
      GMTrace.o(1865894854656L, 13902);
      return bool;
      i = this.fl;
      if (i != -1)
      {
        i = o.b(paramMotionEvent, i);
        float f2 = o.d(paramMotionEvent, i);
        float f1 = f2 - this.yN;
        float f4 = Math.abs(f1);
        float f3 = o.e(paramMotionEvent, i);
        float f5 = Math.abs(f3 - this.xD);
        if (f1 != 0.0F)
        {
          float f6 = this.yN;
          if (((f6 < this.yM) && (f1 > 0.0F)) || ((f6 > getWidth() - this.yM) && (f1 < 0.0F))) {}
          for (i = 1; (i == 0) && (a(this, false, (int)f1, (int)f2, (int)f3)); i = 0)
          {
            this.yN = f2;
            this.yO = f3;
            this.yK = true;
            GMTrace.o(1865894854656L, 13902);
            return false;
          }
        }
        if ((f4 > this.iE) && (0.5F * f4 > f5))
        {
          this.iC = true;
          X(1);
          if (f1 > 0.0F)
          {
            f1 = this.xC + this.iE;
            label410:
            this.yN = f1;
            this.yO = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.iC) && (o(f2)))
        {
          z.F(this);
          break;
          f1 = this.xC - this.iE;
          break label410;
          if (f5 > this.iE) {
            this.yK = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.xC = f1;
        this.yN = f1;
        f1 = paramMotionEvent.getY();
        this.xD = f1;
        this.yO = f1;
        this.fl = o.c(paramMotionEvent, 0);
        this.yK = false;
        this.yw.computeScrollOffset();
        if ((this.xV == 2) && (Math.abs(this.yw.getFinalX() - this.yw.getCurrX()) > this.yS))
        {
          this.yw.abortAnimation();
          this.yI = false;
          populate();
          this.iC = true;
          X(1);
        }
        else
        {
          r(false);
          this.iC = false;
          continue;
          h(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1865223766016L, 13897);
    int i1 = getChildCount();
    int i3 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i4 = getScrollX();
    int j = 0;
    int m = 0;
    View localView;
    LayoutParams localLayoutParams;
    int i5;
    int k;
    label162:
    int n;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label688;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.zo) {
        break label688;
      }
      paramInt4 = localLayoutParams.gravity;
      i5 = localLayoutParams.gravity;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt2;
        k = paramInt2;
        switch (i5 & 0x70)
        {
        default: 
          n = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = n;
          label212:
          paramInt4 += i4;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
          j += 1;
          paramInt4 = i;
          paramInt3 = k;
          i = paramInt1;
          paramInt1 = j;
        }
        break;
      }
    }
    for (;;)
    {
      m += 1;
      k = paramInt3;
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i;
      i = paramInt4;
      paramInt2 = k;
      break;
      k = localView.getMeasuredWidth();
      paramInt4 = paramInt2;
      k += paramInt2;
      break label162;
      paramInt4 = Math.max((i3 - localView.getMeasuredWidth()) / 2, paramInt2);
      k = paramInt2;
      break label162;
      k = localView.getMeasuredWidth();
      paramInt4 = i + localView.getMeasuredWidth();
      n = i3 - i - k;
      i = paramInt4;
      k = paramInt2;
      paramInt4 = n;
      break label162;
      n = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      n += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = n;
      break label212;
      n = Math.max((i2 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = n;
      break label212;
      n = i2 - paramInt3 - localView.getMeasuredHeight();
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i5;
      paramInt3 = n;
      break label212;
      i = i3 - paramInt2 - i;
      paramInt4 = 0;
      while (paramInt4 < i1)
      {
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.zo)
          {
            b localb = dy(localView);
            if (localb != null)
            {
              float f = i;
              k = (int)(localb.zn * f) + paramInt2;
              if (localLayoutParams.zp)
              {
                localLayoutParams.zp = false;
                f = i;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.zm * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(k, paramInt1, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        paramInt4 += 1;
      }
      this.yB = paramInt1;
      this.yC = (i2 - paramInt3);
      this.yZ = j;
      if (this.yW) {
        a(this.ys, false, 0, false);
      }
      this.yW = false;
      GMTrace.o(1865223766016L, 13897);
      return;
      label688:
      paramInt4 = j;
      j = paramInt1;
      k = paramInt2;
      paramInt1 = paramInt4;
      paramInt4 = i;
      i = paramInt3;
      paramInt2 = j;
      paramInt3 = k;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(1864821112832L, 13894);
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.yM = Math.min(paramInt1 / 10, this.yL);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int k = 0;
    View localView;
    int i;
    int j;
    LayoutParams localLayoutParams;
    int m;
    int i1;
    label192:
    int n;
    if (k < i4)
    {
      localView = getChildAt(k);
      i = paramInt1;
      j = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localLayoutParams.zo)
          {
            i = localLayoutParams.gravity & 0x7;
            m = localLayoutParams.gravity & 0x70;
            i1 = Integer.MIN_VALUE;
            j = Integer.MIN_VALUE;
            if ((m != 48) && (m != 80)) {
              break label342;
            }
            m = 1;
            if ((i != 3) && (i != 5)) {
              break label348;
            }
            n = 1;
            label207:
            if (m == 0) {
              break label354;
            }
            i = 1073741824;
            label217:
            if (localLayoutParams.width == -2) {
              break label551;
            }
            i1 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label545;
            }
            i = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i3;
      if (localLayoutParams.height != -2)
      {
        i2 = 1073741824;
        j = i2;
        if (localLayoutParams.height != -1)
        {
          i3 = localLayoutParams.height;
          j = i2;
        }
      }
      for (int i2 = i3;; i2 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, i1), View.MeasureSpec.makeMeasureSpec(i2, j));
        if (m != 0)
        {
          j = paramInt2 - localView.getMeasuredHeight();
          i = paramInt1;
        }
        for (;;)
        {
          k += 1;
          paramInt1 = i;
          paramInt2 = j;
          break;
          label342:
          m = 0;
          break label192;
          label348:
          n = 0;
          break label207;
          label354:
          i = i1;
          if (n == 0) {
            break label217;
          }
          j = 1073741824;
          i = i1;
          break label217;
          i = paramInt1;
          j = paramInt2;
          if (n != 0)
          {
            i = paramInt1 - localView.getMeasuredWidth();
            j = paramInt2;
          }
        }
        this.yF = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.yG = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.pd = true;
        populate();
        this.pd = false;
        i = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if (((localLayoutParams == null) || (!localLayoutParams.zo)) && (localLayoutParams != null))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.zm * f), 1073741824), this.yG);
            }
          }
          paramInt2 += 1;
        }
        GMTrace.o(1864821112832L, 13894);
        return;
      }
      label545:
      i = paramInt1;
      continue;
      label551:
      i1 = i;
      i = paramInt1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int j = -1;
    GMTrace.i(1868579209216L, 13922);
    int k = getChildCount();
    int i;
    if ((paramInt & 0x2) != 0)
    {
      j = 1;
      i = 0;
    }
    while (i != k)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = dy(localView);
        if ((localb != null) && (localb.position == this.ys) && (localView.requestFocus(paramInt, paramRect)))
        {
          GMTrace.o(1868579209216L, 13922);
          return true;
          i = k - 1;
          k = -1;
          continue;
        }
      }
      i += j;
    }
    GMTrace.o(1868579209216L, 13922);
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    GMTrace.i(1863881588736L, 13887);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      GMTrace.o(1863881588736L, 13887);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.yr != null)
    {
      this.yr.a(paramParcelable.zr, paramParcelable.zt);
      a(paramParcelable.position, false, true);
      GMTrace.o(1863881588736L, 13887);
      return;
    }
    this.yt = paramParcelable.position;
    this.yu = paramParcelable.zr;
    this.yv = paramParcelable.zt;
    GMTrace.o(1863881588736L, 13887);
  }
  
  public Parcelable onSaveInstanceState()
  {
    GMTrace.i(1863747371008L, 13886);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.ys;
    if (this.yr != null) {
      localSavedState.zr = this.yr.bb();
    }
    GMTrace.o(1863747371008L, 13886);
    return localSavedState;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1864955330560L, 13895);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      u(paramInt1, paramInt3, this.yz, this.yz);
    }
    GMTrace.o(1864955330560L, 13895);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = 0;
    GMTrace.i(1866029072384L, 13903);
    if (this.yT)
    {
      GMTrace.o(1866029072384L, 13903);
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
    {
      GMTrace.o(1866029072384L, 13903);
      return false;
    }
    if ((this.yr == null) || (this.yr.getCount() == 0))
    {
      GMTrace.o(1866029072384L, 13903);
      return false;
    }
    if (this.fk == null) {
      this.fk = VelocityTracker.obtain();
    }
    this.fk.addMovement(paramMotionEvent);
    int i = n;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = n;
    }
    for (;;)
    {
      if (i != 0) {
        z.F(this);
      }
      GMTrace.o(1866029072384L, 13903);
      return true;
      this.yw.abortAnimation();
      this.yI = false;
      populate();
      this.iC = true;
      X(1);
      float f1 = paramMotionEvent.getX();
      this.xC = f1;
      this.yN = f1;
      f1 = paramMotionEvent.getY();
      this.xD = f1;
      this.yO = f1;
      this.fl = o.c(paramMotionEvent, 0);
      i = n;
      continue;
      float f2;
      if (!this.iC)
      {
        i = o.b(paramMotionEvent, this.fl);
        f1 = o.d(paramMotionEvent, i);
        float f3 = Math.abs(f1 - this.yN);
        f2 = o.e(paramMotionEvent, i);
        float f4 = Math.abs(f2 - this.yO);
        if ((f3 > this.iE) && (f3 > f4))
        {
          this.iC = true;
          if (f1 - this.xC <= 0.0F) {
            break label409;
          }
        }
      }
      label409:
      for (f1 = this.xC + this.iE;; f1 = this.xC - this.iE)
      {
        this.yN = f1;
        this.yO = f2;
        X(1);
        setScrollingCacheEnabled(true);
        i = n;
        if (!this.iC) {
          break;
        }
        bool1 = o(o.d(paramMotionEvent, o.b(paramMotionEvent, this.fl))) | false;
        break;
      }
      boolean bool1 = n;
      if (this.iC)
      {
        Object localObject = this.fk;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.yQ);
        int i2 = (int)y.a((VelocityTracker)localObject, this.fl);
        this.yI = true;
        int j = bP();
        int i1 = getScrollX();
        localObject = bZe();
        n = ((b)localObject).position;
        f2 = (i1 / j - ((b)localObject).zn) / ((b)localObject).zm;
        i1 = o.b(paramMotionEvent, this.fl);
        j = i1;
        if (i1 < 0) {
          j = 0;
        }
        boolean bool4;
        if ((Math.abs((int)(o.d(paramMotionEvent, j) - this.xC)) > this.yR) && (Math.abs(i2) > this.yP))
        {
          if (i2 > 0) {}
          for (j = n;; k = n + 1)
          {
            n = j;
            if (this.eh.size() > 0) {
              n = Math.max(bSt(), Math.min(j, bSu()));
            }
            a(n, true, true, i2);
            this.fl = -1;
            cz();
            bool4 = this.yU.cr();
            boolean bool2 = this.yV.cr() | bool4;
            break;
          }
        }
        if (n >= this.ys) {}
        for (f1 = 0.6F;; f1 = 0.4F)
        {
          k = (int)(f1 + (n + f2));
          break;
        }
        int k = n;
        if (this.iC)
        {
          a(this.ys, true, 0, false);
          this.fl = -1;
          cz();
          bool4 = this.yU.cr();
          boolean bool3 = this.yV.cr() | bool4;
          continue;
          int m = o.e(paramMotionEvent);
          this.yN = o.d(paramMotionEvent, m);
          this.fl = o.c(paramMotionEvent, m);
          m = n;
          continue;
          h(paramMotionEvent);
          this.yN = o.d(paramMotionEvent, o.b(paramMotionEvent, this.fl));
          m = n;
        }
      }
    }
  }
  
  final void populate()
  {
    GMTrace.i(1863210500096L, 13882);
    Z(this.ys);
    GMTrace.o(1863210500096L, 13882);
  }
  
  public void removeView(View paramView)
  {
    GMTrace.i(1864150024192L, 13889);
    if (this.pd)
    {
      removeViewInLayout(paramView);
      GMTrace.o(1864150024192L, 13889);
      return;
    }
    super.removeView(paramView);
    GMTrace.o(1864150024192L, 13889);
  }
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1865089548288L, 13896);
    if ((paramInt2 > 0) && (!this.eh.isEmpty()))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      f = getScrollX() / (paramInt2 - k - m + paramInt4);
      paramInt2 = (int)((paramInt1 - i - j + paramInt3) * f);
      scrollTo(paramInt2, getScrollY());
      if (!this.yw.isFinished())
      {
        paramInt3 = this.yw.getDuration();
        paramInt4 = this.yw.timePassed();
        localb = BX(this.ys);
        this.yw.startScroll(paramInt2, 0, (int)(localb.zn * paramInt1), 0, paramInt3 - paramInt4);
      }
      GMTrace.o(1865089548288L, 13896);
      return;
    }
    b localb = BX(this.ys);
    if (localb != null) {}
    for (float f = Math.min(localb.zn, this.yE);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX())
      {
        r(false);
        scrollTo(paramInt1, getScrollY());
      }
      GMTrace.o(1865089548288L, 13896);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    GMTrace.i(1862673629184L, 13878);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.yA))
    {
      GMTrace.o(1862673629184L, 13878);
      return true;
    }
    GMTrace.o(1862673629184L, 13878);
    return false;
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public int gravity;
    int position;
    float zm;
    public boolean zo;
    boolean zp;
    int zq;
    
    public LayoutParams()
    {
      super(-1);
      GMTrace.i(1854754783232L, 13819);
      this.zm = 0.0F;
      GMTrace.o(1854754783232L, 13819);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      GMTrace.i(1854889000960L, 13820);
      this.zm = 0.0F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, WxViewPager.bX());
      this.gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
      GMTrace.o(1854889000960L, 13820);
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int position;
    Parcelable zr;
    ClassLoader zt;
    
    static
    {
      GMTrace.i(1860257710080L, 13860);
      CREATOR = android.support.v4.os.b.a(new c() {});
      GMTrace.o(1860257710080L, 13860);
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      GMTrace.i(1860123492352L, 13859);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.zr = paramParcel.readParcelable(localClassLoader);
      this.zt = localClassLoader;
      GMTrace.o(1860123492352L, 13859);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
      GMTrace.i(1859720839168L, 13856);
      GMTrace.o(1859720839168L, 13856);
    }
    
    public String toString()
    {
      GMTrace.i(1859989274624L, 13858);
      String str = "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
      GMTrace.o(1859989274624L, 13858);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      GMTrace.i(1859855056896L, 13857);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.zr, paramInt);
      GMTrace.o(1859855056896L, 13857);
    }
  }
  
  static abstract interface a {}
  
  static final class b
  {
    int position;
    Object zk;
    boolean zl;
    float zm;
    float zn;
    
    b()
    {
      GMTrace.i(1870995128320L, 13940);
      GMTrace.o(1870995128320L, 13940);
    }
  }
  
  final class c
    extends a
  {
    c()
    {
      GMTrace.i(1855291654144L, 13823);
      GMTrace.o(1855291654144L, 13823);
    }
    
    private boolean bY()
    {
      GMTrace.i(1855828525056L, 13827);
      if ((WxViewPager.b(WxViewPager.this) != null) && (WxViewPager.b(WxViewPager.this).getCount() > 1))
      {
        GMTrace.o(1855828525056L, 13827);
        return true;
      }
      GMTrace.o(1855828525056L, 13827);
      return false;
    }
    
    public final void a(View paramView, android.support.v4.view.a.b paramb)
    {
      GMTrace.i(1855560089600L, 13825);
      super.a(paramView, paramb);
      paramb.setClassName(WxViewPager.class.getName());
      paramb.setScrollable(bY());
      if (WxViewPager.this.canScrollHorizontally(1)) {
        paramb.addAction(4096);
      }
      if (WxViewPager.this.canScrollHorizontally(-1)) {
        paramb.addAction(8192);
      }
      GMTrace.o(1855560089600L, 13825);
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      GMTrace.i(1855425871872L, 13824);
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(WxViewPager.class.getName());
      paramView = f.ch();
      paramView.setScrollable(bY());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (WxViewPager.b(WxViewPager.this) != null))
      {
        paramView.setItemCount(WxViewPager.b(WxViewPager.this).getCount());
        paramView.setFromIndex(WxViewPager.c(WxViewPager.this));
        paramView.setToIndex(WxViewPager.c(WxViewPager.this));
      }
      GMTrace.o(1855425871872L, 13824);
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      GMTrace.i(1855694307328L, 13826);
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      {
        GMTrace.o(1855694307328L, 13826);
        return true;
      }
      switch (paramInt)
      {
      default: 
        GMTrace.o(1855694307328L, 13826);
        return false;
      case 4096: 
        if (WxViewPager.this.canScrollHorizontally(1))
        {
          WxViewPager.this.Y(WxViewPager.c(WxViewPager.this) + 1);
          GMTrace.o(1855694307328L, 13826);
          return true;
        }
        GMTrace.o(1855694307328L, 13826);
        return false;
      }
      if (WxViewPager.this.canScrollHorizontally(-1))
      {
        WxViewPager.this.Y(WxViewPager.c(WxViewPager.this) - 1);
        GMTrace.o(1855694307328L, 13826);
        return true;
      }
      GMTrace.o(1855694307328L, 13826);
      return false;
    }
  }
  
  private final class d
    extends DataSetObserver
  {
    private d()
    {
      GMTrace.i(1871129346048L, 13941);
      GMTrace.o(1871129346048L, 13941);
    }
    
    public final void onChanged()
    {
      GMTrace.i(1871263563776L, 13942);
      WxViewPager.this.bQ();
      GMTrace.o(1871263563776L, 13942);
    }
    
    public final void onInvalidated()
    {
      GMTrace.i(1871397781504L, 13943);
      WxViewPager.this.bQ();
      GMTrace.o(1871397781504L, 13943);
    }
  }
  
  static final class e
    implements Comparator<View>
  {
    e()
    {
      GMTrace.i(1860391927808L, 13861);
      GMTrace.o(1860391927808L, 13861);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/mogic/WxViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */