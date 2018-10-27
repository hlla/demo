package android.support.design.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.appbar.AppBarLayout;
import android.support.design.bottomsheet.BottomSheetBehavior;
import android.support.design.internal.f;
import android.support.design.internal.p;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.h;
import android.support.design.widget.k;
import android.support.v4.view.ac;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class FloatingActionButton$BaseBehavior
  extends h
{
  private boolean a;
  private Rect b;
  
  public FloatingActionButton$BaseBehavior()
  {
    this.a = true;
  }
  
  public FloatingActionButton$BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, n.b);
    this.a = paramContext.getBoolean(n.c, true);
    paramContext.recycle();
  }
  
  private final boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
  {
    if (a(paramAppBarLayout, paramFloatingActionButton))
    {
      if (this.b == null) {
        this.b = new Rect();
      }
      Rect localRect = this.b;
      f.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.b();
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.a();
      }
    }
    return false;
  }
  
  private final boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
  {
    int j = 0;
    Object localObject1 = paramCoordinatorLayout.b(paramFloatingActionButton);
    int k = ((List)localObject1).size();
    int i = 0;
    Object localObject2;
    if (i < k)
    {
      localObject2 = (View)((List)localObject1).get(i);
      if (!(localObject2 instanceof AppBarLayout)) {
        break label239;
      }
      if (!a(paramCoordinatorLayout, (AppBarLayout)localObject2, paramFloatingActionButton)) {
        break label230;
      }
    }
    for (;;)
    {
      paramCoordinatorLayout.a(paramFloatingActionButton, paramInt);
      localObject1 = paramFloatingActionButton.c;
      if ((localObject1 != null) && (((Rect)localObject1).centerX() > 0) && (((Rect)localObject1).centerY() > 0))
      {
        localObject2 = (k)paramFloatingActionButton.getLayoutParams();
        if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - ((k)localObject2).rightMargin) {
          break label203;
        }
        paramInt = ((Rect)localObject1).right;
      }
      for (;;)
      {
        if (paramFloatingActionButton.getBottom() >= paramCoordinatorLayout.getHeight() - ((k)localObject2).bottomMargin) {
          i = ((Rect)localObject1).bottom;
        }
        for (;;)
        {
          if (i != 0) {
            ac.e(paramFloatingActionButton, i);
          }
          if (paramInt != 0) {
            ac.f(paramFloatingActionButton, paramInt);
          }
          return true;
          i = j;
          if (paramFloatingActionButton.getTop() <= ((k)localObject2).topMargin) {
            i = -((Rect)localObject1).top;
          }
        }
        label203:
        if (paramFloatingActionButton.getLeft() <= ((k)localObject2).leftMargin) {
          paramInt = -((Rect)localObject1).left;
        } else {
          paramInt = 0;
        }
      }
      label230:
      label239:
      do
      {
        i += 1;
        break;
      } while ((!b((View)localObject2)) || (!b((View)localObject2, paramFloatingActionButton)));
    }
  }
  
  private final boolean a(View paramView, FloatingActionButton paramFloatingActionButton)
  {
    k localk = (k)paramFloatingActionButton.getLayoutParams();
    if (this.a)
    {
      if (localk.g == paramView.getId()) {
        return paramFloatingActionButton.getUserSetVisibility() == 0;
      }
      return false;
    }
    return false;
  }
  
  private static boolean b(View paramView)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof k)) {
      return ((k)paramView).i instanceof BottomSheetBehavior;
    }
    return false;
  }
  
  private final boolean b(View paramView, FloatingActionButton paramFloatingActionButton)
  {
    if (a(paramView, paramFloatingActionButton))
    {
      k localk = (k)paramFloatingActionButton.getLayoutParams();
      int i = paramView.getTop();
      int j = paramFloatingActionButton.getHeight() / 2;
      if (i < localk.topMargin + j) {
        paramFloatingActionButton.b();
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.a();
      }
    }
    return false;
  }
  
  public final void a(k paramk)
  {
    if (paramk.b == 0) {
      paramk.b = 80;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/floatingactionbutton/FloatingActionButton$BaseBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */