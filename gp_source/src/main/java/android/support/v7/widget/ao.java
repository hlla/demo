package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.widget.ak;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

final class ao
  extends PopupWindow
{
  private static final boolean a;
  private boolean b;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public ao(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramContext = hf.a(paramContext, paramAttributeSet, a.bZ, paramInt1, paramInt2);
    boolean bool;
    if (paramContext.g(a.cb))
    {
      bool = paramContext.a(a.cb, false);
      if (!a) {
        break label72;
      }
      this.b = bool;
    }
    for (;;)
    {
      setBackgroundDrawable(paramContext.a(a.ca));
      paramContext.c.recycle();
      return;
      label72:
      ak.a(this, bool);
    }
  }
  
  public final void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (a)
    {
      i = paramInt2;
      if (this.b) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i);
  }
  
  public final void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    if (a)
    {
      i = paramInt2;
      if (this.b) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i, paramInt3);
  }
  
  public final void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (a) {
      if (this.b) {
        paramInt2 -= paramView.getHeight();
      }
    }
    for (;;)
    {
      super.update(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */