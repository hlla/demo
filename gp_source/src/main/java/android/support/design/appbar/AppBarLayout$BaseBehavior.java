package android.support.design.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.k;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.view.s;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;

public class AppBarLayout$BaseBehavior
  extends e
{
  public int a;
  private WeakReference c;
  private int d;
  private ValueAnimator e;
  private int f = -1;
  private boolean g;
  private float h;
  
  public AppBarLayout$BaseBehavior() {}
  
  public AppBarLayout$BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void a(int paramInt1, AppBarLayout paramAppBarLayout, View paramView, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramInt2 = a();
      if (paramInt1 < 0) {
        break label35;
      }
      if ((paramInt1 <= 0) || (paramInt2 != -paramAppBarLayout.d())) {}
    }
    for (;;)
    {
      ac.H(paramView);
      return;
      label35:
      if (paramInt2 != 0) {
        break;
      }
    }
  }
  
  private static void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    int k = Math.abs(paramInt1);
    int m = paramAppBarLayout.getChildCount();
    int i = 0;
    Object localObject;
    if (i < m)
    {
      localObject = paramAppBarLayout.getChildAt(i);
      if (k < ((View)localObject).getTop()) {}
      while (k > ((View)localObject).getBottom())
      {
        i += 1;
        break;
      }
    }
    for (;;)
    {
      boolean bool1;
      if (localObject != null)
      {
        i = ((d)((View)localObject).getLayoutParams()).a;
        if ((i & 0x1) == 0) {
          break label391;
        }
        k = ac.s((View)localObject);
        if (paramInt2 > 0) {
          break label353;
        }
        if ((i & 0x2) == 0) {
          break label347;
        }
        if (-paramInt1 < ((View)localObject).getBottom() - k - paramAppBarLayout.e()) {
          break label341;
        }
        bool1 = true;
      }
      for (;;)
      {
        boolean bool2 = bool1;
        if (paramAppBarLayout.c)
        {
          paramInt2 = paramCoordinatorLayout.getChildCount();
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            View localView = paramCoordinatorLayout.getChildAt(paramInt1);
            localObject = localView;
            if ((localView instanceof s)) {
              break label178;
            }
            paramInt1 += 1;
          }
          localObject = null;
          label178:
          bool2 = bool1;
          if (localObject != null) {
            if (((View)localObject).getScrollY() <= 0) {
              break label335;
            }
          }
        }
        label224:
        label321:
        label335:
        for (bool2 = true;; bool2 = false)
        {
          bool1 = paramAppBarLayout.a(bool2);
          if (Build.VERSION.SDK_INT >= 11) {
            if (!paramBoolean) {
              break label224;
            }
          }
          for (;;)
          {
            paramAppBarLayout.jumpDrawablesToCurrentState();
            do
            {
              for (;;)
              {
                return;
                if (bool1)
                {
                  localObject = paramCoordinatorLayout.a.b(paramAppBarLayout);
                  paramCoordinatorLayout.e.clear();
                  if (localObject != null) {
                    paramCoordinatorLayout.e.addAll((Collection)localObject);
                  }
                  paramCoordinatorLayout = paramCoordinatorLayout.e;
                  paramInt2 = paramCoordinatorLayout.size();
                  paramInt1 = j;
                  while (paramInt1 < paramInt2)
                  {
                    localObject = ((k)((View)paramCoordinatorLayout.get(paramInt1)).getLayoutParams()).i;
                    if ((localObject instanceof AppBarLayout.ScrollingViewBehavior)) {
                      break label321;
                    }
                    paramInt1 += 1;
                  }
                }
              }
            } while (((AppBarLayout.ScrollingViewBehavior)localObject).a == 0);
          }
        }
        label341:
        bool1 = false;
        continue;
        label347:
        bool1 = false;
        continue;
        label353:
        if ((i & 0xC) == 0) {
          break;
        }
        if (-paramInt1 >= ((View)localObject).getBottom() - k - paramAppBarLayout.e())
        {
          bool1 = true;
        }
        else
        {
          bool1 = false;
          continue;
          label391:
          bool1 = false;
        }
      }
      localObject = null;
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private final void b(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
  {
    int n = a();
    int m = paramAppBarLayout.getChildCount();
    int i = 0;
    Object localObject;
    int j;
    int i1;
    if (i < m)
    {
      localObject = paramAppBarLayout.getChildAt(i);
      k = ((View)localObject).getTop();
      j = ((View)localObject).getBottom();
      localObject = (d)((View)localObject).getLayoutParams();
      if (a(((d)localObject).a, 32))
      {
        i1 = ((d)localObject).topMargin;
        j = ((d)localObject).bottomMargin + j;
        k -= i1;
        i1 = -n;
        if (k > i1) {}
        while (j < i1)
        {
          i += 1;
          break;
        }
      }
    }
    for (int k = i;; k = -1)
    {
      d locald;
      if (k >= 0)
      {
        localObject = paramAppBarLayout.getChildAt(k);
        locald = (d)((View)localObject).getLayoutParams();
        i1 = locald.a;
        if ((i1 & 0x11) == 17)
        {
          j = -((View)localObject).getTop();
          m = -((View)localObject).getBottom();
          i = m;
          if (k == paramAppBarLayout.getChildCount() - 1) {
            i = m + paramAppBarLayout.e();
          }
          if (!a(i1, 2)) {
            break label293;
          }
          k = i + ac.s((View)localObject);
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        m = i;
        k = j;
        if (a(i1, 32))
        {
          m = i + locald.topMargin;
          k = j - locald.bottomMargin;
        }
        if (n < (k + m) / 2) {}
        for (;;)
        {
          b(paramCoordinatorLayout, paramAppBarLayout, android.support.v4.d.a.a(k, -paramAppBarLayout.getTotalScrollRange(), 0));
          return;
          k = m;
        }
        label293:
        if (a(i1, 5))
        {
          k = ac.s((View)localObject) + i;
          if (n >= k)
          {
            i = j;
            j = k;
          }
          else
          {
            j = i;
            i = k;
          }
        }
        else
        {
          k = i;
          i = j;
          j = k;
        }
      }
      break;
    }
  }
  
  private final void b(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    int i = Math.abs(a() - paramInt);
    float f1 = Math.abs(0.0F);
    if (f1 > 0.0F) {}
    for (i = Math.round(i / f1 * 1000.0F) * 3;; i = (int)((i / paramAppBarLayout.getHeight() + 1.0F) * 150.0F))
    {
      int j = a();
      if (j == paramInt)
      {
        paramCoordinatorLayout = this.e;
        if ((paramCoordinatorLayout != null) && (paramCoordinatorLayout.isRunning())) {
          this.e.cancel();
        }
        return;
      }
      ValueAnimator localValueAnimator = this.e;
      if (localValueAnimator == null)
      {
        this.e = new ValueAnimator();
        this.e.setInterpolator(android.support.design.a.a.a);
        this.e.addUpdateListener(new b(this, paramCoordinatorLayout, paramAppBarLayout));
      }
      for (;;)
      {
        this.e.setDuration(Math.min(i, 600));
        this.e.setIntValues(new int[] { j, paramInt });
        this.e.start();
        return;
        localValueAnimator.cancel();
      }
    }
  }
  
  final int a()
  {
    return c() + this.a;
  }
  
  public Parcelable a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
  {
    boolean bool = false;
    Object localObject = super.b(paramCoordinatorLayout, paramAppBarLayout);
    int j = c();
    int k = paramAppBarLayout.getChildCount();
    int i = 0;
    if (i < k)
    {
      paramCoordinatorLayout = paramAppBarLayout.getChildAt(i);
      int m = paramCoordinatorLayout.getBottom() + j;
      if (paramCoordinatorLayout.getTop() + j > 0) {}
      while (m < 0)
      {
        i += 1;
        break;
      }
      localObject = new AppBarLayout.BaseBehavior.SavedState((Parcelable)localObject);
      ((AppBarLayout.BaseBehavior.SavedState)localObject).b = i;
      if (m == ac.s(paramCoordinatorLayout) + paramAppBarLayout.e()) {
        bool = true;
      }
      ((AppBarLayout.BaseBehavior.SavedState)localObject).a = bool;
      ((AppBarLayout.BaseBehavior.SavedState)localObject).c = (m / paramCoordinatorLayout.getHeight());
      return (Parcelable)localObject;
    }
    return (Parcelable)localObject;
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof AppBarLayout.BaseBehavior.SavedState))
    {
      paramParcelable = (AppBarLayout.BaseBehavior.SavedState)paramParcelable;
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramParcelable.e);
      this.f = paramParcelable.b;
      this.h = paramParcelable.c;
      this.g = paramParcelable.a;
      return;
    }
    super.a(paramCoordinatorLayout, paramAppBarLayout, paramParcelable);
    this.f = -1;
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt1 < 0)
    {
      b(paramCoordinatorLayout, paramAppBarLayout, paramInt1, -paramAppBarLayout.d(), 0);
      a(paramInt1, paramAppBarLayout, paramView, paramInt2);
    }
    if (paramAppBarLayout.c)
    {
      if (paramView.getScrollY() > 0) {
        bool = true;
      }
      paramAppBarLayout.a(bool);
    }
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    boolean bool = super.a(paramCoordinatorLayout, paramAppBarLayout, paramInt);
    int i = paramAppBarLayout.d;
    paramInt = this.f;
    if ((paramInt >= 0) && ((i & 0x8) == 0))
    {
      localView = paramAppBarLayout.getChildAt(paramInt);
      paramInt = -localView.getBottom();
      if (this.g)
      {
        paramInt = ac.s(localView) + paramAppBarLayout.e() + paramInt;
        a_(paramCoordinatorLayout, paramAppBarLayout, paramInt);
      }
    }
    while (i == 0) {
      for (;;)
      {
        View localView;
        paramAppBarLayout.d = 0;
        this.f = -1;
        a_(android.support.v4.d.a.a(c(), -paramAppBarLayout.getTotalScrollRange(), 0));
        a(paramCoordinatorLayout, paramAppBarLayout, c(), 0, true);
        return bool;
        paramInt = Math.round(localView.getHeight() * this.h) + paramInt;
      }
    }
    int j = i & 0x4;
    if (j == 0) {}
    for (paramInt = 0;; paramInt = 1)
    {
      if ((i & 0x2) != 0)
      {
        i = -paramAppBarLayout.getTotalScrollRange();
        if (paramInt != 0)
        {
          b(paramCoordinatorLayout, paramAppBarLayout, i);
          break;
        }
        a_(paramCoordinatorLayout, paramAppBarLayout, i);
        break;
      }
      if ((i & 0x1) == 0) {
        break;
      }
      if (j == 0)
      {
        a_(paramCoordinatorLayout, paramAppBarLayout, 0);
        break;
      }
      b(paramCoordinatorLayout, paramAppBarLayout, 0);
      break;
    }
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt1 & 0x2) != 0)
    {
      bool1 = bool2;
      if (!paramAppBarLayout.c)
      {
        if (paramAppBarLayout.getTotalScrollRange() == 0) {
          break label86;
        }
        if (paramCoordinatorLayout.getHeight() - paramView1.getHeight() > paramAppBarLayout.getHeight()) {
          break label80;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (bool1)
      {
        paramCoordinatorLayout = this.e;
        if (paramCoordinatorLayout != null) {
          paramCoordinatorLayout.cancel();
        }
      }
      this.c = null;
      this.d = paramInt2;
      return bool1;
      label80:
      bool1 = false;
      continue;
      label86:
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/AppBarLayout$BaseBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */