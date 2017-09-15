package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.os.b;
import android.support.v4.os.c;
import android.support.v4.view.ap;
import android.support.v4.view.f;
import android.support.v4.view.o;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
  extends ViewGroup
  implements r
{
  static final String gU;
  static final Class<?>[] gV;
  static final ThreadLocal<Map<String, Constructor<Behavior>>> gW;
  static final Comparator<View> gY;
  static final g gZ;
  private ap eD;
  final Comparator<View> gX = new Comparator() {};
  final List<View> ha = new ArrayList();
  private final List<View> hb = new ArrayList();
  private final List<View> hc = new ArrayList();
  final Rect hd = new Rect();
  final Rect he = new Rect();
  private final Rect hf = new Rect();
  private final int[] hg = new int[2];
  private boolean hh;
  private boolean hi;
  private int[] hj;
  private View hk;
  private View hl;
  private View hm;
  private e hn;
  private boolean ho;
  private boolean hp;
  private Drawable hq;
  private ViewGroup.OnHierarchyChangeListener hr;
  private final s hs = new s(this);
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      gU = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label80;
      }
      gY = new f();
    }
    for (gZ = new h();; gZ = null)
    {
      gV = new Class[] { Context.class, AttributeSet.class };
      gW = new ThreadLocal();
      return;
      localObject = null;
      break;
      label80:
      gY = null;
    }
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    t.g(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.bK, paramInt, a.h.aP);
    paramInt = paramAttributeSet.getResourceId(a.i.bR, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getResources();
      this.hj = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.hj.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = this.hj;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
        paramInt += 1;
      }
    }
    this.hq = paramAttributeSet.getDrawable(a.i.bS);
    paramAttributeSet.recycle();
    if (gZ != null) {
      gZ.a(this, new a());
    }
    super.setOnHierarchyChangeListener(new c());
  }
  
  private void R()
  {
    if (this.hk != null)
    {
      Behavior localBehavior = ((d)this.hk.getLayoutParams()).hu;
      if (localBehavior != null)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        localBehavior.b(this, this.hk, localMotionEvent);
        localMotionEvent.recycle();
      }
      this.hk = null;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((d)getChildAt(i).getLayoutParams()).hB = false;
      i += 1;
    }
    this.hh = false;
  }
  
  private void S()
  {
    int k = getChildCount();
    int j = 0;
    View localView1;
    d locald;
    int i;
    if (j < k)
    {
      localView1 = getChildAt(j);
      locald = (d)localView1.getLayoutParams();
      if (locald.hz != null)
      {
        i = 1;
        label39:
        if (i == 0) {
          break label161;
        }
      }
    }
    for (int n = 1;; n = 0)
    {
      if (n != this.ho)
      {
        if (n != 0)
        {
          if (this.hi)
          {
            if (this.hn == null) {
              this.hn = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.hn);
          }
          this.ho = true;
        }
      }
      else
      {
        return;
        int m = getChildCount();
        i = 0;
        for (;;)
        {
          if (i >= m) {
            break label156;
          }
          View localView2 = getChildAt(i);
          if ((localView2 != localView1) && (locald.c(this, localView1, localView2)))
          {
            i = 1;
            break;
          }
          i += 1;
        }
        label156:
        i = 0;
        break label39;
        label161:
        j += 1;
        break;
      }
      if ((this.hi) && (this.hn != null)) {
        getViewTreeObserver().removeOnPreDrawListener(this.hn);
      }
      this.ho = false;
      return;
    }
  }
  
  static Behavior a(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramString.startsWith(".")) {
      str = paramContext.getPackageName() + paramString;
    }
    label225:
    for (;;)
    {
      try
      {
        paramString = (Map)gW.get();
        if (paramString != null) {
          break label225;
        }
        paramString = new HashMap();
        gW.set(paramString);
        Constructor localConstructor2 = (Constructor)paramString.get(str);
        Constructor localConstructor1 = localConstructor2;
        if (localConstructor2 == null)
        {
          localConstructor1 = Class.forName(str, true, paramContext.getClassLoader()).getConstructor(gV);
          localConstructor1.setAccessible(true);
          paramString.put(str, localConstructor1);
        }
        paramContext = (Behavior)localConstructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
        return paramContext;
      }
      catch (Exception paramContext)
      {
        throw new RuntimeException("Could not inflate Behavior subclass " + str, paramContext);
      }
      str = paramString;
      if (paramString.indexOf('.') < 0)
      {
        str = paramString;
        if (!TextUtils.isEmpty(gU)) {
          str = gU + '.' + paramString;
        }
      }
    }
  }
  
  private void a(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    d locald = (d)paramView.getLayoutParams();
    int j = locald.gravity;
    int i = j;
    if (j == 0) {
      i = 17;
    }
    int n = f.getAbsoluteGravity(i, paramInt);
    i = f.getAbsoluteGravity(t(locald.hw), paramInt);
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    switch (i & 0x7)
    {
    default: 
      paramInt = paramRect1.left;
      switch (i & 0x70)
      {
      default: 
        i = paramRect1.top;
        label138:
        j = paramInt;
        switch (n & 0x7)
        {
        default: 
          j = paramInt - k;
        case 5: 
          label178:
          paramInt = i;
          switch (n & 0x70)
          {
          }
          break;
        }
        break;
      }
      break;
    }
    for (paramInt = i - m;; paramInt = i - m / 2)
    {
      n = getWidth();
      i = getHeight();
      j = Math.max(getPaddingLeft() + locald.leftMargin, Math.min(j, n - getPaddingRight() - k - locald.rightMargin));
      paramInt = Math.max(getPaddingTop() + locald.topMargin, Math.min(paramInt, i - getPaddingBottom() - m - locald.bottomMargin));
      paramRect2.set(j, paramInt, j + k, paramInt + m);
      return;
      paramInt = paramRect1.right;
      break;
      paramInt = paramRect1.left;
      paramInt = paramRect1.width() / 2 + paramInt;
      break;
      i = paramRect1.bottom;
      break label138;
      i = paramRect1.top + paramRect1.height() / 2;
      break label138;
      j = paramInt - k / 2;
      break label178;
    }
  }
  
  private static void a(List<View> paramList, Comparator<View> paramComparator)
  {
    if ((paramList == null) || (paramList.size() < 2)) {}
    for (;;)
    {
      return;
      View[] arrayOfView = new View[paramList.size()];
      paramList.toArray(arrayOfView);
      int n = arrayOfView.length;
      int i = 0;
      while (i < n)
      {
        int j = i + 1;
        int m;
        for (int k = i; j < n; k = m)
        {
          m = k;
          if (paramComparator.compare(arrayOfView[j], arrayOfView[k]) < 0) {
            m = j;
          }
          j += 1;
        }
        if (i != k)
        {
          View localView = arrayOfView[k];
          arrayOfView[k] = arrayOfView[i];
          arrayOfView[i] = localView;
        }
        i += 1;
      }
      paramList.clear();
      i = 0;
      while (i < n)
      {
        paramList.add(arrayOfView[i]);
        i += 1;
      }
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool1 = false;
    int k = 0;
    int m = o.d(paramMotionEvent);
    List localList = this.hb;
    localList.clear();
    boolean bool2 = isChildrenDrawingOrderEnabled();
    int n = getChildCount();
    int i = n - 1;
    if (i >= 0)
    {
      if (bool2) {}
      for (j = getChildDrawingOrder(n, i);; j = i)
      {
        localList.add(getChildAt(j));
        i -= 1;
        break;
      }
    }
    if (gY != null) {
      Collections.sort(localList, gY);
    }
    n = localList.size();
    int j = 0;
    MotionEvent localMotionEvent = null;
    i = k;
    View localView;
    d locald;
    Behavior localBehavior;
    if (j < n)
    {
      localView = (View)localList.get(j);
      locald = (d)localView.getLayoutParams();
      localBehavior = locald.hu;
      if (((bool1) || (i != 0)) && (m != 0))
      {
        if (localBehavior == null) {
          break label456;
        }
        if (localMotionEvent != null) {
          break label453;
        }
        long l = SystemClock.uptimeMillis();
        localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        label199:
        switch (paramInt)
        {
        }
      }
    }
    label304:
    label359:
    label434:
    label443:
    label453:
    label456:
    for (;;)
    {
      j += 1;
      break;
      localBehavior.a(this, localView, localMotionEvent);
      continue;
      localBehavior.b(this, localView, localMotionEvent);
      continue;
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (localBehavior == null) {}
      }
      switch (paramInt)
      {
      default: 
        bool2 = bool1;
        if (bool1)
        {
          this.hk = localView;
          bool2 = bool1;
        }
        bool1 = bool2;
        if (locald.hu == null) {
          locald.hB = false;
        }
        boolean bool3 = locald.hB;
        if (locald.hB)
        {
          bool2 = true;
          if ((!bool2) || (bool3)) {
            break label434;
          }
        }
        break;
      }
      for (i = 1;; i = 0)
      {
        if (bool2)
        {
          bool2 = bool1;
          if (i == 0) {
            break label443;
          }
        }
        break;
        bool1 = localBehavior.a(this, localView, paramMotionEvent);
        break label304;
        bool1 = localBehavior.b(this, localView, paramMotionEvent);
        break label304;
        bool2 = locald.hB | false;
        locald.hB = bool2;
        break label359;
      }
      bool2 = bool1;
      localList.clear();
      return bool2;
      break label199;
    }
  }
  
  private static d m(View paramView)
  {
    d locald = (d)paramView.getLayoutParams();
    View localView;
    if (!locald.hv)
    {
      Class localClass = paramView.getClass();
      paramView = null;
      for (;;)
      {
        localView = paramView;
        if (localClass == null) {
          break;
        }
        paramView = (b)localClass.getAnnotation(b.class);
        localView = paramView;
        if (paramView != null) {
          break;
        }
        localClass = localClass.getSuperclass();
      }
      if (localView == null) {}
    }
    try
    {
      locald.a((Behavior)localView.value().newInstance());
      locald.hv = true;
      return locald;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        new StringBuilder("Default behavior class ").append(localView.value().getName()).append(" could not be instantiated. Did you forget a default constructor?");
      }
    }
  }
  
  private int s(int paramInt)
  {
    if (this.hj == null)
    {
      new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(paramInt);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= this.hj.length))
    {
      new StringBuilder("Keyline index ").append(paramInt).append(" out of range for ").append(this);
      return 0;
    }
    return this.hj[paramInt];
  }
  
  private static int t(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388659;
    }
    return i;
  }
  
  private static int u(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388661;
    }
    return i;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  final void a(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((paramView.isLayoutRequested()) || (paramView.getVisibility() == 8))
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (paramBoolean)
    {
      x.a(this, paramView, paramRect);
      return;
    }
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  public final boolean b(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = this.hd;
    x.a(this, paramView, localRect);
    return localRect.contains(paramInt1, paramInt2);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof d)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    paramView.getLayoutParams();
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.hq;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  public final void e(View paramView, int paramInt)
  {
    Object localObject = (d)paramView.getLayoutParams();
    if ((((d)localObject).hz == null) && (((d)localObject).hy != -1)) {}
    for (int i = 1; i != 0; i = 0) {
      throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }
    if (((d)localObject).hz != null)
    {
      localObject = ((d)localObject).hz;
      paramView.getLayoutParams();
      localRect1 = this.hd;
      localRect2 = this.he;
      x.a(this, (View)localObject, localRect1);
      a(paramView, paramInt, localRect1, localRect2);
      paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
      return;
    }
    if (((d)localObject).hx >= 0)
    {
      int j = ((d)localObject).hx;
      localObject = (d)paramView.getLayoutParams();
      int i2 = f.getAbsoluteGravity(u(((d)localObject).gravity), paramInt);
      int i1 = getWidth();
      int n = getHeight();
      int k = paramView.getMeasuredWidth();
      int m = paramView.getMeasuredHeight();
      i = j;
      if (paramInt == 1) {
        i = i1 - j;
      }
      paramInt = s(i) - k;
      switch (i2 & 0x7)
      {
      default: 
        switch (i2 & 0x70)
        {
        default: 
          i = 0;
        }
        break;
      }
      for (;;)
      {
        paramInt = Math.max(getPaddingLeft() + ((d)localObject).leftMargin, Math.min(paramInt, i1 - getPaddingRight() - k - ((d)localObject).rightMargin));
        i = Math.max(getPaddingTop() + ((d)localObject).topMargin, Math.min(i, n - getPaddingBottom() - m - ((d)localObject).bottomMargin));
        paramView.layout(paramInt, i, paramInt + k, i + m);
        return;
        paramInt += k;
        break;
        paramInt += k / 2;
        break;
        i = m + 0;
        continue;
        i = m / 2 + 0;
      }
    }
    localObject = (d)paramView.getLayoutParams();
    Rect localRect1 = this.hd;
    localRect1.set(getPaddingLeft() + ((d)localObject).leftMargin, getPaddingTop() + ((d)localObject).topMargin, getWidth() - getPaddingRight() - ((d)localObject).rightMargin, getHeight() - getPaddingBottom() - ((d)localObject).bottomMargin);
    if ((this.eD != null) && (z.aa(this)) && (!z.aa(paramView)))
    {
      localRect1.left += this.eD.getSystemWindowInsetLeft();
      localRect1.top += this.eD.getSystemWindowInsetTop();
      localRect1.right -= this.eD.getSystemWindowInsetRight();
      localRect1.bottom -= this.eD.getSystemWindowInsetBottom();
    }
    Rect localRect2 = this.he;
    f.apply(t(((d)localObject).gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
  }
  
  public int getNestedScrollAxes()
  {
    return this.hs.xn;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  final void i(boolean paramBoolean)
  {
    int k = z.J(this);
    int m = this.ha.size();
    int i = 0;
    while (i < m)
    {
      View localView = (View)this.ha.get(i);
      Object localObject1 = (d)localView.getLayoutParams();
      int j = 0;
      Object localObject3;
      while (j < i)
      {
        localObject2 = (View)this.ha.get(j);
        if (((d)localObject1).hA == localObject2)
        {
          localObject2 = (d)localView.getLayoutParams();
          if (((d)localObject2).hz != null)
          {
            localObject3 = this.hd;
            Rect localRect1 = this.he;
            Rect localRect2 = this.hf;
            x.a(this, ((d)localObject2).hz, (Rect)localObject3);
            a(localView, false, localRect1);
            a(localView, k, (Rect)localObject3, localRect2);
            int n = localRect2.left - localRect1.left;
            int i1 = localRect2.top - localRect1.top;
            if (n != 0) {
              localView.offsetLeftAndRight(n);
            }
            if (i1 != 0) {
              localView.offsetTopAndBottom(i1);
            }
            if ((n != 0) || (i1 != 0))
            {
              localObject3 = ((d)localObject2).hu;
              if (localObject3 != null) {
                ((Behavior)localObject3).b(this, localView, ((d)localObject2).hz);
              }
            }
          }
        }
        j += 1;
      }
      localObject1 = this.hd;
      Object localObject2 = this.he;
      ((Rect)localObject1).set(((d)localView.getLayoutParams()).hE);
      a(localView, true, (Rect)localObject2);
      if (!((Rect)localObject1).equals(localObject2))
      {
        ((d)localView.getLayoutParams()).hE.set((Rect)localObject2);
        j = i + 1;
        if (j < m)
        {
          localObject1 = (View)this.ha.get(j);
          localObject2 = (d)((View)localObject1).getLayoutParams();
          localObject3 = ((d)localObject2).hu;
          if ((localObject3 != null) && (((Behavior)localObject3).e(localView)))
          {
            if ((paramBoolean) || (!((d)localObject2).hD)) {
              break label388;
            }
            ((d)localObject2).hD = false;
          }
          for (;;)
          {
            j += 1;
            break;
            label388:
            ((Behavior)localObject3).b(this, (View)localObject1, localView);
            if (paramBoolean) {
              ((d)localObject2).hD = false;
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public final List<View> n(View paramView)
  {
    d locald = (d)paramView.getLayoutParams();
    List localList = this.hc;
    localList.clear();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView != paramView) && (locald.c(this, paramView, localView))) {
        localList.add(localView);
      }
      i += 1;
    }
    return localList;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    R();
    if (this.ho)
    {
      if (this.hn == null) {
        this.hn = new e();
      }
      getViewTreeObserver().addOnPreDrawListener(this.hn);
    }
    if ((this.eD == null) && (z.aa(this))) {
      z.Z(this);
    }
    this.hi = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    R();
    if ((this.ho) && (this.hn != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.hn);
    }
    if (this.hm != null) {
      onStopNestedScroll(this.hm);
    }
    this.hi = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.hp) && (this.hq != null)) {
      if (this.eD == null) {
        break label61;
      }
    }
    label61:
    for (int i = this.eD.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.hq.setBounds(0, 0, getWidth(), i);
        this.hq.draw(paramCanvas);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = o.d(paramMotionEvent);
    if (i == 0) {
      R();
    }
    boolean bool = a(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      R();
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = z.J(this);
    paramInt3 = this.ha.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)this.ha.get(paramInt1);
      Behavior localBehavior = ((d)localView.getLayoutParams()).hu;
      if ((localBehavior == null) || (!localBehavior.a(this, localView, paramInt2))) {
        e(localView, paramInt2);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.ha.clear();
    int k = getChildCount();
    int j = 0;
    Object localObject3;
    int i;
    label165:
    Object localObject2;
    Object localObject1;
    if (j < k)
    {
      localObject3 = getChildAt(j);
      d locald = m((View)localObject3);
      if (locald.hy == -1)
      {
        locald.hA = null;
        locald.hz = null;
      }
      for (;;)
      {
        this.ha.add(localObject3);
        j += 1;
        break;
        if (locald.hz != null)
        {
          if (locald.hz.getId() == locald.hy) {
            break label165;
          }
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            break label254;
          }
          locald.hz = findViewById(locald.hy);
          if (locald.hz == null) {
            break label372;
          }
          if (locald.hz != this) {
            break label267;
          }
          if (!isInEditMode()) {
            break label256;
          }
          locald.hA = null;
          locald.hz = null;
          break;
          localObject2 = locald.hz;
          for (localObject1 = locald.hz.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
          {
            if (localObject1 == this) {
              break label244;
            }
            if ((localObject1 == null) || (localObject1 == localObject3))
            {
              locald.hA = null;
              locald.hz = null;
              i = 0;
              break;
            }
            if ((localObject1 instanceof View)) {
              localObject2 = (View)localObject1;
            }
          }
          label244:
          locald.hA = ((View)localObject2);
          i = 1;
        }
        label254:
        continue;
        label256:
        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        label267:
        localObject2 = locald.hz;
        for (localObject1 = locald.hz.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
        {
          if ((localObject1 == this) || (localObject1 == null)) {
            break label362;
          }
          if (localObject1 == localObject3)
          {
            if (isInEditMode())
            {
              locald.hA = null;
              locald.hz = null;
              break;
            }
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
          }
          if ((localObject1 instanceof View)) {
            localObject2 = (View)localObject1;
          }
        }
        label362:
        locald.hA = ((View)localObject2);
        continue;
        label372:
        if (!isInEditMode()) {
          break label394;
        }
        locald.hA = null;
        locald.hz = null;
      }
      label394:
      throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(locald.hy) + " to anchor view " + localObject3);
    }
    a(this.ha, this.gX);
    S();
    int i5 = getPaddingLeft();
    int i6 = getPaddingTop();
    int i7 = getPaddingRight();
    int i8 = getPaddingBottom();
    int i9 = z.J(this);
    int i2;
    int i1;
    label548:
    int m;
    int n;
    label565:
    int i3;
    int i4;
    int i15;
    if (i9 == 1)
    {
      j = 1;
      int i10 = View.MeasureSpec.getMode(paramInt1);
      int i11 = View.MeasureSpec.getSize(paramInt1);
      int i12 = View.MeasureSpec.getMode(paramInt2);
      int i13 = View.MeasureSpec.getSize(paramInt2);
      i2 = getSuggestedMinimumWidth();
      i1 = getSuggestedMinimumHeight();
      if ((this.eD == null) || (!z.aa(this))) {
        break label891;
      }
      k = 1;
      int i14 = this.ha.size();
      m = 0;
      n = 0;
      if (m >= i14) {
        break label938;
      }
      localObject1 = (View)this.ha.get(m);
      localObject2 = (d)((View)localObject1).getLayoutParams();
      i3 = 0;
      i = i3;
      if (((d)localObject2).hx >= 0)
      {
        i = i3;
        if (i10 != 0)
        {
          i4 = s(((d)localObject2).hx);
          i15 = f.getAbsoluteGravity(u(((d)localObject2).gravity), i9) & 0x7;
          if (((i15 != 3) || (j != 0)) && ((i15 != 5) || (j == 0))) {
            break label897;
          }
          i = Math.max(0, i11 - i7 - i4);
        }
      }
      label684:
      if ((k == 0) || (z.aa((View)localObject1))) {
        break label966;
      }
      i3 = this.eD.getSystemWindowInsetLeft();
      int i16 = this.eD.getSystemWindowInsetRight();
      i4 = this.eD.getSystemWindowInsetTop();
      i15 = this.eD.getSystemWindowInsetBottom();
      i3 = View.MeasureSpec.makeMeasureSpec(i11 - (i3 + i16), i10);
      i4 = View.MeasureSpec.makeMeasureSpec(i13 - (i4 + i15), i12);
    }
    for (;;)
    {
      localObject3 = ((d)localObject2).hu;
      if ((localObject3 == null) || (!((Behavior)localObject3).a(this, (View)localObject1, i3, i, i4, 0))) {
        a((View)localObject1, i3, i, i4, 0);
      }
      i2 = Math.max(i2, ((View)localObject1).getMeasuredWidth() + (i5 + i7) + ((d)localObject2).leftMargin + ((d)localObject2).rightMargin);
      i1 = Math.max(i1, ((View)localObject1).getMeasuredHeight() + (i6 + i8) + ((d)localObject2).topMargin + ((d)localObject2).bottomMargin);
      n = z.combineMeasuredStates(n, z.N((View)localObject1));
      m += 1;
      break label565;
      j = 0;
      break;
      label891:
      k = 0;
      break label548;
      label897:
      if ((i15 != 5) || (j != 0))
      {
        i = i3;
        if (i15 != 3) {
          break label684;
        }
        i = i3;
        if (j == 0) {
          break label684;
        }
      }
      i = Math.max(0, i4 - i5);
      break label684;
      label938:
      setMeasuredDimension(z.resolveSizeAndState(i2, paramInt1, 0xFF000000 & n), z.resolveSizeAndState(i1, paramInt2, n << 16));
      return;
      label966:
      i4 = paramInt2;
      i3 = paramInt1;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool = false;
    if (i < j)
    {
      paramView = getChildAt(i);
      Object localObject = (d)paramView.getLayoutParams();
      if (!((d)localObject).hC) {
        break label92;
      }
      localObject = ((d)localObject).hu;
      if (localObject == null) {
        break label92;
      }
      bool = ((Behavior)localObject).a(this, paramView, paramFloat2, paramBoolean) | bool;
    }
    label92:
    for (;;)
    {
      i += 1;
      break;
      if (bool) {
        i(true);
      }
      return bool;
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool = false;
    if (i < j)
    {
      View localView = getChildAt(i);
      Object localObject = (d)localView.getLayoutParams();
      if (!((d)localObject).hC) {
        break label85;
      }
      localObject = ((d)localObject).hu;
      if (localObject == null) {
        break label85;
      }
      bool = ((Behavior)localObject).a(this, localView, paramView, paramFloat1, paramFloat2) | bool;
    }
    label85:
    for (;;)
    {
      i += 1;
      break;
      return bool;
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int j = 0;
    int i = 0;
    int k = 0;
    int i1 = getChildCount();
    int m = 0;
    label112:
    label129:
    int n;
    if (m < i1)
    {
      View localView = getChildAt(m);
      Object localObject = (d)localView.getLayoutParams();
      if (!((d)localObject).hC) {
        break label220;
      }
      localObject = ((d)localObject).hu;
      if (localObject == null) {
        break label220;
      }
      int[] arrayOfInt = this.hg;
      this.hg[1] = 0;
      arrayOfInt[0] = 0;
      ((Behavior)localObject).a(this, localView, paramView, paramInt2, this.hg);
      if (paramInt1 > 0)
      {
        j = Math.max(j, this.hg[0]);
        if (paramInt2 <= 0) {
          break label181;
        }
        i = Math.max(i, this.hg[1]);
        n = 1;
        k = i;
        i = n;
      }
    }
    for (;;)
    {
      n = m + 1;
      m = k;
      k = i;
      i = m;
      m = n;
      break;
      j = Math.min(j, this.hg[0]);
      break label112;
      label181:
      i = Math.min(i, this.hg[1]);
      break label129;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      if (k != 0) {
        i(true);
      }
      return;
      label220:
      n = i;
      i = k;
      k = n;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt2 < paramInt3)
    {
      paramView = getChildAt(paramInt2);
      Object localObject = (d)paramView.getLayoutParams();
      if (!((d)localObject).hC) {
        break label79;
      }
      localObject = ((d)localObject).hu;
      if (localObject == null) {
        break label79;
      }
      ((Behavior)localObject).b(this, paramView, paramInt4);
      paramInt1 = 1;
    }
    label79:
    for (;;)
    {
      paramInt2 += 1;
      break;
      if (paramInt1 != 0) {
        i(true);
      }
      return;
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.hs.xn = paramInt;
    this.hl = paramView1;
    this.hm = paramView2;
    int i = getChildCount();
    paramInt = 0;
    while (paramInt < i)
    {
      getChildAt(paramInt).getLayoutParams();
      paramInt += 1;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      paramParcelable = paramParcelable.hG;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        int k = localView.getId();
        Behavior localBehavior = m(localView).hu;
        if ((k != -1) && (localBehavior != null))
        {
          Parcelable localParcelable = (Parcelable)paramParcelable.get(k);
          if (localParcelable != null) {
            localBehavior.a(this, localView, localParcelable);
          }
        }
        i += 1;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      int k = ((View)localObject).getId();
      Behavior localBehavior = ((d)((View)localObject).getLayoutParams()).hu;
      if ((k != -1) && (localBehavior != null))
      {
        localObject = localBehavior.b(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    localSavedState.hG = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    boolean bool1 = false;
    if (i < j)
    {
      paramView2 = getChildAt(i);
      d locald = (d)paramView2.getLayoutParams();
      Behavior localBehavior = locald.hu;
      if (localBehavior != null)
      {
        boolean bool2 = localBehavior.a(this, paramView2, paramView1, paramInt);
        locald.hC = bool2;
        bool1 |= bool2;
      }
      for (;;)
      {
        i += 1;
        break;
        locald.hC = false;
      }
    }
    return bool1;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.hs.xn = 0;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      d locald = (d)localView.getLayoutParams();
      if (locald.hC)
      {
        Behavior localBehavior = locald.hu;
        if (localBehavior != null) {
          localBehavior.a(this, localView, paramView);
        }
        locald.hC = false;
        locald.hD = false;
      }
      i += 1;
    }
    this.hl = null;
    this.hm = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = o.d(paramMotionEvent);
    boolean bool2;
    if (this.hk == null)
    {
      bool2 = a(paramMotionEvent, 1);
      if (!bool2) {}
    }
    for (;;)
    {
      Behavior localBehavior = ((d)this.hk.getLayoutParams()).hu;
      boolean bool1;
      if (localBehavior != null) {
        bool1 = localBehavior.b(this, this.hk, paramMotionEvent);
      }
      for (;;)
      {
        if (this.hk == null)
        {
          bool1 |= super.onTouchEvent(paramMotionEvent);
          paramMotionEvent = null;
        }
        for (;;)
        {
          if (paramMotionEvent != null) {
            paramMotionEvent.recycle();
          }
          if ((i == 1) || (i == 3)) {
            R();
          }
          return bool1;
          if (bool2)
          {
            long l = SystemClock.uptimeMillis();
            paramMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
            super.onTouchEvent(paramMotionEvent);
          }
          else
          {
            paramMotionEvent = null;
          }
        }
        bool1 = false;
        continue;
        bool1 = false;
      }
      bool2 = false;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.hh))
    {
      R();
      this.hh = true;
    }
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.hr = paramOnHierarchyChangeListener;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.hq != null) && (this.hq.isVisible() != bool)) {
        this.hq.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.hq);
  }
  
  public static abstract class Behavior<V extends View>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
    
    public static ap a(ap paramap)
    {
      return paramap;
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable) {}
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView) {}
    
    public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt, int[] paramArrayOfInt) {}
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, float paramFloat, boolean paramBoolean)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
    {
      return false;
    }
    
    public Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return View.BaseSavedState.EMPTY_STATE;
    }
    
    public void b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {}
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
    {
      return false;
    }
    
    public boolean e(View paramView)
    {
      return false;
    }
  }
  
  protected static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = b.a(new c() {});
    SparseArray<Parcelable> hG;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      int j = paramParcel.readInt();
      int[] arrayOfInt = new int[j];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      this.hG = new SparseArray(j);
      int i = 0;
      while (i < j)
      {
        this.hG.append(arrayOfInt[i], paramParcel[i]);
        i += 1;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int j = 0;
      super.writeToParcel(paramParcel, paramInt);
      if (this.hG != null) {}
      int[] arrayOfInt;
      Parcelable[] arrayOfParcelable;
      for (int i = this.hG.size();; i = 0)
      {
        paramParcel.writeInt(i);
        arrayOfInt = new int[i];
        arrayOfParcelable = new Parcelable[i];
        while (j < i)
        {
          arrayOfInt[j] = this.hG.keyAt(j);
          arrayOfParcelable[j] = ((Parcelable)this.hG.valueAt(j));
          j += 1;
        }
      }
      paramParcel.writeIntArray(arrayOfInt);
      paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
    }
  }
  
  private final class a
    implements android.support.v4.view.t
  {
    public a() {}
    
    public final ap a(View paramView, ap paramap)
    {
      return CoordinatorLayout.a(CoordinatorLayout.this, paramap);
    }
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface b
  {
    Class<? extends CoordinatorLayout.Behavior> value();
  }
  
  private final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    public c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      if (CoordinatorLayout.a(CoordinatorLayout.this) != null) {
        CoordinatorLayout.a(CoordinatorLayout.this).onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      CoordinatorLayout localCoordinatorLayout = CoordinatorLayout.this;
      int k = localCoordinatorLayout.ha.size();
      int j = 0;
      int i = 0;
      if (j < k)
      {
        View localView = (View)localCoordinatorLayout.ha.get(j);
        if (localView == paramView2) {
          i = 1;
        }
        for (;;)
        {
          j += 1;
          break;
          if (i != 0) {
            localView.getLayoutParams();
          }
        }
      }
      if (CoordinatorLayout.a(CoordinatorLayout.this) != null) {
        CoordinatorLayout.a(CoordinatorLayout.this).onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
  
  public static final class d
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = 0;
    View hA;
    boolean hB;
    boolean hC;
    boolean hD;
    final Rect hE = new Rect();
    Object hF;
    CoordinatorLayout.Behavior hu;
    boolean hv = false;
    public int hw = 0;
    public int hx = -1;
    int hy = -1;
    View hz;
    
    public d()
    {
      super(-2);
    }
    
    d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.bL);
      this.gravity = localTypedArray.getInteger(a.i.bM, 0);
      this.hy = localTypedArray.getResourceId(a.i.bN, -1);
      this.hw = localTypedArray.getInteger(a.i.bO, 0);
      this.hx = localTypedArray.getInteger(a.i.bQ, -1);
      this.hv = localTypedArray.hasValue(a.i.bP);
      if (this.hv) {
        this.hu = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(a.i.bP));
      }
      localTypedArray.recycle();
    }
    
    public d(d paramd)
    {
      super();
    }
    
    public d(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public final void a(CoordinatorLayout.Behavior paramBehavior)
    {
      if (this.hu != paramBehavior)
      {
        this.hu = paramBehavior;
        this.hF = null;
        this.hv = true;
      }
    }
    
    final boolean c(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return (paramView2 == this.hA) || ((this.hu != null) && (this.hu.e(paramView2)));
    }
  }
  
  final class e
    implements ViewTreeObserver.OnPreDrawListener
  {
    e() {}
    
    public final boolean onPreDraw()
    {
      CoordinatorLayout.this.i(false);
      return true;
    }
  }
  
  static final class f
    implements Comparator<View>
  {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/CoordinatorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */