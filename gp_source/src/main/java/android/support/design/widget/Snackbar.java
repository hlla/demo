package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.internal.n;
import android.support.design.snackbar.BaseTransientBottomBar;
import android.support.design.snackbar.SnackbarContentLayout;
import android.support.design.snackbar.q;
import android.support.design.snackbar.s;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

@Deprecated
public final class Snackbar
  extends b
{
  private Snackbar(ViewGroup paramViewGroup, View paramView, s params)
  {
    super(paramViewGroup, paramView, params);
  }
  
  public static Snackbar a(View paramView, int paramInt1, int paramInt2)
  {
    return a(paramView, paramView.getResources().getText(paramInt1), paramInt2);
  }
  
  public static Snackbar a(View paramView, CharSequence paramCharSequence, int paramInt)
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
      if (!n.b(paramView.getContext())) {}
      for (int i = 2131624137;; i = 2131624610)
      {
        localObject1 = (SnackbarContentLayout)((LayoutInflater)localObject1).inflate(i, paramView, false);
        paramView = new Snackbar(paramView, (View)localObject1, (s)localObject1);
        ((SnackbarContentLayout)paramView.i.getChildAt(0)).getMessageView().setText(paramCharSequence);
        paramView.e = paramInt;
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
            break label185;
          }
        }
        label185:
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
  
  public final Snackbar a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    return a(this.d.getText(paramInt), paramOnClickListener);
  }
  
  public final Snackbar a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    Button localButton = ((SnackbarContentLayout)this.i.getChildAt(0)).getActionView();
    if (TextUtils.isEmpty(paramCharSequence)) {}
    while (paramOnClickListener == null)
    {
      localButton.setVisibility(8);
      localButton.setOnClickListener(null);
      return this;
    }
    localButton.setVisibility(0);
    localButton.setText(paramCharSequence);
    localButton.setOnClickListener(new o(this, paramOnClickListener));
    return this;
  }
  
  public final Snackbar c(int paramInt)
  {
    ((SnackbarContentLayout)this.i.getChildAt(0)).getActionView().setTextColor(paramInt);
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/widget/Snackbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */