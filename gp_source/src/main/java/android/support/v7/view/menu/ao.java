package android.support.v7.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

final class ao
  implements View.OnAttachStateChangeListener
{
  ao(am paramam) {}
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    Object localObject = this.a.d;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        this.a.d = paramView.getViewTreeObserver();
      }
      localObject = this.a;
      ((am)localObject).d.removeGlobalOnLayoutListener(((am)localObject).a);
    }
    paramView.removeOnAttachStateChangeListener(this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */