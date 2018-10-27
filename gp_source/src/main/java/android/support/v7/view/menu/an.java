package android.support.v7.view.menu;

import android.support.v7.widget.du;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class an
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  an(am paramam) {}
  
  public final void onGlobalLayout()
  {
    if (this.a.d())
    {
      Object localObject = this.a;
      if (!((am)localObject).b.n)
      {
        localObject = ((am)localObject).c;
        if ((localObject != null) && (((View)localObject).isShown())) {
          break label49;
        }
        this.a.c();
      }
    }
    return;
    label49:
    this.a.b.b();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */