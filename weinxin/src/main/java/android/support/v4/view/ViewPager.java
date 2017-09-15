package android.support.v4.view;

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
import android.support.v4.view.a.f;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
  extends ViewGroup
{
  private static final int[] ym = { 16842931 };
  private static final Comparator<b> yo = new Comparator() {};
  private static final Interpolator yp = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private static final i zh = new i();
  private final ArrayList<b> eh = new ArrayList();
  private final Rect eq = new Rect();
  private VelocityTracker fk;
  private int fl = -1;
  private boolean iC;
  private int iE;
  private boolean pd;
  private float xC;
  private float xD;
  private int xV = 0;
  private Drawable yA;
  private int yB;
  private int yC;
  private float yD = -3.4028235E38F;
  private float yE = Float.MAX_VALUE;
  private int yF;
  private int yG;
  private boolean yH;
  private boolean yI;
  public int yJ = 1;
  private boolean yK;
  private int yL;
  private int yM;
  private float yN;
  private float yO;
  private int yP;
  private int yQ;
  private int yR;
  private int yS;
  private boolean yT;
  private i yU;
  private i yV;
  private boolean yW = true;
  private boolean yX = false;
  private boolean yY;
  private int yZ;
  private int yn;
  private final b yq = new b();
  u yr;
  public int ys;
  private int yt = -1;
  private Parcelable yu = null;
  private ClassLoader yv = null;
  private Scroller yw;
  private boolean yx;
  private g yy;
  private int yz;
  public List<e> za;
  public e zb;
  private e zc;
  d zd;
  private f ze;
  private int zf;
  private ArrayList<View> zg;
  private final Runnable zi = new Runnable()
  {
    public final void run()
    {
      ViewPager.a(ViewPager.this);
      ViewPager.this.populate();
    }
  };
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
    z.b(this, new t()
    {
      private final Rect eq = new Rect();
      
      public final ap a(View paramAnonymousView, ap paramAnonymousap)
      {
        paramAnonymousView = z.a(paramAnonymousView, paramAnonymousap);
        if (paramAnonymousView.isConsumed()) {
          return paramAnonymousView;
        }
        paramAnonymousap = this.eq;
        paramAnonymousap.left = paramAnonymousView.getSystemWindowInsetLeft();
        paramAnonymousap.top = paramAnonymousView.getSystemWindowInsetTop();
        paramAnonymousap.right = paramAnonymousView.getSystemWindowInsetRight();
        paramAnonymousap.bottom = paramAnonymousView.getSystemWindowInsetBottom();
        int i = 0;
        int j = ViewPager.this.getChildCount();
        while (i < j)
        {
          ap localap = z.b(ViewPager.this.getChildAt(i), paramAnonymousView);
          paramAnonymousap.left = Math.min(localap.getSystemWindowInsetLeft(), paramAnonymousap.left);
          paramAnonymousap.top = Math.min(localap.getSystemWindowInsetTop(), paramAnonymousap.top);
          paramAnonymousap.right = Math.min(localap.getSystemWindowInsetRight(), paramAnonymousap.right);
          paramAnonymousap.bottom = Math.min(localap.getSystemWindowInsetBottom(), paramAnonymousap.bottom);
          i += 1;
        }
        return paramAnonymousView.d(paramAnonymousap.left, paramAnonymousap.top, paramAnonymousap.right, paramAnonymousap.bottom);
      }
    });
  }
  
  private void X(int paramInt)
  {
    int m = 0;
    if (this.xV == paramInt) {}
    label38:
    label74:
    label80:
    do
    {
      return;
      this.xV = paramInt;
      int i;
      int j;
      if (this.ze != null)
      {
        if (paramInt != 0)
        {
          i = 1;
          int n = getChildCount();
          j = 0;
          if (j >= n) {
            break label80;
          }
          if (i == 0) {
            break label74;
          }
        }
        for (int k = 2;; k = 0)
        {
          z.a(getChildAt(j), k, null);
          j += 1;
          break label38;
          i = 0;
          break;
        }
      }
      if (this.zb != null) {
        this.zb.W(paramInt);
      }
      if (this.za != null)
      {
        j = this.za.size();
        i = m;
        while (i < j)
        {
          e locale = (e)this.za.get(i);
          if (locale != null) {
            locale.W(paramInt);
          }
          i += 1;
        }
      }
    } while (this.zc == null);
    this.zc.W(paramInt);
  }
  
  private void Z(int paramInt)
  {
    Object localObject2;
    if (this.ys != paramInt)
    {
      localObject2 = aa(this.ys);
      this.ys = paramInt;
    }
    for (;;)
    {
      if (this.yr == null) {
        bR();
      }
      do
      {
        return;
        if (this.yI)
        {
          bR();
          return;
        }
      } while (getWindowToken() == null);
      paramInt = this.yJ;
      int i2 = Math.max(0, this.ys - paramInt);
      int n = this.yr.getCount();
      int i1 = Math.min(n - 1, paramInt + this.ys);
      Object localObject1;
      if (n != this.yn) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.yn + ", found: " + n + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.yr.getClass());
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
            break label1230;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (n > 0)) {}
        for (Object localObject3 = l(this.ys, paramInt);; localObject3 = localObject1)
        {
          label310:
          int i3;
          float f2;
          label323:
          int i;
          float f3;
          int j;
          label345:
          float f1;
          if (localObject3 != null)
          {
            int m = paramInt - 1;
            int k;
            Object localObject4;
            if (m >= 0)
            {
              localObject1 = (b)this.eh.get(m);
              i3 = bP();
              if (i3 > 0) {
                break label507;
              }
              f2 = 0.0F;
              i = this.ys;
              f3 = 0.0F;
              k = i - 1;
              j = paramInt;
              localObject4 = localObject1;
              if (k < 0) {
                break label657;
              }
              if ((f3 < f2) || (k >= i2)) {
                break label537;
              }
              if (localObject4 == null) {
                break label657;
              }
              localObject1 = localObject4;
              paramInt = m;
              f1 = f3;
              i = j;
              if (k == ((b)localObject4).position)
              {
                localObject1 = localObject4;
                paramInt = m;
                f1 = f3;
                i = j;
                if (!((b)localObject4).zl)
                {
                  this.eh.remove(m);
                  this.yr.a(this, k, ((b)localObject4).zk);
                  paramInt = m - 1;
                  i = j - 1;
                  if (paramInt < 0) {
                    break label528;
                  }
                  localObject1 = (b)this.eh.get(paramInt);
                  f1 = f3;
                }
              }
            }
            for (;;)
            {
              k -= 1;
              localObject4 = localObject1;
              m = paramInt;
              f3 = f1;
              j = i;
              break label345;
              paramInt += 1;
              break;
              localObject1 = null;
              break label310;
              label507:
              f2 = 2.0F - ((b)localObject3).zm + getPaddingLeft() / i3;
              break label323;
              label528:
              localObject1 = null;
              f1 = f3;
              continue;
              label537:
              if ((localObject4 != null) && (k == ((b)localObject4).position))
              {
                f1 = f3 + ((b)localObject4).zm;
                paramInt = m - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (b)this.eh.get(paramInt);
                  i = j;
                }
                else
                {
                  localObject1 = null;
                  i = j;
                }
              }
              else
              {
                f1 = f3 + l(k, m + 1).zm;
                i = j + 1;
                if (m >= 0)
                {
                  localObject1 = (b)this.eh.get(m);
                  paramInt = m;
                }
                else
                {
                  localObject1 = null;
                  paramInt = m;
                }
              }
            }
            label657:
            f1 = ((b)localObject3).zm;
            paramInt = j + 1;
            if (f1 < 2.0F) {
              if (paramInt < this.eh.size())
              {
                localObject1 = (b)this.eh.get(paramInt);
                label698:
                if (i3 > 0) {
                  break label823;
                }
                f2 = 0.0F;
                label705:
                i = this.ys;
                i += 1;
                label717:
                if (i >= n) {
                  break label966;
                }
                if ((f1 < f2) || (i <= i1)) {
                  break label844;
                }
                if (localObject1 == null) {
                  break label966;
                }
                if ((i != ((b)localObject1).position) || (((b)localObject1).zl)) {
                  break label1220;
                }
                this.eh.remove(paramInt);
                this.yr.a(this, i, ((b)localObject1).zk);
                if (paramInt >= this.eh.size()) {
                  break label838;
                }
                localObject1 = (b)this.eh.get(paramInt);
              }
            }
          }
          label823:
          label838:
          label844:
          label966:
          label1212:
          label1218:
          label1220:
          for (;;)
          {
            i += 1;
            break label717;
            localObject1 = null;
            break label698;
            f2 = getPaddingRight() / i3 + 2.0F;
            break label705;
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
            localObject1 = l(i, paramInt);
            paramInt += 1;
            f3 = ((b)localObject1).zm;
            if (paramInt < this.eh.size()) {}
            for (localObject1 = (b)this.eh.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            a((b)localObject3, j, (b)localObject2);
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
                  localObject2 = ap((View)localObject2);
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
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = aq((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (((b)localObject1).position == this.ys)) {
                break label1218;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1212;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = ap((View)localObject1);
                if ((localObject2 != null) && (((b)localObject2).position == this.ys) && (((View)localObject1).requestFocus(2))) {
                  break;
                }
                paramInt += 1;
              }
              break;
            }
            break;
          }
        }
        label1230:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
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
      return paramRect;
    }
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    int j;
    int i2;
    int n;
    Object localObject;
    int k;
    int m;
    label132:
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
        localObject = getChildAt(n);
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        if (!localLayoutParams.zo) {
          break label482;
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
          i4 = k + i1 - ((View)localObject).getLeft();
          k = i;
          m = j;
          if (i4 != 0)
          {
            ((View)localObject).offsetLeftAndRight(i4);
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
      k = ((View)localObject).getWidth();
      m = k + i;
      k = i;
      i = j;
      j = m;
      break label132;
      k = Math.max((i2 - ((View)localObject).getMeasuredWidth()) / 2, i);
      m = i;
      i = j;
      j = m;
      break label132;
      k = i2 - j - ((View)localObject).getMeasuredWidth();
      i4 = ((View)localObject).getMeasuredWidth();
      m = i;
      i = j + i4;
      j = m;
      break label132;
      if (this.zb != null) {
        this.zb.a(paramInt1, paramFloat, paramInt2);
      }
      if (this.za != null)
      {
        j = this.za.size();
        i = 0;
        while (i < j)
        {
          localObject = (e)this.za.get(i);
          if (localObject != null) {
            ((e)localObject).a(paramInt1, paramFloat, paramInt2);
          }
          i += 1;
        }
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
          localObject = getChildAt(paramInt1);
          if (!((LayoutParams)((View)localObject).getLayoutParams()).zo)
          {
            paramFloat = (((View)localObject).getLeft() - paramInt2) / bP();
            this.ze.h((View)localObject, paramFloat);
          }
          paramInt1 += 1;
        }
      }
      this.yY = true;
      return;
      label482:
      k = j;
      m = i;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    b localb = aa(paramInt1);
    if (localb != null) {}
    for (int j = (int)(bP() * Math.max(this.yD, Math.min(localb.zn, this.yE)));; j = 0)
    {
      if (paramBoolean1)
      {
        if (getChildCount() == 0)
        {
          setScrollingCacheEnabled(false);
          if (paramBoolean2) {
            ac(paramInt1);
          }
          return;
        }
        int i;
        if ((this.yw != null) && (!this.yw.isFinished()))
        {
          i = 1;
          label87:
          if (i == 0) {
            break label184;
          }
          if (!this.yx) {
            break label172;
          }
          i = this.yw.getCurrX();
          label108:
          this.yw.abortAnimation();
          setScrollingCacheEnabled(false);
        }
        int k;
        int m;
        for (;;)
        {
          k = getScrollY();
          j -= i;
          m = 0 - k;
          if ((j != 0) || (m != 0)) {
            break label193;
          }
          r(false);
          populate();
          X(0);
          break;
          i = 0;
          break label87;
          label172:
          i = this.yw.getStartX();
          break label108;
          label184:
          i = getScrollX();
        }
        label193:
        setScrollingCacheEnabled(true);
        X(2);
        int n = bP();
        int i1 = n / 2;
        float f3 = Math.min(1.0F, 1.0F * Math.abs(j) / n);
        float f1 = i1;
        float f2 = i1;
        f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
        paramInt2 = Math.abs(paramInt2);
        if (paramInt2 > 0) {}
        for (paramInt2 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt2)) * 4;; paramInt2 = (int)((Math.abs(j) / (f1 * 1.0F + this.yz) + 1.0F) * 100.0F))
        {
          paramInt2 = Math.min(paramInt2, 600);
          this.yx = false;
          this.yw.startScroll(i, k, j, m, paramInt2);
          z.F(this);
          break;
          f1 = n;
        }
      }
      if (paramBoolean2) {
        ac(paramInt1);
      }
      r(false);
      scrollTo(j, 0);
      ab(j);
      return;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.yr == null) || (this.yr.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.ys == paramInt1) && (this.eh.size() != 0))
    {
      setScrollingCacheEnabled(false);
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
      if (paramBoolean2) {
        ac(i);
      }
      requestLayout();
      return;
    }
    Z(i);
    a(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  private void a(b paramb1, int paramInt, b paramb2)
  {
    int k = this.yr.getCount();
    int i = bP();
    if (i > 0) {}
    float f1;
    int j;
    for (float f2 = this.yz / i;; f2 = 0.0F)
    {
      if (paramb2 == null) {
        break label365;
      }
      i = paramb2.position;
      if (i >= paramb1.position) {
        break;
      }
      f1 = paramb2.zn + paramb2.zm + f2;
      j = 0;
      i += 1;
      if ((i > paramb1.position) || (j >= this.eh.size())) {
        break label365;
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
            label365:
            int m = this.eh.size();
            float f3 = paramb1.zn;
            i = paramb1.position - 1;
            if (paramb1.position == 0)
            {
              f1 = paramb1.zn;
              this.yD = f1;
              if (paramb1.position != k - 1) {
                break label498;
              }
              f1 = paramb1.zn + paramb1.zm - 1.0F;
              label431:
              this.yE = f1;
              j = paramInt - 1;
              f1 = f3;
            }
            for (;;)
            {
              if (j < 0) {
                break label551;
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
                  label498:
                  f1 = Float.MAX_VALUE;
                  break label431;
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
            label551:
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
            return;
          }
        }
      }
    }
  }
  
  private boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
      if (i >= 0)
      {
        localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j < localView.getLeft()) || (paramInt2 + j >= localView.getRight()) || (paramInt3 + k < localView.getTop()) || (paramInt3 + k >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (z.g(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i -= 1;
      break;
    }
    return false;
  }
  
  private b aa(int paramInt)
  {
    int i = 0;
    while (i < this.eh.size())
    {
      b localb = (b)this.eh.get(i);
      if (localb.position == paramInt) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  private boolean ab(int paramInt)
  {
    if (this.eh.size() == 0)
    {
      if (this.yW) {}
      do
      {
        return false;
        this.yY = false;
        a(0, 0.0F, 0);
      } while (this.yY);
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    b localb = bU();
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
    return true;
  }
  
  private void ac(int paramInt)
  {
    if (this.zb != null) {
      this.zb.V(paramInt);
    }
    if (this.za != null)
    {
      int j = this.za.size();
      int i = 0;
      while (i < j)
      {
        e locale = (e)this.za.get(i);
        if (locale != null) {
          locale.V(paramInt);
        }
        i += 1;
      }
    }
    if (this.zc != null) {
      this.zc.V(paramInt);
    }
  }
  
  private b ap(View paramView)
  {
    int i = 0;
    while (i < this.eh.size())
    {
      b localb = (b)this.eh.get(i);
      if (this.yr.a(paramView, localb.zk)) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  private b aq(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return ap(paramView);
  }
  
  private boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int j;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label308;
      }
      if (paramInt != 17) {
        break label254;
      }
      i = a(this.eq, localView).left;
      j = a(this.eq, (View)localObject).left;
      if ((localObject != null) && (i >= j))
      {
        bool = bV();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label354;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label361;
      }
      if (localObject != this) {}
    }
    label254:
    label308:
    label348:
    label354:
    label361:
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
        break label89;
        if (paramInt == 66)
        {
          i = a(this.eq, localView).left;
          j = a(this.eq, (View)localObject).left;
          if ((localObject == null) || (i > j))
          {
            bool = localView.requestFocus();
            break label89;
            if ((paramInt == 17) || (paramInt == 1))
            {
              bool = bV();
              break label89;
            }
            if ((paramInt != 66) && (paramInt != 2)) {
              break label348;
            }
          }
          bool = bW();
          break label89;
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  private int bP()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void bR()
  {
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
      Collections.sort(this.zg, zh);
    }
  }
  
  private boolean bS()
  {
    this.fl = -1;
    this.iC = false;
    this.yK = false;
    if (this.fk != null)
    {
      this.fk.recycle();
      this.fk = null;
    }
    return this.yU.cr() | this.yV.cr();
  }
  
  private void bT()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private b bU()
  {
    int i = bP();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int k;
    int j;
    Object localObject1;
    label53:
    Object localObject2;
    b localb;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label203;
      }
      f2 = this.yz / i;
      f4 = 0.0F;
      f3 = 0.0F;
      k = -1;
      i = 0;
      j = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i < this.eh.size())
      {
        localb = (b)this.eh.get(i);
        if ((j != 0) || (localb.position == k + 1)) {
          break label238;
        }
        localb = this.yq;
        localb.zn = (f4 + f3 + f2);
        localb.position = (k + 1);
        localb.zm = 1.0F;
        i -= 1;
      }
    }
    label203:
    label208:
    label238:
    for (;;)
    {
      f3 = localb.zn;
      f4 = localb.zm;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i != this.eh.size() - 1)) {
          break label208;
        }
        localObject2 = localb;
      }
      return (b)localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      k = localb.position;
      f4 = localb.zm;
      j = 0;
      i += 1;
      localObject1 = localb;
      break label53;
    }
  }
  
  private boolean bV()
  {
    if (this.ys > 0)
    {
      k(this.ys - 1, true);
      return true;
    }
    return false;
  }
  
  private boolean bW()
  {
    if ((this.yr != null) && (this.ys < this.yr.getCount() - 1))
    {
      k(this.ys + 1, true);
      return true;
    }
    return false;
  }
  
  private void h(MotionEvent paramMotionEvent)
  {
    int i = o.e(paramMotionEvent);
    if (o.c(paramMotionEvent, i) == this.fl) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      this.yN = o.d(paramMotionEvent, i);
      this.fl = o.c(paramMotionEvent, i);
      if (this.fk != null) {
        this.fk.clear();
      }
      return;
    }
  }
  
  private b l(int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.position = paramInt1;
    localb.zk = this.yr.b(this, paramInt1);
    localb.zm = 1.0F;
    if ((paramInt2 < 0) || (paramInt2 >= this.eh.size()))
    {
      this.eh.add(localb);
      return localb;
    }
    this.eh.add(paramInt2, localb);
    return localb;
  }
  
  private boolean o(float paramFloat)
  {
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
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
    int i;
    if (this.xV == 2)
    {
      i = 1;
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        if (this.yw.isFinished()) {
          break label170;
        }
      }
    }
    label170:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.yw.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.yw.getCurrX();
        int n = this.yw.getCurrY();
        if ((j != m) || (k != n))
        {
          scrollTo(m, n);
          if (m != j) {
            ab(m);
          }
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
      i = 0;
      break;
    }
    if (j != 0)
    {
      if (paramBoolean) {
        z.a(this, this.zi);
      }
    }
    else {
      return;
    }
    this.zi.run();
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.yH != paramBoolean) {
      this.yH = paramBoolean;
    }
  }
  
  public final void Y(int paramInt)
  {
    this.yI = false;
    if (!this.yW) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  final e a(e parame)
  {
    e locale = this.zc;
    this.zc = parame;
    return locale;
  }
  
  public final void a(u paramu)
  {
    if (this.yr != null)
    {
      this.yr.a(null);
      int i = 0;
      while (i < this.eh.size())
      {
        localObject = (b)this.eh.get(i);
        this.yr.a(this, ((b)localObject).position, ((b)localObject).zk);
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
    Object localObject = this.yr;
    this.yr = paramu;
    this.yn = 0;
    boolean bool;
    if (this.yr != null)
    {
      if (this.yy == null) {
        this.yy = new g((byte)0);
      }
      this.yr.a(this.yy);
      this.yI = false;
      bool = this.yW;
      this.yW = true;
      this.yn = this.yr.getCount();
      if (this.yt < 0) {
        break label290;
      }
      this.yr.a(this.yu, this.yv);
      a(this.yt, false, true);
      this.yt = -1;
      this.yu = null;
      this.yv = null;
    }
    for (;;)
    {
      if ((this.zd != null) && (localObject != paramu)) {
        this.zd.b((u)localObject, paramu);
      }
      return;
      label290:
      if (!bool) {
        populate();
      } else {
        requestLayout();
      }
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
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
          b localb = ap(localView);
          if ((localb != null) && (localb.position == this.ys)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if (((k == 262144) && (j != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = ap(localView);
        if ((localb != null) && (localb.position == this.ys)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramLayoutParams;
      localLayoutParams.zo |= paramView instanceof a;
      if (this.pd)
      {
        if ((localLayoutParams != null) && (localLayoutParams.zo)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.zp = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void bQ()
  {
    int i2 = this.yr.getCount();
    this.yn = i2;
    int i;
    int j;
    int k;
    int n;
    int m;
    label67:
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
        break label270;
      }
      localObject = (b)this.eh.get(k);
      n = this.yr.j(((b)localObject).zk);
      if (n == -1) {
        break label354;
      }
      if (n != -2) {
        break label218;
      }
      this.eh.remove(k);
      m = k - 1;
      k = j;
      if (j == 0) {
        k = 1;
      }
      this.yr.a(this, ((b)localObject).position, ((b)localObject).zk);
      if (this.ys != ((b)localObject).position) {
        break label375;
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
      break label67;
      i = 0;
      break;
      label218:
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
        label270:
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
      }
      else
      {
        label354:
        n = i;
        i1 = m;
        m = k;
        i = j;
        j = n;
        k = i1;
        continue;
        label375:
        j = i;
        n = 1;
        i = k;
        k = n;
      }
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.yr == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
        i = bP();
        j = getScrollX();
        if (paramInt >= 0) {
          break;
        }
      } while (j <= (int)(i * this.yD));
      return true;
    } while ((paramInt <= 0) || (j >= (int)(i * this.yE)));
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    this.yx = true;
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
      return;
    }
    r(true);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!super.dispatchKeyEvent(paramKeyEvent))
    {
      if (paramKeyEvent.getAction() == 0) {}
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      if (bool1) {
        bool2 = true;
      }
      return bool2;
      bool1 = arrowScroll(17);
      continue;
      bool1 = arrowScroll(66);
      continue;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      if (g.a(paramKeyEvent))
      {
        bool1 = arrowScroll(2);
      }
      else
      {
        if (!g.a(paramKeyEvent, 1)) {
          break;
        }
        bool1 = arrowScroll(1);
      }
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = ap(localView);
        if ((localb != null) && (localb.position == this.ys) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
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
      return;
      this.yU.finish();
      this.yV.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.yA;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.zf == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((LayoutParams)((View)this.zg.get(i)).getLayoutParams()).zq;
  }
  
  public final void k(int paramInt, boolean paramBoolean)
  {
    this.yI = false;
    a(paramInt, paramBoolean, false);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.yW = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.zi);
    if ((this.yw != null) && (!this.yw.isFinished())) {
      this.yw.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
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
            this.yA.setBounds(Math.round(f2), this.yB, Math.round(this.yz + f2), this.yC);
            this.yA.draw(paramCanvas);
          }
          if (f2 > k + m) {
            return;
          }
          i += 1;
          break;
          f2 = (1.0F + f1) * m;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1)) {
      bS();
    }
    do
    {
      return false;
      if (i == 0) {
        break;
      }
      if (this.iC) {
        return true;
      }
    } while (this.yK);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.fk == null) {
        this.fk = VelocityTracker.obtain();
      }
      this.fk.addMovement(paramMotionEvent);
      return this.iC;
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
            return false;
          }
        }
        if ((f4 > this.iE) && (0.5F * f4 > f5))
        {
          this.iC = true;
          bT();
          X(1);
          if (f1 > 0.0F)
          {
            f1 = this.xC + this.iE;
            label328:
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
          break label328;
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
        this.yx = true;
        this.yw.computeScrollOffset();
        if ((this.xV == 2) && (Math.abs(this.yw.getFinalX() - this.yw.getCurrX()) > this.yS))
        {
          this.yw.abortAnimation();
          this.yI = false;
          populate();
          this.iC = true;
          bT();
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
    label154:
    int n;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label671;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.zo) {
        break label671;
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
          label204:
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
      break label154;
      paramInt4 = Math.max((i3 - localView.getMeasuredWidth()) / 2, paramInt2);
      k = paramInt2;
      break label154;
      k = localView.getMeasuredWidth();
      paramInt4 = i + localView.getMeasuredWidth();
      n = i3 - i - k;
      i = paramInt4;
      k = paramInt2;
      paramInt4 = n;
      break label154;
      n = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      n += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = n;
      break label204;
      n = Math.max((i2 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = n;
      break label204;
      n = i2 - paramInt3 - localView.getMeasuredHeight();
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i5;
      paramInt3 = n;
      break label204;
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
            b localb = ap(localView);
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
      return;
      label671:
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
    label183:
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
              break label333;
            }
            m = 1;
            if ((i != 3) && (i != 5)) {
              break label339;
            }
            n = 1;
            label198:
            if (m == 0) {
              break label345;
            }
            i = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label528;
            }
            i1 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label522;
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
          label333:
          m = 0;
          break label183;
          label339:
          n = 0;
          break label198;
          label345:
          i = i1;
          if (n == 0) {
            break label208;
          }
          j = 1073741824;
          i = i1;
          break label208;
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
            if ((localLayoutParams == null) || (!localLayoutParams.zo))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.zm * f), 1073741824), this.yG);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label522:
      i = paramInt1;
      continue;
      label528:
      i1 = i;
      i = paramInt1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int j = -1;
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
        b localb = ap(localView);
        if ((localb != null) && (localb.position == this.ys) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i = k - 1;
          k = -1;
          continue;
        }
      }
      i += j;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.yr != null)
    {
      this.yr.a(paramParcelable.zr, paramParcelable.zt);
      a(paramParcelable.position, false, true);
      return;
    }
    this.yt = paramParcelable.position;
    this.yu = paramParcelable.zr;
    this.yv = paramParcelable.zt;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.ys;
    if (this.yr != null) {
      localSavedState.zr = this.yr.bb();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = this.yz;
      paramInt4 = this.yz;
      if ((paramInt3 <= 0) || (this.eh.isEmpty())) {
        break label132;
      }
      if (!this.yw.isFinished()) {
        this.yw.setFinalX(this.ys * bP());
      }
    }
    else
    {
      return;
    }
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    float f = getScrollX() / (paramInt4 + (paramInt3 - k - m));
    scrollTo((int)((paramInt2 + (paramInt1 - i - j)) * f), getScrollY());
    return;
    label132:
    b localb = aa(this.ys);
    if (localb != null) {}
    for (f = Math.min(localb.zn, this.yE);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      r(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.yT) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.yr == null) || (this.yr.getCount() == 0)) {
      return false;
    }
    if (this.fk == null) {
      this.fk = VelocityTracker.obtain();
    }
    this.fk.addMovement(paramMotionEvent);
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        z.F(this);
      }
      return true;
      this.yw.abortAnimation();
      this.yI = false;
      populate();
      float f1 = paramMotionEvent.getX();
      this.xC = f1;
      this.yN = f1;
      f1 = paramMotionEvent.getY();
      this.xD = f1;
      this.yO = f1;
      this.fl = o.c(paramMotionEvent, 0);
      bool1 = bool2;
      continue;
      int i;
      float f2;
      if (!this.iC)
      {
        i = o.b(paramMotionEvent, this.fl);
        if (i == -1)
        {
          bool1 = bS();
          continue;
        }
        f1 = o.d(paramMotionEvent, i);
        float f3 = Math.abs(f1 - this.yN);
        f2 = o.e(paramMotionEvent, i);
        float f4 = Math.abs(f2 - this.yO);
        if ((f3 > this.iE) && (f3 > f4))
        {
          this.iC = true;
          bT();
          if (f1 - this.xC <= 0.0F) {
            break label392;
          }
        }
      }
      Object localObject;
      label392:
      for (f1 = this.xC + this.iE;; f1 = this.xC - this.iE)
      {
        this.yN = f1;
        this.yO = f2;
        X(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        bool1 = bool2;
        if (!this.iC) {
          break;
        }
        bool1 = o(o.d(paramMotionEvent, o.b(paramMotionEvent, this.fl))) | false;
        break;
      }
      bool1 = bool2;
      if (this.iC)
      {
        localObject = this.fk;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.yQ);
        int k = (int)y.a((VelocityTracker)localObject, this.fl);
        this.yI = true;
        int j = bP();
        int m = getScrollX();
        localObject = bU();
        f1 = this.yz / j;
        i = ((b)localObject).position;
        f2 = (m / j - ((b)localObject).zn) / (((b)localObject).zm + f1);
        if ((Math.abs((int)(o.d(paramMotionEvent, o.b(paramMotionEvent, this.fl)) - this.xC)) > this.yR) && (Math.abs(k) > this.yP))
        {
          if (k > 0) {}
          for (;;)
          {
            j = i;
            if (this.eh.size() > 0)
            {
              paramMotionEvent = (b)this.eh.get(0);
              localObject = (b)this.eh.get(this.eh.size() - 1);
              j = Math.max(paramMotionEvent.position, Math.min(i, ((b)localObject).position));
            }
            a(j, true, true, k);
            bool1 = bS();
            break;
            i += 1;
          }
        }
        if (i >= this.ys) {}
        for (f1 = 0.4F;; f1 = 0.6F)
        {
          i = (int)(i + f2 + f1);
          break;
        }
        bool1 = bool2;
        if (this.iC)
        {
          a(this.ys, true, 0, false);
          bool1 = bS();
          continue;
          i = o.e(paramMotionEvent);
          this.yN = o.d(paramMotionEvent, i);
          this.fl = o.c(paramMotionEvent, i);
          bool1 = bool2;
          continue;
          h(paramMotionEvent);
          this.yN = o.d(paramMotionEvent, o.b(paramMotionEvent, this.fl));
          bool1 = bool2;
        }
      }
    }
  }
  
  public final void populate()
  {
    Z(this.ys);
  }
  
  public void removeView(View paramView)
  {
    if (this.pd)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.yA);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public int gravity;
    int position;
    float zm = 0.0F;
    public boolean zo;
    boolean zp;
    int zq;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.bX());
      this.gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = android.support.v4.os.b.a(new c() {});
    int position;
    Parcelable zr;
    ClassLoader zt;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.zr = paramParcel.readParcelable(localClassLoader);
      this.zt = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.zr, paramInt);
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
  }
  
  final class c
    extends a
  {
    c() {}
    
    private boolean bY()
    {
      return (ViewPager.b(ViewPager.this) != null) && (ViewPager.b(ViewPager.this).getCount() > 1);
    }
    
    public final void a(View paramView, android.support.v4.view.a.b paramb)
    {
      super.a(paramView, paramb);
      paramb.setClassName(ViewPager.class.getName());
      paramb.setScrollable(bY());
      if (ViewPager.this.canScrollHorizontally(1)) {
        paramb.addAction(4096);
      }
      if (ViewPager.this.canScrollHorizontally(-1)) {
        paramb.addAction(8192);
      }
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ViewPager.class.getName());
      paramView = android.support.v4.view.a.a.a(paramAccessibilityEvent);
      paramView.setScrollable(bY());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (ViewPager.b(ViewPager.this) != null))
      {
        paramView.setItemCount(ViewPager.b(ViewPager.this).getCount());
        paramView.setFromIndex(ViewPager.c(ViewPager.this));
        paramView.setToIndex(ViewPager.c(ViewPager.this));
      }
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 4096: 
        if (ViewPager.this.canScrollHorizontally(1))
        {
          ViewPager.this.Y(ViewPager.c(ViewPager.this) + 1);
          return true;
        }
        return false;
      }
      if (ViewPager.this.canScrollHorizontally(-1))
      {
        ViewPager.this.Y(ViewPager.c(ViewPager.this) - 1);
        return true;
      }
      return false;
    }
  }
  
  static abstract interface d
  {
    public abstract void b(u paramu1, u paramu2);
  }
  
  public static abstract interface e
  {
    public abstract void V(int paramInt);
    
    public abstract void W(int paramInt);
    
    public abstract void a(int paramInt1, float paramFloat, int paramInt2);
  }
  
  public static abstract interface f
  {
    public abstract void h(View paramView, float paramFloat);
  }
  
  private final class g
    extends DataSetObserver
  {
    private g() {}
    
    public final void onChanged()
    {
      ViewPager.this.bQ();
    }
    
    public final void onInvalidated()
    {
      ViewPager.this.bQ();
    }
  }
  
  public static class h
    implements ViewPager.e
  {
    public void V(int paramInt) {}
    
    public void W(int paramInt) {}
    
    public void a(int paramInt1, float paramFloat, int paramInt2) {}
  }
  
  static final class i
    implements Comparator<View>
  {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */