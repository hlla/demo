package android.support.design.snackbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.design.behavior.SwipeDismissBehavior;
import android.support.design.internal.n;
import android.support.v4.view.ac;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;

public class BaseTransientBottomBar
{
  public static final boolean a;
  public static final Handler f;
  private static final int[] j;
  public List b;
  public final s c;
  public final Context d;
  public int e;
  public final x g = new f(this);
  public final ViewGroup h;
  public final q i;
  private final AccessibilityManager k;
  
  static
  {
    if (Build.VERSION.SDK_INT <= 19) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      j = new int[] { 2130969516 };
      f = new Handler(Looper.getMainLooper(), new a());
      return;
    }
  }
  
  public BaseTransientBottomBar(ViewGroup paramViewGroup, View paramView, s params)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }
    if (paramView == null) {
      throw new IllegalArgumentException("Transient bottom bar must have non-null content");
    }
    if (params != null)
    {
      this.h = paramViewGroup;
      this.c = params;
      this.d = paramViewGroup.getContext();
      n.a(this.d);
      this.i = ((q)LayoutInflater.from(this.d).inflate(a(), this.h, false));
      this.i.addView(paramView);
      ac.d(this.i, 1);
      ac.b(this.i, 1);
      ac.z(this.i);
      ac.a(this.i, new d());
      ac.a(this.i, new e(this));
      this.k = ((AccessibilityManager)this.d.getSystemService("accessibility"));
      return;
    }
    throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
  }
  
  public int a()
  {
    if (b()) {
      return 2131624609;
    }
    return 2131624136;
  }
  
  public final BaseTransientBottomBar a(m paramm)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramm);
    return this;
  }
  
  public final void a(int paramInt)
  {
    v localv = v.a();
    x localx = this.g;
    synchronized (localv.c)
    {
      if (!localv.e(localx))
      {
        if (localv.f(localx)) {
          localv.a(localv.d, paramInt);
        }
        return;
      }
      localv.a(localv.a, paramInt);
    }
  }
  
  final void b(int paramInt)
  {
    v localv = v.a();
    x localx = this.g;
    synchronized (localv.c)
    {
      if (localv.e(localx))
      {
        localv.a = null;
        if (localv.d != null) {}
      }
      else
      {
        ??? = this.b;
        if (??? != null)
        {
          int m = ((List)???).size() - 1;
          while (m >= 0)
          {
            ((m)this.b.get(m)).a(paramInt);
            m -= 1;
          }
        }
        ??? = this.i.getParent();
        if ((??? instanceof ViewGroup)) {
          ((ViewGroup)???).removeView(this.i);
        }
        return;
      }
      localv.b();
    }
  }
  
  public final boolean b()
  {
    boolean bool = false;
    TypedArray localTypedArray = this.d.obtainStyledAttributes(j);
    int m = localTypedArray.getResourceId(0, -1);
    localTypedArray.recycle();
    if (m != -1) {
      bool = true;
    }
    return bool;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public final void d()
  {
    v localv = v.a();
    int m = c();
    Object localObject3 = this.g;
    for (;;)
    {
      synchronized (localv.c)
      {
        if (localv.e((x)localObject3)) {
          break;
        }
        if (!localv.f((x)localObject3))
        {
          localv.d = new y(m, (x)localObject3);
          localObject3 = localv.a;
          if ((localObject3 == null) || (!localv.a((y)localObject3, 4)))
          {
            localv.a = null;
            localv.b();
            return;
          }
          return;
        }
      }
      ((v)localObject2).d.b = m;
    }
    localObject3 = ((v)localObject2).a;
    ((y)localObject3).b = m;
    ((v)localObject2).b.removeCallbacksAndMessages(localObject3);
    ((v)localObject2).a(((v)localObject2).a);
  }
  
  public final boolean e()
  {
    return v.a().c(this.g);
  }
  
  public SwipeDismissBehavior f()
  {
    return new BaseTransientBottomBar.Behavior();
  }
  
  final void g()
  {
    int m = h();
    if (a) {
      ac.e(this.i, m);
    }
    for (;;)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setIntValues(new int[] { m, 0 });
      localValueAnimator.setInterpolator(android.support.design.a.a.c);
      localValueAnimator.setDuration(250L);
      localValueAnimator.addListener(new k(this));
      localValueAnimator.addUpdateListener(new l(this, m));
      localValueAnimator.start();
      return;
      this.i.setTranslationY(m);
    }
  }
  
  final int h()
  {
    int m = this.i.getHeight();
    ViewGroup.LayoutParams localLayoutParams = this.i.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin + m;
    }
    return m;
  }
  
  final void i()
  {
    v localv = v.a();
    x localx = this.g;
    synchronized (localv.c)
    {
      if (localv.e(localx)) {
        localv.a(localv.a);
      }
      ??? = this.b;
      if (??? != null)
      {
        int m = ((List)???).size() - 1;
        if (m >= 0)
        {
          ((m)this.b.get(m)).a(this);
          m -= 1;
        }
      }
    }
  }
  
  final boolean j()
  {
    List localList = this.k.getEnabledAccessibilityServiceList(1);
    return (localList != null) && (localList.isEmpty());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/BaseTransientBottomBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */