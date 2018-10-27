package android.support.design.snackbar;

import android.support.design.behavior.SwipeDismissBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.view.MotionEvent;
import android.view.View;

public final class n
{
  private x a;
  
  public n(SwipeDismissBehavior paramSwipeDismissBehavior)
  {
    paramSwipeDismissBehavior.b = SwipeDismissBehavior.a(0.1F);
    paramSwipeDismissBehavior.a = SwipeDismissBehavior.a(0.6F);
    paramSwipeDismissBehavior.e = 0;
  }
  
  public final void a(BaseTransientBottomBar paramBaseTransientBottomBar)
  {
    this.a = paramBaseTransientBottomBar.g;
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return;
      } while (!paramCoordinatorLayout.a(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
      v.a().a(this.a);
      return;
    }
    v.a().b(this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */