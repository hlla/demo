package android.support.v7.view.menu;

import android.support.v7.widget.du;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.util.Iterator;
import java.util.List;

final class h
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  h(g paramg) {}
  
  public final void onGlobalLayout()
  {
    Object localObject;
    if ((this.a.d()) && (this.a.c.size() > 0) && (!((l)this.a.c.get(0)).c.n))
    {
      localObject = this.a.d;
      if ((localObject != null) && (((View)localObject).isShown())) {
        break label77;
      }
      this.a.c();
    }
    for (;;)
    {
      return;
      label77:
      localObject = this.a.c.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((l)((Iterator)localObject).next()).c.b();
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */