package android.support.design.snackbar;

import android.support.design.behavior.SwipeDismissBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.view.MotionEvent;
import android.view.View;

public class BaseTransientBottomBar$Behavior
  extends SwipeDismissBehavior
{
  public final n g = new n(this);
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    this.g.a(paramCoordinatorLayout, paramView, paramMotionEvent);
    return super.a(paramCoordinatorLayout, paramView, paramMotionEvent);
  }
  
  public final boolean b(View paramView)
  {
    return paramView instanceof q;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/BaseTransientBottomBar$Behavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */