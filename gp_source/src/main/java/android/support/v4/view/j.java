package android.support.v4.view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

final class j
  implements g
{
  private final GestureDetector a;
  
  j(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.a = new GestureDetector(paramContext, paramOnGestureListener, null);
  }
  
  public final void a()
  {
    this.a.setIsLongpressEnabled(true);
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    return this.a.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */