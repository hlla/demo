package android.support.design.appbar;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ac;
import android.view.View;
import android.widget.OverScroller;

final class f
  implements Runnable
{
  private final View a;
  private final CoordinatorLayout b;
  
  f(e parame, CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    this.b = paramCoordinatorLayout;
    this.a = paramView;
  }
  
  public final void run()
  {
    if (this.a != null)
    {
      Object localObject = this.c.b;
      if (localObject != null)
      {
        if (!((OverScroller)localObject).computeScrollOffset()) {
          break label60;
        }
        localObject = this.c;
        ((e)localObject).a_(this.b, this.a, ((e)localObject).b.getCurrY());
        ac.a(this.a, this);
      }
    }
    return;
    label60:
    this.c.a(this.b, this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */