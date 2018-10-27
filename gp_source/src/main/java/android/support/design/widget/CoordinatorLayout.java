package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.content.d;
import android.support.v4.g.r;
import android.support.v4.g.t;
import android.support.v4.g.v;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.view.bf;
import android.support.v4.view.w;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.support.v4.widget.bd;
import android.support.v4.widget.q;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
  extends ViewGroup
  implements w
{
  private static final Class[] f;
  private static final Comparator g;
  private static final String h;
  private static final ThreadLocal v;
  private static final r w;
  public final q a = new q();
  public boolean b;
  public bf c;
  public ViewGroup.OnHierarchyChangeListener d;
  public final List e = new ArrayList();
  private y i;
  private View j;
  private final List k = new ArrayList();
  private boolean l;
  private boolean m;
  private int[] n;
  private boolean o;
  private final x p = new x();
  private View q;
  private l r;
  private Drawable s;
  private final int[] t = new int[2];
  private final List u = new ArrayList();
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null) {}
    for (localObject = ((Package)localObject).getName();; localObject = null)
    {
      h = (String)localObject;
      if (Build.VERSION.SDK_INT >= 21) {}
      for (g = new n();; g = null)
      {
        f = new Class[] { Context.class, AttributeSet.class };
        v = new ThreadLocal();
        w = new t(12);
        return;
      }
    }
  }
  
  public CoordinatorLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968832);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramInt == 0) {}
    for (paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.b.a.a, 0, 2132018472);; paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.b.a.a, paramInt, 0))
    {
      paramInt = paramAttributeSet.getResourceId(android.support.b.a.j, 0);
      if (paramInt != 0)
      {
        paramContext = paramContext.getResources();
        this.n = paramContext.getIntArray(paramInt);
        float f1 = paramContext.getDisplayMetrics().density;
        int i2 = this.n.length;
        paramInt = i1;
        while (paramInt < i2)
        {
          paramContext = this.n;
          paramContext[paramInt] = ((int)(paramContext[paramInt] * f1));
          paramInt += 1;
        }
      }
      this.s = paramAttributeSet.getDrawable(android.support.b.a.k);
      paramAttributeSet.recycle();
      b();
      super.setOnHierarchyChangeListener(new j(this));
      return;
    }
  }
  
  private static Rect a()
  {
    Rect localRect2 = (Rect)w.a();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  static h a(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("."))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getPackageName());
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    try
    {
      for (;;)
      {
        paramString = (Map)v.get();
        if (paramString == null)
        {
          paramString = new HashMap();
          v.set(paramString);
        }
        for (;;)
        {
          Constructor localConstructor2 = (Constructor)paramString.get(localObject);
          Constructor localConstructor1 = localConstructor2;
          if (localConstructor2 == null)
          {
            localConstructor1 = paramContext.getClassLoader().loadClass((String)localObject).getConstructor(f);
            localConstructor1.setAccessible(true);
            paramString.put(localObject, localConstructor1);
          }
          paramContext = (h)localConstructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
          return paramContext;
        }
        localObject = paramString;
        if (paramString.indexOf('.') < 0)
        {
          localObject = paramString;
          if (!TextUtils.isEmpty(h))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(h);
            ((StringBuilder)localObject).append('.');
            ((StringBuilder)localObject).append(paramString);
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramAttributeSet = new StringBuilder();
      paramAttributeSet.append("Could not inflate Behavior subclass ");
      paramAttributeSet.append((String)localObject);
      throw new RuntimeException(paramAttributeSet.toString(), paramContext);
    }
  }
  
  private static void a(int paramInt1, Rect paramRect1, Rect paramRect2, k paramk, int paramInt2, int paramInt3)
  {
    int i2 = paramk.c;
    int i1 = i2;
    if (i2 == 0) {
      i1 = 17;
    }
    int i3 = android.support.v4.view.k.a(i1, paramInt1);
    i1 = android.support.v4.view.k.a(c(paramk.a), paramInt1);
    switch (i1 & 0x7)
    {
    default: 
      paramInt1 = paramRect1.left;
    }
    for (;;)
    {
      switch (i1 & 0x70)
      {
      default: 
        i1 = paramRect1.top;
      }
      for (;;)
      {
        i2 = paramInt1;
        switch (i3 & 0x7)
        {
        }
        for (i2 = paramInt1 - paramInt2;; i2 = paramInt1 - paramInt2 / 2)
        {
          paramInt1 = i1;
          switch (i3 & 0x70)
          {
          }
          for (paramInt1 = i1 - paramInt3;; paramInt1 = i1 - paramInt3 / 2)
          {
            paramRect2.set(i2, paramInt1, i2 + paramInt2, paramInt1 + paramInt3);
            return;
          }
        }
        i1 = paramRect1.bottom;
        continue;
        i1 = paramRect1.top + paramRect1.height() / 2;
      }
      paramInt1 = paramRect1.right;
      continue;
      paramInt1 = paramRect1.left + paramRect1.width() / 2;
    }
  }
  
  private static void a(Rect paramRect)
  {
    paramRect.setEmpty();
    w.a(paramRect);
  }
  
  private final void a(k paramk, Rect paramRect, int paramInt1, int paramInt2)
  {
    int i2 = getWidth();
    int i1 = getHeight();
    i2 = Math.max(getPaddingLeft() + paramk.leftMargin, Math.min(paramRect.left, i2 - getPaddingRight() - paramInt1 - paramk.rightMargin));
    i1 = Math.max(getPaddingTop() + paramk.topMargin, Math.min(paramRect.top, i1 - getPaddingBottom() - paramInt2 - paramk.bottomMargin));
    paramRect.set(i2, i1, i2 + paramInt1, i1 + paramInt2);
  }
  
  private final void a(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((paramView.isLayoutRequested()) || (paramView.getVisibility() == 8))
    {
      paramRect.setEmpty();
      return;
    }
    if (!paramBoolean)
    {
      paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      return;
    }
    bd.a(this, paramView, paramRect);
  }
  
  private final void a(boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      h localh = ((k)localView.getLayoutParams()).i;
      MotionEvent localMotionEvent;
      if (localh != null)
      {
        long l1 = SystemClock.uptimeMillis();
        localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        if (!paramBoolean) {
          break label82;
        }
        localh.a(this, localView, localMotionEvent);
      }
      for (;;)
      {
        localMotionEvent.recycle();
        i1 += 1;
        break;
        label82:
        localh.b(this, localView, localMotionEvent);
      }
    }
    i1 = 0;
    while (i1 < i2)
    {
      ((k)getChildAt(i1).getLayoutParams()).k = false;
      i1 += 1;
    }
    this.j = null;
    this.l = false;
  }
  
  private final boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i3 = paramMotionEvent.getActionMasked();
    List localList = this.u;
    localList.clear();
    boolean bool1 = isChildrenDrawingOrderEnabled();
    int i4 = getChildCount();
    int i1 = i4 - 1;
    if (i1 < 0)
    {
      if (g != null) {
        Collections.sort(localList, g);
      }
      i4 = localList.size();
      bool1 = false;
      i1 = 0;
      MotionEvent localMotionEvent = null;
      i2 = 0;
      View localView;
      k localk;
      h localh;
      if (i2 < i4)
      {
        localView = (View)localList.get(i2);
        localk = (k)localView.getLayoutParams();
        localh = localk.i;
        if (!bool1) {
          break label402;
        }
        label117:
        if (i3 != 0) {
          break label314;
        }
      }
      for (;;)
      {
        label127:
        boolean bool3;
        boolean bool2;
        if (bool1)
        {
          if (localk.i == null) {
            localk.k = false;
          }
          bool3 = localk.k;
          if (!bool3)
          {
            localk.k = bool3;
            bool2 = bool3;
            label164:
            if (!bool2)
            {
              i1 = 0;
              label171:
              if (bool2) {}
            }
          }
        }
        label200:
        label314:
        do
        {
          for (;;)
          {
            i2 += 1;
            break;
            bool2 = bool1;
            if (i1 == 0) {
              break label200;
            }
          }
          bool2 = bool1;
          localList.clear();
          return bool2;
          if (!bool3)
          {
            i1 = 1;
            break label171;
          }
          i1 = 0;
          break label171;
          bool2 = true;
          break label164;
          if (localh == null) {
            break label127;
          }
          switch (paramInt)
          {
          default: 
            bool2 = bool1;
          }
          for (;;)
          {
            bool1 = bool2;
            if (!bool2) {
              break;
            }
            this.j = localView;
            bool1 = bool2;
            break;
            bool2 = localh.a(this, localView, paramMotionEvent);
            continue;
            bool2 = localh.b(this, localView, paramMotionEvent);
          }
        } while (localh == null);
        if (localMotionEvent == null)
        {
          long l1 = SystemClock.uptimeMillis();
          localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        }
        for (;;)
        {
          switch (paramInt)
          {
          default: 
            break;
          case 0: 
            localh.a(this, localView, localMotionEvent);
            break;
          case 1: 
            localh.b(this, localView, localMotionEvent);
            break;
          }
        }
        label402:
        if (i1 != 0) {
          break label117;
        }
      }
    }
    if (bool1) {}
    for (int i2 = getChildDrawingOrder(i4, i1);; i2 = i1)
    {
      localList.add(getChildAt(i2));
      i1 -= 1;
      break;
    }
  }
  
  private final int b(int paramInt)
  {
    Object localObject = this.n;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No keylines defined for ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" - attempted index lookup ");
      ((StringBuilder)localObject).append(paramInt);
      Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= localObject.length))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Keyline index ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" out of range for ");
      ((StringBuilder)localObject).append(this);
      Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
      return 0;
    }
    return localObject[paramInt];
  }
  
  private final void b()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (ac.y(this))
      {
        if (this.i == null) {
          this.i = new f(this);
        }
        ac.a(this, this.i);
        setSystemUiVisibility(1280);
      }
    }
    else {
      return;
    }
    ac.a(this, null);
  }
  
  private static int c(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      paramInt = 0x800003 | paramInt;
    }
    for (;;)
    {
      int i1 = paramInt;
      if ((paramInt & 0x70) == 0) {
        i1 = paramInt | 0x30;
      }
      return i1;
    }
  }
  
  private static k c(View paramView)
  {
    k localk = (k)paramView.getLayoutParams();
    if (!localk.j)
    {
      if ((paramView instanceof g))
      {
        paramView = ((g)paramView).a();
        if (paramView == null) {
          Log.e("CoordinatorLayout", "Attached behavior class is null");
        }
        localk.a(paramView);
        localk.j = true;
      }
    }
    else {
      return localk;
    }
    Class localClass = paramView.getClass();
    paramView = null;
    while (localClass != null)
    {
      paramView = (i)localClass.getAnnotation(i.class);
      if (paramView != null) {
        break label192;
      }
      localClass = localClass.getSuperclass();
    }
    label192:
    for (;;)
    {
      if (paramView != null) {}
      try
      {
        localk.a((h)paramView.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        localk.j = true;
        return localk;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Default behavior class ");
          localStringBuilder.append(paramView.a().getName());
          localStringBuilder.append(" could not be instantiated. Did you forget");
          localStringBuilder.append(" a default constructor?");
          Log.e("CoordinatorLayout", localStringBuilder.toString(), localException);
        }
      }
    }
  }
  
  private static void c(View paramView, int paramInt)
  {
    k localk = (k)paramView.getLayoutParams();
    int i1 = localk.m;
    if (i1 != paramInt)
    {
      ac.f(paramView, paramInt - i1);
      localk.m = paramInt;
    }
  }
  
  private static int d(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = 8388661;
    }
    return i1;
  }
  
  private static void d(View paramView, int paramInt)
  {
    k localk = (k)paramView.getLayoutParams();
    int i1 = localk.n;
    if (i1 != paramInt)
    {
      ac.e(paramView, paramInt - i1);
      localk.n = paramInt;
    }
  }
  
  final void a(int paramInt)
  {
    int i4 = ac.h(this);
    int i5 = this.k.size();
    Object localObject1 = a();
    Rect localRect1 = a();
    Rect localRect2 = a();
    int i3 = 0;
    while (i3 < i5)
    {
      View localView = (View)this.k.get(i3);
      Object localObject2 = (k)localView.getLayoutParams();
      int i1;
      if (paramInt == 0)
      {
        if (localView.getVisibility() == 8) {
          i3 += 1;
        } else {
          i1 = 0;
        }
      }
      else {
        for (;;)
        {
          Object localObject3;
          Object localObject4;
          Object localObject5;
          int i6;
          int i7;
          int i2;
          if (i1 < i3)
          {
            localObject3 = (View)this.k.get(i1);
            Rect localRect3;
            if (((k)localObject2).f == localObject3)
            {
              localObject3 = (k)localView.getLayoutParams();
              if (((k)localObject3).h != null)
              {
                localObject4 = a();
                localObject5 = a();
                localRect3 = a();
                bd.a(this, ((k)localObject3).h, (Rect)localObject4);
                a(localView, false, (Rect)localObject5);
                i6 = localView.getMeasuredWidth();
                i7 = localView.getMeasuredHeight();
                a(i4, (Rect)localObject4, localRect3, (k)localObject3, i6, i7);
                if (localRect3.left != ((Rect)localObject5).left) {
                  break label356;
                }
                if (localRect3.top != ((Rect)localObject5).top) {
                  break label351;
                }
                i2 = 0;
              }
            }
            for (;;)
            {
              a((k)localObject3, localRect3, i6, i7);
              i6 = localRect3.left - ((Rect)localObject5).left;
              i7 = localRect3.top - ((Rect)localObject5).top;
              if (i6 != 0) {
                ac.f(localView, i6);
              }
              if (i7 != 0) {
                ac.e(localView, i7);
              }
              if (i2 == 0) {}
              for (;;)
              {
                a((Rect)localObject4);
                a((Rect)localObject5);
                a(localRect3);
                i1 += 1;
                break;
                h localh = ((k)localObject3).i;
                if (localh != null) {
                  localh.a(this, localView, ((k)localObject3).h);
                }
              }
              label351:
              i2 = 1;
              continue;
              label356:
              i2 = 1;
            }
          }
          a(localView, true, localRect1);
          if ((((k)localObject2).d != 0) && (!localRect1.isEmpty()))
          {
            i1 = android.support.v4.view.k.a(((k)localObject2).d, i4);
            switch (i1 & 0x70)
            {
            }
          }
          for (;;)
          {
            switch (i1 & 0x7)
            {
            }
            for (;;)
            {
              if (((k)localObject2).b == 0) {}
              for (;;)
              {
                if (paramInt != 2)
                {
                  localRect2.set(((k)localView.getLayoutParams()).o);
                  if (localRect2.equals(localRect1)) {
                    break;
                  }
                  ((k)localView.getLayoutParams()).o.set(localRect1);
                }
                i1 = i3 + 1;
                if (i1 >= i5) {
                  break;
                }
                localObject2 = (View)this.k.get(i1);
                localObject3 = (k)((View)localObject2).getLayoutParams();
                localObject4 = ((k)localObject3).i;
                if (localObject4 == null) {}
                for (;;)
                {
                  i1 += 1;
                  break;
                  if (((h)localObject4).a_(localView))
                  {
                    if ((paramInt != 0) || (!((k)localObject3).l)) {
                      break label601;
                    }
                    ((k)localObject3).l = false;
                  }
                }
                label601:
                switch (paramInt)
                {
                }
                for (boolean bool = ((h)localObject4).a(this, (View)localObject2, localView); paramInt == 1; bool = true)
                {
                  ((k)localObject3).l = bool;
                  break;
                }
                if ((localView.getVisibility() == 0) && (ac.I(localView)) && (localView.getWidth() > 0) && (localView.getHeight() > 0))
                {
                  localObject4 = (k)localView.getLayoutParams();
                  localObject5 = ((k)localObject4).i;
                  localObject2 = a();
                  localObject3 = a();
                  ((Rect)localObject3).set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
                  if ((localObject5 != null) && (((h)localObject5).a(localView, (Rect)localObject2)))
                  {
                    if (!((Rect)localObject3).contains((Rect)localObject2))
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append("Rect should be within the child's bounds. Rect:");
                      ((StringBuilder)localObject1).append(((Rect)localObject2).toShortString());
                      ((StringBuilder)localObject1).append(" | Bounds:");
                      ((StringBuilder)localObject1).append(((Rect)localObject3).toShortString());
                      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                    }
                  }
                  else {
                    ((Rect)localObject2).set((Rect)localObject3);
                  }
                  a((Rect)localObject3);
                  if (!((Rect)localObject2).isEmpty()) {
                    break label854;
                  }
                  a((Rect)localObject2);
                }
              }
              label854:
              i2 = android.support.v4.view.k.a(((k)localObject4).b, i4);
              if ((i2 & 0x30) == 48)
              {
                i1 = ((Rect)localObject2).top - ((k)localObject4).topMargin - ((k)localObject4).n;
                if (i1 < ((Rect)localObject1).top)
                {
                  d(localView, ((Rect)localObject1).top - i1);
                  i1 = 1;
                }
              }
              for (;;)
              {
                if ((i2 & 0x50) == 80)
                {
                  i6 = getHeight() - ((Rect)localObject2).bottom - ((k)localObject4).bottomMargin + ((k)localObject4).n;
                  if (i6 < ((Rect)localObject1).bottom) {
                    d(localView, i6 - ((Rect)localObject1).bottom);
                  }
                }
                for (;;)
                {
                  if ((i2 & 0x3) == 3)
                  {
                    i1 = ((Rect)localObject2).left - ((k)localObject4).leftMargin - ((k)localObject4).m;
                    if (i1 < ((Rect)localObject1).left)
                    {
                      c(localView, ((Rect)localObject1).left - i1);
                      i1 = 1;
                    }
                  }
                  for (;;)
                  {
                    if ((i2 & 0x5) == 5)
                    {
                      i2 = getWidth();
                      i6 = ((Rect)localObject2).right;
                      i7 = ((k)localObject4).rightMargin;
                      i2 = ((k)localObject4).m + (i2 - i6 - i7);
                      if (i2 < ((Rect)localObject1).right) {
                        c(localView, i2 - ((Rect)localObject1).right);
                      }
                    }
                    for (;;)
                    {
                      a((Rect)localObject2);
                      break;
                      if (i1 == 0) {
                        c(localView, 0);
                      }
                    }
                    i1 = 0;
                    continue;
                    i1 = 0;
                  }
                  if (i1 == 0) {
                    d(localView, 0);
                  }
                }
                i1 = 0;
                continue;
                i1 = 0;
              }
              ((Rect)localObject1).right = Math.max(((Rect)localObject1).right, getWidth() - localRect1.left);
              continue;
              ((Rect)localObject1).left = Math.max(((Rect)localObject1).left, localRect1.right);
            }
            ((Rect)localObject1).bottom = Math.max(((Rect)localObject1).bottom, getHeight() - localRect1.top);
            continue;
            ((Rect)localObject1).top = Math.max(((Rect)localObject1).top, localRect1.bottom);
          }
          i1 = 0;
        }
      }
    }
    a((Rect)localObject1);
    a(localRect1);
    a(localRect2);
  }
  
  public final void a(View paramView)
  {
    List localList = this.a.b(paramView);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i1 = 0;
      if (i1 < localList.size())
      {
        View localView = (View)localList.get(i1);
        h localh = ((k)localView.getLayoutParams()).i;
        if (localh == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localh.a(this, localView, paramView);
        }
      }
    }
  }
  
  public final void a(View paramView, int paramInt)
  {
    localObject1 = (k)paramView.getLayoutParams();
    Object localObject2 = ((k)localObject1).h;
    if ((localObject2 == null) && (((k)localObject1).g != -1)) {
      throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }
    if (localObject2 != null)
    {
      localObject1 = a();
      localRect = a();
    }
    try
    {
      bd.a(this, (View)localObject2, (Rect)localObject1);
      localObject2 = (k)paramView.getLayoutParams();
      i1 = paramView.getMeasuredWidth();
      i2 = paramView.getMeasuredHeight();
      a(paramInt, (Rect)localObject1, localRect, (k)localObject2, i1, i2);
      a((k)localObject2, localRect, i1, i2);
      paramView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
      return;
    }
    finally
    {
      int i1;
      int i2;
      int i3;
      int i7;
      int i6;
      int i5;
      int i4;
      a((Rect)localObject1);
      a(localRect);
    }
    i3 = ((k)localObject1).e;
    if (i3 >= 0)
    {
      localObject1 = (k)paramView.getLayoutParams();
      i7 = android.support.v4.view.k.a(d(((k)localObject1).c), paramInt);
      i6 = getWidth();
      i5 = getHeight();
      i4 = paramView.getMeasuredWidth();
      i2 = paramView.getMeasuredHeight();
      i1 = i3;
      if (paramInt == 1) {
        i1 = i6 - i3;
      }
      paramInt = b(i1) - i4;
      switch (i7 & 0x7)
      {
      }
      for (;;)
      {
        switch (i7 & 0x70)
        {
        default: 
          i1 = 0;
        }
        for (;;)
        {
          paramInt = Math.max(getPaddingLeft() + ((k)localObject1).leftMargin, Math.min(paramInt, i6 - getPaddingRight() - i4 - ((k)localObject1).rightMargin));
          i1 = Math.max(getPaddingTop() + ((k)localObject1).topMargin, Math.min(i1, i5 - getPaddingBottom() - i2 - ((k)localObject1).bottomMargin));
          paramView.layout(paramInt, i1, paramInt + i4, i2 + i1);
          return;
          i1 = i2 / 2;
          continue;
          i1 = i2;
        }
        paramInt += i4 / 2;
        continue;
        paramInt += i4;
      }
    }
    localObject1 = (k)paramView.getLayoutParams();
    localRect = a();
    localRect.set(getPaddingLeft() + ((k)localObject1).leftMargin, getPaddingTop() + ((k)localObject1).topMargin, getWidth() - getPaddingRight() - ((k)localObject1).rightMargin, getHeight() - getPaddingBottom() - ((k)localObject1).bottomMargin);
    if ((this.c != null) && (ac.y(this)) && (!ac.y(paramView)))
    {
      localRect.left += this.c.a();
      localRect.top += this.c.b();
      localRect.right -= this.c.c();
      localRect.bottom -= this.c.d();
    }
    localObject2 = a();
    android.support.v4.view.k.a(c(((k)localObject1).c), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, (Rect)localObject2, paramInt);
    paramView.layout(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom);
    a(localRect);
    a((Rect)localObject2);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i1 = getChildCount();
    paramInt1 = 0;
    paramInt3 = 0;
    if (paramInt3 < i1)
    {
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        Object localObject = (k)localView.getLayoutParams();
        if (((k)localObject).a(paramInt5))
        {
          localObject = ((k)localObject).i;
          if (localObject != null)
          {
            ((h)localObject).a(this, localView, paramView, paramInt2, paramInt4, paramInt5);
            paramInt1 = 1;
          }
        }
      }
      for (;;)
      {
        paramInt3 += 1;
        break;
        continue;
      }
    }
    if (paramInt1 != 0) {
      a(1);
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i6 = getChildCount();
    int i2 = 0;
    int i1 = 0;
    int i3 = 0;
    int i4 = 0;
    if (i4 < i6)
    {
      View localView = getChildAt(i4);
      Object localObject;
      int i5;
      if (localView.getVisibility() != 8)
      {
        localObject = (k)localView.getLayoutParams();
        if (!((k)localObject).a(paramInt3))
        {
          i5 = i3;
          i3 = i2;
          i2 = i1;
          i1 = i5;
        }
      }
      for (;;)
      {
        i5 = i4 + 1;
        i4 = i3;
        i3 = i1;
        i1 = i2;
        i2 = i4;
        i4 = i5;
        break;
        localObject = ((k)localObject).i;
        if (localObject != null)
        {
          int[] arrayOfInt = this.t;
          arrayOfInt[1] = 0;
          arrayOfInt[0] = 0;
          ((h)localObject).a(this, localView, paramView, paramInt2, arrayOfInt, paramInt3);
          if (paramInt1 <= 0) {}
          for (i3 = Math.min(i2, this.t[0]);; i3 = Math.max(i2, this.t[0]))
          {
            if (paramInt2 <= 0) {}
            for (i1 = Math.min(i1, this.t[1]);; i1 = Math.max(i1, this.t[1]))
            {
              i2 = i1;
              i1 = 1;
              break;
            }
          }
        }
        i5 = i3;
        i3 = i2;
        i2 = i1;
        i1 = i5;
        continue;
        i5 = i3;
        i3 = i2;
        i2 = i1;
        i1 = i5;
      }
    }
    paramArrayOfInt[0] = i2;
    paramArrayOfInt[1] = i1;
    if (i3 != 0) {
      a(1);
    }
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = a();
    bd.a(this, paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      return bool;
    }
    finally
    {
      a(localRect);
    }
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    int i2 = getChildCount();
    boolean bool1 = false;
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      k localk;
      if (localView.getVisibility() != 8)
      {
        localk = (k)localView.getLayoutParams();
        h localh = localk.i;
        if (localh != null)
        {
          boolean bool2 = localh.a(this, localView, paramView1, paramView2, paramInt1, paramInt2);
          bool1 |= bool2;
          localk.a(paramInt2, bool2);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        localk.a(paramInt2, false);
      }
    }
    return (byte)bool1;
  }
  
  public final List b(View paramView)
  {
    q localq = this.a;
    int i2 = localq.a.size();
    Object localObject1 = null;
    int i1 = 0;
    while (i1 < i2)
    {
      ArrayList localArrayList = (ArrayList)localq.a.c(i1);
      Object localObject2 = localObject1;
      if (localArrayList != null)
      {
        if (!localArrayList.contains(paramView)) {
          localObject2 = localObject1;
        }
      }
      else
      {
        i1 += 1;
        localObject1 = localObject2;
        continue;
      }
      if (localObject1 == null) {
        localObject1 = new ArrayList();
      }
      for (;;)
      {
        ((ArrayList)localObject1).add(localq.a.b(i1));
        localObject2 = localObject1;
        break;
      }
    }
    this.e.clear();
    if (localObject1 != null) {
      this.e.addAll((Collection)localObject1);
    }
    return this.e;
  }
  
  public final void b(View paramView, int paramInt)
  {
    this.p.a = 0;
    int i2 = getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      k localk = (k)localView.getLayoutParams();
      if (!localk.a(paramInt)) {}
      for (;;)
      {
        i1 += 1;
        break;
        h localh = localk.i;
        if (localh != null) {
          localh.a(this, localView, paramView, paramInt);
        }
        localk.a(paramInt, false);
        localk.l = false;
      }
    }
    this.q = null;
  }
  
  public final void b(View paramView, int paramInt1, int paramInt2)
  {
    this.p.a = paramInt1;
    this.q = paramView;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      getChildAt(paramInt1).getLayoutParams();
      paramInt1 += 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof k)) && (super.checkLayoutParams(paramLayoutParams));
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
    Drawable localDrawable = this.s;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(arrayOfInt))) {
      invalidate();
    }
  }
  
  public final bf getLastWindowInsets()
  {
    return this.c;
  }
  
  public int getNestedScrollAxes()
  {
    return this.p.a;
  }
  
  public Drawable getStatusBarBackground()
  {
    return this.s;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(false);
    if (this.o)
    {
      if (this.r == null) {
        this.r = new l(this);
      }
      getViewTreeObserver().addOnPreDrawListener(this.r);
    }
    if ((this.c == null) && (ac.y(this))) {
      ac.x(this);
    }
    this.m = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a(false);
    if ((this.o) && (this.r != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.r);
    }
    View localView = this.q;
    if (localView != null) {
      onStopNestedScroll(localView);
    }
    this.m = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    bf localbf;
    if ((this.b) && (this.s != null))
    {
      localbf = this.c;
      if (localbf == null) {
        break label60;
      }
    }
    label60:
    for (int i1 = localbf.b();; i1 = 0)
    {
      if (i1 > 0)
      {
        this.s.setBounds(0, 0, getWidth(), i1);
        this.s.draw(paramCanvas);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0) {
      a(true);
    }
    boolean bool = a(paramMotionEvent, 0);
    if ((i1 == 1) || (i1 == 3)) {
      a(true);
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = ac.h(this);
    paramInt3 = this.k.size();
    paramInt1 = 0;
    if (paramInt1 < paramInt3)
    {
      View localView = (View)this.k.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        h localh = ((k)localView.getLayoutParams()).i;
        if ((localh == null) || (!localh.a(this, localView, paramInt2))) {
          break label86;
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label86:
        a(localView, paramInt2);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.k.clear();
    Object localObject1 = this.a;
    int i2 = ((q)localObject1).a.size();
    int i1 = 0;
    Object localObject3;
    label414:
    label425:
    label702:
    k localk;
    for (;;)
    {
      if (i1 >= i2)
      {
        ((q)localObject1).a.clear();
        int i3 = getChildCount();
        i1 = 0;
        int i4;
        int i5;
        for (;;)
        {
          if (i1 >= i3)
          {
            localObject1 = this.k;
            localObject2 = this.a;
            ((q)localObject2).c.clear();
            ((q)localObject2).d.clear();
            i2 = ((q)localObject2).a.size();
            i1 = 0;
            while (i1 < i2)
            {
              ((q)localObject2).a(((q)localObject2).a.b(i1), ((q)localObject2).c, ((q)localObject2).d);
              i1 += 1;
            }
            ((List)localObject1).addAll(((q)localObject2).c);
            Collections.reverse(this.k);
            i3 = getChildCount();
            i1 = 0;
            if (i1 < i3)
            {
              localObject1 = getChildAt(i1);
              localObject2 = this.a;
              i4 = ((q)localObject2).a.size();
              i2 = 0;
              if (i2 < i4)
              {
                localObject3 = (ArrayList)((q)localObject2).a.c(i2);
                if (localObject3 == null) {}
                while (!((ArrayList)localObject3).contains(localObject1))
                {
                  i2 += 1;
                  break;
                }
              }
            }
            for (int i22 = 1;; i22 = 0)
            {
              if (i22 == this.o) {}
              for (;;)
              {
                int i10 = getPaddingLeft();
                int i11 = getPaddingTop();
                int i12 = getPaddingRight();
                int i13 = getPaddingBottom();
                int i14 = ac.h(this);
                if (i14 != 1) {}
                for (int i8 = 0;; i8 = 1)
                {
                  int i15 = View.MeasureSpec.getMode(paramInt1);
                  int i16 = View.MeasureSpec.getSize(paramInt1);
                  int i17 = View.MeasureSpec.getMode(paramInt2);
                  int i18 = View.MeasureSpec.getSize(paramInt2);
                  i5 = getSuggestedMinimumWidth();
                  i4 = getSuggestedMinimumHeight();
                  if (this.c != null) {
                    if (ac.y(this)) {
                      i2 = 1;
                    }
                  }
                  for (;;)
                  {
                    int i19 = this.k.size();
                    i3 = 0;
                    int i9 = 0;
                    if (i9 < i19)
                    {
                      localObject1 = (View)this.k.get(i9);
                      int i7;
                      int i6;
                      if (((View)localObject1).getVisibility() != 8)
                      {
                        localObject2 = (k)((View)localObject1).getLayoutParams();
                        i1 = ((k)localObject2).e;
                        if (i1 < 0)
                        {
                          i1 = 0;
                          if (i2 == 0)
                          {
                            i7 = paramInt2;
                            i6 = paramInt1;
                            localObject3 = ((k)localObject2).i;
                            if ((localObject3 == null) || (!((h)localObject3).a(this, (View)localObject1, i6, i1, i7, 0))) {
                              a((View)localObject1, i6, i1, i7, 0);
                            }
                            i1 = Math.max(i5, ((View)localObject1).getMeasuredWidth() + (i10 + i12) + ((k)localObject2).leftMargin + ((k)localObject2).rightMargin);
                            i4 = Math.max(i4, ((View)localObject1).getMeasuredHeight() + (i11 + i13) + ((k)localObject2).topMargin + ((k)localObject2).bottomMargin);
                            i5 = View.combineMeasuredStates(i3, ((View)localObject1).getMeasuredState());
                            i3 = i4;
                            i4 = i5;
                          }
                        }
                      }
                      for (;;)
                      {
                        i9 += 1;
                        i5 = i3;
                        i3 = i4;
                        i4 = i5;
                        i5 = i1;
                        break;
                        if (!ac.y((View)localObject1))
                        {
                          i6 = this.c.a();
                          int i21 = this.c.c();
                          i7 = this.c.b();
                          int i20 = this.c.d();
                          i6 = View.MeasureSpec.makeMeasureSpec(i16 - (i6 + i21), i15);
                          i7 = View.MeasureSpec.makeMeasureSpec(i18 - (i7 + i20), i17);
                          break label425;
                        }
                        i7 = paramInt2;
                        i6 = paramInt1;
                        break label425;
                        if (i15 != 0)
                        {
                          i1 = b(i1);
                          i6 = android.support.v4.view.k.a(d(((k)localObject2).c), i14) & 0x7;
                          if (i6 != 3) {}
                          for (;;)
                          {
                            if (i6 != 5) {}
                            while (i8 == 0)
                            {
                              if (i6 != 5)
                              {
                                if (i6 != 3)
                                {
                                  i1 = 0;
                                  break;
                                }
                                if (i14 != 1) {}
                              }
                              for (;;)
                              {
                                i1 = Math.max(0, i1 - i10);
                                break;
                                i1 = 0;
                                break;
                                if (i14 == 1) {
                                  break label702;
                                }
                              }
                            }
                            do
                            {
                              i1 = Math.max(0, i16 - i12 - i1);
                              break;
                            } while (i8 == 0);
                          }
                        }
                        i1 = 0;
                        break label414;
                        i1 = i4;
                        i4 = i3;
                        i3 = i1;
                        i1 = i5;
                      }
                    }
                    setMeasuredDimension(View.resolveSizeAndState(i5, paramInt1, 0xFF000000 & i3), View.resolveSizeAndState(i4, paramInt2, i3 << 16));
                    return;
                    i2 = 0;
                    continue;
                    i2 = 0;
                  }
                }
                if (i22 == 0)
                {
                  if ((this.m) && (this.r != null)) {
                    getViewTreeObserver().removeOnPreDrawListener(this.r);
                  }
                  this.o = false;
                }
                else
                {
                  if (this.m)
                  {
                    if (this.r == null) {
                      this.r = new l(this);
                    }
                    getViewTreeObserver().addOnPreDrawListener(this.r);
                  }
                  this.o = true;
                }
              }
              i1 += 1;
              break;
            }
          }
          localObject3 = getChildAt(i1);
          localk = c((View)localObject3);
          if (localk.g != -1) {
            break label1250;
          }
          localk.f = null;
          localk.h = null;
          this.a.a(localObject3);
          i2 = 0;
          if (i2 < i3) {
            break;
          }
          i1 += 1;
        }
        View localView;
        if (i2 != i1)
        {
          localView = getChildAt(i2);
          if (localView == localk.f) {
            break label1099;
          }
          i4 = ac.h(this);
          i5 = android.support.v4.view.k.a(((k)localView.getLayoutParams()).d, i4);
          if ((i5 != 0) && ((android.support.v4.view.k.a(localk.b, i4) & i5) == i5)) {
            break label1099;
          }
          localObject1 = localk.i;
          if (localObject1 != null) {
            break label1089;
          }
        }
        label1089:
        while (!((h)localObject1).a_(localView))
        {
          i2 += 1;
          break;
        }
        label1099:
        if (this.a.a.containsKey(localView)) {}
        for (;;)
        {
          q localq = this.a;
          if ((!localq.a.containsKey(localView)) || (!localq.a.containsKey(localObject3))) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
          }
          localObject2 = (ArrayList)localq.a.get(localView);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = (ArrayList)localq.b.a();
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new ArrayList();
            }
            localq.a.put(localView, localObject1);
          }
          ((ArrayList)localObject1).add(localObject3);
          break;
          this.a.a(localView);
        }
        label1250:
        localObject1 = localk.h;
        if (localObject1 == null) {}
        label1378:
        while (((View)localObject1).getId() != localk.g)
        {
          localk.h = findViewById(localk.g);
          localObject2 = localk.h;
          if (localObject2 == null)
          {
            if (!isInEditMode()) {
              break label1563;
            }
            localk.f = null;
            localk.h = null;
            break;
          }
          if (localObject2 != this)
          {
            for (localObject1 = ((View)localObject2).getParent();; localObject1 = ((ViewParent)localObject1).getParent())
            {
              if (localObject1 == this) {}
              while (localObject1 == null)
              {
                localk.f = ((View)localObject2);
                break;
              }
              if (localObject1 == localObject3) {
                break label1378;
              }
              if ((localObject1 instanceof View)) {
                localObject2 = (View)localObject1;
              }
            }
            if (!isInEditMode()) {
              break label1629;
            }
            localk.f = null;
            localk.h = null;
            break;
          }
          if (!isInEditMode()) {
            break label1640;
          }
          localk.f = null;
          localk.h = null;
          break;
        }
        localObject2 = localk.h;
        for (localObject1 = ((View)localObject2).getParent();; localObject1 = ((ViewParent)localObject1).getParent())
        {
          if (localObject1 == this)
          {
            localk.f = ((View)localObject2);
            break;
          }
          if (localObject1 == null) {}
          while (localObject1 == localObject3)
          {
            localk.f = null;
            localk.h = null;
            break;
          }
          if ((localObject1 instanceof View)) {
            localObject2 = (View)localObject1;
          }
        }
      }
      Object localObject2 = (ArrayList)((q)localObject1).a.c(i1);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).clear();
        ((q)localObject1).b.a(localObject2);
      }
      i1 += 1;
    }
    label1563:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Could not find CoordinatorLayout descendant view with id ");
    ((StringBuilder)localObject1).append(getResources().getResourceName(localk.g));
    ((StringBuilder)localObject1).append(" to anchor view ");
    ((StringBuilder)localObject1).append(localObject3);
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
    label1629:
    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
    label1640:
    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      paramView = getChildAt(i1);
      if (paramView.getVisibility() == 8) {}
      for (;;)
      {
        i1 += 1;
        break;
        paramView.getLayoutParams();
      }
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int i2 = getChildCount();
    int i1 = 0;
    boolean bool = false;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 8)
      {
        Object localObject = (k)localView.getLayoutParams();
        if (((k)localObject).a(0))
        {
          localObject = ((k)localObject).i;
          if (localObject != null) {
            bool = ((h)localObject).a(this, localView, paramView, paramFloat1, paramFloat2) | bool;
          }
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        continue;
      }
    }
    return (byte)bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    b(paramView2, paramInt, 0);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof CoordinatorLayout.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (CoordinatorLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.e);
    paramParcelable = paramParcelable.a;
    int i2 = getChildCount();
    int i1 = 0;
    label38:
    View localView;
    int i3;
    h localh;
    if (i1 < i2)
    {
      localView = getChildAt(i1);
      i3 = localView.getId();
      localh = c(localView).i;
      if (i3 != -1) {
        break label80;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label38;
      break;
      label80:
      if (localh != null)
      {
        Parcelable localParcelable = (Parcelable)paramParcelable.get(i3);
        if (localParcelable != null) {
          localh.a(this, localView, localParcelable);
        }
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    CoordinatorLayout.SavedState localSavedState = new CoordinatorLayout.SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int i2 = getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = getChildAt(i1);
      int i3 = ((View)localObject).getId();
      h localh = ((k)((View)localObject).getLayoutParams()).i;
      if (i3 == -1) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (localh != null)
        {
          localObject = localh.b(this, (View)localObject);
          if (localObject != null) {
            localSparseArray.append(i3, localObject);
          }
        }
      }
    }
    localSavedState.a = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return a(paramView1, paramView2, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    b(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool2;
    if (this.j == null)
    {
      bool2 = a(paramMotionEvent, 1);
      if (bool2) {
        break label164;
      }
      bool1 = false;
      if (this.j == null)
      {
        bool1 |= super.onTouchEvent(paramMotionEvent);
        paramMotionEvent = null;
      }
      for (;;)
      {
        if (paramMotionEvent != null) {
          paramMotionEvent.recycle();
        }
        if (i1 == 1) {}
        for (;;)
        {
          a(false);
          do
          {
            return bool1;
          } while (i1 != 3);
        }
        if (bool2)
        {
          long l1 = SystemClock.uptimeMillis();
          paramMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
          super.onTouchEvent(paramMotionEvent);
        }
        else
        {
          paramMotionEvent = null;
        }
      }
    }
    label164:
    for (boolean bool1 = false;; bool1 = bool2)
    {
      h localh = ((k)this.j.getLayoutParams()).i;
      if (localh != null)
      {
        bool3 = localh.b(this, this.j, paramMotionEvent);
        bool2 = bool1;
        bool1 = bool3;
        break;
      }
      boolean bool3 = false;
      bool2 = bool1;
      bool1 = bool3;
      break;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    h localh = ((k)paramView.getLayoutParams()).i;
    if ((localh == null) || (!localh.a(this, paramView, paramRect, paramBoolean))) {
      return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
    }
    return true;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.l))
    {
      a(false);
      this.l = true;
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    b();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.d = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable1 = null;
    Drawable localDrawable2 = this.s;
    if (localDrawable2 != paramDrawable)
    {
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.s = localDrawable1;
      paramDrawable = this.s;
      if (paramDrawable != null)
      {
        if (paramDrawable.isStateful()) {
          this.s.setState(getDrawableState());
        }
        android.support.v4.a.a.a.b(this.s, ac.h(this));
        paramDrawable = this.s;
        if (getVisibility() != 0) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      paramDrawable.setVisible(bool, false);
      this.s.setCallback(this);
      ac.e(this);
      return;
    }
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    setStatusBarBackground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = d.a(getContext(), paramInt);; localDrawable = null)
    {
      setStatusBarBackground(localDrawable);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Drawable localDrawable = this.s;
      if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
        this.s.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.s);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/widget/CoordinatorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */