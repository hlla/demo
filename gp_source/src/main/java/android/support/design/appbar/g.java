package android.support.design.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.d.a;
import android.support.v4.view.ac;
import android.support.v4.view.bf;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

abstract class g
  extends i
{
  public int a;
  public final Rect b = new Rect();
  public int c = 0;
  private final Rect d = new Rect();
  
  public g() {}
  
  public g(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  abstract View a(List paramList);
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramView.getLayoutParams().height;
    if (j == -1) {}
    for (;;)
    {
      View localView = a(paramCoordinatorLayout.b(paramView));
      if (localView != null)
      {
        if ((ac.y(localView)) && (!ac.y(paramView)))
        {
          ac.z(paramView);
          if (ac.y(paramView))
          {
            paramView.requestLayout();
            return true;
          }
        }
        int i = View.MeasureSpec.getSize(paramInt3);
        paramInt3 = i;
        if (i == 0) {
          paramInt3 = paramCoordinatorLayout.getHeight();
        }
        int k = localView.getMeasuredHeight();
        int m = c(localView);
        if (j == -1) {}
        for (i = 1073741824;; i = Integer.MIN_VALUE)
        {
          paramCoordinatorLayout.a(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(m + (paramInt3 - k), i), paramInt4);
          return true;
        }
      }
      do
      {
        return false;
      } while (j != -2);
    }
  }
  
  float b(View paramView)
  {
    return 1.0F;
  }
  
  protected final void b(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = a(paramCoordinatorLayout.b(paramView));
    if (localView != null)
    {
      android.support.design.widget.k localk = (android.support.design.widget.k)paramView.getLayoutParams();
      Rect localRect = this.b;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + localk.leftMargin, localView.getBottom() + localk.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - localk.rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - localk.bottomMargin);
      bf localbf = paramCoordinatorLayout.getLastWindowInsets();
      if ((localbf != null) && (ac.y(paramCoordinatorLayout)) && (!ac.y(paramView)))
      {
        localRect.left += localbf.a();
        localRect.right -= localbf.c();
      }
      paramCoordinatorLayout = this.d;
      int j = localk.c;
      int i = j;
      if (j == 0) {
        i = 8388659;
      }
      android.support.v4.view.k.a(i, paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = d(localView);
      paramView.layout(paramCoordinatorLayout.left, paramCoordinatorLayout.top - paramInt, paramCoordinatorLayout.right, paramCoordinatorLayout.bottom - paramInt);
      this.c = (paramCoordinatorLayout.top - localView.getBottom());
      return;
    }
    super.b(paramCoordinatorLayout, paramView, paramInt);
    this.c = 0;
  }
  
  int c(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  final int d(View paramView)
  {
    int i = 0;
    if (this.a != 0)
    {
      float f = b(paramView);
      i = this.a;
      i = a.a((int)(f * i), 0, i);
    }
    return i;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */