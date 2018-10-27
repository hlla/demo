package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.a.a.a;
import android.support.v4.content.d;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.view.k;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
{
  public static final boolean a;
  public static final int[] b;
  public static final boolean c;
  private static final int[] n;
  private int A = 3;
  private int B = 3;
  private int C;
  private final ArrayList D;
  private final y E;
  private int F = -1728053248;
  private float G;
  private Paint H = new Paint();
  private Drawable I;
  private Drawable J;
  private Drawable K;
  public boolean d;
  public boolean e;
  public int f;
  public Object g;
  public final az h;
  public List i;
  public final az j;
  public Drawable k = null;
  public CharSequence l;
  public CharSequence m;
  private final t o = new t();
  private Rect p;
  private Matrix q;
  private float r;
  private boolean s = true;
  private boolean t;
  private float u;
  private float v;
  private final y w;
  private u x;
  private int y = 3;
  private int z = 3;
  
  static
  {
    boolean bool2 = true;
    n = new int[] { 16843828 };
    b = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a = bool1;
      if (Build.VERSION.SDK_INT >= 21) {}
      for (bool1 = bool2;; bool1 = false)
      {
        c = bool1;
        return;
      }
    }
  }
  
  public DrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.C = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.w = new y(this, 3);
    this.E = new y(this, 5);
    this.h = az.a(this, 1.0F, this.w);
    paramAttributeSet = this.h;
    paramAttributeSet.j = 1;
    paramAttributeSet.h = f2;
    this.w.b = paramAttributeSet;
    this.j = az.a(this, 1.0F, this.E);
    paramAttributeSet = this.j;
    paramAttributeSet.j = 2;
    paramAttributeSet.h = f2;
    this.E.b = paramAttributeSet;
    setFocusableInTouchMode(true);
    ac.b(this, 1);
    ac.a(this, new s(this));
    setMotionEventSplittingEnabled(false);
    if (ac.y(this))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label305;
      }
      setOnApplyWindowInsetsListener(new r());
      setSystemUiVisibility(1280);
      paramContext = paramContext.obtainStyledAttributes(n);
    }
    for (;;)
    {
      try
      {
        this.K = paramContext.getDrawable(0);
        paramContext.recycle();
        this.r = (f1 * 10.0F);
        return;
      }
      finally
      {
        label305:
        paramContext.recycle();
      }
      this.K = null;
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    int i1 = k.a(paramInt2, ac.h(this));
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        switch (paramInt1)
        {
        }
        do
        {
          do
          {
            return;
            localObject = a(i1);
          } while (localObject == null);
          f((View)localObject);
          return;
          localObject = a(i1);
        } while (localObject == null);
        e((View)localObject);
        return;
      }
      if (i1 != 3) {}
      for (Object localObject = this.j;; localObject = this.h)
      {
        ((az)localObject).a();
        break;
      }
      this.y = paramInt1;
      continue;
      this.B = paramInt1;
      continue;
      this.A = paramInt1;
      continue;
      this.z = paramInt1;
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    boolean bool = false;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      v localv = (v)localView.getLayoutParams();
      if (!d(localView)) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (!paramBoolean) {}
        while (localv.b)
        {
          int i3 = localView.getWidth();
          if (a(localView, 3)) {
            bool |= this.h.a(localView, -i3, localView.getTop());
          }
          for (;;)
          {
            localv.b = false;
            break;
            bool |= this.j.a(localView, getWidth(), localView.getTop());
          }
        }
      }
    }
    this.w.b();
    this.E.b();
    if (bool) {
      invalidate();
    }
  }
  
  private static boolean a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (a.a(paramDrawable)))
    {
      a.b(paramDrawable, paramInt);
      return true;
    }
    return false;
  }
  
  static float b(View paramView)
  {
    return ((v)paramView.getLayoutParams()).c;
  }
  
  private final View d()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((((v)localView.getLayoutParams()).d & 0x1) != 1) {
        i1 += 1;
      } else {
        return localView;
      }
    }
    return null;
  }
  
  static boolean d(View paramView)
  {
    int i1 = k.a(((v)paramView.getLayoutParams()).a, ac.h(paramView));
    if ((i1 & 0x3) == 0) {
      return (i1 & 0x5) != 0;
    }
    return true;
  }
  
  public static boolean g(View paramView)
  {
    if (!d(paramView))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("View ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(" is not a drawer");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (byte)(((v)paramView.getLayoutParams()).d & 0x1);
  }
  
  static boolean h(View paramView)
  {
    return (ac.f(paramView) != 4) && (ac.f(paramView) != 2);
  }
  
  private static boolean i(View paramView)
  {
    return ((v)paramView.getLayoutParams()).a == 0;
  }
  
  public final int a(View paramView)
  {
    if (!d(paramView))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("View ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(" is not a drawer");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    int i1 = ((v)paramView.getLayoutParams()).a;
    int i3 = ac.h(this);
    switch (i1)
    {
    }
    for (;;)
    {
      i1 = 0;
      label118:
      int i2;
      do
      {
        do
        {
          do
          {
            do
            {
              return i1;
              i2 = this.z;
              i1 = i2;
            } while (i2 != 3);
            if (i3 != 0) {}
            for (i2 = this.y;; i2 = this.B)
            {
              i1 = i2;
              if (i2 != 3) {
                break label118;
              }
              break;
            }
            i2 = this.y;
            i1 = i2;
          } while (i2 != 3);
          if (i3 != 0) {}
          for (i1 = this.z; i1 != 3; i1 = this.A) {
            return i1;
          }
          i2 = this.B;
          i1 = i2;
        } while (i2 != 3);
        if (i3 != 0) {}
        for (i1 = this.A; i1 != 3; i1 = this.z) {
          return i1;
        }
        i2 = this.A;
        i1 = i2;
      } while (i2 != 3);
      if (i3 != 0) {}
      for (i1 = this.B; i1 != 3; i1 = this.y) {
        return i1;
      }
    }
  }
  
  public final View a(int paramInt)
  {
    int i1 = k.a(paramInt, ac.h(this));
    int i2 = getChildCount();
    paramInt = 0;
    while (paramInt < i2)
    {
      View localView2 = getChildAt(paramInt);
      localView1 = localView2;
      if ((c(localView2) & 0x7) == (i1 & 0x7)) {
        break label58;
      }
      paramInt += 1;
    }
    View localView1 = null;
    label58:
    return localView1;
  }
  
  public final void a(u paramu)
  {
    if (paramu != null)
    {
      if (this.i == null) {
        this.i = new ArrayList();
      }
      this.i.add(paramu);
    }
  }
  
  final void a(View paramView, boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((!paramBoolean) && (!d(localView))) {}
      for (;;)
      {
        ac.b(localView, 1);
        i1 += 1;
        break;
        if (!paramBoolean) {}
        while (localView != paramView)
        {
          ac.b(localView, 4);
          break;
        }
      }
    }
  }
  
  final boolean a(View paramView, int paramInt)
  {
    return (c(paramView) & paramInt) == paramInt;
  }
  
  final void a_(View paramView, float paramFloat)
  {
    Object localObject = (v)paramView.getLayoutParams();
    if (paramFloat != ((v)localObject).c)
    {
      ((v)localObject).c = paramFloat;
      localObject = this.i;
      if (localObject != null)
      {
        int i1 = ((List)localObject).size() - 1;
        while (i1 >= 0)
        {
          ((u)this.i.get(i1)).a(paramView, paramFloat);
          i1 -= 1;
        }
      }
    }
  }
  
  public void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    int i3 = 0;
    if (getDescendantFocusability() != 393216)
    {
      int i4 = getChildCount();
      int i1 = 0;
      int i2 = 0;
      View localView;
      if (i1 < i4)
      {
        localView = getChildAt(i1);
        if (d(localView)) {
          if (g(localView))
          {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
            i2 = 1;
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          this.D.add(localView);
        }
      }
      if (i2 == 0)
      {
        i2 = this.D.size();
        i1 = i3;
        if (i1 < i2)
        {
          localView = (View)this.D.get(i1);
          if (localView.getVisibility() != 0) {}
          for (;;)
          {
            i1 += 1;
            break;
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
      }
      this.D.clear();
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((d() != null) || (d(paramView))) {
      ac.b(paramView, 4);
    }
    for (;;)
    {
      if (!a) {
        ac.a(paramView, this.o);
      }
      return;
      ac.b(paramView, 1);
    }
  }
  
  public final void as_()
  {
    Object localObject2 = null;
    int i1;
    Object localObject1;
    if (!c)
    {
      i1 = ac.h(this);
      if (i1 != 0) {
        break label89;
      }
      localObject1 = this.k;
      if (localObject1 == null) {
        break label84;
      }
      a((Drawable)localObject1, i1);
      localObject1 = this.k;
    }
    for (;;)
    {
      this.I = ((Drawable)localObject1);
      i1 = ac.h(this);
      localObject1 = localObject2;
      if (i1 != 0)
      {
        Drawable localDrawable = this.k;
        localObject1 = localObject2;
        if (localDrawable != null)
        {
          a(localDrawable, i1);
          localObject1 = this.k;
        }
      }
      this.J = ((Drawable)localObject1);
      return;
      label84:
      localObject1 = null;
      continue;
      label89:
      localObject1 = null;
    }
  }
  
  public final boolean at_()
  {
    View localView = a(8388611);
    if (localView == null) {
      return false;
    }
    return g(localView);
  }
  
  public final void b(u paramu)
  {
    if (paramu != null)
    {
      List localList = this.i;
      if (localList != null) {
        localList.remove(paramu);
      }
    }
  }
  
  final int c(View paramView)
  {
    return k.a(((v)paramView.getLayoutParams()).a, ac.h(this));
  }
  
  final View c()
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (!d(localView)) {}
      do
      {
        i1 += 1;
        break;
        if (!d(localView))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("View ");
          localStringBuilder.append(localView);
          localStringBuilder.append(" is not a drawer");
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      } while (((v)localView.getLayoutParams()).c <= 0.0F);
      return localView;
    }
    return null;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof v)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    int i2 = getChildCount();
    float f1 = 0.0F;
    int i1 = 0;
    while (i1 < i2)
    {
      f1 = Math.max(f1, ((v)getChildAt(i1).getLayoutParams()).c);
      i1 += 1;
    }
    this.G = f1;
    boolean bool1 = this.h.b();
    boolean bool2 = this.j.b();
    if (bool1) {}
    for (;;)
    {
      ac.e(this);
      do
      {
        return;
      } while (!bool2);
    }
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) == 0) || (paramMotionEvent.getAction() == 10) || (this.G <= 0.0F)) {
      return super.dispatchGenericMotionEvent(paramMotionEvent);
    }
    int i1 = getChildCount();
    if (i1 != 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i1 -= 1;
      if (i1 >= 0)
      {
        View localView = getChildAt(i1);
        if (this.p == null) {
          this.p = new Rect();
        }
        localView.getHitRect(this.p);
        if (!this.p.contains((int)f1, (int)f2)) {}
        for (;;)
        {
          i1 -= 1;
          break;
          if (!i(localView))
          {
            boolean bool;
            if (localView.getMatrix().isIdentity())
            {
              float f3 = getScrollX() - localView.getLeft();
              float f4 = getScrollY() - localView.getTop();
              paramMotionEvent.offsetLocation(f3, f4);
              bool = localView.dispatchGenericMotionEvent(paramMotionEvent);
              paramMotionEvent.offsetLocation(-f3, -f4);
            }
            while (bool)
            {
              return true;
              int i2 = getScrollX();
              int i3 = localView.getLeft();
              int i4 = getScrollY();
              int i5 = localView.getTop();
              MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
              localMotionEvent.offsetLocation(i2 - i3, i4 - i5);
              Matrix localMatrix = localView.getMatrix();
              if (!localMatrix.isIdentity())
              {
                if (this.q == null) {
                  this.q = new Matrix();
                }
                localMatrix.invert(this.q);
                localMotionEvent.transform(this.q);
              }
              bool = localView.dispatchGenericMotionEvent(localMotionEvent);
              localMotionEvent.recycle();
            }
          }
        }
      }
    }
    return false;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i8 = getHeight();
    boolean bool1 = i(paramView);
    int i3 = getWidth();
    int i7 = paramCanvas.save();
    int i1;
    int i4;
    if (bool1)
    {
      int i9 = getChildCount();
      i1 = 0;
      i4 = 0;
      if (i4 >= i9) {
        paramCanvas.clipRect(i1, 0, i3, getHeight());
      }
    }
    for (;;)
    {
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i7);
      float f1 = this.G;
      if (f1 <= 0.0F) {}
      while (!bool1)
      {
        if ((this.I != null) && (a(paramView, 3)))
        {
          i1 = this.I.getIntrinsicWidth();
          i2 = paramView.getRight();
          i3 = this.h.c;
          f1 = Math.max(0.0F, Math.min(i2 / i3, 1.0F));
          this.I.setBounds(i2, paramView.getTop(), i1 + i2, paramView.getBottom());
          this.I.setAlpha((int)(255.0F * f1));
          this.I.draw(paramCanvas);
        }
        while ((this.J == null) || (!a(paramView, 5))) {
          return bool2;
        }
        i1 = this.J.getIntrinsicWidth();
        i2 = paramView.getLeft();
        i3 = getWidth();
        i4 = this.j.c;
        f1 = Math.max(0.0F, Math.min((i3 - i2) / i4, 1.0F));
        this.J.setBounds(i2 - i1, paramView.getTop(), i2, paramView.getBottom());
        this.J.setAlpha((int)(255.0F * f1));
        this.J.draw(paramCanvas);
        return bool2;
      }
      int i2 = this.F;
      this.H.setColor((int)(f1 * ((0xFF000000 & i2) >>> 24)) << 24 | i2 & 0xFFFFFF);
      paramCanvas.drawRect(i1, 0.0F, i3, getHeight(), this.H);
      return bool2;
      View localView = getChildAt(i4);
      int i5;
      if (localView == paramView)
      {
        i2 = i1;
        i5 = i3;
      }
      for (;;)
      {
        i4 += 1;
        i1 = i2;
        i3 = i5;
        break;
        if (localView.getVisibility() == 0)
        {
          Drawable localDrawable = localView.getBackground();
          if (localDrawable != null)
          {
            if (localDrawable.getOpacity() != -1)
            {
              i5 = i3;
              i2 = i1;
            }
            else if (!d(localView))
            {
              i5 = i3;
              i2 = i1;
            }
            else if (localView.getHeight() < i8)
            {
              i5 = i3;
              i2 = i1;
            }
            else if (a(localView, 3))
            {
              int i6 = localView.getRight();
              i5 = i3;
              i2 = i6;
              if (i6 <= i1)
              {
                i5 = i3;
                i2 = i1;
              }
            }
            else
            {
              i5 = localView.getLeft();
              if (i5 >= i3)
              {
                i5 = i3;
                i2 = i1;
              }
              else
              {
                i2 = i1;
              }
            }
          }
          else
          {
            i5 = i3;
            i2 = i1;
          }
        }
        else
        {
          i5 = i3;
          i2 = i1;
        }
      }
      i1 = 0;
    }
  }
  
  public final void e(View paramView)
  {
    if (!d(paramView))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("View ");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(" is not a sliding drawer");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = (v)paramView.getLayoutParams();
    if (this.s)
    {
      ((v)localObject).c = 1.0F;
      ((v)localObject).d = 1;
      a(paramView, true);
    }
    for (;;)
    {
      invalidate();
      return;
      ((v)localObject).d |= 0x2;
      if (a(paramView, 3)) {
        this.h.a(paramView, 0, paramView.getTop());
      } else {
        this.j.a(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  public final void f(View paramView)
  {
    if (!d(paramView))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("View ");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(" is not a sliding drawer");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = (v)paramView.getLayoutParams();
    if (this.s)
    {
      ((v)localObject).c = 0.0F;
      ((v)localObject).d = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      ((v)localObject).d |= 0x4;
      if (a(paramView, 3)) {
        this.h.a(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.j.a(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new v();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new v(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof v)) {
      return new v((v)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new v((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new v(paramLayoutParams);
  }
  
  public float getDrawerElevation()
  {
    if (!c) {
      return 0.0F;
    }
    return this.r;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.K;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.s = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.s = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1;
    if ((this.e) && (this.K != null))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label76;
      }
      Object localObject = this.g;
      if (localObject == null) {
        break label71;
      }
      i1 = ((WindowInsets)localObject).getSystemWindowInsetTop();
    }
    for (;;)
    {
      if (i1 > 0)
      {
        this.K.setBounds(0, 0, getWidth(), i1);
        this.K.draw(paramCanvas);
      }
      return;
      label71:
      i1 = 0;
      continue;
      label76:
      i1 = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool1 = this.h.a(paramMotionEvent);
    boolean bool2 = this.j.a(paramMotionEvent);
    switch (i1)
    {
    }
    for (;;)
    {
      i1 = 0;
      for (;;)
      {
        if ((!(bool1 | bool2)) && (i1 == 0))
        {
          i2 = getChildCount();
          i1 = 0;
          while (i1 < i2)
          {
            if (((v)getChildAt(i1).getLayoutParams()).b) {
              break label128;
            }
            i1 += 1;
          }
          if (!this.d) {
            return false;
          }
        }
        label128:
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.u = f1;
        this.v = f2;
        if (this.G > 0.0F)
        {
          paramMotionEvent = this.h.b((int)f1, (int)f2);
          if (paramMotionEvent != null) {
            if (i(paramMotionEvent)) {
              i1 = 1;
            }
          }
        }
        for (;;)
        {
          this.d = false;
          break;
          i1 = 0;
          continue;
          i1 = 0;
          continue;
          i1 = 0;
        }
        paramMotionEvent = this.h;
        int i2 = paramMotionEvent.d.length;
        i1 = 0;
        for (;;)
        {
          if (i1 >= i2) {
            break label323;
          }
          if (paramMotionEvent.a(i1))
          {
            f1 = paramMotionEvent.f[i1] - paramMotionEvent.d[i1];
            f2 = paramMotionEvent.g[i1] - paramMotionEvent.e[i1];
            int i3 = paramMotionEvent.i;
            if (f1 * f1 + f2 * f2 > i3 * i3)
            {
              this.w.b();
              this.E.b();
              break;
            }
          }
          i1 += 1;
        }
        label323:
        i1 = 0;
      }
      a(true);
      this.d = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (c() != null))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      paramKeyEvent = c();
      if ((paramKeyEvent != null) && (a(paramKeyEvent) == 0)) {
        a(false);
      }
      if (paramKeyEvent != null) {
        bool = true;
      }
      return bool;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.t = true;
    int i3 = paramInt3 - paramInt1;
    int i4 = getChildCount();
    paramInt3 = 0;
    while (paramInt3 < i4)
    {
      View localView = getChildAt(paramInt3);
      v localv;
      if (localView.getVisibility() != 8)
      {
        localv = (v)localView.getLayoutParams();
        if (i(localView)) {
          localView.layout(localv.leftMargin, localv.topMargin, localv.leftMargin + localView.getMeasuredWidth(), localv.topMargin + localView.getMeasuredHeight());
        }
      }
      else
      {
        paramInt3 += 1;
        continue;
      }
      int i5 = localView.getMeasuredWidth();
      int i6 = localView.getMeasuredHeight();
      int i1;
      if (a(localView, 3))
      {
        f1 = i5;
        i1 = -i5 + (int)(localv.c * f1);
      }
      for (float f1 = (i5 + i1) / f1;; f1 = (i3 - i1) / f1)
      {
        float f2 = localv.c;
        switch (localv.a & 0x70)
        {
        default: 
          localView.layout(i1, localv.topMargin, i5 + i1, i6 + localv.topMargin);
        case 80: 
          for (;;)
          {
            if (f1 == f2) {}
            for (;;)
            {
              if (localv.c > 0.0F) {}
              for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
              {
                localView.setVisibility(paramInt1);
                break;
              }
              a_(localView, f1);
            }
            paramInt1 = paramInt4 - paramInt2;
            localView.layout(i1, paramInt1 - localv.bottomMargin - localView.getMeasuredHeight(), i5 + i1, paramInt1 - localv.bottomMargin);
          }
        }
        int i7 = paramInt4 - paramInt2;
        int i2 = (i7 - i6) / 2;
        if (i2 < localv.topMargin) {
          paramInt1 = localv.topMargin;
        }
        for (;;)
        {
          localView.layout(i1, paramInt1, i5 + i1, i6 + paramInt1);
          break;
          paramInt1 = i2;
          if (i2 + i6 > i7 - localv.bottomMargin) {
            paramInt1 = i7 - localv.bottomMargin - i6;
          }
        }
        f1 = i5;
        i1 = i3 - (int)(localv.c * f1);
      }
    }
    this.t = false;
    this.s = false;
  }
  
  @SuppressLint({"WrongConstant"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    label47:
    label63:
    label88:
    int i5;
    int i6;
    View localView;
    v localv;
    int i9;
    Object localObject2;
    Object localObject1;
    if (i4 != 1073741824)
    {
      if (!isInEditMode()) {
        break label759;
      }
      if (i4 == Integer.MIN_VALUE) {
        if (i3 == Integer.MIN_VALUE)
        {
          i3 = i2;
          i2 = i1;
          setMeasuredDimension(i2, i3);
          if (this.g != null) {
            if (ac.y(this))
            {
              i4 = 1;
              int i7 = ac.h(this);
              int i8 = getChildCount();
              i5 = 0;
              i1 = 0;
              i6 = 0;
              for (;;)
              {
                if (i6 >= i8) {
                  return;
                }
                localView = getChildAt(i6);
                if (localView.getVisibility() == 8) {
                  break label684;
                }
                localv = (v)localView.getLayoutParams();
                if (i4 != 0)
                {
                  i9 = k.a(localv.a, i7);
                  if (!ac.y(localView)) {
                    break label559;
                  }
                  if (Build.VERSION.SDK_INT >= 21)
                  {
                    localObject2 = (WindowInsets)this.g;
                    if (i9 != 3) {
                      break label523;
                    }
                    localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(((WindowInsets)localObject2).getSystemWindowInsetLeft(), ((WindowInsets)localObject2).getSystemWindowInsetTop(), 0, ((WindowInsets)localObject2).getSystemWindowInsetBottom());
                    label215:
                    localView.dispatchApplyWindowInsets((WindowInsets)localObject1);
                  }
                }
                label223:
                if (!i(localView)) {
                  break;
                }
                localView.measure(View.MeasureSpec.makeMeasureSpec(i2 - localv.leftMargin - localv.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i3 - localv.topMargin - localv.bottomMargin, 1073741824));
                label276:
                i6 += 1;
              }
              if (!d(localView)) {
                break label770;
              }
              if (c)
              {
                float f1 = ac.u(localView);
                float f2 = this.r;
                if (f1 != f2) {
                  ac.g(localView, f2);
                }
              }
              i9 = c(localView) & 0x7;
              if ((i9 == 3) && (i5 != 0))
              {
                label347:
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Child drawer has absolute gravity ");
                if ((i9 & 0x3) != 3) {
                  break label844;
                }
                localObject1 = "LEFT";
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" but this ");
      ((StringBuilder)localObject2).append("DrawerLayout");
      ((StringBuilder)localObject2).append(" already has a ");
      ((StringBuilder)localObject2).append("drawer view along that edge");
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
      if (i9 == 3) {}
      while (i1 == 0)
      {
        if (i9 != 3) {
          i1 = 1;
        }
        if (i9 == 3) {
          i5 = 1;
        }
        for (;;)
        {
          localView.measure(getChildMeasureSpec(paramInt1, this.C + localv.leftMargin + localv.rightMargin, localv.width), getChildMeasureSpec(paramInt2, localv.topMargin + localv.bottomMargin, localv.height));
          break;
        }
      }
      break label347;
      label523:
      localObject1 = localObject2;
      if (i9 != 5) {
        break label215;
      }
      localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(0, ((WindowInsets)localObject2).getSystemWindowInsetTop(), ((WindowInsets)localObject2).getSystemWindowInsetRight(), ((WindowInsets)localObject2).getSystemWindowInsetBottom());
      break label215;
      label559:
      if (Build.VERSION.SDK_INT < 21) {
        break label223;
      }
      localObject2 = (WindowInsets)this.g;
      if (i9 == 3) {
        localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(((WindowInsets)localObject2).getSystemWindowInsetLeft(), ((WindowInsets)localObject2).getSystemWindowInsetTop(), 0, ((WindowInsets)localObject2).getSystemWindowInsetBottom());
      }
      for (;;)
      {
        localv.leftMargin = ((WindowInsets)localObject1).getSystemWindowInsetLeft();
        localv.topMargin = ((WindowInsets)localObject1).getSystemWindowInsetTop();
        localv.rightMargin = ((WindowInsets)localObject1).getSystemWindowInsetRight();
        localv.bottomMargin = ((WindowInsets)localObject1).getSystemWindowInsetBottom();
        break;
        localObject1 = localObject2;
        if (i9 == 5) {
          localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(0, ((WindowInsets)localObject2).getSystemWindowInsetTop(), ((WindowInsets)localObject2).getSystemWindowInsetRight(), ((WindowInsets)localObject2).getSystemWindowInsetBottom());
        }
      }
      label684:
      break label276;
      i4 = 0;
      break label88;
      i4 = 0;
      break label88;
      if (i3 == 0)
      {
        i3 = 300;
        i2 = i1;
        break label63;
      }
      i3 = i2;
      i2 = i1;
      break label63;
      if (i4 != 0) {
        break label47;
      }
      i1 = 300;
      break label47;
      if (i3 != 1073741824) {
        break;
      }
      i3 = i2;
      i2 = i1;
      break label63;
      label759:
      throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
      label770:
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Child ");
      ((StringBuilder)localObject1).append(localView);
      ((StringBuilder)localObject1).append(" at index ");
      ((StringBuilder)localObject1).append(i6);
      ((StringBuilder)localObject1).append(" does not have a valid layout_gravity - must be Gravity.LEFT, ");
      ((StringBuilder)localObject1).append("Gravity.RIGHT or Gravity.NO_GRAVITY");
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
      label844:
      if ((i9 & 0x5) != 5) {
        localObject1 = Integer.toHexString(i9);
      } else {
        localObject1 = "RIGHT";
      }
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof DrawerLayout.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (DrawerLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.e);
    int i1 = paramParcelable.g;
    View localView;
    if (i1 != 0)
    {
      localView = a(i1);
      if (localView != null) {
        break label114;
      }
    }
    for (;;)
    {
      i1 = paramParcelable.b;
      if (i1 != 3) {
        a(i1, 3);
      }
      i1 = paramParcelable.c;
      if (i1 != 3) {
        a(i1, 5);
      }
      i1 = paramParcelable.f;
      if (i1 != 3) {
        a(i1, 8388611);
      }
      i1 = paramParcelable.a;
      if (i1 == 3) {
        break;
      }
      a(i1, 8388613);
      return;
      label114:
      e(localView);
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    as_();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    DrawerLayout.SavedState localSavedState = new DrawerLayout.SavedState(super.onSaveInstanceState());
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      v localv;
      int i3;
      if (i1 < i2)
      {
        localv = (v)getChildAt(i1).getLayoutParams();
        i3 = localv.d;
        if (i3 != 1) {
          break label98;
        }
      }
      label98:
      while (i3 == 2)
      {
        localSavedState.g = localv.a;
        localSavedState.b = this.z;
        localSavedState.c = this.A;
        localSavedState.f = this.B;
        localSavedState.a = this.y;
        return localSavedState;
      }
      i1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    this.h.b(paramMotionEvent);
    this.j.b(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return true;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.u = f1;
      this.v = f2;
      this.d = false;
      return true;
    case 3: 
      a(true);
      this.d = false;
      return true;
    }
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    paramMotionEvent = this.h.b((int)f2, (int)f1);
    if (paramMotionEvent != null) {
      if (i(paramMotionEvent))
      {
        f2 -= this.u;
        f1 -= this.v;
        int i1 = this.h.i;
        if (f2 * f2 + f1 * f1 < i1 * i1)
        {
          paramMotionEvent = d();
          if (paramMotionEvent != null) {
            if (a(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
    }
    for (;;)
    {
      a(bool);
      return true;
      bool = true;
      continue;
      bool = true;
      continue;
      bool = true;
      continue;
      bool = true;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if (paramBoolean) {
      a(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.t) {
      super.requestLayout();
    }
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    this.r = paramFloat;
    int i1 = 0;
    if (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (!d(localView)) {}
      for (;;)
      {
        i1 += 1;
        break;
        ac.g(localView, this.r);
      }
    }
  }
  
  @Deprecated
  public void setDrawerListener(u paramu)
  {
    u localu = this.x;
    if (localu != null) {
      b(localu);
    }
    if (paramu != null) {
      a(paramu);
    }
    this.x = paramu;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    a(paramInt, 3);
    a(paramInt, 5);
  }
  
  public void setScrimColor(int paramInt)
  {
    this.F = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = d.a(getContext(), paramInt);; localDrawable = null)
    {
      this.K = localDrawable;
      invalidate();
      return;
    }
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    this.K = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    this.K = new ColorDrawable(paramInt);
    invalidate();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/DrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */