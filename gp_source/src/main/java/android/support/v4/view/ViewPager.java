package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.content.d;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
  extends ViewGroup
{
  public static final int[] a = { 16842931 };
  private static final Interpolator ad = new aj();
  private static final aw ae = new aw();
  private static final Comparator i = new ai();
  private boolean A;
  private boolean B;
  private boolean C;
  private final ArrayList D = new ArrayList();
  private float E;
  private float F;
  private float G = Float.MAX_VALUE;
  private EdgeEffect H;
  private Drawable I;
  private int J;
  private int K;
  private at L;
  private int M = 1;
  private ar N;
  private List O;
  private int P;
  private boolean Q;
  private int R = -1;
  private EdgeEffect S;
  private int T = 0;
  private boolean U;
  private final an V = new an();
  private final Rect W = new Rect();
  private int aa;
  private int ab;
  private VelocityTracker ac;
  public z b;
  public List c;
  public int d;
  public int e;
  public as f;
  public int g;
  public Scroller h;
  private int j = -1;
  private int k;
  private boolean l;
  private int m;
  private int n;
  private int o;
  private int p;
  private ArrayList q;
  private final Runnable r = new ak(this);
  private int s;
  private boolean t = true;
  private float u = -3.4028235E38F;
  private int v;
  private int w;
  private boolean x;
  private float y;
  private float z;
  
  public ViewPager(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  private final Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView != null)
      {
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
      paramRect.set(0, 0, 0, 0);
      return paramRect;
    }
  }
  
  private final an a(int paramInt1, int paramInt2)
  {
    an localan = new an();
    localan.c = paramInt1;
    localan.a = this.b.a(this, paramInt1);
    localan.e = 1.0F;
    if ((paramInt2 < 0) || (paramInt2 >= this.D.size()))
    {
      this.D.add(localan);
      return localan;
    }
    this.D.add(paramInt2, localan);
    return localan;
  }
  
  private final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i2;
    int i1;
    int i3;
    if (this.o > 0)
    {
      int i6 = getScrollX();
      i2 = getPaddingLeft();
      i1 = getPaddingRight();
      int i7 = getWidth();
      int i8 = getChildCount();
      int i4 = 0;
      if (i4 < i8)
      {
        localObject = getChildAt(i4);
        ao localao = (ao)((View)localObject).getLayoutParams();
        label120:
        int i5;
        if (localao.c) {
          switch (localao.b & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            i3 = i2;
            int i9 = i3 + i6 - ((View)localObject).getLeft();
            i3 = i1;
            i5 = i2;
            if (i9 != 0)
            {
              ((View)localObject).offsetLeftAndRight(i9);
              i5 = i2;
              i3 = i1;
            }
            break;
          }
        }
        for (;;)
        {
          i4 += 1;
          i1 = i3;
          i2 = i5;
          break;
          i5 = ((View)localObject).getWidth();
          i3 = i2;
          i2 = i5 + i2;
          break label120;
          i5 = ((View)localObject).getMeasuredWidth();
          i3 = ((View)localObject).getMeasuredWidth() + i1;
          i5 = i7 - i1 - i5;
          i1 = i3;
          i3 = i5;
          break label120;
          i3 = Math.max((i7 - ((View)localObject).getMeasuredWidth()) / 2, i2);
          break label120;
          i3 = i1;
          i5 = i2;
        }
      }
    }
    Object localObject = this.N;
    if (localObject != null) {
      ((ar)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.O;
    if (localObject != null)
    {
      i2 = ((List)localObject).size();
      i1 = 0;
      if (i1 < i2)
      {
        localObject = (ar)this.O.get(i1);
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          ((ar)localObject).a(paramInt1, paramFloat, paramInt2);
        }
      }
    }
    if (this.f != null)
    {
      paramInt2 = getScrollX();
      i1 = getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i1)
      {
        localObject = getChildAt(paramInt1);
        if (!((ao)((View)localObject).getLayoutParams()).c)
        {
          i2 = ((View)localObject).getLeft();
          i3 = f();
          this.f.a((View)localObject, (i2 - paramInt2) / i3);
        }
        paramInt1 += 1;
      }
    }
    this.l = true;
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 <= 0) {}
    while (this.D.isEmpty())
    {
      an localan = c(this.d);
      if (localan != null) {}
      for (f1 = Math.min(localan.b, this.G);; f1 = 0.0F)
      {
        paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
        if (paramInt1 != getScrollX())
        {
          a(false);
          scrollTo(paramInt1, getScrollY());
        }
        return;
      }
    }
    if (!this.h.isFinished())
    {
      this.h.setFinalX(getCurrentItem() * f());
      return;
    }
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    int i3 = getPaddingLeft();
    int i4 = getPaddingRight();
    float f1 = getScrollX() / (paramInt2 - i3 - i4 + paramInt4);
    scrollTo((int)((paramInt1 - i1 - i2 + paramInt3) * f1), getScrollY());
  }
  
  private final void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = c(paramInt1);
    float f1;
    if (localObject != null) {
      f1 = f();
    }
    for (int i2 = (int)(Math.max(this.u, Math.min(((an)localObject).b, this.G)) * f1);; i2 = 0)
    {
      if (paramBoolean1)
      {
        if (getChildCount() == 0)
        {
          b(false);
          if (paramBoolean2) {
            e(paramInt1);
          }
          return;
        }
        localObject = this.h;
        int i1;
        if ((localObject != null) && (!((Scroller)localObject).isFinished())) {
          if (!this.B)
          {
            i1 = this.h.getStartX();
            label106:
            this.h.abortAnimation();
            b(false);
          }
        }
        for (;;)
        {
          int i3 = getScrollY();
          i2 -= i1;
          int i4 = -i3;
          if (i2 != 0) {}
          while (i4 != 0)
          {
            b(true);
            a(2);
            int i5 = f();
            f1 = i5;
            float f2 = i5 / 2;
            float f3 = (float)Math.sin((Math.min(1.0F, Math.abs(i2) / f1) - 0.5F) * 0.47123894F);
            paramInt2 = Math.abs(paramInt2);
            if (paramInt2 > 0) {}
            for (paramInt2 = Math.round(Math.abs((f2 + f3 * f2) / paramInt2) * 1000.0F) * 4;; paramInt2 = (int)((Math.abs(i2) / (f1 + this.P) + 1.0F) * 100.0F))
            {
              paramInt2 = Math.min(paramInt2, 600);
              this.B = false;
              this.h.startScroll(i1, i3, i2, i4, paramInt2);
              ac.e(this);
              break;
            }
          }
          a(false);
          b();
          a(0);
          break;
          i1 = this.h.getCurrX();
          break label106;
          i1 = getScrollX();
        }
      }
      if (!paramBoolean2) {}
      for (;;)
      {
        a(false);
        scrollTo(i2, 0);
        d(i2);
        return;
        e(paramInt1);
      }
    }
  }
  
  private final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  private final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    z localz = this.b;
    if ((localz == null) || (localz.a() <= 0))
    {
      b(false);
      return;
    }
    if ((!paramBoolean2) && (this.d == paramInt1) && (this.D.size() != 0))
    {
      b(false);
      return;
    }
    if (paramInt1 >= 0)
    {
      i1 = paramInt1;
      if (paramInt1 < this.b.a()) {}
    }
    for (int i1 = this.b.a() - 1;; i1 = 0)
    {
      paramInt1 = this.M;
      int i2 = this.d;
      if (i1 <= i2 + paramInt1) {
        if (i1 < i2 - paramInt1) {}
      }
      for (;;)
      {
        paramBoolean2 = bool;
        if (this.d != i1) {
          paramBoolean2 = true;
        }
        if (this.t)
        {
          this.d = i1;
          if (paramBoolean2) {
            e(i1);
          }
          requestLayout();
          return;
        }
        b(i1);
        a(i1, paramBoolean1, paramInt2, paramBoolean2);
        return;
        paramInt1 = 0;
        while (paramInt1 < this.D.size())
        {
          ((an)this.D.get(paramInt1)).d = true;
          paramInt1 += 1;
          continue;
          paramInt1 = 0;
        }
      }
    }
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.j) {
      if (i1 != 0) {
        break label55;
      }
    }
    label55:
    for (i1 = 1;; i1 = 0)
    {
      this.E = paramMotionEvent.getX(i1);
      this.j = paramMotionEvent.getPointerId(i1);
      paramMotionEvent = this.ac;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
      return;
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (this.T == 2) {}
    for (int i1 = 1;; i1 = 0)
    {
      int i2;
      int i3;
      int i4;
      int i5;
      if (i1 != 0)
      {
        b(false);
        if ((this.h.isFinished() ^ true))
        {
          this.h.abortAnimation();
          i2 = getScrollX();
          i3 = getScrollY();
          i4 = this.h.getCurrX();
          i5 = this.h.getCurrY();
          if (i2 == i4) {
            break label181;
          }
        }
      }
      for (;;)
      {
        scrollTo(i4, i5);
        if (i2 != i4) {
          d(i4);
        }
        label181:
        do
        {
          this.Q = false;
          i3 = 0;
          i2 = i1;
          i1 = i3;
          while (i1 < this.D.size())
          {
            an localan = (an)this.D.get(i1);
            if (localan.d)
            {
              localan.d = false;
              i2 = 1;
            }
            i1 += 1;
          }
          if (i2 != 0)
          {
            if (!paramBoolean) {
              this.r.run();
            }
          }
          else {
            return;
          }
          ac.a(this, this.r);
          return;
        } while (i3 == i5);
      }
    }
  }
  
  private final boolean a(float paramFloat)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = this.E;
    this.E = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    float f3 = f();
    paramFloat = f3 * this.u;
    f1 = this.G;
    an localan = (an)this.D.get(0);
    Object localObject = this.D;
    localObject = (an)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    if (localan.c != 0) {
      paramFloat = localan.b * f3;
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (((an)localObject).c != this.b.a() - 1) {
        f1 = ((an)localObject).b * f3;
      }
      for (int i2 = 0;; i2 = 1)
      {
        if (f2 >= paramFloat) {
          if (f2 <= f1) {
            f1 = f2;
          }
        }
        for (;;)
        {
          i1 = (int)f1;
          this.E += f1 - i1;
          scrollTo(i1, getScrollY());
          d(i1);
          return bool1;
          bool1 = bool2;
          if (i2 != 0)
          {
            this.S.onPull(Math.abs(f2 - f1) / f3);
            bool1 = true;
          }
          continue;
          f1 = paramFloat;
          if (i1 != 0)
          {
            this.H.onPull(Math.abs(paramFloat - f2) / f3);
            bool1 = true;
            f1 = paramFloat;
          }
        }
        f1 = f3 * f1;
      }
    }
  }
  
  private final boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      int i1 = localViewGroup.getChildCount() - 1;
      if (i1 >= 0)
      {
        localView = localViewGroup.getChildAt(i1);
        i4 = paramInt2 + i2;
        if (i4 < localView.getLeft()) {}
        do
        {
          do
          {
            i1 -= 1;
            break;
          } while (i4 >= localView.getRight());
          i5 = paramInt3 + i3;
        } while ((i5 < localView.getTop()) || (i5 >= localView.getBottom()) || (!a(localView, true, paramInt1, i4 - localView.getLeft(), i5 - localView.getTop())));
      }
    }
    while ((paramBoolean) && (paramView.canScrollHorizontally(-paramInt1)))
    {
      View localView;
      int i4;
      int i5;
      return true;
    }
    return false;
  }
  
  private final void b(int paramInt)
  {
    int i1 = this.d;
    an localan;
    if (i1 != paramInt)
    {
      localan = c(i1);
      this.d = paramInt;
    }
    for (;;)
    {
      if (this.b == null) {
        g();
      }
      do
      {
        return;
        if (this.Q)
        {
          g();
          return;
        }
      } while (getWindowToken() == null);
      paramInt = this.M;
      int i3 = Math.max(0, this.d - paramInt);
      int i5 = this.b.a();
      int i6 = Math.min(i5 - 1, paramInt + this.d);
      if (i5 != this.s) {}
      try
      {
        Object localObject1 = getResources().getResourceName(getId());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
        ((StringBuilder)localObject2).append(this.s);
        ((StringBuilder)localObject2).append(", found: ");
        ((StringBuilder)localObject2).append(i5);
        ((StringBuilder)localObject2).append(" Pager id: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" Pager class: ");
        ((StringBuilder)localObject2).append(getClass());
        ((StringBuilder)localObject2).append(" Problematic adapter: ");
        ((StringBuilder)localObject2).append(this.b.getClass());
        throw new IllegalStateException(((StringBuilder)localObject2).toString());
        paramInt = 0;
        int i2;
        for (;;)
        {
          if (paramInt < this.D.size())
          {
            localObject1 = (an)this.D.get(paramInt);
            i1 = ((an)localObject1).c;
            i2 = this.d;
            if (i1 < i2) {
              paramInt += 1;
            } else {
              if (i1 == i2) {
                break;
              }
            }
          }
        }
        for (localObject1 = null;; localObject1 = null)
        {
          if (localObject1 != null) {
            localObject2 = localObject1;
          }
          for (;;)
          {
            if (localObject2 == null)
            {
              this.b.b();
              i1 = getChildCount();
              paramInt = 0;
              if (paramInt < i1)
              {
                localObject2 = getChildAt(paramInt);
                localObject1 = (ao)((View)localObject2).getLayoutParams();
                ((ao)localObject1).a = paramInt;
                if (((ao)localObject1).c) {}
                for (;;)
                {
                  paramInt += 1;
                  break;
                  if (((ao)localObject1).f == 0.0F)
                  {
                    localObject2 = a((View)localObject2);
                    if (localObject2 != null)
                    {
                      ((ao)localObject1).f = ((an)localObject2).e;
                      ((ao)localObject1).e = ((an)localObject2).c;
                    }
                  }
                }
              }
              g();
              if (!hasFocus()) {
                break;
              }
              localObject1 = findFocus();
              if (localObject1 != null)
              {
                label439:
                localObject2 = ((View)localObject1).getParent();
                if (localObject2 == this) {
                  localObject1 = a((View)localObject1);
                }
              }
              for (;;)
              {
                if (localObject1 != null)
                {
                  if (((an)localObject1).c == this.d) {
                    break;
                  }
                  paramInt = 0;
                }
                while (paramInt < getChildCount())
                {
                  localObject1 = getChildAt(paramInt);
                  localObject2 = a((View)localObject1);
                  if (localObject2 == null) {}
                  while ((((an)localObject2).c != this.d) || (!((View)localObject1).requestFocus(2)))
                  {
                    paramInt += 1;
                    break;
                  }
                  return;
                  paramInt = 0;
                }
                if (localObject2 != null)
                {
                  if ((localObject2 instanceof View))
                  {
                    localObject1 = (View)localObject2;
                    break label439;
                  }
                  localObject1 = null;
                  continue;
                }
                localObject1 = null;
                continue;
                localObject1 = null;
              }
            }
            i1 = paramInt - 1;
            if (i1 >= 0) {}
            for (localObject1 = (an)this.D.get(i1);; localObject1 = null)
            {
              int i4 = f();
              if (i4 > 0) {}
              for (float f2 = 2.0F - ((an)localObject2).e + getPaddingLeft() / i4;; f2 = 0.0F)
              {
                i2 = this.d - 1;
                float f1 = 0.0F;
                label650:
                label729:
                float f3;
                if (i2 < 0)
                {
                  f1 = ((an)localObject2).e;
                  i2 = paramInt + 1;
                  if (f1 < 2.0F) {
                    if (i2 >= this.D.size()) {
                      break label1666;
                    }
                  }
                  label1131:
                  label1264:
                  label1301:
                  label1330:
                  label1390:
                  label1432:
                  label1437:
                  label1482:
                  label1666:
                  for (localObject1 = (an)this.D.get(i2);; localObject1 = null)
                  {
                    if (i4 > 0) {}
                    for (f2 = getPaddingRight() / i4 + 2.0F;; f2 = 0.0F)
                    {
                      i3 = this.d + 1;
                      i1 = i2;
                      if (i3 >= i5)
                      {
                        i4 = this.b.a();
                        i1 = f();
                        if (i1 > 0) {}
                        for (f2 = this.P / i1;; f2 = 0.0F)
                        {
                          if (localan == null) {}
                          do
                          {
                            i3 = this.D.size();
                            f1 = ((an)localObject2).b;
                            i5 = ((an)localObject2).c;
                            if (i5 == 0) {}
                            for (f3 = f1;; f3 = -3.4028235E38F)
                            {
                              this.u = f3;
                              i4 -= 1;
                              if (i5 == i4) {}
                              for (f3 = ((an)localObject2).e + f1 - 1.0F;; f3 = Float.MAX_VALUE)
                              {
                                this.G = f3;
                                i1 = paramInt - 1;
                                paramInt = i5 - 1;
                                if (i1 < 0)
                                {
                                  f1 = ((an)localObject2).b + ((an)localObject2).e + f2;
                                  paramInt = ((an)localObject2).c + 1;
                                  i1 = i2;
                                  if (i1 < i3)
                                  {
                                    localObject1 = (an)this.D.get(i1);
                                    for (;;)
                                    {
                                      i2 = ((an)localObject1).c;
                                      if (paramInt >= i2) {
                                        break;
                                      }
                                      paramInt += 1;
                                      f1 += 1.0F + f2;
                                    }
                                    if (i2 != i4) {}
                                    for (;;)
                                    {
                                      ((an)localObject1).b = f1;
                                      f1 += ((an)localObject1).e + f2;
                                      paramInt += 1;
                                      i1 += 1;
                                      break;
                                      this.G = (((an)localObject1).e + f1 - 1.0F);
                                    }
                                  }
                                  this.b.a(((an)localObject2).a);
                                  break;
                                }
                                localObject1 = (an)this.D.get(i1);
                                for (;;)
                                {
                                  i5 = ((an)localObject1).c;
                                  if (paramInt <= i5) {
                                    break;
                                  }
                                  paramInt -= 1;
                                  f1 -= 1.0F + f2;
                                }
                                f1 -= ((an)localObject1).e + f2;
                                ((an)localObject1).b = f1;
                                if (i5 != 0) {}
                                for (;;)
                                {
                                  paramInt -= 1;
                                  i1 -= 1;
                                  break;
                                  this.u = f1;
                                }
                              }
                            }
                            i1 = localan.c;
                            i3 = ((an)localObject2).c;
                            if (i1 < i3)
                            {
                              f1 = localan.b;
                              f3 = localan.e;
                              i3 = 0;
                              f1 = f1 + f3 + f2;
                              i1 += 1;
                              if ((i1 <= ((an)localObject2).c) && (i3 < this.D.size())) {
                                for (localObject1 = (an)this.D.get(i3);; localObject1 = (an)this.D.get(i3))
                                {
                                  if (i1 <= ((an)localObject1).c) {
                                    break label1264;
                                  }
                                  if (i3 >= this.D.size() - 1) {
                                    break;
                                  }
                                  i3 += 1;
                                }
                              }
                              for (;;)
                              {
                                if (i1 >= ((an)localObject1).c)
                                {
                                  ((an)localObject1).b = f1;
                                  f1 += ((an)localObject1).e + f2;
                                  i1 += 1;
                                  break label1131;
                                  break;
                                }
                                i1 += 1;
                                f1 = 1.0F + f2 + f1;
                              }
                            }
                          } while (i1 <= i3);
                          i3 = this.D.size();
                          f1 = localan.b;
                          i3 -= 1;
                          i1 -= 1;
                          if ((i1 >= ((an)localObject2).c) && (i3 >= 0))
                          {
                            localObject1 = (an)this.D.get(i3);
                            if (i1 < ((an)localObject1).c) {
                              break label1390;
                            }
                          }
                          for (;;)
                          {
                            if (i1 <= ((an)localObject1).c)
                            {
                              f1 -= ((an)localObject1).e + f2;
                              ((an)localObject1).b = f1;
                              i1 -= 1;
                              break label1301;
                              break;
                            }
                            i1 -= 1;
                            f1 -= 1.0F + f2;
                            continue;
                            if (i3 > 0)
                            {
                              i3 -= 1;
                              localObject1 = (an)this.D.get(i3);
                              break label1330;
                            }
                          }
                        }
                      }
                      if (f1 < f2) {
                        if (localObject1 == null)
                        {
                          i4 = i1 + 1;
                          f3 = a(i3, i1).e;
                          if (i4 < this.D.size())
                          {
                            localObject1 = (an)this.D.get(i4);
                            i1 = i4;
                            f1 += f3;
                          }
                        }
                      }
                      for (;;)
                      {
                        i3 += 1;
                        break;
                        localObject1 = null;
                        break label1482;
                        if (i3 != ((an)localObject1).c) {
                          break label1437;
                        }
                        f1 += ((an)localObject1).e;
                        i1 += 1;
                        if (i1 < this.D.size())
                        {
                          localObject1 = (an)this.D.get(i1);
                        }
                        else
                        {
                          localObject1 = null;
                          continue;
                          if (i3 <= i6) {
                            break label1432;
                          }
                          if (localObject1 == null) {
                            break label729;
                          }
                          if (i3 == ((an)localObject1).c) {
                            if (!((an)localObject1).d)
                            {
                              this.D.remove(i1);
                              this.b.a(this, i3, ((an)localObject1).a);
                              if (i1 < this.D.size()) {}
                              for (localObject1 = (an)this.D.get(i1);; localObject1 = null) {
                                break;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                if (f1 < f2) {
                  label1678:
                  if (localObject1 == null)
                  {
                    label1683:
                    f3 = a(i2, i1 + 1).e;
                    paramInt += 1;
                    if (i1 >= 0)
                    {
                      localObject1 = (an)this.D.get(i1);
                      label1721:
                      f1 += f3;
                    }
                  }
                }
                for (;;)
                {
                  i2 -= 1;
                  break;
                  localObject1 = null;
                  break label1721;
                  if (i2 != ((an)localObject1).c) {
                    break label1683;
                  }
                  f3 = ((an)localObject1).e;
                  i1 -= 1;
                  if (i1 >= 0) {}
                  for (localObject1 = (an)this.D.get(i1);; localObject1 = null)
                  {
                    f1 += f3;
                    break;
                  }
                  if (i2 >= i3) {
                    break label1678;
                  }
                  if (localObject1 == null) {
                    break label650;
                  }
                  if (i2 == ((an)localObject1).c) {
                    if (!((an)localObject1).d)
                    {
                      this.D.remove(i1);
                      this.b.a(this, i2, ((an)localObject1).a);
                      i1 -= 1;
                      paramInt -= 1;
                      if (i1 >= 0) {}
                      for (localObject1 = (an)this.D.get(i1);; localObject1 = null) {
                        break;
                      }
                    }
                  }
                }
              }
            }
            if (i5 > 0) {
              localObject2 = a(this.d, paramInt);
            } else {
              localObject2 = localObject1;
            }
          }
        }
        localan = null;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          String str = Integer.toHexString(getId());
        }
      }
    }
  }
  
  private final void b(boolean paramBoolean)
  {
    if (this.U != paramBoolean) {
      this.U = paramBoolean;
    }
  }
  
  private final an c(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.D.size())
    {
      an localan2 = (an)this.D.get(i1);
      localan1 = localan2;
      if (localan2.c == paramInt) {
        return localan1;
      }
      i1 += 1;
    }
    an localan1 = null;
    return localan1;
  }
  
  private final boolean d(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.D.size() == 0)
    {
      bool1 = bool2;
      if (!this.t)
      {
        this.l = false;
        a(0, 0.0F, 0);
        bool1 = bool2;
        if (!this.l) {
          throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
      }
    }
    else
    {
      an localan = j();
      int i1 = f();
      int i2 = this.P;
      float f1 = i1;
      int i3 = localan.c;
      f1 = (paramInt / f1 - localan.b) / (localan.e + i2 / f1);
      this.l = false;
      a(i3, f1, (int)((i1 + i2) * f1));
      if (!this.l) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool1 = true;
    }
    return bool1;
  }
  
  private final void e()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.h = new Scroller(localContext, ad);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.ab = localViewConfiguration.getScaledPagingTouchSlop();
    this.K = ((int)(400.0F * f1));
    this.J = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.H = new EdgeEffect(localContext);
    this.S = new EdgeEffect(localContext);
    this.v = ((int)(25.0F * f1));
    this.n = ((int)(f1 + f1));
    this.p = ((int)(16.0F * f1));
    ac.a(this, new ap(this));
    if (ac.f(this) == 0) {
      ac.b(this, 1);
    }
    ac.a(this, new al(this));
  }
  
  private final void e(int paramInt)
  {
    Object localObject = this.N;
    if (localObject != null) {
      ((ar)localObject).r_(paramInt);
    }
    localObject = this.O;
    if (localObject != null)
    {
      int i2 = ((List)localObject).size();
      int i1 = 0;
      if (i1 < i2)
      {
        localObject = (ar)this.O.get(i1);
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          ((ar)localObject).r_(paramInt);
        }
      }
    }
  }
  
  private final int f()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private final boolean f(int paramInt)
  {
    Object localObject1 = findFocus();
    if (localObject1 == this) {
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = FocusFinder.getInstance().findNextFocus(this, (View)localObject1, paramInt);
      label38:
      boolean bool;
      if (localObject2 == null) {
        if (paramInt == 17) {
          bool = aE_();
        }
      }
      for (;;)
      {
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
        if (paramInt == 1) {
          break label38;
        }
        if (paramInt == 66) {}
        while (paramInt == 2)
        {
          bool = d();
          break;
        }
        bool = false;
        continue;
        if (localObject2 == localObject1) {
          break;
        }
        int i1;
        int i2;
        if (paramInt == 17)
        {
          i1 = a(this.W, (View)localObject2).left;
          i2 = a(this.W, (View)localObject1).left;
          if (localObject1 == null) {}
          while (i1 < i2)
          {
            bool = ((View)localObject2).requestFocus();
            break;
          }
          break label38;
        }
        if (paramInt == 66)
        {
          i1 = a(this.W, (View)localObject2).left;
          i2 = a(this.W, (View)localObject1).left;
          if (localObject1 == null) {}
          while (i1 > i2)
          {
            bool = ((View)localObject2).requestFocus();
            break;
          }
          bool = d();
        }
        else
        {
          bool = false;
        }
      }
      label382:
      if (localObject1 != null) {
        for (localObject2 = ((View)localObject1).getParent();; localObject2 = ((ViewParent)localObject2).getParent())
        {
          if (!(localObject2 instanceof ViewGroup))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(localObject1.getClass().getSimpleName());
            for (localObject1 = ((View)localObject1).getParent(); (localObject1 instanceof ViewGroup); localObject1 = ((ViewParent)localObject1).getParent())
            {
              ((StringBuilder)localObject2).append(" => ");
              ((StringBuilder)localObject2).append(localObject1.getClass().getSimpleName());
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("arrowScroll tried to find focus based on non-child current focused view ");
            ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
            Log.e("ViewPager", ((StringBuilder)localObject1).toString());
            localObject1 = null;
            break;
          }
          if (localObject2 == this) {
            break label382;
          }
        }
      }
    }
  }
  
  private final void g()
  {
    Object localObject;
    if (this.e != 0)
    {
      localObject = this.q;
      if (localObject != null) {
        break label72;
      }
      this.q = new ArrayList();
    }
    for (;;)
    {
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = getChildAt(i1);
        this.q.add(localObject);
        i1 += 1;
      }
      Collections.sort(this.q, ae);
      return;
      label72:
      ((ArrayList)localObject).clear();
    }
  }
  
  private final boolean h()
  {
    boolean bool = false;
    this.j = -1;
    this.A = false;
    this.C = false;
    VelocityTracker localVelocityTracker = this.ac;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.ac = null;
    }
    this.H.onRelease();
    this.S.onRelease();
    if ((this.H.isFinished()) || (this.S.isFinished())) {
      bool = true;
    }
    return bool;
  }
  
  private final void i()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private final an j()
  {
    int i1 = f();
    if (i1 > 0) {}
    for (float f1 = getScrollX() / i1;; f1 = 0.0F)
    {
      if (i1 > 0) {}
      for (float f2 = this.P / i1;; f2 = 0.0F)
      {
        float f4 = 0.0F;
        float f3 = 0.0F;
        int i3 = -1;
        i1 = 0;
        int i2 = 1;
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (i1 < this.D.size())
        {
          localObject1 = (an)this.D.get(i1);
          if (i2 != 0) {
            break label228;
          }
          i3 += 1;
          if (((an)localObject1).c == i3) {
            break label225;
          }
          localObject1 = this.V;
          ((an)localObject1).b = (f4 + f3 + f2);
          ((an)localObject1).c = i3;
          ((an)localObject1).e = 1.0F;
          i1 -= 1;
        }
        label225:
        label228:
        for (;;)
        {
          f3 = ((an)localObject1).b;
          f4 = ((an)localObject1).e;
          if (i2 != 0) {}
          while (f1 >= f3)
          {
            if ((f1 >= f4 + f3 + f2) && (i1 != this.D.size() - 1))
            {
              i3 = ((an)localObject1).c;
              f4 = ((an)localObject1).e;
              i2 = 0;
              i1 += 1;
              localObject2 = localObject1;
              break;
            }
            return (an)localObject1;
          }
          return (an)localObject2;
        }
      }
    }
  }
  
  public final an a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.D.size())
    {
      an localan2 = (an)this.D.get(i1);
      localan1 = localan2;
      if (this.b.a(paramView, localan2.a)) {
        return localan1;
      }
      i1 += 1;
    }
    an localan1 = null;
    return localan1;
  }
  
  final void a()
  {
    int i7 = this.b.a();
    this.s = i7;
    int i1 = this.D.size();
    int i2 = this.M;
    if (i1 < i2 + i2 + 1) {
      if (this.D.size() < i7) {
        i1 = 1;
      }
    }
    for (;;)
    {
      int i5 = this.d;
      int i3 = 0;
      i2 = 0;
      int i4 = i1;
      i1 = i5;
      if (i2 == 0) {}
      for (i5 = 0;; i5 = 1)
      {
        Object localObject;
        if (i3 < this.D.size())
        {
          localObject = (an)this.D.get(i3);
          int i6 = this.b.b(((an)localObject).a);
          if (i6 == -1)
          {
            i5 = i3;
            i3 = i4;
            i4 = i5;
          }
          for (;;)
          {
            i5 = i3;
            i3 = i4 + 1;
            i4 = i5;
            break;
            if (i6 == -2)
            {
              this.D.remove(i3);
              i4 = i3 - 1;
              i3 = i5;
              if (i2 == 0) {
                i3 = 1;
              }
              this.b.a(this, ((an)localObject).c, ((an)localObject).a);
              i2 = this.d;
              if (i2 == ((an)localObject).c)
              {
                i1 = Math.max(0, Math.min(i2, i7 - 1));
                i2 = i3;
                i3 = 1;
              }
              else
              {
                i2 = i3;
                i3 = 1;
              }
            }
            else
            {
              i5 = ((an)localObject).c;
              if (i5 != i6) {
                break label259;
              }
              i5 = i4;
              i4 = i3;
              i3 = i5;
            }
          }
          label259:
          if (i5 == this.d) {
            i1 = i6;
          }
          for (;;)
          {
            ((an)localObject).c = i6;
            i5 = 1;
            i4 = i3;
            i3 = i5;
            break;
          }
        }
        if (i2 == 0) {}
        for (;;)
        {
          Collections.sort(this.D, i);
          if (i4 != 0)
          {
            i3 = getChildCount();
            i2 = 0;
            if (i2 < i3)
            {
              localObject = (ao)getChildAt(i2).getLayoutParams();
              if (((ao)localObject).c) {}
              for (;;)
              {
                i2 += 1;
                break;
                ((ao)localObject).f = 0.0F;
              }
            }
            a(i1, false, true);
            requestLayout();
          }
          return;
          this.b.b();
        }
      }
      i1 = 0;
      continue;
      i1 = 0;
    }
  }
  
  final void a(int paramInt)
  {
    int i3 = 0;
    if (this.T != paramInt)
    {
      this.T = paramInt;
      int i2;
      int i1;
      if (this.f == null)
      {
        Object localObject = this.N;
        if (localObject != null) {
          ((ar)localObject).d_(paramInt);
        }
        localObject = this.O;
        if (localObject != null)
        {
          i2 = ((List)localObject).size();
          i1 = i3;
          if (i1 < i2)
          {
            localObject = (ar)this.O.get(i1);
            if (localObject == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              ((ar)localObject).d_(paramInt);
            }
          }
        }
      }
      else
      {
        int i4 = getChildCount();
        i1 = 0;
        label115:
        if (i1 < i4) {
          if (paramInt == 0) {
            break label147;
          }
        }
        label147:
        for (i2 = this.g;; i2 = 0)
        {
          getChildAt(i1).setLayerType(i2, null);
          i1 += 1;
          break label115;
          break;
        }
      }
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    this.Q = false;
    a(paramInt, paramBoolean, false);
  }
  
  public final void a(ar paramar)
  {
    if (this.O == null) {
      this.O = new ArrayList();
    }
    this.O.add(paramar);
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {}
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
    case 21: 
    case 61: 
      do
      {
        return false;
        if (paramKeyEvent.hasModifiers(2)) {
          return aE_();
        }
        return f(17);
        if (paramKeyEvent.hasNoModifiers()) {
          return f(2);
        }
      } while (!paramKeyEvent.hasModifiers(1));
      return f(1);
    }
    if (paramKeyEvent.hasModifiers(2)) {
      return d();
    }
    return f(66);
  }
  
  public boolean aE_()
  {
    int i1 = this.d;
    if (i1 > 0)
    {
      a(i1 - 1, true);
      return true;
    }
    return false;
  }
  
  public void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    int i2 = paramArrayList.size();
    int i3 = getDescendantFocusability();
    if (i3 == 393216)
    {
      if (i3 != 262144) {}
      for (;;)
      {
        if ((isFocusable()) && (((paramInt2 & 0x1) != 1) || (!isInTouchMode()) || (isFocusableInTouchMode())) && (paramArrayList != null)) {
          paramArrayList.add(this);
        }
        do
        {
          return;
        } while (i2 != paramArrayList.size());
      }
    }
    int i1 = 0;
    label82:
    View localView;
    if (i1 < getChildCount())
    {
      localView = getChildAt(i1);
      if (localView.getVisibility() == 0) {
        break label116;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label82;
      break;
      label116:
      an localan = a(localView);
      if ((localan != null) && (localan.c == this.d)) {
        localView.addFocusables(paramArrayList, paramInt1, paramInt2);
      }
    }
  }
  
  public void addTouchables(ArrayList paramArrayList)
  {
    int i1 = 0;
    if (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 0) {}
      for (;;)
      {
        i1 += 1;
        break;
        an localan = a(localView);
        if ((localan != null) && (localan.c == this.d)) {
          localView.addTouchables(paramArrayList);
        }
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      ao localao = (ao)paramLayoutParams;
      boolean bool2 = localao.c;
      if (paramView.getClass().getAnnotation(am.class) != null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localao.c = (bool1 | bool2);
        if (!this.x)
        {
          super.addView(paramView, paramInt, paramLayoutParams);
          return;
        }
        if (localao == null) {}
        while (!localao.c)
        {
          localao.d = true;
          addViewInLayout(paramView, paramInt, paramLayoutParams);
          return;
        }
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
    }
  }
  
  public final void b()
  {
    b(this.d);
  }
  
  public final void b(ar paramar)
  {
    List localList = this.O;
    if (localList != null) {
      localList.remove(paramar);
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.b != null)
    {
      int i1 = f();
      int i2 = getScrollX();
      if (paramInt < 0) {
        if (i2 <= (int)(i1 * this.u)) {}
      }
      do
      {
        return true;
        return false;
        if (paramInt <= 0) {
          break;
        }
      } while (i2 < (int)(i1 * this.G));
      return false;
      return false;
    }
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof ao)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    this.B = true;
    if ((!this.h.isFinished()) && (this.h.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.h.getCurrX();
      int i4 = this.h.getCurrY();
      if (i1 != i3) {}
      for (;;)
      {
        scrollTo(i3, i4);
        if (!d(i3))
        {
          this.h.abortAnimation();
          scrollTo(0, i4);
        }
        do
        {
          ac.e(this);
          return;
        } while (i2 == i4);
      }
    }
    a(true);
  }
  
  public boolean d()
  {
    z localz = this.b;
    if ((localz != null) && (this.d < localz.a() - 1))
    {
      a(this.d + 1, true);
      return true;
    }
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096) {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int i2;
    int i1;
    do
    {
      return bool1;
      i2 = getChildCount();
      i1 = 0;
      bool1 = bool2;
    } while (i1 >= i2);
    View localView = getChildAt(i1);
    if (localView.getVisibility() != 0) {}
    an localan;
    do
    {
      i1 += 1;
      break;
      localan = a(localView);
    } while ((localan == null) || (localan.c != this.d) || (!localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)));
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i1 = getOverScrollMode();
    if (i1 == 0) {}
    for (;;)
    {
      int i2;
      int i3;
      boolean bool1;
      if (!this.H.isFinished())
      {
        i1 = paramCanvas.save();
        i2 = getHeight() - getPaddingTop() - getPaddingBottom();
        i3 = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i2 + getPaddingTop(), this.u * i3);
        this.H.setSize(i2, i3);
        bool1 = this.H.draw(paramCanvas);
        paramCanvas.restoreToCount(i1);
      }
      for (;;)
      {
        boolean bool2 = bool1;
        if (!this.S.isFinished())
        {
          i1 = paramCanvas.save();
          i2 = getWidth();
          i3 = getHeight();
          int i4 = getPaddingTop();
          int i5 = getPaddingBottom();
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-getPaddingTop(), -(this.G + 1.0F) * i2);
          this.S.setSize(i3 - i4 - i5, i2);
          bool2 = bool1 | this.S.draw(paramCanvas);
          paramCanvas.restoreToCount(i1);
        }
        if (bool2) {
          ac.e(this);
        }
        return;
        bool1 = false;
      }
      if (i1 != 1) {}
      z localz;
      do
      {
        this.H.finish();
        this.S.finish();
        return;
        localz = this.b;
      } while ((localz == null) || (localz.a() <= 1));
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.I;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ao();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ao(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public z getAdapter()
  {
    return this.b;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (this.e == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    }
    return ((ao)((View)this.q.get(i1)).getLayoutParams()).a;
  }
  
  public int getCurrentItem()
  {
    return this.d;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.M;
  }
  
  public int getPageMargin()
  {
    return this.P;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.t = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.r);
    Scroller localScroller = this.h;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      this.h.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.P > 0) && (this.I != null) && (this.D.size() > 0) && (this.b != null))
    {
      int i3 = getScrollX();
      int i4 = getWidth();
      float f3 = i4;
      float f4 = this.P / f3;
      an localan = (an)this.D.get(0);
      float f1 = localan.b;
      int i5 = this.D.size();
      int i2 = localan.c;
      int i6 = ((an)this.D.get(i5 - 1)).c;
      int i1 = 0;
      if (i2 < i6) {
        for (;;)
        {
          int i7 = localan.c;
          if (i2 <= i7) {}
          while (i1 >= i5)
          {
            float f2;
            if (i2 == i7)
            {
              f1 = localan.b + localan.e;
              f2 = f1 * f3;
            }
            for (f1 += f4;; f1 = 1.0F + f4 + f1)
            {
              if (this.P + f2 > i3)
              {
                this.I.setBounds(Math.round(f2), this.aa, Math.round(this.P + f2), this.k);
                this.I.draw(paramCanvas);
              }
              if (f2 > i3 + i4) {
                return;
              }
              i2 += 1;
              break;
              f2 = (1.0F + f1) * f3;
            }
          }
          i1 += 1;
          localan = (an)this.D.get(i1);
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 == 3) || (i1 == 1))
    {
      h();
      return false;
    }
    if (i1 == 0) {}
    label190:
    label304:
    label372:
    do
    {
      switch (i1)
      {
      }
      for (;;)
      {
        if (this.ac == null) {
          this.ac = VelocityTracker.obtain();
        }
        this.ac.addMovement(paramMotionEvent);
        return this.A;
        a(paramMotionEvent);
        continue;
        i1 = this.j;
        if (i1 != -1)
        {
          i1 = paramMotionEvent.findPointerIndex(i1);
          float f2 = paramMotionEvent.getX(i1);
          float f1 = f2 - this.E;
          float f4 = Math.abs(f1);
          float f3 = paramMotionEvent.getY(i1);
          float f5 = Math.abs(f3 - this.z);
          float f6;
          if (f1 != 0.0F)
          {
            f6 = this.E;
            if (f6 < this.w) {
              break label372;
            }
            if (f6 <= getWidth() - this.w) {}
            while (f1 >= 0.0F)
            {
              if (!a(this, false, (int)f1, (int)f2, (int)f3)) {
                break;
              }
              this.E = f2;
              this.F = f3;
              this.C = true;
              return false;
            }
          }
          for (;;)
          {
            f6 = this.ab;
            if ((f4 > f6) && (0.5F * f4 > f5))
            {
              this.A = true;
              i();
              a(1);
              if (f1 <= 0.0F)
              {
                f1 = this.y - this.ab;
                this.E = f1;
                this.F = f3;
                b(true);
              }
            }
            while ((this.A) && (a(f2)))
            {
              ac.e(this);
              break;
              f1 = this.y + this.ab;
              break label304;
              if (f5 > f6) {
                this.C = true;
              }
            }
            if (f1 <= 0.0F) {
              break label190;
            }
          }
          f1 = paramMotionEvent.getX();
          this.y = f1;
          this.E = f1;
          f1 = paramMotionEvent.getY();
          this.z = f1;
          this.F = f1;
          this.j = paramMotionEvent.getPointerId(0);
          this.C = false;
          this.B = true;
          this.h.computeScrollOffset();
          if ((this.T == 2) && (Math.abs(this.h.getFinalX() - this.h.getCurrX()) > this.n))
          {
            this.h.abortAnimation();
            this.Q = false;
            b();
            this.A = true;
            i();
            a(1);
          }
          else
          {
            a(false);
            this.A = false;
          }
        }
      }
      if (this.A) {
        break;
      }
    } while (!this.C);
    return false;
    return true;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i6 = getChildCount();
    int i7 = paramInt3 - paramInt1;
    int i8 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i9 = getScrollX();
    int i1 = 0;
    int i4 = 0;
    int i2;
    ao localao;
    label158:
    int i3;
    if (i4 >= i6)
    {
      i2 = 0;
      if (i2 >= i6)
      {
        this.aa = paramInt1;
        this.k = (i8 - paramInt3);
        this.o = i1;
        if (this.t) {
          a(this.d, false, 0, false);
        }
        this.t = false;
        return;
      }
      localView = getChildAt(i2);
      if (localView.getVisibility() != 8)
      {
        localao = (ao)localView.getLayoutParams();
        if (!localao.c) {
          break label158;
        }
      }
      for (;;)
      {
        i2 += 1;
        break;
        an localan = a(localView);
        if (localan != null)
        {
          float f1 = i7 - paramInt2 - paramInt4;
          i3 = (int)(localan.b * f1) + paramInt2;
          if (localao.d)
          {
            localao.d = false;
            localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localao.f * f1), 1073741824), View.MeasureSpec.makeMeasureSpec(i8 - paramInt1 - paramInt3, 1073741824));
          }
          localView.layout(i3, paramInt1, localView.getMeasuredWidth() + i3, localView.getMeasuredHeight() + paramInt1);
        }
      }
    }
    View localView = getChildAt(i4);
    if (localView.getVisibility() == 8)
    {
      i2 = i1;
      i3 = paramInt3;
      paramInt3 = paramInt4;
      i1 = paramInt2;
      paramInt4 = paramInt1;
      paramInt2 = i3;
      paramInt1 = i2;
    }
    for (;;)
    {
      i4 += 1;
      i2 = i1;
      i3 = paramInt4;
      paramInt4 = paramInt3;
      i1 = paramInt1;
      paramInt3 = paramInt2;
      paramInt1 = i3;
      paramInt2 = i2;
      break;
      localao = (ao)localView.getLayoutParams();
      if (localao.c)
      {
        int i10 = localao.b;
        switch (i10 & 0x7)
        {
        case 2: 
        case 4: 
        default: 
          i2 = paramInt2;
          i3 = paramInt2;
        }
        for (;;)
        {
          switch (i10 & 0x70)
          {
          default: 
            paramInt2 = paramInt1;
          }
          for (;;)
          {
            i2 += i9;
            localView.layout(i2, paramInt2, localView.getMeasuredWidth() + i2, localView.getMeasuredHeight() + paramInt2);
            i2 = i1 + 1;
            paramInt2 = paramInt3;
            paramInt3 = paramInt4;
            paramInt4 = paramInt1;
            i1 = i3;
            paramInt1 = i2;
            break;
            paramInt2 = i8 - paramInt3 - localView.getMeasuredHeight();
            paramInt3 += localView.getMeasuredHeight();
            continue;
            paramInt2 = Math.max((i8 - localView.getMeasuredHeight()) / 2, paramInt1);
            continue;
            i5 = localView.getMeasuredHeight();
            paramInt2 = paramInt1;
            paramInt1 = i5 + paramInt1;
          }
          i3 = localView.getMeasuredWidth();
          i2 = paramInt2;
          i3 += paramInt2;
          continue;
          i3 = localView.getMeasuredWidth();
          i2 = paramInt4 + localView.getMeasuredWidth();
          int i5 = i7 - paramInt4 - i3;
          paramInt4 = i2;
          i3 = paramInt2;
          i2 = i5;
          continue;
          i2 = Math.max((i7 - localView.getMeasuredWidth()) / 2, paramInt2);
          i3 = paramInt2;
        }
      }
      i2 = paramInt1;
      i3 = paramInt2;
      paramInt1 = i1;
      paramInt2 = paramInt3;
      paramInt3 = paramInt4;
      paramInt4 = i2;
      i1 = i3;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.w = Math.min(paramInt1 / 10, this.p);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i9 = getChildCount();
    int i7 = 0;
    ao localao;
    if (i7 >= i9)
    {
      View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      this.m = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      this.x = true;
      b();
      this.x = false;
      i1 = getChildCount();
      paramInt2 = 0;
      while (paramInt2 < i1)
      {
        localView = getChildAt(paramInt2);
        if (localView.getVisibility() != 8)
        {
          localao = (ao)localView.getLayoutParams();
          if ((localao == null) || (!localao.c))
          {
            float f1 = paramInt1;
            localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localao.f * f1), 1073741824), this.m);
          }
        }
        paramInt2 += 1;
      }
    }
    View localView = getChildAt(i7);
    int i1 = paramInt1;
    int i2 = paramInt2;
    if (localView.getVisibility() != 8)
    {
      localao = (ao)localView.getLayoutParams();
      if (localao != null) {
        break label257;
      }
      i2 = paramInt2;
      i1 = paramInt1;
    }
    label257:
    do
    {
      i7 += 1;
      paramInt1 = i1;
      paramInt2 = i2;
      break;
      i1 = paramInt1;
      i2 = paramInt2;
    } while (!localao.c);
    i2 = localao.b;
    i1 = i2 & 0x7;
    i2 &= 0x70;
    int i3;
    if (i2 != 48) {
      if (i2 != 80) {
        i3 = 0;
      }
    }
    for (;;)
    {
      int i4;
      if (i1 != 3) {
        if (i1 != 5) {
          i4 = 0;
        }
      }
      for (;;)
      {
        if (i3 != 0)
        {
          i2 = 1073741824;
          i1 = Integer.MIN_VALUE;
        }
        for (;;)
        {
          int i5;
          if (localao.width == -2)
          {
            i5 = i2;
            i2 = paramInt1;
          }
          for (;;)
          {
            int i6;
            if (localao.height == -2)
            {
              int i8 = paramInt2;
              i6 = i1;
              i1 = i8;
            }
            for (;;)
            {
              localView.measure(View.MeasureSpec.makeMeasureSpec(i2, i5), View.MeasureSpec.makeMeasureSpec(i1, i6));
              if (i3 != 0)
              {
                i2 = paramInt2 - localView.getMeasuredHeight();
                i1 = paramInt1;
                break;
              }
              i1 = paramInt1;
              i2 = paramInt2;
              if (i4 == 0) {
                break;
              }
              i1 = paramInt1 - localView.getMeasuredWidth();
              i2 = paramInt2;
              break;
              if (localao.height != -1)
              {
                i1 = localao.height;
                i6 = 1073741824;
              }
              else
              {
                i6 = 1073741824;
                i1 = paramInt2;
              }
            }
            if (localao.width != -1)
            {
              i2 = localao.width;
              i5 = 1073741824;
            }
            else
            {
              i5 = 1073741824;
              i2 = paramInt1;
            }
          }
          if (i4 != 0)
          {
            i2 = Integer.MIN_VALUE;
            i1 = 1073741824;
          }
          else
          {
            i2 = Integer.MIN_VALUE;
            i1 = Integer.MIN_VALUE;
          }
        }
        i4 = 1;
        continue;
        i4 = 1;
      }
      i3 = 1;
      continue;
      i3 = 1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i2 = -1;
    int i1 = getChildCount();
    int i3;
    if ((paramInt & 0x2) == 0)
    {
      i1 -= 1;
      i3 = -1;
    }
    for (;;)
    {
      if (i1 != i2)
      {
        View localView = getChildAt(i1);
        if (localView.getVisibility() != 0) {}
        an localan;
        do
        {
          i1 += i3;
          break;
          localan = a(localView);
        } while ((localan == null) || (localan.c != this.d) || (!localView.requestFocus(paramInt, paramRect)));
        return true;
      }
      return false;
      i2 = i1;
      i1 = 0;
      i3 = 1;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.e);
    if (this.b != null)
    {
      localObject = paramParcelable.a;
      localObject = paramParcelable.b;
      a(paramParcelable.c, false, true);
      return;
    }
    this.R = paramParcelable.c;
    Object localObject = paramParcelable.a;
    paramParcelable = paramParcelable.b;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.c = this.d;
    if (this.b != null) {
      localSavedState.a = null;
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = this.P;
      a(paramInt1, paramInt3, paramInt2, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 0) || (paramMotionEvent.getEdgeFlags() == 0))
    {
      Object localObject = this.b;
      if ((localObject != null) && (((z)localObject).a() != 0))
      {
        if (this.ac == null) {
          this.ac = VelocityTracker.obtain();
        }
        this.ac.addMovement(paramMotionEvent);
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        }
        boolean bool;
        label241:
        label285:
        label332:
        do
        {
          do
          {
            for (;;)
            {
              return true;
              this.h.abortAnimation();
              this.Q = false;
              b();
              f1 = paramMotionEvent.getX();
              this.y = f1;
              this.E = f1;
              f1 = paramMotionEvent.getY();
              this.z = f1;
              this.F = f1;
              this.j = paramMotionEvent.getPointerId(0);
              continue;
              a(paramMotionEvent);
              this.E = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.j));
              continue;
              i1 = paramMotionEvent.getActionIndex();
              this.E = paramMotionEvent.getX(i1);
              this.j = paramMotionEvent.getPointerId(i1);
            }
          } while (!this.A);
          a(this.d, true, 0, false);
          for (bool = h(); bool; bool = h())
          {
            ac.e(this);
            break;
            if (this.A) {
              break label332;
            }
            i1 = paramMotionEvent.findPointerIndex(this.j);
            if (i1 != -1) {
              break label285;
            }
          }
          f1 = paramMotionEvent.getX(i1);
          f3 = Math.abs(f1 - this.E);
          f2 = paramMotionEvent.getY(i1);
          f4 = Math.abs(f2 - this.F);
          if (f3 <= this.ab) {}
          while (f3 <= f4)
          {
            if (!this.A) {
              break;
            }
            bool = a(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.j)));
            break label241;
          }
          this.A = true;
          i();
          f3 = this.y;
          if (f1 - f3 <= 0.0F) {}
          for (f1 = f3 - this.ab;; f1 = f3 + this.ab)
          {
            this.E = f1;
            this.F = f2;
            a(1);
            b(true);
            localObject = getParent();
            if (localObject == null) {
              break;
            }
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
            break;
          }
        } while (!this.A);
        localObject = this.ac;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.J);
        int i3 = (int)((VelocityTracker)localObject).getXVelocity(this.j);
        this.Q = true;
        int i1 = f();
        int i2 = getScrollX();
        localObject = j();
        int i4 = this.P;
        float f1 = i1;
        i1 = ((an)localObject).c;
        float f2 = i2 / f1;
        float f3 = ((an)localObject).b;
        float f4 = ((an)localObject).e;
        f2 = (f2 - f3) / (i4 / f1 + f4);
        if ((Math.abs((int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.j)) - this.y)) <= this.v) || (Math.abs(i3) <= this.K)) {
          if (i1 >= this.d)
          {
            f1 = 0.4F;
            label620:
            i1 = (int)(f1 + f2) + i1;
          }
        }
        for (;;)
        {
          i2 = i1;
          if (this.D.size() > 0)
          {
            paramMotionEvent = (an)this.D.get(0);
            localObject = this.D;
            localObject = (an)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            i2 = Math.max(paramMotionEvent.c, Math.min(i1, ((an)localObject).c));
          }
          a(i2, true, true, i3);
          bool = h();
          break;
          f1 = 0.6F;
          break label620;
          if (i3 <= 0) {
            i1 += 1;
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public void removeView(View paramView)
  {
    if (this.x)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(z paramz)
  {
    int i3 = 0;
    Object localObject = this.b;
    int i1;
    int i2;
    if (localObject != null)
    {
      ((z)localObject).c(null);
      i1 = 0;
      while (i1 < this.D.size())
      {
        localObject = (an)this.D.get(i1);
        this.b.a(this, ((an)localObject).c, ((an)localObject).a);
        i1 += 1;
      }
      this.b.b();
      this.D.clear();
      for (i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
      {
        i2 = i1;
        if (!((ao)getChildAt(i1).getLayoutParams()).c)
        {
          removeViewAt(i1);
          i2 = i1 - 1;
        }
      }
      this.d = 0;
      scrollTo(0, 0);
    }
    this.b = paramz;
    this.s = 0;
    boolean bool;
    if (this.b != null)
    {
      if (this.L == null) {
        this.L = new at(this);
      }
      this.b.c(this.L);
      this.Q = false;
      bool = this.t;
      this.t = true;
      this.s = this.b.a();
      i1 = this.R;
      if (i1 < 0) {
        break label302;
      }
      a(i1, false, true);
      this.R = -1;
    }
    for (;;)
    {
      localObject = this.c;
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break;
      }
      i2 = this.c.size();
      i1 = i3;
      while (i1 < i2)
      {
        ((aq)this.c.get(i1)).a(this, paramz);
        i1 += 1;
      }
      label302:
      if (bool) {
        requestLayout();
      } else {
        b();
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.Q = false;
    a(paramInt, this.t ^ true, false);
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt <= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      Log.w("ViewPager", localStringBuilder.toString());
      i1 = 1;
    }
    if (i1 != this.M)
    {
      this.M = i1;
      b();
    }
  }
  
  @Deprecated
  public void setOnPageChangeListener(ar paramar)
  {
    this.N = paramar;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.P;
    this.P = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(d.a(getContext(), paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.I = paramDrawable;
    if (paramDrawable == null) {}
    for (;;)
    {
      if (paramDrawable == null) {}
      for (boolean bool = true;; bool = false)
      {
        setWillNotDraw(bool);
        invalidate();
        return;
      }
      refreshDrawableState();
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.I);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */