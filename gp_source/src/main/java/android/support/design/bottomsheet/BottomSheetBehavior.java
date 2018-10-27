package android.support.design.bottomsheet;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.h;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.widget.az;
import android.support.v4.widget.bc;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior
  extends h
{
  public int a;
  public int b;
  public boolean c = true;
  public int d;
  public int e;
  public boolean f;
  public WeakReference g;
  public int h;
  public int i = 4;
  public boolean j;
  public az k;
  public WeakReference l;
  private final bc m = new a(this);
  private boolean n;
  private Map o;
  private int p;
  private int q;
  private int r;
  private float s;
  private boolean t;
  private int u;
  private boolean v;
  private int w;
  private boolean x;
  private VelocityTracker y;
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, d.a);
    TypedValue localTypedValue = paramAttributeSet.peekValue(d.d);
    if ((localTypedValue != null) && (localTypedValue.data == -1)) {
      c(localTypedValue.data);
    }
    for (;;)
    {
      this.f = paramAttributeSet.getBoolean(d.c, false);
      boolean bool = paramAttributeSet.getBoolean(d.b, true);
      if (this.c != bool)
      {
        this.c = bool;
        if (this.l != null) {
          c();
        }
        if ((this.c) && (this.i == 6)) {
          break label172;
        }
      }
      label172:
      for (int i1 = this.i;; i1 = 3)
      {
        b(i1);
        this.x = paramAttributeSet.getBoolean(d.e, false);
        paramAttributeSet.recycle();
        this.s = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
        return;
      }
      c(paramAttributeSet.getDimensionPixelSize(d.d, -1));
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject = this.l;
    int i2;
    int i1;
    if (localObject != null)
    {
      localObject = ((View)((WeakReference)localObject).get()).getParent();
      if ((localObject instanceof CoordinatorLayout))
      {
        localObject = (CoordinatorLayout)localObject;
        i2 = ((CoordinatorLayout)localObject).getChildCount();
        if (!paramBoolean) {
          break label193;
        }
        if (this.o == null)
        {
          this.o = new HashMap(i2);
          i1 = 0;
        }
      }
    }
    for (;;)
    {
      if (i1 < i2)
      {
        View localView = ((CoordinatorLayout)localObject).getChildAt(i1);
        if (localView == this.l.get()) {}
        for (;;)
        {
          i1 += 1;
          break;
          if (paramBoolean)
          {
            this.o.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
            ac.b(localView, 4);
          }
          else
          {
            Map localMap = this.o;
            if ((localMap != null) && (localMap.containsKey(localView))) {
              ac.b(localView, ((Integer)this.o.get(localView)).intValue());
            }
          }
        }
      }
      if (!paramBoolean) {
        this.o = null;
      }
      return;
      label193:
      i1 = 0;
    }
  }
  
  private final View b(View paramView)
  {
    View localView = paramView;
    if (!ac.F(paramView))
    {
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i2 = paramView.getChildCount();
        int i1 = 0;
        for (;;)
        {
          if (i1 >= i2) {
            break label60;
          }
          localView = b(paramView.getChildAt(i1));
          if (localView != null) {
            break;
          }
          i1 += 1;
        }
      }
    }
    else {
      return localView;
    }
    label60:
    return null;
  }
  
  private final void c()
  {
    if (this.c)
    {
      this.b = Math.max(this.h - this.r, this.d);
      return;
    }
    this.b = (this.h - this.r);
  }
  
  private final void c(int paramInt)
  {
    if (paramInt != -1) {
      if ((this.v) || (this.u != paramInt))
      {
        this.v = false;
        this.u = Math.max(0, paramInt);
        this.b = (this.h - paramInt);
      }
    }
    for (;;)
    {
      if (this.i == 4)
      {
        Object localObject = this.l;
        if (localObject != null)
        {
          localObject = (View)((WeakReference)localObject).get();
          if (localObject != null) {
            ((View)localObject).requestLayout();
          }
        }
      }
      do
      {
        return;
      } while (this.v);
      this.v = true;
    }
  }
  
  private final void d()
  {
    this.a = -1;
    VelocityTracker localVelocityTracker = this.y;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.y = null;
    }
  }
  
  final int a()
  {
    if (this.c) {
      return this.d;
    }
    return 0;
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, View paramView, Parcelable paramParcelable)
  {
    paramParcelable = (BottomSheetBehavior.SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramView, paramParcelable.e);
    int i1 = paramParcelable.a;
    if (i1 == 1) {}
    while (i1 == 2)
    {
      this.i = 4;
      return;
    }
    this.i = i1;
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt)
  {
    int i1 = 3;
    if (paramView1.getTop() == a()) {
      b(3);
    }
    while ((paramView2 != this.g.get()) || (!this.t)) {
      return;
    }
    if (this.q > 0)
    {
      paramInt = a();
      if (this.k.a(paramView1, paramView1.getLeft(), paramInt))
      {
        b(2);
        ac.a(paramView1, new c(this, paramView1, i1));
      }
      for (;;)
      {
        this.t = false;
        return;
        b(i1);
      }
    }
    if (!this.f) {}
    label338:
    for (;;)
    {
      if (this.q == 0)
      {
        paramInt = paramView1.getTop();
        if (this.c)
        {
          if (Math.abs(paramInt - this.d) < Math.abs(paramInt - this.b))
          {
            paramInt = this.d;
            break;
          }
          paramInt = this.b;
          i1 = 4;
          break;
        }
        int i2 = this.e;
        if (paramInt < i2)
        {
          if (paramInt >= Math.abs(paramInt - this.b))
          {
            paramInt = this.e;
            i1 = 6;
            break;
          }
          paramInt = 0;
          break;
        }
        if (Math.abs(paramInt - i2) < Math.abs(paramInt - this.b))
        {
          paramInt = this.e;
          i1 = 6;
          break;
        }
        paramInt = this.b;
        i1 = 4;
        break;
      }
      paramInt = this.b;
      i1 = 4;
      break;
      paramCoordinatorLayout = this.y;
      if (paramCoordinatorLayout != null) {
        paramCoordinatorLayout.computeCurrentVelocity(1000, this.s);
      }
      for (float f1 = this.y.getYVelocity(this.a);; f1 = 0.0F)
      {
        if (!a(paramView1, f1)) {
          break label338;
        }
        paramInt = this.h;
        i1 = 5;
        break;
      }
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i1;
    if ((paramInt2 != 1) && (paramView2 == (View)this.g.get()))
    {
      paramInt2 = paramView1.getTop();
      i1 = paramInt2 - paramInt1;
      if (paramInt1 <= 0) {
        break label114;
      }
      if (i1 >= a()) {
        break label93;
      }
      paramArrayOfInt[1] = (paramInt2 - a());
      ac.e(paramView1, -paramArrayOfInt[1]);
      b(3);
    }
    for (;;)
    {
      paramView1.getTop();
      b();
      this.q = paramInt1;
      this.t = true;
      return;
      label93:
      paramArrayOfInt[1] = paramInt1;
      ac.e(paramView1, -paramInt1);
      b(1);
      continue;
      label114:
      if ((paramInt1 < 0) && (!paramView2.canScrollVertically(-1)))
      {
        int i2 = this.b;
        if ((i1 <= i2) || (this.f))
        {
          paramArrayOfInt[1] = paramInt1;
          ac.e(paramView1, -paramInt1);
          b(1);
        }
        else
        {
          paramArrayOfInt[1] = (paramInt2 - i2);
          ac.e(paramView1, -paramArrayOfInt[1]);
          b(4);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    if ((ac.y(paramCoordinatorLayout)) && (!ac.y(paramView))) {
      paramView.setFitsSystemWindows(true);
    }
    int i1 = paramView.getTop();
    paramCoordinatorLayout.a(paramView, paramInt);
    this.h = paramCoordinatorLayout.getHeight();
    if (this.v) {
      if (this.w == 0) {
        this.w = paramCoordinatorLayout.getResources().getDimensionPixelSize(2131165550);
      }
    }
    for (this.r = Math.max(this.w, this.h - paramCoordinatorLayout.getWidth() * 9 / 16);; this.r = this.u)
    {
      this.d = Math.max(0, this.h - paramView.getHeight());
      this.e = (this.h / 2);
      c();
      paramInt = this.i;
      if (paramInt == 3) {
        ac.e(paramView, a());
      }
      for (;;)
      {
        if (this.k == null) {
          this.k = az.a(paramCoordinatorLayout, this.m);
        }
        this.l = new WeakReference(paramView);
        this.g = new WeakReference(b(paramView));
        return true;
        if (paramInt == 6)
        {
          ac.e(paramView, this.e);
        }
        else
        {
          if (!this.f) {}
          while (paramInt != 5)
          {
            if (paramInt == 4)
            {
              ac.e(paramView, this.b);
              break;
            }
            if (paramInt == 1) {}
            for (;;)
            {
              ac.e(paramView, i1 - paramView.getTop());
              break;
              if (paramInt != 2) {
                break;
              }
            }
          }
          ac.e(paramView, this.h);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if (!paramView.isShown())
    {
      this.n = true;
      return false;
    }
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0) {
      d();
    }
    if (this.y == null) {
      this.y = VelocityTracker.obtain();
    }
    this.y.addMovement(paramMotionEvent);
    switch (i1)
    {
    case 2: 
    default: 
    case 1: 
    case 3: 
      do
      {
        if (!this.n)
        {
          paramView = this.k;
          if ((paramView != null) && (paramView.a(paramMotionEvent))) {}
        }
        else
        {
          paramView = this.g;
          if (paramView != null) {}
          for (paramView = (View)paramView.get(); (i1 == 2) && (paramView != null) && (!this.n) && (this.i != 1) && (!paramCoordinatorLayout.a(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.k != null) && (Math.abs(this.p - paramMotionEvent.getY()) > this.k.i); paramView = null) {
            return true;
          }
        }
        return true;
        this.j = false;
        this.a = -1;
      } while (!this.n);
      this.n = false;
      return false;
    }
    int i2 = (int)paramMotionEvent.getX();
    this.p = ((int)paramMotionEvent.getY());
    Object localObject = this.g;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if ((localObject != null) && (paramCoordinatorLayout.a((View)localObject, i2, this.p)))
      {
        this.a = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
        this.j = true;
      }
      boolean bool;
      if (this.a == -1) {
        if (!paramCoordinatorLayout.a(paramView, i2, this.p)) {
          bool = true;
        }
      }
      for (;;)
      {
        this.n = bool;
        break;
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, float paramFloat1, float paramFloat2)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView2 == this.g.get())
    {
      if (this.i != 3) {
        break label54;
      }
      bool1 = bool3;
      if (super.a(paramCoordinatorLayout, paramView1, paramView2, paramFloat1, paramFloat2)) {}
    }
    label54:
    for (bool1 = bool2;; bool1 = true) {
      return bool1;
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.q = 0;
    this.t = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    if (!this.x)
    {
      if (paramView.getTop() < this.b) {}
    }
    else {
      return Math.abs(paramView.getTop() + 0.1F * paramFloat - this.b) / this.u > 0.5F;
    }
    return false;
  }
  
  public final Parcelable b(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    return new BottomSheetBehavior.SavedState(super.b(paramCoordinatorLayout, paramView), this.i);
  }
  
  final void b()
  {
    this.l.get();
  }
  
  final void b(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      if (paramInt != 6) {
        break label33;
      }
    }
    label33:
    while (paramInt == 3)
    {
      a(true);
      this.l.get();
      return;
    }
    if (paramInt == 5) {}
    for (;;)
    {
      a(false);
      break;
      if (paramInt != 4) {
        break;
      }
    }
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.isShown())
    {
      int i1 = paramMotionEvent.getActionMasked();
      if (this.i != 1) {}
      while (i1 != 0)
      {
        paramCoordinatorLayout = this.k;
        if (paramCoordinatorLayout != null) {
          paramCoordinatorLayout.b(paramMotionEvent);
        }
        if (i1 != 0) {}
        for (;;)
        {
          if (this.y == null) {
            this.y = VelocityTracker.obtain();
          }
          this.y.addMovement(paramMotionEvent);
          if ((i1 == 2) && (!this.n))
          {
            i1 = this.p;
            float f1 = paramMotionEvent.getY();
            f1 = Math.abs(i1 - f1);
            paramCoordinatorLayout = this.k;
            if (f1 > paramCoordinatorLayout.i) {
              paramCoordinatorLayout.a(paramView, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
            }
          }
          return this.n ^ true;
          d();
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/bottomsheet/BottomSheetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */