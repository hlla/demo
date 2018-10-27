package android.support.design.widget;

import android.support.design.snackbar.n;
import android.support.design.snackbar.q;
import android.view.MotionEvent;
import android.view.View;

@Deprecated
final class d
  extends SwipeDismissBehavior
{
  private final n g = new n(this);
  
  public d(b paramb)
  {
    this.g.a(paramb);
  }
  
  private final boolean a(CoordinatorLayout paramCoordinatorLayout, e parame, MotionEvent paramMotionEvent)
  {
    this.g.a(paramCoordinatorLayout, parame, paramMotionEvent);
    return super.a(paramCoordinatorLayout, parame, paramMotionEvent);
  }
  
  public final boolean b(View paramView)
  {
    return paramView instanceof q;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */