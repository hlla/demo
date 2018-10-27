package android.support.v7.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

final class i
  implements View.OnAttachStateChangeListener
{
  i(g paramg) {}
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    Object localObject = this.a.f;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        this.a.f = paramView.getViewTreeObserver();
      }
      localObject = this.a;
      ((g)localObject).f.removeGlobalOnLayoutListener(((g)localObject).a);
    }
    paramView.removeOnAttachStateChangeListener(this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */