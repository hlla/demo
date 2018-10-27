package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.a;
import android.support.v4.view.a.e;
import android.support.v4.view.b;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import java.util.ArrayList;
import java.util.List;

public abstract class ab
  extends b
{
  private static final Rect f = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
  public int b = Integer.MIN_VALUE;
  public final View c;
  public int d = Integer.MIN_VALUE;
  public final AccessibilityManager e;
  private int g = Integer.MIN_VALUE;
  private ae h;
  private final int[] i = new int[2];
  private final Rect j = new Rect();
  private final Rect k = new Rect();
  private final Rect l = new Rect();
  
  static
  {
    new ac();
    new ad();
  }
  
  public ab(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("View may not be null");
    }
    this.c = paramView;
    this.e = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
    paramView.setFocusable(true);
    if (android.support.v4.view.ac.f(paramView) == 0) {
      android.support.v4.view.ac.b(paramView, 1);
    }
  }
  
  private final void d(int paramInt)
  {
    int m = this.g;
    if (m != paramInt)
    {
      this.g = paramInt;
      a(paramInt, 128);
      a(m, 256);
    }
  }
  
  public abstract int a(float paramFloat1, float paramFloat2);
  
  final a a(int paramInt)
  {
    Object localObject2;
    int m;
    Object localObject1;
    label490:
    label493:
    View localView;
    if (paramInt != -1)
    {
      localObject2 = a.a(AccessibilityNodeInfo.obtain());
      ((a)localObject2).i(true);
      ((a)localObject2).c(true);
      ((a)localObject2).b("android.view.View");
      ((a)localObject2).b(f);
      ((a)localObject2).d(f);
      ((a)localObject2).a(this.c);
      a(paramInt, (a)localObject2);
      if ((((a)localObject2).a.getText() != null) || (((a)localObject2).a.getContentDescription() != null))
      {
        ((a)localObject2).a(this.j);
        if (this.j.equals(f)) {
          throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        m = ((a)localObject2).a.getActions();
        if ((m & 0x40) != 0) {
          throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((m & 0x80) != 0) {
          break label770;
        }
        ((a)localObject2).a(this.c.getContext().getPackageName());
        localObject1 = this.c;
        ((a)localObject2).a.setSource((View)localObject1, paramInt);
        if (this.b == paramInt)
        {
          ((a)localObject2).f(true);
          ((a)localObject2).a(128);
        }
        for (;;)
        {
          if (this.d == paramInt) {}
          for (boolean bool = true;; bool = false)
          {
            if (!bool) {
              if (((a)localObject2).a.isFocusable()) {}
            }
            for (;;)
            {
              ((a)localObject2).d(bool);
              this.c.getLocationOnScreen(this.i);
              ((a)localObject2).c(this.k);
              if (this.k.equals(f))
              {
                ((a)localObject2).a(this.k);
                if (((a)localObject2).b != -1) {
                  break label493;
                }
              }
              for (;;)
              {
                this.k.offset(this.i[0] - this.c.getScrollX(), this.i[1] - this.c.getScrollY());
                if (this.c.getLocalVisibleRect(this.l))
                {
                  this.l.offset(this.i[0] - this.c.getScrollX(), this.i[1] - this.c.getScrollY());
                  if (this.k.intersect(this.l))
                  {
                    ((a)localObject2).d(this.k);
                    localObject1 = this.k;
                    if ((localObject1 != null) && (!((Rect)localObject1).isEmpty()) && (this.c.getWindowVisibility() == 0))
                    {
                      for (localObject1 = this.c.getParent(); (localObject1 instanceof View); localObject1 = ((View)localObject1).getParent())
                      {
                        localObject1 = (View)localObject1;
                        if ((((View)localObject1).getAlpha() <= 0.0F) || (((View)localObject1).getVisibility() != 0)) {
                          break label490;
                        }
                      }
                      if (localObject1 != null) {
                        ((a)localObject2).e(true);
                      }
                    }
                  }
                }
                return (a)localObject2;
                localObject1 = a.a(AccessibilityNodeInfo.obtain());
                for (paramInt = ((a)localObject2).b; paramInt != -1; paramInt = ((a)localObject1).b)
                {
                  localView = this.c;
                  ((a)localObject1).b = -1;
                  ((a)localObject1).a.setParent(localView, -1);
                  ((a)localObject1).b(f);
                  a(paramInt, (a)localObject1);
                  ((a)localObject1).a(this.j);
                  this.k.offset(this.j.left, this.j.top);
                }
                ((a)localObject1).a.recycle();
              }
              ((a)localObject2).a(1);
              continue;
              ((a)localObject2).a(2);
            }
          }
          ((a)localObject2).f(false);
          ((a)localObject2).a(64);
        }
      }
    }
    else
    {
      localObject1 = a.a(AccessibilityNodeInfo.obtain(this.c));
      android.support.v4.view.ac.a(this.c, (a)localObject1);
      localObject2 = new ArrayList();
      a((List)localObject2);
      if (((a)localObject1).a.getChildCount() <= 0) {}
      while (((ArrayList)localObject2).size() <= 0)
      {
        m = ((ArrayList)localObject2).size();
        paramInt = 0;
        while (paramInt < m)
        {
          localView = this.c;
          int n = ((Integer)((ArrayList)localObject2).get(paramInt)).intValue();
          ((a)localObject1).a.addChild(localView, n);
          paramInt += 1;
        }
        return (a)localObject1;
      }
      throw new RuntimeException("Views cannot have both real and virtual children");
    }
    throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    label770:
    throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
  }
  
  public final e a(View paramView)
  {
    if (this.h == null) {
      this.h = new ae(this);
    }
    return this.h;
  }
  
  public abstract void a(int paramInt, a parama);
  
  public void a(int paramInt, AccessibilityEvent paramAccessibilityEvent) {}
  
  public void a(a parama) {}
  
  public final void a(View paramView, a parama)
  {
    super.a(paramView, parama);
    a(parama);
  }
  
  public abstract void a(List paramList);
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    ViewParent localViewParent;
    AccessibilityEvent localAccessibilityEvent;
    if (paramInt1 != Integer.MIN_VALUE)
    {
      bool1 = bool2;
      if (this.e.isEnabled())
      {
        localViewParent = this.c.getParent();
        bool1 = bool2;
        if (localViewParent != null) {
          switch (paramInt1)
          {
          default: 
            localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
            a locala = a(paramInt1);
            localAccessibilityEvent.getText().add(locala.a.getText());
            localAccessibilityEvent.setContentDescription(locala.a.getContentDescription());
            localAccessibilityEvent.setScrollable(locala.a.isScrollable());
            localAccessibilityEvent.setPassword(locala.a.isPassword());
            localAccessibilityEvent.setEnabled(locala.a.isEnabled());
            localAccessibilityEvent.setChecked(locala.a.isChecked());
            a(paramInt1, localAccessibilityEvent);
            if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
              throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            localAccessibilityEvent.setClassName(locala.a.getClassName());
            localAccessibilityEvent.setSource(this.c, paramInt1);
            localAccessibilityEvent.setPackageName(this.c.getContext().getPackageName());
          }
        }
      }
    }
    for (;;)
    {
      bool1 = localViewParent.requestSendAccessibilityEvent(this.c, localAccessibilityEvent);
      return bool1;
      localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
      this.c.onInitializeAccessibilityEvent(localAccessibilityEvent);
    }
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((this.e.isEnabled()) && (this.e.isTouchExplorationEnabled()))
    {
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      default: 
        bool = false;
      case 7: 
      case 9: 
        int m;
        do
        {
          return bool;
          m = a(paramMotionEvent.getX(), paramMotionEvent.getY());
          d(m);
        } while (m != Integer.MIN_VALUE);
        return false;
      }
      if (this.g != Integer.MIN_VALUE)
      {
        d(Integer.MIN_VALUE);
        return true;
      }
      return false;
    }
    return false;
  }
  
  final boolean b(int paramInt)
  {
    if (this.b == paramInt)
    {
      this.b = Integer.MIN_VALUE;
      this.c.invalidate();
      a(paramInt, 65536);
      return true;
    }
    return false;
  }
  
  public abstract boolean b(int paramInt1, int paramInt2);
  
  public final boolean c(int paramInt)
  {
    if (this.d == paramInt)
    {
      this.d = Integer.MIN_VALUE;
      a(paramInt, 8);
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */