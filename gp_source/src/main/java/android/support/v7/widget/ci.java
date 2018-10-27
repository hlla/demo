package android.support.v7.widget;

import android.view.View;
import android.view.ViewParent;

final class ci
  implements Runnable
{
  ci(ch paramch) {}
  
  public final void run()
  {
    ViewParent localViewParent = this.a.b.getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */