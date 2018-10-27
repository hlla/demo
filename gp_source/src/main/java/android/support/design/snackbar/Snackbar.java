package android.support.design.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.TextView;

public final class Snackbar
  extends BaseTransientBottomBar
{
  private static final int[] k = { 2130969515 };
  public boolean j;
  private final AccessibilityManager l;
  
  private Snackbar(ViewGroup paramViewGroup, View paramView, s params)
  {
    super(paramViewGroup, paramView, params);
    this.l = ((AccessibilityManager)paramViewGroup.getContext().getSystemService("accessibility"));
  }
  
  public static Snackbar a(View paramView, int paramInt)
  {
    return a(paramView, paramView.getResources().getText(paramInt));
  }
  
  public static Snackbar a(View paramView, CharSequence paramCharSequence)
  {
    View localView = null;
    Object localObject2 = paramView;
    if ((localObject2 instanceof CoordinatorLayout)) {
      paramView = (ViewGroup)localObject2;
    }
    label20:
    while (paramView != null)
    {
      Object localObject1 = LayoutInflater.from(paramView.getContext());
      localObject2 = paramView.getContext().obtainStyledAttributes(k);
      int i = ((TypedArray)localObject2).getResourceId(0, -1);
      ((TypedArray)localObject2).recycle();
      if (i != -1) {}
      for (i = 2131624610;; i = 2131624137)
      {
        localObject1 = (SnackbarContentLayout)((LayoutInflater)localObject1).inflate(i, paramView, false);
        paramView = new Snackbar(paramView, (View)localObject1, (s)localObject1);
        ((SnackbarContentLayout)paramView.i.getChildAt(0)).getMessageView().setText(paramCharSequence);
        paramView.e = 0;
        return paramView;
      }
      paramView = localView;
      if ((localObject2 instanceof FrameLayout))
      {
        if (((View)localObject2).getId() == 16908290) {
          paramView = (ViewGroup)localObject2;
        } else {
          paramView = (ViewGroup)localObject2;
        }
      }
      else
      {
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = ((View)localObject2).getParent();
          if (!(localObject1 instanceof View)) {
            break label193;
          }
        }
        label193:
        for (localObject1 = (View)localObject1;; localObject1 = null)
        {
          localObject2 = localObject1;
          localView = paramView;
          if (localObject1 != null) {
            break;
          }
          break label20;
        }
      }
    }
    throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
  }
  
  public final int c()
  {
    if ((!this.j) || (!this.l.isTouchExplorationEnabled())) {
      return super.c();
    }
    return -2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/Snackbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */