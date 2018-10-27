package android.support.v7.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

final class cj
  implements Runnable
{
  cj(ch paramch) {}
  
  public final void run()
  {
    ch localch = this.a;
    localch.d();
    View localView = localch.b;
    if ((localView.isEnabled()) && (!localView.isLongClickable()) && (localch.b()))
    {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      localView.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localch.a = true;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */