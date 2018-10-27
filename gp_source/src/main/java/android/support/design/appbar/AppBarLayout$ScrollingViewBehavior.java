package android.support.design.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.k;
import android.support.v4.view.ac;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class AppBarLayout$ScrollingViewBehavior
  extends g
{
  public AppBarLayout$ScrollingViewBehavior() {}
  
  public AppBarLayout$ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, h.k);
    this.a = paramContext.getDimensionPixelSize(h.l, 0);
    paramContext.recycle();
  }
  
  private static AppBarLayout b(List paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramList.get(i);
      if (!(localView instanceof AppBarLayout)) {
        i += 1;
      } else {
        return (AppBarLayout)localView;
      }
    }
    return null;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppBarLayout localAppBarLayout = b(paramCoordinatorLayout.b(paramView));
    if (localAppBarLayout != null)
    {
      paramRect.offset(paramView.getLeft(), paramView.getTop());
      paramView = this.b;
      paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
      if (!paramView.contains(paramRect))
      {
        localAppBarLayout.a(false, paramBoolean ^ true, true);
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = ((k)paramView2.getLayoutParams()).i;
    if ((paramCoordinatorLayout instanceof AppBarLayout.BaseBehavior))
    {
      paramCoordinatorLayout = (AppBarLayout.BaseBehavior)paramCoordinatorLayout;
      int i = paramView2.getBottom();
      int j = paramView1.getTop();
      ac.e(paramView1, paramCoordinatorLayout.a + (i - j) + this.c - d(paramView2));
    }
    if ((paramView2 instanceof AppBarLayout))
    {
      paramCoordinatorLayout = (AppBarLayout)paramView2;
      if (paramCoordinatorLayout.c) {
        if (paramView1.getScrollY() <= 0) {
          break label98;
        }
      }
    }
    label98:
    for (boolean bool = true;; bool = false)
    {
      paramCoordinatorLayout.a(bool);
      return false;
    }
  }
  
  public final boolean a_(View paramView)
  {
    return paramView instanceof AppBarLayout;
  }
  
  final float b(View paramView)
  {
    if ((paramView instanceof AppBarLayout))
    {
      paramView = (AppBarLayout)paramView;
      int j = paramView.getTotalScrollRange();
      int k = paramView.c();
      paramView = ((k)paramView.getLayoutParams()).i;
      if ((paramView instanceof AppBarLayout.BaseBehavior)) {}
      for (int i = ((AppBarLayout.BaseBehavior)paramView).a();; i = 0)
      {
        if (k == 0) {}
        while (j + i > k)
        {
          j -= k;
          if (j == 0) {
            break;
          }
          return i / j + 1.0F;
        }
        return 0.0F;
      }
    }
    return 0.0F;
  }
  
  final int c(View paramView)
  {
    if ((paramView instanceof AppBarLayout)) {
      return ((AppBarLayout)paramView).getTotalScrollRange();
    }
    return super.c(paramView);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/AppBarLayout$ScrollingViewBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */